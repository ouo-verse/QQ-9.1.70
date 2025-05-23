package com.qzone.album.business.photolist.ui.interactingbar;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.qzone.album.business.photolist.controller.BasePhotoModelController;
import com.qzone.album.business.photolist.ui.interactingbar.a;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class b {

    /* renamed from: e, reason: collision with root package name */
    protected static final String f43576e = "b";

    /* renamed from: a, reason: collision with root package name */
    public LinearLayout f43577a;

    /* renamed from: b, reason: collision with root package name */
    protected Activity f43578b;

    /* renamed from: c, reason: collision with root package name */
    protected BasePhotoModelController f43579c;

    /* renamed from: d, reason: collision with root package name */
    protected a.InterfaceC0344a f43580d;

    public b(Activity activity, BasePhotoModelController basePhotoModelController, a.InterfaceC0344a interfaceC0344a) {
        this.f43578b = activity;
        this.f43579c = basePhotoModelController;
        this.f43580d = interfaceC0344a;
    }

    public abstract int a();

    public abstract ImageView b();

    public View c() {
        return this.f43577a;
    }

    public abstract void d();

    public abstract boolean e();

    public abstract void f();

    public abstract void g(int i3);

    public abstract void h(boolean z16, int i3);
}
