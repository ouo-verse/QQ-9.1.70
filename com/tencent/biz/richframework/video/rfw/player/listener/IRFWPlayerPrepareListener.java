package com.tencent.biz.richframework.video.rfw.player.listener;

import com.tencent.biz.richframework.video.rfw.RFWPlayer;

/* loaded from: classes5.dex */
public interface IRFWPlayerPrepareListener {
    void onFirstFrameRendered(RFWPlayer rFWPlayer);

    void onVideoPrepared(RFWPlayer rFWPlayer);
}
