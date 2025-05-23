package com.tencent.mtt.hippy.uimanager;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.mtt.hippy.uimanager.h;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes20.dex */
public class NativeGestureDispatcher implements h.a {
    private static final String KEY_EVENT_NAME = "name";
    private static final String KEY_PAGE_X = "page_x";
    private static final String KEY_PAGE_Y = "page_y";
    private static final String KEY_TAG_ID = "id";
    private static final String TAG = "NativeGestureDispatcher";
    private HippyEngineContext mEngineContext;
    private h mGestureProcessor;
    private HashSet<String> mGestureTypes = null;
    private final View mTargetView;
    private static final int TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
    private static final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher.1
        @Override // android.view.View.OnClickListener
        public void onClick(final View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view != null && (view.getContext() instanceof HippyInstanceContext)) {
                view.postDelayed(new Runnable() { // from class: com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int id5 = view.getId();
                        View view2 = view;
                        NativeGestureDispatcher.handleClick(view2, ((HippyInstanceContext) view2.getContext()).getEngineContext(), id5, false);
                    }
                }, NativeGestureDispatcher.TAP_TIMEOUT);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    };
    private static final View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher.2
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(final View view) {
            EventCollector.getInstance().onViewLongClickedBefore(view);
            if (view != null && (view.getContext() instanceof HippyInstanceContext)) {
                view.postDelayed(new Runnable() { // from class: com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        NativeGestureDispatcher.handleLongClick(((HippyInstanceContext) view.getContext()).getEngineContext(), view.getId());
                    }
                }, NativeGestureDispatcher.TAP_TIMEOUT);
            }
            EventCollector.getInstance().onViewLongClicked(view);
            return true;
        }
    };
    private static final View.OnAttachStateChangeListener mOnAttachedToWindowListener = new View.OnAttachStateChangeListener() { // from class: com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher.3
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            if (view != null && (view.getContext() instanceof HippyInstanceContext)) {
                NativeGestureDispatcher.handleAttachedToWindow(((HippyInstanceContext) view.getContext()).getEngineContext(), view.getId());
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    };
    private static final View.OnAttachStateChangeListener mOnDetachedFromWindowListener = new View.OnAttachStateChangeListener() { // from class: com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher.4
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (view != null && (view.getContext() instanceof HippyInstanceContext)) {
                NativeGestureDispatcher.handleDetachedFromWindow(((HippyInstanceContext) view.getContext()).getEngineContext(), view.getId());
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }
    };

    public NativeGestureDispatcher(View view) {
        this.mTargetView = view;
        if (view != null && (view.getContext() instanceof HippyInstanceContext)) {
            this.mEngineContext = ((HippyInstanceContext) view.getContext()).getEngineContext();
        }
    }

    private static void getLocationInWindow(HippyEngineContext hippyEngineContext, int i3, int[] iArr) {
        View findView;
        if (i3 >= 0 && (findView = hippyEngineContext.getRenderManager().getControllerManager().findView(i3)) != null) {
            findView.getLocationInWindow(iArr);
        }
    }

    public static View.OnAttachStateChangeListener getOnAttachedToWindowListener() {
        return mOnAttachedToWindowListener;
    }

    public static View.OnClickListener getOnClickListener() {
        return mOnClickListener;
    }

    public static View.OnAttachStateChangeListener getOnDetachedFromWindowListener() {
        return mOnDetachedFromWindowListener;
    }

    public static View.OnLongClickListener getOnLongClickListener() {
        return mOnLongClickListener;
    }

    public static void handleAttachedToWindow(HippyEngineContext hippyEngineContext, int i3) {
        if (hippyEngineContext == null) {
            return;
        }
        ((EventDispatcher) hippyEngineContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(i3, NodeProps.ON_ATTACHED_TO_WINDOW, null);
    }

    public static void handleClick(View view, HippyEngineContext hippyEngineContext, int i3, boolean z16) {
        if (hippyEngineContext == null) {
            return;
        }
        HippyEngineMonitorAdapter engineMonitorAdapter = hippyEngineContext.getGlobalConfigs().getEngineMonitorAdapter();
        if (engineMonitorAdapter != null && view != null) {
            engineMonitorAdapter.reportClickEvent(view, z16);
        }
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushString("name", NodeProps.ON_CLICK);
        hippyMap.pushInt("id", i3);
        ((EventDispatcher) hippyEngineContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeGesture(hippyMap);
        LogUtils.d(TAG, "send msg: onClick");
    }

    public static void handleDetachedFromWindow(HippyEngineContext hippyEngineContext, int i3) {
        if (hippyEngineContext == null) {
            return;
        }
        ((EventDispatcher) hippyEngineContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(i3, NodeProps.ON_DETACHED_FROM_WINDOW, null);
    }

    public static void handleLongClick(HippyEngineContext hippyEngineContext, int i3) {
        if (hippyEngineContext == null) {
            return;
        }
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushString("name", NodeProps.ON_LONG_CLICK);
        hippyMap.pushInt("id", i3);
        ((EventDispatcher) hippyEngineContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeGesture(hippyMap);
    }

    public static void handlePressIn(HippyEngineContext hippyEngineContext, int i3) {
        if (hippyEngineContext == null) {
            return;
        }
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushString("name", NodeProps.ON_PRESS_IN);
        hippyMap.pushInt("id", i3);
        ((EventDispatcher) hippyEngineContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeGesture(hippyMap);
        LogUtils.d(TAG, "send msg: onPressIn");
    }

    public static void handlePressOut(HippyEngineContext hippyEngineContext, int i3) {
        if (hippyEngineContext == null) {
            return;
        }
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushString("name", NodeProps.ON_PRESS_OUT);
        hippyMap.pushInt("id", i3);
        ((EventDispatcher) hippyEngineContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeGesture(hippyMap);
        LogUtils.d(TAG, "send msg: onPressIn");
    }

    public static void handleTouchCancel(HippyEngineContext hippyEngineContext, int i3, float f16, float f17, int i16) {
        getLocationInWindow(hippyEngineContext, i16, new int[2]);
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushString("name", "onTouchCancel");
        hippyMap.pushInt("id", i3);
        hippyMap.pushDouble(KEY_PAGE_X, PixelUtil.px2dp(r0[0] + f16));
        hippyMap.pushDouble(KEY_PAGE_Y, PixelUtil.px2dp(r0[1] + f17));
        ((EventDispatcher) hippyEngineContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeGesture(hippyMap);
    }

    public static void handleTouchDown(HippyEngineContext hippyEngineContext, int i3, float f16, float f17, int i16) {
        getLocationInWindow(hippyEngineContext, i16, new int[2]);
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushString("name", NodeProps.ON_TOUCH_DOWN);
        hippyMap.pushInt("id", i3);
        hippyMap.pushDouble(KEY_PAGE_X, PixelUtil.px2dp(r0[0] + f16));
        hippyMap.pushDouble(KEY_PAGE_Y, PixelUtil.px2dp(r0[1] + f17));
        ((EventDispatcher) hippyEngineContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeGesture(hippyMap);
    }

    public static void handleTouchEnd(HippyEngineContext hippyEngineContext, int i3, float f16, float f17, int i16) {
        getLocationInWindow(hippyEngineContext, i16, new int[2]);
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushString("name", "onTouchEnd");
        hippyMap.pushInt("id", i3);
        hippyMap.pushDouble(KEY_PAGE_X, PixelUtil.px2dp(r0[0] + f16));
        hippyMap.pushDouble(KEY_PAGE_Y, PixelUtil.px2dp(r0[1] + f17));
        ((EventDispatcher) hippyEngineContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeGesture(hippyMap);
    }

    public static void handleTouchMove(HippyEngineContext hippyEngineContext, int i3, float f16, float f17, int i16) {
        getLocationInWindow(hippyEngineContext, i16, new int[2]);
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushString("name", "onTouchMove");
        hippyMap.pushInt("id", i3);
        hippyMap.pushDouble(KEY_PAGE_X, PixelUtil.px2dp(r0[0] + f16));
        hippyMap.pushDouble(KEY_PAGE_Y, PixelUtil.px2dp(r0[1] + f17));
        ((EventDispatcher) hippyEngineContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeGesture(hippyMap);
    }

    public void addGestureType(String str) {
        if (this.mGestureTypes == null) {
            this.mGestureTypes = new HashSet<>();
        }
        this.mGestureTypes.add(str);
    }

    @Override // com.tencent.mtt.hippy.uimanager.h.a
    public void handle(String str, float f16, float f17) {
        if (this.mTargetView == null) {
            LogUtils.e(TAG, "handle!!! but view is null!!!!");
            return;
        }
        if (TextUtils.equals(str, NodeProps.ON_PRESS_IN)) {
            handlePressIn(this.mEngineContext, this.mTargetView.getId());
            return;
        }
        if (TextUtils.equals(str, NodeProps.ON_PRESS_OUT)) {
            handlePressOut(this.mEngineContext, this.mTargetView.getId());
            return;
        }
        if (TextUtils.equals(str, NodeProps.ON_TOUCH_DOWN)) {
            handleTouchDown(this.mEngineContext, this.mTargetView.getId(), f16, f17, this.mTargetView.getId());
            return;
        }
        if (TextUtils.equals(str, "onTouchMove")) {
            handleTouchMove(this.mEngineContext, this.mTargetView.getId(), f16, f17, this.mTargetView.getId());
        } else if (TextUtils.equals(str, "onTouchEnd")) {
            handleTouchEnd(this.mEngineContext, this.mTargetView.getId(), f16, f17, this.mTargetView.getId());
        } else if (TextUtils.equals(str, "onTouchCancel")) {
            handleTouchCancel(this.mEngineContext, this.mTargetView.getId(), f16, f17, this.mTargetView.getId());
        }
    }

    public boolean handleTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureProcessor == null) {
            this.mGestureProcessor = new h(this);
        }
        return this.mGestureProcessor.a(motionEvent);
    }

    @Override // com.tencent.mtt.hippy.uimanager.h.a
    public boolean needHandle(String str) {
        HashSet<String> hashSet = this.mGestureTypes;
        if (hashSet != null) {
            boolean contains = hashSet.contains(str);
            if (!contains && !TextUtils.equals(str, NodeProps.ON_INTERCEPT_TOUCH_EVENT) && !TextUtils.equals(str, NodeProps.ON_INTERCEPT_PULL_UP_EVENT) && (needHandle(NodeProps.ON_INTERCEPT_TOUCH_EVENT) || needHandle(NodeProps.ON_INTERCEPT_PULL_UP_EVENT))) {
                return true;
            }
            return contains;
        }
        return false;
    }

    public void removeGestureType(String str) {
        HashSet<String> hashSet = this.mGestureTypes;
        if (hashSet != null) {
            hashSet.remove(str);
        }
    }
}
