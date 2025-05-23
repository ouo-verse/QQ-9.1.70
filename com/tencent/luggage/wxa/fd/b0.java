package com.tencent.luggage.wxa.fd;

import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    public static final b0 f125700a = new b0();

    /* renamed from: b, reason: collision with root package name */
    public static final String f125701b = "Luggage.RequirePrivateInfoLogic";

    /* renamed from: c, reason: collision with root package name */
    public static final Lazy f125702c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f125703d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f125704a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.tn.f0 invoke() {
            return com.tencent.luggage.wxa.tn.f0.e(b0.f125701b);
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(a.f125704a);
        f125702c = lazy;
        f125703d = "%s_private_infos";
    }

    public final com.tencent.luggage.wxa.tn.f0 b() {
        return (com.tencent.luggage.wxa.tn.f0) f125702c.getValue();
    }

    public final int a(String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        com.tencent.luggage.wxa.tn.f0 b16 = b();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(f125703d, Arrays.copyOf(new Object[]{appId}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        int a16 = b16.a(format, 0);
        com.tencent.luggage.wxa.tn.w.d(f125701b, "getExtFlag %s, %d", appId, Integer.valueOf(a16));
        return a16;
    }
}
