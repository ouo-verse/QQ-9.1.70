package com.tencent.mobileqq.statistics.crash;

import android.annotation.SuppressLint;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class CopyOnWriteArrayListMonitor {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "COWriteArrayListMonitor";

    /* compiled from: P */
    /* loaded from: classes18.dex */
    static class CopyOnWriteArrayListException extends RuntimeException {
        static IPatchRedirector $redirector_;

        public CopyOnWriteArrayListException(String str) {
            super(str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            }
        }
    }

    public CopyOnWriteArrayListMonitor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @SuppressLint({"NewApi"})
    public static void checkWithObj(Object obj) {
        try {
            if (obj instanceof CopyOnWriteArrayList) {
                Log.e(TAG, "Collections.sort's first parameter couldn't be CopyOnWriteArrayList", new RuntimeException());
                throwException(new RuntimeException());
            }
        } catch (Throwable unused) {
        }
    }

    private static void throwException(Throwable th5) {
        new BaseThread(th5) { // from class: com.tencent.mobileqq.statistics.crash.CopyOnWriteArrayListMonitor.1
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
                throw new CopyOnWriteArrayListException(Log.getStackTraceString(this.C));
            }
        }.start();
    }
}
