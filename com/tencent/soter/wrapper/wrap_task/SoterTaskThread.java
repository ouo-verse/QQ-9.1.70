package com.tencent.soter.wrapper.wrap_task;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.soter.core.model.SLogger;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SoterTaskThread {
    static IPatchRedirector $redirector_ = null;
    private static final String HANDLER_THREAD_NAME = "SoterGenKeyHandlerThreadName";
    private static final String TAG = "Soter.SoterTaskThread";
    private static volatile SoterTaskThread mInstance;
    private Handler mMainLooperHandler;
    private Handler mTaskHandler;
    private HandlerThread mTaskHandlerThread;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18054);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            mInstance = null;
        }
    }

    SoterTaskThread() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mTaskHandler = null;
        this.mMainLooperHandler = null;
        if (this.mTaskHandlerThread == null) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread(HANDLER_THREAD_NAME);
            this.mTaskHandlerThread = baseHandlerThread;
            baseHandlerThread.start();
            if (this.mTaskHandlerThread.getLooper() != null) {
                this.mTaskHandler = new Handler(this.mTaskHandlerThread.getLooper());
            } else {
                SLogger.e(TAG, "soter: task looper is null! use main looper as the task looper", new Object[0]);
                this.mTaskHandler = new Handler(Looper.getMainLooper());
            }
        }
        this.mMainLooperHandler = new Handler(Looper.getMainLooper());
    }

    public static SoterTaskThread getInstance() {
        SoterTaskThread soterTaskThread;
        if (mInstance == null) {
            synchronized (SoterTaskThread.class) {
                if (mInstance == null) {
                    mInstance = new SoterTaskThread();
                }
                soterTaskThread = mInstance;
            }
            return soterTaskThread;
        }
        return mInstance;
    }

    public void postToMainThread(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) runnable);
        } else {
            this.mMainLooperHandler.post(runnable);
        }
    }

    public void postToMainThreadDelayed(Runnable runnable, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, runnable, Long.valueOf(j3));
        } else {
            this.mMainLooperHandler.postDelayed(runnable, j3);
        }
    }

    public void postToWorker(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) runnable);
        } else {
            this.mTaskHandler.post(runnable);
        }
    }

    public void postToWorkerDelayed(Runnable runnable, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, runnable, Long.valueOf(j3));
        } else {
            this.mTaskHandler.postDelayed(runnable, j3);
        }
    }

    public void setTaskHandlerThread(HandlerThread handlerThread) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) handlerThread);
            return;
        }
        HandlerThread handlerThread2 = this.mTaskHandlerThread;
        if (handlerThread2 != null && handlerThread2.isAlive()) {
            SLogger.i(TAG, "quit the previous thread", new Object[0]);
            this.mTaskHandlerThread.quit();
        }
        this.mTaskHandlerThread = handlerThread;
        handlerThread.setName(HANDLER_THREAD_NAME);
        if (!handlerThread.isAlive()) {
            handlerThread.start();
        }
        this.mTaskHandler = new Handler(this.mTaskHandlerThread.getLooper());
    }
}
