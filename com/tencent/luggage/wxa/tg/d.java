package com.tencent.luggage.wxa.tg;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d implements e {

    /* renamed from: a, reason: collision with root package name */
    public final String f141299a;

    /* renamed from: b, reason: collision with root package name */
    public final String f141300b;

    public d(String str, String str2) {
        this.f141300b = str;
        this.f141299a = str2;
    }

    public String a(String str) {
        if (!str.equals("application/octet-stream") || TextUtils.isEmpty(this.f141300b)) {
            return str;
        }
        h.a(5, this.f141299a, "fix contentType from " + str + " to " + this.f141300b);
        return this.f141300b;
    }

    @Override // com.tencent.luggage.wxa.tg.e
    public Map a(Map map) {
        List list;
        if (map == null || (list = (List) map.get("Content-Type")) == null || list.size() <= 0) {
            return map;
        }
        String str = (String) list.get(0);
        if (!str.equals("application/octet-stream") || TextUtils.isEmpty(this.f141300b)) {
            return map;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() != null && ((String) entry.getKey()).equals("Content-Type")) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.f141300b);
                hashMap.put("Content-Type", arrayList);
                h.a(5, this.f141299a, "fix Content-Type from " + str + " to " + this.f141300b);
            } else {
                hashMap.put((String) entry.getKey(), (List) entry.getValue());
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }
}
