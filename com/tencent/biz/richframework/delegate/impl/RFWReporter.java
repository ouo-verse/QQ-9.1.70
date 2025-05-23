package com.tencent.biz.richframework.delegate.impl;

import com.tencent.biz.richframework.delegate.IReportDelegate;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWReporter {
    private static final String EVENT_KEY_ATTACH_INFO = "attach_info";
    private static final String EVENT_KEY_REPORT_TYPE = "report_type";
    private static final String EVENT_NAME_CATCH_THROWABLE = "catch_throwable";
    private static final String EVENT_NAME_COMMON_EVENT = "common_event";
    public static volatile IReportDelegate sDelegateReporter;

    private static IReportDelegate getReportDelegate() {
        if (sDelegateReporter == null) {
            synchronized (RFWReporter.class) {
                if (sDelegateReporter == null) {
                    sDelegateReporter = (IReportDelegate) RFWDelegate.getDelegate(IReportDelegate.class);
                }
            }
        }
        return sDelegateReporter;
    }

    public static void report(String str, Map<String, Object> map) {
        if (getReportDelegate() != null) {
            getReportDelegate().report(str, map);
        }
    }

    public static void reportCommonEvent(String str, Map<String, Object> map) {
        if (getReportDelegate() != null) {
            map.put("report_type", str);
            getReportDelegate().report(EVENT_NAME_COMMON_EVENT, map);
        }
    }

    public static void reportThrowableCache(Throwable th5) {
        HashMap hashMap = new HashMap();
        hashMap.put("attach_info", th5.getMessage());
        report(EVENT_NAME_CATCH_THROWABLE, hashMap);
    }
}
