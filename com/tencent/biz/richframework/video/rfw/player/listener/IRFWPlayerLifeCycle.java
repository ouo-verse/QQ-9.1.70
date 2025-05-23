package com.tencent.biz.richframework.video.rfw.player.listener;

import com.tencent.biz.richframework.video.rfw.RFWPlayer;

/* loaded from: classes5.dex */
public interface IRFWPlayerLifeCycle {
    void onDeInit(RFWPlayer rFWPlayer);

    void onPause(RFWPlayer rFWPlayer);

    void onRelease(RFWPlayer rFWPlayer);

    void onStart(RFWPlayer rFWPlayer);

    void onStop(RFWPlayer rFWPlayer);
}
