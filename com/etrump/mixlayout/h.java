package com.etrump.mixlayout;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes2.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<c> f32738a = new ArrayList<>(4);

    /* renamed from: b, reason: collision with root package name */
    private int f32739b;

    /* renamed from: c, reason: collision with root package name */
    private int f32740c;

    /* renamed from: d, reason: collision with root package name */
    private int f32741d;

    /* renamed from: e, reason: collision with root package name */
    private int f32742e;

    /* renamed from: f, reason: collision with root package name */
    private int f32743f;

    public void a(c cVar) {
        this.f32738a.add(cVar);
    }

    public void b(Canvas canvas, int i3, int i16) {
        Iterator<c> it = this.f32738a.iterator();
        while (it.hasNext()) {
            c next = it.next();
            next.c(canvas, i3, i16, this.f32742e);
            i3 += next.n();
        }
    }

    public void c(ETEngine eTEngine, Bitmap bitmap, ETDecoration eTDecoration, int i3, int i16) {
        Iterator<c> it = this.f32738a.iterator();
        while (it.hasNext()) {
            c next = it.next();
            int i17 = i3;
            next.e(eTEngine, bitmap, eTDecoration, i17, ((this.f32742e - next.h()) + i16) - (this.f32743f - next.f(eTEngine)));
            i3 += next.n();
        }
    }

    public ArrayList<c> d() {
        return this.f32738a;
    }

    public int e() {
        return this.f32742e;
    }

    public int f() {
        return this.f32739b;
    }

    public int g() {
        return this.f32743f;
    }

    public int h() {
        return this.f32740c;
    }

    public int i() {
        return this.f32741d;
    }

    public void j(ETEngine eTEngine, int i3, int i16, int i17) {
        this.f32739b = i3;
        this.f32740c = i16;
        this.f32741d = 0;
        this.f32742e = i17;
        Iterator<c> it = this.f32738a.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.h() > this.f32742e) {
                this.f32742e = next.h();
            }
            this.f32741d += next.n();
        }
        this.f32743f = 0;
        Iterator<c> it5 = this.f32738a.iterator();
        while (it5.hasNext()) {
            int f16 = it5.next().f(eTEngine);
            if (f16 > this.f32743f) {
                this.f32743f = f16;
            }
        }
    }

    public void k(Canvas canvas, int i3, int i16) {
        Iterator<c> it = this.f32738a.iterator();
        while (it.hasNext()) {
            c next = it.next();
            next.v(canvas, i3, i16, this.f32742e);
            i3 += next.n();
        }
    }
}
