package com.tencent.luggage.wxa.pd;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public Map f137492a = new HashMap();

    public String a(String str) {
        return (String) this.f137492a.get(str);
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        for (Map.Entry entry : this.f137492a.entrySet()) {
            sb5.append(entry.getKey());
            sb5.append(":");
            sb5.append(entry.getValue());
            sb5.append("\n");
        }
        if (sb5.length() > 1) {
            sb5.deleteCharAt(sb5.length() - 1);
        }
        return sb5.toString();
    }

    public void a(String str, String str2) {
        this.f137492a.put(str, str2);
    }
}
