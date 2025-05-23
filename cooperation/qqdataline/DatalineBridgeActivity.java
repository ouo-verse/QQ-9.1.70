package cooperation.qqdataline;

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
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.ca;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginInfo;

/* compiled from: P */
/* loaded from: classes28.dex */
public class DatalineBridgeActivity extends IphoneTitleBarActivity implements Handler.Callback {

    /* renamed from: a0, reason: collision with root package name */
    private MqqWeakReferenceHandler f390529a0;

    /* renamed from: b0, reason: collision with root package name */
    private IPluginManager f390530b0;

    /* renamed from: c0, reason: collision with root package name */
    private QQProgressDialog f390531c0;

    /* renamed from: d0, reason: collision with root package name */
    private long f390532d0;

    /* renamed from: e0, reason: collision with root package name */
    private String f390533e0;

    /* renamed from: f0, reason: collision with root package name */
    private Bundle f390534f0;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a implements DialogInterface.OnDismissListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            DatalineBridgeActivity.this.finish();
        }
    }

    private boolean G2() {
        QQAppInterface qQAppInterface;
        if (!DatalinePluginProxyActivity.G2(this) || (qQAppInterface = this.app) == null) {
            return false;
        }
        IPluginManager iPluginManager = (IPluginManager) qQAppInterface.getManager(QQManagerFactory.MGR_PLUGIN);
        this.f390530b0 = iPluginManager;
        if (iPluginManager == null) {
            H2(-6);
            return false;
        }
        PluginInfo queryPlugin = iPluginManager.queryPlugin("qqdataline.apk");
        if (queryPlugin != null && queryPlugin.mState != 4) {
            return false;
        }
        QLog.i("DatalineBridgeActivity", 1, "[DatalineBridgeActivity] launchPlugin");
        Intent intent = new Intent();
        boolean z16 = this.f390534f0.getBoolean("string_from", false);
        boolean z17 = this.f390534f0.getBoolean("string_uin", false);
        long j3 = this.f390534f0.getLong("device_din", 0L);
        int i3 = this.f390534f0.getInt("sTitleID", 0);
        if (z16) {
            intent.addFlags(536870912);
        }
        intent.putExtra("string_uin", z17);
        intent.putExtra("device_din", j3);
        intent.putExtra("sTitleID", i3);
        intent.putExtra(PluginStatic.PARAM_USE_QQ_RESOURCES, 2);
        String account = this.app.getAccount();
        try {
            QQAppInterface qQAppInterface2 = this.app;
            account = ac.F(qQAppInterface2, qQAppInterface2.getAccount());
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (account == null) {
            account = this.app.getAccount();
        }
        DatalinePluginProxyActivity.H2(this, account, intent, this.f390533e0, -1, null);
        finish();
        overridePendingTransition(0, 0);
        return true;
    }

    private void H2(int i3) {
        QLog.e("DatalineBridgeActivity", 1, "[DatalineBridgeActivity] handleFailed errCode:" + i3);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.title_bar_height);
        String qqStr = HardCodeUtil.qqStr(R.string.l8i);
        if (-4 == i3) {
            qqStr = HardCodeUtil.qqStr(R.string.f171826l90);
        } else if (-5 != i3 && -1 != i3 && -3 != i3 && -2 != i3) {
            if (-6 == i3) {
                qqStr = HardCodeUtil.qqStr(R.string.l8y);
            }
        } else {
            qqStr = HardCodeUtil.qqStr(R.string.l8v);
        }
        QQToast.makeText(this.app.getApp(), 1, qqStr, 0).show(dimensionPixelSize);
        finish();
    }

    private void I2() {
        QLog.i("DatalineBridgeActivity", 1, "[DatalineBridgeActivity] launchPlugin->");
        Intent intent = new Intent();
        boolean z16 = this.f390534f0.getBoolean("string_from", false);
        boolean z17 = this.f390534f0.getBoolean("string_uin", false);
        long j3 = this.f390534f0.getLong("device_din", 0L);
        int i3 = this.f390534f0.getInt("sTitleID", 0);
        if (z16) {
            intent.addFlags(536870912);
        }
        intent.putExtra("string_uin", z17);
        intent.putExtra("device_din", j3);
        intent.putExtra("sTitleID", i3);
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface == null) {
            return;
        }
        String account = qQAppInterface.getAccount();
        try {
            QQAppInterface qQAppInterface2 = this.app;
            account = ac.F(qQAppInterface2, qQAppInterface2.getAccount());
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (account == null) {
            account = this.app.getAccount();
        }
        String str = account;
        if (DatalinePluginProxyActivity.G2(this)) {
            DatalinePluginProxyActivity.H2(this, str, intent, this.f390533e0, -1, null);
            finish();
            overridePendingTransition(0, 0);
        } else {
            intent.putExtra(PluginStatic.PARAM_USE_QQ_RESOURCES, 2);
            DatalinePluginProxyActivity.H2(this, str, intent, this.f390533e0, -1, this.f390531c0);
            overridePendingTransition(0, 0);
        }
    }

    private void J2(String str, PluginBaseInfo pluginBaseInfo) {
        boolean z16;
        if (QLog.isDevelopLevel()) {
            QLog.d("DatalineBridgeActivity", 4, "[DatalineBridgeActivity] queryPluginInfo!");
        }
        if (System.currentTimeMillis() - this.f390532d0 > 30000) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (pluginBaseInfo == null) {
            if (!this.f390530b0.isReady()) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("DatalineBridgeActivity", 4, "[DatalineBridgeActivity] queryPluginInfo is no ready and query it");
                }
                if (z16) {
                    H2(-5);
                    return;
                } else {
                    this.f390529a0.sendEmptyMessageDelayed(1001, 400L);
                    return;
                }
            }
            H2(-1);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("DatalineBridgeActivity", 4, "[DatalineBridgeActivity] queryPluginInfo mState : " + pluginBaseInfo.mState + " progress:" + pluginBaseInfo.mDownloadProgress);
        }
        int i3 = pluginBaseInfo.mState;
        if (-2 != i3 && 4 != i3 && !NetworkUtil.isNetworkAvailable(getApplicationContext()) && System.currentTimeMillis() - this.f390532d0 > 5000) {
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
                this.f390530b0.x5("qqdataline.apk");
                break;
            case 1:
            case 2:
                break;
            case 3:
                if (z16) {
                    H2(-5);
                    return;
                } else {
                    this.f390529a0.sendEmptyMessageDelayed(1001, 400L);
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
            this.f390529a0.sendEmptyMessageDelayed(1001, 400L);
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
        super.doOnCreate(bundle);
        this.f390534f0 = getIntent().getBundleExtra("_param_");
        this.f390533e0 = getIntent().getStringExtra("componetname");
        this.f390529a0 = new MqqWeakReferenceHandler(this);
        if (G2()) {
            return true;
        }
        QQProgressDialog qQProgressDialog = new QQProgressDialog(this, getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        this.f390531c0 = qQProgressDialog;
        qQProgressDialog.setMessage(HardCodeUtil.qqStr(R.string.l8w));
        this.f390531c0.setOnDismissListener(new a());
        this.f390529a0.postDelayed(new Runnable() { // from class: cooperation.qqdataline.DatalineBridgeActivity.2
            @Override // java.lang.Runnable
            public void run() {
                DatalineBridgeActivity.this.start();
            }
        }, 300L);
        return true;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1001) {
            if (QLog.isDevelopLevel()) {
                QLog.d("DatalineBridgeActivity", 4, "[DatalineBridgeActivity]  ACTION_QUERY!");
            }
            if (!isFinishing()) {
                J2("qqdataline.apk", this.f390530b0.queryPlugin("qqdataline.apk"));
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
        QQProgressDialog qQProgressDialog = this.f390531c0;
        if (qQProgressDialog != null) {
            qQProgressDialog.dismiss();
            this.f390531c0 = null;
        }
        MqqWeakReferenceHandler mqqWeakReferenceHandler = this.f390529a0;
        if (mqqWeakReferenceHandler != null) {
            mqqWeakReferenceHandler.removeMessages(1001);
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("QPlugin", 4, "DatalineBridgeActivity onDestroy");
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
        this.f390530b0 = (IPluginManager) this.app.getManager(QQManagerFactory.MGR_PLUGIN);
        boolean z16 = true;
        QLog.i("DatalineBridgeActivity", 1, "[DatalineBridgeActivity] onPluginManagerLoaded SUPPORT_NETWORKING:true");
        if (this.f390530b0 == null) {
            H2(-6);
            return;
        }
        this.f390532d0 = System.currentTimeMillis();
        PluginInfo queryPlugin = this.f390530b0.queryPlugin("qqdataline.apk");
        if (queryPlugin != null) {
            if (queryPlugin.mState == 4) {
                I2();
                if (z16) {
                    QQProgressDialog qQProgressDialog = this.f390531c0;
                    if (qQProgressDialog != null) {
                        qQProgressDialog.setMessage(HardCodeUtil.qqStr(R.string.l8u));
                        this.f390531c0.show();
                    }
                    this.f390529a0.sendEmptyMessageDelayed(1001, 400L);
                    return;
                }
                return;
            }
            QLog.i("DatalineBridgeActivity", 1, "[DatalineBridgeActivity] onPluginManagerLoaded start down or install...");
            this.f390530b0.x5("qqdataline.apk");
        }
        z16 = false;
        if (z16) {
        }
    }
}
