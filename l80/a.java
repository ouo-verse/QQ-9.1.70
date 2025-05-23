package l80;

import android.widget.ImageView;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import k80.d;
import p70.i;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class a extends b {

    /* renamed from: c, reason: collision with root package name */
    protected final QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> f413951c;

    /* renamed from: d, reason: collision with root package name */
    private t80.a f413952d;

    /* renamed from: e, reason: collision with root package name */
    private t80.b f413953e;

    /* renamed from: f, reason: collision with root package name */
    private FeedCloudMeta$StFeed f413954f;

    public a(QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> qFSBaseFeedChildPresenter) {
        this.f413951c = qFSBaseFeedChildPresenter;
    }

    private void k() {
        boolean z16;
        QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> qFSBaseFeedChildPresenter = this.f413951c;
        if (qFSBaseFeedChildPresenter instanceof d) {
            z16 = ((d) qFSBaseFeedChildPresenter).j1().t2();
        } else {
            z16 = false;
        }
        this.f413953e = null;
        this.f413952d = null;
        if (z16) {
            m();
        } else {
            l();
        }
    }

    private void l() {
        this.f413952d = i();
        if (this.f413951c instanceof d) {
            UIStateData<List<e30.b>> value = this.f413955a.j().getValue();
            if (value != null) {
                this.f413952d.O1(((d) this.f413951c).j1(), value.getData());
                return;
            } else {
                QLog.w("QFSSearchCardMixSourceViewModelHelper", 1, "#prepareFeedViewModel: data is null");
                return;
            }
        }
        QLog.w("QFSSearchCardMixSourceViewModelHelper", 1, "#prepareFeedViewModel: presenter is not QFSSearchBaseCardMediaPresenter-" + this.f413951c);
    }

    private void m() {
        t80.b j3 = j();
        this.f413953e = j3;
        j3.I2(this.f413954f);
        i iVar = this.f413956b;
        if (iVar != null) {
            this.f413953e.H2(iVar.e2());
        }
        UIStateData<List<e30.b>> value = this.f413955a.j().getValue();
        if (value != null) {
            this.f413953e.F2(value.getData());
            return;
        }
        ArrayList arrayList = new ArrayList();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f413954f;
        if (feedCloudMeta$StFeed != null) {
            arrayList.add(feedCloudMeta$StFeed);
        }
        this.f413953e.G2(arrayList);
        QLog.w("QFSSearchCardMixSourceViewModelHelper", 1, "#prepareRecommendViewModel: viewModel has no data");
    }

    @Override // l80.b
    public void a(QCircleLayerBean qCircleLayerBean, FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, ImageView imageView) {
        k();
        super.a(qCircleLayerBean, feedCloudMeta$StFeed, i3, imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // l80.b
    public IDataDisplaySurface<e30.b> b() {
        t80.a aVar = this.f413952d;
        if (aVar != null) {
            return aVar;
        }
        return this.f413953e;
    }

    @Override // l80.b
    protected String e() {
        t80.a aVar = this.f413952d;
        if (aVar != null) {
            return aVar.M1();
        }
        return this.f413953e.E2();
    }

    protected abstract t80.a i();

    protected abstract t80.b j();

    public void n(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.f413954f = feedCloudMeta$StFeed;
    }
}
