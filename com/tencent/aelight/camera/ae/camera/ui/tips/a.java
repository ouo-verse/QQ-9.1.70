package com.tencent.aelight.camera.ae.camera.ui.tips;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends com.tencent.aelight.camera.ae.camera.ui.a {

    /* renamed from: h, reason: collision with root package name */
    private View f63308h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f63309i;

    public a(ViewStub viewStub) {
        super(viewStub);
    }

    public void n() {
        if (k()) {
            this.f63308h.setVisibility(8);
            this.f63309i.setVisibility(8);
        }
    }

    public void o() {
        if (k()) {
            this.f63309i.setVisibility(8);
        }
    }

    public void show() {
        i();
        this.f63308h.setVisibility(0);
        this.f63309i.setVisibility(0);
        this.f63309i.setText(R.string.y8h);
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.a
    protected void l(View view) {
        this.f63308h = view.findViewById(R.id.f163752rt4);
        this.f63309i = (TextView) view.findViewById(R.id.rt5);
    }
}
