package com.tencent.luggage.wxa.uj;

import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public static final n f142511a = new n();

    /* renamed from: b, reason: collision with root package name */
    public static final Lazy f142512b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f142513a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final i invoke() {
            i iVar = (i) com.tencent.luggage.wxa.eo.g.a(i.class);
            if (iVar == null) {
                return new h();
            }
            return iVar;
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) a.f142513a);
        f142512b = lazy;
    }

    public final i a() {
        return (i) f142512b.getValue();
    }

    public final i b() {
        return a();
    }
}
