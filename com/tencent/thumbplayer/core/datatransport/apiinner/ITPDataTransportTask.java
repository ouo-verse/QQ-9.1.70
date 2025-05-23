package com.tencent.thumbplayer.core.datatransport.apiinner;

import com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote;
import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportTaskParam;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportOfflineTaskMgr;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportPreloadTaskMgr;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr;
import com.tencent.thumbplayer.core.datatransport.resourceloader.ITPDownloadProxyResourceLoaderListener;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes26.dex */
public interface ITPDataTransportTask {
    int createMultiOfflineTask(List<TPDataTransportTaskParam> list, ITPDataTransportOfflineTaskMgr.OfflineTaskListener offlineTaskListener);

    int createMultiTask(List<TPDataTransportTaskParam> list, ITPDataTransportTaskMgr.TaskListener taskListener);

    int createOfflineTask(TPDataTransportTaskParam tPDataTransportTaskParam, ITPDataTransportOfflineTaskMgr.OfflineTaskListener offlineTaskListener);

    int createPreloadTask(TPDataTransportTaskParam tPDataTransportTaskParam, ITPDataTransportPreloadTaskMgr.PreloadTaskListener preloadTaskListener);

    int createTask(TPDataTransportTaskParam tPDataTransportTaskParam, ITPDataTransportTaskMgr.TaskListener taskListener);

    ArrayList<String> getMultiProxyUrlList(int i3, int i16);

    String getProxyUrl(int i3, int i16);

    String getTaskAccessibleNativeInfo(int i3, int i16);

    String getTaskErrorCode(int i3);

    void pauseTask(int i3);

    void resumeTask(int i3);

    void setTaskOptionalConfigParam(int i3, String str, String str2);

    void setTaskResourceLoaderListener(int i3, ITPDownloadProxyResourceLoaderListener iTPDownloadProxyResourceLoaderListener);

    void startTask(int i3);

    void stopTask(int i3);

    void updateRemoteService(ITPDataTransportRemote iTPDataTransportRemote);

    void updateRunningTaskParam(int i3, List<TPDataTransportTaskParam> list);
}
