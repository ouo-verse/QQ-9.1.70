package a90;

import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends k80.b {
    private final l80.b X = new c90.a();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // k80.d
    protected QCircleLayerBean h1() {
        if (r() != null && this.f85017h != 0) {
            QCircleLayerBean h16 = super.h1();
            this.X.a(h16, (FeedCloudMeta$StFeed) this.f85017h, this.f85018i, this.J);
            return h16;
        }
        return new QCircleLayerBean();
    }

    @Override // k80.d
    protected String i1() {
        return "hotRank";
    }

    @Override // k80.b, k80.d, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: q1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        if (this.f85017h == feedCloudMeta$StFeed) {
            return;
        }
        super.L0(feedCloudMeta$StFeed, i3);
        if (feedCloudMeta$StFeed != null && this.X.d() == null) {
            this.X.g((com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.viewmodel.b) A0(com.tencent.biz.qqcircle.immersive.views.search.hotrank.b.class));
        }
    }

    @Override // k80.b, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSSearchHotRankImagePresenter";
    }
}
