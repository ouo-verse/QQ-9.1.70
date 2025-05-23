package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.content.Context;
import android.os.Bundle;
import android.view.Surface;
import java.lang.reflect.InvocationHandler;

/* loaded from: classes23.dex */
public interface IWXLivePlayerProxy {
    void hookListenerAndGoOn(String str, InvocationHandler invocationHandler);

    void init(Context context, InvocationHandler invocationHandler, InvocationHandler invocationHandler2);

    void initLivePlayer(Object obj, Bundle bundle);

    boolean needLoadAvJar();

    void txCloudVideoView_disableLog(Boolean bool);

    void txCloudVideoView_showLog(Boolean bool);

    void txLivePlayConfig_setAutoAdjustCacheTime(Boolean bool);

    void txLivePlayConfig_setCacheTime(float f16);

    void txLivePlayConfig_setEnableMetaData(Boolean bool);

    void txLivePlayConfig_setMaxAutoAdjustCacheTime(float f16);

    void txLivePlayConfig_setMinAutoAdjustCacheTime(float f16);

    void txLivePlay_snapshot(InvocationHandler invocationHandler);

    void txLivePlayer_enableAudioVolumeEvaluation(int i3);

    void txLivePlayer_enableHardwareDecode(Boolean bool);

    boolean txLivePlayer_isPlaying();

    void txLivePlayer_muteAudio(Boolean bool);

    void txLivePlayer_muteVideo(Boolean bool);

    void txLivePlayer_pause();

    void txLivePlayer_resume();

    void txLivePlayer_setAudioRoute(int i3);

    void txLivePlayer_setAudioVolumeEvaluationListener(Object obj);

    void txLivePlayer_setConfig();

    void txLivePlayer_setPlayListener(Object obj);

    void txLivePlayer_setPlayerView(Object obj);

    void txLivePlayer_setRenderMode(int i3);

    void txLivePlayer_setRenderRotation(int i3);

    void txLivePlayer_setSurface(Surface surface);

    void txLivePlayer_setSurfaceSize(int i3, int i16);

    void txLivePlayer_showDebugLog(Boolean bool);

    int txLivePlayer_startPlay(String str, int i3);

    int txLivePlayer_stopPlay(Boolean bool);

    void txPlayConfig_setEnableMessage(Boolean bool);

    void updateLivePlayer(Bundle bundle);
}
