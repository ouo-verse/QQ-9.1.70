package com.tencent.mobileqq.pic;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected static SharedPreferences f258588a;

    /* renamed from: b, reason: collision with root package name */
    protected static SharedPreferences.Editor f258589b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(ProfileContants.FIELD_THEME_TYPE);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
        f258588a = defaultSharedPreferences;
        f258589b = defaultSharedPreferences.edit();
    }

    public static int a() {
        int systemNetwork = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
        if (systemNetwork == 1) {
            return 0;
        }
        if (systemNetwork != 2) {
            if (systemNetwork == 3) {
                return 2;
            }
            if (systemNetwork == 4) {
                return 1;
            }
        }
        return 3;
    }

    public static long b(String str, long j3) {
        return f258588a.getLong(str, j3);
    }

    public static Boolean c(String str, Boolean bool) {
        return Boolean.valueOf(f258588a.getBoolean(str, bool.booleanValue()));
    }

    public static String d(String str, String str2) {
        return f258588a.getString(str, str2);
    }

    @TargetApi(9)
    public static void e(String str, long j3) {
        f(str, j3, true);
    }

    @TargetApi(9)
    public static void f(String str, long j3, boolean z16) {
        f258589b.putLong(str, j3);
        if (z16) {
            f258589b.apply();
        }
    }

    @TargetApi(9)
    public static void g(String str, boolean z16, boolean z17) {
        f258589b.putBoolean(str, z16);
        if (z17) {
            f258589b.apply();
        }
    }

    @TargetApi(9)
    public static void h(String str, String str2, boolean z16) {
        f258589b.putString(str, str2);
        if (z16) {
            f258589b.apply();
        }
    }
}
