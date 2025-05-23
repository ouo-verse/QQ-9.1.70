package com.tencent.luggage.wxa.c3;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.hippy.qq.api.TabPreloadItem;
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
public final class a extends k0 {
    public static final int CTRL_INDEX = 75;

    @NotNull
    public static final String NAME = "onShareAppMessage";

    /* renamed from: a, reason: collision with root package name */
    public final Map f123237a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f123238b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f123239c;

    /* renamed from: d, reason: collision with root package name */
    public final Map f123240d;

    /* renamed from: e, reason: collision with root package name */
    public final Map f123241e;

    /* renamed from: f, reason: collision with root package name */
    public final Map f123242f;

    /* renamed from: g, reason: collision with root package name */
    public final Map f123243g;

    /* renamed from: h, reason: collision with root package name */
    public final Map f123244h;

    /* renamed from: i, reason: collision with root package name */
    public final Map f123245i;

    /* renamed from: j, reason: collision with root package name */
    public final Map f123246j;

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f123236l = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "title", "getTitle()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "desc", "getDesc()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "path", "getPath()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "webViewUrl", "getWebViewUrl()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "imgUrl", "getImgUrl()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "mode", "getMode()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, TabPreloadItem.TAB_NAME_DYNAMIC, "getDynamic()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "itemID", "getItemID()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, TtmlNode.ATTR_TTS_ORIGIN, "getOrigin()Ljava/lang/String;", 0))};

    /* renamed from: k, reason: collision with root package name */
    public static final C6090a f123235k = new C6090a(null);

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.c3.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6090a {
        public C6090a() {
        }

        public /* synthetic */ C6090a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public static final b f123247a = new b();

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
        withDefaultMutable = MapsKt__MapWithDefaultKt.withDefaultMutable(new HashMap(), b.f123247a);
        this.f123237a = withDefaultMutable;
        this.f123238b = withDefaultMutable;
        this.f123239c = withDefaultMutable;
        this.f123240d = withDefaultMutable;
        this.f123241e = withDefaultMutable;
        this.f123242f = withDefaultMutable;
        this.f123243g = withDefaultMutable;
        this.f123244h = withDefaultMutable;
        this.f123245i = withDefaultMutable;
        this.f123246j = withDefaultMutable;
    }

    public final void a(boolean z16) {
        Map map = this.f123244h;
        KProperty kProperty = f123236l[6];
        map.put(kProperty.getName(), Boolean.valueOf(z16));
    }

    public final void b(String str) {
        this.f123239c.put(f123236l[1].getName(), str);
    }

    public final void c(String str) {
        this.f123242f.put(f123236l[4].getName(), str);
    }

    public final void d(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f123243g.put(f123236l[5].getName(), str);
    }

    @Override // com.tencent.luggage.wxa.xd.k0
    public void dispatch() {
        setData(this.f123237a);
        w.d("Luggage.WXA.EventOnShareAppMessage", "dispatch with src:" + getSrc() + ", dest:" + getDest() + ", data:" + getData());
        super.dispatch();
    }

    public final void e(String str) {
        this.f123246j.put(f123236l[8].getName(), str);
    }

    public final void f(String str) {
        this.f123240d.put(f123236l[2].getName(), str);
    }

    public final void g(String str) {
        this.f123238b.put(f123236l[0].getName(), str);
    }

    public final void h(String str) {
        this.f123241e.put(f123236l[3].getName(), str);
    }

    public final void a(int i3) {
        Map map = this.f123245i;
        KProperty kProperty = f123236l[7];
        map.put(kProperty.getName(), Integer.valueOf(i3));
    }
}
