package com.tencent.luggage.wxa.r4;

import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f139215a = new k();

    /* renamed from: b, reason: collision with root package name */
    public static final Lazy f139216b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f139217a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(com.tencent.luggage.wxa.im.a.b().a("clicfg_android_appbrand_js_context_interface_share_use_object", true));
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(a.f139217a);
        f139216b = lazy;
    }

    public final boolean a() {
        return ((Boolean) f139216b.getValue()).booleanValue();
    }

    public i a(com.tencent.luggage.wxa.ic.l env, com.tencent.luggage.wxa.ei.t contextManager) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(contextManager, "contextManager");
        return a() ? new l(env, contextManager) : new j(contextManager);
    }
}
