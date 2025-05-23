package com.huawei.hms.hwid;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.hwid.internal.ui.activity.HwIdSignInHubActivity;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.hms.support.api.entity.hwid.HuaweiIdSignInRequest;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParams;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import com.huawei.hms.support.hwid.result.HuaweiIdAuthResult;
import com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService;
import com.huawei.hms.utils.Util;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class x {
    public static Intent a(Context context, HuaweiIdAuthParams huaweiIdAuthParams, String str) {
        as.b("[HUAWEIIDSDK]HuaweiIdAuthTool", "getSignInIntent enter", true);
        Intent intent = new Intent("com.huawei.hms.jos.signIn");
        intent.setPackage(context.getPackageName());
        intent.setClass(context, HwIdSignInHubActivity.class);
        String appId = Util.getAppId(context);
        String packageName = context.getPackageName();
        s sVar = new s();
        sVar.b(appId);
        sVar.c(packageName);
        sVar.a(60400302L);
        sVar.d(str);
        HuaweiIdSignInRequest huaweiIdSignInRequest = new HuaweiIdSignInRequest();
        huaweiIdSignInRequest.setHuaweiIdAuthParams(huaweiIdAuthParams);
        try {
            intent.putExtra("HUAWEIID_CP_CLIENTINFO", sVar.d());
            intent.putExtra("HUAWEIID_SIGNIN_REQUEST", huaweiIdSignInRequest.toJson());
        } catch (JSONException unused) {
            as.b("[HUAWEIIDSDK]HuaweiIdAuthTool", "JSONException", true);
        }
        return intent;
    }

    public static AuthHuaweiId b() {
        return y.a().b();
    }

    public static HuaweiIdAuthResult a(Intent intent) {
        as.b("[HUAWEIIDSDK]HuaweiIdAuthTool", "getSignInResultFromIntent", true);
        if (intent != null && intent.hasExtra(HuaweiIdAuthAPIService.EXTRA_AUTH_HUAWEI_ID)) {
            try {
                return new HuaweiIdAuthResult().fromJson(intent.getStringExtra(HuaweiIdAuthAPIService.EXTRA_AUTH_HUAWEI_ID));
            } catch (JSONException unused) {
                as.d("[HUAWEIIDSDK]HuaweiIdAuthTool", "JSONException", true);
                return null;
            }
        }
        as.d("[HUAWEIIDSDK]HuaweiIdAuthTool", "data or signInResult is null", true);
        return null;
    }

    public static void a() {
        y.a().c();
    }

    public static HuaweiIdAuthParams a(List<Scope> list) {
        HuaweiIdAuthParamsHelper huaweiIdAuthParamsHelper = new HuaweiIdAuthParamsHelper();
        if (ap.b(list).booleanValue()) {
            huaweiIdAuthParamsHelper.setScopeList(list);
        }
        Iterator<Scope> it = list.iterator();
        while (it.hasNext()) {
            if (a(it.next(), CommonConstant.SCOPE.SCOPE_ACCOUNT_SHIPPING_ADDRESS)) {
                huaweiIdAuthParamsHelper.setShippingAddress();
            }
        }
        return huaweiIdAuthParamsHelper.createParams();
    }

    private static boolean a(Scope scope, String str) {
        if (scope != null) {
            return TextUtils.equals(scope.getScopeUri(), str);
        }
        return false;
    }
}
