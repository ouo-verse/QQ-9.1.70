package com.tencent.luggage.wxa.bk;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import org.apache.commons.lang.StringUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class j {
    public static String a(String str) {
        if (w0.c(str)) {
            return "";
        }
        try {
            return w0.d(com.tencent.luggage.wxa.aa.m.a(str));
        } catch (Exception e16) {
            w.b("MicroMsg.AppBrand.ReportUtil", "safeEncode, given %s, e %s", str, e16);
            return "";
        }
    }

    public static Object[] a(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return new Object[0];
        }
        Object[] objArr2 = new Object[objArr.length];
        int length = objArr.length;
        int i3 = 0;
        int i16 = 0;
        while (i3 < length) {
            Object obj = objArr[i3];
            if (obj == null) {
                obj = "";
            } else if (obj instanceof String) {
                String str = (String) obj;
                if (str.contains(",")) {
                    obj = a(str);
                }
                obj = StringUtils.substring((String) obj, 0, 1024);
            }
            objArr2[i16] = String.valueOf(obj);
            i3++;
            i16++;
        }
        return objArr2;
    }
}
