package com.tencent.qq.effect.alphavideo.videoplayer.interfaces;

/* loaded from: classes22.dex */
public interface IVideoPLayListener {
    public static final int ERROR_CREATE_DECODER = -2;
    public static final int ERROR_FILE_RELATIVE = -1;
    public static final int ERROR_IN_PLAYING = -11;
    public static final int ERROR_START_DECODE_TIMEOUT = -3;
    public static final int ERROR_STATE_ALSO_PLAYING = -10;
    public static final int ERROR_STATE_VIEW_ALSO_READY = -11;
    public static final int ERROR_STATE_VIEW_ALSO_STOPING = -12;

    void onEnd();

    void onError(int i3);

    void onPlayAtTime(long j3);

    void onStart();

    void onVideoSize(int i3, int i16);
}
