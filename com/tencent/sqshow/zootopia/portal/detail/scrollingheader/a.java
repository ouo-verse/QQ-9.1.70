package com.tencent.sqshow.zootopia.portal.detail.scrollingheader;

import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes34.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final View f372341a;

    /* renamed from: b, reason: collision with root package name */
    private int f372342b;

    /* renamed from: c, reason: collision with root package name */
    private int f372343c;

    /* renamed from: d, reason: collision with root package name */
    private int f372344d;

    /* renamed from: e, reason: collision with root package name */
    private int f372345e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f372346f = true;

    /* renamed from: g, reason: collision with root package name */
    private boolean f372347g = true;

    public a(View view) {
        this.f372341a = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        View view = this.f372341a;
        ViewCompat.offsetTopAndBottom(view, this.f372344d - (view.getTop() - this.f372342b));
        View view2 = this.f372341a;
        ViewCompat.offsetLeftAndRight(view2, this.f372345e - (view2.getLeft() - this.f372343c));
    }

    public int b() {
        return this.f372344d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f372342b = this.f372341a.getTop();
        this.f372343c = this.f372341a.getLeft();
    }

    public boolean d(int i3) {
        if (!this.f372347g || this.f372345e == i3) {
            return false;
        }
        this.f372345e = i3;
        a();
        return true;
    }

    public boolean e(int i3) {
        if (!this.f372346f || this.f372344d == i3) {
            return false;
        }
        this.f372344d = i3;
        a();
        return true;
    }
}
