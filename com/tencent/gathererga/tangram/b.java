package com.tencent.gathererga.tangram;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f108342a;

    /* renamed from: b, reason: collision with root package name */
    private String f108343b;

    /* renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<Integer, c> f108344c;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.gathererga.core.c f108345d;

    /* renamed from: e, reason: collision with root package name */
    private String f108346e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f108347f;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.gathererga.core.d f108348g;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.gathererga.core.internal.component.c f108349h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.gathererga.sdk.b f108350i;

    /* renamed from: j, reason: collision with root package name */
    private com.tencent.gathererga.tangram.a f108351j;

    /* compiled from: P */
    /* renamed from: com.tencent.gathererga.tangram.b$b, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1148b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private String f108352a;

        /* renamed from: b, reason: collision with root package name */
        private String f108353b;

        /* renamed from: c, reason: collision with root package name */
        private ConcurrentHashMap<Integer, c> f108354c;

        /* renamed from: d, reason: collision with root package name */
        private com.tencent.gathererga.core.c f108355d;

        /* renamed from: e, reason: collision with root package name */
        private String f108356e;

        /* renamed from: f, reason: collision with root package name */
        private com.tencent.gathererga.core.d f108357f;

        /* renamed from: g, reason: collision with root package name */
        private com.tencent.gathererga.core.internal.component.c f108358g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f108359h;

        /* renamed from: i, reason: collision with root package name */
        private com.tencent.gathererga.sdk.b f108360i;

        /* renamed from: j, reason: collision with root package name */
        private com.tencent.gathererga.tangram.a f108361j;

        public C1148b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f108356e = "Gatherer";
                this.f108359h = true;
            }
        }

        public final b k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (b) iPatchRedirector.redirect((short) 12, (Object) this);
            }
            return new b(this, null);
        }

        public final C1148b l(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (C1148b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            this.f108353b = str;
            return this;
        }

        public final C1148b m(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (C1148b) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            this.f108352a = str;
            return this;
        }

        public final C1148b n(com.tencent.gathererga.core.c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (C1148b) iPatchRedirector.redirect((short) 5, (Object) this, (Object) cVar);
            }
            this.f108355d = cVar;
            return this;
        }

        public final C1148b o(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (C1148b) iPatchRedirector.redirect((short) 7, (Object) this, z16);
            }
            this.f108359h = z16;
            return this;
        }

        public final C1148b p(com.tencent.gathererga.core.d dVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (C1148b) iPatchRedirector.redirect((short) 8, (Object) this, (Object) dVar);
            }
            this.f108357f = dVar;
            return this;
        }

        public final C1148b q(com.tencent.gathererga.sdk.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (C1148b) iPatchRedirector.redirect((short) 10, (Object) this, (Object) bVar);
            }
            this.f108360i = bVar;
            return this;
        }

        public final C1148b r(ConcurrentHashMap<Integer, c> concurrentHashMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (C1148b) iPatchRedirector.redirect((short) 4, (Object) this, (Object) concurrentHashMap);
            }
            this.f108354c = concurrentHashMap;
            return this;
        }
    }

    /* synthetic */ b(C1148b c1148b, a aVar) {
        this(c1148b);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            return;
        }
        iPatchRedirector.redirect((short) 12, (Object) this, (Object) c1148b, (Object) aVar);
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f108343b;
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f108342a;
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f108346e;
    }

    public com.tencent.gathererga.core.c d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.gathererga.core.c) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f108345d;
    }

    public com.tencent.gathererga.core.internal.component.c e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.gathererga.core.internal.component.c) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f108349h;
    }

    public ConcurrentHashMap<Integer, c> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f108344c;
    }

    public com.tencent.gathererga.core.d g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.gathererga.core.d) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f108348g;
    }

    public com.tencent.gathererga.tangram.a h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (com.tencent.gathererga.tangram.a) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.f108351j;
    }

    public boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.f108347f;
    }

    public com.tencent.gathererga.sdk.b j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (com.tencent.gathererga.sdk.b) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.f108350i;
    }

    b(C1148b c1148b) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) c1148b);
            return;
        }
        this.f108342a = c1148b.f108352a;
        this.f108343b = c1148b.f108353b;
        this.f108344c = c1148b.f108354c;
        this.f108345d = c1148b.f108355d;
        this.f108346e = c1148b.f108356e;
        this.f108347f = c1148b.f108359h;
        this.f108348g = c1148b.f108357f;
        this.f108349h = c1148b.f108358g;
        this.f108350i = c1148b.f108360i;
        this.f108351j = c1148b.f108361j;
    }
}
