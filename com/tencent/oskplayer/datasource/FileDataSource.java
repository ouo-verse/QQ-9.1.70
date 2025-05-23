package com.tencent.oskplayer.datasource;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.proxy.FileType;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: P */
/* loaded from: classes22.dex */
public class FileDataSource implements UriDataSource {
    public static final String TAG = "FileDataSource";
    private long bytesAvailable;
    private long bytesRemaining;
    private String extraLogTag;
    private RandomAccessFile file;
    private final TransferListener listener;
    private boolean opened;
    private Uri uri;
    private String uriString;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class FileDataSourceException extends IOException {
        public FileDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public FileDataSource() {
        this(null);
    }

    @Override // com.tencent.oskplayer.datasource.DataSource
    public long available() {
        return this.bytesAvailable;
    }

    @Override // com.tencent.oskplayer.datasource.DataSource
    public void close() throws FileDataSourceException {
        this.uriString = null;
        RandomAccessFile randomAccessFile = this.file;
        if (randomAccessFile != null) {
            try {
                try {
                    randomAccessFile.close();
                } catch (IOException e16) {
                    throw new FileDataSourceException(e16);
                }
            } finally {
                this.file = null;
                if (this.opened) {
                    this.opened = false;
                    TransferListener transferListener = this.listener;
                    if (transferListener != null) {
                        transferListener.onTransferEnd();
                    }
                }
            }
        }
    }

    @Override // com.tencent.oskplayer.datasource.DataSource
    public FileType getFileType() {
        String type = PlayerConfig.g().getAppContext().getContentResolver().getType(this.uri);
        if (type == null) {
            return FileType.VIDEO_MP4;
        }
        return FileType.getFileType(type);
    }

    @Override // com.tencent.oskplayer.datasource.DataSource
    public String getLogTag() {
        return this.extraLogTag + TAG;
    }

    @Override // com.tencent.oskplayer.datasource.DataSource
    public long getTotalLength() {
        try {
            return this.file.length();
        } catch (IOException e16) {
            e16.printStackTrace();
            return 0L;
        }
    }

    @Override // com.tencent.oskplayer.datasource.UriDataSource
    public String getUri() {
        Uri uri;
        if (TextUtils.isEmpty(this.uriString) && (uri = this.uri) != null) {
            this.uriString = uri.toString();
        }
        return this.uriString;
    }

    @Override // com.tencent.oskplayer.datasource.DataSource
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
            this.bytesAvailable = this.file.length() - dataSpec.position;
            if (this.bytesRemaining >= 0) {
                this.opened = true;
                TransferListener transferListener = this.listener;
                if (transferListener != null) {
                    transferListener.onTransferStart();
                }
                return this.bytesRemaining;
            }
            throw new EOFException();
        } catch (IOException e16) {
            throw new FileDataSourceException(e16);
        }
    }

    @Override // com.tencent.oskplayer.datasource.DataSource
    public int read(byte[] bArr, int i3, int i16) throws FileDataSourceException {
        long j3 = this.bytesRemaining;
        if (j3 == 0) {
            return -1;
        }
        try {
            int read = this.file.read(bArr, i3, (int) Math.min(j3, i16));
            if (read > 0) {
                this.bytesRemaining -= read;
                TransferListener transferListener = this.listener;
                if (transferListener != null) {
                    transferListener.onBytesTransferred(read);
                }
            }
            return read;
        } catch (IOException e16) {
            throw new FileDataSourceException(e16);
        }
    }

    @Override // com.tencent.oskplayer.datasource.DataSource
    public void setLogTag(String str) {
        this.extraLogTag = str;
    }

    public FileDataSource(TransferListener transferListener) {
        this.bytesAvailable = -1L;
        this.extraLogTag = "";
        this.listener = transferListener;
    }
}
