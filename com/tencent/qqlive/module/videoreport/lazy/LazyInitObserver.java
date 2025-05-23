package com.tencent.qqlive.module.videoreport.lazy;

import android.support.annotation.Nullable;
import android.widget.Toast;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConfigConstants;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.task.IThreadTaskInterceptor;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import com.tencent.qqlive.module.videoreport.utils.ReportUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class LazyInitObserver implements IThreadTaskInterceptor {
    private static final long DEFAULT_DELAY_TIME = 0;
    private boolean mCanProceed;
    private boolean mHasInitialized;
    private boolean mHasNotified;
    private final List<Runnable> mPendingTasks;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class InstanceHolder {
        static LazyInitObserver sInstance = new LazyInitObserver();

        InstanceHolder() {
        }
    }

    public static LazyInitObserver getInstance() {
        return InstanceHolder.sInstance;
    }

    private boolean hasInitialized() {
        return this.mHasInitialized;
    }

    private void markInitialized() {
        this.mHasInitialized = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void proceedPendingTasks() {
        Iterator<Runnable> it = this.mPendingTasks.iterator();
        while (it.hasNext()) {
            ThreadUtils.runOnUiThread(it.next());
        }
        this.mPendingTasks.clear();
    }

    private void proceedPendingTasksDelay(long j3) {
        ThreadUtils.getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.lazy.LazyInitObserver.1
            @Override // java.lang.Runnable
            public void run() {
                Log.d(DTConfigConstants.LAZY_INIT_TAG, "start to proceed");
                LazyInitObserver.this.mCanProceed = true;
                LazyInitObserver.this.proceedPendingTasks();
            }
        }, j3);
    }

    private void registerFirstDraw() {
        if (VideoReportInner.getInstance().getConfiguration().getLazyInitType() == 0) {
            markToProceed(0L);
        }
    }

    private void waitToWarn() {
        if (!VideoReportInner.getInstance().isDebugMode()) {
            return;
        }
        ThreadUtils.getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.lazy.LazyInitObserver.2
            @Override // java.lang.Runnable
            public void run() {
                if (!LazyInitObserver.this.mCanProceed) {
                    Log.e(DTConfigConstants.LAZY_INIT_TAG, "ATTENTION:\n=========================ERROR============================\n\n\n    ERROR: \u4f60\u53ef\u80fd\u5fd8\u8bb0\u8c03\u7528markToProceed\uff01\u4f1a\u5bfc\u81f4\u6570\u636e\u65e0\u6cd5\u4e0a\u62a5\uff01\n\n\n========================ERROR END=========================\n");
                    Toast.makeText(ReportUtils.getContext(), "ERROR: \u4f60\u53ef\u80fd\u5fd8\u8bb0\u8c03\u7528markToProceed\uff01\u4f1a\u5bfc\u81f4\u6570\u636e\u65e0\u6cd5\u4e0a\u62a5\uff01", 1).show();
                }
            }
        }, 5000L);
    }

    public void markToProceed() {
        markToProceed(0L);
    }

    public synchronized boolean mayProceedOnMain(@Nullable Runnable runnable) {
        if (runnable == null) {
            return this.mCanProceed;
        }
        if (!this.mCanProceed) {
            this.mPendingTasks.remove(runnable);
            this.mPendingTasks.add(runnable);
        }
        return this.mCanProceed;
    }

    public void onInitialized() {
        if (hasInitialized()) {
            return;
        }
        registerFirstDraw();
        markInitialized();
        waitToWarn();
    }

    @Override // com.tencent.qqlive.module.videoreport.task.IThreadTaskInterceptor
    public boolean removePendingTask(Runnable runnable) {
        return this.mPendingTasks.remove(runnable);
    }

    @Override // com.tencent.qqlive.module.videoreport.task.IThreadTaskInterceptor
    public boolean shouldInterceptTask(Runnable runnable) {
        return !mayProceedOnMain(runnable);
    }

    LazyInitObserver() {
        this.mPendingTasks = new ArrayList();
    }

    private void markToProceed(long j3) {
        if (this.mHasNotified) {
            return;
        }
        this.mHasNotified = true;
        Log.d(DTConfigConstants.LAZY_INIT_TAG, "mark and post to proceed: delay " + j3);
        proceedPendingTasksDelay(j3);
    }
}
