package com.tencent.gathererga.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a extends com.tencent.gathererga.core.internal.b {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private volatile Context f108326a;

        /* renamed from: b, reason: collision with root package name */
        private volatile String f108327b;

        /* renamed from: c, reason: collision with root package name */
        private volatile int f108328c;

        /* renamed from: d, reason: collision with root package name */
        private volatile String f108329d;

        /* renamed from: e, reason: collision with root package name */
        private volatile String f108330e;

        /* renamed from: f, reason: collision with root package name */
        private volatile com.tencent.gathererga.core.internal.component.c f108331f;

        /* renamed from: g, reason: collision with root package name */
        private volatile boolean f108332g;

        /* renamed from: h, reason: collision with root package name */
        private volatile com.tencent.gathererga.core.c f108333h;

        /* renamed from: i, reason: collision with root package name */
        private volatile com.tencent.gathererga.core.internal.component.cache.c f108334i;

        /* renamed from: j, reason: collision with root package name */
        private volatile com.tencent.gathererga.core.d f108335j;

        /* renamed from: k, reason: collision with root package name */
        private volatile ConcurrentHashMap<Integer, Object> f108336k;

        /* renamed from: l, reason: collision with root package name */
        private volatile ConcurrentHashMap<Integer, Boolean> f108337l;

        /* renamed from: m, reason: collision with root package name */
        private volatile ConcurrentHashMap<Integer, Boolean> f108338m;

        /* synthetic */ b(Context context, int i3, C1147a c1147a) {
            this(context, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
                return;
            }
            iPatchRedirector.redirect((short) 14, this, context, Integer.valueOf(i3), c1147a);
        }

        public final b n(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (b) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            }
            this.f108329d = str;
            return this;
        }

        public final b o(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (b) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            this.f108327b = str;
            return this;
        }

        public final a p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (a) iPatchRedirector.redirect((short) 13, (Object) this);
            }
            return new a(this, null);
        }

        public final b q(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (b) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            }
            if (!TextUtils.isEmpty(str)) {
                this.f108330e = str;
            }
            return this;
        }

        public final b r(com.tencent.gathererga.core.c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (b) iPatchRedirector.redirect((short) 10, (Object) this, (Object) cVar);
            }
            this.f108333h = cVar;
            return this;
        }

        public final b s(com.tencent.gathererga.core.internal.component.c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (b) iPatchRedirector.redirect((short) 8, (Object) this, (Object) cVar);
            }
            this.f108331f = cVar;
            return this;
        }

        public final b t(ConcurrentHashMap<Integer, Boolean> concurrentHashMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) concurrentHashMap);
            }
            this.f108337l = concurrentHashMap;
            return this;
        }

        public final b u(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (b) iPatchRedirector.redirect((short) 9, (Object) this, z16);
            }
            this.f108332g = z16;
            return this;
        }

        public final b v(com.tencent.gathererga.core.d dVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (b) iPatchRedirector.redirect((short) 12, (Object) this, (Object) dVar);
            }
            this.f108335j = dVar;
            return this;
        }

        public final b w(com.tencent.gathererga.core.internal.component.cache.c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (b) iPatchRedirector.redirect((short) 11, (Object) this, (Object) cVar);
            }
            this.f108334i = cVar;
            return this;
        }

        b(Context context, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, i3);
                return;
            }
            this.f108327b = "";
            this.f108330e = "Gatherer";
            this.f108332g = false;
            this.f108336k = new ConcurrentHashMap<>();
            this.f108337l = new ConcurrentHashMap<>();
            this.f108338m = new ConcurrentHashMap<>();
            this.f108326a = context.getApplicationContext();
            this.f108328c = i3;
        }
    }

    /* synthetic */ a(b bVar, C1147a c1147a) {
        this(bVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar, (Object) c1147a);
    }

    public static b n(Context context, int i3) {
        return new b(context, i3, null);
    }

    a(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
            return;
        }
        this.f108196a = bVar.f108326a;
        this.f108197b = bVar.f108327b;
        this.f108198c = bVar.f108337l;
        this.f108199d = bVar.f108338m;
        this.f108207l = bVar.f108336k;
        this.f108200e = bVar.f108328c;
        this.f108201f = bVar.f108329d;
        this.f108208m = bVar.f108330e;
        this.f108202g = bVar.f108331f;
        this.f108203h = bVar.f108332g;
        this.f108204i = bVar.f108333h;
        this.f108205j = bVar.f108334i;
        this.f108206k = bVar.f108335j;
    }
}
