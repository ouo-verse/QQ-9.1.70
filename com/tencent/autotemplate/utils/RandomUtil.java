package com.tencent.autotemplate.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes3.dex */
public class RandomUtil {
    static IPatchRedirector $redirector_;

    public RandomUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int RandomInt(int i3, int i16) {
        return new Random().nextInt(i16 - i3) + i3;
    }
}
