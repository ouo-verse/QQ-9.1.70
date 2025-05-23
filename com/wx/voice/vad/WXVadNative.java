package com.wx.voice.vad;

/* compiled from: P */
/* loaded from: classes22.dex */
public class WXVadNative {
    public static final int VAD_ERROR = 1;
    public static final int VAD_OK = 0;
    public static final int VAD_SILENCE = 3;
    public static final int VAD_SPEAK = 2;
    public static final int VAD_UNKNOW = 4;

    public native WXVadData GetOnlineProcessDataSize(long j3);

    public native long Init(String str, String str2);

    public native long InitUserParam(WXVadParam wXVadParam);

    public native WXVadData OfflineProcess(long j3, short[] sArr, long j16);

    public native WXVadData OnlineProcess(long j3, short[] sArr, long j16, int i3);

    public native int Release(long j3);

    public native int Reset(long j3);
}
