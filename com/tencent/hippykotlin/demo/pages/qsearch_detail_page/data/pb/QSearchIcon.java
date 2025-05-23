package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser;
import com.tencent.mobileqq.vas.avatar.NtFaceConstant;
import com.tencent.mobileqq.wink.api.QQWinkTempConstants;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchIcon implements ISSOReqModel, ISSORspModel<QSearchIcon> {
    public final QSearchPictureDetail auth;
    public final int height;
    public final String iconLink;
    public final int iconType;
    public final QSearchJump jumpLink;
    public final QSearchReportInfo reportInfo;
    public final QSearchText subTitle;
    public final long timestamp;
    public final QSearchText title;
    public final String uin;
    public final int uinType;
    public final QSearchIcon visibleRange;
    public final int width;

    public QSearchIcon() {
        this(null, null, null, null, 0L, null, null, null, 0, 0, 0, null, 0, InitSkin.DRAWABLE_COUNT, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("icon_link", this.iconLink);
        QSearchJump qSearchJump = this.jumpLink;
        if (qSearchJump != null) {
            eVar.v("jump_link", qSearchJump.encode());
        }
        QSearchText qSearchText = this.title;
        if (qSearchText != null) {
            eVar.v("title", qSearchText.encode());
        }
        QSearchText qSearchText2 = this.subTitle;
        if (qSearchText2 != null) {
            eVar.v("sub_title", qSearchText2.encode());
        }
        eVar.u("timestamp", this.timestamp);
        QSearchPictureDetail qSearchPictureDetail = this.auth;
        if (qSearchPictureDetail != null) {
            eVar.v(WinkDaTongReportConstant.ElementParamValue.XSJ_OPERATION_TYPE_AUTH, qSearchPictureDetail.encode());
        }
        QSearchIcon qSearchIcon = this.visibleRange;
        if (qSearchIcon != null) {
            eVar.v("visible_range", qSearchIcon.encode());
        }
        QSearchReportInfo qSearchReportInfo = this.reportInfo;
        if (qSearchReportInfo != null) {
            eVar.v(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO, qSearchReportInfo.encode());
        }
        eVar.t("icon_type", this.iconType);
        eVar.t("width", this.width);
        eVar.t("height", this.height);
        eVar.v("uin", this.uin);
        eVar.t(IPublicAccountBrowser.KEY_UIN_TYPE, this.uinType);
        return eVar;
    }

    public QSearchIcon(String str, QSearchJump qSearchJump, QSearchText qSearchText, QSearchText qSearchText2, long j3, QSearchPictureDetail qSearchPictureDetail, QSearchIcon qSearchIcon, QSearchReportInfo qSearchReportInfo, int i3, int i16, int i17, String str2, int i18) {
        this.iconLink = str;
        this.jumpLink = qSearchJump;
        this.title = qSearchText;
        this.subTitle = qSearchText2;
        this.timestamp = j3;
        this.auth = qSearchPictureDetail;
        this.visibleRange = qSearchIcon;
        this.reportInfo = qSearchReportInfo;
        this.iconType = i3;
        this.width = i16;
        this.height = i17;
        this.uin = str2;
        this.uinType = i18;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QSearchIcon decode(e eVar) {
        QSearchJump qSearchJump;
        QSearchPictureDetail qSearchPictureDetail;
        String q16 = eVar.q("icon_link", "");
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
        e m17 = eVar.m("title");
        QSearchText m18 = m17 != null ? QSearchBanner$$ExternalSyntheticOutline0.m(null, null, 15, m17) : null;
        e m19 = eVar.m("sub_title");
        QSearchText m26 = m19 != null ? QSearchBanner$$ExternalSyntheticOutline0.m(null, null, 15, m19) : null;
        long o16 = eVar.o("timestamp", 0L);
        e m27 = eVar.m(WinkDaTongReportConstant.ElementParamValue.XSJ_OPERATION_TYPE_AUTH);
        if (m27 != null) {
            e m28 = m27.m(NtFaceConstant.LARGE);
            QSearchPicture decode = m28 != null ? new QSearchPicture(null, null, 0, 0, null, 31, null).decode(m28) : null;
            e m29 = m27.m(NtFaceConstant.SMALL);
            qSearchPictureDetail = new QSearchPictureDetail(decode, m29 != null ? new QSearchPicture(null, null, 0, 0, null, 31, null).decode(m29) : null);
        } else {
            qSearchPictureDetail = null;
        }
        e m36 = eVar.m("visible_range");
        QSearchIcon decode2 = m36 != null ? new QSearchIcon(null, null, null, null, 0L, null, null, null, 0, 0, 0, null, 0, InitSkin.DRAWABLE_COUNT, null).decode(m36) : null;
        e m37 = eVar.m(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO);
        return new QSearchIcon(q16, qSearchJump, m18, m26, o16, qSearchPictureDetail, decode2, m37 != null ? new QSearchReportInfo(m37.q("eid", ""), m37.q(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO, "")) : null, eVar.k("icon_type", 0), eVar.k("width", 0), eVar.k("height", 0), eVar.q("uin", ""), eVar.k(IPublicAccountBrowser.KEY_UIN_TYPE, 0));
    }

    public /* synthetic */ QSearchIcon(String str, QSearchJump qSearchJump, QSearchText qSearchText, QSearchText qSearchText2, long j3, QSearchPictureDetail qSearchPictureDetail, QSearchIcon qSearchIcon, QSearchReportInfo qSearchReportInfo, int i3, int i16, int i17, String str2, int i18, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this("", null, null, null, 0L, null, null, null, 0, 0, 0, "", 0);
    }
}
