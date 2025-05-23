package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.widgets.QCircleDoubleClickLayout;
import com.tencent.biz.qqcircle.widgets.QCircleDoublePraiseView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class bp extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    private QCircleDoubleClickLayout I;
    private QCircleDoublePraiseView J;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i1(MotionEvent motionEvent) {
        T0(new com.tencent.biz.qqcircle.immersive.feed.event.ak(u.c(this.E).f398449id.get(), motionEvent));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: l1, reason: merged with bridge method [inline-methods] */
    public void j1() {
        if (s0() == null) {
            QLog.d("QFSFeedChildAdDoublePraisePresenter", 1, "[openSharePanel] feed ioc should not be null.");
            return;
        }
        if (((FeedCloudMeta$StFeed) this.f85017h).opMask2.get().contains(26)) {
            QCircleToast.h(R.string.f187933vb, 0);
            return;
        }
        QCircleShareInfo c16 = com.tencent.biz.qqcircle.immersive.utils.au.c((FeedCloudMeta$StFeed) this.f85017h);
        c16.feedBlockData = this.E;
        c16.extraTypeInfo.mDataPosition = this.f85018i;
        c16.feed = (FeedCloudMeta$StFeed) this.f85017h;
        c16.mReportBean = getReportBean();
        c16.isShowReport = false;
        c16.isShowDisLike = false;
        c16.isShowDeletePushDisable = false;
        c16.isShowDeletePush = false;
        c16.isShowSetToPublicPermission = false;
        s0().onHandlerMessage("event_open_share", c16);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void K0() {
        super.K0();
        QCircleDoublePraiseView qCircleDoublePraiseView = this.J;
        if (qCircleDoublePraiseView != null) {
            qCircleDoublePraiseView.setReportBean(getReportBean());
            this.J.setPageType(y0());
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.I = (QCircleDoubleClickLayout) view.findViewById(R.id.v_o);
        this.J = (QCircleDoublePraiseView) view.findViewById(R.id.v9n);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: k1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        this.J.setFeed(feedCloudMeta$StFeed, i3);
        this.I.setOnTapClickListener(new QCircleDoubleClickLayout.c() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.bn
            @Override // com.tencent.biz.qqcircle.widgets.QCircleDoubleClickLayout.c
            public final void a(MotionEvent motionEvent) {
                bp.this.i1(motionEvent);
            }
        });
        this.I.setOnLongClickListener(new QCircleDoubleClickLayout.b() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.bo
            @Override // com.tencent.biz.qqcircle.widgets.QCircleDoubleClickLayout.b
            public final void onLongClick() {
                bp.this.j1();
            }
        });
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildAdDoublePraisePresenter";
    }
}
