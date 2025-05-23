package com.tencent.luggage.wxa.mo;

import android.content.Context;
import android.view.LayoutInflater;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f implements d {

    /* renamed from: a, reason: collision with root package name */
    public static final f f134788a = new f();

    /* renamed from: b, reason: collision with root package name */
    public static final Lazy f134789b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f134790a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final d invoke() {
            d dVar = (d) com.tencent.luggage.wxa.eo.g.a(d.class);
            if (dVar == null) {
                return c.f134787a;
            }
            return dVar;
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) a.f134790a);
        f134789b = lazy;
    }

    public final d a() {
        return (d) f134789b.getValue();
    }

    @Override // com.tencent.luggage.wxa.mo.d
    public LayoutInflater h(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return a().h(context);
    }
}
