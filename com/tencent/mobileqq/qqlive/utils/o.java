package com.tencent.mobileqq.qqlive.utils;

import android.os.Looper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IAegisLogApi;

/* compiled from: P */
/* loaded from: classes17.dex */
public class o {
    static IPatchRedirector $redirector_;

    public static void a(String str, String str2) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).a(str, str2);
        }
    }
}
