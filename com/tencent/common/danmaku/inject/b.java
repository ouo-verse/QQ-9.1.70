package com.tencent.common.danmaku.inject;

import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import com.tencent.common.danmaku.data.ViewDanmaku;
import com.tencent.imsdk.BaseConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name */
    private static final String f99708m;

    /* renamed from: n, reason: collision with root package name */
    private static m f99709n;

    /* renamed from: o, reason: collision with root package name */
    private static com.tencent.common.danmaku.data.c f99710o;

    /* renamed from: a, reason: collision with root package name */
    private final com.tencent.common.danmaku.tool.d<Drawable> f99711a;

    /* renamed from: b, reason: collision with root package name */
    private final SparseArray<h> f99712b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f99713c;

    /* renamed from: d, reason: collision with root package name */
    private g f99714d;

    /* renamed from: e, reason: collision with root package name */
    private d f99715e;

    /* renamed from: f, reason: collision with root package name */
    private List<com.tencent.common.danmaku.render.a> f99716f;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.common.danmaku.render.d f99717g;

    /* renamed from: h, reason: collision with root package name */
    private k f99718h;

    /* renamed from: i, reason: collision with root package name */
    private int f99719i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f99720j;

    /* renamed from: k, reason: collision with root package name */
    private int f99721k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f99722l;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f99723a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f99724b;

        /* renamed from: c, reason: collision with root package name */
        private g f99725c;

        /* renamed from: d, reason: collision with root package name */
        private List<com.tencent.common.danmaku.render.a> f99726d;

        /* renamed from: e, reason: collision with root package name */
        public d f99727e;

        /* renamed from: f, reason: collision with root package name */
        private k f99728f;

        /* renamed from: g, reason: collision with root package name */
        private int f99729g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f99730h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f99731i;

        /* synthetic */ a(com.tencent.common.danmaku.inject.a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
                return;
            }
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) aVar);
        }

        static /* synthetic */ f d(a aVar) {
            aVar.getClass();
            return null;
        }

        static /* synthetic */ e e(a aVar) {
            aVar.getClass();
            return null;
        }

        static /* synthetic */ j f(a aVar) {
            aVar.getClass();
            return null;
        }

        static /* synthetic */ i g(a aVar) {
            aVar.getClass();
            return null;
        }

        static /* synthetic */ c h(a aVar) {
            aVar.getClass();
            return null;
        }

        public a l(com.tencent.common.danmaku.render.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (a) iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
            }
            this.f99726d.add(aVar);
            return this;
        }

        public b m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (b) iPatchRedirector.redirect((short) 18, (Object) this);
            }
            return new b(this, null);
        }

        public a n(d dVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (a) iPatchRedirector.redirect((short) 12, (Object) this, (Object) dVar);
            }
            this.f99727e = dVar;
            return this;
        }

        public a o(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (a) iPatchRedirector.redirect((short) 17, (Object) this, z16);
            }
            this.f99731i = z16;
            return this;
        }

        public a p(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this, z16);
            }
            this.f99724b = z16;
            return this;
        }

        public a q(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (a) iPatchRedirector.redirect((short) 16, (Object) this, i3);
            }
            this.f99723a = i3;
            return this;
        }

        public a r(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (a) iPatchRedirector.redirect((short) 8, (Object) this, i3);
            }
            this.f99729g = i3;
            return this;
        }

        public a s(g gVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) gVar);
            }
            this.f99725c = gVar;
            return this;
        }

        public a t(k kVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (a) iPatchRedirector.redirect((short) 15, (Object) this, (Object) kVar);
            }
            this.f99728f = kVar;
            return this;
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f99723a = 3;
            this.f99726d = new ArrayList();
            this.f99729g = -10;
            this.f99730h = false;
            this.f99731i = false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(BaseConstants.ERR_SDK_NET_DISCONNECT);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
        } else {
            f99708m = b.class.getSimpleName();
        }
    }

    /* synthetic */ b(a aVar, com.tencent.common.danmaku.inject.a aVar2) {
        this(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            return;
        }
        iPatchRedirector.redirect((short) 19, (Object) this, (Object) aVar, (Object) aVar2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ e a(b bVar) {
        bVar.getClass();
        return null;
    }

    private void b() {
        if (!this.f99713c && this.f99714d == null) {
            throw new IllegalArgumentException("Danmaku module need an IDanmakuPlayTimeSupplier or is live setter for computing timeline");
        }
    }

    public static com.tencent.common.danmaku.data.c k() {
        if (f99710o == null) {
            synchronized (b.class) {
                if (f99710o == null) {
                    f99710o = new com.tencent.common.danmaku.data.c();
                }
            }
        }
        return f99710o;
    }

    public static m p() {
        if (f99709n == null) {
            synchronized (b.class) {
                m mVar = f99709n;
            }
        }
        if (f99709n == null) {
            f99709n = new m();
        }
        return f99709n;
    }

    private void q(a aVar) {
        ArrayList arrayList = new ArrayList();
        this.f99716f = arrayList;
        arrayList.addAll(aVar.f99726d);
    }

    public static a s() {
        return new a(null);
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            this.f99711a.e(0);
        }
    }

    public com.tencent.common.danmaku.data.a d(int i3) {
        com.tencent.common.danmaku.data.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.common.danmaku.data.a) iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
        if (i3 == -2147483647) {
            return new ViewDanmaku(this);
        }
        d dVar = this.f99715e;
        if (dVar != null) {
            aVar = dVar.a(this, i3);
        } else {
            aVar = null;
        }
        if (aVar == null) {
            return new com.tencent.common.danmaku.data.b(this);
        }
        return aVar;
    }

    public com.tencent.common.danmaku.core.a e(b bVar, com.tencent.common.danmaku.core.b bVar2, Comparator<com.tencent.common.danmaku.data.a> comparator, com.tencent.common.danmaku.tool.f fVar, com.tencent.common.danmaku.tool.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (com.tencent.common.danmaku.core.a) iPatchRedirector.redirect((short) 16, this, bVar, bVar2, comparator, fVar, cVar);
        }
        k kVar = this.f99718h;
        if (kVar != null) {
            return kVar.a(bVar, bVar2, comparator, fVar, cVar);
        }
        return new com.tencent.common.danmaku.core.e(bVar, bVar2, comparator, fVar, cVar);
    }

    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return this.f99722l;
    }

    public com.tencent.common.danmaku.render.a g(com.tencent.common.danmaku.data.a aVar) {
        com.tencent.common.danmaku.render.a aVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.common.danmaku.render.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        }
        Iterator<com.tencent.common.danmaku.render.a> it = h().iterator();
        while (true) {
            if (it.hasNext()) {
                aVar2 = it.next();
                if (aVar2.a(aVar)) {
                    break;
                }
            } else {
                aVar2 = null;
                break;
            }
        }
        if (aVar2 == null) {
            return this.f99717g;
        }
        return aVar2;
    }

    public List<com.tencent.common.danmaku.render.a> h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (List) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.f99716f;
    }

    public h i(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (h) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        h hVar = this.f99712b.get(i3);
        if (hVar == null) {
            synchronized (b.class) {
                hVar = this.f99712b.get(i3);
            }
        }
        if (hVar == null) {
            return k();
        }
        return hVar;
    }

    public int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return (int) Math.ceil(com.tencent.common.danmaku.util.d.b(p()));
    }

    public int l(int i3, m mVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) mVar)).intValue();
        }
        return 0;
    }

    public int m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return this.f99721k;
    }

    public long n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, (Object) this)).longValue();
        }
        g gVar = this.f99714d;
        if (gVar == null) {
            return -1L;
        }
        return gVar.a();
    }

    public int o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.f99719i;
    }

    public boolean r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (!this.f99713c && n() >= 0) {
            return false;
        }
        return true;
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        }
    }

    public void u(com.tencent.common.danmaku.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) aVar);
        }
    }

    b(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            return;
        }
        this.f99712b = new SparseArray<>();
        this.f99713c = false;
        this.f99717g = new com.tencent.common.danmaku.render.d();
        this.f99722l = false;
        this.f99713c = aVar.f99724b;
        this.f99714d = aVar.f99725c;
        a.d(aVar);
        a.e(aVar);
        a.f(aVar);
        a.g(aVar);
        aVar.getClass();
        this.f99715e = aVar.f99727e;
        a.h(aVar);
        this.f99718h = aVar.f99728f;
        this.f99719i = aVar.f99729g;
        this.f99720j = aVar.f99730h;
        this.f99711a = new com.tencent.common.danmaku.tool.d<>();
        this.f99721k = aVar.f99723a;
        this.f99722l = aVar.f99731i;
        q(aVar);
        b();
    }
}
