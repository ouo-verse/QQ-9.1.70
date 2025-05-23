package com.tencent.biz.qqcircle.immersive.feed;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.aspectj.QCircleForbidInteractProcessor;
import com.tencent.biz.qqcircle.immersive.events.QFSDoTopProfileEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSLongPressOpenShareEvent;
import com.tencent.biz.qqcircle.widgets.QCircleDoubleClickLayout;
import com.tencent.biz.qqcircle.widgets.QCircleDoublePraiseView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ac extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    private QCircleDoublePraiseView I;
    private QCircleDoubleClickLayout J;
    private FeedCloudMeta$StFeed K;
    private int L = 0;
    private boolean M = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements QCircleDoubleClickLayout.c {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.biz.qqcircle.widgets.QCircleDoubleClickLayout.c
        public void a(MotionEvent motionEvent) {
            QLog.d("QFSFeedChildDoublePraisePresenter", 1, "[onTapClick] mIsShowPopupWindow: " + ac.this.M);
            if (ac.this.M) {
                QLog.d("QFSFeedChildDoublePraisePresenter", 1, "[onTapClick] current show popup window state, tap click end.");
                ac.this.n1(false);
            } else {
                ac acVar = ac.this;
                acVar.T0(new com.tencent.biz.qqcircle.immersive.feed.event.ak(((FeedCloudMeta$StFeed) acVar.f85017h).f398449id.get(), motionEvent));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements QCircleDoubleClickLayout.b {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QCircleDoubleClickLayout.b
        public void onLongClick() {
            ac.this.j1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j1() {
        if (QCircleForbidInteractProcessor.forbidInteractIfGuildFeed(this.K, 2)) {
            QLog.d(getTAG(), 1, "handleLongClick: guild feed forbid interact");
        } else if (s0() == null) {
            QLog.d("QFSFeedChildDoublePraisePresenter", 1, "[handleLongClick] feed ioc should not be null.");
        } else {
            T0(new com.tencent.biz.qqcircle.immersive.feed.event.ab(9));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void k1(@NonNull com.tencent.biz.qqcircle.immersive.feed.event.ad adVar) {
        T t16 = this.f85017h;
        if (t16 != 0 && TextUtils.equals(((FeedCloudMeta$StFeed) t16).f398449id.get(), adVar.a())) {
            this.L = adVar.b();
        }
    }

    private boolean l1(int i3) {
        if (i3 == 0 || m0() == null || m0().hashCode() != i3) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n1(boolean z16) {
        this.M = z16;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        super.C0(hVar);
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.ar) {
            n1(((com.tencent.biz.qqcircle.immersive.feed.event.ar) hVar).a());
        } else if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.ad) {
            k1((com.tencent.biz.qqcircle.immersive.feed.event.ad) hVar);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void K0() {
        super.K0();
        QCircleDoublePraiseView qCircleDoublePraiseView = this.I;
        if (qCircleDoublePraiseView != null) {
            qCircleDoublePraiseView.setReportBean(getReportBean());
            this.I.setPageType(y0());
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        QCircleDoubleClickLayout qCircleDoubleClickLayout = (QCircleDoubleClickLayout) view.findViewById(R.id.v_o);
        this.J = qCircleDoubleClickLayout;
        qCircleDoubleClickLayout.setContentDescription("\u5355\u51fb\u6682\u505c");
        this.I = (QCircleDoublePraiseView) view.findViewById(R.id.v9n);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QFSDoTopProfileEvent.class);
        eventClass.add(QFSLongPressOpenShareEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: m1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        this.K = feedCloudMeta$StFeed;
        QCircleDoublePraiseView qCircleDoublePraiseView = this.I;
        if (qCircleDoublePraiseView != null) {
            qCircleDoublePraiseView.setFeed(feedCloudMeta$StFeed, i3);
        }
        QCircleDoubleClickLayout qCircleDoubleClickLayout = this.J;
        if (qCircleDoubleClickLayout != null) {
            qCircleDoubleClickLayout.setOnTapClickListener(new a());
            this.J.setOnLongClickListener(new b());
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        if (rFWFeedSelectInfo == null) {
            return;
        }
        if (rFWFeedSelectInfo.getPosition() != this.f85018i) {
            QLog.d("QFSFeedChildDoublePraisePresenter", 1, "[onFeedUnSelected] selectInfo: " + rFWFeedSelectInfo + " | mPos: " + this.f85018i);
            return;
        }
        n1(false);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedUnSelected(rFWFeedSelectInfo);
        if (rFWFeedSelectInfo == null) {
            return;
        }
        if (rFWFeedSelectInfo.getPosition() != this.f85018i) {
            QLog.d("QFSFeedChildDoublePraisePresenter", 1, "[onFeedUnSelected] selectInfo: " + rFWFeedSelectInfo + " | mPos: " + this.f85018i);
            return;
        }
        n1(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSDoTopProfileEvent) {
            QFSDoTopProfileEvent qFSDoTopProfileEvent = (QFSDoTopProfileEvent) simpleBaseEvent;
            T t16 = this.f85017h;
            if (t16 != 0 && TextUtils.equals(((FeedCloudMeta$StFeed) t16).f398449id.get(), qFSDoTopProfileEvent.mTargetFeedId)) {
                if (qFSDoTopProfileEvent.isDoProfile) {
                    ((FeedCloudMeta$StFeed) this.f85017h).opMask2.get().add(20);
                    return;
                } else {
                    ((FeedCloudMeta$StFeed) this.f85017h).opMask2.get().remove((Object) 20);
                    return;
                }
            }
            return;
        }
        if (simpleBaseEvent instanceof QFSLongPressOpenShareEvent) {
            QFSLongPressOpenShareEvent qFSLongPressOpenShareEvent = (QFSLongPressOpenShareEvent) simpleBaseEvent;
            if (this.K != null && l1(qFSLongPressOpenShareEvent.mContextHashcode) && TextUtils.equals(qFSLongPressOpenShareEvent.mFeedId, this.K.f398449id.get())) {
                j1();
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildDoublePraisePresenter";
    }
}
