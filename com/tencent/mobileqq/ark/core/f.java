package com.tencent.mobileqq.ark.core;

import android.os.Build;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ark;
import com.tencent.ark.open.ArkUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.api.IArkConfig;
import com.tencent.mobileqq.ark.api.IArkEnvDelegate;
import com.tencent.mobileqq.ark.temp.api.IDisplayConfig;
import com.tencent.mobileqq.ark.util.NativeLibLoader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.io.File;
import java.util.Map;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f199343a = false;

    /* renamed from: b, reason: collision with root package name */
    public static volatile boolean f199344b = false;

    /* renamed from: c, reason: collision with root package name */
    static boolean f199345c = false;

    /* renamed from: e, reason: collision with root package name */
    public static IArkEnvDelegate f199347e;

    /* renamed from: d, reason: collision with root package name */
    private static final Object f199346d = new Object();

    /* renamed from: f, reason: collision with root package name */
    static final ArkEnvironmentManager.ILog f199348f = new a();

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements ArkEnvironmentManager.ILog {
        a() {
        }

        @Override // com.tencent.ark.ArkEnvironmentManager.ILog
        public void d(String str, String str2) {
            if (f.f199345c && QLog.isColorLevel()) {
                QLog.d(str, 2, str2);
            }
        }

        @Override // com.tencent.ark.ArkEnvironmentManager.ILog
        public void e(String str, String str2) {
            QLog.e(str, 1, str2);
        }

        @Override // com.tencent.ark.ArkEnvironmentManager.ILog
        public void i(String str, String str2) {
            if (f.f199345c) {
                QLog.i(str, 1, str2);
            }
        }

        @Override // com.tencent.ark.ArkEnvironmentManager.ILog
        public void w(String str, String str2) {
            QLog.w(str, 1, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b implements ArkEnvironmentManager.ThreadCreater {
        b() {
        }

        @Override // com.tencent.ark.ArkEnvironmentManager.ThreadCreater
        public HandlerThread createHandlerThread(String str) {
            return ThreadManagerV2.newFreeHandlerThread(str, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class c implements ArkEnvironmentManager.LibraryLoader {
        c() {
        }

        @Override // com.tencent.ark.ArkEnvironmentManager.LibraryLoader
        public boolean Load() {
            f.l();
            return f.f199344b;
        }

        @Override // com.tencent.ark.ArkEnvironmentManager.LibraryLoader
        public boolean isLibraryLoad() {
            return f.f199344b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class d implements ArkEnvironmentManager.IDataReport {
        d() {
        }

        @Override // com.tencent.ark.ArkEnvironmentManager.IDataReport
        public void dtReport(String str, Map<String, String> map) {
            VideoReport.reportEvent(str, map);
        }

        @Override // com.tencent.ark.ArkEnvironmentManager.IDataReport
        public void report(String str, String str2, boolean z16, int i3, Map<String, String> map) {
            com.tencent.mobileqq.ark.util.b.c(MobileQQ.sMobileQQ.waitAppRuntime(null), str, str2, z16, i3, map);
        }
    }

    private static void a(ArkEnvironmentManager arkEnvironmentManager) {
        d91.b arkAIKeyWordConfig = ((IArkConfig) QRoute.api(IArkConfig.class)).getArkAIKeyWordConfig();
        boolean z16 = arkAIKeyWordConfig.c().f395989c;
        if (ArkEnvironmentManager.getInstance().isEGLSpecialDeviceLimited()) {
            QLog.i("ArkApp.Environment", 1, "EGLSpecialDeviceLimited. not support MultiThreadMode");
            z16 = false;
        }
        ArkEnvironmentManager.getInstance().setSingleThreadMode(!z16);
        QLog.d("ArkApp.Environment", 1, "singleThreadMode = " + ArkEnvironmentManager.getInstance().isSingleThreadMode());
        arkEnvironmentManager.loadLibrary();
        if (f199344b) {
            boolean z17 = arkAIKeyWordConfig.c().f395988b;
            ark.SetUseAndroidHTTP(z17);
            d91.g arkPlatformConfig = ((IArkConfig) QRoute.api(IArkConfig.class)).getArkPlatformConfig();
            if (arkPlatformConfig != null && arkPlatformConfig.c() != null) {
                ark.SetCustomFontEnable(arkPlatformConfig.c().b());
            }
            DisplayMetrics displayMetrics = ((IDisplayConfig) QRoute.api(IDisplayConfig.class)).getDisplayMetrics();
            float f16 = displayMetrics.widthPixels;
            float f17 = displayMetrics.density;
            float f18 = f16 / f17;
            float f19 = displayMetrics.heightPixels / f17;
            ark.arkSetScreenSize(f18, f19);
            ArkEnvironmentManager.getInstance().setThreadMode();
            QLog.i("ArkApp.Environment", 1, "setupArkEnvironment, https=" + z17 + ", multithreads=" + z16 + ", screen=" + f18 + "," + f19);
        }
    }

    private static ArkEnvironmentManager.IDataReport b() {
        return new d();
    }

    protected static String c() {
        IArkEnvDelegate iArkEnvDelegate = f199347e;
        if (iArkEnvDelegate != null) {
            return iArkEnvDelegate.getLibJSCPath();
        }
        return null;
    }

    private static ArkEnvironmentManager.LibraryLoader d() {
        return new c();
    }

    private static ArkEnvironmentManager.ThreadCreater e() {
        return new b();
    }

    private static boolean f() {
        return true;
    }

    private static void g(ArkEnvironmentManager arkEnvironmentManager) {
        f199345c = f();
        arkEnvironmentManager.setProfilingLogFlag(true);
        arkEnvironmentManager.setThreadCreator(e());
        arkEnvironmentManager.setLogCallback(f199348f);
        arkEnvironmentManager.setLibraryLoader(d());
        arkEnvironmentManager.setDebugFlag(false);
        arkEnvironmentManager.setDataReport(b());
    }

    public static boolean h() {
        if (!f199344b) {
            QLog.i("ArkApp.Environment", 1, "InitJSCLibPath: ark library not load");
            return false;
        }
        String c16 = c();
        if (TextUtils.isEmpty(c16)) {
            QLog.i("ArkApp.Environment", 1, "InitJSCLibPath: folder path is empty.");
            return false;
        }
        ark.arkSetLibraryPath(c16, "libjsc.so");
        QLog.i("ArkApp.Environment", 1, "InitJSCLibPath: folder=" + c16 + ", name=libjsc.so, exist=" + k());
        return true;
    }

    private static boolean i() {
        return false;
    }

    public static boolean j(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str, str2);
            if (file.exists() && file.isFile()) {
                return true;
            }
            QLog.d("ArkApp.Environment", 1, "load lib " + str2 + " NOT exist.");
        }
        return false;
    }

    public static boolean k() {
        if (i()) {
            return true;
        }
        String c16 = c();
        if (TextUtils.isEmpty(c16)) {
            QLog.d("ArkApp.Environment", 1, "isJSCLibExist folder path is empty.");
            return false;
        }
        return j(c16, "libjsc.so");
    }

    public static void l() {
        if (!f199344b && ArkUtil.sARMv7Compatible) {
            if (!f199344b && ArkUtil.sARMv7Compatible) {
                long currentTimeMillis = System.currentTimeMillis();
                NativeLibLoader.a(BaseApplication.getContext(), NativeLibLoader.g());
                f199344b = NativeLibLoader.b(BaseApplication.getContext(), "ark");
                QLog.i("ArkApp.Environment", 1, "load libark.so for ARMv7!, loaded=" + f199344b + ", time=" + (System.currentTimeMillis() - currentTimeMillis));
                if (f199344b) {
                    NotoColorEmojiHelper.c();
                }
            }
            if (f199344b) {
                h();
            } else {
                ReportController.o(null, "CliOper", "", "", "0X8006365", "ark.lib.load.fail", 1, 1, "1", "1", Build.CPU_ABI, Build.CPU_ABI2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void m(boolean z16) {
        ArkEnvironmentManager arkEnvironmentManager = ArkEnvironmentManager.getInstance();
        if (!f199343a) {
            synchronized (arkEnvironmentManager) {
                if (!f199343a) {
                    g(arkEnvironmentManager);
                    f199343a = true;
                }
            }
        }
        if (!f199344b) {
            synchronized (f199346d) {
                if (!f199344b && z16 && !f199344b) {
                    a(arkEnvironmentManager);
                }
            }
        }
    }
}
