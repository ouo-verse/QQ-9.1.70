package cooperation.qqpim;

import android.app.ActivityManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import cooperation.qqpim.QQPimPluginLoadRunnable;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes28.dex */
public class QQPimBridgeActivity extends IphoneTitleBarActivity implements Handler.Callback {

    /* renamed from: e0, reason: collision with root package name */
    public static long f390765e0;

    /* renamed from: a0, reason: collision with root package name */
    private QQProgressDialog f390766a0;

    /* renamed from: b0, reason: collision with root package name */
    private MqqWeakReferenceHandler f390767b0;

    /* renamed from: c0, reason: collision with root package name */
    private QQPimPluginLoadRunnable f390768c0;

    /* renamed from: d0, reason: collision with root package name */
    QQPimPluginLoadRunnable.a f390769d0 = new b();

    /* loaded from: classes28.dex */
    class a implements DialogInterface.OnDismissListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            QQPimBridgeActivity.this.finish();
        }
    }

    public static boolean H2(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null || (runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY))) == null) {
            return false;
        }
        Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
        while (it.hasNext()) {
            if ("com.tencent.mobileqq:tool".compareTo(it.next().processName) == 0) {
                return true;
            }
        }
        return false;
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
        super.doOnCreate(bundle);
        getWindow().setBackgroundDrawableResource(R.color.ajr);
        if (System.currentTimeMillis() - f390765e0 < 800) {
            finish();
            return true;
        }
        this.f390767b0 = new MqqWeakReferenceHandler(this);
        f390765e0 = System.currentTimeMillis();
        QQProgressDialog qQProgressDialog = new QQProgressDialog(this, super.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        this.f390766a0 = qQProgressDialog;
        qQProgressDialog.setMessage(HardCodeUtil.qqStr(R.string.qzd));
        this.f390766a0.setCanceledOnTouchOutside(false);
        this.f390766a0.setOnDismissListener(new a());
        QQPimPluginLoadRunnable qQPimPluginLoadRunnable = this.f390768c0;
        if (qQPimPluginLoadRunnable != null) {
            qQPimPluginLoadRunnable.stop();
        }
        QQPimPluginLoadRunnable qQPimPluginLoadRunnable2 = new QQPimPluginLoadRunnable(this.f390769d0);
        this.f390768c0 = qQPimPluginLoadRunnable2;
        ThreadManagerV2.postImmediately(qQPimPluginLoadRunnable2, null, true);
        return true;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        QQProgressDialog qQProgressDialog = this.f390766a0;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.f390766a0.dismiss();
            this.f390766a0 = null;
        }
        BaseActivity.sTopActivity = null;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        QQProgressDialog qQProgressDialog;
        int i3 = message.what;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2 && !isFinishing()) {
                    int i16 = message.arg1;
                    int dimensionPixelSize = super.getResources().getDimensionPixelSize(R.dimen.title_bar_height);
                    String qqStr = HardCodeUtil.qqStr(R.string.qzg);
                    if (-4 == i16) {
                        qqStr = HardCodeUtil.qqStr(R.string.qzh);
                    } else if (-5 != i16 && -1 != i16 && -3 != i16 && -2 != i16) {
                        if (-6 == i16) {
                            qqStr = HardCodeUtil.qqStr(R.string.qze);
                        }
                    } else {
                        qqStr = HardCodeUtil.qqStr(R.string.qzc);
                    }
                    QQToast.makeText(this.app.getApp(), 1, qqStr, 0).show(dimensionPixelSize);
                    finish();
                }
            } else if (!isFinishing()) {
                Bundle extras = getIntent().getExtras();
                QQProgressDialog qQProgressDialog2 = null;
                if (cooperation.qqpim.a.f390805i.equals(extras.getString(cooperation.qqpim.a.f390811o))) {
                    if (!H2(getApplicationContext())) {
                        qQProgressDialog2 = this.f390766a0;
                    }
                    QQPimPluginProxyActivity.F2(this, extras, qQProgressDialog2);
                    finish();
                } else if (cooperation.qqpim.a.f390806j.equals(extras.getString(cooperation.qqpim.a.f390811o))) {
                    if (!H2(getApplicationContext())) {
                        qQProgressDialog2 = this.f390766a0;
                    }
                    QQPimPluginProxyActivity.G2(this, extras, qQProgressDialog2);
                    finish();
                }
            }
        } else if (!isFinishing() && (qQProgressDialog = this.f390766a0) != null) {
            qQProgressDialog.setMessage(HardCodeUtil.qqStr(R.string.qzf));
            this.f390766a0.show();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        super.requestWindowFeature(1);
    }

    /* loaded from: classes28.dex */
    class b implements QQPimPluginLoadRunnable.a {
        b() {
        }

        @Override // cooperation.qqpim.QQPimPluginLoadRunnable.a
        public void b() {
            QQPimBridgeActivity.this.f390767b0.sendEmptyMessage(0);
        }

        @Override // cooperation.qqpim.QQPimPluginLoadRunnable.a
        public void c(int i3) {
            if (QLog.isColorLevel()) {
                QLog.i(cooperation.qqpim.a.f390797a, 2, "QQPimBridgeActivity.downloadError()");
            }
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.arg1 = i3;
            QQPimBridgeActivity.this.f390767b0.sendMessage(obtain);
        }

        @Override // cooperation.qqpim.QQPimPluginLoadRunnable.a
        public void d() {
            if (QLog.isColorLevel()) {
                QLog.i(cooperation.qqpim.a.f390797a, 2, "QQPimBridgeActivity.hasInstalled()");
            }
            QQPimBridgeActivity.this.f390767b0.sendEmptyMessage(1);
        }

        @Override // cooperation.qqpim.QQPimPluginLoadRunnable.a
        public void a(float f16) {
        }
    }
}
