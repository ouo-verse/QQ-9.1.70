package com.tencent.msdk.dns.c.d;

import android.app.Activity;
import android.content.Context;
import com.epicgames.ue4.GameActivity;
import com.epicgames.ue4.Logger;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes21.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static a f336232a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class b extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: c, reason: collision with root package name */
        private static Class f336233c;

        /* renamed from: b, reason: collision with root package name */
        private Activity f336234b;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17410);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            try {
                f336233c = Class.forName("org.cocos2dx.lib.Cocos2dxActivity");
            } catch (Throwable unused) {
                f336233c = null;
            }
        }

        b() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f336234b = null;
            }
        }

        static a d() {
            if (f336233c == null) {
                return null;
            }
            return new b();
        }

        @Override // com.tencent.msdk.dns.c.d.a
        public Activity c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Activity) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            Activity activity = this.f336234b;
            if (activity != null) {
                return activity;
            }
            try {
                Context context = (Context) f336233c.getMethod("getContext", new Class[0]).invoke(null, new Object[0]);
                if (context instanceof Activity) {
                    this.f336234b = (Activity) context;
                }
            } catch (Throwable th5) {
                com.tencent.msdk.dns.base.log.c.d(th5, "Get Activity failed", new Object[0]);
            }
            return this.f336234b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class c extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        private static Class f336235b;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16152);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            try {
                f336235b = Class.forName("com.unity3d.player.UnityPlayer");
            } catch (Throwable unused) {
                f336235b = null;
            }
        }

        c() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        static a d() {
            if (f336235b == null) {
                return null;
            }
            return new c();
        }

        @Override // com.tencent.msdk.dns.c.d.a
        public Activity c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Activity) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            try {
                return (Activity) f336235b.getField("currentActivity").get(null);
            } catch (Throwable th5) {
                com.tencent.msdk.dns.base.log.c.d(th5, "Get Activity failed", new Object[0]);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class d extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        private static Class f336236b;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18123);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            try {
                Logger logger = GameActivity.Log;
                f336236b = GameActivity.class;
            } catch (Throwable unused) {
                f336236b = null;
            }
        }

        d() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        static a d() {
            if (f336236b == null) {
                return null;
            }
            return new d();
        }

        @Override // com.tencent.msdk.dns.c.d.a
        public Activity c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Activity) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            try {
                return (Activity) f336236b.getMethod("Get", new Class[0]).invoke(null, new Object[0]);
            } catch (Throwable th5) {
                com.tencent.msdk.dns.base.log.c.d(th5, "Get Activity failed", new Object[0]);
                return null;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16770);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f336232a = a();
        }
    }

    /* synthetic */ a(C9210a c9210a) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) c9210a);
    }

    private static a a() {
        a d16 = b.d();
        if (d16 != null) {
            return d16;
        }
        a d17 = c.d();
        if (d17 != null) {
            return d17;
        }
        a d18 = d.d();
        if (d18 != null) {
            return d18;
        }
        return new a();
    }

    public static a b() {
        return f336232a;
    }

    public Activity c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Activity) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return null;
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
