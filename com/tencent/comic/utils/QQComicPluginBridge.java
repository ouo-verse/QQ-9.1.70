package com.tencent.comic.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.comic.VipComicProxyActivity;
import com.tencent.comic.VipProxyPreLoadComicProcess;
import com.tencent.comic.api.IQQComicPluginUtil;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.pluginsdk.PluginConst;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.module.d;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Observer;
import mqq.app.AppRuntime;

/* loaded from: classes32.dex */
public class QQComicPluginBridge {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f99472a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static volatile boolean f99473b = false;

    /* renamed from: c, reason: collision with root package name */
    public static com.tencent.comic.utils.b f99474c;

    /* renamed from: d, reason: collision with root package name */
    public static d f99475d;

    /* loaded from: classes32.dex */
    public interface a {
        void a(int i3, String str);
    }

    /* loaded from: classes32.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public long f99480a = 0;

        /* renamed from: b, reason: collision with root package name */
        public long f99481b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f99482c = -1;

        /* renamed from: d, reason: collision with root package name */
        public a f99483d = null;
    }

    public static boolean b(AppRuntime appRuntime, final boolean z16, final b bVar) {
        String str;
        String f16;
        if (e(appRuntime)) {
            f99473b = true;
            if (QLog.isColorLevel()) {
                QLog.d("QQComicPluginBridge", 2, "QQComic is ready");
            }
            return true;
        }
        final com.tencent.mobileqq.qroute.module.a plugin = QRoute.plugin(IQQComicPluginUtil.COMIC_PLUGIN_ID);
        if (plugin == null) {
            if (QLog.isColorLevel()) {
                QLog.d("QQComicPluginBridge", 2, "PluginManager is NOT ready");
            }
            return false;
        }
        ThreadManagerV2.executeOnNetWorkThread(new Runnable() { // from class: com.tencent.comic.utils.QQComicPluginBridge.1

            /* renamed from: com.tencent.comic.utils.QQComicPluginBridge$1$a */
            /* loaded from: classes32.dex */
            class a implements com.tencent.mobileqq.qroute.module.c {
                a() {
                }

                @Override // com.tencent.mobileqq.qroute.module.c
                public void onInstallBegin(String str) {
                    a aVar;
                    b bVar = bVar;
                    if (bVar == null || (aVar = bVar.f99483d) == null) {
                        return;
                    }
                    aVar.a(98, "\u8f7d\u5165\u4e2d,\uff08\u6211\u4f1a\u8d8a\u6765\u8d8a\u5feb\u7684>_<\uff09");
                }

                @Override // com.tencent.mobileqq.qroute.module.c
                public void onInstallDownloadProgress(String str, int i3, int i16) {
                    b bVar = bVar;
                    if (bVar == null || i3 <= 0 || i16 <= 0) {
                        return;
                    }
                    bVar.f99480a = System.currentTimeMillis();
                    a aVar = bVar.f99483d;
                    if (aVar != null) {
                        aVar.a((int) ((i3 / i16) * 95.0f), "\u52a0\u8f7d\u4e2d,\uff08\u522b\u7d27\u5f20\u554a\u6211\u5f88\u5c0f\u7684>_<\uff09");
                    }
                }

                @Override // com.tencent.mobileqq.qroute.module.c
                public void onInstallError(String str, int i3) {
                    synchronized (QQComicPluginBridge.f99472a) {
                        QQComicPluginBridge.f99472a.notifyAll();
                    }
                    b bVar = bVar;
                    if (bVar != null) {
                        bVar.f99482c = i3;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("QQComicPluginBridge", 2, "QQComic install error");
                    }
                }

                @Override // com.tencent.mobileqq.qroute.module.c
                public void onInstallFinish(String str) {
                    if (!z16) {
                        QQComicPluginBridge.f99473b = true;
                    }
                    synchronized (QQComicPluginBridge.f99472a) {
                        QQComicPluginBridge.f99472a.notifyAll();
                    }
                    b bVar = bVar;
                    if (bVar != null) {
                        bVar.f99481b = System.currentTimeMillis();
                        a aVar = bVar.f99483d;
                        if (aVar != null) {
                            aVar.a(99, "\u8f7d\u5165\u4e2d,\uff08\u6211\u4f1a\u8d8a\u6765\u8d8a\u5feb\u7684>_<\uff09");
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("QQComicPluginBridge", 2, "QQComic is installed");
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                com.tencent.mobileqq.qroute.module.a.this.d(new a());
            }
        });
        if (!z16) {
            return false;
        }
        com.tencent.mobileqq.qroute.module.e j3 = plugin.j();
        while (j3 != null && j3.d() != 4) {
            Object obj = f99472a;
            synchronized (obj) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQComicPluginBridge", 2, "QQComic is waiting for installation");
                }
                try {
                    LockMethodProxy.wait(obj);
                    if (QLog.isColorLevel()) {
                        QLog.d("QQComicPluginBridge", 2, "QQComic installation is finished");
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
        com.tencent.mobileqq.qroute.module.e j16 = plugin.j();
        f99473b = j16 != null && j16.d() == 4;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("QQComic is ");
            if (f99473b) {
                str = "installed";
            } else {
                str = "NOT installed";
            }
            sb5.append(str);
            sb5.append(", ComicPlugin.pluginInfo.version=");
            if (j16 == null) {
                f16 = "info null";
            } else {
                f16 = j16.f();
            }
            sb5.append(f16);
            QLog.d("QQComicPluginBridge", 2, sb5.toString());
        }
        if (f99473b) {
            c("plugin_ready");
        }
        return f99473b;
    }

    public static void c(String str) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            Class<?> loadClass = PluginStatic.getOrCreateClassLoader(com.tencent.comic.utils.a.b(), IQQComicPluginUtil.COMIC_PLUGIN_ID).loadClass("com.qqcomic.utils.ComicPluginVersionInfo");
            loadClass.getDeclaredMethod("printVersionInfo", String.class).invoke(loadClass, str);
            QLog.i("QQComicPluginBridge", 2, "ComicPlugin.checkBoodoPluginVersion, msg=" + str + ", call_time=" + (System.currentTimeMillis() - currentTimeMillis));
        } catch (ClassNotFoundException e16) {
            QLog.e("QQComicPluginBridge", 1, e16, new Object[0]);
        } catch (IllegalAccessException e17) {
            QLog.e("QQComicPluginBridge", 1, e17, new Object[0]);
        } catch (InstantiationException e18) {
            QLog.e("QQComicPluginBridge", 1, e18, new Object[0]);
        } catch (Exception e19) {
            QLog.e("QQComicPluginBridge", 1, e19, new Object[0]);
        }
    }

    public static com.tencent.comic.jsp.e d(WebViewPlugin.b bVar, com.tencent.comic.jsp.c cVar) {
        return null;
    }

    public static boolean e(AppRuntime appRuntime) {
        if (f99473b) {
            if (QLog.isColorLevel()) {
                QLog.d("QQComicPluginBridge", 2, "QQComic is ready");
            }
            return true;
        }
        if (!(appRuntime instanceof BaseQQAppInterface)) {
            if (QLog.isColorLevel()) {
                QLog.d("QQComicPluginBridge", 2, "Not in main process, QQComic is NOT installed");
            }
            return f99473b;
        }
        com.tencent.mobileqq.qroute.module.a plugin = QRoute.plugin(IQQComicPluginUtil.COMIC_PLUGIN_ID);
        if (plugin == null) {
            if (QLog.isColorLevel()) {
                QLog.d("QQComicPluginBridge", 2, "PluginManager is NOT ready");
            }
            return false;
        }
        com.tencent.mobileqq.qroute.module.e j3 = plugin.j();
        if (j3 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("QQComicPluginBridge", 2, "QQComic is NOT found");
            }
            return false;
        }
        f99473b = j3.d() == 4;
        return f99473b;
    }

    public static boolean f(Activity activity, Intent intent, String str, com.tencent.mobileqq.hitrate.b bVar) {
        if (!f99473b || activity == null || intent == null || TextUtils.isEmpty(str)) {
            return false;
        }
        intent.putExtra("big_brother_source_key", "biz_src_zz_bodong");
        if (activity instanceof BasePluginActivity) {
            activity.startActivity(intent);
        } else {
            intent.putExtra(PluginStatic.PARAM_USE_QQ_RESOURCES, 2);
            intent.putExtra(PluginStatic.PARAM_USE_SKIN_ENGINE, false);
            intent.putExtra(PluginConst.PARAMS_REMOTE_CONNECT_AT_LAUNCH, true);
            QRoute.plugin(IQQComicPluginUtil.COMIC_PLUGIN_ID).f(new d.b(activity).b(str).c(VipComicProxyActivity.getProxyActivityClass(str)).d(intent).h(10000).f(bVar).a());
        }
        return true;
    }

    public static void h(Context context, Bundle bundle) {
        if (QLog.isColorLevel()) {
            QLog.d("QQComicDebug", 2, "load plugin start");
        }
        if (!QIPCServerHelper.getInstance().isModuleRunning(IQQComicPluginUtil.COMIC_PLUGIN_ID)) {
            VasWebviewUtil.reportVasStatus("qqcomic", IQQComicPluginUtil.PLUGIN_LAUNCH_ACTION, "0", 0, 201);
        }
        Intent intent = new Intent(context, (Class<?>) VipProxyPreLoadComicProcess.class);
        intent.putExtra(PluginStatic.PARAM_USE_QQ_RESOURCES, 2);
        intent.putExtra(PluginStatic.PARAM_USE_SKIN_ENGINE, false);
        intent.putExtra(PluginConst.PARAMS_REMOTE_CONNECT_AT_LAUNCH, true);
        intent.putExtra(RemoteMessageConst.SEND_TIME, SystemClock.elapsedRealtime());
        c.a(com.tencent.comic.utils.a.a(), 1, 1, 0L);
        i(intent);
        if (QLog.isColorLevel()) {
            QLog.d("QQComicDebug", 2, "load plugin end");
        }
    }

    public static void j(Observer observer) {
        d dVar = f99475d;
        if (dVar == null || observer == null) {
            return;
        }
        dVar.deleteObserver(observer);
    }

    public static void k(Observer observer) {
        com.tencent.comic.utils.b bVar = f99474c;
        if (bVar == null) {
            f99474c = new com.tencent.comic.utils.b();
        } else {
            bVar.deleteObservers();
        }
        f99474c.addObserver(observer);
    }

    public static void l(Observer observer) {
        d dVar = f99475d;
        if (dVar == null) {
            f99475d = new d();
        } else {
            dVar.deleteObservers();
        }
        f99475d.addObserver(observer);
    }

    public static void g(Context context) {
        h(context, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void i(Intent intent) {
        boolean z16;
        boolean z17;
        boolean z18;
        int i3;
        boolean z19;
        boolean z26;
        Exception e16;
        Integer[] numArr;
        if (intent == null) {
            return;
        }
        String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.comic_plugin_profile.name(), "");
        if (QLog.isColorLevel()) {
            QLog.d("QQComicPluginBridge", 2, "parseDPC config = " + featureValue);
        }
        boolean z27 = false;
        boolean z28 = true;
        if (!TextUtils.isEmpty(featureValue)) {
            try {
                numArr = new Integer[7];
                Arrays.fill((Object[]) numArr, (Object) 0);
                numArr[2] = 1;
            } catch (Exception e17) {
                z19 = false;
                z18 = false;
                i3 = 0;
                z26 = true;
                e16 = e17;
                z16 = false;
            }
            if (((IDPCApi) QRoute.api(IDPCApi.class)).parseComplexParamsByStringToIntParser(featureValue, numArr) >= 7) {
                z16 = numArr[0].intValue() == 1;
                try {
                    z19 = numArr[1].intValue() == 1;
                    try {
                        z26 = numArr[2].intValue() == 1;
                        try {
                            z18 = numArr[3].intValue() == 1;
                            try {
                                i3 = numArr[5].intValue();
                                try {
                                    if (numArr[6].intValue() == 1) {
                                        z27 = true;
                                    }
                                } catch (Exception e18) {
                                    e16 = e18;
                                    e16.printStackTrace();
                                    z28 = z26;
                                    boolean z29 = z27;
                                    z27 = z19;
                                    z17 = z29;
                                    intent.putExtra("isSetHardWareLayerForWebview", z27);
                                    intent.putExtra("isHandleNavigationBar", z28);
                                    intent.putExtra("isCloseHardAcc", z18);
                                    intent.putExtra("bitDepthFlag", i3);
                                    intent.putExtra("skipBitmapReuse", z17);
                                    if (QLog.isColorLevel()) {
                                    }
                                }
                            } catch (Exception e19) {
                                e16 = e19;
                                i3 = 0;
                            }
                        } catch (Exception e26) {
                            e16 = e26;
                            z18 = false;
                            i3 = 0;
                        }
                    } catch (Exception e27) {
                        z18 = false;
                        i3 = 0;
                        e16 = e27;
                        z26 = true;
                    }
                } catch (Exception e28) {
                    z18 = false;
                    i3 = 0;
                    z26 = true;
                    e16 = e28;
                    z19 = false;
                }
                z28 = z26;
                boolean z292 = z27;
                z27 = z19;
                z17 = z292;
                intent.putExtra("isSetHardWareLayerForWebview", z27);
                intent.putExtra("isHandleNavigationBar", z28);
                intent.putExtra("isCloseHardAcc", z18);
                intent.putExtra("bitDepthFlag", i3);
                intent.putExtra("skipBitmapReuse", z17);
                if (QLog.isColorLevel()) {
                    QLog.d("QQComicDebug", 2, "parseDPC isPreloadInMiddlePage = " + z16 + " , isSetHardWareLayerForWebview = " + z27 + " , isHandleNavigationBar = " + z28 + " , isCloseHardAcc = " + z18 + " , bitDepthFlag = " + i3 + " , skipBitmapReuse = " + z17);
                    return;
                }
                return;
            }
        }
        z16 = false;
        z17 = false;
        z18 = false;
        i3 = 0;
        intent.putExtra("isSetHardWareLayerForWebview", z27);
        intent.putExtra("isHandleNavigationBar", z28);
        intent.putExtra("isCloseHardAcc", z18);
        intent.putExtra("bitDepthFlag", i3);
        intent.putExtra("skipBitmapReuse", z17);
        if (QLog.isColorLevel()) {
        }
    }
}
