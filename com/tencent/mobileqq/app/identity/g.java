package com.tencent.mobileqq.app.identity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.View;
import com.tencent.mobileqq.app.identity.jwt.JWTUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xweb.FileReaderHelper;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class g {
    static IPatchRedirector $redirector_;

    public static boolean a(Dialog dialog, Activity activity) {
        if (dialog == null || activity == null || f(dialog) != activity) {
            return false;
        }
        return true;
    }

    public static boolean b(Dialog dialog) {
        if (dialog != null && dialog.isShowing()) {
            return true;
        }
        return false;
    }

    public static boolean c(String str, long j3) {
        long optLong;
        long optLong2;
        if (str == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            optLong = jSONObject.optLong("iat");
            optLong2 = jSONObject.optLong("exp");
        } catch (JSONException e16) {
            QLog.e("IdentityUtils", 1, "parse payload error : ", e16.getMessage());
        }
        if (j3 <= optLong || j3 >= optLong2) {
            return false;
        }
        return true;
    }

    public static boolean d(String str, long j3) {
        String h16;
        if (TextUtils.isEmpty(str) || (h16 = h(str)) == null) {
            return false;
        }
        return c(h16, j3);
    }

    public static QQCustomDialog e(Context context, String str, String str2, String str3, String str4, boolean z16, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        return DialogUtil.createCountdownDialog(context, str4, str3, str, str2, z16, 5, 0, onClickListener, onClickListener2);
    }

    private static Context f(Dialog dialog) {
        if (dialog == null) {
            return null;
        }
        Context context = dialog.getContext();
        if (context instanceof Activity) {
            return context;
        }
        if (context instanceof ContextThemeWrapper) {
            return ((ContextThemeWrapper) context).getBaseContext();
        }
        return context;
    }

    public static boolean g(String str) {
        if (str == null) {
            QLog.e("IdentityUtils", 1, "payload should not be null");
            return false;
        }
        Boolean bool = (Boolean) i(FileReaderHelper.OPEN_FILE_FROM_FORCE, str);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static String h(String str) {
        try {
            return JWTUtil.getPayload(str, "-----BEGIN PUBLIC KEY-----\nMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvpgaMJnHS3HZLto4PIoH\n8LLs/QBNSWe0jEMxWulLOPfpC3jh+jbuVAv/65lDoJEoisvBNB5eAkILd9iI8IIQ\nAaW8ehqYat32ggZTtuJ52NZWLAZtMIMk/eL2Un+o+/7ZA+P3u8aCzbruWZyR01lw\n31GchZfLcv5BeGEDHvGyrArsjAnWsoW8/jJhdqbiVBIsgMh+k+n2rEKX1iG81ATb\nktbp2mTBLxpJSExuM3FhEOPTiosz4TTbuC5oI4VMKpqsUWYkav66v3f3jKkof1ym\nUiC+tqkuDzHcRDRzy8BKCwIrv290FOY5TixXHbNcKupks4Z82H9kE/dUNb+gjssz\nIQIDAQAB\n-----END PUBLIC KEY-----");
        } catch (Exception e16) {
            QLog.e("IdentityUtils", 1, "getJwtPayloadWithKey1 error\uff0c jwt : ", str, " exception : ", e16);
            return null;
        }
    }

    private static <T> T i(String str, String str2) {
        try {
            T t16 = (T) new JSONObject(str2).opt(str);
            if (t16 != null) {
                return t16;
            }
            return null;
        } catch (ClassCastException e16) {
            QLog.e("IdentityUtils", 1, "getValueFromPayload ClassCastException : ", e16.getMessage());
            return null;
        } catch (JSONException e17) {
            QLog.e("IdentityUtils", 1, "getValueFromPayload JSONException : ", e17.getMessage());
            return null;
        }
    }
}
