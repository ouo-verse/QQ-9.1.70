package com.tencent.luggage.wxa.ar;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c0 {

    /* renamed from: a, reason: collision with root package name */
    public int f121622a;

    /* renamed from: b, reason: collision with root package name */
    public String f121623b;

    /* renamed from: c, reason: collision with root package name */
    public String f121624c;

    /* renamed from: d, reason: collision with root package name */
    public int f121625d;

    /* renamed from: e, reason: collision with root package name */
    public String f121626e;

    /* renamed from: f, reason: collision with root package name */
    public int f121627f = 1;

    public boolean a() {
        if (this.f121625d == 2) {
            return true;
        }
        return false;
    }

    public boolean b() {
        if (this.f121625d == 1) {
            return true;
        }
        return false;
    }

    public boolean c() {
        if (this.f121622a == 1) {
            return true;
        }
        return false;
    }

    public boolean d() {
        if (this.f121622a == 2) {
            return true;
        }
        return false;
    }

    public boolean e() {
        if (this.f121622a == 3) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "PatchFileConfig type:" + this.f121622a + ", originalFileType:" + this.f121625d + ", originalFileName:" + this.f121626e + ", patchFileName:" + this.f121623b + ", patchEndFileMd5:" + this.f121624c + ", patchType:" + this.f121627f;
    }
}
