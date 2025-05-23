package com.qzone.widget.util;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.covercomponent.env.CoverEnv;
import com.qzone.proxy.feedcomponent.util.j;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheWeatherData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qzonehub.api.utils.IQzoneOfflineCacheHelper;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes37.dex */
public class QzonePreloadHtmlResourcesHelper {

    /* renamed from: a, reason: collision with root package name */
    private static d f61103a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile HashMap<String, d> f61104b;

    /* renamed from: c, reason: collision with root package name */
    private static Handler f61105c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class b implements d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f61106a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f61107b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f61108c;

        b(long j3, String str, long j16) {
            this.f61106a = j3;
            this.f61107b = str;
            this.f61108c = j16;
        }

        @Override // com.qzone.widget.util.QzonePreloadHtmlResourcesHelper.d
        public void onFinish() {
            QzonePreloadHtmlResourcesHelper.k(this.f61106a, this.f61107b, this.f61108c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class c extends Handler {
        c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 203) {
                Object obj = message.obj;
                if (obj instanceof Bundle) {
                    try {
                        String string = ((Bundle) obj).getString("url");
                        d dVar = (d) QzonePreloadHtmlResourcesHelper.f61104b.remove(string);
                        if (dVar == null) {
                            QZLog.w("PreloadHtml_PreloadAction", "url no callback");
                            return;
                        }
                        if (!CoverEnv.isNetworkAvailable()) {
                            dVar.onFinish();
                            return;
                        }
                        if (!CoverEnv.isWifiConn()) {
                            dVar.onFinish();
                            return;
                        }
                        String n3 = com.tencent.mobileqq.webview.webso.e.n(string);
                        if (TextUtils.isEmpty(n3)) {
                            dVar.onFinish();
                            return;
                        }
                        List<String> a16 = e.a(n3);
                        if (a16 != null && a16.size() != 0) {
                            QzonePreloadHtmlResourcesHelper.h(a16, string);
                            dVar.onFinish();
                            return;
                        }
                        dVar.onFinish();
                    } catch (Exception e16) {
                        QZLog.e("PreloadHtml_PreloadAction", "initPreloadHandler error.", e16);
                    }
                }
            }
        }
    }

    /* loaded from: classes37.dex */
    public interface d {
        void onFinish();
    }

    public static void e(String str, d dVar) {
        if (TextUtils.isEmpty(str) || dVar == null) {
            return;
        }
        if (f61104b == null) {
            f61104b = new HashMap<>();
        }
        f61104b.put(str, dVar);
    }

