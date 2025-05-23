package com.tencent.minibox.loader.base;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.minibox.dynamic.api.BaseDelegatorActivity;
import com.tencent.minibox.dynamic.api.IActivityDelegate;
import com.tencent.minibox.loader.core.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import mqq.app.Constants;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000f\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0010\u00a2\u0006\u0002\b\nJ\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/minibox/loader/base/DelegatorActivity;", "Lcom/tencent/minibox/dynamic/api/BaseDelegatorActivity;", "()V", "mActivityImpl", "Lcom/tencent/minibox/dynamic/api/IActivityDelegate;", "getMActivityImpl", "()Lcom/tencent/minibox/dynamic/api/IActivityDelegate;", "setMActivityImpl", "(Lcom/tencent/minibox/dynamic/api/IActivityDelegate;)V", "getActivityImpl", "getActivityImpl$MiniBoxLoader_release", "onCreate", "", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "MiniBoxLoader_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes9.dex */
public abstract class DelegatorActivity extends BaseDelegatorActivity {

    @Nullable
    private IActivityDelegate mActivityImpl;

    @Override // com.tencent.minibox.dynamic.api.BaseDelegatorActivity, android.app.Activity, android.view.Window.Callback, com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Nullable
    public IActivityDelegate getActivityImpl$MiniBoxLoader_release() {
        if (getMActivityImpl() != null) {
            return getMActivityImpl();
        }
        a aVar = a.f151655b;
        if (!aVar.b()) {
            return null;
        }
        setMActivityImpl(aVar.a().getActivityImpl(this));
        return getMActivityImpl();
    }

    @Nullable
    public IActivityDelegate getMActivityImpl() {
        return this.mActivityImpl;
    }

    @Override // com.tencent.minibox.dynamic.api.BaseDelegatorActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.minibox.dynamic.api.BaseDelegatorActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        injectDelegate(getActivityImpl$MiniBoxLoader_release());
        super.onCreate(savedInstanceState);
    }

    public void setMActivityImpl(@Nullable IActivityDelegate iActivityDelegate) {
        this.mActivityImpl = iActivityDelegate;
    }
}
