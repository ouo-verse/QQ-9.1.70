package com.tencent.luggage.wxa.xn;

import androidx.lifecycle.ViewModel;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import java.lang.reflect.Constructor;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* compiled from: P */
/* loaded from: classes9.dex */
public class g extends ViewModel {

    /* renamed from: d, reason: collision with root package name */
    public static final a f145179d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Lazy f145180a;

    /* renamed from: b, reason: collision with root package name */
    public Class f145181b;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.luggage.wxa.xn.a f145182c;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b extends Lambda implements Function0 {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.zn.c invoke() {
            return g.this.a();
        }
    }

    public g() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new b());
        this.f145180a = lazy;
    }

    public com.tencent.luggage.wxa.zn.c a() {
        com.tencent.luggage.wxa.zn.c b16 = b();
        if (b16 == null) {
            w.d(e(), "create new storage observer owner");
            return new com.tencent.luggage.wxa.zn.c();
        }
        return b16;
    }

    public final com.tencent.luggage.wxa.zn.c b() {
        com.tencent.luggage.wxa.zn.c cVar;
        com.tencent.luggage.wxa.xn.a d16 = d();
        if (d16 != null) {
            cVar = d16.c();
        } else {
            cVar = null;
        }
        if (!(cVar instanceof com.tencent.luggage.wxa.zn.c)) {
            return null;
        }
        return cVar;
    }

    public Class c() {
        if (this.f145181b == null) {
            w.d(e(), "getAttachClazz start: " + ResourceAttributes.TelemetrySdkLanguageValues.JAVA);
            long currentTimeMillis = System.currentTimeMillis();
            Class a16 = com.tencent.luggage.wxa.rn.a.a(Reflection.getOrCreateKotlinClass(getClass()));
            if (!(a16 instanceof Class)) {
                a16 = null;
            }
            this.f145181b = a16;
            w.d(e(), "getAttachClazz cost: " + (System.currentTimeMillis() - currentTimeMillis));
        }
        return this.f145181b;
    }

    public com.tencent.luggage.wxa.xn.a d() {
        com.tencent.luggage.wxa.xn.a aVar;
        Constructor declaredConstructor;
        if (this.f145182c == null) {
            Class c16 = c();
            if (c16 != null && (declaredConstructor = c16.getDeclaredConstructor(new Class[0])) != null) {
                aVar = (com.tencent.luggage.wxa.xn.a) declaredConstructor.newInstance(new Object[0]);
            } else {
                aVar = null;
            }
            this.f145182c = aVar;
        }
        return this.f145182c;
    }

    public String e() {
        return "MicroMsg.Mvvm.ObservableStorage";
    }
}
