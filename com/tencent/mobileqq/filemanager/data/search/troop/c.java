package com.tencent.mobileqq.filemanager.data.search.troop;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c implements sn2.c {

    /* renamed from: d, reason: collision with root package name */
    private View f207963d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f207964e;

    /* renamed from: f, reason: collision with root package name */
    private EllipsizingTextView f207965f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f207966h;

    public c(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ame, viewGroup, false);
        this.f207963d = inflate;
        this.f207964e = (ImageView) inflate.findViewById(R.id.c_5);
        this.f207965f = (EllipsizingTextView) this.f207963d.findViewById(R.id.c_g);
        this.f207966h = (TextView) this.f207963d.findViewById(R.id.bg6);
        this.f207965f.setMaxLines(1);
        this.f207965f.setEllipsize(TextUtils.TruncateAt.MIDDLE);
    }

    @Override // sn2.c
    public TextView b() {
        return this.f207965f;
    }

    @Override // sn2.c
    public TextView c() {
        return null;
    }

    @Override // sn2.c
    public TextView d() {
        return null;
    }

    @Override // sn2.a
    public ImageView f() {
        return this.f207964e;
    }

    @Override // sn2.c
    public ImageView g() {
        return null;
    }

    @Override // sn2.d
    public View getView() {
        return this.f207963d;
    }

    @Override // sn2.c
    public View h(String str) {
        return null;
    }

    @Override // sn2.c
    public TextView k() {
        return this.f207966h;
    }
}
