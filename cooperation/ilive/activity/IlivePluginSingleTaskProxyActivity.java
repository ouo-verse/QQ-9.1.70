package cooperation.ilive.activity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Process;
import android.view.MotionEvent;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes28.dex */
public class IlivePluginSingleTaskProxyActivity extends Activity {
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
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        QLog.i("IlivePluginSingleTaskProxyActivity", 2, "\u5f02\u5e38\u5206\u652f\uff1a\u81ea\u52a8\u91cd\u542f\u63d2\u4ef6Activity\u7684\u573a\u666f\uff0cfinish\u4e0d\u505a\u4efb\u4f55\u5904\u7406 ");
        finish();
        SystemMethodProxy.killProcess(Process.myPid());
    }
}
