package com.tencent.mobileqq.wink.view.scrollingheader;

import android.view.View;
import androidx.core.view.ViewCompat;

/* compiled from: P */
/* loaded from: classes21.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    private final View f327113a;

    /* renamed from: b, reason: collision with root package name */
    private int f327114b;

    /* renamed from: c, reason: collision with root package name */
    private int f327115c;

    /* renamed from: d, reason: collision with root package name */
    private int f327116d;

    /* renamed from: e, reason: collision with root package name */
    private int f327117e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f327118f = true;

    /* renamed from: g, reason: collision with root package name */
    private boolean f327119g = true;

    public a(View view) {
        this.f327113a = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        View view = this.f327113a;
        ViewCompat.offsetTopAndBottom(view, this.f327116d - (view.getTop() - this.f327114b));
        View view2 = this.f327113a;
        ViewCompat.offsetLeftAndRight(view2, this.f327117e - (view2.getLeft() - this.f327115c));
    }

    public int b() {
        return this.f327116d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f327114b = this.f327113a.getTop();
        this.f327115c = this.f327113a.getLeft();
    }

    public boolean d(int i3) {
        if (this.f327119g && this.f327117e != i3) {
            this.f327117e = i3;
            a();
            return true;
        }
        return false;
    }

    public boolean e(int i3) {
        if (this.f327118f && this.f327116d != i3) {
            this.f327116d = i3;
            a();
            return true;
        }
        return false;
    }
}
