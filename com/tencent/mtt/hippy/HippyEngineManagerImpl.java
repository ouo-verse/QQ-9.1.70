package com.tencent.mtt.hippy;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.a.h;
import com.tencent.mtt.hippy.a.o;
import com.tencent.mtt.hippy.adapter.exception.HippyExceptionHandlerAdapter;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.mtt.hippy.adapter.thirdparty.HippyThirdPartyAdapter;
import com.tencent.mtt.hippy.bridge.a;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyAssetBundleLoader;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyFileBundleLoader;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyRemoteBundleLoader;
import com.tencent.mtt.hippy.common.Callback;
import com.tencent.mtt.hippy.common.HippyJsException;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.common.ThreadExecutor;
import com.tencent.mtt.hippy.dom.b;
import com.tencent.mtt.hippy.dom.node.DomNodeRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.HippyModuleManagerImpl;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.mtt.hippy.modules.nativemodules.deviceevent.DeviceEventModule;
import com.tencent.mtt.hippy.uimanager.RenderManager;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.TimeMonitor;
import com.tencent.mtt.hippy.utils.UIThreadUtils;
import com.tencent.mtt.hippy.v8.V8;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes20.dex */
public abstract class HippyEngineManagerImpl extends HippyEngineManager implements HippyRootView.OnResumeAndPauseListener, HippyRootView.OnSizeChangedListener, h, ThreadExecutor.UncaughtExceptionHandler {
    static final int MSG_ENGINE_INIT_TIMEOUT = 100;
    static final String TAG = "HippyEngineManagerImpl";
    final boolean enableV8Serialization;
    final List<HippyAPIProvider> mAPIProviders;
    HippyBundleLoader mCoreBundleLoader;
    private final String mDebugComponentName;
    final boolean mDebugMode;
    o mDevSupportManager;
    final IDomOperate mDomOperateInterceptor;
    HippyEngineContextImpl mEngineContext;
    final HippyGlobalConfigs mGlobalConfigs;
    V8 mHippyV8;
    final HippyBundleLoader mPreloadBundleLoader;
    private final String mRemoteServerUrl;
    final boolean mRunningOnTVPlatform;
    final String mServerBundleName;
    private final String mServerHost;
    final TimeMonitor mStartTimeMonitor;
    private final HippyThirdPartyAdapter mThirdPartyAdapter;
    private final HippyEngine.V8InitParams v8InitParams;
    final CopyOnWriteArrayList<HippyRootView> mInstances = new CopyOnWriteArrayList<>();
    boolean mDevManagerInited = false;
    boolean mHasReportEngineLoadResult = false;
    private Object mRestoreSyncObject = new Object();
    private boolean mRestoreSucceed = false;
    final Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.tencent.mtt.hippy.HippyEngineManagerImpl.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 100) {
                HippyEngineManagerImpl.this.reportEngineLoadResult(2, null);
            }
            super.handleMessage(message);
        }
    };

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class HippyEngineContextImpl implements HippyEngineContext {
        private final a mBridgeManager;
        private String mComponentName;
        private final b mDomManager = new b(this);
        private IDomOperate mDomOperateInterceptor;
        volatile CopyOnWriteArrayList<HippyEngineLifecycleEventListener> mEngineLifecycleEventListeners;
        volatile CopyOnWriteArrayList<HippyInstanceLifecycleEventListener> mInstanceLifecycleEventListeners;
        private final HippyModuleManager mModuleManager;
        private Map<String, Object> mNativeParams;
        final RenderManager mRenderManager;

        public HippyEngineContextImpl(boolean z16, String str, IDomOperate iDomOperate) {
            this.mModuleManager = new HippyModuleManagerImpl(this, HippyEngineManagerImpl.this.mAPIProviders);
            this.mBridgeManager = new com.tencent.mtt.hippy.bridge.b(this, HippyEngineManagerImpl.this.mCoreBundleLoader, HippyEngineManagerImpl.this.getBridgeType(), HippyEngineManagerImpl.this.enableV8Serialization, z16, str, HippyEngineManagerImpl.this.mGroupId, HippyEngineManagerImpl.this.mThirdPartyAdapter, HippyEngineManagerImpl.this.v8InitParams);
            this.mRenderManager = new RenderManager(this, HippyEngineManagerImpl.this.mAPIProviders);
            this.mDomOperateInterceptor = iDomOperate;
        }

        @Override // com.tencent.mtt.hippy.HippyEngineContext
        public void addApiProviders(List<HippyAPIProvider> list) {
            this.mModuleManager.addModules(list);
            this.mRenderManager.getControllerManager().a(list);
        }

        @Override // com.tencent.mtt.hippy.HippyEngineContext
        public void addEngineLifecycleEventListener(HippyEngineLifecycleEventListener hippyEngineLifecycleEventListener) {
            if (this.mEngineLifecycleEventListeners == null) {
                synchronized (HippyEngineContextImpl.class) {
                    if (this.mEngineLifecycleEventListeners == null) {
                        this.mEngineLifecycleEventListeners = new CopyOnWriteArrayList<>();
                    }
                }
            }
            this.mEngineLifecycleEventListeners.add(hippyEngineLifecycleEventListener);
        }

        @Override // com.tencent.mtt.hippy.HippyEngineContext
        public void addInstanceLifecycleEventListener(HippyInstanceLifecycleEventListener hippyInstanceLifecycleEventListener) {
            if (this.mInstanceLifecycleEventListeners == null) {
                synchronized (HippyEngineContextImpl.class) {
                    if (this.mInstanceLifecycleEventListeners == null) {
                        this.mInstanceLifecycleEventListeners = new CopyOnWriteArrayList<>();
                    }
                }
            }
            this.mInstanceLifecycleEventListeners.add(hippyInstanceLifecycleEventListener);
        }

        public void destroy() {
            a aVar = this.mBridgeManager;
            if (aVar != null) {
                aVar.a();
            }
            HippyModuleManager hippyModuleManager = this.mModuleManager;
            if (hippyModuleManager != null) {
                hippyModuleManager.destroy();
            }
            b bVar = this.mDomManager;
            if (bVar != null) {
                bVar.b();
            }
            RenderManager renderManager = this.mRenderManager;
            if (renderManager != null) {
                renderManager.a();
            }
            if (this.mInstanceLifecycleEventListeners != null) {
                this.mInstanceLifecycleEventListeners.clear();
            }
            if (this.mEngineLifecycleEventListeners != null) {
                this.mEngineLifecycleEventListeners.clear();
            }
            Map<String, Object> map = this.mNativeParams;
            if (map != null) {
                map.clear();
            }
        }

        public void destroyBridge(Callback<Boolean> callback, boolean z16) {
            this.mBridgeManager.a(callback, z16);
        }

        @Override // com.tencent.mtt.hippy.HippyEngineContext
        public a getBridgeManager() {
            return this.mBridgeManager;
        }

        @Override // com.tencent.mtt.hippy.HippyEngineContext
        public String getComponentName() {
            return this.mComponentName;
        }

        @Override // com.tencent.mtt.hippy.HippyEngineContext
        public o getDevSupportManager() {
            return HippyEngineManagerImpl.this.mDevSupportManager;
        }

        @Override // com.tencent.mtt.hippy.HippyEngineContext
        public b getDomManager() {
            return this.mDomManager;
        }

        @Override // com.tencent.mtt.hippy.HippyEngineContext
        public IDomOperate getDomOperateInterceptor() {
            return this.mDomOperateInterceptor;
        }

        @Override // com.tencent.mtt.hippy.HippyEngineContext
        public int getEngineId() {
            return HippyEngineManagerImpl.this.getId();
        }

        @Override // com.tencent.mtt.hippy.HippyEngineContext
        public HippyGlobalConfigs getGlobalConfigs() {
            return HippyEngineManagerImpl.this.mGlobalConfigs;
        }

        @Override // com.tencent.mtt.hippy.HippyEngineContext
        public HippyRootView getInstance(int i3) {
            Iterator<HippyRootView> it = HippyEngineManagerImpl.this.mInstances.iterator();
            while (it.hasNext()) {
                HippyRootView next = it.next();
                if (next.getId() == i3) {
                    return next;
                }
            }
            return null;
        }

        @Override // com.tencent.mtt.hippy.HippyEngineContext
        public HippyModuleManager getModuleManager() {
            return this.mModuleManager;
        }

        @Override // com.tencent.mtt.hippy.HippyEngineContext
        @Nullable
        public Map<String, Object> getNativeParams() {
            return this.mNativeParams;
        }

        @Override // com.tencent.mtt.hippy.HippyEngineContext
        public RenderManager getRenderManager() {
            return this.mRenderManager;
        }

        @Override // com.tencent.mtt.hippy.HippyEngineContext
        public TimeMonitor getStartTimeMonitor() {
            return HippyEngineManagerImpl.this.mStartTimeMonitor;
        }

        @Override // com.tencent.mtt.hippy.HippyEngineContext
        public ThreadExecutor getThreadExecutor() {
            return HippyEngineManagerImpl.this.getThreadExecutor();
        }

        @Override // com.tencent.mtt.hippy.HippyEngineContext
        public void handleException(Throwable th5) {
            o oVar;
            HippyEngineManagerImpl hippyEngineManagerImpl = HippyEngineManagerImpl.this;
            if (hippyEngineManagerImpl.mDebugMode && (oVar = hippyEngineManagerImpl.mDevSupportManager) != null) {
                oVar.a(th5);
                return;
            }
            boolean z16 = th5 instanceof HippyJsException;
            HippyExceptionHandlerAdapter exceptionHandler = hippyEngineManagerImpl.mGlobalConfigs.getExceptionHandler();
            if (z16) {
                HippyJsException hippyJsException = (HippyJsException) th5;
                exceptionHandler.handleJsException(hippyJsException);
                HippyEngineManagerImpl.this.mEngineContext.getBridgeManager().a(hippyJsException);
                return;
            }
            exceptionHandler.handleNativeException(new RuntimeException(th5), true);
        }

        @Override // com.tencent.mtt.hippy.HippyEngineContext
        public boolean isRunningOnTVPlatform() {
            return HippyEngineManagerImpl.this.mRunningOnTVPlatform;
        }

        @Override // com.tencent.mtt.hippy.HippyEngineContext
        public void removeEngineLifecycleEventListener(HippyEngineLifecycleEventListener hippyEngineLifecycleEventListener) {
            if (this.mEngineLifecycleEventListeners != null) {
                this.mEngineLifecycleEventListeners.remove(hippyEngineLifecycleEventListener);
            }
        }

        @Override // com.tencent.mtt.hippy.HippyEngineContext
        public void removeInstanceLifecycleEventListener(HippyInstanceLifecycleEventListener hippyInstanceLifecycleEventListener) {
            if (this.mInstanceLifecycleEventListeners != null) {
                this.mInstanceLifecycleEventListeners.remove(hippyInstanceLifecycleEventListener);
            }
        }

        void runScript(@NonNull String str) {
            this.mBridgeManager.a(str);
        }

        public void setComponentName(String str) {
            this.mComponentName = str;
        }

        public void setNativeParams(Map<String, Object> map) {
            this.mNativeParams = map;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HippyEngineManagerImpl(HippyEngine.EngineInitParams engineInitParams, HippyBundleLoader hippyBundleLoader) {
        HippyBundleLoader hippyBundleLoader2;
        String str;
        if (!TextUtils.isEmpty(engineInitParams.coreJSAssetsPath)) {
            hippyBundleLoader2 = new HippyAssetBundleLoader(engineInitParams.context, engineInitParams.coreJSAssetsPath, !TextUtils.isEmpty(engineInitParams.codeCacheTag), engineInitParams.codeCacheTag);
        } else if (!TextUtils.isEmpty(engineInitParams.coreJSFilePath)) {
            hippyBundleLoader2 = new HippyFileBundleLoader(engineInitParams.coreJSFilePath, !TextUtils.isEmpty(engineInitParams.codeCacheTag), engineInitParams.codeCacheTag);
        } else {
            hippyBundleLoader2 = null;
        }
        this.mGlobalConfigs = new HippyGlobalConfigs(engineInitParams);
        this.mCoreBundleLoader = hippyBundleLoader2;
        this.mPreloadBundleLoader = hippyBundleLoader;
        this.mAPIProviders = engineInitParams.providers;
        boolean z16 = engineInitParams.debugMode;
        this.mDebugMode = z16;
        if (z16) {
            str = engineInitParams.debugBundleName;
        } else {
            str = "";
        }
        this.mServerBundleName = str;
        this.mStartTimeMonitor = new TimeMonitor(!z16);
        this.enableV8Serialization = engineInitParams.enableV8Serialization;
        this.mServerHost = engineInitParams.debugServerHost;
        this.mDebugComponentName = engineInitParams.debugComponentName;
        this.mRemoteServerUrl = engineInitParams.remoteServerUrl;
        this.mGroupId = engineInitParams.groupId;
        this.mThirdPartyAdapter = engineInitParams.thirdPartyAdapter;
        this.v8InitParams = engineInitParams.v8InitParams;
        this.mRunningOnTVPlatform = engineInitParams.runningOnTVPlatform;
        this.mDomOperateInterceptor = engineInitParams.domOperateInterceptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addNodeRecordOfChild(ArrayList<DomNodeRecord> arrayList, com.tencent.mtt.hippy.dom.node.b bVar, int i3, int i16) {
        int childCount = bVar.getChildCount();
        for (int i17 = 0; i17 < childCount; i17++) {
            com.tencent.mtt.hippy.dom.node.b childAt = bVar.getChildAt(i17);
            if (childAt != null) {
                DomNodeRecord domNodeRecord = new DomNodeRecord();
                domNodeRecord.rootId = i16;
                domNodeRecord.f337371id = childAt.getId();
                domNodeRecord.index = i17;
                domNodeRecord.pid = bVar.getId();
                domNodeRecord.className = childAt.getViewClass();
                domNodeRecord.props = childAt.getTotalProps();
                arrayList.add(domNodeRecord);
                addNodeRecordOfChild(arrayList, childAt, i17, i16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void internalLoadInstance(HippyRootView hippyRootView) {
        HippyEngine.ModuleLoadStatus moduleLoadStatus;
        String str;
        if (this.mEngineContext != null && hippyRootView != null) {
            LogUtils.d(TAG, "in internalLoadInstance");
            if (this.mEngineContext.mInstanceLifecycleEventListeners != null) {
                Iterator<HippyInstanceLifecycleEventListener> it = this.mEngineContext.mInstanceLifecycleEventListeners.iterator();
                while (it.hasNext()) {
                    it.next().onInstanceLoad(hippyRootView.getId());
                }
            }
            hippyRootView.attachToEngine(this.mEngineContext);
            HippyMap launchParams = hippyRootView.getLaunchParams();
            HippyBundleLoader bundleLoader = ((HippyInstanceContext) hippyRootView.getContext()).getBundleLoader();
            if (!this.mDebugMode) {
                if (bundleLoader != null) {
                    if (hippyRootView.getTimeMonitor() != null) {
                        hippyRootView.getTimeMonitor().startEvent(HippyEngineMonitorEvent.MODULE_LOAD_EVENT_WAIT_LOAD_BUNDLE);
                    }
                    this.mEngineContext.getBridgeManager().a(hippyRootView.getId(), bundleLoader, this.mModuleListener, hippyRootView);
                } else {
                    moduleLoadStatus = HippyEngine.ModuleLoadStatus.STATUS_VARIABLE_NULL;
                    str = "load module error. loader==null";
                }
            }
            LogUtils.d(TAG, "in internalLoadInstance before loadInstance");
            this.mEngineContext.getBridgeManager().a(hippyRootView.getName(), hippyRootView.getId(), launchParams);
            if (this.mDebugMode) {
                notifyModuleLoaded(HippyEngine.ModuleLoadStatus.STATUS_OK, null, hippyRootView);
                return;
            }
            return;
        }
        moduleLoadStatus = HippyEngine.ModuleLoadStatus.STATUS_VARIABLE_NULL;
        str = "load module error. mEngineContext=" + this.mEngineContext + ", HippyRootView instance=" + hippyRootView;
        notifyModuleLoaded(moduleLoadStatus, str, hippyRootView);
    }

    private void notifyModuleLoaded(final HippyEngine.ModuleLoadStatus moduleLoadStatus, final String str, final HippyRootView hippyRootView) {
        if (this.mModuleListener != null) {
            if (UIThreadUtils.isOnUiThread()) {
                HippyEngine.ModuleListener moduleListener = this.mModuleListener;
                if (moduleListener != null) {
                    moduleListener.onLoadCompleted(moduleLoadStatus, str, hippyRootView);
                    this.mModuleListener = null;
                    return;
                }
                return;
            }
            UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mtt.hippy.HippyEngineManagerImpl.8
                @Override // java.lang.Runnable
                public void run() {
                    HippyEngine.ModuleListener moduleListener2 = HippyEngineManagerImpl.this.mModuleListener;
                    if (moduleListener2 != null) {
                        moduleListener2.onLoadCompleted(moduleLoadStatus, str, hippyRootView);
                        HippyEngineManagerImpl.this.mModuleListener = null;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportEngineLoadResult(int i3, Throwable th5) {
        this.mHandler.removeMessages(100);
        if (!this.mDebugMode && !this.mHasReportEngineLoadResult) {
            this.mHasReportEngineLoadResult = true;
            this.mGlobalConfigs.getEngineMonitorAdapter().reportEngineLoadResult(i3, this.mStartTimeMonitor.getTotalTime(), this.mStartTimeMonitor.getEvents(), th5);
        }
    }

    private void resetEngine() {
        HippyEngineContextImpl hippyEngineContextImpl = this.mEngineContext;
        if (hippyEngineContextImpl != null) {
            hippyEngineContextImpl.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void restartEngineInBackground() {
        if (this.mCurrentState == HippyEngine.EngineState.DESTROYED) {
            String str = "restartEngineInBackground... error STATUS_WRONG_STATE, state=" + this.mCurrentState;
            LogUtils.e(TAG, str);
            notifyEngineInitialized(HippyEngine.EngineInitStatus.STATUS_WRONG_STATE, new Throwable(str));
            return;
        }
        this.mStartTimeMonitor.begine();
        this.mStartTimeMonitor.startEvent(HippyEngineMonitorEvent.ENGINE_LOAD_EVENT_INIT_INSTANCE);
        if (this.mCurrentState != HippyEngine.EngineState.INITING) {
            this.mCurrentState = HippyEngine.EngineState.ONRESTART;
        }
        resetEngine();
        HippyEngineContextImpl hippyEngineContextImpl = new HippyEngineContextImpl(this.mDebugMode, this.mServerHost, this.mDomOperateInterceptor);
        this.mEngineContext = hippyEngineContextImpl;
        hippyEngineContextImpl.getBridgeManager().a(new Callback<Boolean>() { // from class: com.tencent.mtt.hippy.HippyEngineManagerImpl.10
            @Override // com.tencent.mtt.hippy.common.Callback
            public void callback(Boolean bool, Throwable th5) {
                if (HippyEngineManagerImpl.this.mCurrentState != HippyEngine.EngineState.INITING && HippyEngineManagerImpl.this.mCurrentState != HippyEngine.EngineState.ONRESTART) {
                    LogUtils.e(HippyEngineManagerImpl.TAG, "initBridge callback error STATUS_WRONG_STATE, state=" + HippyEngineManagerImpl.this.mCurrentState);
                    HippyEngineManagerImpl.this.notifyEngineInitialized(HippyEngine.EngineInitStatus.STATUS_WRONG_STATE, th5);
                    return;
                }
                HippyEngineManagerImpl.this.mStartTimeMonitor.startEvent(HippyEngineMonitorEvent.ENGINE_LOAD_EVENT_NOTIFY_ENGINE_INITED);
                Iterator<HippyRootView> it = HippyEngineManagerImpl.this.mInstances.iterator();
                while (it.hasNext()) {
                    HippyEngineManagerImpl.this.internalLoadInstance(it.next());
                }
                HippyEngine.EngineState engineState = HippyEngineManagerImpl.this.mCurrentState;
                HippyEngineManagerImpl.this.mCurrentState = bool.booleanValue() ? HippyEngine.EngineState.INITED : HippyEngine.EngineState.INITERRORED;
                if (engineState != HippyEngine.EngineState.ONRESTART) {
                    HippyEngineManagerImpl.this.notifyEngineInitialized(bool.booleanValue() ? HippyEngine.EngineInitStatus.STATUS_OK : HippyEngine.EngineInitStatus.STATUS_ERR_BRIDGE, th5);
                    return;
                }
                LogUtils.e(HippyEngineManagerImpl.TAG, "initBridge callback error STATUS_WRONG_STATE, state=" + HippyEngineManagerImpl.this.mCurrentState);
                HippyEngineManagerImpl.this.notifyEngineInitialized(HippyEngine.EngineInitStatus.STATUS_WRONG_STATE, th5);
                HippyEngineManagerImpl.this.mStartTimeMonitor.end();
            }
        });
    }

    @Override // com.tencent.mtt.hippy.HippyEngine
    public void destroyEngine() {
        HippyEngineContextImpl hippyEngineContextImpl = this.mEngineContext;
        if (hippyEngineContextImpl == null) {
            return;
        }
        hippyEngineContextImpl.destroyBridge(new Callback<Boolean>() { // from class: com.tencent.mtt.hippy.HippyEngineManagerImpl.2
            @Override // com.tencent.mtt.hippy.common.Callback
            public void callback(Boolean bool, Throwable th5) {
                UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mtt.hippy.HippyEngineManagerImpl.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        HippyEngineManagerImpl.this.onDestroy();
                    }
                });
            }
        }, false);
    }

    @Override // com.tencent.mtt.hippy.HippyEngine
    public void destroyInstanceState(HippyRootView hippyRootView) {
        if (hippyRootView != null && this.mEngineContext != null) {
            hippyRootView.setOnSizeChangedListener(null);
            final int id5 = hippyRootView.getId();
            final b domManager = this.mEngineContext.getDomManager();
            getThreadExecutor().postOnDomThread(new Runnable() { // from class: com.tencent.mtt.hippy.HippyEngineManagerImpl.7
                @Override // java.lang.Runnable
                public void run() {
                    domManager.d(id5);
                }
            });
            if (this.mInstances.contains(hippyRootView)) {
                this.mInstances.remove(hippyRootView);
            }
        }
    }

    @Override // com.tencent.mtt.hippy.HippyEngine
    public void destroyModule(HippyRootView hippyRootView) {
        if (hippyRootView != null && this.mInstances.contains(hippyRootView)) {
            hippyRootView.setOnResumeAndPauseListener(null);
            hippyRootView.setOnSizeChangedListener(null);
            o oVar = this.mDevSupportManager;
            if (oVar != null) {
                oVar.b(hippyRootView);
            }
            HippyEngineContextImpl hippyEngineContextImpl = this.mEngineContext;
            if (hippyEngineContextImpl != null && hippyEngineContextImpl.getBridgeManager() != null) {
                this.mEngineContext.getBridgeManager().c(hippyRootView.getId());
            }
            HippyEngineContextImpl hippyEngineContextImpl2 = this.mEngineContext;
            if (hippyEngineContextImpl2 != null && hippyEngineContextImpl2.mInstanceLifecycleEventListeners != null) {
                Iterator<HippyInstanceLifecycleEventListener> it = this.mEngineContext.mInstanceLifecycleEventListeners.iterator();
                while (it.hasNext()) {
                    it.next().onInstanceDestroy(hippyRootView.getId());
                }
            }
            hippyRootView.destroy();
            this.mInstances.remove(hippyRootView);
        }
    }

    public abstract int getBridgeType();

    public abstract ThreadExecutor getThreadExecutor();

    @Override // com.tencent.mtt.hippy.HippyEngine
    public V8 getV8() {
        HippyEngineContextImpl hippyEngineContextImpl = this.mEngineContext;
        if (hippyEngineContextImpl == null) {
            return null;
        }
        if (this.mHippyV8 == null) {
            long b16 = hippyEngineContextImpl.getBridgeManager().b();
            if (b16 != -1) {
                this.mHippyV8 = new V8(b16);
            }
        }
        return this.mHippyV8;
    }

    @Override // com.tencent.mtt.hippy.common.ThreadExecutor.UncaughtExceptionHandler
    public void handleThreadUncaughtException(Thread thread, Throwable th5, Integer num) {
        o oVar;
        if (this.mDebugMode && (oVar = this.mDevSupportManager) != null) {
            oVar.a(th5);
        } else {
            this.mGlobalConfigs.getExceptionHandler().handleNativeException(new RuntimeException(th5), false);
        }
    }

    @Override // com.tencent.mtt.hippy.HippyEngine
    public void initEngine(HippyEngine.EngineListener engineListener) {
        if (this.mCurrentState != HippyEngine.EngineState.UNINIT) {
            if (engineListener != null) {
                listen(engineListener);
                return;
            }
            return;
        }
        this.mCurrentState = HippyEngine.EngineState.INITING;
        if (engineListener != null) {
            this.mEventListeners.add(engineListener);
        }
        this.mGlobalConfigs.getEngineMonitorAdapter().reportEngineLoadStart();
        this.mHandler.removeMessages(100);
        try {
            o oVar = new o(this.mGlobalConfigs, this.mDebugMode, this.mServerHost, this.mServerBundleName, this.mRemoteServerUrl);
            this.mDevSupportManager = oVar;
            oVar.a(this);
            if (this.mDebugMode) {
                this.mDevSupportManager.c(this.mDebugComponentName);
                HippyRemoteBundleLoader hippyRemoteBundleLoader = new HippyRemoteBundleLoader(this.mDevSupportManager.a(this.mServerBundleName));
                this.mCoreBundleLoader = hippyRemoteBundleLoader;
                hippyRemoteBundleLoader.setIsDebugMode(true);
            }
            LogUtils.d(TAG, "start restartEngineInBackground...");
            restartEngineInBackground();
        } catch (Throwable th5) {
            this.mCurrentState = HippyEngine.EngineState.INITERRORED;
            notifyEngineInitialized(HippyEngine.EngineInitStatus.STATUS_INIT_EXCEPTION, th5);
        }
    }

    @Override // com.tencent.mtt.hippy.HippyEngine
    public boolean isDebugMode() {
        return this.mDebugMode;
    }

    @Override // com.tencent.mtt.hippy.HippyEngineManager
    @Deprecated
    public HippyRootView loadInstance(HippyRootViewParams hippyRootViewParams) {
        return loadInstance(hippyRootViewParams, null, null);
    }

    @Override // com.tencent.mtt.hippy.HippyEngine
    public HippyRootView loadModule(HippyEngine.ModuleLoadParams moduleLoadParams) {
        return loadModule(moduleLoadParams, null, null);
    }

    void notifyEngineInitialized(final HippyEngine.EngineInitStatus engineInitStatus, final Throwable th5) {
        int i3;
        String th6;
        this.mHandler.removeMessages(100);
        if (this.mPreloadBundleLoader != null) {
            LogUtils.d(TAG, "preload bundle loader");
            preloadModule(this.mPreloadBundleLoader);
        }
        if (UIThreadUtils.isOnUiThread()) {
            this.mStartTimeMonitor.end();
            if (this.mCurrentState == HippyEngine.EngineState.INITED) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            reportEngineLoadResult(i3, th5);
            Iterator<HippyEngine.EngineListener> it = this.mEventListeners.iterator();
            while (it.hasNext()) {
                HippyEngine.EngineListener next = it.next();
                if (th5 == null) {
                    th6 = null;
                } else {
                    th6 = th5.toString();
                }
                next.onInitialized(engineInitStatus, th6);
            }
            this.mEventListeners.clear();
            return;
        }
        UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mtt.hippy.HippyEngineManagerImpl.9
            @Override // java.lang.Runnable
            public void run() {
                String th7;
                int i16;
                if (HippyEngineManagerImpl.this.mCurrentState != HippyEngine.EngineState.DESTROYED) {
                    HippyEngineManagerImpl.this.mStartTimeMonitor.end();
                    HippyEngineManagerImpl hippyEngineManagerImpl = HippyEngineManagerImpl.this;
                    if (hippyEngineManagerImpl.mCurrentState == HippyEngine.EngineState.INITED) {
                        i16 = 0;
                    } else {
                        i16 = 1;
                    }
                    hippyEngineManagerImpl.reportEngineLoadResult(i16, th5);
                }
                Iterator<HippyEngine.EngineListener> it5 = HippyEngineManagerImpl.this.mEventListeners.iterator();
                while (it5.hasNext()) {
                    HippyEngine.EngineListener next2 = it5.next();
                    HippyEngine.EngineInitStatus engineInitStatus2 = engineInitStatus;
                    Throwable th8 = th5;
                    if (th8 == null) {
                        th7 = null;
                    } else {
                        th7 = th8.toString();
                    }
                    next2.onInitialized(engineInitStatus2, th7);
                }
                HippyEngineManagerImpl.this.mEventListeners.clear();
            }
        });
    }

    @Override // com.tencent.mtt.hippy.HippyEngineManager
    public boolean onBackPress(final DeviceEventModule.InvokeDefaultBackPress invokeDefaultBackPress) {
        return onBackPressed(new HippyEngine.BackPressHandler() { // from class: com.tencent.mtt.hippy.HippyEngineManagerImpl.4
            @Override // com.tencent.mtt.hippy.HippyEngine.BackPressHandler
            public void handleBackPress() {
                DeviceEventModule.InvokeDefaultBackPress invokeDefaultBackPress2 = invokeDefaultBackPress;
                if (invokeDefaultBackPress2 != null) {
                    invokeDefaultBackPress2.callSuperOnBackPress();
                }
            }
        });
    }

    @Override // com.tencent.mtt.hippy.HippyEngine
    public boolean onBackPressed(HippyEngine.BackPressHandler backPressHandler) {
        HippyEngineContextImpl hippyEngineContextImpl = this.mEngineContext;
        if (hippyEngineContextImpl != null && hippyEngineContextImpl.getModuleManager().getNativeModule(DeviceEventModule.class) != null) {
            return ((DeviceEventModule) this.mEngineContext.getModuleManager().getNativeModule(DeviceEventModule.class)).onBackPressed(backPressHandler);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        this.mCurrentState = HippyEngine.EngineState.DESTROYED;
        Iterator<HippyRootView> it = this.mInstances.iterator();
        while (it.hasNext()) {
            destroyInstance(it.next());
        }
        this.mEventListeners.clear();
        resetEngine();
        HippyGlobalConfigs hippyGlobalConfigs = this.mGlobalConfigs;
        if (hippyGlobalConfigs != null) {
            hippyGlobalConfigs.destroyIfNeed();
        }
        this.mExtendDatas.clear();
    }

    @Override // com.tencent.mtt.hippy.a.h
    public void onDevBundleReLoad() {
        this.mEngineContext.destroyBridge(new Callback<Boolean>() { // from class: com.tencent.mtt.hippy.HippyEngineManagerImpl.11
            @Override // com.tencent.mtt.hippy.common.Callback
            public void callback(Boolean bool, Throwable th5) {
                UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mtt.hippy.HippyEngineManagerImpl.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        HippyEngineManagerImpl.this.restartEngineInBackground();
                    }
                });
            }
        }, true);
    }

    @Override // com.tencent.mtt.hippy.HippyEngine
    public void onEnginePause() {
        HippyEngineContextImpl hippyEngineContextImpl = this.mEngineContext;
        if (hippyEngineContextImpl != null && hippyEngineContextImpl.mEngineLifecycleEventListeners != null) {
            Iterator<HippyRootView> it = this.mInstances.iterator();
            while (it.hasNext()) {
                it.next().onPause();
            }
            b domManager = this.mEngineContext.getDomManager();
            if (domManager != null) {
                domManager.onEnginePause();
            }
            Iterator<HippyEngineLifecycleEventListener> it5 = this.mEngineContext.mEngineLifecycleEventListeners.iterator();
            while (it5.hasNext()) {
                HippyEngineLifecycleEventListener next = it5.next();
                if (!(next instanceof b)) {
                    next.onEnginePause();
                }
            }
        }
    }

    @Override // com.tencent.mtt.hippy.HippyEngine
    public void onEngineResume() {
        HippyEngineContextImpl hippyEngineContextImpl = this.mEngineContext;
        if (hippyEngineContextImpl != null && hippyEngineContextImpl.mEngineLifecycleEventListeners != null) {
            Iterator<HippyRootView> it = this.mInstances.iterator();
            while (it.hasNext()) {
                it.next().onResume();
            }
            Iterator<HippyEngineLifecycleEventListener> it5 = this.mEngineContext.mEngineLifecycleEventListeners.iterator();
            while (it5.hasNext()) {
                HippyEngineLifecycleEventListener next = it5.next();
                if (!(next instanceof b)) {
                    next.onEngineResume();
                }
            }
            b domManager = this.mEngineContext.getDomManager();
            if (domManager != null) {
                domManager.onEngineResume();
            }
        }
    }

    @Override // com.tencent.mtt.hippy.HippyEngine
    public void onFontChanged(final int i3) {
        final b domManager = this.mEngineContext.getDomManager();
        getThreadExecutor().postOnDomThread(new Runnable() { // from class: com.tencent.mtt.hippy.HippyEngineManagerImpl.3
            @Override // java.lang.Runnable
            public void run() {
                domManager.b(i3);
            }
        });
    }

    @Override // com.tencent.mtt.hippy.a.h
    public void onInitDevError(Throwable th5) {
        this.mCurrentState = HippyEngine.EngineState.INITED;
        this.mDevManagerInited = false;
        notifyEngineInitialized(HippyEngine.EngineInitStatus.STATUS_ERR_DEVSERVER, th5);
    }

    @Override // com.tencent.mtt.hippy.HippyRootView.OnResumeAndPauseListener
    public void onInstancePause(int i3) {
        HippyEngineContextImpl hippyEngineContextImpl = this.mEngineContext;
        if (hippyEngineContextImpl == null) {
            return;
        }
        if (hippyEngineContextImpl.mInstanceLifecycleEventListeners != null) {
            Iterator<HippyInstanceLifecycleEventListener> it = this.mEngineContext.mInstanceLifecycleEventListeners.iterator();
            while (it.hasNext()) {
                it.next().onInstancePause(i3);
            }
        }
        if (this.mEngineContext.getBridgeManager() != null) {
            this.mEngineContext.getBridgeManager().b(i3);
        }
    }

    @Override // com.tencent.mtt.hippy.HippyRootView.OnResumeAndPauseListener
    public void onInstanceResume(int i3) {
        HippyEngineContextImpl hippyEngineContextImpl = this.mEngineContext;
        if (hippyEngineContextImpl == null) {
            return;
        }
        if (hippyEngineContextImpl.mInstanceLifecycleEventListeners != null) {
            Iterator<HippyInstanceLifecycleEventListener> it = this.mEngineContext.mInstanceLifecycleEventListeners.iterator();
            while (it.hasNext()) {
                it.next().onInstanceResume(i3);
            }
        }
        if (this.mEngineContext.getBridgeManager() != null) {
            this.mEngineContext.getBridgeManager().a(i3);
        }
    }

    @Override // com.tencent.mtt.hippy.HippyRootView.OnSizeChangedListener
    public void onSizeChanged(final HippyRootView hippyRootView, final int i3, final int i16, int i17, int i18) {
        getThreadExecutor().postOnDomThread(new Runnable() { // from class: com.tencent.mtt.hippy.HippyEngineManagerImpl.12
            @Override // java.lang.Runnable
            public void run() {
                HippyEngineContextImpl hippyEngineContextImpl = HippyEngineManagerImpl.this.mEngineContext;
                if (hippyEngineContextImpl != null && hippyEngineContextImpl.getDomManager() != null) {
                    HippyEngineManagerImpl.this.mEngineContext.getDomManager().b(hippyRootView.getId(), i3, i16);
                }
            }
        });
    }

    @Override // com.tencent.mtt.hippy.HippyEngineManager
    public HippyInstanceContext preCreateInstanceContext(Context context) {
        return new HippyInstanceContext(context);
    }

    @Override // com.tencent.mtt.hippy.HippyEngine
    public void preloadModule(HippyBundleLoader hippyBundleLoader) {
        HippyEngineContextImpl hippyEngineContextImpl = this.mEngineContext;
        if (hippyEngineContextImpl != null && hippyEngineContextImpl.getBridgeManager() != null) {
            this.mEngineContext.getBridgeManager().a(-1, hippyBundleLoader, (HippyEngine.ModuleListener) null, (HippyRootView) null);
        }
    }

    @Override // com.tencent.mtt.hippy.HippyEngine
    @Nullable
    public HippyRootView restoreInstanceState(final ArrayList<DomNodeRecord> arrayList, HippyEngine.ModuleLoadParams moduleLoadParams, final boolean z16) {
        if (arrayList == null || arrayList.isEmpty() || this.mEngineContext == null) {
            return null;
        }
        this.mRestoreSucceed = false;
        long currentTimeMillis = System.currentTimeMillis();
        final b domManager = this.mEngineContext.getDomManager();
        RenderManager renderManager = this.mEngineContext.getRenderManager();
        HippyInstanceContext hippyInstanceContext = new HippyInstanceContext(moduleLoadParams.context, moduleLoadParams);
        hippyInstanceContext.setEngineContext(this.mEngineContext);
        final HippyRootView hippyRootView = new HippyRootView(hippyInstanceContext, moduleLoadParams);
        hippyRootView.setTimeMonitor(new TimeMonitor(true));
        hippyRootView.getTimeMonitor().begine();
        hippyRootView.getTimeMonitor().startEvent(HippyEngineMonitorEvent.MODULE_LOAD_EVENT_RESTORE_INSTANCE_STATE);
        hippyRootView.setOnSizeChangedListener(this);
        final int id5 = hippyRootView.getId();
        renderManager.getControllerManager().a(hippyRootView);
        getThreadExecutor().postOnDomThread(new Runnable() { // from class: com.tencent.mtt.hippy.HippyEngineManagerImpl.6
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                int i16;
                int i17;
                HippyMap hippyMap;
                try {
                    domManager.c();
                    for (int i18 = 0; i18 < arrayList.size(); i18++) {
                        DomNodeRecord domNodeRecord = (DomNodeRecord) arrayList.get(i18);
                        if (domNodeRecord != null && domNodeRecord.f337371id >= 0) {
                            if (i18 == 0) {
                                if (domNodeRecord.className.equals(NodeProps.ROOT_NODE) && (hippyMap = domNodeRecord.props) != null) {
                                    i16 = hippyMap.getInt("width");
                                    i17 = domNodeRecord.props.getInt("height");
                                } else {
                                    i16 = 0;
                                    i17 = 0;
                                }
                                domManager.a(id5, i16, i17);
                                if (domNodeRecord.className.equals(NodeProps.ROOT_NODE)) {
                                }
                            }
                            int i19 = domNodeRecord.pid;
                            if (i19 % 10 == 0) {
                                i3 = id5;
                            } else {
                                i3 = 0 - i19;
                            }
                            domManager.a(hippyRootView, id5, 0 - domNodeRecord.f337371id, i3, domNodeRecord.index, domNodeRecord.className, domNodeRecord.tagName, domNodeRecord.props);
                        }
                    }
                    domManager.b(z16);
                    if (z16) {
                        synchronized (HippyEngineManagerImpl.this.mRestoreSyncObject) {
                            HippyEngineManagerImpl.this.mRestoreSucceed = true;
                            HippyEngineManagerImpl.this.mRestoreSyncObject.notify();
                        }
                    }
                } catch (Exception e16) {
                    LogUtils.w(HippyEngineMonitorEvent.MODULE_LOAD_EVENT_RESTORE_INSTANCE_STATE, "dom restore exception: " + e16.getMessage());
                    domManager.a(z16);
                    if (z16) {
                        synchronized (HippyEngineManagerImpl.this.mRestoreSyncObject) {
                            HippyEngineManagerImpl.this.mRestoreSyncObject.notify();
                        }
                    }
                }
            }
        });
        if (z16) {
            try {
                synchronized (this.mRestoreSyncObject) {
                    LockMethodProxy.wait(this.mRestoreSyncObject);
                    LogUtils.d(HippyEngineMonitorEvent.MODULE_LOAD_EVENT_RESTORE_INSTANCE_STATE, "dom batch end: " + (System.currentTimeMillis() - currentTimeMillis));
                    if (!this.mRestoreSucceed) {
                        LogUtils.w(HippyEngineMonitorEvent.MODULE_LOAD_EVENT_RESTORE_INSTANCE_STATE, "restore dom node failed!!");
                        destroyInstanceState(hippyRootView);
                        return null;
                    }
                    domManager.h();
                    LogUtils.d(HippyEngineMonitorEvent.MODULE_LOAD_EVENT_RESTORE_INSTANCE_STATE, "render batch end: " + (System.currentTimeMillis() - currentTimeMillis));
                }
            } catch (Exception e16) {
                LogUtils.w(HippyEngineMonitorEvent.MODULE_LOAD_EVENT_RESTORE_INSTANCE_STATE, "render restore exception: " + e16.getMessage());
                destroyInstanceState(hippyRootView);
                return null;
            }
        }
        return hippyRootView;
    }

    @Override // com.tencent.mtt.hippy.HippyEngine
    public void runScript(@NonNull String str) {
        HippyEngineContextImpl hippyEngineContextImpl = this.mEngineContext;
        if (hippyEngineContextImpl != null) {
            hippyEngineContextImpl.runScript(str);
        }
    }

    @Override // com.tencent.mtt.hippy.HippyEngine
    public void saveInstanceState() {
        saveInstanceState(null);
    }

    @Override // com.tencent.mtt.hippy.HippyEngine
    public void sendEvent(String str, Object obj) {
        sendEvent(str, obj, HippyEngine.BridgeTransferType.BRIDGE_TRANSFER_TYPE_NORMAL);
    }

    @Override // com.tencent.mtt.hippy.HippyEngineManager
    @Deprecated
    public HippyEngineContextImpl getCurrentEngineContext() {
        return getEngineContext();
    }

    @Override // com.tencent.mtt.hippy.HippyEngine
    public HippyEngineContextImpl getEngineContext() {
        return this.mEngineContext;
    }

    @Override // com.tencent.mtt.hippy.HippyEngineManager
    @Deprecated
    public HippyRootView loadInstance(HippyRootViewParams hippyRootViewParams, HippyEngine.ModuleListener moduleListener) {
        return loadInstance(hippyRootViewParams, moduleListener, null);
    }

    @Override // com.tencent.mtt.hippy.HippyEngine
    public HippyRootView loadModule(HippyEngine.ModuleLoadParams moduleLoadParams, HippyEngine.ModuleListener moduleListener) {
        return loadModule(moduleLoadParams, moduleListener, null);
    }

    @Override // com.tencent.mtt.hippy.HippyEngine
    public void saveInstanceState(final Object obj) {
        final b domManager = this.mEngineContext.getDomManager();
        if (this.mEngineContext == null || domManager == null || this.mThirdPartyAdapter == null) {
            return;
        }
        getThreadExecutor().postOnDomThread(new Runnable() { // from class: com.tencent.mtt.hippy.HippyEngineManagerImpl.5
            @Override // java.lang.Runnable
            public void run() {
                int f16 = domManager.f();
                com.tencent.mtt.hippy.dom.node.b c16 = domManager.c(f16);
                if (c16 == null) {
                    LogUtils.e(HippyEngineManagerImpl.TAG, "saveInstanceState root node is null!");
                    return;
                }
                ArrayList<DomNodeRecord> arrayList = new ArrayList<>();
                DomNodeRecord domNodeRecord = new DomNodeRecord();
                domNodeRecord.rootId = c16.getId();
                domNodeRecord.f337371id = c16.getId();
                domNodeRecord.className = c16.getViewClass();
                HippyMap hippyMap = new HippyMap();
                domNodeRecord.props = hippyMap;
                hippyMap.pushInt("width", Math.round(c16.getStyleWidth()));
                domNodeRecord.props.pushInt("height", Math.round(c16.getStyleHeight()));
                arrayList.add(domNodeRecord);
                int childCount = c16.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    com.tencent.mtt.hippy.dom.node.b childAt = c16.getChildAt(i3);
                    if (childAt != null) {
                        DomNodeRecord domNodeRecord2 = new DomNodeRecord();
                        domNodeRecord2.rootId = f16;
                        domNodeRecord2.f337371id = childAt.getId();
                        domNodeRecord2.index = i3;
                        domNodeRecord2.pid = f16;
                        domNodeRecord2.className = childAt.getViewClass();
                        domNodeRecord2.props = childAt.getTotalProps();
                        arrayList.add(domNodeRecord2);
                        HippyEngineManagerImpl.this.addNodeRecordOfChild(arrayList, childAt, i3, f16);
                    }
                }
                HippyEngineManagerImpl.this.mThirdPartyAdapter.saveInstanceState(arrayList, obj);
            }
        });
    }

    @Override // com.tencent.mtt.hippy.HippyEngine
    public void sendEvent(String str, Object obj, HippyEngine.BridgeTransferType bridgeTransferType) {
        HippyEngineContextImpl hippyEngineContextImpl = this.mEngineContext;
        if (hippyEngineContextImpl == null || hippyEngineContextImpl.getModuleManager() == null) {
            return;
        }
        ((EventDispatcher) this.mEngineContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent(str, obj, bridgeTransferType);
    }

    @Override // com.tencent.mtt.hippy.HippyEngineManager
    @Deprecated
    public HippyRootView loadInstance(HippyRootViewParams hippyRootViewParams, HippyEngine.ModuleListener moduleListener, HippyRootView.OnLoadCompleteListener onLoadCompleteListener) {
        HippyEngine.ModuleLoadParams moduleLoadParams = new HippyEngine.ModuleLoadParams();
        moduleLoadParams.context = hippyRootViewParams.getActivity();
        moduleLoadParams.componentName = hippyRootViewParams.getName();
        HippyBundleLoader bundleLoader = hippyRootViewParams.getBundleLoader();
        if (bundleLoader instanceof HippyAssetBundleLoader) {
            moduleLoadParams.jsAssetsPath = hippyRootViewParams.getBundleLoader().getRawPath();
        } else if (bundleLoader instanceof HippyFileBundleLoader) {
            moduleLoadParams.jsFilePath = hippyRootViewParams.getBundleLoader().getRawPath();
        }
        moduleLoadParams.jsParams = hippyRootViewParams.getLaunchParams();
        moduleLoadParams.nativeParams = hippyRootViewParams.getNativeParams();
        moduleLoadParams.hippyContext = hippyRootViewParams.getInstanceContext();
        moduleLoadParams.bundleLoader = hippyRootViewParams.getBundleLoader();
        return loadModule(moduleLoadParams, moduleListener, onLoadCompleteListener);
    }

    @Override // com.tencent.mtt.hippy.HippyEngine
    public HippyRootView loadModule(HippyEngine.ModuleLoadParams moduleLoadParams, HippyEngine.ModuleListener moduleListener, HippyRootView.OnLoadCompleteListener onLoadCompleteListener) {
        HippyMap hippyMap;
        String str;
        if (moduleLoadParams == null) {
            throw new RuntimeException("Hippy: loadModule loadParams must no be null");
        }
        if (moduleLoadParams.context == null) {
            throw new RuntimeException("Hippy: loadModule loadParams.context must no be null");
        }
        if (!this.mDebugMode && TextUtils.isEmpty(moduleLoadParams.jsAssetsPath) && TextUtils.isEmpty(moduleLoadParams.jsFilePath)) {
            throw new RuntimeException("Hippy: loadModule debugMode=true, loadParams.jsAssetsPath and jsFilePath both null!");
        }
        HippyEngineContextImpl hippyEngineContextImpl = this.mEngineContext;
        if (hippyEngineContextImpl != null) {
            hippyEngineContextImpl.setComponentName(moduleLoadParams.componentName);
            this.mEngineContext.setNativeParams(moduleLoadParams.nativeParams);
        }
        if (moduleLoadParams.jsParams == null) {
            moduleLoadParams.jsParams = new HippyMap();
        }
        HippyInstanceContext hippyInstanceContext = moduleLoadParams.hippyContext;
        if (hippyInstanceContext != null) {
            hippyInstanceContext.setModuleParams(moduleLoadParams);
        }
        if (TextUtils.isEmpty(moduleLoadParams.jsAssetsPath)) {
            hippyMap = moduleLoadParams.jsParams;
            str = moduleLoadParams.jsFilePath;
        } else {
            hippyMap = moduleLoadParams.jsParams;
            str = moduleLoadParams.jsAssetsPath;
        }
        hippyMap.pushString("sourcePath", str);
        this.mModuleListener = moduleListener;
        HippyRootView hippyRootView = new HippyRootView(moduleLoadParams);
        if (this.mCurrentState == HippyEngine.EngineState.DESTROYED) {
            notifyModuleLoaded(HippyEngine.ModuleLoadStatus.STATUS_ENGINE_UNINIT, "load module error wrong state, Engine destroyed", hippyRootView);
            return hippyRootView;
        }
        if (onLoadCompleteListener != null) {
            hippyRootView.setOnLoadCompleteListener(onLoadCompleteListener);
        }
        hippyRootView.setTimeMonitor(new TimeMonitor(!this.mDebugMode));
        hippyRootView.getTimeMonitor().begine();
        hippyRootView.getTimeMonitor().startEvent(HippyEngineMonitorEvent.MODULE_LOAD_EVENT_WAIT_ENGINE);
        hippyRootView.setOnResumeAndPauseListener(this);
        hippyRootView.setOnSizeChangedListener(this);
        hippyRootView.attachEngineManager(this);
        this.mInstances.add(hippyRootView);
        this.mDevSupportManager.a(hippyRootView);
        if (!this.mDevManagerInited && this.mDebugMode) {
            this.mDevManagerInited = true;
        }
        LogUtils.d(TAG, "internalLoadInstance start...");
        if (this.mCurrentState == HippyEngine.EngineState.INITED) {
            internalLoadInstance(hippyRootView);
        } else {
            notifyModuleLoaded(HippyEngine.ModuleLoadStatus.STATUS_ENGINE_UNINIT, "error wrong state, Engine state not INITED, state:" + this.mCurrentState, hippyRootView);
        }
        return hippyRootView;
    }

    @Override // com.tencent.mtt.hippy.a.h
    public void onDevBundleLoadReady(InputStream inputStream) {
    }
}
