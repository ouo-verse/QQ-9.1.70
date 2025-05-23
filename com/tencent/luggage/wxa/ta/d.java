package com.tencent.luggage.wxa.ta;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d {
    public static final String a(String str, String str2) {
        if (!str.contains(":") && str.length() >= 1) {
            return str;
        }
        String[] split = str.split(":");
        String str3 = split[0];
        if (str3 != null && str3.length() > 0) {
            return split[0];
        }
        return str2;
    }
}
