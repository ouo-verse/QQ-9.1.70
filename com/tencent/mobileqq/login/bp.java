package com.tencent.mobileqq.login;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.bean.AccountInfo;
import com.tencent.mobileqq.login.LoginReportConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class bp {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f242004a;

    /* renamed from: b, reason: collision with root package name */
    @LoginReportConstants.LoginScene
    public int f242005b;

    /* renamed from: c, reason: collision with root package name */
    public AccountInfo f242006c;

    /* renamed from: d, reason: collision with root package name */
    public String f242007d;

    /* renamed from: e, reason: collision with root package name */
    public String f242008e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f242009f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f242010g;

    /* renamed from: h, reason: collision with root package name */
    public String f242011h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f242012i;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final int f242013a;

        /* renamed from: b, reason: collision with root package name */
        private final int f242014b;

        /* renamed from: c, reason: collision with root package name */
        private final AccountInfo f242015c;

        /* renamed from: d, reason: collision with root package name */
        private String f242016d;

        /* renamed from: e, reason: collision with root package name */
        private String f242017e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f242018f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f242019g;

        /* renamed from: h, reason: collision with root package name */
        private String f242020h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f242021i;

        public a(int i3, @LoginReportConstants.LoginScene int i16, @NonNull AccountInfo accountInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), accountInfo);
                return;
            }
            this.f242013a = i3;
            this.f242014b = i16;
            this.f242015c = accountInfo;
        }

        public bp a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (bp) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            bp bpVar = new bp();
            bpVar.f242008e = this.f242017e;
            bpVar.f242007d = this.f242016d;
            bpVar.f242009f = this.f242018f;
            bpVar.f242004a = this.f242013a;
            bpVar.f242005b = this.f242014b;
            bpVar.f242006c = this.f242015c;
            bpVar.f242010g = this.f242019g;
            bpVar.f242011h = this.f242020h;
            bpVar.f242012i = this.f242021i;
            return bpVar;
        }

        public a b(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            this.f242017e = str;
            return this;
        }

        public a c(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (a) iPatchRedirector.redirect((short) 5, (Object) this, z16);
            }
            this.f242019g = z16;
            return this;
        }

        public a d(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (a) iPatchRedirector.redirect((short) 4, (Object) this, z16);
            }
            this.f242018f = z16;
            return this;
        }

        public a e(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (a) iPatchRedirector.redirect((short) 7, (Object) this, z16);
            }
            this.f242021i = z16;
            return this;
        }

        public a f(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (a) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            }
            this.f242020h = str;
            return this;
        }

        public a g(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            this.f242016d = str;
            return this;
        }
    }

    public bp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
