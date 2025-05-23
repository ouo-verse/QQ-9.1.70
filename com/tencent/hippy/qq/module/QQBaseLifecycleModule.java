package com.tencent.hippy.qq.module;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.fragment.HippyActivityLifecycleListener;
import com.tencent.hippy.qq.fragment.HippyActivityLifecycleOwner;
import com.tencent.mtt.hippy.HippyEngineContext;

/* compiled from: P */
/* loaded from: classes7.dex */
public class QQBaseLifecycleModule extends QQBaseModule implements HippyActivityLifecycleListener {
    public QQBaseLifecycleModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
        bindLifecycleListener();
    }

    public final void bindLifecycleListener() {
        HippyActivityLifecycleOwner hippyActivityLifecycleOwner = getHippyActivityLifecycleOwner();
        if (hippyActivityLifecycleOwner != null) {
            hippyActivityLifecycleOwner.getActivityLifecycleDispatcher().addActivityLifecycleListener(this);
        }
    }

    @Override // com.tencent.hippy.qq.module.QQBaseModule, com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase
    public void destroy() {
        super.destroy();
        unbindLifecycleListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HippyActivityLifecycleOwner getHippyActivityLifecycleOwner() {
        HippyQQEngine hippyQQEngine = getHippyQQEngine();
        if (hippyQQEngine == null) {
            return null;
        }
        return hippyQQEngine.getHippyActivityLifecycleOwner();
    }

    public final void unbindLifecycleListener() {
        HippyActivityLifecycleOwner hippyActivityLifecycleOwner = getHippyActivityLifecycleOwner();
        if (hippyActivityLifecycleOwner != null) {
            hippyActivityLifecycleOwner.getActivityLifecycleDispatcher().removeActivityLifecycleListener(this);
        }
    }

    @Override // com.tencent.hippy.qq.fragment.HippyActivityLifecycleListener
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // com.tencent.hippy.qq.fragment.HippyActivityLifecycleListener
    public void onActivityPaused(Activity activity) {
    }

    @Override // com.tencent.hippy.qq.fragment.HippyActivityLifecycleListener
    public void onActivityResumed(Activity activity) {
    }

    @Override // com.tencent.hippy.qq.fragment.HippyActivityLifecycleListener
    public void onActivityStarted(Activity activity) {
    }

    @Override // com.tencent.hippy.qq.fragment.HippyActivityLifecycleListener
    public void onActivityStopped(Activity activity) {
    }

    @Override // com.tencent.hippy.qq.fragment.HippyActivityLifecycleListener
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // com.tencent.hippy.qq.fragment.HippyActivityLifecycleListener
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // com.tencent.hippy.qq.fragment.HippyActivityLifecycleListener
    public void onNewIntent(Activity activity, Intent intent) {
    }

    @Override // com.tencent.hippy.qq.fragment.HippyActivityLifecycleListener
    public void onActivityResult(Activity activity, int i3, int i16, Intent intent) {
    }
}
