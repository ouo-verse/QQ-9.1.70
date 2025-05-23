package com.tencent.falco.base.downloader.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.NetworkUtil;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static boolean a() {
        return NetworkUtil.isNetworkAvailable();
    }
}
