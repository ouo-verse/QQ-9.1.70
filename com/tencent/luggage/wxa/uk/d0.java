package com.tencent.luggage.wxa.uk;

import com.tencent.mobileqq.tianshu.ui.RedTouch;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d0 {
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        return str.replace("\u2028", RedTouch.NEWLINE_CHAR).replace("\u2029", RedTouch.NEWLINE_CHAR);
    }

    public static boolean a(String str, String str2) {
        return com.tencent.luggage.wxa.h6.o.a(str, str2);
    }
}
