package com.tencent.luggage.wxa.o3;

import android.util.Log;
import com.tencent.luggage.wxa.o3.e;
import com.tencent.luggage.wxa.tn.f0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.apache.commons.lang.StringUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class l implements e {

    /* renamed from: a, reason: collision with root package name */
    public static final l f136139a = new l();

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f136140b = new byte[0];

    /* renamed from: c, reason: collision with root package name */
    public static e f136141c;

    /* renamed from: d, reason: collision with root package name */
    public static final Lazy f136142d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f136143a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final f0 invoke() {
            return f0.c("Luggage.AccountManager", 2);
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(a.f136143a);
        f136142d = lazy;
    }

    public final void a(e eVar) {
        synchronized (f136140b) {
            f136141c = eVar;
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.luggage.wxa.o3.e
    public void b(e.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        e j3 = j();
        if (j3 != null) {
            j3.b(callback);
        }
    }

    @Override // com.tencent.luggage.wxa.o3.e
    public boolean c() {
        boolean z16;
        e j3 = j();
        if (j3 != null) {
            z16 = j3.c();
        } else {
            z16 = false;
        }
        w.d("Luggage.AccountManager", "hasLogin impl:" + f136139a.j() + ", ret:" + z16);
        return z16;
    }

    @Override // com.tencent.luggage.wxa.o3.e
    public boolean d() {
        e j3 = j();
        if (j3 != null) {
            return j3.d();
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.o3.e
    public String e() {
        String e16;
        e j3 = j();
        if (j3 == null || (e16 = j3.e()) == null) {
            return "";
        }
        return e16;
    }

    @Override // com.tencent.luggage.wxa.o3.e
    public boolean f() {
        long a16 = w0.a();
        e j3 = j();
        if (j3 != null) {
            return j3.f();
        }
        w.d("Luggage.AccountManager", "refreshSessionInfoSync ret[false] cost[" + (w0.a() - a16) + "ms]");
        return false;
    }

    public final String g() {
        boolean z16;
        String string = i().getString("Luggage.AccountManager.deviceId", "");
        if (string != null && string.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            string = StringUtils.substring("LU" + com.tencent.luggage.wxa.s5.a.a(), 0, 16);
            w.a("Luggage.AccountManager", "generated luggage deviceId: " + string);
            i().putString("Luggage.AccountManager.deviceId", string);
        } else {
            w.a("Luggage.AccountManager", "get saved luggage deviceId: " + string);
        }
        Intrinsics.checkNotNull(string);
        return string;
    }

    public final String h() {
        return g();
    }

    public final f0 i() {
        return (f0) f136142d.getValue();
    }

    public final e j() {
        e eVar;
        synchronized (f136140b) {
            if (f136141c == null) {
                f136141c = new i();
            }
            eVar = f136141c;
        }
        return eVar;
    }

    @Override // com.tencent.luggage.wxa.o3.e
    public void b() {
        w.d("Luggage.AccountManager", "logout: [%s]", Log.getStackTraceString(new Throwable()));
        e j3 = j();
        if (j3 != null) {
            j3.b();
        }
    }

    @Override // com.tencent.luggage.wxa.o3.e
    public void a(boolean z16) {
        e j3 = j();
        if (j3 != null) {
            j3.a(z16);
        }
    }

    @Override // com.tencent.luggage.wxa.o3.e
    public j a() {
        e j3 = j();
        if (j3 != null) {
            return j3.a();
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.o3.e
    public void a(e.b logic, e.c cVar) {
        Intrinsics.checkNotNullParameter(logic, "logic");
        e j3 = j();
        if (j3 != null) {
            j3.a(logic, cVar);
        }
    }

    @Override // com.tencent.luggage.wxa.o3.e
    public void a(e.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        e j3 = j();
        if (j3 != null) {
            j3.a(callback);
        }
    }

    @Override // com.tencent.luggage.wxa.o3.e
    public void a(j jVar) {
        e j3 = j();
        if (j3 != null) {
            j3.a(jVar);
        }
    }
}
