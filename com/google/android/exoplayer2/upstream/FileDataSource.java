package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class FileDataSource implements DataSource {
    private long bytesRemaining;
    private RandomAccessFile file;
    private final TransferListener<? super FileDataSource> listener;
    private boolean opened;
    private Uri uri;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class FileDataSourceException extends IOException {
        public FileDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public FileDataSource() {
        this(null);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws FileDataSourceException {
        this.uri = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.file;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (IOException e16) {
                throw new FileDataSourceException(e16);
            }
        } finally {
            this.file = null;
            if (this.opened) {
                this.opened = false;
                TransferListener<? super FileDataSource> transferListener = this.listener;
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
    public long open(DataSpec dataSpec) throws FileDataSourceException {
        try {
            this.uri = dataSpec.uri;
            RandomAccessFile randomAccessFile = new RandomAccessFile(dataSpec.uri.getPath(), "r");
            this.file = randomAccessFile;
            randomAccessFile.seek(dataSpec.position);
            long j3 = dataSpec.length;
            if (j3 == -1) {
                j3 = this.file.length() - dataSpec.position;
            }
            this.bytesRemaining = j3;
            if (j3 >= 0) {
                this.opened = true;
                TransferListener<? super FileDataSource> transferListener = this.listener;
                if (transferListener != null) {
                    transferListener.onTransferStart(this, dataSpec);
                }
                return this.bytesRemaining;
            }
            throw new EOFException();
        } catch (IOException e16) {
            throw new FileDataSourceException(e16);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public int read(byte[] bArr, int i3, int i16) throws FileDataSourceException {
        if (i16 == 0) {
            return 0;
        }
        long j3 = this.bytesRemaining;
        if (j3 == 0) {
            return -1;
        }
        try {
            int read = this.file.read(bArr, i3, (int) Math.min(j3, i16));
            if (read > 0) {
                this.bytesRemaining -= read;
                TransferListener<? super FileDataSource> transferListener = this.listener;
                if (transferListener != null) {
                    transferListener.onBytesTransferred(this, read);
                }
            }
            return read;
        } catch (IOException e16) {
            throw new FileDataSourceException(e16);
        }
    }

    public FileDataSource(TransferListener<? super FileDataSource> transferListener) {
        this.listener = transferListener;
    }
}
