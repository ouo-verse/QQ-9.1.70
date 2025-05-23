package com.airbnb.lottie;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import androidx.annotation.ColorInt;

/* compiled from: P */
/* loaded from: classes.dex */
public class SimpleColorFilter extends PorterDuffColorFilter {
    public SimpleColorFilter(@ColorInt int i3) {
        super(i3, PorterDuff.Mode.SRC_ATOP);
    }
}
