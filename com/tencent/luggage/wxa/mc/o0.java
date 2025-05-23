package com.tencent.luggage.wxa.mc;

import com.tencent.luggage.wxa.xn.a;

/* compiled from: P */
/* loaded from: classes8.dex */
public class o0 extends com.tencent.luggage.wxa.q9.o implements com.tencent.luggage.wxa.jk.a {

    /* renamed from: t, reason: collision with root package name */
    public static final String[] f134346t;

    /* renamed from: u, reason: collision with root package name */
    public static final a.C6921a f134347u = com.tencent.luggage.wxa.q9.o.a(o0.class);

    /* renamed from: v, reason: collision with root package name */
    public static final String[] f134348v;

    static {
        String[] strArr = {"pluginAppID", "pluginAppVersion"};
        f134346t = strArr;
        String str = " PRIMARY KEY (";
        for (int i3 = 0; i3 < 2; i3++) {
            str = str + ", " + strArr[i3];
        }
        String str2 = str.replaceFirst(",", "") + " )";
        StringBuilder sb5 = new StringBuilder();
        a.C6921a c6921a = f134347u;
        sb5.append(c6921a.f145162e);
        sb5.append(",");
        sb5.append(str2);
        c6921a.f145162e = sb5.toString();
        f134348v = new String[]{com.tencent.luggage.wxa.xn.c.a(c6921a, "WxaPluginCodeVersionInfo")};
    }

    @Override // com.tencent.luggage.wxa.xn.a
    public a.C6921a b() {
        return f134347u;
    }

    @Override // com.tencent.luggage.wxa.jk.a
    public String[] getKeys() {
        return f134346t;
    }
}
