package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser;
import com.tencent.mobileqq.wink.api.QQWinkTempConstants;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchText implements ISSOReqModel, ISSORspModel<QSearchText> {
    public final String color;
    public final QSearchJump jumpLink;
    public final QSearchReportInfo reportInfo;
    public final String text;

    public QSearchText() {
        this(null, 0 == true ? 1 : 0, 15);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("text", this.text);
        QSearchJump qSearchJump = this.jumpLink;
        if (qSearchJump != null) {
            eVar.v("jump_link", qSearchJump.encode());
        }
        QSearchReportInfo qSearchReportInfo = this.reportInfo;
        if (qSearchReportInfo != null) {
            eVar.v(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO, qSearchReportInfo.encode());
        }
        eVar.v("color", this.color);
        return eVar;
    }

    public QSearchText(String str, QSearchJump qSearchJump, QSearchReportInfo qSearchReportInfo, String str2) {
        this.text = str;
        this.jumpLink = qSearchJump;
        this.reportInfo = qSearchReportInfo;
        this.color = str2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QSearchText decode(e eVar) {
        QSearchJump qSearchJump;
        String q16 = eVar.q("text", "");
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
        return new QSearchText(q16, qSearchJump, m17 != null ? new QSearchReportInfo(m17.q("eid", ""), m17.q(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO, "")) : null, eVar.q("color", ""));
    }

    public /* synthetic */ QSearchText(String str, QSearchJump qSearchJump, int i3) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? null : qSearchJump, null, (i3 & 8) == 0 ? null : "");
    }
}
