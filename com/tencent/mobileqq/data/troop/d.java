package com.tencent.mobileqq.data.troop;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private long f203206a;

    /* renamed from: b, reason: collision with root package name */
    private int f203207b;

    /* renamed from: c, reason: collision with root package name */
    private String f203208c;

    /* renamed from: d, reason: collision with root package name */
    private String f203209d;

    /* renamed from: e, reason: collision with root package name */
    private String f203210e;

    /* renamed from: f, reason: collision with root package name */
    private int f203211f;

    /* renamed from: g, reason: collision with root package name */
    private int f203212g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f203213h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f203214i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f203215j;

    public d(long j3, int i3, String str, String str2, String str3, int i16, int i17, boolean z16, boolean z17, boolean z18) {
        this.f203206a = j3;
        this.f203207b = i3;
        this.f203208c = str;
        this.f203209d = str2;
        this.f203210e = str3;
        this.f203211f = i16;
        this.f203212g = i17;
        this.f203213h = z16;
        this.f203214i = z17;
        this.f203215j = z18;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public d clone() {
        return new d(this.f203206a, this.f203207b, this.f203208c, this.f203209d, this.f203210e, this.f203211f, this.f203212g, this.f203213h, this.f203214i, this.f203215j);
    }

    public int b() {
        return this.f203207b;
    }

    public String c() {
        return this.f203210e;
    }

    public String d() {
        return this.f203208c;
    }

    public int e() {
        return this.f203212g;
    }

    public String f() {
        return this.f203209d;
    }

    public int g() {
        return this.f203211f;
    }

    public long h() {
        return this.f203206a;
    }

    public boolean i() {
        return this.f203213h;
    }

    public boolean j() {
        return this.f203214i;
    }

    public boolean k() {
        return this.f203215j;
    }

    public void l(int i3) {
        this.f203207b = i3;
    }

    public void m(String str) {
        this.f203210e = str;
    }

    public void n(String str) {
        this.f203208c = str;
    }

    public void o(int i3) {
        this.f203212g = i3;
    }

    public void p(String str) {
        this.f203209d = str;
    }

    public void q(int i3) {
        this.f203211f = i3;
    }

    public void r(boolean z16) {
        this.f203213h = z16;
    }

    public void s(boolean z16) {
        this.f203214i = z16;
    }

    public void t(boolean z16) {
        this.f203215j = z16;
    }

    public d(long j3, int i3, String str, String str2, String str3, int i16, boolean z16, boolean z17) {
        this.f203206a = j3;
        this.f203207b = i3;
        this.f203208c = str;
        this.f203209d = str2;
        this.f203210e = str3;
        this.f203211f = i16;
        this.f203215j = z16;
        this.f203213h = z17;
    }

    public d(long j3, int i3, boolean z16) {
        this.f203215j = false;
        this.f203206a = j3;
        this.f203212g = i3;
        this.f203214i = z16;
    }
}
