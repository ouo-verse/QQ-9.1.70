package com.tencent.luggage.wxa.t4;

import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.tn.y;
import java.io.File;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a implements b {

    /* renamed from: d, reason: collision with root package name */
    public static final C6733a f140844d = new C6733a(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f140845a;

    /* renamed from: b, reason: collision with root package name */
    public final String f140846b;

    /* renamed from: c, reason: collision with root package name */
    public String f140847c;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.t4.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6733a {
        public C6733a() {
        }

        public /* synthetic */ C6733a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(String uin, String appId) {
        boolean endsWith$default;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(appId, "appId");
        this.f140845a = uin;
        this.f140846b = appId;
        this.f140847c = "";
        v a16 = v.a(new File(com.tencent.luggage.wxa.db.a.i()));
        if (a16 != null) {
            String g16 = a16.g();
            Intrinsics.checkNotNullExpressionValue(g16, "cacheRootDir.absolutePath");
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(g16, "/", false, 2, null);
            if (!endsWith$default) {
                g16 = g16 + '/';
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(g16);
            sb5.append(y.a(uin + '#' + appId));
            String sb6 = sb5.toString();
            this.f140847c = sb6;
            if (!new v(sb6).e()) {
                x.m(this.f140847c);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.t4.b
    public String m() {
        return this.f140847c;
    }
}
