package com.tencent.hlyyb.downloader.g.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes7.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static Map<b, Handler> f114672a;

    /* renamed from: b, reason: collision with root package name */
    public static Handler f114673b;

    /* renamed from: c, reason: collision with root package name */
    public static Handler f114674c;

    /* renamed from: d, reason: collision with root package name */
    public static Handler f114675d;

    /* renamed from: e, reason: collision with root package name */
    public static Handler f114676e;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class a extends Handler {
        static IPatchRedirector $redirector_;

        public a(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            } else {
                try {
                    super.dispatchMessage(message);
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final b f114677a;

        /* renamed from: b, reason: collision with root package name */
        public static final b f114678b;

        /* renamed from: c, reason: collision with root package name */
        public static final b f114679c;

        /* renamed from: d, reason: collision with root package name */
        public static final b f114680d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19078);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            f114677a = new b("YYB_DOWNLOAD_SDK_DEFAULT", 0);
            f114678b = new b("YYB_DOWNLOAD_SDK_CONFIG", 1);
            f114679c = new b("YYB_DOWNLOAD_SDK_HELPER", 2);
            f114680d = new b("YYB_DOWNLOAD_SDK_FETCH", 3);
        }

        public b(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17542);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f114672a = new ConcurrentHashMap();
        }
    }

    public static Handler a() {
        if (f114674c == null) {
            f114674c = b(b.f114678b);
        }
        return f114674c;
    }

    public static Handler b(b bVar) {
        if (f114672a.containsKey(bVar)) {
            return f114672a.get(bVar);
        }
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread(bVar.name());
        baseHandlerThread.start();
        a aVar = new a(baseHandlerThread.getLooper());
        f114672a.put(bVar, aVar);
        return aVar;
    }

    public static Handler c() {
        if (f114673b == null) {
            f114673b = b(b.f114677a);
        }
        return f114673b;
    }

    public static Handler d() {
        if (f114676e == null) {
            f114676e = b(b.f114680d);
        }
        return f114676e;
    }

    public static Handler e() {
        if (f114675d == null) {
            f114675d = b(b.f114679c);
        }
        return f114675d;
    }
}
