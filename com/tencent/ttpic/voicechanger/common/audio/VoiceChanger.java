package com.tencent.ttpic.voicechanger.common.audio;

import com.tencent.ttpic.baseutils.log.LogUtils;

/* compiled from: P */
/* loaded from: classes27.dex */
public class VoiceChanger {
    public static final double FRAME_DURATION = 0.02d;
    private static final String TAG = "VoiceChanger";
    private long changer;
    private int environment;
    private int frameLength;
    private String outputPath;
    private int sampleRate;
    private int voiceKind;

    public VoiceChanger(String str, int i3, int i16, int i17) {
        this.outputPath = str;
        this.sampleRate = i3;
        this.frameLength = (int) (i3 * 0.02d);
        this.voiceKind = i16;
        this.environment = i17;
        this.changer = initVoiceChanger(i3, i16, i17);
    }

    private native short[] changeFrames(short[] sArr);

    public static native int changeVoice4File(String str, String str2, int i3, int i16, int i17);

    public static native int demo(String str, String str2, int i3);

    public static native long initVoiceChanger(int i3, int i16, int i17);

    private native void releaseVoiceChanger();

    private byte[] short2Byte(short[] sArr) {
        int length = sArr.length;
        byte[] bArr = new byte[length * 2];
        for (int i3 = 0; i3 < length; i3++) {
            int i16 = i3 * 2;
            short s16 = sArr[i3];
            bArr[i16] = (byte) (s16 & 255);
            bArr[i16 + 1] = (byte) (s16 >> 8);
            sArr[i3] = 0;
        }
        return bArr;
    }

    public static native String stringFromJNI();

    public static byte[] toByteArray(short[] sArr) {
        int length = sArr.length;
        byte[] bArr = new byte[length << 1];
        for (int i3 = 0; i3 < length; i3++) {
            int i16 = i3 * 2;
            short s16 = sArr[i3];
            bArr[i16] = (byte) (s16 >> 8);
            bArr[i16 + 1] = (byte) (s16 >> 0);
        }
        return bArr;
    }

    public byte[] getBytes(short s16, boolean z16) {
        byte[] bArr = new byte[2];
        if (z16) {
            for (int i3 = 1; i3 >= 0; i3--) {
                bArr[i3] = (byte) (s16 & 255);
                s16 = (short) (s16 >> 8);
            }
        } else {
            for (int i16 = 0; i16 < 2; i16++) {
                bArr[i16] = (byte) (s16 & 255);
                s16 = (short) (s16 >> 8);
            }
        }
        return bArr;
    }

    public void release() {
        releaseVoiceChanger();
        LogUtils.i(TAG, "releaseVoiceChanger()");
    }

    public byte[] shorts2Bytes(short[] sArr) {
        byte[] bArr = new byte[sArr.length * 2];
        for (int i3 = 0; i3 < sArr.length; i3++) {
            byte[] bytes = getBytes(sArr[i3], false);
            for (int i16 = 0; i16 < 2; i16++) {
                bArr[(i3 * 2) + i16] = bytes[i16];
            }
        }
        return bArr;
    }

    public short[] writeVoiceFrameByShort(short[] sArr) {
        LogUtils.i(TAG, "writeVoiceFrames()");
        return changeFrames(sArr);
    }

    public byte[] writeVoiceFrames(short[] sArr) {
        LogUtils.i(TAG, "writeVoiceFrames()");
        short[] changeFrames = changeFrames(sArr);
        if (changeFrames == null) {
            return null;
        }
        return short2Byte(changeFrames);
    }
}
