package com.tencent.ams.fusion.widget.alphaplayer.player;

import android.view.Surface;
import androidx.annotation.NonNull;

/* loaded from: classes3.dex */
public interface IPlayer {

    /* loaded from: classes3.dex */
    public interface OnCompletionListener {
        void onCompletion(@NonNull IPlayer iPlayer);
    }

    /* loaded from: classes3.dex */
    public interface OnErrorListener {
        boolean onError(@NonNull IPlayer iPlayer, int i3, int i16);
    }

    /* loaded from: classes3.dex */
    public interface OnInfoListener {
        boolean onInfo(@NonNull IPlayer iPlayer, int i3, int i16);
    }

    /* loaded from: classes3.dex */
    public interface OnPreparedListener {
        void onPrepared(@NonNull IPlayer iPlayer);
    }

    /* loaded from: classes3.dex */
    public interface OnSeekCompleteListener {
        void onSeekComplete(@NonNull IPlayer iPlayer);
    }

    int getCurrentPosition();

    int getDuration();

    int getVideoHeight();

    int getVideoWidth();

    boolean isPlaying();

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
