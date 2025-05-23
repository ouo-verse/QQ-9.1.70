package com.tencent.minibox.loader.delegator;

import android.content.res.Configuration;
import android.view.MotionEvent;
import com.tencent.minibox.loader.base.DelegatorActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/minibox/loader/delegator/PluginDelegatorActivity;", "Lcom/tencent/minibox/loader/base/DelegatorActivity;", "()V", "FirstMainActivity", "SecondMainActivity", "ThirdMainActivity", "MiniBoxLoader_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes9.dex */
public abstract class PluginDelegatorActivity extends DelegatorActivity {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/minibox/loader/delegator/PluginDelegatorActivity$FirstMainActivity;", "Lcom/tencent/minibox/loader/delegator/PluginDelegatorActivity;", "()V", "MiniBoxLoader_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes9.dex */
    public static final class FirstMainActivity extends PluginDelegatorActivity {
        @Override // com.tencent.minibox.loader.delegator.PluginDelegatorActivity, com.tencent.minibox.loader.base.DelegatorActivity, com.tencent.minibox.dynamic.api.BaseDelegatorActivity, android.app.Activity, android.view.Window.Callback, com.tencent.minibox.dynamic.api.IActivityDelegator
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
            return dispatchTouchEvent;
        }

        @Override // com.tencent.minibox.loader.delegator.PluginDelegatorActivity, com.tencent.minibox.loader.base.DelegatorActivity, com.tencent.minibox.dynamic.api.BaseDelegatorActivity, android.app.Activity, android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            super.onConfigurationChanged(configuration);
            EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/minibox/loader/delegator/PluginDelegatorActivity$SecondMainActivity;", "Lcom/tencent/minibox/loader/delegator/PluginDelegatorActivity;", "()V", "MiniBoxLoader_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes9.dex */
    public static final class SecondMainActivity extends PluginDelegatorActivity {
        @Override // com.tencent.minibox.loader.delegator.PluginDelegatorActivity, com.tencent.minibox.loader.base.DelegatorActivity, com.tencent.minibox.dynamic.api.BaseDelegatorActivity, android.app.Activity, android.view.Window.Callback, com.tencent.minibox.dynamic.api.IActivityDelegator
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
            return dispatchTouchEvent;
        }

        @Override // com.tencent.minibox.loader.delegator.PluginDelegatorActivity, com.tencent.minibox.loader.base.DelegatorActivity, com.tencent.minibox.dynamic.api.BaseDelegatorActivity, android.app.Activity, android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            super.onConfigurationChanged(configuration);
            EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/minibox/loader/delegator/PluginDelegatorActivity$ThirdMainActivity;", "Lcom/tencent/minibox/loader/delegator/PluginDelegatorActivity;", "()V", "MiniBoxLoader_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes9.dex */
    public static final class ThirdMainActivity extends PluginDelegatorActivity {
        @Override // com.tencent.minibox.loader.delegator.PluginDelegatorActivity, com.tencent.minibox.loader.base.DelegatorActivity, com.tencent.minibox.dynamic.api.BaseDelegatorActivity, android.app.Activity, android.view.Window.Callback, com.tencent.minibox.dynamic.api.IActivityDelegator
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
            return dispatchTouchEvent;
        }

        @Override // com.tencent.minibox.loader.delegator.PluginDelegatorActivity, com.tencent.minibox.loader.base.DelegatorActivity, com.tencent.minibox.dynamic.api.BaseDelegatorActivity, android.app.Activity, android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            super.onConfigurationChanged(configuration);
            EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
        }
    }

    @Override // com.tencent.minibox.loader.base.DelegatorActivity, com.tencent.minibox.dynamic.api.BaseDelegatorActivity, android.app.Activity, android.view.Window.Callback, com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.minibox.loader.base.DelegatorActivity, com.tencent.minibox.dynamic.api.BaseDelegatorActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
