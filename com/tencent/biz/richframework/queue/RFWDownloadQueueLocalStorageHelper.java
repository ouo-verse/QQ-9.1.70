package com.tencent.biz.richframework.queue;

import android.text.TextUtils;
import com.tencent.biz.richframework.queue.RFWDownloadTaskLocalStorageDelegate;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWDownloadQueueLocalStorageHelper {
    public static void deleteTaskEntry(RFWDownloadTaskStateData rFWDownloadTaskStateData, RFWDownloadTaskLocalStorageDelegate rFWDownloadTaskLocalStorageDelegate) {
        if (rFWDownloadTaskStateData != null && rFWDownloadTaskLocalStorageDelegate != null) {
            rFWDownloadTaskLocalStorageDelegate.deleteTaskEntry(RFWDownloadQueueUtils.copyDownloadTaskStateData(rFWDownloadTaskStateData));
        }
    }

    public static void queryTaskEntryList(String str, RFWDownloadTaskLocalStorageDelegate rFWDownloadTaskLocalStorageDelegate, RFWDownloadTaskLocalStorageDelegate.OnQueryTaskListCallback onQueryTaskListCallback) {
        if (!TextUtils.isEmpty(str) && rFWDownloadTaskLocalStorageDelegate != null) {
            rFWDownloadTaskLocalStorageDelegate.queryTaskEntryList(str, onQueryTaskListCallback);
        }
    }

    public static void updateTaskEntry(RFWDownloadTaskStateData rFWDownloadTaskStateData, RFWDownloadTaskLocalStorageDelegate rFWDownloadTaskLocalStorageDelegate) {
        if (rFWDownloadTaskStateData != null && rFWDownloadTaskLocalStorageDelegate != null) {
            rFWDownloadTaskLocalStorageDelegate.updateTaskEntry(RFWDownloadQueueUtils.copyDownloadTaskStateData(rFWDownloadTaskStateData));
        }
    }
}
