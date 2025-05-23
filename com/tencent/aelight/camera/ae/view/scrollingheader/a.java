package com.tencent.aelight.camera.ae.view.scrollingheader;

import android.view.View;
import androidx.core.view.ViewCompat;

/* compiled from: P */
/* loaded from: classes32.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    private final View f65956a;

    /* renamed from: b, reason: collision with root package name */
    private int f65957b;

    /* renamed from: c, reason: collision with root package name */
    private int f65958c;

    /* renamed from: d, reason: collision with root package name */
    private int f65959d;

    /* renamed from: e, reason: collision with root package name */
    private int f65960e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f65961f = true;

    /* renamed from: g, reason: collision with root package name */
    private boolean f65962g = true;

    public a(View view) {
        this.f65956a = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        View view = this.f65956a;
        ViewCompat.offsetTopAndBottom(view, this.f65959d - (view.getTop() - this.f65957b));
        View view2 = this.f65956a;
        ViewCompat.offsetLeftAndRight(view2, this.f65960e - (view2.getLeft() - this.f65958c));
    }

    public int b() {
        return this.f65959d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f65957b = this.f65956a.getTop();
        this.f65958c = this.f65956a.getLeft();
    }

    public boolean d(int i3) {
        if (!this.f65962g || this.f65960e == i3) {
            return false;
        }
        this.f65960e = i3;
        a();
        return true;
    }

    public boolean e(int i3) {
        if (!this.f65961f || this.f65959d == i3) {
            return false;
        }
        this.f65959d = i3;
        a();
        return true;
    }
}
