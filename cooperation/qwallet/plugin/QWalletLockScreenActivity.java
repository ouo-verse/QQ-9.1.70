package cooperation.qwallet.plugin;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.app.AppActivity;
import mqq.app.Foreground;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QWalletLockScreenActivity extends AppActivity implements View.OnClickListener {
    public static int lsActivity_count;
    private BaseQQAppInterface app;
    String content;
    TextView contentView;
    private RelativeLayout mBackBtn;
    ScreenBroadcastReceiver mScreenReceiver;
    String time;
    TextView timeView;
    String title;
    TextView titleView;
    private final int MSG_FINISH_ACTIVITY = 2;
    private final int MSG_START_UNLOCKACTIVITY = 9;
    private Handler handler = new Handler(Looper.getMainLooper()) { // from class: cooperation.qwallet.plugin.QWalletLockScreenActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 != 2) {
                if (i3 == 9) {
                    QWalletLockScreenActivity.this.unlockAndStartPayBridgeActivity();
                }
            } else {
                QWalletLockScreenActivity.this.moveTaskToBack(true);
                QWalletLockScreenActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class ScreenBroadcastReceiver extends BroadcastReceiver {
        private String action = null;

        ScreenBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            this.action = action;
            if (IECScreenReceiver.ACTION_SCREEN_ON.equals(action)) {
                if (QLog.isColorLevel()) {
                    QLog.d(IQWalletHelper.TAG_WALLET_PUSH, 2, "QWalletLockScreenActivity ACTION_SCREEN_ON");
                }
            } else if (IECScreenReceiver.ACTION_SCREEN_OFF.equals(this.action)) {
                if (QLog.isColorLevel()) {
                    QLog.d(IQWalletHelper.TAG_WALLET_PUSH, 2, "QWalletLockScreenActivity ACTION_SCREEN_OFF");
                }
            } else if ("android.intent.action.USER_PRESENT".equals(this.action) && QLog.isColorLevel()) {
                QLog.d(IQWalletHelper.TAG_WALLET_PUSH, 2, "QWalletLockScreenActivity ACTION_USER_PRESENT");
            }
        }
    }

    private void initNavigationBarColor() {
        com.tencent.mobileqq.theme.a.d(getWindow());
    }

    @TargetApi(16)
    private boolean isKeyguardLock() {
        try {
            KeyguardManager keyguardManager = (KeyguardManager) getSystemService("keyguard");
            if (QLog.isColorLevel()) {
                QLog.e(IQWalletHelper.TAG_WALLET_PUSH, 2, "QWalletLockScreenActivity kgm.isKeyguardLocked()=" + keyguardManager.isKeyguardLocked() + ". kgm.isKeyguardSecure()=" + keyguardManager.isKeyguardSecure());
            }
            if (keyguardManager != null && keyguardManager.isKeyguardLocked()) {
                if (keyguardManager.isKeyguardSecure()) {
                    return true;
                }
            }
            return false;
        } catch (SecurityException e16) {
            if (QLog.isColorLevel()) {
                QLog.e(IQWalletHelper.TAG_WALLET_PUSH, 2, "QWalletLockScreenActivity kgm.isKeyguardLocked()=" + e16);
            }
            return true;
        }
    }

    private void registerListener() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_ON);
        intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        registerReceiver(this.mScreenReceiver, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unlockAndStartPayBridgeActivity() {
        boolean isKeyguardLock = isKeyguardLock();
        if (QLog.isColorLevel()) {
            QLog.d(IQWalletHelper.TAG_WALLET_PUSH, 2, "QWalletLockScreenActivity isKeyGuardLock=" + isKeyguardLock);
        }
        if (!isKeyguardLock) {
            Intent intent = new Intent(this, ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).getQQLSUnlockActivityClazz());
            intent.putExtra(IQWalletConst.FROM_WALLET_UNLOCK, true);
            startActivity(intent);
        } else {
            moveTaskToBack(true);
            finish();
        }
    }

    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnBackPressed() {
        super.doOnBackPressed();
        if (QLog.isColorLevel()) {
            QLog.d(IQWalletHelper.TAG_WALLET_PUSH, 2, "QWalletLockScreenActivity onBackPressed=== ");
        }
        if (!isFinishing()) {
            if (QLog.isColorLevel()) {
                QLog.d(IQWalletHelper.TAG_WALLET_PUSH, 2, "QWalletLockScreenActivity onBackPressed not finish ");
            }
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        super.doOnCreate(bundle);
        if (QLog.isColorLevel()) {
            QLog.d(IQWalletHelper.TAG_WALLET_PUSH, 2, "QWalletLockScreenActivity doOnCreate taskId" + getTaskId() + Thread.currentThread().getId());
        }
        setContentView(R.layout.bdw);
        getWindow().addFlags(524288);
        this.mScreenReceiver = new ScreenBroadcastReceiver();
        registerListener();
        initNavigationBarColor();
        BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) getAppRuntime();
        this.app = baseQQAppInterface;
        if (baseQQAppInterface == null) {
            if (QLog.isColorLevel()) {
                QLog.d(IQWalletHelper.TAG_WALLET_PUSH, 2, "QWalletLockScreenActivity app null,  finish");
            }
            finish();
            return true;
        }
        this.title = getIntent().getStringExtra("title");
        this.content = getIntent().getStringExtra("content");
        this.time = getIntent().getStringExtra("time");
        this.titleView = (TextView) findViewById(R.id.f166986jo4);
        this.contentView = (TextView) findViewById(R.id.grh);
        this.timeView = (TextView) findViewById(R.id.grm);
        this.titleView.setText(this.title);
        this.contentView.setText(this.content);
        this.timeView.setText(this.time);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.aga);
        this.mBackBtn = relativeLayout;
        relativeLayout.setOnClickListener(this);
        this.contentView.setOnClickListener(this);
        if (QLog.isColorLevel()) {
            QLog.d(IQWalletHelper.TAG_WALLET_PUSH, 2, "QWalletLockScreenActivity new brightWakeLock");
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        ScreenBroadcastReceiver screenBroadcastReceiver = this.mScreenReceiver;
        if (screenBroadcastReceiver != null) {
            unregisterReceiver(screenBroadcastReceiver);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnPause() {
        ComponentName componentName;
        super.doOnPause();
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getRunningTasks(1);
        if (runningTasks != null && runningTasks.size() > 0) {
            componentName = runningTasks.get(0).topActivity;
            String className = componentName.getClassName();
            if (QLog.isColorLevel()) {
                QLog.d(IQWalletHelper.TAG_WALLET_PUSH, 2, "QWalletLockScreenActivity doOnPause by :" + className);
            }
            if ("com.tencent.mobileqq.activity.GesturePWDUnlockActivity".equals(className)) {
                if (QLog.isColorLevel()) {
                    QLog.d(IQWalletHelper.TAG_WALLET_PUSH, 2, "QWalletLockScreenActivity doOnPause by locking activity need to front");
                }
                Intent intent = new Intent(this, (Class<?>) QWalletLockScreenActivity.class);
                intent.addFlags(131072);
                startActivity(intent);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(IQWalletHelper.TAG_WALLET_PUSH, 2, "QWalletLockScreenActivity doOnPause taskId" + getTaskId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnStart() {
        super.doOnStart();
        boolean isScreenLocked = ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).isScreenLocked(this);
        if (QLog.isColorLevel()) {
            QLog.d(IQWalletHelper.TAG_WALLET_PUSH, 2, "QWalletLockScreenActivity doOnStart isScreenLocked=" + isScreenLocked);
        }
        if (!isScreenLocked) {
            finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long j3;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.grh) {
            Message obtainMessage = this.handler.obtainMessage(9);
            Handler handler = this.handler;
            if (((IQWalletTemp) QRoute.api(IQWalletTemp.class)).getJumpLock(this, this.app.getCurrentAccountUin())) {
                j3 = 500;
            } else {
                j3 = 0;
            }
            handler.sendMessageDelayed(obtainMessage, j3);
        } else if (view.getId() == R.id.aga) {
            this.handler.sendMessageDelayed(this.handler.obtainMessage(2), 1500L);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Foreground.sCountActivity.decrementAndGet();
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Foreground.sCountActivity.incrementAndGet();
        super.onStop();
    }
}
