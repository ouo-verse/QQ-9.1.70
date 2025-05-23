package com.qq.e.comm.pi;

import android.view.Surface;

/* loaded from: classes3.dex */
public interface ITangramDecoderPlayer {

    /* loaded from: classes3.dex */
    public interface OnCompletionListener {
        void onCompletion(ITangramDecoderPlayer iTangramDecoderPlayer);
    }

    /* loaded from: classes3.dex */
    public interface OnErrorListener {
        boolean onError(ITangramDecoderPlayer iTangramDecoderPlayer, int i3, int i16);
    }

    /* loaded from: classes3.dex */
    public interface OnInfoListener {
        boolean onInfo(ITangramDecoderPlayer iTangramDecoderPlayer, int i3, int i16);
    }

    /* loaded from: classes3.dex */
    public interface OnPreparedListener {
        void onPrepared(ITangramDecoderPlayer iTangramDecoderPlayer);
    }

    /* loaded from: classes3.dex */
    public interface OnSeekCompleteListener {
        void onSeekComplete(ITangramDecoderPlayer iTangramDecoderPlayer);
    }

    int getCurrentPosition();

    int getDuration();

    int getVideoHeight();

    int getVideoWidth();

    void pause();

    void prepareAsync();

    void release();

    void seekTo(int i3);

    void setDataSource(String str);

    void setLooping(boolean z16);

    void setOnCompletionListener(OnCompletionListener onCompletionListener);

    void setOnErrorListener(OnErrorListener onErrorListener);

    void setOnInfoListener(OnInfoListener onInfoListener);

    void setOnPreparedListener(OnPreparedListener onPreparedListener);

    void setOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener);

    void setSurface(Surface surface);

    void setVolume(float f16, float f17);

    void start();

    void stop();
}
