package com.tencent.qqlive.module.videoreport.visual.debug.util;

import android.app.Activity;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ActivityUtil {
    private static WeakReference<Activity> mCurrentTopActivityRef;
    private static WeakReference<Activity> mLastTopActivityRef;

    @Nullable
    private static Activity getCurrentActivityByReflect() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            for (Object obj : ((Map) declaredField.get(invoke)).values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField("paused");
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                    declaredField3.setAccessible(true);
                    return (Activity) declaredField3.get(obj);
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return null;
    }

    @Nullable
    public static Activity getLastTopActivity() {
        WeakReference<Activity> weakReference = mLastTopActivityRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Nullable
    public static Activity getTopActivity() {
        Activity activity;
        WeakReference<Activity> weakReference = mCurrentTopActivityRef;
        if (weakReference != null) {
            activity = weakReference.get();
        } else {
            activity = null;
        }
        if (activity == null) {
            return getCurrentActivityByReflect();
        }
        return activity;
    }

    public static void setLastTopActivityRef(Activity activity) {
        mLastTopActivityRef = new WeakReference<>(activity);
    }

    public static void setTopActivity(Activity activity) {
        mCurrentTopActivityRef = new WeakReference<>(activity);
    }
}
