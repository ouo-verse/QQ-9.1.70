package lw2;

import com.tencent.tvideo.protocol.pb.AdReport;
import java.util.ArrayList;
import java.util.List;
import pw2.y;

/* compiled from: P */
/* loaded from: classes19.dex */
class d implements g<AdReport, com.tencent.qqlive.ona.protocol.jce.AdReport> {
    private ArrayList<String> c(List<String> list) {
        if (!y.h(list)) {
            return new ArrayList<>(list);
        }
        return null;
    }

    private String d(List<String> list) {
        if (!y.h(list)) {
            return list.get(0);
        }
        return "";
    }

    @Override // lw2.g
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.tencent.qqlive.ona.protocol.jce.AdReport a(AdReport adReport) {
        if (adReport == null) {
            return null;
        }
        com.tencent.qqlive.ona.protocol.jce.AdReport adReport2 = new com.tencent.qqlive.ona.protocol.jce.AdReport();
        adReport2.url = d(adReport.report_urls);
        adReport2.apiReportUrl = c(adReport.api_urls);
        adReport2.sdkReportUrl = c(adReport.sdk_urls);
        adReport2.reportTime = adReport.report_begin;
        String str = adReport.header_info;
        if (str == null) {
            str = "";
        }
        adReport2.headerInfo = str;
        return adReport2;
    }
}
