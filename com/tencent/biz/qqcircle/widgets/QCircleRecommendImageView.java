package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.PopupWindow;
import androidx.annotation.Nullable;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.events.QCircleHostPushClickEvent;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.events.QCirclePushAnimationEvent;
import com.tencent.biz.qqcircle.events.QCirclePushAnimationStateEvent;
import com.tencent.biz.qqcircle.events.QCirclePushUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleUndoPushUpdateEvent;
import com.tencent.biz.qqcircle.events.QFSPushParabolaAnimEvent;
import com.tencent.biz.qqcircle.events.QFSPushTenTimesEvent;
import com.tencent.biz.qqcircle.immersive.feed.cf;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.manager.diffres.QCircleChangeResEngine;
import com.tencent.biz.qqcircle.manager.diffres.beans.QCirclePushButtonResPackage;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.push.QFSOverPushView;
import com.tencent.biz.qqcircle.requests.QCircleDoRecommendRequest;
import com.tencent.biz.qqcircle.richframework.sender.iml.QCircleRequestCall;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.utils.ce;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.call.Call;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import da0.b;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StPushList;
import feedcloud.FeedCloudWrite$StDoPushRsp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import qqcircle.QQCircleFeedBase$StFeedBusiReqData;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleRecommendImageView extends FrameAnimationView implements SimpleEventReceiver, Call.OnRspCallBack, b.a {
    private int C;
    private long D;
    private long E;
    private boolean F;
    private Timer G;
    private boolean H;
    private int I;
    private int J;
    private int K;
    private int L;
    private boolean M;
    private db0.d N;
    private int P;
    private int Q;
    private int R;
    private int S;
    private d T;
    private e U;
    private f V;
    private boolean W;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f93082a0;

    /* renamed from: b0, reason: collision with root package name */
    private com.tencent.biz.qqcircle.push.d f93083b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f93084c0;

    /* renamed from: d0, reason: collision with root package name */
    private int f93085d0;

    /* renamed from: e, reason: collision with root package name */
    private int f93086e;

    /* renamed from: e0, reason: collision with root package name */
    private int f93087e0;

    /* renamed from: f, reason: collision with root package name */
    private int f93088f;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f93089f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f93090g0;

    /* renamed from: h, reason: collision with root package name */
    private int f93091h;

    /* renamed from: i, reason: collision with root package name */
    private FeedCloudMeta$StFeed f93092i;

    /* renamed from: m, reason: collision with root package name */
    private FeedCloudMeta$StPushList f93093m;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private static class LongPressTimerTask extends TimerTask {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QCircleRecommendImageView> f93095d;

        /* renamed from: e, reason: collision with root package name */
        private int f93096e;

        /* JADX INFO: Access modifiers changed from: private */
        public void d(QCircleRecommendImageView qCircleRecommendImageView) {
            QLog.d("QCircleRecommend_", 1, "handleLongPressType:" + this.f93096e);
            int i3 = this.f93096e;
            if (i3 == 1) {
                if (com.tencent.biz.qqcircle.l.b() || qCircleRecommendImageView.f93090g0) {
                    qCircleRecommendImageView.d0(false);
                }
                qCircleRecommendImageView.A(1, QCircleDaTongConstant.ElementParamValue.LONG_PRESS, 5);
                ce.e(true, qCircleRecommendImageView.getParent());
                return;
            }
            if (i3 == 2) {
                if (com.tencent.biz.qqcircle.l.b() || qCircleRecommendImageView.f93090g0) {
                    qCircleRecommendImageView.h0();
                    qCircleRecommendImageView.e0();
                } else {
                    qCircleRecommendImageView.c0(true, true);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e() {
            QCircleRecommendImageView qCircleRecommendImageView;
            if (this.f93096e != 0 || (qCircleRecommendImageView = this.f93095d.get()) == null) {
                return;
            }
            if (qCircleRecommendImageView.f93088f != 0 && qCircleRecommendImageView.H && !qCircleRecommendImageView.N() && !qCircleRecommendImageView.M()) {
                this.f93096e = 2;
            } else {
                this.f93096e = 1;
            }
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView.LongPressTimerTask.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        LongPressTimerTask.this.e();
                        QCircleRecommendImageView qCircleRecommendImageView = (QCircleRecommendImageView) LongPressTimerTask.this.f93095d.get();
                        if (qCircleRecommendImageView != null) {
                            LongPressTimerTask.this.d(qCircleRecommendImageView);
                        }
                    } catch (Exception e16) {
                        QLog.e("QCircleRecommend_", 1, e16.getMessage());
                        e16.printStackTrace();
                    } catch (OutOfMemoryError e17) {
                        QLog.e("QCircleRecommend_", 1, e17.getMessage());
                        e17.printStackTrace();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a extends View.AccessibilityDelegate {
        a() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            boolean z16 = true;
            accessibilityNodeInfo.setCheckable(true);
            if (QCircleRecommendImageView.this.E() <= 0) {
                z16 = false;
            }
            accessibilityNodeInfo.setChecked(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements QFSOverPushView.b {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.push.QFSOverPushView.b
        public void a(boolean z16, int i3, int i16) {
            if (i16 == 0) {
                QCircleRecommendImageView.this.I(i3);
            } else if (i16 == 8) {
                QCircleRecommendImageView.this.y(true);
            } else {
                QCircleRecommendImageView.this.z(i3, i16);
            }
            QCircleRecommendImageView.this.f93082a0 = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c implements QFSOverPushView.b {
        c() {
        }

        @Override // com.tencent.biz.qqcircle.push.QFSOverPushView.b
        public void a(boolean z16, int i3, int i16) {
            if (i16 == 0) {
                QCircleRecommendImageView.this.I(i3);
            } else if (i16 == 8) {
                QCircleRecommendImageView.this.y(true);
            } else {
                QCircleRecommendImageView.this.z(i3, i16);
            }
            QCircleRecommendImageView.this.f93082a0 = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface d {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface e {
        void a();

        void b(com.tencent.biz.qqcircle.push.a aVar);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface f {
        boolean a();
    }

    public QCircleRecommendImageView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(int i3, String str, int i16) {
        int t16 = com.tencent.biz.qqcircle.f.v().t();
        QLog.d("QCircleRecommend_", 1, "doPreConsumeWithAnimation currentFuelCount:" + t16 + " consumeCount:" + i3 + " clickType:" + str + " mPendingPushTimes:" + this.f93088f + " mMaxPushCount:" + this.f93084c0 + " mCurrentPushTimes:" + this.f93086e);
        if (com.tencent.biz.qqcircle.l.b() || this.f93090g0) {
            t16 = this.f93087e0;
        }
        if (t16 < i3) {
            h0();
            if (str.equals(QCircleDaTongConstant.ElementParamValue.TEN_PUSH_CLICK) || str.equals(QCircleDaTongConstant.ElementParamValue.PUSH_V3)) {
                T();
            }
        } else if (this.f93088f + i3 <= this.f93084c0) {
            if (a0() && this.f93088f == 0) {
                cf.b().f();
            }
            this.f93088f += i3;
            if (i3 == 1) {
                this.f93091h++;
            } else if (!com.tencent.biz.qqcircle.l.b() && !this.f93090g0) {
                this.f93091h = this.f93088f;
            } else {
                this.f93091h = i3;
            }
            j0(this.f93088f);
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f93092i;
            if (feedCloudMeta$StFeed != null && !TextUtils.isEmpty(feedCloudMeta$StFeed.f398449id.get())) {
                U(i16);
                W(str, i3);
            }
            com.tencent.biz.qqcircle.f.v().R(t16 - i3);
            this.f93087e0 -= i3;
        } else {
            this.M = true;
            QLog.e(B(), 1, "consume over MAX_PUSH_TIME");
            h0();
            x();
        }
        V();
    }

    private String B() {
        if (this.f93092i != null) {
            return "QCircleRecommend_id:" + this.f93092i.f398449id.get();
        }
        return "QCircleRecommend_";
    }

    private String D(int i3) {
        if (i3 == this.f93084c0) {
            return getResources().getString(R.string.f194364bp, Integer.valueOf(this.f93084c0));
        }
        int i16 = this.f93088f;
        if (i16 == i3) {
            return getResources().getString(R.string.f194354bo, Integer.valueOf(this.f93088f));
        }
        if (i16 > i3) {
            return getResources().getString(R.string.f194344bn, Integer.valueOf(i3));
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int E() {
        FeedCloudMeta$StPushList feedCloudMeta$StPushList = this.f93093m;
        if (feedCloudMeta$StPushList == null) {
            return 0;
        }
        return feedCloudMeta$StPushList.hasClickCount.get();
    }

    private void G() {
        boolean z16;
        if (this.D - this.E > 400) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && this.f93086e >= 1 && !N()) {
            c0(true, true);
            return;
        }
        int i3 = this.f93088f;
        int i16 = this.f93084c0;
        if (i3 >= i16) {
            if (this.f93086e >= i16) {
                e0();
                return;
            } else {
                this.M = true;
                return;
            }
        }
        if (a0() && this.f93088f == 0) {
            cf.b().f();
        }
        int i17 = this.f93088f + 1;
        this.f93088f = i17;
        j0(i17);
        if (z16) {
            this.f93091h = 1;
            SimpleEventBus.getInstance().dispatchEvent(new QCirclePushAnimationEvent(C().f398449id.get(), 1, 1, this.C));
            this.f93089f0 = true;
        } else {
            this.f93091h++;
            SimpleEventBus.getInstance().dispatchEvent(new QCirclePushAnimationEvent(C().f398449id.get(), this.f93091h, 2, this.C));
            this.f93089f0 = true;
        }
        com.tencent.biz.qqcircle.f.v().R(com.tencent.biz.qqcircle.f.v().t() - 1);
        W("clck", 1);
        V();
    }

    private void H(QCircleHostPushClickEvent qCircleHostPushClickEvent) {
        if (qCircleHostPushClickEvent.isPush) {
            QLog.d(B(), 1, "host click: push");
            if (this.f93088f <= 1) {
                this.D = this.E + 400 + 1;
                G();
                return;
            }
            return;
        }
        QLog.d(B(), 1, "host click: cancel push");
        y(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(int i3) {
        if (com.tencent.biz.qqcircle.f.v().t() < i3 - this.f93088f) {
            T();
            if (com.tencent.biz.qqcircle.l.b()) {
                QCircleRequestCall b16 = com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b();
                db0.c cVar = new db0.c();
                cVar.d(true);
                b16.addReqInterceptor(cVar).addRequest(new QCircleDoRecommendRequest(this.f93092i, i3, this.f93093m, 0, QCirclePluginUtil.getQCircleInitBean(getContext()))).execute();
                com.tencent.biz.qqcircle.f.v().R(com.tencent.biz.qqcircle.f.v().t() + (this.f93088f - this.f93086e));
                this.f93088f = this.f93086e;
                this.f93091h = 0;
                j0(0);
                QLog.d("QCircleRecommend_", 1, "handleNoPush, rocketRunOut");
                return;
            }
            return;
        }
        QCircleToast.l(QCircleToast.f91645e, D(i3), 0, true, false);
    }

    private void J(QCirclePushAnimationStateEvent qCirclePushAnimationStateEvent) {
        if (qCirclePushAnimationStateEvent.mTargetFeedId.equals(this.f93092i.f398449id.get()) && qCirclePushAnimationStateEvent.mSceneType == this.C) {
            QLog.d(B(), 1, "mTargetFeedId:" + qCirclePushAnimationStateEvent.mTargetFeedId + "mPage" + qCirclePushAnimationStateEvent.mSceneType);
            if (this.M) {
                e0();
                this.M = false;
            }
            this.f93089f0 = false;
            postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView.2
                @Override // java.lang.Runnable
                public void run() {
                    QCircleRecommendImageView.this.setVisibility(0);
                    QCircleRecommendImageView qCircleRecommendImageView = QCircleRecommendImageView.this;
                    qCircleRecommendImageView.j0(qCircleRecommendImageView.f93088f);
                }
            }, 250L);
        }
    }

    private void K(Context context, @Nullable AttributeSet attributeSet, int i3) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, y91.a.F5, i3, 0);
        this.P = obtainStyledAttributes.getResourceId(y91.a.G5, -1);
        this.Q = obtainStyledAttributes.getResourceId(y91.a.K5, R.drawable.orp);
        this.R = obtainStyledAttributes.getResourceId(y91.a.J5, R.drawable.opx);
        this.S = obtainStyledAttributes.getResourceId(y91.a.H5, R.drawable.opx);
        this.C = obtainStyledAttributes.getInteger(y91.a.I5, -1);
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean M() {
        int i3;
        if (com.tencent.biz.qqcircle.l.b() && (i3 = this.f93088f) != 0 && i3 < this.f93084c0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean N() {
        if (this.f93088f != this.f93086e) {
            return true;
        }
        return false;
    }

    private boolean O() {
        if (!uq3.o.Y1("qqcircle_enable_cancel_push_gesture_optimize_9155", true) || !N()) {
            return false;
        }
        return this.f93089f0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P() {
        int dimension = (int) getContext().getResources().getDimension(R.dimen.d1p);
        QCirclePluginUtil.expandViewTouchDelegate(this, dimension, dimension, dimension, dimension);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q() {
        this.f93083b0 = null;
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R() {
        this.f93083b0 = null;
        setVisibility(0);
        ce.e(false, getParent());
    }

    private void U(int i3) {
        int i16 = 3;
        if (i3 == 3) {
            return;
        }
        if (i3 == 9) {
            i16 = 4;
        } else if (i3 == 10) {
            i16 = 5;
        }
        SimpleEventBus.getInstance().dispatchEvent(new QCirclePushAnimationEvent(this.f93092i.f398449id.get(), this.f93091h, i16, this.C));
        this.f93089f0 = true;
    }

    private void V() {
        if (this.f93088f >= this.f93084c0) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSPushTenTimesEvent(C()));
        }
    }

    private void W(String str, int i3) {
        if (this.f93092i != null && this.f93093m != null) {
            QCircleDoRecommendRequest qCircleDoRecommendRequest = new QCircleDoRecommendRequest(this.f93092i, i3, this.f93093m, 0, QCirclePluginUtil.getQCircleInitBean(getContext()));
            db0.d dVar = this.N;
            if (dVar != null) {
                dVar.k(str);
                com.tencent.biz.qqcircle.push.d dVar2 = this.f93083b0;
                if (dVar2 != null) {
                    this.N.m(dVar2.e());
                }
            }
            QCircleRequestCall b16 = com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b();
            f fVar = this.V;
            if (fVar == null || fVar.a()) {
                db0.c cVar = new db0.c();
                cVar.e(this.f93085d0);
                b16.addReqInterceptor(cVar);
                this.f93085d0 = 0;
            }
            b16.addReqInterceptor(this.N).addRspInterceptor(new eb0.c()).m250setRspOnCallBack((Call.OnRspCallBack) this).addRequest(qCircleDoRecommendRequest).execute();
        }
    }

    private void X() {
        fa0.d e16 = F().e();
        QCirclePushButtonResPackage qCirclePushButtonResPackage = (QCirclePushButtonResPackage) e16.o();
        if (qCirclePushButtonResPackage.isDefaultRes) {
            com.tencent.biz.qqcircle.immersive.manager.d c16 = com.tencent.biz.qqcircle.immersive.manager.d.c();
            int i3 = this.S;
            if (i3 == -1) {
                i3 = R.drawable.opx;
            }
            setImageDrawable(c16.d(i3));
            return;
        }
        e16.g(qCirclePushButtonResPackage.iconRes, "maxPushedIcon.png", this);
    }

    private void Y() {
        fa0.d e16 = F().e();
        QCirclePushButtonResPackage qCirclePushButtonResPackage = (QCirclePushButtonResPackage) e16.o();
        if (qCirclePushButtonResPackage.isDefaultRes) {
            com.tencent.biz.qqcircle.immersive.manager.d c16 = com.tencent.biz.qqcircle.immersive.manager.d.c();
            int i3 = this.R;
            if (i3 == -1) {
                i3 = R.drawable.opx;
            }
            setImageDrawable(c16.d(i3));
            return;
        }
        e16.g(qCirclePushButtonResPackage.iconRes, "pushedIcon.png", this);
    }

    private void Z() {
        fa0.d e16 = F().e();
        QCirclePushButtonResPackage qCirclePushButtonResPackage = (QCirclePushButtonResPackage) e16.o();
        if (qCirclePushButtonResPackage.isDefaultRes) {
            if (this.Q != -1) {
                setImageDrawable(QCircleSkinHelper.getInstance().getDrawable(this.Q));
                return;
            }
            return;
        }
        e16.g(qCirclePushButtonResPackage.iconRes, "unPushIcon.png", this);
    }

    private void b0(final String str) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView.3
            @Override // java.lang.Runnable
            public void run() {
                if (!HostNetworkUtils.isNetworkAvailable()) {
                    QCircleToast.l(QCircleToast.f91645e, QCircleRecommendImageView.this.getContext().getResources().getString(R.string.f181603e8), 0, true, false);
                } else {
                    QCircleToast.l(QCircleToast.f91645e, str, 0, true, false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(boolean z16, boolean z17) {
        h0();
        if ((this.f93090g0 && !z16) || this.f93082a0) {
            return;
        }
        com.tencent.biz.qqcircle.push.d dVar = new com.tencent.biz.qqcircle.push.d(getContext(), z16);
        this.f93083b0 = dVar;
        dVar.l(new b());
        this.f93083b0.m(this.f93088f);
        this.f93083b0.c(this.f93092i);
        this.f93083b0.o(this);
        this.f93083b0.p(z16);
        this.f93083b0.r(this);
        this.f93083b0.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.tencent.biz.qqcircle.widgets.r
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                QCircleRecommendImageView.this.Q();
            }
        });
        if (!this.f93090g0) {
            setVisibility(8);
        }
        this.f93082a0 = true;
        e eVar = this.U;
        if (eVar != null) {
            eVar.a();
        }
        if (z17) {
            x();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(boolean z16) {
        if (this.f93090g0 && !z16) {
            QLog.d("QCircleRecommend_", 1, "simpleMode and is not cancel");
            return;
        }
        if (!this.f93082a0 && this.F) {
            if (!isShown()) {
                QLog.d(B(), 1, "[showPopupWindowForV5] is not shown, return.");
                return;
            }
            if (z16 && O()) {
                QLog.d(B(), 1, "[showPopupWindowForV5] anim is showing, return.");
                return;
            }
            com.tencent.biz.qqcircle.push.d dVar = new com.tencent.biz.qqcircle.push.d(getContext(), z16);
            this.f93083b0 = dVar;
            dVar.l(new c());
            this.f93083b0.m(this.f93088f);
            this.f93083b0.c(this.f93092i);
            this.f93083b0.p(z16);
            this.f93083b0.n(z16);
            this.f93083b0.q(this.f93087e0);
            this.f93083b0.o(this);
            this.f93083b0.s(this, this.f93090g0);
            this.f93083b0.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.tencent.biz.qqcircle.widgets.s
                @Override // android.widget.PopupWindow.OnDismissListener
                public final void onDismiss() {
                    QCircleRecommendImageView.this.R();
                }
            });
            if (!this.f93090g0) {
                setVisibility(8);
            }
            this.f93082a0 = true;
            e eVar = this.U;
            if (eVar != null) {
                eVar.a();
            }
            ce.e(true, getParent());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0() {
        if (this.f93088f < this.f93084c0) {
            T();
        } else {
            QCircleToast.l(QCircleToast.f91645e, getResources().getString(R.string.f183753k1, Integer.valueOf(this.f93084c0)), 0, true, false);
        }
    }

    private void f0(int i3) {
        setPadding(this.I, this.J, this.K, this.L);
        try {
            if (i3 >= this.f93084c0) {
                X();
            } else {
                Y();
            }
            if (this.P != -1) {
                setBackgroundDrawable(QCircleSkinHelper.getInstance().getDrawable(this.P));
            }
        } catch (Exception unused) {
            QLog.e(B(), 1, "showRecommendView setBackgroundDrawable error");
        }
    }

    private void g0() {
        setPadding(this.I, this.J, this.K, this.L);
        try {
            if (this.P != -1) {
                setBackgroundDrawable(QCircleSkinHelper.getInstance().getDrawable(this.P));
            }
            Z();
        } catch (Exception unused) {
            QLog.e(B(), 1, "showUnRecommendView setBackgroundDrawable error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0() {
        Timer timer = this.G;
        if (timer != null) {
            timer.cancel();
            this.G.purge();
        }
        SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(30, this.f93092i.f398449id.get(), false));
    }

    private void i0(int i3) {
        QQCircleFeedBase$StFeedBusiReqData qQCircleFeedBase$StFeedBusiReqData = new QQCircleFeedBase$StFeedBusiReqData();
        try {
            qQCircleFeedBase$StFeedBusiReqData.mergeFrom(this.f93092i.busiData.get().toByteArray());
            if (qQCircleFeedBase$StFeedBusiReqData.pushList != null) {
                j0(i3);
                this.f93086e = i3;
                this.f93088f = i3;
                QLog.d(B(), 1, "hasLikeCount" + this.f93086e);
                com.tencent.biz.qqcircle.utils.ac.d(qQCircleFeedBase$StFeedBusiReqData.pushList, i3);
                this.f93093m = qQCircleFeedBase$StFeedBusiReqData.pushList;
                this.f93092i.busiData.set(ByteStringMicro.copyFrom(qQCircleFeedBase$StFeedBusiReqData.toByteArray()));
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        } catch (Exception e17) {
            QLog.e(B(), 1, "receiveEvent error" + e17.getMessage());
            e17.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0(int i3) {
        if (i3 > 0) {
            f0(i3);
        } else {
            g0();
        }
    }

    private void v() {
        setImportantForAccessibility(1);
        setClickable(true);
        setAccessibilityDelegate(new a());
    }

    private void w() {
        com.tencent.biz.qqcircle.push.d dVar;
        if (bz.t() && (dVar = this.f93083b0) != null && dVar.isShowing()) {
            this.f93083b0.dismiss();
            QLog.d("QCircleRecommend_", 1, "dismiss popWindow.");
        }
    }

    private void x() {
        String str;
        int i3;
        if ((com.tencent.biz.qqcircle.l.b() || (this.f93092i != null && this.f93086e == 0)) && this.f93088f != 0 && this.f93091h != 0) {
            getLocationInWindow(r1);
            int[] iArr = {iArr[0] + (getWidth() / 2), iArr[1] - (getHeight() / 2)};
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f93092i;
            if (feedCloudMeta$StFeed != null) {
                str = feedCloudMeta$StFeed.f398449id.get();
            } else {
                str = "";
            }
            QFSPushParabolaAnimEvent qFSPushParabolaAnimEvent = new QFSPushParabolaAnimEvent(str);
            if (this.f93088f >= 10) {
                i3 = 6;
            } else {
                i3 = 5;
            }
            qFSPushParabolaAnimEvent.setPushType(i3);
            qFSPushParabolaAnimEvent.setPushIconLocation(iArr[0], iArr[1]);
            if (com.tencent.biz.qqcircle.l.b()) {
                qFSPushParabolaAnimEvent.setHasPushCount(this.f93088f);
            }
            SimpleEventBus.getInstance().dispatchEvent(qFSPushParabolaAnimEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z16) {
        db0.d dVar = this.N;
        if (dVar != null) {
            dVar.k(QCircleDaTongConstant.ElementParamValue.LONG_PRESS_CANCEL);
            this.N.n(z16);
            com.tencent.biz.qqcircle.push.d dVar2 = this.f93083b0;
            if (dVar2 != null) {
                this.N.m(dVar2.e());
            }
        }
        QCirclePushInfoManager.e().m(this.f93092i, this.N, 1);
        this.f93091h = 0;
        this.f93088f = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i3, int i16) {
        int i17;
        QLog.d("QCircleRecommend_", 1, "doOverPush" + i3);
        if (i3 == 0) {
            return;
        }
        if (!com.tencent.biz.qqcircle.l.b() && !this.f93090g0) {
            if (com.tencent.biz.qqcircle.l.a() && i3 != this.f93084c0) {
                i17 = i3;
            } else {
                i17 = i3 - this.f93088f;
            }
        } else {
            int i18 = this.f93086e;
            this.f93088f = i18;
            int i19 = i18 + i3;
            int i26 = this.f93084c0;
            if (i19 > i26) {
                i17 = i26 - i18;
            } else {
                i17 = i3;
            }
            this.f93091h = 0;
            this.f93085d0 = i17;
        }
        if (i17 >= 1) {
            A(i17, QCircleDaTongConstant.ElementParamValue.PUSH_V3, i16);
            x();
            if (com.tencent.biz.qqcircle.l.b()) {
                this.f93091h = 0;
            }
        }
        if (this.U != null && i16 == 3) {
            com.tencent.biz.qqcircle.push.a aVar = new com.tencent.biz.qqcircle.push.a();
            aVar.d(3);
            aVar.h(i3);
            this.U.b(aVar);
        }
    }

    public FeedCloudMeta$StFeed C() {
        return this.f93092i;
    }

    public da0.b F() {
        return QCircleChangeResEngine.INSTANCE.getResManager(QCirclePushButtonResPackage.class);
    }

    protected void L() {
        this.I = getPaddingLeft();
        this.J = getPaddingTop();
        this.K = getPaddingRight();
        this.L = getPaddingBottom();
        g0();
        F().o(this);
    }

    protected void S() {
        j0(E());
        this.f93091h = 0;
        this.f93089f0 = false;
    }

    public void T() {
        d dVar = this.T;
        if (dVar == null) {
            return;
        }
        dVar.a();
    }

    @Override // da0.b.a
    public void a(fa0.d dVar) {
        j0(this.f93086e);
    }

    public boolean a0() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        FeedCloudMeta$StPushList feedCloudMeta$StPushList = this.f93093m;
        if (feedCloudMeta$StPushList != null && feedCloudMeta$StPushList.totalClickCount.get() == 0 && (feedCloudMeta$StFeed = this.f93092i) != null && !QCirclePluginUtil.isFeedOwner(feedCloudMeta$StFeed)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCirclePushAnimationStateEvent.class);
        arrayList.add(QCirclePushUpdateEvent.class);
        arrayList.add(QCircleUndoPushUpdateEvent.class);
        arrayList.add(QCircleHostPushClickEvent.class);
        return arrayList;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        QCircleChangeResEngine.INSTANCE.onTurnPage();
        S();
        F().l(this);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.FrameAnimationView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        F().m(this);
        com.tencent.biz.qqcircle.push.d dVar = this.f93083b0;
        if (dVar != null && dVar.isShowing()) {
            this.f93083b0.dismiss();
        }
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_push_view_not_unregister_event_receiver", true)) {
            return;
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.richframework.sender.call.Call.OnRspCallBack
    public void onReceive(boolean z16, long j3, String str, Object obj, Object obj2, Bundle bundle) {
        String str2;
        if (!z16) {
            this.f93088f = this.f93086e;
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView.4
                @Override // java.lang.Runnable
                public void run() {
                    QCircleRecommendImageView qCircleRecommendImageView = QCircleRecommendImageView.this;
                    qCircleRecommendImageView.j0(qCircleRecommendImageView.f93086e);
                }
            });
        }
        com.tencent.biz.qqcircle.push.d dVar = this.f93083b0;
        if (dVar != null && dVar.isShowing()) {
            this.f93083b0.dismiss();
        }
        if ((obj instanceof QCircleDoRecommendRequest) && (obj2 instanceof FeedCloudWrite$StDoPushRsp)) {
            QCircleDoRecommendRequest qCircleDoRecommendRequest = (QCircleDoRecommendRequest) obj;
            if (qCircleDoRecommendRequest.getReq() != null && this.f93092i != null && qCircleDoRecommendRequest.getReq().feed.f398449id.get().equals(this.f93092i.f398449id.get())) {
                FeedCloudWrite$StDoPushRsp feedCloudWrite$StDoPushRsp = (FeedCloudWrite$StDoPushRsp) obj2;
                if (j3 == 0) {
                    com.tencent.biz.qqcircle.f.v().R(feedCloudWrite$StDoPushRsp.myFuel.get());
                    QLog.d(B(), 1, "req traceId:" + qCircleDoRecommendRequest.getTraceId());
                    QLog.d(B(), 1, "QCircleDoRecommendRequest push success myFuel:" + feedCloudWrite$StDoPushRsp.myFuel.get() + "consumeFuel" + feedCloudWrite$StDoPushRsp.consumeFuel.get());
                } else if (j3 == 700207) {
                    QLog.d(B(), 1, "CW_HAVE_PUSH_MAX_CNT");
                    e0();
                } else if (j3 == 700202) {
                    T();
                } else {
                    QLog.d(B(), 1, "net_error" + j3);
                    b0(str);
                }
                j0(E());
                this.f93088f = this.f93086e;
                FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f93092i;
                if (feedCloudMeta$StFeed == null) {
                    str2 = "";
                } else {
                    str2 = feedCloudMeta$StFeed.f398449id.get();
                }
                com.tencent.biz.qqcircle.immersive.utils.ar.a(getContext(), this, feedCloudWrite$StDoPushRsp.push_broke_toast.get(), str2);
                return;
            }
            QLog.d("QCircleRecommend_", 1, "unExceptOnReceive");
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent.mHashCode != hashCode() && this.f93092i != null) {
            if (simpleBaseEvent instanceof QCirclePushAnimationStateEvent) {
                J((QCirclePushAnimationStateEvent) simpleBaseEvent);
            }
            if (simpleBaseEvent instanceof QCirclePushUpdateEvent) {
                QCirclePushUpdateEvent qCirclePushUpdateEvent = (QCirclePushUpdateEvent) simpleBaseEvent;
                if (qCirclePushUpdateEvent.mTargetFeedId.equals(this.f93092i.f398449id.get())) {
                    QLog.d(B(), 1, "updateFeedPushInfo");
                    i0(qCirclePushUpdateEvent.mAllPushTimes);
                }
            }
            if ((simpleBaseEvent instanceof QCircleUndoPushUpdateEvent) && ((QCircleUndoPushUpdateEvent) simpleBaseEvent).mTargetFeedId.equals(this.f93092i.f398449id.get())) {
                i0(0);
                this.f93091h = 0;
            }
            if (simpleBaseEvent instanceof QCircleHostPushClickEvent) {
                QCircleHostPushClickEvent qCircleHostPushClickEvent = (QCircleHostPushClickEvent) simpleBaseEvent;
                if (qCircleHostPushClickEvent.mTargetFeedId.equals(this.f93092i.f398449id.get()) && getRootView() != null && qCircleHostPushClickEvent.mHashCode == getRootView().hashCode()) {
                    H(qCircleHostPushClickEvent);
                    return;
                }
                return;
            }
            return;
        }
        QLog.d(B(), 1, "receive event sent by self or feed is null");
    }

    public void onStop() {
        w();
    }

    public void setEnableCancelPush(boolean z16) {
        this.H = z16;
    }

    public void setFeedData(e30.b bVar, int i3) {
        FeedCloudMeta$StFeed g16;
        this.f93084c0 = com.tencent.biz.qqcircle.l.c();
        if (bVar == null) {
            g16 = null;
        } else {
            g16 = bVar.g();
        }
        if (g16 != null && g16.busiData.get() != null) {
            this.C = i3;
            this.f93092i = g16;
            try {
                QQCircleFeedBase$StFeedBusiReqData qQCircleFeedBase$StFeedBusiReqData = (QQCircleFeedBase$StFeedBusiReqData) bVar.b("DITTO_FEED_BUSI_REQ_DATA");
                if (qQCircleFeedBase$StFeedBusiReqData == null) {
                    qQCircleFeedBase$StFeedBusiReqData = new QQCircleFeedBase$StFeedBusiReqData();
                    qQCircleFeedBase$StFeedBusiReqData.mergeFrom(g16.busiData.get().toByteArray());
                }
                FeedCloudMeta$StPushList feedCloudMeta$StPushList = qQCircleFeedBase$StFeedBusiReqData.pushList;
                this.f93093m = feedCloudMeta$StPushList;
                if (feedCloudMeta$StPushList != null) {
                    QCirclePushInfoManager.e().p(g16.f398449id.get(), this.f93093m);
                    int i16 = this.f93093m.hasClickCount.get();
                    this.f93086e = i16;
                    this.f93088f = i16;
                    QLog.d(B(), 1, "hashCode" + hashCode() + "feedId:" + this.f93092i.f398449id.get() + "  hasClickCount" + this.f93086e);
                }
            } catch (Exception e16) {
                QLog.e("QCircleRecommend_", 1, e16, new Object[0]);
            }
            j0(this.f93086e);
        }
    }

    public void setMaxPushedIconId(int i3) {
        this.S = i3;
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        boolean z16;
        super.setOnClickListener(onClickListener);
        if (onClickListener != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.W = z16;
    }

    public void setOnPushBtnClickDelegate(f fVar) {
        this.V = fVar;
    }

    public void setOverPushListener(e eVar) {
        this.U = eVar;
    }

    public void setPageType(int i3) {
        this.C = i3;
    }

    public void setPushReportReqInterceptor(db0.d dVar) {
        this.N = dVar;
    }

    public void setPushedIconId(int i3) {
        this.R = i3;
    }

    public void setRecommendViewActionListener(d dVar) {
        this.T = dVar;
    }

    public void setSinglePush(boolean z16) {
        this.f93090g0 = z16;
    }

    public void setUnPushIconId(int i3) {
        this.Q = i3;
    }

    public QCircleRecommendImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QCircleRecommendImageView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.F = false;
        this.H = false;
        this.M = false;
        this.P = -1;
        this.Q = -1;
        this.R = -1;
        this.S = -1;
        this.W = false;
        this.f93082a0 = false;
        this.f93084c0 = 10;
        this.f93089f0 = false;
        this.f93090g0 = false;
        K(context, attributeSet, i3);
        L();
        v();
        post(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.q
            @Override // java.lang.Runnable
            public final void run() {
                QCircleRecommendImageView.this.P();
            }
        });
    }
}
