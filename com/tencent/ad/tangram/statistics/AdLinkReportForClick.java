package com.tencent.ad.tangram.statistics;

import android.content.Context;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.protocol.link_report;
import com.tencent.ad.tangram.protocol.sdk_event_log;
import com.tencent.biz.common.util.WebViewConstants;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdLinkReportForClick {
    public static void linkReportForClickStart(Context context, Ad ad5, int i3) {
        link_report.LinkReport.ReportBiz reportBiz = new link_report.LinkReport.ReportBiz();
        reportBiz.click_action_type = i3;
        AdReporterForLinkEvent.getInstance().reportAsync(context, sdk_event_log.SdkEventDimension.EVENT_CLICK, ad5, reportBiz, null);
    }

    public static void linkReportForReportEnd(Context context, Ad ad5, boolean z16, long j3, int i3) {
        int i16;
        long j16 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        if (j3 != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
            j16 = System.currentTimeMillis() - j3;
        }
        link_report.LinkReport.ReportBiz reportBiz = new link_report.LinkReport.ReportBiz();
        if (j16 > 0) {
            reportBiz.cost_time = (int) j16;
        }
        reportBiz.click_action_type = i3;
        if (z16) {
            i16 = sdk_event_log.SdkEventDimension.EVENT_STATISTICS_CLICK_SUCCESS;
        } else {
            i16 = sdk_event_log.SdkEventDimension.EVENT_STATISTICS_CLICK_FAILED;
        }
        AdReporterForLinkEvent.getInstance().reportAsync(context, i16, ad5, reportBiz, null);
    }

    public static void linkReportForReportStart(Context context, Ad ad5, long j3, int i3) {
        long j16 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        if (j3 != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
            j16 = System.currentTimeMillis() - j3;
        }
        link_report.LinkReport.ReportBiz reportBiz = new link_report.LinkReport.ReportBiz();
        if (j16 > 0) {
            reportBiz.cost_time = (int) j16;
        }
        reportBiz.click_action_type = i3;
        AdReporterForLinkEvent.getInstance().reportAsync(context, sdk_event_log.SdkEventDimension.EVENT_STATISTICS_CLICK_START, ad5, reportBiz, null);
    }
}
