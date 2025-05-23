package com.tencent.ad.tangram.views.canvas.framework;

import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.protocol.link_report;
import com.tencent.ad.tangram.statistics.AdReporterForLinkEvent;
import com.tencent.biz.common.util.WebViewConstants;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdCanvasReporterForLinkEvent {
    public static void reportForNativeLandingPage(@Nullable Context context, @Nullable Ad ad5, int i3, long j3, int i16) {
        int i17;
        if (context != null && ad5 != null) {
            link_report.LinkReport.ReportBiz reportBiz = new link_report.LinkReport.ReportBiz();
            if (j3 != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
                i17 = (int) (System.currentTimeMillis() - j3);
            } else {
                i17 = 0;
            }
            reportBiz.cost_time = i17;
            reportBiz.lp_type = 2;
            reportBiz.click_req_type = 3;
            if (i3 == 4003026 || i3 == 4003024) {
                reportBiz.f61330bp = i16;
            }
            AdReporterForLinkEvent.getInstance().reportAsync(context, i3, ad5, reportBiz, null);
        }
    }
}
