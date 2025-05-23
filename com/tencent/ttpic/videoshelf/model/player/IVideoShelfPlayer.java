package com.tencent.ttpic.videoshelf.model.player;

import android.content.res.AssetManager;
import android.view.Surface;
import android.view.SurfaceHolder;

/* loaded from: classes27.dex */
public interface IVideoShelfPlayer {
    public static final int PAG_VIDEO_SHELF = 1;
    public static final int WESEE_VIDEO_SHELF = 0;

    void flush();

    int getCurrentPosition();

    long getDuration();

    int getVideoHeight();

    int getVideoWidth();

    boolean isPlaying();

    void pause();

    void prepare();

    void reset();

    void seekTo(int i3);

    void setDataSource(AssetManager assetManager, String str);

    void setDataSource(String str);

    void setDisplay(SurfaceHolder surfaceHolder);

    void setLooping(boolean z16);

    void setParam(String str, Object... objArr);

    void setSurface(Surface surface);

    void setVideoShelfPlayerListener(IVideoShelfPlayerListener iVideoShelfPlayerListener);

    void start();

    void stop();

    void surfaceUpdateSize();
}
