package com.tencent.biz.qqcircle;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleFaceBitmapListener;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostFaceUtils;
import com.tencent.biz.qqcircle.aspectj.utils.QCircleAnonymousObjectUtils;
import com.tencent.biz.qqcircle.beans.QCircleOpenSharePanelBean;
import com.tencent.biz.qqcircle.debug.mocklbs.data.MockLbsInfo;
import com.tencent.biz.qqcircle.debug.recommend.data.RecExptInfo;
import com.tencent.biz.qqcircle.download.QCircleRichMediaDownLoadManager;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.helpers.QFSFetchFeedCountsHelper;
import com.tencent.biz.qqcircle.helpers.QFSWeakNetworkOptHelper;
import com.tencent.biz.qqcircle.helpers.y;
import com.tencent.biz.qqcircle.immersive.utils.av;
import com.tencent.biz.qqcircle.immersive.utils.bi;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.manager.QFSUsersLiveStatusManager;
import com.tencent.biz.qqcircle.picload.avatar.QCircleAvatarLoader;
import com.tencent.biz.qqcircle.richframework.recycler.QCircleMemoryManager;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.biz.qqcircle.utils.bx;
import com.tencent.biz.richframework.monitor.RFWMonitorManager;
import com.tencent.biz.richframework.video.rfw.player.exp.RFWFastCostExp9095;
import com.tencent.biz.richframework.video.rfw.player.exp.RFWLowDeviceAv1Exp;
import com.tencent.biz.richframework.video.rfw.player.exp.RFWPlayerBusinessStrategyExp9095;
import com.tencent.biz.richframework.video.rfw.player.exp.RFWPlayerPreRenderExp9095;
import com.tencent.biz.richframework.video.rfw.player.exp.RFWVideoFluencyExp9095;
import com.tencent.biz.richframework.video.rfw.player.exp.RFWVideoSystemExp9065;
import com.tencent.biz.richframework.video.rfw.player.monitor.RFWPlayerMonitor;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWLowDeviceStatusMonitorManager;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerPreRenderHelper;
import com.tencent.biz.richframework.video.rfw.player.strategy.RFWPlayerAV1DecodeStrategyV2;
import com.tencent.biz.richframework.video.rfw.player.strategy.RFWServerABTestStrategy;
import com.tencent.biz.richframework.video.rfw.player.videopreload.RFWVideoPreloadManager;
import com.tencent.biz.richframework.video.rfw.view.RFWAudioPlayerManager;
import com.tencent.biz.richframework.video.rfw.view.RFWVideoDurationHelper;
import com.tencent.biz.richframework.video.rfw.view.RFWVideoPlayerManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.auto.engine.lib.ASInject;
import com.tencent.mobileqq.auto.engine.lib.IASEngineDelegate;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.IQCircleConfigApi;
import com.tencent.mobileqq.qcircle.api.global.QCircleUserLabelConfig;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.text.rich.parser.RFWPreloadParseRichTextHelper;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.helpers.QCircleFollowManager;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.QFSAuthorUinMonitorManager;
import cooperation.qqcircle.report.perf.QFSPerfUtils;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
import p40.u;

/* loaded from: classes4.dex */
public class QCirclePluginGlobalInfo {

    /* renamed from: f, reason: collision with root package name */
    private static boolean f82548f;

    /* renamed from: k, reason: collision with root package name */
    public static String f82553k;

    /* renamed from: l, reason: collision with root package name */
    public static volatile FeedCloudMeta$StUser f82554l;

    /* renamed from: n, reason: collision with root package name */
    private static boolean f82556n;

    /* renamed from: r, reason: collision with root package name */
    private static boolean f82560r;

    /* renamed from: s, reason: collision with root package name */
    private static boolean f82561s;

    /* renamed from: u, reason: collision with root package name */
    private static boolean f82563u;

    /* renamed from: v, reason: collision with root package name */
    private static boolean f82564v;

    /* renamed from: w, reason: collision with root package name */
    private static FeedCloudMeta$StFeed f82565w;

