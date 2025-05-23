package com.tencent.tdf.embed;

import android.graphics.Rect;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public final /* synthetic */ class b {
    public static Rect a(IGestureInfoProvider iGestureInfoProvider) {
        IPatchRedirector iPatchRedirector = IGestureInfoProvider.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Rect) iPatchRedirector.redirect((short) 2, (Object) iGestureInfoProvider);
        }
        return new Rect();
    }

    public static boolean b(IGestureInfoProvider iGestureInfoProvider) {
        IPatchRedirector iPatchRedirector = IGestureInfoProvider.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) iGestureInfoProvider)).booleanValue();
        }
        return false;
    }
}
