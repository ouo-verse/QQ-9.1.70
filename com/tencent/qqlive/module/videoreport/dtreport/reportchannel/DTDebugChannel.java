package com.tencent.qqlive.module.videoreport.dtreport.reportchannel;

import com.tencent.qqlive.module.videoreport.IInnerReporter;
import com.tencent.qqlive.module.videoreport.IReporter;
import com.tencent.qqlive.module.videoreport.Log;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DTDebugChannel implements IReporter, IInnerReporter {
    private static final String TAG = "common.DTDebugChannel";
    private Map<String, Long> mEventCount = new TreeMap();

    private synchronized void addReport(String str) {
        if (str == null) {
            return;
        }
        Long l3 = this.mEventCount.get(str);
        if (l3 == null) {
            this.mEventCount.put(str, 1L);
        } else {
            this.mEventCount.put(str, Long.valueOf(l3.longValue() + 1));
        }
        Log.d(TAG, this.mEventCount.toString());
    }

    @Override // com.tencent.qqlive.module.videoreport.IInnerReporter
    public void report(Object obj, String str, Map<String, Object> map, String str2) {
        addReport(str);
    }

    @Override // com.tencent.qqlive.module.videoreport.IReporter
    public void report(Object obj, String str, Map<String, Object> map) {
        addReport(str);
    }
}
