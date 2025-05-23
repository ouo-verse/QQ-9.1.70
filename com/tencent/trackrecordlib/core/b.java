package com.tencent.trackrecordlib.core;

import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b extends BaseHandlerThread {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    private static final String f381032a = "HookThread";

    /* renamed from: b, reason: collision with root package name */
    private static Handler f381033b;

    /* renamed from: c, reason: collision with root package name */
    private static MessageQueue f381034c;

    /* renamed from: d, reason: collision with root package name */
    private static Runnable f381035d;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f381036e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10824);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f381036e = true;
        }
    }

    public b() {
        super(f381032a);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void c() {
        MessageQueue messageQueue = f381034c;
        if (messageQueue != null && f381033b != null) {
            messageQueue.addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.tencent.trackrecordlib.core.b.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                    }
                }

                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                    }
                    if (b.f381035d != null) {
                        boolean unused = b.f381036e = false;
                        b.f381033b.post(b.f381035d);
                        Runnable unused2 = b.f381035d = null;
                    } else {
                        boolean unused3 = b.f381036e = true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // android.os.HandlerThread
    protected void onLooperPrepared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.onLooperPrepared();
        f381033b = new Handler(Looper.myLooper());
        f381034c = Looper.myQueue();
        c();
    }

    public static boolean a(Runnable runnable) {
        if (f381036e) {
            f381036e = false;
            f381035d = null;
            Handler handler = f381033b;
            return handler != null && handler.post(runnable);
        }
        f381035d = runnable;
        return true;
    }
}
