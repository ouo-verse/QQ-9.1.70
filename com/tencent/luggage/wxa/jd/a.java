package com.tencent.luggage.wxa.jd;

import com.tencent.luggage.wxa.aa.e;
import com.tencent.luggage.wxa.tn.w;
import java.net.URLDecoder;
import java.net.URLEncoder;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {
    public static String a(String str) {
        String str2;
        if (!e.a("appbrand")) {
            w.b("MicroMsg.DesensitizationUtil", "appbrand delivery is not installed");
            return "";
        }
        try {
            str2 = URLDecoder.decode(str);
        } catch (Exception unused) {
            str2 = str;
        }
        int indexOf = str2.indexOf(63);
        if (indexOf < 0) {
            return "";
        }
        String substring = str2.substring(indexOf + 1);
        String a16 = com.tencent.luggage.wxa.q0.a.a(substring, 1, 2);
        String encode = URLEncoder.encode(a16);
        w.a("MicroMsg.DesensitizationUtil", "original pagePath: %s\ndecoded pagePath: %s\noriginal query: %s\ndesensitized query: %s\nencoded query: %s", str, str2, substring, a16, encode);
        return encode;
    }
}
