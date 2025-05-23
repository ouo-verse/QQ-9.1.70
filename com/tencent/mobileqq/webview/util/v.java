package com.tencent.mobileqq.webview.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes20.dex */
public class v {
    static IPatchRedirector $redirector_;

    public static boolean a() {
        return ((Boolean) t.m("busi_preload_").b("key_preload", Boolean.FALSE)).booleanValue();
    }

    public static void b(boolean z16) {
        t.m("busi_preload_").d("key_preload", Boolean.valueOf(z16)).g();
    }
}
