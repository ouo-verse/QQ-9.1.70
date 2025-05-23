package com.tencent.mobileqq.armap;

import android.app.ActivityManager;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.mobileqq.armap.ARGLSurfaceView;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.m;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ARMapTracer implements ARGLSurfaceView.TraceCallback {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static int f199689a;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class GLHackTask implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: h, reason: collision with root package name */
        private static final Object f199690h;

        /* renamed from: i, reason: collision with root package name */
        private static GLHackTask f199691i;

        /* renamed from: m, reason: collision with root package name */
        private static int f199692m;

        /* renamed from: d, reason: collision with root package name */
        private Runnable f199693d;

        /* renamed from: e, reason: collision with root package name */
        private GLHackTask f199694e;

        /* renamed from: f, reason: collision with root package name */
        private WeakReference<ARGLSurfaceView> f199695f;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70848);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f199690h = new Object();
                f199692m = 0;
            }
        }

        public GLHackTask(Runnable runnable, ARGLSurfaceView aRGLSurfaceView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) runnable, (Object) aRGLSurfaceView);
                return;
            }
            this.f199693d = runnable;
            this.f199694e = null;
            this.f199695f = new WeakReference<>(aRGLSurfaceView);
        }

        public static GLHackTask a(Runnable runnable, ARGLSurfaceView aRGLSurfaceView) {
            synchronized (f199690h) {
                GLHackTask gLHackTask = f199691i;
                if (gLHackTask != null) {
                    f199691i = gLHackTask.f199694e;
                    gLHackTask.f199694e = null;
                    gLHackTask.f199693d = runnable;
                    gLHackTask.f199695f = new WeakReference<>(aRGLSurfaceView);
                    f199692m--;
                    return gLHackTask;
                }
                return new GLHackTask(runnable, aRGLSurfaceView);
            }
        }

        private void e() {
            this.f199693d = null;
            this.f199695f = null;
            synchronized (f199690h) {
                int i3 = f199692m;
                if (i3 < 50) {
                    this.f199694e = f199691i;
                    f199691i = this;
                    f199692m = i3 + 1;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.f199693d != null && this.f199695f.get() != null && !this.f199695f.get().mIsDestroyed) {
                this.f199693d.run();
            }
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            if (QLog.isDevelopLevel() && elapsedRealtime2 > 33) {
                String simpleName = GLHackTask.class.getSimpleName();
                Object[] objArr = new Object[3];
                objArr[0] = "%s cost: %d";
                Runnable runnable = this.f199693d;
                if (runnable != null) {
                    str = runnable.getClass().getName();
                } else {
                    str = "default";
                }
                objArr[1] = str;
                objArr[2] = Long.valueOf(elapsedRealtime2);
                QLog.d(simpleName, 2, objArr);
            }
            e();
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class ReportRunnable implements Runnable {
        static IPatchRedirector $redirector_;
        public long C;
        public int D;

        /* renamed from: d, reason: collision with root package name */
        public String f199696d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f199697e;

        /* renamed from: f, reason: collision with root package name */
        public float f199698f;

        /* renamed from: h, reason: collision with root package name */
        public float f199699h;

        /* renamed from: i, reason: collision with root package name */
        public float f199700i;

        /* renamed from: m, reason: collision with root package name */
        public float f199701m;

        @Override // java.lang.Runnable
        public void run() {
            int i3;
            int i16;
            int i17;
            int i18;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (this.C < 0) {
                this.C = 0L;
            }
            try {
                this.C /= 1000;
                HashMap<String, String> hashMap = new HashMap<>(10);
                Debug.MemoryInfo[] processMemoryInfo = SystemMethodProxy.getProcessMemoryInfo((ActivityManager) BaseApplication.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY), new int[]{Process.myPid()});
                if (processMemoryInfo != null && processMemoryInfo.length > 0) {
                    i16 = processMemoryInfo[0].getTotalPss();
                    Debug.MemoryInfo memoryInfo = processMemoryInfo[0];
                    int i19 = memoryInfo.otherPss;
                    i17 = memoryInfo.nativePss;
                    i18 = memoryInfo.dalvikPss;
                    i3 = i19;
                } else {
                    i3 = 0;
                    i16 = 0;
                    i17 = 0;
                    i18 = 0;
                }
                hashMap.put("fpsAvg", String.valueOf(this.f199698f));
                hashMap.put("fps0", String.valueOf(this.f199699h));
                hashMap.put("fps18", String.valueOf(this.f199700i));
                hashMap.put("fps25", String.valueOf(this.f199701m));
                hashMap.put("duration", String.valueOf(this.C));
                hashMap.put("pss", String.valueOf(i16));
                hashMap.put("level", String.valueOf(this.D));
                hashMap.put("devType", String.valueOf(ARMapTracer.a()));
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f199696d, "actARMapTrace", this.f199697e, this.C, i16, hashMap, null);
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder(200);
                    sb5.append("ReportRunnable [");
                    sb5.append("suc: ");
                    sb5.append(this.f199697e);
                    sb5.append(", duration: ");
                    sb5.append(this.C);
                    sb5.append(", fpsAvg: ");
                    sb5.append(this.f199698f);
                    sb5.append(", fps0: ");
                    sb5.append(this.f199699h);
                    sb5.append(", fps18: ");
                    sb5.append(this.f199700i);
                    sb5.append(", fps25: ");
                    sb5.append(this.f199701m);
                    sb5.append(", level: ");
                    sb5.append(this.D);
                    sb5.append(", pss: ");
                    sb5.append(i16);
                    sb5.append(", otherPss: ");
                    sb5.append(i3);
                    sb5.append(", nativePss: ");
                    sb5.append(i17);
                    sb5.append(", dalvikPss: ");
                    sb5.append(i18);
                    sb5.append("]");
                    QLog.i("ARMapTracer", 2, sb5.toString());
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70851);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f199689a = 0;
        }
    }

    public static int a() {
        if (f199689a == 0) {
            float c16 = ((float) m.c()) / 1.07374182E9f;
            int n3 = ah.n();
            float m3 = ((float) ah.m()) / 1000000.0f;
            if (n3 >= 4 && m3 >= 2.0f && c16 >= 2.5f) {
                f199689a = 1;
            } else if (n3 >= 4 && m3 >= 1.5f && c16 >= 1.7f) {
                f199689a = 2;
            } else {
                f199689a = 3;
            }
            if (QLog.isColorLevel()) {
                QLog.i("ARMapTracer", 2, String.format(Locale.getDefault(), "DEV_TYPE: %d, RAM: %f, CPU-NUM: %d, CPU-Freq: %f", Integer.valueOf(f199689a), Float.valueOf(c16), Integer.valueOf(n3), Float.valueOf(m3)));
            }
        }
        return f199689a;
    }
}
