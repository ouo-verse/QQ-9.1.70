package com.tencent.biz.richframework.queue;

import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface RFWDownloadTaskLocalStorageDelegate extends RFWTaskClearStrategy {

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface OnQueryTaskListCallback {
        void onResult(List<RFWDownloadTaskStateData> list);
    }

    void deleteTaskEntry(RFWDownloadTaskStateData rFWDownloadTaskStateData);

    void queryTaskEntryList(String str, OnQueryTaskListCallback onQueryTaskListCallback);

    void updateTaskEntry(RFWDownloadTaskStateData rFWDownloadTaskStateData);
}
