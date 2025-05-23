package com.qq.wx.voice.embedqqegg.vad;

/* compiled from: P */
/* loaded from: classes3.dex */
public class EVadNative {
    public static final int VAD_ERROR = 1;
    public static final int VAD_SILENCE = 3;
    public static final int VAD_SPEAK = 2;
    public static final int VAD_SUCCESS = 0;
    public static final int VAD_UNKNOW = 4;

    public native int AddData(long j3, short[] sArr, int i3);

    public native long Init(int i3, int i16, float f16, int i17, int i18);

    public native int Release(long j3);

    public native int Reset(long j3);
}
