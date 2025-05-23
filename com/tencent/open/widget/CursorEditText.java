package com.tencent.open.widget;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.widget.EditText;

/* compiled from: P */
/* loaded from: classes22.dex */
public class CursorEditText extends EditText {

    /* renamed from: d, reason: collision with root package name */
    protected Class<?> f341790d;

    public CursorEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int i3, int i16) {
        super.onSelectionChanged(i3, i16);
        if (this.f341790d == null) {
            return;
        }
        Editable editableText = super.getEditableText();
        int i17 = 0;
        Object[] spans = editableText.getSpans(0, editableText.length(), this.f341790d);
        for (Object obj : spans) {
            int spanStart = editableText.getSpanStart(obj);
            if (i3 < editableText.getSpanEnd(obj) && i3 > spanStart) {
                int length = spans.length;
                while (i17 < length) {
                    Object obj2 = spans[i17];
                    int spanStart2 = editableText.getSpanStart(obj2);
                    int spanEnd = editableText.getSpanEnd(obj2);
                    if (i16 < spanEnd && i16 > spanStart2) {
                        super.setSelection(spanEnd);
                        return;
                    }
                    i17++;
                }
                super.setSelection(i16);
                return;
            }
        }
        int length2 = spans.length;
        while (i17 < length2) {
            Object obj3 = spans[i17];
            int spanStart3 = editableText.getSpanStart(obj3);
            if (i16 < editableText.getSpanEnd(obj3) && i16 > spanStart3) {
                super.setSelection(i3);
                return;
            }
            i17++;
        }
        super.setSelection(i3, i16);
    }

    public void setSpannedClassToSkip(Class<?> cls) {
        this.f341790d = cls;
    }
}