    /* renamed from: x, reason: collision with root package name */
    private static e30.b f82566x;

    /* renamed from: y, reason: collision with root package name */
    private static QCircleOpenSharePanelBean f82567y;

    /* renamed from: z, reason: collision with root package name */
    private static Pair<Integer, Boolean> f82568z;

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<String, Integer> f82543a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static int f82544b = uq3.c.v3(6);

    /* renamed from: c, reason: collision with root package name */
    private static final AtomicInteger f82545c = new AtomicInteger(0);

    /* renamed from: d, reason: collision with root package name */
    private static MockLbsInfo f82546d = null;

    /* renamed from: e, reason: collision with root package name */
    private static RecExptInfo f82547e = null;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f82549g = true;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f82550h = true;

    /* renamed from: i, reason: collision with root package name */
    private static boolean f82551i = true;

    /* renamed from: j, reason: collision with root package name */
    public static ConcurrentHashMap<Integer, Boolean> f82552j = new ConcurrentHashMap<>();

    /* renamed from: m, reason: collision with root package name */
    private static ConcurrentHashMap<String, Float> f82555m = new ConcurrentHashMap<>();

    /* renamed from: o, reason: collision with root package name */
    private static String f82557o = "";

    /* renamed from: p, reason: collision with root package name */
    private static String f82558p = "";

    /* renamed from: q, reason: collision with root package name */
    private static int f82559q = -1;

    /* renamed from: t, reason: collision with root package name */
    private static String f82562t = "";

    public static String A() {
        String str = f82558p;
        f82558p = "";
        return str;
    }

    public static e30.b B() {
        return f82566x;
    }

    public static boolean C() {
        return f82561s;
    }

    public static boolean D() {
        return f82564v;
    }

    public static boolean E() {
        return f82556n;
    }

    public static boolean F() {
        return f82550h;
    }

    private static boolean G() {
        Pair<Integer, Boolean> pair = f82568z;
        if (pair != null && ((Boolean) pair.second).booleanValue()) {
            return true;
        }
        return false;
    }

    public static boolean H() {
        return f82548f;
    }

    public static boolean I() {
        return f82549g;
    }

