package com.tencent.qimei.r;

import android.util.Base64;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qimei.ad.c;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, String> f343359a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18881);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
        f343359a = concurrentHashMap;
        concurrentHashMap.put(0, a("aWVtaXE="));
        concurrentHashMap.put(1, a("NjNpZW1pcQ=="));
        concurrentHashMap.put(2, a("QVRHTkVEX0lFTUlR"));
        concurrentHashMap.put(3, a("MV9JRU1JUV9OT0NBRUI="));
        concurrentHashMap.put(4, a("MnZfaWVtaXE="));
        concurrentHashMap.put(5, a("ZGlhbw=="));
        concurrentHashMap.put(6, a("aWVtaQ=="));
        concurrentHashMap.put(7, a("aXNtaQ=="));
        concurrentHashMap.put(8, a("Y2Ft"));
        concurrentHashMap.put(9, a("ZGlj"));
        concurrentHashMap.put(10, a("aWVtaVFldGFkcHU="));
        concurrentHashMap.put(11, a("ZElkaW9yZG5h"));
        concurrentHashMap.put(12, a("ZHJhb2IudGN1ZG9ycC5vcg=="));
        concurrentHashMap.put(13, a("ZG5hcmIudGN1ZG9ycC5vcg=="));
        concurrentHashMap.put(14, a("ZWNpdmVkLnRjdWRvcnAub3I="));
        concurrentHashMap.put(15, a("bGV2ZWxfaXBhX3RzcmlmLnRjdWRvcnAub3I="));
        concurrentHashMap.put(16, a("cmVydXRjYWZ1bmFtLnRjdWRvcnAub3I="));
        concurrentHashMap.put(17, a("ZW1hbi50Y3Vkb3JwLm9y"));
        concurrentHashMap.put(18, a("dHNvaC5kbGl1Yi5vcg=="));
        concurrentHashMap.put(19, a("S0RTaWVtaVEua2RzLmllbWlxLnRuZWNuZXQubW9j"));
        concurrentHashMap.put(20, a("Y3JTZElub2NhZWI="));
        concurrentHashMap.put(21, a("c2oudG5pcnByZWduaWYvdHNldGFsL2Jldy1rZHNpZW1pcS9pZW1pcS9tb2MucXEuZWxpZmNpdGF0cy8vOnNwdHRo"));
        concurrentHashMap.put(22, a("aWVtaXEubml3LnRuZWNuZXQuc3lz"));
        concurrentHashMap.put(23, a("bGVkb20udG5lY25ldC5zeXM="));
        concurrentHashMap.put(24, a("ZGl1Zy50bmVjbmV0LnN5cw=="));
    }

    public static String a(int i3) {
        String str = f343359a.get(Integer.valueOf(i3));
        return str == null ? "" : str;
    }

    public static String a(String str) {
        try {
            return new StringBuilder(new String(Base64.decode(str, 2))).reverse().toString();
        } catch (Exception e16) {
            c.a(e16);
            return "";
        }
    }
}
