package com.tencent.mtt.hippy.uimanager;

import android.content.Context;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mapsdk.internal.by;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.common.HippyTag;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.dom.node.StyleNode;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.g;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.views.common.CommonBorder;
import com.tencent.mtt.hippy.views.hippylist.HippyRecyclerViewWrapper;
import com.tencent.mtt.hippy.views.list.HippyListView;
import com.tencent.mtt.hippy.views.scroll.HippyScrollView;
import com.tencent.mtt.hippy.views.view.HippyViewGroupController;
import com.tencent.mtt.supportui.views.IGradient;
import com.tencent.mtt.supportui.views.IShadow;
import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public abstract class HippyViewController<T extends View & HippyViewBase> implements View.OnFocusChangeListener {
    public static final String FAKE_NODE_TAG = "fake";
    private static final String TAG = "HippyViewController";
    private static final g.a sMatrixDecompositionContext = new g.a();
    private static final double[] sTransformDecompositionArray = new double[16];
    private boolean bUserChageFocus = false;
    private Class mSubClass;
    private Method[] mSubClassMethods;

    private void applyTransform(T t16, HippyArray hippyArray) {
        double[] dArr = sTransformDecompositionArray;
        l.a(hippyArray, dArr);
        g.a aVar = sMatrixDecompositionContext;
        aVar.a();
        g.a(dArr, aVar);
        t16.setTranslationX(PixelUtil.dp2px((float) aVar.f337687e[0]));
        t16.setTranslationY(PixelUtil.dp2px((float) aVar.f337687e[1]));
        t16.setRotation((float) aVar.f337688f[2]);
        t16.setRotationX((float) aVar.f337688f[0]);
        t16.setRotationY((float) aVar.f337688f[1]);
        t16.setScaleX((float) aVar.f337685c[0]);
        t16.setScaleY((float) aVar.f337685c[1]);
    }

    private Method[] getSubClassDeclaredMethods() {
        if (this.mSubClassMethods == null) {
            this.mSubClassMethods = getClass().getDeclaredMethods();
        }
        return this.mSubClassMethods;
    }

    private Class getSubViewClass() {
        Type[] actualTypeArguments;
        Class cls = this.mSubClass;
        if (cls != null) {
            return cls;
        }
        Type genericSuperclass = getClass().getGenericSuperclass();
        if ((genericSuperclass instanceof ParameterizedType) && (actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments()) != null && actualTypeArguments.length > 0) {
            Type type = actualTypeArguments[0];
            if (type instanceof Class) {
                Class cls2 = (Class) type;
                this.mSubClass = cls2;
                return cls2;
            }
        }
        return null;
    }

    private boolean isInSubClass(String str) {
        Method[] subClassDeclaredMethods = getSubClassDeclaredMethods();
        if (subClassDeclaredMethods == null) {
            return false;
        }
        for (Method method : subClassDeclaredMethods) {
            if (method.getName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static void resetTransform(View view) {
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
        view.setRotation(0.0f);
        view.setRotationX(0.0f);
        view.setRotationY(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addView(ViewGroup viewGroup, View view, int i3) {
        if (i3 > viewGroup.getChildCount()) {
            i3 = viewGroup.getChildCount();
        }
        try {
            viewGroup.addView(view, i3);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public boolean canControlView(View view, String str) {
        try {
            Class subViewClass = getSubViewClass();
            if (subViewClass == null || subViewClass.isInstance(view)) {
                return true;
            }
            return !isInSubClass(str);
        } catch (Throwable unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public StyleNode createNode(boolean z16) {
        return new StyleNode();
    }

    public RenderNode createRenderNode(int i3, HippyMap hippyMap, String str, HippyRootView hippyRootView, ControllerManager controllerManager, boolean z16) {
        return new RenderNode(i3, hippyMap, str, hippyRootView, controllerManager, z16);
    }

    public View createView(HippyRootView hippyRootView, int i3, HippyEngineContext hippyEngineContext, String str, HippyMap hippyMap) {
        Map nativeParams;
        if (i3 < 0) {
            hippyMap.pushBoolean("fake", true);
        }
        View view = null;
        if (hippyRootView != null) {
            Context context = hippyRootView.getContext();
            if ((context instanceof HippyInstanceContext) && (nativeParams = ((HippyInstanceContext) context).getNativeParams()) != null) {
                Object obj = nativeParams.get(HippyCustomViewCreator.HIPPY_CUSTOM_VIEW_CREATOR);
                if (obj instanceof HippyCustomViewCreator) {
                    view = ((HippyCustomViewCreator) obj).createCustomView(str, hippyRootView.getContext(), hippyMap);
                }
            }
            if (view == null && (view = createViewImpl(hippyRootView.getContext(), hippyMap)) == null) {
                view = createViewImpl(hippyRootView.getContext());
            }
            if (i3 < 0) {
                if (view instanceof HippyRecyclerViewWrapper) {
                    ((HippyRecyclerViewWrapper) view).setScrollEnable(false);
                }
                if (view instanceof HippyListView) {
                    ((HippyListView) view).setScrollEnable(false);
                }
                if (view instanceof HippyScrollView) {
                    ((HippyScrollView) view).setScrollEnabled(false);
                }
            }
            LogUtils.d(TAG, "createView id " + i3);
            view.setId(i3);
            view.setTag(HippyTag.createTagMap(str, hippyMap));
        }
        return view;
    }

    @Deprecated
    protected abstract View createViewImpl(Context context);

    protected View createViewImpl(Context context, HippyMap hippyMap) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void deleteChild(ViewGroup viewGroup, View view) {
        viewGroup.removeView(view);
    }

    public void dispatchFunction(T t16, String str, HippyArray hippyArray) {
    }

    public View getChildAt(T t16, int i3) {
        if (t16 instanceof ViewGroup) {
            return ((ViewGroup) t16).getChildAt(i3);
        }
        return null;
    }

    public int getChildCount(T t16) {
        if (t16 instanceof ViewGroup) {
            return ((ViewGroup) t16).getChildCount();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getInnerPath(HippyInstanceContext hippyInstanceContext, String str) {
        String str2;
        if (str != null && str.startsWith("hpfile://")) {
            String replace = str.replace("hpfile://./", "");
            if (hippyInstanceContext.getBundleLoader() != null) {
                str2 = hippyInstanceContext.getBundleLoader().getPath();
            } else {
                str2 = null;
            }
            if (str2 == null) {
                return null;
            }
            return ((Object) str2.subSequence(0, str2.lastIndexOf(File.separator) + 1)) + replace;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean handleGestureBySelf() {
        return false;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z16) {
        if (this.bUserChageFocus) {
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushBoolean(WSPublicAccReport.SOP_NAME_FOCUS, z16);
            new HippyViewEvent("onFocus").send(view, hippyMap);
        }
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = NodeProps.REQUEST_FOCUS)
    public void requestFocus(final T t16, boolean z16) {
        if (z16) {
            Looper.getMainLooper();
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.tencent.mtt.hippy.uimanager.HippyViewController.1
                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() {
                    HippyViewController.this.bUserChageFocus = true;
                    if (!t16.requestFocusFromTouch()) {
                        LogUtils.d(NodeProps.REQUEST_FOCUS, "requestFocus result:" + t16.requestFocus());
                    }
                    HippyViewController.this.bUserChageFocus = false;
                    return false;
                }
            });
        }
    }

    @HippyControllerProps(name = NodeProps.PROP_ACCESSIBILITY_LABEL)
    public void setAccessibilityLabel(T t16, String str) {
        if (str == null) {
            str = "";
        }
        t16.setContentDescription(str);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = NodeProps.ON_ATTACHED_TO_WINDOW)
    public void setAttachedToWindowHandle(T t16, boolean z16) {
        if (z16) {
            t16.addOnAttachStateChangeListener(NativeGestureDispatcher.getOnAttachedToWindowListener());
        } else {
            t16.removeOnAttachStateChangeListener(NativeGestureDispatcher.getOnAttachedToWindowListener());
        }
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = "backgroundColor")
    public void setBackground(T t16, int i3) {
        t16.setBackgroundColor(i3);
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.BORDER_BOTTOM_COLOR)
    public void setBorderBottomWidth(T t16, int i3) {
        if (t16 instanceof CommonBorder) {
            ((CommonBorder) t16).setBorderColor(i3, CommonBorder.BorderWidthDirection.BOTTOM.ordinal());
        }
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.BORDER_COLOR)
    public void setBorderColor(T t16, int i3) {
        if (t16 instanceof CommonBorder) {
            ((CommonBorder) t16).setBorderColor(i3, CommonBorder.BorderWidthDirection.ALL.ordinal());
        }
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.BORDER_LEFT_COLOR)
    public void setBorderLeftColor(T t16, int i3) {
        if (t16 instanceof CommonBorder) {
            ((CommonBorder) t16).setBorderColor(i3, CommonBorder.BorderWidthDirection.LEFT.ordinal());
        }
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.BORDER_RADIUS)
    public void setBorderRadius(T t16, float f16) {
        if (t16 instanceof CommonBorder) {
            ((CommonBorder) t16).setBorderRadius(f16, CommonBorder.BorderRadiusDirection.ALL.ordinal());
        }
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.BORDER_RIGHT_COLOR)
    public void setBorderRightWidth(T t16, int i3) {
        if (t16 instanceof CommonBorder) {
            ((CommonBorder) t16).setBorderColor(i3, CommonBorder.BorderWidthDirection.RIGHT.ordinal());
        }
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.BORDER_TOP_COLOR)
    public void setBorderTopWidth(T t16, int i3) {
        if (t16 instanceof CommonBorder) {
            ((CommonBorder) t16).setBorderColor(i3, CommonBorder.BorderWidthDirection.TOP.ordinal());
        }
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.BORDER_WIDTH)
    public void setBorderWidth(T t16, float f16) {
        if (t16 instanceof CommonBorder) {
            ((CommonBorder) t16).setBorderWidth(f16, CommonBorder.BorderWidthDirection.ALL.ordinal());
        }
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.BORDER_BOTTOM_WIDTH)
    public void setBottomBorderWidth(T t16, float f16) {
        if (t16 instanceof CommonBorder) {
            ((CommonBorder) t16).setBorderWidth(f16, CommonBorder.BorderWidthDirection.BOTTOM.ordinal());
        }
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.BORDER_BOTTOM_LEFT_RADIUS)
    public void setBottomLeftBorderRadius(T t16, float f16) {
        if (t16 instanceof CommonBorder) {
            ((CommonBorder) t16).setBorderRadius(f16, CommonBorder.BorderRadiusDirection.BOTTOM_LEFT.ordinal());
        }
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.BORDER_BOTTOM_RIGHT_RADIUS)
    public void setBottomRightBorderRadius(T t16, float f16) {
        if (t16 instanceof CommonBorder) {
            ((CommonBorder) t16).setBorderRadius(f16, CommonBorder.BorderRadiusDirection.BOTTOM_RIGHT.ordinal());
        }
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = NodeProps.ON_CLICK)
    public void setClickable(T t16, boolean z16) {
        if (!handleGestureBySelf()) {
            if (z16) {
                t16.setOnClickListener(NativeGestureDispatcher.getOnClickListener());
            } else {
                t16.setOnClickListener(null);
                t16.setClickable(false);
            }
        }
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = NodeProps.ON_DETACHED_FROM_WINDOW)
    public void setDetachedFromWindowHandle(T t16, boolean z16) {
        if (z16) {
            t16.addOnAttachStateChangeListener(NativeGestureDispatcher.getOnDetachedFromWindowListener());
        } else {
            t16.removeOnAttachStateChangeListener(NativeGestureDispatcher.getOnDetachedFromWindowListener());
        }
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = NodeProps.FOCUSABLE)
    public void setFocusable(T t16, boolean z16) {
        t16.setFocusable(z16);
        t16.setFocusableInTouchMode(z16);
        if (z16) {
            t16.setOnFocusChangeListener(this);
        } else {
            t16.setOnFocusChangeListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setGestureType(T t16, String str, boolean z16) {
        if (z16) {
            T t17 = t16;
            if (t17.getGestureDispatcher() == null) {
                t17.setGestureDispatcher(new NativeGestureDispatcher(t16));
            }
            t17.getGestureDispatcher().addGestureType(str);
            return;
        }
        T t18 = t16;
        if (t18.getGestureDispatcher() != null) {
            t18.getGestureDispatcher().removeGestureType(str);
        }
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.BORDER_LEFT_WIDTH)
    public void setLeftBorderWidth(T t16, float f16) {
        if (t16 instanceof CommonBorder) {
            ((CommonBorder) t16).setBorderWidth(f16, CommonBorder.BorderWidthDirection.LEFT.ordinal());
        }
    }

    @HippyControllerProps(defaultType = "map", name = NodeProps.LINEAR_GRADIENT)
    public void setLinearGradient(T t16, HippyMap hippyMap) {
        float f16;
        if (t16 instanceof IGradient) {
            if (hippyMap == null) {
                IGradient iGradient = (IGradient) t16;
                iGradient.setGradientAngle(null);
                iGradient.setGradientColors(null);
                iGradient.setGradientPositions(null);
                return;
            }
            String string = hippyMap.getString("angle");
            HippyArray array = hippyMap.getArray("colorStopList");
            if (!TextUtils.isEmpty(string) && array != null && array.size() != 0) {
                int size = array.size();
                ArrayList<Integer> arrayList = new ArrayList<>();
                ArrayList<Float> arrayList2 = new ArrayList<>();
                for (int i3 = 0; i3 < size; i3++) {
                    HippyMap map = array.getMap(i3);
                    if (map != null) {
                        arrayList.add(Integer.valueOf(map.getInt("color")));
                        if (map.containsKey("ratio")) {
                            f16 = (float) map.getDouble("ratio");
                        } else if (i3 == size - 1) {
                            f16 = 1.0f;
                        } else {
                            f16 = 0.0f;
                        }
                        arrayList2.add(Float.valueOf(f16));
                    }
                }
                IGradient iGradient2 = (IGradient) t16;
                iGradient2.setGradientAngle(string);
                iGradient2.setGradientColors(arrayList);
                iGradient2.setGradientPositions(arrayList2);
            }
        }
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = NodeProps.ON_LONG_CLICK)
    public void setLongClickable(T t16, boolean z16) {
        if (!handleGestureBySelf()) {
            if (z16) {
                t16.setOnLongClickListener(NativeGestureDispatcher.getOnLongClickListener());
            } else {
                t16.setOnLongClickListener(null);
                t16.setLongClickable(false);
            }
        }
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = NodeProps.NEXT_FOCUS_DOWN_ID)
    public void setNextFocusDownId(T t16, int i3) {
        t16.setNextFocusDownId(i3);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = NodeProps.NEXT_FOCUS_LEFT_ID)
    public void setNextFocusLeftId(T t16, int i3) {
        t16.setNextFocusLeftId(i3);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = NodeProps.NEXT_FOCUS_RIGHT_ID)
    public void setNextFocusRightId(T t16, int i3) {
        t16.setNextFocusRightId(i3);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = NodeProps.NEXT_FOCUS_UP_ID)
    public void setNextFocusUpId(T t16, int i3) {
        t16.setNextFocusUpId(i3);
    }

    @HippyControllerProps(defaultNumber = by.f147964a, defaultType = "number", name = "opacity")
    public void setOpacity(T t16, float f16) {
        t16.setAlpha(f16);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = NodeProps.ON_PRESS_IN)
    public void setPressInable(T t16, boolean z16) {
        if (!handleGestureBySelf()) {
            setGestureType(t16, NodeProps.ON_PRESS_IN, z16);
        }
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = NodeProps.ON_PRESS_OUT)
    public void setPressOutable(T t16, boolean z16) {
        if (!handleGestureBySelf()) {
            setGestureType(t16, NodeProps.ON_PRESS_OUT, z16);
        }
    }

    @HippyControllerProps(defaultBoolean = false, defaultType = HippyControllerProps.BOOLEAN, name = "renderToHardwareTextureAndroid")
    public void setRenderToHardwareTexture(T t16, boolean z16) {
        int i3;
        if (z16) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        t16.setLayerType(i3, null);
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.BORDER_RIGHT_WIDTH)
    public void setRightBorderWidth(T t16, float f16) {
        if (t16 instanceof CommonBorder) {
            ((CommonBorder) t16).setBorderWidth(f16, CommonBorder.BorderWidthDirection.RIGHT.ordinal());
        }
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.SHADOW_COLOR)
    public void setShadowColor(T t16, int i3) {
        if (t16 instanceof IShadow) {
            ((IShadow) t16).setShadowColor(i3);
        }
    }

    @HippyControllerProps(defaultType = "map", name = NodeProps.SHADOW_OFFSET)
    public void setShadowOffset(T t16, HippyMap hippyMap) {
        if (hippyMap != null && (t16 instanceof IShadow)) {
            float f16 = hippyMap.getInt(HippyTKDListViewAdapter.X);
            float f17 = hippyMap.getInt("y");
            IShadow iShadow = (IShadow) t16;
            iShadow.setShadowOffsetX(f16);
            iShadow.setShadowOffsetY(f17);
        }
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.SHADOW_OFFSET_X)
    public void setShadowOffsetX(T t16, float f16) {
        if (t16 instanceof IShadow) {
            ((IShadow) t16).setShadowOffsetX(f16);
        }
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.SHADOW_OFFSET_Y)
    public void setShadowOffsetY(T t16, float f16) {
        if (t16 instanceof IShadow) {
            ((IShadow) t16).setShadowOffsetY(f16);
        }
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.SHADOW_OPACITY)
    public void setShadowOpacity(T t16, float f16) {
        if (t16 instanceof IShadow) {
            ((IShadow) t16).setShadowOpacity(f16);
        }
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.SHADOW_RADIUS)
    public void setShadowRadius(T t16, float f16) {
        if (t16 instanceof IShadow) {
            ((IShadow) t16).setShadowRadius(f16);
        }
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.SHADOW_SPREAD)
    public void setShadowSpread(T t16, float f16) {
        if (t16 instanceof IShadow) {
            ((IShadow) t16).setShadowSpread(f16);
        }
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.BORDER_TOP_WIDTH)
    public void setTopBorderWidth(T t16, float f16) {
        if (t16 instanceof CommonBorder) {
            ((CommonBorder) t16).setBorderWidth(f16, CommonBorder.BorderWidthDirection.TOP.ordinal());
        }
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.BORDER_TOP_LEFT_RADIUS)
    public void setTopLeftBorderRadius(T t16, float f16) {
        if (t16 instanceof CommonBorder) {
            ((CommonBorder) t16).setBorderRadius(f16, CommonBorder.BorderRadiusDirection.TOP_LEFT.ordinal());
        }
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.BORDER_TOP_RIGHT_RADIUS)
    public void setTopRightBorderRadius(T t16, float f16) {
        if (t16 instanceof CommonBorder) {
            ((CommonBorder) t16).setBorderRadius(f16, CommonBorder.BorderRadiusDirection.TOP_RIGHT.ordinal());
        }
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "onTouchCancel")
    public void setTouchCancelHandle(T t16, boolean z16) {
        if (!handleGestureBySelf()) {
            setGestureType(t16, "onTouchCancel", z16);
        }
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = NodeProps.ON_TOUCH_DOWN)
    public void setTouchDownHandle(T t16, boolean z16) {
        if (!handleGestureBySelf()) {
            setGestureType(t16, NodeProps.ON_TOUCH_DOWN, z16);
        }
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "onTouchEnd")
    public void setTouchEndHandle(T t16, boolean z16) {
        if (!handleGestureBySelf()) {
            setGestureType(t16, "onTouchEnd", z16);
        }
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "onTouchMove")
    public void setTouchMoveHandle(T t16, boolean z16) {
        if (!handleGestureBySelf()) {
            setGestureType(t16, "onTouchMove", z16);
        }
    }

    @HippyControllerProps(defaultType = HippyControllerProps.ARRAY, name = "transform")
    public void setTransform(T t16, HippyArray hippyArray) {
        if (hippyArray == null) {
            resetTransform(t16);
        } else {
            applyTransform(t16, hippyArray);
        }
    }

    @HippyControllerProps(defaultString = NodeProps.VISIBLE, defaultType = HippyControllerProps.STRING, name = "visibility")
    public void setVisibility(T t16, String str) {
        int i3;
        if (!TextUtils.isEmpty(str) && !NodeProps.VISIBLE.equals(str)) {
            if ("hidden".equals(str)) {
                i3 = 4;
            } else {
                throw new RuntimeException("Invalid visibility: " + str);
            }
        } else {
            i3 = 0;
        }
        t16.setVisibility(i3);
    }

    @HippyControllerProps(defaultBoolean = true, defaultType = HippyControllerProps.BOOLEAN, name = "setVisible")
    @Deprecated
    public void setVisible(T t16, boolean z16) {
        int i3;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 4;
        }
        t16.setVisibility(i3);
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.Z_INDEX)
    public void setZIndex(T t16, int i3) {
        HippyViewGroupController.setViewZIndex(t16, i3);
        ViewParent parent = t16.getParent();
        if (parent instanceof e) {
            ((e) parent).updateDrawingOrder();
        }
    }

    protected boolean shouldInterceptLayout(View view, int i3, int i16, int i17, int i18) {
        return false;
    }

    public void updateLayout(int i3, int i16, int i17, int i18, int i19, b bVar) {
        View a16 = bVar.a(i3);
        if (a16 != null) {
            a16.measure(View.MeasureSpec.makeMeasureSpec(i18, 1073741824), View.MeasureSpec.makeMeasureSpec(i19, 1073741824));
            if (!shouldInterceptLayout(a16, i16, i17, i18, i19)) {
                a16.layout(i16, i17, i18 + i16, i19 + i17);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public StyleNode createNode(boolean z16, int i3) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void deleteChild(ViewGroup viewGroup, View view, int i3) {
        deleteChild(viewGroup, view);
    }

    public void dispatchFunction(T t16, String str, HippyArray hippyArray, Promise promise) {
    }

    public void onAfterUpdateProps(T t16) {
    }

    public void onBatchComplete(T t16) {
    }

    public void onBatchStart(T t16) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onManageChildComplete(T t16) {
    }

    public void onViewDestroy(T t16) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateExtra(View view, Object obj) {
    }

    @HippyControllerProps(name = NodeProps.CUSTOM_PROP)
    public void setCustomProp(T t16, String str, Object obj) {
    }
}
