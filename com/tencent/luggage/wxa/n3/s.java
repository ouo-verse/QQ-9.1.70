package com.tencent.luggage.wxa.n3;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum s {
    NO_SCAN,
    SCANNED,
    CONFIRMED,
    CANCELLED,
    EXPIRED;


    /* renamed from: a, reason: collision with root package name */
    public static final b f135254a = new b(null);

    /* renamed from: b, reason: collision with root package name */
    public static final Lazy f135255b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List a() {
            return (List) s.f135255b.getValue();
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.tencent.luggage.wxa.n3.s.a
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final List invoke() {
                List list;
                list = ArraysKt___ArraysKt.toList(s.values());
                return list;
            }
        });
        f135255b = lazy;
    }
}
