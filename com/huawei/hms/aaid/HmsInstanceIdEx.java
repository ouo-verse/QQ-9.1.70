package com.huawei.hms.aaid;

import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.opendevice.l;
import com.huawei.hms.opendevice.o;
import com.huawei.hms.opendevice.q;
import com.huawei.hms.support.log.HMSLog;
import java.util.UUID;

/* compiled from: P */
@Deprecated
/* loaded from: classes2.dex */
public class HmsInstanceIdEx {
    public static final String TAG = "HmsInstanceIdEx";

    /* renamed from: a, reason: collision with root package name */
    public Context f36598a;

    /* renamed from: b, reason: collision with root package name */
    public PushPreferences f36599b;

    /* renamed from: c, reason: collision with root package name */
    public HuaweiApi<Api.ApiOptions.NoOptions> f36600c;

    public HmsInstanceIdEx(Context context) {
        this.f36599b = null;
        this.f36598a = context;
        this.f36599b = new PushPreferences(context, "aaid");
        HuaweiApi<Api.ApiOptions.NoOptions> huaweiApi = new HuaweiApi<>(context, (Api<Api.ApiOptions>) new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH), (Api.ApiOptions) null, new PushClientBuilder());
        this.f36600c = huaweiApi;
        huaweiApi.setKitSdkVersion(60300305);
    }

    public static HmsInstanceIdEx getInstance(Context context) {
        Preconditions.checkNotNull(context);
        return new HmsInstanceIdEx(context);
    }

    public final String a(String str) {
        return "creationTime" + str;
    }

    public void deleteAAID(String str) throws ApiException {
        if (str != null) {
            try {
                if (this.f36599b.containsKey(str)) {
                    this.f36599b.removeKey(str);
                    this.f36599b.removeKey(a(str));
                    return;
                }
                return;
            } catch (RuntimeException unused) {
                throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
            } catch (Exception unused2) {
                throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
            }
        }
        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
    }

    public String getAAId(String str) throws ApiException {
        if (str != null) {
            try {
                if (this.f36599b.containsKey(str)) {
                    return this.f36599b.getString(str);
                }
                String uuid = UUID.randomUUID().toString();
                this.f36599b.saveString(str, uuid);
                this.f36599b.saveLong(a(str), Long.valueOf(System.currentTimeMillis()));
                return uuid;
            } catch (RuntimeException unused) {
                throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
            } catch (Exception unused2) {
                throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
            }
        }
        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
    }

    public long getCreationTime(String str) throws ApiException {
        if (str != null) {
            try {
                if (!this.f36599b.containsKey(a(str))) {
                    getAAId(str);
                }
                return this.f36599b.getLong(a(str));
            } catch (RuntimeException unused) {
                throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
            } catch (Exception unused2) {
                throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
            }
        }
        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
    }

    public Task<TokenResult> getToken() {
        if (ProxyCenter.getProxy() != null) {
            try {
                HMSLog.i(TAG, "use proxy get token, please check HmsMessageService.onNewToken receive result.");
                ProxyCenter.getProxy().getToken(this.f36598a, null, null);
                TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                taskCompletionSource.setResult(new TokenResult());
                return taskCompletionSource.getTask();
            } catch (ApiException e16) {
                return a(e16);
            } catch (Exception unused) {
                return a(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
            }
        }
        String a16 = q.a(this.f36598a, "push.gettoken");
        try {
            TokenReq b16 = o.b(this.f36598a, null, null);
            b16.setAaid(HmsInstanceId.getInstance(this.f36598a).getId());
            return this.f36600c.doWrite(new l("push.gettoken", b16, this.f36598a, a16));
        } catch (RuntimeException unused2) {
            Context context = this.f36598a;
            ErrorEnum errorEnum = ErrorEnum.ERROR_INTERNAL_ERROR;
            q.a(context, "push.gettoken", a16, errorEnum);
            return a(errorEnum.toApiException());
        } catch (Exception unused3) {
            Context context2 = this.f36598a;
            ErrorEnum errorEnum2 = ErrorEnum.ERROR_INTERNAL_ERROR;
            q.a(context2, "push.gettoken", a16, errorEnum2);
            return a(errorEnum2.toApiException());
        }
    }

    public final Task<TokenResult> a(Exception exc) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setException(exc);
        return taskCompletionSource.getTask();
    }
}
