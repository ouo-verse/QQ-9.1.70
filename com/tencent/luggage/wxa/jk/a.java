package com.tencent.luggage.wxa.jk;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface a {

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.jk.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6342a {
        public static String a(String[] strArr) {
            String str = " PRIMARY KEY ( ";
            for (String str2 : strArr) {
                str = str + ", " + str2;
            }
            return "," + (str.replaceFirst(",", "") + " )");
        }
    }

    String[] getKeys();
}
