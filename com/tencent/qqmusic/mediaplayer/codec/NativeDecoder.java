package com.tencent.qqmusic.mediaplayer.codec;

import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.NativeLibs;
import com.tencent.qqmusic.mediaplayer.upstream.FileDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: P */
/* loaded from: classes23.dex */
public class NativeDecoder extends BaseDecoder {
    private static final String TAG = "NativeDecoder";
    private final ReadWriteLock mReadWriteLock = new ReentrantReadWriteLock();
    private long mNativePointer = 0;

    private native int nativeDecode(long j3, byte[] bArr, int i3, int i16);

    private native AudioInformation nativeGetAudioInformation(long j3);

    private native long nativeGetBytePositionOfTime(long j3, long j16);

    private native long nativeGetCurrentPosition(long j3);

    private native int nativeGetDetailErrorCode(long j3);

    private native String nativeGetDetailErrorDescription(long j3);

    private native long nativeGetDuration(long j3);

    private native long nativeGetMinBufferSize(long j3);

    private native long[] nativeInit(long j3);

    private native long[] nativeInit(IDataSource iDataSource);

    private native int nativeRelease(long j3);

    private native long nativeSeekTo(long j3, long j16);

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public int decodeData(int i3, byte[] bArr) {
        this.mReadWriteLock.readLock().lock();
        try {
            return nativeDecode(this.mNativePointer, bArr, 0, i3);
        } finally {
            this.mReadWriteLock.readLock().unlock();
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public AudioInformation getAudioInformation() {
        this.mReadWriteLock.readLock().lock();
        try {
            return nativeGetAudioInformation(this.mNativePointer);
        } finally {
            this.mReadWriteLock.readLock().unlock();
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public long getBytePositionOfTime(long j3) {
        this.mReadWriteLock.readLock().lock();
        try {
            return nativeGetBytePositionOfTime(this.mNativePointer, j3);
        } finally {
            this.mReadWriteLock.readLock().unlock();
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public long getCurrentTime() {
        this.mReadWriteLock.readLock().lock();
        try {
            return nativeGetCurrentPosition(this.mNativePointer);
        } finally {
            this.mReadWriteLock.readLock().unlock();
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public long getDuration() {
        this.mReadWriteLock.readLock().lock();
        try {
            return nativeGetDuration(this.mNativePointer);
        } finally {
            this.mReadWriteLock.readLock().unlock();
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public int getErrorCodeMask() {
        return -1;
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public long getMinBufferSize() {
        this.mReadWriteLock.readLock().lock();
        try {
            return nativeGetMinBufferSize(this.mNativePointer);
        } finally {
            this.mReadWriteLock.readLock().unlock();
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public List<NativeLibs> getNativeLibs() {
        return Arrays.asList(NativeLibs.audioCommon, NativeLibs.formatDetector, NativeLibs.codecFactory, NativeLibs.decoderJni, NativeLibs.cppShared, NativeLibs.stlportShared, NativeLibs.xlog, NativeLibs.xFFmpeg);
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public int init(IDataSource iDataSource) {
        long j3;
        this.mReadWriteLock.writeLock().lock();
        try {
            long[] nativeInit = nativeInit(iDataSource);
            if (nativeInit == null || nativeInit.length < 2) {
                j3 = -1;
            } else {
                this.mNativePointer = nativeInit[0];
                j3 = nativeInit[1];
            }
            int i3 = (int) j3;
            return i3;
        } finally {
            this.mReadWriteLock.writeLock().unlock();
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public int release() {
        this.mReadWriteLock.writeLock().lock();
        try {
            int nativeRelease = nativeRelease(this.mNativePointer);
            this.mNativePointer = 0L;
            return nativeRelease;
        } finally {
            this.mReadWriteLock.writeLock().unlock();
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public int seekTo(int i3) {
        this.mReadWriteLock.readLock().lock();
        try {
            return (int) nativeSeekTo(this.mNativePointer, i3);
        } finally {
            this.mReadWriteLock.readLock().unlock();
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public int init(INativeDataSource iNativeDataSource) {
        long j3;
        this.mReadWriteLock.writeLock().lock();
        if (iNativeDataSource != null) {
            try {
                long[] nativeInit = nativeInit(iNativeDataSource.getNativeInstance());
                if (nativeInit != null && nativeInit.length >= 2) {
                    this.mNativePointer = nativeInit[0];
                    j3 = nativeInit[1];
                    int i3 = (int) j3;
                    return i3;
                }
            } finally {
                this.mReadWriteLock.writeLock().unlock();
            }
        }
        j3 = -1;
        int i36 = (int) j3;
        return i36;
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public int init(String str, boolean z16) {
        return init(new FileDataSource(str));
    }
}
