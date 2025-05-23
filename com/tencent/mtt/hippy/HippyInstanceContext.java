package com.tencent.mtt.hippy;

import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyAssetBundleLoader;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyFileBundleLoader;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.supportui.utils.struct.WeakEventHub;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class HippyInstanceContext extends ContextWrapper {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "HippyInstanceContext";
    private HippyBundleLoader mBundleLoader;
    private WeakEventHub<InstanceDestroyListener> mDestroyListeners;
    private HippyEngineContext mEngineContext;
    HippyEngine mHippyEngineManager;
    HippyEngine.ModuleLoadParams mModuleParams;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface InstanceDestroyListener {
        void onInstanceDestroy();
    }

    public HippyInstanceContext(Context context) {
        super(context);
        this.mDestroyListeners = new WeakEventHub<>();
    }

    public void attachEngineManager(HippyEngine hippyEngine) {
        this.mHippyEngineManager = hippyEngine;
    }

    public HippyBundleLoader getBundleLoader() {
        return this.mBundleLoader;
    }

    public HippyEngineContext getEngineContext() {
        return this.mEngineContext;
    }

    public HippyEngine getEngineManager() {
        return this.mHippyEngineManager;
    }

    public HippyEngine.ModuleLoadParams getModuleParams() {
        return this.mModuleParams;
    }

    public Map getNativeParams() {
        HippyEngine.ModuleLoadParams moduleLoadParams = this.mModuleParams;
        if (moduleLoadParams != null) {
            return moduleLoadParams.nativeParams;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyInstanceDestroy() {
        WeakEventHub<InstanceDestroyListener> weakEventHub = this.mDestroyListeners;
        if (weakEventHub != null && weakEventHub.size() > 0) {
            for (InstanceDestroyListener instanceDestroyListener : this.mDestroyListeners.getNotifyListeners()) {
                if (instanceDestroyListener != null) {
                    try {
                        instanceDestroyListener.onInstanceDestroy();
                    } catch (Exception e16) {
                        LogUtils.e(TAG, "notifyInstanceDestroy: " + e16);
                    }
                }
            }
        }
        this.mDestroyListeners = null;
    }

    public void registerInstanceDestroyListener(InstanceDestroyListener instanceDestroyListener) {
        WeakEventHub<InstanceDestroyListener> weakEventHub;
        if (instanceDestroyListener != null && (weakEventHub = this.mDestroyListeners) != null) {
            weakEventHub.registerListener(instanceDestroyListener);
        }
    }

    public void setEngineContext(HippyEngineContext hippyEngineContext) {
        this.mEngineContext = hippyEngineContext;
    }

    public void setModuleParams(HippyEngine.ModuleLoadParams moduleLoadParams) {
        HippyBundleLoader hippyFileBundleLoader;
        this.mModuleParams = moduleLoadParams;
        if (moduleLoadParams == null || (hippyFileBundleLoader = moduleLoadParams.bundleLoader) == null) {
            if (!TextUtils.isEmpty(moduleLoadParams.jsAssetsPath)) {
                hippyFileBundleLoader = new HippyAssetBundleLoader(moduleLoadParams.context, moduleLoadParams.jsAssetsPath, !TextUtils.isEmpty(moduleLoadParams.codeCacheTag), moduleLoadParams.codeCacheTag);
            } else if (!TextUtils.isEmpty(moduleLoadParams.jsFilePath)) {
                hippyFileBundleLoader = new HippyFileBundleLoader(moduleLoadParams.jsFilePath, !TextUtils.isEmpty(moduleLoadParams.codeCacheTag), moduleLoadParams.codeCacheTag);
            } else {
                return;
            }
        }
        this.mBundleLoader = hippyFileBundleLoader;
    }

    public void unregisterInstanceDestroyListener(InstanceDestroyListener instanceDestroyListener) {
        WeakEventHub<InstanceDestroyListener> weakEventHub;
        if (instanceDestroyListener != null && (weakEventHub = this.mDestroyListeners) != null) {
            weakEventHub.unregisterListener(instanceDestroyListener);
        }
    }

    public HippyInstanceContext(Context context, HippyEngine.ModuleLoadParams moduleLoadParams) {
        super(context);
        setModuleParams(moduleLoadParams);
        this.mDestroyListeners = new WeakEventHub<>();
    }
}
