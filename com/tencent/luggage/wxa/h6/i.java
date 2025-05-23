package com.tencent.luggage.wxa.h6;

import com.tencent.luggage.wxa.tn.f0;
import com.tencent.luggage.wxa.tn.w;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class i {

    /* renamed from: f, reason: collision with root package name */
    public static final a f126891f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public String f126892a;

    /* renamed from: b, reason: collision with root package name */
    public Object f126893b;

    /* renamed from: c, reason: collision with root package name */
    public Class f126894c;

    /* renamed from: d, reason: collision with root package name */
    public Object f126895d;

    /* renamed from: e, reason: collision with root package name */
    public final Lazy f126896e;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Collection a(Class cls) {
            ArrayList arrayList = new ArrayList();
            for (Class superclass = cls.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
                arrayList.add(superclass);
            }
            return arrayList;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function0 {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final f0 invoke() {
            String str = i.this.f126892a;
            if (str == null) {
                Object obj = i.this.f126895d;
                if (obj == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("thisRef");
                    obj = Unit.INSTANCE;
                }
                str = obj.getClass().getCanonicalName();
                Intrinsics.checkNotNull(str);
            }
            return f0.c(str, 2);
        }
    }

    public i(Object defaultValue) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        lazy = LazyKt__LazyJVMKt.lazy(new b());
        this.f126896e = lazy;
        this.f126893b = defaultValue;
        this.f126894c = defaultValue.getClass();
    }

    public final f0 a() {
        Object value = this.f126896e.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mmkv>(...)");
        return (f0) value;
    }

    public final Object a(Object thisRef, KProperty property) {
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter(property, "property");
        this.f126895d = thisRef;
        Class cls = this.f126894c;
        if (Intrinsics.areEqual(cls, Float.TYPE) ? true : Intrinsics.areEqual(cls, Float.class)) {
            f0 a16 = a();
            String name = property.getName();
            Object obj = this.f126893b;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
            return Float.valueOf(a16.getFloat(name, ((Float) obj).floatValue()));
        }
        if (Intrinsics.areEqual(cls, Integer.TYPE) ? true : Intrinsics.areEqual(cls, Integer.class)) {
            f0 a17 = a();
            String name2 = property.getName();
            Object obj2 = this.f126893b;
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
            return Integer.valueOf(a17.getInt(name2, ((Integer) obj2).intValue()));
        }
        if (Intrinsics.areEqual(cls, String.class)) {
            f0 a18 = a();
            String name3 = property.getName();
            Object obj3 = this.f126893b;
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
            String string = a18.getString(name3, (String) obj3);
            Intrinsics.checkNotNull(string, "null cannot be cast to non-null type T of com.tencent.luggage.util.LuggageMMKVProperty");
            return string;
        }
        if (Intrinsics.areEqual(cls, Long.TYPE) ? true : Intrinsics.areEqual(cls, Long.class)) {
            f0 a19 = a();
            String name4 = property.getName();
            Object obj4 = this.f126893b;
            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Long");
            return Long.valueOf(a19.getLong(name4, ((Long) obj4).longValue()));
        }
        if (Intrinsics.areEqual(cls, Boolean.TYPE) ? true : Intrinsics.areEqual(cls, Boolean.class)) {
            f0 a26 = a();
            String name5 = property.getName();
            Object obj5 = this.f126893b;
            Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.Boolean");
            return Boolean.valueOf(a26.getBoolean(name5, ((Boolean) obj5).booleanValue()));
        }
        if (!Intrinsics.areEqual(cls, byte[].class)) {
            if (f126891f.a(this.f126894c).contains(com.tencent.luggage.wxa.fn.b.class)) {
                byte[] b16 = a().b(property.getName());
                if (b16 == null) {
                    return this.f126893b;
                }
                try {
                    Object newInstance = this.f126894c.newInstance();
                    Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.mm.protobuf.BaseProtoBuf");
                    com.tencent.luggage.wxa.fn.b bVar = (com.tencent.luggage.wxa.fn.b) newInstance;
                    bVar.a(b16);
                    return bVar;
                } catch (Exception unused) {
                    w.b("AppBrand.utils.AppBrandMMKVProperty", "parse pb failed, class:" + this.f126894c.getCanonicalName());
                    return this.f126893b;
                }
            }
            throw new IllegalAccessError("unsupported type:" + this.f126894c);
        }
        Object b17 = a().b(property.getName());
        if (b17 == null) {
            b17 = this.f126893b;
        }
        Intrinsics.checkNotNull(b17, "null cannot be cast to non-null type T of com.tencent.luggage.util.LuggageMMKVProperty");
        return b17;
    }
}
