package com.tencent.mobileqq.videoplatform.imp;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.videoplatform.api.IThreadMgr;
import com.tencent.mobileqq.videoplatform.util.LogUtil;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ThreadMgrImp implements IThreadMgr {
    static IPatchRedirector $redirector_;
    Handler mMainHandler;
    Handler mSubHandler;
    volatile HandlerThread mSubThread;

    public ThreadMgrImp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private String getLogTag() {
        return "[VideoPlatForm]ThreadMgrImp";
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IThreadMgr
    public void postOnSubThread(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) runnable);
            return;
        }
        synchronized (this) {
            if (this.mSubThread == null) {
                this.mSubThread = new BaseHandlerThread("VideoPlatfom_SUB", 0);
                this.mSubThread.start();
                this.mSubHandler = new Handler(this.mSubThread.getLooper());
                if (LogUtil.isColorLevel()) {
                    LogUtil.d(getLogTag(), 2, "new sub thread");
                }
            }
        }
        this.mSubHandler.post(runnable);
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IThreadMgr
    public void postOnSubThreadDelayed(Runnable runnable, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, runnable, Long.valueOf(j3));
            return;
        }
        synchronized (this) {
            if (this.mSubThread == null) {
                this.mSubThread = new BaseHandlerThread("VideoPlatfom_SUB", 0);
                this.mSubThread.start();
                this.mSubHandler = new Handler(this.mSubThread.getLooper());
                if (LogUtil.isColorLevel()) {
                    LogUtil.d(getLogTag(), 2, "new sub thread");
                }
            }
        }
        this.mSubHandler.postDelayed(runnable, j3);
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IThreadMgr
    public void postOnUIThread(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
            return;
        }
        synchronized (this) {
            if (this.mMainHandler == null) {
                this.mMainHandler = new Handler(Looper.getMainLooper());
            }
            this.mMainHandler.post(runnable);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IThreadMgr
    public void postOnUIThreadDelayed(Runnable runnable, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, runnable, Long.valueOf(j3));
            return;
        }
        synchronized (this) {
            if (this.mMainHandler == null) {
                this.mMainHandler = new Handler(Looper.getMainLooper());
            }
            this.mMainHandler.postDelayed(runnable, j3);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IThreadMgr
    public void quitSubThread() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (LogUtil.isColorLevel()) {
            LogUtil.d(getLogTag(), 2, "quitSubThread");
        }
        synchronized (this) {
            if (this.mSubThread != null) {
                this.mSubThread.quitSafely();
            }
            this.mSubHandler = null;
            this.mSubThread = null;
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IThreadMgr
    public void removeCallbackOnSubHandler(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) runnable);
            return;
        }
        synchronized (this) {
            Handler handler = this.mSubHandler;
            if (handler != null) {
                handler.removeCallbacks(runnable);
            }
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IThreadMgr
    public void removeCallbackOnUIHandler(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) runnable);
            return;
        }
        synchronized (this) {
            Handler handler = this.mMainHandler;
            if (handler != null) {
                handler.removeCallbacks(runnable);
            }
        }
    }
}
