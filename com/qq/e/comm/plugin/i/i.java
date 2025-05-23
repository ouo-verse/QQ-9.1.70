package com.qq.e.comm.plugin.i;

/* compiled from: P */
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private int f39577a;

    /* renamed from: b, reason: collision with root package name */
    private String f39578b;

    /* renamed from: c, reason: collision with root package name */
    private String f39579c;

    /* renamed from: d, reason: collision with root package name */
    private long f39580d;

    /* renamed from: e, reason: collision with root package name */
    private long f39581e;

    /* renamed from: f, reason: collision with root package name */
    private long f39582f;

    public i() {
    }

    public long a() {
        return this.f39581e;
    }

    public long b() {
        return this.f39582f;
    }

    public int c() {
        return this.f39577a;
    }

    public long d() {
        return this.f39580d;
    }

    public String e() {
        return this.f39578b;
    }

    public String f() {
        return this.f39579c;
    }

    public String toString() {
        return "DownloadThreadInfo{id=" + this.f39577a + ", tag='" + this.f39578b + "', uri='" + this.f39579c + "', start=" + this.f39580d + ", end=" + this.f39581e + ", finished=" + this.f39582f + '}';
    }

    public i(int i3, String str, String str2) {
        this.f39577a = i3;
        this.f39578b = str;
        this.f39579c = str2;
    }

    public void a(long j3) {
        this.f39581e = j3;
    }

    public void b(long j3) {
        this.f39582f = j3;
    }

    public void c(long j3) {
        this.f39580d = j3;
    }

    public void a(int i3) {
        this.f39577a = i3;
    }

    public void b(String str) {
        this.f39579c = str;
    }

    public void a(String str) {
        this.f39578b = str;
    }

    public i(int i3, String str, String str2, long j3, long j16, long j17) {
        this.f39581e = j16;
        this.f39582f = j17;
        this.f39577a = i3;
        this.f39580d = j3;
        this.f39578b = str;
        this.f39579c = str2;
    }
}
