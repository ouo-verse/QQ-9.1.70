package com.tencent.luggage.wxa.nj;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface e {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f135856a;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.nj.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6518a extends a {

            /* renamed from: b, reason: collision with root package name */
            public static final C6518a f135857b = new C6518a();

            public C6518a() {
                super(11, null);
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b extends a {

            /* renamed from: b, reason: collision with root package name */
            public static final b f135858b = new b();

            public b() {
                super(10, null);
            }
        }

        public /* synthetic */ a(int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3);
        }

        public final int a() {
            return this.f135856a;
        }

        public a(int i3) {
            this.f135856a = i3;
        }
    }

    i a();

    boolean a(com.tencent.luggage.wxa.ic.g gVar, String str, Runnable runnable);

    a b();
}
