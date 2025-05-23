package com.tencent.qqmini.sdk.launcher.core.proxy;

/* loaded from: classes23.dex */
public abstract class IMiniGameProxy {

    /* loaded from: classes23.dex */
    public interface QMiniTouchHeartBeatListener {
        void onHeartBeat(String str);
    }

    public long getBeatInterval() {
        return 5000L;
    }

    public abstract QMiniTouchHeartBeatListener getHeartBeatListener();
}
