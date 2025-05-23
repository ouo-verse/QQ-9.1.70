package com.tencent.open.base;

import android.text.InputFilter;
import android.text.Spanned;
import android.widget.EditText;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e implements InputFilter {

    /* renamed from: d, reason: collision with root package name */
    protected EditText f340971d;

    /* renamed from: e, reason: collision with root package name */
    protected int f340972e;

    public e(EditText editText, int i3) {
        this.f340971d = editText;
        this.f340972e = i3;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
        int c16;
        int i19;
        int c17 = this.f340972e - j.c(new StringBuilder(this.f340971d.getEditableText().toString()).toString());
        int c18 = j.c(charSequence.subSequence(i3, i16).toString());
        if (c17 <= 0) {
            return "";
        }
        if (c17 >= c18) {
            return null;
        }
        int i26 = i3;
        while (i26 < i16) {
            if (Character.isHighSurrogate(charSequence.charAt(i26))) {
                c16 = j.c(charSequence.subSequence(i26, i26 + 2).toString());
                i19 = 2;
            } else {
                c16 = j.c(String.valueOf(charSequence.charAt(i26)));
                i19 = 1;
            }
            c17 -= c16;
            if (c17 < 0) {
                break;
            }
            i26 += i19;
        }
        if (i26 == i3) {
            return "";
        }
        return charSequence.subSequence(i3, i26);
    }
}
