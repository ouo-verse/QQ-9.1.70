package com.tencent.biz.pubaccount.weishi.main;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, f> f80926a = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements f {
        a() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.main.d.f
        public com.tencent.biz.pubaccount.weishi.main.b a(com.tencent.biz.pubaccount.weishi.main.c cVar) {
            return new WSMainHomePresenter(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements f {
        b() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.main.d.f
        public com.tencent.biz.pubaccount.weishi.main.b a(com.tencent.biz.pubaccount.weishi.main.c cVar) {
            return new WSMainProfilePresenter(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements f {
        c() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.main.d.f
        public com.tencent.biz.pubaccount.weishi.main.b a(com.tencent.biz.pubaccount.weishi.main.c cVar) {
            return new WSMainProfilePresenter(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.pubaccount.weishi.main.d$d, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public class C0827d implements f {
        C0827d() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.main.d.f
        public com.tencent.biz.pubaccount.weishi.main.b a(com.tencent.biz.pubaccount.weishi.main.c cVar) {
            return new WSMainProfilePresenter(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class e implements f {
        e() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.main.d.f
        public com.tencent.biz.pubaccount.weishi.main.b a(com.tencent.biz.pubaccount.weishi.main.c cVar) {
            return new WSMainProfilePresenter(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface f {
        com.tencent.biz.pubaccount.weishi.main.b a(com.tencent.biz.pubaccount.weishi.main.c cVar);
    }

    static {
        a();
        c();
        b();
        d();
        e();
    }

    private static void a() {
        f80926a.put("home", new a());
    }

    private static void b() {
        f80926a.put("personal_guest", new c());
    }

    private static void c() {
        f80926a.put("personal_main", new b());
    }

    private static void d() {
        f80926a.put("mini_app_personal_guest", new e());
    }

    private static void e() {
        f80926a.put("mini_app_personal_main", new C0827d());
    }

    public static com.tencent.biz.pubaccount.weishi.main.b f(String str, com.tencent.biz.pubaccount.weishi.main.c cVar) {
        f fVar = f80926a.get(str);
        if (fVar == null) {
            return new WSMainVerticalPresenter(cVar);
        }
        return fVar.a(cVar);
    }
}
