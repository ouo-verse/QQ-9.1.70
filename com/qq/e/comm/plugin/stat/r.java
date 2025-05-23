package com.qq.e.comm.plugin.stat;

import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.pi.ILandingPageReportListener;
import com.qq.e.comm.pi.LandingPageReportModel;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: P */
/* loaded from: classes3.dex */
public class r {
    public static void a(final int i3, final String str, final String str2, final String str3, final int i16) {
        if (com.qq.e.comm.plugin.j.c.a("landingPageReportNeedCallBack", 0, 1) && SDKStatus.getSDKVersionCode() >= 410) {
            GdtSDKThreadManager.getInstance().runOnThread(3, new Runnable() { // from class: com.qq.e.comm.plugin.stat.r.1
                @Override // java.lang.Runnable
                public void run() {
                    ILandingPageReportListener landingPageReportListener = GlobalSetting.getLandingPageReportListener();
                    if (landingPageReportListener != null) {
                        LandingPageReportModel landingPageReportModel = new LandingPageReportModel();
                        landingPageReportModel.setEventId(i3);
                        landingPageReportModel.setAdId(str);
                        landingPageReportModel.setTraceId(str2);
                        landingPageReportModel.setUrl(str3);
                        landingPageReportModel.setDestType(i16);
                        landingPageReportModel.setTimeStamp(System.currentTimeMillis());
                        landingPageReportListener.onReport(landingPageReportModel);
                        GDTLogger.d("ILandingPageReportListener onReport, EventId = " + landingPageReportModel.getEventId() + ", AdId = " + landingPageReportModel.getAdId() + ", TraceId = " + landingPageReportModel.getTraceId() + ", TimeStamp = " + landingPageReportModel.getTimeStamp() + ", DestType = " + landingPageReportModel.getDestType() + ", Url = " + landingPageReportModel.getUrl());
                    }
                }
            });
        }
    }
}
