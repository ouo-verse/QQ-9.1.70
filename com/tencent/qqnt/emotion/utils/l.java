package com.tencent.qqnt.emotion.utils;

import android.content.Context;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes24.dex */
public class l {
    static IPatchRedirector $redirector_;

    public static boolean a(Context context) {
        return AppNetConnInfo.isNetSupport();
    }

    public static boolean b() {
        return true;
    }
}
