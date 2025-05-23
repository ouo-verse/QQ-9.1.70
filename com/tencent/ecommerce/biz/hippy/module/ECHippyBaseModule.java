package com.tencent.ecommerce.biz.hippy.module;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import cg0.a;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.biz.hippy.api.IECHippyEngine;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import kotlin.Metadata;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001 B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0004J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0004J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0004J\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u000bJ\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0004J\u001c\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0017J\u0012\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0017J\u0012\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0017J\u0012\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0017J\u0012\u0010\u0019\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0017J\u0012\u0010\u001a\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0017\u00a8\u0006!"}, d2 = {"Lcom/tencent/ecommerce/biz/hippy/module/ECHippyBaseModule;", "Lcom/tencent/mtt/hippy/modules/nativemodules/HippyNativeModuleBase;", "Landroidx/lifecycle/LifecycleObserver;", "Landroidx/fragment/app/Fragment;", "getFragment", "Landroid/app/Activity;", "getActivity", "Lcom/tencent/ecommerce/biz/hippy/api/IECHippyEngine;", "getHippyEngine", "", "registerLifecycleObserver", "", "unregisterLifecycleObserver", "", AdMetricTag.EVENT_NAME, "Lcom/tencent/mtt/hippy/common/HippyMap;", "hippyMap", "sendEventToJs", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onActivityCreated", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "onActivityDestroyed", "Lcom/tencent/mtt/hippy/HippyEngineContext;", "context", "<init>", "(Lcom/tencent/mtt/hippy/HippyEngineContext;)V", "Companion", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public class ECHippyBaseModule extends HippyNativeModuleBase implements LifecycleObserver {
    private static final String TAG = "ECHippyBaseModule";

    public ECHippyBaseModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Activity getActivity() {
        Fragment fragment = getFragment();
        if (fragment != null) {
            return fragment.getActivity();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Fragment getFragment() {
        IECHippyEngine hippyEngine = getHippyEngine();
        if (hippyEngine != null) {
            return hippyEngine.getCurrentFragment();
        }
        return null;
    }

    protected final IECHippyEngine getHippyEngine() {
        return QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getHippyProxy().getEngine(this.mContext.getEngineId());
    }

    public final boolean registerLifecycleObserver() {
        Fragment fragment = getFragment();
        if (fragment == null) {
            return false;
        }
        if (fragment.getActivity() != null && fragment.requireActivity().isFinishing()) {
            return false;
        }
        fragment.getLifecycle().addObserver(this);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void sendEventToJs(String eventName, HippyMap hippyMap) {
        HippyModuleManager moduleManager;
        EventDispatcher eventDispatcher;
        a.b(TAG, "#sendEventToJs: eventName=" + eventName + ", params=" + hippyMap);
        HippyEngineContext hippyEngineContext = this.mContext;
        if (hippyEngineContext == null || (moduleManager = hippyEngineContext.getModuleManager()) == null || (eventDispatcher = (EventDispatcher) moduleManager.getJavaScriptModule(EventDispatcher.class)) == null) {
            return;
        }
        eventDispatcher.receiveNativeEvent(eventName, hippyMap);
    }

    public final void unregisterLifecycleObserver() {
        Lifecycle lifecycle;
        Fragment fragment = getFragment();
        if (fragment == null || (lifecycle = fragment.getLifecycle()) == null) {
            return;
        }
        lifecycle.removeObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onActivityDestroyed(Activity activity) {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onActivityPaused(Activity activity) {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onActivityResumed(Activity activity) {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onActivityStarted(Activity activity) {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onActivityStopped(Activity activity) {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
    }
}
