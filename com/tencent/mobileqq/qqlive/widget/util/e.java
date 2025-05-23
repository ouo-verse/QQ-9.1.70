package com.tencent.mobileqq.qqlive.widget.util;

import androidx.annotation.ColorRes;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes17.dex */
public class e {
    static IPatchRedirector $redirector_;

    public static int a(@ColorRes int i3) {
        return BaseApplication.getContext().getResources().getColor(i3);
    }
}
