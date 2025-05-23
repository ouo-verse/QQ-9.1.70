package com.tencent.open.inner.auth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.ads.data.AdParam;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.agent.util.m;
import com.tencent.open.agent.util.t;
import com.tencent.qphone.base.util.QLog;
import wp3.b;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QQAuth {
    public static final String ACTIVITY_AGENT = "com.tencent.open.agent.AgentActivity";
    private static final String DEFAULT_PF = "openmobile_android_inner";
    private static final String TAG = "QQAuth";

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class AuthParams {
        String clientAppId;
        Bundle extra;
        String proxyAppId;
        String proxyAppName;
        String scope;

        public AuthParams(String str, String str2, String str3, String str4) {
            this(str, str2, str3, str4, null);
        }

        public static String base64EncodeNoWrap(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    return PluginBaseInfoHelper.Base64Helper.encodeToString(str.getBytes("UTF-8"), 2);
                } catch (Exception e16) {
                    QLog.e(QQAuth.TAG, 1, "base64EncodeNoWrap exception ", e16);
                    return "";
                }
            }
            return "";
        }

        public AuthParams(String str, String str2, String str3, String str4, Bundle bundle) {
            this.proxyAppId = str;
            this.clientAppId = str2;
            this.proxyAppName = str3;
            this.scope = str4;
            this.extra = bundle;
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final QQAuth f341592a = new QQAuth();
    }

    QQAuth() {
    }

    private Bundle buildKeyParams(Activity activity, AuthParams authParams) {
        Bundle bundle = authParams.extra;
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (!TextUtils.isEmpty(authParams.proxyAppId)) {
            bundle.putString("key_proxy_appid", authParams.proxyAppId);
        }
        bundle.putString(CommonConstant.ReqAccessTokenParam.CLIENT_ID, authParams.clientAppId);
        bundle.putString("scope", authParams.scope);
        bundle.putString("oauth_app_name", authParams.proxyAppName);
        if (!TextUtils.isEmpty(authParams.proxyAppName)) {
            bundle.putString("oauth_app_name", authParams.proxyAppName);
        }
        bundle.putString(AdParam.PF, DEFAULT_PF);
        bundle.putString("need_pay", "1");
        bundle.putString("ppsts", m.f(activity, m.g(bundle)));
        return bundle;
    }

    private void errorCallback(b bVar, wp3.a aVar) {
        if (bVar != null && aVar != null) {
            bVar.onError(aVar);
        } else {
            t.b(TAG, "erroCallback: listener or openError is null");
        }
    }

    private Intent getAuthIntent(Activity activity, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClassName(activity.getApplicationContext().getPackageName(), ACTIVITY_AGENT);
        intent.putExtra("key_action", "action_login");
        intent.putExtra("key_params", bundle);
        intent.putExtra("appid", bundle.getString(CommonConstant.ReqAccessTokenParam.CLIENT_ID));
        return intent;
    }

    public static QQAuth getInstance() {
        return a.f341592a;
    }

    private wp3.a paramsCheck(Context context, AuthParams authParams) {
        wp3.a aVar = new wp3.a(-1, context.getString(R.string.f172592qv), context.getString(R.string.f172582qu, ""));
        if (authParams == null) {
            return aVar;
        }
        if (TextUtils.isEmpty(authParams.clientAppId)) {
            aVar.f446031c = context.getString(R.string.f172582qu, CommonConstant.ReqAccessTokenParam.CLIENT_ID);
            return aVar;
        }
        if (TextUtils.isEmpty(authParams.scope)) {
            aVar.f446031c = context.getString(R.string.f172582qu, "scope");
            return aVar;
        }
        aVar.f446029a = 0;
        aVar.f446030b = "";
        aVar.f446031c = "";
        return aVar;
    }

    private void startAuthActivity(Fragment fragment, Activity activity, Bundle bundle) {
        Intent authIntent = getAuthIntent(activity, bundle);
        if (fragment != null) {
            fragment.startActivityForResult(authIntent, 10001);
        } else {
            activity.startActivityForResult(authIntent, 10001);
        }
    }

    public void proxyAuth(Activity activity, b bVar, AuthParams authParams) {
        proxyAuth(null, activity, bVar, authParams);
    }

    public void proxyAuth(Fragment fragment, b bVar, AuthParams authParams) {
        proxyAuth(fragment, fragment == null ? null : fragment.getActivity(), bVar, authParams);
    }

    private void proxyAuth(Fragment fragment, Activity activity, b bVar, AuthParams authParams) {
        if (activity == null) {
            errorCallback(bVar, new wp3.a(-2));
            return;
        }
        wp3.a paramsCheck = paramsCheck(activity, authParams);
        if (paramsCheck != null && paramsCheck.f446029a < 0) {
            errorCallback(bVar, paramsCheck);
        } else {
            startAuthActivity(fragment, activity, buildKeyParams(activity, authParams));
            ReportController.o(null, "dc00898", "", "", "0X800BF26", "0X800BF26", 0, 0, authParams.proxyAppId, authParams.clientAppId, authParams.proxyAppName, authParams.scope);
        }
    }
}
