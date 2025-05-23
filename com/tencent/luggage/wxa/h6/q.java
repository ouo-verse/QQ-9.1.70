package com.tencent.luggage.wxa.h6;

import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public static final q f126909a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f126910b;

    /* renamed from: c, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.e5.k f126911c;

    /* renamed from: d, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.e5.j f126912d;

    /* renamed from: e, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.e5.j f126913e;

    static {
        q qVar = f126909a;
        f126910b = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(qVar, q.class, "hideSplashCapsule", "getHideSplashCapsule()Z", 0)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(qVar, q.class, "enableDarkMode", "getEnableDarkMode()Z", 0))};
        f126909a = new q();
        com.tencent.luggage.wxa.e5.k kVar = new com.tencent.luggage.wxa.e5.k("Luggage.WxaSetting");
        f126911c = kVar;
        Boolean bool = Boolean.FALSE;
        f126912d = new com.tencent.luggage.wxa.e5.j(kVar, bool);
        f126913e = new com.tencent.luggage.wxa.e5.j(kVar, bool);
    }

    public static final boolean a() {
        return ((Boolean) f126913e.a(f126909a, f126910b[1])).booleanValue();
    }

    public static final boolean b() {
        return ((Boolean) f126912d.a(f126909a, f126910b[0])).booleanValue();
    }
}
