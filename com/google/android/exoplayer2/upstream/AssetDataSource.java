package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class AssetDataSource implements DataSource {
    private final AssetManager assetManager;
    private long bytesRemaining;
    private InputStream inputStream;
    private final TransferListener<? super AssetDataSource> listener;
    private boolean opened;
    private Uri uri;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class AssetDataSourceException extends IOException {
        public AssetDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public AssetDataSource(Context context) {
        this(context, null);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws AssetDataSourceException {
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
                TransferListener<? super AssetDataSource> transferListener = this.listener;
                if (transferListener != null) {
                    transferListener.onTransferEnd(this);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) throws AssetDataSourceException {
        try {
            Uri uri = dataSpec.uri;
            this.uri = uri;
            String path = uri.getPath();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            InputStream open = this.assetManager.open(path, 1);
            this.inputStream = open;
            if (open.skip(dataSpec.position) >= dataSpec.position) {
                long j3 = dataSpec.length;
                if (j3 != -1) {
                    this.bytesRemaining = j3;
                } else {
                    long available = this.inputStream.available();
                    this.bytesRemaining = available;
                    if (available == TTL.MAX_VALUE) {
                        this.bytesRemaining = -1L;
                    }
                }
                this.opened = true;
                TransferListener<? super AssetDataSource> transferListener = this.listener;
                if (transferListener != null) {
                    transferListener.onTransferStart(this, dataSpec);
                }
                return this.bytesRemaining;
            }
            throw new EOFException();
        } catch (IOException e16) {
            throw new AssetDataSourceException(e16);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public int read(byte[] bArr, int i3, int i16) throws AssetDataSourceException {
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
        TransferListener<? super AssetDataSource> transferListener = this.listener;
        if (transferListener != null) {
            transferListener.onBytesTransferred(this, read);
        }
        return read;
    }

    public AssetDataSource(Context context, TransferListener<? super AssetDataSource> transferListener) {
        this.assetManager = context.getAssets();
        this.listener = transferListener;
    }
}
