package com.tencent.tab.exp.sdk.export.injector.network;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class TabMetricsNetInfo {

    /* renamed from: a, reason: collision with root package name */
    private RecordType f374015a;

    /* renamed from: b, reason: collision with root package name */
    private int f374016b;

    /* renamed from: c, reason: collision with root package name */
    private String f374017c;

    /* renamed from: d, reason: collision with root package name */
    private String f374018d;

    /* renamed from: e, reason: collision with root package name */
    private float f374019e;

    /* renamed from: f, reason: collision with root package name */
    private float f374020f;

    /* renamed from: g, reason: collision with root package name */
    private float f374021g;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public enum RecordType {
        RECORD_SUCCESS,
        RECORD_TIMEOUT,
        RECORD_FAILED
    }

    public String a() {
        return this.f374017c;
    }

    public String b() {
        return this.f374018d;
    }

    public float c() {
        return this.f374021g;
    }

    public RecordType d() {
        return this.f374015a;
    }

    public float e() {
        return this.f374020f;
    }

    public int f() {
        return this.f374016b;
    }

    public float g() {
        return this.f374019e;
    }

    public void h(String str) {
        this.f374017c = str;
    }

    public void i(String str) {
        this.f374018d = str;
    }

    public void j(float f16) {
        this.f374021g = f16;
    }

    public void k(RecordType recordType) {
        this.f374015a = recordType;
    }

    public void l(float f16) {
        this.f374020f = f16;
    }

    public void m(int i3) {
        this.f374016b = i3;
    }

    public void n(float f16) {
        this.f374019e = f16;
    }

    public String toString() {
        return "TabMetricsNetInfo{recordType=" + this.f374015a + ", statusCode=" + this.f374016b + ", apiName='" + this.f374017c + "', appId='" + this.f374018d + "', ttfbTime=" + this.f374019e + ", requestTime=" + this.f374020f + ", parseTime=" + this.f374021g + '}';
    }
}
