package com.tencent.qqlive.module.videoreport.staging;

import android.app.Activity;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.collect.DefaultEventListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.report.FinalDataTarget;
import com.tencent.qqlive.module.videoreport.staging.data.StashEvent;
import com.tencent.qqlive.module.videoreport.storage.DataStorageFactory;
import com.tencent.qqlive.module.videoreport.storage.IDataStorage;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import com.tencent.qqlive.module.videoreport.utils.ReportUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class EventStashManager extends DefaultEventListener {
    private static final String TAG = "EventStashManager";
    private volatile boolean mLaunchReported;
    private Map<String, StashEvent> mPendingStashEvents;
    private IDataStorage mStorage;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class InstanceHolder {
        static final EventStashManager INSTANCE;

        static {
            EventStashManager eventStashManager = new EventStashManager();
            INSTANCE = eventStashManager;
            eventStashManager.init();
        }

        InstanceHolder() {
        }
    }

    public static EventStashManager getInstance() {
        return InstanceHolder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() {
        this.mPendingStashEvents = new ConcurrentHashMap();
        this.mStorage = DataStorageFactory.getInstance(ReportUtils.getContext(), 1);
        EventCollector.getInstance().registerEventListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void movePendingToStore() {
        HashMap hashMap;
        synchronized (this.mPendingStashEvents) {
            if (!this.mPendingStashEvents.isEmpty()) {
                hashMap = new HashMap(this.mPendingStashEvents);
                this.mPendingStashEvents.clear();
            } else {
                hashMap = null;
            }
        }
        if (hashMap == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(hashMap.keySet());
        this.mStorage.storeOrUpdate(new ArrayList(hashMap.values()), arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void realCancelStashEvent(String str) {
        if (!this.mStorage.contains(StashEvent.class, str)) {
            Log.i(TAG, "realRemoveStashEvent, not found stash event, stashKey: " + str + ", report stash event is ignored!");
            return;
        }
        Log.i(TAG, "realCancelStashEvent, remove stash event, stashKey: " + str);
        this.mStorage.delete(StashEvent.class, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void realReportEvent() {
        List<StashEvent> loadAll = this.mStorage.loadAll(StashEvent.class);
        if (BaseUtils.isEmpty(loadAll)) {
            Log.w(TAG, "realReportEvent, stash event is empty, report stash event is ignored!");
            return;
        }
        Log.w(TAG, "realReportEvent, stash event count: " + loadAll.size());
        this.mStorage.deleteAll(StashEvent.class);
        for (StashEvent stashEvent : loadAll) {
            FinalDataTarget.reportStashEvent(null, stashEvent.getEventKey(), stashEvent.getEventParams(), stashEvent.getAppKey());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void realStashEvent(String str, StashEvent stashEvent) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "realStashEvent, stash event, stashKey: " + str + ", stashEvent: " + stashEvent);
        }
        if (!this.mLaunchReported) {
            this.mPendingStashEvents.put(str, stashEvent);
        } else {
            this.mStorage.storeOrUpdate((IDataStorage) stashEvent, str);
        }
        reportStashEventIfNeed();
    }

    private void reportStashEventIfNeed() {
        ThreadUtils.execTask(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.staging.EventStashManager.3
            @Override // java.lang.Runnable
            public void run() {
                if (!EventStashManager.this.mLaunchReported) {
                    EventStashManager.this.realReportEvent();
                    EventStashManager.this.mLaunchReported = true;
                    EventStashManager.this.movePendingToStore();
                }
            }
        });
    }

    public void cancelStashEvent(String str, Map<String, Object> map) {
        final String stashKey = StashKeyExtractor.getStashKey(str, map);
        if (stashKey == null) {
            return;
        }
        ThreadUtils.execTask(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.staging.EventStashManager.2
            @Override // java.lang.Runnable
            public void run() {
                EventStashManager.this.realCancelStashEvent(stashKey);
            }
        });
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.DefaultEventListener, com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onActivityResume(Activity activity) {
        super.onActivityResume(activity);
        reportStashEventIfNeed();
    }

    public void stashEvent(String str, Map<String, Object> map, String str2) {
        final String stashKey = StashKeyExtractor.getStashKey(str, map);
        if (stashKey == null) {
            Log.w(TAG, "stashEvent, The event key: " + str + "hasn't specified stashId, stash event is ignored!");
            return;
        }
        final StashEvent stashEvent = new StashEvent(str, map, str2);
        ThreadUtils.execTask(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.staging.EventStashManager.1
            @Override // java.lang.Runnable
            public void run() {
                EventStashManager.this.realStashEvent(stashKey, stashEvent);
            }
        });
    }

    EventStashManager() {
    }
}
