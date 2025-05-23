package com.tencent.qqlive.tvkplayer.api;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKVideoFrameCapture {

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface OnCaptureBufferedListener {
        void onEndOfBuffering(ITVKVideoFrameCapture iTVKVideoFrameCapture);

        void onStartBuffering(ITVKVideoFrameCapture iTVKVideoFrameCapture);
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface OnCaptureCompletionListener {
        void onCaptureCompletion(ITVKVideoFrameCapture iTVKVideoFrameCapture);
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface OnCaptureErrorListener {
        boolean onError(ITVKVideoFrameCapture iTVKVideoFrameCapture, int i3, String str);
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface OnCaptureFrameOutListener {
        void onVideoFrame(byte[] bArr, int i3, int i16, int i17, int i18, long j3);
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface OnCapturePreparedListener {
        void onCapturePrepared(ITVKVideoFrameCapture iTVKVideoFrameCapture);
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface OnCaptureSeekCompleteListener {
        void onCaptureSeekComplete(ITVKVideoFrameCapture iTVKVideoFrameCapture);
    }

    boolean addOnCaptureBufferedListener(OnCaptureBufferedListener onCaptureBufferedListener);

    boolean addOnCaptureCompletionListener(OnCaptureCompletionListener onCaptureCompletionListener);

    boolean addOnCaptureErrorListener(OnCaptureErrorListener onCaptureErrorListener);

    boolean addOnCaptureFrameOutListener(OnCaptureFrameOutListener onCaptureFrameOutListener);

    boolean addOnCapturePreparedListener(OnCapturePreparedListener onCapturePreparedListener);

    boolean addOnCaptureSeekCompleteListener(OnCaptureSeekCompleteListener onCaptureSeekCompleteListener);

    void captureVideoByUrl(Context context, String str, long j3, long j16);

    void captureVideoByVid(Context context, TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo);

    void pause();

    void release();

    void seekTo(int i3);

    void seekToAccuratePos(int i3);

    void start();

    void stop();
}
