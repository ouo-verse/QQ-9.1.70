package a90;

import android.util.Size;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.event.h;
import com.tencent.biz.qqcircle.immersive.utils.n;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.widget.QFSSearchResultLabelLayout;
import com.tencent.biz.qqcircle.immersive.views.search.util.p;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.mobileqq.R;
import feedcloud.FeedCloudMeta$StFeed;
import p70.i;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    private View I;
    private QFSSearchResultLabelLayout J;
    private QCircleAvatarView K;
    private TextView L;
    private View M;
    private TextView N;
    private Size P;
    private final z90.a Q = new z90.a();
    private i R;

    /* JADX WARN: Multi-variable type inference failed */
    private void h1() {
        this.I.setVisibility(0);
        this.K.setUser(((FeedCloudMeta$StFeed) this.f85017h).poster, this.P);
        this.N.setText(r.f(((FeedCloudMeta$StFeed) this.f85017h).visitorInfo.viewCount.get()));
        this.L.setText(((FeedCloudMeta$StFeed) this.f85017h).poster.nick.get());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(h hVar) {
        if (hVar instanceof j80.a) {
            L0((FeedCloudMeta$StFeed) this.f85017h, this.f85018i);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.J = (QFSSearchResultLabelLayout) view.findViewById(R.id.f43851nl);
        this.I = view.findViewById(R.id.f34520zd);
        this.K = (QCircleAvatarView) view.findViewById(R.id.f516628p);
        this.L = (TextView) view.findViewById(R.id.f517028t);
        this.M = view.findViewById(R.id.evy);
        this.N = (TextView) view.findViewById(R.id.f57272mv);
        this.P = n.a(view.getContext(), R.dimen.d4y);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        if (this.R == null) {
            i iVar = (i) A0(i.class);
            this.R = iVar;
            this.Q.c(iVar.f2());
        }
        this.I.setVisibility(8);
        this.Q.d(8);
        this.J.a((FeedCloudMeta$StFeed) this.f85017h);
        if (p.y(feedCloudMeta$StFeed)) {
            this.M.setVisibility(8);
            if (p.j(feedCloudMeta$StFeed) == 1) {
                h1();
                return;
            } else {
                this.Q.a(this.C, feedCloudMeta$StFeed);
                return;
            }
        }
        this.M.setVisibility(0);
        h1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSSearchHotRankWidgetPresenter";
    }
}
