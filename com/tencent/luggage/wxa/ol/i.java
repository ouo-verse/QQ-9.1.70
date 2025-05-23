package com.tencent.luggage.wxa.ol;

import android.text.Editable;
import android.view.inputmethod.BaseInputConnection;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class i extends j0 {

    /* renamed from: e, reason: collision with root package name */
    public final String f136760e;

    /* renamed from: f, reason: collision with root package name */
    public final BaseInputConnection f136761f;

    public i(String str, BaseInputConnection baseInputConnection) {
        super(null, 1, null);
        this.f136760e = str;
        this.f136761f = baseInputConnection;
    }

    @Override // com.tencent.luggage.wxa.ol.s0
    public String a() {
        Editable editable;
        BaseInputConnection baseInputConnection = this.f136761f;
        if (baseInputConnection != null && (editable = baseInputConnection.getEditable()) != null) {
            return editable.toString();
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.ol.s0
    public String getInputType() {
        return this.f136760e;
    }
}
