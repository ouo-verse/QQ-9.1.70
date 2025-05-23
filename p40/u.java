package p40;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.av.utils.PhoneStatusMonitor;
import com.tencent.avbiz.Constants;
import com.tencent.avbiz.b;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QFSTransitionAnimBean;
import com.tencent.biz.qqcircle.immersive.floatingwindow.event.QFSFloatingWindowReleaseEvent;
import com.tencent.biz.qqcircle.immersive.floatingwindow.model.QFSSmallWindowGlobalCollect;
import com.tencent.biz.qqcircle.immersive.floatingwindow.view.QFSFloatingVerticalView;
import com.tencent.biz.qqcircle.immersive.model.bottombarrage.QFSVideoPauseEvent;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSLayerFeedPosSyncEvent;
import com.tencent.biz.qqcircle.immersive.utils.ad;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.video.event.RFWMediaFocusChangeEvent;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qcircle.api.event.QFSSmallWindowScreenStateEvent;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qav.monitor.PhoneStatusAudioModeMonitor;
import com.tencent.qcircle.cooperation.config.AccountChangeEvent;
import com.tencent.qcircle.cooperation.config.AccountKickedEvent;
import com.tencent.qcircle.cooperation.config.AccountLoginOutEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.gallery.video.RFWLayerVideoPlayPosRecorder;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import p40.f;
import p40.u;
import qqcircle.QQCircleFeedBase$StFeedListBusiReqData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class u implements p40.a, bz3.b, SimpleEventReceiver, cz3.b, PhoneStatusMonitor.a, b.a, QFSSmallWindowGlobalCollect.b, QFSSmallWindowGlobalCollect.c {
    private static volatile u R;
    private BroadcastReceiver C;
    private boolean D;
    private com.tencent.qui.video.floatingview.operate.a E;
    private WeakReference<Activity> H;
    private PhoneStatusAudioModeMonitor I;
    private Runnable M;
    private com.tencent.qui.video.floatingview.e N;
    private Pair<String, Boolean> P;

    /* renamed from: e, reason: collision with root package name */
    private FeedCloudMeta$StFeed f425315e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f425316f;

    /* renamed from: h, reason: collision with root package name */
    private volatile QFSFloatingVerticalView f425317h;

    /* renamed from: i, reason: collision with root package name */
    private FrameLayout f425318i;

    /* renamed from: m, reason: collision with root package name */
    private BroadcastReceiver f425319m;

    /* renamed from: d, reason: collision with root package name */
    private String f425314d = "share";
    private int F = 0;
    private boolean G = false;
    private String J = "";
    private int K = -1;
    private Runnable L = null;
    private String Q = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends f.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f.d f425320a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f425321b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f425322c;

        a(f.d dVar, Activity activity, boolean z16) {
            this.f425320a = dVar;
            this.f425321b = activity;
            this.f425322c = z16;
        }

        @Override // p40.f.d
        public void a() {
            f.d dVar = this.f425320a;
            if (dVar != null) {
                dVar.a();
            }
        }

        @Override // p40.f.d
        public void b() {
            f.d dVar = this.f425320a;
            if (dVar != null) {
                dVar.b();
            }
        }

        @Override // p40.f.d, com.tencent.biz.richframework.animation.transition.TransitionManager.OnAnimEndListener
        public void onAnimEnd() {
            f.d dVar = this.f425320a;
            if (dVar != null) {
                dVar.onAnimEnd();
            }
            if (!u.this.y0(this.f425321b, this.f425322c)) {
                QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[openWithContentView] error");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class b extends BroadcastReceiver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(Intent intent) {
            u.H().r0(intent);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: p40.v
                @Override // java.lang.Runnable
                public final void run() {
                    u.b.b(intent);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class c extends BroadcastReceiver {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(Intent intent) {
            String action;
            if (intent == null) {
                action = null;
            } else {
                action = intent.getAction();
            }
            u.H().c0(action);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: p40.w
                @Override // java.lang.Runnable
                public final void run() {
                    u.c.b(intent);
                }
            });
        }
    }

    u() {
        SimpleEventBus.getInstance().registerReceiver(this);
        com.tencent.qui.video.floatingview.d.i().k(this);
        com.tencent.avbiz.b.a(this);
        QFSSmallWindowGlobalCollect.k().s(this);
        QFSSmallWindowGlobalCollect.k().t(this);
        A();
    }

    private void A() {
        if (this.M != null) {
            RFWThreadManager.getInstance().remove(this.M);
        }
        this.M = new Runnable() { // from class: p40.q
            @Override // java.lang.Runnable
            public final void run() {
                u.this.p0();
            }
        };
        RFWThreadManager.getInstance().execOnSubThread(this.M);
    }

    private void A0() {
        com.tencent.qui.video.floatingview.operate.a aVar = this.E;
        if (aVar == null) {
            return;
        }
        com.tencent.qui.video.floatingview.e c16 = aVar.c();
        com.tencent.qui.video.floatingview.e eVar = new com.tencent.qui.video.floatingview.e();
        this.N = eVar;
        eVar.j(c16.f());
        this.N.l(c16.e());
        this.N.g(c16.a());
        this.N.i(c16.b());
        this.N.h(c16.c());
    }

    private void B0() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f425315e;
        if (feedCloudMeta$StFeed != null) {
            this.J = feedCloudMeta$StFeed.f398449id.get();
        }
    }

    private FrameLayout C(Context context) {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(layoutParams);
        return frameLayout;
    }

    private QFSFloatingVerticalView D(Context context, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        QFSFloatingVerticalView qFSFloatingVerticalView = new QFSFloatingVerticalView(context);
        qFSFloatingVerticalView.h(this);
        qFSFloatingVerticalView.F(feedCloudMeta$StFeed);
        return qFSFloatingVerticalView;
    }

    private void D0() {
        boolean z16;
        com.tencent.qui.video.floatingview.e eVar = this.N;
        if (eVar != null && this.E != null && eVar.a()) {
            this.E.q();
            com.tencent.qui.video.floatingview.e c16 = this.E.c();
            boolean z17 = false;
            if (c16 != null && c16.b()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (c16 != null && c16.f()) {
                z17 = true;
            }
            QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[recoverCurrentFloatingWindowState] recover floating window, isMute: " + z16 + " | isPlaying: " + z17);
        }
    }

    private void E(FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str, boolean z16) {
        String str2;
        if (feedCloudMeta$StFeed != null) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.putAll(ua0.c.e(feedCloudMeta$StFeed));
            buildElementParams.put("xsj_custom_pgid", QCircleDaTongConstant.PageId.PG_XSJ_SMALL_WINDOW_PLAY_PAGE);
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SCENE, P());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TYPE, str);
            if (z16) {
                str2 = "auto";
            } else {
                str2 = QCircleDaTongConstant.ElementParamValue.MANUAL;
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_MANUAL, str2);
            buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_SMALL_WINDOW_OPERATE);
            VideoReport.setElementId(this.f425318i, QCircleDaTongConstant.ElementId.EM_XSJ_SMALL_WINDOW_OPERATE);
            VideoReport.setElementParams(this.f425318i, buildElementParams);
            VideoReport.reportEvent("ev_xsj_abnormal_clck", this.f425318i, buildElementParams);
        }
    }

    private void F(String str, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed != null) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.putAll(ua0.c.e(feedCloudMeta$StFeed));
            buildElementParams.put("xsj_custom_pgid", QCircleDaTongConstant.PageId.PG_XSJ_SMALL_WINDOW_PLAY_PAGE);
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SCENE, P());
            VideoReport.setElementId(this.f425318i, QCircleDaTongConstant.ElementId.EM_XSJ_SMALL_WINDOW_PLAY);
            VideoReport.setElementParams(this.f425318i, buildElementParams);
            VideoReport.reportEvent(str, this.f425318i, buildElementParams);
        }
    }

    private void F0(String str) {
        int b16 = r40.a.b(str);
        int a16 = r40.a.a(str);
        QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[sendInfluenceFloatWindow] businessName: " + str + " | type: " + b16 + " | scene: " + a16);
        com.tencent.qui.video.floatingview.d.i().a(new com.tencent.qui.video.floatingview.a(b16, a16));
    }

    private void G(FeedCloudMeta$StFeed feedCloudMeta$StFeed, Activity activity, boolean z16, f.d dVar) {
        if (!TextUtils.equals("flyer_enlarge_close", this.f425314d) && !TextUtils.equals("top_entrance", this.f425314d) && !TextUtils.equals("share_layer_page", this.f425314d) && !TextUtils.equals("auto_layer_page", this.f425314d) && uq3.c.M6() && !QCircleHostGlobalInfo.isNowFlatState()) {
            if (!((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).checkPermission(activity)) {
                ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).enterPermissionRequestDialog(activity);
                E0();
                return;
            } else {
                f.g(feedCloudMeta$StFeed, new a(dVar, activity, z16));
                return;
            }
        }
        y0(activity, z16);
        if (dVar != null) {
            dVar.a();
            dVar.b();
            dVar.onAnimEnd();
        }
    }

    private void G0(String str) {
        int b16 = r40.a.b(str);
        QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[sendUnInfluenceFloatWindow] businessName: " + str + " | type: " + b16 + " | scene: 8888");
        com.tencent.qui.video.floatingview.d.i().b(new com.tencent.qui.video.floatingview.a(b16, 8888));
    }

    public static u H() {
        if (R == null) {
            synchronized (u.class) {
                if (R == null) {
                    R = new u();
                }
            }
        }
        return R;
    }

    private Context I() {
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null) {
            return qBaseActivity;
        }
        WeakReference<Activity> weakReference = this.H;
        if (weakReference == null) {
            return RFWApplication.getApplication();
        }
        Activity activity = weakReference.get();
        if (activity == null) {
            return RFWApplication.getApplication();
        }
        return activity;
    }

    private void J0() {
        if (this.C != null) {
            return;
        }
        try {
            this.C = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("av_action_close_focus");
            intentFilter.addAction("av_action_request_focus");
            RFWApplication.getApplication().registerReceiver(this.C, intentFilter);
        } catch (Throwable th5) {
            QLog.e("QFP-QFSNewFloatingPlayManager", 1, "[tryRegisterAVBusinessNotifyReceiver] error: ", th5);
            this.C = null;
        }
    }

    private void K0() {
        try {
            if (this.I == null && Build.VERSION.SDK_INT >= 31) {
                PhoneStatusAudioModeMonitor phoneStatusAudioModeMonitor = new PhoneStatusAudioModeMonitor();
                this.I = phoneStatusAudioModeMonitor;
                phoneStatusAudioModeMonitor.i(this);
                this.I.j(RFWApplication.getApplication());
                QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[tryRegisterAndroidSPhoneCall] register android s phone call.");
            }
        } catch (Throwable th5) {
            QLog.e("QFP-QFSNewFloatingPlayManager", 1, "[tryRegisterAndroidSPhoneCall] error: ", th5);
            this.I = null;
        }
    }

    private long L() {
        if (this.f425317h == null) {
            return 0L;
        }
        return this.f425317h.t();
    }

    private void L0() {
        if (this.f425319m != null) {
            return;
        }
        this.f425319m = new c();
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            RFWApplication.getApplication().registerReceiver(this.f425319m, intentFilter);
        } catch (Throwable th5) {
            QLog.e("QFP-QFSNewFloatingPlayManager", 1, "[tryRegisterScreenOnOffReceiver] error: ", th5);
            this.f425319m = null;
        }
    }

    private void M0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, Activity activity, String str, int i3, f.d dVar) {
        String str2;
        boolean z16;
        if (activity != null) {
            this.H = new WeakReference<>(activity);
        }
        this.f425314d = str;
        this.K = i3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[showVideoFloatingWindow]:");
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        } else {
            str2 = str;
        }
        sb5.append(str2);
        sb5.append(" | pageId: ");
        sb5.append(i3);
        QLog.d("QFP-QFSNewFloatingPlayManager", 2, sb5.toString());
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this.f425315e;
        if (feedCloudMeta$StFeed2 != null && (feedCloudMeta$StFeed2.f398449id.get().equals(feedCloudMeta$StFeed.f398449id.get()) || this.f425315e.f398449id.get().contains(feedCloudMeta$StFeed.f398449id.get()))) {
            QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[showVideoFloatingWindow] same feed, open video floating fail.");
            com.tencent.qui.video.floatingview.operate.a aVar = this.E;
            if (aVar != null) {
                aVar.q();
                this.E.j();
                this.f425317h.G(1);
                return;
            }
            return;
        }
        if (this.f425317h != null) {
            this.f425317h.k();
        }
        A();
        this.f425315e = feedCloudMeta$StFeed;
        B0();
        final boolean z17 = !gb0.b.z(feedCloudMeta$StFeed);
        this.f425317h = D(RFWApplication.getApplication(), feedCloudMeta$StFeed);
        StringBuilder sb6 = new StringBuilder();
        sb6.append("[showVideoFloatingWindow] feedId: ");
        sb6.append(v0(feedCloudMeta$StFeed));
        sb6.append(" | enterType: ");
        sb6.append(str);
        sb6.append(" | sourcePageId: ");
        sb6.append(i3);
        sb6.append(" | isVideoVertical: ");
        sb6.append(z17);
        sb6.append(" | isCreateVideoContainer: ");
        if (this.f425318i == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb6.append(z16);
        QLog.d("QFP-QFSNewFloatingPlayManager", 1, sb6.toString());
        if (this.f425318i == null) {
            G(feedCloudMeta$StFeed, activity, z17, dVar);
            return;
        }
        com.tencent.qui.video.floatingview.operate.a aVar2 = this.E;
        if (aVar2 != null && aVar2.c().a()) {
            this.E.q();
            if (this.L != null) {
                RFWThreadManager.getUIHandler().removeCallbacks(this.L);
            }
            this.L = new Runnable() { // from class: p40.t
                @Override // java.lang.Runnable
                public final void run() {
                    u.this.s0(z17);
                }
            };
            RFWThreadManager.getUIHandler().postDelayed(this.L, 300L);
            return;
        }
        s0(z17);
    }

    private QCircleLayerBean O(Context context) {
        e30.b t06 = t0();
        if (t06 != null && t06.g() != null) {
            long L = L();
            QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[preloadPlayer] feed poi bean:" + L);
            FeedCloudMeta$StFeed g16 = t06.g();
            QQCircleFeedBase$StFeedListBusiReqData qQCircleFeedBase$StFeedListBusiReqData = new QQCircleFeedBase$StFeedListBusiReqData();
            QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
            QCircleInitBean qCircleInitBean = new QCircleInitBean();
            QCircleReportBean qCircleReportBean = new QCircleReportBean();
            qCircleReportBean.setDtPageId(QCircleDaTongConstant.PageId.PG_XSJ_SMALL_WINDOW_PLAY_PAGE);
            qCircleLayerBean.setFeed(g16);
            qCircleLayerBean.setFeedListBusiReqData(qQCircleFeedBase$StFeedListBusiReqData);
            qCircleLayerBean.setUseLoadingPic(true);
            qCircleLayerBean.setSourceType(15);
            qCircleLayerBean.setFromReportBean(qCircleReportBean);
            qCircleLayerBean.setVideoCurrentPosition(L);
            qCircleLayerBean.setPageCode(hashCode());
            qCircleLayerBean.setTransInitBean(qCircleInitBean);
            qCircleLayerBean.setNeedReleaseOtherSceneIdPlayer(false);
            qCircleLayerBean.setLayerBizAssemblerType("biz_data_share");
            qCircleLayerBean.setGlobalViewModelKey(this.f425317h.w());
            if (context instanceof Activity) {
                int[] iArr = new int[2];
                View b16 = this.E.b();
                b16.getLocationOnScreen(iArr);
                int i3 = iArr[0];
                int i16 = com.tencent.qui.video.floatingview.view.m.f363980m;
                float f16 = i3 + i16;
                float f17 = iArr[1] + i16;
                int measuredWidth = i3 + b16.getMeasuredWidth();
                int i17 = com.tencent.qui.video.floatingview.view.m.f363980m;
                RectF rectF = new RectF(f16, f17, measuredWidth - i17, (iArr[1] - i17) + b16.getMeasuredHeight());
                qCircleLayerBean.setTransitionAnimBean(new QFSTransitionAnimBean().setLayoutRect(new QFSTransitionAnimBean.SourceRect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom)).setScaleType(ImageView.ScaleType.CENTER_CROP).setImageUrl(this.f425317h.p().g().cover.picUrl.get()).setTransitionDelayTimeMs(0).setEnterAnimFadeCoverTimeMs(300).setTransitionDurationMs(200).setBackTransitionUseVideoFrame(true).setBackTransition(true));
                if (qCircleLayerBean.getTransitionAnimBean() != null && this.f425317h.o() != null) {
                    qCircleLayerBean.getTransitionAnimBean().setCoverDrawable(this.f425317h.o().getDrawable());
                }
            }
            return qCircleLayerBean;
        }
        return new QCircleLayerBean();
    }

    private void U() {
        E0();
    }

    private void U0(QFSSmallWindowScreenStateEvent qFSSmallWindowScreenStateEvent) {
        if (!uq3.o.j1()) {
            return;
        }
        this.D = qFSSmallWindowScreenStateEvent.isLockScreen();
        QLog.d("QFP-QFSNewFloatingPlayManager", RFWLog.USR, "[updateScreenState] screen state: " + this.D);
    }

    private void V(String str, String str2, String str3, long j3) {
        if (TextUtils.equals(str2, Constants.Business.QQ_CIRCLE_WINDOW)) {
            return;
        }
        if (TextUtils.equals("av_action_request_focus", str) && e0(str2)) {
            Z(true, str2);
            return;
        }
        if (TextUtils.equals("av_action_close_focus", str) && e0(str2)) {
            Z(false, str2);
        } else if (TextUtils.equals("av_action_request_focus", str) && n0(str2)) {
            E0();
        } else {
            Y(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public void r0(Intent intent) {
        String action;
        Bundle bundle = null;
        if (intent == null) {
            action = null;
        } else {
            action = intent.getAction();
        }
        u H = H();
        if (intent != null) {
            bundle = intent.getExtras();
        }
        if (H != null && bundle != null) {
            H.V(action, bundle.getString("av_msg_name"), bundle.getString("av_msg_process_name"), bundle.getLong("av_msg_type"));
        } else {
            QLog.d("QFP-QFSNewFloatingPlayManager", 2, "[onReceive] manager == null || extras == null.");
        }
    }

    private void X(RFWMediaFocusChangeEvent rFWMediaFocusChangeEvent) {
        if (!TextUtils.equals(rFWMediaFocusChangeEvent.getConflictBusinessName(), Constants.Business.QQ_CIRCLE_WINDOW)) {
            return;
        }
        QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[handleMediaFocusChangeEvent] execute pause, current feed id: " + v0(u0()) + " | focusBusinessName: " + rFWMediaFocusChangeEvent.getFocusBusinessName() + " | conflictBusinessName: " + rFWMediaFocusChangeEvent.getConflictBusinessName() + " | hasFocusConflict: " + rFWMediaFocusChangeEvent.hasFocusConflict() + " | isFloatingPlaying: " + j0());
        if (rFWMediaFocusChangeEvent.hasFocusConflict()) {
            G0(rFWMediaFocusChangeEvent.getConflictBusinessName());
            F0(rFWMediaFocusChangeEvent.getFocusBusinessName());
            A0();
        }
    }

    private void Y(String str) {
        com.tencent.qui.video.floatingview.e c16;
        com.tencent.qui.video.floatingview.operate.a aVar = this.E;
        if (aVar != null && (c16 = aVar.c()) != null && !TextUtils.equals(str, "av_action_close_focus")) {
            QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[handlerOtherBusinessFocusReceive] status folded: " + c16.a() + " | isPlaying: " + c16.f());
            if (!c16.a() && !c16.f()) {
                this.E.d();
            }
        }
    }

    private void Z(boolean z16, String str) {
        this.G = z16;
        if (z16) {
            F0(str);
            A0();
        } else {
            G0(str);
            D0();
        }
        QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[handlerPhoneCallFlow] current isCallPhone:" + z16 + ", businessName: " + str);
    }

    private void b0(QFSLayerFeedPosSyncEvent qFSLayerFeedPosSyncEvent) {
        if (qFSLayerFeedPosSyncEvent.getPageCode() != hashCode()) {
            return;
        }
        ad.d(qFSLayerFeedPosSyncEvent.getCoverUrl(), Boolean.valueOf(qFSLayerFeedPosSyncEvent.isVerticalFeed()), hashCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(String str) {
        if (TextUtils.equals(str, "android.intent.action.USER_PRESENT")) {
            QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[handlerScreenState] screen open");
            this.D = false;
        } else if (TextUtils.equals(str, IECScreenReceiver.ACTION_SCREEN_OFF)) {
            QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[handlerScreenState] screen off");
            this.D = true;
            E0();
        }
    }

    private void d0(QFSVideoPauseEvent qFSVideoPauseEvent) {
        com.tencent.qui.video.floatingview.e c16;
        com.tencent.qui.video.floatingview.operate.a aVar = this.E;
        if (aVar == null) {
            c16 = null;
        } else {
            c16 = aVar.c();
        }
        if (c16 != null && c16.a() && !c16.f() && qFSVideoPauseEvent.mIsPause && qFSVideoPauseEvent.mIsClick) {
            this.E.q();
            QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[handlerVideoPauseEvent] current video pause, un folder window.");
        }
    }

    private boolean e0(String str) {
        if (!TextUtils.equals(str, Constants.Business.QQ_RTC) && !TextUtils.equals(str, Constants.Business.SYSTEM_PHONE)) {
            return false;
        }
        return true;
    }

    private boolean n0(String str) {
        return TextUtils.equals(str, "QQ\u76f4\u64ad");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0() {
        L0();
        J0();
        K0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(boolean z16) {
        Z(z16, Constants.Business.SYSTEM_PHONE);
    }

    private e30.b t0() {
        if (this.f425317h == null) {
            return null;
        }
        return this.f425317h.p();
    }

    private FeedCloudMeta$StFeed u0() {
        e30.b t06 = t0();
        if (t06 == null) {
            return null;
        }
        return t06.g();
    }

    private String v0(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return "";
        }
        return feedCloudMeta$StFeed.f398449id.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean y0(Activity activity, boolean z16) {
        if (this.f425317h == null) {
            QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[openWithContentView] vertical view should not be null.");
            return false;
        }
        com.tencent.qui.video.floatingview.c cVar = new com.tencent.qui.video.floatingview.c("QCIRCLE");
        cVar.e(z16);
        cVar.d(false);
        FrameLayout C = C(RFWApplication.getApplication());
        this.f425318i = C;
        try {
            C.addView(this.f425317h, new FrameLayout.LayoutParams(-1, -1));
            this.E = com.tencent.qui.video.floatingview.d.i().j(activity, this.f425318i, cVar, this);
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f425315e;
            T0(feedCloudMeta$StFeed, feedCloudMeta$StFeed.video.duration.get(), (int) R(this.f425315e));
            boolean g16 = this.E.g();
            if (g16) {
                QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[openWithContentView] error:" + this.E);
                E0();
            } else {
                if (tb0.a.f435779d.b()) {
                    this.E.h();
                }
                F("dt_imp", this.f425315e);
            }
            return !g16;
        } catch (Throwable th5) {
            QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[addViewToContainer] ex: ", th5);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void s0(boolean z16) {
        if (this.f425318i.getChildCount() >= 0) {
            this.f425318i.removeAllViews();
        }
        com.tencent.qui.video.floatingview.operate.a aVar = this.E;
        if (aVar != null) {
            aVar.l(z16);
        }
        if (this.f425317h == null) {
            QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[addViewToContainer] vertical view should not be null.");
            return;
        }
        try {
            this.f425318i.addView(this.f425317h, new FrameLayout.LayoutParams(-1, -1));
        } catch (Throwable th5) {
            QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[addViewToContainer] ex: ", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        try {
            com.tencent.qui.video.floatingview.operate.a aVar = this.E;
            if (aVar != null) {
                aVar.a();
            }
            if (this.f425317h != null) {
                this.f425317h.k();
                this.f425317h = null;
            }
            if (this.L != null) {
                RFWThreadManager.getUIHandler().removeCallbacks(this.L);
            }
            if (this.M != null) {
                RFWThreadManager.getInstance().remove(this.M);
            }
            this.f425315e = null;
            this.f425318i = null;
            this.E = null;
            QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[postMainRelease] execute floating play window release.");
        } catch (Throwable th5) {
            QLog.e("QFP-QFSNewFloatingPlayManager", 1, "[postMainRelease] ex: ", th5);
        }
    }

    public void B() {
        m.b().a();
    }

    public void C0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, long j3) {
        if (!n.e().c(feedCloudMeta$StFeed)) {
            return;
        }
        RFWLayerVideoPlayPosRecorder.INSTANCE.updatePlayPosition(feedCloudMeta$StFeed.f398449id.get(), j3);
    }

    public void E0() {
        if (RFWThreadManager.isMainThread()) {
            z0();
        } else {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: p40.p
                @Override // java.lang.Runnable
                public final void run() {
                    u.this.z0();
                }
            });
        }
    }

    public void H0(int i3) {
        if (this.f425317h != null) {
            this.f425317h.setEnterImgVisible(i3);
        }
    }

    public void I0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, Activity activity, String str, int i3, f.d dVar) {
        if ((TextUtils.equals(str, "share_layer_page") || TextUtils.equals(str, "top_entrance")) && activity != null && activity.isFinishing()) {
            QLog.w("QFP-QFSNewFloatingPlayManager", 1, "[showVideoFloatingWindow] current activity is finishing, not show floating window.");
            return;
        }
        try {
            M0(feedCloudMeta$StFeed, activity, str, i3, dVar);
        } catch (Throwable th5) {
            QLog.e("QFP-QFSNewFloatingPlayManager", 1, "[showVideoFloatingWindow] error: ", th5);
        }
    }

    public FeedCloudMeta$StFeed J() {
        return this.f425315e;
    }

    public int K() {
        if (this.f425317h == null) {
            return -1;
        }
        return this.f425317h.s();
    }

    public QFSVideoView M() {
        if (this.f425317h != null) {
            return this.f425317h.q();
        }
        return null;
    }

    public QCircleLayerBean N() {
        return O(I());
    }

    public void N0(int i3, String str) {
        QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[updateCurrentFeed] source: " + i3 + " | feedId: " + str);
        this.Q = str;
    }

    public void O0(int i3, int i16) {
        QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[updateErrorState] errorCode: " + i3 + " | errorCode: " + i16);
        com.tencent.qui.video.floatingview.operate.a aVar = this.E;
        if (aVar != null) {
            aVar.i();
        }
        QCircleToast.v(1, RFWApplication.getApplication().getString(R.string.f195894fu), 0);
    }

    public Object P() {
        return this.f425314d;
    }

    public void P0(int i3) {
        if (uq3.o.i1() && bz.l()) {
            QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[updatePageCreate] pageId: " + i3 + ", not is fold phone.");
            return;
        }
        if (i3 == 503 || i3 == 501 || i3 == 504) {
            l.t().L(false);
            QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[updatePageCreate] pageId: " + i3 + " | feedId: " + v0(u0()));
        }
    }

    public String Q() {
        return this.J;
    }

    public void Q0(int i3) {
        if (this.E == null) {
            return;
        }
        if (uq3.o.i1() && bz.l()) {
            QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[updatePageDestroy] pageId: " + i3 + ", not is fold phone.");
            return;
        }
        if (i3 == 501 || i3 == 504) {
            l.t().L(true);
            QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[updatePageDestroy] pageId: " + i3 + " | feedId: " + v0(u0()));
        }
    }

    public long R(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (!n.e().c(feedCloudMeta$StFeed)) {
            return 0L;
        }
        long playPosition = RFWLayerVideoPlayPosRecorder.INSTANCE.getPlayPosition(feedCloudMeta$StFeed.f398449id.get());
        if (playPosition == 0) {
            return 0L;
        }
        return playPosition;
    }

    public void R0(int i3) {
        this.F = i3;
    }

    public int S() {
        return this.K;
    }

    public void S0(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.P = new Pair<>(str, Boolean.valueOf(z16));
    }

    public View T() {
        com.tencent.qui.video.floatingview.operate.a aVar = this.E;
        if (aVar == null) {
            return null;
        }
        return aVar.b();
    }

    public void T0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, int i16) {
        FeedCloudMeta$StFeed g16;
        if (i16 <= 0) {
            return;
        }
        e30.b t06 = t0();
        if (t06 == null) {
            g16 = null;
        } else {
            g16 = t06.g();
        }
        if (!TextUtils.equals(v0(feedCloudMeta$StFeed), v0(g16))) {
            return;
        }
        int min = Math.min(Math.max((int) (((i16 * 1.0f) / i3) * 100.0f), 0), 100);
        com.tencent.qui.video.floatingview.operate.a aVar = this.E;
        if (aVar == null) {
            QLog.e("QFP-QFSNewFloatingPlayManager", 4, "[updateProgress] video float window operator should not be null.");
        } else {
            aVar.o(min);
        }
        C0(feedCloudMeta$StFeed, i16);
    }

    public void V0(boolean z16) {
        if (this.f425317h == null) {
            QLog.e("QFP-QFSNewFloatingPlayManager", 1, "[updateVoiceMute] vertical view should not be null.");
            return;
        }
        if (this.E == null) {
            QLog.e("QFP-QFSNewFloatingPlayManager", 1, "[updateVoiceMute] video float window operator should not be null.");
            return;
        }
        QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[updateVoiceMute] isEnabledMute: " + z16);
        this.f425317h.H(z16);
        if (z16) {
            this.E.h();
        } else {
            this.E.r();
        }
    }

    @Override // com.tencent.av.utils.PhoneStatusMonitor.a
    public void a(final boolean z16) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: p40.r
            @Override // java.lang.Runnable
            public final void run() {
                u.this.q0(z16);
            }
        });
    }

    public void a0() {
        if (this.f425317h == null) {
            QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[handlerPlayerViewPause] vertical view should not be null.");
        } else {
            if (this.E == null) {
                QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[handlerPlayerViewPause] video float window operator should not be null.");
                return;
            }
            QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[handlerPlayerViewPause] current pause...");
            this.f425317h.G(2);
            this.E.i();
        }
    }

    @Override // bz3.b
    public void b(boolean z16) {
        if (this.f425317h == null) {
            QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[onFolded] vertical view should not be null.");
            return;
        }
        a0();
        E(this.f425315e, QCircleDaTongConstant.ElementParamValue.FOLD_WINDOW, z16);
        QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[onFolded] execute window folded isAuto: " + z16);
    }

    @Override // bz3.b
    public void c() {
        QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[didFloatWindowFrameChanged] did float window open. ");
    }

    @Override // bz3.b
    public /* synthetic */ void d() {
        bz3.a.b(this);
    }

    @Override // cz3.b
    public void e(com.tencent.qui.video.floatingview.a aVar) {
        if (aVar == null) {
            QLog.e("QFP-QFSNewFloatingPlayManager", 1, "[onBusinessUnInfluence] type == null.");
            return;
        }
        cz3.a.a(this, aVar);
        if (this.E == null) {
            QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[onBusinessInfluence] other business influence with type should not be null.");
            return;
        }
        QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[onBusinessInfluence] type: " + aVar.b() + " | sceneId: " + aVar.a());
        this.E.d();
        a0();
    }

    @Override // cz3.b
    public void f(com.tencent.qui.video.floatingview.a aVar) {
        if (aVar == null) {
            QLog.e("QFP-QFSNewFloatingPlayManager", 1, "[onBusinessUnInfluence] type == null.");
            return;
        }
        cz3.a.a(this, aVar);
        QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[onOtherBusinessUnInfluenceWithType] type: " + aVar.b() + " | sceneId: " + aVar.a());
    }

    public boolean f0(String str) {
        if (this.f425316f && TextUtils.equals(str, this.Q)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.floatingwindow.model.QFSSmallWindowGlobalCollect.b
    public void g(String str) {
        if (!uq3.o.H1()) {
            return;
        }
        QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[onRecoverSmallWindow] sceneName: " + str);
        D0();
    }

    public boolean g0() {
        return this.f425316f;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(RFWMediaFocusChangeEvent.class);
        arrayList.add(QFSLayerFeedPosSyncEvent.class);
        arrayList.add(QFSVideoPauseEvent.class);
        arrayList.add(AccountChangeEvent.class);
        arrayList.add(AccountKickedEvent.class);
        arrayList.add(AccountLoginOutEvent.class);
        arrayList.add(QFSSmallWindowScreenStateEvent.class);
        return arrayList;
    }

    @Override // bz3.b
    public void h() {
        if (this.f425317h == null) {
            QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[onMute] vertical view should not be null.");
        } else {
            this.f425317h.H(true);
        }
    }

    public boolean h0() {
        com.tencent.qui.video.floatingview.operate.a aVar = this.E;
        if (aVar != null && aVar.c() != null && this.E.c().a()) {
            return true;
        }
        return false;
    }

    @Override // bz3.b
    public /* synthetic */ void i() {
        bz3.a.a(this);
    }

    public boolean i0() {
        com.tencent.qui.video.floatingview.operate.a aVar = this.E;
        if (aVar != null && aVar.c() != null && this.E.c().b()) {
            return true;
        }
        return false;
    }

    @Override // bz3.b
    public void j(boolean z16) {
        if (this.f425317h == null) {
            QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[onFolded] vertical view should not be null.");
            return;
        }
        E(this.f425315e, QCircleDaTongConstant.ElementParamValue.EXPAND_WINDOW, z16);
        QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[onUnFolded] execute window unfolded...." + z16);
    }

    public boolean j0() {
        com.tencent.qui.video.floatingview.operate.a aVar = this.E;
        if (aVar != null && aVar.c() != null && this.E.c().f()) {
            return true;
        }
        return false;
    }

    @Override // bz3.b
    public void k() {
        bz3.a.c(this);
        QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[willFloatWindowOpen] will float window open.");
    }

    public boolean k0() {
        if (this.f425315e != null && this.f425318i != null && this.E != null && this.f425317h != null && this.E.c() != null && this.E.c().c()) {
            return true;
        }
        return false;
    }

    @Override // bz3.b
    public void l() {
        if (this.f425317h == null) {
            QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[onUnMute] vertical view should not be null.");
        } else {
            this.f425317h.H(false);
        }
    }

    public boolean l0() {
        return this.G;
    }

    @Override // com.tencent.avbiz.b.a
    public void m(final Intent intent) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: p40.s
            @Override // java.lang.Runnable
            public final void run() {
                u.this.r0(intent);
            }
        });
    }

    public boolean m0(String str) {
        Pair<String, Boolean> pair = this.P;
        if (pair == null) {
            return false;
        }
        this.P = null;
        if (!TextUtils.equals((String) pair.first, str)) {
            return false;
        }
        return ((Boolean) pair.second).booleanValue();
    }

    @Override // bz3.b
    public void n() {
        QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[willFloatWindowEnlarge] execute float window click.");
        if (fb0.a.a("QFP-QFSNewFloatingPlayManager") || this.E == null) {
            return;
        }
        l.t().y(this.E.b(), I(), O(I()), this.f425315e, L());
    }

    @Override // bz3.b
    public void o() {
        QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[didFloatWindowClose] did float window close.");
        SimpleEventBus.getInstance().dispatchEvent(new QFSFloatingWindowReleaseEvent());
        E0();
    }

    public boolean o0() {
        return this.D;
    }

    @Override // bz3.b
    public void onPause() {
        if (this.f425317h == null) {
            QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[onPause] vertical view should not be null.");
        } else {
            QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[onPause] current pause...");
            this.f425317h.G(2);
        }
    }

    @Override // bz3.b
    public void onPlay() {
        if (this.f425317h == null) {
            QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[onPlay] vertical view should not be null.");
        } else {
            QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[onPlay] current play...");
            this.f425317h.G(1);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof RFWMediaFocusChangeEvent) {
            X((RFWMediaFocusChangeEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSLayerFeedPosSyncEvent) {
            b0((QFSLayerFeedPosSyncEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSVideoPauseEvent) {
            d0((QFSVideoPauseEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof AccountChangeEvent) {
            U();
            return;
        }
        if (!(simpleBaseEvent instanceof AccountKickedEvent) && !(simpleBaseEvent instanceof AccountLoginOutEvent)) {
            if (simpleBaseEvent instanceof QFSSmallWindowScreenStateEvent) {
                U0((QFSSmallWindowScreenStateEvent) simpleBaseEvent);
                return;
            }
            return;
        }
        E0();
    }

    @Override // com.tencent.biz.qqcircle.immersive.floatingwindow.model.QFSSmallWindowGlobalCollect.c
    public void p(String str) {
        if (!uq3.o.J1()) {
            return;
        }
        QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[onReleaseSmallWindow] sceneName: " + str);
        E0();
    }

    @Override // p40.a
    public void q(e30.b bVar, boolean z16) {
        FeedCloudMeta$StFeed g16;
        if (bVar == null) {
            g16 = null;
        } else {
            g16 = bVar.g();
        }
        this.f425315e = g16;
        B0();
        this.f425316f = z16;
        boolean z17 = !gb0.b.z(g16);
        QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[onFeedChange] target feed: " + v0(g16) + " | isFirstFeed: " + z16 + " | isVideoVertical:" + z17);
        com.tencent.qui.video.floatingview.operate.a aVar = this.E;
        if (aVar != null) {
            aVar.l(z17);
            this.E.j();
        }
    }

    public void w0() {
        QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[onCloseIconClick] close icon click.");
    }

    public void x0() {
        QFSFloatingVerticalView qFSFloatingVerticalView = this.f425317h;
        if (qFSFloatingVerticalView != null) {
            synchronized (u.class) {
                QLog.d("QFP-QFSNewFloatingPlayManager", 1, "[onExitQFS] vertical view register view.");
                qFSFloatingVerticalView.J();
            }
        }
    }
}
