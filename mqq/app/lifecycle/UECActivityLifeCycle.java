package mqq.app.lifecycle;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QActivityLifecycleCallbacks;

/* compiled from: P */
@TargetApi(14)
/* loaded from: classes28.dex */
public final class UECActivityLifeCycle implements QActivityLifecycleCallbacks, Handler.Callback {
    private static final int DELAY_BROADCAST = 100;
    private static final int MSG_BACK = 0;
    private static final int MSG_FORE = 1;
    public static final String TAG = "MobileQQLife";
    private Context mContext;
    public int mCountActivity = 0;
    public int mCountResume = 0;
    private Handler mHandler;
    private String mProcessName;

    public UECActivityLifeCycle(Context context, Looper looper, String str) {
        this.mProcessName = str;
        this.mContext = context;
        this.mHandler = new Handler(looper, this);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        long j3 = (message.arg1 << 32) | (message.arg2 & (-1));
        QLog.i("mqq", 1, message.what + ", " + this.mProcessName + ", " + j3 + ", " + this.mCountActivity);
        int i3 = message.what;
        if (i3 != 0) {
            if (i3 == 1) {
                if (this.mCountActivity > 0) {
                    MsfServiceSdk.get().onProcessViewableChanged(true, j3);
                }
            }
            return true;
        }
        if (this.mCountActivity == 0) {
            MsfServiceSdk.get().onProcessViewableChanged(false, j3);
        }
        return true;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.mCountResume--;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.mCountResume++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        int i3 = this.mCountActivity + 1;
        this.mCountActivity = i3;
        if (i3 == 1 || i3 == 2) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, (int) (uptimeMillis >>> 32), (int) (uptimeMillis & (-1))), 100L);
            QLog.i("mqq", 1, "onActivityStarted");
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int i3 = this.mCountActivity - 1;
        this.mCountActivity = i3;
        if (i3 == 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, (int) (uptimeMillis >>> 32), (int) (uptimeMillis & (-1))), 100L);
            QLog.i("mqq", 1, "onActivityStopped");
        }
    }

    @Override // mqq.app.QActivityLifecycleCallbacks
    public void onProcessBackground() {
    }

    @Override // mqq.app.QActivityLifecycleCallbacks
    public void onProcessForeground() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
