package com.tencent.biz.qqcircle.richframework.video.player.playinterceptor;

import com.tencent.biz.qqcircle.immersive.adapter.n;
import com.tencent.biz.qqcircle.immersive.feed.ad.u;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.RFWPCDNRecorderManager;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerP2PParams;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerDownOption;
import com.tencent.superplayer.api.SuperPlayerOption;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a extends RFWPlayerBaseInterceptor {
    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void beforeOpenMedia(SuperPlayerOption superPlayerOption, ISuperPlayer iSuperPlayer) {
        RFWPlayerP2PParams c16;
        boolean z16;
        RFWPlayer rFWPlayer = this.mPlayer;
        if (rFWPlayer == null || rFWPlayer.getRFWPlayerOptions() == null || superPlayerOption == null || iSuperPlayer == null || this.mPlayer.getCurrentSuperVideoInfo() == null || this.mPlayerOptions.getIOC().getBusinessReportInfo() == null) {
            return;
        }
        FeedCloudMeta$StFeed g16 = ((e30.b) this.mPlayerOptions.getIOC().getBusinessReportInfo().getOriginBusinessData()).g();
        if ((g16 != null && n.e(g16) != 4003) || (c16 = com.tencent.biz.qqcircle.immersive.utils.ad.a.f90082a.c(u.e(new e30.b(g16).p()))) == null) {
            return;
        }
        SuperPlayerDownOption superPlayerDownOption = superPlayerOption.superPlayerDownOption;
        superPlayerDownOption.pcdnChargeId = "pcdn_ad_qqxsj";
        superPlayerDownOption.enableP2P = c16.isEnableP2P();
        SuperPlayerDownOption superPlayerDownOption2 = superPlayerOption.superPlayerDownOption;
        if (c16.isEnablePCDN(this.mPlayerOptions.getHost()) && RFWPCDNRecorderManager.g().enablePCDN(this.mPlayer.getCurrentSuperVideoInfo().getFileId())) {
            z16 = true;
        } else {
            z16 = false;
        }
        superPlayerDownOption2.enablePcdn = z16;
        iSuperPlayer.setBusinessDownloadStrategy(c16.getEmergencyTime(), c16.getSafePlayTime(), c16.getEmergencyTimeForPrePlay(), c16.getSafePlayTimeForPrePlay());
        RFWLog.d(getTag(), RFWLog.USR, "QFSPlayerP2PParams()|initPlayDownLoadParams:" + c16);
    }
}
