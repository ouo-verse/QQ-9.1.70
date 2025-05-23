package com.tencent.mobileqq.qqvideoedit.view.scrollingheader;

import android.view.View;
import androidx.core.view.ViewCompat;

/* compiled from: P */
/* loaded from: classes17.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    private final View f276346a;

    /* renamed from: b, reason: collision with root package name */
    private int f276347b;

    /* renamed from: c, reason: collision with root package name */
    private int f276348c;

    /* renamed from: d, reason: collision with root package name */
    private int f276349d;

    /* renamed from: e, reason: collision with root package name */
    private int f276350e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f276351f = true;

    /* renamed from: g, reason: collision with root package name */
    private boolean f276352g = true;

    public a(View view) {
        this.f276346a = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        View view = this.f276346a;
        ViewCompat.offsetTopAndBottom(view, this.f276349d - (view.getTop() - this.f276347b));
        View view2 = this.f276346a;
        ViewCompat.offsetLeftAndRight(view2, this.f276350e - (view2.getLeft() - this.f276348c));
    }

    public int b() {
        return this.f276349d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f276347b = this.f276346a.getTop();
        this.f276348c = this.f276346a.getLeft();
    }

    public boolean d(int i3) {
        if (this.f276352g && this.f276350e != i3) {
            this.f276350e = i3;
            a();
            return true;
        }
        return false;
    }

    public boolean e(int i3) {
        if (this.f276351f && this.f276349d != i3) {
            this.f276349d = i3;
            a();
            return true;
        }
        return false;
    }
}
