package com.tencent.luggage.wxa.yi;

import android.net.Network;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class w implements y {

    /* renamed from: a, reason: collision with root package name */
    public static final w f145969a = new w();

    /* renamed from: b, reason: collision with root package name */
    public static final Lazy f145970b;

    /* renamed from: c, reason: collision with root package name */
    public static final Lazy f145971c;

    /* renamed from: d, reason: collision with root package name */
    public static final Lazy f145972d;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f145973a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Method invoke() {
            Class b16 = w.f145969a.b();
            if (b16 == null) {
                return null;
            }
            try {
                Class<?> cls = Integer.TYPE;
                return b16.getDeclaredMethod("bindSocketToNetwork", cls, cls);
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.BindSocketToNetworkBelowApi23Ability", "reflect bindSocketToNetworkMethod fail since " + e16);
                return null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final b f145974a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Class invoke() {
            try {
                return Class.forName("android.net.NetworkUtils");
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.BindSocketToNetworkBelowApi23Ability", "reflect networkUtilsClass fail since " + e16);
                return null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class c extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final c f145975a = new c();

        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            Class b16 = w.f145969a.b();
            if (b16 == null) {
                return null;
            }
            try {
                return b16.newInstance();
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.BindSocketToNetworkBelowApi23Ability", "new networkUtils fail since " + e16);
                return null;
            }
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(b.f145974a);
        f145970b = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(c.f145975a);
        f145971c = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(a.f145973a);
        f145972d = lazy3;
    }

    public final Class b() {
        return (Class) f145970b.getValue();
    }

    public final Object c() {
        return f145971c.getValue();
    }

    public final Method a() {
        return (Method) f145972d.getValue();
    }

    @Override // com.tencent.luggage.wxa.yi.y
    public boolean a(int i3, Network network) {
        Method a16;
        Intrinsics.checkNotNullParameter(network, "network");
        Object c16 = c();
        if (c16 == null || (a16 = a()) == null) {
            return false;
        }
        try {
            Object invoke = a16.invoke(c16, Integer.valueOf(i3), Integer.valueOf(a(network)));
            Integer num = invoke instanceof Integer ? (Integer) invoke : null;
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.BindSocketToNetworkBelowApi23Ability", "doBind, bindRet: " + num);
            if (num == null) {
                return false;
            }
            return num.intValue() == 0;
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.BindSocketToNetworkBelowApi23Ability", "call bindSocketToNetworkMethod fail since " + e16);
            return false;
        }
    }

    public final int a(Network network) {
        return network.hashCode() / 11;
    }
}
