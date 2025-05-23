package com.huawei.hms.common.internal;

import android.os.Parcelable;
import com.huawei.hmf.tasks.CancellationToken;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class TaskApiCall<ClientT extends AnyClient, ResultT> {

    /* renamed from: a, reason: collision with root package name */
    private final String f36885a;

    /* renamed from: b, reason: collision with root package name */
    private final String f36886b;

    /* renamed from: c, reason: collision with root package name */
    private Parcelable f36887c;

    /* renamed from: d, reason: collision with root package name */
    private String f36888d;

    /* renamed from: e, reason: collision with root package name */
    private CancellationToken f36889e;

    /* renamed from: f, reason: collision with root package name */
    private int f36890f;

    @Deprecated
    public TaskApiCall(String str, String str2) {
        this.f36890f = 1;
        this.f36885a = str;
        this.f36886b = str2;
        this.f36887c = null;
        this.f36888d = null;
    }

    protected abstract void doExecute(ClientT clientt, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<ResultT> taskCompletionSource);

    public int getApiLevel() {
        return this.f36890f;
    }

    @Deprecated
    public int getMinApkVersion() {
        return 30000000;
    }

    public Parcelable getParcelable() {
        return this.f36887c;
    }

    public String getRequestJson() {
        return this.f36886b;
    }

    public CancellationToken getToken() {
        return this.f36889e;
    }

    public String getTransactionId() {
        return this.f36888d;
    }

    public String getUri() {
        return this.f36885a;
    }

    public final void onResponse(ClientT clientt, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<ResultT> taskCompletionSource) {
        CancellationToken cancellationToken = this.f36889e;
        if (cancellationToken != null && cancellationToken.isCancellationRequested()) {
            HMSLog.i("TaskApiCall", "This Task has been canceled, uri:" + this.f36885a + ", transactionId:" + this.f36888d);
            return;
        }
        HMSLog.i("TaskApiCall", "doExecute, uri:" + this.f36885a + ", errorCode:" + responseErrorCode.getErrorCode() + ", transactionId:" + this.f36888d);
        doExecute(clientt, responseErrorCode, str, taskCompletionSource);
    }

    public void setApiLevel(int i3) {
        this.f36890f = i3;
    }

    public void setParcelable(Parcelable parcelable) {
        this.f36887c = parcelable;
    }

    public void setToken(CancellationToken cancellationToken) {
        this.f36889e = cancellationToken;
    }

    public void setTransactionId(String str) {
        this.f36888d = str;
    }

    public TaskApiCall(String str, String str2, String str3) {
        this.f36890f = 1;
        this.f36885a = str;
        this.f36886b = str2;
        this.f36887c = null;
        this.f36888d = str3;
    }

    public TaskApiCall(String str, String str2, String str3, int i3) {
        this.f36885a = str;
        this.f36886b = str2;
        this.f36887c = null;
        this.f36888d = str3;
        this.f36890f = i3;
    }
}
