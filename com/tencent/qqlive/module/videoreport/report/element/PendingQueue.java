package com.tencent.qqlive.module.videoreport.report.element;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.data.DataBinder;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes22.dex */
public class PendingQueue {
    private static final String TAG = "PendingQueue";
    private OnQueueListener mOnQueueListener;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final Map<Long, PendingTask> mPendingTasks = new ConcurrentHashMap();

    /* loaded from: classes22.dex */
    public interface OnQueueListener {
        void onDequeue(ExposureElementInfo exposureElementInfo);
    }

    /* loaded from: classes22.dex */
    private class PendingTask implements Runnable {
        final List<ExposureElementInfo> pendingExposureElementInfoRef;

        PendingTask() {
            this.pendingExposureElementInfoRef = new ArrayList();
        }

        void add(ExposureElementInfo exposureElementInfo) {
            this.pendingExposureElementInfoRef.add(exposureElementInfo);
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.pendingExposureElementInfoRef.size();
            for (int i3 = 0; i3 < size; i3++) {
                ExposureElementInfo exposureElementInfo = this.pendingExposureElementInfoRef.get(i3);
                if (exposureElementInfo != null && PendingQueue.this.mOnQueueListener != null) {
                    PendingQueue.this.mOnQueueListener.onDequeue(exposureElementInfo);
                }
            }
            this.pendingExposureElementInfoRef.clear();
        }
    }

    void clearQueue() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void enqueue(List<ExposureElementInfo> list, long j3) {
        if (list == null) {
            return;
        }
        this.mPendingTasks.clear();
        ArrayList arrayList = new ArrayList(list);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            ExposureElementInfo exposureElementInfo = (ExposureElementInfo) arrayList.get(i3);
            if (exposureElementInfo != null) {
                View view = exposureElementInfo.getView();
                FinalData finalData = exposureElementInfo.getFinalData();
                if (view != null && finalData != null) {
                    long max = Math.max(0L, ReportHelper.getExposureMinTime(DataBinder.getDataEntity(view)) + j3);
                    PendingTask pendingTask = this.mPendingTasks.get(Long.valueOf(max));
                    if (pendingTask == null) {
                        pendingTask = new PendingTask();
                        this.mPendingTasks.put(Long.valueOf(max), pendingTask);
                    }
                    pendingTask.add(exposureElementInfo);
                }
            }
        }
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "enqueue: mPendingTasks.size() = " + this.mPendingTasks.size());
        }
        for (Map.Entry<Long, PendingTask> entry : this.mPendingTasks.entrySet()) {
            Long key = entry.getKey();
            PendingTask value = entry.getValue();
            if (VideoReportInner.getInstance().isDebugMode()) {
                Log.d(TAG, "enqueue: delay = " + key + ", view count = " + value.pendingExposureElementInfoRef.size());
            }
            this.mHandler.postDelayed(value, key.longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnQueueListener(OnQueueListener onQueueListener) {
        this.mOnQueueListener = onQueueListener;
    }
}
