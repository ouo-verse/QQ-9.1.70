package com.tencent.qphone.base.util.log.wrapper;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.log.ILogWriter;
import com.tencent.qphone.base.util.log.encrypt.XorKey;
import com.tencent.qphone.base.util.log.processor.ByteProcessorComposer;
import com.tencent.qphone.base.util.log.processor.DeflateCompressor;
import com.tencent.qphone.base.util.log.processor.ProcessByteData;
import com.tencent.qphone.base.util.log.processor.XOREncryption;
import com.tencent.qphone.base.util.log.utils.JavaStringCoder;
import com.tencent.qphone.base.util.log.utils.MagicHeadWriter;
import com.tencent.qphone.base.util.log.utils.MappedLogWriter;
import com.tencent.qphone.base.util.log.utils.MmapUtil;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MmapLogWrapper implements ILogWriter, JavaStringCoder.JavaStringCoderCallback {
    public static final String TAG = "JavaMmapAppender";
    int bufferSize;
    MappedByteBuffer cacheFileMmapBuffer;
    boolean compress;
    boolean encrypt;
    MappedLogWriter finalLogFileWriter;
    private boolean isLastUnwriteMmapExist;
    JavaStringCoder javaStringCoder;
    protected Object lock = this;
    String logPath;
    MagicHeadWriter magicWriter;
    String mmapCachePath;
    ByteProcessorComposer processors;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class Builder {
        private String bufferFilePath;
        private int bufferSize = 8192;
        private boolean compress;
        private boolean encrypt;
        private String logFilePath;

        public MmapLogWrapper create() {
            if (this.logFilePath != null) {
                if (this.bufferFilePath != null) {
                    return new MmapLogWrapper(this);
                }
                throw new RuntimeException("need bufferFilePath path");
            }
            throw new IllegalArgumentException("logFilePath cannot be null");
        }

        public Builder setBufferFilePath(String str) {
            this.bufferFilePath = str;
            return this;
        }

        public Builder setBufferSize(int i3) {
            this.bufferSize = i3;
            return this;
        }

        public Builder setCompress(boolean z16) {
            this.compress = z16;
            return this;
        }

        public Builder setEncrypt(boolean z16) {
            this.encrypt = z16;
            return this;
        }

        public Builder setLogFilePath(String str) {
            this.logFilePath = str;
            return this;
        }
    }

    public MmapLogWrapper(Builder builder) {
        this.mmapCachePath = builder.bufferFilePath;
        this.logPath = builder.logFilePath;
        this.bufferSize = builder.bufferSize;
        this.compress = builder.compress;
        this.encrypt = builder.encrypt;
        try {
            this.isLastUnwriteMmapExist = new File(this.mmapCachePath).exists();
            this.cacheFileMmapBuffer = MmapUtil.getMmapFileByPath(this.mmapCachePath, this.bufferSize);
            this.finalLogFileWriter = new MappedLogWriter(this.logPath);
            ByteProcessorComposer byteProcessorComposer = new ByteProcessorComposer();
            this.processors = byteProcessorComposer;
            byteProcessorComposer.addProcessor(new DeflateCompressor(this.compress));
            this.processors.addProcessor(new XOREncryption(this.encrypt));
            this.magicWriter = new MagicHeadWriter(this.cacheFileMmapBuffer, this.compress);
            this.javaStringCoder = new JavaStringCoder(this);
            writeLastCacheAndNewHeader();
        } catch (IOException e16) {
            e16.printStackTrace();
        }
    }

    private void copyCacheToLogFileAndReset() {
        if (this.magicWriter.prepareToWrite()) {
            this.finalLogFileWriter.writeThroughMmapBuffer(this.cacheFileMmapBuffer);
        }
        this.cacheFileMmapBuffer.clear();
        this.magicWriter.writeInitLength();
    }

    private static byte[] getExistedMmapBytes(MappedByteBuffer mappedByteBuffer) {
        mappedByteBuffer.getInt();
        int i3 = mappedByteBuffer.getInt();
        if (i3 <= mappedByteBuffer.capacity() && i3 > 0) {
            byte[] bArr = new byte[i3];
            mappedByteBuffer.get(bArr);
            return bArr;
        }
        return null;
    }

    private void writeLastCacheAndNewHeader() {
        byte[] existedMmapBytes;
        int i3;
        try {
            if (this.isLastUnwriteMmapExist && (existedMmapBytes = getExistedMmapBytes(this.cacheFileMmapBuffer)) != null && existedMmapBytes.length != 0) {
                if (this.compress) {
                    i3 = MagicHeadWriter.MAGIC_HEAD_COMPRESS;
                } else {
                    i3 = MagicHeadWriter.MAGIC_HEAD_NO_COMPRESS;
                }
                this.finalLogFileWriter.writeThroughByteArray(ByteBuffer.allocate(4).putInt(i3).array());
                this.finalLogFileWriter.writeThroughByteArray(ByteBuffer.allocate(4).putInt(existedMmapBytes.length).array());
                this.finalLogFileWriter.writeThroughByteArray(existedMmapBytes);
            }
        } catch (Throwable th5) {
            Log.e(TAG, "writeLastCacheAndNewHeader failed. ", th5);
        }
        this.cacheFileMmapBuffer.clear();
        try {
            String encryptedKey = XorKey.encryptedKey(XOREncryption.getXorKey());
            if (!TextUtils.isEmpty(encryptedKey)) {
                this.cacheFileMmapBuffer.putInt(MagicHeadWriter.MAGIC_ENCRYPT_CODE);
                byte[] bytes = encryptedKey.getBytes(XOREncryption.charset);
                this.cacheFileMmapBuffer.putInt(bytes.length + 4);
                this.cacheFileMmapBuffer.putInt(1);
                this.cacheFileMmapBuffer.put(bytes);
                if (QLog.isDebugVersion()) {
                    Log.d(TAG, "copyCacheToLogFileAndReset:  encryptedKey: " + encryptedKey);
                    Log.d(TAG, "writeThroughMmapBuffer first length=" + this.cacheFileMmapBuffer.position() + " limit=" + this.cacheFileMmapBuffer.limit());
                }
                this.cacheFileMmapBuffer.flip();
                this.finalLogFileWriter.writeThroughMmapBuffer(this.cacheFileMmapBuffer);
            }
        } catch (Throwable th6) {
            Log.e(TAG, "", th6);
        }
        this.cacheFileMmapBuffer.clear();
        this.magicWriter.writeInitLength();
    }

    @Override // com.tencent.qphone.base.util.log.ILogWriter
    public void close() {
        synchronized (this.lock) {
            this.javaStringCoder.flush();
            copyCacheToLogFileAndReset();
            try {
                this.finalLogFileWriter.close();
                this.processors.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
    }

    @Override // com.tencent.qphone.base.util.log.ILogWriter
    public void flush() {
        synchronized (this.lock) {
            this.javaStringCoder.flush();
        }
    }

    @Override // com.tencent.qphone.base.util.log.utils.JavaStringCoder.JavaStringCoderCallback
    public void onBufferFull(ProcessByteData processByteData) {
        ProcessByteData handleData = this.processors.handleData(processByteData);
        this.cacheFileMmapBuffer.put(handleData.bytes, handleData.offset, handleData.length);
        this.magicWriter.updateLength();
        if (this.cacheFileMmapBuffer.position() > this.cacheFileMmapBuffer.capacity() + MessageRecord.MSG_TYPE_TROOP_REWARD) {
            copyCacheToLogFileAndReset();
            this.processors.reset();
        }
    }

    @Override // com.tencent.qphone.base.util.log.ILogWriter
    public void write(String str) {
        synchronized (this.lock) {
            this.javaStringCoder.feedIn(str);
        }
    }

    @Override // com.tencent.qphone.base.util.log.ILogWriter
    public void write(int i3) {
        synchronized (this.lock) {
            this.javaStringCoder.feedIn(i3);
        }
    }

    @Override // com.tencent.qphone.base.util.log.ILogWriter
    public void write(char[] cArr, int i3, int i16) {
        synchronized (this.lock) {
            this.javaStringCoder.feedIn(cArr, i3, i16);
        }
    }

    @Override // com.tencent.qphone.base.util.log.ILogWriter
    public void write(byte[] bArr, int i3, int i16) throws IOException {
        synchronized (this.lock) {
            this.javaStringCoder.feedIn(bArr, i3, i16);
        }
    }
}
