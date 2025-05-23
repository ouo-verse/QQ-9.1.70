package com.qzone.proxy.feedcomponent.model;

/* compiled from: P */
/* loaded from: classes39.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private String f50392a;

    /* renamed from: b, reason: collision with root package name */
    private String f50393b;

    /* renamed from: c, reason: collision with root package name */
    private int f50394c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f50395d;

    public m(String str, String str2, String str3, String str4) {
        this.f50394c = 0;
        this.f50392a = str;
        this.f50393b = str2;
        try {
            this.f50394c = Integer.parseInt(str3);
        } catch (Exception unused) {
        }
        this.f50395d = "1".equals(str4);
    }

    public String a() {
        return this.f50393b;
    }

    public int b() {
        return this.f50394c;
    }

    public String c() {
        return this.f50392a;
    }

    public boolean d() {
        return this.f50395d;
    }
}
