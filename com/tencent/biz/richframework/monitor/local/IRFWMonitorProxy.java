package com.tencent.biz.richframework.monitor.local;

import com.tencent.biz.richframework.monitor.local.fps.RFWDropFrameCollector;

/* loaded from: classes5.dex */
public interface IRFWMonitorProxy {
    boolean isEnabledPerformanceUI();

    boolean isEnabledTracePrint();

    boolean isWnsEnabledCollect();

    void onBeginFPSFrameMonitor(String str);

    void onEndFPSFrameMonitor(String str);

    void onFrameInfo(RFWDropFrameCollector.DropFrameInfo dropFrameInfo, boolean z16);

    String onParseSceneForPageId(int i3);
}
