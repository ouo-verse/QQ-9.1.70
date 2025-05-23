package com.huawei.hms.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.adapter.sysobs.SystemObserver;
import com.huawei.hms.adapter.ui.NotInstalledHmsAdapter;
import com.huawei.hms.adapter.ui.UpdateAdapter;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.note.AppSpoofResolution;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSBIInitializer;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.UIUtil;

/* compiled from: P */
/* loaded from: classes2.dex */
public class AvailableAdapter {

    /* renamed from: a, reason: collision with root package name */
    private final int f36636a;

    /* renamed from: b, reason: collision with root package name */
    private AvailableCallBack f36637b;

    /* renamed from: d, reason: collision with root package name */
    private SystemObserver f36639d = new a();

    /* renamed from: c, reason: collision with root package name */
    private boolean f36638c = false;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface AvailableCallBack {
        void onComplete(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements SystemObserver {
        a() {
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemObserver
        public boolean onNoticeResult(int i3) {
            AvailableCallBack a16 = AvailableAdapter.this.a();
            if (a16 == null) {
                HMSLog.e("AvailableAdapter", "onNoticeResult baseCallBack null");
                return true;
            }
            a16.onComplete(i3);
            return true;
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemObserver
        public boolean onSolutionResult(Intent intent, String str) {
            return false;
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemObserver
        public boolean onUpdateResult(int i3) {
            AvailableCallBack a16 = AvailableAdapter.this.a();
            if (a16 == null) {
                HMSLog.e("AvailableAdapter", "onUpdateResult baseCallBack null");
                return true;
            }
            a16.onComplete(i3);
            return true;
        }
    }

    public AvailableAdapter(int i3) {
        this.f36636a = i3;
    }

    private void b(Context context) {
        HMSBIInitializer.getInstance(context).initBI();
    }

    public int checkHuaweiMobileServicesForUpdate(Context context) {
        Checker.checkNonNull(context, "context must not be null.");
        int a16 = a(context);
        if (a16 != 0) {
            return a16;
        }
        if (HMSPackageManager.getInstance(context).isApkNeedUpdate(this.f36636a)) {
            HMSLog.i("AvailableAdapter", "The current version does not meet the target version requirements");
            return 2;
        }
        return a16;
    }

    public int isHuaweiMobileServicesAvailable(Context context) {
        Checker.checkNonNull(context, "context must not be null.");
        int a16 = a(context);
        if (a16 != 0) {
            return a16;
        }
        if (HMSPackageManager.getInstance(context).isApkUpdateNecessary(this.f36636a)) {
            HMSLog.i("AvailableAdapter", "The current version does not meet the minimum version requirements");
            return 2;
        }
        return a16;
    }

    public boolean isUserNoticeError(int i3) {
        if (i3 != 29) {
            return false;
        }
        return true;
    }

    public boolean isUserResolvableError(int i3) {
        if (i3 == 1 || i3 == 2) {
            return true;
        }
        return false;
    }

    public void setCalledBySolutionInstallHms(boolean z16) {
        this.f36638c = z16;
    }

    public void startNotice(Activity activity, AvailableCallBack availableCallBack) {
        if (activity != null && availableCallBack != null) {
            if (UIUtil.isBackground(activity)) {
                HMSLog.i("AvailableAdapter", "current app is in Background");
                availableCallBack.onComplete(28);
            } else {
                HMSLog.i("AvailableAdapter", "startNotice");
                this.f36637b = availableCallBack;
                SystemManager.getSystemNotifier().registerObserver(this.f36639d);
                activity.startActivity(BridgeActivity.getIntentStartBridgeActivity(activity, AppSpoofResolution.class.getName()));
            }
        }
    }

    public void startResolution(Activity activity, AvailableCallBack availableCallBack) {
        if (activity != null && availableCallBack != null) {
            b(activity);
            if (UIUtil.isBackground(activity)) {
                HMSLog.i("AvailableAdapter", "current app is in Background");
                availableCallBack.onComplete(28);
                return;
            }
            boolean a16 = a(activity);
            if (!AvailableUtil.isInstallerLibExist(activity) && !a16) {
                a(activity, availableCallBack);
                return;
            }
            HMSLog.i("AvailableAdapter", "startResolution");
            this.f36637b = availableCallBack;
            SystemManager.getSystemNotifier().registerObserver(this.f36639d);
            Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(activity, UpdateAdapter.class.getName());
            intentStartBridgeActivity.putExtra(CommonCode.MapKey.UPDATE_VERSION, this.f36636a);
            if (this.f36638c) {
                intentStartBridgeActivity.putExtra("installHMS", "installHMS");
            }
            intentStartBridgeActivity.putExtra(CommonCode.MapKey.NEW_UPDATE, a16);
            activity.startActivity(intentStartBridgeActivity);
        }
    }

    private int a(Context context) {
        if (HMSPackageManager.getInstance(context).isUseOldCertificate()) {
            HMSLog.e("AvailableAdapter", "The CP uses the old certificate to terminate the connection.");
            return 13;
        }
        PackageManagerHelper.PackageStates hMSPackageStatesForMultiService = HMSPackageManager.getInstance(context).getHMSPackageStatesForMultiService();
        if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(hMSPackageStatesForMultiService)) {
            HMSLog.i("AvailableAdapter", "HMS is not installed");
            return 1;
        }
        if (PackageManagerHelper.PackageStates.SPOOF.equals(hMSPackageStatesForMultiService)) {
            HMSLog.i("AvailableAdapter", "HMS is spoofed");
            return 29;
        }
        if (!PackageManagerHelper.PackageStates.DISABLED.equals(hMSPackageStatesForMultiService)) {
            return 0;
        }
        HMSLog.i("AvailableAdapter", "HMS is disabled");
        return 3;
    }

    private void a(Activity activity, AvailableCallBack availableCallBack) {
        HMSLog.i("AvailableAdapter", "<showHmsApkNotInstalledDialog> startResolution");
        if (NotInstalledHmsAdapter.getShowLock()) {
            this.f36637b = availableCallBack;
            SystemManager.getSystemNotifier().registerObserver(this.f36639d);
            activity.startActivity(BridgeActivity.getIntentStartBridgeActivity(activity, NotInstalledHmsAdapter.class.getName()));
            return;
        }
        availableCallBack.onComplete(31);
    }

    private boolean a(Activity activity) {
        if (HMSPackageManager.getInstance(activity).getHmsVersionCode() < 40000000) {
            return false;
        }
        HMSLog.i("AvailableAdapter", "enter 4.0 HmsCore upgrade process");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AvailableCallBack a() {
        return this.f36637b;
    }
}
