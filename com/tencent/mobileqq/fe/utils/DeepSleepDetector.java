package com.tencent.mobileqq.fe.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.mobileqq.fe.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes12.dex */
public class DeepSleepDetector {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "fekit_DeepSleepDetector";
    private static Handler checkHandler;
    private static CheckRunnable checkRunnable;
    private static final Object lock;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    static class CheckRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private long f205842d;

        /* renamed from: e, reason: collision with root package name */
        private long f205843e;

        CheckRunnable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f205842d = SystemClock.elapsedRealtime();
            }
        }

        public float e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Float) iPatchRedirector.redirect((short) 3, (Object) this)).floatValue();
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.f205842d;
            float f16 = ((float) elapsedRealtime) / 1000.0f;
            c.c(DeepSleepDetector.TAG, 1, "check result count " + this.f205843e + " cost time " + elapsedRealtime);
            return f16 - ((float) this.f205843e);
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                synchronized (DeepSleepDetector.lock) {
                    this.f205843e++;
                    if (DeepSleepDetector.checkHandler != null) {
                        DeepSleepDetector.checkHandler.postDelayed(this, 1000L);
                    }
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13189);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            lock = new Object();
        }
    }

    public DeepSleepDetector() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String getCheckResult() {
        CheckRunnable checkRunnable2 = checkRunnable;
        if (checkRunnable2 != null) {
            return String.valueOf(checkRunnable2.e());
        }
        return "-1";
    }

    public static void startCheck() {
        c.c(TAG, 1, "startCheck");
        if (checkHandler == null) {
            checkHandler = new Handler(Looper.getMainLooper());
            CheckRunnable checkRunnable2 = new CheckRunnable();
            checkRunnable = checkRunnable2;
            checkHandler.postDelayed(checkRunnable2, 1000L);
        }
    }

    private static void stopCheck() {
        CheckRunnable checkRunnable2;
        synchronized (lock) {
            c.c(TAG, 1, "stop check");
            Handler handler = checkHandler;
            if (handler != null && (checkRunnable2 = checkRunnable) != null) {
                handler.removeCallbacks(checkRunnable2);
            }
            checkHandler = null;
            checkRunnable = null;
        }
    }
}
