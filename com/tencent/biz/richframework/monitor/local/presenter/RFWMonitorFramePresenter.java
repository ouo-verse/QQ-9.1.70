package com.tencent.biz.richframework.monitor.local.presenter;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.monitor.local.IRFWMonitorProxy;
import com.tencent.biz.richframework.monitor.local.fps.RFWDropFrameCollector;
import com.tencent.biz.richframework.monitor.local.presenter.ui.RFWMonitorFrameView;

/* loaded from: classes5.dex */
public class RFWMonitorFramePresenter implements IRFWMonitorInfoPresenter, RFWDropFrameCollector.DropFrameCallback {
    private RFWDropFrameCollector mDropFrameCollector;
    private IRFWMonitorProxy mMonitorProxy = null;
    private RFWMonitorFrameView mRFMonitorFrameView;

    private void printColorLog(String str) {
        if (RFWLog.isColorLevel()) {
            RFWLog.d("FAM-RFMonitorInfoPresenter", RFWLog.USR, str);
        }
    }

    private void updateCollectorEnabledPrint(IRFWMonitorProxy iRFWMonitorProxy) {
        RFWDropFrameCollector rFWDropFrameCollector;
        if (iRFWMonitorProxy == null || (rFWDropFrameCollector = this.mDropFrameCollector) == null) {
            return;
        }
        rFWDropFrameCollector.setEnabledTracePrint(iRFWMonitorProxy.isEnabledTracePrint());
    }

    public void calculateOnce() {
        this.mDropFrameCollector.calculateOnce();
    }

    public void endPageScroll(int i3) {
        IRFWMonitorProxy iRFWMonitorProxy = this.mMonitorProxy;
        if (iRFWMonitorProxy == null) {
            return;
        }
        printColorLog("[endPageScroll] page id: " + i3 + " | scene: " + iRFWMonitorProxy.onParseSceneForPageId(i3));
        this.mDropFrameCollector.stopMonitorDropFrame();
    }

    @Override // com.tencent.biz.richframework.monitor.local.presenter.IRFWMonitorInfoPresenter
    public void injectProxyImpl(IRFWMonitorProxy iRFWMonitorProxy) {
        this.mMonitorProxy = iRFWMonitorProxy;
        updateCollectorEnabledPrint(iRFWMonitorProxy);
    }

    @Override // com.tencent.biz.richframework.monitor.local.presenter.IRFWMonitorInfoPresenter
    public void onCreateView(View view) {
        RFWMonitorFrameView rFWMonitorFrameView = new RFWMonitorFrameView();
        this.mRFMonitorFrameView = rFWMonitorFrameView;
        rFWMonitorFrameView.onInitView(view);
    }

    @Override // com.tencent.biz.richframework.monitor.local.fps.RFWDropFrameCollector.DropFrameCallback
    public void onInfo(RFWDropFrameCollector.DropFrameInfo dropFrameInfo, boolean z16) {
        if (dropFrameInfo == null) {
            RFWLog.d("FAM-RFMonitorInfoPresenter", RFWLog.USR, "[onInfo] info should not be null.");
            return;
        }
        RFWMonitorFrameView rFWMonitorFrameView = this.mRFMonitorFrameView;
        if (rFWMonitorFrameView != null) {
            rFWMonitorFrameView.updateData(dropFrameInfo);
        }
        IRFWMonitorProxy iRFWMonitorProxy = this.mMonitorProxy;
        if (iRFWMonitorProxy != null) {
            iRFWMonitorProxy.onFrameInfo(dropFrameInfo, z16);
        }
    }

    @Override // com.tencent.biz.richframework.monitor.local.presenter.IRFWMonitorInfoPresenter
    public void onInit(WindowManager windowManager) {
        RFWDropFrameCollector rFWDropFrameCollector = this.mDropFrameCollector;
        if (rFWDropFrameCollector != null) {
            rFWDropFrameCollector.init(windowManager);
        } else {
            this.mDropFrameCollector = new RFWDropFrameCollector(this, windowManager);
        }
    }

    @Override // com.tencent.biz.richframework.monitor.local.presenter.IRFWMonitorInfoPresenter
    public void onStart(Context context) {
        RFWDropFrameCollector rFWDropFrameCollector = this.mDropFrameCollector;
        if (rFWDropFrameCollector == null) {
            RFWLog.d("FAM-RFMonitorInfoPresenter", RFWLog.USR, "[onStart] drop frame collector should not be null.");
        } else {
            rFWDropFrameCollector.start();
        }
    }

    @Override // com.tencent.biz.richframework.monitor.local.presenter.IRFWMonitorInfoPresenter
    public void onStop() {
        RFWDropFrameCollector rFWDropFrameCollector = this.mDropFrameCollector;
        if (rFWDropFrameCollector == null) {
            RFWLog.d("FAM-RFMonitorInfoPresenter", RFWLog.USR, "[onStart] drop frame collector should not be null.");
        } else {
            rFWDropFrameCollector.stop();
        }
    }

    public void startPageScroll(int i3) {
        IRFWMonitorProxy iRFWMonitorProxy = this.mMonitorProxy;
        if (iRFWMonitorProxy == null) {
            return;
        }
        String onParseSceneForPageId = iRFWMonitorProxy.onParseSceneForPageId(i3);
        printColorLog("[startPageScroll] page id: " + i3 + " | scene: " + onParseSceneForPageId);
        this.mDropFrameCollector.startMonitorDropFrame(onParseSceneForPageId);
    }
}
