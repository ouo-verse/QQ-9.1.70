package com.tencent.biz.qqcircle.immersive.feed;

import android.view.View;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSRatePlayGestureEvent;
import com.tencent.biz.qqcircle.immersive.views.QFSSeekBar;
import com.tencent.biz.qqcircle.widgets.QCircleDoubleClickLayout;
import com.tencent.biz.qqcircle.widgets.QFSGestureDetectorView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.media.QUIPlayIconView;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class be extends dr implements SeekBar.OnSeekBarChangeListener {
    private QFSGestureDetectorView N;
    private QUIPlayIconView P;
    private QFSSeekBar Q;
    private QCircleDoubleClickLayout R;
    private boolean S = true;

    private void u1() {
        x0().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.bd
            @Override // java.lang.Runnable
            public final void run() {
                be.this.w1();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void v1() {
        if (this.N == null) {
            QLog.d(getTAG(), 1, "[changeGestureStatus] null");
            return;
        }
        if (y1()) {
            this.N.setVisibility(8);
            QLog.d(getTAG(), 1, "[changeGestureStatus] gone");
        } else {
            this.N.setVisibility(0);
            this.N.setFeed((FeedCloudMeta$StFeed) this.f85017h);
            QLog.d(getTAG(), 1, "[changeGestureStatus] VISIBLE");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w1() {
        View findViewById;
        try {
            View view = this.C;
            if (view != null && this.N != null) {
                View findViewById2 = view.findViewById(R.id.f40501ej);
                if (findViewById2 != null) {
                    this.N.h(findViewById2);
                }
                View findViewById3 = this.C.findViewById(R.id.f34460z8);
                if (findViewById3 != null) {
                    this.N.h(findViewById3);
                }
                View findViewById4 = this.C.findViewById(R.id.f40151dl);
                if (findViewById4 != null) {
                    this.N.h(findViewById4);
                }
                if (com.tencent.biz.qqcircle.utils.l.f("exp_tapshareandhold", "exp_tapshareandhold_B") && (findViewById = this.C.findViewById(R.id.f41401gz)) != null) {
                    this.N.h(findViewById);
                }
            }
        } catch (Exception e16) {
            QLog.d("QFSFeedChildVideoPlayRateGuestPresenter", 1, "adjust  view size error", e16);
        }
    }

    private void x1() {
        View findViewById = this.C.findViewById(R.id.f34460z8);
        if (findViewById != null) {
            this.N.h(findViewById);
        }
    }

    private boolean y1() {
        boolean z16 = false;
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_unable_qfs_gesture_detector_view", false) || QCircleDaTongConstant.PageId.PG_XSJ_QZEON_VIDEO_UGC_MID_PAG.equals(q0())) {
            z16 = true;
        }
        QLog.d(getTAG(), 1, "[notEnableGesture]:" + z16);
        return z16;
    }

    private void z1(boolean z16) {
        int i3;
        if (this.N != null && this.R != null) {
            QLog.d(getTAG(), 1, "[setEnableRatePlayGesture] :" + z16);
            QFSGestureDetectorView qFSGestureDetectorView = this.N;
            int i16 = 0;
            if (z16 && !y1()) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            qFSGestureDetectorView.setVisibility(i3);
            QCircleDoubleClickLayout qCircleDoubleClickLayout = this.R;
            if (!z16) {
                i16 = 8;
            }
            qCircleDoubleClickLayout.setVisibility(i16);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        super.C0(hVar);
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.n) {
            x1();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.dr, com.tencent.biz.qqcircle.widgets.QFSRatePlayGestureDetectorView.b
    public void D(View view, boolean z16) {
        QFSRatePlayGestureEvent currentContextHaseCode;
        if (!q1()) {
            return;
        }
        if (!this.S) {
            QLog.d(getTAG(), 1, "[onYOrientationChange] not handle long press");
            return;
        }
        super.D(view, z16);
        if (z16) {
            currentContextHaseCode = new QFSRatePlayGestureEvent(3, 2.0f).setCurrentFeed((FeedCloudMeta$StFeed) this.f85017h).setCurrentContextHaseCode(m0().hashCode());
        } else {
            currentContextHaseCode = new QFSRatePlayGestureEvent(4, 1.5f).setCurrentFeed((FeedCloudMeta$StFeed) this.f85017h).setCurrentContextHaseCode(m0().hashCode());
        }
        currentContextHaseCode.setIsHitLockRate(this.L);
        SimpleEventBus.getInstance().dispatchEvent(currentContextHaseCode);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.dr, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        QFSGestureDetectorView qFSGestureDetectorView = (QFSGestureDetectorView) view.findViewById(R.id.f45131r2);
        this.N = qFSGestureDetectorView;
        qFSGestureDetectorView.setYOrientationChangeListener(this);
        this.N.setRatePlayLongPressListener(this);
        this.P = (QUIPlayIconView) view.findViewById(R.id.va5);
        this.Q = (QFSSeekBar) view.findViewById(R.id.vad);
        this.R = (QCircleDoubleClickLayout) view.findViewById(R.id.v_o);
        this.Q.z(this);
        v1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.dr, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: m1 */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        v1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.dr, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onDestroy() {
        super.onDestroy();
        QFSSeekBar qFSSeekBar = this.Q;
        if (qFSSeekBar == null) {
            return;
        }
        qFSSeekBar.U(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        if (!J0()) {
            return;
        }
        v1();
        SimpleEventBus.getInstance().dispatchEvent(new QFSRatePlayGestureEvent(1, this.I).setCurrentFeed((FeedCloudMeta$StFeed) this.f85017h).setCurrentContextHaseCode(m0().hashCode()));
        u1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.dr, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedUnSelected(rFWFeedSelectInfo);
        if (!J0()) {
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new QFSRatePlayGestureEvent(1, this.I).setCurrentFeed((FeedCloudMeta$StFeed) this.f85017h).setCurrentContextHaseCode(m0().hashCode()));
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        z1(false);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
        z1(true);
        EventCollector.getInstance().onStopTrackingTouch(seekBar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.dr, com.tencent.biz.qqcircle.widgets.QFSRatePlayGestureDetectorView.a
    public void q(View view) {
        if (!this.S) {
            QLog.d(getTAG(), 1, "[onLongPressUP] not handle long press");
            return;
        }
        QLog.d(getTAG(), 1, "[onLongPressUP] receive");
        super.q(view);
        QFSSeekBar qFSSeekBar = this.Q;
        if (qFSSeekBar != null) {
            qFSSeekBar.setEnabled(true);
        }
        SimpleEventBus.getInstance().dispatchEvent(new QFSRatePlayGestureEvent(1, this.I).setCurrentFeed((FeedCloudMeta$StFeed) this.f85017h).setCurrentContextHaseCode(m0().hashCode()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.dr, com.tencent.biz.qqcircle.widgets.QFSRatePlayGestureDetectorView.a
    public void w(View view) {
        float f16;
        T t16 = this.f85017h;
        if (t16 != 0 && !com.tencent.biz.qqcircle.immersive.repository.foldertab.j.g((FeedCloudMeta$StFeed) t16)) {
            QLog.d(getTAG(), 1, "[onLongPress] receive");
            this.S = true;
            super.w(view);
            if (!q1()) {
                f16 = 1.0f;
            } else {
                f16 = 2.0f;
            }
            QFSRatePlayGestureEvent currentContextHaseCode = new QFSRatePlayGestureEvent(0, f16).setCurrentFeed((FeedCloudMeta$StFeed) this.f85017h).setCurrentContextHaseCode(m0().hashCode());
            currentContextHaseCode.setIsHitLockRate(this.L);
            SimpleEventBus.getInstance().dispatchEvent(currentContextHaseCode);
            QUIPlayIconView qUIPlayIconView = this.P;
            if (qUIPlayIconView != null) {
                qUIPlayIconView.setVisibility(8);
            }
            QFSSeekBar qFSSeekBar = this.Q;
            if (qFSSeekBar != null) {
                qFSSeekBar.W();
                this.Q.setEnabled(false);
                return;
            }
            return;
        }
        this.S = false;
        QLog.d(getTAG(), 1, "[onLongPress] not handle long press, mData is null or simple feed.");
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.dr, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildVideoPlayRateGuestPresenter";
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
    }
}
