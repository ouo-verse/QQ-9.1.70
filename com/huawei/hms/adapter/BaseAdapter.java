package com.huawei.hms.adapter;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.sysobs.ApkResolutionFailedManager;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.adapter.sysobs.SystemObserver;
import com.huawei.hms.adapter.ui.BaseResolutionAdapter;
import com.huawei.hms.adapter.ui.UpdateAdapter;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.ResponseWrap;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.kpms.KpmsConstant;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.IntentUtil;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.ResolutionFlagUtil;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.sql.Timestamp;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<ApiClient> f36644a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<Activity> f36645b;

    /* renamed from: c, reason: collision with root package name */
    private BaseCallBack f36646c;

    /* renamed from: d, reason: collision with root package name */
    private String f36647d;

    /* renamed from: e, reason: collision with root package name */
    private String f36648e;

    /* renamed from: f, reason: collision with root package name */
    private Parcelable f36649f;

    /* renamed from: g, reason: collision with root package name */
    private BaseCallBack f36650g;

    /* renamed from: h, reason: collision with root package name */
    private String f36651h;

    /* renamed from: i, reason: collision with root package name */
    private Context f36652i;

    /* renamed from: j, reason: collision with root package name */
    private RequestHeader f36653j = new RequestHeader();

    /* renamed from: k, reason: collision with root package name */
    private ResponseHeader f36654k = new ResponseHeader();

    /* renamed from: l, reason: collision with root package name */
    private SystemObserver f36655l;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface BaseCallBack {
        void onComplete(String str, String str2, Parcelable parcelable);

        void onError(String str);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class BaseRequestResultCallback implements ResultCallback<ResolveResult<CoreBaseResponse>> {

        /* renamed from: a, reason: collision with root package name */
        private AtomicBoolean f36659a = new AtomicBoolean(true);

        public BaseRequestResultCallback() {
        }

        private void a(String str, BaseCallBack baseCallBack, CoreBaseResponse coreBaseResponse, int i3) {
            if ("intent".equals(str)) {
                Activity c16 = BaseAdapter.this.c();
                HMSLog.i("BaseAdapter", "activity is: " + c16);
                if (c16 != null && !c16.isFinishing()) {
                    PendingIntent pendingIntent = coreBaseResponse.getPendingIntent();
                    if (pendingIntent != null) {
                        if (!Util.isAvailableLibExist(BaseAdapter.this.f36652i)) {
                            baseCallBack.onError(BaseAdapter.this.b(-9));
                            return;
                        } else {
                            BaseAdapter.this.a(c16, pendingIntent, coreBaseResponse);
                            return;
                        }
                    }
                    Intent intent = coreBaseResponse.getIntent();
                    if (intent != null) {
                        if (!Util.isAvailableLibExist(BaseAdapter.this.f36652i)) {
                            baseCallBack.onError(BaseAdapter.this.b(-9));
                            return;
                        } else {
                            BaseAdapter.this.a(c16, intent, coreBaseResponse);
                            return;
                        }
                    }
                    if (i3 == 2) {
                        BaseAdapter baseAdapter = BaseAdapter.this;
                        baseCallBack.onError(baseAdapter.b(baseAdapter.f36654k.getErrorCode()));
                        return;
                    } else {
                        HMSLog.e("BaseAdapter", "hasResolution is true but NO_SOLUTION");
                        baseCallBack.onError(BaseAdapter.this.b(-4));
                        return;
                    }
                }
                HMSLog.e("BaseAdapter", "activity null");
                BaseAdapter.this.a(baseCallBack, coreBaseResponse);
                return;
            }
            if (!"installHMS".equals(str)) {
                BaseAdapter.this.a(baseCallBack, coreBaseResponse);
            } else {
                HMSLog.i("BaseAdapter", "has resolutin: installHMS");
                a(baseCallBack, coreBaseResponse);
            }
        }

        @Override // com.huawei.hms.support.api.client.ResultCallback
        public void onResult(ResolveResult<CoreBaseResponse> resolveResult) {
            BaseCallBack b16 = BaseAdapter.this.b();
            if (b16 == null) {
                HMSLog.e("BaseAdapter", "onResult baseCallBack null");
                return;
            }
            if (resolveResult == null) {
                HMSLog.e("BaseAdapter", "result null");
                b16.onError(BaseAdapter.this.b(-1));
                return;
            }
            CoreBaseResponse value = resolveResult.getValue();
            if (value == null) {
                HMSLog.e("BaseAdapter", "response null");
                b16.onError(BaseAdapter.this.b(-1));
                return;
            }
            if (!TextUtils.isEmpty(value.getJsonHeader())) {
                JsonUtil.jsonToEntity(value.getJsonHeader(), BaseAdapter.this.f36654k);
                if (this.f36659a.compareAndSet(true, false)) {
                    BaseAdapter baseAdapter = BaseAdapter.this;
                    baseAdapter.a(baseAdapter.f36652i, BaseAdapter.this.f36654k);
                }
                String resolution = BaseAdapter.this.f36654k.getResolution();
                int statusCode = BaseAdapter.this.f36654k.getStatusCode();
                HMSLog.i("BaseAdapter", "api is: " + BaseAdapter.this.f36654k.getApiName() + ", resolution: " + resolution + ", status_code: " + statusCode);
                a(resolution, b16, value, statusCode);
                return;
            }
            HMSLog.e("BaseAdapter", "jsonHeader null");
            b16.onError(BaseAdapter.this.b(-1));
        }

        private void a(final BaseCallBack baseCallBack, CoreBaseResponse coreBaseResponse) {
            if (Util.isAvailableLibExist(BaseAdapter.this.f36652i)) {
                Activity c16 = BaseAdapter.this.c();
                if (c16 != null && !c16.isFinishing()) {
                    HMSLog.i("BaseAdapter", "start handleSolutionForHMS");
                    AvailableAdapter availableAdapter = new AvailableAdapter(10000000);
                    availableAdapter.setCalledBySolutionInstallHms(true);
                    availableAdapter.startResolution(c16, new AvailableAdapter.AvailableCallBack() { // from class: com.huawei.hms.adapter.BaseAdapter.BaseRequestResultCallback.1
                        @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
                        public void onComplete(int i3) {
                            HMSLog.i("BaseAdapter", "complete handleSolutionForHMS, result: " + i3);
                            if (i3 == 0) {
                                HMSPackageManager.getInstance(BaseAdapter.this.f36652i).resetMultiServiceState();
                                BaseAdapter baseAdapter = BaseAdapter.this;
                                baseCallBack.onError(baseAdapter.a(11, baseAdapter.a(11)).toJson());
                                BaseAdapter.this.i();
                                return;
                            }
                            BaseAdapter baseAdapter2 = BaseAdapter.this;
                            baseCallBack.onError(baseAdapter2.a(i3, baseAdapter2.a(i3)).toJson());
                        }
                    });
                    return;
                }
                HMSLog.e("BaseAdapter", "activity is null");
                try {
                    if (BaseAdapter.this.f36652i != null && AvailableUtil.isInstallerLibExist(BaseAdapter.this.f36652i)) {
                        HMSLog.i("BaseAdapter", "pass installHMS intent");
                        Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(BaseAdapter.this.f36652i, UpdateAdapter.class.getName());
                        intentStartBridgeActivity.putExtra(CommonCode.MapKey.UPDATE_VERSION, 10000000);
                        intentStartBridgeActivity.putExtra("installHMS", "installHMS");
                        coreBaseResponse.setIntent(intentStartBridgeActivity);
                        BaseAdapter.this.a(baseCallBack, coreBaseResponse);
                    } else {
                        HMSLog.i("BaseAdapter", "pass ACTIVITY_NULL error");
                        BaseAdapter baseAdapter = BaseAdapter.this;
                        baseCallBack.onError(baseAdapter.a(-3, baseAdapter.a(-3)).toJson());
                    }
                    return;
                } catch (RuntimeException unused) {
                    HMSLog.e("BaseAdapter", "handleSolutionForHms pass result failed");
                    return;
                }
            }
            HMSLog.i("BaseAdapter", "handleSolutionForHms: no Available lib exist");
            baseCallBack.onError(BaseAdapter.this.b(-9));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a extends PendingResultImpl<ResolveResult<CoreBaseResponse>, CoreBaseResponse> {
        public a(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ResolveResult<CoreBaseResponse> onComplete(CoreBaseResponse coreBaseResponse) {
            ResolveResult<CoreBaseResponse> resolveResult = new ResolveResult<>(coreBaseResponse);
            resolveResult.setStatus(Status.SUCCESS);
            return resolveResult;
        }
    }

    public BaseAdapter(ApiClient apiClient) {
        this.f36644a = new WeakReference<>(apiClient);
        this.f36652i = apiClient.getContext().getApplicationContext();
        HMSLog.i("BaseAdapter", "In constructor, WeakReference is " + this.f36644a);
    }

    private void h() {
        if (this.f36647d != null && this.f36650g != null) {
            this.f36654k = null;
            this.f36654k = new ResponseHeader();
            baseRequest(d(), e(), f(), a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.f36652i == null) {
            HMSLog.e("BaseAdapter", "sendBroadcastAfterResolutionHms, context is null");
            return;
        }
        Intent intent = new Intent("com.huawei.hms.core.action.SESSION_INVALID");
        try {
            intent.setPackage(this.f36652i.getPackageName());
            this.f36652i.sendBroadcast(intent);
        } catch (IllegalArgumentException unused) {
            HMSLog.e("BaseAdapter", "IllegalArgumentException when sendBroadcastAfterResolutionHms intent.setPackage");
        }
    }

    public void baseRequest(String str, String str2, Parcelable parcelable, BaseCallBack baseCallBack) {
        a(str, str2, parcelable, baseCallBack);
        if (this.f36644a == null) {
            HMSLog.e("BaseAdapter", "client is null");
            baseCallBack.onError(b(-2));
            return;
        }
        this.f36646c = baseCallBack;
        JsonUtil.jsonToEntity(str, this.f36653j);
        CoreBaseRequest coreBaseRequest = new CoreBaseRequest();
        coreBaseRequest.setJsonObject(str2);
        coreBaseRequest.setJsonHeader(str);
        coreBaseRequest.setParcelable(parcelable);
        String apiName = this.f36653j.getApiName();
        if (TextUtils.isEmpty(apiName)) {
            HMSLog.e("BaseAdapter", "get uri null");
            baseCallBack.onError(b(-5));
            return;
        }
        String transactionId = this.f36653j.getTransactionId();
        this.f36651h = transactionId;
        if (TextUtils.isEmpty(transactionId)) {
            HMSLog.e("BaseAdapter", "get transactionId null");
            baseCallBack.onError(b(-6));
            return;
        }
        HMSLog.i("BaseAdapter", "in baseRequest + uri is :" + apiName + ", transactionId is : " + this.f36651h);
        a(this.f36652i, this.f36653j);
        a(this.f36644a.get(), apiName, coreBaseRequest).setResultCallback(new BaseRequestResultCallback());
    }

    private String d() {
        return this.f36647d;
    }

    private String e() {
        return this.f36648e;
    }

    private Parcelable f() {
        return this.f36649f;
    }

    private void g() {
        this.f36655l = new SystemObserver() { // from class: com.huawei.hms.adapter.BaseAdapter.2
            @Override // com.huawei.hms.adapter.sysobs.SystemObserver
            public boolean onNoticeResult(int i3) {
                return false;
            }

            @Override // com.huawei.hms.adapter.sysobs.SystemObserver
            public boolean onSolutionResult(Intent intent, String str) {
                if (TextUtils.isEmpty(str)) {
                    HMSLog.e("BaseAdapter", "onSolutionResult but id is null");
                    BaseCallBack b16 = BaseAdapter.this.b();
                    if (b16 == null) {
                        HMSLog.e("BaseAdapter", "onSolutionResult baseCallBack null");
                        return true;
                    }
                    b16.onError(BaseAdapter.this.b(-6));
                    return true;
                }
                if (str.equals(BaseAdapter.this.f36651h)) {
                    HMSLog.i("BaseAdapter", "onSolutionResult + id is :" + str);
                    BaseCallBack b17 = BaseAdapter.this.b();
                    if (b17 == null) {
                        HMSLog.e("BaseAdapter", "onResult baseCallBack null");
                        return true;
                    }
                    if (intent == null) {
                        HMSLog.e("BaseAdapter", "onSolutionResult but data is null");
                        String b18 = BaseAdapter.this.b(-7);
                        BaseAdapter baseAdapter = BaseAdapter.this;
                        baseAdapter.a(baseAdapter.f36652i, BaseAdapter.this.f36654k, 0L);
                        b17.onError(b18);
                        return true;
                    }
                    if (BaseAdapter.this.b(intent, b17) || BaseAdapter.this.a(intent, b17)) {
                        return true;
                    }
                    HMSLog.e("BaseAdapter", "onComplete for on activity result");
                    BaseAdapter.this.c(intent, b17);
                    return true;
                }
                return false;
            }

            @Override // com.huawei.hms.adapter.sysobs.SystemObserver
            public boolean onUpdateResult(int i3) {
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity c() {
        if (this.f36645b == null) {
            HMSLog.i("BaseAdapter", "activityWeakReference is " + this.f36645b);
            return null;
        }
        ApiClient apiClient = this.f36644a.get();
        if (apiClient == null) {
            HMSLog.i("BaseAdapter", "tmpApi is null");
            return null;
        }
        HMSLog.i("BaseAdapter", "activityWeakReference has " + this.f36645b.get());
        return Util.getActiveActivity(this.f36645b.get(), apiClient.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BaseCallBack b() {
        BaseCallBack baseCallBack = this.f36646c;
        if (baseCallBack != null) {
            return baseCallBack;
        }
        HMSLog.e("BaseAdapter", "callback null");
        return null;
    }

    private void b(Context context, RequestHeader requestHeader) {
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getInstance().getMapFromRequestHeader(requestHeader);
        mapFromRequestHeader.put("direction", "req");
        mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(requestHeader.getKitSdkVersion())));
        mapFromRequestHeader.put("phoneType", Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_START_RESOLUTION, mapFromRequestHeader);
    }

    public BaseAdapter(ApiClient apiClient, Activity activity) {
        this.f36644a = new WeakReference<>(apiClient);
        this.f36645b = new WeakReference<>(activity);
        this.f36652i = activity.getApplicationContext();
        HMSLog.i("BaseAdapter", "In constructor, activityWeakReference is " + this.f36645b + ", activity is " + this.f36645b.get());
    }

    private PendingResult<ResolveResult<CoreBaseResponse>> a(ApiClient apiClient, String str, CoreBaseRequest coreBaseRequest) {
        return new a(apiClient, str, coreBaseRequest);
    }

    private void c(int i3) {
        this.f36654k.setTransactionId(this.f36653j.getTransactionId());
        this.f36654k.setAppID(this.f36653j.getAppID());
        this.f36654k.setApiName(this.f36653j.getApiName());
        this.f36654k.setSrvName(this.f36653j.getSrvName());
        this.f36654k.setPkgName(this.f36653j.getPkgName());
        this.f36654k.setStatusCode(1);
        this.f36654k.setErrorCode(i3);
        this.f36654k.setErrorReason("Core error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BaseCallBack baseCallBack, CoreBaseResponse coreBaseResponse) {
        HMSLog.i("BaseAdapter", "baseCallBack.onComplete");
        PendingIntent pendingIntent = coreBaseResponse.getPendingIntent();
        if (pendingIntent != null) {
            baseCallBack.onComplete(coreBaseResponse.getJsonHeader(), coreBaseResponse.getJsonBody(), pendingIntent);
            return;
        }
        Intent modifyIntentBehaviorsSafe = IntentUtil.modifyIntentBehaviorsSafe(coreBaseResponse.getIntent());
        if (modifyIntentBehaviorsSafe != null) {
            baseCallBack.onComplete(coreBaseResponse.getJsonHeader(), coreBaseResponse.getJsonBody(), modifyIntentBehaviorsSafe);
        } else {
            baseCallBack.onComplete(coreBaseResponse.getJsonHeader(), coreBaseResponse.getJsonBody(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(int i3) {
        c(i3);
        return this.f36654k.toJson();
    }

    private void b(String str) {
        this.f36648e = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(Intent intent, BaseCallBack baseCallBack) {
        if (!intent.hasExtra(KpmsConstant.KIT_UPDATE_RESULT)) {
            return false;
        }
        int intExtra = intent.getIntExtra(KpmsConstant.KIT_UPDATE_RESULT, 0);
        HMSLog.i("BaseAdapter", "kit_update_result is " + intExtra);
        if (intExtra == 1) {
            HMSLog.e("BaseAdapter", "kit update success,replay request");
            h();
        } else {
            HMSLog.e("BaseAdapter", "kit update failed");
            baseCallBack.onError(a(-10, a(intExtra)).toJson());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, Parcelable parcelable, CoreBaseResponse coreBaseResponse) {
        HMSLog.i("BaseAdapter", "startResolution");
        RequestHeader requestHeader = this.f36653j;
        if (requestHeader != null) {
            b(this.f36652i, requestHeader);
        }
        if (this.f36655l == null) {
            g();
        }
        SystemManager.getSystemNotifier().registerObserver(this.f36655l);
        if (Build.VERSION.SDK_INT >= 29) {
            a(coreBaseResponse);
        }
        Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(activity, BaseResolutionAdapter.class.getName());
        Bundle bundle = new Bundle();
        bundle.putParcelable("resolution", parcelable);
        intentStartBridgeActivity.putExtras(bundle);
        intentStartBridgeActivity.putExtra(CommonCode.MapKey.TRANSACTION_ID, this.f36651h);
        long time = new Timestamp(System.currentTimeMillis()).getTime();
        intentStartBridgeActivity.putExtra(CommonCode.MapKey.RESOLUTION_FLAG, time);
        ResolutionFlagUtil.getInstance().saveResolutionFlag(this.f36651h, time);
        activity.startActivity(intentStartBridgeActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Intent intent, BaseCallBack baseCallBack) {
        long j3;
        String stringExtra = intent.getStringExtra(CommonCode.MapKey.JSON_HEADER);
        String stringExtra2 = intent.getStringExtra(CommonCode.MapKey.JSON_BODY);
        Object infoFromJsonobject = JsonUtil.getInfoFromJsonobject(stringExtra, "status_code");
        Object infoFromJsonobject2 = JsonUtil.getInfoFromJsonobject(stringExtra, "error_code");
        if (intent.hasExtra(CommonCode.MapKey.HMS_FOREGROUND_RES_UI)) {
            Object infoFromJsonobject3 = JsonUtil.getInfoFromJsonobject(intent.getStringExtra(CommonCode.MapKey.HMS_FOREGROUND_RES_UI), "uiDuration");
            if (infoFromJsonobject3 instanceof Long) {
                j3 = ((Long) infoFromJsonobject3).longValue();
                if (!(infoFromJsonobject instanceof Integer) && (infoFromJsonobject2 instanceof Integer)) {
                    int intValue = ((Integer) infoFromJsonobject).intValue();
                    b(((Integer) infoFromJsonobject2).intValue());
                    this.f36654k.setStatusCode(intValue);
                    a(this.f36652i, this.f36654k, j3);
                } else {
                    b(-8);
                    a(this.f36652i, this.f36654k, j3);
                }
                baseCallBack.onComplete(stringExtra, stringExtra2, null);
            }
        }
        j3 = 0;
        if (!(infoFromJsonobject instanceof Integer)) {
        }
        b(-8);
        a(this.f36652i, this.f36654k, j3);
        baseCallBack.onComplete(stringExtra, stringExtra2, null);
    }

    private void a(final CoreBaseResponse coreBaseResponse) {
        HMSLog.i("BaseAdapter", "postResolutionTimeoutHandle");
        ApkResolutionFailedManager.getInstance().postTask(this.f36651h, new Runnable() { // from class: com.huawei.hms.adapter.BaseAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                HMSLog.i("BaseAdapter", "postResolutionTimeoutHandle handle");
                SystemManager.getSystemNotifier().unRegisterObserver(BaseAdapter.this.f36655l);
                ApkResolutionFailedManager.getInstance().removeValueOnly(BaseAdapter.this.f36651h);
                BaseCallBack b16 = BaseAdapter.this.b();
                if (b16 != null) {
                    BaseAdapter.this.a(b16, coreBaseResponse);
                } else {
                    HMSLog.e("BaseAdapter", "timeoutRunnable callBack is null");
                }
            }
        });
    }

    private void a(Context context, RequestHeader requestHeader) {
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getInstance().getMapFromRequestHeader(requestHeader);
        mapFromRequestHeader.put("direction", "req");
        mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(requestHeader.getKitSdkVersion())));
        mapFromRequestHeader.put("phoneType", Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_CALL_AIDL, mapFromRequestHeader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, ResponseHeader responseHeader) {
        HiAnalyticsUtil.getInstance();
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getMapFromRequestHeader(responseHeader);
        mapFromRequestHeader.put("direction", "rsp");
        mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.f36653j.getKitSdkVersion())));
        mapFromRequestHeader.put("phoneType", Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_CALL_AIDL, mapFromRequestHeader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, ResponseHeader responseHeader, long j3) {
        HiAnalyticsUtil.getInstance();
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getMapFromRequestHeader(responseHeader);
        mapFromRequestHeader.put("direction", "rsp");
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME, String.valueOf(j3));
        mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.f36653j.getKitSdkVersion())));
        mapFromRequestHeader.put("phoneType", Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_START_RESOLUTION, mapFromRequestHeader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ResponseWrap a(int i3, String str) {
        c(i3);
        ResponseWrap responseWrap = new ResponseWrap(this.f36654k);
        responseWrap.setBody(str);
        return responseWrap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(int i3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errorCode", i3);
        } catch (JSONException e16) {
            HMSLog.e("BaseAdapter", "buildBodyStr failed: " + e16.getMessage());
        }
        return jSONObject.toString();
    }

    private void a(String str) {
        this.f36647d = str;
    }

    private void a(Parcelable parcelable) {
        this.f36649f = parcelable;
    }

    private BaseCallBack a() {
        return this.f36650g;
    }

    private void a(BaseCallBack baseCallBack) {
        this.f36650g = baseCallBack;
    }

    private void a(String str, String str2, Parcelable parcelable, BaseCallBack baseCallBack) {
        a(str);
        b(str2);
        a(parcelable);
        a(baseCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Intent intent, BaseCallBack baseCallBack) {
        if (!intent.hasExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT)) {
            return false;
        }
        int intExtra = intent.getIntExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT, 1001);
        if (intExtra == 1001) {
            HMSLog.i("BaseAdapter", "privacy_statement_confirm_result agreed: " + intExtra + ", replay request");
            h();
            return true;
        }
        HMSLog.i("BaseAdapter", "privacy_statement_confirm_result rejected: " + intExtra);
        baseCallBack.onError(a(CommonCode.BusInterceptor.PRIVACY_CNCEL_ERROR_CODE, a(CommonCode.BusInterceptor.PRIVACY_CNCEL_ERROR_CODE)).toJson());
        return true;
    }
}
