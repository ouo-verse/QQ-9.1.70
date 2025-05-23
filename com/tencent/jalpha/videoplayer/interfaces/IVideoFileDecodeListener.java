package com.tencent.jalpha.videoplayer.interfaces;

import android.media.MediaFormat;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface IVideoFileDecodeListener {
    public static final int ERROR_CREATE_CODEC = -5;
    public static final int ERROR_FILE_PATH = -1;
    public static final int ERROR_FORMAT_NOT_VIDEO = -3;
    public static final int ERROR_IN_DECODING = -101;
    public static final int ERROR_SELECT_VIDEO_TRACK_FORMAT = -2;

    void onVideoDecodeEnd();

    void onVideoDecodeError(int i3);

    void onVideoDecodeFrame(long j3, byte[] bArr);

    void onVideoDecodeStart();

    void onVideoDecoderCreated(boolean z16);

    void onVideoFormat(MediaFormat mediaFormat);

    void onVideoSize(int i3, int i16);
}
