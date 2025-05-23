package cooperation.liveroom;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AndroidOreoUtils;

/* loaded from: classes28.dex */
public class LiveRoomProxyActivity extends Activity {
    private static final String TAG = "LiveRoomProxyActivity";

    public static void open(Activity activity, String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "plugin is NOT installed, opening loading page");
        }
        openWebView(activity, str);
    }

    public static void openWebView(Activity activity, String str) {
        Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("key_isReadModeEnabled", true);
        intent.putExtra("url", str);
        activity.startActivity(intent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        AndroidOreoUtils androidOreoUtils = new AndroidOreoUtils(this);
        if (Build.VERSION.SDK_INT == 26 && getApplicationInfo().targetSdkVersion >= 27 && androidOreoUtils.isTranslucentOrFloating()) {
            QLog.i(TAG, 1, "onCreate fixOrientation when Oreo, result = " + androidOreoUtils.fixOrientation());
        }
        super.onCreate(bundle);
    }
}
