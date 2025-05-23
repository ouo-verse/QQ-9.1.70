package com.tencent.mobileqq.microapp.app;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class b extends Observable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static b f245885a;

    /* renamed from: b, reason: collision with root package name */
    private static byte[] f245886b;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f245887a;

        /* renamed from: b, reason: collision with root package name */
        public com.tencent.mobileqq.microapp.a.c f245888b;

        /* renamed from: c, reason: collision with root package name */
        public String f245889c;

        /* renamed from: d, reason: collision with root package name */
        public int f245890d;

        public a(int i3, String str, int i16, com.tencent.mobileqq.microapp.a.c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, Integer.valueOf(i16), cVar);
                return;
            }
            this.f245887a = i3;
            this.f245889c = str;
            this.f245890d = i16;
            this.f245888b = cVar;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "MiniAppStateMsg{state=" + this.f245887a + ", apkgInfo=" + this.f245888b + ", appId='" + this.f245889c + "', versionType='" + this.f245890d + "'}";
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.microapp.app.b$b, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C8029b implements Observer {
        static IPatchRedirector $redirector_;

        public C8029b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public void a(a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        }

        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) observable, obj);
            } else if (obj instanceof a) {
                a((a) obj);
            } else if (obj instanceof c) {
                a((c) obj);
            }
        }

        public void a(c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f245891a;

        /* renamed from: b, reason: collision with root package name */
        public int f245892b;

        /* renamed from: c, reason: collision with root package name */
        public String f245893c;

        /* renamed from: d, reason: collision with root package name */
        public String f245894d;

        /* renamed from: e, reason: collision with root package name */
        public String f245895e;

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (String) iPatchRedirector.redirect((short) 1, (Object) this);
            }
            return "ShareMsg{appId=" + this.f245891a + ", versionType=" + this.f245892b + ", content=" + this.f245893c + ", sharePicPath=" + this.f245894d + ", entryPath='" + this.f245895e + "'}";
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9864);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f245886b = new byte[0];
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static b a() {
        if (f245885a == null) {
            synchronized (f245886b) {
                if (f245885a == null) {
                    f245885a = new b();
                }
            }
        }
        return f245885a;
    }

    public void a(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MiniAppStateManager", 2, "notifyChange...msg=" + obj);
        }
        setChanged();
        if (obj != null) {
            notifyObservers(obj);
        } else {
            notifyObservers();
        }
    }
}
