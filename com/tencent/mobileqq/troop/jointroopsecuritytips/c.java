package com.tencent.mobileqq.troop.jointroopsecuritytips;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    int f297554a;

    /* renamed from: b, reason: collision with root package name */
    String f297555b;

    /* renamed from: c, reason: collision with root package name */
    String f297556c;

    /* renamed from: d, reason: collision with root package name */
    List<a> f297557d;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        String f297558a;

        /* renamed from: b, reason: collision with root package name */
        String f297559b;

        /* renamed from: c, reason: collision with root package name */
        String f297560c;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
                return;
            }
            this.f297558a = "";
            this.f297559b = "";
            this.f297560c = "";
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f297557d = null;
        this.f297554a = 0;
        this.f297555b = "";
        this.f297556c = "";
        this.f297557d = new ArrayList();
    }
}
