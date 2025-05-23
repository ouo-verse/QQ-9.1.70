package com.tencent.biz.richframework.video.rfw.player.playinterceptor;

import androidx.annotation.NonNull;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.controller.RFWBaseInterceptorController;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;

/* loaded from: classes5.dex */
public class RFWPlayerInterceptorController extends RFWBaseInterceptorController {
    public RFWPlayerInterceptorController(@NonNull RFWPlayer rFWPlayer) {
        super(rFWPlayer);
    }

    private boolean useSurfaceView() {
        boolean z16;
        if ((this.mPlayer.getRFWPlayerOptions().getStVideo() != null && this.mPlayer.getRFWPlayerOptions().getStVideo().isHdrVideo()) || uq3.c.q7()) {
            z16 = true;
        } else {
            z16 = false;
        }
        RFWLog.d(this.mPlayer.getRFWPlayerOptions().tag(), RFWLog.USR, "useSurfaceView:" + z16);
        return z16;
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.controller.RFWBaseInterceptorController
    public void assembleInterceptor() {
        this.mInterceptorList.add(new RFWPlayerUrlBeanInterceptor(this));
        this.mInterceptorList.add(new RFWPlayerStatusInterceptor(this));
        this.mInterceptorList.add(new RFWPlayerP2PInterceptor(this));
        this.mInterceptorList.add(new RFWPlayerQUICInterceptor(this));
        this.mInterceptorList.add(new RFWPlayerPerfReportInterceptor(this));
        this.mInterceptorList.add(new RFWPlayerCommonInterceptor(this));
        this.mInterceptorList.add(new RFWPlayerSPRInterceptor(this));
        this.mInterceptorList.add(new RFWPlayerFrameDropInterceptor(this));
        this.mInterceptorList.add(new RFWPlayerFirstFrameInterceptor(this));
        this.mInterceptorList.add(new RFWPlayerBackGroundInterceptor(this));
        this.mInterceptorList.add(new RFWPlayerClearInvalidCacheInterceptor(this));
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.controller.IRFWPlayerAction
    public ISPlayerVideoView createPlayerVideoView() {
        return SuperPlayerFactory.createPlayerVideoView(RFWApplication.getApplication(), !useSurfaceView());
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.controller.IRFWPlayerAction
    public ISuperPlayer ensureSuperPlayer(ISPlayerVideoView iSPlayerVideoView) {
        return SuperPlayerFactory.createMediaPlayer(RFWApplication.getApplication(), getPlayerSceneId(), iSPlayerVideoView);
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.controller.IRFWPlayerAction
    public void tryToOpenMediaPlayer(@NonNull ISuperPlayer iSuperPlayer, SuperPlayerVideoInfo superPlayerVideoInfo, long j3, SuperPlayerOption superPlayerOption) {
        iSuperPlayer.openMediaPlayer(RFWApplication.getApplication(), superPlayerVideoInfo, j3, superPlayerOption);
    }
}
