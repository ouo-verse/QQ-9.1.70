package com.airbnb.lottie.animation;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.NonNull;
import com.airbnb.lottie.utils.MiscUtils;

/* loaded from: classes.dex */
public class LPaint extends Paint {
    public LPaint() {
    }

    @Override // android.graphics.Paint
    public void setAlpha(int i3) {
        if (Build.VERSION.SDK_INT < 30) {
            setColor((MiscUtils.clamp(i3, 0, 255) << 24) | (getColor() & 16777215));
        } else {
            super.setAlpha(MiscUtils.clamp(i3, 0, 255));
        }
    }

    public LPaint(int i3) {
        super(i3);
    }

    public LPaint(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }

    public LPaint(int i3, PorterDuff.Mode mode) {
        super(i3);
        setXfermode(new PorterDuffXfermode(mode));
    }

    @Override // android.graphics.Paint
    public void setTextLocales(@NonNull LocaleList localeList) {
    }
}
