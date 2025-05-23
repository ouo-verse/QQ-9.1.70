package com.tencent.luggage.wxa.uk;

import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.tianshu.ui.RedTouch;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class w {

    /* renamed from: a, reason: collision with root package name */
    public static final String[][] f142785a = {new String[]{"\\", "\\\\"}, new String[]{"'", "\\'"}, new String[]{"\"", "\\\""}, new String[]{"\n", RedTouch.NEWLINE_CHAR}, new String[]{"\t", "\\t"}, new String[]{"\b", "\\b"}, new String[]{"\f", "\\f"}, new String[]{"\r", "\\r"}, new String[]{"\u2028", "\\u2028"}, new String[]{"\u2029", "\\u2029"}};

    public static String a(String str) {
        if (w0.c(str)) {
            return str;
        }
        for (String[] strArr : f142785a) {
            str = str.replace(strArr[0], strArr[1]);
        }
        return str;
    }
}
