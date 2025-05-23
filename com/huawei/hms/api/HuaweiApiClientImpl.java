package com.huawei.hms.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.common.api.ConnectionPostProcessor;
import com.huawei.hms.common.internal.AutoLifecycleFragment;
import com.huawei.hms.core.aidl.CodecLookup;
import com.huawei.hms.core.aidl.DataBuffer;
import com.huawei.hms.core.aidl.IAIDLCallback;
import com.huawei.hms.core.aidl.IAIDLInvoke;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.MessageCodec;
import com.huawei.hms.core.aidl.RequestHeader;
import com.huawei.hms.core.aidl.ResponseHeader;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.BundleResult;
import com.huawei.hms.support.api.client.InnerApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.core.ConnectService;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.core.CheckConnectInfo;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.api.entity.core.ConnectInfo;
import com.huawei.hms.support.api.entity.core.ConnectResp;
import com.huawei.hms.support.api.entity.core.DisconnectInfo;
import com.huawei.hms.support.api.entity.core.DisconnectResp;
import com.huawei.hms.support.api.entity.core.JosGetNoticeResp;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.UIUtil;
import com.huawei.hms.utils.Util;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HuaweiApiClientImpl extends HuaweiApiClient implements InnerApiClient, ServiceConnection {
    private static final Object A = new Object();
    private static final Object B = new Object();
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final int SIGN_IN_MODE_OPTIONAL = 2;
    public static final int SIGN_IN_MODE_REQUIRED = 1;

    /* renamed from: b, reason: collision with root package name */
    private final Context f36719b;

    /* renamed from: c, reason: collision with root package name */
    private final String f36720c;

    /* renamed from: d, reason: collision with root package name */
    private String f36721d;

    /* renamed from: e, reason: collision with root package name */
    private String f36722e;

    /* renamed from: f, reason: collision with root package name */
    private volatile IAIDLInvoke f36723f;

    /* renamed from: g, reason: collision with root package name */
    private String f36724g;

    /* renamed from: h, reason: collision with root package name */
    private WeakReference<Activity> f36725h;

    /* renamed from: i, reason: collision with root package name */
    private WeakReference<Activity> f36726i;

    /* renamed from: l, reason: collision with root package name */
    private List<Scope> f36729l;

    /* renamed from: m, reason: collision with root package name */
    private List<PermissionInfo> f36730m;

    /* renamed from: n, reason: collision with root package name */
    private Map<Api<?>, Api.ApiOptions> f36731n;

    /* renamed from: o, reason: collision with root package name */
    private SubAppInfo f36732o;

    /* renamed from: s, reason: collision with root package name */
    private final ReentrantLock f36736s;

    /* renamed from: t, reason: collision with root package name */
    private final Condition f36737t;

    /* renamed from: u, reason: collision with root package name */
    private ConnectionResult f36738u;

    /* renamed from: v, reason: collision with root package name */
    private HuaweiApiClient.ConnectionCallbacks f36739v;

    /* renamed from: w, reason: collision with root package name */
    private HuaweiApiClient.OnConnectionFailedListener f36740w;

    /* renamed from: x, reason: collision with root package name */
    private Handler f36741x;

    /* renamed from: y, reason: collision with root package name */
    private Handler f36742y;

    /* renamed from: z, reason: collision with root package name */
    private CheckUpdatelistener f36743z;

    /* renamed from: a, reason: collision with root package name */
    private int f36718a = -1;

    /* renamed from: j, reason: collision with root package name */
    private boolean f36727j = false;

    /* renamed from: k, reason: collision with root package name */
    private AtomicInteger f36728k = new AtomicInteger(1);

    /* renamed from: p, reason: collision with root package name */
    private long f36733p = 0;

    /* renamed from: q, reason: collision with root package name */
    private int f36734q = 0;

    /* renamed from: r, reason: collision with root package name */
    private final Object f36735r = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message != null && message.what == 2) {
                HMSLog.e("HuaweiApiClientImpl", "In connect, bind core service time out");
                if (HuaweiApiClientImpl.this.f36728k.get() == 5) {
                    HuaweiApiClientImpl.this.c(1);
                    HuaweiApiClientImpl.this.b();
                }
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b implements Handler.Callback {
        b() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message != null && message.what == 3) {
                HMSLog.e("HuaweiApiClientImpl", "In connect, process time out");
                if (HuaweiApiClientImpl.this.f36728k.get() == 2) {
                    HuaweiApiClientImpl.this.c(1);
                    HuaweiApiClientImpl.this.b();
                }
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class c extends IAIDLCallback.Stub {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ResultCallback f36746a;

        c(ResultCallback resultCallback) {
            this.f36746a = resultCallback;
        }

        @Override // com.huawei.hms.core.aidl.IAIDLCallback
        public void call(DataBuffer dataBuffer) {
            if (dataBuffer != null) {
                MessageCodec find = CodecLookup.find(dataBuffer.getProtocol());
                ResponseHeader responseHeader = new ResponseHeader();
                find.decode(dataBuffer.header, responseHeader);
                BundleResult bundleResult = new BundleResult(responseHeader.getStatusCode(), dataBuffer.getBody());
                HMSLog.i("HuaweiApiClientImpl", "Exit asyncRequest onResult");
                this.f36746a.onResult(bundleResult);
                return;
            }
            HMSLog.i("HuaweiApiClientImpl", "Exit asyncRequest onResult -1");
            this.f36746a.onResult(new BundleResult(-1, null));
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class d extends PendingResultImpl<Status, IMessageEntity> {
        public d(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Status onComplete(IMessageEntity iMessageEntity) {
            return new Status(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class e implements ResultCallback<ResolveResult<ConnectResp>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ResolveResult f36749a;

            a(ResolveResult resolveResult) {
                this.f36749a = resolveResult;
            }

            @Override // java.lang.Runnable
            public void run() {
                HuaweiApiClientImpl.this.a((ResolveResult<ConnectResp>) this.f36749a);
            }
        }

        e() {
        }

        @Override // com.huawei.hms.support.api.client.ResultCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(ResolveResult<ConnectResp> resolveResult) {
            new Handler(Looper.getMainLooper()).post(new a(resolveResult));
        }

        /* synthetic */ e(HuaweiApiClientImpl huaweiApiClientImpl, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class f implements ResultCallback<ResolveResult<DisconnectResp>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ResolveResult f36752a;

            a(ResolveResult resolveResult) {
                this.f36752a = resolveResult;
            }

            @Override // java.lang.Runnable
            public void run() {
                HuaweiApiClientImpl.this.b((ResolveResult<DisconnectResp>) this.f36752a);
            }
        }

        f() {
        }

        @Override // com.huawei.hms.support.api.client.ResultCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(ResolveResult<DisconnectResp> resolveResult) {
            new Handler(Looper.getMainLooper()).post(new a(resolveResult));
        }

        /* synthetic */ f(HuaweiApiClientImpl huaweiApiClientImpl, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class g implements ResultCallback<ResolveResult<JosGetNoticeResp>> {
        g() {
        }

        @Override // com.huawei.hms.support.api.client.ResultCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(ResolveResult<JosGetNoticeResp> resolveResult) {
            JosGetNoticeResp value;
            Intent noticeIntent;
            if (resolveResult != null && resolveResult.getStatus().isSuccess() && (noticeIntent = (value = resolveResult.getValue()).getNoticeIntent()) != null && value.getStatusCode() == 0) {
                HMSLog.i("HuaweiApiClientImpl", "get notice has intent.");
                Activity validActivity = Util.getValidActivity((Activity) HuaweiApiClientImpl.this.f36725h.get(), HuaweiApiClientImpl.this.getTopActivity());
                if (validActivity != null) {
                    HuaweiApiClientImpl.this.f36727j = true;
                    validActivity.startActivity(noticeIntent);
                } else {
                    HMSLog.e("HuaweiApiClientImpl", "showNotice no valid activity!");
                }
            }
        }

        /* synthetic */ g(HuaweiApiClientImpl huaweiApiClientImpl, a aVar) {
            this();
        }
    }

    public HuaweiApiClientImpl(Context context) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f36736s = reentrantLock;
        this.f36737t = reentrantLock.newCondition();
        this.f36741x = null;
        this.f36742y = null;
        this.f36743z = null;
        this.f36719b = context;
        String appId = Util.getAppId(context);
        this.f36720c = appId;
        this.f36721d = appId;
        this.f36722e = Util.getCpId(context);
    }

    private DisconnectInfo d() {
        ArrayList arrayList = new ArrayList();
        Map<Api<?>, Api.ApiOptions> map = this.f36731n;
        if (map != null) {
            Iterator<Api<?>> it = map.keySet().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getApiName());
            }
        }
        return new DisconnectInfo(this.f36729l, arrayList);
    }

    private int e() {
        int hmsVersion = Util.getHmsVersion(this.f36719b);
        if (hmsVersion != 0 && hmsVersion >= 20503000) {
            return hmsVersion;
        }
        int f16 = f();
        if (g()) {
            if (f16 < 20503000) {
                return 20503000;
            }
            return f16;
        }
        if (f16 < 20600000) {
            return 20600000;
        }
        return f16;
    }

    private int f() {
        Integer num;
        int intValue;
        Map<Api<?>, Api.ApiOptions> apiMap = getApiMap();
        int i3 = 0;
        if (apiMap == null) {
            return 0;
        }
        Iterator<Api<?>> it = apiMap.keySet().iterator();
        while (it.hasNext()) {
            String apiName = it.next().getApiName();
            if (!TextUtils.isEmpty(apiName) && (num = HuaweiApiAvailability.getApiMap().get(apiName)) != null && (intValue = num.intValue()) > i3) {
                i3 = intValue;
            }
        }
        return i3;
    }

    private boolean g() {
        Map<Api<?>, Api.ApiOptions> map = this.f36731n;
        if (map != null) {
            Iterator<Api<?>> it = map.keySet().iterator();
            while (it.hasNext()) {
                if (HuaweiApiAvailability.HMS_API_NAME_GAME.equals(it.next().getApiName())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private void h() {
        Handler handler = this.f36741x;
        if (handler != null) {
            handler.removeMessages(2);
        } else {
            this.f36741x = new Handler(Looper.getMainLooper(), new a());
        }
        this.f36741x.sendEmptyMessageDelayed(2, 5000L);
    }

    private void i() {
        synchronized (B) {
            Handler handler = this.f36742y;
            if (handler != null) {
                handler.removeMessages(3);
            } else {
                this.f36742y = new Handler(Looper.getMainLooper(), new b());
            }
            HMSLog.d("HuaweiApiClientImpl", "sendEmptyMessageDelayed for onConnectionResult 3 seconds. the result is : " + this.f36742y.sendEmptyMessageDelayed(3, 3000L));
        }
    }

    private void j() {
        HMSLog.i("HuaweiApiClientImpl", "Enter sendConnectApiServceRequest.");
        ConnectService.connect(this, c()).setResultCallback(new e(this, null));
    }

    private void k() {
        ConnectService.disconnect(this, d()).setResultCallback(new f(this, null));
    }

    private void l() {
        HMSLog.i("HuaweiApiClientImpl", "Enter sendForceConnectApiServceRequest.");
        ConnectService.forceConnect(this, c()).setResultCallback(new e(this, null));
    }

    private void m() {
        if (this.f36727j) {
            HMSLog.i("HuaweiApiClientImpl", "Connect notice has been shown.");
        } else if (HuaweiApiAvailability.getInstance().isHuaweiMobileNoticeAvailable(this.f36719b) == 0) {
            ConnectService.getNotice(this, 0, "6.9.0.300").setResultCallback(new g(this, null));
        }
    }

    private void n() {
        Util.unBindServiceCatchException(this.f36719b, this);
        this.f36723f = null;
    }

    public int asyncRequest(Bundle bundle, String str, int i3, ResultCallback<BundleResult> resultCallback) {
        HMSLog.i("HuaweiApiClientImpl", "Enter asyncRequest.");
        if (resultCallback != null && str != null && bundle != null) {
            if (!innerIsConnected()) {
                HMSLog.e("HuaweiApiClientImpl", "client is unConnect.");
                return CommonCode.ErrorCode.CLIENT_API_INVALID;
            }
            DataBuffer dataBuffer = new DataBuffer(str, i3);
            MessageCodec find = CodecLookup.find(dataBuffer.getProtocol());
            dataBuffer.addBody(bundle);
            RequestHeader requestHeader = new RequestHeader(getAppID(), getPackageName(), 60900300, getSessionId());
            requestHeader.setApiNameList(getApiNameList());
            dataBuffer.header = find.encode(requestHeader, new Bundle());
            try {
                getService().asyncCall(dataBuffer, new c(resultCallback));
                return 0;
            } catch (RemoteException e16) {
                HMSLog.e("HuaweiApiClientImpl", "remote exception:" + e16.getMessage());
                return CommonCode.ErrorCode.INTERNAL_ERROR;
            }
        }
        HMSLog.e("HuaweiApiClientImpl", "arguments is invalid.");
        return CommonCode.ErrorCode.ARGUMENTS_INVALID;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void checkUpdate(Activity activity, CheckUpdatelistener checkUpdatelistener) {
        if (checkUpdatelistener == null) {
            HMSLog.e("HuaweiApiClientImpl", "listener is null!");
            return;
        }
        if (activity != null && !activity.isFinishing()) {
            this.f36743z = checkUpdatelistener;
            try {
                Class<?> cls = Class.forName("com.huawei.hms.update.manager.CheckUpdateLegacy");
                cls.getMethod("initCheckUpdateCallBack", Object.class, Activity.class).invoke(cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), this, activity);
                return;
            } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | InvocationTargetException e16) {
                HMSLog.e("HuaweiApiClientImpl", "invoke CheckUpdateLegacy.initCheckUpdateCallBack fail. " + e16.getMessage());
                checkUpdatelistener.onResult(-1);
                return;
            }
        }
        HMSLog.e("HuaweiApiClientImpl", "checkUpdate, activity is illegal: " + activity);
        checkUpdatelistener.onResult(-1);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void connect(Activity activity) {
        HMSLog.i("HuaweiApiClientImpl", "====== HMSSDK version: 60900300 ======");
        int i3 = this.f36728k.get();
        HMSLog.i("HuaweiApiClientImpl", "Enter connect, Connection Status: " + i3);
        if (i3 == 3 || i3 == 5 || i3 == 2 || i3 == 4) {
            return;
        }
        if (activity != null) {
            this.f36725h = new WeakReference<>(activity);
            this.f36726i = new WeakReference<>(activity);
        }
        this.f36721d = TextUtils.isEmpty(this.f36720c) ? Util.getAppId(this.f36719b) : this.f36720c;
        int e16 = e();
        HMSLog.i("HuaweiApiClientImpl", "connect minVersion:" + e16);
        HuaweiApiAvailability.setServicesVersionCode(e16);
        int isHuaweiMobileServicesAvailable = HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(this.f36719b, e16);
        HMSLog.i("HuaweiApiClientImpl", "In connect, isHuaweiMobileServicesAvailable result: " + isHuaweiMobileServicesAvailable);
        this.f36734q = HMSPackageManager.getInstance(this.f36719b).getHmsMultiServiceVersion();
        if (isHuaweiMobileServicesAvailable == 0) {
            c(5);
            if (this.f36723f == null) {
                a();
                return;
            }
            c(2);
            j();
            i();
            return;
        }
        if (this.f36740w != null) {
            b(isHuaweiMobileServicesAvailable);
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void connectForeground() {
        String str;
        HMSLog.i("HuaweiApiClientImpl", "====== HMSSDK version: 60900300 ======");
        int i3 = this.f36728k.get();
        HMSLog.i("HuaweiApiClientImpl", "Enter forceConnect, Connection Status: " + i3);
        if (i3 != 3 && i3 != 5 && i3 != 2 && i3 != 4) {
            if (TextUtils.isEmpty(this.f36720c)) {
                str = Util.getAppId(this.f36719b);
            } else {
                str = this.f36720c;
            }
            this.f36721d = str;
            l();
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void disableLifeCycleManagement(Activity activity) {
        if (this.f36718a >= 0) {
            AutoLifecycleFragment.getInstance(activity).stopAutoManage(this.f36718a);
            return;
        }
        throw new IllegalStateException("disableLifeCycleManagement failed");
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public PendingResult<Status> discardAndReconnect() {
        return new d(this, null, null);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void disconnect() {
        int i3 = this.f36728k.get();
        HMSLog.i("HuaweiApiClientImpl", "Enter disconnect, Connection Status: " + i3);
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 == 5) {
                    a(2);
                    c(4);
                    return;
                }
                return;
            }
            c(4);
            k();
            return;
        }
        c(4);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public Map<Api<?>, Api.ApiOptions> getApiMap() {
        return this.f36731n;
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public List<String> getApiNameList() {
        ArrayList arrayList = new ArrayList();
        Map<Api<?>, Api.ApiOptions> map = this.f36731n;
        if (map != null) {
            Iterator<Api<?>> it = map.keySet().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getApiName());
            }
        }
        return arrayList;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getAppID() {
        return this.f36721d;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public ConnectionResult getConnectionResult(Api<?> api) {
        if (isConnected()) {
            this.f36738u = null;
            return new ConnectionResult(0, (PendingIntent) null);
        }
        ConnectionResult connectionResult = this.f36738u;
        if (connectionResult != null) {
            return connectionResult;
        }
        return new ConnectionResult(13, (PendingIntent) null);
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public Context getContext() {
        return this.f36719b;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getCpID() {
        return this.f36722e;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getPackageName() {
        return this.f36719b.getPackageName();
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public List<PermissionInfo> getPermissionInfos() {
        return this.f36730m;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public List<Scope> getScopes() {
        return this.f36729l;
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public IAIDLInvoke getService() {
        return this.f36723f;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getSessionId() {
        return this.f36724g;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public final SubAppInfo getSubAppInfo() {
        return this.f36732o;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public Activity getTopActivity() {
        WeakReference<Activity> weakReference = this.f36726i;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getTransportName() {
        return IPCTransport.class.getName();
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean hasConnectedApi(Api<?> api) {
        return isConnected();
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean hasConnectionFailureListener(HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Checker.checkNonNull(onConnectionFailedListener, "onConnectionFailedListener should not be null");
        synchronized (this.f36735r) {
            if (this.f36740w == onConnectionFailedListener) {
                return true;
            }
            return false;
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean hasConnectionSuccessListener(HuaweiApiClient.ConnectionCallbacks connectionCallbacks) {
        Checker.checkNonNull(connectionCallbacks, "connectionCallbacksListener should not be null");
        synchronized (this.f36735r) {
            if (this.f36739v == connectionCallbacks) {
                return true;
            }
            return false;
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public ConnectionResult holdUpConnect() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.f36736s.lock();
            try {
                connect((Activity) null);
                while (isConnecting()) {
                    this.f36737t.await();
                }
                if (isConnected()) {
                    this.f36738u = null;
                    return new ConnectionResult(0, (PendingIntent) null);
                }
                ConnectionResult connectionResult = this.f36738u;
                return connectionResult != null ? connectionResult : new ConnectionResult(13, (PendingIntent) null);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, (PendingIntent) null);
            } finally {
                this.f36736s.unlock();
            }
        }
        throw new IllegalStateException("blockingConnect must not be called on the UI thread");
    }

    @Override // com.huawei.hms.support.api.client.InnerApiClient
    public boolean innerIsConnected() {
        if (this.f36728k.get() != 3 && this.f36728k.get() != 4) {
            return false;
        }
        return true;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient, com.huawei.hms.support.api.client.ApiClient
    public boolean isConnected() {
        if (this.f36734q == 0) {
            this.f36734q = HMSPackageManager.getInstance(this.f36719b).getHmsMultiServiceVersion();
        }
        if (this.f36734q < 20504000) {
            long currentTimeMillis = System.currentTimeMillis() - this.f36733p;
            if (currentTimeMillis > 0 && currentTimeMillis < MiniBoxNoticeInfo.MIN_5) {
                return innerIsConnected();
            }
            if (innerIsConnected()) {
                Status status = ConnectService.checkconnect(this, new CheckConnectInfo()).awaitOnAnyThread(2000L, TimeUnit.MILLISECONDS).getStatus();
                if (status.isSuccess()) {
                    this.f36733p = System.currentTimeMillis();
                    return true;
                }
                int statusCode = status.getStatusCode();
                HMSLog.i("HuaweiApiClientImpl", "isConnected is false, statuscode:" + statusCode);
                if (statusCode != 907135004) {
                    n();
                    c(1);
                    this.f36733p = System.currentTimeMillis();
                    return false;
                }
                return false;
            }
            return false;
        }
        return innerIsConnected();
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean isConnecting() {
        int i3 = this.f36728k.get();
        if (i3 != 2 && i3 != 5) {
            return false;
        }
        return true;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void onPause(Activity activity) {
        HMSLog.i("HuaweiApiClientImpl", MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
    }

    public void onResult(int i3) {
        this.f36743z.onResult(i3);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void onResume(Activity activity) {
        if (activity != null) {
            HMSLog.i("HuaweiApiClientImpl", "onResume");
            this.f36726i = new WeakReference<>(activity);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        PendingIntent pendingIntent;
        HMSLog.i("HuaweiApiClientImpl", "HuaweiApiClientImpl Enter onServiceConnected.");
        a(2);
        this.f36723f = IAIDLInvoke.Stub.asInterface(iBinder);
        if (this.f36723f == null) {
            HMSLog.e("HuaweiApiClientImpl", "In onServiceConnected, mCoreService must not be null.");
            n();
            c(1);
            if (this.f36740w != null) {
                WeakReference<Activity> weakReference = this.f36725h;
                if (weakReference != null && weakReference.get() != null) {
                    pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.f36725h.get(), 10);
                } else {
                    pendingIntent = null;
                }
                ConnectionResult connectionResult = new ConnectionResult(10, pendingIntent);
                this.f36740w.onConnectionFailed(connectionResult);
                this.f36738u = connectionResult;
                return;
            }
            return;
        }
        if (this.f36728k.get() == 5) {
            c(2);
            j();
            i();
        } else if (this.f36728k.get() != 3) {
            n();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        HMSLog.i("HuaweiApiClientImpl", "Enter onServiceDisconnected.");
        this.f36723f = null;
        c(1);
        HuaweiApiClient.ConnectionCallbacks connectionCallbacks = this.f36739v;
        if (connectionCallbacks != null) {
            connectionCallbacks.onConnectionSuspended(1);
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void reconnect() {
        disconnect();
        connect((Activity) null);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void removeConnectionFailureListener(HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Checker.checkNonNull(onConnectionFailedListener, "onConnectionFailedListener should not be null");
        synchronized (this.f36735r) {
            if (this.f36740w != onConnectionFailedListener) {
                HMSLog.w("HuaweiApiClientImpl", "unregisterConnectionFailedListener: this onConnectionFailedListener has not been registered");
            } else {
                this.f36740w = null;
            }
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void removeConnectionSuccessListener(HuaweiApiClient.ConnectionCallbacks connectionCallbacks) {
        Checker.checkNonNull(connectionCallbacks, "connectionCallbacksListener should not be null");
        synchronized (this.f36735r) {
            if (this.f36739v != connectionCallbacks) {
                HMSLog.w("HuaweiApiClientImpl", "unregisterConnectionCallback: this connectionCallbacksListener has not been registered");
            } else {
                this.f36739v = null;
            }
        }
    }

    public void resetListener() {
        this.f36743z = null;
    }

    public void setApiMap(Map<Api<?>, Api.ApiOptions> map) {
        this.f36731n = map;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setAutoLifecycleClientId(int i3) {
        this.f36718a = i3;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void setConnectionCallbacks(HuaweiApiClient.ConnectionCallbacks connectionCallbacks) {
        this.f36739v = connectionCallbacks;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void setConnectionFailedListener(HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f36740w = onConnectionFailedListener;
    }

    public void setHasShowNotice(boolean z16) {
        this.f36727j = z16;
    }

    public void setPermissionInfos(List<PermissionInfo> list) {
        this.f36730m = list;
    }

    public void setScopes(List<Scope> list) {
        this.f36729l = list;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean setSubAppInfo(SubAppInfo subAppInfo) {
        String str;
        HMSLog.i("HuaweiApiClientImpl", "Enter setSubAppInfo");
        if (subAppInfo == null) {
            HMSLog.e("HuaweiApiClientImpl", "subAppInfo is null");
            return false;
        }
        String subAppID = subAppInfo.getSubAppID();
        if (TextUtils.isEmpty(subAppID)) {
            HMSLog.e("HuaweiApiClientImpl", "subAppId is empty");
            return false;
        }
        if (TextUtils.isEmpty(this.f36720c)) {
            str = Util.getAppId(this.f36719b);
        } else {
            str = this.f36720c;
        }
        if (subAppID.equals(str)) {
            HMSLog.e("HuaweiApiClientImpl", "subAppId is host appid");
            return false;
        }
        this.f36732o = new SubAppInfo(subAppInfo);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i3) {
        this.f36728k.set(i3);
        if (i3 == 1 || i3 == 3 || i3 == 2) {
            this.f36736s.lock();
            try {
                this.f36737t.signalAll();
            } finally {
                this.f36736s.unlock();
            }
        }
    }

    private void b(int i3) {
        PendingIntent pendingIntent;
        WeakReference<Activity> weakReference = this.f36725h;
        if (weakReference == null || weakReference.get() == null) {
            pendingIntent = null;
        } else {
            pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.f36725h.get(), i3);
            HMSLog.i("HuaweiApiClientImpl", "connect 2.0 fail: " + i3);
        }
        ConnectionResult connectionResult = new ConnectionResult(i3, pendingIntent);
        this.f36740w.onConnectionFailed(connectionResult);
        this.f36738u = connectionResult;
    }

    private void a() {
        Intent intent = new Intent(HMSPackageManager.getInstance(this.f36719b).getServiceAction());
        HMSPackageManager.getInstance(this.f36719b).refreshForMultiService();
        try {
            intent.setPackage(HMSPackageManager.getInstance(this.f36719b).getHMSPackageNameForMultiService());
            synchronized (A) {
                if (this.f36719b.bindService(intent, this, 1)) {
                    h();
                    return;
                }
                c(1);
                HMSLog.e("HuaweiApiClientImpl", "In connect, bind core service fail");
                b();
            }
        } catch (IllegalArgumentException unused) {
            HMSLog.e("HuaweiApiClientImpl", "IllegalArgumentException when bindCoreService intent.setPackage");
            c(1);
            HMSLog.e("HuaweiApiClientImpl", "In connect, bind core service fail");
            b();
        }
    }

    private ConnectInfo c() {
        String packageSignature = new PackageManagerHelper(this.f36719b).getPackageSignature(this.f36719b.getPackageName());
        if (packageSignature == null) {
            packageSignature = "";
        }
        SubAppInfo subAppInfo = this.f36732o;
        return new ConnectInfo(getApiNameList(), this.f36729l, packageSignature, subAppInfo == null ? null : subAppInfo.getSubAppID());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        n();
        if (this.f36740w != null) {
            int i3 = UIUtil.isBackground(this.f36719b) ? 7 : 6;
            WeakReference<Activity> weakReference = this.f36725h;
            ConnectionResult connectionResult = new ConnectionResult(i3, (weakReference == null || weakReference.get() == null) ? null : HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.f36725h.get(), i3));
            this.f36740w.onConnectionFailed(connectionResult);
            this.f36738u = connectionResult;
        }
    }

    private void c(ResolveResult<ConnectResp> resolveResult) {
        if (resolveResult.getValue() != null) {
            ProtocolNegotiate.getInstance().negotiate(resolveResult.getValue().protocolVersion);
        }
        c(3);
        this.f36738u = null;
        HuaweiApiClient.ConnectionCallbacks connectionCallbacks = this.f36739v;
        if (connectionCallbacks != null) {
            connectionCallbacks.onConnected();
        }
        if (this.f36725h != null) {
            m();
        }
        for (Map.Entry<Api<?>, Api.ApiOptions> entry : getApiMap().entrySet()) {
            if (entry.getKey().getmConnetctPostList() != null && !entry.getKey().getmConnetctPostList().isEmpty()) {
                HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult, get the ConnetctPostList ");
                for (ConnectionPostProcessor connectionPostProcessor : entry.getKey().getmConnetctPostList()) {
                    HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult, processor.run");
                    connectionPostProcessor.run(this, this.f36725h);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ResolveResult<DisconnectResp> resolveResult) {
        HMSLog.i("HuaweiApiClientImpl", "Enter onDisconnectionResult, disconnect from server result: " + resolveResult.getStatus().getStatusCode());
        n();
        c(1);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public ConnectionResult holdUpConnect(long j3, TimeUnit timeUnit) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.f36736s.lock();
            try {
                connect((Activity) null);
                long nanos = timeUnit.toNanos(j3);
                while (isConnecting()) {
                    if (nanos <= 0) {
                        disconnect();
                        return new ConnectionResult(14, (PendingIntent) null);
                    }
                    nanos = this.f36737t.awaitNanos(nanos);
                }
                if (isConnected()) {
                    this.f36738u = null;
                    return new ConnectionResult(0, (PendingIntent) null);
                }
                ConnectionResult connectionResult = this.f36738u;
                return connectionResult != null ? connectionResult : new ConnectionResult(13, (PendingIntent) null);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, (PendingIntent) null);
            } finally {
                this.f36736s.unlock();
            }
        }
        throw new IllegalStateException("blockingConnect must not be called on the UI thread");
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void connect(int i3) {
        connect((Activity) null);
    }

    private void a(int i3) {
        if (i3 == 2) {
            synchronized (A) {
                Handler handler = this.f36741x;
                if (handler != null) {
                    handler.removeMessages(i3);
                    this.f36741x = null;
                }
            }
        }
        if (i3 == 3) {
            synchronized (B) {
                Handler handler2 = this.f36742y;
                if (handler2 != null) {
                    handler2.removeMessages(i3);
                    this.f36742y = null;
                }
            }
        }
        synchronized (A) {
            Handler handler3 = this.f36741x;
            if (handler3 != null) {
                handler3.removeMessages(2);
                this.f36741x = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResolveResult<ConnectResp> resolveResult) {
        HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult");
        if (this.f36723f != null && this.f36728k.get() == 2) {
            a(3);
            ConnectResp value = resolveResult.getValue();
            if (value != null) {
                this.f36724g = value.sessionId;
            }
            SubAppInfo subAppInfo = this.f36732o;
            PendingIntent pendingIntent = null;
            String subAppID = subAppInfo == null ? null : subAppInfo.getSubAppID();
            if (!TextUtils.isEmpty(subAppID)) {
                this.f36721d = subAppID;
            }
            int statusCode = resolveResult.getStatus().getStatusCode();
            HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult, connect to server result: " + statusCode);
            if (Status.SUCCESS.equals(resolveResult.getStatus())) {
                c(resolveResult);
                return;
            }
            if (resolveResult.getStatus() != null && resolveResult.getStatus().getStatusCode() == 1001) {
                n();
                c(1);
                HuaweiApiClient.ConnectionCallbacks connectionCallbacks = this.f36739v;
                if (connectionCallbacks != null) {
                    connectionCallbacks.onConnectionSuspended(3);
                    return;
                }
                return;
            }
            n();
            c(1);
            if (this.f36740w != null) {
                WeakReference<Activity> weakReference = this.f36725h;
                if (weakReference != null && weakReference.get() != null) {
                    pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.f36725h.get(), statusCode);
                }
                ConnectionResult connectionResult = new ConnectionResult(statusCode, pendingIntent);
                this.f36740w.onConnectionFailed(connectionResult);
                this.f36738u = connectionResult;
                return;
            }
            return;
        }
        HMSLog.e("HuaweiApiClientImpl", "Invalid onConnectionResult");
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void print(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }
}
