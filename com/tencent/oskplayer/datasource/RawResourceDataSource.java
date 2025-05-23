package com.tencent.oskplayer.datasource;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.oskplayer.proxy.FileType;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;

/* compiled from: P */
/* loaded from: classes22.dex */
public class RawResourceDataSource implements UriDataSource {
    public static final String RAW_RESOURCE_SCHEME = "android.resource";
    public static final String TAG = "RawResourceDataSource";
    private AssetFileDescriptor assetFileDescriptor;
    private long assetSize;
    private long bytesAvailable;
    private long bytesRemaining;
    private String extraLogTag;
    private InputStream inputStream;
    private final TransferListener listener;
    private String mimeType;
    private boolean opened;
    private final Resources resources;
    private Uri uri;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class RawResourceDataSourceException extends IOException {
        public RawResourceDataSourceException(String str) {
            super(str);
        }

        public RawResourceDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public RawResourceDataSource(Context context) {
        this(context, null);
    }

    public static Uri buildRawResourceUri(Context context, int i3) {
        return Uri.parse("android.resource:///" + context.getPackageName() + "/" + i3);
    }

    @Override // com.tencent.oskplayer.datasource.DataSource
    public long available() {
        return this.bytesAvailable;
    }

    @Override // com.tencent.oskplayer.datasource.DataSource
    public void close() throws IOException {
        this.uri = null;
        try {
            try {
                InputStream inputStream = this.inputStream;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.inputStream = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.assetFileDescriptor;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e16) {
                        throw new RawResourceDataSourceException(e16);
                    }
                } finally {
                    this.assetFileDescriptor = null;
                    if (this.opened) {
                        this.opened = false;
                        TransferListener transferListener = this.listener;
                        if (transferListener != null) {
                            transferListener.onTransferEnd();
                        }
                    }
                }
            } catch (IOException e17) {
                throw new RawResourceDataSourceException(e17);
            }
        } catch (Throwable th5) {
            this.inputStream = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.assetFileDescriptor;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.assetFileDescriptor = null;
                    if (this.opened) {
                        this.opened = false;
                        TransferListener transferListener2 = this.listener;
                        if (transferListener2 != null) {
                            transferListener2.onTransferEnd();
                        }
                    }
                    throw th5;
                } finally {
                    this.assetFileDescriptor = null;
                    if (this.opened) {
                        this.opened = false;
                        TransferListener transferListener3 = this.listener;
                        if (transferListener3 != null) {
                            transferListener3.onTransferEnd();
                        }
                    }
                }
            } catch (IOException e18) {
                throw new RawResourceDataSourceException(e18);
            }
        }
    }

    @Override // com.tencent.oskplayer.datasource.DataSource
    public FileType getFileType() {
        if (TextUtils.isEmpty(this.mimeType)) {
            return FileType.OCTET_STREAM;
        }
        return FileType.getFileType(this.mimeType);
    }

    @Override // com.tencent.oskplayer.datasource.DataSource
    public String getLogTag() {
        return this.extraLogTag + TAG;
    }

    @Override // com.tencent.oskplayer.datasource.DataSource
    public long getTotalLength() {
        return this.assetSize;
    }

    @Override // com.tencent.oskplayer.datasource.UriDataSource
    public String getUri() {
        Uri uri = this.uri;
        if (uri != null) {
            return uri.toString();
        }
        return null;
    }

    @Override // com.tencent.oskplayer.datasource.DataSource
    public long open(DataSpec dataSpec) throws IOException {
        try {
            Uri uri = dataSpec.uri;
            this.uri = uri;
            if (TextUtils.equals(RAW_RESOURCE_SCHEME, uri.getScheme())) {
                try {
                    AssetFileDescriptor openRawResourceFd = this.resources.openRawResourceFd(Integer.parseInt(this.uri.getLastPathSegment()));
                    this.assetFileDescriptor = openRawResourceFd;
                    long length = openRawResourceFd.getLength();
                    this.assetSize = length;
                    this.bytesAvailable = length - dataSpec.position;
                    FileInputStream fileInputStream = new FileInputStream(this.assetFileDescriptor.getFileDescriptor());
                    this.inputStream = fileInputStream;
                    if (fileInputStream.markSupported()) {
                        this.mimeType = URLConnection.guessContentTypeFromStream(this.inputStream);
                    }
                    this.inputStream.skip(this.assetFileDescriptor.getStartOffset());
                    if (this.inputStream.skip(dataSpec.position) >= dataSpec.position) {
                        long j3 = dataSpec.length;
                        long j16 = -1;
                        if (j3 != -1) {
                            this.bytesRemaining = j3;
                        } else {
                            long length2 = this.assetFileDescriptor.getLength();
                            if (length2 != -1) {
                                j16 = length2 - dataSpec.position;
                            }
                            this.bytesRemaining = j16;
                        }
                        this.opened = true;
                        TransferListener transferListener = this.listener;
                        if (transferListener != null) {
                            transferListener.onTransferStart();
                        }
                        return this.bytesRemaining;
                    }
                    throw new EOFException();
                } catch (NumberFormatException unused) {
                    throw new RawResourceDataSourceException("Resource identifier must be an integer.");
                }
            }
            throw new RawResourceDataSourceException("URI must use scheme android.resource");
        } catch (IOException e16) {
            throw new RawResourceDataSourceException(e16);
        }
    }

    @Override // com.tencent.oskplayer.datasource.DataSource
    public int read(byte[] bArr, int i3, int i16) throws IOException {
        if (i16 == 0) {
            return 0;
        }
        long j3 = this.bytesRemaining;
        if (j3 == 0) {
            return -1;
        }
        if (j3 != -1) {
            try {
                i16 = (int) Math.min(j3, i16);
            } catch (IOException e16) {
                throw new RawResourceDataSourceException(e16);
            }
        }
        int read = this.inputStream.read(bArr, i3, i16);
        if (read == -1) {
            if (this.bytesRemaining == -1) {
                return -1;
            }
            throw new RawResourceDataSourceException(new EOFException());
        }
        long j16 = this.bytesRemaining;
        if (j16 != -1) {
            this.bytesRemaining = j16 - read;
        }
        TransferListener transferListener = this.listener;
        if (transferListener != null) {
            transferListener.onBytesTransferred(read);
        }
        return read;
    }

    @Override // com.tencent.oskplayer.datasource.DataSource
    public void setLogTag(String str) {
        this.extraLogTag = str;
    }

    public RawResourceDataSource(Context context, TransferListener transferListener) {
        this.mimeType = null;
        this.assetSize = -1L;
        this.bytesAvailable = -1L;
        this.extraLogTag = "";
        this.resources = context.getResources();
        this.listener = transferListener;
    }
}
