package com.tencent.gdtad.statistics;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.ad.tangram.protocol.link_report;
import com.tencent.ad.tangram.statistics.AdReporterForLinkEvent;
import com.tencent.ad.tangram.web.AdBrowser;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class b {
    public static void a(@NonNull AdBrowser.Params params) {
        int i3;
        if (params != null && params.isValid()) {
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).initGdtContext(params.activity.get(), new InitGdtContextParams());
            link_report.LinkReport.ReportBiz reportBiz = new link_report.LinkReport.ReportBiz();
            reportBiz.wv_progress = 2;
            if (params.actionCode == 502 && !TextUtils.isEmpty(params.f61348ad.getUrlForRewardLandingPage())) {
                i3 = 13;
            } else {
                i3 = 1;
            }
            reportBiz.lp_type = i3;
            if (((IGdtAPI) QRoute.api(IGdtAPI.class)).isClickCgiUrlForTool(params.url)) {
                reportBiz.click_req_type = 1;
            } else {
                reportBiz.click_req_type = 3;
            }
            reportBiz.act_code = params.actionCode;
            AdReporterForLinkEvent.getInstance().reportAsync(params.activity.get(), 4003001, params.f61348ad, reportBiz, null);
            return;
        }
        GdtLog.e("GdtLinkReportForBrowser", "reportLandingPageStart error");
    }
}
