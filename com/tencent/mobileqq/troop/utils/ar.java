package com.tencent.mobileqq.troop.utils;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ar {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static long f302079a;

    /* renamed from: b, reason: collision with root package name */
    private static final Drawable f302080b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76780);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f302079a = 0L;
            f302080b = new ColorDrawable(-5658199);
        }
    }

    public static String a() {
        return "https://qun.qq.com/interactive/userhonor?gc=<$GC>&uin=<$UIN>&_wv=3&&_wwv=128";
    }
}
