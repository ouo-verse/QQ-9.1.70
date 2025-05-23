package com.tencent.mobileqq.upgrade;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes20.dex */
public class NewUpgradeConfig implements Serializable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static NewUpgradeConfig f306148d;
    public a dialog;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f306149a;

        /* renamed from: b, reason: collision with root package name */
        public String f306150b;

        /* renamed from: c, reason: collision with root package name */
        public long f306151c;

        /* renamed from: d, reason: collision with root package name */
        public long f306152d;

        /* renamed from: e, reason: collision with root package name */
        public String f306153e;

        /* renamed from: f, reason: collision with root package name */
        public String f306154f;

        /* renamed from: g, reason: collision with root package name */
        public String f306155g;

        /* renamed from: h, reason: collision with root package name */
        public String f306156h;

        /* renamed from: i, reason: collision with root package name */
        public String f306157i;

        /* renamed from: j, reason: collision with root package name */
        public String f306158j;

        /* renamed from: k, reason: collision with root package name */
        public int f306159k;

        /* renamed from: l, reason: collision with root package name */
        public String f306160l;

        /* renamed from: m, reason: collision with root package name */
        public String f306161m;

        /* renamed from: n, reason: collision with root package name */
        public String f306162n;

        /* renamed from: o, reason: collision with root package name */
        public String f306163o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f306164p;

        /* renamed from: q, reason: collision with root package name */
        public int f306165q;

        /* renamed from: r, reason: collision with root package name */
        public int f306166r;

        /* renamed from: s, reason: collision with root package name */
        public int f306167s;

        /* renamed from: t, reason: collision with root package name */
        public int f306168t;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f306164p = false;
            this.f306165q = 0;
            this.f306166r = 0;
            this.f306167s = 0;
            this.f306168t = 0;
        }
    }

    NewUpgradeConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static synchronized NewUpgradeConfig getInstance() {
        NewUpgradeConfig newUpgradeConfig;
        synchronized (NewUpgradeConfig.class) {
            if (f306148d == null) {
                NewUpgradeConfig newUpgradeConfig2 = new NewUpgradeConfig();
                f306148d = newUpgradeConfig2;
                newUpgradeConfig2.prepareDialog();
            }
            newUpgradeConfig = f306148d;
        }
        return newUpgradeConfig;
    }

    public void prepareDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.dialog = new a();
        }
    }
}
