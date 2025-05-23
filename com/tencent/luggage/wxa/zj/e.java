package com.tencent.luggage.wxa.zj;

import com.tencent.luggage.wxa.tn.w;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class e {
    public static String a(Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            if (objArr.length == 1) {
                return String.valueOf(objArr[0]);
            }
            StringBuilder sb5 = new StringBuilder();
            int length = objArr.length - 1;
            for (int i3 = 0; i3 < length; i3++) {
                sb5.append(String.valueOf(objArr[i3]).replace(',', TokenParser.SP));
                sb5.append(',');
            }
            sb5.append(String.valueOf(objArr[length]));
            return sb5.toString();
        }
        w.f("Luggage.KVReportStringUtils", "vals is null, use '' as value");
        return "";
    }
}
