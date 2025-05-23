package com.tencent.aelight.camera.ae.flashshow.tips;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends c {

    /* renamed from: d, reason: collision with root package name */
    private View f64399d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f64400e;

    public a(ViewStub viewStub) {
        super(viewStub);
    }

    public void g() {
        if (d()) {
            this.f64399d.setVisibility(8);
            this.f64400e.setVisibility(8);
        }
    }

    public void h() {
        if (d()) {
            this.f64400e.setVisibility(8);
        }
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.tips.c
    protected void e(View view) {
        this.f64399d = view.findViewById(R.id.f163752rt4);
        this.f64400e = (TextView) view.findViewById(R.id.rt5);
    }
}