    private static boolean f() {
        String[] split;
        int i3 = Calendar.getInstance().get(11);
        String config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PRELOAD_SMALL_GAME_ALLOW_HOURS, QzoneConfig.PRELOAD_SMALL_GAME_ALLOW_HOURS_DEFAULT);
        boolean z16 = false;
        if (!TextUtils.isEmpty(config) && (split = config.split(",")) != null && split.length > 0) {
            String valueOf = String.valueOf(i3);
            int length = split.length;
            int i16 = 0;
            while (true) {
                if (i16 >= length) {
                    break;
                }
                if (valueOf.equals(split[i16])) {
                    z16 = true;
                    break;
                }
                i16++;
            }
        }
        if (!z16 && j.h()) {
            j.f("PreloadHtml_PreloadAction", "PreloadAction \u5f53\u524d\u65f6\u95f4\u4e0d\u662f\u95f2\u65f6\uff0c\u4e0d\u9884\u52a0\u8f7d,list=" + config);
        }
        return z16;
    }

    private static boolean g() {
        long config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PRELOAD_SMALL_GAME_INTERVAL_SECONDS, 86400);
        if (j.h()) {
            j.f("PreloadHtml_PreloadAction", "PreloadAction interval=" + config);
        }
        long uin = LoginData.getInstance().getUin();
        if (uin < 10000) {
            j.i("PreloadHtml_PreloadAction", "preloadSmallGame login uin is invalid:" + uin);
            return false;
        }
        if (System.currentTimeMillis() - Math.max(LocalMultiProcConfig.getLong4Uin(QzoneConfig.SP_KEY_PRELOAD_SMALL_GAME_TIMESTAMP, 0L, uin), ((IQzoneOfflineCacheHelper) QRoute.api(IQzoneOfflineCacheHelper.class)).getSmallGameLastCacheTime(uin)) > config * 1000) {
            return true;
        }
        if (j.h()) {
            j.f("PreloadHtml_PreloadAction", "PreloadAction \u6ca1\u6709\u8d85\u8fc7\u65f6\u95f4\u95f4\u9694\uff0c\u7ed3\u675f");
        }
        return false;
    }

    static Handler i() {
        if (f61105c == null) {
            f61105c = new c(QzoneHandlerThreadFactory.getHandlerThreadLooper(QzoneHandlerThreadFactory.BackGroundThread));
        }
        return f61105c;
    }

    public static boolean j(String str) {
        return f61104b != null && f61104b.containsKey(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(long j3, String str, long j16) {
        try {
            if (com.tencent.mobileqq.webview.webso.e.d(str)) {
                long currentTimeMillis = System.currentTimeMillis();
                ((IQzoneOfflineCacheHelper) QRoute.api(IQzoneOfflineCacheHelper.class)).updataSmallGameLastCacheFinishTime(j3, currentTimeMillis);
                j.f("PreloadHtml_PreloadAction", "PreloadAction \u9884\u52a0\u8f7d\u5c0f\u6e38\u620fhtml\u5b8c\u6210.");
                int i3 = Calendar.getInstance().get(11);
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put(WidgetCacheWeatherData.HOUR, String.valueOf(i3));
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(LoginData.getInstance().getUinString(), "qzone_preload_smallgame", true, currentTimeMillis - j16, 0L, hashMap, null);
            }
        } catch (Exception e16) {
            j.j("PreloadHtml_PreloadAction", "onPreloadFinish error", e16);
        }
    }

    public static void l(String str, d dVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (com.tencent.mobileqq.webview.webso.e.D(Uri.parse(str))) {
                if (dVar == null) {
                    if (f61103a == null) {
                        f61103a = new a();
                    }
                    dVar = f61103a;
                }
                if (j(str)) {
                    j.f("PreloadHtml_PreloadAction", "\u6b63\u5728\u9884\u52a0\u8f7d\u4e2d\uff0c\u4e0d\u8981\u91cd\u590d\u5904\u7406 url=" + str);
                    return;
                }
                e(str, dVar);
                CoverEnv.Webso.startWebSoRequest(str, i(), true);
            }
        } catch (Exception e16) {
            j.j("PreloadHtml_PreloadAction", "preloadLoadWnsHtmlAndOfflineResources error", e16);
        }
    }

    public static void m() {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).postDelayed(new Runnable() { // from class: com.qzone.widget.util.QzonePreloadHtmlResourcesHelper.3
            @Override // java.lang.Runnable
            public void run() {
                QzonePreloadHtmlResourcesHelper.n();
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n() {
        try {
            if (1 == QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PRELOAD_SMALL_GAME_HTML_ENABLE, 0)) {
                if (BaseApplication.getContext() == null) {
                    j.c("PreloadHtml_PreloadAction", "preloadSmallGame context is null");
                    return;
                }
                if (CoverEnv.isWifiConn() && f() && g()) {
                    long uin = LoginData.getInstance().getUin();
                    long currentTimeMillis = System.currentTimeMillis();
                    LocalMultiProcConfig.putLong4Uin(QzoneConfig.SP_KEY_PRELOAD_SMALL_GAME_TIMESTAMP, currentTimeMillis, uin);
                    j.f("PreloadHtml_PreloadAction", "PreloadAction \u9884\u52a0\u8f7d\u5c0f\u6e38\u620fhtml");
                    String config = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_GAMEBAR, QzoneConfig.DefaultValue.QZONE_GAMEBAR_URL);
                    l(config, new b(uin, config, currentTimeMillis));
                }
            }
        } catch (Exception e16) {
            j.j("PreloadHtml_PreloadAction", "preloadSmallGameImpl error", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(List<String> list, String str) {
        if (list == null) {
            return;
        }
        int config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PRELOAD_HTML_PAGE_URL_MAX_COUNT, 100);
        int i3 = 0;
        for (String str2 : list) {
            if (((IQzoneWebViewPluginHelper) QRoute.api(IQzoneWebViewPluginHelper.class)).checkOfflineUrl(str2)) {
                i3++;
                if (i3 > config) {
                    QZLog.w("PreloadHtml_PreloadAction", "downloadUrlResources url\u6570\u91cf\u8d85\u8fc7\uff1a" + config + ",lists count=" + list.size());
                    return;
                }
                ((IQzoneWebViewPluginHelper) QRoute.api(IQzoneWebViewPluginHelper.class)).downLoadFileIfNeeded(null, str2, null, true, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class a implements d {
        a() {
        }

        @Override // com.qzone.widget.util.QzonePreloadHtmlResourcesHelper.d
        public void onFinish() {
        }
    }
}
