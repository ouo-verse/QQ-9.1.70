package com.tencent.mobileqq.multiaio.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static int f251433a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f251434b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73140);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f251433a = 12;
            f251434b = false;
        }
    }

    public static int a(Context context, int i3) {
        int i16 = i3 / 5;
        int b16 = b(context);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float f16 = (displayMetrics.heightPixels * 1.0f) / displayMetrics.widthPixels;
        if (QLog.isColorLevel()) {
            QLog.d("VelocityUtil", 2, "getInitVelocity() displayMetrics.widthPixels = " + displayMetrics.widthPixels + ", displayMetrics.heightPixels = " + displayMetrics.heightPixels + ", ratio = " + f16 + ", 16.F/9.F = 1.7777778,viewPagerClientWidth = " + b16);
        }
        if (f16 > 1.7777778f && QLog.isColorLevel()) {
            QLog.d("VelocityUtil", 2, "getInitVelocity() ratio > 16.F/9.F");
        }
        QLog.d("VelocityUtil", 1, "getInitVelocity: pendingVelocity = " + i16 + ", viewPagerClientWidth = " + b16);
        return i16;
    }

    public static int b(Context context) {
        Resources resources = context.getResources();
        return resources.getDisplayMetrics().widthPixels - (BaseAIOUtils.f(42.0f, resources) * 2);
    }
}