    public static boolean J() {
        AtomicInteger atomicInteger = f82545c;
        if (atomicInteger.get() == 0) {
            return false;
        }
        if (atomicInteger.get() == 1 && QCirclePluginUtil.isTabMode() && !ASInject.g().getAsEngineDelegate().isOnThirdTab(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean K(String str, long j3) {
        com.tencent.rdelivery.reshub.api.g q16;
        String d16;
        try {
            com.tencent.rdelivery.reshub.api.i resHubInstance = ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).getResHubInstance();
            if (resHubInstance.getRDelivery() == null || (q16 = resHubInstance.q(str, true)) == null || (d16 = q16.d()) == null) {
                return false;
            }
            String optString = new JSONObject(d16).optString("so_version");
            if (TextUtils.isEmpty(optString)) {
                return false;
            }
            long parseLong = Long.parseLong(optString.replace(".", ""));
            QLog.d("QCircleGlobalInfo", 1, "is target version:" + optString);
            if (parseLong < j3) {
                return false;
            }
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    public static void L() {
        QCircleMemoryManager.p();
        HostDataTransUtils.setP2POpenStatus(true);
        QFSPerfUtils.enter(QFSPerfUtils.SCENE_BOTTOM_TAB_CLICK);
        RFWLowDeviceStatusMonitorManager.INSTANCE.startMonitor();
        RFWLowDeviceAv1Exp.reportExpExposure();
        RFWVideoSystemExp9065.reportExpExposure();
        RFWVideoFluencyExp9095.reportExpExposure();
        RFWFastCostExp9095.reportExpExposure();
        RFWPlayerBusinessStrategyExp9095.reportExpExposure();
        RFWPlayerPreRenderExp9095.reportExpExposure();
        com.tencent.biz.qqcircle.immersive.tab.c.f90017a.b();
        r60.a.f430818a.f();
        com.tencent.biz.qqcircle.immersive.personal.utils.i.f89085a.a();
        av.d();
        if (RFWPlayerAV1DecodeStrategyV2.g().shouldInject()) {
            RFWPlayerAV1DecodeStrategyV2.g().injectShiplyVersion(y());
        }
        RFWPlayerAV1DecodeStrategyV2.g().triggerDetect();
    }

    public static void M(Context context) {
        com.tencent.biz.qqcircle.immersive.model.barrage.b.b().release();
        com.tencent.biz.qqcircle.immersive.manager.d.c().m();
        QCircleFeedPicLoader.g().release();
        RFWAudioPlayerManager.getInstance().releaseAll();
        RFWPlayerPreRenderHelper.getInstance().releaseRender();
        RFWVideoPreloadManager.g(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).releaseAllPreloadVideo();
        RFWPreloadParseRichTextHelper.g().release();
        QLog.d("QCircleGlobalInfo", 1, "onTabUnSelected clear some instances");
        QCircleMemoryManager.e();
        HostDataTransUtils.setP2POpenStatus(false);
        QFSPerfUtils.exit();
        RFWLowDeviceStatusMonitorManager.INSTANCE.stopMonitor();
        QFSAuthorUinMonitorManager.getInstance().release();
        QCirclePanelStateEvent.resetPanelState(context);
    }

    private static void N() {
        try {
            com.tencent.biz.qqcircle.immersive.model.barrage.b.b().release();
            w20.a.o();
            ha0.a.a().b();
            QFSFetchFeedCountsHelper.v();
            u.H().x0();
            QCircleFeedPicLoader.g().release();
            QCircleAvatarLoader.g().release();
            bi.o();
            QFSUsersLiveStatusManager.i().m();
        } catch (Throwable th5) {
            QLog.e("QCircleGlobalInfo", 1, "[quitQCircleMemoryClear] quit release ex: ", th5);
        }
    }

    private static void O(boolean z16) {
        boolean z17;
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_release_player_when_exit", true)) {
            return;
        }
        boolean G = G();
        if (f82545c.get() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        QLog.d("QCircleGlobalInfo", 1, "releasePlayer: pageCountEmpty:" + z17 + " |forceRelease:" + z16 + " | isFolderCreate:" + G());
        if (z17 || z16 || G) {
            RFWVideoPlayerManager.getInstance().releaseAll();
            RFWAudioPlayerManager.getInstance().releaseAll();
        }
    }

    public static synchronized void P() {
        synchronized (QCirclePluginGlobalInfo.class) {
            QLog.i("QCircleGlobalInfo", 1, "releaseWhenAccountChange");
            QCircleFollowManager.getInstance().clearAll();
            com.tencent.biz.qqcircle.manager.e.b().a();
            QCirclePushInfoManager.e().k();
            f.O();
            Q(true);
            HostDataTransUtils.release();
            HostDataTransUtils.resetAccount();
            com.tencent.biz.qqcircle.immersive.manager.d.c().m();
            Z(false);
            com.tencent.biz.qqcircle.manager.d.b().f();
            RFWMonitorManager.instance().release();
            y.u();
            QCircleAnonymousObjectUtils.release();
            N();
            RFWPlayerPreRenderHelper.getInstance().releaseRender();
            c();
            QCircleMemoryManager.n();
            if (g()) {
                Y(true);
            }
            com.tencent.biz.qqcircle.immersive.manager.f.f().j();
            RFWVideoDurationHelper.g().reset();
            QFSCommentHelper.L().q0();
            com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo.c.INSTANCE.b();
            com.tencent.biz.qqcircle.drawer.i.d();
            l.f();
            h20.c.i();
            QFSWeakNetworkOptHelper.f84577a.e();
            com.tencent.biz.qqcircle.immersive.manager.c.d().a();
            qc0.j.f428831a.g();
        }
    }

    public static synchronized void Q(final boolean z16) {
        synchronized (QCirclePluginGlobalInfo.class) {
            QLog.i("QCircleGlobalInfo", 1, "releaseWhenExitQCircle , forceRelease = " + z16 + " , sPageCounts = " + f82545c.get());
            if (uq3.c.b7()) {
                RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.QCirclePluginGlobalInfo.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QCirclePluginGlobalInfo.e(z16);
                    }
                });
            } else {
                e(z16);
            }
        }
    }

    public static void R(MockLbsInfo mockLbsInfo) {
        f82546d = mockLbsInfo;
    }

    public static void S(@NonNull RecExptInfo recExptInfo) {
        f82547e = recExptInfo;
    }

    public static void T(int i3) {
        f82544b = i3;
    }

    public static void U(String str) {
        f82557o = str;
    }

    public static void V(int i3, boolean z16) {
        if (z16) {
            f82568z = new Pair<>(Integer.valueOf(i3), Boolean.TRUE);
            QLog.d("QCircleGlobalInfo", 1, "setFolderActivityStatus:" + i3 + "|true");
            return;
        }
        Pair<Integer, Boolean> pair = f82568z;
        if (pair == null) {
            f82568z = new Pair<>(Integer.valueOf(i3), Boolean.FALSE);
            QLog.d("QCircleGlobalInfo", 1, "setFolderActivityStatus not create?:" + i3 + "|false");
            return;
        }
        if (((Integer) pair.first).intValue() == i3) {
            f82568z = new Pair<>(Integer.valueOf(i3), Boolean.FALSE);
            QLog.d("QCircleGlobalInfo", 1, "setFolderActivityStatus:" + i3 + "|false");
        }
    }

    public static void W(boolean z16) {
        f82561s = z16;
    }

    public static void X(boolean z16) {
        f82564v = z16;
    }

    public static void Y(boolean z16) {
        f82556n = z16;
    }

    public static void Z(boolean z16) {
        QLog.i("QCircleGlobalInfo", 1, "setIsFirstLogin  sIsFirstLogin = " + H() + " , isFirstLogin = " + z16);
        f82548f = z16;
    }

    public static void a0(boolean z16) {
        QLog.i("QCircleGlobalInfo", 1, "setIsFirstLoginQQ  sIsFirstLoginQQ = " + I() + " , isFirstLoginQQ = " + z16);
        f82549g = z16;
    }

    public static void b0(boolean z16) {
        QLog.i("QCircleGlobalInfo", 1, "setIsFirstShowQFSMantle  sIsFirstShowQFSMantle = " + F() + " , isFirstShowMantle = " + z16);
        f82550h = z16;
    }

    private static void c() {
        f82555m.clear();
    }

    public static void c0(QCircleOpenSharePanelBean qCircleOpenSharePanelBean) {
        f82567y = qCircleOpenSharePanelBean;
    }

    public static FeedCloudMeta$StFeed d() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = f82565w;
        String str = null;
        f82565w = null;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("consumeFastPlayFeed:");
        if (feedCloudMeta$StFeed != null) {
            str = feedCloudMeta$StFeed.f398449id.get();
        }
        sb5.append(str);
        QLog.d("QCircleGlobalInfo", 1, sb5.toString());
        return feedCloudMeta$StFeed;
    }

