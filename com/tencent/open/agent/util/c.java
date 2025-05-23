package com.tencent.open.agent.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {
    public static boolean a(Bundle bundle, String str, boolean z16) {
        if (bundle == null) {
            t.f("AuthParamUtil", "getBoolean bundle is null, key=" + str);
            return z16;
        }
        return bundle.getBoolean(str, z16);
    }

    public static boolean b(Intent intent, String str, boolean z16) {
        if (intent == null) {
            t.e("AuthParamUtil", "getBooleanExtra intent is null, key=" + str);
            return z16;
        }
        try {
            return intent.getBooleanExtra(str, z16);
        } catch (Exception e16) {
            t.d("AuthParamUtil", "Exception", e16);
            return z16;
        }
    }

    public static Bundle c(Activity activity, String str) {
        if (activity == null) {
            t.f("AuthParamUtil", "getBundleExtra activity is null, key=" + str);
            return null;
        }
        return d(activity.getIntent(), str);
    }

    public static Bundle d(Intent intent, String str) {
        return e(intent, str, null);
    }

    public static Bundle e(Intent intent, String str, Bundle bundle) {
        if (intent == null) {
            t.e("AuthParamUtil", "getBundleExtra intent is null, key=" + str);
            return bundle;
        }
        try {
            Bundle bundleExtra = intent.getBundleExtra(str);
            if (bundleExtra != null) {
                return bundleExtra;
            }
            return bundle;
        } catch (Exception e16) {
            t.d("AuthParamUtil", "Exception", e16);
            return bundle;
        }
    }

    public static int f(Bundle bundle, String str, int i3) {
        if (bundle == null) {
            t.f("AuthParamUtil", "getInt bundle is null, key=" + str);
            return i3;
        }
        return bundle.getInt(str, i3);
    }

    public static String g(Activity activity) {
        return i(c(activity, "key_params"), "packagename");
    }

    public static String h(Bundle bundle) {
        return i(bundle, "packagename");
    }

    public static String i(Bundle bundle, String str) {
        if (bundle == null) {
            t.f("AuthParamUtil", "getString bundle is null, key=" + str);
            return null;
        }
        try {
            return bundle.getString(str);
        } catch (Exception e16) {
            t.d("AuthParamUtil", "Exception", e16);
            return null;
        }
    }

    public static String j(Bundle bundle, String str, String str2) {
        String i3 = i(bundle, str);
        if (i3 != null) {
            return i3;
        }
        return str2;
    }

    public static String k(Activity activity, String str) {
        if (activity == null) {
            t.f("AuthParamUtil", "getStringExtra activity is null, key=" + str);
            return null;
        }
        return l(activity.getIntent(), str);
    }

    public static String l(Intent intent, String str) {
        if (intent == null) {
            t.e("AuthParamUtil", "getStringExtra intent is null, key=" + str);
            return null;
        }
        try {
            return intent.getStringExtra(str);
        } catch (Exception e16) {
            t.d("AuthParamUtil", "Exception", e16);
            return null;
        }
    }

    public static boolean m(Intent intent) {
        return b(intent, "authority_start_qq_login", false);
    }

    public static boolean n(Bundle bundle) {
        return a(bundle, "authority_start_qq_login", false);
    }

    public static String o(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        if (str.length() != 0) {
            try {
            } catch (Exception unused) {
                return null;
            }
        }
        return new String(PluginBaseInfoHelper.Base64Helper.decode(str, 2));
    }
}
