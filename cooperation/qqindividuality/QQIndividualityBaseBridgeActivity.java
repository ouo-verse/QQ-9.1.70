package cooperation.qqindividuality;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import cooperation.plugin.IPluginManager;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class QQIndividualityBaseBridgeActivity extends IphoneTitleBarActivity implements Handler.Callback {

    /* renamed from: a0, reason: collision with root package name */
    protected MqqWeakReferenceHandler f390717a0;

    /* renamed from: b0, reason: collision with root package name */
    protected IPluginManager f390718b0;

    public void G2(String str, PluginBaseInfo pluginBaseInfo) {
        if (pluginBaseInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.d("QQIndividuality", 2, "handlePluginInfo null == pluginInfo");
            }
            this.f390717a0.sendEmptyMessageDelayed(1000, 200L);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQIndividuality", 2, "pluginInfo.mState:" + pluginBaseInfo.mState + ", pluginInfo.mDownloadProgress:" + pluginBaseInfo.mDownloadProgress);
        }
        int i3 = pluginBaseInfo.mState;
        if (i3 != -2) {
            if (i3 != 0) {
                if (i3 != 1 && i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            H2();
                            return;
                        }
                        return;
                    }
                    this.f390717a0.sendEmptyMessageDelayed(1000, 200L);
                    return;
                }
            } else {
                this.f390718b0.x5("qqindividuality_plugin.apk");
                this.f390717a0.sendEmptyMessageDelayed(1000, 200L);
            }
            this.f390717a0.sendEmptyMessageDelayed(1000, 200L);
            return;
        }
        this.f390717a0.sendEmptyMessage(1001);
    }

    public abstract void H2();

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
        super.doOnCreate(bundle);
        this.f390717a0 = new MqqWeakReferenceHandler(this);
        this.f390718b0 = (IPluginManager) this.app.getManager(QQManagerFactory.MGR_PLUGIN);
        this.f390717a0.postDelayed(new Runnable() { // from class: cooperation.qqindividuality.QQIndividualityBaseBridgeActivity.1
            @Override // java.lang.Runnable
            public void run() {
                QQIndividualityBaseBridgeActivity.this.initPlugin();
            }
        }, 300L);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        MqqWeakReferenceHandler mqqWeakReferenceHandler = this.f390717a0;
        if (mqqWeakReferenceHandler != null) {
            mqqWeakReferenceHandler.removeMessages(1000);
            this.f390717a0.removeMessages(200);
            this.f390717a0.removeMessages(1001);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 != 1000) {
            if (i3 == 1001) {
                QLog.e("QQIndividuality", 2, "install plugin action error");
                ReportController.o(null, "CliOper", "", "", "ep_mall", "0X8006A99", 0, 0, "", "", "", "");
                return true;
            }
            return true;
        }
        if (!isFinishing()) {
            G2("qqindividuality_plugin.apk", this.f390718b0.queryPlugin("qqindividuality_plugin.apk"));
            return true;
        }
        return true;
    }

    public abstract void initPlugin();

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
