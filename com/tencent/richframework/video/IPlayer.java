package com.tencent.richframework.video;

import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0002H&J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH&J\b\u0010\r\u001a\u00020\fH&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0002H&J\b\u0010\u0012\u001a\u00020\nH&J\b\u0010\u0013\u001a\u00020\nH&J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0002H&J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0016H&J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0019H&J\u0018\u0010 \u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH&J\"\u0010'\u001a\u00020\n2\u0006\u0010\"\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010&\u001a\u00020%H&J\b\u0010(\u001a\u00020\u0016H&J\b\u0010)\u001a\u00020\u0016H&J\n\u0010+\u001a\u0004\u0018\u00010*H&\u00a8\u0006,"}, d2 = {"Lcom/tencent/richframework/video/IPlayer;", "", "", "isReady", "isRelease", "isPlaying", "isPausing", "isBuffering", "Lcom/tencent/richframework/video/RFWPlayerVideoInfo;", QCircleScheme.AttrDetail.VIDEO_INFO, "", "setVideoInfo", "Landroid/view/View;", "getVideoView", "Landroid/view/TextureView;", "getRenderTextureView", "outputMute", "setOutputMute", "start", "pause", "loopBack", "setLoopback", "", "position", InnerAudioPlugin.AUDIO_OPERATE_SEEK, "", "playRate", "setPlayRate", "", "url", "Lcom/tencent/richframework/video/SwitchUrlType;", "type", "switchDefinitionForUrl", "Lcom/tencent/richframework/video/IPlayerStateCallback;", "callback", "Landroid/view/Surface;", "surface", "", WadlProxyConsts.SCENE_ID, "init", "getDurationMs", "getCurrentPositionMs", "Lcom/tencent/richframework/video/MediaInfo;", "getMediaInfo", "video-base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public interface IPlayer {
    long getCurrentPositionMs();

    long getDurationMs();

    @Nullable
    MediaInfo getMediaInfo();

    @Nullable
    TextureView getRenderTextureView();

    @NotNull
    View getVideoView();

    void init(@NotNull IPlayerStateCallback callback, @Nullable Surface surface, int sceneId);

    boolean isBuffering();

    boolean isPausing();

    boolean isPlaying();

    boolean isReady();

    boolean isRelease();

    void pause();

    void seek(long position);

    void setLoopback(boolean loopBack);

    void setOutputMute(boolean outputMute);

    void setPlayRate(float playRate);

    void setVideoInfo(@NotNull RFWPlayerVideoInfo videoInfo);

    void start();

    void switchDefinitionForUrl(@NotNull String url, @NotNull SwitchUrlType type);
}
