package com.tencent.biz.richframework.video.rfw.player.playinterceptor.controller;

import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;

/* loaded from: classes5.dex */
public interface IRFWPlayerAction {
    ISPlayerVideoView createPlayerVideoView();

    ISuperPlayer ensureSuperPlayer(ISPlayerVideoView iSPlayerVideoView);

    void tryToOpenMediaPlayer(ISuperPlayer iSuperPlayer, SuperPlayerVideoInfo superPlayerVideoInfo, long j3, SuperPlayerOption superPlayerOption);
}
