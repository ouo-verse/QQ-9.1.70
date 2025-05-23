package com.tencent.mobileqq.troop.utils;

import android.content.res.Resources;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static Drawable a(Resources resources, int i3) {
        return b(resources, i3, resources.getDrawable(R.drawable.b3n));
    }

    public static Drawable b(Resources resources, int i3, Drawable drawable) {
        Drawable mutate = drawable.getConstantState().newDrawable(resources).mutate();
        mutate.setColorFilter(new LightingColorFilter(-16777216, i3));
        mutate.setAlpha(i3 >>> 24);
        return mutate;
    }
}
