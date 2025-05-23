package com.huawei.hms.aaid;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.AAIDResult;
import com.huawei.hms.aaid.entity.DeleteTokenReq;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.opendevice.c;
import com.huawei.hms.opendevice.i;
import com.huawei.hms.opendevice.j;
import com.huawei.hms.opendevice.k;
import com.huawei.hms.opendevice.l;
import com.huawei.hms.opendevice.o;
import com.huawei.hms.opendevice.p;
import com.huawei.hms.opendevice.q;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HmsInstanceId {
    public static final String TAG = "HmsInstanceId";

    /* renamed from: a, reason: collision with root package name */
    public Context f36595a;

    /* renamed from: b, reason: collision with root package name */
    public PushPreferences f36596b;

    /* renamed from: c, reason: collision with root package name */
    public HuaweiApi<Api.ApiOptions.NoOptions> f36597c;

    public HmsInstanceId(Context context) {
        this.f36595a = context.getApplicationContext();
        this.f36596b = new PushPreferences(context, "aaid");
        HuaweiApi<Api.ApiOptions.NoOptions> huaweiApi = new HuaweiApi<>(context, (Api<Api.ApiOptions>) new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH), (Api.ApiOptions) null, new PushClientBuilder());
        this.f36597c = huaweiApi;
        huaweiApi.setKitSdkVersion(60300305);
    }

    public static HmsInstanceId getInstance(Context context) {
        Preconditions.checkNotNull(context);
        c.c(context);
        return new HmsInstanceId(context);
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (p.e(this.f36595a)) {
            String string = i.a(this.f36595a).getString("subjectId");
            if (TextUtils.isEmpty(string)) {
                i.a(this.f36595a).saveString("subjectId", str);
                return;
            }
            if (string.contains(str)) {
                return;
            }
            i.a(this.f36595a).saveString("subjectId", string + "," + str);
            return;
        }
        i.a(this.f36595a).removeKey("subjectId");
    }

    public final void b() throws ApiException {
        if (Looper.getMainLooper() != Looper.myLooper()) {
        } else {
            throw ErrorEnum.ERROR_MAIN_THREAD.toApiException();
        }
    }

    public void deleteAAID() throws ApiException {
        b();
        try {
            if (!this.f36596b.containsKey("aaid")) {
                return;
            }
            this.f36596b.removeKey("aaid");
            this.f36596b.removeKey("creationTime");
            if (!o.e(this.f36595a)) {
                return;
            }
            if (ProxyCenter.getProxy() != null) {
                HMSLog.i(TAG, "use proxy delete all token after delete AaId.");
                ProxyCenter.getProxy().deleteAllToken(this.f36595a);
                return;
            }
            DeleteTokenReq b16 = o.b(this.f36595a);
            b16.setDeleteType(1);
            b16.setMultiSender(false);
            a(b16, 1);
            BaseUtils.deleteAllTokenCache(this.f36595a);
        } catch (ApiException e16) {
            throw e16;
        } catch (Exception unused) {
            throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        }
    }

    public void deleteToken(String str, String str2) throws ApiException {
        b();
        a();
        DeleteTokenReq a16 = o.a(this.f36595a, str, str2);
        a16.setMultiSender(false);
        a(a16, 1);
    }

    public Task<AAIDResult> getAAID() {
        try {
            return Tasks.callInBackground(new j(this.f36595a.getApplicationContext()));
        } catch (Exception unused) {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setException(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
            return taskCompletionSource.getTask();
        }
    }

    public long getCreationTime() {
        try {
            if (!this.f36596b.containsKey("creationTime")) {
                getAAID();
            }
            return this.f36596b.getLong("creationTime");
        } catch (Exception unused) {
            return 0L;
        }
    }

    public String getId() {
        return o.c(this.f36595a);
    }

    @Deprecated
    public String getToken() {
        try {
            return getToken(null, null);
        } catch (Exception unused) {
            return null;
        }
    }

    public String getToken(String str, String str2) throws ApiException {
        b();
        a();
        TokenReq b16 = o.b(this.f36595a, null, str2);
        b16.setAaid(getId());
        b16.setMultiSender(false);
        i.a(this.f36595a).saveString(this.f36595a.getPackageName(), "1");
        return a(b16, 1);
    }

    public void deleteToken(String str) throws ApiException {
        b();
        a();
        if (!TextUtils.isEmpty(str)) {
            String d16 = o.d(this.f36595a);
            if (!TextUtils.isEmpty(d16)) {
                if (str.equals(d16)) {
                    deleteToken(null, null);
                    return;
                }
                DeleteTokenReq a16 = o.a(this.f36595a, str);
                a16.setMultiSender(true);
                a(a16, 2);
                return;
            }
            throw ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException();
        }
        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
    }

    public String getToken(String str) throws ApiException {
        b();
        a();
        if (!TextUtils.isEmpty(str)) {
            String d16 = o.d(this.f36595a);
            if (!TextUtils.isEmpty(d16)) {
                if (str.equals(d16)) {
                    return getToken(null, null);
                }
                TokenReq b16 = o.b(this.f36595a, str);
                b16.setAaid(getId());
                b16.setMultiSender(true);
                return a(b16, 2);
            }
            throw ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException();
        }
        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
    }

    public final String a(TokenReq tokenReq, int i3) throws ApiException {
        if (ProxyCenter.getProxy() != null) {
            HMSLog.i(TAG, "use proxy get token, please check HmsMessageService.onNewToken receive result.");
            ProxyCenter.getProxy().getToken(this.f36595a, tokenReq.getSubjectId(), null);
            return null;
        }
        a(tokenReq.getSubjectId());
        String a16 = q.a(this.f36595a, "push.gettoken");
        try {
            String str = TAG;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getToken req :");
            sb5.append(tokenReq.toString());
            HMSLog.d(str, sb5.toString());
            l lVar = new l("push.gettoken", tokenReq, this.f36595a, a16);
            lVar.setApiLevel(i3);
            return ((TokenResult) Tasks.await(this.f36597c.doWrite(lVar))).getToken();
        } catch (Exception e16) {
            if (e16.getCause() instanceof ApiException) {
                ApiException apiException = (ApiException) e16.getCause();
                q.a(this.f36595a, "push.gettoken", a16, apiException.getStatusCode());
                throw apiException;
            }
            Context context = this.f36595a;
            ErrorEnum errorEnum = ErrorEnum.ERROR_INTERNAL_ERROR;
            q.a(context, "push.gettoken", a16, errorEnum);
            throw errorEnum.toApiException();
        }
    }

    public final void a(DeleteTokenReq deleteTokenReq, int i3) throws ApiException {
        String subjectId = deleteTokenReq.getSubjectId();
        if (ProxyCenter.getProxy() != null) {
            HMSLog.i(TAG, "use proxy delete token");
            ProxyCenter.getProxy().deleteToken(this.f36595a, subjectId, null);
            return;
        }
        String a16 = q.a(this.f36595a, "push.deletetoken");
        try {
            String b16 = i.a(this.f36595a).b(subjectId);
            if (deleteTokenReq.isMultiSender() && (TextUtils.isEmpty(b16) || b16.equals(i.a(this.f36595a).b(null)))) {
                i.a(this.f36595a).removeKey(subjectId);
                HMSLog.i(TAG, "The local subject token is null");
                return;
            }
            deleteTokenReq.setToken(b16);
            k kVar = new k("push.deletetoken", deleteTokenReq, a16);
            kVar.setApiLevel(i3);
            Tasks.await(this.f36597c.doWrite(kVar));
            i.a(this.f36595a).c(subjectId);
        } catch (Exception e16) {
            if (e16.getCause() instanceof ApiException) {
                ApiException apiException = (ApiException) e16.getCause();
                q.a(this.f36595a, "push.deletetoken", a16, apiException.getStatusCode());
                throw apiException;
            }
            Context context = this.f36595a;
            ErrorEnum errorEnum = ErrorEnum.ERROR_INTERNAL_ERROR;
            q.a(context, "push.deletetoken", a16, errorEnum);
            throw errorEnum.toApiException();
        }
    }

    public final void a() throws ApiException {
        if (BaseUtils.getProxyInit(this.f36595a) && ProxyCenter.getProxy() == null && !BaseUtils.isMainProc(this.f36595a)) {
            HMSLog.e(TAG, "Operations in child processes are not supported.");
            throw ErrorEnum.ERROR_OPER_IN_CHILD_PROCESS.toApiException();
        }
    }
}
