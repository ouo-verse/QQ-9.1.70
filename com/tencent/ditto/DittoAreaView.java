package com.tencent.ditto;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.ditto.annoations.DittoField;
import com.tencent.ditto.annoations.DittoOnClick;
import com.tencent.ditto.annoations.DittoOnLongClick;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoAreaGroup;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.func.DittoIdFuncPoly;
import com.tencent.ditto.func.DittoIdFuncPolyInf;
import com.tencent.ditto.reflect.DittoValue;
import com.tencent.ditto.shell.DittoUIEngine;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.ditto.utils.DittoLog;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DittoAreaView extends View implements DittoHost {
    private static final Map<Class<? extends DittoAreaView>, DittoIdFuncPolyInf> REFLECT_FUNC_POLY_MAP = new ConcurrentHashMap();
    protected static volatile Map<Class<? extends DittoAreaView>, DittoIdFuncPolyInf> sAptIdFuncPolyMap;
    protected final Set<DittoArea> exposureReportingAreas;
    private boolean hardwareAccelerationTurned;
    protected DittoArea mDittoArea;
    private DittoHost mHost;
    protected Handler mMainHandler;
    private List<KVCNode> needKVCAreas;
    private Object viewModel;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class KVCNode {
        DittoArea area;

        /* renamed from: id, reason: collision with root package name */
        String f100543id;
        Map<String, DittoValue> kvcSet;

        KVCNode(DittoArea dittoArea, Map<String, DittoValue> map) {
            this.area = dittoArea;
            this.f100543id = dittoArea.getId();
            this.kvcSet = map;
        }
    }

    public DittoAreaView(Context context) {
        super(context);
        this.exposureReportingAreas = new HashSet();
        this.hardwareAccelerationTurned = false;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.needKVCAreas = Collections.synchronizedList(new ArrayList());
    }

    private static void classFieldList(Class cls, ArrayList<Field> arrayList) {
        if (cls == DittoAreaView.class) {
            return;
        }
        arrayList.addAll(Arrays.asList(cls.getDeclaredFields()));
        classFieldList(cls.getSuperclass(), arrayList);
    }

    private static void classMethodList(Class cls, ArrayList<Method> arrayList) {
        if (cls == DittoAreaView.class) {
            return;
        }
        arrayList.addAll(Arrays.asList(cls.getDeclaredMethods()));
        classMethodList(cls.getSuperclass(), arrayList);
    }

    private void doSetUIElement(DittoArea dittoArea) {
        if (this.mDittoArea == dittoArea) {
            return;
        }
        this.mDittoArea = dittoArea;
        requestLayout();
    }

    public static ArrayMap<String, Field> getFields(Class cls) {
        ArrayMap<String, Field> arrayMap = new ArrayMap<>();
        ArrayList arrayList = new ArrayList();
        classFieldList(cls, arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Field field = (Field) it.next();
            Annotation annotation = field.getAnnotation(DittoField.class);
            if (annotation != null && DittoArea.class.isAssignableFrom(field.getType())) {
                String value = ((DittoField) annotation).value();
                if ("0".equals(value)) {
                    value = field.getName();
                }
                arrayMap.put(value, field);
            }
        }
        return arrayMap;
    }

    public static int[] getLocationToViewHost(DittoArea dittoArea) {
        int paddingTop;
        int paddingLeft;
        if (dittoArea == null) {
            return new int[]{0, 0};
        }
        int[] iArr = new int[2];
        DittoArea dittoArea2 = dittoArea;
        int i3 = 0;
        int i16 = 0;
        while (dittoArea2 != null) {
            i16 += dittoArea2.getLeft();
            i3 += dittoArea2.getTop();
            dittoArea2 = dittoArea2.getParent();
            if (dittoArea2 != null) {
                i16 += dittoArea2.getPaddingLeft();
                i3 += dittoArea2.getPaddingTop();
            }
        }
        if (dittoArea.getHost() == null) {
            paddingTop = 0;
        } else {
            paddingTop = dittoArea.getHost().getPaddingTop();
        }
        int i17 = i3 + paddingTop;
        if (dittoArea.getHost() == null) {
            paddingLeft = 0;
        } else {
            paddingLeft = dittoArea.getHost().getPaddingLeft();
        }
        iArr[0] = i16 + paddingLeft;
        iArr[1] = i17;
        return iArr;
    }

    public static ArrayMap<String, Method>[] getMethods(Class cls) {
        ArrayMap<String, Method>[] arrayMapArr = {new ArrayMap<>(), new ArrayMap<>()};
        ArrayList arrayList = new ArrayList();
        classMethodList(cls, arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Method method = (Method) it.next();
            for (Annotation annotation : method.getAnnotations()) {
                if (annotation instanceof DittoOnClick) {
                    DittoOnClick dittoOnClick = (DittoOnClick) annotation;
                    if (dittoOnClick.values().length != 0) {
                        for (String str : dittoOnClick.values()) {
                            arrayMapArr[0].put(str, method);
                        }
                    }
                    if (!dittoOnClick.value().equals("0") && !arrayMapArr[0].containsKey(dittoOnClick.value())) {
                        arrayMapArr[0].put(dittoOnClick.value(), method);
                    }
                } else if (annotation instanceof DittoOnLongClick) {
                    DittoOnLongClick dittoOnLongClick = (DittoOnLongClick) annotation;
                    if (dittoOnLongClick.values().length != 0) {
                        for (String str2 : dittoOnLongClick.values()) {
                            arrayMapArr[1].put(str2, method);
                        }
                    }
                    if (!dittoOnLongClick.value().equals("0") && !arrayMapArr[1].containsKey(dittoOnLongClick.value())) {
                        arrayMapArr[1].put(dittoOnLongClick.value(), method);
                    }
                }
            }
        }
        return arrayMapArr;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (getTouchDelegate() != null) {
            getTouchDelegate().onTouchEvent(motionEvent);
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        motionEvent.offsetLocation(paddingLeft * (-1), paddingTop * (-1));
        DittoArea dittoArea = this.mDittoArea;
        if (dittoArea != null && dittoArea.dispatchTouchEvent(motionEvent)) {
            return true;
        }
        motionEvent.offsetLocation(paddingLeft, paddingTop);
        return super.dispatchTouchEvent(motionEvent);
    }

    public DittoArea findAreaById(String str) {
        if (this.mDittoArea != null && !TextUtils.isEmpty(str)) {
            if (str.equals(this.mDittoArea.getId())) {
                return this.mDittoArea;
            }
            DittoArea dittoArea = this.mDittoArea;
            if (dittoArea instanceof DittoAreaGroup) {
                return ((DittoAreaGroup) dittoArea).findChildById(str);
            }
            return null;
        }
        return null;
    }

    public DittoArea findAreaByPosition(float f16, float f17) {
        DittoArea dittoArea = this.mDittoArea;
        if (dittoArea != null) {
            return dittoArea.findTarget(f16, f17);
        }
        return null;
    }

    public DittoArea getCanvasArea() {
        return this.mDittoArea;
    }

    @Override // com.tencent.ditto.area.DittoHost
    public Object getCurrentViewModel() {
        return this.viewModel;
    }

    @Override // android.view.View, com.tencent.ditto.area.DittoHost
    public void invalidate() {
        DittoHost dittoHost = this.mHost;
        if (dittoHost != null) {
            dittoHost.invalidate();
        }
        super.invalidate();
    }

    @Override // com.tencent.ditto.area.DittoHost
    public void invokeAreaClick(String str, MotionEvent motionEvent) {
        DittoArea findChildById;
        DittoArea dittoArea = this.mDittoArea;
        if ((dittoArea instanceof DittoAreaGroup) && (findChildById = ((DittoAreaGroup) dittoArea).findChildById(str)) != null) {
            findChildById.performClick(motionEvent);
        }
    }

    public void onContentDescriptionChanged(DittoArea dittoArea) {
        DittoHost dittoHost = this.mHost;
        if (dittoHost != null) {
            dittoHost.onContentDescriptionChanged(dittoArea);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int saveCount = canvas.getSaveCount();
        canvas.save();
        canvas.translate(getPaddingLeft(), getPaddingTop());
        DittoArea dittoArea = this.mDittoArea;
        if (dittoArea != null) {
            dittoArea.draw(canvas);
        }
        canvas.restoreToCount(saveCount);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        try {
            if (this.mDittoArea != null) {
                this.mDittoArea.layout(getPaddingLeft(), getPaddingTop(), (i17 - i3) - getPaddingRight(), (i18 - i16) - getPaddingBottom());
                super.onLayout(z16, i3, i16, i17, i18);
            }
        } catch (Exception e16) {
            DittoLog.e(DittoLog.defaultTag, "layout error", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i3, int i16) {
        int i17;
        int i18;
        try {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int paddingRight = getPaddingRight();
            int paddingBottom = getPaddingBottom();
            DittoArea dittoArea = this.mDittoArea;
            if (dittoArea != null && dittoArea.getVisibility() != 8) {
                this.mDittoArea.measure(DittoAreaGroup.getChildMeasureSpec(i3, paddingLeft + paddingRight, this.mDittoArea.getLayoutAttr().width), DittoAreaGroup.getChildMeasureSpec(i16, paddingTop + paddingBottom, this.mDittoArea.getLayoutAttr().height));
                i17 = this.mDittoArea.getMeasuredWidth() + paddingLeft + paddingRight;
                i18 = this.mDittoArea.getMeasuredHeight() + paddingTop + paddingBottom;
            } else {
                i17 = 0;
                i18 = 0;
            }
            setMeasuredDimension(Math.max(i17, getSuggestedMinimumWidth()), Math.max(i18, getSuggestedMinimumHeight()));
        } catch (Exception e16) {
            DittoLog.e(DittoLog.defaultTag, "measure error", e16);
            setMeasuredDimension(0, 0);
        }
    }

    @Override // android.view.View, com.tencent.ditto.area.DittoHost
    public void postInvalidate() {
        DittoHost dittoHost = this.mHost;
        if (dittoHost != null) {
            dittoHost.postInvalidate();
        }
        super.postInvalidate();
    }

    @Override // android.view.View, com.tencent.ditto.area.DittoHost
    public void postInvalidateDelayed(long j3) {
        DittoHost dittoHost = this.mHost;
        if (dittoHost != null) {
            dittoHost.postInvalidateDelayed(j3);
        }
        super.postInvalidateDelayed(j3);
    }

    public void removeAccessibilityArea(List<DittoArea> list) {
        DittoHost dittoHost = this.mHost;
        if (dittoHost != null) {
            dittoHost.removeAccessibilityArea(list);
        }
    }

    @Override // android.view.View, com.tencent.ditto.area.DittoHost
    public void requestLayout() {
        DittoHost dittoHost = this.mHost;
        if (dittoHost != null) {
            dittoHost.requestLayout();
        }
        super.requestLayout();
    }

    public void setCanvasArea(DittoArea dittoArea) {
        doSetUIElement(dittoArea);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setContentAreaForJsonFile(String str, boolean z16) {
        final DittoIdFuncPolyInf dittoIdFuncPolyInf;
        this.needKVCAreas.clear();
        Class<?> cls = getClass();
        if (sAptIdFuncPolyMap != null) {
            dittoIdFuncPolyInf = sAptIdFuncPolyMap.get(cls);
        } else {
            dittoIdFuncPolyInf = null;
        }
        if (dittoIdFuncPolyInf == null) {
            Map<Class<? extends DittoAreaView>, DittoIdFuncPolyInf> map = REFLECT_FUNC_POLY_MAP;
            DittoIdFuncPolyInf dittoIdFuncPolyInf2 = (DittoIdFuncPolyInf) map.get(cls);
            if (dittoIdFuncPolyInf2 == null) {
                dittoIdFuncPolyInf2 = DittoIdFuncPoly.createReflectIdFuncPoly(cls);
                map.put(cls, dittoIdFuncPolyInf2);
            }
            dittoIdFuncPolyInf = dittoIdFuncPolyInf2;
        }
        this.exposureReportingAreas.clear();
        setCanvasArea(DittoUIEngine.g().inflateDittoArea(this, str, new DittoUIEngine.DittoUIEngineInflateListener() { // from class: com.tencent.ditto.DittoAreaView.1
            @Override // com.tencent.ditto.shell.DittoUIEngine.DittoUIEngineInflateListener
            public void didInflatedArea(DittoArea dittoArea, String str2) {
                if (dittoArea.getCompassExposureKey() != null) {
                    DittoAreaView.this.exposureReportingAreas.add(dittoArea);
                }
                dittoIdFuncPolyInf.inflateArea(DittoAreaView.this, dittoArea, str2);
            }

            @Override // com.tencent.ditto.shell.DittoUIEngine.DittoUIEngineInflateListener
            public void setOutKVCSet(DittoArea dittoArea, Map<String, DittoValue> map2) {
                DittoAreaView.this.needKVCAreas.add(new KVCNode(dittoArea, map2));
            }
        }, z16));
        updateViewModel(getCurrentViewModel());
    }

    public void setHost(DittoHost dittoHost) {
        this.mHost = dittoHost;
    }

    @Override // com.tencent.ditto.area.DittoHost
    public void turnOffHardwareAcceleration() {
        if (!this.hardwareAccelerationTurned) {
            setLayerType(1, null);
            this.hardwareAccelerationTurned = true;
            DittoHost dittoHost = this.mHost;
            if (dittoHost != null) {
                dittoHost.turnOffHardwareAcceleration();
            }
        }
    }

    public void updateViewModel(Object obj) {
        Object value;
        this.viewModel = obj;
        boolean z16 = false;
        for (KVCNode kVCNode : this.needKVCAreas) {
            DittoArea dittoArea = kVCNode.area;
            if (dittoArea != null) {
                LayoutAttrSet layoutAttr = dittoArea.getLayoutAttr();
                for (String str : kVCNode.kvcSet.keySet()) {
                    DittoValue dittoValue = kVCNode.kvcSet.get(str);
                    if (dittoValue != null && (value = dittoValue.getValue(obj)) != null) {
                        layoutAttr.addLayoutAttr(str, value);
                        if (!z16) {
                            z16 = true;
                        }
                    }
                }
                kVCNode.area.setLayoutAttr(layoutAttr);
            }
        }
        if (z16) {
            requestLayout();
        }
    }

    @Override // android.view.View, com.tencent.ditto.area.DittoHost
    public void invalidate(int i3, int i16, int i17, int i18) {
        DittoHost dittoHost = this.mHost;
        if (dittoHost != null) {
            dittoHost.invalidate(i3, i16, i17, i18);
        }
        super.invalidate(i3, i16, i17, i18);
    }

    public DittoAreaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.exposureReportingAreas = new HashSet();
        this.hardwareAccelerationTurned = false;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.needKVCAreas = Collections.synchronizedList(new ArrayList());
    }

    @Override // com.tencent.ditto.area.DittoHost
    public View getContainerView() {
        return this;
    }

    public void reportTTTClick(int i3) {
    }

    public void storageViewModel(boolean z16) {
    }

    public void handleSilentUri(String str, DittoArea dittoArea, MotionEvent motionEvent) {
    }

    public void handleUri(String str, DittoArea dittoArea, MotionEvent motionEvent) {
    }

    public void handleSilentRequest(String str, String str2, int i3, DittoArea dittoArea, MotionEvent motionEvent) {
    }
}
