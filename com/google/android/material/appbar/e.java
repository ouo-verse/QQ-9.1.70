package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final View f33243a;

    /* renamed from: b, reason: collision with root package name */
    private int f33244b;

    /* renamed from: c, reason: collision with root package name */
    private int f33245c;

    /* renamed from: d, reason: collision with root package name */
    private int f33246d;

    /* renamed from: e, reason: collision with root package name */
    private int f33247e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f33248f = true;

    /* renamed from: g, reason: collision with root package name */
    private boolean f33249g = true;

    public e(View view) {
        this.f33243a = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        View view = this.f33243a;
        ViewCompat.offsetTopAndBottom(view, this.f33246d - (view.getTop() - this.f33244b));
        View view2 = this.f33243a;
        ViewCompat.offsetLeftAndRight(view2, this.f33247e - (view2.getLeft() - this.f33245c));
    }

    public int b() {
        return this.f33244b;
    }

    public int c() {
        return this.f33247e;
    }

    public int d() {
        return this.f33246d;
    }

    public boolean e() {
        return this.f33249g;
    }

    public boolean f() {
        return this.f33248f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        this.f33244b = this.f33243a.getTop();
        this.f33245c = this.f33243a.getLeft();
    }

    public void h(boolean z16) {
        this.f33249g = z16;
    }

    public boolean i(int i3) {
        if (this.f33249g && this.f33247e != i3) {
            this.f33247e = i3;
            a();
            return true;
        }
        return false;
    }

    public boolean j(int i3) {
        if (this.f33248f && this.f33246d != i3) {
            this.f33246d = i3;
            a();
            return true;
        }
        return false;
    }

    public void k(boolean z16) {
        this.f33248f = z16;
    }
}
