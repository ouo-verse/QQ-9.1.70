package com.tencent.tmsqmsp.oaid2;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes26.dex */
public class k0 {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Uri f380822a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44181);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f380822a = Uri.parse("content://cn.nubia.identity/identity");
        }
    }

    public static String a(Context context, String str) {
        try {
            int i3 = Build.VERSION.SDK_INT;
            ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(f380822a);
            Bundle call = acquireUnstableContentProviderClient.call("getAAID", str, null);
            if (i3 >= 24) {
                acquireUnstableContentProviderClient.close();
            } else {
                acquireUnstableContentProviderClient.release();
            }
            if (call.getInt("code", -1) == 0) {
                String string = call.getString("id");
                t0.b("NubiaLog succeed:".concat(String.valueOf(string)));
                return string;
            }
            String string2 = call.getString("message");
            t0.b("NubiaLog failed:".concat(String.valueOf(string2)));
            return string2;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static String b(Context context) {
        try {
            int i3 = Build.VERSION.SDK_INT;
            ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(f380822a);
            Bundle call = acquireUnstableContentProviderClient.call(com.tencent.luggage.wxa.q2.e.NAME, null, null);
            if (i3 >= 24) {
                acquireUnstableContentProviderClient.close();
            } else {
                acquireUnstableContentProviderClient.release();
            }
            if (call.getInt("code", -1) == 0) {
                String string = call.getString("id");
                t0.b("NubiaLog succeed:".concat(String.valueOf(string)));
                return string;
            }
            String string2 = call.getString("message");
            t0.b("NubiaLog failed:".concat(String.valueOf(string2)));
            return string2;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static boolean a(Context context) {
        try {
            int i3 = Build.VERSION.SDK_INT;
            ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(f380822a);
            Bundle call = acquireUnstableContentProviderClient.call("isSupport", null, null);
            if (i3 >= 24) {
                acquireUnstableContentProviderClient.close();
            } else {
                acquireUnstableContentProviderClient.release();
            }
            if (call.getInt("code", -1) == 0) {
                t0.b("NubiaLog succeed");
                return call.getBoolean("issupport", true);
            }
            t0.b("NubiaLog failed:" + call.getString("message"));
            return false;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }
}
