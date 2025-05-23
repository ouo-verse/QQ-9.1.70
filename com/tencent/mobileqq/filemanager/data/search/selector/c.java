package com.tencent.mobileqq.filemanager.data.search.selector;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c implements sn2.c {

    /* renamed from: d, reason: collision with root package name */
    private View f207937d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f207938e;

    /* renamed from: f, reason: collision with root package name */
    private EllipsizingTextView f207939f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f207940h;

    /* renamed from: i, reason: collision with root package name */
    private CheckBox f207941i;

    public c(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ame, viewGroup, false);
        this.f207937d = inflate;
        this.f207938e = (ImageView) inflate.findViewById(R.id.c_5);
        this.f207939f = (EllipsizingTextView) this.f207937d.findViewById(R.id.c_g);
        this.f207940h = (TextView) this.f207937d.findViewById(R.id.bg6);
        this.f207939f.setMaxLines(1);
        this.f207939f.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        CheckBox checkBox = (CheckBox) this.f207937d.findViewById(R.id.c_i);
        this.f207941i = checkBox;
        checkBox.setVisibility(0);
    }

    @Override // sn2.c
    public TextView b() {
        return this.f207939f;
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
        return this.f207938e;
    }

    @Override // sn2.c
    public ImageView g() {
        return null;
    }

    @Override // sn2.d
    public View getView() {
        return this.f207937d;
    }

    @Override // sn2.c
    public View h(String str) {
        return null;
    }

    @Override // sn2.c
    public TextView k() {
        return this.f207940h;
    }
}
