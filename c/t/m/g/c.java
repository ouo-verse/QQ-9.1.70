package c.t.m.g;

import android.os.Build;

/* compiled from: P */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public String f29515a;

    /* renamed from: b, reason: collision with root package name */
    public String f29516b;

    /* renamed from: c, reason: collision with root package name */
    public String f29517c;

    public c(String str, String str2, String str3) {
        this.f29515a = str2;
        this.f29516b = str;
        this.f29517c = str3;
    }

    public final String a(String str) {
        return str == null ? "" : str;
    }

    public String b() {
        return a(this.f29516b);
    }

    public String c() {
        return a(this.f29515a);
    }

    public String d() {
        return a(Build.MANUFACTURER);
    }

    public String e() {
        return a(l1.e());
    }

    public String f() {
        return "1.7.7";
    }

    public String a() {
        return a(this.f29517c);
    }
}
