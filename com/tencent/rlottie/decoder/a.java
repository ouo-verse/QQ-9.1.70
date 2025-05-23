package com.tencent.rlottie.decoder;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.photoplus.sticker.Sticker;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static boolean a(String str) {
        return str.substring(str.lastIndexOf(".")).equalsIgnoreCase(Sticker.JSON_SUFFIX);
    }
}
