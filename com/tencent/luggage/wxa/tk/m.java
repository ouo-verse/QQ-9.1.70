package com.tencent.luggage.wxa.tk;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class m {
    public static String a(Object obj) {
        Object obj2;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Token@");
        if (obj != null) {
            obj2 = Integer.valueOf(obj.hashCode());
        } else {
            obj2 = "null";
        }
        sb5.append(obj2);
        return sb5.toString();
    }
}
