package com.huawei.hms.common;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.adapter.BinderAdapter;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api.ApiOptions;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.BindResolveClients;
import com.huawei.hms.common.internal.ClientSettings;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.RequestManager;
import com.huawei.hms.common.internal.ResolveClientBean;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.common.internal.TaskApiCallWrapper;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.core.aidl.IAIDLInvoke;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.hianalytics.HiAnalyticsInnerClient;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSBIInitializer;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.Util;
import com.tencent.map.sdk.comps.vis.VisualLayer;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HuaweiApi<TOption extends Api.ApiOptions> {

    /* renamed from: a, reason: collision with root package name */
    private Context f36785a;

    /* renamed from: b, reason: collision with root package name */
    private TOption f36786b;

    /* renamed from: c, reason: collision with root package name */
    private Context f36787c;

    /* renamed from: d, reason: collision with root package name */
    private AbstractClientBuilder<?, TOption> f36788d;

    /* renamed from: e, reason: collision with root package name */
    private String f36789e;

    /* renamed from: f, reason: collision with root package name */
    private String f36790f;

    /* renamed from: g, reason: collision with root package name */
    private SubAppInfo f36791g;

    /* renamed from: h, reason: collision with root package name */
    private WeakReference<Activity> f36792h;

    /* renamed from: i, reason: collision with root package name */
    private int f36793i;

    /* renamed from: j, reason: collision with root package name */
    private int f36794j = 1;

    /* renamed from: k, reason: collision with root package name */
    private boolean f36795k = false;

    /* renamed from: l, reason: collision with root package name */
    private String f36796l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f36797m;

    /* renamed from: n, reason: collision with root package name */
    private RequestManager f36798n;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class RequestHandler<OptionsT extends Api.ApiOptions> implements BaseHmsClient.ConnectionCallbacks, BaseHmsClient.OnConnectionFailedListener {

        /* renamed from: b, reason: collision with root package name */
        private final AnyClient f36803b;

        /* renamed from: d, reason: collision with root package name */
        private final HuaweiApi<OptionsT> f36805d;

        /* renamed from: e, reason: collision with root package name */
        private ResolveClientBean f36806e;
        public final Queue<TaskApiCallbackWrapper> callbackWaitQueue = new LinkedList();

        /* renamed from: a, reason: collision with root package name */
        private final Queue<TaskApiCallbackWrapper> f36802a = new LinkedList();

        /* renamed from: c, reason: collision with root package name */
        private ConnectionResult f36804c = null;

        RequestHandler(HuaweiApi<OptionsT> huaweiApi) {
            this.f36805d = huaweiApi;
            this.f36803b = huaweiApi.getClient(RequestManager.getHandler().getLooper(), this);
        }

        public AnyClient getClient() {
            return this.f36803b;
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks
        public void onConnected() {
            HMSLog.i("HuaweiApi", "onConnected");
            BindResolveClients.getInstance().unRegister(this.f36806e);
            this.f36806e = null;
            RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.4
                @Override // java.lang.Runnable
                public void run() {
                    RequestHandler.this.b();
                }
            });
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.OnConnectionFailedListener
        public void onConnectionFailed(final ConnectionResult connectionResult) {
            HMSLog.i("HuaweiApi", "onConnectionFailed");
            BindResolveClients.getInstance().unRegister(this.f36806e);
            this.f36806e = null;
            RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.3
                @Override // java.lang.Runnable
                public void run() {
                    RequestHandler.this.b(connectionResult);
                }
            });
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks
        public void onConnectionSuspended(int i3) {
            HMSLog.i("HuaweiApi", "onConnectionSuspended");
            BindResolveClients.getInstance().unRegister(this.f36806e);
            this.f36806e = null;
            RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.5
                @Override // java.lang.Runnable
                public void run() {
                    RequestHandler.this.c();
                }
            });
        }

        public void postMessage(final TaskApiCallbackWrapper taskApiCallbackWrapper) {
            Context context;
            RequestManager.addToConnectedReqMap(taskApiCallbackWrapper.a().getTaskApiCall().getTransactionId(), this);
            this.f36802a.add(taskApiCallbackWrapper);
            String uri = taskApiCallbackWrapper.a().getTaskApiCall().getUri();
            if (((HuaweiApi) this.f36805d).f36787c != null) {
                context = ((HuaweiApi) this.f36805d).f36787c;
            } else {
                context = this.f36805d.getContext();
            }
            String packageName = context.getPackageName();
            if (((HuaweiApi) this.f36805d).f36787c != null) {
                HuaweiApi<OptionsT> huaweiApi = this.f36805d;
                huaweiApi.b(((HuaweiApi) huaweiApi).f36787c);
            }
            final RequestHeader requestHeader = new RequestHeader();
            requestHeader.setSrvName(uri.split("\\.")[0]);
            requestHeader.setApiName(uri);
            requestHeader.setAppID(this.f36805d.getAppID() + "|" + this.f36805d.getSubAppID());
            requestHeader.setPkgName(packageName);
            requestHeader.setSessionId(this.f36803b.getSessionId());
            TaskApiCall taskApiCall = taskApiCallbackWrapper.a().getTaskApiCall();
            requestHeader.setTransactionId(a(taskApiCall.getTransactionId(), uri));
            requestHeader.setParcelable(taskApiCall.getParcelable());
            requestHeader.setKitSdkVersion(this.f36805d.getKitSdkVersion());
            requestHeader.setApiLevel(Math.max(this.f36805d.getApiLevel(), taskApiCall.getApiLevel()));
            this.f36803b.post(requestHeader, taskApiCall.getRequestJson(), new AnyClient.CallBack() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.2
                @Override // com.huawei.hms.common.internal.AnyClient.CallBack
                public void onCallback(IMessageEntity iMessageEntity, String str) {
                    AnyClient.CallBack b16 = taskApiCallbackWrapper.b();
                    if (b16 != null) {
                        b16.onCallback(iMessageEntity, str);
                    }
                    RequestManager.removeReqByTransId(requestHeader.getTransactionId());
                    RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RequestHandler.this.f36802a.remove(taskApiCallbackWrapper);
                        }
                    });
                }
            });
        }

        private TaskApiCallbackWrapper b(final TaskApiCallWrapper taskApiCallWrapper) {
            return new TaskApiCallbackWrapper(taskApiCallWrapper, new AnyClient.CallBack() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.1

                /* renamed from: a, reason: collision with root package name */
                private AtomicBoolean f36807a = new AtomicBoolean(true);

                @Override // com.huawei.hms.common.internal.AnyClient.CallBack
                public void onCallback(IMessageEntity iMessageEntity, String str) {
                    if (!(iMessageEntity instanceof ResponseHeader)) {
                        HMSLog.e("HuaweiApi", "header is not instance of ResponseHeader");
                        return;
                    }
                    ResponseHeader responseHeader = (ResponseHeader) iMessageEntity;
                    if (responseHeader.getErrorCode() == 11) {
                        RequestHandler.this.a();
                        HMSLog.i("HuaweiApi", "unbind service");
                    }
                    if (!TextUtils.isEmpty(responseHeader.getResolution())) {
                        HMSLog.e("HuaweiApi", "Response has resolution: " + responseHeader.getResolution());
                    }
                    if (this.f36807a.compareAndSet(true, false)) {
                        HiAnalyticsInnerClient.reportEntryExit(RequestHandler.this.f36805d.getContext(), responseHeader, String.valueOf(RequestHandler.this.f36805d.getKitSdkVersion()));
                    }
                    taskApiCallWrapper.getTaskApiCall().onResponse(RequestHandler.this.f36803b, responseHeader, str, taskApiCallWrapper.getTaskCompletionSource());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            HMSLog.i("HuaweiApi", "wait queue size = " + this.callbackWaitQueue.size());
            HMSLog.i("HuaweiApi", "run queue size = " + this.f36802a.size());
            Iterator<TaskApiCallbackWrapper> it = this.callbackWaitQueue.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            Iterator<TaskApiCallbackWrapper> it5 = this.f36802a.iterator();
            while (it5.hasNext()) {
                a(it5.next());
            }
            this.callbackWaitQueue.clear();
            this.f36802a.clear();
            this.f36804c = null;
            this.f36803b.disconnect();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(ConnectionResult connectionResult) {
            this.f36804c = connectionResult;
            Iterator<TaskApiCallbackWrapper> it = this.callbackWaitQueue.iterator();
            boolean z16 = true;
            while (it.hasNext()) {
                TaskApiCallWrapper a16 = it.next().a();
                ResponseHeader responseHeader = new ResponseHeader(1, CommonCode.ErrorCode.CLIENT_API_INVALID, "Connection Failed:" + a(connectionResult) + "(" + connectionResult.getErrorCode() + ")");
                responseHeader.setTransactionId(a16.getTaskApiCall().getTransactionId());
                HiAnalyticsInnerClient.reportEntryExit(this.f36805d.getContext(), responseHeader, String.valueOf(this.f36805d.getKitSdkVersion()));
                if (this.f36804c.getResolution() != null && z16) {
                    responseHeader.setParcelable(this.f36804c.getResolution());
                    if (Util.isAvailableLibExist(this.f36805d.getContext()) && this.f36804c.getErrorCode() == 26) {
                        responseHeader.setResolution(CommonCode.Resolution.HAS_RESOLUTION);
                    }
                    z16 = false;
                }
                int errorCode = this.f36804c.getErrorCode();
                if (errorCode == 30 || errorCode == 31) {
                    responseHeader.setErrorCode(errorCode);
                }
                a16.getTaskApiCall().onResponse(this.f36803b, responseHeader, null, a16.getTaskCompletionSource());
            }
            this.callbackWaitQueue.clear();
            this.f36802a.clear();
            this.f36804c = null;
            this.f36803b.disconnect();
        }

        void a(TaskApiCallWrapper taskApiCallWrapper) {
            HMSLog.i("HuaweiApi", "sendRequest");
            TaskApiCallbackWrapper b16 = b(taskApiCallWrapper);
            int hmsVersionCode = HMSPackageManager.getInstance(((HuaweiApi) this.f36805d).f36785a).getHmsVersionCode();
            if ((hmsVersionCode < 40000000 && hmsVersionCode > 0) && this.f36803b.isConnected() && !((HuaweiApi) this.f36805d).f36797m && ((BaseHmsClient) this.f36803b).getAdapter().getServiceAction().equals("com.huawei.hms.core.aidlservice")) {
                int requestHmsVersionCode = this.f36803b.getRequestHmsVersionCode();
                if (requestHmsVersionCode <= taskApiCallWrapper.getTaskApiCall().getMinApkVersion()) {
                    requestHmsVersionCode = taskApiCallWrapper.getTaskApiCall().getMinApkVersion();
                }
                if (requestHmsVersionCode > hmsVersionCode) {
                    this.f36803b.disconnect();
                }
            }
            if (this.f36803b.isConnected()) {
                HMSLog.i("HuaweiApi", "isConnected:true.");
                BinderAdapter adapter = ((BaseHmsClient) this.f36803b).getAdapter();
                adapter.updateDelayTask();
                ((HmsClient) this.f36803b).setService(IAIDLInvoke.Stub.asInterface(adapter.getServiceBinder()));
                postMessage(b16);
                return;
            }
            HMSLog.i("HuaweiApi", "isConnected:false.");
            this.callbackWaitQueue.add(b16);
            ConnectionResult connectionResult = this.f36804c;
            if (connectionResult != null && connectionResult.getErrorCode() != 0) {
                HMSLog.i("HuaweiApi", "onConnectionFailed, ErrorCode:" + this.f36804c.getErrorCode());
                onConnectionFailed(this.f36804c);
                return;
            }
            RequestManager.addRequestToQueue(this);
            Object obj = this.f36803b;
            if (obj instanceof BaseHmsClient) {
                ((BaseHmsClient) obj).setInternalRequest(this);
            }
            a(taskApiCallWrapper.getTaskApiCall().getMinApkVersion(), b16);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            this.f36804c = null;
            this.f36802a.clear();
            Iterator<TaskApiCallbackWrapper> it = this.callbackWaitQueue.iterator();
            while (it.hasNext()) {
                postMessage(it.next());
            }
            this.callbackWaitQueue.clear();
        }

        private String a(String str, String str2) {
            return TextUtils.isEmpty(str) ? TransactionIdCreater.getId(this.f36805d.getAppID(), str2) : str;
        }

        synchronized void a(int i3, TaskApiCallbackWrapper taskApiCallbackWrapper) {
            if (this.f36803b.isConnected()) {
                HMSLog.d("HuaweiApi", "client is connected");
                return;
            }
            if (this.f36803b.isConnecting()) {
                HMSLog.d("HuaweiApi", "client is isConnecting");
                return;
            }
            if (this.f36805d.getActivity() != null) {
                if (this.f36806e == null) {
                    this.f36806e = new ResolveClientBean(this.f36803b, i3);
                }
                if (BindResolveClients.getInstance().isClientRegistered(this.f36806e)) {
                    HMSLog.i("HuaweiApi", "mResolveClientBean has already register, return!");
                    return;
                }
                BindResolveClients.getInstance().register(this.f36806e);
            }
            this.f36803b.connect(i3);
        }

        void a() {
            this.f36803b.disconnect();
        }

        private void a(TaskApiCallbackWrapper taskApiCallbackWrapper) {
            TaskApiCallWrapper a16 = taskApiCallbackWrapper.a();
            ResponseHeader responseHeader = new ResponseHeader(1, CommonCode.ErrorCode.CLIENT_API_INVALID, "Connection Suspended");
            responseHeader.setTransactionId(a16.getTaskApiCall().getTransactionId());
            a16.getTaskApiCall().onResponse(this.f36803b, responseHeader, null, a16.getTaskCompletionSource());
        }

        private String a(ConnectionResult connectionResult) {
            if (Util.isAvailableLibExist(this.f36805d.getContext())) {
                int errorCode = connectionResult.getErrorCode();
                if (errorCode != -1) {
                    if (errorCode == 3) {
                        return "HuaWei Mobile Service is disabled";
                    }
                    if (errorCode != 8) {
                        if (errorCode != 10) {
                            if (errorCode == 13) {
                                return "update cancelled";
                            }
                            if (errorCode == 21) {
                                return "device is too old to be support";
                            }
                            switch (errorCode) {
                                case 25:
                                    return "failed to get update result";
                                case 26:
                                    return "update failed, because no activity incoming, can't pop update page";
                                case 27:
                                    return "there is already an update popup at the front desk, but it hasn't been clicked or it is not effective for a while";
                                default:
                                    return "unknown errorReason";
                            }
                        }
                        return "application configuration error, please developer check configuration";
                    }
                    return VisualLayer.OnLayerStatusChangedListener.LayerStatusMsg.MSG_ERR_INTERNAL_ERROR;
                }
                return "get update result, but has other error codes";
            }
            int errorCode2 = connectionResult.getErrorCode();
            if (errorCode2 != -1) {
                if (errorCode2 != 8) {
                    if (errorCode2 != 10) {
                        return "unknown errorReason";
                    }
                    return "application configuration error, please developer check configuration";
                }
                return VisualLayer.OnLayerStatusChangedListener.LayerStatusMsg.MSG_ERR_INTERNAL_ERROR;
            }
            return "get update result, but has other error codes";
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class TaskApiCallbackWrapper {

        /* renamed from: a, reason: collision with root package name */
        private final TaskApiCallWrapper f36818a;

        /* renamed from: b, reason: collision with root package name */
        private final AnyClient.CallBack f36819b;

        TaskApiCallbackWrapper(TaskApiCallWrapper taskApiCallWrapper, AnyClient.CallBack callBack) {
            this.f36818a = taskApiCallWrapper;
            this.f36819b = callBack;
        }

        TaskApiCallWrapper a() {
            return this.f36818a;
        }

        AnyClient.CallBack b() {
            return this.f36819b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a<OptionsT extends Api.ApiOptions> implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final HuaweiApi<OptionsT> f36820a;

        /* renamed from: b, reason: collision with root package name */
        private final TaskApiCallWrapper f36821b;

        public a(HuaweiApi<OptionsT> huaweiApi, TaskApiCallWrapper taskApiCallWrapper) {
            this.f36820a = huaweiApi;
            this.f36821b = taskApiCallWrapper;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0058 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void a(RequestHandler requestHandler, Throwable th5) {
            Throwable th6;
            AnyClient anyClient;
            String str;
            ResponseHeader responseHeader;
            TaskCompletionSource taskCompletionSource;
            boolean z16 = true;
            TaskApiCall taskApiCall = null;
            try {
                anyClient = requestHandler.getClient();
            } catch (Throwable th7) {
                th6 = th7;
                anyClient = null;
            }
            try {
                responseHeader = new ResponseHeader(1, CommonCode.ErrorCode.INTERNAL_ERROR, th5.getMessage());
                try {
                    str = new JSONObject().toString();
                    try {
                        taskCompletionSource = this.f36821b.getTaskCompletionSource();
                    } catch (Throwable th8) {
                        th6 = th8;
                        taskCompletionSource = null;
                    }
                    try {
                        taskApiCall = this.f36821b.getTaskApiCall();
                    } catch (Throwable th9) {
                        th6 = th9;
                        HMSLog.e("HuaweiApi", "<notifyCpException> " + th6.getMessage());
                        if (anyClient != null) {
                        }
                        z16 = false;
                        if (z16) {
                        }
                    }
                } catch (Throwable th10) {
                    th6 = th10;
                    str = null;
                    taskCompletionSource = null;
                }
            } catch (Throwable th11) {
                th6 = th11;
                str = null;
                responseHeader = null;
                taskCompletionSource = null;
                HMSLog.e("HuaweiApi", "<notifyCpException> " + th6.getMessage());
                if (anyClient != null) {
                }
                z16 = false;
                if (z16) {
                }
            }
            if (anyClient != null || responseHeader == null || str == null || taskCompletionSource == null || taskApiCall == null) {
                z16 = false;
            }
            if (z16) {
                taskApiCall.onResponse(anyClient, responseHeader, str, taskCompletionSource);
            } else {
                HMSLog.e("HuaweiApi", "<notifyCpException> isNotify is false, Can not notify CP.");
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            RequestHandler requestHandler = new RequestHandler(this.f36820a);
            try {
                requestHandler.a(this.f36821b);
            } catch (Throwable th5) {
                a(requestHandler, th5);
            }
        }
    }

    public HuaweiApi(Activity activity, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i3) {
        Checker.checkNonNull(activity, "Null activity is not permitted.");
        this.f36792h = new WeakReference<>(activity);
        a(activity, api, toption, abstractClientBuilder, i3, null);
    }

    @Deprecated
    public Task<Boolean> disconnectService() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        RequestManager.getInstance();
        RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.1
            @Override // java.lang.Runnable
            public void run() {
                HuaweiApi.this.a((HuaweiApi<?>) this, (TaskCompletionSource<Boolean>) taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public <TResult, TClient extends AnyClient> Task<TResult> doWrite(TaskApiCall<TClient, TResult> taskApiCall) {
        String subAppID;
        this.f36795k = true;
        if (taskApiCall == null) {
            HMSLog.e("HuaweiApi", "in doWrite:taskApiCall is null");
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setException(new ApiException(Status.FAILURE));
            return taskCompletionSource.getTask();
        }
        if (TextUtils.isEmpty(this.f36791g.getSubAppID())) {
            subAppID = this.f36790f;
        } else {
            subAppID = this.f36791g.getSubAppID();
        }
        HiAnalyticsInnerClient.reportEntryClient(this.f36785a, taskApiCall.getUri(), subAppID, taskApiCall.getTransactionId(), String.valueOf(getKitSdkVersion()));
        if (this.f36798n == null) {
            this.f36798n = RequestManager.getInstance();
        }
        return a(taskApiCall);
    }

    public Activity getActivity() {
        WeakReference<Activity> weakReference = this.f36792h;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int getApiLevel() {
        return this.f36794j;
    }

    public String getAppID() {
        return this.f36790f;
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [com.huawei.hms.common.internal.AnyClient] */
    public AnyClient getClient(Looper looper, RequestHandler requestHandler) {
        return this.f36788d.buildClient(this.f36785a, getClientSetting(), requestHandler, requestHandler);
    }

    protected ClientSettings getClientSetting() {
        ClientSettings clientSettings = new ClientSettings(this.f36785a.getPackageName(), this.f36785a.getClass().getName(), getScopes(), this.f36789e, null, this.f36791g);
        if (!this.f36797m) {
            this.f36796l = HMSPackageManager.getInstance(this.f36785a).getHMSPackageNameForMultiService();
            HMSLog.i("HuaweiApi", "No setInnerHms, hms pkg name is " + this.f36796l);
        }
        clientSettings.setInnerHmsPkg(this.f36796l);
        clientSettings.setUseInnerHms(this.f36797m);
        WeakReference<Activity> weakReference = this.f36792h;
        if (weakReference != null) {
            clientSettings.setCpActivity(weakReference.get());
        }
        return clientSettings;
    }

    public Context getContext() {
        return this.f36785a;
    }

    public int getKitSdkVersion() {
        return this.f36793i;
    }

    public TOption getOption() {
        return this.f36786b;
    }

    protected List<Scope> getScopes() {
        return Collections.emptyList();
    }

    public String getSubAppID() {
        return this.f36791g.getSubAppID();
    }

    public void setApiLevel(int i3) {
        this.f36794j = i3;
    }

    public void setHostContext(Context context) {
        this.f36787c = context;
    }

    public void setInnerHms() {
        this.f36796l = this.f36785a.getPackageName();
        this.f36797m = true;
        HMSLog.i("HuaweiApi", "<setInnerHms> init inner hms pkg info:" + this.f36796l);
    }

    public void setKitSdkVersion(int i3) {
        this.f36793i = i3;
    }

    public void setSubAppId(String str) throws ApiException {
        if (setSubAppInfo(new SubAppInfo(str))) {
        } else {
            throw new ApiException(Status.FAILURE);
        }
    }

    @Deprecated
    public boolean setSubAppInfo(SubAppInfo subAppInfo) {
        HMSLog.i("HuaweiApi", "Enter setSubAppInfo");
        SubAppInfo subAppInfo2 = this.f36791g;
        if (subAppInfo2 != null && !TextUtils.isEmpty(subAppInfo2.getSubAppID())) {
            HMSLog.e("HuaweiApi", "subAppInfo is already set");
            return false;
        }
        if (subAppInfo == null) {
            HMSLog.e("HuaweiApi", "subAppInfo is null");
            return false;
        }
        String subAppID = subAppInfo.getSubAppID();
        if (TextUtils.isEmpty(subAppID)) {
            HMSLog.e("HuaweiApi", "subAppId is empty");
            return false;
        }
        if (subAppID.equals(this.f36789e)) {
            HMSLog.e("HuaweiApi", "subAppId is host appid");
            return false;
        }
        if (this.f36795k) {
            HMSLog.e("HuaweiApi", "Client has sent request to Huawei Mobile Services, setting subAppId is not allowed");
            return false;
        }
        this.f36791g = new SubAppInfo(subAppInfo);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        String appId = Util.getAppId(context);
        this.f36789e = appId;
        this.f36790f = appId;
    }

    private void a(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i3, String str) {
        this.f36785a = context.getApplicationContext();
        this.f36786b = toption;
        this.f36788d = abstractClientBuilder;
        b(context);
        this.f36791g = new SubAppInfo("");
        this.f36793i = i3;
        if (!TextUtils.isEmpty(str)) {
            if (str.equals(this.f36789e)) {
                HMSLog.e("HuaweiApi", "subAppId is host appid");
            } else {
                HMSLog.i("HuaweiApi", "subAppId is " + str);
                this.f36791g = new SubAppInfo(str);
            }
        }
        a(context);
    }

    public HuaweiApi(Activity activity, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i3, String str) {
        Checker.checkNonNull(activity, "Null activity is not permitted.");
        this.f36792h = new WeakReference<>(activity);
        a(activity, api, toption, abstractClientBuilder, i3, str);
    }

    public HuaweiApi(Activity activity, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder) {
        Checker.checkNonNull(activity, "Null activity is not permitted.");
        this.f36792h = new WeakReference<>(activity);
        a(activity, api, toption, abstractClientBuilder, 0, null);
    }

    private void a(Context context) {
        HMSBIInitializer.getInstance(context).initBI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HuaweiApi<?> huaweiApi, TaskCompletionSource<Boolean> taskCompletionSource) {
        HMSLog.i("HuaweiApi", "innerDisconnect.");
        try {
            huaweiApi.getClient(RequestManager.getHandler().getLooper(), null).disconnect();
            taskCompletionSource.setResult(Boolean.TRUE);
        } catch (Exception e16) {
            HMSLog.w("HuaweiApi", "disconnect the binder failed for:" + e16.getMessage());
        }
    }

    public HuaweiApi(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i3) {
        Checker.checkNonNull(context, "Null context is not permitted.");
        a(context, api, toption, abstractClientBuilder, i3, null);
    }

    private <TResult, TClient extends AnyClient> Task<TResult> a(TaskApiCall<TClient, TResult> taskApiCall) {
        TaskCompletionSource taskCompletionSource;
        if (taskApiCall.getToken() == null) {
            taskCompletionSource = new TaskCompletionSource();
        } else {
            taskCompletionSource = new TaskCompletionSource(taskApiCall.getToken());
        }
        RequestManager.getHandler().post(new a(this, new TaskApiCallWrapper(taskApiCall, taskCompletionSource)));
        return taskCompletionSource.getTask();
    }

    public HuaweiApi(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i3, String str) {
        Checker.checkNonNull(context, "Null context is not permitted.");
        a(context, api, toption, abstractClientBuilder, i3, str);
    }

    public HuaweiApi(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder) {
        Checker.checkNonNull(context, "Null context is not permitted.");
        a(context, api, toption, abstractClientBuilder, 0, null);
    }
}
