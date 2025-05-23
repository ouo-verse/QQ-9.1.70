package com.tencent.luggage.wxa.y6;

import java.util.LinkedList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f145437a = new f();

    /* renamed from: b, reason: collision with root package name */
    public static final Lazy f145438b;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f145439a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final LinkedList invoke() {
            LinkedList linkedList = new LinkedList();
            linkedList.add(new e());
            linkedList.add(new com.tencent.luggage.wxa.y6.a());
            linkedList.add(new d());
            linkedList.add(new c());
            return linkedList;
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(a.f145439a);
        f145438b = lazy;
    }

    public final List a() {
        return (List) f145438b.getValue();
    }
}
