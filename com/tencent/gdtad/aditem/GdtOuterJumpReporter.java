package com.tencent.gdtad.aditem;

import android.content.Context;
import android.os.Bundle;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.protocol.link_report;
import com.tencent.ad.tangram.statistics.AdReporterForLinkEvent;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtOuterJumpReporter {
    private static final String TAG = "GdtOuterJumpReport ";
    private static volatile GdtOuterJumpReporter sInstance;
    private volatile IPCHandler mIpcHandler;
    private volatile LifeCycleReportListener mLifeCycleReportListener;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    private static final class IPCHandler implements AdIPCManager.Handler {
        private static final String ACTION = "GDT_OUTER_JUMP_REPORT";
        private static final String AID = "aid";
        private static final String PID = "pid";
        private static final String TID = "traceId";
        private final WeakReference<Context> mAppContext;

        IPCHandler(WeakReference<Context> weakReference) {
            this.mAppContext = weakReference;
            AdIPCManager.getInstance().register(ACTION, this);
        }

        public void doOuterReportStart(String str, String str2, String str3) {
            Context context;
            WeakReference<Context> weakReference = this.mAppContext;
            if (weakReference != null) {
                context = weakReference.get();
            } else {
                context = null;
            }
            if (context != null) {
                GdtLog.i(GdtOuterJumpReporter.TAG, "[doOuterReportStart] start IPC preload");
                Bundle bundle = new Bundle();
                bundle.putString(AdIPCManager.Params.KEY_ACTION, ACTION);
                bundle.putString(AdIPCManager.Params.KEY_TO_PROCESS_NAME, AdProcessManager.getInstance().getMainProcessName());
                bundle.putString("aid", str);
                bundle.putString("pid", str2);
                bundle.putString(TID, str3);
                AdIPCManager.Result send = AdIPCManager.getInstance().send(context, new AdIPCManager.Params(bundle));
                if (send != null && send.success) {
                    GdtLog.i(GdtOuterJumpReporter.TAG, "[doOuterReportStart] success");
                }
            }
        }

        @Override // com.tencent.ad.tangram.ipc.AdIPCManager.Handler
        public AdIPCManager.Result handle(AdIPCManager.Params params) {
            Boolean isOnMainProcess = AdProcessManager.getInstance().isOnMainProcess();
            if (isOnMainProcess != null && isOnMainProcess.booleanValue() && params != null && params.bundle != null) {
                GdtLog.i(GdtOuterJumpReporter.TAG, "[doOuterReportStart] handle success");
                AdIPCManager.Result result = new AdIPCManager.Result();
                link_report.LinkReport.ReportBiz reportBiz = new link_report.LinkReport.ReportBiz();
                reportBiz.aid = params.bundle.getString("aid");
                reportBiz.pid = params.bundle.getString("pid");
                reportBiz.traceid = params.bundle.getString(TID);
                GdtOuterJumpReporter.getInstance().clickStartReal(reportBiz);
                result.success = true;
                return result;
            }
            GdtLog.e(GdtOuterJumpReporter.TAG, "[doOuterReportStart] handle error");
            return null;
        }
    }

    GdtOuterJumpReporter() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clear() {
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.aditem.GdtOuterJumpReporter.3
            @Override // java.lang.Runnable
            public void run() {
                if (GdtOuterJumpReporter.this.mLifeCycleReportListener == null) {
                    GdtLog.i(GdtOuterJumpReporter.TAG, "[clear] mLifeCycleReportListener is null");
                    return;
                }
                try {
                    GuardManager.sInstance.unregisterCallback(GdtOuterJumpReporter.this.mLifeCycleReportListener);
                } catch (Throwable th5) {
                    GdtLog.e(GdtOuterJumpReporter.TAG, "[clear] ", th5);
                }
                GdtOuterJumpReporter.this.mLifeCycleReportListener = null;
            }
        }, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clickStartReal(final link_report.LinkReport.ReportBiz reportBiz) {
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.aditem.GdtOuterJumpReporter.2
            @Override // java.lang.Runnable
            public void run() {
                if (reportBiz == null) {
                    GdtLog.e(GdtOuterJumpReporter.TAG, "[clickStartReal] biz is null");
                    return;
                }
                if (GdtOuterJumpReporter.this.mLifeCycleReportListener == null) {
                    GdtOuterJumpReporter.this.mLifeCycleReportListener = new LifeCycleReportListener();
                    try {
                        GuardManager.sInstance.registerCallBack(GdtOuterJumpReporter.this.mLifeCycleReportListener);
                    } catch (Throwable th5) {
                        GdtLog.e(GdtOuterJumpReporter.TAG, "[clickStartReal]", th5);
                        return;
                    }
                }
                GdtOuterJumpReporter.this.mLifeCycleReportListener.setStartTimeMillis(System.currentTimeMillis());
                GdtOuterJumpReporter.this.mLifeCycleReportListener.setBiz(reportBiz);
            }
        }, 0);
    }

    public static GdtOuterJumpReporter getInstance() {
        if (sInstance == null) {
            synchronized (GdtOuterJumpReporter.class) {
                if (sInstance == null) {
                    sInstance = new GdtOuterJumpReporter();
                }
            }
        }
        return sInstance;
    }

    public void clickStart(final Ad ad5) {
        if (ad5 == null) {
            GdtLog.e(TAG, "[clickStart] no need reporter");
            return;
        }
        Boolean isOnMainProcess = AdProcessManager.getInstance().isOnMainProcess();
        if (isOnMainProcess == null) {
            GdtLog.e(TAG, "update isOnMainProcess == null");
            return;
        }
        if (!isOnMainProcess.booleanValue()) {
            AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.aditem.GdtOuterJumpReporter.1
                @Override // java.lang.Runnable
                public void run() {
                    if (GdtOuterJumpReporter.this.mIpcHandler != null) {
                        GdtOuterJumpReporter.this.mIpcHandler.doOuterReportStart(String.valueOf(ad5.getAId()), ad5.getPosId(), ad5.getTraceId());
                    }
                }
            }, 3);
            return;
        }
        link_report.LinkReport.ReportBiz reportBiz = new link_report.LinkReport.ReportBiz();
        reportBiz.pid = ad5.getPosId();
        reportBiz.aid = String.valueOf(ad5.getAId());
        reportBiz.traceid = ad5.getTraceId();
        clickStartReal(reportBiz);
    }

    public void registerOuterReportHandler() {
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.aditem.GdtOuterJumpReporter.4
            @Override // java.lang.Runnable
            public void run() {
                if (GdtOuterJumpReporter.this.mIpcHandler == null) {
                    GdtOuterJumpReporter.this.mIpcHandler = new IPCHandler(new WeakReference(BaseApplication.getContext()));
                }
            }
        }, 3);
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    private static class LifeCycleReportListener implements IGuardInterface {
        private link_report.LinkReport.ReportBiz mBiz;
        private long mStartTimeMillis;

        LifeCycleReportListener() {
        }

        private boolean isValid() {
            if (this.mStartTimeMillis > 0 && this.mBiz != null) {
                return true;
            }
            return false;
        }

        private void linkReportWithCostTime(int i3) {
            if (!isValid()) {
                GdtLog.e(GdtOuterJumpReporter.TAG, "[linkReportWithCostTime] !isValid");
                return;
            }
            this.mBiz.cost_time = (int) (System.currentTimeMillis() - this.mStartTimeMillis);
            AdReporterForLinkEvent.getInstance().reportAsync(BaseApplication.getContext(), i3, null, this.mBiz, null);
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationBackground() {
            GdtLog.i(GdtOuterJumpReporter.TAG, "[onApplicationBackground]");
            linkReportWithCostTime(4002027);
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationForeground() {
            GdtLog.i(GdtOuterJumpReporter.TAG, "[onApplicationForeground]");
            linkReportWithCostTime(4002028);
            GdtOuterJumpReporter.getInstance().clear();
        }

        public void setBiz(link_report.LinkReport.ReportBiz reportBiz) {
            this.mBiz = reportBiz;
        }

        public void setStartTimeMillis(long j3) {
            this.mStartTimeMillis = j3;
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundTimeTick(long j3) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundUnguardTimeTick(long j3) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onLiteTimeTick(long j3) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onScreensStateChanged(boolean z16) {
        }
    }
}
