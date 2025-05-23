package com.tencent.comic;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.comic.api.IQQComicPluginUtil;
import com.tencent.comic.api.IQQComicUtil;
import com.tencent.comic.config.QQComicConfBean;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pluginsdk.PluginConst;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.webbundle.sdk.WebBundleConfig;
import com.tencent.webbundle.sdk.WebBundleH5OptionListner;
import com.tencent.webbundle.sdk.WebBundleLogListener;
import com.tencent.webbundle.sdk.WebBundleManager;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes32.dex */
public class VipComicHelper {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f99165a = false;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f99166b = true;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements WebBundleLogListener {
        a() {
        }

        @Override // com.tencent.webbundle.sdk.WebBundleLogListener
        public void log(int i3, String str, String str2) {
            if (QLog.isColorLevel()) {
                if (i3 == 3) {
                    QLog.d(str, 2, str2);
                    return;
                }
                if (i3 == 4) {
                    QLog.i(str, 2, str2);
                } else if (i3 == 5) {
                    QLog.w(str, 2, str2);
                } else {
                    if (i3 != 6) {
                        return;
                    }
                    QLog.e(str, 2, str2);
                }
            }
        }
    }

    public static String b() {
        String account = com.tencent.comic.utils.a.a().getAccount();
        String string = com.tencent.comic.utils.a.b().getSharedPreferences("ComicGlobalConfig_" + account, 0).getString("defaultComicTab", null);
        if (QLog.isColorLevel()) {
            QLog.d("ComicHelper", 2, "[ComicGlobalConfig] get default tab is " + string);
        }
        return string;
    }

    public static void g(Intent intent) {
        intent.setComponent(new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.QQBrowserActivity"));
        intent.putExtra("fragmentStyle", 1);
        intent.putExtra("tabBarStyle", 1);
        intent.putExtra("titleBarStyle", 1);
        intent.putExtra("hide_operation_bar", true);
        intent.putExtra("hide_more_button", true);
        intent.putExtra("isScreenOrientationPortrait", true);
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        if (!intent.hasExtra("big_brother_source_key")) {
            intent.putExtra("big_brother_source_key", "biz_src_zz_bodong");
        }
        if (!intent.hasExtra("url") || TextUtils.isEmpty(com.tencent.comic.data.f.f99354k)) {
            return;
        }
        String stringExtra = intent.getStringExtra("url");
        intent.putExtra("url", ((IQQComicUtil) QRoute.api(IQQComicUtil.class)).addParamToUrl(stringExtra, "mod=" + com.tencent.comic.data.f.f99354k));
    }

    public static void h(String str) {
        String account = com.tencent.comic.utils.a.a().getAccount();
        SharedPreferences sharedPreferences = com.tencent.comic.utils.a.b().getSharedPreferences("ComicGlobalConfig_" + account, 4);
        if (!TextUtils.isEmpty(str)) {
            sharedPreferences.edit().putString("sp_key_danmu_answer_url", str).commit();
        } else {
            sharedPreferences.edit().remove("sp_key_danmu_answer_url").commit();
        }
    }

    public static void i(String str) {
        String account = com.tencent.comic.utils.a.a().getAccount();
        SharedPreferences sharedPreferences = com.tencent.comic.utils.a.b().getSharedPreferences("ComicGlobalConfig_" + account, 0);
        String string = sharedPreferences.getString("defaultComicTab", null);
        if (TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(string)) {
                return;
            }
            sharedPreferences.edit().remove("defaultComicTab").apply();
            if (QLog.isColorLevel()) {
                QLog.d("ComicHelper", 2, "[ComicGlobalConfig] erase default tab");
                return;
            }
            return;
        }
        if (str.equals(string)) {
            return;
        }
        sharedPreferences.edit().putString("defaultComicTab", str).apply();
        if (QLog.isColorLevel()) {
            QLog.d("ComicHelper", 2, "[ComicGlobalConfig] update default tab to " + str);
        }
    }

