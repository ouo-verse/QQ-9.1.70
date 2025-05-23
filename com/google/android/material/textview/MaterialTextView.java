package com.google.android.material.textview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleableRes;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.mobileqq.R;
import g1.b;
import g1.c;
import w0.a;

/* compiled from: P */
/* loaded from: classes2.dex */
public class MaterialTextView extends AppCompatTextView {
    public MaterialTextView(@NonNull Context context) {
        this(context, null);
    }

    private void a(@NonNull Resources.Theme theme, int i3) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(i3, a.f443953m5);
        int e16 = e(getContext(), obtainStyledAttributes, a.f443976o5, a.f443988p5);
        obtainStyledAttributes.recycle();
        if (e16 >= 0) {
            setLineHeight(e16);
        }
    }

    private static boolean b(Context context) {
        return b.b(context, R.attr.bfd, true);
    }

    private static int d(@NonNull Resources.Theme theme, @Nullable AttributeSet attributeSet, int i3, int i16) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, a.f444000q5, i3, i16);
        int resourceId = obtainStyledAttributes.getResourceId(a.f444012r5, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private static int e(@NonNull Context context, @NonNull TypedArray typedArray, @NonNull @StyleableRes int... iArr) {
        int i3 = -1;
        for (int i16 = 0; i16 < iArr.length && i3 < 0; i16++) {
            i3 = c.d(context, typedArray, iArr[i16], -1);
        }
        return i3;
    }

    private static boolean f(@NonNull Context context, @NonNull Resources.Theme theme, @Nullable AttributeSet attributeSet, int i3, int i16) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, a.f444000q5, i3, i16);
        int e16 = e(context, obtainStyledAttributes, a.f444024s5, a.f444036t5);
        obtainStyledAttributes.recycle();
        if (e16 == -1) {
            return false;
        }
        return true;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextAppearance(@NonNull Context context, int i3) {
        super.setTextAppearance(context, i3);
        if (b(context)) {
            a(context.getTheme(), i3);
        }
    }

    public MaterialTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, android.R.attr.textViewStyle);
    }

    public MaterialTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public MaterialTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(k1.a.c(context, attributeSet, i3, i16), attributeSet, i3);
        int d16;
        Context context2 = getContext();
        if (b(context2)) {
            Resources.Theme theme = context2.getTheme();
            if (f(context2, theme, attributeSet, i3, i16) || (d16 = d(theme, attributeSet, i3, i16)) == -1) {
                return;
            }
            a(theme, d16);
        }
    }
}
