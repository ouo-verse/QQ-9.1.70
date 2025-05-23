package com.huawei.hms.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.ForegroundBusResponseMgr;
import com.huawei.hms.activity.internal.ForegroundInnerHeader;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.support.api.entity.core.CoreNaming;
import com.huawei.hms.utils.Util;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ForegroundIntentBuilder {

    /* renamed from: a, reason: collision with root package name */
    private Activity f36623a;

    /* renamed from: b, reason: collision with root package name */
    private RequestHeader f36624b;

    /* renamed from: c, reason: collision with root package name */
    private String f36625c;

    /* renamed from: d, reason: collision with root package name */
    private ForegroundInnerHeader f36626d;

    /* renamed from: e, reason: collision with root package name */
    private String f36627e;

    /* renamed from: f, reason: collision with root package name */
    private Context f36628f;

    public ForegroundIntentBuilder(Activity activity) throws IllegalArgumentException {
        if (activity != null) {
            this.f36623a = activity;
            RequestHeader requestHeader = new RequestHeader();
            this.f36624b = requestHeader;
            requestHeader.setSdkVersion(60900300);
            this.f36625c = "";
            ForegroundInnerHeader foregroundInnerHeader = new ForegroundInnerHeader();
            this.f36626d = foregroundInnerHeader;
            foregroundInnerHeader.setApkVersion(30000000);
            return;
        }
        throw new IllegalArgumentException("listener must not be null.");
    }

    public static void registerResponseCallback(String str, BusResponseCallback busResponseCallback) {
        ForegroundBusResponseMgr.getInstance().registerObserver(str, busResponseCallback);
    }

    public static void unregisterResponseCallback(String str) {
        ForegroundBusResponseMgr.getInstance().unRegisterObserver(str);
    }

    public Intent build() {
        String packageName;
        String appId;
        Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(this.f36623a, ForegroundBusDelegate.class.getName());
        Context context = this.f36628f;
        if (context != null) {
            packageName = context.getPackageName();
            appId = Util.getAppId(this.f36628f);
        } else {
            packageName = this.f36623a.getPackageName();
            appId = Util.getAppId(this.f36623a);
        }
        if (this.f36624b.getAppID() == null) {
            this.f36624b.setAppID(appId + "|");
        } else {
            this.f36624b.setAppID(appId + "|" + this.f36624b.getAppID());
        }
        if (TextUtils.isEmpty(this.f36624b.getTransactionId())) {
            RequestHeader requestHeader = this.f36624b;
            requestHeader.setTransactionId(TransactionIdCreater.getId(requestHeader.getAppID(), CoreNaming.HUBREQUEST));
        }
        this.f36624b.setPkgName(packageName);
        intentStartBridgeActivity.putExtra(ForegroundBusDelegate.HMS_FOREGROUND_REQ_HEADER, this.f36624b.toJson());
        intentStartBridgeActivity.putExtra(ForegroundBusDelegate.HMS_FOREGROUND_REQ_BODY, this.f36625c);
        intentStartBridgeActivity.putExtra(ForegroundBusDelegate.HMS_FOREGROUND_REQ_INNER, this.f36626d.toJson());
        if (!TextUtils.isEmpty(this.f36627e)) {
            intentStartBridgeActivity.putExtra(ForegroundBusDelegate.INNER_PKG_NAME, this.f36627e);
        }
        return intentStartBridgeActivity;
    }

    public ForegroundIntentBuilder setAction(String str) {
        this.f36624b.setApiName(str);
        return this;
    }

    public ForegroundIntentBuilder setApiLevel(int i3) {
        this.f36624b.setApiLevel(i3);
        return this;
    }

    public ForegroundIntentBuilder setApplicationContext(Context context) {
        this.f36628f = context;
        return this;
    }

    public ForegroundIntentBuilder setInnerHms() {
        this.f36627e = this.f36623a.getPackageName();
        return this;
    }

    public ForegroundIntentBuilder setKitSdkVersion(int i3) {
        this.f36624b.setKitSdkVersion(i3);
        return this;
    }

    public ForegroundIntentBuilder setMinApkVersion(int i3) {
        this.f36626d.setApkVersion(i3);
        return this;
    }

    public ForegroundIntentBuilder setRequestBody(String str) {
        this.f36625c = str;
        return this;
    }

    public ForegroundIntentBuilder setResponseCallback(String str, BusResponseCallback busResponseCallback) {
        this.f36626d.setResponseCallbackKey(str);
        ForegroundBusResponseMgr.getInstance().registerObserver(str, busResponseCallback);
        return this;
    }

    public ForegroundIntentBuilder setServiceName(String str) {
        this.f36624b.setSrvName(str);
        return this;
    }

    public ForegroundIntentBuilder setSubAppId(String str) {
        this.f36624b.setAppID(str);
        return this;
    }

    public ForegroundIntentBuilder setTransactionId(String str) {
        this.f36624b.setTransactionId(str);
        return this;
    }

    public ForegroundIntentBuilder setResponseCallback(String str) {
        this.f36626d.setResponseCallbackKey(str);
        return this;
    }
}
