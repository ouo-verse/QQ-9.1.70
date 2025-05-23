package com.huawei.hms.common.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.adapter.BinderAdapter;
import com.huawei.hms.adapter.InnerBinderAdapter;
import com.huawei.hms.adapter.OuterBinderAdapter;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.FailedBinderCallBack;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.api.IPCTransport;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.core.aidl.IAIDLInvoke;
import com.huawei.hms.support.api.client.AidlApiClient;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.Util;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class BaseHmsClient implements AidlApiClient {
    protected static final int TIMEOUT_DISCONNECTED = 6;

    /* renamed from: i, reason: collision with root package name */
    private static final Object f36832i = new Object();

    /* renamed from: j, reason: collision with root package name */
    private static final AtomicInteger f36833j = new AtomicInteger(1);

    /* renamed from: k, reason: collision with root package name */
    private static final AtomicInteger f36834k = new AtomicInteger(1);

    /* renamed from: l, reason: collision with root package name */
    private static BinderAdapter f36835l;

    /* renamed from: m, reason: collision with root package name */
    private static BinderAdapter f36836m;

    /* renamed from: a, reason: collision with root package name */
    private final Context f36837a;

    /* renamed from: b, reason: collision with root package name */
    private String f36838b;

    /* renamed from: c, reason: collision with root package name */
    private final ClientSettings f36839c;

    /* renamed from: d, reason: collision with root package name */
    private volatile IAIDLInvoke f36840d;

    /* renamed from: e, reason: collision with root package name */
    private final ConnectionCallbacks f36841e;

    /* renamed from: f, reason: collision with root package name */
    private final OnConnectionFailedListener f36842f;

    /* renamed from: g, reason: collision with root package name */
    private Handler f36843g = null;

    /* renamed from: h, reason: collision with root package name */
    private HuaweiApi.RequestHandler f36844h;
    protected String sessionId;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface ConnectionCallbacks {
        public static final int CAUSE_API_CLIENT_EXPIRED = 3;
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected();

        void onConnectionSuspended(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class ConnectionResultWrapper {

        /* renamed from: a, reason: collision with root package name */
        private HuaweiApi.RequestHandler f36849a;

        /* renamed from: b, reason: collision with root package name */
        private ConnectionResult f36850b;

        public ConnectionResultWrapper(HuaweiApi.RequestHandler requestHandler, ConnectionResult connectionResult) {
            this.f36849a = requestHandler;
            this.f36850b = connectionResult;
        }

        public ConnectionResult getConnectionResult() {
            return this.f36850b;
        }

        public HuaweiApi.RequestHandler getRequest() {
            return this.f36849a;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    public BaseHmsClient(Context context, ClientSettings clientSettings, OnConnectionFailedListener onConnectionFailedListener, ConnectionCallbacks connectionCallbacks) {
        this.f36837a = context;
        this.f36839c = clientSettings;
        this.f36838b = clientSettings.getAppID();
        this.f36842f = onConnectionFailedListener;
        this.f36841e = connectionCallbacks;
    }

    private BinderAdapter.BinderCallBack c() {
        return new BinderAdapter.BinderCallBack() { // from class: com.huawei.hms.common.internal.BaseHmsClient.1
            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onBinderFailed(int i3) {
                onBinderFailed(i3, null);
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onNullBinding(ComponentName componentName) {
                BaseHmsClient.this.b(1);
                BaseHmsClient.this.a(10);
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                HMSLog.i("BaseHmsClient", "Enter onServiceConnected.");
                BaseHmsClient.this.connectedInternal(iBinder);
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onServiceDisconnected(ComponentName componentName) {
                HMSLog.i("BaseHmsClient", "Enter onServiceDisconnected.");
                BaseHmsClient.this.b(1);
                RequestManager.getHandler().sendEmptyMessage(10013);
                if (BaseHmsClient.this.f36841e != null && !(BaseHmsClient.this.f36841e instanceof HuaweiApi.RequestHandler)) {
                    BaseHmsClient.this.f36841e.onConnectionSuspended(1);
                }
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onTimedDisconnected() {
                BaseHmsClient.this.b(6);
                if (BaseHmsClient.this.f36841e != null && !(BaseHmsClient.this.f36841e instanceof HuaweiApi.RequestHandler)) {
                    BaseHmsClient.this.f36841e.onConnectionSuspended(1);
                }
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onBinderFailed(int i3, Intent intent) {
                if (intent != null) {
                    Activity activeActivity = Util.getActiveActivity(BaseHmsClient.this.getClientSettings().getCpActivity(), BaseHmsClient.this.getContext());
                    if (activeActivity != null) {
                        HMSLog.i("BaseHmsClient", "onBinderFailed: SDK try to resolve and reConnect!");
                        long time = new Timestamp(System.currentTimeMillis()).getTime();
                        FailedBinderCallBack.getInstance().setCallBack(Long.valueOf(time), new FailedBinderCallBack.BinderCallBack() { // from class: com.huawei.hms.common.internal.BaseHmsClient.1.1
                            @Override // com.huawei.hms.api.FailedBinderCallBack.BinderCallBack
                            public void binderCallBack(int i16) {
                                if (i16 != 0) {
                                    BaseHmsClient.this.a(new ConnectionResult(10, (PendingIntent) null));
                                    BaseHmsClient.this.f36840d = null;
                                }
                            }
                        });
                        intent.putExtra("callId", time);
                        activeActivity.startActivity(intent);
                        return;
                    }
                    HMSLog.i("BaseHmsClient", "onBinderFailed: return pendingIntent to kit and cp");
                    BaseHmsClient.this.a(new ConnectionResult(10, PendingIntent.getActivity(BaseHmsClient.this.f36837a, 11, intent, 67108864)));
                    BaseHmsClient.this.f36840d = null;
                    return;
                }
                HMSLog.i("BaseHmsClient", "onBinderFailed: intent is null!");
                BaseHmsClient.this.a(new ConnectionResult(10, (PendingIntent) null));
                BaseHmsClient.this.f36840d = null;
            }
        };
    }

    private void d() {
        HMSLog.w("BaseHmsClient", "Failed to get service as interface, trying to unbind.");
        if (this.f36839c.isUseInnerHms()) {
            BinderAdapter binderAdapter = f36836m;
            if (binderAdapter == null) {
                HMSLog.w("BaseHmsClient", "mInnerBinderAdapter is null.");
                return;
            }
            binderAdapter.unBind();
        } else {
            BinderAdapter binderAdapter2 = f36835l;
            if (binderAdapter2 == null) {
                HMSLog.w("BaseHmsClient", "mOuterBinderAdapter is null.");
                return;
            }
            binderAdapter2.unBind();
        }
        b(1);
        a(10);
    }

    private void e() {
        if (this.f36839c.isUseInnerHms()) {
            BinderAdapter binderAdapter = f36836m;
            if (binderAdapter != null) {
                binderAdapter.unBind();
                return;
            }
            return;
        }
        BinderAdapter binderAdapter2 = f36835l;
        if (binderAdapter2 != null) {
            binderAdapter2.unBind();
        }
    }

    protected final void checkConnected() {
        if (isConnected()) {
        } else {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void connect(int i3) {
        a(i3, false);
    }

    public void connectedInternal(IBinder iBinder) {
        this.f36840d = IAIDLInvoke.Stub.asInterface(iBinder);
        if (this.f36840d == null) {
            HMSLog.e("BaseHmsClient", "mService is null, try to unBind.");
            d();
        } else {
            onConnecting();
        }
    }

    protected final void connectionConnected() {
        b(3);
        RequestManager.getHandler().sendEmptyMessage(10011);
        ConnectionCallbacks connectionCallbacks = this.f36841e;
        if (connectionCallbacks != null && !(connectionCallbacks instanceof HuaweiApi.RequestHandler)) {
            connectionCallbacks.onConnected();
        }
    }

    public void disconnect() {
        AtomicInteger atomicInteger;
        if (this.f36839c.isUseInnerHms()) {
            atomicInteger = f36834k;
        } else {
            atomicInteger = f36833j;
        }
        int i3 = atomicInteger.get();
        HMSLog.i("BaseHmsClient", "Enter disconnect, Connection Status: " + i3);
        if (i3 != 3) {
            if (i3 == 5) {
                b();
                b(1);
                return;
            }
            return;
        }
        e();
        b(1);
    }

    public BinderAdapter getAdapter() {
        HMSLog.i("BaseHmsClient", "getAdapter:isInner:" + this.f36839c.isUseInnerHms() + ", mInnerBinderAdapter:" + f36836m + ", mOuterBinderAdapter:" + f36835l);
        if (this.f36839c.isUseInnerHms()) {
            return f36836m;
        }
        return f36835l;
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public List<String> getApiNameList() {
        return this.f36839c.getApiName();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getAppID() {
        return this.f36838b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ClientSettings getClientSettings() {
        return this.f36839c;
    }

    public int getConnectionStatus() {
        AtomicInteger atomicInteger;
        if (this.f36839c.isUseInnerHms()) {
            atomicInteger = f36834k;
        } else {
            atomicInteger = f36833j;
        }
        return atomicInteger.get();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public Context getContext() {
        return this.f36837a;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getCpID() {
        return this.f36839c.getCpID();
    }

    @Deprecated
    public int getMinApkVersion() {
        return 30000000;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getPackageName() {
        return this.f36839c.getClientPackageName();
    }

    public int getRequestHmsVersionCode() {
        return getMinApkVersion();
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public IAIDLInvoke getService() {
        return this.f36840d;
    }

    public String getServiceAction() {
        HMSPackageManager hMSPackageManager = HMSPackageManager.getInstance(this.f36837a);
        if (this.f36839c.isUseInnerHms()) {
            return hMSPackageManager.getInnerServiceAction();
        }
        return hMSPackageManager.getServiceAction();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getSessionId() {
        return this.sessionId;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public SubAppInfo getSubAppInfo() {
        return this.f36839c.getSubAppID();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getTransportName() {
        return IPCTransport.class.getName();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public boolean isConnected() {
        if (!this.f36839c.isUseInnerHms() ? f36833j.get() == 3 : f36834k.get() == 3) {
            return true;
        }
        return false;
    }

    public boolean isConnecting() {
        AtomicInteger atomicInteger;
        if (this.f36839c.isUseInnerHms()) {
            atomicInteger = f36834k;
        } else {
            atomicInteger = f36833j;
        }
        if (atomicInteger.get() == 5) {
            return true;
        }
        return false;
    }

    public void onConnecting() {
        connectionConnected();
    }

    public final void setInternalRequest(HuaweiApi.RequestHandler requestHandler) {
        this.f36844h = requestHandler;
    }

    public void setService(IAIDLInvoke iAIDLInvoke) {
        this.f36840d = iAIDLInvoke;
    }

    void b(int i3) {
        if (this.f36839c.isUseInnerHms()) {
            f36834k.set(i3);
        } else {
            f36833j.set(i3);
        }
    }

    public void connect(int i3, boolean z16) {
        a(i3, z16);
    }

    private void b() {
        synchronized (f36832i) {
            Handler handler = this.f36843g;
            if (handler != null) {
                handler.removeMessages(2);
                this.f36843g = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        String innerHmsPkg = this.f36839c.getInnerHmsPkg();
        String serviceAction = getServiceAction();
        HMSLog.i("BaseHmsClient", "enter bindCoreService, packageName is " + innerHmsPkg + ", serviceAction is " + serviceAction);
        a(innerHmsPkg, serviceAction);
    }

    private void a(String str, String str2) {
        if (this.f36839c.isUseInnerHms()) {
            f36836m = InnerBinderAdapter.getInstance(this.f36837a, str2, str);
            if (isConnected()) {
                HMSLog.i("BaseHmsClient", "The binder is already connected.");
                getAdapter().updateDelayTask();
                connectedInternal(getAdapter().getServiceBinder());
                return;
            } else {
                b(5);
                f36836m.binder(c());
                return;
            }
        }
        f36835l = OuterBinderAdapter.getInstance(this.f36837a, str2, str);
        if (isConnected()) {
            HMSLog.i("BaseHmsClient", "The binder is already connected.");
            getAdapter().updateDelayTask();
            connectedInternal(getAdapter().getServiceBinder());
        } else {
            b(5);
            f36835l.binder(c());
        }
    }

    private void b(AvailableAdapter availableAdapter, int i3) {
        HMSLog.i("BaseHmsClient", "enter HmsCore resolution");
        if (!getClientSettings().isHasActivity()) {
            a(new ConnectionResult(26, HuaweiApiAvailability.getInstance().getErrPendingIntent(this.f36837a, i3, 0)));
            return;
        }
        Activity activeActivity = Util.getActiveActivity(getClientSettings().getCpActivity(), getContext());
        if (activeActivity != null) {
            availableAdapter.startResolution(activeActivity, new AvailableAdapter.AvailableCallBack() { // from class: com.huawei.hms.common.internal.BaseHmsClient.3
                @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
                public void onComplete(int i16) {
                    if (i16 != 0) {
                        BaseHmsClient.this.a(i16);
                    } else {
                        BaseHmsClient.this.a();
                    }
                }
            });
        } else {
            a(26);
        }
    }

    private void a(int i3, boolean z16) {
        HMSLog.i("BaseHmsClient", "====== HMSSDK version: 60900300 ======");
        int i16 = (this.f36839c.isUseInnerHms() ? f36834k : f36833j).get();
        HMSLog.i("BaseHmsClient", "Enter connect, Connection Status: " + i16);
        if (z16 || !(i16 == 3 || i16 == 5)) {
            if (getMinApkVersion() > i3) {
                i3 = getMinApkVersion();
            }
            HMSLog.i("BaseHmsClient", "connect minVersion:" + i3 + " packageName:" + this.f36839c.getInnerHmsPkg());
            if (this.f36837a.getPackageName().equals(this.f36839c.getInnerHmsPkg())) {
                HMSLog.i("BaseHmsClient", "service packageName is same, bind core service return");
                a();
                return;
            }
            if (Util.isAvailableLibExist(this.f36837a)) {
                AvailableAdapter availableAdapter = new AvailableAdapter(i3);
                int isHuaweiMobileServicesAvailable = availableAdapter.isHuaweiMobileServicesAvailable(this.f36837a);
                HMSLog.i("BaseHmsClient", "check available result: " + isHuaweiMobileServicesAvailable);
                if (isHuaweiMobileServicesAvailable == 0) {
                    a();
                    return;
                }
                if (availableAdapter.isUserResolvableError(isHuaweiMobileServicesAvailable)) {
                    HMSLog.i("BaseHmsClient", "bindCoreService3.0 fail, start resolution now.");
                    b(availableAdapter, isHuaweiMobileServicesAvailable);
                    return;
                } else {
                    if (availableAdapter.isUserNoticeError(isHuaweiMobileServicesAvailable)) {
                        HMSLog.i("BaseHmsClient", "bindCoreService3.0 fail, start notice now.");
                        a(availableAdapter, isHuaweiMobileServicesAvailable);
                        return;
                    }
                    HMSLog.i("BaseHmsClient", "bindCoreService3.0 fail: " + isHuaweiMobileServicesAvailable + " is not resolvable.");
                    a(isHuaweiMobileServicesAvailable);
                    return;
                }
            }
            int isHuaweiMobileServicesAvailable2 = HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(this.f36837a, i3);
            HMSLog.i("BaseHmsClient", "HuaweiApiAvailability check available result: " + isHuaweiMobileServicesAvailable2);
            if (isHuaweiMobileServicesAvailable2 == 0) {
                a();
            } else {
                a(isHuaweiMobileServicesAvailable2);
            }
        }
    }

    private void a(AvailableAdapter availableAdapter, int i3) {
        HMSLog.i("BaseHmsClient", "enter notice");
        if (!getClientSettings().isHasActivity()) {
            if (i3 == 29) {
                i3 = 9;
            }
            a(new ConnectionResult(26, HuaweiApiAvailability.getInstance().getErrPendingIntent(this.f36837a, i3, 0)));
        } else {
            Activity activeActivity = Util.getActiveActivity(getClientSettings().getCpActivity(), getContext());
            if (activeActivity != null) {
                availableAdapter.startNotice(activeActivity, new AvailableAdapter.AvailableCallBack() { // from class: com.huawei.hms.common.internal.BaseHmsClient.2
                    @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
                    public void onComplete(int i16) {
                        BaseHmsClient.this.a(i16);
                    }
                });
            } else {
                a(26);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i3) {
        HMSLog.i("BaseHmsClient", "notifyFailed result: " + i3);
        Message message = new Message();
        message.what = 10012;
        message.obj = new ConnectionResultWrapper(this.f36844h, new ConnectionResult(i3));
        RequestManager.getHandler().sendMessage(message);
        OnConnectionFailedListener onConnectionFailedListener = this.f36842f;
        if (onConnectionFailedListener == null || (onConnectionFailedListener instanceof HuaweiApi.RequestHandler)) {
            return;
        }
        onConnectionFailedListener.onConnectionFailed(new ConnectionResult(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ConnectionResult connectionResult) {
        HMSLog.i("BaseHmsClient", "notifyFailed result: " + connectionResult.getErrorCode());
        Message message = new Message();
        message.what = 10012;
        HuaweiApi.RequestHandler requestHandler = this.f36844h;
        this.f36844h = null;
        message.obj = new ConnectionResultWrapper(requestHandler, connectionResult);
        RequestManager.getHandler().sendMessage(message);
        OnConnectionFailedListener onConnectionFailedListener = this.f36842f;
        if (onConnectionFailedListener == null || (onConnectionFailedListener instanceof HuaweiApi.RequestHandler)) {
            return;
        }
        onConnectionFailedListener.onConnectionFailed(connectionResult);
    }
}
