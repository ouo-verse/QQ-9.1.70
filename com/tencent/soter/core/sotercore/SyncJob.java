package com.tencent.soter.core.sotercore;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.soter.core.model.SLogger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SyncJob {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "Soter.SyncJob";
    private static Handler mMainLooperHandler;
    private CountDownLatch countDownWait;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18218);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            mMainLooperHandler = null;
        }
    }

    public SyncJob() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.countDownWait = null;
        }
    }

    private static void postToMainThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (mMainLooperHandler == null) {
            mMainLooperHandler = new Handler(Looper.getMainLooper());
        }
        mMainLooperHandler.post(runnable);
    }

    public void countDown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        CountDownLatch countDownLatch = this.countDownWait;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    public void doAsSyncJob(long j3, Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), runnable);
            return;
        }
        SLogger.i(TAG, "doAsSyncJob", new Object[0]);
        if (runnable == null) {
            return;
        }
        this.countDownWait = new CountDownLatch(1);
        runnable.run();
        CountDownLatch countDownLatch = this.countDownWait;
        if (countDownLatch != null) {
            try {
                countDownLatch.await(j3, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e16) {
                SLogger.printErrStackTrace(TAG, e16, "");
            }
        }
    }
}
