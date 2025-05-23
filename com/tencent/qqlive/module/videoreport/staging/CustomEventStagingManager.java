package com.tencent.qqlive.module.videoreport.staging;

import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.common.EventData;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes22.dex */
public class CustomEventStagingManager {
    private static final String TAG = "StagingManager";
    private List<EventData> mCustomEventStagingDataList;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class InstanceHolder {
        static final CustomEventStagingManager INSTANCE = new CustomEventStagingManager();

        InstanceHolder() {
        }
    }

    public static CustomEventStagingManager getInstance() {
        return InstanceHolder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return VideoReportInner.getInstance().isDebugMode();
    }

    private boolean isStagingListEmpty() {
        return this.mCustomEventStagingDataList.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void supplementStagingEvent() {
        if (this.mCustomEventStagingDataList.isEmpty()) {
            Log.i(TAG, "supplementStagingEvent dataList is empty");
            return;
        }
        if (isDebug()) {
            Log.i(TAG, "supplementStagingEvent");
        }
        ArrayList arrayList = new ArrayList();
        for (EventData eventData : this.mCustomEventStagingDataList) {
            VideoReportInner.getInstance().reportEvent(eventData);
            arrayList.add(eventData);
        }
        this.mCustomEventStagingDataList.removeAll(arrayList);
        arrayList.clear();
    }

    public void save(EventData eventData) {
        if (isDebug()) {
            Log.i(TAG, "eventData:" + eventData);
        }
        this.mCustomEventStagingDataList.add(eventData);
    }

    public void supplementReportsEvent() {
        if (isStagingListEmpty()) {
            return;
        }
        ThreadUtils.execTask(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.staging.CustomEventStagingManager.1
            @Override // java.lang.Runnable
            public void run() {
                if (CustomEventStagingManager.this.isDebug()) {
                    Log.i(CustomEventStagingManager.TAG, "supplementReportsEvent");
                }
                CustomEventStagingManager.this.supplementStagingEvent();
            }
        });
    }

    CustomEventStagingManager() {
        this.mCustomEventStagingDataList = new CopyOnWriteArrayList();
    }
}
