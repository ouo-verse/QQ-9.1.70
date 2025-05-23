package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;

/* loaded from: classes31.dex */
public final class QPlusCirStFeed implements ISSOReqModel, ISSORspModel<QPlusCirStFeed> {
    public final String content;
    public final QPlusCirStImage cover;
    public final long createTime;
    public final String feedId;
    public final QPlusCirStUser poster;
    public final QPlusCirStRecommendInfo recommendInfo;
    public final String subtitle;
    public final String title;
    public final QPlusCirStVideo video;
    public final QPlusCirStVisitor visitorInfo;

    public QPlusCirStFeed() {
        this(null, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 1023);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("feedId", this.feedId);
        eVar.v("title", this.title);
        eVar.v("subtitle", this.subtitle);
        QPlusCirStUser qPlusCirStUser = this.poster;
        if (qPlusCirStUser != null) {
            eVar.v(QAdVrReport.ElementID.AD_POSTER, qPlusCirStUser.encode());
        }
        QPlusCirStImage qPlusCirStImage = this.cover;
        if (qPlusCirStImage != null) {
            eVar.v("cover", qPlusCirStImage.encode());
        }
        QPlusCirStVideo qPlusCirStVideo = this.video;
        if (qPlusCirStVideo != null) {
            eVar.v("video", qPlusCirStVideo.encode());
        }
        eVar.v("content", this.content);
        eVar.u(WadlProxyConsts.CREATE_TIME, this.createTime);
        QPlusCirStVisitor qPlusCirStVisitor = this.visitorInfo;
        if (qPlusCirStVisitor != null) {
            eVar.v("visitorInfo", qPlusCirStVisitor.encode());
        }
        QPlusCirStRecommendInfo qPlusCirStRecommendInfo = this.recommendInfo;
        if (qPlusCirStRecommendInfo != null) {
            eVar.v("recommend_info", qPlusCirStRecommendInfo.encode());
        }
        return eVar;
    }

    public QPlusCirStFeed(String str, String str2, String str3, QPlusCirStUser qPlusCirStUser, QPlusCirStImage qPlusCirStImage, QPlusCirStVideo qPlusCirStVideo, String str4, long j3, QPlusCirStVisitor qPlusCirStVisitor, QPlusCirStRecommendInfo qPlusCirStRecommendInfo) {
        this.feedId = str;
        this.title = str2;
        this.subtitle = str3;
        this.poster = qPlusCirStUser;
        this.cover = qPlusCirStImage;
        this.video = qPlusCirStVideo;
        this.content = str4;
        this.createTime = j3;
        this.visitorInfo = qPlusCirStVisitor;
        this.recommendInfo = qPlusCirStRecommendInfo;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusCirStFeed decode(e eVar) {
        QPlusCirStUser qPlusCirStUser;
        String q16 = eVar.q("feedId", "");
        String q17 = eVar.q("title", "");
        String q18 = eVar.q("subtitle", "");
        e m3 = eVar.m(QAdVrReport.ElementID.AD_POSTER);
        if (m3 != null) {
            String q19 = m3.q("uin", "");
            String q26 = m3.q("nick", "");
            e m16 = m3.m("icon");
            qPlusCirStUser = new QPlusCirStUser(q19, q26, m16 != null ? new QPlusCirStIconInfo(m16.q("iconUrl", "")) : null);
        } else {
            qPlusCirStUser = null;
        }
        e m17 = eVar.m("cover");
        QPlusCirStImage qPlusCirStImage = m17 != null ? new QPlusCirStImage(m17.k("width", 0), m17.k("height", 0), m17.q("picUrl", "")) : null;
        e m18 = eVar.m("video");
        QPlusCirStVideo qPlusCirStVideo = m18 != null ? new QPlusCirStVideo(m18.q("fileId", ""), m18.k("fileSize", 0), m18.k("duration", 0), m18.k("width", 0), m18.k("height", 0), m18.q("playUrl", "")) : null;
        String q27 = eVar.q("content", "");
        long o16 = eVar.o(WadlProxyConsts.CREATE_TIME, 0L);
        e m19 = eVar.m("visitorInfo");
        QPlusCirStVisitor qPlusCirStVisitor = m19 != null ? new QPlusCirStVisitor(m19.k("viewCount", 0)) : null;
        e m26 = eVar.m("recommend_info");
        return new QPlusCirStFeed(q16, q17, q18, qPlusCirStUser, qPlusCirStImage, qPlusCirStVideo, q27, o16, qPlusCirStVisitor, m26 != null ? new QPlusCirStRecommendInfo(m26.k("recommend_status", 0)) : null);
    }

    public /* synthetic */ QPlusCirStFeed(String str, QPlusCirStImage qPlusCirStImage, String str2, int i3) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : null, (i3 & 4) != 0 ? "" : null, null, (i3 & 16) != 0 ? null : qPlusCirStImage, null, (i3 & 64) != 0 ? "" : str2, 0L, null, null);
    }
}
