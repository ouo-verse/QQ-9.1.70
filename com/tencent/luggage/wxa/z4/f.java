package com.tencent.luggage.wxa.z4;

import android.content.Context;
import android.content.Intent;
import android.util.ArraySet;
import android.util.Log;
import com.tencent.luggage.wxa.ic.u;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class f {

    /* renamed from: b */
    public static final a f146283b = new a(null);

    /* renamed from: c */
    public static final byte[] f146284c = new byte[0];

    /* renamed from: d */
    public static final com.tencent.luggage.wxa.e5.k f146285d;

    /* renamed from: e */
    public static final com.tencent.luggage.wxa.e5.j f146286e;

    /* renamed from: f */
    public static f f146287f;

    /* renamed from: a */
    public final Lazy f146288a;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {

        /* renamed from: a */
        public static final /* synthetic */ KProperty[] f146289a = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "banInvokePrivacyAPI", "getBanInvokePrivacyAPI()Z", 0))};

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.z4.f$a$a */
        /* loaded from: classes9.dex */
        public static final class C6971a implements com.tencent.luggage.wxa.jq.g, com.tencent.luggage.wxa.jq.e {
            @Override // com.tencent.luggage.wxa.jq.e
            public boolean a() {
                return false;
            }

            @Override // com.tencent.luggage.wxa.jq.g, com.tencent.luggage.wxa.jq.f
            public String getKey() {
                return "";
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = f.f146287f;
                if (fVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("INSTANCE_");
                    fVar = null;
                }
                Iterator it = fVar.g().iterator();
                while (it.hasNext()) {
                    ((com.tencent.luggage.wxa.z4.e) it.next()).h();
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static final class b implements com.tencent.luggage.wxa.jq.g, com.tencent.luggage.wxa.jq.e {
            @Override // com.tencent.luggage.wxa.jq.e
            public boolean a() {
                return false;
            }

            @Override // com.tencent.luggage.wxa.jq.g, com.tencent.luggage.wxa.jq.f
            public String getKey() {
                return "";
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = f.f146287f;
                if (fVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("INSTANCE_");
                    fVar = null;
                }
                Iterator it = fVar.g().iterator();
                while (it.hasNext()) {
                    ((com.tencent.luggage.wxa.z4.e) it.next()).h();
                }
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(boolean z16) {
            f.f146286e.a(this, f146289a[0], Boolean.valueOf(z16));
        }

        public final boolean b() {
            return ((Boolean) f.f146286e.a(this, f146289a[0])).booleanValue();
        }

        public final byte[] c() {
            return f.f146284c;
        }

        public final void d() {
            if (b()) {
                return;
            }
            com.tencent.luggage.wxa.zp.h.f146825d.execute(new C6971a());
        }

        public final f a() {
            f fVar;
            if (com.tencent.luggage.wxa.eo.g.b(u.class)) {
                ((u) com.tencent.luggage.wxa.eo.g.a(u.class)).J();
            }
            synchronized (c()) {
                fVar = f.f146287f;
                if (fVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("INSTANCE_");
                    fVar = null;
                }
            }
            return fVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0052  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void b(f _instance) {
            f fVar;
            Intrinsics.checkNotNullParameter(_instance, "_instance");
            if (z.m()) {
                if (f.f146287f != null) {
                    fVar = f.f146287f;
                    if (fVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("INSTANCE_");
                    }
                    Object[] objArr = new Object[3];
                    objArr[0] = fVar != null ? Integer.valueOf(fVar.hashCode()) : null;
                    objArr[1] = Integer.valueOf(_instance.hashCode());
                    objArr[2] = Log.getStackTraceString(new Throwable());
                    w.a("Luggage.LuggageMiniProgramProcessManager", "reInject: old %s new %s stack %s", objArr);
                    if (fVar != null) {
                        fVar.a(com.tencent.luggage.wxa.z4.c.KILL_PROCESS_DIRECTLY);
                    }
                    f.f146287f = _instance;
                    d();
                    return;
                }
                fVar = null;
                Object[] objArr2 = new Object[3];
                objArr2[0] = fVar != null ? Integer.valueOf(fVar.hashCode()) : null;
                objArr2[1] = Integer.valueOf(_instance.hashCode());
                objArr2[2] = Log.getStackTraceString(new Throwable());
                w.a("Luggage.LuggageMiniProgramProcessManager", "reInject: old %s new %s stack %s", objArr2);
                if (fVar != null) {
                }
                f.f146287f = _instance;
                d();
                return;
            }
            throw new IllegalAccessError("ProcessManager can only used by main process");
        }

        public final void a(f _instance) {
            Intrinsics.checkNotNullParameter(_instance, "_instance");
            if (z.m()) {
                if (f.f146287f == null) {
                    f.f146287f = _instance;
                    com.tencent.luggage.wxa.zp.h.f146825d.c(new b());
                    return;
                }
                return;
            }
            throw new IllegalAccessError("ProcessManager can only used by main process");
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b extends Lambda implements Function0 {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final CopyOnWriteArrayList invoke() {
            return new CopyOnWriteArrayList(f.this.h());
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class c extends Lambda implements Function1 {
        public c() {
            super(1);
        }

        public final void a(com.tencent.luggage.wxa.z4.g record) {
            Intrinsics.checkNotNullParameter(record, "record");
            f.this.c(record);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.z4.g) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class d extends Lambda implements Function1 {

        /* renamed from: a */
        public final /* synthetic */ ArrayList f146292a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ArrayList arrayList) {
            super(1);
            this.f146292a = arrayList;
        }

        public final void a(com.tencent.luggage.wxa.z4.g it) {
            Intrinsics.checkNotNullParameter(it, "it");
            this.f146292a.add(it);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.z4.g) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class e implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((com.tencent.luggage.wxa.z4.g) obj2).e()), Long.valueOf(((com.tencent.luggage.wxa.z4.g) obj).e()));
            return compareValues;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.z4.f$f */
    /* loaded from: classes9.dex */
    public static final class C6972f extends Lambda implements Function0 {

        /* renamed from: b */
        public final /* synthetic */ String f146294b;

        /* renamed from: c */
        public final /* synthetic */ j f146295c;

        /* renamed from: d */
        public final /* synthetic */ com.tencent.luggage.wxa.z4.i f146296d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C6972f(String str, j jVar, com.tencent.luggage.wxa.z4.i iVar) {
            super(0);
            this.f146294b = str;
            this.f146295c = jVar;
            this.f146296d = iVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final Pair invoke() {
            return new Pair(k.CREATE_NEW, f.this.a(this.f146294b, this.f146295c, this.f146296d));
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class g extends Lambda implements Function1 {

        /* renamed from: b */
        public final /* synthetic */ boolean f146298b;

        /* renamed from: c */
        public final /* synthetic */ int f146299c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(boolean z16, int i3) {
            super(1);
            this.f146298b = z16;
            this.f146299c = i3;
        }

        public final void a(com.tencent.luggage.wxa.z4.g record) {
            Intrinsics.checkNotNullParameter(record, "record");
            f.this.a(record, this.f146298b, this.f146299c);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.z4.g) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class h extends Lambda implements Function1 {

        /* renamed from: a */
        public final /* synthetic */ com.tencent.luggage.wxa.z4.e f146300a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(com.tencent.luggage.wxa.z4.e eVar) {
            super(1);
            this.f146300a = eVar;
        }

        public final void a(com.tencent.luggage.wxa.z4.g record) {
            Intrinsics.checkNotNullParameter(record, "record");
            this.f146300a.a(record);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.z4.g) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class i extends Lambda implements Function1 {

        /* renamed from: a */
        public static final i f146301a = new i();

        public i() {
            super(1);
        }

        public final void a(com.tencent.luggage.wxa.z4.g record) {
            Intrinsics.checkNotNullParameter(record, "record");
            if (record.f()) {
                record.a(false);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.z4.g) obj);
            return Unit.INSTANCE;
        }
    }

    static {
        com.tencent.luggage.wxa.e5.k kVar = new com.tencent.luggage.wxa.e5.k("Luggage.MiniProgramProcessManager");
        f146285d = kVar;
        f146286e = new com.tencent.luggage.wxa.e5.j(kVar, Boolean.TRUE);
    }

    public f() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new b());
        this.f146288a = lazy;
    }

    public static final f a() {
        return f146283b.a();
    }

    public abstract void a(Context context, Intent intent, j jVar, k kVar, com.tencent.luggage.wxa.z4.g gVar);

    public abstract void a(com.tencent.luggage.wxa.z4.c cVar, Set set);

    public abstract boolean a(j jVar);

    public void b(String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
    }

    public abstract void c(com.tencent.luggage.wxa.z4.g gVar);

    public abstract void d(com.tencent.luggage.wxa.z4.g gVar);

    public final String e(String str, int i3) {
        com.tencent.luggage.wxa.z4.g c16;
        if (str == null || (c16 = c(str, i3)) == null) {
            return null;
        }
        return c16.d();
    }

    public abstract void e(com.tencent.luggage.wxa.z4.g gVar);

    public final void f(String appId, int i3) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        a(this, appId, i3, false, 0, 12, (Object) null);
    }

    public final List g() {
        return (List) this.f146288a.getValue();
    }

    public final boolean h(String appId, int i3) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        if (b(appId, i3) != null) {
            return true;
        }
        return false;
    }

    public abstract com.tencent.luggage.wxa.z4.e[] h();

    public void i() {
        Object obj;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (com.tencent.luggage.wxa.z4.e eVar : g()) {
            String e16 = eVar.e();
            if (e16 != null) {
                if (eVar.i()) {
                    concurrentHashMap.putIfAbsent(e16, Boolean.TRUE);
                } else {
                    Boolean FALSE = Boolean.FALSE;
                    Intrinsics.checkNotNullExpressionValue(FALSE, "FALSE");
                    concurrentHashMap.put(e16, FALSE);
                }
            }
        }
        for (Map.Entry entry : concurrentHashMap.entrySet()) {
            String str = (String) entry.getKey();
            if (((Boolean) entry.getValue()).booleanValue()) {
                w.d("Luggage.LuggageMiniProgramProcessManager", "killAll SILENT_IF_INACTIVE kill process(%s)", str);
                Iterator it = g().iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (Intrinsics.areEqual(((com.tencent.luggage.wxa.z4.e) obj).e(), str)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                com.tencent.luggage.wxa.z4.e eVar2 = (com.tencent.luggage.wxa.z4.e) obj;
                if (eVar2 != null) {
                    eVar2.k();
                }
            }
        }
        w.d("Luggage.LuggageMiniProgramProcessManager", "killAll SILENT_IF_INACTIVE");
    }

    public void a(com.tencent.luggage.wxa.b5.l runtimeInfo) {
        Intrinsics.checkNotNullParameter(runtimeInfo, "runtimeInfo");
    }

    public final void c(String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        a(appId, -1, i.f146301a);
    }

    public final com.tencent.luggage.wxa.z4.g[] d(String appId, int i3) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        ArrayList arrayList = new ArrayList();
        a(appId, i3, new d(arrayList));
        Object[] array = arrayList.toArray(new com.tencent.luggage.wxa.z4.g[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (com.tencent.luggage.wxa.z4.g[]) array;
    }

    public final String f() {
        int collectionSizeOrDefault;
        List g16 = g();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(g16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = g16.iterator();
        while (it.hasNext()) {
            arrayList.add(((com.tencent.luggage.wxa.z4.e) it.next()).toString());
        }
        Iterator it5 = arrayList.iterator();
        if (it5.hasNext()) {
            Object next = it5.next();
            while (it5.hasNext()) {
                next = ((String) next) + '\n' + ((String) it5.next());
            }
            return (String) next;
        }
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }

    public final void g(String appId, int i3) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        a(appId, -1, new h((com.tencent.luggage.wxa.z4.e) g().get(i3)));
    }

    public boolean a(j params, com.tencent.luggage.wxa.z4.e process) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(process, "process");
        return false;
    }

    public com.tencent.luggage.wxa.z4.e b(String appId, j params) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(params, "params");
        return a(appId, params, params.e() ? com.tencent.luggage.wxa.z4.i.WAGAME : com.tencent.luggage.wxa.z4.i.WASERVICE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    public final com.tencent.luggage.wxa.z4.g c(String str, int i3) {
        com.tencent.luggage.wxa.z4.g gVar;
        boolean z16 = i3 < 0;
        List g16 = g();
        ArrayList arrayList = new ArrayList();
        Iterator it = g16.iterator();
        while (true) {
            gVar = null;
            if (!it.hasNext()) {
                break;
            }
            com.tencent.luggage.wxa.z4.g a16 = com.tencent.luggage.wxa.z4.e.a((com.tencent.luggage.wxa.z4.e) it.next(), str, 0, 2, (Object) null);
            if (a16 != null && (z16 || a16.b() == i3)) {
                gVar = a16;
            }
            if (gVar != null) {
                arrayList.add(gVar);
            }
        }
        Iterator it5 = arrayList.iterator();
        if (it5.hasNext()) {
            ?? next = it5.next();
            if (it5.hasNext()) {
                ?? f16 = ((com.tencent.luggage.wxa.z4.g) next).f();
                do {
                    Object next2 = it5.next();
                    ?? f17 = ((com.tencent.luggage.wxa.z4.g) next2).f();
                    f16 = f16;
                    next = next;
                    if (f16 > f17) {
                        next = next2;
                        f16 = f17 == true ? 1 : 0;
                    }
                } while (it5.hasNext());
            }
            gVar = next;
        }
        return gVar;
    }

    public final List e() {
        List g16 = g();
        ArrayList arrayList = new ArrayList();
        Iterator it = g16.iterator();
        while (it.hasNext()) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, ((com.tencent.luggage.wxa.z4.e) it.next()).c());
        }
        return arrayList;
    }

    public void b(com.tencent.luggage.wxa.z4.g record, int i3) {
        Intrinsics.checkNotNullParameter(record, "record");
        d(record);
    }

    public static /* synthetic */ k a(f fVar, Context context, j jVar, com.tencent.luggage.wxa.tk.i iVar, Function1 function1, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startApp");
        }
        if ((i3 & 1) != 0) {
            context = z.c();
            Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        }
        if ((i3 & 4) != 0) {
            iVar = null;
        }
        if ((i3 & 8) != 0) {
            function1 = null;
        }
        return fVar.a(context, jVar, iVar, function1);
    }

    public final void b(com.tencent.luggage.wxa.z4.g record) {
        com.tencent.luggage.wxa.z4.e eVar;
        Intrinsics.checkNotNullParameter(record, "record");
        try {
            eVar = a(record);
        } catch (l unused) {
            eVar = null;
        }
        a(eVar, record);
    }

    public final k a(Context context, j params, com.tencent.luggage.wxa.tk.i iVar, Function1 function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        String a16 = params.a();
        boolean a17 = a(params);
        Pair a18 = a(params, a17);
        k kVar = (k) a18.component1();
        com.tencent.luggage.wxa.z4.e eVar = (com.tencent.luggage.wxa.z4.e) a18.component2();
        com.tencent.luggage.wxa.z4.g a19 = eVar.a(params.a(), params.d(), params.c(), params.b(), a17);
        Class d16 = a17 ? eVar.d() : eVar.f();
        Intent intent = new Intent(context, (Class<?>) d16);
        intent.addFlags((com.tencent.luggage.wxa.bo.a.a(context) != null && a17) ? 0 : 268435456);
        int a26 = a(eVar);
        intent.putExtra(MiniAppCmdUtil.KEY_INDEX, a26);
        w.d("Luggage.LuggageMiniProgramProcessManager", "startApp: appId:[%s] strategy:[%s] index:[%d] process:[%s],isPersistent:[%b],versionType:[%d],uiClass:[%s]", a16, kVar.name(), Integer.valueOf(a26), eVar.e(), Boolean.valueOf(a17), Integer.valueOf(params.d()), d16.getName());
        com.tencent.luggage.wxa.so.h.a("MiniProgramPM-onStartWxaApp-" + d16.getSimpleName());
        a(context, intent, params, kVar, a19);
        com.tencent.luggage.wxa.so.h.a();
        c(a16);
        if (iVar != null) {
            iVar.f141499a = eVar;
        }
        String e16 = eVar.e();
        if (e16 != null && function1 != null) {
            function1.invoke(e16);
        }
        return kVar;
    }

    public final com.tencent.luggage.wxa.z4.g b(String appId, int i3) {
        int collectionSizeOrDefault;
        com.tencent.luggage.wxa.z4.g a16;
        Intrinsics.checkNotNullParameter(appId, "appId");
        if (appId.length() == 0) {
            return null;
        }
        List<com.tencent.luggage.wxa.z4.e> g16 = g();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(g16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (com.tencent.luggage.wxa.z4.e eVar : g16) {
            if ((eVar != null && eVar.j()) && (a16 = eVar.a(appId, i3)) != null) {
                return a16;
            }
            arrayList.add(Unit.INSTANCE);
        }
        return null;
    }

    public Pair a(j params, boolean z16) {
        List sortedWith;
        Lazy lazy;
        Pair pair;
        Object obj;
        Object first;
        Intrinsics.checkNotNullParameter(params, "params");
        String a16 = params.a();
        int d16 = params.d();
        com.tencent.luggage.wxa.z4.i a17 = com.tencent.luggage.wxa.z4.i.f146315a.a(params.e());
        sortedWith = ArraysKt___ArraysKt.sortedWith(d(a16, d16), new e());
        lazy = LazyKt__LazyJVMKt.lazy(new C6972f(a16, params, a17));
        boolean z17 = !sortedWith.isEmpty();
        boolean z18 = false;
        if (true == (z16 && !z17)) {
            pair = a(a16, params);
        } else {
            if (true == (z16 && z17)) {
                Iterator it = sortedWith.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (((com.tencent.luggage.wxa.z4.g) obj).f()) {
                        break;
                    }
                }
                com.tencent.luggage.wxa.z4.g gVar = (com.tencent.luggage.wxa.z4.g) obj;
                if (gVar == null) {
                    w.d("Luggage.LuggageMiniProgramProcessManager", "getStartStrategyAndTask(" + a16 + "): stash task lost (localRecords.size:" + sortedWith.size() + ") fallback");
                    first = CollectionsKt___CollectionsKt.first((List<? extends Object>) sortedWith);
                    pair = a((com.tencent.luggage.wxa.z4.g) first, params);
                } else {
                    pair = a(gVar, params);
                }
            } else {
                if (true == ((z16 || z17) ? false : true)) {
                    pair = (Pair) lazy.getValue();
                } else {
                    if (!z16 && z17) {
                        z18 = true;
                    }
                    if (true == z18) {
                        try {
                            Pair a18 = a(sortedWith);
                            if (a18.getFirst() == k.RESUME_EXISTED && a(params, (com.tencent.luggage.wxa.z4.e) a18.getSecond())) {
                                Iterator it5 = sortedWith.iterator();
                                while (it5.hasNext()) {
                                    a((com.tencent.luggage.wxa.z4.g) it5.next(), true, 2);
                                }
                                pair = (Pair) lazy.getValue();
                            } else {
                                pair = a18;
                            }
                        } catch (l unused) {
                            w.b("Luggage.LuggageMiniProgramProcessManager", "getStartStrategyAndTask(" + a16 + "): commit failed. fallback to create new strategy");
                            pair = (Pair) lazy.getValue();
                        }
                    } else {
                        throw new IllegalStateException("never!");
                    }
                }
            }
        }
        ((com.tencent.luggage.wxa.z4.e) pair.getSecond()).a(a17);
        return pair;
    }

    public final Pair a(List list) {
        Object obj;
        Object obj2;
        Object first;
        Iterator it = list.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            if (((com.tencent.luggage.wxa.z4.g) obj2).f()) {
                break;
            }
        }
        com.tencent.luggage.wxa.z4.g gVar = (com.tencent.luggage.wxa.z4.g) obj2;
        if (gVar == null) {
            k kVar = k.RESUME_EXISTED;
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
            return new Pair(kVar, a((com.tencent.luggage.wxa.z4.g) first));
        }
        Iterator it5 = list.iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            Object next = it5.next();
            if (((com.tencent.luggage.wxa.z4.g) next).f()) {
                obj = next;
                break;
            }
        }
        Intrinsics.checkNotNull(obj);
        com.tencent.luggage.wxa.z4.e a16 = a((com.tencent.luggage.wxa.z4.g) obj);
        gVar.a(false);
        return new Pair(k.RESUME_EXISTED, a16);
    }

    public final Pair a(String str, j jVar) {
        return new Pair(k.CREATE_NEW, b(str, jVar));
    }

    public Pair a(com.tencent.luggage.wxa.z4.g record, j params) {
        Intrinsics.checkNotNullParameter(record, "record");
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.luggage.wxa.z4.e a16 = a(record);
        k kVar = k.RESUME_EXISTED;
        record.a(true);
        return new Pair(kVar, a16);
    }

    public final com.tencent.luggage.wxa.z4.e a(List availableProcess, String appId, j params, com.tencent.luggage.wxa.z4.i type) {
        Object obj;
        Object obj2;
        int collectionSizeOrDefault;
        Comparable minOrNull;
        int collectionSizeOrDefault2;
        Comparable minOrNull2;
        Object obj3;
        Intrinsics.checkNotNullParameter(availableProcess, "availableProcess");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(type, "type");
        com.tencent.luggage.wxa.z4.e a16 = a(appId);
        if (a16 != null) {
            return a16;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj4 : availableProcess) {
            com.tencent.luggage.wxa.z4.e eVar = (com.tencent.luggage.wxa.z4.e) obj4;
            boolean b16 = eVar.b(type);
            if (b16) {
                eVar.h();
            }
            if (b16) {
                arrayList.add(obj4);
            }
        }
        Iterator it = arrayList.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            com.tencent.luggage.wxa.z4.e eVar2 = (com.tencent.luggage.wxa.z4.e) obj2;
            if (eVar2.i() && eVar2.j() && (eVar2.g() == com.tencent.luggage.wxa.z4.i.NIL || eVar2.g() == type)) {
                break;
            }
        }
        com.tencent.luggage.wxa.z4.e eVar3 = (com.tencent.luggage.wxa.z4.e) obj2;
        if (eVar3 == null) {
            Iterator it5 = arrayList.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    obj3 = null;
                    break;
                }
                obj3 = it5.next();
                com.tencent.luggage.wxa.z4.e eVar4 = (com.tencent.luggage.wxa.z4.e) obj3;
                if (eVar4.i() && (eVar4.g() == com.tencent.luggage.wxa.z4.i.NIL || eVar4.g() == type)) {
                    break;
                }
            }
            eVar3 = (com.tencent.luggage.wxa.z4.e) obj3;
        }
        if (eVar3 != null) {
            return eVar3;
        }
        Iterator it6 = arrayList.iterator();
        if (it6.hasNext()) {
            Object next = it6.next();
            if (it6.hasNext()) {
                Collection c16 = ((com.tencent.luggage.wxa.z4.e) next).c();
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(c16, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                Iterator it7 = c16.iterator();
                while (it7.hasNext()) {
                    arrayList2.add(Long.valueOf(((com.tencent.luggage.wxa.z4.g) it7.next()).e()));
                }
                minOrNull = CollectionsKt___CollectionsKt.minOrNull((Iterable<? extends Comparable>) arrayList2);
                Long l3 = (Long) minOrNull;
                long longValue = l3 != null ? l3.longValue() : 0L;
                do {
                    Object next2 = it6.next();
                    Collection c17 = ((com.tencent.luggage.wxa.z4.e) next2).c();
                    collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(c17, 10);
                    ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
                    Iterator it8 = c17.iterator();
                    while (it8.hasNext()) {
                        arrayList3.add(Long.valueOf(((com.tencent.luggage.wxa.z4.g) it8.next()).e()));
                    }
                    minOrNull2 = CollectionsKt___CollectionsKt.minOrNull((Iterable<? extends Comparable>) arrayList3);
                    Long l16 = (Long) minOrNull2;
                    long longValue2 = l16 != null ? l16.longValue() : 0L;
                    if (longValue > longValue2) {
                        next = next2;
                        longValue = longValue2;
                    }
                } while (it6.hasNext());
            }
            obj = next;
        }
        Intrinsics.checkNotNull(obj);
        return (com.tencent.luggage.wxa.z4.e) obj;
    }

    public com.tencent.luggage.wxa.z4.e a(String appId, j params, com.tencent.luggage.wxa.z4.i type) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(type, "type");
        return a(g(), appId, params, type);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object] */
    public final com.tencent.luggage.wxa.z4.e a(List availableProcess, com.tencent.luggage.wxa.z4.i serviceType) {
        com.tencent.luggage.wxa.z4.e eVar;
        Class f16;
        com.tencent.luggage.wxa.z4.e eVar2;
        Object first;
        Object obj;
        Class f17;
        Object first2;
        Intrinsics.checkNotNullParameter(availableProcess, "availableProcess");
        Intrinsics.checkNotNullParameter(serviceType, "serviceType");
        if (serviceType != com.tencent.luggage.wxa.z4.i.NIL) {
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : availableProcess) {
                com.tencent.luggage.wxa.z4.e eVar3 = (com.tencent.luggage.wxa.z4.e) obj2;
                if (serviceType == eVar3.g() && eVar3.i()) {
                    arrayList.add(obj2);
                }
            }
            String str = null;
            if (!arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (((com.tencent.luggage.wxa.z4.e) obj).j()) {
                        break;
                    }
                }
                eVar = (com.tencent.luggage.wxa.z4.e) obj;
                if (eVar == null) {
                    first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
                    eVar = (com.tencent.luggage.wxa.z4.e) first2;
                }
                Object[] objArr = new Object[2];
                objArr[0] = (eVar == null || (f17 = eVar.f()) == null) ? null : f17.getSimpleName();
                objArr[1] = serviceType;
                w.d("Luggage.LuggageMiniProgramProcessManager", "getAvailableTaskToPreload found empty task[%s], which can be used as [%s]", objArr);
            } else {
                eVar = null;
            }
            if (eVar == null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj3 : availableProcess) {
                    com.tencent.luggage.wxa.z4.e eVar4 = (com.tencent.luggage.wxa.z4.e) obj3;
                    if (eVar4.g() == com.tencent.luggage.wxa.z4.i.NIL && eVar4.b(serviceType)) {
                        arrayList2.add(obj3);
                    }
                }
                if (!arrayList2.isEmpty()) {
                    Iterator it5 = arrayList2.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            eVar2 = 0;
                            break;
                        }
                        eVar2 = it5.next();
                        if (((com.tencent.luggage.wxa.z4.e) eVar2).j()) {
                            break;
                        }
                    }
                    eVar = eVar2;
                    if (eVar == null) {
                        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList2);
                        eVar = (com.tencent.luggage.wxa.z4.e) first;
                    }
                }
                Object[] objArr2 = new Object[2];
                objArr2[0] = serviceType;
                if (eVar != null && (f16 = eVar.f()) != null) {
                    str = f16.getSimpleName();
                }
                if (str == null) {
                    str = "null";
                }
                objArr2[1] = str;
                w.d("Luggage.LuggageMiniProgramProcessManager", "getAvailableTaskToPreload serviceType = [%s] not reached max limit , got ui task = [%s]", objArr2);
            }
            return eVar;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public com.tencent.luggage.wxa.z4.e a(com.tencent.luggage.wxa.z4.i serviceType) {
        Intrinsics.checkNotNullParameter(serviceType, "serviceType");
        return a(g(), serviceType);
    }

    public final int a(com.tencent.luggage.wxa.z4.e process) {
        Intrinsics.checkNotNullParameter(process, "process");
        return g().indexOf(process);
    }

    public final com.tencent.luggage.wxa.z4.e a(String appId) {
        Object obj;
        Intrinsics.checkNotNullParameter(appId, "appId");
        Iterator it = g().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((com.tencent.luggage.wxa.z4.e) obj).b().contains(appId)) {
                break;
            }
        }
        return (com.tencent.luggage.wxa.z4.e) obj;
    }

    public final List a(Function1 predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        List g16 = g();
        ArrayList arrayList = new ArrayList();
        for (Object obj : g16) {
            if (((Boolean) predicate.invoke((com.tencent.luggage.wxa.z4.e) obj)).booleanValue()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final com.tencent.luggage.wxa.z4.e a(com.tencent.luggage.wxa.z4.g record) {
        Object obj;
        Intrinsics.checkNotNullParameter(record, "record");
        Iterator it = g().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((com.tencent.luggage.wxa.z4.e) obj).c().contains(record)) {
                break;
            }
        }
        com.tencent.luggage.wxa.z4.e eVar = (com.tencent.luggage.wxa.z4.e) obj;
        if (eVar != null) {
            return eVar;
        }
        throw new l();
    }

    public final com.tencent.luggage.wxa.z4.e a(int i3) {
        return (com.tencent.luggage.wxa.z4.e) g().get(i3);
    }

    public final void a(int i3, com.tencent.luggage.wxa.j4.d initConfig, j params) {
        Intrinsics.checkNotNullParameter(initConfig, "initConfig");
        Intrinsics.checkNotNullParameter(params, "params");
        ((com.tencent.luggage.wxa.z4.e) g().get(i3)).a(params.a(), params.d(), "", (com.tencent.luggage.wxa.fd.i) initConfig, false).a(com.tencent.luggage.wxa.z4.h.PRE_RENDERED);
    }

    public final void a(com.tencent.luggage.wxa.z4.c killType) {
        Intrinsics.checkNotNullParameter(killType, "killType");
        if (killType == com.tencent.luggage.wxa.z4.c.KILL_TYPE_SILENT_IF_INACTIVE) {
            i();
            return;
        }
        ArraySet arraySet = new ArraySet();
        for (com.tencent.luggage.wxa.z4.e eVar : g()) {
            if (!eVar.a(killType)) {
                arraySet.add(eVar);
            }
        }
        a(killType, arraySet);
    }

    public final void a(String appId, int i3) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        a(appId, i3, new c());
    }

    public static /* synthetic */ void a(f fVar, String str, int i3, boolean z16, int i16, int i17, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: killByAppId");
        }
        if ((i17 & 2) != 0) {
            i3 = -1;
        }
        if ((i17 & 4) != 0) {
            z16 = false;
        }
        if ((i17 & 8) != 0) {
            i16 = 1;
        }
        fVar.a(str, i3, z16, i16);
    }

    public final void a(String appId, int i3, boolean z16, int i16) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        w.d("Luggage.LuggageMiniProgramProcessManager", "killByAppId(appId:" + appId + ", versionType:" + i3 + ", sync:" + z16 + ')');
        a(appId, i3, new g(z16, i16));
    }

    public final void a(com.tencent.luggage.wxa.z4.g record, boolean z16, int i3) {
        Intrinsics.checkNotNullParameter(record, "record");
        if (z16) {
            a(record, i3);
        } else {
            b(record, i3);
        }
        if (record.f()) {
            c(record.a());
        } else {
            b(record);
        }
    }

    public final void a(String appId, int i3, Function1 command) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(command, "command");
        List g16 = g();
        ArrayList<com.tencent.luggage.wxa.z4.g> arrayList = new ArrayList();
        Iterator it = g16.iterator();
        while (it.hasNext()) {
            com.tencent.luggage.wxa.z4.g a16 = com.tencent.luggage.wxa.z4.e.a((com.tencent.luggage.wxa.z4.e) it.next(), appId, 0, 2, (Object) null);
            if (a16 != null) {
                arrayList.add(a16);
            }
        }
        if (arrayList.isEmpty()) {
            w.h("Luggage.LuggageMiniProgramProcessManager", "findRecords: ([%s][%s]) not found", appId, Integer.valueOf(i3));
        }
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (com.tencent.luggage.wxa.z4.g gVar : arrayList) {
            if (gVar.f()) {
                linkedList.add(gVar);
            } else {
                linkedList2.add(gVar);
            }
        }
        if (arrayList.size() > 2 || linkedList.size() > 1 || linkedList2.size() > 1) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("records(%s %d) size[%d] persistent size[%d] !persistent size[%d]", Arrays.copyOf(new Object[]{appId, Integer.valueOf(i3), Integer.valueOf(arrayList.size()), Integer.valueOf(linkedList.size()), Integer.valueOf(linkedList2.size())}, 5));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            if (!com.tencent.luggage.wxa.tn.e.f141565g && !com.tencent.luggage.wxa.tn.e.f141559a) {
                w.b("Luggage.LuggageMiniProgramProcessManager", format);
            } else {
                throw new IllegalStateException(format);
            }
        }
        Iterator it5 = linkedList2.iterator();
        while (it5.hasNext()) {
            com.tencent.luggage.wxa.z4.g record = (com.tencent.luggage.wxa.z4.g) it5.next();
            if (i3 < 0 || record.b() == i3) {
                Intrinsics.checkNotNullExpressionValue(record, "record");
                command.invoke(record);
                return;
            }
        }
        Iterator it6 = linkedList.iterator();
        while (it6.hasNext()) {
            com.tencent.luggage.wxa.z4.g record2 = (com.tencent.luggage.wxa.z4.g) it6.next();
            if (i3 < 0 || record2.b() == i3) {
                Intrinsics.checkNotNullExpressionValue(record2, "record");
                command.invoke(record2);
                return;
            }
        }
    }

    public void a(com.tencent.luggage.wxa.z4.g record, int i3) {
        Intrinsics.checkNotNullParameter(record, "record");
        e(record);
    }

    public final void a(com.tencent.luggage.wxa.z4.e eVar, com.tencent.luggage.wxa.z4.g record) {
        Intrinsics.checkNotNullParameter(record, "record");
        if (eVar != null) {
            eVar.a(record);
        }
    }

    public final com.tencent.luggage.wxa.z4.g a(String appId, int i3, int i16, String instanceId, com.tencent.luggage.wxa.fd.i initConfig) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        Intrinsics.checkNotNullParameter(initConfig, "initConfig");
        w.d("Luggage.LuggageMiniProgramProcessManager", "stashPersistentApp: appId[%s]versionType[%d]instanceId[%s]processIndex[%d]", appId, Integer.valueOf(i3), instanceId, Integer.valueOf(i16));
        com.tencent.luggage.wxa.z4.g a16 = com.tencent.luggage.wxa.z4.e.a(a(i16), appId, 0, 2, (Object) null);
        if (a16 == null) {
            return a(i16).a(appId, true, i3, instanceId, initConfig);
        }
        a16.a(true);
        return a16;
    }

    public static /* synthetic */ com.tencent.luggage.wxa.z4.g a(f fVar, String str, int i3, int i16, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findAliveAppRecord");
        }
        if ((i16 & 2) != 0) {
            i3 = -1;
        }
        return fVar.b(str, i3);
    }

    public final void a(String excludeInstanceId, String appId) {
        Intrinsics.checkNotNullParameter(excludeInstanceId, "excludeInstanceId");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Iterator it = g().iterator();
        while (it.hasNext()) {
            ((com.tencent.luggage.wxa.z4.e) it.next()).a(excludeInstanceId, appId, true);
        }
    }

    public final void a(com.tencent.luggage.wxa.z4.e excludeProcess, String excludeInstanceId, String appId) {
        Intrinsics.checkNotNullParameter(excludeProcess, "excludeProcess");
        Intrinsics.checkNotNullParameter(excludeInstanceId, "excludeInstanceId");
        Intrinsics.checkNotNullParameter(appId, "appId");
        for (com.tencent.luggage.wxa.z4.e eVar : g()) {
            if (!Intrinsics.areEqual(excludeProcess.e(), eVar.e())) {
                eVar.a(appId, true);
            } else if (!Intrinsics.areEqual(excludeProcess, eVar)) {
                eVar.a(appId, false);
            } else {
                eVar.a(excludeInstanceId, appId, true);
            }
        }
    }
}
