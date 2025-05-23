package com.tencent.luggage.wxa.m6;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.y;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class j {
    public static String a(String str) {
        w.d("MicroMsg.WebviewJSSDKConstants", "genLocalIdByFilePath, file path is \uff1a%s", str);
        if (w0.c(str)) {
            return null;
        }
        String str2 = "weixin://resourceid/" + y.a(str);
        w.d("MicroMsg.WebviewJSSDKConstants", "gen local id by filepath, filepath : %s, localid : %s", str, str2);
        return str2;
    }
}
