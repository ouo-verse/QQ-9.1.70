package com.tencent.luggage.wxa.v2;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum f implements e {
    IMAGE(1),
    VIDEO(2);


    /* renamed from: b, reason: collision with root package name */
    public static final a f143008b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final int f143012a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    f(int i3) {
        this.f143012a = i3;
    }

    @Override // com.tencent.luggage.wxa.v2.e
    public /* synthetic */ boolean a(int i3) {
        return i41.a.a(this, i3);
    }

    @Override // com.tencent.luggage.wxa.v2.e
    public /* bridge */ /* synthetic */ String getName() {
        return name();
    }

    @Override // com.tencent.luggage.wxa.v2.e
    public int a() {
        return this.f143012a;
    }
}
