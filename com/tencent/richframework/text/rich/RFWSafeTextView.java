package com.tencent.richframework.text.rich;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RFWSafeTextView extends AppCompatTextView {
    public RFWSafeTextView(Context context) {
        this(context, null);
    }

    public static boolean containsEmoji(String str) {
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (!isNormalCharacter(str.charAt(i3))) {
                return true;
            }
        }
        return false;
    }

    public static String filterEmoji(String str) {
        if (str != null && str.length() > 0) {
            if (!containsEmoji(str)) {
                return str;
            }
            int length = str.length();
            StringBuilder sb5 = null;
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = str.charAt(i3);
                if (isNormalCharacter(charAt)) {
                    if (sb5 == null) {
                        sb5 = new StringBuilder(str.length());
                    }
                    sb5.append(charAt);
                }
            }
            if (sb5 == null) {
                return "";
            }
            if (sb5.length() == length) {
                return str;
            }
            return sb5.toString();
        }
        return str;
    }

    private static boolean isNormalCharacter(char c16) {
        if (c16 != 0 && c16 != '\t' && c16 != '\n' && c16 != '\r' && ((c16 < ' ' || c16 > '\ud7ff') && (c16 < '\ue000' || c16 > '\ufffd'))) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i3, int i16) {
        try {
            try {
                super.onMeasure(i3, i16);
            } catch (Throwable unused) {
                setText("");
                super.onMeasure(i3, i16);
            }
        } catch (Throwable unused2) {
            setText(filterEmoji(getText().toString()));
            super.onMeasure(i3, i16);
        }
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        try {
            try {
                super.setText(charSequence, bufferType);
            } catch (Throwable unused) {
                super.setText(filterEmoji(getText().toString()), bufferType);
            }
        } catch (Throwable unused2) {
            setText("");
        }
    }

    public RFWSafeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RFWSafeTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
