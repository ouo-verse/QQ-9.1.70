package com.tencent.mobileqq.qqnt.videoplay.player;

import com.tencent.mobileqq.qqnt.videoplay.api.param.c;
import com.tencent.superplayer.view.ISPlayerVideoView;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b`\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0010H&J\b\u0010\u0013\u001a\u00020\u000bH&J\b\u0010\u0014\u001a\u00020\u000bH&J\b\u0010\u0015\u001a\u00020\u000bH&J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0010H&\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qqnt/videoplay/player/a;", "", "Lcom/tencent/superplayer/view/ISPlayerVideoView;", "getVideoView", "", "getVideoDurationMs", "getCurrentPositionMs", "Lcom/tencent/mobileqq/qqnt/videoplay/player/PlayState;", "getPlayState", "", "time", "", "seekTo", "Lcom/tencent/mobileqq/qqnt/videoplay/api/param/c;", "playParam", "a", "", "isMute", "setMute", "startPlay", "resumePlay", QZoneJsConstants.METHOD_RECORDER_PAUSE_PLAY, "needRecordPosition", QZoneJsConstants.METHOD_RECORDER_STOP_PLAY, "videoplay_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public interface a {
    void a(@NotNull c playParam);

    long getCurrentPositionMs();

    @NotNull
    PlayState getPlayState();

    long getVideoDurationMs();

    @Nullable
    ISPlayerVideoView getVideoView();

    boolean isMute();

    void pausePlay();

    void resumePlay();

    void seekTo(int time);

    void setMute(boolean isMute);

    void startPlay();

    void stopPlay(boolean needRecordPosition);
}
