package com.tencent.luggage.wxa.ii;

import com.tencent.luggage.wxa.hn.i0;
import com.tencent.luggage.wxa.hn.j0;
import com.tencent.luggage.wxa.hn.k1;
import com.tencent.luggage.wxa.hn.l6;
import com.tencent.luggage.wxa.hn.r8;
import com.tencent.luggage.wxa.hn.t2;
import com.tencent.luggage.wxa.hn.u2;
import com.tencent.luggage.wxa.ii.l;
import com.tencent.luggage.wxa.xo.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class j implements l {

    /* renamed from: a, reason: collision with root package name */
    public static final j f130505a = new j();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {

        /* renamed from: a, reason: collision with root package name */
        public static final C6313a f130506a = C6313a.f130507b;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.ii.j$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6313a implements a {

            /* renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ C6313a f130507b = new C6313a();

            /* renamed from: c, reason: collision with root package name */
            public static final AtomicBoolean f130508c = new AtomicBoolean(false);

            /* renamed from: d, reason: collision with root package name */
            public static boolean f130509d;

            public boolean a(boolean z16) {
                if (z16) {
                    return false;
                }
                if (!f130508c.getAndSet(true)) {
                    f130509d = y.f130598a.a();
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter", "after WxaEncryptPkgKeyInstaller.ensureKeyInstalled(), isEncryptPkgEnabled=" + f130509d);
                }
                return f130509d;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f130510a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Function1 function1) {
            super(1);
            this.f130510a = function1;
        }

        public final void a(u2[] items) {
            Intrinsics.checkNotNullParameter(items, "items");
            Function1 function1 = this.f130510a;
            j0 j0Var = new j0();
            for (u2 u2Var : items) {
                if (u2Var != null) {
                    j0Var.f127924e.add(u2Var);
                }
            }
            function1.invoke(j0Var);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((u2[]) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f130511b;

        public c(Function1 function1) {
            this.f130511b = function1;
        }

        public final void a(j0 resp) {
            Function1 function1 = this.f130511b;
            Intrinsics.checkNotNullExpressionValue(resp, "resp");
            function1.invoke(resp);
        }

        @Override // com.tencent.luggage.wxa.uo.b
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            a((j0) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f130512a;

        public d(Function1 function1) {
            this.f130512a = function1;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public final void a(Object obj) {
            String str;
            if (obj instanceof Throwable) {
                this.f130512a.invoke(obj);
                return;
            }
            Function1 function1 = this.f130512a;
            if (obj != null) {
                str = obj.toString();
            } else {
                str = null;
            }
            function1.invoke(new RuntimeException(str));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f130513b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ l.a f130514c;

        public e(Function1 function1, l.a aVar) {
            this.f130513b = function1;
            this.f130514c = aVar;
        }

        public final void a(j0 j0Var) {
            Function1 function1 = this.f130513b;
            u2[] a16 = com.tencent.luggage.wxa.ii.f.a(j0Var, this.f130514c);
            Intrinsics.checkNotNull(a16);
            function1.invoke(a16);
        }

        @Override // com.tencent.luggage.wxa.uo.b
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            a((j0) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f130515a;

        public f(Function1 function1) {
            this.f130515a = function1;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public final void a(Object obj) {
            String str;
            if (obj instanceof Throwable) {
                this.f130515a.invoke(obj);
                return;
            }
            Function1 function1 = this.f130515a;
            if (obj != null) {
                str = obj.toString();
            } else {
                str = null;
            }
            function1.invoke(new RuntimeException(str));
        }
    }

    public static final t2 b(l.a aVar) {
        t2 t2Var = new t2();
        t2Var.f128716d = f130505a.c(aVar);
        t2Var.f128718f = aVar.h();
        boolean z16 = true;
        if (aVar.f()) {
            t2Var.f128720h = true;
            t2Var.f128719g = aVar.b();
        } else {
            t2Var.f128719g = aVar.b();
        }
        String i3 = aVar.i();
        if (i3 != null && i3.length() != 0) {
            z16 = false;
        }
        if (!z16) {
            t2Var.f128723k = aVar.i();
        }
        com.tencent.luggage.wxa.ii.f.a(t2Var);
        return t2Var;
    }

    @Override // com.tencent.luggage.wxa.ii.l
    public void a(l.a request, Function1 onSuccess, Function1 onError, int i3, k1 cgiCommRequestSource) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(cgiCommRequestSource, "cgiCommRequestSource");
        i0 i0Var = new i0();
        i0Var.f127824e.addAll(f130505a.a(request));
        i0Var.f127825f = i3;
        i0Var.f127826g = cgiCommRequestSource;
        new com.tencent.luggage.wxa.ii.d().a(request.a(), i0Var, j0.class).c(new e(onSuccess, request)).a(new f(onError));
    }

    public final r8 c(l.a aVar) {
        boolean contains;
        boolean contains2;
        r8 r8Var = new r8();
        r8Var.f128593d = aVar.a();
        int g16 = aVar.g();
        int[] WEAPP_CODE_PKG_INTEGRATED_PACKAGE_TYPES = com.tencent.luggage.wxa.ip.a.f130735e;
        Intrinsics.checkNotNullExpressionValue(WEAPP_CODE_PKG_INTEGRATED_PACKAGE_TYPES, "WEAPP_CODE_PKG_INTEGRATED_PACKAGE_TYPES");
        contains = ArraysKt___ArraysKt.contains(WEAPP_CODE_PKG_INTEGRATED_PACKAGE_TYPES, g16);
        if (contains) {
            r8Var.f128595f = null;
        } else {
            int[] PLUGINCODE_PACKAGE_TYPES = com.tencent.luggage.wxa.ip.a.f130734d;
            Intrinsics.checkNotNullExpressionValue(PLUGINCODE_PACKAGE_TYPES, "PLUGINCODE_PACKAGE_TYPES");
            contains2 = ArraysKt___ArraysKt.contains(PLUGINCODE_PACKAGE_TYPES, g16);
            if (contains2) {
                r8Var.f128595f = null;
            } else {
                r8Var.f128595f = aVar.e();
            }
        }
        r8Var.f128596g = aVar.g();
        r8Var.f128597h = aVar.j();
        return r8Var;
    }

    public final void a(List inRequestList, Function1 onSuccess, Function1 onError, int i3, k1 cgiCommRequestSource) {
        Object first;
        Object first2;
        Intrinsics.checkNotNullParameter(inRequestList, "inRequestList");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(cgiCommRequestSource, "cgiCommRequestSource");
        if (inRequestList.size() == 1) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("waitForBatchGetDownloadUrl, use single routine instead, with ");
            first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) inRequestList);
            sb5.append(first2);
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", sb5.toString());
            a((l.a) inRequestList.get(0), new b(onSuccess), onError, i3, cgiCommRequestSource);
            return;
        }
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList(inRequestList);
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "waitForBatchGetDownloadUrl, inRequestList.size=" + inRequestList.size() + ", realRequestList.size=" + linkedList2.size() + ", preGetRespItemList.size=" + linkedList.size());
        if (linkedList2.size() <= 0) {
            j0 j0Var = new j0();
            j0Var.f127924e.addAll(linkedList);
            onSuccess.invoke(j0Var);
            return;
        }
        i0 i0Var = new i0();
        Iterator it = linkedList2.iterator();
        while (it.hasNext()) {
            i0Var.f127824e.addAll(f130505a.a((l.a) it.next()));
            i0Var.f127825f = i3;
            i0Var.f127826g = cgiCommRequestSource;
        }
        com.tencent.luggage.wxa.ii.d dVar = new com.tencent.luggage.wxa.ii.d();
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) inRequestList);
        dVar.a(((l.a) first).a(), i0Var, j0.class).c(new c(onSuccess)).a(new d(onError));
    }

    public final List a(l.a aVar) {
        LinkedList linkedList = new LinkedList();
        t2 b16 = b(aVar);
        b16.f128717e = null;
        b16.f128721i = false;
        linkedList.add(b16);
        t2 b17 = b(aVar);
        b17.f128717e = null;
        b17.f128721i = true;
        linkedList.add(b17);
        if (aVar.d() > 0) {
            t2 b18 = b(aVar);
            l6 l6Var = new l6();
            b18.f128717e = l6Var;
            l6Var.f128066d = aVar.d();
            b18.f128717e.f128067e = aVar.c();
            b18.f128721i = false;
            linkedList.add(b18);
        }
        return linkedList;
    }
}
