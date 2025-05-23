package com.tencent.oskplayer.cache;

import com.tencent.oskplayer.datasource.DataSink;
import com.tencent.oskplayer.datasource.DataSpec;
import com.tencent.oskplayer.proxy.FileType;
import com.tencent.oskplayer.util.Assertions;
import com.tencent.oskplayer.util.PlayerUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes22.dex */
public class CacheDataSink implements DataSink {
    private final Cache cache;
    protected DataSpec dataSpec;
    protected long dataSpecBytesWritten;
    protected File file;
    private FileOutputStream fileOutputStream;
    protected final long maxCacheFileSize;
    private BufferedOutputStream outputStream;
    protected long outputStreamBytesWritten;
    protected long totalLength = -1;
    protected FileType fileType = FileType.UNKNOWN;
    protected String TAG = "CacheDataSink";
    private String extraLogTag = "";

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class CacheDataSinkException extends IOException {
        public CacheDataSinkException(IOException iOException) {
            super(iOException);
        }
    }

    public CacheDataSink(Cache cache, long j3) {
        this.cache = cache;
        this.maxCacheFileSize = j3;
    }

    private void closeCurrentOutputStream() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.outputStream;
        if (bufferedOutputStream == null) {
            PlayerUtils.log(4, getLogTag(), "finish cache: outputStream == null");
            return;
        }
        try {
            bufferedOutputStream.flush();
            this.fileOutputStream.getFD().sync();
            closeQuietly(this.outputStream);
            commitFile();
            PlayerUtils.log(4, getLogTag(), "finish cache " + this.file.getAbsolutePath() + "  filesize=" + this.file.length());
            this.fileOutputStream = null;
            this.outputStream = null;
            this.file = null;
        } catch (Throwable th5) {
            closeQuietly(this.outputStream);
            this.file.delete();
            PlayerUtils.log(6, getLogTag(), "closeCurrentOutputStream failed: " + this.file.getAbsolutePath());
            this.fileOutputStream = null;
            this.outputStream = null;
            this.file = null;
            throw th5;
        }
    }

    private static void closeQuietly(OutputStream outputStream) {
        try {
            outputStream.close();
        } catch (IOException unused) {
        }
    }

    @Override // com.tencent.oskplayer.datasource.DataSink
    public void close() throws CacheDataSinkException {
        try {
            closeCurrentOutputStream();
            PlayerUtils.log(4, getLogTag(), "close " + String.format("total cached %d bytes", Long.valueOf(this.dataSpecBytesWritten)));
        } catch (IOException e16) {
            throw new CacheDataSinkException(e16);
        }
    }

    protected void commitFile() throws IOException {
        this.cache.commitFile(this.file);
    }

    @Override // com.tencent.oskplayer.datasource.DataSink
    public String getLogTag() {
        return this.extraLogTag + this.TAG;
    }

    @Override // com.tencent.oskplayer.datasource.DataSink
    public DataSink open(DataSpec dataSpec, long j3, FileType fileType) throws CacheDataSinkException {
        boolean z16;
        if (dataSpec.length != -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkState(z16);
        this.totalLength = j3;
        this.fileType = fileType;
        try {
            this.dataSpec = dataSpec;
            this.dataSpecBytesWritten = 0L;
            openNextOutputStream();
            return this;
        } catch (IOException e16) {
            throw new CacheDataSinkException(e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void openNextOutputStream() throws IOException {
        startFile();
        PlayerUtils.log(4, getLogTag(), "start cache " + this.file.getAbsolutePath());
        this.fileOutputStream = new FileOutputStream(this.file);
        this.outputStream = new BufferedOutputStream(this.fileOutputStream);
        this.outputStreamBytesWritten = 0L;
    }

    @Override // com.tencent.oskplayer.datasource.DataSink
    public void setLogTag(String str) {
        this.extraLogTag = str;
    }

    protected void startFile() {
        Cache cache = this.cache;
        DataSpec dataSpec = this.dataSpec;
        String str = dataSpec.key;
        long j3 = dataSpec.absoluteStreamPosition;
        long j16 = this.dataSpecBytesWritten;
        this.file = cache.startFile(str, j3 + j16, this.totalLength, this.fileType, Math.min(dataSpec.length - j16, this.maxCacheFileSize));
    }

    @Override // com.tencent.oskplayer.datasource.DataSink
    public void write(byte[] bArr, int i3, int i16) throws CacheDataSinkException {
        int i17 = 0;
        while (i17 < i16) {
            try {
                if (this.outputStreamBytesWritten == this.maxCacheFileSize) {
                    closeCurrentOutputStream();
                    openNextOutputStream();
                }
                int min = (int) Math.min(i16 - i17, this.maxCacheFileSize - this.outputStreamBytesWritten);
                this.outputStream.write(bArr, i3 + i17, min);
                i17 += min;
                long j3 = min;
                this.outputStreamBytesWritten += j3;
                this.dataSpecBytesWritten += j3;
            } catch (IOException e16) {
                throw new CacheDataSinkException(e16);
            }
        }
    }
}
