package com.tencent.luggage.wxa.qe;

import java.util.UUID;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {
    public static UUID a(String str) {
        int length = str.length();
        if (length == 4) {
            str = "0000" + str + "-0000-1000-8000-00805F9B34FB";
        } else if (length == 8) {
            str = str + "-0000-1000-8000-00805F9B34FB";
        } else if (length != 36) {
            throw new IllegalArgumentException("Invalid UUID name: " + str);
        }
        return UUID.fromString(str);
    }
}
