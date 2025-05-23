package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.wink.api.QQWinkTempConstants;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchGameButton implements ISSOReqModel, ISSORspModel<QSearchGameButton> {
    public final String appId;
    public final String appSize;
    public final String businessChannel;
    public final String channelId;
    public final String icon;
    public final String name;
    public final String pkgName;
    public final QSearchReportInfo reportInfo;
    public final String url;

    public QSearchGameButton(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, QSearchReportInfo qSearchReportInfo) {
        this.appId = str;
        this.channelId = str2;
        this.pkgName = str3;
        this.name = str4;
        this.icon = str5;
        this.url = str6;
        this.appSize = str7;
        this.businessChannel = str8;
        this.reportInfo = qSearchReportInfo;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("app_id", this.appId);
        eVar.v("channel_id", this.channelId);
        eVar.v("pkg_name", this.pkgName);
        eVar.v("name", this.name);
        eVar.v("icon", this.icon);
        eVar.v("url", this.url);
        eVar.v("app_size", this.appSize);
        eVar.v("business_channel", this.businessChannel);
        QSearchReportInfo qSearchReportInfo = this.reportInfo;
        if (qSearchReportInfo != null) {
            eVar.v(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO, qSearchReportInfo.encode());
        }
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QSearchGameButton decode(e eVar) {
        String q16 = eVar.q("app_id", "");
        String q17 = eVar.q("channel_id", "");
        String q18 = eVar.q("pkg_name", "");
        String q19 = eVar.q("name", "");
        String q26 = eVar.q("icon", "");
        String q27 = eVar.q("url", "");
        String q28 = eVar.q("app_size", "");
        String q29 = eVar.q("business_channel", "");
        e m3 = eVar.m(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO);
        return new QSearchGameButton(q16, q17, q18, q19, q26, q27, q28, q29, m3 != null ? new QSearchReportInfo(m3.q("eid", ""), m3.q(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO, "")) : null);
    }
}
