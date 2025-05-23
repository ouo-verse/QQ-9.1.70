package com.tencent.luggage.wxa.qq;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.luggage.wxa.ar.x0;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class l {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f138988a;

        /* renamed from: b, reason: collision with root package name */
        public Map f138989b;

        public static a a() {
            a aVar = new a();
            aVar.f138988a = false;
            aVar.f138989b = null;
            return aVar;
        }
    }

    public static boolean a(String str) {
        if (str != null) {
            return System.currentTimeMillis() < Long.parseLong(str);
        }
        return false;
    }

    public static a b(String str) {
        x0.d("XWebDebugCommandLinkUtil", "checkLinkValid, cmd:" + str);
        String a16 = com.tencent.luggage.wxa.ar.a.a(str);
        if (a16 == null) {
            x0.f("XWebDebugCommandLinkUtil", "checkLinkValid, decrypt error");
            return a.a();
        }
        Map c16 = c(a16);
        String str2 = (String) c16.get("platform");
        if (!"android".equalsIgnoreCase(str2)) {
            x0.f("XWebDebugCommandLinkUtil", "checkLinkValid, invalid platform:" + str2);
            return a.a();
        }
        String str3 = (String) c16.get("expiration");
        if (!a(str3)) {
            x0.f("XWebDebugCommandLinkUtil", "checkLinkValid, link expired:" + str3);
            return a.a();
        }
        a aVar = new a();
        aVar.f138988a = true;
        aVar.f138989b = c16;
        return aVar;
    }

    public static Map c(String str) {
        HashMap hashMap = new HashMap();
        for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
            String[] split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER, 2);
            if (split.length == 2) {
                hashMap.put(split[0], split[1]);
            }
        }
        return hashMap;
    }

    public static String a(Map map) {
        map.remove("platform");
        map.remove("expiration");
        if (map.isEmpty()) {
            x0.f("XWebDebugCommandLinkUtil", "createNewDebugLink, map empty");
            return null;
        }
        StringBuilder sb5 = new StringBuilder("http://debugxweb.qq.com/?");
        for (Map.Entry entry : map.entrySet()) {
            sb5.append((String) entry.getKey());
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append((String) entry.getValue());
            sb5.append(ContainerUtils.FIELD_DELIMITER);
        }
        if (sb5.length() > 0) {
            sb5.setLength(sb5.length() - 1);
        }
        return sb5.toString();
    }
}
