package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser;
import com.tencent.mobileqq.wink.api.QQWinkTempConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchListDetail implements ISSOReqModel, ISSORspModel<QSearchListDetail> {
    public final QSearchButton button;
    public final QSearchIcon icon;
    public final QSearchJump jumpLink;
    public final QSearchReportInfo reportInfo;
    public final QSearchText subTitle;
    public final QSearchText title;

    public QSearchListDetail() {
        this(null, null, null, null, null, null, 63, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        QSearchIcon qSearchIcon = this.icon;
        if (qSearchIcon != null) {
            eVar.v("icon", qSearchIcon.encode());
        }
        QSearchText qSearchText = this.title;
        if (qSearchText != null) {
            eVar.v("title", qSearchText.encode());
        }
        QSearchText qSearchText2 = this.subTitle;
        if (qSearchText2 != null) {
            eVar.v("sub_title", qSearchText2.encode());
        }
        QSearchButton qSearchButton = this.button;
        if (qSearchButton != null) {
            eVar.v("button", qSearchButton.encode());
        }
        QSearchJump qSearchJump = this.jumpLink;
        if (qSearchJump != null) {
            eVar.v("jump_link", qSearchJump.encode());
        }
        QSearchReportInfo qSearchReportInfo = this.reportInfo;
        if (qSearchReportInfo != null) {
            eVar.v(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO, qSearchReportInfo.encode());
        }
        return eVar;
    }

    public QSearchListDetail(QSearchIcon qSearchIcon, QSearchText qSearchText, QSearchText qSearchText2, QSearchButton qSearchButton, QSearchJump qSearchJump, QSearchReportInfo qSearchReportInfo) {
        this.icon = qSearchIcon;
        this.title = qSearchText;
        this.subTitle = qSearchText2;
        this.button = qSearchButton;
        this.jumpLink = qSearchJump;
        this.reportInfo = qSearchReportInfo;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QSearchListDetail decode(e eVar) {
        QSearchJump qSearchJump;
        e m3 = eVar.m("icon");
        QSearchIcon decode = m3 != null ? new QSearchIcon(null, null, null, null, 0L, null, null, null, 0, 0, 0, null, 0, InitSkin.DRAWABLE_COUNT, null).decode(m3) : null;
        e m16 = eVar.m("title");
        QSearchText m17 = m16 != null ? QSearchBanner$$ExternalSyntheticOutline0.m(null, null, 15, m16) : null;
        e m18 = eVar.m("sub_title");
        QSearchText m19 = m18 != null ? QSearchBanner$$ExternalSyntheticOutline0.m(null, null, 15, m18) : null;
        e m26 = eVar.m("button");
        QSearchButton decode2 = m26 != null ? new QSearchButton(null, null, null, 0, 15, null).decode(m26) : null;
        e m27 = eVar.m("jump_link");
        if (m27 != null) {
            String q16 = m27.q("jump_link", "");
            int k3 = m27.k("type", 0);
            int k16 = m27.k("tab_mask", 0);
            e m28 = m27.m("guild_jump");
            qSearchJump = new QSearchJump(q16, k3, k16, m28 != null ? new QSearchGuildJump(m28.o("guild_id", 0L), m28.q("join_guild_sig", ""), m28.k("join_status", 0)) : null, m27.q(MimeTypeParser.ATTR_EXTENSION, ""));
        } else {
            qSearchJump = null;
        }
        e m29 = eVar.m(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO);
        return new QSearchListDetail(decode, m17, m19, decode2, qSearchJump, m29 != null ? new QSearchReportInfo(m29.q("eid", ""), m29.q(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO, "")) : null);
    }

    public /* synthetic */ QSearchListDetail(QSearchIcon qSearchIcon, QSearchText qSearchText, QSearchText qSearchText2, QSearchButton qSearchButton, QSearchJump qSearchJump, QSearchReportInfo qSearchReportInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null, null, null, null, null);
    }
}
