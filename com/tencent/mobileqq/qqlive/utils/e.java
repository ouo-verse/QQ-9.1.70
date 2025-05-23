package com.tencent.mobileqq.qqlive.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.util.QQDeviceInfo;

/* compiled from: P */
/* loaded from: classes17.dex */
public class e {
    static IPatchRedirector $redirector_;

    public static String a() {
        return QQDeviceInfo.getQIMEI();
    }
}
