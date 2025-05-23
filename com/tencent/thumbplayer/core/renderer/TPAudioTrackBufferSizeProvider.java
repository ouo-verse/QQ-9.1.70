package com.tencent.thumbplayer.core.renderer;

import com.tencent.thumbplayer.core.utils.TPNativeLog;

/* loaded from: classes26.dex */
public class TPAudioTrackBufferSizeProvider {
    private static final int AC3_BUFFER_MULTIPLICATION_FACTOR = 2;
    private static final int MAX_PCM_BUFFER_DURATION_US = 750000;
    private static final int MIN_PCM_BUFFER_DURATION_US = 250000;
    private static final int PASSTHROUGH_BUFFER_DURATION_US = 250000;
    private static final int PCM_BUFFER_MULTIPLICATION_FACTOR = 4;
    private static final String TAG = "AudioTrackBufferSizeProvider";
    protected final int minPcmBufferDurationUs = 250000;
    protected final int maxPcmBufferDurationUs = MAX_PCM_BUFFER_DURATION_US;
    protected final int pcmBufferMultiplicationFactor = 4;
    protected final int passthroughBufferDurationUs = 250000;
    public final int ac3BufferMultiplicationFactor = 2;

    protected static int durationUsToBytes(int i3, int i16, int i17) {
        return (int) (((i3 * i16) * i17) / 1000000);
    }

    protected static int getMaximumEncodedRateBytesPerSecond(int i3) {
        switch (i3) {
            case 5:
                return 80000;
            case 6:
            case 18:
                return 768000;
            case 7:
                return 192000;
            case 8:
                return 2250000;
            case 9:
                return 40000;
            case 10:
                return 100000;
            case 11:
                return 16000;
            case 12:
                return 7000;
            case 13:
            case 19:
            default:
                throw new IllegalArgumentException();
            case 14:
                return 3062500;
            case 15:
                return 8000;
            case 16:
                return 256000;
            case 17:
                return 336000;
            case 20:
                return 63750;
        }
    }

    protected int get1xBufferSizeInBytes(int i3, int i16, int i17, int i18, int i19, int i26) {
        if (i17 != 0) {
            if (i17 == 1) {
                return getPassthroughBufferSizeInBytes(i16, i26);
            }
            throw new IllegalArgumentException();
        }
        return getPcmBufferSizeInBytes(i3, i19, i18);
    }

    public int getBufferSizeInBytes(int i3, int i16, int i17, int i18, int i19, int i26) {
        return (((Math.max(i3, get1xBufferSizeInBytes(i3, i16, i17, i18, i19, i26)) + i18) - 1) / i18) * i18;
    }

    protected int getPassthroughBufferSizeInBytes(int i3, int i16) {
        int maximumEncodedRateBytesPerSecond;
        int i17 = this.passthroughBufferDurationUs;
        if (i3 == 5) {
            i17 *= this.ac3BufferMultiplicationFactor;
        }
        if (i16 != -1) {
            maximumEncodedRateBytesPerSecond = i16 / 8;
        } else {
            maximumEncodedRateBytesPerSecond = getMaximumEncodedRateBytesPerSecond(i3);
        }
        int i18 = (int) ((i17 * maximumEncodedRateBytesPerSecond) / 1000000);
        TPNativeLog.printLog(2, TAG, "bufferSizeUs:" + i17 + " encoding:" + i3 + " byteRate:" + maximumEncodedRateBytesPerSecond + " getPassthroughBufferSizeInBytes:" + i18);
        return i18;
    }

    protected int getPcmBufferSizeInBytes(int i3, int i16, int i17) {
        int i18 = this.pcmBufferMultiplicationFactor * i3;
        int durationUsToBytes = durationUsToBytes(this.minPcmBufferDurationUs, i16, i17);
        int durationUsToBytes2 = durationUsToBytes(this.maxPcmBufferDurationUs, i16, i17);
        int constrainValue = TPAudioSinkUtils.constrainValue(i18, durationUsToBytes, durationUsToBytes2);
        TPNativeLog.printLog(2, TAG, "minBufferSizeInBytes:" + i3 + " targetBufferSize:" + i18 + " minAppBufferSize:" + durationUsToBytes + " maxAppBufferSize:" + durationUsToBytes2 + " getPcmBufferSizeInBytes:" + constrainValue);
        return constrainValue;
    }
}
