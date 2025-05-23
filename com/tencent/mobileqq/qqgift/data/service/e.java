package com.tencent.mobileqq.qqgift.data.service;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f264894a;

    /* renamed from: b, reason: collision with root package name */
    public String f264895b;

    /* renamed from: c, reason: collision with root package name */
    public String f264896c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f264897d;

    /* renamed from: e, reason: collision with root package name */
    public List<d> f264898e;

    /* renamed from: f, reason: collision with root package name */
    public a f264899f;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f264900a;

        /* renamed from: b, reason: collision with root package name */
        public String f264901b;

        /* renamed from: c, reason: collision with root package name */
        public String f264902c;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f264900a = "";
            this.f264901b = "";
            this.f264902c = "";
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "EmptyInfo{msg='" + this.f264900a + "', button='" + this.f264901b + "', url='" + this.f264902c + "'}";
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f264894a = "";
        this.f264895b = "";
        this.f264896c = "";
        this.f264898e = new ArrayList();
        this.f264899f = null;
    }
}
