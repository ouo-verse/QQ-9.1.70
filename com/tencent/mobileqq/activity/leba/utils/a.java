package com.tencent.mobileqq.activity.leba.utils;

import android.content.Context;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.utils.abtest.QCommonOnlineExpProviderImpl;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static boolean f183350a;

    /* renamed from: b, reason: collision with root package name */
    private static BusinessInfoCheckUpdate.RedTypeInfo f183351b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68506);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f183350a = false;
        }
    }

    public static BusinessInfoCheckUpdate.RedTypeInfo a() {
        return f183351b;
    }

    public static boolean b(BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo) {
        if (redTypeInfo != null && redTypeInfo.red_type.get() == 0) {
            return true;
        }
        return false;
    }

    public static boolean c(AppRuntime appRuntime) {
        if (SimpleUIUtil.getSimpleUISwitch() && e(appRuntime)) {
            return true;
        }
        return false;
    }

    public static boolean d(Context context) {
        if (context == null || !(context instanceof SplashActivity)) {
            return false;
        }
        return e(((SplashActivity) context).app);
    }

    public static boolean e(AppRuntime appRuntime) {
        if (appRuntime == null) {
            return false;
        }
        return QCommonOnlineExpProviderImpl.EXP_QQ_LEBA_CONCISE_THEME_CONTENT_B.equals(((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).getExpContentInSimpleUI(appRuntime));
    }

    public static boolean f() {
        return f183350a;
    }

    public static void g(BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo) {
        f183351b = redTypeInfo;
    }

    public static void h(boolean z16) {
        f183350a = z16;
    }
}
