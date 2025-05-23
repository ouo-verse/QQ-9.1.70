package p40;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Pair;
import android.view.View;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qcircleshadow.lib.QCircleHostRedPointHelper;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.helpers.y;
import com.tencent.biz.qqcircle.immersive.events.QFSFloatEndCaptureEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFullScreenCloseEvent;
import com.tencent.biz.qqcircle.immersive.floatingwindow.model.QFSSmallWindowGlobalCollect;
import com.tencent.biz.qqcircle.immersive.utils.be;
import com.tencent.biz.qqcircle.immersive.utils.bi;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.utils.bj;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.playerprender.RFWPlayerPreRenderBean;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerPreRenderHelper;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWStVideo;
import com.tencent.biz.richframework.video.rfw.view.RFWPlayerReuseUtils;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qcircle.api.IQCircleCommonUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleRedPointAppidContants;
import com.tencent.mobileqq.qcircle.api.event.QCircleSelectTabEvent;
import com.tencent.mobileqq.qcircle.api.event.QFSSmallInsertFeedEvent;
import com.tencent.mobileqq.qcircle.api.event.QFSSmallRefreshSelectedEvent;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qcircle.api.utils.EeveeRedpointUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.lifecycle.RFWLifecycleHelper;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import p40.f;
import qqcircle.QQCircleCounter$RedPointInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class l {

    /* renamed from: c, reason: collision with root package name */
    private static volatile l f425287c;

    /* renamed from: d, reason: collision with root package name */
    private static final AtomicBoolean f425288d = new AtomicBoolean(false);

    /* renamed from: a, reason: collision with root package name */
    private FeedCloudMeta$StFeed f425289a;

    /* renamed from: b, reason: collision with root package name */
    private final Runnable f425290b = new Runnable() { // from class: p40.i
        @Override // java.lang.Runnable
        public final void run() {
            l.C();
        }
    };

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends f.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f425291a;

        a(d dVar) {
            this.f425291a = dVar;
        }

        @Override // p40.f.d
        public void a() {
            l.i(this.f425291a);
        }

        @Override // p40.f.d
        public void b() {
            d dVar = this.f425291a;
            if (dVar != null) {
                dVar.c();
            }
            u.H().E0();
        }

        @Override // p40.f.d, com.tencent.biz.richframework.animation.transition.TransitionManager.OnAnimEndListener
        public void onAnimEnd() {
            d dVar = this.f425291a;
            if (dVar != null) {
                dVar.b();
            }
            u.H().E0();
            l.this.G();
            y.g().z(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b extends f.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f425293a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f425294b;

        b(FeedCloudMeta$StFeed feedCloudMeta$StFeed, Context context) {
            this.f425293a = feedCloudMeta$StFeed;
            this.f425294b = context;
        }

        private void c(boolean z16) {
            QLog.d("QFP-QFSFloatingEnterControl", 1, "[jumpSmallToHomePage] anim end, feed id: " + bj.g(this.f425293a) + " | isAnimEnd: " + z16);
            l.this.j(this.f425294b);
            l.t().H();
            l.this.G();
            y.g().z(false);
            if (uq3.o.n1()) {
                u.H().E0();
            }
        }

        @Override // p40.f.d, com.tencent.biz.richframework.animation.transition.TransitionManager.OnAnimEndListener
        public void onAnimCancel() {
            super.onAnimCancel();
            c(false);
        }

        @Override // p40.f.d, com.tencent.biz.richframework.animation.transition.TransitionManager.OnAnimEndListener
        public void onAnimEnd() {
            super.onAnimEnd();
            c(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c extends f.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f425296a;

        c(d dVar) {
            this.f425296a = dVar;
        }

        @Override // p40.f.d
        public void a() {
            l.i(this.f425296a);
        }

        @Override // p40.f.d
        public void b() {
            d dVar = this.f425296a;
            if (dVar != null) {
                dVar.c();
            }
        }

        @Override // p40.f.d, com.tencent.biz.richframework.animation.transition.TransitionManager.OnAnimEndListener
        public void onAnimEnd() {
            d dVar = this.f425296a;
            if (dVar != null) {
                dVar.b();
            }
        }
    }

    l() {
    }

    private void A(final Context context, final QCircleLayerBean qCircleLayerBean, FeedCloudMeta$StFeed feedCloudMeta$StFeed, long j3) {
        if (qCircleLayerBean == null) {
            QLog.d("QFP-QFSFloatingEnterControl", 1, "[jumpToDetailPage] bean == null.");
            return;
        }
        F(qCircleLayerBean.getFeed(), j3);
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: p40.j
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.biz.qqcircle.launcher.c.u(context, qCircleLayerBean);
            }
        }, 500L);
        if (feedCloudMeta$StFeed != null) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSFullScreenCloseEvent(feedCloudMeta$StFeed.f398449id.get()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void C() {
        if (!t().u()) {
            QLog.d("QFP-QFSFloatingEnterControl", 1, "[activateAppToFrontCheck] current is foreground, end flow.");
        } else {
            QLog.d("QFP-QFSFloatingEnterControl", 1, "[activateAppToFrontCheck] current is background, splash to front.");
            t().h(RFWApplication.getApplication());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void D(f.d dVar, FeedCloudMeta$StFeed feedCloudMeta$StFeed, QFSVideoView qFSVideoView, View view, boolean z16, Pair pair) {
        if (pair != null && pair.second != null) {
            QLog.d("QFP-QFSFloatingEnterControl", 1, "[startSmallWindowEnterAnimation] to full screen animation, feedId: " + bj.g(feedCloudMeta$StFeed) + " | bitmapHashCode: " + ((Bitmap) pair.second).hashCode());
            RFWPlayerReuseUtils.prepareToReusePlayer(qFSVideoView);
            f.h(view, (Bitmap) pair.second, feedCloudMeta$StFeed, z16, dVar);
            if (dVar != null) {
                dVar.b();
            }
            SimpleEventBus.getInstance().dispatchEvent(new QFSFloatEndCaptureEvent(feedCloudMeta$StFeed.f398449id.get(), (Bitmap) pair.second));
            return;
        }
        QLog.d("QFP-QFSFloatingEnterControl", 1, "[startSmallWindowEnterAnimation] bitmapInfo == null || bitmapInfo.second == null.");
        if (dVar != null) {
            dVar.a();
            dVar.b();
            dVar.onAnimEnd();
        }
    }

    private void F(FeedCloudMeta$StFeed feedCloudMeta$StFeed, long j3) {
        if (feedCloudMeta$StFeed == null) {
            QLog.e("QFP-QFSFloatingEnterControl", 1, "[preloadPlayer] feed should not be null.");
            return;
        }
        QLog.d("QFP-QFSFloatingEnterControl", 2, "[preloadPlayer]fs_lifecycle startANewPlayer float preload]feed position:" + j3);
        RFWStVideo k3 = gb0.b.k(feedCloudMeta$StFeed.video);
        RFWPlayerPreRenderHelper.getInstance().playerRender(gb0.b.f(new RFWPlayerPreRenderBean(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO(), 10006).setActivity(((IQCircleCommonUtil) QRoute.api(IQCircleCommonUtil.class)).getTopActivity()).setPreloadVideo(k3).setPreloadOriginData(gb0.b.m(new e30.b(feedCloudMeta$StFeed).o("KEY_RFW_VIDEO_FEED_POI", 0))).setPlayerOptions(RFWPlayerOptions.obtain(126).setStVideo(k3).setStartOffset(j3)).setIsJumpTrigger(uq3.o.U0()).setMultiLevel(false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        if (!uq3.o.I1()) {
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new QFSSmallRefreshSelectedEvent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        com.tencent.biz.qqcircle.immersive.floatingwindow.model.a d16 = QFSSmallWindowGlobalCollect.k().d();
        FrameFragment d17 = d16.d();
        if (d17 == null) {
            QLog.d("QFP-QFSFloatingEnterControl", 1, "[selectedBottomTab] frame fragment should not be null.");
            return;
        }
        int a16 = d16.a();
        QLog.d("QFP-QFSFloatingEnterControl", 1, "[selectedBottomTab] currentBusinessIndex: " + a16);
        d17.setCurrentTab(a16);
    }

    private void I(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            QLog.d("QFP-QFSFloatingEnterControl", 1, "[sendFeedInsertEvent] feed should not be null.");
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new QCircleSelectTabEvent(6));
        SimpleEventBus.getInstance().dispatchEvent(new QFSSmallInsertFeedEvent(feedCloudMeta$StFeed));
        K(feedCloudMeta$StFeed);
        QLog.d("QFP-QFSFloatingEnterControl", 1, "INSERT-[sendFeedInsertEvent] feedId: " + bj.g(feedCloudMeta$StFeed) + ", send event.");
    }

    private void J(final View view, final FeedCloudMeta$StFeed feedCloudMeta$StFeed, final boolean z16, final f.d dVar) {
        n.e().u(true, false);
        final QFSVideoView M = u.H().M();
        be.c().h(M, feedCloudMeta$StFeed, new bi.a() { // from class: p40.k
            @Override // com.tencent.biz.qqcircle.immersive.utils.bi.a
            public final void a(Pair pair) {
                l.D(f.d.this, feedCloudMeta$StFeed, M, view, z16, pair);
            }
        });
    }

    private void h(Context context) {
        Intent intent = new Intent();
        intent.addFlags(131072);
        RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTER_SPLASH);
        QLog.d("QFP-QFSFloatingEnterControl", 1, "[activateAppToFront] start splash activity.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(d dVar) {
        if (dVar != null) {
            dVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Context context) {
        if (uq3.o.V0() && !u()) {
            QLog.d("QFP-QFSFloatingEnterControl", 1, "[activateAppToFront] current is app front flag, not restart app to front.");
            RFWThreadManager.getUIHandler().removeCallbacks(this.f425290b);
            RFWThreadManager.getUIHandler().postDelayed(this.f425290b, 300L);
            return;
        }
        h(context);
    }

    private int k(int i3) {
        if (i3 == 503) {
            return 6;
        }
        if (i3 == 501) {
            return 1;
        }
        if (i3 == 504) {
            return 9;
        }
        return -1;
    }

    private FeedCloudMeta$StFeed o() {
        QCircleLayerBean N = u.H().N();
        if (N == null) {
            return null;
        }
        return N.getFeed();
    }

    private FeedCloudMeta$StFeed p() {
        return u.H().J();
    }

    private void q(View view, Context context, FeedCloudMeta$StFeed feedCloudMeta$StFeed, f.d dVar) {
        boolean z16;
        if (feedCloudMeta$StFeed == null) {
            QLog.e("QFP-QFSFloatingEnterControl", 1, "[jumpToTargetBottomTab] currentFeed == null.");
            if (dVar != null) {
                dVar.onAnimEnd();
                return;
            }
            return;
        }
        boolean n3 = y.g().n();
        int S = u.H().S();
        boolean g06 = u.H().g0();
        int k3 = k(S);
        int l3 = y.g().l();
        QLog.d("QFP-QFSFloatingEnterControl", 1, "[insertFeedForBottomTabAnimFlow] hasRedPoint: " + n3 + " | sourcePageId: " + S + " | isFirstFeed: " + g06 + " | sourceTabType: " + k3 + " | targetTabType: " + l3);
        if (k3 != -1 && n3 && k3 != l3 && g06) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.d("QFP-QFSFloatingEnterControl", 1, "[insertFeedForBottomTabAnimFlow] current handler all push call");
            if (dVar != null) {
                dVar.onAnimEnd();
                return;
            }
            return;
        }
        if (v()) {
            QLog.d("QFP-QFSFloatingEnterControl", 1, "[jumpToTargetBottomTab] current is red point, jump to bottom tab, end flow.");
            if (dVar != null) {
                dVar.onAnimEnd();
            }
            n.e().u(false, true);
            return;
        }
        s(feedCloudMeta$StFeed);
        J(view, feedCloudMeta$StFeed, false, dVar);
    }

    private void r(View view, boolean z16, FeedCloudMeta$StFeed feedCloudMeta$StFeed, f.d dVar) {
        if (feedCloudMeta$StFeed == null) {
            QLog.e("QFP-QFSFloatingEnterControl", 1, "[jumpToTargetBottomTab] currentFeed == null.");
            return;
        }
        if (v()) {
            y.g().z(true);
            n.e().u(false, true);
            if (dVar != null) {
                dVar.onAnimCancel();
            }
            QLog.d("QFP-QFSFloatingEnterControl", 1, "[insertFeedForSmallAnimFlow] exists refresh red point, end flow.");
            return;
        }
        s(feedCloudMeta$StFeed);
        J(view, feedCloudMeta$StFeed, z16, dVar);
    }

    private void s(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (u.H().f0(bj.g(feedCloudMeta$StFeed))) {
            QLog.w("QFP-QFSFloatingEnterControl", 1, "INSERT-[insertFeedToTargetPage] current is first feed and target data equal, not insert feed.");
        } else {
            I(feedCloudMeta$StFeed);
        }
    }

    public static l t() {
        if (f425287c == null) {
            synchronized (l.class) {
                if (f425287c == null) {
                    f425287c = new l();
                }
            }
        }
        return f425287c;
    }

    private boolean u() {
        return RFWLifecycleHelper.getInstance().isRunningInBackground();
    }

    private boolean v() {
        int i3;
        QQCircleCounter$RedPointInfo qQMainTabOuterEntranceRedPointInfoByAppid = QCircleHostRedPointHelper.getQQMainTabOuterEntranceRedPointInfoByAppid(QCircleRedPointAppidContants.QCIRCLE_ENTRANCE);
        y.g();
        boolean q16 = y.q(qQMainTabOuterEntranceRedPointInfoByAppid);
        int i16 = -1;
        if (qQMainTabOuterEntranceRedPointInfoByAppid == null) {
            i3 = -1;
        } else {
            i3 = qQMainTabOuterEntranceRedPointInfoByAppid.redType.get();
        }
        if (qQMainTabOuterEntranceRedPointInfoByAppid != null) {
            i16 = qQMainTabOuterEntranceRedPointInfoByAppid.tabType.get();
        }
        QLog.d("QFP-QFSFloatingEnterControl", 1, "[isExistsRedPointUndertake] isExistsRedPointUndertake: " + q16 + " | redPointType: " + i3 + " | tabType: " + i16 + " | redPointId: " + EeveeRedpointUtil.getRedPointId(qQMainTabOuterEntranceRedPointInfoByAppid));
        return q16;
    }

    public static boolean w() {
        return u.H().k0();
    }

    private boolean x() {
        boolean g16 = QFSSmallWindowGlobalCollect.k().d().g();
        boolean M6 = uq3.c.M6();
        boolean isNowFlatState = QCircleHostGlobalInfo.isNowFlatState();
        QLog.d("QFP-QFSFloatingEnterControl", 1, "[isJumpToDetailPage] isTopSceneLayer: " + g16 + "| isOnMainTab: " + M6 + "| isNowFlatState: " + isNowFlatState);
        if (!g16 || !M6 || isNowFlatState) {
            return true;
        }
        return false;
    }

    private void z(View view, Context context, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        r(view, true, feedCloudMeta$StFeed, new b(feedCloudMeta$StFeed, context));
    }

    public boolean E() {
        boolean z16;
        if (!uq3.o.p()) {
            QLog.d("QFP-QFSFloatingEnterControl", 1, "[needInsertData]  close");
            return false;
        }
        boolean v3 = v();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[needInsertData]|isExistsRedPointUndertake:");
        sb5.append(v3);
        sb5.append("|mCurrentInsertFeed != null");
        if (this.f425289a != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        QLog.d("QFP-QFSFloatingEnterControl", 1, sb5.toString());
        if (v3 || this.f425289a == null) {
            return false;
        }
        return true;
    }

    public void K(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.f425289a = feedCloudMeta$StFeed;
    }

    public void L(boolean z16) {
        f425288d.set(z16);
    }

    public void l(Context context, d dVar) {
        if (!uq3.c.M6()) {
            QLog.d("QFP-QFSFloatingEnterControl", 1, "onReceiveEvent not mainTabMode");
            i(dVar);
            return;
        }
        QLog.d("QFP-QFSFloatingEnterControl", 1, "onReceiveEvent tab un Selected");
        if (!com.tencent.biz.qqcircle.f.c() && !n.e().n()) {
            QLog.d("QFP-QFSFloatingEnterControl", 1, "auto trigger return switch close");
            i(dVar);
            return;
        }
        WeakReference<QFSVideoView> weakReference = QFSVideoView.D;
        if (weakReference == null) {
            QLog.d("QFP-QFSFloatingEnterControl", 1, "sCurrentPlayVideoView np");
            i(dVar);
            return;
        }
        QFSVideoView qFSVideoView = weakReference.get();
        if (qFSVideoView == null) {
            QLog.d("QFP-QFSFloatingEnterControl", 1, "sCurrentPlayVideoView np");
            i(dVar);
            return;
        }
        FeedCloudMeta$StFeed data = qFSVideoView.getData();
        if (!n.e().m(data)) {
            i(dVar);
            return;
        }
        QLog.d("QFP-QFSFloatingEnterControl", 1, "tryShowFloating");
        int pageId = qFSVideoView.getPageId();
        if (data == null) {
            QLog.d("QFP-QFSFloatingEnterControl", 1, "feed np");
            i(dVar);
        } else {
            n.e().p(context, data, false, pageId, new c(dVar));
        }
    }

    public void m(Context context, d dVar) {
        y.g().z(false);
        if (!u.H().k0()) {
            if (dVar != null) {
                dVar.b();
            }
            n.e().u(false, false);
            u.H().E0();
            RFWLog.d("QFP-QFSFloatingEnterControl", RFWLog.USR, "[executeBottomTabFlow] current floating window not show release.");
            return;
        }
        AtomicBoolean atomicBoolean = f425288d;
        if (atomicBoolean.get()) {
            QLog.e("QFP-QFSFloatingEnterControl", 1, "[executeBottomTabFlow] resident page.");
            if (dVar != null) {
                dVar.b();
            }
            u.H().E0();
            n.e().u(false, false);
            atomicBoolean.set(false);
            return;
        }
        FeedCloudMeta$StFeed p16 = p();
        FeedCloudMeta$StFeed o16 = o();
        if (p16 == null) {
            QLog.d("QFP-QFSFloatingEnterControl", 1, "INSERT-[executeBottomTabFlow] current init feed is null, init feed id: " + bj.g(o16));
        }
        if (p16 == null) {
            p16 = o16;
        }
        q(u.H().T(), context, p16, new a(dVar));
    }

    public FeedCloudMeta$StFeed n() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f425289a;
        this.f425289a = null;
        return feedCloudMeta$StFeed;
    }

    public void y(View view, Context context, QCircleLayerBean qCircleLayerBean, FeedCloudMeta$StFeed feedCloudMeta$StFeed, long j3) {
        FeedCloudMeta$StFeed feed;
        boolean z16;
        if (!u.H().k0()) {
            u.H().E0();
            return;
        }
        if (qCircleLayerBean == null) {
            QLog.d("QFP-QFSFloatingEnterControl", 1, "[jumpFloatingWindowToTargetPage] bean should not be null.");
            return;
        }
        if (qCircleLayerBean.getFeed() == null) {
            feed = feedCloudMeta$StFeed;
        } else {
            feed = qCircleLayerBean.getFeed();
        }
        qCircleLayerBean.setFeed(feed);
        boolean x16 = x();
        if (f.m() != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[jumpFloatingWindowToTargetPage] isJumpToDetailPage: ");
        sb5.append(x16);
        sb5.append(" | play position: ");
        sb5.append(j3);
        sb5.append(" | isResident: ");
        AtomicBoolean atomicBoolean = f425288d;
        sb5.append(atomicBoolean.get());
        sb5.append("|isSplashActivityAlive:");
        sb5.append(z16);
        QLog.d("QFP-QFSFloatingEnterControl", 1, sb5.toString());
        if (!x16 && !atomicBoolean.get() && z16) {
            z(view, context, feed);
            return;
        }
        QFSVideoView M = u.H().M();
        if (M != null) {
            RFWPlayerReuseUtils.prepareToReusePlayer(M);
        }
        A(context, qCircleLayerBean, feedCloudMeta$StFeed, j3);
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class d {
        public void a() {
        }

        public void b() {
        }

        public void c() {
        }
    }
}
