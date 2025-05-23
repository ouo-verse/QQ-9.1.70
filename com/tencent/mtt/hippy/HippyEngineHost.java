package com.tencent.mtt.hippy;

import android.app.Application;
import com.tencent.mtt.hippy.HippyEngineManager;
import com.tencent.mtt.hippy.HippyGlobalConfigs;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader;
import com.tencent.mtt.hippy.utils.ContextHolder;
import java.util.List;

/* compiled from: P */
@Deprecated
/* loaded from: classes20.dex */
public abstract class HippyEngineHost {
    private final Application mApplication;

    public HippyEngineHost(Application application) {
        this.mApplication = application;
        ContextHolder.initAppContext(application);
    }

    public HippyEngineManager createDebugHippyEngineManager(String str, String str2) {
        HippyEngineManager.Builder builder = new HippyEngineManager.Builder();
        builder.setHippyGlobalConfigs(getHippyGlobalConfigs()).setCoreBundleLoader(null).setPackages(getPackages()).setSupportDev(true).setDebugJs(str).setGroupId(getGroupId()).setRemoteDebugUrl(str2);
        return builder.build();
    }

    protected boolean enableHippyBufferBridge() {
        return false;
    }

    protected HippyBundleLoader getCoreBundleLoader() {
        return null;
    }

    protected int getGroupId() {
        return -1;
    }

    public HippyGlobalConfigs getHippyGlobalConfigs() {
        return new HippyGlobalConfigs.Builder().setContext(this.mApplication).build();
    }

    protected abstract List<HippyAPIProvider> getPackages();
}
