package com.tencent.luggage.wxa.e5;

import com.tencent.luggage.wxa.tn.f0;
import com.tencent.luggage.wxa.tn.w;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes8.dex */
public class j {

    /* renamed from: e, reason: collision with root package name */
    public static final a f124549e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final d f124550a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f124551b;

    /* renamed from: c, reason: collision with root package name */
    public final Class f124552c;

    /* renamed from: d, reason: collision with root package name */
    public Object f124553d;

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

    public j(d set, Object defaultValue) {
        Intrinsics.checkNotNullParameter(set, "set");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        this.f124550a = set;
        this.f124551b = defaultValue;
        this.f124552c = defaultValue.getClass();
    }

    public Object a(Object thisRef, KProperty property) {
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter(property, "property");
        this.f124553d = thisRef;
        Class cls = this.f124552c;
        if (Intrinsics.areEqual(cls, Float.TYPE) ? true : Intrinsics.areEqual(cls, Float.class)) {
            f0 a16 = this.f124550a.a();
            String name = property.getName();
            Object obj = this.f124551b;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
            return Float.valueOf(a16.getFloat(name, ((Float) obj).floatValue()));
        }
        if (Intrinsics.areEqual(cls, Integer.TYPE) ? true : Intrinsics.areEqual(cls, Integer.class)) {
            f0 a17 = this.f124550a.a();
            String name2 = property.getName();
            Object obj2 = this.f124551b;
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
            return Integer.valueOf(a17.getInt(name2, ((Integer) obj2).intValue()));
        }
        if (Intrinsics.areEqual(cls, String.class)) {
            f0 a18 = this.f124550a.a();
            String name3 = property.getName();
            Object obj3 = this.f124551b;
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
            String string = a18.getString(name3, (String) obj3);
            Intrinsics.checkNotNull(string, "null cannot be cast to non-null type T of com.tencent.luggage.sdk.wxa_ktx.WxaMmkvProperty");
            return string;
        }
        if (Intrinsics.areEqual(cls, Long.TYPE) ? true : Intrinsics.areEqual(cls, Long.class)) {
            f0 a19 = this.f124550a.a();
            String name4 = property.getName();
            Object obj4 = this.f124551b;
            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Long");
            return Long.valueOf(a19.getLong(name4, ((Long) obj4).longValue()));
        }
        if (Intrinsics.areEqual(cls, Boolean.TYPE) ? true : Intrinsics.areEqual(cls, Boolean.class)) {
            f0 a26 = this.f124550a.a();
            String name5 = property.getName();
            Object obj5 = this.f124551b;
            Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.Boolean");
            return Boolean.valueOf(a26.getBoolean(name5, ((Boolean) obj5).booleanValue()));
        }
        if (!Intrinsics.areEqual(cls, byte[].class)) {
            if (f124549e.a(this.f124552c).contains(com.tencent.luggage.wxa.fn.b.class)) {
                byte[] b16 = this.f124550a.a().b(property.getName());
                if (b16 == null) {
                    return this.f124551b;
                }
                try {
                    Object newInstance = this.f124552c.newInstance();
                    Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.mm.protobuf.BaseProtoBuf");
                    com.tencent.luggage.wxa.fn.b bVar = (com.tencent.luggage.wxa.fn.b) newInstance;
                    bVar.a(b16);
                    return bVar;
                } catch (Exception unused) {
                    w.b("Luggage.WxaMmkvProperty", "parse pb failed, class:" + this.f124552c.getCanonicalName());
                    return this.f124551b;
                }
            }
            if (!Intrinsics.areEqual(this.f124552c.getSuperclass(), Enum.class) && !Intrinsics.areEqual(this.f124552c.getSuperclass(), Enum.class)) {
                throw new IllegalAccessError("unsupported type:" + this.f124552c);
            }
            f0 a27 = this.f124550a.a();
            String name6 = property.getName();
            Object obj6 = this.f124551b;
            Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type kotlin.Enum<*>");
            String string2 = a27.getString(name6, ((Enum) obj6).name());
            Intrinsics.checkNotNull(string2);
            Enum a28 = e.a(this.f124552c, string2);
            Intrinsics.checkNotNull(a28, "null cannot be cast to non-null type T of com.tencent.luggage.sdk.wxa_ktx.WxaMmkvProperty");
            return a28;
        }
        Object b17 = this.f124550a.a().b(property.getName());
        if (b17 == null) {
            b17 = this.f124551b;
        }
        Intrinsics.checkNotNull(b17, "null cannot be cast to non-null type T of com.tencent.luggage.sdk.wxa_ktx.WxaMmkvProperty");
        return b17;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(String mmkvName, Object defaultValue) {
        this(new k(mmkvName), defaultValue);
        Intrinsics.checkNotNullParameter(mmkvName, "mmkvName");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
    }

    public void a(Object thisRef, KProperty property, Object obj) {
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter(property, "property");
        this.f124553d = thisRef;
        if (obj == null) {
            this.f124550a.a().g(property.getName());
            return;
        }
        Class cls = this.f124552c;
        if (Intrinsics.areEqual(cls, Float.TYPE) ? true : Intrinsics.areEqual(cls, Float.class)) {
            this.f124550a.a().putFloat(property.getName(), ((Float) obj).floatValue());
            return;
        }
        if (Intrinsics.areEqual(cls, Integer.TYPE) ? true : Intrinsics.areEqual(cls, Integer.class)) {
            this.f124550a.a().putInt(property.getName(), ((Integer) obj).intValue());
            return;
        }
        if (Intrinsics.areEqual(cls, String.class)) {
            this.f124550a.a().putString(property.getName(), (String) obj);
            return;
        }
        if (Intrinsics.areEqual(cls, Long.TYPE) ? true : Intrinsics.areEqual(cls, Long.class)) {
            this.f124550a.a().putLong(property.getName(), ((Long) obj).longValue());
            return;
        }
        if (Intrinsics.areEqual(cls, Boolean.TYPE) ? true : Intrinsics.areEqual(cls, Boolean.class)) {
            this.f124550a.a().putBoolean(property.getName(), ((Boolean) obj).booleanValue());
            return;
        }
        if (!Intrinsics.areEqual(cls, byte[].class)) {
            if (f124549e.a(this.f124552c).contains(com.tencent.luggage.wxa.fn.b.class)) {
                this.f124550a.a().a(property.getName(), ((com.tencent.luggage.wxa.fn.b) obj).b());
                return;
            }
            if (!Intrinsics.areEqual(this.f124552c.getSuperclass(), Enum.class) && !Intrinsics.areEqual(this.f124552c.getSuperclass(), Enum.class)) {
                throw new IllegalAccessError("unsupported type:" + this.f124552c);
            }
            this.f124550a.a().putString(property.getName(), ((Enum) obj).name());
            return;
        }
        this.f124550a.a().a(property.getName(), (byte[]) obj);
    }
}
