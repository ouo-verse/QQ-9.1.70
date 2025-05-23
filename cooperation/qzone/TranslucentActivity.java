package cooperation.qzone;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.ITranslucentActivityProxy;
import mqq.app.AndroidOreoUtils;

/* compiled from: P */
/* loaded from: classes28.dex */
public class TranslucentActivity extends Activity {
    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i3) {
        return ((ITranslucentActivityProxy) QRoute.api(ITranslucentActivityProxy.class)).getSharedPreferences(str, i3);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        AndroidOreoUtils androidOreoUtils = new AndroidOreoUtils(this);
        if (Build.VERSION.SDK_INT == 26 && getApplicationInfo().targetSdkVersion >= 27 && androidOreoUtils.isTranslucentOrFloating()) {
            QLog.i("TranslucentActivity", 1, "onCreate fixOrientation when Oreo, result = " + androidOreoUtils.fixOrientation());
        }
        super.onCreate(bundle);
        Intent intent = super.getIntent();
        if (!TextUtils.isEmpty(QzonePluginProxyActivity.getActivityNameToIntent(intent))) {
            ((ITranslucentActivityProxy) QRoute.api(ITranslucentActivityProxy.class)).startPlugin(intent, this);
        } else {
            finish();
        }
    }
}
