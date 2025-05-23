package cooperation.plugin;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.MotionEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes28.dex */
public class PluginBaseActivity extends BasePluginActivity {

    /* renamed from: d, reason: collision with root package name */
    public boolean f390221d = true;

    @Override // com.tencent.mobileqq.pluginsdk.BasePluginActivity, mqq.app.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    public int g0() {
        return getResources().getDimensionPixelSize(R.dimen.title_bar_height);
    }

    @Override // com.tencent.mobileqq.pluginsdk.BasePluginActivity, mqq.app.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    public final Activity getActivity() {
        return this;
    }
}
