package com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Cover;
import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.Video;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GameFeed implements ISSOReqModel, ISSORspModel<GameFeed> {
    public final AdData adData;
    public final Comment comment;
    public final String content;
    public final Cover cover;
    public final long createTime;
    public final String feedPb;
    public final String feedPbToken;

    /* renamed from: id, reason: collision with root package name */
    public final String f114193id;
    public final Like like;
    public final Poster poster;
    public final Share share;
    public final Video video;

    public GameFeed() {
        this(null, null, null, null, null, 0L, null, null, null, null, null, null, 4095, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("feed_pb", this.feedPb);
        AdData adData = this.adData;
        if (adData != null) {
            eVar.v("ad_data", adData.encode());
        }
        eVar.v("id", this.f114193id);
        eVar.v("content", this.content);
        eVar.u(AlbumCacheData.CREATE_TIME, this.createTime);
        Poster poster = this.poster;
        if (poster != null) {
            eVar.v(QAdVrReport.ElementID.AD_POSTER, poster.encode());
        }
        Comment comment = this.comment;
        if (comment != null) {
            eVar.v("comment", comment.encode());
        }
        Like like = this.like;
        if (like != null) {
            eVar.v("like", like.encode());
        }
        Share share = this.share;
        if (share != null) {
            eVar.v("share", share.encode());
        }
        Video video = this.video;
        if (video != null) {
            eVar.v("video", video.encode());
        }
        Cover cover = this.cover;
        if (cover != null) {
            eVar.v("cover", cover.encode());
        }
        return eVar;
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("GameFeed(feedPbToken='");
        m3.append(this.feedPbToken);
        m3.append("', id='");
        m3.append(this.f114193id);
        m3.append("', content='");
        return OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(m3, this.content, "')");
    }

    public GameFeed(String str, String str2, AdData adData, String str3, String str4, long j3, Poster poster, Comment comment, Like like, Share share, Video video, Cover cover) {
        this.feedPbToken = str;
        this.feedPb = str2;
        this.adData = adData;
        this.f114193id = str3;
        this.content = str4;
        this.createTime = j3;
        this.poster = poster;
        this.comment = comment;
        this.like = like;
        this.share = share;
        this.video = video;
        this.cover = cover;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final GameFeed decode(e eVar) {
        Share share;
        Like like;
        Video video;
        String q16 = eVar.q("feed_pb", "");
        e m3 = eVar.m("ad_data");
        AdData decode = m3 != null ? new AdData(0, null, null).decode(m3) : null;
        String q17 = eVar.q("id", "");
        String q18 = eVar.q("content", "");
        long o16 = eVar.o(AlbumCacheData.CREATE_TIME, 0L);
        e m16 = eVar.m(QAdVrReport.ElementID.AD_POSTER);
        Poster poster = m16 != null ? new Poster(m16.q("nick", "")) : null;
        e m17 = eVar.m("comment");
        Comment comment = m17 != null ? new Comment(m17.k("count", 0)) : null;
        e m18 = eVar.m("like");
        Like like2 = m18 != null ? new Like(m18.k("count", 0), m18.k("status", 0)) : null;
        e m19 = eVar.m("share");
        Share share2 = m19 != null ? new Share(m19.k("count", 0)) : null;
        e m26 = eVar.m("video");
        if (m26 != null) {
            share = share2;
            like = like2;
            video = new Video(m26.k("file_size", 0), m26.k("width", 0), m26.k("height", 0), m26.k("duration", 0));
        } else {
            share = share2;
            like = like2;
            video = null;
        }
        e m27 = eVar.m("cover");
        return new GameFeed(q16.hashCode() + Utils.INSTANCE.currentBridgeModule().getPagerId(), q16, decode, q17, q18, o16, poster, comment, like, share, video, m27 != null ? new Cover(m27.q("pic_url", ""), m27.q("layer_picUrl", "")) : null);
    }

    public /* synthetic */ GameFeed(String str, String str2, AdData adData, String str3, String str4, long j3, Poster poster, Comment comment, Like like, Share share, Video video, Cover cover, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", null, "", "", 0L, null, null, null, null, null, null);
    }
}
