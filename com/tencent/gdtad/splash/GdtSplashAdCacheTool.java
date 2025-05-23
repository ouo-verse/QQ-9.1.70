package com.tencent.gdtad.splash;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.qq.e.tg.TangramUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.message.messageclean.x;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtSplashAdCacheTool implements x {

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements com.tencent.qqperf.monitor.crash.safemode.a {
        a() {
        }

        @Override // com.tencent.qqperf.monitor.crash.safemode.a
        public void a(Context context) {
            QLog.i("GdtSplashAdCacheTool", 1, "[doOnSafeModeStartUp]");
            GdtSplashAdCacheTool.h();
        }

        @Override // com.tencent.qqperf.monitor.crash.safemode.a
        public String b() {
            return "GtdSafeModeRunner";
        }
    }

    public static com.tencent.qqperf.monitor.crash.safemode.a d() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e() {
        QLog.i("GdtSplashAdCacheTool", 1, "clearSplashCache");
        GdtSplashManager.p().n();
    }

    public static void f() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gdtad.splash.GdtSplashAdCacheTool.2
            @Override // java.lang.Runnable
            public void run() {
                GdtSplashAdCacheTool.e();
            }
        }, 64, null, true);
        QLog.i("GdtSplashAdCacheTool", 1, "doClearCacheForConfigChange, thread=" + Thread.currentThread());
    }

    private static void g() {
        e();
        QLog.i("GdtSplashAdCacheTool", 1, "doClearCacheForManual, thread=" + Thread.currentThread());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gdtad.splash.GdtSplashAdCacheTool.3
            @Override // java.lang.Runnable
            public void run() {
                GdtSplashAdCacheTool.e();
            }
        }, 64, null, true);
        QLog.i("GdtSplashAdCacheTool", 1, "doClearCacheForSafeMode, thread=" + Thread.currentThread());
    }

    public static long i() {
        long j3;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            j3 = TangramUtil.getSplashCacheSize(BaseApplication.getContext());
        } else {
            j3 = 0;
        }
        QLog.i("GdtSplashAdCacheTool", 1, "doGetCacheSizeForManual, size=" + j3 + ", thread=" + Thread.currentThread());
        return j3;
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.x
    @NonNull
    public CopyOnWriteArrayList<String> a() {
        return new CopyOnWriteArrayList<>();
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.x
    public void clearCache() {
        g();
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.x
    public long getCacheSize() {
        return i();
    }
}
