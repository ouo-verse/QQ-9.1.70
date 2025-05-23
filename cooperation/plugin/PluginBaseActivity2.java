package cooperation.plugin;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

/* loaded from: classes28.dex */
public class PluginBaseActivity2 extends BasePluginActivity {

    /* renamed from: d, reason: collision with root package name */
    public boolean f390222d = true;

    /* renamed from: e, reason: collision with root package name */
    public boolean f390223e = true;

    /* renamed from: f, reason: collision with root package name */
    public SystemBarCompact f390224f;

    @Override // com.tencent.mobileqq.pluginsdk.BasePluginActivity, mqq.app.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.pluginsdk.BasePluginActivity, mqq.app.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pluginsdk.BasePluginActivity, mqq.app.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f390222d && ImmersiveUtils.isSupporImmersive() == 1) {
            getWindow().addFlags(67108864);
            if (this.f390223e) {
                this.f390224f = new SystemBarCompact((Activity) this, true, getResources().getColor(R.color.skin_color_title_immersive_bar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pluginsdk.BasePluginActivity, mqq.app.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        SystemBarCompact systemBarCompact = this.f390224f;
        if (systemBarCompact != null) {
            systemBarCompact.init();
        }
    }
}