    public static boolean d0(Integer num) {
        f82552j.put(num, Boolean.TRUE);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(boolean z16) {
        AtomicInteger atomicInteger = f82545c;
        if (atomicInteger.get() == 0 || z16) {
            f82543a.clear();
            QCircleRichMediaDownLoadManager.g().i();
            com.tencent.biz.qqcircle.immersive.manager.d.c().m();
            f82552j.clear();
            b.f82683f.b();
            N();
            QCircleMemoryManager.e();
            QCircleAnonymousObjectUtils.release();
            HostDataTransUtils.setP2POpenStatus(false);
            RFWPlayerMonitor.g().clearPlayRecord();
            QCircleFeedPicLoader.g().deleteSdCacheIfNeed();
            RFWPlayerPreRenderHelper.getInstance().releaseRender();
            com.tencent.biz.qqcircle.immersive.manager.f.f().j();
            com.tencent.biz.qqcircle.immersive.manager.c.d().a();
            QFSAuthorUinMonitorManager.getInstance().release();
            bx.b();
        }
        if (atomicInteger.get() == 0 || z16 || (atomicInteger.get() == 1 && QCirclePluginUtil.isTabMode() && !ASInject.g().getAsEngineDelegate().isOnThirdTab(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE))) {
            QCircleNativeSessionManager.g().exitQCircle();
            QFSPerfUtils.exit();
            O(z16);
            RFWLowDeviceStatusMonitorManager.INSTANCE.stopMonitor();
            z20.f.k().g();
        }
    }

    public static void e0(boolean z16) {
        f82560r = z16;
    }

    public static boolean f() {
        return f82563u;
    }

    public static void f0(int i3) {
        f82559q = i3;
    }

    private static boolean g() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_set_mode_change_flag_when_account_change", true);
    }

