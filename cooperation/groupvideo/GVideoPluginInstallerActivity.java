package cooperation.groupvideo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.format.Time;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import cooperation.plugin.IPluginManager;
import java.util.ArrayList;

/* loaded from: classes38.dex */
public class GVideoPluginInstallerActivity extends IphoneTitleBarActivity {
    Handler mInstallTreadHandler;
    IPluginManager mPluginManager;
    TextView mTextView;
    final String TAG = getClass().getSimpleName();
    final int MSG_OPEN_TROOP_VIDEO = 1;
    final int MSG_SET_TEXT = 2;
    final int MSG_PLUGIN_INSTALL_ERROR = 3;
    final int MSG_QUIT = 4;
    final String HT_INSTALL_THREAD_NAME = "TroopVideoPluginInstaller";
    final Handler mMainThreadHandler = new a(Looper.getMainLooper());
    private final OnPluginInstallListener mPluginInstallListener = new b();
    private final Runnable mInstallRunnable = new Runnable() { // from class: cooperation.groupvideo.GVideoPluginInstallerActivity.3
        @Override // java.lang.Runnable
        public void run() {
            GVideoPluginInstallerActivity gVideoPluginInstallerActivity = GVideoPluginInstallerActivity.this;
            IPluginManager iPluginManager = gVideoPluginInstallerActivity.mPluginManager;
            if (iPluginManager == null) {
                return;
            }
            iPluginManager.installPlugin("group_video_plugin.apk", gVideoPluginInstallerActivity.mPluginInstallListener);
        }
    };

    /* loaded from: classes38.dex */
    class b extends OnPluginInstallListener.Stub {
        b() {
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallBegin(String str) throws RemoteException {
            if (QLog.isColorLevel()) {
                QLog.d(GVideoPluginInstallerActivity.this.TAG, 2, "Group video plugin onInstallBegin...");
            }
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallDownloadProgress(String str, int i3, int i16) throws RemoteException {
            if (QLog.isColorLevel()) {
                QLog.d(GVideoPluginInstallerActivity.this.TAG, 2, "Group video plugin onInstallDownloadProgress...");
            }
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallError(String str, int i3) throws RemoteException {
            if (QLog.isColorLevel()) {
                QLog.d(GVideoPluginInstallerActivity.this.TAG, 2, "Group video plugin onInstallError...");
            }
            GVideoPluginInstallerActivity.this.mMainThreadHandler.sendEmptyMessageDelayed(3, 200L);
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallFinish(String str) throws RemoteException {
            if (QLog.isColorLevel()) {
                QLog.d(GVideoPluginInstallerActivity.this.TAG, 2, "Group video plugin onInstallFinish...");
            }
            GVideoPluginInstallerActivity.this.mMainThreadHandler.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enterTroopVideo() {
        Intent intent = super.getIntent();
        if (intent == null) {
            return;
        }
        TextView textView = this.leftView;
        if (textView != null) {
            intent.putExtra("leftViewString", textView.getText().toString());
        }
        cooperation.groupvideo.a.c(this.app, this, intent, 1);
    }

    private String getLocalVerify(ArrayList<String> arrayList, boolean z16) {
        String obj;
        Time time = new Time();
        time.setToNow();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("com.tencent.process.exit");
        sb5.append(time.year);
        sb5.append(time.month + 1);
        sb5.append(time.monthDay);
        sb5.append(time.hour);
        if (z16) {
            sb5.append(time.minute - 1);
        } else {
            sb5.append(time.minute);
        }
        if (arrayList == null) {
            obj = "null";
        } else {
            obj = arrayList.toString();
        }
        sb5.append(obj);
        return MD5.toMD5(MD5.toMD5(sb5.toString()) + sb5.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPluginInstallError() {
        this.mTextView.setText(getString(R.string.ewp));
        this.mMainThreadHandler.sendEmptyMessageDelayed(4, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        super.doOnActivityResult(i3, i16, intent);
        if (i3 == 1) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        boolean doOnCreate = super.doOnCreate(bundle);
        super.setContentView(R.layout.ak8);
        super.setTitle(getString(R.string.ewr));
        if (this.leftView != null && getIntent() != null) {
            this.leftView.setText(getIntent().getExtras().getString(AppConstants.LeftViewText.LEFTVIEWTEXT));
        }
        TextView textView = (TextView) findViewById(R.id.jfo);
        this.mTextView = textView;
        textView.setText(getString(R.string.ewq));
        this.mPluginManager = (IPluginManager) this.app.getManager(QQManagerFactory.MGR_PLUGIN);
        return doOnCreate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        this.mMainThreadHandler.removeCallbacksAndMessages(null);
        Handler handler = this.mInstallTreadHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            Looper looper = this.mInstallTreadHandler.getLooper();
            if (looper != null) {
                looper.quit();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnWindowFocusChanged(boolean z16) {
        IPluginManager iPluginManager;
        super.doOnWindowFocusChanged(z16);
        if (!z16 || (iPluginManager = this.mPluginManager) == null) {
            return;
        }
        if (iPluginManager.isPlugininstalled("group_video_plugin.apk")) {
            this.mMainThreadHandler.sendEmptyMessageDelayed(1, 1000L);
            return;
        }
        if (cooperation.groupvideo.a.e(getApplicationContext())) {
            Intent intent = new Intent("com.tencent.process.exit");
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("com.tencent.mobileqq:groupvideo");
            intent.putStringArrayListExtra("procNameList", arrayList);
            intent.putExtra("verify", getLocalVerify(arrayList, false));
            sendBroadcast(intent);
            this.mMainThreadHandler.sendEmptyMessageDelayed(3, 200L);
            return;
        }
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("TroopVideoPluginInstaller", 10);
        baseHandlerThread.start();
        Handler handler = new Handler(baseHandlerThread.getLooper());
        this.mInstallTreadHandler = handler;
        handler.postDelayed(this.mInstallRunnable, 200L);
    }

    /* loaded from: classes38.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            TextView textView;
            if (message == null) {
                return;
            }
            int i3 = message.what;
            if (i3 == 1) {
                GVideoPluginInstallerActivity.this.enterTroopVideo();
                return;
            }
            if (i3 == 2) {
                Object obj = message.obj;
                if (!(obj instanceof String) || (textView = GVideoPluginInstallerActivity.this.mTextView) == null) {
                    return;
                }
                textView.setText((String) obj);
                return;
            }
            if (i3 == 3) {
                GVideoPluginInstallerActivity.this.onPluginInstallError();
            } else {
                if (i3 != 4) {
                    return;
                }
                GVideoPluginInstallerActivity.this.finish();
            }
        }
    }
}
