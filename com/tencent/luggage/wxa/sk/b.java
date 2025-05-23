package com.tencent.luggage.wxa.sk;

import com.tencent.luggage.wxa.q9.p;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xn.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b extends c {

    /* renamed from: h, reason: collision with root package name */
    public static final a f140387h = new a(null);

    /* renamed from: g, reason: collision with root package name */
    public final com.tencent.luggage.wxa.xn.b f140388g;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(com.tencent.luggage.wxa.xn.b db5) {
        super(db5, com.tencent.luggage.wxa.sk.a.f140384p.a(), "WxaUsageHistory", p.f138538j);
        Intrinsics.checkNotNullParameter(db5, "db");
        this.f140388g = db5;
    }

    public final void f(String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        com.tencent.luggage.wxa.sk.a aVar = new com.tencent.luggage.wxa.sk.a();
        aVar.f138544b = appId;
        aVar.f138546d = w0.d();
        w.d("WMPF.WxaUseHistoryStorage", "addUseHistory ret:" + b(aVar));
    }
}
