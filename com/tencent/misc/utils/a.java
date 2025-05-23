package com.tencent.misc.utils;

import android.content.Context;
import com.tencent.component.appx.utils.AppUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import cooperation.qzone.api.QZoneContant;

/* compiled from: P */
@Deprecated
/* loaded from: classes9.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static int f151671a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(QZoneContant.REQUEST_CODE_CLOSE_MASK);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f151671a = -1;
        }
    }

    public static int a(float f16) {
        return AppUtils.UI.dip2px(f16);
    }

    public static int b(Context context, float f16) {
        AppUtils.zInitGlobal(context.getApplicationContext());
        return AppUtils.UI.dip2px(f16);
    }

    public static int c(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }
}
