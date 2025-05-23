package com.tencent.luggage.wxa.tj;

import com.tencent.luggage.wxa.e5.h;
import com.tencent.luggage.wxa.e5.l;
import com.tencent.luggage.wxa.tj.b;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uk.a;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a extends com.tencent.luggage.wxa.uk.a {

    /* renamed from: e, reason: collision with root package name */
    public static final b f141423e = new b(null);

    /* renamed from: f, reason: collision with root package name */
    public static final HashMap f141424f = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ic.g f141425d;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.tj.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6759a extends Lambda implements Function1 {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.tj.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6760a extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f141427a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C6760a(a aVar) {
                super(0);
                this.f141427a = aVar;
            }

            public final void a() {
                a.f141424f.remove(this.f141427a.f141425d);
                this.f141427a.a();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        public C6759a() {
            super(1);
        }

        public final void a(h lifecycle) {
            Intrinsics.checkNotNullParameter(lifecycle, "$this$lifecycle");
            lifecycle.b(new C6760a(a.this));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((h) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a a(com.tencent.luggage.wxa.ic.d component) {
            a aVar;
            Intrinsics.checkNotNullParameter(component, "component");
            com.tencent.luggage.wxa.ic.g runtime = component.getRuntime();
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (runtime != null) {
                synchronized (a.f141424f) {
                    aVar = (a) a.f141424f.get(runtime);
                    if (aVar == null) {
                        aVar = new a(runtime, defaultConstructorMarker);
                        a.f141424f.put(runtime, aVar);
                    }
                }
                return aVar;
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements a.InterfaceC6804a {

        /* renamed from: a, reason: collision with root package name */
        public final e f141428a;

        /* renamed from: b, reason: collision with root package name */
        public final b.j f141429b;

        /* renamed from: c, reason: collision with root package name */
        public final String f141430c;

        public c(e context, b.j jVar, String key) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(key, "key");
            this.f141428a = context;
            this.f141429b = jVar;
            this.f141430c = key;
        }

        public final e a() {
            return this.f141428a;
        }

        public final b.j b() {
            return this.f141429b;
        }

        public final String c() {
            return this.f141430c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (Intrinsics.areEqual(this.f141428a, cVar.f141428a) && Intrinsics.areEqual(this.f141429b, cVar.f141429b) && Intrinsics.areEqual(this.f141430c, cVar.f141430c)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = this.f141428a.hashCode() * 31;
            b.j jVar = this.f141429b;
            if (jVar == null) {
                hashCode = 0;
            } else {
                hashCode = jVar.hashCode();
            }
            return ((hashCode2 + hashCode) * 31) + this.f141430c.hashCode();
        }

        public String toString() {
            return "Task(context=" + this.f141428a + ", callback=" + this.f141429b + ", key=" + this.f141430c + ')';
        }
    }

    public /* synthetic */ a(com.tencent.luggage.wxa.ic.g gVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(gVar);
    }

    public static final a a(com.tencent.luggage.wxa.ic.d dVar) {
        return f141423e.a(dVar);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends b.h {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f141431b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(b.j jVar, Function0 function0) {
            super(jVar);
            this.f141431b = function0;
        }

        @Override // com.tencent.luggage.wxa.tj.b.h, com.tencent.luggage.wxa.tj.b.j
        public void a() {
            super.a();
            this.f141431b.invoke();
        }

        @Override // com.tencent.luggage.wxa.tj.b.h, com.tencent.luggage.wxa.tj.b.j
        public void onCancel() {
            super.onCancel();
            this.f141431b.invoke();
        }

        @Override // com.tencent.luggage.wxa.tj.b.h, com.tencent.luggage.wxa.tj.b.j
        public void a(int i3, String str) {
            super.a(i3, str);
            this.f141431b.invoke();
        }
    }

    public a(com.tencent.luggage.wxa.ic.g gVar) {
        super(1);
        this.f141425d = gVar;
        l.f124555a.a(gVar, new C6759a());
    }

    public final void a(e context, b.j jVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        String str = "name[" + context.a() + "], callbackId[" + context.c() + "], appId[" + context.d().getAppId() + "], component[" + context.d().getComponentId() + ']';
        w.d("MicroMsg.AppBrandJSApiUserAuthExecutor", "execute " + str);
        super.b(new c(context, jVar, str));
    }

    @Override // com.tencent.luggage.wxa.uk.a
    public void a(c task, Function0 onEnd) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(onEnd, "onEnd");
        e a16 = task.a();
        b.j b16 = task.b();
        w.d("MicroMsg.AppBrandJSApiUserAuthExecutor", "runTask " + task.c());
        com.tencent.luggage.wxa.tj.b.a(a16, new d(b16, onEnd), com.tencent.luggage.wxa.tj.b.f141433e);
    }
}
