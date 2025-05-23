package com.tencent.nativecrash;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.nio.charset.Charset;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class NativeCrash {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static c f337806a;

    /* renamed from: b, reason: collision with root package name */
    public static a f337807b;

    /* renamed from: c, reason: collision with root package name */
    public static final Charset f337808c;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface a {
        boolean a(int i3, String str);
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class b implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public boolean f337809a;

        /* renamed from: b, reason: collision with root package name */
        public Throwable f337810b;

        /* renamed from: c, reason: collision with root package name */
        public final c f337811c;

        /* renamed from: d, reason: collision with root package name */
        public final a f337812d;

        /* renamed from: e, reason: collision with root package name */
        public final int f337813e;

        /* renamed from: f, reason: collision with root package name */
        public final String f337814f;

        /* renamed from: g, reason: collision with root package name */
        public final String f337815g;

        public b(boolean z16, int i3, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Integer.valueOf(i3), str, str2);
                return;
            }
            this.f337809a = false;
            this.f337810b = null;
            if (z16) {
                this.f337811c = null;
                this.f337812d = NativeCrash.a();
            } else {
                this.f337811c = NativeCrash.b();
                this.f337812d = null;
            }
            this.f337813e = i3;
            this.f337814f = str;
            this.f337815g = str2;
        }

        public boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            if (this.f337811c == null && this.f337812d == null) {
                return false;
            }
            BaseThread baseThread = new BaseThread(this, "NativeCrash Dump Callback");
            baseThread.start();
            baseThread.join(5000L);
            return this.f337809a;
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            try {
                a aVar = this.f337812d;
                if (aVar != null) {
                    this.f337809a = aVar.a(this.f337813e, this.f337815g);
                    return;
                }
                c cVar = this.f337811c;
                if (cVar != null) {
                    this.f337809a = cVar.a(this.f337813e, this.f337814f, this.f337815g);
                } else {
                    this.f337809a = false;
                }
            } catch (Throwable th5) {
                this.f337810b = th5;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface c {
        boolean a(int i3, String str, String str2);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61723);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f337808c = Charset.forName("UTF-8");
        }
    }

    public static c a(c cVar) {
        c cVar2 = f337806a;
        f337806a = cVar;
        return cVar2;
    }

    public static c b() {
        return f337806a;
    }

    public static void c() {
        nativeResetCustomInfo();
    }

    private static native void nativeCustomInfo(byte[] bArr);

    private static native void nativeInit(String str, int i3, int i16, boolean z16);

    private static native void nativeResetCustomInfo();

    @Keep
    private static boolean onANRDumped(int i3, String str) throws Throwable {
        return new b(true, i3, null, str).a();
    }

    @Keep
    private static boolean onCrashDumped(int i3, String str, String str2) throws Throwable {
        return new b(false, i3, str, str2).a();
    }

    public static a a() {
        return f337807b;
    }

    public static a a(a aVar) {
        a aVar2 = f337807b;
        f337807b = aVar;
        return aVar2;
    }

    public static void a(String str, int i3, int i16, boolean z16) {
        if (!InitializationProbe.libLoaded) {
            System.loadLibrary("wechatcrash");
        }
        nativeInit(str, i3, i16, z16);
    }

    public static void a(String str) {
        String str2;
        if (str == null) {
            return;
        }
        if (!str.endsWith("\n")) {
            str2 = str + "\n\u0000";
        } else {
            str2 = str + (char) 0;
        }
        nativeCustomInfo(str2.getBytes(f337808c));
    }
}
