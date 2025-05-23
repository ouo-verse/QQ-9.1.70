package com.tencent.hippy.qq.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Size;
import android.util.SparseArray;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.tencent.hippy.qq.api.IBaseHttpAdapter;
import com.tencent.hippy.qq.api.IHippyAdapter;
import com.tencent.hippy.qq.api.IHippyDomNodeManager;
import com.tencent.hippy.qq.api.IHippyLibrary;
import com.tencent.hippy.qq.api.IHippyLifeCycleApi;
import com.tencent.hippy.qq.api.IHippyQQUpdate;
import com.tencent.hippy.qq.api.IHippySSR;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.hippy.qq.api.INativeProxy;
import com.tencent.hippy.qq.api.IUpdateListener;
import com.tencent.hippy.qq.api.LibraryLoadListener;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.api.PackageUpdateListener;
import com.tencent.hippy.qq.fragment.HippyActivityLifecycleOwner;
import com.tencent.hippy.qq.module.tkd.TJsCallBack;
import com.tencent.hippy.qq.module.tkd.TNativeProxy;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippy.qq.utils.HippyDebugUtil;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pad.m;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.adapter.exception.HippyExceptionHandlerAdapter;
import com.tencent.mtt.hippy.adapter.executor.DefaultExecutorSupplierAdapter;
import com.tencent.mtt.hippy.adapter.font.HippyFontScaleAdapter;
import com.tencent.mtt.hippy.adapter.image.HippyImageLoader;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter;
import com.tencent.mtt.hippy.adapter.thirdparty.HippyThirdPartyAdapter;
import com.tencent.mtt.hippy.common.HippyJsException;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyCustomViewCreator;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyQQEngine implements LibraryLoadListener {
    private static final int DESTORY_ENGINE_DELAY_MILLIS = 3000;
    private static final String EVENT_PAGE_APPEAR = "PageAppear";
    private static final String EVENT_PAGE_DESTORY = "PageDestory";
    private static final String EVENT_PAGE_DISAPPEAR = "PageDisappear";
    public static final String HIPPY_OTHER_LIST_INFO = "OtherList";
    public static final String HIPPY_PREDRAW_LIST_INFO = "PredrawList";
    public static final String HIPPY_PRELOAD_LIST_INFO = "PreloadList";
    public static final String HIPPY_TOP_SHOWING_NAME = "topShowingName";
    public static final String HIPPY_TOP_SHOWING_VERSION = "topShowingVersion";
    public static final String HIPPY_VISIBLE_LIST_INFO = "VisibleList";
    protected static final String TAG = "HippyQQEngine";
    private Activity activity;
    protected String componentName;
    private HippyActivityLifecycleOwner hippyActivityLifecycleOwner;
    private JSONObject mBusinessData;
    protected ViewGroup mContainer;
    private int mContainerFixedWidth;
    private HippyEngineInitListener mEngineInitListener;
    protected HippyQQEngineListener mEngineListener;
    private HippyEngineMonitorAdapter mEngineMonitorAdapter;
    public long mExecuteSSRCommonJsCost;
    protected QBaseFragment mFragment;
    private JSONObject mGlobalData;
    private HippyEngine mHippyEngine;
    protected HippyRootView mHippyRootView;
    IBaseHttpAdapter mHttpAdapter;
    HippyImageLoader mImageLoader;
    public int mMaxWidthOnSplitMode;
    private HippyEngineModuleListener mModuleListener;
    protected String mModuleName;
    private HippyRootView.OnLoadCompleteListener mOnFirstViewAddedListener;
    private JSONObject mPageData;
    private HippyThirdPartyAdapter mThirdPartyAdapter;
    protected String mUrl;

    @NonNull
    private INativeProxy nativeProxy;
    private HippyMap propsMap;
    private HippyRootView snapshotRootView;
    private static boolean mDebugSwitch = HippyDebugUtil.isHippyDebug();
    private static String mDebugMoudleName = HippyDebugUtil.getHippyBundleName();
    private static String mDebugServerHost = HippyDebugUtil.getHippyServerHost();
    public static SparseArray<WeakReference<HippyQQEngine>> mEngines = new SparseArray<>();
    private static HashMap<String, Long> mModuleUpdateTime = new HashMap<>();
    protected boolean mIsResumed = false;
    protected boolean mIsShowing = false;
    protected boolean mIsDestroyed = false;
    protected boolean mIsPageLoaded = false;
    protected int mModuleVersion = 0;
    private String mJsBundleType = HippyQQConstants.HIPPY_VUE;
    protected HippyCustomViewCreator viewCreator = null;
    protected List<HippyAPIProvider> providers = new ArrayList();
    protected HashMap<String, Long> mMapLoadStepsTime = new HashMap<>();
    private OpenHippyInfo mOpenHippyInfo = new OpenHippyInfo();

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class HippyEngineInitListener implements HippyEngine.EngineListener {
        private WeakReference<HippyQQEngine> engineWeakReference;

        public HippyEngineInitListener(HippyQQEngine hippyQQEngine) {
            this.engineWeakReference = new WeakReference<>(hippyQQEngine);
        }

        @Override // com.tencent.mtt.hippy.HippyEngine.EngineListener
        public void onInitialized(HippyEngine.EngineInitStatus engineInitStatus, String str) {
            HippyQQEngine hippyQQEngine = this.engineWeakReference.get();
            if (hippyQQEngine == null) {
                QLog.e(HippyQQEngine.TAG, 1, "onInitialized qqEngine was recycled");
            } else {
                hippyQQEngine.onEngineInitialized(engineInitStatus, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class HippyEngineModuleListener implements HippyEngine.ModuleListener {
        private WeakReference<HippyQQEngine> engineWeakReference;

        public HippyEngineModuleListener(HippyQQEngine hippyQQEngine) {
            this.engineWeakReference = new WeakReference<>(hippyQQEngine);
        }

        @Override // com.tencent.mtt.hippy.HippyEngine.ModuleListener
        public boolean onJsException(HippyJsException hippyJsException) {
            HippyQQEngine hippyQQEngine = this.engineWeakReference.get();
            if (hippyQQEngine == null) {
                QLog.e(HippyQQEngine.TAG, 1, "onJsException qqEngine was recycled");
            } else {
                hippyQQEngine.onModuleJsException(hippyJsException);
            }
            return true;
        }

        @Override // com.tencent.mtt.hippy.HippyEngine.ModuleListener
        public void onLoadCompleted(HippyEngine.ModuleLoadStatus moduleLoadStatus, String str, HippyRootView hippyRootView) {
            HippyQQEngine hippyQQEngine = this.engineWeakReference.get();
            if (hippyQQEngine == null) {
                QLog.e(HippyQQEngine.TAG, 1, "onLoadCompleted qqEngine was recycled");
            } else {
                hippyQQEngine.onLoadModuleCompleted(moduleLoadStatus, str, hippyRootView);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface HippyQQEngineListener {
        void onError(int i3, String str);

        void onSuccess();
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class HippyQQExecutorAdapter extends DefaultExecutorSupplierAdapter {
        WeakReference<HippyQQEngine> engineWeakReference;

        public HippyQQExecutorAdapter(HippyQQEngine hippyQQEngine) {
            this.engineWeakReference = new WeakReference<>(hippyQQEngine);
        }

        @Override // com.tencent.mtt.hippy.adapter.executor.DefaultExecutorSupplierAdapter, com.tencent.mtt.hippy.adapter.executor.HippyExecutorSupplierAdapter
        public Executor getBackgroundTaskExecutor() {
            Executor executor;
            IBaseHttpAdapter iBaseHttpAdapter;
            HippyQQEngine hippyQQEngine = this.engineWeakReference.get();
            if (hippyQQEngine != null && (iBaseHttpAdapter = hippyQQEngine.mHttpAdapter) != null) {
                executor = iBaseHttpAdapter.getExecutor();
            } else {
                executor = null;
            }
            if (executor == null) {
                return super.getBackgroundTaskExecutor();
            }
            return executor;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HippyQQEngine(QBaseFragment qBaseFragment, String str, String str2) {
        this.mFragment = qBaseFragment;
        if (qBaseFragment instanceof HippyActivityLifecycleOwner) {
            setHippyActivityLifecycleOwner((HippyActivityLifecycleOwner) qBaseFragment);
        }
        init(str, str2);
    }

    private void adapterJsBundleType(String str) {
        try {
            String queryParameter = Uri.parse(str).getQueryParameter("framework");
            if (!TextUtils.isEmpty(queryParameter)) {
                this.mJsBundleType = queryParameter;
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "adapterJsBundleType error:" + e16);
        }
    }

    private void addHippyToFixedWidthContainer(HippyRootView hippyRootView, int i3) {
        FrameLayout frameLayout = new FrameLayout(this.mContainer.getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, -1);
        layoutParams.addRule(14);
        RelativeLayout relativeLayout = new RelativeLayout(this.mContainer.getContext());
        relativeLayout.addView(frameLayout, layoutParams);
        this.mContainer.addView(relativeLayout, new ViewGroup.LayoutParams(-1, -1));
        frameLayout.addView(hippyRootView, 0);
    }

    private boolean checkRightToReceiveEvent(String str, String str2) {
        if (this.mModuleName == null || isDestroyed() || (!TextUtils.isEmpty(str2) && !str2.equals(this.mModuleName))) {
            return false;
        }
        return true;
    }

    private static String describeHippyEngines(List<HippyQQEngine> list) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append('[');
        for (int size = list.size() - 1; size >= 0; size--) {
            HippyQQEngine hippyQQEngine = list.get(size);
            String moduleName = hippyQQEngine.getModuleName();
            int moduleVersion = hippyQQEngine.getModuleVersion();
            if (!hippyQQEngine.mIsResumed && (hippyQQEngine instanceof HippyQQPreloadEngine)) {
                moduleVersion = ((HippyQQPreloadEngine) hippyQQEngine).getPreloadModuleVersion();
            }
            sb5.append(moduleName);
            sb5.append(":");
            sb5.append(moduleVersion);
            if (size > 0) {
                sb5.append(',');
            }
        }
        sb5.append(']');
        return sb5.toString();
    }

    public static synchronized void dispatchEvent(String str, String str2, HippyMap hippyMap) {
        HippyQQEngine hippyQQEngine;
        HippyEngine hippyEngine;
        synchronized (HippyQQEngine.class) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            for (int i3 = 0; i3 < mEngines.size(); i3++) {
                try {
                    WeakReference<HippyQQEngine> valueAt = mEngines.valueAt(i3);
                    if (valueAt != null) {
                        hippyQQEngine = valueAt.get();
                    } else {
                        hippyQQEngine = null;
                    }
                    if (hippyQQEngine != null && hippyQQEngine.checkRightToReceiveEvent(str, str2) && (hippyEngine = hippyQQEngine.mHippyEngine) != null && hippyEngine.getEngineState() == HippyEngine.EngineState.INITED) {
                        hippyEngine.sendEvent(str, hippyMap);
                    }
                } catch (Throwable th5) {
                    QLog.e(TAG, 1, "dispatchEvent error:" + th5);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doOnUpdateComplete(final int i3, final String str, final String str2, final long j3) {
        Runnable runnable = new Runnable() { // from class: com.tencent.hippy.qq.app.HippyQQEngine.2
            @Override // java.lang.Runnable
            public void run() {
                HippyQQEngine.this.doUpdatePackageComplete(i3, str, str2, j3);
            }
        };
        if (isMainThread()) {
            runnable.run();
        } else {
            ThreadManager.getUIHandler().post(runnable);
        }
    }

    public static String getDebugMoudleName() {
        return mDebugMoudleName;
    }

    public static String getDebugServerHost() {
        return mDebugServerHost;
    }

    public static boolean getDebugSwitch() {
        return mDebugSwitch;
    }

    public static synchronized HippyQQEngine getEngineInstance(int i3) {
        HippyQQEngine hippyQQEngine;
        synchronized (HippyQQEngine.class) {
            WeakReference<HippyQQEngine> weakReference = mEngines.get(i3);
            if (weakReference != null) {
                hippyQQEngine = weakReference.get();
            } else {
                hippyQQEngine = null;
            }
        }
        return hippyQQEngine;
    }

    public static synchronized HashMap<String, String> getHippyStatus() {
        HashMap<String, String> hashMap;
        HippyQQEngine hippyQQEngine;
        synchronized (HippyQQEngine.class) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            for (int i3 = 0; i3 < mEngines.size(); i3++) {
                WeakReference<HippyQQEngine> valueAt = mEngines.valueAt(i3);
                if (valueAt != null) {
                    hippyQQEngine = valueAt.get();
                } else {
                    hippyQQEngine = null;
                }
                if (hippyQQEngine != null && !hippyQQEngine.isDestroyed()) {
                    if (hippyQQEngine.mIsResumed) {
                        arrayList.add(hippyQQEngine);
                    } else if (hippyQQEngine instanceof HippyQQPreloadEngine) {
                        if (((HippyQQPreloadEngine) hippyQQEngine).isPredraw()) {
                            arrayList2.add(hippyQQEngine);
                        } else {
                            arrayList3.add(hippyQQEngine);
                        }
                    } else {
                        arrayList4.add(hippyQQEngine);
                    }
                }
            }
            hashMap = new HashMap<>();
            if (arrayList.size() > 0) {
                putTopShowingHippyInfo(arrayList, hashMap);
                hashMap.put(HIPPY_VISIBLE_LIST_INFO, describeHippyEngines(arrayList));
            }
            if (arrayList2.size() > 0) {
                hashMap.put(HIPPY_PREDRAW_LIST_INFO, describeHippyEngines(arrayList2));
            }
            if (arrayList3.size() > 0) {
                hashMap.put(HIPPY_PRELOAD_LIST_INFO, describeHippyEngines(arrayList3));
            }
            if (arrayList4.size() > 0) {
                hashMap.put(HIPPY_OTHER_LIST_INFO, describeHippyEngines(arrayList4));
            }
        }
        return hashMap;
    }

    private int getSplitModeFunctionZoneWidth() {
        Size c16;
        if (!(getActivity() instanceof FragmentActivity) || (c16 = m.c((FragmentActivity) getActivity())) == null) {
            return 0;
        }
        return c16.getWidth();
    }

    private void init(String str, String str2) {
        this.mModuleName = str;
        this.mUrl = str2;
        this.nativeProxy = new TNativeProxy();
        this.mContainerFixedWidth = ((IHippySetting) QRoute.api(IHippySetting.class)).getFixedWidth(this.mModuleName);
        initJsBundleTypeFromUrl();
    }

    private boolean isActivityDestroyed() {
        Activity activity = this.activity;
        if (activity != null && activity.isFinishing()) {
            return true;
        }
        return false;
    }

    private boolean isFragmentDestroyed() {
        QBaseFragment qBaseFragment;
        if (this.activity == null && ((qBaseFragment = this.mFragment) == null || qBaseFragment.getActivity() == null)) {
            return true;
        }
        return false;
    }

    public static boolean isMainThread() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    private boolean isPageDestroyed() {
        if (this.mModuleName.equals("TKDADwormhole")) {
            return false;
        }
        if (!isActivityDestroyed() && !isFragmentDestroyed()) {
            return false;
        }
        onLoadFail(-11, "fragment or activity destroyed!");
        return true;
    }

    public static void onDebugModuleChanged(String str) {
        if (!TextUtils.isEmpty(str)) {
            mDebugMoudleName = str;
        }
    }

    public static void onDebugPortChanged(String str) {
        if (!TextUtils.isEmpty(str)) {
            mDebugServerHost = str;
        }
    }

    public static void onDebugSwitchChanged(boolean z16) {
        mDebugSwitch = z16;
    }

    protected static synchronized void putEngineInstance(int i3, HippyQQEngine hippyQQEngine) {
        synchronized (HippyQQEngine.class) {
            mEngines.put(i3, new WeakReference<>(hippyQQEngine));
        }
    }

    private static void putTopShowingHippyInfo(List<HippyQQEngine> list, HashMap<String, String> hashMap) {
        String str;
        int i3;
        int size = list.size() - 1;
        while (true) {
            if (size >= 0) {
                if (list.get(size).mIsShowing) {
                    str = list.get(size).getModuleName();
                    i3 = list.get(size).getModuleVersion();
                    break;
                }
                size--;
            } else {
                str = "";
                i3 = 0;
                break;
            }
        }
        hashMap.put(HIPPY_TOP_SHOWING_NAME, str);
        hashMap.put(HIPPY_TOP_SHOWING_VERSION, String.valueOf(i3));
    }

    protected static synchronized void removeEngineInstance(int i3) {
        synchronized (HippyQQEngine.class) {
            mEngines.remove(i3);
        }
    }

    public static void runTaskInUIThread(Runnable runnable) {
        if (isMainThread()) {
            runnable.run();
        } else {
            ThreadManager.getUIHandler().post(runnable);
        }
    }

    public static void runTaskInUIThreadFront(Runnable runnable) {
        if (isMainThread()) {
            runnable.run();
        } else {
            ThreadManager.getUIHandler().postAtFrontOfQueue(runnable);
        }
        QLog.i(TAG, 2, "[runTaskInUIThreadFront] " + MobileQQ.sMobileQQ.getQQProcessName());
    }

    private void tryAddSnapShotView(HippyEngine.ModuleLoadParams moduleLoadParams) {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime != null) {
            final IHippyDomNodeManager iHippyDomNodeManager = (IHippyDomNodeManager) waitAppRuntime.getRuntimeService(IHippyDomNodeManager.class, ProcessConstant.MULTI);
            this.snapshotRootView = iHippyDomNodeManager.addSnapshotRootViewIfNeed(this.mHippyEngine, this.mContainer, this.mModuleName, this.mModuleVersion, this.mOpenHippyInfo.preRenderTag, moduleLoadParams, new IHippyDomNodeManager.SnapshotLoadListener() { // from class: com.tencent.hippy.qq.app.HippyQQEngine.4
                @Override // com.tencent.hippy.qq.api.IHippyDomNodeManager.SnapshotLoadListener
                public void onLoadComplete() {
                    long longValue;
                    long currentTimeMillis = System.currentTimeMillis();
                    HippyQQEngine.this.mMapLoadStepsTime.put(HippyQQConstants.STEP_NAME_LOAD_SNAPSHOT_END, Long.valueOf(currentTimeMillis));
                    Long l3 = HippyQQEngine.this.mMapLoadStepsTime.get(HippyQQConstants.STEP_NAME_LOAD_MODULE_START);
                    IHippyDomNodeManager iHippyDomNodeManager2 = iHippyDomNodeManager;
                    HippyQQEngine hippyQQEngine = HippyQQEngine.this;
                    String str = hippyQQEngine.mModuleName;
                    int i3 = hippyQQEngine.mModuleVersion;
                    if (l3 == null) {
                        longValue = 0;
                    } else {
                        longValue = l3.longValue();
                    }
                    iHippyDomNodeManager2.reportSnapshotShow(str, i3, currentTimeMillis - longValue, true, "");
                }

                @Override // com.tencent.hippy.qq.api.IHippyDomNodeManager.SnapshotLoadListener
                public void onLoadFailed(@NonNull String str) {
                    IHippyDomNodeManager iHippyDomNodeManager2 = iHippyDomNodeManager;
                    HippyQQEngine hippyQQEngine = HippyQQEngine.this;
                    iHippyDomNodeManager2.reportSnapshotShow(hippyQQEngine.mModuleName, hippyQQEngine.mModuleVersion, 0L, false, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void addRootView(HippyRootView hippyRootView) {
        int i3;
        if (hippyRootView.getParent() == null && this.mContainer != null) {
            if (getOpenHippyInfo().isLoadOnSplitMode && HippyUtils.isFold()) {
                if (this.mMaxWidthOnSplitMode <= 0) {
                    this.mMaxWidthOnSplitMode = getSplitModeFunctionZoneWidth();
                }
                int i16 = this.mMaxWidthOnSplitMode;
                if (i16 > 0) {
                    i3 = i16;
                } else {
                    i3 = this.mContainerFixedWidth;
                }
                this.mContainerFixedWidth = i3;
                QLog.d(TAG, 1, "addRootView function zone width:", Integer.valueOf(i16));
                int i17 = this.mContainerFixedWidth;
                if (i17 > 0) {
                    addHippyToFixedWidthContainer(hippyRootView, i17);
                    return;
                }
            }
            if (this.mContainerFixedWidth > 0 && (this.mContainer.getWidth() <= 0 || this.mContainerFixedWidth < this.mContainer.getWidth())) {
                addHippyToFixedWidthContainer(hippyRootView, this.mContainerFixedWidth);
            } else {
                this.mContainer.addView(hippyRootView, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkPackageUpdate() {
        boolean z16;
        if (TextUtils.isEmpty(this.mModuleName)) {
            return;
        }
        mModuleUpdateTime.put(this.mModuleName, Long.valueOf(System.currentTimeMillis()));
        final long currentTimeMillis = System.currentTimeMillis();
        Bundle bundle = new Bundle();
        bundle.putString("reportFrom", "oldUpdate");
        if (this.mModuleVersion > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        bundle.putBoolean(IHippyUpdate.EXTRA_KEY_IS_CONTROL_FLOW, z16);
        ((IHippyUpdate) QRoute.api(IHippyUpdate.class)).updateJsBundle(this.mModuleName, ((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).isUpdateHippyJsBundleByHttp(), 4, bundle, new IUpdateListener() { // from class: com.tencent.hippy.qq.app.HippyQQEngine.1
            @Override // com.tencent.hippy.qq.api.IUpdateListener
            public void onUpdateFailed(int i3, int i16, String str, String str2, HashMap<String, String> hashMap) {
                HippyQQEngine.this.doOnUpdateComplete(i16, str, null, currentTimeMillis);
            }

            @Override // com.tencent.hippy.qq.api.IUpdateListener
            public void onUpdateSuccess(int i3, String str, HashMap<String, String> hashMap) {
                HippyQQEngine.this.doOnUpdateComplete(0, "", null, currentTimeMillis);
            }
        });
    }

    protected HippyFontScaleAdapter createHippyFontScaleAdapter() {
        return ((IHippyAdapter) QRoute.api(IHippyAdapter.class)).createFontScaleAdapter();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void destroyEngine() {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "destoryEngine");
        }
        IBaseHttpAdapter iBaseHttpAdapter = this.mHttpAdapter;
        if (iBaseHttpAdapter != null) {
            iBaseHttpAdapter.shutdownExecutor();
        }
        HippyImageLoader hippyImageLoader = this.mImageLoader;
        if (hippyImageLoader != null) {
            hippyImageLoader.destroyIfNeed();
        }
        HippyEngine hippyEngine = this.mHippyEngine;
        if (hippyEngine != null) {
            hippyEngine.destroyModule(this.mHippyRootView);
            this.mHippyEngine.destroyEngine();
        }
    }

    public void destroyEngineImmediately(String str) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "destoryEngineImmediately engine:" + this.mHippyEngine + " bundleName:" + this.mModuleName + " from:" + str);
        }
        HippyEngine hippyEngine = this.mHippyEngine;
        if (hippyEngine != null && !this.mIsDestroyed) {
            this.mIsDestroyed = true;
            hippyEngine.sendEvent(EVENT_PAGE_DESTORY, null);
            removeEngineInstance(this.mHippyEngine.getId());
            this.mFragment = null;
            this.mEngineListener = null;
            destroyEngine();
        }
        HippyUtils.reportEngineRemoved(this.mModuleName, this.mModuleVersion, -1, str);
    }

    public boolean doOnBackPressed(HippyEngine.BackPressHandler backPressHandler) {
        HippyEngine hippyEngine = this.mHippyEngine;
        if (hippyEngine != null) {
            return hippyEngine.onBackPressed(backPressHandler);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doUpdatePackageComplete(int i3, String str, String str2, long j3) {
        File moduleFile;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mModuleVersion <= 0) {
            if (str2 == null) {
                int moduleVersion = ((IHippySetting) QRoute.api(IHippySetting.class)).getModuleVersion(this.mModuleName);
                if (moduleVersion == -1) {
                    moduleFile = null;
                } else {
                    moduleFile = ((IHippySetting) QRoute.api(IHippySetting.class)).getModuleFile(this.mModuleName, moduleVersion);
                }
                if (moduleFile == null) {
                    str2 = null;
                } else {
                    str2 = moduleFile.getAbsolutePath();
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                loadModule(str2 + "/" + HippyQQConstants.MAIN_BUNDLE_NAME);
            } else {
                HippyQQEngineListener hippyQQEngineListener = this.mEngineListener;
                if (hippyQQEngineListener != null) {
                    hippyQQEngineListener.onError(i3, str);
                }
            }
        }
        HippyReporter.getInstance().reportCheckUpdate(this.mModuleName, 5, i3, str, currentTimeMillis - j3, null);
    }

    public HashMap<String, String> generateReportExtraParams() {
        HashMap<String, String> hashMap = new HashMap<>();
        long coreJsFileLength = ((IHippyLibrary) QRoute.api(IHippyLibrary.class)).getCoreJsFileLength(getCoreJsFileName());
        long moduleIndexFileLength = ((IHippySetting) QRoute.api(IHippySetting.class)).getModuleIndexFileLength(this.mModuleName, this.mModuleVersion);
        hashMap.put("coreJsLength", String.valueOf(coreJsFileLength));
        hashMap.put("busJsLength", String.valueOf(moduleIndexFileLength));
        return hashMap;
    }

    public Activity getActivity() {
        Activity activity = this.activity;
        if (activity != null) {
            return activity;
        }
        QBaseFragment qBaseFragment = this.mFragment;
        if (qBaseFragment != null) {
            return qBaseFragment.getActivity();
        }
        return null;
    }

    public int getContainerHeight() {
        ViewGroup viewGroup = this.mContainer;
        if (viewGroup != null) {
            return viewGroup.getHeight();
        }
        return 0;
    }

    public int getContainerWidth() {
        int i3;
        ViewGroup viewGroup = this.mContainer;
        if (viewGroup != null) {
            i3 = viewGroup.getWidth();
        } else {
            i3 = 0;
        }
        int i16 = this.mContainerFixedWidth;
        if (i16 > 0 && (i3 <= 0 || i16 < i3)) {
            return i16;
        }
        return i3;
    }

    public String getCoreJsFileName() {
        if (!TextUtils.isEmpty(this.mJsBundleType) && this.mJsBundleType.equals("react")) {
            return HippyQQConstants.REACT_CORE_BUNDLE_NAME;
        }
        return HippyQQConstants.VUE_CORE_BUNDLE_NAME;
    }

    public QBaseFragment getFragment() {
        return this.mFragment;
    }

    public HippyActivityLifecycleOwner getHippyActivityLifecycleOwner() {
        return this.hippyActivityLifecycleOwner;
    }

    public HippyEngine getHippyEngine() {
        return this.mHippyEngine;
    }

    public HippyRootView getHippyRootView() {
        return this.mHippyRootView;
    }

    public IBaseHttpAdapter getHttpAdapter() {
        return this.mHttpAdapter;
    }

    public String getJsBundleType() {
        return this.mJsBundleType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public HippyMap getJsParamsMap(HippyEngine.ModuleLoadParams moduleLoadParams) {
        HippyMap hippyMap = new HippyMap();
        HippyMap hippyMap2 = this.propsMap;
        if (hippyMap2 != null) {
            hippyMap.pushAll(hippyMap2);
        }
        hippyMap.pushString("msgFromNative", "Hi js developer, I come from native code!");
        JSONObject jSONObject = this.mBusinessData;
        if (jSONObject != null) {
            hippyMap.pushString("cookie", jSONObject.toString());
        }
        return hippyMap;
    }

    public HashMap<String, Long> getLoadStepsTime() {
        return this.mMapLoadStepsTime;
    }

    public String getModuleName() {
        return this.mModuleName;
    }

    public int getModuleVersion() {
        return this.mModuleVersion;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public Map<String, Object> getNativeParams() {
        HashMap hashMap = new HashMap();
        HippyCustomViewCreator hippyCustomViewCreator = this.viewCreator;
        if (hippyCustomViewCreator != null) {
            hashMap.put(HippyCustomViewCreator.HIPPY_CUSTOM_VIEW_CREATOR, hippyCustomViewCreator);
        }
        return hashMap;
    }

    @NonNull
    public INativeProxy getNativeProxy() {
        return this.nativeProxy;
    }

    public OpenHippyInfo getOpenHippyInfo() {
        return this.mOpenHippyInfo;
    }

    public String getPageUrl() {
        return this.mUrl;
    }

    public HippyThirdPartyAdapter getThirdPartyAdapter() {
        return this.mThirdPartyAdapter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initHippyEngine() {
        if (!isCanInitHippyEngine()) {
            return;
        }
        QLog.d(HippyQQConstants.HIPPY_TAG, 1, "Hippy: initHippyEngine:" + this.mModuleName + ",groupId: " + this.mOpenHippyInfo.groupId);
        String coreJsFileName = getCoreJsFileName();
        String coreJsFilePath = ((IHippyLibrary) QRoute.api(IHippyLibrary.class)).getCoreJsFilePath(coreJsFileName);
        if (Boolean.valueOf(((IHippyLibrary) QRoute.api(IHippyLibrary.class)).isUseDebugSo()).booleanValue()) {
            coreJsFilePath = ((IHippyLibrary) QRoute.api(IHippyLibrary.class)).getDebugCoreJsPath(coreJsFileName);
        }
        if (TextUtils.isEmpty(coreJsFilePath)) {
            onLoadFail(-10, "could not found core js file!");
            return;
        }
        if (this.mHttpAdapter == null) {
            this.mHttpAdapter = ((IHippyAdapter) QRoute.api(IHippyAdapter.class)).createBaseHttpAdapter(HippyUtils.enableHttp2());
        }
        PixelUtil.setDisplayMetrics(FontSettingManager.customMetrics);
        HippyEngine.EngineInitParams engineInitParams = new HippyEngine.EngineInitParams();
        engineInitParams.context = BaseApplication.getContext().getApplicationContext();
        HippyImageLoader createImageLoader = ((IHippyAdapter) QRoute.api(IHippyAdapter.class)).createImageLoader();
        this.mImageLoader = createImageLoader;
        engineInitParams.imageLoader = createImageLoader;
        engineInitParams.httpAdapter = ((IHippyAdapter) QRoute.api(IHippyAdapter.class)).createHttpAdapter(this.mHttpAdapter, this.mOpenHippyInfo);
        engineInitParams.fontScaleAdapter = createHippyFontScaleAdapter();
        engineInitParams.thirdPartyAdapter = ((IHippyAdapter) QRoute.api(IHippyAdapter.class)).createThirdPartyAdapter();
        engineInitParams.deviceAdapter = ((IHippyAdapter) QRoute.api(IHippyAdapter.class)).createHippyDeviceAdapter();
        engineInitParams.logAdapter = ((IHippyAdapter) QRoute.api(IHippyAdapter.class)).createHippyLogAdapter();
        engineInitParams.executorSupplier = new HippyQQExecutorAdapter(this);
        engineInitParams.thirdPartyAdapter.setPageUrl(this.mUrl);
        engineInitParams.thirdPartyAdapter.setExtraData(this.mGlobalData);
        engineInitParams.enableTurbo = true;
        this.mThirdPartyAdapter = engineInitParams.thirdPartyAdapter;
        int i3 = this.mOpenHippyInfo.groupId;
        if (i3 != 0) {
            engineInitParams.groupId = i3;
        }
        boolean isDebugMode = isDebugMode();
        engineInitParams.debugMode = isDebugMode;
        if (isDebugMode && HippyDebugUtil.isDebugEnable() && !TextUtils.isEmpty(mDebugServerHost)) {
            engineInitParams.debugServerHost = mDebugServerHost;
        }
        if (!TextUtils.isEmpty(this.mOpenHippyInfo.bundleUrl) && this.mOpenHippyInfo.bundleUrl.contains("debugUrl")) {
            engineInitParams.remoteServerUrl = this.mOpenHippyInfo.bundleUrl;
        }
        engineInitParams.domOperateInterceptor = this.mOpenHippyInfo.getDomOperateInterceptor();
        engineInitParams.enableLog = true;
        engineInitParams.coreJSFilePath = coreJsFilePath;
        engineInitParams.exceptionHandler = new MyHippyExceptionHandlerAdapter(this);
        HippyEngineMonitorAdapter hippyEngineMonitorAdapter = this.mEngineMonitorAdapter;
        if (hippyEngineMonitorAdapter == null) {
            hippyEngineMonitorAdapter = ((IHippyAdapter) QRoute.api(IHippyAdapter.class)).createEngineMonitorAdapter();
        }
        engineInitParams.engineMonitor = hippyEngineMonitorAdapter;
        HippyUtils.addBaseApiProvider(this.providers);
        engineInitParams.providers = this.providers;
        fillEngineInitParams(engineInitParams);
        HippyEngine create = HippyEngine.create(engineInitParams);
        this.mHippyEngine = create;
        putEngineInstance(create.getId(), this);
        HippyEngineInitListener hippyEngineInitListener = new HippyEngineInitListener(this);
        this.mEngineInitListener = hippyEngineInitListener;
        this.mHippyEngine.initEngine(hippyEngineInitListener);
    }

    public void initHippyInContainer(@android.support.annotation.NonNull ViewGroup viewGroup, @android.support.annotation.NonNull JSONObject jSONObject, boolean z16, HippyQQEngineListener hippyQQEngineListener) {
        this.mModuleVersion = 0;
        this.mPageData = jSONObject;
        this.mEngineListener = hippyQQEngineListener;
        this.mContainer = viewGroup;
        this.mMapLoadStepsTime.put(HippyQQConstants.STEP_NAME_LOAD_LIBRARY_START, Long.valueOf(System.currentTimeMillis()));
        ((IHippyLibrary) QRoute.api(IHippyLibrary.class)).loadLibraryIfNeed(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initJsBundleTypeFromUrl() {
        if (TextUtils.isEmpty(this.mUrl)) {
            return;
        }
        adapterJsBundleType(this.mUrl);
    }

    protected boolean isCanCheckPackageUpdate() {
        if (TextUtils.isEmpty(this.mModuleName)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (mModuleUpdateTime.containsKey(this.mModuleName)) {
            long longValue = mModuleUpdateTime.get(this.mModuleName).longValue();
            long j3 = currentTimeMillis - longValue;
            if (this.mModuleVersion > 0 && longValue > 0 && j3 > 0 && j3 < 1800000) {
                return false;
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isCanInitHippyEngine() {
        return !isPageDestroyed();
    }

    public boolean isDebugMode() {
        if (HippyDebugUtil.isDebugEnable()) {
            if (TextUtils.isEmpty(mDebugMoudleName) || this.mModuleName.equals(mDebugMoudleName)) {
                return mDebugSwitch;
            }
            return false;
        }
        return false;
    }

    public boolean isDestroyed() {
        return this.mIsDestroyed;
    }

    public boolean isReady() {
        int moduleVersion;
        File moduleIndex;
        if (!((IHippyLibrary) QRoute.api(IHippyLibrary.class)).isLibraryLoaded() || (moduleVersion = ((IHippySetting) QRoute.api(IHippySetting.class)).getModuleVersion(this.mModuleName)) == -1 || (moduleIndex = ((IHippySetting) QRoute.api(IHippySetting.class)).getModuleIndex(this.mModuleName, moduleVersion)) == null || !moduleIndex.exists()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void loadModule() {
        int i3;
        String str;
        if (HippyDebugUtil.isDebugEnable() && !TextUtils.isEmpty(this.mOpenHippyInfo.bundleUrl)) {
            QLog.i(TAG, 1, "loadModule from bundleUrl:" + this.mOpenHippyInfo.bundleUrl);
            final long currentTimeMillis = System.currentTimeMillis();
            ((IHippyQQUpdate) QRoute.api(IHippyQQUpdate.class)).loadOnlineBundle(this.mOpenHippyInfo.bundleUrl, this.mModuleName, new PackageUpdateListener() { // from class: com.tencent.hippy.qq.app.HippyQQEngine.3
                @Override // com.tencent.hippy.qq.api.PackageUpdateListener
                public void onUpdateComplete(int i16, String str2, String str3) {
                    HippyQQEngine.this.doOnUpdateComplete(i16, str2, str3, currentTimeMillis);
                }
            });
            return;
        }
        int moduleVersion = ((IHippySetting) QRoute.api(IHippySetting.class)).getModuleVersion(this.mModuleName);
        if (moduleVersion < 0) {
            i3 = -5;
            str = "no jsbundle";
        } else if (moduleVersion < this.mOpenHippyInfo.minJsBundleVersion) {
            i3 = -12;
            str = "jsbundle too old";
        } else {
            File moduleIndex = ((IHippySetting) QRoute.api(IHippySetting.class)).getModuleIndex(this.mModuleName, moduleVersion);
            if (moduleIndex == null || !moduleIndex.exists()) {
                i3 = -13;
                str = "jsbundle doesn't exist";
            } else {
                this.mModuleVersion = moduleVersion;
                loadModule(moduleIndex.getAbsolutePath());
                i3 = 0;
                str = "";
            }
        }
        if (isCanCheckPackageUpdate()) {
            checkPackageUpdate();
        } else if (i3 != 0) {
            onLoadFail(i3, str);
        }
    }

    public boolean onConsumeBackKeyEvent() {
        return false;
    }

    public void onDestroy() {
        QLog.i(TAG, 1, "onDestroy this:" + this + " engine:" + this.mHippyEngine + " mIsDestroyed:" + this.mIsDestroyed);
        ((IHippyLibrary) QRoute.api(IHippyLibrary.class)).removeListener(this);
        HippyEngine hippyEngine = this.mHippyEngine;
        if (hippyEngine != null && !this.mIsDestroyed) {
            this.mIsDestroyed = true;
            hippyEngine.sendEvent(EVENT_PAGE_DESTORY, null);
            removeEngineInstance(this.mHippyEngine.getId());
            ((IHippyLifeCycleApi) QRoute.api(IHippyLifeCycleApi.class)).onDestroy();
            destroyEngine();
        }
        this.mFragment = null;
        this.activity = null;
        this.hippyActivityLifecycleOwner = null;
        this.mEngineListener = null;
    }

    protected void onEngineInitialized(HippyEngine.EngineInitStatus engineInitStatus, String str) {
        this.mMapLoadStepsTime.put(HippyQQConstants.STEP_NAME_INIT_ENGINE_END, Long.valueOf(System.currentTimeMillis()));
        if (engineInitStatus == HippyEngine.EngineInitStatus.STATUS_OK && !TextUtils.isEmpty(this.mOpenHippyInfo.ssrBundleUrl)) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!((IHippySSR) QRoute.api(IHippySSR.class)).loadSSRCommonJs(this, this.mOpenHippyInfo.minSSRCommonVersion)) {
                engineInitStatus = HippyEngine.EngineInitStatus.STATUS_WRONG_STATE;
                str = "SSR common js is too old";
            }
            this.mExecuteSSRCommonJsCost = System.currentTimeMillis() - currentTimeMillis;
        }
        onInitEngineComplete(engineInitStatus, str);
    }

    protected void onInitEngineComplete(HippyEngine.EngineInitStatus engineInitStatus, String str) {
        if (QLog.isColorLevel()) {
            QLog.d(HippyQQConstants.HIPPY_TAG, 1, "initEngine statusCode=", engineInitStatus, " msg=", str);
        }
        if (engineInitStatus != HippyEngine.EngineInitStatus.STATUS_OK) {
            onLoadFail(engineInitStatus.value(), str);
        } else if (isDebugMode()) {
            loadModule(HippyQQConstants.MAIN_BUNDLE_NAME);
        } else {
            loadModule();
        }
    }

    @Override // com.tencent.hippy.qq.api.LibraryLoadListener
    public void onLoadFail(int i3, String str) {
        QLog.e(TAG, 1, "load so error statusCode:" + i3 + " msg:" + str);
        HippyQQEngineListener hippyQQEngineListener = this.mEngineListener;
        if (hippyQQEngineListener != null) {
            hippyQQEngineListener.onError(i3, str);
        }
    }

    protected void onLoadModuleCompleted(HippyEngine.ModuleLoadStatus moduleLoadStatus, String str, HippyRootView hippyRootView) {
        QLog.i(TAG, 1, "loadModule onInitialized statusCode:" + moduleLoadStatus + " mIsResumed:" + this.mIsResumed);
        this.mMapLoadStepsTime.put(HippyQQConstants.STEP_NAME_LOAD_MODULE_END, Long.valueOf(System.currentTimeMillis()));
        if (this.mFragment == null && this.activity == null) {
            return;
        }
        if (hippyRootView != null && (moduleLoadStatus == HippyEngine.ModuleLoadStatus.STATUS_OK || moduleLoadStatus == HippyEngine.ModuleLoadStatus.STATUS_REPEAT_LOAD)) {
            addRootView(hippyRootView);
            HippyQQEngineListener hippyQQEngineListener = this.mEngineListener;
            if (hippyQQEngineListener != null) {
                hippyQQEngineListener.onSuccess();
            }
            this.mIsPageLoaded = true;
            HippyEngine hippyEngine = this.mHippyEngine;
            if (hippyEngine != null && this.mIsResumed) {
                hippyEngine.sendEvent(EVENT_PAGE_APPEAR, null);
                return;
            }
            return;
        }
        onLoadFail(moduleLoadStatus.value(), str);
    }

    @Override // com.tencent.hippy.qq.api.LibraryLoadListener
    public void onLoadSuccess() {
        this.mMapLoadStepsTime.put(HippyQQConstants.STEP_NAME_LOAD_LIBRARY_END, Long.valueOf(System.currentTimeMillis()));
        initHippyEngine();
    }

    protected void onModuleJsException(HippyJsException hippyJsException) {
        QLog.e(HippyQQConstants.HIPPY_TAG, 1, "onJsException exception:" + hippyJsException);
        HippyReporter.getInstance().reportException(this.mModuleName, this.mModuleVersion, 4, hippyJsException, generateReportExtraParams());
    }

    public void onPause() {
        QLog.i(TAG, 1, "onPause " + this.mModuleName + " this:" + this + " engine:" + this.mHippyEngine);
        this.mIsShowing = false;
        HippyEngine hippyEngine = this.mHippyEngine;
        if (hippyEngine != null) {
            hippyEngine.sendEvent(EVENT_PAGE_DISAPPEAR, null);
            this.mHippyEngine.onEnginePause();
        }
    }

    public void onResume() {
        QLog.i(TAG, 1, "onResume " + this.mModuleName + " this:" + this + " engine:" + this.mHippyEngine + " mIsResumed:" + this.mIsResumed + " mIsPageLoaded:" + this.mIsPageLoaded);
        this.mIsResumed = true;
        this.mIsShowing = true;
        HippyEngine hippyEngine = this.mHippyEngine;
        if (hippyEngine != null) {
            hippyEngine.onEngineResume();
            if (this.mIsPageLoaded) {
                this.mHippyEngine.sendEvent(EVENT_PAGE_APPEAR, null);
            }
        }
    }

    public void registerNativeMethod(String str, String str2, TJsCallBack tJsCallBack) {
        this.nativeProxy.registerNativeMethod(str, str2, tJsCallBack);
    }

    public void removeEngineListener() {
        this.mEngineListener = null;
    }

    public void removeSnapshotRootViewIfNeed() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime != null) {
            ((IHippyDomNodeManager) waitAppRuntime.getRuntimeService(IHippyDomNodeManager.class, ProcessConstant.MULTI)).removeSnapshotRootViewIfNeed(this.mHippyEngine, this.mContainer, this.snapshotRootView);
        }
    }

    public void runJavaScript(String str) {
        HippyEngine hippyEngine = this.mHippyEngine;
        if (hippyEngine != null) {
            hippyEngine.runScript(str);
        }
    }

    public void sendEvent(String str, Object obj) {
        HippyEngine hippyEngine = this.mHippyEngine;
        if (hippyEngine != null) {
            hippyEngine.sendEvent(str, obj);
        }
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void setComponentName(String str) {
        this.componentName = str;
    }

    public void setEngineMonitorAdapter(HippyEngineMonitorAdapter hippyEngineMonitorAdapter) {
        this.mEngineMonitorAdapter = hippyEngineMonitorAdapter;
    }

    public void setFragment(QBaseFragment qBaseFragment) {
        this.mFragment = qBaseFragment;
    }

    public final void setHippyActivityLifecycleOwner(HippyActivityLifecycleOwner hippyActivityLifecycleOwner) {
        this.hippyActivityLifecycleOwner = hippyActivityLifecycleOwner;
    }

    public void setHttpAdapter(IBaseHttpAdapter iBaseHttpAdapter) {
        this.mHttpAdapter = iBaseHttpAdapter;
    }

    public void setInitData(JSONObject jSONObject, JSONObject jSONObject2) {
        this.mGlobalData = jSONObject;
        this.mBusinessData = jSONObject2;
    }

    public void setJsBundleType(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mJsBundleType = str;
        }
    }

    public void setOnFirstViewAddedListener(HippyRootView.OnLoadCompleteListener onLoadCompleteListener) {
        this.mOnFirstViewAddedListener = onLoadCompleteListener;
    }

    public void setOpenHippyInfo(OpenHippyInfo openHippyInfo) {
        if (openHippyInfo == null) {
            this.mOpenHippyInfo = new OpenHippyInfo();
        } else {
            this.mOpenHippyInfo = openHippyInfo;
        }
    }

    public void setPageUrl(String str) {
        this.mUrl = str;
    }

    public void setPropsMap(HippyMap hippyMap) {
        this.propsMap = hippyMap;
    }

    public void setViewCreator(HippyCustomViewCreator hippyCustomViewCreator) {
        this.viewCreator = hippyCustomViewCreator;
    }

    public void unRegisterNativeMethod(String str, String str2) {
        this.nativeProxy.unRegisterNativeMethod(str, str2);
    }

    public void destroyEngineImmediately() {
        destroyEngineImmediately("default");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void loadModule(String str) {
        if (isPageDestroyed()) {
            return;
        }
        HippyEngine.ModuleLoadParams moduleLoadParams = new HippyEngine.ModuleLoadParams();
        moduleLoadParams.context = getActivity();
        moduleLoadParams.componentName = TextUtils.isEmpty(this.componentName) ? this.mModuleName : this.componentName;
        moduleLoadParams.jsFilePath = str;
        moduleLoadParams.nativeParams = getNativeParams();
        fillLoadParams(moduleLoadParams);
        moduleLoadParams.jsParams = getJsParamsMap(moduleLoadParams);
        this.mMapLoadStepsTime.put(HippyQQConstants.STEP_NAME_LOAD_MODULE_START, Long.valueOf(System.currentTimeMillis()));
        HippyEngineModuleListener hippyEngineModuleListener = new HippyEngineModuleListener(this);
        this.mModuleListener = hippyEngineModuleListener;
        this.mHippyRootView = this.mHippyEngine.loadModule(moduleLoadParams, hippyEngineModuleListener, this.mOnFirstViewAddedListener);
        tryAddSnapShotView(moduleLoadParams);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HippyQQEngine(Activity activity, String str, String str2) {
        this.activity = activity;
        if (activity instanceof HippyActivityLifecycleOwner) {
            setHippyActivityLifecycleOwner((HippyActivityLifecycleOwner) activity);
        }
        init(str, str2);
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class MyHippyExceptionHandlerAdapter implements HippyExceptionHandlerAdapter {
        private final WeakReference<HippyQQEngine> weakReference;

        public MyHippyExceptionHandlerAdapter(HippyQQEngine hippyQQEngine) {
            this.weakReference = new WeakReference<>(hippyQQEngine);
        }

        @Override // com.tencent.mtt.hippy.adapter.exception.HippyExceptionHandlerAdapter
        public void handleJsException(HippyJsException hippyJsException) {
            QLog.e(HippyQQConstants.HIPPY_TAG, 1, "handleJsException exception:" + hippyJsException);
            HippyQQEngine hippyQQEngine = this.weakReference.get();
            if (hippyQQEngine == null) {
                return;
            }
            HippyReporter.getInstance().reportException(hippyQQEngine.mModuleName, hippyQQEngine.mModuleVersion, 1, hippyJsException, hippyQQEngine.generateReportExtraParams());
        }

        @Override // com.tencent.mtt.hippy.adapter.exception.HippyExceptionHandlerAdapter
        public void handleNativeException(Exception exc, boolean z16) {
            QLog.e(HippyQQConstants.HIPPY_TAG, 1, "handleNativeExceptionhaveCaught:" + z16 + " exception:" + exc);
            HippyQQEngine hippyQQEngine = this.weakReference.get();
            if (hippyQQEngine == null) {
                return;
            }
            HippyReporter.getInstance().reportException(hippyQQEngine.mModuleName, hippyQQEngine.mModuleVersion, 2, exc, hippyQQEngine.generateReportExtraParams());
        }

        @Override // com.tencent.mtt.hippy.adapter.exception.HippyExceptionHandlerAdapter
        public void handleBackgroundTracing(String str) {
        }
    }

    protected void fillEngineInitParams(HippyEngine.EngineInitParams engineInitParams) {
    }

    protected void fillLoadParams(HippyEngine.ModuleLoadParams moduleLoadParams) {
    }

    public void reload(HippyQQEngineListener hippyQQEngineListener) {
    }

    @Deprecated
    public void setDebugMode(boolean z16) {
    }

    public void onActivityResult(int i3, int i16, Intent intent) {
    }
}
