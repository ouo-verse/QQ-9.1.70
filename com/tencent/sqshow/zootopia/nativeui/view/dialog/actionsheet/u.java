package com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet;

import android.graphics.Bitmap;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes34.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    private String f371787a;

    /* renamed from: b, reason: collision with root package name */
    private int f371788b;

    /* renamed from: c, reason: collision with root package name */
    private int f371789c;

    /* renamed from: d, reason: collision with root package name */
    private Bitmap f371790d;

    /* compiled from: P */
    /* loaded from: classes34.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private String f371791a;

        /* renamed from: b, reason: collision with root package name */
        private int f371792b;

        /* renamed from: c, reason: collision with root package name */
        private int f371793c;

        /* renamed from: d, reason: collision with root package name */
        private Bitmap f371794d;

        public u e() {
            return new u(this);
        }

        public b f(int i3) {
            this.f371793c = i3;
            return this;
        }

        public b g(Bitmap bitmap) {
            this.f371794d = bitmap;
            return this;
        }

        public b h(int i3) {
            this.f371792b = i3;
            return this;
        }

        public b i(String str) {
            this.f371791a = str;
            return this;
        }

        b() {
        }
    }

    public static b f() {
        return new b();
    }

    public int a() {
        return this.f371789c;
    }

    public Bitmap b() {
        return this.f371790d;
    }

    public int c() {
        return this.f371788b;
    }

    public String d() {
        return this.f371787a;
    }

    public boolean e() {
        return TextUtils.isEmpty(this.f371787a) || this.f371788b < 0;
    }

    public String toString() {
        return "QrCodeParams{mUrl='" + this.f371787a + "', mSize=" + this.f371788b + ", mColor=" + this.f371789c + ", mLogoBitmap=" + this.f371790d + '}';
    }

    u(b bVar) {
        this.f371787a = bVar.f371791a;
        this.f371788b = bVar.f371792b;
        this.f371789c = bVar.f371793c;
        this.f371790d = bVar.f371794d;
    }
}
