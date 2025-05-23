package com.tencent.minibox.loader.stub;

import android.content.res.Configuration;
import android.view.MotionEvent;
import androidx.annotation.Keep;
import com.tencent.minibox.loader.base.DelegatorActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

/* compiled from: P */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/minibox/loader/stub/StubActivity;", "Lcom/tencent/minibox/loader/base/DelegatorActivity;", "()V", "A00", "A01", "A02", "A03", "MiniBoxLoader_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes9.dex */
public abstract class StubActivity extends DelegatorActivity {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/minibox/loader/stub/StubActivity$A00;", "Lcom/tencent/minibox/loader/stub/StubActivity;", "()V", "MiniBoxLoader_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes9.dex */
    public static final class A00 extends StubActivity {
        @Override // com.tencent.minibox.loader.stub.StubActivity, com.tencent.minibox.loader.base.DelegatorActivity, com.tencent.minibox.dynamic.api.BaseDelegatorActivity, android.app.Activity, android.view.Window.Callback, com.tencent.minibox.dynamic.api.IActivityDelegator
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
            return dispatchTouchEvent;
        }

        @Override // com.tencent.minibox.loader.stub.StubActivity, com.tencent.minibox.loader.base.DelegatorActivity, com.tencent.minibox.dynamic.api.BaseDelegatorActivity, android.app.Activity, android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            super.onConfigurationChanged(configuration);
            EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/minibox/loader/stub/StubActivity$A01;", "Lcom/tencent/minibox/loader/stub/StubActivity;", "()V", "MiniBoxLoader_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes9.dex */
    public static final class A01 extends StubActivity {
        @Override // com.tencent.minibox.loader.stub.StubActivity, com.tencent.minibox.loader.base.DelegatorActivity, com.tencent.minibox.dynamic.api.BaseDelegatorActivity, android.app.Activity, android.view.Window.Callback, com.tencent.minibox.dynamic.api.IActivityDelegator
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
            return dispatchTouchEvent;
        }

        @Override // com.tencent.minibox.loader.stub.StubActivity, com.tencent.minibox.loader.base.DelegatorActivity, com.tencent.minibox.dynamic.api.BaseDelegatorActivity, android.app.Activity, android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            super.onConfigurationChanged(configuration);
            EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/minibox/loader/stub/StubActivity$A02;", "Lcom/tencent/minibox/loader/stub/StubActivity;", "()V", "MiniBoxLoader_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes9.dex */
    public static final class A02 extends StubActivity {
        @Override // com.tencent.minibox.loader.stub.StubActivity, com.tencent.minibox.loader.base.DelegatorActivity, com.tencent.minibox.dynamic.api.BaseDelegatorActivity, android.app.Activity, android.view.Window.Callback, com.tencent.minibox.dynamic.api.IActivityDelegator
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
            return dispatchTouchEvent;
        }

        @Override // com.tencent.minibox.loader.stub.StubActivity, com.tencent.minibox.loader.base.DelegatorActivity, com.tencent.minibox.dynamic.api.BaseDelegatorActivity, android.app.Activity, android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            super.onConfigurationChanged(configuration);
            EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/minibox/loader/stub/StubActivity$A03;", "Lcom/tencent/minibox/loader/stub/StubActivity;", "()V", "MiniBoxLoader_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes9.dex */
    public static final class A03 extends StubActivity {
        @Override // com.tencent.minibox.loader.stub.StubActivity, com.tencent.minibox.loader.base.DelegatorActivity, com.tencent.minibox.dynamic.api.BaseDelegatorActivity, android.app.Activity, android.view.Window.Callback, com.tencent.minibox.dynamic.api.IActivityDelegator
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
            return dispatchTouchEvent;
        }

        @Override // com.tencent.minibox.loader.stub.StubActivity, com.tencent.minibox.loader.base.DelegatorActivity, com.tencent.minibox.dynamic.api.BaseDelegatorActivity, android.app.Activity, android.content.ComponentCallbacks
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
