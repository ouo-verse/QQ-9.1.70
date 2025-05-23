package com.tencent.commonsdk.util;

import android.annotation.SuppressLint;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import okio.Utf8;

/* compiled from: P */
@SuppressLint({"UseValueOf"})
/* loaded from: classes5.dex */
public class LargerInteger {
    static IPatchRedirector $redirector_ = null;
    private static final Integer[] LARGER_VALUES;
    private static final int MAX = 4096;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13179);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        LARGER_VALUES = new Integer[Utf8.MASK_2BYTES];
        for (int i3 = 128; i3 < 4096; i3++) {
            LARGER_VALUES[i3 - 128] = new Integer(i3);
        }
    }

    public LargerInteger() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Integer valueOf(int i3) {
        if (i3 >= 128 && i3 < 4096) {
            return LARGER_VALUES[i3 - 128];
        }
        return Integer.valueOf(i3);
    }
}
