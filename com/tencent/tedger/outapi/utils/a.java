package com.tencent.tedger.outapi.utils;

import android.os.Handler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* renamed from: com.tencent.tedger.outapi.utils.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static class C9901a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f375277a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f375278b;

        public C9901a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public static Handler a(String str, int i3, Handler.Callback callback, C9901a c9901a) {
        try {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread(str, i3);
            baseHandlerThread.start();
            Handler handler = new Handler(baseHandlerThread.getLooper(), callback);
            c9901a.f375278b = true;
            return handler;
        } catch (OutOfMemoryError e16) {
            c9901a.f375278b = false;
            c9901a.f375277a = e16.toString();
            return null;
        }
    }
}
