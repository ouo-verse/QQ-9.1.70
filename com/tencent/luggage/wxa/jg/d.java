package com.tencent.luggage.wxa.jg;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends com.tencent.luggage.wxa.jg.c {

    /* renamed from: b, reason: collision with root package name */
    public static final c f131070b = new c(null);

    /* renamed from: c, reason: collision with root package name */
    public static final Lazy f131071c;

    /* renamed from: d, reason: collision with root package name */
    public static final Lazy f131072d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f131073a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List invoke() {
            List listOf;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new d0[]{new b0(), new y()});
            return listOf;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final b f131074a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Map invoke() {
            Map mapOf;
            a0 a0Var = new a0();
            e0 e0Var = new e0();
            z zVar = new z();
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(a0Var.a(), a0Var), TuplesKt.to(e0Var.a(), e0Var), TuplesKt.to(zVar.a(), zVar));
            return mapOf;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c {
        public c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List a() {
            return (List) d.f131071c.getValue();
        }

        public final Map b() {
            return (Map) d.f131072d.getValue();
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(a.f131073a);
        f131071c = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(b.f131074a);
        f131072d = lazy2;
    }

    @Override // com.tencent.luggage.wxa.jg.c
    public Map a(String type, com.tencent.luggage.wxa.ic.d component) {
        Map a16;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(component, "component");
        Iterator it = f131070b.a().iterator();
        while (it.hasNext()) {
            Map a17 = ((d0) it.next()).a(type, component);
            if (a17 != null) {
                return a17;
            }
        }
        c0 c0Var = (c0) f131070b.b().get(type);
        return (c0Var == null || (a16 = c0Var.a(type, component)) == null) ? super.a(type, (com.tencent.luggage.wxa.xd.d) component) : a16;
    }
}
