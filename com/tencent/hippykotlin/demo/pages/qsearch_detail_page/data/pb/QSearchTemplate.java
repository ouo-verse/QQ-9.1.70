package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser;
import com.tencent.mobileqq.wink.api.QQWinkTempConstants;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchTemplate implements ISSOReqModel, ISSORspModel<QSearchTemplate> {
    public final String data;
    public final QSearchJump jumpLink;
    public final QSearchLayOut layOut;
    public final QSearchReportInfo reportInfo;
    public final int templateId;

    public QSearchTemplate(int i3, String str, QSearchLayOut qSearchLayOut, QSearchReportInfo qSearchReportInfo, QSearchJump qSearchJump) {
        this.templateId = i3;
        this.data = str;
        this.layOut = qSearchLayOut;
        this.reportInfo = qSearchReportInfo;
        this.jumpLink = qSearchJump;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.t("template_id", this.templateId);
        eVar.v("data", this.data);
        QSearchLayOut qSearchLayOut = this.layOut;
        if (qSearchLayOut != null) {
            eVar.v("lay_out", qSearchLayOut.encode());
        }
        QSearchReportInfo qSearchReportInfo = this.reportInfo;
        if (qSearchReportInfo != null) {
            eVar.v(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO, qSearchReportInfo.encode());
        }
        QSearchJump qSearchJump = this.jumpLink;
        if (qSearchJump != null) {
            eVar.v("jump_link", qSearchJump.encode());
        }
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QSearchTemplate decode(e eVar) {
        QSearchJump qSearchJump;
        int k3 = eVar.k("template_id", 0);
        String q16 = eVar.q("data", "");
        e m3 = eVar.m("lay_out");
        QSearchLayOut qSearchLayOut = m3 != null ? new QSearchLayOut(m3.q("highlight", ""), (float) m3.i(LayoutAttrDefine.MARGIN_TOP, 0.0d), (float) m3.i("top_corner", 0.0d), (float) m3.i("bottom_corner", 0.0d), m3.g("show_divider", false), m3.g("use_one_card", false)) : null;
        e m16 = eVar.m(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO);
        QSearchReportInfo qSearchReportInfo = m16 != null ? new QSearchReportInfo(m16.q("eid", ""), m16.q(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO, "")) : null;
        e m17 = eVar.m("jump_link");
        if (m17 != null) {
            String q17 = m17.q("jump_link", "");
            int k16 = m17.k("type", 0);
            int k17 = m17.k("tab_mask", 0);
            e m18 = m17.m("guild_jump");
            qSearchJump = new QSearchJump(q17, k16, k17, m18 != null ? new QSearchGuildJump(m18.o("guild_id", 0L), m18.q("join_guild_sig", ""), m18.k("join_status", 0)) : null, m17.q(MimeTypeParser.ATTR_EXTENSION, ""));
        } else {
            qSearchJump = null;
        }
        return new QSearchTemplate(k3, q16, qSearchLayOut, qSearchReportInfo, qSearchJump);
    }
}
