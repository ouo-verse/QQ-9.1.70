package com.tencent.open.applist;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.open.base.f;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tmassistantbase.common.DownloadSDKConfigManager;
import com.tencent.util.WeakReferenceHandler;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginInfo;
import cooperation.qappcenter.QAppCenterPluginProxyActivityQzone;
import cooperation.qappcenter.QAppCenterPluginProxyActivityTools;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QZoneAppListActivity extends IphoneTitleBarActivity implements Handler.Callback {

    /* renamed from: a0, reason: collision with root package name */
    private int f340761a0 = 0;

    /* renamed from: b0, reason: collision with root package name */
    private IPluginManager f340762b0;

    /* renamed from: c0, reason: collision with root package name */
    private WeakReferenceHandler f340763c0;

    /* renamed from: d0, reason: collision with root package name */
    private TextView f340764d0;

    /* renamed from: e0, reason: collision with root package name */
    private TextView f340765e0;

    /* renamed from: f0, reason: collision with root package name */
    private LinearLayout f340766f0;

    /* renamed from: g0, reason: collision with root package name */
    private View f340767g0;

    private String I2() {
        switch (this.f340761a0) {
            case 1:
                return "com.tencent.plugin.qappcenter.QZoneAppListActivity";
            case 2:
            case 3:
            case 4:
                return "com.tencent.plugin.qappcenter.QZoneAppWebViewActivity";
            case 5:
                return "com.tencent.plugin.qappcenter.WebAppActivity";
            case 6:
                return "com.tencent.plugin.qappcenter.AppCenterMainActivity";
            case 7:
                return "com.tencent.plugin.qappcenter.AppCenterAppDetailActivity";
            case 8:
                return "com.tencent.plugin.qappcenter.AppCenterSearchActivity";
            case 9:
                return "com.tencent.plugin.qappcenter.AppCenterBrowserActivity";
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K2() {
        IPluginManager.i iVar = new IPluginManager.i(1);
        iVar.f390198d = "qappcenter_plugin.apk";
        iVar.f390201g = HardCodeUtil.qqStr(R.string.rox);
        iVar.f390197c = this.app.getCurrentAccountUin();
        iVar.f390202h = I2();
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.getIntExtra(CrashHianalyticsData.PROCESS_ID, -1) == 2) {
                iVar.f390203i = QAppCenterPluginProxyActivityQzone.class;
            } else {
                iVar.f390203i = QAppCenterPluginProxyActivityTools.class;
            }
        } else {
            iVar.f390203i = QAppCenterPluginProxyActivityTools.class;
        }
        f.e("GHOST", "[launchPlugin] class:" + iVar.f390203i);
        Intent intent2 = new Intent();
        intent2.putExtra(PluginStatic.PARAM_USE_QQ_RESOURCES, 2);
        if (intent != null && intent.getExtras() != null) {
            intent2.putExtras(intent.getExtras());
        }
        iVar.f390204j = intent2;
        IPluginManager.B5(this, iVar);
        finish();
    }

    private void initPlugin() {
        boolean z16;
        PluginInfo queryPlugin = this.f340762b0.queryPlugin("qappcenter_plugin.apk");
        if (queryPlugin != null) {
            int i3 = queryPlugin.mState;
            if (i3 == 4) {
                z16 = true;
            } else {
                if (i3 != 1) {
                    this.f340762b0.installPlugin("qappcenter_plugin.apk", new OnPluginInstallListener.Stub() { // from class: com.tencent.open.applist.QZoneAppListActivity.1
                        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
                        public void onInstallDownloadProgress(String str, int i16, int i17) throws RemoteException {
                            QZoneAppListActivity.this.L2((i16 / i17) * 100);
                        }

                        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
                        public void onInstallError(String str, int i16) throws RemoteException {
                            QZoneAppListActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.open.applist.QZoneAppListActivity.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    QZoneAppListActivity.this.f340764d0.setText(HardCodeUtil.qqStr(R.string.rov));
                                }
                            });
                        }

                        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
                        public void onInstallFinish(String str) throws RemoteException {
                            QZoneAppListActivity.this.K2();
                        }

                        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
                        public void onInstallBegin(String str) throws RemoteException {
                        }
                    });
                }
                z16 = false;
            }
            if (!z16) {
                this.f340763c0.sendEmptyMessageDelayed(1, 400L);
            } else {
                this.f340763c0.sendEmptyMessageDelayed(5, 0L);
            }
        }
    }

    public void J2(String str, PluginBaseInfo pluginBaseInfo) {
        if (pluginBaseInfo == null) {
            if (!this.f340762b0.isReady()) {
                this.f340763c0.sendEmptyMessageDelayed(1, 400L);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("IphoneTitleBarActivity", 2, "handlePluginInfo:" + pluginBaseInfo.mState);
        }
        int i3 = pluginBaseInfo.mState;
        if (i3 != -2) {
            if (i3 != 0) {
                if (i3 != 1 && i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                this.f340763c0.sendEmptyMessageDelayed(1, 400L);
                                return;
                            }
                            return;
                        } else {
                            L2(100);
                            K2();
                            return;
                        }
                    }
                    this.f340763c0.sendEmptyMessage(3);
                    this.f340763c0.sendEmptyMessageDelayed(1, 400L);
                    return;
                }
                this.f340763c0.obtainMessage(2, (int) (pluginBaseInfo.mDownloadProgress * 90.0f), 0).sendToTarget();
                this.f340763c0.sendEmptyMessageDelayed(1, 400L);
                return;
            }
            this.f340762b0.x5("qappcenter_plugin.apk");
            return;
        }
        this.f340763c0.sendEmptyMessage(4);
    }

    public void L2(final int i3) {
        runOnUiThread(new Runnable() { // from class: com.tencent.open.applist.QZoneAppListActivity.2
            @Override // java.lang.Runnable
            public void run() {
                QZoneAppListActivity.this.f340764d0.setText(i3 + "%");
            }
        });
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
        int i3;
        super.doOnCreate(bundle);
        getWindow().setBackgroundDrawableResource(R.color.ajr);
        setContentView(R.layout.f168444wb);
        TextView textView = (TextView) findViewById(R.id.g1f);
        this.f340764d0 = textView;
        textView.setText("0%");
        this.f340767g0 = findViewById(R.id.f7b);
        this.f340765e0 = (TextView) findViewById(R.id.f125877n9);
        this.f340766f0 = (LinearLayout) findViewById(R.id.f125887n_);
        if (QQTheme.isNowThemeIsNight()) {
            this.f340765e0.setTextColor(getResources().getColor(R.color.f158017al3));
            this.f340766f0.setBackground(getResources().getDrawable(R.color.black));
        } else {
            this.f340765e0.setTextColor(getResources().getColor(R.color.black));
            this.f340766f0.setBackground(getResources().getDrawable(R.color.f158017al3));
        }
        setTitle(R.string.d8d);
        updateAppRuntime();
        this.f340762b0 = (IPluginManager) this.app.getManager(QQManagerFactory.MGR_PLUGIN);
        this.f340763c0 = new WeakReferenceHandler(this);
        if (DownloadSDKConfigManager.canGotoNewAppListPage()) {
            i3 = 6;
        } else {
            i3 = 1;
        }
        DownloadSDKConfigManager.refreshNewAppCenterConfig();
        this.f340761a0 = getIntent().getIntExtra("goto_type", i3);
        f.e("GHOST", "[doOnCreate] mGotoType:" + this.f340761a0);
        initPlugin();
        return true;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3;
        int i16 = message.what;
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 != 3) {
                    if (i16 == 5) {
                        K2();
                    }
                } else {
                    try {
                        i3 = Integer.valueOf(this.f340764d0.getText().toString()).intValue();
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.w("IphoneTitleBarActivity", 2, "handleMessage Exception:", e16);
                        }
                        i3 = 0;
                    }
                    int i17 = 99;
                    if (i3 >= 99) {
                        i17 = i3 + 1;
                    }
                    L2(i17);
                }
            } else {
                L2(message.arg1);
            }
        } else if (!isFinishing()) {
            J2("qappcenter_plugin.apk", this.f340762b0.queryPlugin("qappcenter_plugin.apk"));
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
