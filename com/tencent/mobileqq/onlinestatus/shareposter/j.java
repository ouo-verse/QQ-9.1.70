package com.tencent.mobileqq.onlinestatus.shareposter;

import android.graphics.Bitmap;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes16.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private String f256274a;

    /* renamed from: b, reason: collision with root package name */
    private int f256275b;

    /* renamed from: c, reason: collision with root package name */
    private int f256276c;

    /* renamed from: d, reason: collision with root package name */
    private Bitmap f256277d;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private String f256278a;

        /* renamed from: b, reason: collision with root package name */
        private int f256279b;

        /* renamed from: c, reason: collision with root package name */
        private int f256280c;

        /* renamed from: d, reason: collision with root package name */
        private Bitmap f256281d;

        a() {
        }

        public j e() {
            return new j(this);
        }

        public a f(int i3) {
            this.f256280c = i3;
            return this;
        }

        public a g(Bitmap bitmap) {
            this.f256281d = bitmap;
            return this;
        }

        public a h(int i3) {
            this.f256279b = i3;
            return this;
        }

        public a i(String str) {
            this.f256278a = str;
            return this;
        }
    }

    j(a aVar) {
        this.f256274a = aVar.f256278a;
        this.f256275b = aVar.f256279b;
        this.f256276c = aVar.f256280c;
        this.f256277d = aVar.f256281d;
    }

    public static a f() {
        return new a();
    }

    public int a() {
        return this.f256276c;
    }

    public Bitmap b() {
        return this.f256277d;
    }

    public int c() {
        return this.f256275b;
    }

    public String d() {
        return this.f256274a;
    }

    public boolean e() {
        if (!TextUtils.isEmpty(this.f256274a) && this.f256275b >= 0) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "QrCodeParams{mUrl='" + this.f256274a + "', mSize=" + this.f256275b + ", mColor=" + this.f256276c + ", mLogoBitmap=" + this.f256277d + '}';
    }
}
