package com.tencent.aelight.camera.ae.flashshow.tips;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b extends c {

    /* renamed from: d, reason: collision with root package name */
    private View f64401d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f64402e;

    public b(ViewStub viewStub) {
        super(viewStub);
    }

    public void g() {
        if (d()) {
            this.f64401d.setVisibility(8);
            this.f64402e.setVisibility(8);
        }
    }

    public void h() {
        if (d()) {
            this.f64402e.setVisibility(8);
        }
    }

    public void i() {
        c();
        this.f64401d.setVisibility(0);
        this.f64402e.setVisibility(0);
        this.f64402e.setText(R.string.y8h);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.tips.c
    protected void e(View view) {
        this.f64401d = view.findViewById(R.id.f163751rt3);
        this.f64402e = (TextView) view.findViewById(R.id.f163750rt2);
    }
}
