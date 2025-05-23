package com.huawei.hms.activity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.BusResponseResult;
import com.huawei.hms.activity.internal.ForegroundBusResponseMgr;
import com.huawei.hms.activity.internal.ForegroundInnerHeader;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.IntentUtil;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.UIUtil;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ForegroundBusDelegate implements IBridgeActivityDelegate {
    public static final String HMS_FOREGROUND_REQ_BODY = "HMS_FOREGROUND_REQ_BODY";
    public static final String HMS_FOREGROUND_REQ_HEADER = "HMS_FOREGROUND_REQ_HEADER";
    public static final String HMS_FOREGROUND_REQ_INNER = "HMS_FOREGROUND_REQ_INNER";
    public static final String HMS_FOREGROUND_RESP_HEADER = "HMS_FOREGROUND_RESP_HEADER";
    public static final String INNER_PKG_NAME = "INNER_PACKAGE_NAME";

    /* renamed from: a, reason: collision with root package name */
    private RequestHeader f36616a;

    /* renamed from: b, reason: collision with root package name */
    private String f36617b;

    /* renamed from: c, reason: collision with root package name */
    private ForegroundInnerHeader f36618c = new ForegroundInnerHeader();

    /* renamed from: d, reason: collision with root package name */
    private ResponseHeader f36619d;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<Activity> f36620e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f36621f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b implements AvailableAdapter.AvailableCallBack {
        b() {
        }

        @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
        public void onComplete(int i3) {
            if (i3 == 0) {
                ForegroundBusDelegate.this.h();
            } else {
                HMSLog.i("ForegroundBusDelegate", "version check failed");
                ForegroundBusDelegate.this.a(0, "apk version is invalid");
            }
        }
    }

    private BusResponseCallback b(String str) {
        return ForegroundBusResponseMgr.getInstance().get(str);
    }

    private void c() {
        if (this.f36616a != null) {
            a(HiAnalyticsConstant.HMS_SDK_BASE_ACTIVITY_STARTED);
        }
    }

    private void d() {
        a(HiAnalyticsConstant.HMS_SDK_BASE_START_CORE_ACTIVITY);
    }

    private void e() {
        if (g() == null) {
            HMSLog.e("ForegroundBusDelegate", "checkMinVersion failed, activity must not be null.");
            return;
        }
        if (this.f36621f) {
            h();
            return;
        }
        if (!Util.isAvailableLibExist(g().getApplicationContext())) {
            if (HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(g().getApplicationContext(), this.f36618c.getApkVersion()) != 0) {
                HMSLog.e("ForegroundBusDelegate", "checkMinVersion failed, and no available lib exists.");
                a(0, "apk version is invalid");
                return;
            } else {
                h();
                return;
            }
        }
        b bVar = new b();
        AvailableAdapter availableAdapter = new AvailableAdapter(this.f36618c.getApkVersion());
        int isHuaweiMobileServicesAvailable = availableAdapter.isHuaweiMobileServicesAvailable(g());
        if (isHuaweiMobileServicesAvailable == 0) {
            bVar.onComplete(isHuaweiMobileServicesAvailable);
        } else if (availableAdapter.isUserResolvableError(isHuaweiMobileServicesAvailable)) {
            a(g(), availableAdapter, bVar);
        } else {
            bVar.onComplete(isHuaweiMobileServicesAvailable);
        }
    }

    private void f() {
        Activity g16 = g();
        if (g16 != null && !g16.isFinishing()) {
            g16.finish();
        }
    }

    private Activity g() {
        WeakReference<Activity> weakReference = this.f36620e;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        String hMSPackageNameForMultiService;
        HMSLog.i("ForegroundBusDelegate", "startApkHubActivity");
        Activity g16 = g();
        if (g16 == null) {
            HMSLog.e("ForegroundBusDelegate", "startApkHubActivity but activity is null");
            return;
        }
        if (this.f36621f) {
            hMSPackageNameForMultiService = g16.getPackageName();
        } else {
            hMSPackageNameForMultiService = HMSPackageManager.getInstance(g16.getApplicationContext()).getHMSPackageNameForMultiService();
        }
        Intent intent = new Intent(this.f36618c.getAction());
        intent.putExtra(HMS_FOREGROUND_REQ_BODY, this.f36617b);
        try {
            intent.setPackage(hMSPackageNameForMultiService);
        } catch (IllegalArgumentException unused) {
            HMSLog.e("ForegroundBusDelegate", "IllegalArgumentException when startApkHubActivity intent.setPackage");
        }
        intent.putExtra("intent.extra.isfullscreen", UIUtil.isActivityFullscreen(g16));
        intent.setClassName(hMSPackageNameForMultiService, "com.huawei.hms.core.activity.UiJumpActivity");
        intent.putExtra(HMS_FOREGROUND_REQ_HEADER, this.f36616a.toJson());
        intent.putExtra("intent.extra.hms.core.DELEGATE_NAME", "com.huawei.hms.core.activity.ForegroundBus");
        try {
            b();
            g16.startActivityForResult(intent, 431057);
        } catch (ActivityNotFoundException e16) {
            HMSLog.e("ForegroundBusDelegate", "Launch sign in Intent failed. hms is probably being updated\uff1a", e16);
            a(0, "launch bus intent failed");
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 431057;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        String stringExtra;
        RequestHeader requestHeader;
        this.f36620e = new WeakReference<>(activity);
        Intent intent = activity.getIntent();
        try {
            stringExtra = intent.getStringExtra(HMS_FOREGROUND_REQ_HEADER);
            requestHeader = new RequestHeader();
            this.f36616a = requestHeader;
        } catch (Exception e16) {
            HMSLog.e("ForegroundBusDelegate", "ForegroundBusDelegate getStringExtra error:" + e16.getMessage());
        }
        if (!requestHeader.fromJson(stringExtra)) {
            a(0, "header is invalid");
            return;
        }
        this.f36617b = intent.getStringExtra(HMS_FOREGROUND_REQ_BODY);
        ForegroundInnerHeader foregroundInnerHeader = this.f36618c;
        if (foregroundInnerHeader == null) {
            a(0, "inner header is invalid");
            return;
        }
        foregroundInnerHeader.fromJson(intent.getStringExtra(HMS_FOREGROUND_REQ_INNER));
        if (TextUtils.isEmpty(this.f36616a.getApiName())) {
            a(0, "action is invalid");
            return;
        }
        a();
        if (!TextUtils.isEmpty(intent.getStringExtra(INNER_PKG_NAME))) {
            HMSLog.i("ForegroundBusDelegate", "isUseInnerHms: true");
            this.f36621f = true;
        }
        e();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        c();
        this.f36620e = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i3, int i16, Intent intent) {
        if (i3 == 431057) {
            if (intent != null && intent.hasExtra(HMS_FOREGROUND_RESP_HEADER)) {
                String stringExtra = intent.getStringExtra(HMS_FOREGROUND_RESP_HEADER);
                ResponseHeader responseHeader = new ResponseHeader();
                this.f36619d = responseHeader;
                JsonUtil.jsonToEntity(stringExtra, responseHeader);
            }
            d();
            BusResponseCallback b16 = b(this.f36618c.getResponseCallbackKey());
            if (b16 == null) {
                a(i16, intent);
                return true;
            }
            BusResponseResult succeedReturn = b16.succeedReturn(this.f36620e.get(), i16, intent);
            if (succeedReturn == null) {
                a(i16, intent);
                return true;
            }
            a(succeedReturn.getCode(), succeedReturn.getIntent());
            return true;
        }
        return false;
    }

    private void b() {
        Map<String, String> mapFromForegroundRequestHeader = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.f36616a);
        mapFromForegroundRequestHeader.put("direction", "req");
        mapFromForegroundRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.f36616a.getKitSdkVersion())));
        if (g() != null) {
            HiAnalyticsUtil.getInstance().onNewEvent(g().getApplicationContext(), HiAnalyticsConstant.HMS_SDK_BASE_START_CORE_ACTIVITY, mapFromForegroundRequestHeader);
        }
    }

    private void a(int i3, Intent intent) {
        HMSLog.i("ForegroundBusDelegate", "succeedReturn");
        Activity g16 = g();
        if (g16 == null) {
            return;
        }
        g16.setResult(i3, IntentUtil.modifyIntentBehaviorsSafe(intent));
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i3, String str) {
        HMSLog.e("ForegroundBusDelegate", str);
        Activity g16 = g();
        if (g16 == null) {
            return;
        }
        BusResponseCallback b16 = b(this.f36618c.getResponseCallbackKey());
        if (b16 != null) {
            BusResponseResult innerError = b16.innerError(this.f36620e.get(), i3, str);
            if (innerError == null) {
                g16.setResult(0);
            } else {
                g16.setResult(innerError.getCode(), IntentUtil.modifyIntentBehaviorsSafe(innerError.getIntent()));
            }
        } else {
            g16.setResult(0);
        }
        f();
    }

    private static void a(Activity activity, AvailableAdapter availableAdapter, AvailableAdapter.AvailableCallBack availableCallBack) {
        if (activity == null) {
            HMSLog.i("ForegroundBusDelegate", "null activity, could not start resolution intent");
        }
        availableAdapter.startResolution(activity, availableCallBack);
    }

    private void a() {
        Map<String, String> mapFromForegroundRequestHeader = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.f36616a);
        mapFromForegroundRequestHeader.put("direction", "req");
        mapFromForegroundRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.f36616a.getKitSdkVersion())));
        if (g() != null) {
            HiAnalyticsUtil.getInstance().onNewEvent(g().getApplicationContext(), HiAnalyticsConstant.HMS_SDK_BASE_ACTIVITY_STARTED, mapFromForegroundRequestHeader);
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
    }

    private void a(String str) {
        Map<String, String> mapFromForegroundRequestHeader = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.f36616a);
        mapFromForegroundRequestHeader.put("direction", "rsp");
        mapFromForegroundRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.f36616a.getKitSdkVersion())));
        ResponseHeader responseHeader = this.f36619d;
        if (responseHeader != null) {
            mapFromForegroundRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, String.valueOf(responseHeader.getStatusCode()));
            mapFromForegroundRequestHeader.put("result", String.valueOf(this.f36619d.getErrorCode()));
        }
        if (g() != null) {
            HiAnalyticsUtil.getInstance().onNewEvent(g().getApplicationContext(), str, mapFromForegroundRequestHeader);
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i3, KeyEvent keyEvent) {
    }
}
