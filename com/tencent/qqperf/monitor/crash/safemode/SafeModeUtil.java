package com.tencent.qqperf.monitor.crash.safemode;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.ak;
import com.tencent.mobileqq.msf.core.net.patch.PatchCommonUtil;
import com.tencent.mobileqq.msf.core.net.patch.PatchSharedPreUtil;
import com.tencent.mobileqq.msf.core.net.utils.MsfCmdConfig;
import com.tencent.mobileqq.msf.core.net.utils.MsfPullConfigUtil;
import com.tencent.mobileqq.qqperftool.common.f;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.crashdefend.CrashDefendManager;
import com.tencent.qqperf.monitor.crash.QQCrashReportManager;
import com.tencent.util.AppSetting;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SafeModeUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final int f363209a;

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f363210b;

    /* renamed from: c, reason: collision with root package name */
    private static final CountDownLatch f363211c;

    /* renamed from: d, reason: collision with root package name */
    public static long f363212d;

    /* renamed from: e, reason: collision with root package name */
    public static long f363213e;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f363214f;

    /* compiled from: P */
    /* renamed from: com.tencent.qqperf.monitor.crash.safemode.SafeModeUtil$1, reason: invalid class name */
    /* loaded from: classes25.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f363215d;

        @Override // java.lang.Runnable
        public void run() {
            SafeModeUtil.g(this.f363215d, 2);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.qqperf.monitor.crash.safemode.SafeModeUtil$2, reason: invalid class name */
    /* loaded from: classes25.dex */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("sp_safemode_test_flag", 0);
            SharedPreferences sharedPreferences2 = BaseApplication.getContext().getSharedPreferences("sp_safemode_test_crash", 0);
            if (!sharedPreferences.getBoolean("flag", false)) {
                sharedPreferences2.edit().putBoolean("crash", true).commit();
                sharedPreferences.edit().putBoolean("flag", true).commit();
            }
            if (!sharedPreferences2.getBoolean("crash", false)) {
            } else {
                throw new RuntimeException("SafeModeTestCrash");
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.qqperf.monitor.crash.safemode.SafeModeUtil$3, reason: invalid class name */
    /* loaded from: classes25.dex */
    class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            throw new RuntimeException("simulateCrashAtSplash");
        }
    }

    static {
        int i3;
        if ((System.currentTimeMillis() & 1) == 0) {
            i3 = 30;
        } else {
            i3 = 15;
        }
        f363209a = i3;
        f363210b = new AtomicBoolean(false);
        f363211c = new CountDownLatch(2);
        f363213e = -1L;
        f363214f = false;
    }

    public static void a() {
        if (!AppSetting.isPublicVersion() && !AppSetting.isGrayVersion() && 1 == MobileQQ.sProcessId && BaseApplication.getContext().getSharedPreferences(MsfPullConfigUtil.SP_SAFEMODE_TEST_CRASH_CONFIG, 4).getBoolean(MsfPullConfigUtil.KEY_TEST_CRASH_SWITCH, false)) {
            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.qqperf.monitor.crash.safemode.SafeModeUtil.5
                @Override // java.lang.Runnable
                public void run() {
                    File[] listFiles;
                    QLog.d("SafeModeUtil", 1, "1.\u91cd\u65b0\u751f\u6210\u5bfc\u81f4crash\u7684\u6587\u4ef6 2.\u6e05\u7406\u5f02\u5e38\u4e0d\u9000\u51fa\u6807\u8bb0 3.\u6e05\u7a7a\u8865\u4e01\u6587\u4ef6 4.\u6e05\u7a7a\u5b89\u5168\u6a21\u5f0f\u6807\u8bb0");
                    BaseApplication.getContext().getSharedPreferences("sp_safemode_test_crash", 0).edit().putBoolean("crash", true).commit();
                    BaseApplication.getContext().getSharedPreferences(MsfCmdConfig.SP_SAFEMODE_NOT_EXIT, 4).edit().clear().commit();
                    BaseApplication.getContext().getSharedPreferences(PatchSharedPreUtil.SHARED_PREFERENCE_HOTPATCH, 4).edit().clear().commit();
                    File file = new File(PatchCommonUtil.getPatchPath(""));
                    if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                        for (File file2 : listFiles) {
                            if (file2 != null && file2.exists()) {
                                file2.delete();
                            }
                        }
                    }
                    BaseApplication.getContext().getSharedPreferences("sp_safe_mode", 0).edit().clear().commit();
                    SafeModeUtil.f("\u6e05\u9664\u6a21\u62df\u95ea\u9000\u548c\u5b89\u5168\u6a21\u5f0f\u6807\u8bb0, \u4e0b\u6b21\u91cd\u542f\u5c06\u95ea\u9000");
                }
            });
        }
    }

    public static boolean b(String str, String str2) {
        boolean z16;
        boolean z17;
        int i3 = MobileQQ.sProcessId;
        if (1 != i3 && 7 != i3) {
            return false;
        }
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(MsfCmdConfig.SP_SAFEMODE_NOT_EXIT, 4);
        if (sharedPreferences.getBoolean(MsfCmdConfig.KEY_NOT_EXIT_ENABLE, false) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                String string = sharedPreferences.getString(MsfCmdConfig.KEY_NOT_EXIT_CRASH_TYPE, null);
                String string2 = sharedPreferences.getString(MsfCmdConfig.KEY_NOT_EXIT_CRASH_STACK, null);
                if (string != null && !TextUtils.isEmpty(str)) {
                    z16 = false;
                    for (String str3 : string.split("\\|")) {
                        if (str.equals(str3)) {
                            QLog.e("SafeModeUtil", 1, "crashType = ", str, ",crash = ", str3);
                            z16 = true;
                        }
                    }
                } else {
                    z16 = false;
                }
                if (string2 != null && !TextUtils.isEmpty(str2)) {
                    z17 = false;
                    for (String str4 : string2.split("\\|")) {
                        if (str2.contains(str4)) {
                            QLog.e("SafeModeUtil", 1, "crashStack = ", str2, ",crash = ", str4);
                            z17 = true;
                        }
                    }
                } else {
                    z17 = false;
                }
                if (!z17 || !z16) {
                    return false;
                }
                return true;
            } catch (Throwable th5) {
                QLog.e("SafeModeUtil", 1, "isNotExitSafeMode has some error", th5);
            }
        }
        return false;
    }

    public static void c() {
        f363211c.countDown();
    }

    public static boolean d(@NonNull Context context) {
        wy3.b.a("SafeModeUtil", "setSafeModeCrashDefender invoke");
        if (1 != MobileQQ.sProcessId) {
            wy3.b.a("SafeModeUtil", "setSafeModeCrashDefender not main process");
            return false;
        }
        if (!CrashDefendManager.i().e()) {
            wy3.b.a("SafeModeUtil", "setSafeModeCrashDefender checkStartStepCrashDefenderEnable is false");
            return false;
        }
        wy3.b.a("SafeModeUtil", "setSafeModeCrashDefender begin");
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(MsfCmdConfig.SP_SAFEMODE_NOT_EXIT, 4);
            if (!sharedPreferences.getBoolean(MsfCmdConfig.KEY_NOT_EXIT_ENABLE, false)) {
                wy3.b.a("SafeModeUtil", "setSafeModeCrashDefender MsfCmdConfig.KEY_NOT_EXIT_ENABLE is false");
                return false;
            }
            String string = sharedPreferences.getString(MsfCmdConfig.KEY_NOT_EXIT_CRASH_TYPE, null);
            String string2 = sharedPreferences.getString(MsfCmdConfig.KEY_NOT_EXIT_CRASH_STACK, "");
            if (f.a(string) || string2 == null) {
                return false;
            }
            wy3.b.a("SafeModeUtil", "setSafeModeCrashDefender " + string + APLogFileUtil.SEPARATOR_LOG + string2);
            return CrashDefendManager.i().g(string, string2);
        } catch (Throwable th5) {
            Log.e("SafeModeUtil", "isNotExitSafeMode has some error", th5);
            return false;
        }
    }

    private static boolean e() {
        return true;
    }

    public static void f(final String str) {
        if (!AppSetting.isPublicVersion() && !AppSetting.isGrayVersion() && 1 == MobileQQ.sProcessId) {
            boolean z16 = BaseApplication.getContext().getSharedPreferences(MsfPullConfigUtil.SP_SAFEMODE_TEST_CRASH_CONFIG, 4).getBoolean(MsfPullConfigUtil.KEY_TEST_CRASH_SWITCH, false);
            QLog.d("SafeModeUtil", 1, " doCrash: " + z16 + " text: " + str);
            if (z16) {
                if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.qqperf.monitor.crash.safemode.SafeModeUtil.4
                        @Override // java.lang.Runnable
                        public void run() {
                            QQToast.makeText(BaseApplication.getContext(), str, 0).show();
                        }
                    });
                } else {
                    QQToast.makeText(BaseApplication.getContext(), str, 0).show();
                }
            }
        }
    }

    @Deprecated
    public static void g(Context context, int i3) {
        if (QQCrashReportManager.f363164h && context.getSharedPreferences(MsfCmdConfig.SP_SAFEMODE_NOT_EXIT, 4).getBoolean(MsfCmdConfig.KEY_NOT_EXIT_ENABLE, false)) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("sp_safe_mode", 0);
        if (i3 != 1) {
            if (i3 == 2) {
                int i16 = sharedPreferences.getInt("key_count_start_fail", 0);
                if (i16 > 0) {
                    sharedPreferences.edit().putInt("key_count_start_fail", 0).commit();
                    if (e() && i16 > 3) {
                        StatisticCollector.getInstance(context).collectPerformance("", "exitSafeModeStart_" + f363209a, true, 0L, 0L, null, null);
                    }
                }
                ak.b().a();
                return;
            }
            return;
        }
        int i17 = sharedPreferences.getInt("key_count_crash", 0);
        if (i17 > 0) {
            sharedPreferences.edit().putInt("key_count_crash", 0).commit();
            if (e() && i17 > 3) {
                StatisticCollector.getInstance(context).collectPerformance("", "exitSafeModeCrash", true, 0L, 0L, null, null);
            }
        }
    }
}
