package cooperation.qlink;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.ca;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginInfo;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QlinkBridgeActivity extends IphoneTitleBarActivity implements Handler.Callback {

    /* renamed from: a0, reason: collision with root package name */
    private MqqWeakReferenceHandler f390428a0;

    /* renamed from: b0, reason: collision with root package name */
    private IPluginManager f390429b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f390430c0;

    /* renamed from: d0, reason: collision with root package name */
    private Bundle f390431d0;

    /* renamed from: e0, reason: collision with root package name */
    private QQProgressDialog f390432e0;

    /* renamed from: f0, reason: collision with root package name */
    private long f390433f0;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            QlinkBridgeActivity.this.finish();
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class b implements DialogInterface.OnDismissListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            QlinkBridgeActivity.this.finish();
        }
    }

    private boolean G2() {
        if (!QlinkPluginProxyActivity.I2(this)) {
            return false;
        }
        Intent e16 = cooperation.qlink.b.e();
        Bundle bundle = new Bundle();
        bundle.putInt("string_from", this.f390430c0);
        Bundle bundle2 = this.f390431d0;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        e16.putExtra("string_bundle", bundle);
        QQAppInterface qQAppInterface = this.app;
        bundle.putString("_SELF_NICK_", ac.G(qQAppInterface, qQAppInterface.getAccount()));
        QlinkPluginProxyActivity.J2(this, this.app.getAccount(), e16, 0, null);
        finish();
        overridePendingTransition(0, 0);
        return true;
    }

    private void H2(int i3) {
        QLog.e("QlinkBridgeActivity", 1, "[QlinkBridgeActivity] handleFailed errCode:" + i3);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.title_bar_height);
        String qqStr = HardCodeUtil.qqStr(R.string.qfc);
        if (-4 == i3) {
            qqStr = HardCodeUtil.qqStr(R.string.qfd);
        } else if (-5 != i3 && -1 != i3 && -3 != i3 && -2 != i3) {
            if (-6 == i3) {
                qqStr = HardCodeUtil.qqStr(R.string.qfg);
            }
        } else {
            qqStr = HardCodeUtil.qqStr(R.string.qfe);
        }
        QQToast.makeText(this.app.getApp(), 1, qqStr, 0).show(dimensionPixelSize);
        finish();
    }

    private void I2() {
        QLog.i("QlinkBridgeActivity", 1, "[QlinkBridgeActivity] launchPlugin mFrom:" + this.f390430c0);
        Intent e16 = cooperation.qlink.b.e();
        Bundle bundle = new Bundle();
        bundle.putInt("string_from", this.f390430c0);
        Bundle bundle2 = this.f390431d0;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface == null) {
            return;
        }
        String account = qQAppInterface.getAccount();
        try {
            QQAppInterface qQAppInterface2 = this.app;
            account = ac.F(qQAppInterface2, qQAppInterface2.getAccount());
        } catch (Exception e17) {
            e17.printStackTrace();
        }
        if (account == null) {
            account = this.app.getAccount();
        }
        bundle.putString("_SELF_NICK_", account);
        e16.putExtra("string_bundle", bundle);
        if (QlinkPluginProxyActivity.I2(this)) {
            QlinkPluginProxyActivity.J2(this, this.app.getAccount(), e16, 0, null);
            finish();
            overridePendingTransition(0, 0);
        } else {
            QlinkPluginProxyActivity.J2(this, this.app.getAccount(), e16, 0, this.f390432e0);
            overridePendingTransition(0, 0);
        }
    }

    private void J2(String str, PluginBaseInfo pluginBaseInfo) {
        boolean z16;
        if (QLog.isDevelopLevel()) {
            QLog.d("QlinkBridgeActivity", 4, "[QlinkBridgeActivity] queryPluginInfo!");
        }
        if (System.currentTimeMillis() - this.f390433f0 > 30000) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (pluginBaseInfo == null) {
            if (!this.f390429b0.isReady()) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("QlinkBridgeActivity", 4, "[QlinkBridgeActivity] queryPluginInfo is no ready and query it");
                }
                if (z16) {
                    H2(-5);
                    return;
                } else {
                    this.f390428a0.sendEmptyMessageDelayed(1001, 400L);
                    return;
                }
            }
            H2(-1);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("QlinkBridgeActivity", 4, "[QlinkBridgeActivity] queryPluginInfo mState : " + pluginBaseInfo.mState + " progress:" + pluginBaseInfo.mDownloadProgress);
        }
        int i3 = pluginBaseInfo.mState;
        if (-2 != i3 && 4 != i3 && !NetworkUtil.isNetworkAvailable(getApplicationContext()) && System.currentTimeMillis() - this.f390433f0 > 5000) {
            H2(-4);
            return;
        }
        switch (pluginBaseInfo.mState) {
            case -2:
                H2(-2);
                return;
            case -1:
                H2(-6);
                return;
            case 0:
                this.f390429b0.x5("qlink_plugin.apk");
                break;
            case 1:
            case 2:
                break;
            case 3:
                if (z16) {
                    H2(-5);
                    return;
                } else {
                    this.f390428a0.sendEmptyMessageDelayed(1001, 400L);
                    return;
                }
            case 4:
                I2();
                return;
            default:
                H2(-3);
                return;
        }
        if (z16) {
            H2(-5);
        } else {
            this.f390428a0.sendEmptyMessageDelayed(1001, 400L);
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        ca.a(this);
        try {
            super.doOnCreate(bundle);
            this.f390430c0 = getIntent().getIntExtra("_from_", 0);
            this.f390431d0 = getIntent().getBundleExtra("_param_");
            this.f390428a0 = new MqqWeakReferenceHandler(this);
            if (BaseApplication.getContext().getSharedPreferences("QlinkResistTerrorist", 0).getInt("QlinkResistTerrorist_res", 0) == 1) {
                FileManagerReporter.addData("0X8005392");
                if (QLog.isColorLevel()) {
                    QLog.e("QlinkBridgeActivity", 2, "[QLINK] QQ - startQlink failed because of QlinkResistTerrorist_res is 1!!!");
                }
                DialogUtil.createCustomDialog(this, 233, getString(R.string.f4c), getString(R.string.f171469f51), R.string.f4b, R.string.f4b, new a(), (DialogInterface.OnClickListener) null).show();
                return false;
            }
            if (G2()) {
                return true;
            }
            QQProgressDialog qQProgressDialog = new QQProgressDialog(this, getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            this.f390432e0 = qQProgressDialog;
            qQProgressDialog.setMessage(HardCodeUtil.qqStr(R.string.qfb));
            this.f390432e0.setOnDismissListener(new b());
            this.f390428a0.postDelayed(new Runnable() { // from class: cooperation.qlink.QlinkBridgeActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    QlinkBridgeActivity.this.start();
                }
            }, 300L);
            return true;
        } catch (Exception e16) {
            QLog.e("QlinkBridgeActivity", 1, "oncreate excption:" + e16.toString());
            finish();
            return false;
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1001) {
            if (QLog.isDevelopLevel()) {
                QLog.d("QlinkBridgeActivity", 4, "[QlinkBridgeActivity]  ACTION_QUERY!");
            }
            if (!isFinishing()) {
                J2("qlink_plugin.apk", this.f390429b0.queryPlugin("qlink_plugin.apk"));
                return true;
            }
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        QQProgressDialog qQProgressDialog = this.f390432e0;
        if (qQProgressDialog != null) {
            qQProgressDialog.dismiss();
            this.f390432e0 = null;
        }
        MqqWeakReferenceHandler mqqWeakReferenceHandler = this.f390428a0;
        if (mqqWeakReferenceHandler != null) {
            mqqWeakReferenceHandler.removeMessages(1001);
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("QPlugin", 4, "QlinkBridgeActivity onDestroy");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        requestWindowFeature(1);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void start() {
        this.f390429b0 = (IPluginManager) this.app.getManager(QQManagerFactory.MGR_PLUGIN);
        boolean z16 = true;
        QLog.i("QlinkBridgeActivity", 1, "[QlinkBridgeActivity] onPluginManagerLoaded SUPPORT_NETWORKING:true");
        if (this.f390429b0 == null) {
            H2(-6);
            return;
        }
        this.f390433f0 = System.currentTimeMillis();
        PluginInfo queryPlugin = this.f390429b0.queryPlugin("qlink_plugin.apk");
        if (queryPlugin != null) {
            if (queryPlugin.mState == 4) {
                I2();
                if (z16) {
                    QQProgressDialog qQProgressDialog = this.f390432e0;
                    if (qQProgressDialog != null) {
                        qQProgressDialog.setMessage(HardCodeUtil.qqStr(R.string.qff));
                        this.f390432e0.show();
                    }
                    this.f390428a0.sendEmptyMessageDelayed(1001, 400L);
                    return;
                }
                return;
            }
            QLog.i("QlinkBridgeActivity", 1, "[QlinkBridgeActivity] onPluginManagerLoaded start down or install...");
            this.f390429b0.x5("qlink_plugin.apk");
        }
        z16 = false;
        if (z16) {
        }
    }
}
