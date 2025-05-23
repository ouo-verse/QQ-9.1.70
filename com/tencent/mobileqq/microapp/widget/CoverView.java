package com.tencent.mobileqq.microapp.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class CoverView extends TextView {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f246073a;

    public CoverView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    public void a(int i3, int i16, float f16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16), Integer.valueOf(i17));
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i17);
        gradientDrawable.setCornerRadius(f16);
        if (i3 > 0) {
            gradientDrawable.setStroke(i3, i16);
        }
        setBackgroundDrawable(gradientDrawable);
    }
}
