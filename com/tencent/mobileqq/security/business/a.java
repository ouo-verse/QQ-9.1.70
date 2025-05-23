package com.tencent.mobileqq.security.business;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a implements BusinessObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public final String f285284d;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.security.business.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public class C8555a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private long f285285a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f285286b;

        /* renamed from: c, reason: collision with root package name */
        private String f285287c;

        /* renamed from: d, reason: collision with root package name */
        private String f285288d;

        /* renamed from: e, reason: collision with root package name */
        private int f285289e;

        public C8555a(long j3, boolean z16, String str, String str2, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, Long.valueOf(j3), Boolean.valueOf(z16), str, str2, Integer.valueOf(i3));
                return;
            }
            this.f285285a = j3;
            this.f285286b = z16;
            this.f285287c = str;
            this.f285288d = str2;
            this.f285289e = i3;
        }

        public String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.f285288d;
        }

        public String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.f285287c;
        }

        public long c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
            }
            return this.f285285a;
        }

        public int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.f285289e;
        }

        public boolean e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.f285286b;
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f285284d = "ModifyPwdTopBarObserver";
        }
    }

    private boolean a(Object obj) {
        if (obj != null && (obj instanceof Object[]) && ((Object[]) obj).length == 5) {
            return true;
        }
        return false;
    }

    private void c(boolean z16, Object obj) {
        if (a(obj)) {
            Object[] objArr = (Object[]) obj;
            b(z16, new C8555a(((Long) objArr[0]).longValue(), ((Boolean) objArr[1]).booleanValue(), (String) objArr[2], (String) objArr[3], ((Integer) objArr[4]).intValue()));
        } else {
            QLog.e("ModifyPwdTopBarObserver", 2, "onUpdateDisplayInfo error");
        }
    }

    public void b(boolean z16, C8555a c8555a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), c8555a);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
        } else if (i3 == 1) {
            c(z16, obj);
        }
    }
}
