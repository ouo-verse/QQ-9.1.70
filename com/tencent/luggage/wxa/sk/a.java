package com.tencent.luggage.wxa.sk;

import com.tencent.luggage.wxa.q9.p;
import com.tencent.luggage.wxa.xn.a;
import com.tencent.luggage.wxa.xn.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a extends p {

    /* renamed from: p, reason: collision with root package name */
    public static final C6721a f140384p = new C6721a(null);

    /* renamed from: q, reason: collision with root package name */
    public static final a.C6921a f140385q;

    /* renamed from: r, reason: collision with root package name */
    public static final String[] f140386r;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.sk.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6721a {
        public C6721a() {
        }

        public /* synthetic */ C6721a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a.C6921a a() {
            return a.f140385q;
        }
    }

    static {
        a.C6921a a16 = p.a(p.class);
        Intrinsics.checkNotNullExpressionValue(a16, "initAutoDBInfo(BaseWxaUsageHistory::class.java)");
        f140385q = a16;
        String a17 = c.a(a16, "WxaUsageHistory");
        Intrinsics.checkNotNullExpressionValue(a17, "getCreateSQLs(INFO, TABLE_NAME)");
        f140386r = new String[]{a17};
    }

    @Override // com.tencent.luggage.wxa.xn.a
    public a.C6921a b() {
        return f140385q;
    }
}
