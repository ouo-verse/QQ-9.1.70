package b40;

import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta$FeedAlbum;
import feedcloud.FeedCloudMeta$FeedAlbumInfo;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StImage;
import feedcloud.FeedCloudMeta$StLike;
import feedcloud.FeedCloudMeta$StVideo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private FeedCloudMeta$StFeed f27855a;

    /* renamed from: b, reason: collision with root package name */
    private FeedCloudMeta$FeedAlbumInfo f27856b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f27857c;

    public a() {
    }

    private boolean a() {
        FeedCloudMeta$FeedAlbumInfo feedCloudMeta$FeedAlbumInfo = this.f27856b;
        if (feedCloudMeta$FeedAlbumInfo != null && feedCloudMeta$FeedAlbumInfo.album != null) {
            return false;
        }
        return true;
    }

    public String b() {
        PBStringField pBStringField;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f27855a;
        if (feedCloudMeta$StFeed != null && (pBStringField = feedCloudMeta$StFeed.content) != null) {
            return pBStringField.get();
        }
        return "";
    }

    public String c() {
        FeedCloudMeta$FeedAlbum feedCloudMeta$FeedAlbum;
        FeedCloudMeta$StImage feedCloudMeta$StImage;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f27855a;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StImage = feedCloudMeta$StFeed.cover) != null) {
            return feedCloudMeta$StImage.picUrl.get();
        }
        FeedCloudMeta$FeedAlbumInfo feedCloudMeta$FeedAlbumInfo = this.f27856b;
        if (feedCloudMeta$FeedAlbumInfo != null && (feedCloudMeta$FeedAlbum = feedCloudMeta$FeedAlbumInfo.album) != null) {
            return feedCloudMeta$FeedAlbum.cover_url.get();
        }
        return "";
    }

    public int d() {
        FeedCloudMeta$StVideo feedCloudMeta$StVideo;
        PBUInt32Field pBUInt32Field;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f27855a;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StVideo = feedCloudMeta$StFeed.video) != null && (pBUInt32Field = feedCloudMeta$StVideo.duration) != null) {
            return pBUInt32Field.get();
        }
        return 0;
    }

    public FeedCloudMeta$StFeed e() {
        return this.f27855a;
    }

    public FeedCloudMeta$FeedAlbumInfo f() {
        return this.f27856b;
    }

    public int g() {
        if (a()) {
            return 0;
        }
        return this.f27856b.album.feed_count.get();
    }

    public String h() {
        FeedCloudMeta$StLike feedCloudMeta$StLike;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f27855a;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StLike = feedCloudMeta$StFeed.likeInfo) != null) {
            return r.f(feedCloudMeta$StLike.count.get());
        }
        return "0";
    }

    public String i() {
        return c40.a.e(this.f27855a);
    }

    public int j() {
        PBUInt32Field pBUInt32Field;
        FeedCloudMeta$FeedAlbumInfo feedCloudMeta$FeedAlbumInfo = this.f27856b;
        if (feedCloudMeta$FeedAlbumInfo != null && (pBUInt32Field = feedCloudMeta$FeedAlbumInfo.feed_serial_number) != null) {
            return pBUInt32Field.get();
        }
        return 0;
    }

    public Long k() {
        if (a()) {
            return 0L;
        }
        return Long.valueOf(this.f27856b.album.f398441id.get());
    }

    public int l() {
        if (a()) {
            return 0;
        }
        return this.f27856b.album.status.get();
    }

    public String m() {
        if (a()) {
            return "";
        }
        return this.f27856b.album.title.get();
    }

    public boolean n() {
        return this.f27857c;
    }

    public void o(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.f27855a = feedCloudMeta$StFeed;
    }

    public void p(boolean z16) {
        this.f27857c = z16;
    }

    public void q(int i3) {
        if (!a()) {
            this.f27856b.album.status.set(i3);
        }
    }

    public a(FeedCloudMeta$FeedAlbum feedCloudMeta$FeedAlbum) {
        FeedCloudMeta$FeedAlbumInfo feedCloudMeta$FeedAlbumInfo = new FeedCloudMeta$FeedAlbumInfo();
        feedCloudMeta$FeedAlbumInfo.album.set(feedCloudMeta$FeedAlbum);
        this.f27856b = feedCloudMeta$FeedAlbumInfo;
    }

    public a(FeedCloudMeta$FeedAlbumInfo feedCloudMeta$FeedAlbumInfo) {
        this.f27856b = feedCloudMeta$FeedAlbumInfo;
    }
}
