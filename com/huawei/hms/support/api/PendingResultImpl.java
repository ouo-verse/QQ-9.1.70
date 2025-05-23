package com.huawei.hms.support.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.adapter.BaseAdapter;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.InnerPendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.api.transport.DatagramTransport;
import com.huawei.hms.support.gentyref.GenericTypeReflector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public abstract class PendingResultImpl<R extends Result, T extends IMessageEntity> extends InnerPendingResult<R> {

    /* renamed from: a, reason: collision with root package name */
    private CountDownLatch f37517a;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<ApiClient> f37519c;
    protected DatagramTransport transport = null;

    /* renamed from: b, reason: collision with root package name */
    private R f37518b = null;

    /* renamed from: d, reason: collision with root package name */
    private String f37520d = null;

    /* renamed from: e, reason: collision with root package name */
    private String f37521e = null;

    /* renamed from: f, reason: collision with root package name */
    private boolean f37522f = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements DatagramTransport.a {
        a() {
        }

        @Override // com.huawei.hms.support.api.transport.DatagramTransport.a
        public void a(int i3, IMessageEntity iMessageEntity) {
            PendingResultImpl.this.a(i3, iMessageEntity);
            PendingResultImpl.this.f37517a.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements DatagramTransport.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f37524a;

        b(AtomicBoolean atomicBoolean) {
            this.f37524a = atomicBoolean;
        }

        @Override // com.huawei.hms.support.api.transport.DatagramTransport.a
        public void a(int i3, IMessageEntity iMessageEntity) {
            if (!this.f37524a.get()) {
                PendingResultImpl.this.a(i3, iMessageEntity);
            }
            PendingResultImpl.this.f37517a.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements DatagramTransport.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f37526a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ResultCallback f37527b;

        c(d dVar, ResultCallback resultCallback) {
            this.f37526a = dVar;
            this.f37527b = resultCallback;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.huawei.hms.support.api.transport.DatagramTransport.a
        public void a(int i3, IMessageEntity iMessageEntity) {
            PendingResultImpl.this.a(i3, iMessageEntity);
            this.f37526a.a(this.f37527b, PendingResultImpl.this.f37518b);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static class d<R extends Result> extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        public void a(ResultCallback<? super R> resultCallback, R r16) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r16)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        protected void b(ResultCallback<? super R> resultCallback, R r16) {
            resultCallback.onResult(r16);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                Pair pair = (Pair) message.obj;
                b((ResultCallback) pair.first, (Result) pair.second);
            }
        }
    }

    public PendingResultImpl(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
        a(apiClient, str, iMessageEntity, getResponseType(), 0);
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final R await() {
        HMSLog.i("PendingResultImpl", "await");
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return awaitOnAnyThread();
        }
        HMSLog.e("PendingResultImpl", "await in main thread");
        throw new IllegalStateException("await must not be called on the UI thread");
    }

    @Override // com.huawei.hms.support.api.client.InnerPendingResult
    public final R awaitOnAnyThread() {
        HMSLog.i("PendingResultImpl", "awaitOnAnyThread");
        WeakReference<ApiClient> weakReference = this.f37519c;
        if (weakReference == null) {
            HMSLog.e("PendingResultImpl", "api is null");
            a(CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            return this.f37518b;
        }
        ApiClient apiClient = weakReference.get();
        if (!checkApiClient(apiClient)) {
            HMSLog.e("PendingResultImpl", "client invalid");
            a(CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            return this.f37518b;
        }
        if (this.f37522f) {
            a(0, 1);
        }
        this.transport.send(apiClient, new a());
        try {
            this.f37517a.await();
        } catch (InterruptedException unused) {
            HMSLog.e("PendingResultImpl", "await in anythread InterruptedException");
            a(CommonCode.ErrorCode.INTERNAL_ERROR, (IMessageEntity) null);
        }
        return this.f37518b;
    }

    protected boolean checkApiClient(ApiClient apiClient) {
        return true;
    }

    protected Class<T> getResponseType() {
        Type type;
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass != null && (type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[1]) != null) {
            return (Class) type;
        }
        return null;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    @Deprecated
    public boolean isCanceled() {
        return false;
    }

    public abstract R onComplete(T t16);

    protected R onError(int i3) {
        Type type;
        Class<?> cls;
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass != null) {
            type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
        } else {
            type = null;
        }
        if (type != null) {
            cls = GenericTypeReflector.getType(type);
        } else {
            cls = null;
        }
        if (cls != null) {
            try {
                R r16 = (R) cls.newInstance();
                this.f37518b = r16;
                r16.setStatus(new Status(i3));
            } catch (Exception e16) {
                HMSLog.e("PendingResultImpl", "on Error:" + e16.getMessage());
                return null;
            }
        }
        return this.f37518b;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public void setResultCallback(ResultCallback<R> resultCallback) {
        this.f37522f = !(resultCallback instanceof BaseAdapter.BaseRequestResultCallback);
        setResultCallback(Looper.getMainLooper(), resultCallback);
    }

    private void a(ApiClient apiClient, String str, IMessageEntity iMessageEntity, Class<T> cls, int i3) {
        HMSLog.i("PendingResultImpl", "init uri:" + str);
        this.f37520d = str;
        if (apiClient == null) {
            HMSLog.e("PendingResultImpl", "client is null");
            return;
        }
        this.f37519c = new WeakReference<>(apiClient);
        this.f37517a = new CountDownLatch(1);
        try {
            this.transport = (DatagramTransport) Class.forName(apiClient.getTransportName()).getConstructor(String.class, IMessageEntity.class, Class.class, Integer.TYPE).newInstance(str, iMessageEntity, cls, Integer.valueOf(i3));
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | InvocationTargetException e16) {
            HMSLog.e("PendingResultImpl", "gen transport error:" + e16.getMessage());
            throw new IllegalStateException("Instancing transport exception, " + e16.getMessage(), e16);
        }
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final void setResultCallback(Looper looper, ResultCallback<R> resultCallback) {
        HMSLog.i("PendingResultImpl", "setResultCallback");
        if (looper == null) {
            looper = Looper.myLooper();
        }
        d dVar = new d(looper);
        WeakReference<ApiClient> weakReference = this.f37519c;
        if (weakReference == null) {
            HMSLog.e("PendingResultImpl", "api is null");
            a(CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            return;
        }
        ApiClient apiClient = weakReference.get();
        if (!checkApiClient(apiClient)) {
            HMSLog.e("PendingResultImpl", "client is invalid");
            a(CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            dVar.a(resultCallback, this.f37518b);
        } else {
            if (this.f37522f) {
                a(0, 1);
            }
            this.transport.post(apiClient, new c(dVar, resultCallback));
        }
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public R await(long j3, TimeUnit timeUnit) {
        HMSLog.i("PendingResultImpl", "await timeout:" + j3 + " unit:" + timeUnit.toString());
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return awaitOnAnyThread(j3, timeUnit);
        }
        HMSLog.i("PendingResultImpl", "await in main thread");
        throw new IllegalStateException("await must not be called on the UI thread");
    }

    public PendingResultImpl(ApiClient apiClient, String str, IMessageEntity iMessageEntity, Class<T> cls) {
        a(apiClient, str, iMessageEntity, cls, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(int i3, IMessageEntity iMessageEntity) {
        Status status;
        HMSLog.i("PendingResultImpl", "setResult:" + i3);
        Status commonStatus = iMessageEntity instanceof AbstractMessageEntity ? ((AbstractMessageEntity) iMessageEntity).getCommonStatus() : null;
        if (i3 == 0) {
            this.f37518b = onComplete(iMessageEntity);
        } else {
            this.f37518b = onError(i3);
        }
        if (this.f37522f) {
            a(i3, 2);
        }
        R r16 = this.f37518b;
        if (r16 == null || (status = r16.getStatus()) == null || commonStatus == null) {
            return;
        }
        int statusCode = status.getStatusCode();
        String statusMessage = status.getStatusMessage();
        int statusCode2 = commonStatus.getStatusCode();
        String statusMessage2 = commonStatus.getStatusMessage();
        if (statusCode != statusCode2) {
            HMSLog.e("PendingResultImpl", "rstStatus code (" + statusCode + ") is not equal commonStatus code (" + statusCode2 + ")");
            HMSLog.e("PendingResultImpl", "rstStatus msg (" + statusMessage + ") is not equal commonStatus msg (" + statusMessage2 + ")");
            return;
        }
        if (!TextUtils.isEmpty(statusMessage) || TextUtils.isEmpty(statusMessage2)) {
            return;
        }
        HMSLog.i("PendingResultImpl", "rstStatus msg (" + statusMessage + ") is not equal commonStatus msg (" + statusMessage2 + ")");
        this.f37518b.setStatus(new Status(statusCode, statusMessage2, status.getResolution()));
    }

    public PendingResultImpl(ApiClient apiClient, String str, IMessageEntity iMessageEntity, int i3) {
        a(apiClient, str, iMessageEntity, getResponseType(), i3);
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    @Deprecated
    public void setResultCallback(ResultCallback<R> resultCallback, long j3, TimeUnit timeUnit) {
        setResultCallback(resultCallback);
    }

    @Override // com.huawei.hms.support.api.client.InnerPendingResult
    public final R awaitOnAnyThread(long j3, TimeUnit timeUnit) {
        HMSLog.i("PendingResultImpl", "awaitOnAnyThread timeout:" + j3 + " unit:" + timeUnit.toString());
        WeakReference<ApiClient> weakReference = this.f37519c;
        if (weakReference == null) {
            HMSLog.e("PendingResultImpl", "api is null");
            a(CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            return this.f37518b;
        }
        ApiClient apiClient = weakReference.get();
        if (!checkApiClient(apiClient)) {
            HMSLog.e("PendingResultImpl", "client invalid");
            a(CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            return this.f37518b;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        if (this.f37522f) {
            a(0, 1);
        }
        this.transport.post(apiClient, new b(atomicBoolean));
        try {
            if (!this.f37517a.await(j3, timeUnit)) {
                atomicBoolean.set(true);
                a(CommonCode.ErrorCode.EXECUTE_TIMEOUT, (IMessageEntity) null);
            }
        } catch (InterruptedException unused) {
            HMSLog.e("PendingResultImpl", "awaitOnAnyThread InterruptedException");
            a(CommonCode.ErrorCode.INTERNAL_ERROR, (IMessageEntity) null);
        }
        return this.f37518b;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    @Deprecated
    public void cancel() {
    }

    private void a(int i3, int i16) {
        SubAppInfo subAppInfo;
        HMSLog.i("PendingResultImpl", "biReportEvent ====== ");
        ApiClient apiClient = this.f37519c.get();
        if (apiClient != null && this.f37520d != null && !HiAnalyticsUtil.getInstance().hasError(apiClient.getContext())) {
            HashMap hashMap = new HashMap();
            hashMap.put("package", apiClient.getPackageName());
            hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION, "6.9.0.300");
            if (i16 == 1) {
                hashMap.put("direction", "req");
            } else {
                hashMap.put("direction", "rsp");
                hashMap.put("result", String.valueOf(i3));
                R r16 = this.f37518b;
                if (r16 != null && r16.getStatus() != null) {
                    hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, String.valueOf(this.f37518b.getStatus().getStatusCode()));
                }
            }
            hashMap.put("version", "0");
            String appId = Util.getAppId(apiClient.getContext());
            if (TextUtils.isEmpty(appId) && (subAppInfo = apiClient.getSubAppInfo()) != null) {
                appId = subAppInfo.getSubAppID();
            }
            hashMap.put("appid", appId);
            if (TextUtils.isEmpty(this.f37521e)) {
                String id5 = TransactionIdCreater.getId(appId, this.f37520d);
                this.f37521e = id5;
                hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_TRANSID, id5);
            } else {
                hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_TRANSID, this.f37521e);
                this.f37521e = null;
            }
            String[] split = this.f37520d.split("\\.");
            if (split.length >= 2) {
                hashMap.put("service", split[0]);
                hashMap.put("apiName", split[1]);
            }
            hashMap.put("callTime", String.valueOf(System.currentTimeMillis()));
            hashMap.put("phoneType", Util.getSystemProperties("ro.logsystem.usertype", ""));
            HiAnalyticsUtil.getInstance().onEvent(apiClient.getContext(), HiAnalyticsConstant.HMS_SDK_BASE_CALL_AIDL, hashMap);
            return;
        }
        HMSLog.e("PendingResultImpl", "<biReportEvent> has some error.");
    }
}
