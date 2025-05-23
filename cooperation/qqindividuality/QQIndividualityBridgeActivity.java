package cooperation.qqindividuality;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.VasNtCommonReporter;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginInfo;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QQIndividualityBridgeActivity extends QQIndividualityBaseBridgeActivity {

    /* renamed from: j0, reason: collision with root package name */
    public static long f390719j0 = 0;

    /* renamed from: k0, reason: collision with root package name */
    public static int f390720k0 = 0;

    /* renamed from: l0, reason: collision with root package name */
    public static int f390721l0 = 1;

    /* renamed from: m0, reason: collision with root package name */
    public static int f390722m0 = 2;

    /* renamed from: c0, reason: collision with root package name */
    public d f390723c0;

    /* renamed from: e0, reason: collision with root package name */
    public e f390725e0;

    /* renamed from: h0, reason: collision with root package name */
    int f390728h0;

    /* renamed from: d0, reason: collision with root package name */
    boolean f390724d0 = true;

    /* renamed from: f0, reason: collision with root package name */
    String f390726f0 = null;

    /* renamed from: g0, reason: collision with root package name */
    String f390727g0 = null;

    /* renamed from: i0, reason: collision with root package name */
    int f390729i0 = -1;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a implements DialogInterface.OnDismissListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            QQIndividualityBridgeActivity qQIndividualityBridgeActivity = QQIndividualityBridgeActivity.this;
            if (qQIndividualityBridgeActivity.f390724d0) {
                qQIndividualityBridgeActivity.setResult(1001);
                QQIndividualityBridgeActivity.super.finish();
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQIndividuality", 2, "dialog dismiss: " + QQIndividualityBridgeActivity.this.f390724d0);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class b implements DialogInterface.OnDismissListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            QQIndividualityBridgeActivity qQIndividualityBridgeActivity = QQIndividualityBridgeActivity.this;
            if (qQIndividualityBridgeActivity.f390724d0) {
                QQIndividualityBridgeActivity.super.finish();
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQIndividuality", 2, "dialog dismiss: " + QQIndividualityBridgeActivity.this.f390724d0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class d extends QQProgressDialog {
        public d(Context context, int i3) {
            super(context, i3);
        }

        @Override // com.tencent.mobileqq.widget.QQProgressDialog, android.app.Dialog
        public void onBackPressed() {
            if (QQIndividualityBridgeActivity.this.f390724d0) {
                super.onBackPressed();
            } else if (QLog.isColorLevel()) {
                QLog.d("IphoneTitleBarActivity", 2, "tool process has started, cancel by the tool");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class e extends v05.a {
        public e(Context context) {
            super(context);
        }

        @Override // android.app.Dialog
        public void onBackPressed() {
            if (QQIndividualityBridgeActivity.this.f390724d0) {
                super.onBackPressed();
            } else if (QLog.isColorLevel()) {
                QLog.d("IphoneTitleBarActivity", 2, "tool process has started, cancel by the tool");
            }
        }
    }

    @Override // cooperation.qqindividuality.QQIndividualityBaseBridgeActivity
    public void H2() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        if (!QIPCServerHelper.getInstance().isModuleRunning("qqindividuality_plugin.apk")) {
            this.f390724d0 = false;
            int i3 = this.f390729i0;
            if (i3 == f390720k0) {
                QQIndividualityProxyActivity.F2(this, intent, this.app.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualityActivity", QQIndividualityProxyActivity.class, this.f390723c0, this.f390728h0);
                overridePendingTransition(R.anim.f154740cc, 0);
            } else if (i3 == f390721l0) {
                intent.putExtra("startOpenPageTime", System.currentTimeMillis());
                intent.putExtra("is_first_open", true);
                QQIndividualityProxyActivity.F2(this, intent, this.app.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualitySignatureActivity", QQIndividualityProxyActivity.class, this.f390725e0, this.f390728h0);
                overridePendingTransition(R.anim.f154740cc, 0);
            } else if (i3 == f390722m0) {
                QQIndividualityProxyActivity.F2(this, intent, this.app.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualityStatusHistoryActivity", QQIndividualityProxyActivity.class, this.f390725e0, this.f390728h0);
                overridePendingTransition(R.anim.f154740cc, 0);
            }
        } else {
            int i16 = this.f390729i0;
            if (i16 == f390720k0) {
                QQIndividualityProxyActivity.F2(this, intent, this.app.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualityActivity", QQIndividualityProxyActivity.class, null, this.f390728h0);
            } else if (i16 == f390721l0) {
                intent.putExtra("startOpenPageTime", System.currentTimeMillis());
                QQIndividualityProxyActivity.F2(this, intent, this.app.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualitySignatureActivity", QQIndividualityProxyActivity.class, null, this.f390728h0);
            } else if (i16 == f390722m0) {
                QQIndividualityProxyActivity.F2(this, intent, this.app.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualityStatusHistoryActivity", QQIndividualityProxyActivity.class, null, this.f390728h0);
                overridePendingTransition(R.anim.f154740cc, 0);
            }
        }
        if (-1 == this.f390728h0) {
            super.finish();
        }
    }

    @Override // cooperation.qqindividuality.QQIndividualityBaseBridgeActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        e eVar;
        super.doOnActivityResult(i3, i16, intent);
        int i17 = this.f390729i0;
        if (i17 == f390720k0) {
            d dVar = this.f390723c0;
            if (dVar != null) {
                if (dVar.isShowing()) {
                    this.f390723c0.dismiss();
                }
                this.f390723c0.setOnDismissListener(null);
                this.f390723c0 = null;
            }
        } else if ((i17 == f390721l0 || i17 == f390722m0) && (eVar = this.f390725e0) != null) {
            if (eVar.isShowing()) {
                this.f390725e0.dismiss();
            }
            this.f390725e0.setOnDismissListener(null);
            this.f390725e0 = null;
        }
        setResult(i16, intent);
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cooperation.qqindividuality.QQIndividualityBaseBridgeActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        super.doOnCreate(bundle);
        VasNtCommonReporter.getHistoryFeature("QQIndividuality").setValue2("activity-create").report(false);
        getWindow().setBackgroundDrawableResource(R.color.ajr);
        if (Math.abs(System.currentTimeMillis() - f390719j0) < 800) {
            setResult(1001);
            super.finish();
            return true;
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.f390729i0 = intent.getIntExtra("individuality_plugin", -1);
        }
        f390719j0 = System.currentTimeMillis();
        this.f390726f0 = getIntent().getStringExtra(cooperation.qqindividuality.b.f390735c);
        this.f390727g0 = getIntent().getStringExtra(cooperation.qqindividuality.b.f390736d);
        if (TextUtils.isEmpty(this.f390726f0) || TextUtils.isEmpty(this.f390727g0)) {
            if (QLog.isColorLevel()) {
                QLog.d("QQIndividuality", 2, "path or name is null , return: " + this.f390726f0 + " " + this.f390727g0);
            }
            setResult(1001);
            super.finish();
        }
        int dimensionPixelSize = super.getResources().getDimensionPixelSize(R.dimen.title_bar_height);
        this.f390728h0 = getIntent().getIntExtra(cooperation.qqindividuality.b.f390739g, -1);
        int i3 = this.f390729i0;
        if (i3 == f390721l0 || i3 == f390722m0) {
            e eVar = new e(this);
            this.f390725e0 = eVar;
            eVar.setCanceledOnTouchOutside(false);
            this.f390725e0.setOnDismissListener(new a());
        }
        if (this.f390729i0 == f390720k0) {
            d dVar = new d(this, dimensionPixelSize);
            this.f390723c0 = dVar;
            dVar.setMessage(HardCodeUtil.qqStr(R.string.qt_));
            this.f390723c0.setCanceledOnTouchOutside(false);
            if (this.f390728h0 != -1) {
                this.f390723c0.setOnDismissListener(new b());
            }
        }
        return true;
    }

    @Override // cooperation.qqindividuality.QQIndividualityBaseBridgeActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        d dVar = this.f390723c0;
        if (dVar != null) {
            if (dVar.isShowing()) {
                this.f390723c0.dismiss();
            }
            this.f390723c0.setOnDismissListener(null);
            this.f390723c0 = null;
        }
        e eVar = this.f390725e0;
        if (eVar != null) {
            if (eVar.isShowing()) {
                this.f390725e0.dismiss();
            }
            this.f390725e0.setOnDismissListener(null);
            this.f390725e0 = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQIndividuality", 2, "destroy.....");
        }
        BaseActivity.sTopActivity = null;
    }

    @Override // cooperation.qqindividuality.QQIndividualityBaseBridgeActivity
    public void initPlugin() {
        IPluginManager iPluginManager = this.f390718b0;
        if (iPluginManager == null) {
            return;
        }
        PluginInfo queryPlugin = iPluginManager.queryPlugin("qqindividuality_plugin.apk");
        if (queryPlugin != null) {
            int i3 = queryPlugin.mState;
            if (i3 == 4) {
                H2();
                return;
            }
            if (i3 != 1 && i3 != 3) {
                showDialog();
                this.f390718b0.installPlugin("qqindividuality_plugin.apk", new c());
                return;
            } else {
                showDialog();
                this.f390717a0.sendEmptyMessageDelayed(1000, 200L);
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQIndividuality", 2, "initPlugin pluginInfo == null");
        }
        showDialog();
        this.f390717a0.sendEmptyMessageDelayed(1000, 200L);
    }

    @Override // cooperation.qqindividuality.QQIndividualityBaseBridgeActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        super.requestWindowFeature(1);
    }

    public void showDialog() {
        if (!isFinishing()) {
            int i3 = this.f390729i0;
            if (i3 == f390720k0) {
                this.f390723c0.show();
            } else if (i3 == f390722m0 || i3 == f390721l0) {
                this.f390725e0.show();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class c extends OnPluginInstallListener.Stub {
        c() {
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallError(String str, int i3) throws RemoteException {
            String valueOf = String.valueOf(i3);
            String qqStr = HardCodeUtil.qqStr(R.string.qt9);
            int i16 = QQIndividualityBridgeActivity.this.f390729i0;
            if (i16 == QQIndividualityBridgeActivity.f390720k0) {
                qqStr = HardCodeUtil.qqStr(R.string.f172438qt2);
            } else if (i16 == QQIndividualityBridgeActivity.f390721l0) {
                qqStr = HardCodeUtil.qqStr(R.string.f172439qt3);
            } else if (i16 == QQIndividualityBridgeActivity.f390722m0) {
                qqStr = HardCodeUtil.qqStr(R.string.qt6);
            }
            IPluginManager.H5(valueOf, qqStr);
            int systemNetwork = NetworkUtil.getSystemNetwork(QQIndividualityBridgeActivity.this);
            QLog.e("QQIndividuality", 2, "install plugin fail: " + i3 + " and netType = " + systemNetwork);
            QQIndividualityBridgeActivity.this.setResult(1001);
            QQIndividualityBridgeActivity.super.finish();
            ReportController.o(null, "CliOper", "", "", "ep_mall", "0X8006A98", 0, 0, valueOf, String.valueOf(systemNetwork), "", "");
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallFinish(String str) throws RemoteException {
            QQIndividualityBridgeActivity.this.H2();
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallBegin(String str) throws RemoteException {
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallDownloadProgress(String str, int i3, int i16) throws RemoteException {
        }
    }
}
