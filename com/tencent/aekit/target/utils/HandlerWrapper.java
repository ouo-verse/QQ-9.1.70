package com.tencent.aekit.target.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class HandlerWrapper extends Handler {
    static IPatchRedirector $redirector_;

    /* renamed from: mh, reason: collision with root package name */
    private MessageHandler f61813mh;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface MessageHandler {
        void handleMessage(Message message);
    }

    public HandlerWrapper(Looper looper) {
        super(looper);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) looper);
        } else {
            this.f61813mh = null;
        }
    }

    public void call(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
            return;
        }
        Object obj = new Object();
        synchronized (obj) {
            post(new Runnable(obj, runnable) { // from class: com.tencent.aekit.target.utils.HandlerWrapper.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Runnable val$r;
                final /* synthetic */ Object val$syncObj;

                {
                    this.val$syncObj = obj;
                    this.val$r = runnable;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, HandlerWrapper.this, obj, runnable);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    synchronized (this.val$syncObj) {
                        this.val$r.run();
                        this.val$syncObj.notifyAll();
                    }
                }
            });
            try {
                LockMethodProxy.wait(obj);
            } catch (InterruptedException e16) {
                e16.printStackTrace();
            }
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) message);
            return;
        }
        MessageHandler messageHandler = this.f61813mh;
        if (messageHandler != null) {
            messageHandler.handleMessage(message);
        }
    }

    public void setMessageHandler(MessageHandler messageHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) messageHandler);
        } else {
            this.f61813mh = messageHandler;
        }
    }
}
