package com.tencent.mtt.hippy.modules;

import android.os.SystemClock;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.supportui.utils.struct.Pools;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyModuleANRMonitor {
    static final int ANR_TIME = 100;
    static int MONITOR_ID;
    static final int MONITOR_ID_NAN = 0;
    final HippyEngineContext mContext;
    HippyEngineMonitorAdapter mEngineMonitorAdapter;
    ConcurrentHashMap<Integer, MonitorMessage> mMonitorMessages;
    boolean mNeedReportBridgeANR;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    static class MonitorMessage {
        private static final Pools.SynchronizedPool<MonitorMessage> INSTANCE_POOL = new Pools.SynchronizedPool<>(20);
        private static final int POOL_SIZE = 20;
        public String param1;
        public String param2;
        public long startTime;

        MonitorMessage() {
        }

        private void init(String str, String str2, long j3) {
            this.param1 = str;
            this.param2 = str2;
            this.startTime = j3;
        }

        public static MonitorMessage obtain(String str, String str2, long j3) {
            MonitorMessage acquire = INSTANCE_POOL.acquire();
            if (acquire == null) {
                acquire = new MonitorMessage();
            }
            acquire.init(str, str2, j3);
            return acquire;
        }

        public void onDispose() {
            try {
                INSTANCE_POOL.release(this);
            } catch (Throwable th5) {
                LogUtils.d("MonitorMessage", "onDispose: " + th5.getMessage());
            }
        }
    }

    public HippyModuleANRMonitor(HippyEngineContext hippyEngineContext) {
        this.mNeedReportBridgeANR = false;
        this.mContext = hippyEngineContext;
        if (hippyEngineContext != null) {
            HippyEngineMonitorAdapter engineMonitorAdapter = hippyEngineContext.getGlobalConfigs().getEngineMonitorAdapter();
            this.mEngineMonitorAdapter = engineMonitorAdapter;
            boolean needReportBridgeANR = engineMonitorAdapter.needReportBridgeANR();
            this.mNeedReportBridgeANR = needReportBridgeANR;
            if (needReportBridgeANR) {
                this.mMonitorMessages = new ConcurrentHashMap<>();
            }
        }
    }

    public void checkMonitor() {
        ConcurrentHashMap<Integer, MonitorMessage> concurrentHashMap = this.mMonitorMessages;
        if (concurrentHashMap == null) {
            return;
        }
        for (Map.Entry<Integer, MonitorMessage> entry : concurrentHashMap.entrySet()) {
            MonitorMessage value = entry.getValue();
            if (value != null && SystemClock.elapsedRealtime() - value.startTime > 100) {
                HippyEngineMonitorAdapter hippyEngineMonitorAdapter = this.mEngineMonitorAdapter;
                if (hippyEngineMonitorAdapter != null) {
                    hippyEngineMonitorAdapter.reportBridgeANR(value.param1 + APLogFileUtil.SEPARATOR_LOG + value.param2);
                }
                this.mMonitorMessages.remove(entry.getKey());
                value.onDispose();
            }
        }
    }

    public void endMonitor(int i3) {
        MonitorMessage monitorMessage;
        HippyEngineMonitorAdapter hippyEngineMonitorAdapter;
        if (!this.mNeedReportBridgeANR || (monitorMessage = this.mMonitorMessages.get(Integer.valueOf(i3))) == null) {
            return;
        }
        if (SystemClock.elapsedRealtime() - monitorMessage.startTime > 100 && (hippyEngineMonitorAdapter = this.mEngineMonitorAdapter) != null) {
            hippyEngineMonitorAdapter.reportBridgeANR(monitorMessage.param1 + APLogFileUtil.SEPARATOR_LOG + monitorMessage.param2);
        }
        this.mMonitorMessages.remove(Integer.valueOf(i3));
        monitorMessage.onDispose();
    }

    public int startMonitor(String str, String str2) {
        if (!this.mNeedReportBridgeANR) {
            return 0;
        }
        MonitorMessage obtain = MonitorMessage.obtain(str, str2, SystemClock.elapsedRealtime());
        int i3 = MONITOR_ID + 1;
        MONITOR_ID = i3;
        if (i3 == 0) {
            i3++;
            MONITOR_ID = i3;
        }
        this.mMonitorMessages.put(Integer.valueOf(i3), obtain);
        return i3;
    }
}
