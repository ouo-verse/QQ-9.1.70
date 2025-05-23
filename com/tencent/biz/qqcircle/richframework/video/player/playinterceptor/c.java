package com.tencent.biz.qqcircle.richframework.video.player.playinterceptor;

import com.tencent.biz.qqcircle.immersive.adapter.n;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor;
import com.tencent.biz.richframework.video.rfw.player.report.RFWVideoUrlBean;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWPlayerReportInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import cooperation.qqcircle.report.ASEngineQualityReport;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c extends RFWPlayerBaseInterceptor {

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f92018d;

    private boolean a() {
        RFWPlayerOptions rFWPlayerOptions;
        RFWPlayerReportInfo businessReportInfo;
        FeedCloudMeta$StFeed g16;
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_report_video_encode", true) && (rFWPlayerOptions = this.mPlayerOptions) != null && rFWPlayerOptions.getIOC() != null && (businessReportInfo = this.mPlayerOptions.getIOC().getBusinessReportInfo()) != null && (g16 = ((e30.b) businessReportInfo.getOriginBusinessData()).g()) != null && n.e(g16) == 1003) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onVideoPrepare() {
        RFWPlayer rFWPlayer;
        super.onVideoPrepare();
        if (!a() || (rFWPlayer = this.mPlayer) == null || rFWPlayer.getRealPlayer() == null || this.mPlayer.getRealPlayer().getMediaInfo() == null || this.f92018d || this.mPlayerOptions.getRealPlayBean() == null) {
            return;
        }
        int i3 = this.mPlayerOptions.getRealPlayBean().mVideoEncode;
        String videoCodec = this.mPlayer.getRealPlayer().getMediaInfo().getVideoCodec();
        ASEngineQualityReport.report(new ASEngineQualityReport.ReportData().setEventId("video_encode").setExt1(this.mPlayerOptions.getRealPlayUrl()).setExt2(String.valueOf(i3)).setExt3(videoCodec));
        this.f92018d = true;
        RFWLog.d(getTag(), RFWLog.CLR, "play type:" + RFWVideoUrlBean.getEncodeDesc(i3) + " | videoCodec:" + videoCodec);
    }
}
