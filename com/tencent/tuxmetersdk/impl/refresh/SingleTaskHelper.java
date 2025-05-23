package com.tencent.tuxmetersdk.impl.refresh;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SingleTaskHelper {
    static IPatchRedirector $redirector_;
    private final Handler handler;
    private final HandlerThread handlerThread;
    private long interval;
    private OnSingleTaskListener listener;
    private Runnable task;

    public SingleTaskHelper(long j3, OnSingleTaskListener onSingleTaskListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), onSingleTaskListener);
            return;
        }
        this.interval = j3;
        this.listener = onSingleTaskListener;
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("TuxSingleTaskThread");
        this.handlerThread = baseHandlerThread;
        baseHandlerThread.start();
        this.handler = new Handler(baseHandlerThread.getLooper());
        createTask();
    }

    private void createTask() {
        this.task = new Runnable() { // from class: com.tencent.tuxmetersdk.impl.refresh.a
            @Override // java.lang.Runnable
            public final void run() {
                SingleTaskHelper.this.lambda$createTask$0();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createTask$0() {
        OnSingleTaskListener onSingleTaskListener = this.listener;
        if (onSingleTaskListener != null) {
            onSingleTaskListener.onAction();
        }
        start();
    }

    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            stop();
            this.handler.postDelayed(this.task, this.interval);
        }
    }

    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.handler.removeCallbacks(this.task);
        }
    }

    public void updateInterval(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
        } else {
            this.interval = j3;
        }
    }
}
