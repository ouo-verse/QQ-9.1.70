package com.tencent.biz.richframework.video.rfw.player.playinterceptor;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.RFWPCDNRecorderManager;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerP2PParams;
import com.tencent.biz.richframework.video.rfw.player.exp.RFWVideoFluencyExp9095;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.controller.RFWBaseInterceptorController;
import com.tencent.biz.richframework.video.rfw.player.strategy.RFWWeakNetworkPCDNStrategy;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerDownOption;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;

/* loaded from: classes5.dex */
public class RFWPlayerP2PInterceptor extends RFWPlayerBaseInterceptor {
    public RFWPlayerP2PInterceptor(RFWBaseInterceptorController rFWBaseInterceptorController) {
        super(rFWBaseInterceptorController);
    }

    private void setLimitSpeed(SuperPlayerOption superPlayerOption, RFWWeakNetworkPCDNStrategy.WeakNetworkPCDNStrategyResult weakNetworkPCDNStrategyResult) {
        if (!RFWVideoFluencyExp9095.hitExpB() || !superPlayerOption.isPrePlay || com.tencent.mobileqq.qcircle.api.utils.c.h()) {
            return;
        }
        superPlayerOption.superPlayerDownOption.enablePreloadLimitSpeed = weakNetworkPCDNStrategyResult.hasHitWeakNetStrategy();
        RFWLog.d(getTag(), RFWLog.USR, "[setLimitSpeed]:" + superPlayerOption.superPlayerDownOption.enablePreloadLimitSpeed);
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void beforeOpenMedia(SuperPlayerOption superPlayerOption, ISuperPlayer iSuperPlayer) {
        boolean z16;
        RFWPlayer rFWPlayer = this.mPlayer;
        if (rFWPlayer != null && rFWPlayer.getRFWPlayerOptions() != null && superPlayerOption != null && iSuperPlayer != null && this.mPlayer.getCurrentSuperVideoInfo() != null) {
            if (this.mPlayerOptions.isPreloadPlayer() && !this.mPlayerOptions.forceActive()) {
                RFWLog.d(getTag(), RFWLog.USR, "beforeOpenMedia is preloadPlayer:true");
                superPlayerOption.isPrePlay = true;
            }
            RFWPlayerP2PParams rFWPlayerP2PParams = new RFWPlayerP2PParams();
            superPlayerOption.superPlayerDownOption.enableP2P = rFWPlayerP2PParams.isEnableP2P();
            SuperPlayerDownOption superPlayerDownOption = superPlayerOption.superPlayerDownOption;
            if (rFWPlayerP2PParams.isEnablePCDN(this.mPlayerOptions.getHost()) && RFWPCDNRecorderManager.g().enablePCDN(this.mPlayer.getCurrentSuperVideoInfo().getFileId())) {
                z16 = true;
            } else {
                z16 = false;
            }
            superPlayerDownOption.enablePcdn = z16;
            RFWWeakNetworkPCDNStrategy.WeakNetworkPCDNStrategyResult processWeakNetworkPCDNParam = new RFWWeakNetworkPCDNStrategy().processWeakNetworkPCDNParam(rFWPlayerP2PParams, this.mPlayerOptions, superPlayerOption.superPlayerDownOption, false);
            int emergencyTime = processWeakNetworkPCDNParam.getEmergencyTime();
            int safePlayTime = processWeakNetworkPCDNParam.getSafePlayTime();
            iSuperPlayer.setBusinessDownloadStrategy(emergencyTime, safePlayTime, rFWPlayerP2PParams.getEmergencyTimeForPrePlay(), rFWPlayerP2PParams.getSafePlayTimeForPrePlay());
            setLimitSpeed(superPlayerOption, processWeakNetworkPCDNParam);
            RFWLog.d(getTag(), RFWLog.USR, "[beforeOpenMedia] emergencyTime: " + emergencyTime + " | safePlayTime: " + safePlayTime + " | wnsParams:" + rFWPlayerP2PParams);
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onInfo(int i3, long j3, long j16, Object obj) {
        SuperPlayerVideoInfo currentSuperVideoInfo;
        if (i3 != 251 || obj == null || (currentSuperVideoInfo = this.mPlayer.getCurrentSuperVideoInfo()) == null) {
            return;
        }
        RFWPCDNRecorderManager.g().decodeAdnRecPCDNFailedInfo(currentSuperVideoInfo.getFileId(), obj.toString(), "FROM_TYPE_PLAYER");
    }
}
