package com.tencent.biz.qqcircle.immersive.feed;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.events.QCircleVideoRateEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSLockRateStatusChangeEvent;
import com.tencent.biz.qqcircle.immersive.tab.QFSFollowTabFragment;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.widgets.QFSRatePlayGestureDetectorView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.biz.richframework.video.rfw.view.RFWVideoView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class dr extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements QFSRatePlayGestureDetectorView.a, QFSRatePlayGestureDetectorView.b {
    protected float I;
    protected QFSVideoView J;
    protected LinearLayout K;
    protected boolean L = false;
    private boolean M = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            dr.this.n1();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface b {
        RFWVideoView v();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void g1() {
        LinearLayout linearLayout;
        if (this.f85017h != 0 && (linearLayout = this.K) != null) {
            VideoReport.setElementId(linearLayout, QCircleDaTongConstant.ElementId.EM_XSJ_LOCK_SPEED_TOAST);
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put("xsj_feed_id", ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, ((FeedCloudMeta$StFeed) this.f85017h).poster.f398463id.get());
            VideoReport.setElementParams(this.K, buildElementParams);
            VideoReport.setElementReuseIdentifier(this.K, QCircleDaTongConstant.ElementId.EM_XSJ_LOCK_SPEED_TOAST + ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get());
            VideoReport.setElementExposePolicy(this.K, ExposurePolicy.REPORT_NONE);
            VideoReport.setElementClickPolicy(this.K, ClickPolicy.REPORT_ALL);
            VideoReport.reportEvent("dt_imp", this.K, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void i1(QCirclePanelStateEvent qCirclePanelStateEvent) {
        if (this.L && qCirclePanelStateEvent.getPanelType() == 21 && !qCirclePanelStateEvent.isShowing() && this.f85017h != 0 && TextUtils.equals(qCirclePanelStateEvent.getFeedId(), ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get()) && h1() != 2.0f) {
            p1(false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void j1(QCircleVideoRateEvent qCircleVideoRateEvent) {
        if (this.f85017h != 0 && qCircleVideoRateEvent.getFeedId().equals(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get())) {
            this.I = qCircleVideoRateEvent.getSelectedRate();
            p1(false);
        }
    }

    private void k1() {
        if (this.K != null) {
            return;
        }
        View inflate = ((ViewStub) this.C.findViewById(R.id.f490221k)).inflate();
        this.K = (LinearLayout) inflate.findViewById(R.id.f490121j);
        ((ImageView) inflate.findViewById(R.id.f44281or)).setColorFilter(QCircleSkinHelper.getInstance().getColor(R.color.cla));
        this.K.setOnClickListener(new a());
    }

    private boolean l1() {
        return !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105714", false);
    }

    private void o1(float f16) {
        if (!q1()) {
            return;
        }
        RFWVideoView v3 = v();
        if (v3 != null) {
            v3.setPlayRate(f16);
            v3.start();
            QLog.d(getTAG(), 1, "[setPlayRate]:" + f16);
            return;
        }
        QLog.d(getTAG(), 1, "[setPlayRate]: mPlayView is Empty");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void p1(boolean z16) {
        float f16;
        String str;
        int i3;
        if (!this.L) {
            return;
        }
        if (z16) {
            k1();
            g1();
        }
        LinearLayout linearLayout = this.K;
        boolean z17 = false;
        if (linearLayout != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            linearLayout.setVisibility(i3);
        }
        if (s0() != null && (s0().getHostFragment() instanceof QFSFollowTabFragment)) {
            z17 = true;
        }
        if (z16) {
            f16 = h1();
        } else {
            f16 = this.I;
        }
        QFSLockRateStatusChangeEvent qFSLockRateStatusChangeEvent = new QFSLockRateStatusChangeEvent(z16, f16);
        qFSLockRateStatusChangeEvent.setIsFollowPage(z17);
        T t16 = this.f85017h;
        if (t16 != 0) {
            str = ((FeedCloudMeta$StFeed) t16).f398449id.get();
        } else {
            str = "";
        }
        qFSLockRateStatusChangeEvent.setFeedId(str);
        SimpleEventBus.getInstance().dispatchEvent(qFSLockRateStatusChangeEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void r1(float f16) {
        T t16 = this.f85017h;
        if (t16 != 0 && this.L) {
            QCirclePluginGlobalInfo.k0(((FeedCloudMeta$StFeed) t16).f398449id.get(), f16);
        }
    }

    private void s1() {
        com.tencent.biz.qqcircle.immersive.utils.bc.a(50L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void D(View view, boolean z16) {
        if (!q1()) {
            return;
        }
        this.M = !z16;
        if (z16) {
            if (h1() == 2.0f) {
                return;
            }
            o1(2.0f);
            com.tencent.biz.qqcircle.utils.cb.d(view, 2.0f, (FeedCloudMeta$StFeed) this.f85017h, r0());
            s1();
            QLog.d(getTAG(), 1, "set play rate:2.0");
            return;
        }
        if (this.L) {
            s1();
            QLog.d(getTAG(), 1, "[onYOrientationChange] hit rateLock exp, return.");
        } else {
            if (h1() == 1.5f) {
                return;
            }
            o1(1.5f);
            com.tencent.biz.qqcircle.utils.cb.d(view, 1.5f, (FeedCloudMeta$StFeed) this.f85017h, r0());
            s1();
            QLog.d(getTAG(), 1, "set play rate:1.5");
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.J = (QFSVideoView) view.findViewById(R.id.f74163vi);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QCircleVideoRateEvent.class);
        eventClass.add(QCirclePanelStateEvent.class);
        return eventClass;
    }

    protected float h1() {
        RFWVideoView v3 = v();
        if (v3 != null) {
            return v3.getPlayRate();
        }
        return 1.0f;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: m1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        this.I = QCirclePluginGlobalInfo.t(feedCloudMeta$StFeed.f398449id.get());
        this.L = l1();
    }

    protected void n1() {
        if (!this.L) {
            return;
        }
        this.M = false;
        r1(this.I);
        RFWVideoView v3 = v();
        if (v3 != null) {
            v3.setPlayRate(this.I);
        }
        p1(false);
        T0(new com.tencent.biz.qqcircle.immersive.feed.event.aa(h1()));
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onDestroy() {
        super.onDestroy();
        if (com.tencent.biz.qqcircle.utils.bz.k()) {
            n1();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedUnSelected(rFWFeedSelectInfo);
        n1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QCircleVideoRateEvent) {
            j1((QCircleVideoRateEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QCirclePanelStateEvent) {
            i1((QCirclePanelStateEvent) simpleBaseEvent);
        }
    }

    public void q(View view) {
        if (this.L) {
            if (this.M) {
                r1(2.0f);
                p1(true);
                T0(new com.tencent.biz.qqcircle.immersive.feed.event.aa(h1()));
                QLog.d(getTAG(), 1, "[onLongPressUP] lock 2x rate.");
                return;
            }
            p1(false);
            r1(this.I);
            T0(new com.tencent.biz.qqcircle.immersive.feed.event.aa(this.I));
        }
        o1(this.I);
        QLog.d("QFSPlayRateBasePresenter", 1, "reset play rate:" + this.I);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean q1() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = (FeedCloudMeta$StFeed) this.f85017h;
        if (feedCloudMeta$StFeed == null) {
            return false;
        }
        if (com.tencent.biz.qqcircle.immersive.utils.y.j(feedCloudMeta$StFeed) && feedCloudMeta$StFeed.images.size() <= 1) {
            return false;
        }
        return true;
    }

    RFWVideoView v() {
        QFSVideoView qFSVideoView = this.J;
        if (qFSVideoView != null) {
            return qFSVideoView;
        }
        b bVar = (b) u0(b.class);
        if (bVar != null) {
            return bVar.v();
        }
        return null;
    }

    public void w(View view) {
        o1(2.0f);
        s1();
        p1(false);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        throw null;
    }
}
