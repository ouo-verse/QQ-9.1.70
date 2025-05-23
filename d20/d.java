package d20;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes38.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, i> f392675a;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class a implements i {
        a() {
        }

        @Override // d20.d.i
        public d20.a a() {
            return new d20.e();
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class b implements i {
        b() {
        }

        @Override // d20.d.i
        public d20.a a() {
            return new d20.c();
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class c implements i {
        c() {
        }

        @Override // d20.d.i
        public d20.a a() {
            return new d20.h();
        }
    }

    /* compiled from: P */
    /* renamed from: d20.d$d, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    class C10154d implements i {
        C10154d() {
        }

        @Override // d20.d.i
        public d20.a a() {
            return new d20.i();
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class e implements i {
        e() {
        }

        @Override // d20.d.i
        public d20.a a() {
            return new j();
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class f implements i {
        f() {
        }

        @Override // d20.d.i
        public d20.a a() {
            return new d20.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class g implements i {
        g() {
        }

        @Override // d20.d.i
        public d20.a a() {
            return new d20.f();
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class h implements i {
        h() {
        }

        @Override // d20.d.i
        public d20.a a() {
            return new d20.g();
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    private interface i {
        d20.a a();
    }

    static {
        HashMap hashMap = new HashMap();
        f392675a = hashMap;
        hashMap.put("operationh5", new a());
        hashMap.put("waterfall", new b());
        hashMap.put("openPlayer", new c());
        hashMap.put("videoCollection", new C10154d());
        hashMap.put("videoDrama", new e());
        hashMap.put("dramaGround", new f());
        hashMap.put("profile", new g());
        hashMap.put("setting", new h());
    }

    public static d20.a a(String str) {
        i iVar = f392675a.get(str);
        if (iVar != null) {
            return iVar.a();
        }
        return null;
    }
}
