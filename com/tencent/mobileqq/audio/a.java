package com.tencent.mobileqq.audio;

import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static boolean a() {
        return "true".equals(AVBizModuleFactory.getModuleByName("ptt").checkAVFocus());
    }

    public static String b(double d16) {
        int i3 = (int) (d16 / 1000.0d);
        return String.format(Locale.getDefault(), "%02d", Integer.valueOf(i3 / 60)) + ProgressTracer.SEPARATOR + String.format(Locale.getDefault(), "%02d", Integer.valueOf(i3 % 60));
    }
}
