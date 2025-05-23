package com.tencent.zplan.activity;

import android.content.res.Configuration;
import android.view.MotionEvent;
import com.epicgames.ue4.GameActivityExt;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.zplan.engine.service.d;
import com.tencent.zplan.luabridge.ZPlanLuaBridge;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

/* compiled from: P */
@Deprecated(level = DeprecationLevel.ERROR, message = "Use ZPlanActivity instead")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/zplan/activity/GameActivityWithListener;", "Lcom/epicgames/ue4/GameActivityExt;", "()V", "onResume", "", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public class GameActivityWithListener extends GameActivityExt {
    @Override // com.epicgames.ue4.GameActivityExt, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.epicgames.ue4.GameActivityExt, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.epicgames.ue4.GameActivityExt, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        d dVar = d.f385635c;
        dVar.d();
        dVar.e();
        ZPlanLuaBridge.evaluateWaitList$default(ZPlanLuaBridge.INSTANCE, false, 1, null);
    }
}
