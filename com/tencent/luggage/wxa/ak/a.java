package com.tencent.luggage.wxa.ak;

import com.tencent.luggage.wxa.q9.k;
import com.tencent.luggage.wxa.xn.a;
import com.tencent.luggage.wxa.xn.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a extends k {

    /* renamed from: r, reason: collision with root package name */
    public static final C6020a f121549r = new C6020a(null);

    /* renamed from: s, reason: collision with root package name */
    public static final a.C6921a f121550s;

    /* renamed from: t, reason: collision with root package name */
    public static final String[] f121551t;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ak.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6020a {
        public C6020a() {
        }

        public /* synthetic */ C6020a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a.C6921a a() {
            return a.f121550s;
        }
    }

    static {
        a.C6921a a16 = k.a(k.class);
        Intrinsics.checkNotNullExpressionValue(a16, "initAutoDBInfo(BaseRecommendWxaList::class.java)");
        f121550s = a16;
        String a17 = c.a(a16, "RecommendWxaList");
        Intrinsics.checkNotNullExpressionValue(a17, "getCreateSQLs(INFO,\n    \u2026 TABLE_NAME\n            )");
        f121551t = new String[]{a17};
    }
}
