package com.tencent.oskplayer.datasource;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.tencent.oskplayer.proxy.FileType;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AssetDataSource implements UriDataSource {
    public static final String ASSET_SCHEME = "android_asset";
    public static final String TAG = "AssetDataSource";
    private final AssetManager assetManager;
    private long assetSize;
    private long bytesAvailable;
    private long bytesRemaining;
    private String extraLogTag;
    private InputStream inputStream;
    private final TransferListener listener;
    private boolean opened;
    private String path;
    private Uri uri;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class AssetDataSourceException extends IOException {
        public AssetDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public AssetDataSource(Context context) {
        this(context, null);
    }

    private String getMime() {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(this.path);
        if (fileExtensionFromUrl != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x001d, code lost:
    
        if (r2 == null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void initAssetSize() {
        this.assetSize = -1L;
        AssetFileDescriptor assetFileDescriptor = null;
        try {
            try {
                assetFileDescriptor = this.assetManager.openFd(this.path);
                this.assetSize = assetFileDescriptor.getLength();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
            try {
                assetFileDescriptor.close();
            } catch (IOException unused) {
                if (this.assetSize == -1) {
                    this.assetSize = -1L;
                }
            }
        } catch (Throwable th5) {
            if (assetFileDescriptor != null) {
                try {
                    assetFileDescriptor.close();
                } catch (IOException unused2) {
                }
            }
            throw th5;
        }
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
            } catch (IOException e16) {
                throw new AssetDataSourceException(e16);
            }
        } finally {
            this.inputStream = null;
            if (this.opened) {
                this.opened = false;
                TransferListener transferListener = this.listener;
                if (transferListener != null) {
                    transferListener.onTransferEnd();
                }
            }
        }
    }

    @Override // com.tencent.oskplayer.datasource.DataSource
    public FileType getFileType() {
        String mime = getMime();
        if (TextUtils.isEmpty(mime)) {
            return FileType.OCTET_STREAM;
        }
        return FileType.getFileType(mime);
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
            String path = uri.getPath();
            this.path = path;
            if (path.startsWith("/android_asset/")) {
                this.path = this.path.substring(15);
            } else if (this.path.startsWith("/")) {
                this.path = this.path.substring(1);
            }
            this.inputStream = this.assetManager.open(this.path, 1);
            initAssetSize();
            long j3 = this.assetSize;
            long j16 = dataSpec.position;
            this.bytesAvailable = j3 - j16;
            if (this.inputStream.skip(j16) >= dataSpec.position) {
                long j17 = dataSpec.length;
                if (j17 != -1) {
                    this.bytesRemaining = j17;
                } else {
                    long available = this.inputStream.available();
                    this.bytesRemaining = available;
                    if (available == TTL.MAX_VALUE) {
                        this.bytesRemaining = -1L;
                    }
                }
                this.opened = true;
                TransferListener transferListener = this.listener;
                if (transferListener != null) {
                    transferListener.onTransferStart();
                }
                return this.bytesRemaining;
            }
            throw new EOFException();
        } catch (IOException e16) {
            throw new AssetDataSourceException(e16);
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
                throw new AssetDataSourceException(e16);
            }
        }
        int read = this.inputStream.read(bArr, i3, i16);
        if (read == -1) {
            if (this.bytesRemaining == -1) {
                return -1;
            }
            throw new AssetDataSourceException(new EOFException());
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

    public AssetDataSource(Context context, TransferListener transferListener) {
        this.assetSize = -1L;
        this.bytesAvailable = -1L;
        this.extraLogTag = "";
        this.assetManager = context.getAssets();
        this.listener = transferListener;
    }
}
