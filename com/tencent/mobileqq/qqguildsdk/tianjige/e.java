package com.tencent.mobileqq.qqguildsdk.tianjige;

import android.os.Build;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes17.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private String f268504a;

    /* renamed from: b, reason: collision with root package name */
    private double f268505b;

    /* renamed from: c, reason: collision with root package name */
    private double f268506c;

    /* renamed from: d, reason: collision with root package name */
    private String f268507d;

    /* renamed from: e, reason: collision with root package name */
    private String f268508e;

    /* renamed from: f, reason: collision with root package name */
    private String f268509f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f268510g;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f268511a;

        /* renamed from: b, reason: collision with root package name */
        private double f268512b;

        /* renamed from: c, reason: collision with root package name */
        private double f268513c;

        /* renamed from: d, reason: collision with root package name */
        private String f268514d;

        /* renamed from: e, reason: collision with root package name */
        private String f268515e;

        /* renamed from: f, reason: collision with root package name */
        private String f268516f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f268517g;

        public e h() {
            return new e(this);
        }

        public a i(String str) {
            this.f268516f = str;
            return this;
        }

        public a j(boolean z16) {
            this.f268517g = z16;
            return this;
        }

        public a k(double d16) {
            this.f268513c = d16;
            return this;
        }

        public a l(double d16) {
            this.f268512b = d16;
            return this;
        }

        public a m(String str) {
            this.f268511a = str;
            return this;
        }

        public a n(String str) {
            this.f268515e = str;
            return this;
        }

        public a o(String str) {
            this.f268514d = str;
            return this;
        }
    }

    public e(a aVar) {
        this.f268504a = aVar.f268511a;
        this.f268505b = aVar.f268512b;
        this.f268506c = aVar.f268513c;
        this.f268507d = aVar.f268514d;
        this.f268508e = aVar.f268516f;
        this.f268509f = aVar.f268515e;
        this.f268510g = aVar.f268517g;
    }

    public static boolean h() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26 && i3 != 27) {
            return true;
        }
        return false;
    }

    public String a() {
        if (TextUtils.isEmpty(this.f268508e)) {
            return "";
        }
        return this.f268508e;
    }

    public double b() {
        return this.f268506c;
    }

    public double c() {
        return this.f268505b;
    }

    public String d() {
        return this.f268504a;
    }

    public String e() {
        if (TextUtils.isEmpty(this.f268509f)) {
            return "";
        }
        return this.f268509f;
    }

    public String f() {
        if (TextUtils.isEmpty(this.f268507d)) {
            return "";
        }
        return this.f268507d;
    }

    public boolean g() {
        return this.f268510g;
    }

    public void i(String str) {
        this.f268509f = str;
    }
}
