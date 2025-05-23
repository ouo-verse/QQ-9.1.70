package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class RawResourceDataSource implements DataSource {
    public static final String RAW_RESOURCE_SCHEME = "rawresource";
    private AssetFileDescriptor assetFileDescriptor;
    private long bytesRemaining;
    private InputStream inputStream;
    private final TransferListener<? super RawResourceDataSource> listener;
    private boolean opened;
    private final Resources resources;
    private Uri uri;

    /* compiled from: P */
    /* loaded from: classes2.dex */
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

    public static Uri buildRawResourceUri(int i3) {
        return Uri.parse("rawresource:///" + i3);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws RawResourceDataSourceException {
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
                        TransferListener<? super RawResourceDataSource> transferListener = this.listener;
                        if (transferListener != null) {
                            transferListener.onTransferEnd(this);
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
                        TransferListener<? super RawResourceDataSource> transferListener2 = this.listener;
                        if (transferListener2 != null) {
                            transferListener2.onTransferEnd(this);
                        }
                    }
                    throw th5;
                } finally {
                    this.assetFileDescriptor = null;
                    if (this.opened) {
                        this.opened = false;
                        TransferListener<? super RawResourceDataSource> transferListener3 = this.listener;
                        if (transferListener3 != null) {
                            transferListener3.onTransferEnd(this);
                        }
                    }
                }
            } catch (IOException e18) {
                throw new RawResourceDataSourceException(e18);
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) throws RawResourceDataSourceException {
        try {
            Uri uri = dataSpec.uri;
            this.uri = uri;
            if (TextUtils.equals(RAW_RESOURCE_SCHEME, uri.getScheme())) {
                try {
                    this.assetFileDescriptor = this.resources.openRawResourceFd(Integer.parseInt(this.uri.getLastPathSegment()));
                    FileInputStream fileInputStream = new FileInputStream(this.assetFileDescriptor.getFileDescriptor());
                    this.inputStream = fileInputStream;
                    fileInputStream.skip(this.assetFileDescriptor.getStartOffset());
                    if (this.inputStream.skip(dataSpec.position) >= dataSpec.position) {
                        long j3 = dataSpec.length;
                        long j16 = -1;
                        if (j3 != -1) {
                            this.bytesRemaining = j3;
                        } else {
                            long length = this.assetFileDescriptor.getLength();
                            if (length != -1) {
                                j16 = length - dataSpec.position;
                            }
                            this.bytesRemaining = j16;
                        }
                        this.opened = true;
                        TransferListener<? super RawResourceDataSource> transferListener = this.listener;
                        if (transferListener != null) {
                            transferListener.onTransferStart(this, dataSpec);
                        }
                        return this.bytesRemaining;
                    }
                    throw new EOFException();
                } catch (NumberFormatException unused) {
                    throw new RawResourceDataSourceException("Resource identifier must be an integer.");
                }
            }
            throw new RawResourceDataSourceException("URI must use scheme rawresource");
        } catch (IOException e16) {
            throw new RawResourceDataSourceException(e16);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public int read(byte[] bArr, int i3, int i16) throws RawResourceDataSourceException {
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
        TransferListener<? super RawResourceDataSource> transferListener = this.listener;
        if (transferListener != null) {
            transferListener.onBytesTransferred(this, read);
        }
        return read;
    }

    public RawResourceDataSource(Context context, TransferListener<? super RawResourceDataSource> transferListener) {
        this.resources = context.getResources();
        this.listener = transferListener;
    }
}
