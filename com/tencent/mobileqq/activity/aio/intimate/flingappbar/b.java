package com.tencent.mobileqq.activity.aio.intimate.flingappbar;

import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes10.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final View f178979a;

    /* renamed from: b, reason: collision with root package name */
    private int f178980b;

    /* renamed from: c, reason: collision with root package name */
    private int f178981c;

    /* renamed from: d, reason: collision with root package name */
    private int f178982d;

    /* renamed from: e, reason: collision with root package name */
    private int f178983e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f178984f = true;

    /* renamed from: g, reason: collision with root package name */
    private boolean f178985g = true;

    public b(View view) {
        this.f178979a = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        View view = this.f178979a;
        ViewCompat.offsetTopAndBottom(view, this.f178982d - (view.getTop() - this.f178980b));
        View view2 = this.f178979a;
        ViewCompat.offsetLeftAndRight(view2, this.f178983e - (view2.getLeft() - this.f178981c));
    }

    public int b() {
        return this.f178982d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f178980b = this.f178979a.getTop();
        this.f178981c = this.f178979a.getLeft();
    }

    public boolean d(int i3) {
        if (this.f178985g && this.f178983e != i3) {
            this.f178983e = i3;
            a();
            return true;
        }
        return false;
    }

    public boolean e(int i3) {
        if (this.f178984f && this.f178982d != i3) {
            this.f178982d = i3;
            a();
            return true;
        }
        return false;
    }
}
