package com.tencent.luggage.wxa.c3;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.k0;
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
public final class b extends k0 {
    public static final int CTRL_INDEX = 76;

    @NotNull
    public static final String NAME = "onShareTimeline";

    /* renamed from: a, reason: collision with root package name */
    public final Map f123250a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f123251b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f123252c;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f123249e = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(b.class, "title", "getTitle()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(b.class, "path", "getPath()Ljava/lang/String;", 0))};

    /* renamed from: d, reason: collision with root package name */
    public static final a f123248d = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.c3.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6091b extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public static final C6091b f123253a = new C6091b();

        public C6091b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return null;
        }
    }

    public b() {
        Map withDefaultMutable;
        withDefaultMutable = MapsKt__MapWithDefaultKt.withDefaultMutable(new HashMap(), C6091b.f123253a);
        this.f123250a = withDefaultMutable;
        this.f123251b = withDefaultMutable;
        this.f123252c = withDefaultMutable;
    }

    public final void b(String str) {
        this.f123252c.put(f123249e[1].getName(), str);
    }

    public final void c(String str) {
        this.f123251b.put(f123249e[0].getName(), str);
    }

    @Override // com.tencent.luggage.wxa.xd.k0
    public void dispatch() {
        setData(this.f123250a);
        w.d("Luggage.WXA.EventOnShareTimeline", "dispatch with src:" + getSrc() + ", dest:" + getDest() + ", data:" + getData());
        super.dispatch();
    }
}
