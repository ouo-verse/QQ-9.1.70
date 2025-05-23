package com.tencent.turingface.sdk.mfa;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final URL f382515a;

    /* renamed from: b, reason: collision with root package name */
    public final String f382516b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<String, String> f382517c;

    /* renamed from: d, reason: collision with root package name */
    public final int f382518d;

    /* renamed from: e, reason: collision with root package name */
    public final int f382519e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f382520f;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final String f382521a;

        /* renamed from: b, reason: collision with root package name */
        public final URL f382522b;

        /* renamed from: c, reason: collision with root package name */
        public final HashMap<String, String> f382523c;

        /* renamed from: d, reason: collision with root package name */
        public int f382524d;

        /* renamed from: e, reason: collision with root package name */
        public int f382525e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f382526f;

        public a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
                return;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            this.f382523c = hashMap;
            this.f382524d = 10000;
            this.f382525e = 10000;
            this.f382526f = true;
            this.f382521a = str;
            this.f382522b = new URL(str);
            hashMap.put("Content-Type", "application/json; charset=utf-8");
        }
    }

    public i(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            String unused = aVar.f382521a;
            this.f382515a = aVar.f382522b;
            this.f382516b = "GET";
            this.f382517c = aVar.f382523c;
            this.f382518d = aVar.f382524d;
            this.f382519e = aVar.f382525e;
            this.f382520f = aVar.f382526f;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
    }
}
