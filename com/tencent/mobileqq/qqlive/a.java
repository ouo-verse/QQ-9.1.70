package com.tencent.mobileqq.qqlive;

import com.qq.wx.voice.util.ErrorCode;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IAegisLogApi;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static IAegisLogApi f270358a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(ErrorCode.ERROR_TIMESTAMP_NOT_FOUND);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f270358a = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        }
    }

    public static boolean a() {
        return true;
    }

    public static boolean b() {
        boolean a16 = a();
        boolean b16 = AccompanyLibraryLoader.b();
        f270358a.i("AccompanyFeatureToggle", "featureOpen:" + a16 + ", libraryReady:" + b16);
        if (a16 && b16) {
            return true;
        }
        return false;
    }
}