    public static void g0(String str) {
        f82562t = str;
    }

    public static void h(Context context) {
        HostDataTransUtils.setP2POpenStatus(true);
        u.H();
        IASEngineDelegate asEngineDelegate = ASInject.g().getAsEngineDelegate();
        int incrementAndGet = f82545c.incrementAndGet();
        if (incrementAndGet == 1 || (incrementAndGet == 2 && QCirclePluginUtil.isTabMode() && ASInject.g().getAsEngineDelegate() != null && (asEngineDelegate == null || !ASInject.g().getAsEngineDelegate().isOnThirdTab(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE)))) {
            if (!QCircleNativeSessionManager.enableSessionReborn()) {
                QCircleNativeSessionManager.g().enterQCircle();
            }
            HostDataTransUtils.setP2POpenStatus(false);
            RFWServerABTestStrategy.g().addNameToSuperPlayer();
        }
        if ((incrementAndGet == 1 && !QCirclePluginUtil.isTabMode()) || (incrementAndGet == 2 && QCirclePluginUtil.isTabMode() && asEngineDelegate != null && !asEngineDelegate.isOnThirdTab(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE))) {
            if (QCircleNativeSessionManager.enableSessionReborn()) {
                QCircleNativeSessionManager.g().enterQCircle();
            }
            QCircleDeviceInfoUtils.updateDeviceLevelV2();
            QFSPerfUtils.enter(QCirclePluginUtil.getCustomPageId(context));
            RFWLowDeviceAv1Exp.reportExpExposure();
            RFWVideoSystemExp9065.reportExpExposure();
            RFWVideoFluencyExp9095.reportExpExposure();
            RFWFastCostExp9095.reportExpExposure();
            RFWPlayerBusinessStrategyExp9095.reportExpExposure();
            RFWPlayerPreRenderExp9095.reportExpExposure();
            RFWLowDeviceStatusMonitorManager.INSTANCE.startMonitor();
            com.tencent.biz.qqcircle.immersive.tab.c.f90017a.b();
            r60.a.f430818a.f();
            com.tencent.biz.qqcircle.immersive.personal.utils.i.f89085a.a();
            av.d();
        }
        QLog.d("QCircleGlobalInfo", 1, "enter a page currentPageCount:" + incrementAndGet);
    }

    public static void h0(String str) {
        f82558p = str;
    }

    public static void i() {
        QLog.d("QCircleGlobalInfo", 1, "exit a page currentPageCount:" + f82545c.decrementAndGet());
    }

    public static void i0(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        f82565w = feedCloudMeta$StFeed;
    }

    public static MockLbsInfo j() {
        return f82546d;
    }

    public static void j0(e30.b bVar) {
        QLog.i("QCircleGlobalInfo", 1, "setWaitSubPageDisplayFeed:" + bVar);
        f82566x = bVar;
    }

    public static RecExptInfo k() {
        if (f82547e == null) {
            String E = f.E();
            if (!TextUtils.isEmpty(E)) {
                try {
                    RecExptInfo recExptInfo = (RecExptInfo) new Gson().fromJson(E, RecExptInfo.class);
                    f82547e = recExptInfo;
                    return recExptInfo;
                } catch (Exception e16) {
                    QLog.e("QCircleGlobalInfo", 1, "getCurRecExptInfo error,exception:", e16);
                    f82547e = RecExptInfo.obtainDefault();
                }
            }
        }
        return f82547e;
    }

