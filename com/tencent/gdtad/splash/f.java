package com.tencent.gdtad.splash;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.util.AdError;
import com.qq.e.tg.splash.PreCacheSplashAd;
import com.qq.e.tg.splash.SplashOrder;
import com.qq.e.tg.splash.TGSplashAD;
import com.qq.e.tg.splash.TGSplashAdListenerV3;
import com.qq.e.tg.splash.TGSplashHotLaunchHelper;
import com.qq.e.tg.splash.TGSplashPreCacheResult;
import com.qq.e.tg.splash.TGSplashPreCacheUtil;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.IRealTimeConfigApi;
import com.tencent.gdtad.splash.GdtSplashPreloader;
import com.tencent.gdtad.splash.f;
import com.tencent.gdtad.splash.mcconfig.GdtSplashAdSwitchConfigParser;
import com.tencent.gdtad.splash.statistics.GdtSplashReporterUtil;
import com.tencent.gdtad.splash.view.GdtSplashAdViewBuilder;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.ad.api.IAdApi;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0003K+.B\t\b\u0002\u00a2\u0006\u0004\bI\u0010JJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\u000b\u001a\u00020\n2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\"\u0010\u0012\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u0010\u0014\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0002J\u0014\u0010\u0016\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00150\u0006J0\u0010\u001b\u001a\u00020\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00062\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J0\u0010\u001e\u001a\u00020\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00062\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00150\u0006J0\u0010\u001f\u001a\u00020\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00062\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u000e\u0010\"\u001a\u00020\n2\u0006\u0010!\u001a\u00020 J\u0006\u0010#\u001a\u00020\nJ\u0006\u0010$\u001a\u00020\nJ\u0006\u0010%\u001a\u00020\nJ\u0016\u0010'\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u0002J\u0006\u0010(\u001a\u00020\nJ\u0006\u0010)\u001a\u00020\nR\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010A\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010>R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010H\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010G\u00a8\u0006L"}, d2 = {"Lcom/tencent/gdtad/splash/f;", "", "", "isRefreshAdRequest", "Lcom/qq/e/tg/splash/TGSplashAD;", "k", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/gdtad/splash/w;", "callback", "isOlympicSplashCancel", "", "l", "", "eventId", HippyTKDListViewAdapter.X, "", "isRealTime", "aid", "v", PM.SPLASH_AD, "w", "Lcom/tencent/mobileqq/splash/a;", "p", "Landroid/app/Activity;", "weakActivity", "Landroid/view/ViewGroup;", "weakContainer", "y", "weakCallback", "callBack", "r", "t", "", "adShowDuration", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "o", "j", "u", "isSplashRequestLimit", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "Lcom/qq/e/tg/splash/TGSplashHotLaunchHelper;", "b", "Lcom/qq/e/tg/splash/TGSplashHotLaunchHelper;", "mHotLaunchHelper", "c", "J", "mAdShowDuration", "Lcom/tencent/gdtad/splash/view/GdtSplashAdViewBuilder;", "d", "Lcom/tencent/gdtad/splash/view/GdtSplashAdViewBuilder;", "mSplashAdViewBuilder", "Lcom/qq/e/tg/splash/TGSplashHotLaunchHelper$PrepareSplashImageListener;", "e", "Lcom/qq/e/tg/splash/TGSplashHotLaunchHelper$PrepareSplashImageListener;", "mPrepareListener", "Lcom/tencent/gdtad/splash/statistics/a;", "f", "Lcom/tencent/gdtad/splash/statistics/a;", "mReporter", "g", "Lcom/qq/e/tg/splash/TGSplashAD;", "mRealTimeSplash", tl.h.F, "mNormalSplash", "Lcom/qq/e/tg/splash/SplashOrder;", "i", "Lcom/qq/e/tg/splash/SplashOrder;", "mRealtimeSplashOrder", "Lcom/tencent/gdtad/splash/f$c;", "Lcom/tencent/gdtad/splash/f$c;", "mRealtimeSplashListener", "<init>", "()V", "a", "gdt-ad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class f {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static TGSplashHotLaunchHelper mHotLaunchHelper;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static GdtSplashAdViewBuilder mSplashAdViewBuilder;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static TGSplashHotLaunchHelper.PrepareSplashImageListener mPrepareListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static com.tencent.gdtad.splash.statistics.a mReporter;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static TGSplashAD mRealTimeSplash;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static TGSplashAD mNormalSplash;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static SplashOrder mRealtimeSplashOrder;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static c mRealtimeSplashListener;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f109360a = new f();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static long mAdShowDuration = 5000;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0004\b\u0010\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R(\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/gdtad/splash/f$a;", "Lcom/qq/e/tg/splash/TGSplashHotLaunchHelper$PrepareSplashImageListener;", "", "onPrepareSuccess", "", "p0", "onPrepareFailed", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/splash/a;", "a", "Ljava/lang/ref/WeakReference;", "getCallback", "()Ljava/lang/ref/WeakReference;", IECSearchBar.METHOD_SET_CALLBACK, "(Ljava/lang/ref/WeakReference;)V", "callback", "<init>", "gdt-ad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a implements TGSplashHotLaunchHelper.PrepareSplashImageListener {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private WeakReference<com.tencent.mobileqq.splash.a> callback;

        public a(@NotNull WeakReference<com.tencent.mobileqq.splash.a> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.callback = callback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(a this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            com.tencent.mobileqq.splash.a aVar = this$0.callback.get();
            if (aVar != null) {
                QLog.e("GdtHotSplashManager", 1, "onPrepareFailed");
                aVar.a(false);
                f fVar = f.f109360a;
                fVar.w(fVar.k(false));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(a this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            com.tencent.mobileqq.splash.a aVar = this$0.callback.get();
            if (aVar != null) {
                QLog.e("GdtHotSplashManager", 1, "onPrepareSuccess");
                aVar.a(true);
            }
        }

        @Override // com.qq.e.tg.splash.TGSplashHotLaunchHelper.PrepareSplashImageListener
        public void onPrepareFailed(int p06) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.gdtad.splash.d
                @Override // java.lang.Runnable
                public final void run() {
                    f.a.c(f.a.this);
                }
            });
        }

        @Override // com.qq.e.tg.splash.TGSplashHotLaunchHelper.PrepareSplashImageListener
        public void onPrepareSuccess() {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.gdtad.splash.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.a.d(f.a.this);
                }
            });
        }
    }

    static {
        o.b();
    }

    f() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TGSplashAD k(boolean isRefreshAdRequest) {
        TGSplashAD tGSplashAD = new TGSplashAD(BaseApplication.context, null, "1109803375", "9065538021425253", null, Integer.MIN_VALUE, null);
        LoadAdParams loadAdParams = new LoadAdParams();
        loadAdParams.setHotStart(true);
        loadAdParams.setRefreshAdRequest(isRefreshAdRequest);
        tGSplashAD.setLoadAdParams(loadAdParams);
        return tGSplashAD;
    }

    private final void l(WeakReference<w> callback, boolean isOlympicSplashCancel) {
        int i3;
        if (isOlympicSplashCancel) {
            i3 = 1316022;
        } else {
            i3 = 1316024;
        }
        x(i3);
        w wVar = callback.get();
        if (wVar != null) {
            wVar.onDurationUpdate(0L);
        }
        w wVar2 = callback.get();
        if (wVar2 != null) {
            wVar2.a(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q() {
        GdtSplashAdViewBuilder gdtSplashAdViewBuilder = new GdtSplashAdViewBuilder();
        mSplashAdViewBuilder = gdtSplashAdViewBuilder;
        gdtSplashAdViewBuilder.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s() {
        GdtSplashAdViewBuilder gdtSplashAdViewBuilder = new GdtSplashAdViewBuilder();
        mSplashAdViewBuilder = gdtSplashAdViewBuilder;
        gdtSplashAdViewBuilder.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(String eventId, boolean isRealTime, String aid) {
        String str;
        Map<String, String> params = ((IAdApi) QRoute.api(IAdApi.class)).getReportParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put(u.f109451f, u.f109453h);
        String str2 = u.f109452g;
        if (isRealTime) {
            str = u.f109453h;
        } else {
            str = u.f109454i;
        }
        params.put(str2, str);
        if (aid != null) {
            params.put(u.f109450e, aid);
        }
        ((IAdApi) QRoute.api(IAdApi.class)).report(eventId, params);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(TGSplashAD splashAD) {
        if (TextUtils.isEmpty(((IGdtAPI) QRoute.api(IGdtAPI.class)).getSplashEmptyReportExp())) {
            TGSplashHotLaunchHelper tGSplashHotLaunchHelper = mHotLaunchHelper;
            if (tGSplashHotLaunchHelper != null) {
                tGSplashHotLaunchHelper.reportEmptyOrderHotLaunch(splashAD);
                return;
            }
            return;
        }
        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).updateSplashEmptyOrderParams(true, true, 1003);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(int eventId) {
        GdtSplashReporterUtil.e(new com.tencent.gdtad.splash.statistics.b(eventId));
    }

    public final void A(long adShowDuration) {
        if (adShowDuration >= 0 && adShowDuration <= 7500) {
            mAdShowDuration = adShowDuration;
        } else {
            mAdShowDuration = 5000L;
        }
    }

    public final void j() {
        TGSplashHotLaunchHelper tGSplashHotLaunchHelper = mHotLaunchHelper;
        if (tGSplashHotLaunchHelper != null) {
            tGSplashHotLaunchHelper.clearCache();
        }
        mHotLaunchHelper = null;
        mNormalSplash = null;
        GlobalSetting.setiCustomAdDataGenerator(null);
        mRealtimeSplashOrder = null;
        mRealtimeSplashListener = null;
    }

    public final void m() {
        if (!((IGdtAPI) QRoute.api(IGdtAPI.class)).getCanHotAmsSplash()) {
            if (QLog.isColorLevel()) {
                QLog.d("GdtHotSplashManager", 1, "switch close, cancel hotSplashPreloadOnLogin");
                return;
            }
            return;
        }
        new GdtSplashPreloader().j();
    }

    public final void n() {
        int i3;
        String str;
        if (!com.tencent.gdtad.splash.mcconfig.a.e()) {
            QLog.e("GdtHotSplashManager", 1, "splash enable false");
            return;
        }
        p a16 = u.a();
        if (a16 != null) {
            i3 = a16.a();
        } else {
            i3 = Integer.MIN_VALUE;
        }
        if (i3 != 0) {
            QLog.e("GdtHotSplashManager", 1, "onEmptySplash error, canRun errorCode:" + i3);
            return;
        }
        TGSplashPreCacheResult emptyOrderApUrlByDate = TGSplashPreCacheUtil.getEmptyOrderApUrlByDate("9065538021425253", TGSplashPreCacheUtil.getTodayDate());
        if (emptyOrderApUrlByDate != null && emptyOrderApUrlByDate.getPreCacheSplashAd() != null) {
            str = emptyOrderApUrlByDate.getPreCacheSplashAd().getApUrl();
        } else {
            str = null;
        }
        com.tencent.gdtad.splash.statistics.a aVar = new com.tencent.gdtad.splash.statistics.a();
        mReporter = aVar;
        aVar.b(str);
        mHotLaunchHelper = new TGSplashHotLaunchHelper();
        w(k(true));
    }

    public final void o() {
        ((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).reportForAnalysis(1316011);
        w(k(false));
        j();
    }

    public final boolean p(@NotNull WeakReference<com.tencent.mobileqq.splash.a> callback) {
        String str;
        boolean z16;
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!com.tencent.gdtad.splash.mcconfig.a.e()) {
            QLog.e("GdtHotSplashManager", 1, "[prepare] error, not enabled");
            return false;
        }
        p a16 = u.a();
        Intrinsics.checkNotNullExpressionValue(a16, "canRun()");
        int a17 = a16.a();
        if (a17 != 0) {
            QLog.e("GdtHotSplashManager", 1, "[prepare] error, canRun errorCode:" + a17);
            return false;
        }
        if (((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).checkSplashShowtime()) {
            ((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).reportForAnalysis(1316015);
            QLog.e("GdtHotSplashManager", 1, "[prepare] error, check splash show time limit");
            return false;
        }
        TGSplashPreCacheResult emptyOrderApUrlByDate = TGSplashPreCacheUtil.getEmptyOrderApUrlByDate("9065538021425253", TGSplashPreCacheUtil.getTodayDate());
        if (emptyOrderApUrlByDate != null && emptyOrderApUrlByDate.getPreCacheSplashAd() != null) {
            str = emptyOrderApUrlByDate.getPreCacheSplashAd().getApUrl();
        } else {
            str = null;
        }
        com.tencent.gdtad.splash.statistics.a aVar = new com.tencent.gdtad.splash.statistics.a();
        mReporter = aVar;
        aVar.b(str);
        TGSplashHotLaunchHelper tGSplashHotLaunchHelper = new TGSplashHotLaunchHelper();
        mHotLaunchHelper = tGSplashHotLaunchHelper;
        if (tGSplashHotLaunchHelper.canShow()) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.gdtad.splash.statistics.a aVar2 = mReporter;
        if (aVar2 != null) {
            aVar2.a(z16);
        }
        if (!z16) {
            w(k(false));
            return false;
        }
        u.h(System.currentTimeMillis());
        mPrepareListener = new a(callback);
        TGSplashHotLaunchHelper tGSplashHotLaunchHelper2 = mHotLaunchHelper;
        if (tGSplashHotLaunchHelper2 != null) {
            tGSplashHotLaunchHelper2.prepare(BaseApplication.context, new WeakReference<>(mPrepareListener));
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gdtad.splash.b
            @Override // java.lang.Runnable
            public final void run() {
                f.q();
            }
        }, 64, null, true);
        long j3 = mAdShowDuration;
        if (j3 < 500 || j3 > 7500) {
            mAdShowDuration = 5000L;
        }
        return true;
    }

    public final void r(@NotNull WeakReference<Activity> weakActivity, @NotNull WeakReference<w> weakCallback, @NotNull WeakReference<com.tencent.mobileqq.splash.a> callBack) {
        Intrinsics.checkNotNullParameter(weakActivity, "weakActivity");
        Intrinsics.checkNotNullParameter(weakCallback, "weakCallback");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        if (!com.tencent.gdtad.splash.mcconfig.a.e()) {
            QLog.e("GdtHotSplashManager", 1, "[prepare] error, not enabled");
            return;
        }
        p a16 = u.a();
        Intrinsics.checkNotNullExpressionValue(a16, "canRun()");
        int a17 = a16.a();
        if (a17 != 0) {
            QLog.e("GdtHotSplashManager", 1, "[prepare] error, canRun errorCode:" + a17);
            return;
        }
        Activity activity = weakActivity.get();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gdtad.splash.c
            @Override // java.lang.Runnable
            public final void run() {
                f.s();
            }
        }, 64, null, true);
        c cVar = new c();
        mRealtimeSplashListener = cVar;
        cVar.d(callBack);
        c cVar2 = mRealtimeSplashListener;
        if (cVar2 != null) {
            cVar2.c(weakCallback);
        }
        mRealTimeSplash = new TGSplashAD(activity, null, "1109803375", "9065538021425253", mRealtimeSplashListener, (int) ((IRealTimeConfigApi) QRoute.api(IRealTimeConfigApi.class)).getRealTimeSplashDelayTime(), null);
        GdtSplashAdSwitchConfigParser.a b16 = com.tencent.gdtad.splash.mcconfig.a.b();
        if (b16 == null) {
            b16 = new GdtSplashAdSwitchConfigParser.a();
        }
        GlobalSetting.setiCustomAdDataGenerator(new GdtSplashPreloader.GdtCustomAdDataGeneratorSSO(null));
        ArrayList arrayList = new ArrayList(b16.f109389e);
        LoadAdParams loadAdParams = new LoadAdParams();
        loadAdParams.setBlackAidList(arrayList);
        loadAdParams.setHotStart(true);
        loadAdParams.setCanDownloadSrcInRealtimeSelect(((IRealTimeConfigApi) QRoute.api(IRealTimeConfigApi.class)).getRealTimeSplashDownloadRes());
        loadAdParams.setPassThroughInfo(u.c(false));
        TGSplashAD tGSplashAD = mRealTimeSplash;
        if (tGSplashAD != null) {
            tGSplashAD.setLoadAdParams(loadAdParams);
        }
        TGSplashAD tGSplashAD2 = mRealTimeSplash;
        if (tGSplashAD2 != null) {
            tGSplashAD2.fetchAdOnly();
        }
        n nVar = n.f109392a;
        nVar.v();
        nVar.r();
        nVar.t();
        x(1316017);
    }

    public final void t(@NotNull WeakReference<Activity> weakActivity, @NotNull WeakReference<ViewGroup> weakContainer, @NotNull WeakReference<w> callback) {
        boolean z16;
        String str;
        Intrinsics.checkNotNullParameter(weakActivity, "weakActivity");
        Intrinsics.checkNotNullParameter(weakContainer, "weakContainer");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!u.d(weakActivity.get())) {
            QLog.e("GdtHotSplashManager", 1, "[realTimeSelectShow] error, orientation not supported");
            l(callback, true);
            return;
        }
        ViewGroup viewGroup = weakContainer.get();
        if (viewGroup == null) {
            QLog.e("GdtHotSplashManager", 1, "[realTimeSelectShow] error, container is null");
            l(callback, true);
            return;
        }
        GdtSplashAdViewBuilder gdtSplashAdViewBuilder = mSplashAdViewBuilder;
        if (gdtSplashAdViewBuilder == null) {
            QLog.e("GdtHotSplashManager", 1, "[realTimeSelectShow] error, gdtSplashAdView is null");
            l(callback, true);
            return;
        }
        SplashOrder splashOrder = mRealtimeSplashOrder;
        if (splashOrder == null) {
            QLog.e("GdtHotSplashManager", 1, "[realTimeShow] error, mRealTimeSplashOrder is null");
            l(callback, true);
            return;
        }
        if (mRealTimeSplash == null) {
            QLog.e("GdtHotSplashManager", 1, "[realTimeShow] error, mRealTimeSplash is null");
            l(callback, true);
            return;
        }
        if (splashOrder != null && !splashOrder.isOlympicGallery()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (!((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).isAmsSplashExceedLimit(false) && !((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).checkSplashShowtime()) {
                ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).updateAmsSplashShowTime(false, true);
                u.h(System.currentTimeMillis());
                x(1316023);
            } else {
                QLog.e("GdtHotSplashManager", 1, "[realTimeShow] error, SplashExceedLimit");
                l(callback, false);
                return;
            }
        } else {
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).updateAmsSplashShowTime(false, false);
            n.f109392a.n();
            x(1316021);
        }
        TGSplashAD tGSplashAD = mRealTimeSplash;
        if (tGSplashAD != null) {
            tGSplashAD.setSkipView(gdtSplashAdViewBuilder.f());
        }
        TGSplashAD tGSplashAD2 = mRealTimeSplash;
        if (tGSplashAD2 != null) {
            tGSplashAD2.setNeedUseCustomFloatViewPosition(true);
        }
        TGSplashAD tGSplashAD3 = mRealTimeSplash;
        if (tGSplashAD3 != null) {
            tGSplashAD3.setFloatView(gdtSplashAdViewBuilder.e());
        }
        if (mRealtimeSplashOrder != null) {
            mAdShowDuration = r8.getExposureDelay() * 1000;
        }
        w wVar = callback.get();
        if (wVar != null) {
            wVar.onDurationUpdate(mAdShowDuration);
        }
        GdtSplashAdSwitchConfigParser.a b16 = com.tencent.gdtad.splash.mcconfig.a.b();
        TGSplashAD.SplashDisplayParams splashDisplayParams = new TGSplashAD.SplashDisplayParams();
        splashDisplayParams.container = viewGroup;
        splashDisplayParams.firstFrameTimeout = b16.f109388d;
        c cVar = mRealtimeSplashListener;
        if (cVar != null) {
            cVar.c(callback);
        }
        TGSplashAD tGSplashAD4 = mRealTimeSplash;
        if (tGSplashAD4 != null) {
            tGSplashAD4.showAd(splashDisplayParams);
        }
        String SPLASH_AD_EXPOSURE = u.f109447b;
        Intrinsics.checkNotNullExpressionValue(SPLASH_AD_EXPOSURE, "SPLASH_AD_EXPOSURE");
        SplashOrder splashOrder2 = mRealtimeSplashOrder;
        if (splashOrder2 != null) {
            str = splashOrder2.getCl();
        } else {
            str = null;
        }
        v(SPLASH_AD_EXPOSURE, true, str);
    }

    public final void u() {
        TGSplashAD tGSplashAD = mRealTimeSplash;
        if (tGSplashAD != null) {
            tGSplashAD.doRecycleBeforeSplashDismiss();
        }
        mRealTimeSplash = null;
        TGSplashAD tGSplashAD2 = mNormalSplash;
        if (tGSplashAD2 != null) {
            tGSplashAD2.doRecycleBeforeSplashDismiss();
        }
    }

    public final void y(@NotNull WeakReference<Activity> weakActivity, @NotNull WeakReference<ViewGroup> weakContainer, @NotNull WeakReference<w> callback) {
        String str;
        TGSplashPreCacheResult preCacheBackupOrder;
        PreCacheSplashAd preCacheSplashAd;
        Intrinsics.checkNotNullParameter(weakActivity, "weakActivity");
        Intrinsics.checkNotNullParameter(weakContainer, "weakContainer");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Activity activity = weakActivity.get();
        mNormalSplash = new TGSplashAD(activity, null, "1109803375", "9065538021425253", new b(callback), Integer.MIN_VALUE, null);
        GdtSplashAdSwitchConfigParser.a b16 = com.tencent.gdtad.splash.mcconfig.a.b();
        if (b16 == null) {
            b16 = new GdtSplashAdSwitchConfigParser.a();
        }
        ArrayList arrayList = new ArrayList(b16.f109389e);
        LoadAdParams loadAdParams = new LoadAdParams();
        loadAdParams.setBlackAidList(arrayList);
        loadAdParams.setHotStart(true);
        TGSplashAD tGSplashAD = mNormalSplash;
        if (tGSplashAD != null) {
            tGSplashAD.setLoadAdParams(loadAdParams);
        }
        if (activity == null) {
            QLog.e("GdtHotSplashManager", 1, "[show] error, activity is null");
            w wVar = callback.get();
            if (wVar != null) {
                wVar.a(0L);
            }
            w(mNormalSplash);
            return;
        }
        if (!u.d(activity)) {
            QLog.e("GdtHotSplashManager", 1, "[show] error, orientation not supported");
            w wVar2 = callback.get();
            if (wVar2 != null) {
                wVar2.a(0L);
                return;
            }
            return;
        }
        if (weakContainer.get() == null) {
            QLog.e("GdtHotSplashManager", 1, "[show] error, container is null");
            w wVar3 = callback.get();
            if (wVar3 != null) {
                wVar3.a(0L);
            }
            w(mNormalSplash);
            return;
        }
        GdtSplashAdViewBuilder gdtSplashAdViewBuilder = mSplashAdViewBuilder;
        if (gdtSplashAdViewBuilder == null) {
            QLog.e("GdtHotSplashManager", 1, "[show] error, gdtSplashAdView is null");
            w wVar4 = callback.get();
            if (wVar4 != null) {
                wVar4.a(0L);
            }
            w(mNormalSplash);
            return;
        }
        if (mHotLaunchHelper == null) {
            QLog.e("GdtHotSplashManager", 1, "[show] error, mHotLaunchHelper is null");
            w wVar5 = callback.get();
            if (wVar5 != null) {
                wVar5.a(0L);
            }
            w(mNormalSplash);
            return;
        }
        QLog.e("GdtHotSplashManager", 1, "[show] api called");
        TGSplashAD tGSplashAD2 = mNormalSplash;
        if (tGSplashAD2 != null) {
            tGSplashAD2.setSkipView(gdtSplashAdViewBuilder.f());
        }
        TGSplashAD tGSplashAD3 = mNormalSplash;
        if (tGSplashAD3 != null) {
            tGSplashAD3.setNeedUseCustomFloatViewPosition(true);
        }
        TGSplashAD tGSplashAD4 = mNormalSplash;
        if (tGSplashAD4 != null) {
            tGSplashAD4.setFloatView(gdtSplashAdViewBuilder.e());
        }
        w wVar6 = callback.get();
        if (wVar6 != null) {
            wVar6.onDurationUpdate(mAdShowDuration);
        }
        TGSplashHotLaunchHelper tGSplashHotLaunchHelper = mHotLaunchHelper;
        if (tGSplashHotLaunchHelper != null) {
            tGSplashHotLaunchHelper.show(mNormalSplash, weakContainer.get(), 5000L);
        }
        String SPLASH_AD_EXPOSURE = u.f109447b;
        Intrinsics.checkNotNullExpressionValue(SPLASH_AD_EXPOSURE, "SPLASH_AD_EXPOSURE");
        TGSplashHotLaunchHelper tGSplashHotLaunchHelper2 = mHotLaunchHelper;
        if (tGSplashHotLaunchHelper2 != null && (preCacheBackupOrder = tGSplashHotLaunchHelper2.getPreCacheBackupOrder()) != null && (preCacheSplashAd = preCacheBackupOrder.getPreCacheSplashAd()) != null) {
            str = preCacheSplashAd.getAid();
        } else {
            str = null;
        }
        v(SPLASH_AD_EXPOSURE, false, str);
    }

    public final void z(boolean isRefreshAdRequest, boolean isSplashRequestLimit) {
        QLog.d("GdtHotSplashManager", 1, "splashPreload isRefreshAdRequest \uff1a" + isRefreshAdRequest + " isSplashRequestLimit \uff1a" + isSplashRequestLimit);
        new GdtSplashPreloader().r(isRefreshAdRequest, isSplashRequestLimit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u00a2\u0006\u0004\b\u001c\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016R(\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/gdtad/splash/f$b;", "Lcom/qq/e/tg/splash/TGSplashAdListenerV3;", "Lcom/qq/e/tg/splash/SplashOrder;", "splashOrder", "", "onADFetchWithResult", "onLimitAdViewClicked", "onADDismissed", "Lcom/qq/e/comm/util/AdError;", "adError", "onNoAD", "onADPresent", "onADClicked", "", "l", "onADTick", "onADExposure", "onADFetch", "onADSkip", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/gdtad/splash/w;", "a", "Ljava/lang/ref/WeakReference;", "getMWeakCallback", "()Ljava/lang/ref/WeakReference;", "setMWeakCallback", "(Ljava/lang/ref/WeakReference;)V", "mWeakCallback", "<init>", "gdt-ad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements TGSplashAdListenerV3 {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private WeakReference<w> mWeakCallback;

        public b(@NotNull WeakReference<w> mWeakCallback) {
            Intrinsics.checkNotNullParameter(mWeakCallback, "mWeakCallback");
            this.mWeakCallback = mWeakCallback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(AdError adError, b this$0) {
            Intrinsics.checkNotNullParameter(adError, "$adError");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            QLog.e("GdtHotSplashManager", 1, "[onNoAD] errorCode:" + adError.getErrorCode() + " subErrorCode:" + adError.getSubErrorCode());
            w wVar = this$0.mWeakCallback.get();
            if (wVar != null) {
                wVar.onDurationUpdate(0L);
            }
            w wVar2 = this$0.mWeakCallback.get();
            if (wVar2 != null) {
                wVar2.a(0L);
            }
            f fVar = f.f109360a;
            fVar.w(fVar.k(false));
        }

        @Override // com.qq.e.tg.splash.TGSplashAdListener
        public void onADClicked() {
            String str;
            TGSplashPreCacheResult preCacheBackupOrder;
            PreCacheSplashAd preCacheSplashAd;
            QLog.i("GdtHotSplashManager", 1, "[onADClicked]");
            w wVar = this.mWeakCallback.get();
            if (wVar != null) {
                wVar.a(0L);
            }
            f fVar = f.f109360a;
            String SPLASH_AD_CLICK = u.f109448c;
            Intrinsics.checkNotNullExpressionValue(SPLASH_AD_CLICK, "SPLASH_AD_CLICK");
            TGSplashHotLaunchHelper tGSplashHotLaunchHelper = f.mHotLaunchHelper;
            if (tGSplashHotLaunchHelper != null && (preCacheBackupOrder = tGSplashHotLaunchHelper.getPreCacheBackupOrder()) != null && (preCacheSplashAd = preCacheBackupOrder.getPreCacheSplashAd()) != null) {
                str = preCacheSplashAd.getAid();
            } else {
                str = null;
            }
            fVar.v(SPLASH_AD_CLICK, false, str);
        }

        @Override // com.qq.e.tg.splash.TGSplashAdListener
        public void onADDismissed() {
            QLog.i("GdtHotSplashManager", 1, "[onADDismissed]");
            w wVar = this.mWeakCallback.get();
            if (wVar != null) {
                wVar.a(0L);
            }
        }

        @Override // com.qq.e.tg.splash.TGSplashAdListener
        public void onADExposure() {
            QLog.i("GdtHotSplashManager", 1, "[onADExposure]");
        }

        @Override // com.qq.e.tg.splash.TGSplashAdListener
        public void onADFetch() {
            QLog.i("GdtHotSplashManager", 1, "[onADFetch]");
        }

        @Override // com.qq.e.tg.splash.TGSplashAdListenerV2
        public void onADFetchWithResult(@NotNull SplashOrder splashOrder) {
            Intrinsics.checkNotNullParameter(splashOrder, "splashOrder");
            QLog.i("GdtHotSplashManager", 1, "[onADFetchWithResult]");
        }

        @Override // com.qq.e.tg.splash.TGSplashAdListener
        public void onADPresent() {
            QLog.i("GdtHotSplashManager", 1, "[onADPresent]");
            GdtSplashDeviceInfoUtil.d();
        }

        @Override // com.qq.e.tg.splash.TGSplashAdListener
        public void onADSkip() {
            String str;
            TGSplashPreCacheResult preCacheBackupOrder;
            PreCacheSplashAd preCacheSplashAd;
            QLog.i("GdtHotSplashManager", 1, "[onADSkip]");
            w wVar = this.mWeakCallback.get();
            if (wVar != null) {
                wVar.a(0L);
            }
            f fVar = f.f109360a;
            String SPLASH_AD_JUMP_CLICK = u.f109449d;
            Intrinsics.checkNotNullExpressionValue(SPLASH_AD_JUMP_CLICK, "SPLASH_AD_JUMP_CLICK");
            TGSplashHotLaunchHelper tGSplashHotLaunchHelper = f.mHotLaunchHelper;
            if (tGSplashHotLaunchHelper != null && (preCacheBackupOrder = tGSplashHotLaunchHelper.getPreCacheBackupOrder()) != null && (preCacheSplashAd = preCacheBackupOrder.getPreCacheSplashAd()) != null) {
                str = preCacheSplashAd.getAid();
            } else {
                str = null;
            }
            fVar.v(SPLASH_AD_JUMP_CLICK, false, str);
        }

        @Override // com.qq.e.tg.splash.TGSplashAdListener
        public void onADTick(long l3) {
            QLog.i("GdtHotSplashManager", 1, "[onADTick]");
        }

        @Override // com.qq.e.tg.splash.TGSplashAdListener
        public void onNoAD(@NotNull final AdError adError) {
            Intrinsics.checkNotNullParameter(adError, "adError");
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.gdtad.splash.g
                @Override // java.lang.Runnable
                public final void run() {
                    f.b.b(AdError.this, this);
                }
            }, 50L);
        }

        @Override // com.qq.e.tg.splash.TGSplashAdListenerV3
        public void onLimitAdViewClicked() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016R*\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR*\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001e\u0010\u0018\"\u0004\b\u001f\u0010\u001a\u00a8\u0006#"}, d2 = {"Lcom/tencent/gdtad/splash/f$c;", "Lcom/qq/e/tg/splash/TGSplashAdListenerV3;", "Lcom/qq/e/tg/splash/SplashOrder;", "splashOrder", "", "onADFetchWithResult", "onLimitAdViewClicked", "onADDismissed", "Lcom/qq/e/comm/util/AdError;", "adError", "onNoAD", "onADPresent", "onADClicked", "", "l", "onADTick", "onADExposure", "onADFetch", "onADSkip", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/gdtad/splash/w;", "a", "Ljava/lang/ref/WeakReference;", "getMWeakCallback", "()Ljava/lang/ref/WeakReference;", "c", "(Ljava/lang/ref/WeakReference;)V", "mWeakCallback", "Lcom/tencent/mobileqq/splash/a;", "b", "getMWeakPreloadCallback", "d", "mWeakPreloadCallback", "<init>", "()V", "gdt-ad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c implements TGSplashAdListenerV3 {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private WeakReference<w> mWeakCallback;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private WeakReference<com.tencent.mobileqq.splash.a> mWeakPreloadCallback;

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(c this$0) {
            w wVar;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            WeakReference<w> weakReference = this$0.mWeakCallback;
            if (weakReference != null && (wVar = weakReference.get()) != null) {
                wVar.b(0L);
            }
        }

        public final void c(@Nullable WeakReference<w> weakReference) {
            this.mWeakCallback = weakReference;
        }

        public final void d(@Nullable WeakReference<com.tencent.mobileqq.splash.a> weakReference) {
            this.mWeakPreloadCallback = weakReference;
        }

        @Override // com.qq.e.tg.splash.TGSplashAdListener
        public void onADClicked() {
            String str;
            w wVar;
            QLog.i("GdtHotSplashManager", 1, "[RealTime onADClicked]");
            WeakReference<w> weakReference = this.mWeakCallback;
            if (weakReference != null && (wVar = weakReference.get()) != null) {
                wVar.a(0L);
            }
            f fVar = f.f109360a;
            String SPLASH_AD_CLICK = u.f109448c;
            Intrinsics.checkNotNullExpressionValue(SPLASH_AD_CLICK, "SPLASH_AD_CLICK");
            SplashOrder splashOrder = f.mRealtimeSplashOrder;
            if (splashOrder != null) {
                str = splashOrder.getCl();
            } else {
                str = null;
            }
            fVar.v(SPLASH_AD_CLICK, true, str);
            f.mRealtimeSplashOrder = null;
        }

        @Override // com.qq.e.tg.splash.TGSplashAdListener
        public void onADDismissed() {
            w wVar;
            QLog.i("GdtHotSplashManager", 1, "[RealTime onADDismissed]");
            WeakReference<w> weakReference = this.mWeakCallback;
            if (weakReference != null && (wVar = weakReference.get()) != null) {
                wVar.a(0L);
            }
            f.mRealtimeSplashOrder = null;
        }

        @Override // com.qq.e.tg.splash.TGSplashAdListener
        public void onADExposure() {
            QLog.i("GdtHotSplashManager", 1, "[RealTime onADExposure]");
        }

        @Override // com.qq.e.tg.splash.TGSplashAdListener
        public void onADFetch() {
            QLog.i("GdtHotSplashManager", 1, "[RealTime onADFetch]");
        }

        @Override // com.qq.e.tg.splash.TGSplashAdListenerV2
        public void onADFetchWithResult(@Nullable SplashOrder splashOrder) {
            boolean z16;
            com.tencent.mobileqq.splash.a aVar;
            if (splashOrder != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            QLog.i("GdtHotSplashManager", 1, "[RealTime onADFetchWithResult] has order is " + z16);
            f.mRealtimeSplashOrder = splashOrder;
            WeakReference<com.tencent.mobileqq.splash.a> weakReference = this.mWeakPreloadCallback;
            if (weakReference != null && (aVar = weakReference.get()) != null) {
                aVar.a(z16);
            }
            if (!z16) {
                f.f109360a.x(1316025);
            } else {
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.gdtad.splash.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        f.c.b(f.c.this);
                    }
                }, 50L);
            }
        }

        @Override // com.qq.e.tg.splash.TGSplashAdListener
        public void onADPresent() {
            QLog.i("GdtHotSplashManager", 1, "[RealTime onADPresent]");
            GdtSplashDeviceInfoUtil.d();
        }

        @Override // com.qq.e.tg.splash.TGSplashAdListener
        public void onADSkip() {
            String str;
            w wVar;
            QLog.i("GdtHotSplashManager", 1, "[RealTime onADSkip]");
            WeakReference<w> weakReference = this.mWeakCallback;
            if (weakReference != null && (wVar = weakReference.get()) != null) {
                wVar.a(0L);
            }
            f fVar = f.f109360a;
            String SPLASH_AD_JUMP_CLICK = u.f109449d;
            Intrinsics.checkNotNullExpressionValue(SPLASH_AD_JUMP_CLICK, "SPLASH_AD_JUMP_CLICK");
            SplashOrder splashOrder = f.mRealtimeSplashOrder;
            if (splashOrder != null) {
                str = splashOrder.getCl();
            } else {
                str = null;
            }
            fVar.v(SPLASH_AD_JUMP_CLICK, true, str);
            f.mRealtimeSplashOrder = null;
        }

        @Override // com.qq.e.tg.splash.TGSplashAdListener
        public void onADTick(long l3) {
            QLog.i("GdtHotSplashManager", 1, "[RealTime onADTick]");
        }

        @Override // com.qq.e.tg.splash.TGSplashAdListener
        public void onNoAD(@NotNull AdError adError) {
            w wVar;
            Intrinsics.checkNotNullParameter(adError, "adError");
            QLog.e("GdtHotSplashManager", 1, "[RealTime onNoAD] errorCode:" + adError.getErrorCode() + " subErrorCode:" + adError.getSubErrorCode());
            WeakReference<w> weakReference = this.mWeakCallback;
            if (weakReference != null && (wVar = weakReference.get()) != null) {
                wVar.a(0L);
            }
            f.mRealtimeSplashOrder = null;
            f.f109360a.x(1316026);
        }

        @Override // com.qq.e.tg.splash.TGSplashAdListenerV3
        public void onLimitAdViewClicked() {
        }
    }
}
