package com.tencent.mobileqq.widget;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/* compiled from: P */
/* loaded from: classes20.dex */
public class bb {

    /* renamed from: a, reason: collision with root package name */
    private Bitmap f316702a;

    /* renamed from: b, reason: collision with root package name */
    private int f316703b;

    public bb(Bitmap bitmap) {
        this.f316702a = bitmap;
        this.f316703b = 0;
    }

    public Bitmap a() {
        return this.f316702a;
    }

    public int b() {
        if (f()) {
            return this.f316702a.getWidth();
        }
        return this.f316702a.getHeight();
    }

    public Matrix c() {
        Matrix matrix = new Matrix();
        if (this.f316703b != 0) {
            matrix.preTranslate(-(this.f316702a.getWidth() / 2), -(this.f316702a.getHeight() / 2));
            matrix.postRotate(this.f316703b);
            matrix.postTranslate(e() / 2, b() / 2);
        }
        return matrix;
    }

    public int d() {
        return this.f316703b;
    }

    public int e() {
        if (f()) {
            return this.f316702a.getHeight();
        }
        return this.f316702a.getWidth();
    }

    public boolean f() {
        if ((this.f316703b / 90) % 2 != 0) {
            return true;
        }
        return false;
    }

    public void g(Bitmap bitmap) {
        this.f316702a = bitmap;
    }

    public void h(int i3) {
        this.f316703b = i3;
    }

    public bb(Bitmap bitmap, int i3) {
        this.f316702a = bitmap;
        this.f316703b = i3 % 360;
    }
}
