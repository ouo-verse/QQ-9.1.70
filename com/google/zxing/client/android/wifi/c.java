package com.google.zxing.client.android.wifi;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class c extends b {

    /* renamed from: b, reason: collision with root package name */
    private final String f35984b;

    /* renamed from: c, reason: collision with root package name */
    private final String f35985c;

    /* renamed from: d, reason: collision with root package name */
    private final String f35986d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f35987e;

    public c(String str, String str2, String str3, boolean z16) {
        super(ParsedResultType.WIFI);
        this.f35984b = str2;
        this.f35985c = str;
        this.f35986d = str3;
        this.f35987e = z16;
    }

    @Override // com.google.zxing.client.android.wifi.b
    public String a() {
        StringBuilder sb5 = new StringBuilder(80);
        b.b(this.f35984b, sb5);
        b.b(this.f35985c, sb5);
        b.b(this.f35986d, sb5);
        b.b(Boolean.toString(this.f35987e), sb5);
        return sb5.toString();
    }

    public String c() {
        return this.f35985c;
    }

    public String d() {
        return this.f35986d;
    }

    public String e() {
        return this.f35984b;
    }

    public boolean f() {
        return this.f35987e;
    }
}
