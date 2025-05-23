package com.tencent.biz.qqcircle.immersive.feed;

import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSLikeStateChangeEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.QFSAsyncUtils;
import com.tencent.biz.qqcircle.widgets.QFSMultiGuideBtnManageLayout;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;
import qqcircle.QQCircleDitto$StButton;
import qqcircle.QQCircleDitto$StButtonGroup;
import qqcircle.QQCircleFeedBase$StFeedBusiReqData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class o extends com.tencent.biz.qqcircle.immersive.views.banner.bottom.c {
    private View D;
    private View E;
    private QFSMultiGuideBtnManageLayout F;
    private QQCircleDitto$StButtonGroup G;
    private List<QQCircleDitto$StButton> H;
    private boolean I;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends QFSAsyncUtils.Callback<Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e30.b f86372a;

        a(e30.b bVar) {
            this.f86372a = bVar;
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSAsyncUtils.Callback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void doMainAction(Void r85) {
            e30.b bVar;
            super.doMainAction(r85);
            if (o.this.H.size() != 0) {
                o.this.N(0);
                o oVar = o.this;
                oVar.M(5000, 55005, oVar.k(), "2", "");
            } else {
                o.this.N(8);
            }
            if (o.this.F != null && (bVar = this.f86372a) != null && bVar.g() != null) {
                o.this.F.setData(this.f86372a.g(), o.this.G, o.this.D);
                o.this.F.setInfoViewTop(o.this.E);
            }
            o.this.G();
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSAsyncUtils.Callback
        public Void doBackgroundAction(Void... voidArr) {
            e30.b bVar = this.f86372a;
            if (bVar == null) {
                QLog.d("QFSFeedChildBottomFeedbackInfoView", 1, "[doBackgroundAction] feedBlockData should not be null");
                return null;
            }
            QQCircleFeedBase$StFeedBusiReqData qQCircleFeedBase$StFeedBusiReqData = (QQCircleFeedBase$StFeedBusiReqData) bVar.b("DITTO_FEED_BUSI_REQ_DATA");
            if (qQCircleFeedBase$StFeedBusiReqData != null) {
                o.this.G = qQCircleFeedBase$StFeedBusiReqData.bottomButtons.get();
                if (o.this.G != null) {
                    o oVar = o.this;
                    oVar.H = oVar.G.buttons.get();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements QFSMultiGuideBtnManageLayout.m {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSMultiGuideBtnManageLayout.m
        public void a(int i3) {
            o.this.F.s(i3);
            o.this.I = true;
            if (i3 == 1) {
                o.this.J();
            } else if (i3 == 2) {
                o.this.H(i3);
            }
        }
    }

    public o(@NonNull com.tencent.biz.qqcircle.immersive.views.banner.bottom.a aVar) {
        super(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        QFSMultiGuideBtnManageLayout qFSMultiGuideBtnManageLayout = this.F;
        if (qFSMultiGuideBtnManageLayout == null) {
            return;
        }
        qFSMultiGuideBtnManageLayout.setOnSelectedListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(int i3) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this.f90602e;
        if (feedCloudMeta$StFeed2 == null) {
            return;
        }
        if (feedCloudMeta$StFeed2.isRecomFd.get()) {
            feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
            feedCloudMeta$StFeed.f398449id.set(this.f90602e.recomForward.f398458id.get());
            feedCloudMeta$StFeed.poster.set(this.f90602e.recomForward.poster.get());
        } else {
            feedCloudMeta$StFeed = this.f90602e;
        }
        int i16 = this.f90603f;
        SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedEvent(feedCloudMeta$StFeed.f398449id.get(), 3));
        QCircleToast.i(QCircleToast.f91646f, R.string.f182873hn, 0);
        L(feedCloudMeta$StFeed, i3, i16);
    }

    private void I(e30.b bVar) {
        if (this.F == null) {
            QLog.d("QFSFeedChildBottomFeedbackInfoView", 1, "[getGroupBtnData] mMultiBtnGuideLayout should not be null");
        } else if (bVar != null && bVar.g() != null) {
            QFSAsyncUtils.executeSub(new a(bVar), new Void[0]);
        } else {
            QLog.d("QFSFeedChildBottomFeedbackInfoView", 1, "[getGroupBtnData] feed should not be null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        if (this.f90602e != null && this.f90604h != null) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSLikeStateChangeEvent(this.f90602e.f398449id.get(), true));
            QLog.d("PL-QFSFeedChildBottomFeedbackInfoView", 1, "[handleVideoLike] request like state: ", Boolean.TRUE);
            ha0.b.h(this.f90602e, true, this.f90604h.getContext());
        }
    }

    private void K(@NonNull View view) {
        this.F = (QFSMultiGuideBtnManageLayout) view.findViewById(R.id.ypf);
        this.D = view.findViewById(R.id.f34510zc);
        this.E = view.findViewById(R.id.f39941d1);
    }

    private void L(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, int i16) {
        QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(ua0.c.a(feedCloudMeta$StFeed).setToUin(feedCloudMeta$StFeed.poster.f398463id.get()).setActionType(65).setSubActionType(i3).setIndex(i16).setExt3(String.valueOf(feedCloudMeta$StFeed.createTime)).setPageId(p().getPageId())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(int i3, int i16, QCircleExtraTypeInfo qCircleExtraTypeInfo, String str, String str2) {
        if (qCircleExtraTypeInfo != null && qCircleExtraTypeInfo.mFeed != null && p() != null) {
            QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder(ua0.c.c(qCircleExtraTypeInfo.mFeed));
            dataBuilder.setActionType(i3).setSubActionType(i16).setToUin(qCircleExtraTypeInfo.mFeed.poster.f398463id.get()).setPosition(qCircleExtraTypeInfo.mDataPosition).setPlayScene(qCircleExtraTypeInfo.mPlayScene).setExt1(str).setExt4(str2).setPageId(p().getPageId()).setfpageid(Integer.valueOf(p().getFromPageId()).intValue()).setFirstFeedId(w20.a.j().h());
            QCircleLpReportDc05507.report(dataBuilder);
        } else {
            QLog.e("QCircleReportHelper_QFSFeedChildBottomFeedbackInfoView", 1, "extraTypeInfo is null or lost feed,actionType:" + i3 + ",subActionType:" + i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(int i3) {
        O(this.F, i3);
    }

    private void O(View view, int i3) {
        if (view != null && view.getVisibility() != i3) {
            view.setVisibility(i3);
        }
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 118;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        String str;
        if (com.tencent.biz.qqcircle.helpers.d.a(1, false)) {
            QLog.d("QFSFeedChildBottomFeedbackInfoView", 1, "[isElementCanActivate] forbid like because of sencebeat");
            return false;
        }
        if (this.I) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[isElementCanActivate] ");
            sb5.append(this);
            sb5.append(" is operate once, do not show again. feed id =");
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
            if (feedCloudMeta$StFeed == null) {
                str = "";
            } else {
                str = feedCloudMeta$StFeed.f398449id.get();
            }
            sb5.append(str);
            sb5.append(", getContextHashCode =");
            sb5.append(getContextHashCode());
            sb5.append(", mIsClicked =");
            sb5.append(this.I);
            QLog.d("QFSFeedChildBottomFeedbackInfoView", 1, sb5.toString());
            return false;
        }
        return com.tencent.biz.qqcircle.immersive.utils.ak.a().f(this.f90601d);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        QLog.d("QFSFeedChildBottomFeedbackInfoView", 1, "[onElementActivated]");
        K(this.f90604h);
        if (this.I) {
            N(8);
            QLog.d("QFSFeedChildBottomFeedbackInfoView", 1, "multi btn is clicked");
        } else {
            I(this.f90601d);
        }
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        N(8);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    public void q() {
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    public void r() {
    }
}