    public static void k0(String str, float f16) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f82555m.put(str, Float.valueOf(f16));
    }

    public static String l() {
        return HostDataTransUtils.getAccount();
    }

    public static FeedCloudMeta$StUser m() {
        if (f82554l == null) {
            f82554l = new FeedCloudMeta$StUser();
        }
        PBUInt32Field pBUInt32Field = f82554l.label;
        QCircleUserLabelConfig qCircleUserLabelConfig = QCircleUserLabelConfig.INSTANCE;
        pBUInt32Field.set(qCircleUserLabelConfig.getLabel());
        f82554l.is_e_da_xia.set(qCircleUserLabelConfig.getIsEDaxia());
        f82554l.f398463id.set(HostDataTransUtils.getAccount());
        f82554l.icon.iconUrl.set(uq3.c.J0());
        f82554l.icon.setHasFlag(true);
        f82554l.nick.set(uq3.c.F2());
        if (uq3.c.z4() != null) {
            f82554l.qq_vip.set(ByteStringMicro.copyFrom(uq3.c.z4()));
        }
        return f82554l;
    }

    public static int n() {
        return f82544b;
    }

    public static String o() {
        String str = f82557o;
        f82557o = "";
        return str;
    }

    public static Drawable p(String str) {
        return r(str, 1, null);
    }

    public static Drawable q(String str, int i3) {
        return r(str, i3, null);
    }

    public static Drawable r(String str, int i3, @Nullable QCircleFaceBitmapListener qCircleFaceBitmapListener) {
        if (TextUtils.isEmpty(str)) {
            QLog.d("QCircleGlobalInfo", 1, "getHeadDrawable uin null");
            return QCircleApplication.APP.getResources().getDrawable(R.drawable.ntp);
        }
        Drawable headDrawable = HostFaceUtils.getHeadDrawable(str, i3, qCircleFaceBitmapListener);
        if (headDrawable == null) {
            QLog.d("QCircleGlobalInfo", 1, "getHeadDrawable is return null. ");
            return QCircleApplication.APP.getResources().getDrawable(R.drawable.ntp);
        }
        return headDrawable;
    }

    public static Drawable s(String str, @Nullable QCircleFaceBitmapListener qCircleFaceBitmapListener) {
        return r(str, 1, qCircleFaceBitmapListener);
    }

    public static float t(String str) {
        Float f16 = f82555m.get(str);
        if (!TextUtils.isEmpty(str) && f16 != null) {
            return f16.floatValue();
        }
        return 1.0f;
    }

    public static String u() {
        return ((IQCircleConfigApi) QRoute.api(IQCircleConfigApi.class)).getPluginMark();
    }

    public static String v() {
        if (!TextUtils.isEmpty(f82553k)) {
            return f82553k;
        }
        String pluginQUA = ((IQCircleConfigApi) QRoute.api(IQCircleConfigApi.class)).getPluginQUA();
        f82553k = pluginQUA;
        return pluginQUA;
    }

    public static boolean w() {
        boolean z16 = f82560r;
        f82560r = false;
        return z16;
    }

    public static int x(boolean z16) {
        int i3 = f82559q;
        if (z16) {
            f82559q = -1;
        }
        return i3;
    }

    @NonNull
    private static RFWPlayerAV1DecodeStrategyV2.IShiplyVersion y() {
        return new RFWPlayerAV1DecodeStrategyV2.IShiplyVersion() { // from class: com.tencent.biz.qqcircle.g
            @Override // com.tencent.biz.richframework.video.rfw.player.strategy.RFWPlayerAV1DecodeStrategyV2.IShiplyVersion
            public final boolean isTargetVersion(String str, long j3) {
                boolean K;
                K = QCirclePluginGlobalInfo.K(str, j3);
                return K;
            }
        };
    }

    public static String z() {
        return f82562t;
    }
}
