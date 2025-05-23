package com.tencent.qqlive.module.videoreport.detection;

import android.app.Activity;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import com.tencent.qqlive.module.videoreport.utils.IDetectionInterceptor;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DetectionInterceptors {
    private static final IDetectionInterceptor DEFAULT_INTERCEPTOR;
    private static volatile IDetectionInterceptor sDetectionInterceptor;

    static {
        IDetectionInterceptor iDetectionInterceptor = new IDetectionInterceptor() { // from class: com.tencent.qqlive.module.videoreport.detection.DetectionInterceptors.1
            @Override // com.tencent.qqlive.module.videoreport.utils.IDetectionInterceptor
            public boolean ignoreAppEvent(Activity activity) {
                return false;
            }
        };
        DEFAULT_INTERCEPTOR = iDetectionInterceptor;
        sDetectionInterceptor = iDetectionInterceptor;
    }

    public static boolean ignoreAppEvent(Activity activity) {
        return sDetectionInterceptor.ignoreAppEvent(activity);
    }

    public static void setDetectionInterceptor(IDetectionInterceptor iDetectionInterceptor) {
        sDetectionInterceptor = (IDetectionInterceptor) BaseUtils.nullAs(iDetectionInterceptor, DEFAULT_INTERCEPTOR);
    }
}
