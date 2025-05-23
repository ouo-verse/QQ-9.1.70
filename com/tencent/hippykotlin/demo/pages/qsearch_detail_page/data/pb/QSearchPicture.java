package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser;
import com.tencent.mobileqq.wink.api.QQWinkTempConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes32.dex */
public final class QSearchPicture implements ISSOReqModel, ISSORspModel<QSearchPicture> {
    public final int height;
    public QSearchJump jumpLink;
    public String picLink;
    public final QSearchReportInfo reportInfo;
    public final int width;

    public QSearchPicture() {
        this(null, null, 0, 0, null, 31, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("pic_link", this.picLink);
        QSearchJump qSearchJump = this.jumpLink;
        if (qSearchJump != null) {
            eVar.v("jump_link", qSearchJump.encode());
        }
        eVar.t("height", this.height);
        eVar.t("width", this.width);
        QSearchReportInfo qSearchReportInfo = this.reportInfo;
        if (qSearchReportInfo != null) {
            eVar.v(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO, qSearchReportInfo.encode());
        }
        return eVar;
    }

    public QSearchPicture(String str, QSearchJump qSearchJump, int i3, int i16, QSearchReportInfo qSearchReportInfo) {
        this.picLink = str;
        this.jumpLink = qSearchJump;
        this.height = i3;
        this.width = i16;
        this.reportInfo = qSearchReportInfo;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QSearchPicture decode(e eVar) {
        QSearchJump qSearchJump;
        String q16 = eVar.q("pic_link", "");
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
        int k17 = eVar.k("height", 0);
        int k18 = eVar.k("width", 0);
        e m17 = eVar.m(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO);
        return new QSearchPicture(q16, qSearchJump, k17, k18, m17 != null ? new QSearchReportInfo(m17.q("eid", ""), m17.q(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO, "")) : null);
    }

    public /* synthetic */ QSearchPicture(String str, QSearchJump qSearchJump, int i3, int i16, QSearchReportInfo qSearchReportInfo, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this("", null, 0, 0, null);
    }
}
