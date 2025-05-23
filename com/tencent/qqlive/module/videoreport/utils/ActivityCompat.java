package com.tencent.qqlive.module.videoreport.utils;

import android.app.Activity;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ActivityCompat {
    private static volatile boolean sCanGetResumeField = true;

    public static boolean isResumed(Activity activity) {
        if (!sCanGetResumeField) {
            return false;
        }
        try {
            Object fieldWithException = ReflectUtils.getFieldWithException(Activity.class, "mResumed", activity);
            if (!(fieldWithException instanceof Boolean)) {
                return false;
            }
            if (!((Boolean) fieldWithException).booleanValue()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            sCanGetResumeField = false;
            return false;
        }
    }
}
