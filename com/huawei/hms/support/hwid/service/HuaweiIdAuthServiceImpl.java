package com.huawei.hms.support.hwid.service;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.hwid.ab;
import com.huawei.hms.hwid.ac;
import com.huawei.hms.hwid.ad;
import com.huawei.hms.hwid.as;
import com.huawei.hms.hwid.v;
import com.huawei.hms.hwid.x;
import com.huawei.hms.hwid.z;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.common.CommonNaming;
import com.huawei.hms.support.api.entity.hwid.HuaweiIdSignInRequest;
import com.huawei.hms.support.api.entity.hwid.SignOutReq;
import com.huawei.hms.support.api.hwid.HuaweiIdGetTokenOptions;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParams;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HuaweiIdAuthServiceImpl extends HuaweiApi<HuaweiIdAuthParams> implements HuaweiIdAuthService {
    private static final Api<HuaweiIdAuthParams> HUAWEI_ID_AUTH_API = new Api<>(HuaweiApiAvailability.HMS_API_NAME_ID);
    protected static final String TAG = "[HUAWEIIDSDK]HuaweiIdAuthService";
    private String mAccountName;
    private boolean mFromRequestToken;

    public HuaweiIdAuthServiceImpl(Activity activity, HuaweiIdAuthParams huaweiIdAuthParams, int i3) {
        super(activity, HUAWEI_ID_AUTH_API, huaweiIdAuthParams, (AbstractClientBuilder) new v(), i3);
    }

    private HuaweiIdAuthParams setSignInParams(String str) {
        HuaweiIdAuthParams option = getOption();
        try {
            new JSONObject(str);
            try {
                HuaweiIdAuthParams m70clone = option.m70clone();
                m70clone.setSignInParams(str);
                return m70clone;
            } catch (CloneNotSupportedException unused) {
                as.d(TAG, "CloneNotSupportedException", true);
                return option;
            }
        } catch (JSONException unused2) {
            as.d(TAG, "JSONException", true);
            return option;
        }
    }

    @Override // com.huawei.hms.support.feature.service.AuthService
    public Task<Void> cancelAuthorization() {
        as.b(TAG, "cancelAuthorization", true);
        HuaweiIdSignInRequest huaweiIdSignInRequest = new HuaweiIdSignInRequest();
        huaweiIdSignInRequest.setHuaweiIdAuthParams(getOption());
        try {
            return doWrite(new z(CommonNaming.revokeAccess, huaweiIdSignInRequest.toJson(), HiAnalyticsClient.reportEntry(getContext(), CommonNaming.revokeAccess, 60400300)));
        } catch (JSONException unused) {
            as.d(TAG, "JSONException, errorcode is:2015", true);
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setException(new ApiException(new Status(2015)));
            return taskCompletionSource.getTask();
        }
    }

    @Override // com.huawei.hms.common.HuaweiApi
    public int getApiLevel() {
        return 1;
    }

    @Override // com.huawei.hms.support.feature.service.AuthService
    public Intent getSignInIntent() {
        return getSignInIntent("");
    }

    @Override // com.huawei.hms.support.feature.service.AuthService
    public Task<Void> signOut() {
        as.b(TAG, "signOut", true);
        x.a();
        SignOutReq signOutReq = new SignOutReq();
        return doWrite(new ad(CommonNaming.signout, signOutReq.toJson(), HiAnalyticsClient.reportEntry(getContext(), CommonNaming.signout, 60400300)));
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthService
    public Task<AuthHuaweiId> silentSignIn() {
        return silentSignIn("");
    }

    public HuaweiIdAuthServiceImpl(Context context, HuaweiIdAuthParams huaweiIdAuthParams, int i3) {
        super(context, HUAWEI_ID_AUTH_API, huaweiIdAuthParams, new v(), i3);
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthService
    public Intent getSignInIntent(String str) {
        as.b(TAG, "getSignInIntent", true);
        return x.a(getContext(), setSignInParams(str), getSubAppID());
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthService
    public Task<AuthHuaweiId> silentSignIn(String str) {
        as.b(TAG, "silentSignIn", true);
        HuaweiIdSignInRequest huaweiIdSignInRequest = new HuaweiIdSignInRequest();
        huaweiIdSignInRequest.setHuaweiIdAuthParams(setSignInParams(str));
        boolean z16 = this.mFromRequestToken;
        if (z16) {
            huaweiIdSignInRequest.setHuaweiIdGetTokenOptions(new HuaweiIdGetTokenOptions(this.mAccountName, z16));
        }
        try {
            String json = huaweiIdSignInRequest.toJson();
            String reportEntry = HiAnalyticsClient.reportEntry(getContext(), CommonNaming.silentSignIn, 60400300);
            if (this.mFromRequestToken) {
                return doWrite(new ab(CommonNaming.silentSignIn, json, reportEntry));
            }
            return doWrite(new ac(CommonNaming.silentSignIn, json, reportEntry));
        } catch (JSONException unused) {
            as.d(TAG, "JSONException, errorcode is:2015", true);
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setException(new ApiException(new Status(2015)));
            return taskCompletionSource.getTask();
        }
    }

    public HuaweiIdAuthServiceImpl(Context context, HuaweiIdAuthParams huaweiIdAuthParams, String str, int i3) {
        super(context, HUAWEI_ID_AUTH_API, huaweiIdAuthParams, new v(), i3);
        this.mAccountName = str;
        this.mFromRequestToken = true;
    }

    public HuaweiIdAuthServiceImpl(Activity activity, HuaweiIdAuthParams huaweiIdAuthParams, String str, int i3) {
        super(activity, HUAWEI_ID_AUTH_API, huaweiIdAuthParams, (AbstractClientBuilder) new v(), i3);
        this.mAccountName = str;
        this.mFromRequestToken = true;
    }
}
