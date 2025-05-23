package com.tencent.gdtad.basics.motivevideo;

import android.content.Context;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface ICmGameVideoPlayer extends QRouteApi {
    public static final int STATUS_COMPLETE = 5;
    public static final int STATUS_INIT = 1;
    public static final int STATUS_PAUSED = 4;
    public static final int STATUS_PREPARED = 2;
    public static final int STATUS_RELEASED = 6;
    public static final int STATUS_RESUME = 3;

    void addPlayerCallback(l lVar);

    void addPlayerCallback(l lVar, long j3);

    long getCurrentPosition();

    boolean getMuteValue();

    int getStatus();

    View getVideoContainer();

    long getVideoDuration();

    int getVideoHeight();

    int getVideoWidth();

    void initVideoPlayer(Context context, AppInterface appInterface);

    boolean isPaused();

    boolean isPlaying();

    boolean isSurfaceDestroyed();

    boolean pause();

    void release();

    void removePlayerCallback(l lVar);

    void resume();

    void seekTo(int i3);

    void setMute(boolean z16);

    void startPlay(String str, String str2, int i3);

    void stopPlay();
}
