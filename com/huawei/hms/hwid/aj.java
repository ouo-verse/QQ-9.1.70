package com.huawei.hms.hwid;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.hms.support.api.entity.common.CommonNaming;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeServlet;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class aj extends HuaweiApi<Api.ApiOptions.NoOptions> {
    public aj(Activity activity, Api<Api.ApiOptions.NoOptions> api, Api.ApiOptions.NoOptions noOptions, AbstractClientBuilder abstractClientBuilder) {
        super(activity, api, noOptions, abstractClientBuilder);
    }

    private af b() {
        return new af(getContext().getPackageName());
    }

    public Task<Void> a() {
        String a16 = b().a();
        if (TextUtils.isEmpty(a16)) {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setException(new ApiException(new Status(2020, CommonConstant.RETCODE.SMS_PARAM_ERROR)));
            return taskCompletionSource.getTask();
        }
        return doWrite(new ak(CommonNaming.startSmsRetriever, a16, HiAnalyticsClient.reportEntry(getContext(), CommonNaming.startSmsRetriever, 60400300)));
    }

    @Override // com.huawei.hms.common.HuaweiApi
    public int getApiLevel() {
        return 1;
    }

    public aj(Context context, Api<Api.ApiOptions.NoOptions> api, Api.ApiOptions.NoOptions noOptions, AbstractClientBuilder abstractClientBuilder) {
        super(context, api, noOptions, abstractClientBuilder);
    }

    public Task<Void> a(String str) {
        as.b("ReadSmsService", "startConsent enter", true);
        if (str != null && str.length() > 120) {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setException(new ApiException(new Status(2020, CommonConstant.RETCODE.SMS_PARAM_ERROR)));
            return taskCompletionSource.getTask();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("packageName", getContext().getPackageName());
            jSONObject.put(MiniAppSendSmsCodeServlet.KEY_PHONE_NUMBER, str);
        } catch (JSONException unused) {
            as.d("ReadSmsService", "toJson failed", true);
        }
        if (TextUtils.isEmpty(jSONObject.toString())) {
            TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
            taskCompletionSource2.setException(new ApiException(new Status(2020, CommonConstant.RETCODE.SMS_PARAM_ERROR)));
            return taskCompletionSource2.getTask();
        }
        return doWrite(new al(CommonNaming.startConsent, jSONObject.toString(), HiAnalyticsClient.reportEntry(getContext(), CommonNaming.startConsent, 60400300)));
    }
}
