package com.huawei.secure.android.common.util;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private String f38035a;

    /* renamed from: b, reason: collision with root package name */
    private Character f38036b;

    /* renamed from: c, reason: collision with root package name */
    private Character f38037c;

    /* renamed from: d, reason: collision with root package name */
    private int f38038d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f38039e = 0;

    public a(String str) {
        this.f38035a = str;
    }

    public static boolean c(Character ch5) {
        char charValue;
        return ch5 != null && (charValue = ch5.charValue()) >= '0' && charValue <= '7';
    }

    public void a(Character ch5) {
        this.f38036b = ch5;
    }

    public int b() {
        return this.f38038d;
    }

    public Character d() {
        Character ch5 = this.f38036b;
        if (ch5 != null) {
            this.f38036b = null;
            return ch5;
        }
        String str = this.f38035a;
        if (str == null || str.length() == 0 || this.f38038d >= this.f38035a.length()) {
            return null;
        }
        String str2 = this.f38035a;
        int i3 = this.f38038d;
        this.f38038d = i3 + 1;
        return Character.valueOf(str2.charAt(i3));
    }

    public Character e() {
        Character d16 = d();
        if (d16 == null || !b(d16)) {
            return null;
        }
        return d16;
    }

    public Character f() {
        Character d16 = d();
        if (d16 == null || !c(d16)) {
            return null;
        }
        return d16;
    }

    public Character g() {
        Character ch5 = this.f38036b;
        if (ch5 != null) {
            return ch5;
        }
        String str = this.f38035a;
        if (str == null || str.length() == 0 || this.f38038d >= this.f38035a.length()) {
            return null;
        }
        return Character.valueOf(this.f38035a.charAt(this.f38038d));
    }

    protected String h() {
        String substring = this.f38035a.substring(this.f38038d);
        if (this.f38036b != null) {
            return this.f38036b + substring;
        }
        return substring;
    }

    public void i() {
        this.f38036b = this.f38037c;
        this.f38038d = this.f38039e;
    }

    public static boolean b(Character ch5) {
        if (ch5 == null) {
            return false;
        }
        char charValue = ch5.charValue();
        return (charValue >= '0' && charValue <= '9') || (charValue >= 'a' && charValue <= 'f') || (charValue >= 'A' && charValue <= 'F');
    }

    public boolean a() {
        if (this.f38036b != null) {
            return true;
        }
        String str = this.f38035a;
        return (str == null || str.length() == 0 || this.f38038d >= this.f38035a.length()) ? false : true;
    }

    public void c() {
        this.f38037c = this.f38036b;
        this.f38039e = this.f38038d;
    }

    public boolean a(char c16) {
        Character ch5 = this.f38036b;
        if (ch5 != null && ch5.charValue() == c16) {
            return true;
        }
        String str = this.f38035a;
        return str != null && str.length() != 0 && this.f38038d < this.f38035a.length() && this.f38035a.charAt(this.f38038d) == c16;
    }
}
