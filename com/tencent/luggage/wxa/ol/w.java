package com.tencent.luggage.wxa.ol;

import android.content.Context;
import android.view.View;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class w extends u {
    public w(Context context) {
        super(com.tencent.luggage.wxa.ye.c.a(context));
    }

    @Override // com.tencent.luggage.wxa.ol.i0, com.tencent.luggage.wxa.ol.q0
    public View getInputPanel() {
        return f0.a((View) this);
    }

    @Override // com.tencent.luggage.wxa.ol.i0
    public void k() {
        try {
            a1.b(this).restartInput(this);
        } catch (RuntimeException e16) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.Wxa.AppBrandInputWidgetSingleLineWithSoftKeyboard", "ensureInputConnection restartInput re=%s", e16);
            try {
                a1.b(this).showSoftInput(this, 0);
            } catch (RuntimeException e17) {
                com.tencent.luggage.wxa.tn.w.b("Luggage.Wxa.AppBrandInputWidgetSingleLineWithSoftKeyboard", "ensureInputConnection showSoftInput re=%s", e17);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.ol.i0
    public void setPasswordMode(boolean z16) {
        int i3;
        n();
        int inputType = getInputType() | 1;
        if (z16) {
            i3 = inputType | 128;
        } else {
            i3 = inputType & (-129);
        }
        setInputType(i3);
        super.setPasswordMode(z16);
        p();
    }
}
