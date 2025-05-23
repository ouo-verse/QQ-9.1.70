package com.google.android.material.badge;

import android.widget.FrameLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.internal.p;

/* compiled from: P */
/* loaded from: classes2.dex */
class BadgeUtils$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Toolbar f33270d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f33271e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ BadgeDrawable f33272f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ FrameLayout f33273h;

    @Override // java.lang.Runnable
    public void run() {
        ActionMenuItemView a16 = p.a(this.f33270d, this.f33271e);
        if (a16 != null) {
            c.h(this.f33272f, this.f33270d.getResources());
            c.c(this.f33272f, a16, this.f33273h);
            c.b(this.f33272f, a16);
        }
    }
}
