package com.tencent.intervideo.nowproxy.common.util;

import android.content.Context;
import com.tencent.intervideo.nowproxy.ability.SdkBaseAbilityImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ToastUtil {
    static IPatchRedirector $redirector_;

    public ToastUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void show(Context context, CharSequence charSequence, int i3) {
        SdkBaseAbilityImpl.getsInstance().showToast(context, charSequence, i3);
    }
}
