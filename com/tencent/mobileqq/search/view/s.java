package com.tencent.mobileqq.search.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public class s extends sn2.f {
    public ImageView C;
    public TextView D;
    public LinearLayout E;

    /* renamed from: i, reason: collision with root package name */
    public View f285166i;

    /* renamed from: m, reason: collision with root package name */
    public TextView f285167m;

    public s() {
    }

    public LinearLayout a() {
        return this.E;
    }

    public s(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bxh, viewGroup, false);
        this.f433995d = inflate;
        View findViewById = inflate.findViewById(R.id.f0a);
        this.f285166i = findViewById;
        this.f285167m = (TextView) findViewById.findViewById(R.id.e0z);
        this.C = (ImageView) this.f285166i.findViewById(R.id.image);
        this.D = (TextView) this.f285166i.findViewById(R.id.bgt);
        this.E = (LinearLayout) this.f433995d.findViewById(R.id.ecl);
    }
}
