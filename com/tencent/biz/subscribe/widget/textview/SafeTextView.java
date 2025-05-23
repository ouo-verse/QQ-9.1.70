package com.tencent.biz.subscribe.widget.textview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SafeTextView extends TextView {
    public SafeTextView(Context context) {
        this(context, null);
    }

    public static boolean a(String str) {
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (!c(str.charAt(i3))) {
                return true;
            }
        }
        return false;
    }

    public static String b(String str) {
        if (str != null && str.length() > 0) {
            if (!a(str)) {
                return str;
            }
            int length = str.length();
            StringBuilder sb5 = null;
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = str.charAt(i3);
                if (c(charAt)) {
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

    private static boolean c(char c16) {
        if (c16 != 0 && c16 != '\t' && c16 != '\n' && c16 != '\r' && ((c16 < ' ' || c16 > '\ud7ff') && (c16 < '\ue000' || c16 > '\ufffd'))) {
            return false;
        }
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i3, int i16) {
        try {
            try {
                super.onMeasure(i3, i16);
            } catch (Throwable unused) {
                setText("");
                super.onMeasure(i3, i16);
            }
        } catch (Throwable unused2) {
            setText(b(getText().toString()));
            super.onMeasure(i3, i16);
        }
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        try {
            try {
                super.setText(charSequence, bufferType);
            } catch (Throwable unused) {
                super.setText(b(getText().toString()), bufferType);
            }
        } catch (Throwable unused2) {
            setText("");
        }
    }

    public SafeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SafeTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
