package com.tencent.luggage.wxa.x3;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface a extends h {

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.x3.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C6898a {

        /* renamed from: a, reason: collision with root package name */
        public static final C6898a f144554a = new C6898a();

        /* renamed from: b, reason: collision with root package name */
        public static a f144555b;

        public final a a() {
            a aVar = f144555b;
            if (aVar != null) {
                return aVar;
            }
            Intrinsics.throwUninitializedPropertyAccessException("IMPL");
            return null;
        }

        public final void a(a aVar) {
            Intrinsics.checkNotNullParameter(aVar, "<set-?>");
            f144555b = aVar;
        }
    }

    void a();
}
