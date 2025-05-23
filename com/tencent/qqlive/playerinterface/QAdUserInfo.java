package com.tencent.qqlive.playerinterface;

import android.text.TextUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QAdUserInfo {

    /* renamed from: a, reason: collision with root package name */
    private boolean f345340a;

    /* renamed from: b, reason: collision with root package name */
    private String f345341b;

    /* renamed from: c, reason: collision with root package name */
    private String f345342c;

    /* renamed from: d, reason: collision with root package name */
    private int f345343d;

    /* renamed from: e, reason: collision with root package name */
    private String f345344e;

    /* renamed from: f, reason: collision with root package name */
    private String f345345f;

    /* renamed from: g, reason: collision with root package name */
    private String f345346g;

    /* renamed from: h, reason: collision with root package name */
    private String f345347h;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes22.dex */
    public @interface VipType {
        public static final int NONE = 0;
        public static final int SUPPLEMENT_CARD = 2;
        public static final int TENCENT_VIDEO = 1;
        public static final int TENCENT_VIDEO_VVIP = 3;
    }

    public String a() {
        return this.f345346g;
    }

    public String b() {
        return this.f345342c;
    }

    public String c() {
        return this.f345347h;
    }

    public String d() {
        return this.f345344e;
    }

    public String e() {
        return this.f345345f;
    }

    public String f() {
        if (TextUtils.isEmpty(this.f345341b)) {
            return "";
        }
        return this.f345341b;
    }

    public int g() {
        return this.f345343d;
    }

    public boolean h() {
        return this.f345340a;
    }

    public void i(String str) {
        this.f345346g = str;
    }

    public void j(String str) {
        this.f345347h = str;
    }

    public void k(String str) {
        this.f345344e = str;
    }

    public void l(String str) {
        this.f345341b = str;
    }
}
