package com.qzone.album.business.photolist.ui.interactingbar;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.qzone.album.business.photolist.controller.BasePhotoModelController;
import com.qzone.album.business.photolist.ui.interactingbar.a;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes39.dex */
public class e extends com.qzone.album.business.photolist.ui.interactingbar.b {

    /* renamed from: f, reason: collision with root package name */
    public RelativeLayout f43595f;

    /* renamed from: g, reason: collision with root package name */
    public RelativeLayout f43596g;

    /* renamed from: h, reason: collision with root package name */
    public RelativeLayout f43597h;

    /* renamed from: i, reason: collision with root package name */
    public RelativeLayout f43598i;

    /* renamed from: j, reason: collision with root package name */
    public RelativeLayout f43599j;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            e.this.f43580d.h(view);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            e.this.f43580d.c(view);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            e.this.f43580d.b(view, false);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public e(Activity activity, BasePhotoModelController basePhotoModelController, a.InterfaceC0344a interfaceC0344a) {
        super(activity, basePhotoModelController, interfaceC0344a);
    }

    private String i() {
        BasePhotoModelController basePhotoModelController = this.f43579c;
        if (basePhotoModelController == null) {
            return "";
        }
        if (basePhotoModelController.i3()) {
            return "travel";
        }
        if (this.f43579c.e3()) {
            return HippyNestedScrollComponent.PRIORITY_PARENT;
        }
        if (this.f43579c.Y2()) {
            return "lover";
        }
        return "common";
    }

    @Override // com.qzone.album.business.photolist.ui.interactingbar.b
    public int a() {
        return 2;
    }

    @Override // com.qzone.album.business.photolist.ui.interactingbar.b
    public ImageView b() {
        return null;
    }

    @Override // com.qzone.album.business.photolist.ui.interactingbar.b
    public void d() {
        Activity activity = this.f43578b;
        if (activity == null || this.f43579c == null || this.f43580d == null) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) activity.findViewById(R.id.e4t);
        this.f43577a = linearLayout;
        if (linearLayout == null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) this.f43578b.findViewById(R.id.hb5);
        this.f43595f = relativeLayout;
        relativeLayout.setClickable(false);
        this.f43595f.setVisibility(8);
        RelativeLayout relativeLayout2 = (RelativeLayout) this.f43578b.findViewById(R.id.hd7);
        this.f43596g = relativeLayout2;
        relativeLayout2.setOnClickListener(new a());
        RelativeLayout relativeLayout3 = (RelativeLayout) this.f43578b.findViewById(R.id.haz);
        this.f43597h = relativeLayout3;
        relativeLayout3.setOnClickListener(new b());
        com.qzone.album.env.common.a.m().P(326, 2, "31", true, i());
        RelativeLayout relativeLayout4 = (RelativeLayout) this.f43578b.findViewById(R.id.hd9);
        this.f43598i = relativeLayout4;
        relativeLayout4.setOnClickListener(new c());
        RelativeLayout relativeLayout5 = (RelativeLayout) this.f43578b.findViewById(R.id.hcc);
        this.f43599j = relativeLayout5;
        relativeLayout5.setClickable(false);
        this.f43599j.setVisibility(8);
    }

    @Override // com.qzone.album.business.photolist.ui.interactingbar.b
    public boolean e() {
        return false;
    }

    @Override // com.qzone.album.business.photolist.ui.interactingbar.b
    public void f() {
    }

    @Override // com.qzone.album.business.photolist.ui.interactingbar.b
    public void g(int i3) {
    }

    @Override // com.qzone.album.business.photolist.ui.interactingbar.b
    public void h(boolean z16, int i3) {
    }
}
