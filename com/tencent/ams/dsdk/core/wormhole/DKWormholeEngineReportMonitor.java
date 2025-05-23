package com.tencent.ams.dsdk.core.wormhole;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.common.wormhole.report.WormholeReportManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.mtt.hippy.bridge.HippyCallNativeParams;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DKWormholeEngineReportMonitor implements HippyEngineMonitorAdapter {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "WormholeEngineReportMonitor";
    private int engineLOadCostTime;

    public DKWormholeEngineReportMonitor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.engineLOadCostTime = 0;
        }
    }

    @Override // com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter
    public boolean needReportBridgeANR() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter
    public void onCallNativeFinished(@NonNull String str, @NonNull HippyCallNativeParams hippyCallNativeParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, (Object) hippyCallNativeParams);
        }
    }

    @Override // com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter
    public boolean onInterceptCallNative(@NonNull String str, @NonNull HippyCallNativeParams hippyCallNativeParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) hippyCallNativeParams)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter
    public boolean onInterceptPromiseCallback(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @Nullable Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 12, this, str, str2, str3, str4, obj)).booleanValue();
    }

    @Override // com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter
    public void reportBridgeANR(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter
    public void reportClickEvent(Object obj, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, obj, Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter
    public void reportDoCallNatives(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) str2);
        }
    }

    @Override // com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter
    public void reportEngineLoadResult(int i3, int i16, List<HippyEngineMonitorEvent> list, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), list, th5);
            return;
        }
        if (i3 == 0) {
            this.engineLOadCostTime = i16;
            WormholeReportManager.getInstance().addReportTimeData(WormholeReportManager.TIME_LOAD_ENGINE, "" + i16);
        }
        WormholeReportManager.getInstance().postProcessReport("actKanDianWormholeEngineProcess", i3);
        DLog.i(TAG, "Hippy report,reportEngineLoadResult code:" + i3 + ",loadTime:" + i16);
        if (list != null && !list.isEmpty()) {
            for (int i17 = 0; i17 < list.size(); i17++) {
                HippyEngineMonitorEvent hippyEngineMonitorEvent = list.get(i17);
                if (hippyEngineMonitorEvent != null) {
                    DLog.i(TAG, "Hippy report , reportEngineLoadResult eventName:" + hippyEngineMonitorEvent.eventName + ",loadTime:" + (hippyEngineMonitorEvent.endTime - hippyEngineMonitorEvent.startTime) + ",startTime:" + hippyEngineMonitorEvent.startTime + ",endtime:" + hippyEngineMonitorEvent.endTime);
                }
            }
        }
    }

    @Override // com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter
    public void reportEngineLoadStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @Override // com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter
    public void reportGestureEventCallStack(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2);
        }
    }

    @Override // com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter
    public void reportModuleLoadComplete(HippyRootView hippyRootView, int i3, List<HippyEngineMonitorEvent> list) {
        String name;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, hippyRootView, Integer.valueOf(i3), list);
            return;
        }
        if (hippyRootView == null) {
            name = "";
        } else {
            name = hippyRootView.getName();
        }
        DLog.i(TAG, "Hippy report , reportModuleLoadComplete loadTime:" + i3 + ",name:" + name);
        if (list != null) {
            for (int i16 = 0; i16 < list.size(); i16++) {
                HippyEngineMonitorEvent hippyEngineMonitorEvent = list.get(i16);
                if (hippyEngineMonitorEvent != null) {
                    if (HippyEngineMonitorEvent.MODULE_LOAD_EVENT_LOAD_BUNDLE.equals(hippyEngineMonitorEvent.eventName)) {
                        WormholeReportManager.getInstance().addReportTimeData(WormholeReportManager.TIME_LOAD_JSBUNDLE, "" + (hippyEngineMonitorEvent.endTime - hippyEngineMonitorEvent.startTime));
                    } else if (HippyEngineMonitorEvent.MODULE_LOAD_EVENT_RUN_BUNDLE.equals(hippyEngineMonitorEvent.eventName)) {
                        WormholeReportManager.getInstance().addReportTimeData(WormholeReportManager.TIME_RUN_JSBUNDLE, "" + (hippyEngineMonitorEvent.endTime - hippyEngineMonitorEvent.startTime));
                    }
                    DLog.i(TAG, "Hippy report , reportModuleLoadComplete eventName:" + hippyEngineMonitorEvent.eventName + ",loadTime:" + (hippyEngineMonitorEvent.endTime - hippyEngineMonitorEvent.startTime) + ",startTime:" + hippyEngineMonitorEvent.startTime + ",endtime:" + hippyEngineMonitorEvent.endTime);
                }
            }
        }
        WormholeReportManager.getInstance().addReportTimeData(WormholeReportManager.TIME_LOAD_TOTAL, "" + (i3 + this.engineLOadCostTime));
        WormholeReportManager.getInstance().addReportTimeData(WormholeReportManager.COMMON_PAGE_NAME, name);
        WormholeReportManager.getInstance().postEngineAndBundleReportData();
    }
}
