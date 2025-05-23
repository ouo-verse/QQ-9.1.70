package com.tencent.minibox.loader.delegator;

import android.app.Application;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.minibox.dynamic.api.IActivityDelegate;
import com.tencent.minibox.loader.base.DelegatorActivity;
import com.tencent.minibox.loader.core.a;
import com.tencent.minibox.loader.core.e;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0010\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/minibox/loader/delegator/MiniBoxActivity;", "Lcom/tencent/minibox/loader/base/DelegatorActivity;", "()V", "getActivityImpl", "Lcom/tencent/minibox/dynamic/api/IActivityDelegate;", "getActivityImpl$MiniBoxLoader_release", "MiniBoxLoader_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes9.dex */
public final class MiniBoxActivity extends DelegatorActivity {
    @Override // com.tencent.minibox.loader.base.DelegatorActivity, com.tencent.minibox.dynamic.api.BaseDelegatorActivity, android.app.Activity, android.view.Window.Callback, com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.minibox.loader.base.DelegatorActivity
    @Nullable
    public IActivityDelegate getActivityImpl$MiniBoxLoader_release() {
        if (getMActivityImpl() != null) {
            return getMActivityImpl();
        }
        a aVar = a.f151655b;
        if (!aVar.b()) {
            e.f151663b.b(this);
            aVar.c();
            Application application = getApplication();
            Intrinsics.checkExpressionValueIsNotNull(application, "this.application");
            aVar.d(application, new Bundle());
        }
        setMActivityImpl(aVar.a().getActivityImpl(this));
        return getMActivityImpl();
    }

    @Override // com.tencent.minibox.loader.base.DelegatorActivity, com.tencent.minibox.dynamic.api.BaseDelegatorActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
