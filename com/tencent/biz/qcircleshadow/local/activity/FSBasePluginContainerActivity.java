package com.tencent.biz.qcircleshadow.local.activity;

import android.content.res.Configuration;
import android.view.MotionEvent;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.qcircle.shadow.core.runtime.qcircle.container.PluginContainerActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes4.dex */
public class FSBasePluginContainerActivity extends PluginContainerActivity {
    @Override // com.tencent.qcircle.shadow.core.runtime.qcircle.container.PluginContainerActivity, android.app.Activity, android.view.Window.Callback, com.tencent.qcircle.shadow.core.runtime.qcircle.container.HostActivityDelegator
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.qcircle.container.PluginContainerActivity
    public String getUUID(String str) {
        return ASEngineConstants.BusinessKeyToUUID.sUUID.get(str);
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.qcircle.container.PluginContainerActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
