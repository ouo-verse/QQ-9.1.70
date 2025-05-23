package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser;
import com.tencent.mobileqq.vas.avatar.NtFaceConstant;
import com.tencent.mobileqq.wink.api.QQWinkTempConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchNineBoxContent implements ISSOReqModel, ISSORspModel<QSearchNineBoxContent> {
    public final QSearchPictureDetail picture;
    public final QSearchReportInfo reportInfo;
    public final int type;
    public final QSearchVideo video;

    public QSearchNineBoxContent() {
        this(0, null, null, null, 15, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.t("type", this.type);
        QSearchPictureDetail qSearchPictureDetail = this.picture;
        if (qSearchPictureDetail != null) {
            eVar.v("picture", qSearchPictureDetail.encode());
        }
        QSearchVideo qSearchVideo = this.video;
        if (qSearchVideo != null) {
            eVar.v("video", qSearchVideo.encode());
        }
        QSearchReportInfo qSearchReportInfo = this.reportInfo;
        if (qSearchReportInfo != null) {
            eVar.v(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO, qSearchReportInfo.encode());
        }
        return eVar;
    }

    public QSearchNineBoxContent(int i3, QSearchPictureDetail qSearchPictureDetail, QSearchVideo qSearchVideo, QSearchReportInfo qSearchReportInfo) {
        this.type = i3;
        this.picture = qSearchPictureDetail;
        this.video = qSearchVideo;
        this.reportInfo = qSearchReportInfo;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QSearchNineBoxContent decode(e eVar) {
        QSearchPictureDetail qSearchPictureDetail;
        int i3;
        QSearchVideo qSearchVideo;
        QSearchJump qSearchJump;
        QSearchGuildJump qSearchGuildJump;
        int k3 = eVar.k("type", 0);
        e m3 = eVar.m("picture");
        if (m3 != null) {
            e m16 = m3.m(NtFaceConstant.LARGE);
            QSearchPicture decode = m16 != null ? new QSearchPicture(null, null, 0, 0, null, 31, null).decode(m16) : null;
            e m17 = m3.m(NtFaceConstant.SMALL);
            qSearchPictureDetail = new QSearchPictureDetail(decode, m17 != null ? new QSearchPicture(null, null, 0, 0, null, 31, null).decode(m17) : null);
        } else {
            qSearchPictureDetail = null;
        }
        e m18 = eVar.m("video");
        if (m18 != null) {
            e m19 = m18.m("feed");
            StFeed decode2 = m19 != null ? new StFeed().decode(m19) : null;
            String q16 = m18.q("raw_data", "");
            e m26 = m18.m("jump_link");
            if (m26 != null) {
                String q17 = m26.q("jump_link", "");
                int k16 = m26.k("type", 0);
                int k17 = m26.k("tab_mask", 0);
                e m27 = m26.m("guild_jump");
                if (m27 != null) {
                    i3 = k3;
                    qSearchGuildJump = new QSearchGuildJump(m27.o("guild_id", 0L), m27.q("join_guild_sig", ""), m27.k("join_status", 0));
                } else {
                    i3 = k3;
                    qSearchGuildJump = null;
                }
                qSearchJump = new QSearchJump(q17, k16, k17, qSearchGuildJump, m26.q(MimeTypeParser.ATTR_EXTENSION, ""));
            } else {
                i3 = k3;
                qSearchJump = null;
            }
            qSearchVideo = new QSearchVideo(decode2, q16, qSearchJump);
        } else {
            i3 = k3;
            qSearchVideo = null;
        }
        e m28 = eVar.m(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO);
        return new QSearchNineBoxContent(i3, qSearchPictureDetail, qSearchVideo, m28 != null ? new QSearchReportInfo(m28.q("eid", ""), m28.q(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO, "")) : null);
    }

    public /* synthetic */ QSearchNineBoxContent(int i3, QSearchPictureDetail qSearchPictureDetail, QSearchVideo qSearchVideo, QSearchReportInfo qSearchReportInfo, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, null, null, null);
    }
}
