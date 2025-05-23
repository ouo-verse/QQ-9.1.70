package com.tencent.mobileqq.utils;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ar implements TextWatcher {

    /* renamed from: d, reason: collision with root package name */
    private String f307435d = "";

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable != null && editable.toString().getBytes().length > 24) {
            for (int i3 = 1; i3 < editable.length() && editable.toString().substring(0, i3).getBytes().length <= 24; i3++) {
            }
            editable.replace(0, editable.length(), this.f307435d);
        }
        if (editable != null) {
            this.f307435d = editable.toString();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
    }
}
