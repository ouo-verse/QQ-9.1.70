package com.tencent.midas.comm.log.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.comm.APLogInfo;
import com.tencent.midas.comm.log.APLogFileInfo;
import com.tencent.midas.comm.log.processor.APLogCompressor;
import com.tencent.midas.comm.log.processor.APLogEncryptor;
import com.tencent.midas.comm.log.processor.APLogWriter;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Locale;

/* loaded from: classes9.dex */
public class APLogAppender {
    private static final int AUTO_FLUSH_INTERVAL = 15000;
    private static final int BUFFER_BLOCK_SIZE = 153600;
    private static final int POSITION_INIT = 12;
    private static APLogAppender instance = null;
    private static boolean stopAutoFlush = false;
    private Handler autoFlushHandler;
    private HandlerThread autoFlushThread;
    private APLogCompressor mCompressor = null;
    private APLogEncryptor mEncryptor = null;
    private APLogWriter mWriter = null;
    private RandomAccessFile randomAccessFile = null;
    private FileChannel fileChannel = null;
    private MappedByteBuffer mappedByteBuffer = null;
    private Runnable autoFlushRunnable = new Runnable() { // from class: com.tencent.midas.comm.log.internal.APLogAppender.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(APLogInfo.LOG_TAG, "auto flush");
                APLogAppender.this.flushAndWrite();
                if (APLogAppender.stopAutoFlush) {
                    Log.d(APLogInfo.LOG_TAG, "stop auto flush");
                } else if (APLogAppender.this.autoFlushHandler != null) {
                    APLogAppender.this.autoFlushHandler.postDelayed(APLogAppender.this.autoFlushRunnable, 15000L);
                }
            } catch (Throwable th5) {
                Log.e(APLogInfo.LOG_TAG, "auto flush error: " + th5.getMessage());
            }
        }
    };
    private volatile long seq = 12;
    private final byte[] _bytes = new byte[0];
    private final String SPACE = " ";
    private byte[] EMPTY_BUFFER = new byte[BUFFER_BLOCK_SIZE];
    private String FLAG_BEGIN = "============mmap cache begin===========\r\n";
    private String FLAG_END = "============mmap cache end=============\r\n";

    APLogAppender() {
        this.autoFlushThread = null;
        this.autoFlushHandler = null;
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("LOG-FLUSH");
        this.autoFlushThread = baseHandlerThread;
        baseHandlerThread.start();
        this.autoFlushHandler = new Handler(this.autoFlushThread.getLooper());
    }

    private synchronized void checkAndFlushBuffer() {
        MappedByteBuffer mappedByteBuffer;
        try {
            mappedByteBuffer = this.mappedByteBuffer;
        } catch (Throwable th5) {
            Log.e(APLogInfo.LOG_TAG, String.format(Locale.CHINA, "check and flush buffer error: <%s>%s", th5.getClass().getName(), th5.getMessage()));
        }
        if (mappedByteBuffer == null) {
            return;
        }
        int i3 = (int) mappedByteBuffer.getLong(0);
        if (i3 <= 12) {
            this.seq = 12L;
        } else {
            flushBuffer(i3 - 12);
        }
    }

    private void createBufferProcessor() {
        if (APLog.getLogInfo() != null && APLog.getLogInfo().isCompressLog()) {
            this.mCompressor = APLogCompressor.create();
        }
        if (APLog.getLogInfo() != null && APLog.getLogInfo().isEncryptLog()) {
            this.mEncryptor = APLogEncryptor.create();
        }
        this.mWriter = APLogWriter.create();
    }

    private void flushBuffer(int i3) {
        MappedByteBuffer mappedByteBuffer = this.mappedByteBuffer;
        if (mappedByteBuffer == null) {
            return;
        }
        if (i3 > BUFFER_BLOCK_SIZE) {
            i3 = BUFFER_BLOCK_SIZE;
        }
        byte[] bArr = new byte[i3];
        mappedByteBuffer.position(12);
        this.mappedByteBuffer.get(bArr);
        Log.d(APLogInfo.LOG_TAG, "__flush and write data size: " + i3);
        this.mWriter.write(bArr, process(this.FLAG_BEGIN), process(this.FLAG_END));
        this.mappedByteBuffer.position(12);
        this.mappedByteBuffer.put(this.EMPTY_BUFFER, 12, i3);
        this.mappedByteBuffer.putLong(0, 0L);
        resetPosAndSeq();
    }

    private void initMmap() {
        if (this.mappedByteBuffer == null) {
            return;
        }
        checkAndFlushBuffer();
        this.mappedByteBuffer.putLong(0, 12L);
        this.mappedByteBuffer.putInt(8, 45);
        resetPosAndSeq();
    }

    public static APLogAppender open() {
        Log.w(APLogInfo.LOG_TAG, "open log appender");
        APLogAppender aPLogAppender = instance;
        if (aPLogAppender != null) {
            return aPLogAppender;
        }
        APLogAppender aPLogAppender2 = new APLogAppender();
        instance = aPLogAppender2;
        aPLogAppender2.createBufferProcessor();
        instance.openMmapFile();
        instance.initMmap();
        instance.startAutoFlush();
        return instance;
    }

    private void openMmapFile() {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(APLogFileInfo.mmapName, "rw");
            this.randomAccessFile = randomAccessFile;
            FileChannel channel = randomAccessFile.getChannel();
            this.fileChannel = channel;
            this.mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0L, 153600L);
        } catch (Throwable th5) {
            Log.e(APLogInfo.LOG_TAG, String.format(Locale.CHINA, "open log mmap file error: <%s>%s", th5.getClass().getName(), th5.getMessage()));
            th5.printStackTrace();
        }
    }

    private synchronized byte[] process(String str) {
        byte[] bytes;
        try {
            bytes = (System.currentTimeMillis() + " " + str).getBytes();
            APLogCompressor aPLogCompressor = this.mCompressor;
            if (aPLogCompressor != null) {
                bytes = aPLogCompressor.compress(bytes);
            }
            APLogEncryptor aPLogEncryptor = this.mEncryptor;
            if (aPLogEncryptor != null) {
                bytes = aPLogEncryptor.encrypt(bytes);
            }
        } catch (Throwable th5) {
            Log.e(APLogInfo.LOG_TAG, String.format(Locale.CHINA, "process log error: <%s>%s", th5.getClass().getName(), th5.getMessage()));
            return this._bytes;
        }
        return bytes;
    }

    private void resetPosAndSeq() {
        if (this.mappedByteBuffer == null) {
            return;
        }
        this.seq = 12L;
        this.mappedByteBuffer.position(12);
    }

    private void startAutoFlush() {
        if (APLog.getLogInfo() != null && APLog.getLogInfo().isAutoFlush()) {
            try {
                Log.d(APLogInfo.LOG_TAG, "start auto flush");
                this.autoFlushHandler.postDelayed(this.autoFlushRunnable, 15000L);
            } catch (Throwable th5) {
                Log.e(APLogInfo.LOG_TAG, "start auto flush error: " + th5.getMessage());
            }
        }
    }

    private void stopAutoFlush() {
        stopAutoFlush = true;
    }

    public void append(String str) {
        try {
            updateMmap(process(str));
        } catch (Throwable th5) {
            Log.e(APLogInfo.LOG_TAG, String.format(Locale.CHINA, "append log error: <%s> %s", th5.getClass().getName(), th5.getMessage()));
        }
    }

    public void flushAndWrite() {
        try {
            checkAndFlushBuffer();
            APLogWriter aPLogWriter = this.mWriter;
            if (aPLogWriter != null) {
                aPLogWriter.flush();
            }
        } catch (Throwable th5) {
            Log.e(APLogInfo.LOG_TAG, String.format(Locale.CHINA, "flush buffer and write error: <%s>%s", th5.getClass().getName(), th5.getMessage()));
        }
    }

    public synchronized void updateMmap(byte[] bArr) {
        if (this.seq + bArr.length > FaceConstant.HeadDownload.QQHEAD_SYSTEM_MIN_STORAGE_SIZE) {
            checkAndFlushBuffer();
        }
        MappedByteBuffer mappedByteBuffer = this.mappedByteBuffer;
        if (mappedByteBuffer == null) {
            return;
        }
        mappedByteBuffer.put(bArr);
        this.seq += bArr.length;
        this.mappedByteBuffer.putLong(0, this.seq);
    }
}
