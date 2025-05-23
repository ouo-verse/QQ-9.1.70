package com.tencent.luggage.wxa.x6;

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
    public static final f f144599a = new f();

    /* renamed from: b, reason: collision with root package name */
    public static final Lazy f144600b;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f144601a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final LinkedList invoke() {
            LinkedList linkedList = new LinkedList();
            linkedList.add(new e());
            linkedList.add(new d());
            linkedList.add(new c());
            linkedList.add(new b());
            linkedList.add(new com.tencent.luggage.wxa.x6.a());
            return linkedList;
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(a.f144601a);
        f144600b = lazy;
    }

    public final List a() {
        return (List) f144600b.getValue();
    }
}
