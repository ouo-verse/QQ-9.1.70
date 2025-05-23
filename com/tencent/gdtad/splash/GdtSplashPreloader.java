package com.tencent.gdtad.splash;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.ICustomAdDataGenerator;
import com.qq.e.comm.util.AdError;
import com.qq.e.tg.splash.PreCacheSplashAd;
import com.qq.e.tg.splash.SplashADPreloadListener;
import com.qq.e.tg.splash.TGSplashPreloader;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.splash.mcconfig.GdtSplashAdSwitchConfigParser;
import com.tencent.gdtad.splash.statistics.GdtSplashReporterForPreloader;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.api.IVasAdvApi;
import com.tencent.mobileqq.vas.adv.common.pb.SplashAd;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.turingfd.sdk.xq.ITuringDID;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class GdtSplashPreloader {

    /* renamed from: a, reason: collision with root package name */
    private GdtSplashReporterForPreloader f109340a = new GdtSplashReporterForPreloader();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class GdtCustomAdDataGeneratorSSO implements ICustomAdDataGenerator {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<GdtSplashReporterForPreloader> f109341a;

        public GdtCustomAdDataGeneratorSSO(WeakReference<GdtSplashReporterForPreloader> weakReference) {
            this.f109341a = weakReference;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str, Map<String, String> map, ICustomAdDataGenerator.LoadADCallback loadADCallback) {
            GdtSplashReporterForPreloader gdtSplashReporterForPreloader;
            WeakReference<GdtSplashReporterForPreloader> weakReference = this.f109341a;
            if (weakReference != null) {
                gdtSplashReporterForPreloader = weakReference.get();
            } else {
                gdtSplashReporterForPreloader = null;
            }
            String s16 = GdtSplashPreloader.s(GdtSplashPreloader.k(map));
            if (TextUtils.isEmpty(s16)) {
                p pVar = new p(2000010);
                if (gdtSplashReporterForPreloader != null) {
                    gdtSplashReporterForPreloader.m(pVar);
                } else {
                    QLog.e("GdtSplashPreloader", 1, "[GdtCustomAdDataGeneratorSSO][loadADImpl] error, reporter is null");
                }
                GdtSplashPreloader.l(loadADCallback, pVar);
                return;
            }
            QLog.i("GdtSplashPreloader", 1, "[GdtCustomAdDataGeneratorSSO][loadADImpl]");
            ((IVasAdvApi) QRoute.api(IVasAdvApi.class)).reqSplashAd(s16, new e(this.f109341a, loadADCallback));
            if (gdtSplashReporterForPreloader != null) {
                gdtSplashReporterForPreloader.o(System.currentTimeMillis());
            } else {
                QLog.e("GdtSplashPreloader", 1, "[GdtCustomAdDataGeneratorSSO][loadADImpl] error, reporter is null");
            }
        }

        @Override // com.qq.e.comm.pi.ICustomAdDataGenerator
        public boolean loadAD(final String str, Map<String, String> map, final ICustomAdDataGenerator.LoadADCallback loadADCallback) {
            GdtSplashReporterForPreloader gdtSplashReporterForPreloader;
            WeakReference<GdtSplashReporterForPreloader> weakReference = this.f109341a;
            if (weakReference != null) {
                gdtSplashReporterForPreloader = weakReference.get();
            } else {
                gdtSplashReporterForPreloader = null;
            }
            if (gdtSplashReporterForPreloader != null) {
                gdtSplashReporterForPreloader.k();
            } else {
                QLog.e("GdtSplashPreloader", 1, "[GdtCustomAdDataGeneratorSSO][loadAD] , reporter is null");
            }
            final HashMap hashMap = new HashMap();
            hashMap.putAll(map);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gdtad.splash.GdtSplashPreloader.GdtCustomAdDataGeneratorSSO.1
                @Override // java.lang.Runnable
                public void run() {
                    GdtCustomAdDataGeneratorSSO.this.b(str, hashMap, loadADCallback);
                }
            }, 128, null, true);
            return true;
        }
    }

    /* loaded from: classes6.dex */
    class a implements SplashADPreloadListener {
        a() {
        }

        @Override // com.qq.e.tg.splash.SplashADPreloadListener
        public void onBackupAdSelected(PreCacheSplashAd preCacheSplashAd) {
            QLog.e("GdtSplashPreloader", 1, "[hotSplashPreloadOnLogin]  onBackupAdSelected");
        }

        @Override // com.qq.e.tg.splash.SplashADPreloadListener
        public void onError(AdError adError) {
            String str;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[hotSplashPreloadOnLogin] onError ");
            if (adError != null) {
                str = adError.getErrorCode() + adError.getErrorMsg();
            } else {
                str = "";
            }
            sb5.append(str);
            QLog.e("GdtSplashPreloader", 1, sb5.toString());
        }

        @Override // com.qq.e.tg.splash.SplashADPreloadListener
        public void onLoadSuccess() {
            QLog.e("GdtSplashPreloader", 1, "[hotSplashPreloadOnLogin]  onLoadSuccess ");
        }
    }

    /* loaded from: classes6.dex */
    class b implements SplashADPreloadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f109346a;

        b(boolean z16) {
            this.f109346a = z16;
        }

        @Override // com.qq.e.tg.splash.SplashADPreloadListener
        public void onBackupAdSelected(PreCacheSplashAd preCacheSplashAd) {
            QLog.e("GdtSplashPreloader", 1, "setHotStart onBackupAdSelected");
            if (this.f109346a && preCacheSplashAd != null && !GuardManager.sInstance.isApplicationForeground()) {
                QLog.e("GdtSplashPreloader", 1, "setHotStart onBackupAdSelected has result");
                Pair<Long, Long> validTimeDuration = preCacheSplashAd.getValidTimeDuration();
                if (validTimeDuration != null) {
                    QLog.e("GdtSplashPreloader", 1, "setHotStart onBackupAdSelected update\uff0c first time is " + (((Long) validTimeDuration.first).longValue() / 1000) + " second time is " + (((Long) validTimeDuration.second).longValue() / 1000) + "time life is " + (preCacheSplashAd.getTimeLife() * 1000));
                    ((IGdtSplashQQLiteAPI) QRoute.api(IGdtSplashQQLiteAPI.class)).updateGdtHotSplashData(new Pair<>(Long.valueOf(((Long) validTimeDuration.first).longValue() / 1000), Long.valueOf(((Long) validTimeDuration.second).longValue() / 1000)));
                }
                ((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).updateGdtHotSplashDuration(Long.valueOf(preCacheSplashAd.getTimeLife() * 1000));
            }
        }

        @Override // com.qq.e.tg.splash.SplashADPreloadListener
        public void onError(AdError adError) {
            String str;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onError ");
            if (adError != null) {
                str = adError.getErrorCode() + adError.getErrorMsg();
            } else {
                str = "";
            }
            sb5.append(str);
            QLog.e("GdtSplashPreloader", 1, sb5.toString());
        }

        @Override // com.qq.e.tg.splash.SplashADPreloadListener
        public void onLoadSuccess() {
            QLog.e("GdtSplashPreloader", 1, "setHotStart onLoadSuccess isRefreshAdRequest\uff1a" + this.f109346a);
        }
    }

    /* loaded from: classes6.dex */
    class c implements SplashADPreloadListener {
        c() {
        }

        @Override // com.qq.e.tg.splash.SplashADPreloadListener
        public void onBackupAdSelected(PreCacheSplashAd preCacheSplashAd) {
            QLog.e("GdtSplashPreloader", 1, "[splashPreload cold]  onBackupAdSelected");
        }

        @Override // com.qq.e.tg.splash.SplashADPreloadListener
        public void onError(AdError adError) {
            String str;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[splashPreload cold] onError ");
            if (adError != null) {
                str = adError.getErrorCode() + adError.getErrorMsg();
            } else {
                str = "";
            }
            sb5.append(str);
            QLog.e("GdtSplashPreloader", 1, sb5.toString());
        }

        @Override // com.qq.e.tg.splash.SplashADPreloadListener
        public void onLoadSuccess() {
            QLog.e("GdtSplashPreloader", 1, "[splashPreload cold]  onLoadSuccess ");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class e implements ez2.c<SplashAd.SplashAdGetRsp> {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<GdtSplashReporterForPreloader> f109351a;

        /* renamed from: b, reason: collision with root package name */
        private ICustomAdDataGenerator.LoadADCallback f109352b;

        public e(WeakReference<GdtSplashReporterForPreloader> weakReference, ICustomAdDataGenerator.LoadADCallback loadADCallback) {
            this.f109351a = weakReference;
            this.f109352b = loadADCallback;
        }

        @Override // ez2.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(int i3, @Nullable SplashAd.SplashAdGetRsp splashAdGetRsp) {
            GdtSplashReporterForPreloader gdtSplashReporterForPreloader;
            WeakReference<GdtSplashReporterForPreloader> weakReference = this.f109351a;
            if (weakReference != null) {
                gdtSplashReporterForPreloader = weakReference.get();
            } else {
                gdtSplashReporterForPreloader = null;
            }
            if (splashAdGetRsp != null && i3 == 0) {
                String str = splashAdGetRsp.ad_rsp.get();
                QLog.i("GdtSplashPreloader", 1, "[GdtVasResultCallback][onResult]");
                if (gdtSplashReporterForPreloader != null) {
                    gdtSplashReporterForPreloader.i();
                } else {
                    QLog.e("GdtSplashPreloader", 1, "[GdtVasResultCallback][onResult] error, reporter is null");
                }
                GdtSplashPreloader.n(this.f109352b, str);
                return;
            }
            QLog.e("GdtSplashPreloader", 1, "[GdtVasResultCallback][onResult] result is null");
            p pVar = new p(i3);
            if (gdtSplashReporterForPreloader != null) {
                gdtSplashReporterForPreloader.g(pVar);
            } else {
                QLog.e("GdtSplashPreloader", 1, "[GdtVasResultCallback][onResult] error, reporter is null");
            }
            GdtSplashPreloader.l(this.f109352b, pVar);
        }
    }

    /* loaded from: classes6.dex */
    public interface f {
        void a(p pVar);

        void onLoadSuccess();
    }

    public static void h() {
        ym0.a.j("Splash_", GdtSplashConstants$MMKV.KEY_SPLASH_LAST_REQUEST_SUCCESS_TIME_STAMP);
    }

    public static long i() {
        return ym0.a.c("Splash_", GdtSplashConstants$MMKV.KEY_SPLASH_LAST_REQUEST_SUCCESS_TIME_STAMP, WebViewConstants.WV.ENABLE_WEBAIO_SWITCH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0041 A[Catch: all -> 0x0022, TryCatch #1 {all -> 0x0022, blocks: (B:39:0x0017, B:41:0x001d, B:8:0x0027, B:11:0x002e, B:12:0x003b, B:14:0x0041, B:27:0x0049, B:17:0x0050, B:24:0x005c, B:20:0x0063, B:30:0x0074, B:32:0x007a, B:36:0x0080), top: B:38:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007a A[Catch: all -> 0x0022, TryCatch #1 {all -> 0x0022, blocks: (B:39:0x0017, B:41:0x001d, B:8:0x0027, B:11:0x002e, B:12:0x003b, B:14:0x0041, B:27:0x0049, B:17:0x0050, B:24:0x005c, B:20:0x0063, B:30:0x0074, B:32:0x007a, B:36:0x0080), top: B:38:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String k(Map<String, String> map) {
        Set<Map.Entry<String, String>> entrySet;
        Uri build;
        try {
            new JSONObject(map).toString();
        } catch (Throwable th5) {
            QLog.e("GdtSplashPreloader", 1, "[mapToUriQueryEncodedString]", th5);
        }
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    entrySet = map.entrySet();
                    if (entrySet != null && !entrySet.isEmpty()) {
                        Uri.Builder builder = new Uri.Builder();
                        for (Map.Entry<String, String> entry : map.entrySet()) {
                            if (entry == null) {
                                QLog.e("GdtSplashPreloader", 1, "entry is null");
                            } else if (TextUtils.isEmpty(entry.getKey())) {
                                QLog.e("GdtSplashPreloader", 1, "entry.getKey() is null");
                            } else {
                                builder = builder.appendQueryParameter(entry.getKey(), entry.getValue());
                            }
                        }
                        build = builder.build();
                        if (build != null) {
                            return null;
                        }
                        return build.getEncodedQuery();
                    }
                    QLog.e("GdtSplashPreloader", 1, "[mapToUriQueryEncodedString] error, entrySet is empty");
                    return null;
                }
            } catch (Throwable th6) {
                QLog.e("GdtSplashPreloader", 1, "[mapToUriQueryEncodedString]", th6);
                return null;
            }
        }
        entrySet = null;
        if (entrySet != null) {
            Uri.Builder builder2 = new Uri.Builder();
            while (r7.hasNext()) {
            }
            build = builder2.build();
            if (build != null) {
            }
        }
        QLog.e("GdtSplashPreloader", 1, "[mapToUriQueryEncodedString] error, entrySet is empty");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(ICustomAdDataGenerator.LoadADCallback loadADCallback, p pVar) {
        int i3;
        if (loadADCallback == null) {
            QLog.e("GdtSplashPreloader", 1, "[notifyFailed] error, callback is null");
            return;
        }
        if (pVar != null) {
            i3 = pVar.a();
        } else {
            i3 = Integer.MIN_VALUE;
        }
        QLog.i("GdtSplashPreloader", 1, "[notifyFailed] callback.onADLoadErr, errorCode:" + i3);
        loadADCallback.onADLoadErr(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(WeakReference<f> weakReference, p pVar) {
        f fVar;
        if (weakReference != null) {
            fVar = weakReference.get();
        } else {
            fVar = null;
        }
        if (fVar == null) {
            QLog.e("GdtSplashPreloader", 1, "[notifyFailed] error, listener is null");
        } else {
            fVar.a(pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n(ICustomAdDataGenerator.LoadADCallback loadADCallback, String str) {
        if (loadADCallback == null) {
            QLog.e("GdtSplashPreloader", 1, "[notifySuccess] error, callback is null");
        } else {
            QLog.i("GdtSplashPreloader", 1, "[notifySuccess] callback.onADLoadSucc");
            loadADCallback.onADLoadSucc(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void o(WeakReference<f> weakReference) {
        f fVar;
        if (weakReference != null) {
            fVar = weakReference.get();
        } else {
            fVar = null;
        }
        if (fVar == null) {
            QLog.e("GdtSplashPreloader", 1, "[notifySuccess] error, listener is null");
        } else {
            fVar.onLoadSuccess();
        }
    }

    public static void q() {
        boolean z16;
        int i3;
        try {
            z16 = com.tencent.gdtad.splash.mcconfig.a.d();
        } catch (Throwable th5) {
            QLog.e("GdtSplashPreloader", 1, "[reportAfterLoginAndMessageLoaded]", th5);
            z16 = false;
        }
        if (!z16) {
            QLog.e("GdtSplashPreloader", 1, "[reportAfterLoginAndMessageLoaded] do nothing, not enabled");
            return;
        }
        p a16 = u.a();
        if (a16 != null) {
            i3 = a16.a();
        } else {
            i3 = Integer.MIN_VALUE;
        }
        if (i3 != 0) {
            QLog.e("GdtSplashPreloader", 1, "[reportAfterLoginAndMessageLoaded] error, errorCode:" + i3);
            return;
        }
        QLog.i("GdtSplashPreloader", 1, "[reportAfterLoginAndMessageLoaded]");
        GdtSplashReporterForPreloader.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String s(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            QLog.e("GdtSplashPreloader", 1, "[updateDeviceInfo] error, input is empty");
            return null;
        }
        ITuringDID c16 = com.tencent.mobileqq.turingfd.c.a().c(false);
        String str3 = "";
        if (c16 == null || TextUtils.isEmpty(c16.getAIDTicket())) {
            str2 = "";
        } else {
            str2 = c16.getAIDTicket();
        }
        if (c16 != null && !TextUtils.isEmpty(c16.getTAIDTicket())) {
            str3 = c16.getTAIDTicket();
        }
        String replaceAll = str.replaceAll("_QQ_OAID_", str2).replaceAll("_QQ_TAID_", str3);
        if (QLog.isColorLevel()) {
            QLog.i("GdtSplashPreloader", 2, "[updateDeviceInfo] aidTicket:" + str2 + " taidTicket:" + str3);
        }
        return replaceAll;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void t() {
        ym0.a.g("Splash_", GdtSplashConstants$MMKV.KEY_SPLASH_LAST_REQUEST_SUCCESS_TIME_STAMP, System.currentTimeMillis());
    }

    public void j() {
        boolean z16;
        int i3;
        try {
            z16 = com.tencent.gdtad.splash.mcconfig.a.d();
        } catch (Throwable th5) {
            QLog.e("GdtSplashPreloader", 1, "[hotSplashPreloadOnLogin]", th5);
            z16 = false;
        }
        if (!z16) {
            QLog.e("GdtSplashPreloader", 1, "[hotSplashPreloadOnLogin] do nothing, not enabled");
            return;
        }
        p a16 = u.a();
        if (a16 != null) {
            i3 = a16.a();
        } else {
            i3 = Integer.MIN_VALUE;
        }
        if (i3 != 0) {
            QLog.e("GdtSplashPreloader", 1, "[hotSplashPreloadOnLogin] error, errorCode:" + i3);
            return;
        }
        LoadAdParams loadAdParams = new LoadAdParams();
        loadAdParams.setRefreshAdRequest(false);
        loadAdParams.setGooglePlayVersion(false);
        loadAdParams.setHotStart(true);
        new TGSplashPreloader(BaseApplication.getContext(), "1109803375", "9065538021425253", loadAdParams, new GdtCustomAdDataGeneratorSSO(null)).execute(new a());
    }

    public void p(AtomicInteger atomicInteger, WeakReference<f> weakReference) {
        boolean z16;
        int i3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            z16 = com.tencent.gdtad.splash.mcconfig.a.d();
        } catch (Throwable th5) {
            QLog.e("GdtSplashPreloader", 1, "[preloadImpl]", th5);
            z16 = false;
        }
        if (!z16) {
            QLog.e("GdtSplashPreloader", 1, "[preloadImpl] do nothing, not enabled");
            m(weakReference, new p(2000002));
            return;
        }
        p a16 = u.a();
        if (a16 != null) {
            i3 = a16.a();
        } else {
            i3 = Integer.MIN_VALUE;
        }
        if (i3 != 0) {
            QLog.e("GdtSplashPreloader", 1, "[preloadImpl] error, errorCode:" + i3);
            m(weakReference, a16);
            return;
        }
        this.f109340a.j(currentTimeMillis);
        if (atomicInteger == null) {
            QLog.e("GdtSplashPreloader", 1, "[preloadImpl] error, errorCode:" + i3);
            m(weakReference, new p(2000001));
            return;
        }
        if (!com.tencent.gdtad.splash.mcconfig.b.b(atomicInteger.getAndIncrement())) {
            QLog.e("GdtSplashPreloader", 1, "[preloadImpl] error, too frequently");
            p pVar = new p(2000011);
            this.f109340a.l(pVar);
            m(weakReference, pVar);
            return;
        }
        LoadAdParams loadAdParams = new LoadAdParams();
        loadAdParams.setGooglePlayVersion(false);
        GdtSplashDeviceInfoUtil.e();
        new TGSplashPreloader(BaseApplication.getContext(), "1109803375", "9065538021425253", loadAdParams, new GdtCustomAdDataGeneratorSSO(new WeakReference(this.f109340a))).execute(new d(new WeakReference(this.f109340a), weakReference));
        this.f109340a.n();
        com.tencent.gdtad.splash.mcconfig.b.d();
    }

    public void r(boolean z16, boolean z17) {
        boolean z18;
        int i3;
        try {
            z18 = com.tencent.gdtad.splash.mcconfig.a.d();
        } catch (Throwable th5) {
            QLog.e("GdtSplashPreloader", 1, "[splashPreload] \uff1a" + z16, th5);
            z18 = false;
        }
        if (!z18) {
            QLog.e("GdtSplashPreloader", 1, "[splashPreload] " + z16 + "do nothing, not enabled");
            return;
        }
        p a16 = u.a();
        if (a16 != null) {
            i3 = a16.a();
        } else {
            i3 = Integer.MIN_VALUE;
        }
        if (i3 != 0) {
            QLog.e("GdtSplashPreloader", 1, "[splashPreload] error, errorCode:" + i3);
            return;
        }
        GdtSplashAdSwitchConfigParser.a b16 = com.tencent.gdtad.splash.mcconfig.a.b();
        if (b16 == null) {
            b16 = new GdtSplashAdSwitchConfigParser.a();
        }
        ArrayList arrayList = new ArrayList(b16.f109389e);
        LoadAdParams loadAdParams = new LoadAdParams();
        loadAdParams.setRefreshAdRequest(z16);
        loadAdParams.setGooglePlayVersion(false);
        loadAdParams.setHotStart(true);
        loadAdParams.setCanSetupRequest(!z17);
        loadAdParams.setBlackAidList(arrayList);
        new TGSplashPreloader(BaseApplication.getContext(), "1109803375", "9065538021425253", loadAdParams, new GdtCustomAdDataGeneratorSSO(null)).execute(new b(z16));
        LoadAdParams loadAdParams2 = new LoadAdParams();
        loadAdParams2.setRefreshAdRequest(z16);
        loadAdParams.setGooglePlayVersion(false);
        loadAdParams2.setHotStart(false);
        loadAdParams2.setBlackAidList(arrayList);
        loadAdParams2.setCanSetupRequest(!z17);
        new TGSplashPreloader(BaseApplication.getContext(), "1109803375", "9065538021425253", loadAdParams2, new GdtCustomAdDataGeneratorSSO(null)).execute(new c());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class d implements SplashADPreloadListener {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<GdtSplashReporterForPreloader> f109349a;

        /* renamed from: b, reason: collision with root package name */
        private WeakReference<f> f109350b;

        public d(WeakReference<GdtSplashReporterForPreloader> weakReference, WeakReference<f> weakReference2) {
            this.f109349a = weakReference;
            this.f109350b = weakReference2;
        }

        @Override // com.qq.e.tg.splash.SplashADPreloadListener
        public void onError(AdError adError) {
            int i3;
            GdtSplashReporterForPreloader gdtSplashReporterForPreloader;
            int i16 = Integer.MIN_VALUE;
            if (adError != null) {
                i3 = adError.getErrorCode();
            } else {
                i3 = Integer.MIN_VALUE;
            }
            if (adError != null) {
                i16 = adError.getSubErrorCode();
            }
            QLog.e("GdtSplashPreloader", 1, "[GdtSplashPreLoadListener][onError] errorCode:" + i3 + " subErrorCode:" + i16);
            p pVar = new p(2000100, i3, i16);
            WeakReference<GdtSplashReporterForPreloader> weakReference = this.f109349a;
            if (weakReference != null) {
                gdtSplashReporterForPreloader = weakReference.get();
            } else {
                gdtSplashReporterForPreloader = null;
            }
            if (gdtSplashReporterForPreloader != null) {
                gdtSplashReporterForPreloader.f(pVar);
            } else {
                QLog.i("GdtSplashPreloader", 1, "[GdtSplashPreLoadListener][onError] error, reporter is null");
            }
            GdtSplashPreloader.m(this.f109350b, pVar);
        }

        @Override // com.qq.e.tg.splash.SplashADPreloadListener
        public void onLoadSuccess() {
            GdtSplashReporterForPreloader gdtSplashReporterForPreloader;
            QLog.i("GdtSplashPreloader", 1, "[GdtSplashPreLoadListener][onLoadSuccess]");
            GdtSplashPreloader.t();
            WeakReference<GdtSplashReporterForPreloader> weakReference = this.f109349a;
            if (weakReference != null) {
                gdtSplashReporterForPreloader = weakReference.get();
            } else {
                gdtSplashReporterForPreloader = null;
            }
            if (gdtSplashReporterForPreloader != null) {
                gdtSplashReporterForPreloader.h();
            } else {
                QLog.i("GdtSplashPreloader", 1, "[GdtSplashPreLoadListener][onLoadSuccess] error, reporter is null");
            }
            GdtSplashPreloader.o(this.f109350b);
        }

        @Override // com.qq.e.tg.splash.SplashADPreloadListener
        public void onBackupAdSelected(PreCacheSplashAd preCacheSplashAd) {
        }
    }
}
