package com.tencent.qqperf.crashdefend.test;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qqperfnativetool.debug.nativeDebugJNI;
import com.tencent.mobileqq.qqperftool.a;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qqperf.monitor.crash.safemode.SafeModeHelper;
import com.tencent.qqperf.monitor.crash.safemode.SafeModeTestCrashConfigProcessor;
import com.tencent.util.AppSetting;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import wy3.c;

/* compiled from: P */
/* loaded from: classes25.dex */
public class StartUpCrashDefendDebugHelper {

    /* renamed from: a, reason: collision with root package name */
    private static AtomicBoolean f363121a = new AtomicBoolean(false);

    public static void b(Context context, @NonNull String str) {
        if (!d(context, str)) {
            c.e("TestStartUpCrashHelper", "testStartUpCrash jump with:" + str);
            return;
        }
        if (!f363121a.compareAndSet(false, true)) {
            c.e("TestStartUpCrashHelper", "testStartUpCrash jump hasTestCrashed with: " + str);
            return;
        }
        int e16 = e(context);
        c.e("TestStartUpCrashHelper", "testStartUpCrash isRegisterToSystem = " + a.h() + " |crashType = " + e16 + " |crashKey = " + str);
        if (e16 != 1) {
            if (e16 != 2) {
                if (e16 != 3) {
                    if (e16 != 4) {
                        if (e16 != 5) {
                            c.e("TestStartUpCrashHelper", "testStartUpCrash jump with wrong crashType: " + e16);
                            return;
                        }
                        k();
                        return;
                    }
                    i();
                    return;
                }
                h();
                return;
            }
            g();
            return;
        }
        f();
    }

    public static void c() {
        boolean a16 = SafeModeHelper.a();
        if (!a16) {
            c.g("TestStartUpCrashHelper", "testStartUpCrashForPublish jump:" + a16 + "|false");
            return;
        }
        SafeModeTestCrashConfigProcessor.a aVar = (SafeModeTestCrashConfigProcessor.a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("test_for_safemode_crash");
        if (aVar != null && aVar.a()) {
            throw new RuntimeException("Test Crash For SafeModeTestCrashConfig");
        }
    }

    private static synchronized boolean d(Context context, String str) {
        boolean z16;
        boolean z17;
        synchronized (StartUpCrashDefendDebugHelper.class) {
            z16 = false;
            if (!AppSetting.isPublicVersion() && context != null) {
                try {
                    File file = new File(context.getExternalFilesDir(null).getAbsolutePath(), str);
                    Log.i("TestStartUpCrashHelper", "checkStartUpCrashisNeed key is:" + str + " path = " + file.getAbsolutePath());
                    z16 = file.exists();
                } catch (Throwable th5) {
                    Log.e("TestStartUpCrashHelper", "checkFirstStartUpCrashIsNeed has exception " + th5);
                }
            } else {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("checkFirstStartUpCrashIsNeed jump : ");
                boolean z18 = true;
                if (!AppSetting.isPublicVersion()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                sb5.append(z17);
                sb5.append("|");
                if (context == null) {
                    z18 = false;
                }
                sb5.append(z18);
                Log.e("TestStartUpCrashHelper", sb5.toString());
            }
        }
        return z16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0041, code lost:
    
        r6 = r4.replace("testCrashType_", "");
        wy3.c.e("TestStartUpCrashHelper", "getCrashType check file name: " + r4 + " | strType:" + r6);
        r2 = java.lang.Integer.parseInt(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized int e(Context context) {
        File[] listFiles;
        synchronized (StartUpCrashDefendDebugHelper.class) {
            int i3 = 0;
            if (AppSetting.isPublicVersion() || context == null) {
                return 0;
            }
            try {
                File file = new File(context.getExternalFilesDir(null).getAbsolutePath(), "testCrashType");
                if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                    int length = listFiles.length;
                    int i16 = 0;
                    while (true) {
                        if (i16 >= length) {
                            break;
                        }
                        String name = listFiles[i16].getName();
                        if (name.startsWith("testCrashType_")) {
                            break;
                        }
                        i16++;
                    }
                }
                return i3;
            } catch (Throwable th5) {
                try {
                    c.d("TestStartUpCrashHelper", "getCrashType has exception " + th5, th5);
                    return 0;
                } catch (Throwable unused) {
                    return 0;
                }
            }
        }
    }

    private static void f() {
        if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
            j();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqperf.crashdefend.test.StartUpCrashDefendDebugHelper.4
                @Override // java.lang.Runnable
                public void run() {
                    StartUpCrashDefendDebugHelper.j();
                }
            });
        }
    }

    private static void g() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqperf.crashdefend.test.StartUpCrashDefendDebugHelper.5
            @Override // java.lang.Runnable
            public void run() {
                StartUpCrashDefendDebugHelper.j();
            }
        }, 16, null, false);
    }

    private static void h() {
        if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
            nativeDebugJNI.throwNativeNullPointExp();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqperf.crashdefend.test.StartUpCrashDefendDebugHelper.2
                @Override // java.lang.Runnable
                public void run() {
                    nativeDebugJNI.throwNativeNullPointExp();
                }
            });
        }
    }

    private static void i() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqperf.crashdefend.test.StartUpCrashDefendDebugHelper.3
            @Override // java.lang.Runnable
            public void run() {
                nativeDebugJNI.throwNativeNullPointExp();
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j() {
        boolean z16;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            z16 = true;
        } else {
            z16 = false;
        }
        throw new RuntimeException("test Crash, isMainThread=" + z16);
    }

    private static void k() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqperf.crashdefend.test.StartUpCrashDefendDebugHelper.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    LockMethodProxy.sleep(50000L);
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                }
            }
        });
    }
}
