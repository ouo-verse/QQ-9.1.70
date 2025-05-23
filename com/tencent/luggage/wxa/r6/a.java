package com.tencent.luggage.wxa.r6;

import com.tencent.luggage.wxa.tn.w;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final C6676a f139267a = new C6676a(null);

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.r6.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6676a {
        public C6676a() {
        }

        public /* synthetic */ C6676a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public abstract int a();

    public final boolean a(String str) {
        return true;
    }

    public boolean b() {
        return false;
    }

    public final void c() {
        if (w.d() <= 0) {
            w.a("Luggage.AbstractReportStruct", "report id:" + a() + " value:" + d());
        }
        boolean z16 = com.tencent.luggage.wxa.tn.e.f141559a;
        com.tencent.luggage.wxa.zj.f.f146728a.a(a(), d(), !b(), z16, z16);
    }

    public abstract String d();

    public final boolean a(String str, long j3) {
        return true;
    }

    public final boolean b(String str, long j3) {
        return true;
    }

    public final String a(String str, String str2, boolean z16) {
        boolean contains$default;
        String replace$default;
        if (str2 == null || str2.length() == 0) {
            return str2;
        }
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) ",", false, 2, (Object) null);
        if (!contains$default) {
            return str2;
        }
        if (!com.tencent.luggage.wxa.tn.e.f141559a) {
            replace$default = StringsKt__StringsJVMKt.replace$default(str2, ',', TokenParser.SP, false, 4, (Object) null);
            return replace$default;
        }
        throw new IllegalStateException(("value contain comma, please confirm your logic.log id:" + a() + " field:" + str + " value:" + str2).toString());
    }
}
