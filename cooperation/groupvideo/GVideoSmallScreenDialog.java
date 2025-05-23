package cooperation.groupvideo;

import android.content.res.Configuration;
import android.view.MotionEvent;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.groupvideo.api.IGVideoSmallScreenDialog;

/* compiled from: P */
/* loaded from: classes28.dex */
public class GVideoSmallScreenDialog extends PluginProxyActivity {

    /* renamed from: a0, reason: collision with root package name */
    private static final IGVideoSmallScreenDialog f390124a0 = (IGVideoSmallScreenDialog) QRoute.api(IGVideoSmallScreenDialog.class);

    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyActivity
    public String getPluginID() {
        return f390124a0.getPluginID();
    }

    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyActivity
    public Class<? extends PluginProxyActivity> getProxyActivity(String str) {
        return GVideoSmallScreenDialog.class;
    }

    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