    public static void d(Context context) {
        if (context == null) {
            QLog.e("WebBundle.Comic", 2, "init webbundle failed because context is null.");
            return;
        }
        if (!f99166b) {
            QLog.w("WebBundle.Comic", 2, "init webbundle failed because jsApi forbid.");
            return;
        }
        QQComicConfBean qQComicConfBean = (QQComicConfBean) am.s().x(534);
        if (qQComicConfBean != null && qQComicConfBean.f99266a.a()) {
            if (WebBundleManager.getInstance("comic").isInit()) {
                return;
            }
            final SharedPreferences sharedPreferences = com.tencent.comic.utils.a.b().getSharedPreferences("webbundle", 4);
            if (!sharedPreferences.getBoolean("webbundle_enable", true)) {
                QLog.w("WebBundle.Comic", 2, "init webbundle failed because local config forbid.");
                return;
            }
            WebBundleManager.getInstance("comic").init(new com.tencent.comic.webbundle.a(context), new WebBundleConfig().setCarrierActivityClass(QQBrowserActivity.class).setPreloadUrl(qQComicConfBean.f99266a.f99279b).setLogListener(new a()).setOptionListener(new WebBundleH5OptionListner() { // from class: com.tencent.comic.VipComicHelper.3
                @Override // com.tencent.webbundle.sdk.WebBundleH5OptionListner
                public void enableWebBundle(boolean z16) {
                    QLog.d("WebBundle.Comic", 2, "handle enable webbundle. enable = " + z16);
                    sharedPreferences.edit().putBoolean("webbundle_enable", z16).apply();
                    if (z16) {
                        return;
                    }
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.comic.VipComicHelper.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            WebBundleManager.getInstance("comic").destroy();
                        }
                    });
                }
            }));
            WebBundleManager.getInstance("comic").triggerPreload(1500L);
            return;
        }
        QLog.w("WebBundle.Comic", 2, "init webbundle failed because config forbid.");
    }

    public static void c(AppRuntime appRuntime) {
        if (appRuntime == null || f99165a) {
            return;
        }
        ey3.a.f().k();
        f99165a = true;
    }

    public static boolean e(String str, Intent intent) {
        String str2;
        boolean z16;
        Uri parse;
        int i3 = 100;
        if (str == null || (parse = Uri.parse(str)) == null || !parse.isHierarchical()) {
            str2 = null;
            z16 = false;
        } else {
            z16 = "1".equals(parse.getQueryParameter("init_player"));
            str2 = parse.getQueryParameter("id");
            try {
                i3 = Integer.parseInt(parse.getQueryParameter("type"));
            } catch (Exception unused) {
            }
        }
        if (TextUtils.isEmpty(str2) || !z16) {
            return false;
        }
        intent.putExtra("key_comic_id", str2);
        intent.putExtra("key_type", i3);
        intent.putExtra("key_is_fullscreen", false);
        intent.putExtra(PluginConst.PARAMS_REMOTE_CONNECT_AT_LAUNCH, true);
        return true;
    }

    public static void f(Activity activity, Intent intent, int i3) {
        if (activity == null || intent == null) {
            return;
        }
        g(intent);
        try {
            activity.startActivityForResult(intent, i3);
        } catch (Exception e16) {
            QLog.e("ComicHelper", 2, "openQQBrowserActivityForComic", e16);
        }
    }

    public static void j(int i3) {
        boolean z16 = i3 == 1;
        f99166b = z16;
        if (!z16) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.comic.VipComicHelper.2
                @Override // java.lang.Runnable
                public void run() {
                    WebBundleManager.getInstance("comic").destroy();
                    QLog.d("WebBundle.Comic", 2, "WebBundleManager destroy cause setWebBundleOption");
                }
            });
        }
        QLog.d("WebBundle.Comic", 2, "handle setWebBundleOption enable = " + f99166b);
    }

    public static AppRuntime a(MobileQQ mobileQQ, String str) {
        Class<?> cls;
        if (mobileQQ != null && str != null) {
            if (mobileQQ.peekAppRuntime().getRunningModuleSize() > 0 && com.tencent.comic.data.f.f99357n.get() != 2) {
                com.tencent.comic.data.f.f99357n.set(3);
            }
            try {
                try {
                    try {
                        cls = Class.forName("com.qqcomic.app.VipComicPluginRuntime");
                    } catch (IllegalAccessException e16) {
                        e16.printStackTrace();
                    } catch (IllegalArgumentException e17) {
                        e17.printStackTrace();
                    } catch (InstantiationException e18) {
                        e18.printStackTrace();
                    } catch (NoSuchMethodException e19) {
                        e19.printStackTrace();
                    } catch (InvocationTargetException e26) {
                        e26.printStackTrace();
                    } catch (Exception e27) {
                        e27.printStackTrace();
                    }
                } catch (ClassNotFoundException unused) {
                    ClassLoader orCreateClassLoader = PluginStatic.getOrCreateClassLoader(mobileQQ, IQQComicPluginUtil.COMIC_PLUGIN_ID);
                    Class<?> loadClass = orCreateClassLoader.loadClass("com.qqcomic.app.VipComicPluginRuntime");
                    BasicClassTypeUtil.setClassLoader(true, orCreateClassLoader);
                    cls = loadClass;
                }
                if (cls == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ComicHelper", 2, "createCOMICRuntime: load class failed");
                    }
                    return null;
                }
                Object newInstance = cls.getDeclaredConstructor(MobileQQ.class, String.class).newInstance(mobileQQ, str);
                if (newInstance != null && (newInstance instanceof AppRuntime)) {
                    return (AppRuntime) newInstance;
                }
            } catch (ClassNotFoundException e28) {
                e28.printStackTrace();
            }
        }
        return null;
    }

    /* compiled from: P */
    /* renamed from: com.tencent.comic.VipComicHelper$1, reason: invalid class name */
    /* loaded from: classes32.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WeakReference f99167d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f99168e;

        @Override // java.lang.Runnable
        public void run() {
            AppRuntime appRuntime = (AppRuntime) this.f99167d.get();
            if (appRuntime == null) {
                return;
            }
            Integer[] numArr = new Integer[7];
            boolean z16 = false;
            if (((IDPCApi) QRoute.api(IDPCApi.class)).parseComplexParamsByStringToIntParser(((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.comic_plugin_profile.name(), ""), numArr) >= 7 && (numArr[4].intValue() & this.f99168e) != 0) {
                z16 = true;
            }
            if (!z16) {
                if (QLog.isColorLevel()) {
                    QLog.d("ComicHelper", 2, "Skip update offline pkg. entry = " + this.f99168e);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ComicHelper", 2, "Do update offline pkg. entry = " + this.f99168e);
            }
            HtmlOffline.j("354", appRuntime, true, new a());
        }

        /* compiled from: P */
        /* renamed from: com.tencent.comic.VipComicHelper$1$a */
        /* loaded from: classes32.dex */
        class a implements com.tencent.biz.common.offline.a {
            a() {
            }

            @Override // com.tencent.biz.common.offline.a
            public void loaded(String str, int i3) {
                AppRuntime appRuntime = (AppRuntime) AnonymousClass1.this.f99167d.get();
                if (appRuntime == null) {
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ComicHelper", 2, "Finish update offline pkg. code = " + i3 + ", entry = " + AnonymousClass1.this.f99168e);
                }
                boolean z16 = i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4 || i3 == 6;
                SharedPreferences sharedPreferences = appRuntime.getApplication().getSharedPreferences("vip_comic_file", 4);
                int i16 = sharedPreferences.getInt("totalOfflinePkgDownloadCount", 0);
                int i17 = z16 ? i16 + 1 : 0;
                if (i17 != i16) {
                    sharedPreferences.edit().putInt("totalOfflinePkgDownloadCount", i17).apply();
                }
                if (z16) {
                    long serverTime = NetConnInfoCenter.getServerTime();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(i3 + "|");
                    sb5.append(i17 + "|");
                    sb5.append(serverTime + "|");
                    sb5.append("|||||");
                    DcReportUtil.c(appRuntime, "sendtdbank|b_sng_qqvip_qqcomic|offlinePkgDownload", sb5.toString(), true);
                }
            }

            @Override // com.tencent.biz.common.offline.a
            public void progress(int i3) {
            }
        }
    }
}
