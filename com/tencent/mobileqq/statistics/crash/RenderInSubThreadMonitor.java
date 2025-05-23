package com.tencent.mobileqq.statistics.crash;

import android.os.Looper;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.util.AppSetting;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes18.dex */
public class RenderInSubThreadMonitor {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "RendererMonitor";
    private static AtomicBoolean sPauseMonitorTemp;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    static class RenderInSubThreadException extends RuntimeException {
        static IPatchRedirector $redirector_;

        public RenderInSubThreadException(String str) {
            super(str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47758);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sPauseMonitorTemp = new AtomicBoolean(false);
        }
    }

    public RenderInSubThreadMonitor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @RequiresApi(api = 19)
    public static void checkWithObj(Object obj) {
        try {
            if (!AppSetting.isPublicVersion() && !sPauseMonitorTemp.get() && (obj instanceof View)) {
                View view = (View) obj;
                if (view.isAttachedToWindow() && view.getVisibility() == 0 && !isMainThread()) {
                    QLog.e(TAG, 1, "Render in SubThread is not approved,Process will exit !!!\n");
                    throwException(new RuntimeException("Render in SubThread is not approved,Process will exit !!!\n"));
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void disableMonitor() {
        sPauseMonitorTemp.compareAndSet(false, true);
    }

    public static void enableMonitor() {
        sPauseMonitorTemp.compareAndSet(true, false);
    }

    private static boolean isMainThread() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return true;
        }
        return false;
    }

    private static void throwException(Throwable th5) {
        new BaseThread(th5) { // from class: com.tencent.mobileqq.statistics.crash.RenderInSubThreadMonitor.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Throwable C;

            {
                this.C = th5;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) th5);
                }
            }

            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                throw new RenderInSubThreadException(Log.getStackTraceString(this.C));
            }
        }.start();
    }
}
