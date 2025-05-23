package com.tencent.biz.richframework.monitor;

import android.app.Activity;
import android.content.Context;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.monitor.local.IRFWMonitorProxy;
import com.tencent.biz.richframework.monitor.local.RFWPerformanceAnalyse;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWMonitorManager implements IRFWMonitorManager {
    private static volatile IRFWMonitorManager INSTANCE = null;
    private static final String TAG = "FAM-RFWMonitorManager";
    protected IRFWMonitorProxy mMonitorProxy;
    protected RFWPerformanceAnalyse mPerformanceAnalyse;

    private String getPageIdToScene(int i3) {
        IRFWMonitorProxy iRFWMonitorProxy = this.mMonitorProxy;
        if (iRFWMonitorProxy == null) {
            return "";
        }
        return iRFWMonitorProxy.onParseSceneForPageId(i3);
    }

    public static IRFWMonitorManager instance() {
        if (INSTANCE == null) {
            synchronized (RFWMonitorManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new RFWMonitorManager();
                }
            }
        }
        return INSTANCE;
    }

    private boolean isWnsEnabledCollect() {
        IRFWMonitorProxy iRFWMonitorProxy = this.mMonitorProxy;
        if (iRFWMonitorProxy != null && iRFWMonitorProxy.isWnsEnabledCollect()) {
            return true;
        }
        return false;
    }

    private void notifyQAPMHandler(String str, boolean z16) {
        IRFWMonitorProxy iRFWMonitorProxy = this.mMonitorProxy;
        if (iRFWMonitorProxy == null) {
            return;
        }
        if (z16) {
            iRFWMonitorProxy.onBeginFPSFrameMonitor(str);
        } else {
            iRFWMonitorProxy.onEndFPSFrameMonitor(str);
        }
    }

    @Override // com.tencent.biz.richframework.monitor.IRFWMonitorManager
    public void endPageScroll(int i3) {
        notifyQAPMHandler(getPageIdToScene(i3), false);
        if (this.mPerformanceAnalyse != null && isEnabledPerformance()) {
            this.mPerformanceAnalyse.endPageScroll(i3);
        }
    }

    @Override // com.tencent.biz.richframework.monitor.IRFWMonitorManager
    public void injectProxyImpl(IRFWMonitorProxy iRFWMonitorProxy) {
        this.mMonitorProxy = iRFWMonitorProxy;
        RFWPerformanceAnalyse rFWPerformanceAnalyse = this.mPerformanceAnalyse;
        if (rFWPerformanceAnalyse == null) {
            return;
        }
        rFWPerformanceAnalyse.injectAgentImpl(iRFWMonitorProxy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isEnabledFlowWindow() {
        IRFWMonitorProxy iRFWMonitorProxy = this.mMonitorProxy;
        if (iRFWMonitorProxy != null && iRFWMonitorProxy.isEnabledPerformanceUI()) {
            return true;
        }
        return false;
    }

    protected boolean isEnabledPerformance() {
        if (isEnabledFlowWindow()) {
            return true;
        }
        return isWnsEnabledCollect();
    }

    @Override // com.tencent.biz.richframework.monitor.IRFWMonitorManager
    public void release() {
        RFWLog.d(TAG, RFWLog.USR, "[release] performance analyse release.");
        stop();
    }

    @Override // com.tencent.biz.richframework.monitor.IRFWMonitorManager
    public void start(Context context) {
        if (!isEnabledPerformance()) {
            RFWLog.d(TAG, RFWLog.USR, "[start] current wns is close, flow end.");
            return;
        }
        if (!(context instanceof Activity)) {
            RFWLog.d(TAG, RFWLog.USR, "[start] current context not is activity, end flow...");
            return;
        }
        RFWLog.d(TAG, RFWLog.USR, "[start] performance analyse start");
        Activity activity = (Activity) context;
        RFWPerformanceAnalyse rFWPerformanceAnalyse = new RFWPerformanceAnalyse();
        this.mPerformanceAnalyse = rFWPerformanceAnalyse;
        rFWPerformanceAnalyse.injectAgentImpl(this.mMonitorProxy);
        this.mPerformanceAnalyse.init(activity, isEnabledFlowWindow());
        this.mPerformanceAnalyse.start(activity);
    }

    @Override // com.tencent.biz.richframework.monitor.IRFWMonitorManager
    public void startPageScroll(int i3) {
        notifyQAPMHandler(getPageIdToScene(i3), true);
        if (this.mPerformanceAnalyse != null && isEnabledPerformance()) {
            this.mPerformanceAnalyse.startPageScroll(i3);
        }
    }

    @Override // com.tencent.biz.richframework.monitor.IRFWMonitorManager
    public void stop() {
        if (this.mPerformanceAnalyse == null) {
            return;
        }
        RFWLog.d(TAG, RFWLog.USR, "[stop] performance analyse stop.");
        this.mPerformanceAnalyse.stop();
        this.mPerformanceAnalyse.release();
    }
}
