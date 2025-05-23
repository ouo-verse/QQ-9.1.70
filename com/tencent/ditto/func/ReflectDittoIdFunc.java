package com.tencent.ditto.func;

import android.view.MotionEvent;
import com.tencent.ditto.DittoAreaView;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.shell.DittoUIEngine;
import com.tencent.ditto.utils.DittoLog;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ReflectDittoIdFunc implements DittoIdFunc {
    private final Method clickMethod;
    private final Field field;
    private final Method longClickMethod;

    public ReflectDittoIdFunc(Field field, Method method, Method method2) {
        this.field = field;
        this.clickMethod = method;
        this.longClickMethod = method2;
    }

    @Override // com.tencent.ditto.func.DittoIdFunc
    public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
        setValue(dittoAreaView, dittoArea);
        setClickListener(dittoAreaView, dittoArea);
        setLongClickListener(dittoAreaView, dittoArea);
    }

    public void setClickListener(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
        Method method = this.clickMethod;
        if (method == null) {
            return;
        }
        if (method.getParameterTypes().length == 3) {
            this.clickMethod.setAccessible(true);
            dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.tencent.ditto.func.ReflectDittoIdFunc.1
                @Override // com.tencent.ditto.area.DittoArea.ClickListener
                public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                    try {
                        if (dittoArea2.getCompassClickKey() != null) {
                            DittoUIEngine.g().getReporter().compassReport(dittoArea2.getCompassClickKey());
                        }
                        if (dittoArea2.getTttReportArea() != -1) {
                            dittoAreaView.reportTTTClick(dittoArea2.getTttReportArea());
                        }
                        ReflectDittoIdFunc.this.clickMethod.invoke(dittoAreaView, dittoArea2, motionEvent, obj);
                    } catch (IllegalAccessException e16) {
                        DittoLog.e(DittoLog.defaultTag, "getClickListener dittoArea:" + dittoArea2.getId(), e16);
                        throw new RuntimeException(e16.getMessage());
                    } catch (InvocationTargetException e17) {
                        DittoLog.e(DittoLog.defaultTag, "getClickListener dittoArea:" + dittoArea2.getId(), e17);
                        if (e17.getCause() instanceof RuntimeException) {
                            throw ((RuntimeException) e17.getCause());
                        }
                        throw new RuntimeException(e17.getMessage());
                    }
                }
            };
            return;
        }
        throw new RuntimeException("arguments of event method must be (DittoArea, MotionEvent, Object)");
    }

    public void setLongClickListener(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
        Method method = this.longClickMethod;
        if (method == null) {
            return;
        }
        if (method.getParameterTypes().length == 3) {
            this.longClickMethod.setAccessible(true);
            dittoArea.longClickListener = new DittoArea.LongClickListener() { // from class: com.tencent.ditto.func.ReflectDittoIdFunc.2
                @Override // com.tencent.ditto.area.DittoArea.LongClickListener
                public void onLongClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                    try {
                        if (dittoArea2.getCompassClickKey() != null) {
                            DittoUIEngine.g().getReporter().compassReport(dittoArea2.getCompassClickKey());
                        }
                        ReflectDittoIdFunc.this.longClickMethod.invoke(dittoAreaView, dittoArea2, motionEvent, obj);
                    } catch (Exception e16) {
                        DittoLog.e(DittoLog.defaultTag, "getLongClickListenerFailed", e16);
                    }
                }
            };
            return;
        }
        throw new RuntimeException("arguments of event method must be (DittoArea, MotionEvent, Object)");
    }

    public void setValue(DittoAreaView dittoAreaView, DittoArea dittoArea) {
        Field field = this.field;
        if (field == null) {
            return;
        }
        field.setAccessible(true);
        try {
            this.field.set(dittoAreaView, dittoArea);
        } catch (IllegalAccessException e16) {
            DittoLog.e(DittoLog.defaultTag, "inflateErr: ", e16);
        }
    }
}
