package com.tencent.luggage.wxa.so;

import com.tencent.luggage.wxa.tn.f0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.mini.cache.Entry;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f140567a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f140568b;

    /* renamed from: c, reason: collision with root package name */
    public static final HashMap f140569c;

    /* renamed from: d, reason: collision with root package name */
    public static f0 f140570d;

    /* renamed from: e, reason: collision with root package name */
    public static AtomicBoolean f140571e;

    /* renamed from: f, reason: collision with root package name */
    public static final Lazy f140572f;

    /* renamed from: g, reason: collision with root package name */
    public static final Lazy f140573g;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f140574a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            boolean z16;
            try {
                Class.forName("com.tencent.mm.plugin.repairer.ui.RepairerMainUI");
                z16 = true;
            } catch (Throwable unused) {
                z16 = false;
            }
            return Boolean.valueOf(z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final b f140575a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ConcurrentLinkedDeque invoke() {
            return new ConcurrentLinkedDeque();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final c f140576a = new c();

        public c() {
            super(0);
        }

        public final void a() {
            f fVar = f.f140567a;
            fVar.a(f0.e("Repairer"));
            f0 b16 = fVar.b();
            int i3 = 0;
            if (b16 != null) {
                i3 = b16.a(com.tencent.luggage.wxa.so.b.RepairerConfig_Inner_Version_Int.name(), 0);
            }
            if (i3 != 1) {
                f0 b17 = fVar.b();
                if (b17 != null) {
                    b17.c();
                }
                f0 b18 = fVar.b();
                if (b18 != null) {
                    b18.b();
                }
                w.d(fVar.e(), "diff version, clear all currentVersion:" + i3 + " currentVersion:1");
            } else {
                w.d(fVar.e(), "same version, currentVersion:1");
            }
            f0 b19 = fVar.b();
            if (b19 != null) {
                b19.b(com.tencent.luggage.wxa.so.b.RepairerConfig_Inner_Version_Int.name(), 1);
            }
            fVar.c().set(true);
            Iterator it = fVar.d().iterator();
            while (it.hasNext()) {
                com.tencent.luggage.wxa.k0.d.a(((WeakReference) it.next()).get());
            }
            f.f140567a.d().clear();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f140577a;

        public d(Function0 function0) {
            this.f140577a = function0;
        }

        @Override // java.lang.Runnable
        public final /* synthetic */ void run() {
            this.f140577a.invoke();
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        f fVar = new f();
        f140567a = fVar;
        f140568b = "MicroMsg.RepairerLogic";
        f140569c = new HashMap();
        f140571e = new AtomicBoolean(false);
        lazy = LazyKt__LazyJVMKt.lazy(b.f140575a);
        f140572f = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(a.f140574a);
        f140573g = lazy2;
        if (!com.tencent.luggage.wxa.z8.c.b(z.c())) {
            c cVar = c.f140576a;
            if (fVar.a()) {
                cVar.invoke();
            } else {
                com.tencent.luggage.wxa.zp.h.f146825d.b(new d(cVar), "RepairerConfigThread");
            }
        }
    }

    public final f0 b() {
        return f140570d;
    }

    public final AtomicBoolean c() {
        return f140571e;
    }

    public final ConcurrentLinkedDeque d() {
        return (ConcurrentLinkedDeque) f140572f.getValue();
    }

    public final String e() {
        return f140568b;
    }

    public final void a(f0 f0Var) {
        f140570d = f0Var;
    }

    public final boolean a() {
        return ((Boolean) f140573g.getValue()).booleanValue();
    }

    public final Object a(String key, Object defaultValue) {
        List split$default;
        f0 f0Var;
        f0 f0Var2;
        f0 f0Var3;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        HashMap hashMap = f140569c;
        if (hashMap.containsKey(key)) {
            Object obj = hashMap.get(key);
            return obj == null ? defaultValue : obj;
        }
        f0 f0Var4 = f140570d;
        if (f0Var4 != null && f0Var4.a(key)) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) key, new String[]{"_"}, false, 0, 6, (Object) null);
            String str = (String) split$default.get(split$default.size() - 1);
            int hashCode = str.hashCode();
            if (hashCode != -1808118735) {
                if (hashCode != 73679) {
                    if (hashCode != 2374300) {
                        if (hashCode == 67973692 && str.equals("Float") && (f0Var3 = f140570d) != null) {
                            defaultValue = Float.valueOf(f0Var3.a(key, ((Float) defaultValue).floatValue()));
                        }
                    } else if (str.equals("Long") && (f0Var2 = f140570d) != null) {
                        defaultValue = Long.valueOf(f0Var2.a(key, ((Long) defaultValue).longValue()));
                    }
                } else if (str.equals("Int") && (f0Var = f140570d) != null) {
                    defaultValue = Integer.valueOf(f0Var.a(key, ((Integer) defaultValue).intValue()));
                }
            } else if (str.equals(Entry.DATA_TYPE_STRING)) {
                f0 f0Var5 = f140570d;
                String a16 = f0Var5 != null ? f0Var5.a(key, (String) defaultValue) : null;
                if (a16 != null) {
                    defaultValue = a16;
                }
            }
            hashMap.put(key, defaultValue);
        }
        return defaultValue;
    }

    public final String a(com.tencent.luggage.wxa.in.a keyObj) {
        Intrinsics.checkNotNullParameter(keyObj, "keyObj");
        Object a16 = a(keyObj.d(), keyObj.c());
        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type kotlin.String");
        return (String) a16;
    }
}
