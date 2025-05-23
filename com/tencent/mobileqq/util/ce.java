package com.tencent.mobileqq.util;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.PropertiesUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.vaswebviewplugin.MQPSecJsPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.wireless_reg.CaptchaVerifyInfo$captchaVerifyInfo;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ce {
    public static boolean c(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.has("upnum")) {
                    return false;
                }
                if (!jSONObject.has("upmsg")) {
                    return false;
                }
                return true;
            } catch (JSONException e16) {
                QLog.e("RegisterUtils", 1, "checkUpSmsJsonPromptValid exception", e16);
            }
        }
        return false;
    }

    public static boolean d(QBaseActivity qBaseActivity) {
        if (qBaseActivity != null && !qBaseActivity.isFinishing() && !qBaseActivity.isDestroyed()) {
            return false;
        }
        QLog.e("RegisterUtils", 1, "curContextInvalid");
        return true;
    }

    public static void e(Activity activity) {
        Window window;
        View decorView;
        if (!Build.MANUFACTURER.equalsIgnoreCase("XIAOMI") || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        try {
            Field declaredField = Class.forName("com.android.internal.policy.DecorView").getDeclaredField("mDecorCaptionView");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(decorView);
            if (obj == null) {
                return;
            }
            Field declaredField2 = Class.forName("android.view.View").getDeclaredField("mContext");
            declaredField2.setAccessible(true);
            Field declaredField3 = Class.forName("com.android.internal.widget.DecorCaptionView").getDeclaredField("mContent");
            declaredField3.setAccessible(true);
            Object obj2 = declaredField3.get(obj);
            if (obj2 != null && declaredField2.get(obj2) == activity) {
                declaredField3.set(obj, null);
            }
            Class<?> cls = Class.forName("com.android.internal.widget.MiuiDecorCaptionView");
            Field declaredField4 = cls.getDeclaredField("mContent");
            declaredField4.setAccessible(true);
            Object obj3 = declaredField4.get(obj);
            if (obj3 != null && declaredField2.get(obj3) == activity) {
                declaredField4.set(obj, null);
            }
            Field declaredField5 = cls.getDeclaredField("mOwner");
            declaredField5.setAccessible(true);
            Object obj4 = declaredField5.get(obj);
            if (obj4 != null && declaredField2.get(obj4) == activity) {
                declaredField5.set(obj, null);
            }
            Field declaredField6 = Class.forName("android.view.ViewGroup").getDeclaredField("mFocused");
            declaredField6.setAccessible(true);
            Object obj5 = declaredField6.get(obj);
            if (obj5 != null && declaredField2.get(obj5) == activity) {
                declaredField6.set(obj, null);
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("RegisterUtils", 2, th5, new Object[0]);
            }
        }
    }

    public static Bundle f() {
        int i3;
        String str;
        Bundle bundle = new Bundle();
        String read = PropertiesUtils.read(BaseApplication.getContext(), PropertiesUtils.KEY_LOCALE_ID, "0");
        if ("0".equals(read)) {
            QLog.e("RegisterUtils", 1, "addLocaleIdCookie, localeIdStr = 0");
            return bundle;
        }
        bundle.putString("os_language", Locale.getDefault().getLanguage());
        try {
            i3 = Integer.parseInt(read);
        } catch (Exception e16) {
            QLog.e("RegisterUtils", 1, e16.toString());
            i3 = 0;
        }
        bundle.putInt("qq_language", i3);
        try {
            str = ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).getCityCode();
        } catch (Throwable th5) {
            QLog.e("RegisterUtils", 1, th5, new Object[0]);
            str = "";
        }
        bundle.putString("gps_location", str);
        return bundle;
    }

    public static HashMap<String, Object> g(Bundle bundle) {
        if (bundle == null) {
            QLog.e("RegisterUtils", 1, "getRegExtraMap error: data == null");
            return null;
        }
        String string = bundle.getString("ticket", "");
        String string2 = bundle.getString(MQPSecJsPlugin.KEY_RANDSTR, "");
        CaptchaVerifyInfo$captchaVerifyInfo captchaVerifyInfo$captchaVerifyInfo = new CaptchaVerifyInfo$captchaVerifyInfo();
        captchaVerifyInfo$captchaVerifyInfo.bytes_ticket.set(ByteStringMicro.copyFromUtf8(string));
        captchaVerifyInfo$captchaVerifyInfo.str_randstr.set(string2);
        captchaVerifyInfo$captchaVerifyInfo.setHasFlag(true);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("captcha_verify_info", captchaVerifyInfo$captchaVerifyInfo.toByteArray());
        return hashMap;
    }

    public static String h(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, StandardCharsets.UTF_8);
        } catch (Exception e16) {
            QLog.e("RegisterUtils", 1, "strPromptInfo exception: " + e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(QBaseActivity qBaseActivity, int i3, int i16) {
        QQToast.makeText(qBaseActivity, i3, i16, 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(QBaseActivity qBaseActivity, int i3, String str) {
        QQToast.makeText(qBaseActivity, i3, str, 1).show();
    }

    public static void k(final int i3, final int i16) {
        final QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.util.cc
            @Override // java.lang.Runnable
            public final void run() {
                ce.i(QBaseActivity.this, i16, i3);
            }
        });
    }

    public static void l(final String str, final int i3) {
        final QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.util.cd
            @Override // java.lang.Runnable
            public final void run() {
                ce.j(QBaseActivity.this, i3, str);
            }
        });
    }
}
