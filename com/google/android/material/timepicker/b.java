package com.google.android.material.timepicker;

import android.text.InputFilter;
import android.text.Spanned;

/* compiled from: P */
/* loaded from: classes2.dex */
class b implements InputFilter {

    /* renamed from: d, reason: collision with root package name */
    private int f34493d;

    public b(int i3) {
        this.f34493d = i3;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
        try {
            StringBuilder sb5 = new StringBuilder(spanned);
            sb5.replace(i17, i18, charSequence.subSequence(i3, i16).toString());
            if (Integer.parseInt(sb5.toString()) <= this.f34493d) {
                return null;
            }
            return "";
        } catch (NumberFormatException unused) {
            return "";
        }
    }
}
