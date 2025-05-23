package com.huawei.hms.adapter.ui;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.sysobs.ApkResolutionFailedManager;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.kpms.KpmsConstant;
import com.huawei.hms.utils.IntentUtil;
import com.huawei.hms.utils.ResolutionFlagUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes2.dex */
public class BaseResolutionAdapter implements IBridgeActivityDelegate {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<Activity> f36687a;

    /* renamed from: b, reason: collision with root package name */
    private String f36688b = "";

    /* renamed from: c, reason: collision with root package name */
    private long f36689c = 0;

    private void a(long j3) {
        if (!SystemUtils.isChinaROM()) {
            HMSLog.i("BaseResolutionAdapter", "not ChinaROM");
            return;
        }
        Activity c16 = c();
        if (c16 == null || c16.isFinishing()) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("package", c16.getPackageName());
        hashMap.put(CommonCode.MapKey.RESOLUTION_FLAG, this.f36689c + "-" + j3);
        HiAnalyticsUtils.getInstance().onEvent(c16, HiAnalyticsConstant.HMS_SDK_BASE_START_RESOLUTION, hashMap);
        HMSLog.e("BaseResolutionAdapter", "check resolution flag failed, transactionId: " + this.f36688b + ", carriedTimeStamp: " + this.f36689c + ", savedTimeStamp: " + j3);
    }

    private void b() {
        Activity c16 = c();
        if (c16 != null && !c16.isFinishing()) {
            c16.finish();
        }
    }

    private Activity c() {
        WeakReference<Activity> weakReference = this.f36687a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private void d() {
        SystemManager.getInstance().notifyResolutionResult(null, this.f36688b);
        b();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 1001;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0058  */
    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBridgeActivityCreate(Activity activity) {
        Bundle bundle;
        this.f36687a = new WeakReference<>(activity);
        Intent intent = activity.getIntent();
        if (intent == null) {
            d();
            return;
        }
        try {
            bundle = intent.getExtras();
        } catch (Throwable th5) {
            th = th5;
            bundle = null;
        }
        try {
            this.f36688b = intent.getStringExtra(CommonCode.MapKey.TRANSACTION_ID);
            this.f36689c = intent.getLongExtra(CommonCode.MapKey.RESOLUTION_FLAG, 0L);
        } catch (Throwable th6) {
            th = th6;
            HMSLog.e("BaseResolutionAdapter", "get transaction_id or resolution_flag exception:" + th.getClass().getSimpleName());
            if (a()) {
            }
        }
        if (a()) {
            d();
            return;
        }
        if (this.f36688b != null && Build.VERSION.SDK_INT >= 29) {
            HMSLog.i("BaseResolutionAdapter", "remove apk resolution failed task.");
            ApkResolutionFailedManager.getInstance().removeTask(this.f36688b);
        }
        if (bundle == null) {
            d();
            return;
        }
        Parcelable parcelable = bundle.getParcelable("resolution");
        if (parcelable == null) {
            d();
            return;
        }
        if (parcelable instanceof Intent) {
            try {
                activity.startActivityForResult(IntentUtil.modifyIntentBehaviorsSafe((Intent) parcelable), 1001);
                return;
            } catch (Throwable unused) {
                d();
                HMSLog.e("BaseResolutionAdapter", "ActivityNotFoundException:exception");
                return;
            }
        }
        if (parcelable instanceof PendingIntent) {
            try {
                activity.startIntentSenderForResult(((PendingIntent) parcelable).getIntentSender(), 1001, null, 0, 0, 0);
            } catch (IntentSender.SendIntentException unused2) {
                d();
                HMSLog.e("BaseResolutionAdapter", "SendIntentException:exception");
            }
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        HMSLog.i("BaseResolutionAdapter", "onBridgeActivityDestroy");
        this.f36687a = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i3, int i16, Intent intent) {
        if (i3 != getRequestCode()) {
            return false;
        }
        HMSLog.i("BaseResolutionAdapter", "onBridgeActivityResult, resultCode: " + i16);
        if (i16 == 1001 || i16 == 1002) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.putExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT, i16);
        }
        if (i16 != -1 && !intent.hasExtra(KpmsConstant.KIT_UPDATE_RESULT) && !intent.hasExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT)) {
            SystemManager.getInstance().notifyResolutionResult(null, this.f36688b);
        } else {
            SystemManager.getInstance().notifyResolutionResult(intent, this.f36688b);
        }
        b();
        return true;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        HMSLog.i("BaseResolutionAdapter", "onBridgeConfigurationChanged");
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i3, KeyEvent keyEvent) {
        HMSLog.i("BaseResolutionAdapter", "On key up when resolve conn error");
    }

    private boolean a() {
        long resolutionFlag = ResolutionFlagUtil.getInstance().getResolutionFlag(this.f36688b);
        ResolutionFlagUtil.getInstance().removeResolutionFlag(this.f36688b);
        if (resolutionFlag != 0 && resolutionFlag == this.f36689c) {
            return true;
        }
        a(resolutionFlag);
        return false;
    }
}
