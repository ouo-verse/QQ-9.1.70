package com.tencent.android.androidbypass.enhance.inlinekeyboard.view;

import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnStyleSheet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public final /* synthetic */ class b {
    @Nullable
    public static Drawable a(InlineBtnStyleSheet inlineBtnStyleSheet) {
        IPatchRedirector iPatchRedirector = InlineBtnStyleSheet.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Drawable) iPatchRedirector.redirect((short) 6, (Object) inlineBtnStyleSheet);
        }
        return null;
    }

    @DrawableRes
    public static int b(InlineBtnStyleSheet inlineBtnStyleSheet) {
        IPatchRedirector iPatchRedirector = InlineBtnStyleSheet.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) inlineBtnStyleSheet)).intValue();
        }
        return 0;
    }

    public static int c(InlineBtnStyleSheet inlineBtnStyleSheet) {
        IPatchRedirector iPatchRedirector = InlineBtnStyleSheet.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) inlineBtnStyleSheet)).intValue();
        }
        return 0;
    }

    @Nullable
    public static Drawable d(InlineBtnStyleSheet inlineBtnStyleSheet) {
        IPatchRedirector iPatchRedirector = InlineBtnStyleSheet.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Drawable) iPatchRedirector.redirect((short) 2, (Object) inlineBtnStyleSheet);
        }
        return null;
    }

    @DrawableRes
    public static int e(InlineBtnStyleSheet inlineBtnStyleSheet) {
        IPatchRedirector iPatchRedirector = InlineBtnStyleSheet.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, (Object) inlineBtnStyleSheet)).intValue();
        }
        return 0;
    }

    @Nullable
    public static Drawable f(InlineBtnStyleSheet inlineBtnStyleSheet) {
        IPatchRedirector iPatchRedirector = InlineBtnStyleSheet.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Drawable) iPatchRedirector.redirect((short) 7, (Object) inlineBtnStyleSheet);
        }
        return null;
    }

    @Nullable
    public static Drawable g(InlineBtnStyleSheet inlineBtnStyleSheet) {
        IPatchRedirector iPatchRedirector = InlineBtnStyleSheet.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Drawable) iPatchRedirector.redirect((short) 4, (Object) inlineBtnStyleSheet);
        }
        return null;
    }

    @DrawableRes
    public static int h(InlineBtnStyleSheet inlineBtnStyleSheet) {
        IPatchRedirector iPatchRedirector = InlineBtnStyleSheet.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) inlineBtnStyleSheet)).intValue();
        }
        return 0;
    }

    public static InlineBtnStyleSheet.BtnType i(InlineBtnStyleSheet inlineBtnStyleSheet) {
        IPatchRedirector iPatchRedirector = InlineBtnStyleSheet.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (InlineBtnStyleSheet.BtnType) iPatchRedirector.redirect((short) 10, (Object) inlineBtnStyleSheet);
        }
        return InlineBtnStyleSheet.BtnType.NORMAL;
    }
}
