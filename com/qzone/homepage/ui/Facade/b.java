package com.qzone.homepage.ui.Facade;

import android.R;
import android.content.res.ColorStateList;
import android.view.View;
import com.qzone.homepage.ui.Facade.ui.EditableView;
import com.qzone.homepage.ui.Facade.ui.FacadeView;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b extends i {

    /* renamed from: l, reason: collision with root package name */
    public String f47553l;

    /* renamed from: m, reason: collision with root package name */
    public String f47554m;

    /* renamed from: n, reason: collision with root package name */
    public int f47555n;

    /* renamed from: o, reason: collision with root package name */
    public int f47556o;

    /* renamed from: p, reason: collision with root package name */
    public int f47557p;

    /* renamed from: q, reason: collision with root package name */
    public int f47558q;

    /* renamed from: r, reason: collision with root package name */
    public int f47559r;

    /* renamed from: s, reason: collision with root package name */
    public int f47560s;

    /* renamed from: t, reason: collision with root package name */
    private EditableView f47561t;

    @Override // com.qzone.homepage.ui.Facade.i
    public View c(FacadeView facadeView) {
        EditableView editableView = new EditableView(facadeView.getContext());
        this.f47561t = editableView;
        editableView.setDefaultText(this.f47554m);
        this.f47561t.setText(this.f47553l);
        this.f47561t.setTextSize(this.f47557p);
        this.f47561t.setTopOfText(this.f47559r);
        this.f47561t.setHeighOfText(this.f47560s);
        this.f47561t.setGravity(this.f47558q);
        this.f47561t.setSplashMode(facadeView.j() == 1);
        this.f47561t.setIndex(this.f47609a);
        int i3 = this.f47556o;
        if (i3 != 0) {
            this.f47561t.setTextColor(new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[0]}, new int[]{i3, this.f47555n}));
        } else {
            this.f47561t.setTextColor(this.f47555n);
        }
        if (facadeView.m()) {
            this.f47561t.setEditable(true);
        } else {
            this.f47561t.setEditable(false);
        }
        if (facadeView.i() != null && facadeView.k() != 0) {
            this.f47561t.setFacadeEditRequest(facadeView.i(), facadeView.k());
        }
        return this.f47561t;
    }
}
