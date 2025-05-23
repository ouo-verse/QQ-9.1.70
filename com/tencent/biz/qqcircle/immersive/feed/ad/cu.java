package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSAdSpaceDisplayedEvent;
import com.tencent.biz.qqcircle.immersive.manager.QFSTopViewManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.shake.GdtShakeSensor;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes4.dex */
public final class cu extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    private GdtAd I;
    private boolean J;
    private boolean K;
    private boolean M;
    private boolean L = false;
    private volatile boolean N = false;
    private volatile boolean P = false;
    private final GdtShakeSensor Q = new GdtShakeSensor();
    private final GdtShakeSensor.OnShakeListener R = new a();

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements GdtShakeSensor.OnShakeListener {
        a() {
        }

        @Override // com.tencent.gdtad.views.shake.GdtShakeSensor.OnShakeListener
        public void onShakeComplete() {
            QLog.i("QFSFeedChildAdShakeSensorPresenter", 2, "[onShakeComplete]");
            if (!cu.this.J) {
                return;
            }
            if (!cu.this.M && !cu.this.N) {
                return;
            }
            if (!cu.this.K && !QCirclePanelStateEvent.isAnyPanelShowing()) {
                if (cu.this.L) {
                    QLog.i("QFSFeedChildAdShakeSensorPresenter", 2, "[onShakeComplete] error, mSpaceDisplayed is true");
                    return;
                } else if (!cu.this.J0()) {
                    QLog.e("QFSFeedChildAdShakeSensorPresenter", 2, "[onShakeComplete] !isVideoOnScreen()");
                    return;
                } else {
                    com.tencent.biz.qqcircle.immersive.utils.j.f90213a.K(cu.this.I, ((QFSBaseFeedChildPresenter) cu.this).C, ((QFSBaseFeedChildPresenter) cu.this).f85018i, cu.this.r(), 80);
                    return;
                }
            }
            QLog.d("QFSFeedChildAdShakeSensorPresenter", 1, "[onShakeComplete] stop, panel is showing");
            cu.this.stop();
        }
    }

    private void q1(QFSFeedAdFeedbackEvent qFSFeedAdFeedbackEvent) {
        String str;
        boolean z16;
        if (qFSFeedAdFeedbackEvent == null) {
            QLog.e("QFSFeedChildAdShakeSensorPresenter", 2, "[handleFeedbackEvent] error, event is null");
            return;
        }
        QLog.i("QFSFeedChildAdShakeSensorPresenter", 2, "[handleFeedbackEvent] state:" + qFSFeedAdFeedbackEvent.getStatus());
        String str2 = null;
        if (qFSFeedAdFeedbackEvent.getGdtAd() != null) {
            str = qFSFeedAdFeedbackEvent.getGdtAd().getTraceId();
        } else {
            str = null;
        }
        GdtAd gdtAd = this.I;
        if (gdtAd != null) {
            str2 = gdtAd.getTraceId();
        }
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, str2)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            QLog.d("QFSFeedChildAdShakeSensorPresenter", 2, "[handleFeedbackEvent] not the same ad");
            return;
        }
        if (qFSFeedAdFeedbackEvent.getStatus() == QFSFeedAdFeedbackEvent.STATUS_START) {
            this.K = true;
            stop();
        } else {
            if (qFSFeedAdFeedbackEvent.getStatus() == QFSFeedAdFeedbackEvent.STATUS_END) {
                this.K = false;
                if (qFSFeedAdFeedbackEvent.getAction() == 0) {
                    if (this.M || this.N) {
                        start();
                        return;
                    }
                    return;
                }
                return;
            }
            QLog.e("QFSFeedChildAdShakeSensorPresenter", 2, "[handleFeedbackEvent] error, unknown state");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void r1(QCirclePanelStateEvent qCirclePanelStateEvent) {
        if (!this.J) {
            return;
        }
        if ((this.M || this.N) && qCirclePanelStateEvent != null && this.f85017h != 0 && TextUtils.equals(qCirclePanelStateEvent.getFeedId(), ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get())) {
            if (qCirclePanelStateEvent.isShowing()) {
                stop();
                QLog.d("QFSFeedChildAdShakeSensorPresenter", 1, "[handlePanelStateEvent] panel show, stop sensor.");
            } else {
                start();
                QLog.d("QFSFeedChildAdShakeSensorPresenter", 1, "[handlePanelStateEvent] panel dismiss, start sensor.");
            }
        }
    }

    private void s1(QFSAdSpaceDisplayedEvent qFSAdSpaceDisplayedEvent) {
        String str;
        boolean z16;
        if (qFSAdSpaceDisplayedEvent == null) {
            QLog.e("QFSFeedChildAdShakeSensorPresenter", 2, "[handleSpaceDisplayedEvent] error, event is null");
            return;
        }
        String str2 = null;
        if (qFSAdSpaceDisplayedEvent.getAd() != null) {
            str = qFSAdSpaceDisplayedEvent.getAd().getTraceId();
        } else {
            str = null;
        }
        GdtAd gdtAd = this.I;
        if (gdtAd != null) {
            str2 = gdtAd.getTraceId();
        }
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, str2)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            QLog.d("QFSFeedChildAdShakeSensorPresenter", 2, "[handleSpaceDisplayedEvent] not the same ad");
            return;
        }
        QLog.i("QFSFeedChildAdShakeSensorPresenter", 1, "[handleSpaceDisplayedEvent]");
        this.L = true;
        stop();
    }

    private void start() {
        if (this.K) {
            QLog.i("QFSFeedChildAdShakeSensorPresenter", 2, "[start] error, feedback dialog is showing");
            return;
        }
        if (this.L) {
            QLog.i("QFSFeedChildAdShakeSensorPresenter", 2, "[start] error, mSpaceDisplayed is true");
            return;
        }
        if (!J0()) {
            QLog.i("QFSFeedChildAdShakeSensorPresenter", 2, "[start] error, !isVideoOnScreen()");
            return;
        }
        QLog.i("QFSFeedChildAdShakeSensorPresenter", 2, "[start]");
        if (this.J) {
            this.Q.register(m0());
        } else {
            this.Q.unregister(m0());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        QLog.i("QFSFeedChildAdShakeSensorPresenter", 2, "[stop]");
        this.Q.unregister(m0());
    }

    private boolean t1() {
        qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        GdtAd gdtAd = this.I;
        if (gdtAd != null) {
            adInfo = gdtAd.info;
        } else {
            adInfo = null;
        }
        if (adInfo == null) {
            return false;
        }
        boolean Z = af.Z(gdtAd);
        boolean i3 = QFSTopViewManager.i(adInfo);
        this.M = i3;
        return Z | i3;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        super.C0(hVar);
        if (this.I == null) {
            QLog.e("QFSFeedChildAdShakeSensorPresenter", 2, "[handleBroadcastMessage] mGdtAd is null");
            return;
        }
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.e) {
            if (!TextUtils.equals(((com.tencent.biz.qqcircle.immersive.feed.event.e) hVar).getMTraceId(), this.I.getTraceId())) {
                return;
            }
            this.P = true;
            stop();
            return;
        }
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.f) {
            if (!TextUtils.equals(((com.tencent.biz.qqcircle.immersive.feed.event.f) hVar).getMTraceId(), this.I.getTraceId())) {
                return;
            }
            this.P = false;
            start();
            return;
        }
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.c) {
            com.tencent.biz.qqcircle.immersive.feed.event.c cVar = (com.tencent.biz.qqcircle.immersive.feed.event.c) hVar;
            if (!TextUtils.equals(cVar.a(), this.I.getTraceId())) {
                return;
            }
            this.N = cVar.b();
            start();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QFSFeedAdFeedbackEvent.class);
        eventClass.add(QFSAdSpaceDisplayedEvent.class);
        eventClass.add(QCirclePanelStateEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onDestroy() {
        QLog.i("QFSFeedChildAdShakeSensorPresenter", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        stop();
        super.onDestroy();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        QLog.i("QFSFeedChildAdShakeSensorPresenter", 2, "onFeedSelected");
        super.onFeedSelected(rFWFeedSelectInfo);
        if (this.M || this.N) {
            start();
        }
        this.P = false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        QLog.i("QFSFeedChildAdShakeSensorPresenter", 2, "onFeedUnSelected");
        stop();
        super.onFeedUnSelected(rFWFeedSelectInfo);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(RFWFeedSelectInfo rFWFeedSelectInfo) {
        QLog.i("QFSFeedChildAdShakeSensorPresenter", 2, "onPaused");
        stop();
        super.onPaused(rFWFeedSelectInfo);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSFeedAdFeedbackEvent) {
            q1((QFSFeedAdFeedbackEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSAdSpaceDisplayedEvent) {
            s1((QFSAdSpaceDisplayedEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QCirclePanelStateEvent) {
            r1((QCirclePanelStateEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(RFWFeedSelectInfo rFWFeedSelectInfo) {
        QLog.i("QFSFeedChildAdShakeSensorPresenter", 2, "onResumed");
        super.onResumed(rFWFeedSelectInfo);
        if (this.P) {
            return;
        }
        if (this.M || this.N) {
            start();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus
    public void onViewHolderAttachedToWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        QLog.i("QFSFeedChildAdShakeSensorPresenter", 2, "onViewHolderAttachedToWindow");
        super.onViewHolderAttachedToWindow(viewHolder);
        this.N = af.X(this.I);
        if (this.M || this.N) {
            start();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus
    public void onViewHolderDetachedFromWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        QLog.i("QFSFeedChildAdShakeSensorPresenter", 2, "onViewHolderDetachedFromWindow");
        stop();
        this.N = false;
        super.onViewHolderDetachedFromWindow(viewHolder);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: u1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        String str;
        boolean z16;
        super.L0(feedCloudMeta$StFeed, i3);
        qq_ad_get.QQAdGetRsp.AdInfo e16 = u.e(this.E);
        GdtAd gdtAd = new GdtAd(e16);
        String traceId = gdtAd.getTraceId();
        GdtAd gdtAd2 = this.I;
        if (gdtAd2 != null) {
            str = gdtAd2.getTraceId();
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(traceId) && TextUtils.equals(traceId, str)) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.I = gdtAd;
        boolean t16 = t1();
        this.J = t16;
        if (!z16) {
            this.L = false;
        }
        if (!t16) {
            QLog.i("QFSFeedChildAdShakeSensorPresenter", 2, "[onBindData] data disable shakeSensor");
            return;
        }
        this.Q.setShakeListener(new WeakReference<>(this.R));
        this.Q.setShakeFactor(new GdtShakeSensor.Params(e16));
        U0(ae.b(feedCloudMeta$StFeed, i3));
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildAdShakeSensorPresenter";
    }
}
