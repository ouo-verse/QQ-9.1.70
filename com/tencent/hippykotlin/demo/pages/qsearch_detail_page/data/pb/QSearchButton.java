package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser;
import com.tencent.mobileqq.wink.api.QQWinkTempConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchButton implements ISSOReqModel, ISSORspModel<QSearchButton> {
    public final int buttonType;
    public final QSearchJump jumpLink;
    public final QSearchReportInfo reportInfo;
    public final String title;

    public QSearchButton() {
        this(null, null, null, 0, 15, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("title", this.title);
        QSearchJump qSearchJump = this.jumpLink;
        if (qSearchJump != null) {
            eVar.v("jump_link", qSearchJump.encode());
        }
        QSearchReportInfo qSearchReportInfo = this.reportInfo;
        if (qSearchReportInfo != null) {
            eVar.v(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO, qSearchReportInfo.encode());
        }
        eVar.t("button_type", this.buttonType);
        return eVar;
    }

    public QSearchButton(String str, QSearchJump qSearchJump, QSearchReportInfo qSearchReportInfo, int i3) {
        this.title = str;
        this.jumpLink = qSearchJump;
        this.reportInfo = qSearchReportInfo;
        this.buttonType = i3;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QSearchButton decode(e eVar) {
        QSearchJump qSearchJump;
        String q16 = eVar.q("title", "");
        e m3 = eVar.m("jump_link");
        if (m3 != null) {
            String q17 = m3.q("jump_link", "");
            int k3 = m3.k("type", 0);
            int k16 = m3.k("tab_mask", 0);
            e m16 = m3.m("guild_jump");
            qSearchJump = new QSearchJump(q17, k3, k16, m16 != null ? new QSearchGuildJump(m16.o("guild_id", 0L), m16.q("join_guild_sig", ""), m16.k("join_status", 0)) : null, m3.q(MimeTypeParser.ATTR_EXTENSION, ""));
        } else {
            qSearchJump = null;
        }
        e m17 = eVar.m(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO);
        return new QSearchButton(q16, qSearchJump, m17 != null ? new QSearchReportInfo(m17.q("eid", ""), m17.q(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO, "")) : null, eVar.k("button_type", 0));
    }

    public /* synthetic */ QSearchButton(String str, QSearchJump qSearchJump, QSearchReportInfo qSearchReportInfo, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this("", null, null, 0);
    }
}
