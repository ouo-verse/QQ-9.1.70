package com.tencent.mobileqq.nativememorymonitor.library.trafficmonitor;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.nativememorymonitor.library.NativeMemoryMonitor;
import com.tencent.mobileqq.nlog.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes15.dex */
public class NativeTrafficMonitor {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "NativeTrafficMonitor";
    private static int recordThreadStackRange;
    private static int recordThreadStackStart;
    private static ITrafficReporter trafficReporter;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private static class Holder {
        static IPatchRedirector $redirector_;
        private static NativeTrafficMonitor INSTANCE;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11903);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                INSTANCE = new NativeTrafficMonitor();
            }
        }

        Holder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private static class defaultTrafficReporter implements ITrafficReporter {
        static IPatchRedirector $redirector_;

        defaultTrafficReporter() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @Override // com.tencent.mobileqq.nativememorymonitor.library.trafficmonitor.ITrafficReporter
        public boolean onGlobalFdsTrafficReport(Set<TrafficReportBean> set, long j3, long j16, long j17, long j18, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, set, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18), Boolean.valueOf(z16))).booleanValue();
            }
            NativeMemoryMonitor.i(NativeTrafficMonitor.TAG, "defaultTrafficReporter onGlobalFdsTrafficReport, mobileSumTraffic: " + j3 + ", wifiSumTraffic: " + j16 + ", bgMobileSumTraffic: " + j17 + ", bgWifiSumTraffic: " + j18 + ", isReportMobileTraffic:" + z16 + ", params size: " + set.size() + " params: " + set);
            return true;
        }

        @Override // com.tencent.mobileqq.nativememorymonitor.library.trafficmonitor.ITrafficReporter
        public void onSingleFdTrafficReport(TrafficReportBean trafficReportBean) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) trafficReportBean);
                return;
            }
            NativeMemoryMonitor.i(NativeTrafficMonitor.TAG, "defaultTrafficReporter onSingleFdTrafficReport: " + trafficReportBean);
        }

        /* synthetic */ defaultTrafficReporter(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) anonymousClass1);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11916);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
            return;
        }
        trafficReporter = new defaultTrafficReporter(null);
        recordThreadStackStart = 0;
        recordThreadStackRange = Integer.MAX_VALUE;
    }

    public NativeTrafficMonitor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static NativeTrafficMonitor getInstance() {
        NativeMemoryMonitor.loadSoIfNeeded();
        return Holder.INSTANCE;
    }

    private static String[] getThreadStackTrace() {
        String name = Thread.currentThread().getName();
        StringBuilder sb5 = new StringBuilder();
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (int i3 = recordThreadStackStart; i3 < recordThreadStackRange && i3 < stackTrace.length; i3++) {
            sb5.append(stackTrace[i3]);
            sb5.append("\n");
        }
        return new String[]{name, sb5.toString()};
    }

    private native void nativeSetNetStateIsMobile(boolean z16);

    private native void nativeTrafficMonitorInit(Object obj);

    private static boolean onGlobalFdsTrafficReport(Set<TrafficReportBean> set, long j3, long j16, long j17, long j18, boolean z16) {
        NativeMemoryMonitor.e(TAG, "traffic onGlobalFdsTrafficReport");
        ITrafficReporter iTrafficReporter = trafficReporter;
        if (iTrafficReporter == null) {
            return true;
        }
        return iTrafficReporter.onGlobalFdsTrafficReport(set, j3, j16, j17, j18, z16);
    }

    private static void onSingleFdTrafficReport(TrafficReportBean trafficReportBean) {
        String[] threadStackTrace = getThreadStackTrace();
        trafficReportBean.threadName = threadStackTrace[0];
        trafficReportBean.threadStack = threadStackTrace[1];
        ITrafficReporter iTrafficReporter = trafficReporter;
        if (iTrafficReporter == null) {
            return;
        }
        iTrafficReporter.onSingleFdTrafficReport(trafficReportBean);
    }

    public native void nativeEnableDetailMonitor(boolean z16);

    public native void nativeEnableGlobalMonitor(boolean z16);

    public native void nativeSetAppIsOnForeground(boolean z16);

    public native void nativeSetGloBalMonitorThreshold(long j3, long j16, long j17, long j18, long j19, long j26);

    public native void nativeSetReportThreshold(long j3, long j16, long j17, long j18);

    public void setNetStateIsMobile(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        if (!NativeMemoryMonitor.getSoLoadRes()) {
            c.c(TAG, "[setNetStateIsMobile] load so fail, return");
            return;
        }
        try {
            nativeSetNetStateIsMobile(z16);
        } catch (UnsatisfiedLinkError e16) {
            c.b(TAG, "setNetStateIsMobile", e16);
        }
    }

    public void setRecordThreadStackLines(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            recordThreadStackStart = i3;
            recordThreadStackRange = i16;
        }
    }

    public void setTrafficReporter(@NonNull ITrafficReporter iTrafficReporter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iTrafficReporter);
        } else {
            trafficReporter = iTrafficReporter;
        }
    }

    public synchronized void setUpTrafficMonitor(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
            return;
        }
        if (Build.VERSION.SDK_INT <= 23) {
            return;
        }
        NativeMemoryMonitor.getInstance().initJniHook();
        if (!NativeMemoryMonitor.getSoLoadRes()) {
            c.c(TAG, "[setUpTrafficMonitor] load so fail, return");
        } else {
            nativeTrafficMonitorInit(new InetMethodHolder());
        }
    }
}
