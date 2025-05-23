package com.tencent.mobileqq.gamecenter.qa.view;

import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b implements TextWatcher {

    /* renamed from: d, reason: collision with root package name */
    private a f213036d = null;

    private static boolean a(int i3, int i16, int i17) {
        if (i3 > i16 && i3 < i17) {
            return true;
        }
        return false;
    }

    private static void b(EditText editText, int i3, int i16, Spanned spanned, a[] aVarArr) {
        for (a aVar : aVarArr) {
            int spanStart = spanned.getSpanStart(aVar);
            int spanEnd = spanned.getSpanEnd(aVar);
            if (spanStart >= 0) {
                int e16 = e(i3, spanStart, spanEnd);
                int d16 = d(e16, i16, spanStart, spanEnd);
                if (i3 != e16 || i16 != d16) {
                    editText.setSelection(e16, d16);
                    return;
                }
                return;
            }
        }
    }

    public static void c(EditText editText, int i3, int i16) {
        a[] aVarArr;
        Editable editableText = editText.getEditableText();
        if (editableText != null && (aVarArr = (a[]) editableText.getSpans(i3, i16, a.class)) != null && aVarArr.length > 0) {
            b(editText, i3, i16, editableText, aVarArr);
        }
    }

    private static int d(int i3, int i16, int i17, int i18) {
        if (a(i16, i17, i18)) {
            i16 = i18;
        }
        if (i16 >= i3) {
            return i16;
        }
        return i3;
    }

    private static int e(int i3, int i16, int i17) {
        if (a(i3, i16, i17)) {
            return i17;
        }
        return i3;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        QLog.d("DeleteAsAWholeWatcher", 2, "afterTextChanged: s: " + ((Object) editable));
        a aVar = this.f213036d;
        if (aVar != null) {
            int spanStart = editable.getSpanStart(aVar);
            int spanEnd = editable.getSpanEnd(this.f213036d);
            if (spanStart >= 0 && spanEnd <= editable.length()) {
                editable.delete(spanStart, spanEnd);
                this.f213036d.a();
                this.f213036d = null;
            }
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        boolean z16;
        int i18 = i3 + i17;
        if (i17 >= i16) {
            return;
        }
        if (i16 > 0 && i16 == charSequence.length() && i17 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            a[] aVarArr = (a[]) spanned.getSpans(0, charSequence.length(), a.class);
            if (aVarArr != null && aVarArr.length > 0) {
                int length = aVarArr.length;
                for (int i19 = 0; i19 < length; i19++) {
                    if (z16 && length > 1) {
                        aVarArr[i19].a();
                    } else {
                        int spanStart = spanned.getSpanStart(aVarArr[i19]);
                        int spanEnd = spanned.getSpanEnd(aVarArr[i19]);
                        if (spanStart <= i18 && i18 < spanEnd) {
                            this.f213036d = aVarArr[i19];
                            return;
                        }
                    }
                }
            }
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        QLog.d("DeleteAsAWholeWatcher", 2, "onTextChanged: s: " + ((Object) charSequence) + " start: " + i3 + " before: " + i16 + " count: " + i17);
    }
}
