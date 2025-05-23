package com.tencent.luggage.wxa.xg;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f144928a = true;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f144929b = true;

    /* renamed from: c, reason: collision with root package name */
    public static final Function1 f144930c = a.f144931a;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f144931a = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return null;
        }
    }

    public static final boolean a() {
        return f144928a;
    }

    public static final boolean b() {
        return f144929b;
    }
}
