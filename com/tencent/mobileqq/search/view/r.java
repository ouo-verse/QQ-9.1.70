package com.tencent.mobileqq.search.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class r extends s {
    public LinearLayout F;

    public r(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bxf, viewGroup, false);
        this.f433995d = inflate;
        this.f433997f = (TextView) inflate.findViewById(R.id.ezq);
        this.F = (LinearLayout) this.f433995d.findViewById(R.id.ecl);
        this.f433998h = new ArrayList();
        View findViewById = this.f433995d.findViewById(R.id.f0a);
        this.f285166i = findViewById;
        this.f285167m = (TextView) findViewById.findViewById(R.id.e0z);
    }

    @Override // com.tencent.mobileqq.search.view.s
    public LinearLayout a() {
        return this.F;
    }
}
