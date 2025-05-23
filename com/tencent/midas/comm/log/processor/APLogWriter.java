package com.tencent.midas.comm.log.processor;

import android.util.Log;
import com.tencent.midas.comm.APLogInfo;
import com.tencent.midas.comm.log.APLogFileInfo;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Locale;

/* loaded from: classes9.dex */
public class APLogWriter {
    private FileChannel fileChannel = null;
    private MappedByteBuffer mappedByteBuffer = null;
    private RandomAccessFile randomAccessFile = null;

    public static APLogWriter create() {
        APLogWriter aPLogWriter = new APLogWriter();
        aPLogWriter.openLogFile();
        return aPLogWriter;
    }

    private void openLogFile() {
        try {
            Log.d(APLogInfo.LOG_TAG, "open log file: " + APLogFileInfo.fileName);
            RandomAccessFile randomAccessFile = new RandomAccessFile(APLogFileInfo.fileName, "rw");
            this.randomAccessFile = randomAccessFile;
            this.fileChannel = randomAccessFile.getChannel();
        } catch (FileNotFoundException e16) {
            e16.printStackTrace();
        }
    }

    private long refreshFileChannel(long j3) {
        long j16;
        try {
            j16 = this.fileChannel.size();
        } catch (IOException e16) {
            e16.printStackTrace();
            Log.e(APLogInfo.LOG_TAG, "get file channel size error");
            APLogFileInfo.updateFileName();
            openLogFile();
            j16 = 0;
        }
        long j17 = APLogFileUtil.maxLogFileSizeMB * 1024 * 1024;
        long j18 = (j3 + j16) - j17;
        Log.d(APLogInfo.LOG_TAG, String.format(Locale.CHINA, "size to write: %d, channel size: %d, limit: %d", Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17)));
        if (j18 > 0) {
            Log.d(APLogInfo.LOG_TAG, "should refresh file name");
            APLogFileInfo.updateFileName();
            openLogFile();
            return 0L;
        }
        return j16;
    }

    public void close() {
        try {
            FileChannel fileChannel = this.fileChannel;
            if (fileChannel != null) {
                fileChannel.close();
            }
            RandomAccessFile randomAccessFile = this.randomAccessFile;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            MappedByteBuffer mappedByteBuffer = this.mappedByteBuffer;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.force();
                this.mappedByteBuffer.clear();
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public void flush() {
        MappedByteBuffer mappedByteBuffer = this.mappedByteBuffer;
        if (mappedByteBuffer != null) {
            mappedByteBuffer.force();
        }
    }

    public void write(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            long refreshFileChannel = refreshFileChannel(bArr.length);
            long currentTimeMillis = System.currentTimeMillis();
            this.mappedByteBuffer = this.fileChannel.map(FileChannel.MapMode.READ_WRITE, refreshFileChannel, bArr.length + bArr2.length + bArr3.length);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            long currentTimeMillis3 = System.currentTimeMillis();
            this.mappedByteBuffer.put(bArr2);
            this.mappedByteBuffer.put(bArr);
            this.mappedByteBuffer.put(bArr3);
            this.mappedByteBuffer.force();
            Log.d(APLogInfo.LOG_TAG, "write map time: " + currentTimeMillis2 + ", sync time: " + (System.currentTimeMillis() - currentTimeMillis3));
            APLogFileUtil.deleteOldFileToday(APLogFileInfo.dirName);
        } catch (Throwable th5) {
            Log.e(APLogInfo.LOG_TAG, String.format(Locale.CHINA, "cache log to file error: <%s>%s", th5.getClass().getName(), th5.getMessage()));
        }
    }
}
