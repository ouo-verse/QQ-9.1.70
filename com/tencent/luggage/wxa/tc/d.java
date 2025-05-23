package com.tencent.luggage.wxa.tc;

import com.tencent.luggage.wxa.xn.a;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends com.tencent.luggage.wxa.q9.a {
    public static a.C6921a J = com.tencent.luggage.wxa.q9.a.a(d.class);
    public static final String[] K;

    static {
        String[] strArr = {"username", "fetchType"};
        K = strArr;
        String str = " PRIMARY KEY ( ";
        for (int i3 = 0; i3 < 2; i3++) {
            str = str + ", " + strArr[i3];
        }
        String str2 = str.replaceFirst(",", "") + " )";
        StringBuilder sb5 = new StringBuilder();
        a.C6921a c6921a = J;
        sb5.append(c6921a.f145162e);
        sb5.append(",");
        sb5.append(str2);
        c6921a.f145162e = sb5.toString();
    }

    @Override // com.tencent.luggage.wxa.xn.a
    public a.C6921a b() {
        return J;
    }
}
