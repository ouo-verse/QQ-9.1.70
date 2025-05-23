package com.tencent.luggage.wxa.dr;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends Exception {

    /* renamed from: b, reason: collision with root package name */
    public static final Map f124434b;

    /* renamed from: a, reason: collision with root package name */
    public int f124435a;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(-6501, "please call SM2Algo init method first to initialize context");
        hashMap.put(-6502, "please call SM3Algo hashInit method first to initialize sm3 hash context");
        hashMap.put(-6503, "please call SM3Algo hmacInit method first to initialize sm3 hmac context");
        hashMap.put(-6504, "please call SM4Algo stepInit method first to initialize sm4 context");
        hashMap.put(-6505, "please call SMCert init method first to initialize cert context");
        f124434b = Collections.unmodifiableMap(hashMap);
    }

    public c(int i3) {
        super("" + i3 + MsgSummary.STR_COLON + a(i3));
        this.f124435a = i3;
    }

    public static String a(int i3) {
        Map map = f124434b;
        if (map.containsKey(Integer.valueOf(i3))) {
            return (String) map.get(Integer.valueOf(i3));
        }
        return "Please refer to Tencent SM official document";
    }
}
