package com.tencent.luggage.wxa.ol;

import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.EditText;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum b {
    ;

    public static b valueOf(String str) {
        com.tencent.luggage.wxa.k0.d.a(Enum.valueOf(b.class, str));
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(EditText editText, com.tencent.luggage.wxa.vl.i iVar) {
        Typeface create;
        if (editText == 0 || iVar == null) {
            return;
        }
        Float f16 = iVar.f143673k;
        if (f16 != null && f16.floatValue() != editText.getTextSize()) {
            editText.setTextSize(iVar.f143673k.floatValue());
        }
        Integer num = iVar.f143672j;
        if (num != null) {
            editText.setTextColor(num.intValue());
        }
        if (iVar.f143671i != null) {
            if (editText.getBackground() == null || !(editText.getBackground() instanceof ColorDrawable) || ((ColorDrawable) editText.getBackground()).getColor() != iVar.f143671i.intValue()) {
                editText.setBackground(new ColorDrawable(iVar.f143671i.intValue()));
            }
        } else {
            editText.setBackground(null);
        }
        String str = iVar.f143677o;
        if (str != null) {
            if (TextUtils.isEmpty(str)) {
                editText.setHint("");
            } else {
                editText.setHint(a(iVar));
            }
        }
        String str2 = iVar.f143675m;
        if (str2 != null && (create = Typeface.create("sans-serif", com.tencent.luggage.wxa.vl.d.a(str2).f143662a)) != null) {
            editText.setTypeface(create);
        }
        q0 q0Var = (q0) editText;
        com.tencent.luggage.wxa.vl.h.a(iVar.f143670h).a(q0Var);
        editText.setVisibility(a1.a(iVar.f143682t) ? 8 : 0);
        q0Var.setFixed(a1.a(iVar.f143686x));
    }

    public static Spanned a(com.tencent.luggage.wxa.vl.i iVar) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(iVar.f143677o);
        int length = iVar.f143677o.length();
        spannableStringBuilder.setSpan(new StyleSpan(com.tencent.luggage.wxa.vl.d.a(iVar.f143678p).f143662a), 0, length, 18);
        if (iVar.f143680r != null) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(iVar.f143680r.intValue()), 0, length, 18);
        }
        if (iVar.f143679q != null) {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(iVar.f143679q.intValue(), false), 0, length, 18);
        }
        return spannableStringBuilder;
    }

    public static void a(EditText editText, int i3, int i16) {
        if (editText != null && editText.getEditableText() != null) {
            if (i3 <= -2) {
                i3 = editText.getSelectionStart();
            } else if (i3 == -1 || i3 > editText.getText().length()) {
                i3 = editText.getText().length();
            }
            if (i16 <= -2) {
                i16 = editText.getSelectionEnd();
            } else if (i16 == -1 || i16 > editText.getText().length()) {
                i16 = editText.getText().length();
            }
            if (i3 > i16) {
                i3 = i16;
            }
            Selection.removeSelection(editText.getEditableText());
            editText.setSelection(i3, i16);
            return;
        }
        com.tencent.luggage.wxa.tn.w.h("MicroMsg.AppBrandInputCommStyleHelper", "applySelection, invalid input %s", editText);
    }
}
