package com.tencent.qcircle.shadow.core.runtime.qcircle.reflect;

import android.app.Activity;
import android.view.MotionEvent;
import com.tencent.qcircle.shadow.core.runtime.PluginActivity;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DtEventCollectorReflect extends DtBaseReflect {
    public static final String className = "com.tencent.qqlive.module.videoreport.collect.EventCollector";
    private static volatile DtEventCollectorReflect sReflect;

    public static DtEventCollectorReflect g() {
        if (sReflect == null) {
            synchronized (DtEventCollectorReflect.class) {
                if (sReflect == null) {
                    sReflect = new DtEventCollectorReflect();
                }
            }
        }
        return sReflect;
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.qcircle.reflect.DtBaseReflect
    protected void initObject(Activity activity) {
        getInstance(activity, "com.tencent.qqlive.module.videoreport.collect.EventCollector", "getInstance");
    }

    public void invokeOnActivityDispatchTouchEvent(PluginActivity pluginActivity, MotionEvent motionEvent, boolean z16, boolean z17) {
        if (pluginActivity == null) {
            return;
        }
        try {
            if (pluginActivity.getHostActivityDelegator() != null && pluginActivity.getHostActivityDelegator().getHostActivity() != null) {
                Activity activity = (Activity) pluginActivity.getHostActivityDelegator().getHostActivity();
                Object object = getObject(activity);
                Method method = this.mMethodMap.get("onActivityDispatchTouchEvent");
                if (method == null) {
                    Class<?> loadClass = loadClass(activity, "com.tencent.qqlive.module.videoreport.collect.EventCollector");
                    if (loadClass == null) {
                        return;
                    }
                    Class<?> cls = Boolean.TYPE;
                    method = loadClass.getMethod("onActivityDispatchTouchEvent", Activity.class, MotionEvent.class, cls, cls);
                    this.mMethodMap.put("onActivityDispatchTouchEvent", method);
                }
                method.invoke(object, activity, motionEvent, Boolean.valueOf(z16), Boolean.valueOf(z17));
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
