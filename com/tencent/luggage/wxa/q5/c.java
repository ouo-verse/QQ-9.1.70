package com.tencent.luggage.wxa.q5;

import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f137855a = new c();

    /* renamed from: b, reason: collision with root package name */
    public static final Lazy f137856b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f137857a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return new File(com.tencent.luggage.wxa.db.a.f124168a, "CodeCache").getAbsolutePath();
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(a.f137857a);
        f137856b = lazy;
    }

    public final String a() {
        File file = new File(b());
        file.mkdirs();
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "File(PATH).apply { mkdirs() }.absolutePath");
        return absolutePath;
    }

    public final String b() {
        Object value = f137856b.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-PATH>(...)");
        return (String) value;
    }
}
