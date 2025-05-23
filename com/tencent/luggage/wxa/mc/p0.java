package com.tencent.luggage.wxa.mc;

import android.database.Cursor;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class p0 extends com.tencent.luggage.wxa.jk.b {

    /* renamed from: i, reason: collision with root package name */
    public static final a f134350i = new a(null);

    /* renamed from: j, reason: collision with root package name */
    public static final String[] f134351j = o0.f134348v;

    /* renamed from: h, reason: collision with root package name */
    public final com.tencent.luggage.wxa.xn.b f134352h;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function0 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o0 f134354b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(o0 o0Var) {
            super(0);
            this.f134354b = o0Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            boolean a16;
            if (p0.this.a(this.f134354b)) {
                a16 = p0.this.c(this.f134354b, new String[0]);
            } else {
                a16 = p0.this.a((com.tencent.luggage.wxa.xn.a) this.f134354b);
            }
            return Boolean.valueOf(a16);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p0(com.tencent.luggage.wxa.xn.b db5) {
        super(db5, o0.f134347u, "WxaPluginCodeVersionInfo", com.tencent.luggage.wxa.q9.o.f138521m);
        Intrinsics.checkNotNullParameter(db5, "db");
        this.f134352h = db5;
    }

    public final boolean b(o0 o0Var) {
        return ((Boolean) a(new b(o0Var))).booleanValue();
    }

    public final void a(String id5, int i3, String str) {
        Intrinsics.checkNotNullParameter(id5, "id");
        if (str == null) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.WxaPluginCodeVersionInfoStorage", "setPluginStringVersion with id:" + id5 + ", version:" + i3 + ", invalid stringVersion");
            return;
        }
        o0 o0Var = new o0();
        o0Var.f138528b = id5;
        o0Var.f138530d = i3;
        o0Var.f138532f = str;
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaPluginCodeVersionInfoStorage", "setPluginStringVersion id:" + id5 + " version:" + i3 + " stringVersion:" + str + " updated:" + b(o0Var));
    }

    public final Object a(Function0 function0) {
        long b16 = this.f134352h.b(Thread.currentThread().getId());
        try {
            return function0.invoke();
        } finally {
            this.f134352h.a(b16);
        }
    }

    public final boolean a(o0 o0Var) {
        boolean z16 = false;
        Cursor a16 = this.f134352h.a("select count(*) from " + d() + " where pluginAppID=? and pluginAppVersion=?", new String[]{o0Var.f138528b, String.valueOf(o0Var.f138530d)});
        if (a16 != null) {
            try {
                if (a16.moveToFirst()) {
                    if (a16.getInt(0) > 0) {
                        z16 = true;
                    }
                }
                CloseableKt.closeFinally(a16, null);
            } finally {
            }
        }
        return z16;
    }
}
