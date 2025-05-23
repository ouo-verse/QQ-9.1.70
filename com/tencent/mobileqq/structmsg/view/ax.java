package com.tencent.mobileqq.structmsg.view;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ax {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static ax f290630a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75630);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f290630a = null;
        }
    }

    ax() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            f290630a = this;
        }
    }

    public static ax a() {
        if (f290630a == null) {
            f290630a = new ax();
        }
        return f290630a;
    }

    public Drawable b(Resources resources, int i3) {
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Drawable) iPatchRedirector.redirect((short) 2, (Object) this, (Object) resources, i3);
        }
        Object g16 = ImageCacheHelper.f98636a.g(String.valueOf(i3));
        if (g16 instanceof Drawable) {
            return (Drawable) g16;
        }
        try {
            drawable = resources.getDrawable(i3);
        } catch (OutOfMemoryError unused) {
            QLog.e("ViewCache", 1, "getDrawable oom");
            drawable = null;
        }
        if (drawable != null) {
            ImageCacheHelper.f98636a.i(String.valueOf(i3), drawable, Business.AIO);
        }
        return drawable;
    }
}
