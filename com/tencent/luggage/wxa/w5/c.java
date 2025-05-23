package com.tencent.luggage.wxa.w5;

import com.tencent.luggage.wxa.o3.e;
import com.tencent.luggage.wxa.o3.j;
import com.tencent.luggage.wxa.o3.l;
import com.tencent.luggage.wxa.rc.f;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.y8.h;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f144089a = new c();

    /* renamed from: b, reason: collision with root package name */
    public static final Lazy f144090b;

    /* renamed from: c, reason: collision with root package name */
    public static final Lazy f144091c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f144092a = new a();

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.w5.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6865a implements e.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f144093a;

            public C6865a(long j3) {
                this.f144093a = j3;
            }

            @Override // com.tencent.luggage.wxa.o3.e.a
            public void a(j jVar) {
            }

            @Override // com.tencent.luggage.wxa.o3.e.a
            public void a() {
                w.d("Luggage.WxaMMKVStorageManager", "reset isolated mmkv storage, id:" + this.f144093a);
                f.f139521d.a(this.f144093a).c();
            }
        }

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Long invoke() {
            String replaceFirst$default;
            boolean z16;
            String i3 = z.i();
            Intrinsics.checkNotNullExpressionValue(i3, "getProcessName()");
            String h16 = z.h();
            Intrinsics.checkNotNullExpressionValue(h16, "getPackageName()");
            replaceFirst$default = StringsKt__StringsJVMKt.replaceFirst$default(i3, h16, "", false, 4, (Object) null);
            if (replaceFirst$default.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                replaceFirst$default = ":main";
            }
            StringBuilder sb5 = new StringBuilder();
            l lVar = l.f136139a;
            sb5.append(lVar.h());
            sb5.append(replaceFirst$default);
            Long valueOf = Long.valueOf(new h(new com.tencent.luggage.wxa.o3.h(sb5.toString()).hashCode()).longValue());
            long longValue = valueOf.longValue();
            w.d("Luggage.WxaMMKVStorageManager", "ISOLATE_ID created " + longValue);
            lVar.b(new C6865a(longValue));
            return valueOf;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final b f144094a = new b();

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements e.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f144095a;

            public a(long j3) {
                this.f144095a = j3;
            }

            @Override // com.tencent.luggage.wxa.o3.e.a
            public void a(j jVar) {
            }

            @Override // com.tencent.luggage.wxa.o3.e.a
            public void a() {
                w.d("Luggage.WxaMMKVStorageManager", "reset shared mmkv storage, id:" + this.f144095a);
                f.f139521d.a(this.f144095a).c();
            }
        }

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Long invoke() {
            l lVar = l.f136139a;
            Long valueOf = Long.valueOf(new h(new com.tencent.luggage.wxa.o3.h(lVar.h()).hashCode()).longValue());
            long longValue = valueOf.longValue();
            w.d("Luggage.WxaMMKVStorageManager", "SHARE_ID createdy " + longValue);
            if (z.m()) {
                lVar.b(new a(longValue));
            }
            return valueOf;
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(b.f144094a);
        f144090b = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(a.f144092a);
        f144091c = lazy2;
    }

    public final long a() {
        return ((Number) f144091c.getValue()).longValue();
    }

    public final long b() {
        return ((Number) f144090b.getValue()).longValue();
    }

    public static final f a(String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        if (l.f136139a.d()) {
            return f.f139521d.a(f144089a.b());
        }
        return f.f139521d.a(f144089a.a());
    }
}
