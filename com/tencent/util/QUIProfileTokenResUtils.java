package com.tencent.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes27.dex */
public class QUIProfileTokenResUtils {
    static IPatchRedirector $redirector_;

    public QUIProfileTokenResUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static ColorStateList getColorStateList(View view, int i3) {
        return getColorStateList(view.getContext(), de0.c.a(view), i3);
    }

    public static Drawable getDrawable(View view, int i3) {
        return getDrawable(view.getContext(), de0.c.a(view), i3);
    }

    public static ColorStateList getColorStateList(Context context, be0.a aVar, int i3) {
        ColorStateList colorStateList = context.getResources().getColorStateList(i3, null);
        return aVar != null ? aVar.d(colorStateList) : colorStateList;
    }

    public static Drawable getDrawable(Context context, be0.a aVar, int i3) {
        Drawable drawable = ResourcesCompat.getDrawable(context.getResources(), i3, null);
        return aVar != null ? aVar.e(context, drawable) : drawable;
    }
}
