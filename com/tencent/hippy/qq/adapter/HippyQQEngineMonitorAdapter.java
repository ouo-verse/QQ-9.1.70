package com.tencent.hippy.qq.adapter;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.mtt.hippy.bridge.HippyCallNativeParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyQQEngineMonitorAdapter implements HippyEngineMonitorAdapter {
    @Override // com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter
    public boolean needReportBridgeANR() {
        return false;
    }

    @Override // com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter
    public boolean onInterceptCallNative(@NonNull String str, @NonNull HippyCallNativeParams hippyCallNativeParams) {
        return false;
    }

    @Override // com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter
    public boolean onInterceptPromiseCallback(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @Nullable Object obj) {
        return false;
    }

    @Override // com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter
    public void reportClickEvent(Object obj, boolean z16) {
        if ((obj instanceof View) && z16) {
            VideoReport.reportEvent("clck", (View) obj, new HashMap());
        }
    }

    @Override // com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter
    public void reportEngineLoadStart() {
    }

    @Override // com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter
    public void reportBridgeANR(String str) {
    }

    @Override // com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter
    public void onCallNativeFinished(@NonNull String str, @NonNull HippyCallNativeParams hippyCallNativeParams) {
    }

    @Override // com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter
    public void reportDoCallNatives(String str, String str2) {
    }

    @Override // com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter
    public void reportGestureEventCallStack(String str, String str2) {
    }

    @Override // com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter
    public void reportModuleLoadComplete(HippyRootView hippyRootView, int i3, List<HippyEngineMonitorEvent> list) {
    }

    @Override // com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter
    public void reportEngineLoadResult(int i3, int i16, List<HippyEngineMonitorEvent> list, Throwable th5) {
    }
}
