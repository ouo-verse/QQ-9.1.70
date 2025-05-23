package com.tencent.misc.utils;

import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static void a(TextView textView) {
        if (textView == null) {
            return;
        }
        com.tencent.od.common.util.a.b(textView, false);
    }

    public static void b(TextView textView) {
        if (textView == null) {
            return;
        }
        com.tencent.od.common.util.a.b(textView, true);
    }
}
