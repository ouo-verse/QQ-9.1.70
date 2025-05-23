package com.tencent.biz.richframework.monitor.local;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import com.tencent.biz.richframework.monitor.local.presenter.IRFWMonitorInfoPresenter;
import com.tencent.biz.richframework.monitor.local.presenter.RFWMonitorFramePresenter;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes5.dex */
public class RFWPerformanceAnalyse {
    public static final String TAG = "FAM-FPSAnalyseMonitor";
    private final Set<IRFWMonitorInfoPresenter> mMonitorInfoPresenterSet;
    private RFWPerformanceWindow mPerformanceWindow;

    public RFWPerformanceAnalyse() {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        this.mMonitorInfoPresenterSet = copyOnWriteArraySet;
        copyOnWriteArraySet.add(new RFWMonitorFramePresenter());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCreateView(View view) {
        if (this.mMonitorInfoPresenterSet.isEmpty()) {
            return;
        }
        Iterator<IRFWMonitorInfoPresenter> it = this.mMonitorInfoPresenterSet.iterator();
        while (it.hasNext()) {
            it.next().onCreateView(view);
        }
    }

    private void handleInit(WindowManager windowManager) {
        if (this.mMonitorInfoPresenterSet.isEmpty()) {
            return;
        }
        Iterator<IRFWMonitorInfoPresenter> it = this.mMonitorInfoPresenterSet.iterator();
        while (it.hasNext()) {
            it.next().onInit(windowManager);
        }
    }

    private void handleStart(Context context) {
        Iterator<IRFWMonitorInfoPresenter> it = this.mMonitorInfoPresenterSet.iterator();
        while (it.hasNext()) {
            it.next().onStart(context);
        }
    }

    private void handleStop() {
        Iterator<IRFWMonitorInfoPresenter> it = this.mMonitorInfoPresenterSet.iterator();
        while (it.hasNext()) {
            it.next().onStop();
        }
        RFWPerformanceWindow rFWPerformanceWindow = this.mPerformanceWindow;
        if (rFWPerformanceWindow != null) {
            rFWPerformanceWindow.deattch();
        }
    }

    public void calculateOnce() {
        if (this.mMonitorInfoPresenterSet.isEmpty()) {
            return;
        }
        for (IRFWMonitorInfoPresenter iRFWMonitorInfoPresenter : this.mMonitorInfoPresenterSet) {
            if (iRFWMonitorInfoPresenter instanceof RFWMonitorFramePresenter) {
                ((RFWMonitorFramePresenter) iRFWMonitorInfoPresenter).calculateOnce();
            }
        }
    }

    public void endPageScroll(int i3) {
        if (this.mMonitorInfoPresenterSet.isEmpty()) {
            return;
        }
        for (IRFWMonitorInfoPresenter iRFWMonitorInfoPresenter : this.mMonitorInfoPresenterSet) {
            if (iRFWMonitorInfoPresenter instanceof RFWMonitorFramePresenter) {
                ((RFWMonitorFramePresenter) iRFWMonitorInfoPresenter).endPageScroll(i3);
            }
        }
    }

    public void init(Activity activity, boolean z16) {
        if (z16) {
            RFWPerformanceWindow rFWPerformanceWindow = new RFWPerformanceWindow() { // from class: com.tencent.biz.richframework.monitor.local.RFWPerformanceAnalyse.1
                @Override // com.tencent.biz.richframework.monitor.local.RFWPerformanceWindow
                protected void onCreateView(View view) {
                    RFWPerformanceAnalyse.this.handleCreateView(view);
                }
            };
            this.mPerformanceWindow = rFWPerformanceWindow;
            rFWPerformanceWindow.init(activity);
        }
        handleInit((WindowManager) activity.getSystemService("window"));
    }

    public void injectAgentImpl(IRFWMonitorProxy iRFWMonitorProxy) {
        if (this.mMonitorInfoPresenterSet.isEmpty()) {
            return;
        }
        Iterator<IRFWMonitorInfoPresenter> it = this.mMonitorInfoPresenterSet.iterator();
        while (it.hasNext()) {
            it.next().injectProxyImpl(iRFWMonitorProxy);
        }
    }

    public void release() {
        RFWPerformanceWindow rFWPerformanceWindow = this.mPerformanceWindow;
        if (rFWPerformanceWindow != null) {
            rFWPerformanceWindow.release();
        }
    }

    public void start(Context context) {
        handleStart(context);
    }

    public void startPageScroll(int i3) {
        if (this.mMonitorInfoPresenterSet.isEmpty()) {
            return;
        }
        for (IRFWMonitorInfoPresenter iRFWMonitorInfoPresenter : this.mMonitorInfoPresenterSet) {
            if (iRFWMonitorInfoPresenter instanceof RFWMonitorFramePresenter) {
                ((RFWMonitorFramePresenter) iRFWMonitorInfoPresenter).startPageScroll(i3);
            }
        }
    }

    public void stop() {
        handleStop();
    }
}
