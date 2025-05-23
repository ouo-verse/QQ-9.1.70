package com.tencent.qcircle.shadow.core.runtime.qcircle.reflect;

import android.app.Activity;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DtVideoReportReflect extends DtBaseReflect {
    public static final String className = "com.tencent.qqlive.module.videoreport.VideoReport";
    private static volatile DtVideoReportReflect sReflect;

    public static DtVideoReportReflect g() {
        if (sReflect == null) {
            synchronized (DtVideoReportReflect.class) {
                if (sReflect == null) {
                    sReflect = new DtVideoReportReflect();
                }
            }
        }
        return sReflect;
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.qcircle.reflect.DtBaseReflect
    protected void initObject(Activity activity) {
        newInstance(activity, "com.tencent.qqlive.module.videoreport.VideoReport");
    }

    public void invokeAddToDetectionWhitelist(Activity activity) {
        try {
            Object object = getObject(activity);
            Method method = this.mMethodMap.get("addToDetectionWhitelist");
            if (method == null) {
                Class<?> loadClass = loadClass(activity, "com.tencent.qqlive.module.videoreport.VideoReport");
                if (loadClass == null) {
                    return;
                }
                method = loadClass.getMethod("addToDetectionWhitelist", Activity.class);
                this.mMethodMap.put("addToDetectionWhitelist", method);
            }
            method.invoke(object, activity);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
