package com.tencent.luggage.wxa.b7;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.p;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.MapsKt__MapWithDefaultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a extends p {
    public static final int CTRL_INDEX = 799;

    @NotNull
    public static final String NAME = "onAddToFavorites";

    /* renamed from: a, reason: collision with root package name */
    public final Map f121890a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f121891b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f121892c;

    /* renamed from: d, reason: collision with root package name */
    public final Map f121893d;

    /* renamed from: e, reason: collision with root package name */
    public final Map f121894e;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f121889g = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "title", "getTitle()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "path", "getPath()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "webViewUrl", "getWebViewUrl()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "itemID", "getItemID()I", 0))};

    /* renamed from: f, reason: collision with root package name */
    public static final C6034a f121888f = new C6034a(null);

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.b7.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6034a {
        public C6034a() {
        }

        public /* synthetic */ C6034a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public static final b f121895a = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return null;
        }
    }

    public a() {
        Map withDefaultMutable;
        withDefaultMutable = MapsKt__MapWithDefaultKt.withDefaultMutable(new HashMap(), b.f121895a);
        this.f121890a = withDefaultMutable;
        this.f121891b = withDefaultMutable;
        this.f121892c = withDefaultMutable;
        this.f121893d = withDefaultMutable;
        this.f121894e = withDefaultMutable;
    }

    public final void a(int i3) {
        Map map = this.f121894e;
        KProperty kProperty = f121889g[3];
        map.put(kProperty.getName(), Integer.valueOf(i3));
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f121892c.put(f121889g[1].getName(), str);
    }

    public final void d(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f121891b.put(f121889g[0].getName(), str);
    }

    @Override // com.tencent.luggage.wxa.xd.k0
    public void dispatch() {
        setData(this.f121890a);
        w.d("Luggage.WXA.EventOnAddToFavorites", "dispatch with src:" + getSrc() + ", dest:" + getDest() + ", data:" + getData());
        super.dispatch();
    }

    public final void e(String str) {
        this.f121893d.put(f121889g[2].getName(), str);
    }
}
