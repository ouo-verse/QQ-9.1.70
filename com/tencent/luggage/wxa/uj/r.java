package com.tencent.luggage.wxa.uj;

import com.tencent.luggage.wxa.tn.f0;
import com.tencent.luggage.wxa.tn.w;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public static final r f142553a = new r();

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f142554b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public static final Lazy f142555c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f142556a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final f0 invoke() {
            return f0.e("MicroMsg.PhoneNumberReporter");
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(a.f142556a);
        f142555c = lazy;
    }

    public final f0 a() {
        Object value = f142555c.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mmKv>(...)");
        return (f0) value;
    }

    public final synchronized void b(String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        f142554b.put(appId, new q(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, null, 268435455, null));
    }

    public final synchronized void c(String appId) {
        boolean z16;
        Intrinsics.checkNotNullParameter(appId, "appId");
        String string = a().getString(appId, "");
        if (string == null) {
            string = "{}";
        }
        if (string.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            f142554b.put(appId, new q(string));
        }
    }

    public final synchronized void d(String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        q a16 = a(appId);
        if (a16 != null) {
            f142553a.a().putString(appId, a16.toString()).commit();
        }
    }

    public final synchronized void e(String appId) {
        String str;
        Intrinsics.checkNotNullParameter(appId, "appId");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("report ");
        q a16 = a(appId);
        if (a16 != null) {
            str = a16.toString();
        } else {
            str = null;
        }
        sb5.append(str);
        w.e("MicroMsg.PhoneNumberReporter", sb5.toString());
        f142554b.remove(appId);
        a().remove(appId).commit();
    }

    public final synchronized q a(String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        return (q) f142554b.get(appId);
    }
}
