package com.tencent.qmethod.pandoraex.core.ext.netcap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public String f344083a = "";

    /* renamed from: b, reason: collision with root package name */
    public String f344084b = "GET";

    /* renamed from: c, reason: collision with root package name */
    public byte[] f344085c = null;

    /* renamed from: d, reason: collision with root package name */
    public Map<String, List<String>> f344086d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public String f344087e = "";

    /* renamed from: f, reason: collision with root package name */
    public long f344088f = 0;

    public void a() {
        String str;
        try {
            if (this.f344083a.startsWith("https://")) {
                str = "HTTPS";
            } else if (this.f344083a.startsWith("http://")) {
                str = "HTTP";
            } else {
                str = null;
            }
            String str2 = str;
            if (str2 != null) {
                k.e(str2, this.f344083a, this.f344086d, this.f344085c, System.currentTimeMillis(), "HttpClient", this.f344087e, this.f344088f);
            }
        } catch (Exception e16) {
            throw new RuntimeException(e16);
        }
    }

    public void b(String str) {
        this.f344083a = str;
    }
}
