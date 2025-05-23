package com.tencent.mtt.hippy;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyAssetBundleLoader;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyFileBundleLoader;
import com.tencent.mtt.hippy.modules.nativemodules.deviceevent.DeviceEventModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
@Deprecated
/* loaded from: classes20.dex */
public abstract class HippyEngineManager extends HippyEngine {
    final HashMap mExtendDatas = new HashMap();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    static class Builder {
        private HippyBundleLoader mCoreBundleLoader;
        private String mDebugJs;
        private HippyGlobalConfigs mGlobalConfigs;
        private List<HippyAPIProvider> mPackages;
        private HippyBundleLoader mPreloadBundleLoader;
        private String mRemoteServerUrl;
        private boolean mSupportDev = false;
        private boolean enableV8Serialization = true;
        private int mGroupId = -1;

        /* JADX INFO: Access modifiers changed from: package-private */
        public HippyEngineManager build() {
            if (this.mCoreBundleLoader == null && !this.mSupportDev) {
                throw new RuntimeException("In non-debug mode, it must be set core bundle loader!");
            }
            if (this.mSupportDev && TextUtils.isEmpty(this.mDebugJs)) {
                throw new RuntimeException("In debug mode, it must be set debug js!");
            }
            if (this.mPackages == null) {
                this.mPackages = new ArrayList();
            }
            HippyEngine.EngineInitParams engineInitParams = new HippyEngine.EngineInitParams();
            this.mGlobalConfigs.toDebug(engineInitParams);
            engineInitParams.debugMode = this.mSupportDev;
            HippyBundleLoader hippyBundleLoader = this.mCoreBundleLoader;
            if (hippyBundleLoader instanceof HippyAssetBundleLoader) {
                engineInitParams.coreJSAssetsPath = hippyBundleLoader.getRawPath();
            } else if (hippyBundleLoader instanceof HippyFileBundleLoader) {
                engineInitParams.coreJSFilePath = hippyBundleLoader.getRawPath();
            } else if (hippyBundleLoader != null) {
                throw new RuntimeException("Hippy: CoreBundleLoader is neither a HippyAssetBundleLoader nor a HippyFileBundleLoader!");
            }
            engineInitParams.providers = this.mPackages;
            engineInitParams.enableV8Serialization = this.enableV8Serialization;
            HippyBundleLoader hippyBundleLoader2 = this.mCoreBundleLoader;
            if (hippyBundleLoader2 != null) {
                engineInitParams.codeCacheTag = hippyBundleLoader2.getCodeCacheTag();
            }
            engineInitParams.groupId = this.mGroupId;
            engineInitParams.remoteServerUrl = this.mRemoteServerUrl;
            engineInitParams.check();
            if (this.mGroupId == -1) {
                return new HippyNormalEngineManager(engineInitParams, this.mPreloadBundleLoader);
            }
            return new HippySingleThreadEngineManager(engineInitParams, this.mPreloadBundleLoader);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder setCoreBundleLoader(HippyBundleLoader hippyBundleLoader) {
            this.mCoreBundleLoader = hippyBundleLoader;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder setDebugJs(String str) {
            this.mDebugJs = str;
            return this;
        }

        Builder setEnableV8Serialization(boolean z16) {
            this.enableV8Serialization = z16;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder setGroupId(int i3) {
            this.mGroupId = i3;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder setHippyGlobalConfigs(HippyGlobalConfigs hippyGlobalConfigs) {
            this.mGlobalConfigs = hippyGlobalConfigs;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder setPackages(List<HippyAPIProvider> list) {
            this.mPackages = list;
            return this;
        }

        Builder setPreloadBundleLoader(HippyBundleLoader hippyBundleLoader) {
            this.mPreloadBundleLoader = hippyBundleLoader;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder setRemoteDebugUrl(String str) {
            this.mRemoteServerUrl = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder setSupportDev(boolean z16) {
            this.mSupportDev = z16;
            return this;
        }
    }

    public void addEngineEventListener(HippyEngine.EngineListener engineListener) {
        if (engineListener != null) {
            listen(engineListener);
        }
    }

    public void destroyInstance(HippyRootView hippyRootView) {
        destroyModule(hippyRootView);
    }

    public abstract HippyEngineContext getCurrentEngineContext();

    public HippyEngine.EngineState getCurrentEngineState() {
        return this.mCurrentState;
    }

    public Object getExtendData(String str) {
        return this.mExtendDatas.get(str);
    }

    public void initEngineInBackground() {
        initEngine(null);
    }

    public abstract HippyRootView loadInstance(HippyRootViewParams hippyRootViewParams);

    public abstract HippyRootView loadInstance(HippyRootViewParams hippyRootViewParams, HippyEngine.ModuleListener moduleListener);

    public abstract HippyRootView loadInstance(HippyRootViewParams hippyRootViewParams, HippyEngine.ModuleListener moduleListener, HippyRootView.OnLoadCompleteListener onLoadCompleteListener);

    public abstract boolean onBackPress(DeviceEventModule.InvokeDefaultBackPress invokeDefaultBackPress);

    public abstract HippyInstanceContext preCreateInstanceContext(Context context);

    public void putExtendData(String str, Object obj) {
        this.mExtendDatas.put(str, obj);
    }

    public void removeEngineEventListener(HippyEngine.EngineListener engineListener) {
        this.mEventListeners.remove(engineListener);
    }

    public void removeExtendData(String str) {
        this.mExtendDatas.remove(str);
    }
}
