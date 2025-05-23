package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.widgets.QFSLikeImageView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class cg extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements Observer<e30.b> {
    private QFSLikeImageView I;
    private TextView J;
    private e30.b L;
    private boolean K = false;
    private boolean M = false;

    private void i1(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        boolean z16;
        if (this.J == null) {
            QLog.d("PL-QFSFeedChildAdLikePresenter", 1, "[updateFeedLike] video like text should not be null.");
            return;
        }
        if (this.I == null) {
            QLog.d("PL-QFSFeedChildAdLikePresenter", 1, "[updateFeedLike] mLikeImg should not be null.");
            return;
        }
        if (feedCloudMeta$StFeed.likeInfo.count.get() == 0) {
            this.J.setText(R.string.f193704_x);
        } else {
            this.J.setText(com.tencent.biz.qqcircle.immersive.utils.r.d(feedCloudMeta$StFeed.likeInfo.count.get(), 11));
        }
        this.I.setData(feedCloudMeta$StFeed);
        if (feedCloudMeta$StFeed.likeInfo.status.get() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.K = z16;
        if (this.M != z16) {
            QLog.d("PL-QFSFeedChildAdLikePresenter", 1, "[updateFeedLike] is liked: " + this.K);
            this.M = this.K;
        }
        this.I.n(this.K);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void j1() {
        QFSLikeImageView qFSLikeImageView = this.I;
        if (qFSLikeImageView == null) {
            return;
        }
        qFSLikeImageView.setNeedInterceptClick(!((FeedCloudMeta$StFeed) this.f85017h).opMask2.get().contains(23));
        if (((FeedCloudMeta$StFeed) this.f85017h).opMask2.get().contains(23)) {
            this.I.setItemPreClickListener(new QFSLikeImageView.d() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.ce
            });
        } else {
            this.I.setItemPreClickListener(new QFSLikeImageView.d() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.cf
            });
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.I = (QFSLikeImageView) view.findViewById(R.id.f40611eu).findViewById(R.id.f40581er);
        this.J = (TextView) view.findViewById(R.id.f40601et);
        this.I.setContentDescription(com.tencent.biz.qqcircle.utils.h.a(R.string.f1909843k));
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        if (feedCloudMeta$StFeed == null) {
            QLog.d("QFSFeedChildAdLikePresenter", 1, "[onBindData] data should not be null.");
            return;
        }
        i1(feedCloudMeta$StFeed);
        j1();
        this.L = new e30.b(feedCloudMeta$StFeed);
        w20.a.j().observerGlobalState(this.L, this);
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: h1, reason: merged with bridge method [inline-methods] */
    public void onChanged(e30.b bVar) {
        if (bVar == null) {
            return;
        }
        i1(bVar.g());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return null;
    }
}
