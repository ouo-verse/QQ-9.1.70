package com.tencent.luggage.wxa.v7;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class h extends com.tencent.luggage.wxa.l3.h {

    /* renamed from: k, reason: collision with root package name */
    public static final a f143309k = new a(null);

    /* renamed from: j, reason: collision with root package name */
    public final com.tencent.luggage.wxa.l3.g[] f143310j;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final h a() {
            com.tencent.luggage.wxa.z4.f a16 = com.tencent.luggage.wxa.z4.f.f146283b.a();
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.luggage.wxaapi.internal.process.WxaSDKProcessManager");
            return (h) a16;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(com.tencent.luggage.wxa.l3.g[] processes) {
        super(processes);
        Intrinsics.checkNotNullParameter(processes, "processes");
        this.f143310j = processes;
    }

    @Override // com.tencent.luggage.wxa.z4.f
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public com.tencent.luggage.wxa.l3.g[] h() {
        return this.f143310j;
    }
}
