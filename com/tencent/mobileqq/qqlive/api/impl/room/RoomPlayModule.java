package com.tencent.mobileqq.qqlive.api.impl.room;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.richmedia.i;
import com.tencent.mobileqq.qqlive.api.player.IPlayerChangeUrlManager;
import com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView;
import com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener;
import java.util.List;

/* loaded from: classes17.dex */
public interface RoomPlayModule {
    public static final int NOT_PREPARE = 0;
    public static final int PLAY_STATUS_COMPLETE = 3;
    public static final int PLAY_STATUS_PLAYING = 1;
    public static final int PLAY_STATUS_STOP = 2;
    public static final int PREPARED = 2;
    public static final int PREPARING = 1;
    public static final long RETRY_INTERVAL_TIME = 2000;

    void destroy();

    boolean disableViewCallback();

    boolean enableViewCallback();

    int getCurrentStatus();

    String getPlayUrl();

    IPlayerChangeUrlManager getPlayerChangeUrlManager();

    List<AudienceRoomPlayerListener> getPlayerListeners();

    @NonNull
    i getVideoSize();

    ITPPlayerVideoView getVideoView();

    boolean isOutputMute();

    void pause();

    void playerOnlyPauseWhenReset(boolean z16);

    void preloadUrl(String str);

    void registerRoomPlayerListener(AudienceRoomPlayerListener audienceRoomPlayerListener);

    void replay();

    void reset();

    void resetPlayer();

    void retry();

    void setMute(boolean z16);

    void setPlayUrl(String str);

    void setPlayerChangeUrlManager(IPlayerChangeUrlManager iPlayerChangeUrlManager);

    void setRetryParams(long j3, int i3);

    void setRetryParams(long j3, int i3, PlayRetryStrategy playRetryStrategy);

    void setVideoSurface();

    void startPlay(String str);

    void switchDefinition(String str);

    void unRegisterRoomPlayerListener(AudienceRoomPlayerListener audienceRoomPlayerListener);
}
