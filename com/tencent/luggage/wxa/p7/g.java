package com.tencent.luggage.wxa.p7;

import com.tencent.luggage.wxa.q9.m;
import com.tencent.luggage.wxa.xn.a;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g extends m implements com.tencent.luggage.wxa.jk.a {

    /* renamed from: p, reason: collision with root package name */
    public static final String[] f137384p;

    /* renamed from: q, reason: collision with root package name */
    public static final a.C6921a f137385q = m.a(g.class);

    /* renamed from: r, reason: collision with root package name */
    public static final String[] f137386r;

    static {
        String[] strArr = {"userName", "versionType"};
        f137384p = strArr;
        String str = " PRIMARY KEY (";
        for (int i3 = 0; i3 < 2; i3++) {
            str = str + ", " + strArr[i3];
        }
        String str2 = str.replaceFirst(",", "") + " )";
        StringBuilder sb5 = new StringBuilder();
        a.C6921a c6921a = f137385q;
        sb5.append(c6921a.f145162e);
        sb5.append(",");
        sb5.append(str2);
        c6921a.f145162e = sb5.toString();
        f137386r = new String[]{com.tencent.luggage.wxa.xn.c.a(c6921a, "WxaCollectionTableV2")};
    }

    public static g a(String str, int i3) {
        g gVar = new g();
        gVar.f138498b = str;
        gVar.f138500d = i3;
        return gVar;
    }

    @Override // com.tencent.luggage.wxa.xn.a
    public a.C6921a b() {
        return f137385q;
    }

    @Override // com.tencent.luggage.wxa.jk.a
    public String[] getKeys() {
        return f137384p;
    }
}
