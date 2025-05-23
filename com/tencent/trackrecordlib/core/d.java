package com.tencent.trackrecordlib.core;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* compiled from: P */
/* loaded from: classes26.dex */
public class d extends BaseThread {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static final int f381081a = 1001;

    /* renamed from: b, reason: collision with root package name */
    private static final String f381082b = "RecordThread";

    /* renamed from: c, reason: collision with root package name */
    private static Handler f381083c;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean a(Runnable runnable) {
        Handler handler = f381083c;
        return handler != null && handler.post(runnable);
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    @SuppressLint({"HandlerLeak"})
    public void run() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (Looper.myLooper() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Looper.prepare();
        }
        f381083c = new Handler() { // from class: com.tencent.trackrecordlib.core.d.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) d.this);
                }
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) message);
                } else if (message.what != 1001) {
                    Log.e(d.f381082b, "can't accept msg.what: " + message.what);
                }
            }
        };
        if (z16) {
            Looper.loop();
        }
    }

    public static boolean a(Message message) {
        Handler handler = f381083c;
        return handler != null && handler.sendMessage(message);
    }
}
