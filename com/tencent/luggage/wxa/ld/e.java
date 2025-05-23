package com.tencent.luggage.wxa.ld;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class e implements d {

    /* renamed from: a, reason: collision with root package name */
    public a f133281a;

    /* renamed from: c, reason: collision with root package name */
    public String f133283c;

    /* renamed from: d, reason: collision with root package name */
    public String f133284d;

    /* renamed from: e, reason: collision with root package name */
    public Map f133285e = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public String f133282b = b();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum a {
        GET("GET"),
        POST("POST"),
        NOTIFY("NOTIFY"),
        M_SEARCH("M-SEARCH"),
        SUBSCRIBE("SUBSCRIBE"),
        UNSUBSCRIBE("UNSUBSCRIBE"),
        RENEW_SUBSCRIBE("SUBSCRIBE"),
        UNKNOWN("UNKNOWN");


        /* renamed from: a, reason: collision with root package name */
        public String f133295a;

        a(String str) {
            this.f133295a = str;
        }
    }

    public e(String str, String str2) {
        this.f133283c = str;
        this.f133284d = str2;
        a(a.POST);
    }

    public void a(a aVar) {
        this.f133281a = aVar;
    }

    public abstract String b();

    public Map c() {
        return this.f133285e;
    }

    public a d() {
        return this.f133281a;
    }

    public String e() {
        return this.f133283c;
    }

    public void f() {
        a("Content-Type", "text/xml;charset=\"utf-8\"");
        a("Connection", "close");
    }

    public void a(String str, String str2) {
        this.f133285e.put(str, str2);
    }
}
