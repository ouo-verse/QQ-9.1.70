package com.tencent.biz.richframework.monitor.local;

/* loaded from: classes5.dex */
public abstract class RFWAbsMonitorProxy implements IRFWMonitorProxy {
    private static final String TAG = "FAM-RFWAbsMonitorProxy";

    @Override // com.tencent.biz.richframework.monitor.local.IRFWMonitorProxy
    public boolean isEnabledPerformanceUI() {
        return false;
    }

    @Override // com.tencent.biz.richframework.monitor.local.IRFWMonitorProxy
    public String onParseSceneForPageId(int i3) {
        return null;
    }
}
