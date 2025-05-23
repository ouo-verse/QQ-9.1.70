package com.tencent.luggage.wxa.ii;

import com.tencent.luggage.wxa.xn.a;

/* compiled from: P */
/* loaded from: classes8.dex */
public class u extends com.tencent.luggage.wxa.q9.j {

    /* renamed from: t, reason: collision with root package name */
    public static final String[] f130591t;

    /* renamed from: u, reason: collision with root package name */
    public static final a.C6921a f130592u = com.tencent.luggage.wxa.q9.j.a(u.class);

    static {
        String[] strArr = {"appId", "versionDesc"};
        f130591t = strArr;
        String str = " PRIMARY KEY (";
        for (int i3 = 0; i3 < 2; i3++) {
            str = str + ", " + strArr[i3];
        }
        String str2 = str.replaceFirst(",", "") + " )";
        StringBuilder sb5 = new StringBuilder();
        a.C6921a c6921a = f130592u;
        sb5.append(c6921a.f145162e);
        sb5.append(",");
        sb5.append(str2);
        c6921a.f145162e = sb5.toString();
    }

    @Override // com.tencent.luggage.wxa.xn.a
    public a.C6921a b() {
        return null;
    }
}
