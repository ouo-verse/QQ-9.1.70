package com.qzone.proxy.feedcomponent.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/* compiled from: P */
/* loaded from: classes39.dex */
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

    static boolean c(char c16) {
        if (c16 != 0 && c16 != '\t' && c16 != '\n' && c16 != '\r' && ((c16 < ' ' || c16 > '\ud7ff') && ((c16 < '\ue000' || c16 > '\ufffd') && (c16 < 0 || c16 > '\uffff')))) {
            return false;
        }
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i3, int i16) {
        try {
            super.onMeasure(i3, i16);
        } catch (Throwable unused) {
            Log.d("SafeTextView", "--SafeTextView onMeasure fail--" + getText().toString());
            try {
                setText(b(getText().toString()));
                super.onMeasure(i3, i16);
            } catch (Throwable unused2) {
                setText("");
                super.onMeasure(i3, i16);
            }
        }
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        try {
            super.setText(charSequence, bufferType);
        } catch (Throwable unused) {
            Log.d("-- setText fail--", getText().toString());
            try {
                super.setText(b(getText().toString()), bufferType);
            } catch (Throwable unused2) {
                setText("");
            }
        }
    }

    public SafeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SafeTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    public static String b(String str) {
        if (str == null || str.length() <= 0 || !a(str)) {
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
        return sb5.length() == length ? str : sb5.toString();
    }
}
