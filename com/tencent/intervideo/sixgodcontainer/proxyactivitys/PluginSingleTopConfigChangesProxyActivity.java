package com.tencent.intervideo.sixgodcontainer.proxyactivitys;

import android.content.res.Configuration;
import android.view.MotionEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.shadow.core.runtime.container.PluginContainerActivity;

/* loaded from: classes7.dex */
public class PluginSingleTopConfigChangesProxyActivity extends PluginContainerActivity {
    static IPatchRedirector $redirector_;

    public PluginSingleTopConfigChangesProxyActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.shadow.core.runtime.container.PluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.shadow.core.runtime.container.PluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
