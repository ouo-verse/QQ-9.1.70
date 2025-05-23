package cooperation.qzone;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes28.dex */
public class WatchActivityManager {
    public static String TAG = "WatchActivityManager";
    private Activity activity;
    private boolean mPressScreenOff = false;
    private boolean mPressHomeKey = false;
    private boolean mPressMenuKey = false;
    private boolean mActivityStopped = false;
    public ScreenKeyReceiver mScreenReceiver = new ScreenKeyReceiver();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class ScreenKeyReceiver extends BroadcastReceiver {
        private String action;

        ScreenKeyReceiver() {
            this.action = null;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            this.action = action;
            if (!TextUtils.isEmpty(action)) {
                if (IECScreenReceiver.ACTION_SCREEN_OFF.equals(this.action)) {
                    WatchActivityManager.this.mPressScreenOff = true;
                } else if (this.action.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
                    WatchActivityManager.this.mPressHomeKey = true;
                }
            }
        }
    }

    private void registKeyReceiver() {
        if (this.activity != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
            intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
            this.activity.registerReceiver(this.mScreenReceiver, intentFilter);
        }
    }

    private void resetKeyFlag() {
        this.mPressScreenOff = false;
        this.mPressHomeKey = false;
        this.mPressMenuKey = false;
        this.mActivityStopped = false;
    }

    private void unRegistKeyReceiver() {
        Activity activity = this.activity;
        if (activity != null) {
            activity.unregisterReceiver(this.mScreenReceiver);
        }
    }

    public boolean hasJump() {
        QZLog.i(TAG, 4, "ljh, mActivityStopped = " + this.mActivityStopped + ", mPressScreenOff = " + this.mPressScreenOff + ", mPressMenuKey = " + this.mPressMenuKey + ", mPressHomeKey = " + this.mPressHomeKey);
        if (this.mActivityStopped && !this.mPressScreenOff && !this.mPressMenuKey && !this.mPressHomeKey) {
            return true;
        }
        return false;
    }

    public void onCreate(Activity activity) {
        this.activity = activity;
        registKeyReceiver();
    }

    public void onDestroy() {
        unRegistKeyReceiver();
    }

    public void onKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 82) {
            this.mPressMenuKey = true;
        }
    }

    public void onResume() {
        resetKeyFlag();
    }

    public void onStop() {
        this.mActivityStopped = true;
    }
}
