package com.tencent.tav.decoder;

import com.tencent.tav.ResourceLoadUtil;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import kotlin.jvm.internal.ShortCompanionObject;

/* compiled from: P */
/* loaded from: classes26.dex */
public class AudioMixer {
    public static final int OUTPUT_CHANNEL_COUNT = 1;
    public static final int OUTPUT_SAMPLE_RATE = 44100;
    private static final int SIGNED_SHORT_LIMIT = 32768;
    private static final String TAG = "AudioMixer";
    private static final int UNSIGNED_SHORT_MAX = 65535;
    private ByteBuffer cachedByteBuffer;
    private ByteBuffer cachedMergedBuffer;
    private short[] cachedMergedBytes;
    private int destAudioChannelCount;
    private int destAudioSampleRate;
    private ByteBuffer emptyAudioBuffer;
    private long nativeContext;
    private int pcmEncoding;
    private short[] resampleBuffer;
    private short[] sampleBuffer;
    private float sampleFactor;
    private boolean singleChannel;
    private int srcNumChannels;
    private int srcSampleRate;

    static {
        if (!ResourceLoadUtil.isLoaded()) {
            try {
                System.out.println("loadlibrary : tav start");
                System.loadLibrary("tav");
                ResourceLoadUtil.setLoaded(true);
                System.out.println("loadlibrary : tav end");
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    public AudioMixer() {
        this(44100, 1);
    }

    private short[] downRemix(short[] sArr) {
        ShortBuffer wrap = ShortBuffer.wrap(sArr);
        ShortBuffer allocate = ShortBuffer.allocate(sArr.length);
        downRemix(wrap, allocate);
        return allocate.array();
    }

    private short[] getCachedSampleBuffer(int i3) {
        short[] sArr = this.sampleBuffer;
        if (sArr != null && sArr.length >= i3) {
            return sArr;
        }
        short[] sArr2 = new short[i3];
        this.sampleBuffer = sArr2;
        return sArr2;
    }

    private int getResampleLength(int i3) {
        int i16 = (int) (i3 * this.sampleFactor);
        if (i16 % 2 == 1) {
            return i16 - 1;
        }
        return i16;
    }

    private native void nativeRelease(long j3);

    private native long nativeSetup(int i3, int i16);

    private native void readShortFromStream(long j3, short[] sArr);

    private short[] resample(short[] sArr, int i3) {
        float f16 = this.sampleFactor;
        if (f16 == 1.0f) {
            return sArr;
        }
        if (Float.compare(f16, 0.5f) == 0) {
            return downRemix(sArr);
        }
        int resampleLength = getResampleLength(i3);
        short[] sArr2 = this.resampleBuffer;
        if (sArr2 == null || sArr2.length < resampleLength) {
            sArr2 = new short[resampleLength];
            this.resampleBuffer = sArr2;
        }
        float f17 = 1.0f / this.sampleFactor;
        int i16 = 0;
        if (this.singleChannel) {
            while (i16 < resampleLength) {
                short s16 = sArr[(int) (i16 * f17)];
                sArr2[i16 + 1] = s16;
                sArr2[i16] = s16;
                i16 += 2;
            }
        } else {
            while (i16 < resampleLength) {
                int i17 = ((int) (i16 * 0.5d * f17)) * 2;
                sArr2[i16] = sArr[i17];
                sArr2[i16 + 1] = sArr[i17 + 1];
                i16 += 2;
            }
        }
        return sArr2;
    }

    private native int writeShortToStream(long j3, short[] sArr, int i3, float f16, float f17, float f18);

    protected void finalize() {
        release();
    }

    public int getDestAudioChannelCount() {
        return this.destAudioChannelCount;
    }

    public ByteBuffer mergeSamples(ShortBuffer shortBuffer, ShortBuffer shortBuffer2) {
        ByteBuffer byteBuffer = this.cachedMergedBuffer;
        if (byteBuffer != null && byteBuffer.capacity() >= shortBuffer.limit() * 2) {
            this.cachedMergedBuffer.clear();
        } else {
            ByteBuffer allocate = ByteBuffer.allocate(shortBuffer.limit() * 2);
            this.cachedMergedBuffer = allocate;
            allocate.order(shortBuffer.order());
        }
        short[] sArr = this.cachedMergedBytes;
        if (sArr == null || sArr.length < shortBuffer.limit() * 2) {
            this.cachedMergedBytes = new short[shortBuffer.limit() * 2];
        }
        ShortBuffer asShortBuffer = this.cachedMergedBuffer.asShortBuffer();
        short[] sArr2 = this.cachedMergedBytes;
        int min = Math.min(shortBuffer.limit(), shortBuffer2.limit());
        for (int i3 = 0; i3 < min; i3++) {
            int i16 = shortBuffer.get(i3) + shortBuffer2.get(i3);
            int i17 = -32768;
            if (i16 >= -32768) {
                i17 = 32767;
                if (i16 <= 32767) {
                    sArr2[i3] = (short) i16;
                }
            }
            i16 = i17;
            sArr2[i3] = (short) i16;
        }
        asShortBuffer.put(sArr2, 0, min);
        if (min < shortBuffer.limit()) {
            shortBuffer.position(min);
            asShortBuffer.put(shortBuffer);
        }
        this.cachedMergedBuffer.position(0);
        this.cachedMergedBuffer.limit(shortBuffer.limit() * 2);
        return this.cachedMergedBuffer;
    }

    public ByteBuffer processBytes(ByteBuffer byteBuffer, float f16, float f17, float f18) {
        int limit;
        short[] cachedSampleBuffer;
        ByteBuffer allocate;
        if (f16 == 1.0f && f17 == 1.0f && f18 == 1.0f && this.sampleFactor == 1.0f) {
            return byteBuffer;
        }
        int i3 = this.pcmEncoding;
        if (i3 == 2) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            limit = asShortBuffer.limit();
            cachedSampleBuffer = getCachedSampleBuffer(limit);
            asShortBuffer.get(cachedSampleBuffer, 0, limit);
        } else {
            if (i3 != 3) {
                return byteBuffer;
            }
            limit = byteBuffer.limit();
            byteBuffer.get(new byte[limit], 0, limit);
            cachedSampleBuffer = getCachedSampleBuffer(limit);
            for (int i16 = 0; i16 < limit; i16++) {
                cachedSampleBuffer[i16] = r2[i16];
            }
        }
        short[] resample = resample(cachedSampleBuffer, limit);
        int resampleLength = getResampleLength(limit);
        if (f17 == 0.0f) {
            resampleLength = (int) (resampleLength / f16);
        } else if (f16 != 1.0f || f17 != 1.0f || f18 != 1.0f) {
            resampleLength = writeShortToStream(this.nativeContext, resample, resampleLength / this.destAudioChannelCount, f16, f17, f18) * this.destAudioChannelCount;
            resample = getCachedSampleBuffer(resampleLength);
            readShortFromStream(this.nativeContext, resample);
        }
        if (f17 == 0.0f) {
            ByteBuffer byteBuffer2 = this.emptyAudioBuffer;
            if (byteBuffer2 == null || byteBuffer2.limit() < resampleLength * 2) {
                int i17 = resampleLength * 2;
                ByteBuffer allocate2 = ByteBuffer.allocate(i17);
                this.emptyAudioBuffer = allocate2;
                allocate2.order(byteBuffer.order());
                this.emptyAudioBuffer.put(new byte[i17]);
            }
            allocate = this.emptyAudioBuffer;
        } else {
            ByteBuffer byteBuffer3 = this.cachedByteBuffer;
            if (byteBuffer3 != null && byteBuffer3.capacity() >= resampleLength * 2) {
                allocate = this.cachedByteBuffer;
                allocate.clear();
            } else {
                allocate = ByteBuffer.allocate(resampleLength * 2);
                this.cachedByteBuffer = allocate;
                allocate.order(byteBuffer.order());
            }
            allocate.asShortBuffer().put(resample, 0, resampleLength);
        }
        allocate.position(0);
        allocate.limit(resampleLength * 2);
        return allocate;
    }

    public final void release() {
        nativeRelease(this.nativeContext);
        this.nativeContext = 0L;
    }

    public void setAudioInfo(int i3, int i16, int i17) {
        this.srcSampleRate = i3;
        this.srcNumChannels = i16;
        this.sampleFactor = (this.destAudioSampleRate * this.destAudioChannelCount) / ((i3 * i16) * 1.0f);
        boolean z16 = true;
        if (i16 != 1) {
            z16 = false;
        }
        this.singleChannel = z16;
        this.pcmEncoding = i17;
    }

    public AudioMixer(int i3, int i16) {
        this.srcSampleRate = 44100;
        this.srcNumChannels = 1;
        this.destAudioSampleRate = i3;
        this.destAudioChannelCount = i16;
        this.nativeContext = nativeSetup(i3, i16);
        this.sampleFactor = 1.0f;
        this.singleChannel = i16 == 1;
        this.pcmEncoding = 2;
    }

    public void downRemix(ShortBuffer shortBuffer, ShortBuffer shortBuffer2) {
        int min = Math.min(shortBuffer.remaining() / 2, shortBuffer2.remaining());
        for (int i3 = 0; i3 < min; i3++) {
            int i16 = ((shortBuffer.get() + ShortCompanionObject.MIN_VALUE) + (shortBuffer.get() + ShortCompanionObject.MIN_VALUE)) / 2;
            if (i16 >= 65536) {
                i16 = -1;
            }
            shortBuffer2.put((short) (i16 - 32768));
        }
    }
}
