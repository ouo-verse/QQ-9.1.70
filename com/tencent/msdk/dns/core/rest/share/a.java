package com.tencent.msdk.dns.core.rest.share;

import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.msdk.dns.core.i;
import com.tencent.msdk.dns.core.n;
import com.tencent.msdk.dns.core.o;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes21.dex */
public abstract class a implements i<g> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected final d f336317a;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public abstract class b implements i.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        protected int f336327a;

        /* renamed from: b, reason: collision with root package name */
        protected n<g> f336328b;

        /* renamed from: c, reason: collision with root package name */
        protected final i f336329c;

        /* renamed from: d, reason: collision with root package name */
        protected SelectionKey f336330d;

        /* renamed from: e, reason: collision with root package name */
        protected final C9218a f336331e;

        /* renamed from: f, reason: collision with root package name */
        private final b f336332f;

        /* renamed from: g, reason: collision with root package name */
        private List<b> f336333g;

        /* compiled from: P */
        /* renamed from: com.tencent.msdk.dns.core.rest.share.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes21.dex */
        public class C9219a implements i.b.a {
            static IPatchRedirector $redirector_;

            public C9219a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                }
            }

            @Override // com.tencent.msdk.dns.core.i.b.a
            public boolean a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
                }
                b bVar = b.this;
                SelectionKey selectionKey = bVar.f336330d;
                if (selectionKey == null) {
                    if (bVar.f336327a != 0) {
                        return false;
                    }
                    return true;
                }
                if (selectionKey.isValid()) {
                    return true;
                }
                b.this.d();
                return false;
            }

            @Override // com.tencent.msdk.dns.core.i.b.a
            public boolean b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
                }
                b bVar = b.this;
                SelectionKey selectionKey = bVar.f336330d;
                if (selectionKey == null) {
                    if (2 == bVar.f336327a) {
                        return true;
                    }
                    return false;
                }
                if (!selectionKey.isValid()) {
                    b.this.d();
                    return false;
                }
                b bVar2 = b.this;
                if (2 == bVar2.f336327a && bVar2.f336330d.isWritable()) {
                    return true;
                }
                return false;
            }

            @Override // com.tencent.msdk.dns.core.i.b.a
            public boolean c() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
                }
                b bVar = b.this;
                SelectionKey selectionKey = bVar.f336330d;
                if (selectionKey == null) {
                    if (3 == bVar.f336327a) {
                        return true;
                    }
                    return false;
                }
                if (!selectionKey.isValid()) {
                    b.this.d();
                    return false;
                }
                b bVar2 = b.this;
                if (3 == bVar2.f336327a && bVar2.f336330d.isReadable()) {
                    return true;
                }
                return false;
            }

            @Override // com.tencent.msdk.dns.core.i.b.a
            public boolean d() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                b bVar = b.this;
                SelectionKey selectionKey = bVar.f336330d;
                if (selectionKey == null) {
                    if (1 != bVar.f336327a) {
                        return false;
                    }
                    return true;
                }
                if (!selectionKey.isValid()) {
                    b.this.d();
                    return false;
                }
                b bVar2 = b.this;
                if (1 != bVar2.f336327a || !bVar2.f336330d.isConnectable()) {
                    return false;
                }
                return true;
            }
        }

        public b(n<g> nVar, i iVar, b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, nVar, iVar, bVar);
                return;
            }
            this.f336327a = 0;
            this.f336330d = null;
            C9218a c9218a = new C9218a();
            this.f336331e = c9218a;
            this.f336333g = Collections.emptyList();
            if (nVar != null) {
                if (iVar != null) {
                    c9218a.h();
                    c9218a.f336323i = nVar.o();
                    c9218a.f336325k = nVar.s();
                    c9218a.f336326l = nVar.x();
                    this.f336328b = nVar;
                    this.f336329c = iVar;
                    this.f336332f = bVar;
                    if (!nVar.s() && a.this.f336317a.a(nVar.u()) != null) {
                        this.f336327a = 3;
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("dns".concat(" can not be null"));
            }
            throw new IllegalArgumentException("lookupContext".concat(" can not be null"));
        }

        private void o() {
            if (4 != this.f336327a) {
                return;
            }
            b bVar = this.f336332f;
            if (bVar != null) {
                bVar.d();
            }
            Iterator<b> it = this.f336333g.iterator();
            while (it.hasNext()) {
                it.next().d();
            }
        }

        @Override // com.tencent.msdk.dns.core.i.b
        public final String[] b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String[]) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            if (3 != this.f336327a) {
                com.tencent.msdk.dns.base.log.c.c("HttpDns(%d) mState is not readable", Integer.valueOf(this.f336329c.a().f336255b));
                return this.f336331e.f336376a;
            }
            com.tencent.msdk.dns.core.rest.share.h.a aVar = com.tencent.msdk.dns.core.rest.share.h.a.f336369d;
            try {
                if (a.this.d(this.f336328b.l(), this.f336331e)) {
                    String[] strArr = this.f336331e.f336376a;
                    if (aVar != com.tencent.msdk.dns.core.rest.share.h.a.f336370e) {
                        d();
                        o();
                    }
                    return strArr;
                }
                com.tencent.msdk.dns.core.rest.share.h.a n3 = n();
                if (n3 != aVar) {
                    try {
                        if (n3 != com.tencent.msdk.dns.core.rest.share.h.a.f336370e) {
                            this.f336331e.f336319e = 0;
                            a.this.f336317a.d(this.f336328b.l(), n3);
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        aVar = n3;
                        if (aVar != com.tencent.msdk.dns.core.rest.share.h.a.f336370e) {
                            d();
                            o();
                        }
                        throw th;
                    }
                }
                C9218a c9218a = this.f336331e;
                c9218a.f336321g = n3.f336371a;
                c9218a.f336322h = n3.f336373c;
                c9218a.f336376a = n3.f336372b;
                if (n3 != com.tencent.msdk.dns.core.rest.share.h.a.f336370e) {
                    d();
                    o();
                }
                return this.f336331e.f336376a;
            } catch (Throwable th6) {
                th = th6;
            }
        }

        @Override // com.tencent.msdk.dns.core.i.b
        public final boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
            }
            if (4 == this.f336327a) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.msdk.dns.core.i.b
        public final void d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            } else {
                if (4 == this.f336327a) {
                    return;
                }
                this.f336327a = 4;
                this.f336331e.g();
                l();
            }
        }

        @Override // com.tencent.msdk.dns.core.i.b
        public void e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (1 != this.f336327a) {
                return;
            }
            try {
                if (j() != 2) {
                }
            } finally {
                if (4 != this.f336327a) {
                    this.f336327a = 2;
                }
            }
        }

        @Override // com.tencent.msdk.dns.core.i.b
        public i.c f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (i.c) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return this.f336331e;
        }

        @Override // com.tencent.msdk.dns.core.i.b
        public final i g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (i) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.f336329c;
        }

        @Override // com.tencent.msdk.dns.core.i.b
        public final void h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (2 != this.f336327a) {
                return;
            }
            try {
                if (m() != 2) {
                }
            } finally {
                if (4 != this.f336327a) {
                    this.f336327a = 3;
                }
            }
        }

        @Override // com.tencent.msdk.dns.core.i.b
        public final i.b i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (i.b) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            b k3 = k();
            if (Collections.emptyList() == this.f336333g) {
                this.f336333g = new ArrayList();
            }
            this.f336333g.add(k3);
            return k3;
        }

        protected abstract int j();

        protected abstract b k();

        protected abstract void l();

        protected abstract int m();

        protected abstract com.tencent.msdk.dns.core.rest.share.h.a n();
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f336317a = new d(this, new com.tencent.msdk.dns.core.m.a());
        }
    }

    @Override // com.tencent.msdk.dns.core.i
    public com.tencent.msdk.dns.core.d c(o<g> oVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.msdk.dns.core.d) iPatchRedirector.redirect((short) 3, (Object) this, (Object) oVar);
        }
        C9218a c9218a = new C9218a();
        c9218a.f336323i = oVar.f336297l;
        c9218a.f336325k = oVar.f336296k;
        c9218a.f336326l = oVar.f336298m;
        c9218a.h();
        d(oVar, c9218a);
        c9218a.g();
        return new com.tencent.msdk.dns.core.d(c9218a.f336376a, c9218a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean d(o<g> oVar, C9218a c9218a) {
        String str;
        com.tencent.msdk.dns.core.d a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) oVar, (Object) c9218a)).booleanValue();
        }
        if (oVar != null) {
            if (c9218a != null) {
                if (!oVar.f336296k && (a16 = this.f336317a.a((str = oVar.f336287b))) != null) {
                    String[] strArr = a16.f336251a.f336250c;
                    if (!com.tencent.msdk.dns.c.e.a.i(strArr)) {
                        C9218a c9218a2 = (C9218a) a16.f336252b;
                        c9218a.f336319e = 0;
                        c9218a.f336321g = c9218a2.f336321g;
                        c9218a.f336322h = c9218a2.f336322h;
                        c9218a.f336376a = strArr;
                        c9218a.f336324j = true;
                        com.tencent.msdk.dns.base.log.c.c("Lookup for %s, cache hit", str);
                        return true;
                    }
                }
                return false;
            }
            throw new IllegalArgumentException("stat".concat(" can not be null"));
        }
        throw new IllegalArgumentException("lookupParams".concat(" can not be empty"));
    }

    /* compiled from: P */
    /* renamed from: com.tencent.msdk.dns.core.rest.share.a$a, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static class C9218a extends com.tencent.msdk.dns.core.stat.a {
        static IPatchRedirector $redirector_;

        /* renamed from: m, reason: collision with root package name */
        public static final C9218a f336318m;

        /* renamed from: e, reason: collision with root package name */
        public int f336319e;

        /* renamed from: f, reason: collision with root package name */
        public String f336320f;

        /* renamed from: g, reason: collision with root package name */
        public String f336321g;

        /* renamed from: h, reason: collision with root package name */
        public int f336322h;

        /* renamed from: i, reason: collision with root package name */
        public int f336323i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f336324j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f336325k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f336326l;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18053);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
                return;
            }
            C9218a c9218a = new C9218a();
            f336318m = c9218a;
            c9218a.f336319e = 1;
        }

        public C9218a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f336319e = 2;
            this.f336320f = " ";
            this.f336321g = "0";
            this.f336322h = 0;
            this.f336323i = 0;
            this.f336324j = false;
            this.f336325k = false;
            this.f336326l = false;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return "Statistics{errorCode=" + this.f336319e + ", errorMsg='" + this.f336320f + "', clientIp='" + this.f336321g + "', ttl=" + this.f336322h + ", retryTimes=" + this.f336323i + ", cached=" + this.f336324j + ", asyncLookup=" + this.f336325k + ", netChangeLookup=" + this.f336326l + ", ips=" + Arrays.toString(this.f336376a) + ", costTimeMills=" + this.f336378c + ", startLookupTimeMills=" + this.f336379d + '}';
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C9218a(String[] strArr, String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, strArr, str, Integer.valueOf(i3));
                return;
            }
            this.f336319e = 2;
            this.f336320f = " ";
            this.f336321g = "0";
            this.f336322h = 0;
            this.f336323i = 0;
            this.f336324j = false;
            this.f336325k = false;
            this.f336326l = false;
            if (strArr != null) {
                if (!TextUtils.isEmpty(str)) {
                    if (!com.tencent.msdk.dns.core.rest.share.h.a.a(i3)) {
                        this.f336376a = strArr;
                        this.f336321g = str;
                        this.f336322h = i3;
                        return;
                    }
                    throw new IllegalArgumentException(RemoteMessageConst.TTL.concat(" is invalid"));
                }
                throw new IllegalArgumentException(ImageTaskConst.CLIENT_IP.concat(" can not be empty"));
            }
            throw new IllegalArgumentException("ips".concat(" can not be null"));
        }
    }
}
