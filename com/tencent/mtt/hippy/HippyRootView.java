package com.tencent.mtt.hippy;

import android.content.Context;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.a.e;
import com.tencent.mtt.hippy.adapter.device.HippyDeviceAdapter;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.common.HippyTag;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.javascriptmodules.Dimensions;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.mtt.hippy.utils.DimensionsUtil;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.utils.TimeMonitor;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyRootView extends FrameLayout {
    private static final AtomicInteger ID_COUNTER = new AtomicInteger(0);
    private static final int ROOT_VIEW_TAG_INCREMENT = 10;
    private HippyEngineContext mEngineContext;
    private GlobalLayoutListener mGlobalLayoutListener;
    private final int mInstanceId;
    protected boolean mLoadCompleted;
    private final HippyEngine.ModuleLoadParams mLoadParams;
    private OnLoadCompleteListener mOnLoadCompleteListener;
    private OnResumeAndPauseListener mOnResumeAndPauseListener;
    OnSizeChangedListener mSizeChangListener;
    private TimeMonitor mTimeMonitor;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class GlobalLayoutListener implements View.OnSystemUiVisibilityChangeListener, ViewTreeObserver.OnGlobalLayoutListener {
        private int mOrientation;

        GlobalLayoutListener() {
            this.mOrientation = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void checkUpdateDimension(int i3, int i16, boolean z16, boolean z17) {
            int i17;
            int i18;
            HippyDeviceAdapter deviceAdapter;
            if (HippyRootView.this.mEngineContext == null) {
                return;
            }
            DisplayMetrics displayMetrics = HippyRootView.this.getContext().getResources().getDisplayMetrics();
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            displayMetrics2.setTo(displayMetrics);
            try {
                ((WindowManager) HippyRootView.this.getContext().getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics2);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            HippyMap dimensions = DimensionsUtil.getDimensions(i3, i16, HippyRootView.this.mEngineContext.getGlobalConfigs().getContext(), z16);
            if (dimensions != null) {
                HippyMap map = dimensions.getMap("windowPhysicalPixels");
                i17 = map.getInt("width");
                i18 = map.getInt("height");
            } else {
                i17 = 0;
                i18 = 0;
            }
            if ((i16 < 0 || i17 == i18) && HippyRootView.this.mEngineContext.getGlobalConfigs() != null && (deviceAdapter = HippyRootView.this.mEngineContext.getGlobalConfigs().getDeviceAdapter()) != null) {
                deviceAdapter.reviseDimensionIfNeed(HippyRootView.this.getContext(), dimensions, z16, z17);
            }
            if (HippyRootView.this.mEngineContext.getModuleManager() != null) {
                ((Dimensions) HippyRootView.this.mEngineContext.getModuleManager().getJavaScriptModule(Dimensions.class)).set(dimensions);
            }
        }

        private void sendOrientationChangeEvent(int i3) {
            LogUtils.d("HippyRootView", "sendOrientationChangeEvent: orientation=" + i3);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i3;
            if (HippyRootView.this.getContext() != null && (i3 = HippyRootView.this.getContext().getResources().getConfiguration().orientation) != this.mOrientation) {
                this.mOrientation = i3;
                sendOrientationChangeEvent(i3);
                checkUpdateDimension(false, false);
            }
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i3) {
            if ((i3 & 2) == 0) {
                checkUpdateDimension(false, true);
            } else {
                checkUpdateDimension(true, true);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void checkUpdateDimension(boolean z16, boolean z17) {
            checkUpdateDimension(-1, -1, false, false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface OnLoadCompleteListener {
        void onLoadComplete(int i3, List<HippyEngineMonitorEvent> list);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface OnResumeAndPauseListener {
        void onInstancePause(int i3);

        void onInstanceResume(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface OnSizeChangedListener {
        void onSizeChanged(HippyRootView hippyRootView, int i3, int i16, int i17, int i18);
    }

    public HippyRootView(Context context, HippyEngine.ModuleLoadParams moduleLoadParams) {
        super(context);
        this.mLoadCompleted = false;
        this.mInstanceId = -10;
        setId(-10);
        setTag(HippyTag.createTagMap(NodeProps.ROOT_NODE, null));
        this.mLoadParams = moduleLoadParams;
    }

    private GlobalLayoutListener getGlobalLayoutListener() {
        if (this.mGlobalLayoutListener == null) {
            this.mGlobalLayoutListener = new GlobalLayoutListener();
        }
        return this.mGlobalLayoutListener;
    }

    public void attachEngineManager(HippyEngine hippyEngine) {
        ((HippyInstanceContext) getContext()).attachEngineManager(hippyEngine);
    }

    public void attachToEngine(HippyEngineContext hippyEngineContext) {
        this.mEngineContext = hippyEngineContext;
        ((HippyInstanceContext) getContext()).setEngineContext(hippyEngineContext);
        getGlobalLayoutListener().checkUpdateDimension(false, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void destroy() {
        if (getContext() instanceof HippyInstanceContext) {
            ((HippyInstanceContext) getContext()).notifyInstanceDestroy();
        }
    }

    public HippyEngineContext getEngineContext() {
        return this.mEngineContext;
    }

    public Context getHost() {
        return this.mLoadParams.context;
    }

    @Override // android.view.View
    public int getId() {
        return this.mInstanceId;
    }

    public HippyMap getLaunchParams() {
        return this.mLoadParams.jsParams;
    }

    public String getName() {
        return this.mLoadParams.componentName;
    }

    public TimeMonitor getTimeMonitor() {
        return this.mTimeMonitor;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            getViewTreeObserver().removeGlobalOnLayoutListener(getGlobalLayoutListener());
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        getViewTreeObserver().addOnGlobalLayoutListener(getGlobalLayoutListener());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            getViewTreeObserver().removeGlobalOnLayoutListener(getGlobalLayoutListener());
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        setMeasuredDimension(View.MeasureSpec.getSize(i3), View.MeasureSpec.getSize(i16));
    }

    public void onPause() {
        OnResumeAndPauseListener onResumeAndPauseListener = this.mOnResumeAndPauseListener;
        if (onResumeAndPauseListener != null) {
            onResumeAndPauseListener.onInstancePause(getId());
        }
    }

    public void onResume() {
        OnResumeAndPauseListener onResumeAndPauseListener = this.mOnResumeAndPauseListener;
        if (onResumeAndPauseListener != null) {
            onResumeAndPauseListener.onInstanceResume(getId());
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        HippyModuleManager moduleManager;
        super.onSizeChanged(i3, i16, i17, i18);
        if (i3 != i17 || i16 != i18) {
            getGlobalLayoutListener().checkUpdateDimension(i3, i16, false, false);
            HippyEngineContext hippyEngineContext = this.mEngineContext;
            if (hippyEngineContext != null && (moduleManager = hippyEngineContext.getModuleManager()) != null) {
                HippyMap hippyMap = new HippyMap();
                hippyMap.pushDouble("width", PixelUtil.px2dp(i3));
                hippyMap.pushDouble("height", PixelUtil.px2dp(i16));
                hippyMap.pushDouble("oldWidth", PixelUtil.px2dp(i17));
                hippyMap.pushDouble("oldHeight", PixelUtil.px2dp(i18));
                ((EventDispatcher) moduleManager.getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent(MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, hippyMap);
            }
            OnSizeChangedListener onSizeChangedListener = this.mSizeChangListener;
            if (onSizeChangedListener != null) {
                onSizeChangedListener.onSizeChanged(this, i3, i16, i17, i18);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        if (!this.mLoadCompleted && !(view instanceof e)) {
            this.mLoadCompleted = true;
            TimeMonitor timeMonitor = this.mTimeMonitor;
            if (timeMonitor != null) {
                timeMonitor.end();
                OnLoadCompleteListener onLoadCompleteListener = this.mOnLoadCompleteListener;
                if (onLoadCompleteListener != null) {
                    onLoadCompleteListener.onLoadComplete(this.mTimeMonitor.getTotalTime(), this.mTimeMonitor.getEvents());
                }
                if (getId() > 0) {
                    this.mEngineContext.getGlobalConfigs().getEngineMonitorAdapter().reportModuleLoadComplete(this, this.mTimeMonitor.getTotalTime(), this.mTimeMonitor.getEvents());
                }
            }
        }
    }

    public void setOnLoadCompleteListener(OnLoadCompleteListener onLoadCompleteListener) {
        this.mOnLoadCompleteListener = onLoadCompleteListener;
    }

    public void setOnResumeAndPauseListener(OnResumeAndPauseListener onResumeAndPauseListener) {
        this.mOnResumeAndPauseListener = onResumeAndPauseListener;
    }

    public void setOnSizeChangedListener(OnSizeChangedListener onSizeChangedListener) {
        this.mSizeChangListener = onSizeChangedListener;
    }

    public void setTimeMonitor(TimeMonitor timeMonitor) {
        this.mTimeMonitor = timeMonitor;
    }

    public void startMonitorEvent(String str) {
        TimeMonitor timeMonitor = this.mTimeMonitor;
        if (timeMonitor != null) {
            timeMonitor.startEvent(str);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HippyRootView(HippyEngine.ModuleLoadParams moduleLoadParams) {
        super(r0 == null ? new HippyInstanceContext(moduleLoadParams.context, moduleLoadParams) : r0);
        HippyInstanceContext hippyInstanceContext = moduleLoadParams.hippyContext;
        this.mLoadCompleted = false;
        this.mLoadParams = moduleLoadParams;
        int addAndGet = ID_COUNTER.addAndGet(10);
        this.mInstanceId = addAndGet;
        setId(addAndGet);
        setTag(HippyTag.createTagMap(NodeProps.ROOT_NODE, null));
        getViewTreeObserver().addOnGlobalLayoutListener(getGlobalLayoutListener());
        setOnSystemUiVisibilityChangeListener(getGlobalLayoutListener());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
    }
}
