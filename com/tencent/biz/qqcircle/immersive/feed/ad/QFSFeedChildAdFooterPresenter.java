package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.text.TextUtils;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.biz.qqcircle.events.QCircleAdClickEvent;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart;
import com.tencent.biz.qqcircle.immersive.refresh.QFSPullRefreshLayout;
import com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.ioc.RFWIocBaseInterface;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import tencent.gdt.qq_ad_get;

/* loaded from: classes4.dex */
public final class QFSFeedChildAdFooterPresenter extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    private QFSAdOnShowFooterViewListener I;
    private WeakReference<QFSPullRefreshLayout.g> J;
    private qq_ad_get.QQAdGetRsp.AdInfo K;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class QFSAdOnShowFooterViewListener implements QFSPullRefreshLayout.g {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QFSFeedChildAdFooterPresenter> f85361d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f85362e = false;

        /* renamed from: f, reason: collision with root package name */
        private boolean f85363f = false;

        /* renamed from: h, reason: collision with root package name */
        private long f85364h = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;

        /* renamed from: i, reason: collision with root package name */
        private Runnable f85365i = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdFooterPresenter.QFSAdOnShowFooterViewListener.1
            @Override // java.lang.Runnable
            public void run() {
                QFSFeedChildAdFooterPresenter qFSFeedChildAdFooterPresenter;
                QLog.d("QFSFeedChildAdFooterPresenter", 1, "[QFSAdOnShowFooterViewListener][FinishRunnable] visible:" + QFSAdOnShowFooterViewListener.this.f85362e + " mPulling:" + QFSAdOnShowFooterViewListener.this.f85363f + " startTimeMillis:" + QFSAdOnShowFooterViewListener.this.f85364h);
                if (QFSAdOnShowFooterViewListener.this.f85361d != null) {
                    qFSFeedChildAdFooterPresenter = (QFSFeedChildAdFooterPresenter) QFSAdOnShowFooterViewListener.this.f85361d.get();
                } else {
                    qFSFeedChildAdFooterPresenter = null;
                }
                if (qFSFeedChildAdFooterPresenter != null) {
                    qFSFeedChildAdFooterPresenter.q1();
                } else {
                    QLog.e("QFSFeedChildAdFooterPresenter", 1, "[QFSAdOnShowFooterViewListener][FinishRunnable] error, presenter is null");
                }
            }
        };

        public QFSAdOnShowFooterViewListener(WeakReference<QFSFeedChildAdFooterPresenter> weakReference) {
            this.f85361d = weakReference;
        }

        @Override // com.tencent.biz.qqcircle.immersive.refresh.QFSPullRefreshLayout.g
        public void Y(boolean z16, boolean z17) {
            int i3;
            long j3;
            QLog.d("QFSFeedChildAdFooterPresenter", 4, "[QFSAdOnShowFooterViewListener][onPullUpEnd] forced:" + z16 + " visible:" + z17 + " mVisible:" + this.f85362e + " mPulling:" + this.f85363f + " mStartTimeMillis:" + this.f85364h);
            if (z16 && this.f85362e && this.f85363f && this.f85364h != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
                this.f85362e = z17;
                this.f85363f = false;
                WeakReference<QFSFeedChildAdFooterPresenter> weakReference = this.f85361d;
                if (weakReference != null) {
                    i3 = weakReference.get().l1();
                } else {
                    i3 = Integer.MIN_VALUE;
                }
                if (i3 >= 0) {
                    j3 = i3 - (System.currentTimeMillis() - this.f85364h);
                } else {
                    j3 = -2147483648L;
                }
                if (j3 < 0) {
                    j3 = 0;
                }
                QLog.i("QFSFeedChildAdFooterPresenter", 1, "[QFSAdOnShowFooterViewListener][onPullUpEnd] visible:" + z17 + " delayMillis:" + j3);
                RFWThreadManager.getUIHandler().postDelayed(this.f85365i, j3);
                this.f85364h = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
            }
        }

        public void e() {
            RFWThreadManager.getUIHandler().removeCallbacks(this.f85365i);
            this.f85362e = false;
            this.f85363f = false;
            this.f85364h = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }

        @Override // com.tencent.biz.qqcircle.immersive.refresh.QFSPullRefreshLayout.g
        public void f0(boolean z16) {
            QLog.d("QFSFeedChildAdFooterPresenter", 4, "[QFSAdOnShowFooterViewListener][onPullUpStart] forced:" + z16 + " mVisible:" + this.f85362e + " mPulling:" + this.f85363f + " mStartTimeMillis:" + this.f85364h);
            if (z16 && !this.f85363f) {
                QLog.i("QFSFeedChildAdFooterPresenter", 1, "[QFSAdOnShowFooterViewListener][onPullUpStart]");
                this.f85362e = true;
                this.f85363f = true;
                this.f85364h = System.currentTimeMillis();
            }
        }

        @Override // com.tencent.biz.qqcircle.immersive.refresh.QFSPullRefreshLayout.g
        public void onHide(boolean z16) {
            QLog.d("QFSFeedChildAdFooterPresenter", 4, "[QFSAdOnShowFooterViewListener][onHide] forced:" + z16 + " mVisible:" + this.f85362e + " mPulling:" + this.f85363f + " mStartTimeMillis:" + this.f85364h);
            if (z16 && this.f85362e) {
                QLog.i("QFSFeedChildAdFooterPresenter", 1, "[QFSAdOnShowFooterViewListener][onHide]");
                e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: b, reason: collision with root package name */
        private static volatile a f85366b;

        /* renamed from: a, reason: collision with root package name */
        private Set<String> f85367a = new HashSet();

        a() {
        }

        public static a a() {
            if (f85366b == null) {
                synchronized (a.class) {
                    if (f85366b == null) {
                        f85366b = new a();
                    }
                }
            }
            return f85366b;
        }

        public boolean b(String str) {
            if (TextUtils.isEmpty(str)) {
                QLog.e("QFSAdFooterManager", 1, "[FooterManager][isIgnored] error, traceId is null");
                return false;
            }
            return this.f85367a.contains(str);
        }

        public void c(String str) {
            if (TextUtils.isEmpty(str)) {
                QLog.e("QFSAdFooterManager", 1, "[FooterManager][setIgnored] error, traceId is null");
                return;
            }
            QLog.i("QFSAdFooterManager", 2, "[FooterManager][setIgnored] traceId:" + str);
            this.f85367a.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int l1() {
        qq_ad_get.QQAdGetRsp.AdInfo adInfo = this.K;
        if (adInfo != null && adInfo.display_info.ad_holdtime_ms.has()) {
            return this.K.display_info.ad_holdtime_ms.get();
        }
        return Integer.MIN_VALUE;
    }

    private QFSPageTurnContainer m1() {
        RFWIocBaseInterface rFWIocBaseInterface = (RFWIocBaseInterface) u0(t40.c.class);
        if (rFWIocBaseInterface instanceof QFSLayerBasePart) {
            return ((QFSLayerBasePart) rFWIocBaseInterface).getLayerPageContainer();
        }
        return null;
    }

    private void n1(QCircleAdClickEvent qCircleAdClickEvent) {
        String str;
        if (qCircleAdClickEvent != null) {
            str = qCircleAdClickEvent.getMTraceId();
        } else {
            str = null;
        }
        QLog.i("QFSFeedChildAdFooterPresenter", 2, "[handleClickEvent] traceId:" + str);
        if (!s1(str)) {
            QLog.i("QFSFeedChildAdFooterPresenter", 2, "[handleClickEvent] do nothing, not the same ad");
        } else {
            q1();
        }
    }

    private void o1(com.tencent.biz.qqcircle.immersive.feed.event.d dVar) {
        String str;
        if (dVar != null && dVar.a() != null) {
            str = dVar.a().getTraceId();
        } else {
            str = null;
        }
        QLog.i("QFSFeedChildAdFooterPresenter", 2, "[handleVideoLoopEndBroadcastMessage] traceId:" + str);
        if (!s1(str)) {
            QLog.i("QFSFeedChildAdFooterPresenter", 2, "[handleVideoLoopEndBroadcastMessage] do nothing, not the same ad");
        } else {
            q1();
        }
    }

    private void p1(com.tencent.biz.qqcircle.immersive.feed.event.e eVar) {
        String str;
        if (eVar != null) {
            str = eVar.getMTraceId();
        } else {
            str = null;
        }
        QLog.i("QFSFeedChildAdFooterPresenter", 2, "[handleVideoPlayEndBroadcastMessage] traceId:" + str);
        if (!s1(str)) {
            QLog.i("QFSFeedChildAdFooterPresenter", 2, "[handleVideoPlayEndBroadcastMessage] do nothing, not the same ad");
        } else {
            q1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q1() {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdFooterPresenter.3
            @Override // java.lang.Runnable
            public void run() {
                QFSFeedChildAdFooterPresenter.this.r1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r1() {
        String traceId = new GdtAd(this.K).getTraceId();
        QLog.i("QFSFeedChildAdFooterPresenter", 1, "[ignoreImpl] traceId:" + traceId);
        QFSAdOnShowFooterViewListener qFSAdOnShowFooterViewListener = this.I;
        if (qFSAdOnShowFooterViewListener != null && qFSAdOnShowFooterViewListener.f85363f) {
            QLog.i("QFSFeedChildAdFooterPresenter", 1, "[ignoreImpl] do nothing, pulling");
        } else {
            y1();
            a.a().c(traceId);
        }
    }

    private boolean s1(String str) {
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, new GdtAd(this.K).getTraceId())) {
            return true;
        }
        return false;
    }

    private void u1() {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdFooterPresenter.1
            @Override // java.lang.Runnable
            public void run() {
                QFSFeedChildAdFooterPresenter.this.v1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v1() {
        QFSPageTurnContainer m16 = m1();
        if (m16 == null) {
            QLog.e("QFSFeedChildAdFooterPresenter", 1, "[registerImpl] error, pageTurnContainer is null");
            return;
        }
        if (!w1()) {
            QLog.i("QFSFeedChildAdFooterPresenter", 1, "[registerImpl] do nothing, should not show footer view");
            return;
        }
        QLog.i("QFSFeedChildAdFooterPresenter", 1, "[registerImpl]");
        m16.setEnableShowFooterViewByForce(true);
        this.I = new QFSAdOnShowFooterViewListener(new WeakReference(this));
        WeakReference<QFSPullRefreshLayout.g> weakReference = new WeakReference<>(this.I);
        this.J = weakReference;
        m16.setOnShowFooterViewListener(weakReference);
    }

    private boolean w1() {
        String traceId = new GdtAd(this.K).getTraceId();
        if (l1() > 0 && !a.a().b(traceId)) {
            return true;
        }
        return false;
    }

    private void x1() {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdFooterPresenter.2
            @Override // java.lang.Runnable
            public void run() {
                QFSFeedChildAdFooterPresenter.this.y1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y1() {
        if (this.I == null) {
            return;
        }
        QFSPageTurnContainer m16 = m1();
        if (m16 == null) {
            QLog.e("QFSFeedChildAdFooterPresenter", 1, "[unregisterImpl] error, pageTurnContainer is null");
            return;
        }
        QLog.i("QFSFeedChildAdFooterPresenter", 1, "[unregisterImpl]");
        if (this.I.f85362e) {
            QLog.i("QFSFeedChildAdFooterPresenter", 1, "[unregisterImpl] hide");
            m16.D();
            a.a().c(new GdtAd(this.K).getTraceId());
        }
        m16.setEnableShowFooterViewByForce(false);
        m16.P(this.J);
        this.I.e();
        this.I = null;
        this.J = null;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        super.C0(hVar);
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.e) {
            p1((com.tencent.biz.qqcircle.immersive.feed.event.e) hVar);
        } else if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.d) {
            o1((com.tencent.biz.qqcircle.immersive.feed.event.d) hVar);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        if (eventClass == null) {
            eventClass = new ArrayList<>();
        }
        eventClass.add(QCircleAdClickEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        QLog.i("QFSFeedChildAdFooterPresenter", 2, "[onFeedSelected]");
        super.onFeedSelected(rFWFeedSelectInfo);
        x1();
        u1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        QLog.i("QFSFeedChildAdFooterPresenter", 2, "[onFeedUnSelected]");
        x1();
        super.onFeedUnSelected(rFWFeedSelectInfo);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QCircleAdClickEvent) {
            n1((QCircleAdClickEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: t1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        this.K = u.e(this.E);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildAdFooterPresenter";
    }
}
