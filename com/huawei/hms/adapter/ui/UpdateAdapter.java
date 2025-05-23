package com.huawei.hms.adapter.ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.AvailableUtil;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.availableupdate.c;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.kpms.KpmsConstant;
import com.huawei.hms.update.ui.UpdateBean;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class UpdateAdapter implements IBridgeActivityDelegate {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<Activity> f36696a;

    /* renamed from: b, reason: collision with root package name */
    private Context f36697b;

    /* renamed from: c, reason: collision with root package name */
    private int f36698c;

    /* renamed from: d, reason: collision with root package name */
    private UpdateBean f36699d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f36700e = false;

    private boolean a(Intent intent, Activity activity) {
        if (!intent.getBooleanExtra(CommonCode.MapKey.NEW_UPDATE, false)) {
            return false;
        }
        HMSLog.i("UpdateAdapter", "4.0 framework HMSCore upgrade process");
        String hMSPackageName = HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageName();
        ComponentName componentName = new ComponentName(hMSPackageName, "com.huawei.hms.fwksdk.stub.UpdateStubActivity");
        Intent intent2 = new Intent();
        intent2.putExtra(KpmsConstant.CALLER_PACKAGE_NAME, activity.getApplicationContext().getPackageName());
        intent2.putExtra(KpmsConstant.UPDATE_PACKAGE_NAME, hMSPackageName);
        intent2.setComponent(componentName);
        activity.startActivityForResult(intent2, 1001);
        return true;
    }

    private Activity b() {
        WeakReference<Activity> weakReference = this.f36696a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private void c() {
        SystemManager.getInstance().notifyUpdateResult(8);
        a();
    }

    public static Object invokeMethod(String str, String str2, Object[] objArr) {
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i3 = 0; i3 < objArr.length; i3++) {
            Object obj = objArr[i3];
            if (obj instanceof Activity) {
                clsArr[i3] = Activity.class;
            } else if (obj instanceof Context) {
                clsArr[i3] = Context.class;
            } else if (obj instanceof UpdateBean) {
                clsArr[i3] = UpdateBean.class;
            } else if (obj instanceof Integer) {
                clsArr[i3] = Integer.TYPE;
            } else if (obj instanceof Boolean) {
                clsArr[i3] = Boolean.TYPE;
            } else {
                HMSLog.e("UpdateAdapter", "not set args[" + i3 + "] type");
            }
        }
        try {
            Class<?> cls = Class.forName(str);
            return cls.getMethod(str2, clsArr).invoke(cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), objArr);
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | InvocationTargetException e16) {
            HMSLog.e("UpdateAdapter", "invoke " + str + "." + str2 + " fail. " + e16.getMessage());
            return null;
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 1001;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        if (activity == null) {
            HMSLog.i("UpdateAdapter", "activity == null");
            c();
            return;
        }
        this.f36697b = activity.getApplicationContext();
        this.f36696a = new WeakReference<>(activity);
        if (!c.f36762b.a(b())) {
            return;
        }
        Intent intent = activity.getIntent();
        if (intent == null) {
            c();
            return;
        }
        try {
            this.f36698c = intent.getIntExtra(CommonCode.MapKey.UPDATE_VERSION, 0);
        } catch (Exception e16) {
            HMSLog.e("UpdateAdapter", "get update_version:" + e16.getMessage());
        }
        if (this.f36698c == 0) {
            c();
            return;
        }
        if (intent.hasExtra("installHMS")) {
            this.f36700e = true;
        }
        if (!a(intent, activity) && AvailableUtil.isInstallerLibExist(this.f36697b)) {
            UpdateBean updateBean = (UpdateBean) invokeMethod("com.huawei.hms.adapter.ui.InstallerAdapter", "setUpdateBean", new Object[]{activity, Integer.valueOf(this.f36698c), Boolean.valueOf(this.f36700e)});
            this.f36699d = updateBean;
            invokeMethod("com.huawei.hms.adapter.ui.InstallerAdapter", "startUpdateHms", new Object[]{activity, updateBean, 1001});
            this.f36699d = null;
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        HMSLog.i("UpdateAdapter", "onBridgeActivityDestroy");
        c.f36762b.b(b());
        this.f36696a = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i3, int i16, Intent intent) {
        if (i3 != getRequestCode()) {
            this.f36699d = null;
            return false;
        }
        HMSLog.i("UpdateAdapter", "onBridgeActivityResult " + i16);
        if (AvailableUtil.isInstallerLibExist(this.f36697b) && i16 == 1214) {
            HMSLog.i("UpdateAdapter", "Enter update escape route");
            Activity b16 = b();
            if (b16 == null) {
                HMSLog.e("UpdateAdapter", "bridgeActivity is null, update escape failed ");
                this.f36699d = null;
                return true;
            }
            invokeMethod("com.huawei.hms.update.manager.UpdateManager", "startUpdate", new Object[]{b16, 1001, this.f36699d});
            this.f36699d = null;
        }
        if (i16 == -1) {
            if (intent != null) {
                if (intent.getIntExtra(KpmsConstant.KIT_UPDATE_RESULT, 0) == 1) {
                    HMSLog.i("UpdateAdapter", "new framework update process,Error resolved successfully!");
                    SystemManager.getInstance().notifyUpdateResult(0);
                    this.f36699d = null;
                    a();
                    return true;
                }
                a(intent);
            }
        } else if (i16 == 0) {
            HMSLog.i("UpdateAdapter", "Activity.RESULT_CANCELED");
            this.f36699d = null;
            Activity b17 = b();
            if (b17 == null) {
                return true;
            }
            String hMSPackageName = HMSPackageManager.getInstance(b17.getApplicationContext()).getHMSPackageName();
            if (!this.f36700e && !a(b17, hMSPackageName, this.f36698c)) {
                SystemManager.getInstance().notifyUpdateResult(0);
            } else {
                HMSLog.i("UpdateAdapter", "Resolve error, process canceled by user clicking back button!");
                SystemManager.getInstance().notifyUpdateResult(13);
            }
        } else if (i16 == 1) {
            SystemManager.getInstance().notifyUpdateResult(28);
        }
        a();
        return true;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        HMSLog.i("UpdateAdapter", "onBridgeConfigurationChanged");
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i3, KeyEvent keyEvent) {
        HMSLog.i("UpdateAdapter", "On key up when resolve conn error");
    }

    private void a(Intent intent) {
        int intExtra = intent.getIntExtra(BridgeActivity.EXTRA_RESULT, -1);
        if (intExtra == 0) {
            HMSLog.i("UpdateAdapter", "Error resolved successfully!");
            SystemManager.getInstance().notifyUpdateResult(0);
        } else if (intExtra == 13) {
            HMSLog.i("UpdateAdapter", "Resolve error process canceled by user!");
            SystemManager.getInstance().notifyUpdateResult(13);
        } else if (intExtra == 8) {
            HMSLog.i("UpdateAdapter", "Internal error occurred, recommended retry.");
            SystemManager.getInstance().notifyUpdateResult(8);
        } else {
            HMSLog.i("UpdateAdapter", "Other error codes.");
            SystemManager.getInstance().notifyUpdateResult(intExtra);
        }
    }

    private void a() {
        Activity b16 = b();
        if (b16 == null || b16.isFinishing()) {
            return;
        }
        b16.finish();
    }

    private boolean a(Context context, String str, int i3) {
        if (context == null || TextUtils.isEmpty(str) || i3 == 0) {
            return false;
        }
        PackageManagerHelper packageManagerHelper = new PackageManagerHelper(context);
        return PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(packageManagerHelper.getPackageStates(str)) || packageManagerHelper.getPackageVersionCode(str) < i3;
    }
}
