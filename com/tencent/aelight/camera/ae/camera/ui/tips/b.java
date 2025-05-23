package com.tencent.aelight.camera.ae.camera.ui.tips;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b extends com.tencent.aelight.camera.ae.camera.ui.a {

    /* renamed from: h, reason: collision with root package name */
    private View f63310h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f63311i;

    public b(ViewStub viewStub) {
        super(viewStub);
    }

    public void n() {
        if (k()) {
            this.f63310h.setVisibility(8);
            this.f63311i.setVisibility(8);
        }
    }

    public void o() {
        if (k()) {
            this.f63311i.setVisibility(8);
        }
    }

    public void show() {
        i();
        this.f63310h.setVisibility(0);
        this.f63311i.setVisibility(0);
        this.f63311i.setText(R.string.y8h);
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.a
    protected void l(View view) {
        this.f63310h = view.findViewById(R.id.f163751rt3);
        this.f63311i = (TextView) view.findViewById(R.id.f163750rt2);
    }
}
