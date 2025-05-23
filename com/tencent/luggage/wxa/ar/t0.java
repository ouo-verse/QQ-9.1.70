package com.tencent.luggage.wxa.ar;

import android.content.Context;
import java.util.regex.Matcher;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class t0 {
    public static String a(Context context, int i3, String str, String str2) {
        String a16 = p0.a(context, "xweb_error_page.html");
        if (a16 != null) {
            return a16.replaceAll("placeholder_errorCode", i3 + "").replaceAll("placeholder_description", Matcher.quoteReplacement(str)).replaceAll("placeholder_failingUrl", Matcher.quoteReplacement(str2));
        }
        return a16;
    }
}
