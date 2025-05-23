package com.huawei.hms.hwid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.huawei.hms.account.internal.ui.activity.AccountSignInHubActivity;
import com.huawei.hms.support.account.request.AccountAuthParams;
import com.huawei.hms.support.account.request.AccountAuthParamsHelper;
import com.huawei.hms.support.account.result.AccountAuthResult;
import com.huawei.hms.support.account.result.AuthAccount;
import com.huawei.hms.support.api.entity.account.AccountSignInRequest;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService;
import com.huawei.hms.utils.Util;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class f {
    public static Intent a(Context context, AccountAuthParams accountAuthParams, String str) {
        as.b("[AccountSDK]AccountAuthUtil", "getSignInIntent", true);
        return a(context, accountAuthParams, str, 0, "");
    }

    public static AuthAccount b() {
        return g.a().b();
    }

    public static Intent a(Context context, AccountAuthParams accountAuthParams, String str, String str2) {
        as.b("[AccountSDK]AccountAuthUtil", "getIndependentSignInIntent", true);
        return a(context, accountAuthParams, str, 1, str2);
    }

    private static Intent a(Context context, AccountAuthParams accountAuthParams, String str, int i3, String str2) {
        JSONObject jSONObject;
        Intent intent = new Intent(i3 == 1 ? "com.huawei.hms.account.picker.signIn" : "com.huawei.hms.account.signIn");
        intent.setPackage(context.getPackageName());
        intent.setClass(context, AccountSignInHubActivity.class);
        if (i3 == 1) {
            intent.putExtra("ACCESS_TOKEN", str2);
            intent.putExtra("INDEPENDENT_SIGN_IN_FLAG", i3);
            try {
                String signInParams = accountAuthParams.getSignInParams();
                if (TextUtils.isEmpty(signInParams)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(signInParams);
                }
                jSONObject.put("ACCESS_TOKEN", str2);
                jSONObject.put("INDEPENDENT_SIGN_IN_FLAG", i3);
                accountAuthParams.setSignInParams(jSONObject.toString());
            } catch (JSONException e16) {
                as.d("[AccountSDK]AccountAuthUtil", "JSONException:" + e16.getClass().getSimpleName(), true);
            }
        }
        String appId = Util.getAppId(context);
        String packageName = context.getPackageName();
        b bVar = new b();
        bVar.b(appId);
        bVar.c(packageName);
        bVar.a(60400302L);
        bVar.d(str);
        AccountSignInRequest accountSignInRequest = new AccountSignInRequest();
        accountSignInRequest.setAccountAuthParams(accountAuthParams);
        try {
            intent.putExtra("HUAWEIID_CP_CLIENTINFO", bVar.d());
            intent.putExtra("HUAWEIID_SIGNIN_REQUEST", accountSignInRequest.toJson());
        } catch (JSONException unused) {
            as.d("[AccountSDK]AccountAuthUtil", "JSONException", true);
        }
        return intent;
    }

    public static AccountAuthResult a(Intent intent) {
        as.b("[AccountSDK]AccountAuthUtil", "getSignInResultFromIntent", true);
        if (intent != null && intent.hasExtra(HuaweiIdAuthAPIService.EXTRA_AUTH_HUAWEI_ID)) {
            try {
                return new AccountAuthResult().fromJson(intent.getStringExtra(HuaweiIdAuthAPIService.EXTRA_AUTH_HUAWEI_ID));
            } catch (JSONException unused) {
                as.d("[AccountSDK]AccountAuthUtil", "JSONException", true);
                return null;
            }
        }
        as.d("[AccountSDK]AccountAuthUtil", "data or signInResult is null", true);
        return null;
    }

    public static void a() {
        g.a().c();
    }

    public static AccountAuthParams a(List<Scope> list) {
        AccountAuthParamsHelper accountAuthParamsHelper = new AccountAuthParamsHelper();
        if (ap.b(list).booleanValue()) {
            accountAuthParamsHelper.setScopeList(list);
        }
        return accountAuthParamsHelper.createParams();
    }

    public static void a(Window window) {
        if (window == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            as.b("[AccountSDK]AccountAuthUtil", "android version is Higher than 9.0", true);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            window.setAttributes(attributes);
            window.getDecorView().setSystemUiVisibility(5894);
            return;
        }
        as.b("[AccountSDK]AccountAuthUtil", "android version is Below 9.0", true);
        WindowManager.LayoutParams attributes2 = window.getAttributes();
        try {
            Class<?> cls = Class.forName("com.huawei.android.view.LayoutParamsEx");
            cls.getMethod("addHwFlags", Integer.TYPE).invoke(cls.getConstructor(WindowManager.LayoutParams.class).newInstance(attributes2), 4096);
        } catch (RuntimeException e16) {
            as.d("[AccountSDK]AccountAuthUtil", "Adapt to the digging screen occur RuntimeException" + e16.getClass().getSimpleName(), true);
        } catch (Exception e17) {
            as.d("[AccountSDK]AccountAuthUtil", "Adapt to the digging screen occur exception" + e17.getClass().getSimpleName(), true);
        }
    }

    public static void a(Activity activity) {
        try {
            int systemUiVisibility = activity.getWindow().getDecorView().getSystemUiVisibility();
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            activity.getWindow().getDecorView().setSystemUiVisibility(systemUiVisibility | 1024);
            int i3 = Build.VERSION.SDK_INT;
            activity.getWindow().setStatusBarColor(0);
            activity.getWindow().setNavigationBarColor(0);
            if (i3 >= 29) {
                activity.getWindow().setNavigationBarContrastEnforced(false);
            }
        } catch (Exception e16) {
            as.d("[AccountSDK]AccountAuthUtil", "exception occured:" + e16.getClass().getSimpleName(), true);
        }
    }
}
