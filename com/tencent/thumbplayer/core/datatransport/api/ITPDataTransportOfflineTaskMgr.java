package com.tencent.thumbplayer.core.datatransport.api;

import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportMessageInfo;
import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportTaskParam;
import java.util.List;

/* loaded from: classes26.dex */
public interface ITPDataTransportOfflineTaskMgr {

    /* loaded from: classes26.dex */
    public interface OfflineTaskListener {
        void onCommonMessageCallback(int i3, int i16, TPDataTransportMessageInfo tPDataTransportMessageInfo);

        void onDownloadError(int i3, int i16, int i17, String str);

        void onDownloadFinished(int i3);

        void onDownloadProgressUpdate(int i3, int i16, int i17, long j3, long j16, String str);
    }

    int createMultiOfflineTask(List<TPDataTransportTaskParam> list, OfflineTaskListener offlineTaskListener);

    int createOfflineTask(TPDataTransportTaskParam tPDataTransportTaskParam, OfflineTaskListener offlineTaskListener);

    String getHLSOfflineExtTag(String str, String str2, int i3, long j3);

    int removeOfflineTask(int i3, String str);

    void startOfflineTask(int i3);

    void stopOfflineTask(int i3);

    void updateOfflinePath(int i3, String str);

    long verifyOfflineCacheSync(String str, int i3, String str2, String str3);
}
