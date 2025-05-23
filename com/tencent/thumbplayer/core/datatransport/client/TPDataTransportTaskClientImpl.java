package com.tencent.thumbplayer.core.datatransport.client;

import com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote;
import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportTaskParam;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportOfflineTaskMgr;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportPreloadTaskMgr;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr;
import com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportTask;
import com.tencent.thumbplayer.core.datatransport.resourceloader.ITPDownloadProxyResourceLoaderListener;
import com.tencent.thumbplayer.core.datatransport.util.ITPDataTransportLog;
import com.tencent.thumbplayer.core.datatransport.util.TPDataTransportLogFactory;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes26.dex */
public class TPDataTransportTaskClientImpl implements ITPDataTransportTask {
    private static final int INVALID_TASK_ID = -1;
    private final ITPDataTransportLog mLogger;
    private final TPRemotePreloadTaskListenerInnerImpl mRemotePreloadTaskListener;
    private final TPRemoteResourceLoaderListenerInnerImpl mRemoteResourceLoaderListener;
    private ITPDataTransportRemote mRemoteService;
    private final TPRemoteTaskListenerInnerImpl mRemoteTaskListener;

    public TPDataTransportTaskClientImpl() {
        ITPDataTransportLog logger = TPDataTransportLogFactory.getInstance().getLogger("TPDataTransportTaskClientImpl");
        this.mLogger = logger;
        this.mRemoteTaskListener = new TPRemoteTaskListenerInnerImpl();
        this.mRemotePreloadTaskListener = new TPRemotePreloadTaskListenerInnerImpl();
        this.mRemoteResourceLoaderListener = new TPRemoteResourceLoaderListenerInnerImpl();
        logger.i("construct start");
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportTask
    public int createMultiOfflineTask(List<TPDataTransportTaskParam> list, ITPDataTransportOfflineTaskMgr.OfflineTaskListener offlineTaskListener) {
        return -1;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportTask
    public int createMultiTask(List<TPDataTransportTaskParam> list, ITPDataTransportTaskMgr.TaskListener taskListener) {
        ITPDataTransportRemote iTPDataTransportRemote = this.mRemoteService;
        int i3 = -1;
        if (iTPDataTransportRemote == null) {
            this.mLogger.e("createMultiTask failed, remote service is null");
            return -1;
        }
        try {
            i3 = iTPDataTransportRemote.createMultiTask(list, this.mRemoteTaskListener);
            if (i3 > 0) {
                this.mRemoteTaskListener.addTaskListener(i3, taskListener);
            }
        } catch (Throwable th5) {
            this.mLogger.e("createMultiTask failed, error:" + th5);
        }
        return i3;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportTask
    public int createOfflineTask(TPDataTransportTaskParam tPDataTransportTaskParam, ITPDataTransportOfflineTaskMgr.OfflineTaskListener offlineTaskListener) {
        return -1;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportTask
    public int createPreloadTask(TPDataTransportTaskParam tPDataTransportTaskParam, ITPDataTransportPreloadTaskMgr.PreloadTaskListener preloadTaskListener) {
        ITPDataTransportRemote iTPDataTransportRemote = this.mRemoteService;
        int i3 = -1;
        if (iTPDataTransportRemote == null) {
            this.mLogger.e("createPreloadTask failed, remote service is null");
            return -1;
        }
        try {
            i3 = iTPDataTransportRemote.createPreloadTask(tPDataTransportTaskParam, this.mRemotePreloadTaskListener);
            if (i3 > 0) {
                this.mRemotePreloadTaskListener.addPreloadTaskListener(i3, preloadTaskListener);
            }
        } catch (Throwable th5) {
            this.mLogger.e("createPreloadTask failed, error:" + th5);
        }
        return i3;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportTask
    public int createTask(TPDataTransportTaskParam tPDataTransportTaskParam, ITPDataTransportTaskMgr.TaskListener taskListener) {
        ITPDataTransportRemote iTPDataTransportRemote = this.mRemoteService;
        int i3 = -1;
        if (iTPDataTransportRemote == null) {
            this.mLogger.e("createTask failed, remote service is null");
            return -1;
        }
        try {
            i3 = iTPDataTransportRemote.createTask(tPDataTransportTaskParam, this.mRemoteTaskListener);
            if (i3 > 0) {
                this.mRemoteTaskListener.addTaskListener(i3, taskListener);
            }
        } catch (Throwable th5) {
            this.mLogger.e("createTask failed, error:" + th5);
        }
        return i3;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportTask
    public ArrayList<String> getMultiProxyUrlList(int i3, int i16) {
        if (this.mRemoteService == null) {
            this.mLogger.e("getMultiProxyUrlList failed, remote service is null");
            return new ArrayList<>();
        }
        try {
            return new ArrayList<>(this.mRemoteService.getMultiProxyUrlList(i3, i16));
        } catch (Throwable th5) {
            this.mLogger.e("getMultiProxyUrlList failed, error:" + th5);
            return new ArrayList<>();
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportTask
    public String getProxyUrl(int i3, int i16) {
        ITPDataTransportRemote iTPDataTransportRemote = this.mRemoteService;
        if (iTPDataTransportRemote == null) {
            this.mLogger.e("getProxyUrl failed, remote service is null");
            return "";
        }
        try {
            return iTPDataTransportRemote.getProxyUrl(i3, i16);
        } catch (Throwable th5) {
            this.mLogger.e("getProxyUrl failed, error:" + th5);
            return "";
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportTask
    public String getTaskAccessibleNativeInfo(int i3, int i16) {
        ITPDataTransportRemote iTPDataTransportRemote = this.mRemoteService;
        if (iTPDataTransportRemote == null) {
            this.mLogger.e("getTaskAccessibleNativeInfo failed, remote service is null");
            return "";
        }
        try {
            return iTPDataTransportRemote.getTaskAccessibleNativeInfo(i3, i16);
        } catch (Throwable th5) {
            this.mLogger.e("getTaskAccessibleNativeInfo failed, error:" + th5);
            return null;
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportTask
    public String getTaskErrorCode(int i3) {
        ITPDataTransportRemote iTPDataTransportRemote = this.mRemoteService;
        if (iTPDataTransportRemote == null) {
            this.mLogger.e("stopTask failed, remote service is null");
            return "";
        }
        try {
            return iTPDataTransportRemote.getTaskErrorCode(i3);
        } catch (Throwable th5) {
            this.mLogger.e("getTaskErrorCode failed, error:" + th5);
            return "";
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportTask
    public void pauseTask(int i3) {
        ITPDataTransportRemote iTPDataTransportRemote = this.mRemoteService;
        if (iTPDataTransportRemote == null) {
            this.mLogger.e("stopTask failed, remote service is null");
            return;
        }
        try {
            iTPDataTransportRemote.pauseTask(i3);
        } catch (Throwable th5) {
            this.mLogger.e("pauseTask failed, error:" + th5);
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportTask
    public void resumeTask(int i3) {
        ITPDataTransportRemote iTPDataTransportRemote = this.mRemoteService;
        if (iTPDataTransportRemote == null) {
            this.mLogger.e("stopTask failed, remote service is null");
            return;
        }
        try {
            iTPDataTransportRemote.resumeTask(i3);
        } catch (Throwable th5) {
            this.mLogger.e("resumeTask failed, error:" + th5);
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportTask
    public void setTaskOptionalConfigParam(int i3, String str, String str2) {
        ITPDataTransportRemote iTPDataTransportRemote = this.mRemoteService;
        if (iTPDataTransportRemote == null) {
            this.mLogger.e("setTaskOptionalConfigParam failed, remote service is null");
            return;
        }
        try {
            iTPDataTransportRemote.updateRunningTaskInfo(i3, str, str2);
        } catch (Throwable th5) {
            this.mLogger.e("setTaskOptionalConfigParam failed, error:" + th5);
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportTask
    public void setTaskResourceLoaderListener(int i3, ITPDownloadProxyResourceLoaderListener iTPDownloadProxyResourceLoaderListener) {
        ITPDataTransportRemote iTPDataTransportRemote = this.mRemoteService;
        if (iTPDataTransportRemote == null) {
            this.mLogger.e("setTaskResourceLoaderListener failed, remote service is null");
            return;
        }
        if (i3 > 0) {
            try {
                iTPDataTransportRemote.setTaskResourceLoaderListener(i3, this.mRemoteResourceLoaderListener);
                this.mRemoteResourceLoaderListener.addResourceLoaderListener(i3, iTPDownloadProxyResourceLoaderListener);
            } catch (Throwable th5) {
                this.mLogger.e("setTaskResourceLoaderListener failed, error:" + th5);
            }
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportTask
    public void startTask(int i3) {
        ITPDataTransportRemote iTPDataTransportRemote = this.mRemoteService;
        if (iTPDataTransportRemote == null) {
            this.mLogger.e("startTask failed, remote service is null");
            return;
        }
        try {
            iTPDataTransportRemote.startTask(i3);
        } catch (Throwable th5) {
            this.mLogger.e("startTask failed, error:" + th5);
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportTask
    public void stopTask(int i3) {
        ITPDataTransportRemote iTPDataTransportRemote = this.mRemoteService;
        if (iTPDataTransportRemote == null) {
            this.mLogger.e("stopTask failed, remote service is null");
            return;
        }
        try {
            iTPDataTransportRemote.stopTask(i3);
            this.mRemoteTaskListener.removeTaskListener(i3);
            this.mRemotePreloadTaskListener.removePreloadTaskListener(i3);
            this.mRemoteResourceLoaderListener.removeResourceLoaderListener(i3);
        } catch (Throwable th5) {
            this.mLogger.e("stopTask failed, error:" + th5);
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportTask
    public void updateRemoteService(ITPDataTransportRemote iTPDataTransportRemote) {
        this.mLogger.i("update remote service");
        this.mRemoteService = iTPDataTransportRemote;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportTask
    public void updateRunningTaskParam(int i3, List<TPDataTransportTaskParam> list) {
        ITPDataTransportRemote iTPDataTransportRemote = this.mRemoteService;
        if (iTPDataTransportRemote == null) {
            this.mLogger.e("updateRunningTaskParam failed, remote service is null");
            return;
        }
        try {
            iTPDataTransportRemote.updateRunningTaskParam(i3, list);
        } catch (Throwable th5) {
            this.mLogger.e("updateRunningTaskParam failed, error:" + th5);
        }
    }
}
