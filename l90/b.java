package l90;

import android.util.Size;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.immersive.views.search.optimise.video.QFSSearchPrerenderManager;
import com.tencent.biz.qqcircle.immersive.views.search.util.ad;
import com.tencent.biz.qqcircle.immersive.views.search.util.p;
import feedcloud.FeedCloudMeta$StFeed;
import k80.g;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends g {
    private final m90.a T = new m90.a(this);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // k80.g
    protected Size D1() {
        if (p.A((FeedCloudMeta$StFeed) this.f85017h)) {
            return ad.l(this.C);
        }
        return ad.g(this.C);
    }

    @Override // k80.g
    protected l80.b F1() {
        return this.T;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // k80.g
    public void H1() {
        super.H1();
        QFSSearchPrerenderManager.E(m0()).s(i1(), this.f85018i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.d
    public int b0() {
        return this.T.c(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // k80.d
    protected QCircleLayerBean h1() {
        if (r() != null && this.f85017h != 0) {
            QCircleLayerBean h16 = super.h1();
            this.T.a(h16, (FeedCloudMeta$StFeed) this.f85017h, this.f85018i, this.J);
            return h16;
        }
        return new QCircleLayerBean();
    }

    @Override // k80.d
    protected String i1() {
        return "art";
    }

    @Override // k80.g, com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.d
    public void o0() {
        super.o0();
        QFSSearchPrerenderManager.E(m0()).r(i1(), this.f85018i);
    }

    @Override // k80.g, k80.d, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: q1 */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        if (this.f85017h == feedCloudMeta$StFeed) {
            return;
        }
        super.L0(feedCloudMeta$StFeed, i3);
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        if (this.T.d() == null) {
            this.T.g((com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.viewmodel.b) A0(n90.a.class));
        }
        this.T.n(feedCloudMeta$StFeed);
        this.T.f(this.P);
    }

    @Override // k80.g, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSSearchMixUserVideoPresenter";
    }
}
