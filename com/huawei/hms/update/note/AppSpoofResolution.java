package com.huawei.hms.update.note;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.ui.AbstractDialog;
import com.huawei.hms.ui.AbstractPromptDialog;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ResourceLoaderUtil;

/* compiled from: P */
/* loaded from: classes2.dex */
public class AppSpoofResolution implements IBridgeActivityDelegate {

    /* renamed from: a, reason: collision with root package name */
    private Activity f37643a;

    /* renamed from: b, reason: collision with root package name */
    private b f37644b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements AbstractDialog.Callback {
        a() {
        }

        @Override // com.huawei.hms.ui.AbstractDialog.Callback
        public void onCancel(AbstractDialog abstractDialog) {
            com.huawei.hms.availableupdate.a.f36755c.a(true);
            AppSpoofResolution.this.f37644b = null;
            AppSpoofResolution.this.a();
        }

        @Override // com.huawei.hms.ui.AbstractDialog.Callback
        public void onDoWork(AbstractDialog abstractDialog) {
            com.huawei.hms.availableupdate.a.f36755c.a(true);
            AppSpoofResolution.this.f37644b = null;
            AppSpoofResolution.this.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class b extends AbstractPromptDialog {
        b() {
        }

        @Override // com.huawei.hms.ui.AbstractDialog
        public String onGetMessageString(Context context) {
            String str = "com.huawei.hwid";
            String applicationName = new PackageManagerHelper(context).getApplicationName("com.huawei.hwid");
            if (!TextUtils.isEmpty(applicationName)) {
                str = applicationName;
            }
            if (ResourceLoaderUtil.getmContext() == null) {
                ResourceLoaderUtil.setmContext(context);
            }
            return ResourceLoaderUtil.getString("hms_is_spoof", str);
        }

        @Override // com.huawei.hms.ui.AbstractDialog
        public String onGetPositiveButtonString(Context context) {
            if (ResourceLoaderUtil.getmContext() == null) {
                ResourceLoaderUtil.setmContext(context);
            }
            return ResourceLoaderUtil.getString("hms_confirm");
        }

        @Override // com.huawei.hms.ui.AbstractPromptDialog, com.huawei.hms.ui.AbstractDialog
        public String onGetTitleString(Context context) {
            if (ResourceLoaderUtil.getmContext() == null) {
                ResourceLoaderUtil.setmContext(context);
            }
            return ResourceLoaderUtil.getString("hms_spoof_hints");
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    private void b() {
        Activity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            b bVar = this.f37644b;
            if (bVar == null) {
                this.f37644b = new b(null);
            } else {
                bVar.dismiss();
            }
            HMSLog.i("AppSpoofResolution", "enter AppSpoofResolution showPromptdlg to resolve conn error");
            this.f37644b.show(activity, new a());
        }
    }

    protected Activity getActivity() {
        return this.f37643a;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 0;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        HMSLog.i("AppSpoofResolution", "enter AppSpoofResolution onBridgeActivityCreate");
        this.f37643a = activity;
        com.huawei.hms.availableupdate.a aVar = com.huawei.hms.availableupdate.a.f36755c;
        aVar.a(activity);
        aVar.a(false);
        b();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        HMSLog.i("AppSpoofResolution", "enter AppSpoofResolution onBridgeActivityDestroy");
        com.huawei.hms.availableupdate.a aVar = com.huawei.hms.availableupdate.a.f36755c;
        if (aVar.a().compareAndSet(true, false)) {
            SystemManager.getInstance().notifyNoticeResult(29);
        }
        aVar.b(this.f37643a);
        this.f37643a = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i3, int i16, Intent intent) {
        if (i3 != getRequestCode()) {
            return false;
        }
        HMSLog.i("AppSpoofResolution", "enter AppSpoofResolution onBridgeActivityResult");
        return true;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        if (this.f37644b == null) {
            return;
        }
        HMSLog.i("AppSpoofResolution", "enter AppSpoofResolution re show prompt dialog");
        b();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i3, KeyEvent keyEvent) {
        HMSLog.i("AppSpoofResolution", "enter AppSpoofResolution On key up when resolve spoof error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Activity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        HMSLog.i("AppSpoofResolution", "enter AppSpoofResolution finishBridgeActivity\uff1a");
        if (com.huawei.hms.availableupdate.a.f36755c.a().compareAndSet(true, false)) {
            SystemManager.getInstance().notifyNoticeResult(29);
        }
        activity.finish();
    }
}
