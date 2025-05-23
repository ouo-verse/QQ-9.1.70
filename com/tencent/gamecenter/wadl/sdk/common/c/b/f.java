package com.tencent.gamecenter.wadl.sdk.common.c.b;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public int f107097a;

    /* renamed from: b, reason: collision with root package name */
    public String f107098b;

    /* renamed from: c, reason: collision with root package name */
    public int f107099c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f107100d;

    /* renamed from: e, reason: collision with root package name */
    private Map<String, String> f107101e;

    public f(int i3, String str, int i16) {
        this.f107097a = i3;
        this.f107098b = str;
        this.f107099c = i16;
    }

    public String a(String str) {
        if (this.f107101e == null || TextUtils.isEmpty(str)) {
            return "";
        }
        String str2 = this.f107101e.get(str.toLowerCase());
        return !TextUtils.isEmpty(str2) ? str2 : "";
    }

    public String toString() {
        Object obj;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("errorCode:");
        sb5.append(this.f107097a);
        sb5.append(",errorInfo:");
        sb5.append(this.f107098b);
        sb5.append(",httpStatus:");
        sb5.append(this.f107099c);
        sb5.append(",headers:");
        sb5.append(this.f107101e);
        sb5.append(",body:");
        byte[] bArr = this.f107100d;
        if (bArr != null) {
            obj = Integer.valueOf(bArr.length);
        } else {
            obj = "null";
        }
        sb5.append(obj);
        return sb5.toString();
    }

    public void a(Map<String, String> map) {
        this.f107101e = new HashMap();
        if (map == null || map.size() <= 0) {
            return;
        }
        for (String str : map.keySet()) {
            this.f107101e.put(str.toLowerCase(), map.get(str));
        }
    }
}
