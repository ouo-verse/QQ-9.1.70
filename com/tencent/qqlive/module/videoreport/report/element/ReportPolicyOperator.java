package com.tencent.qqlive.module.videoreport.report.element;

import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;

/* loaded from: classes22.dex */
public class ReportPolicyOperator {
    private static final String TAG = "ReportPolicyOperator";

    public static <T> T getReportPolicy(Object obj, String str, Class<T> cls) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "getElementExposePolicy: ");
        }
        if (!VideoReportInner.getInstance().checkElementObjectArgument(obj)) {
            return null;
        }
        Object innerParam = DataRWProxy.getInnerParam(obj, str);
        if (!cls.isInstance(innerParam)) {
            return null;
        }
        return cls.cast(innerParam);
    }

    public static void setReportPolicy(Object obj, Object obj2, String str) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "setElementClickPolicy: object=" + obj + ", policy=" + obj2);
        }
        if (VideoReportInner.getInstance().checkElementObjectArgument(obj)) {
            DataRWProxy.setInnerParam(obj, str, obj2);
        }
    }
}
