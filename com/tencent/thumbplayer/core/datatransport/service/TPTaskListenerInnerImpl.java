package com.tencent.thumbplayer.core.datatransport.service;

import com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteTaskListener;
import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportMessageInfo;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr;
import com.tencent.thumbplayer.core.datatransport.util.ITPDataTransportLog;
import com.tencent.thumbplayer.core.datatransport.util.TPDataTransportLogFactory;

/* loaded from: classes26.dex */
public class TPTaskListenerInnerImpl implements ITPDataTransportTaskMgr.TaskListener {
    private final ITPDataTransportLog mLogger = TPDataTransportLogFactory.getInstance().getLogger("TPTaskListenerInnerImpl");
    private ITPRemoteTaskListener mRemoteTaskListener;

    public TPTaskListenerInnerImpl(ITPRemoteTaskListener iTPRemoteTaskListener) {
        this.mRemoteTaskListener = iTPRemoteTaskListener;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr.TaskListener
    public long getCurrentPlayOffset(int i3) {
        ITPRemoteTaskListener iTPRemoteTaskListener = this.mRemoteTaskListener;
        if (iTPRemoteTaskListener == null) {
            this.mLogger.e("getCurrentPlayOffset remote task listener is null!");
            return -1L;
        }
        try {
            return iTPRemoteTaskListener.getCurrentPlayOffset(i3);
        } catch (Throwable th5) {
            this.mLogger.e("getCurrentPlayOffset failed, taskId:" + i3 + ", error:" + th5);
            return 0L;
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr.TaskListener
    public long getCurrentPosition(int i3) {
        ITPRemoteTaskListener iTPRemoteTaskListener = this.mRemoteTaskListener;
        if (iTPRemoteTaskListener == null) {
            this.mLogger.e("getCurrentPosition remote task listener is null!");
            return -1L;
        }
        try {
            return iTPRemoteTaskListener.getCurrentPosition(i3);
        } catch (Throwable th5) {
            this.mLogger.e("getCurrentPosition failed, taskId:" + i3 + ", error:" + th5);
            return 0L;
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr.TaskListener
    public long getPlayerBufferLength(int i3) {
        ITPRemoteTaskListener iTPRemoteTaskListener = this.mRemoteTaskListener;
        if (iTPRemoteTaskListener == null) {
            this.mLogger.e("getPlayerBufferLength remote task listener is null!");
            return -1L;
        }
        try {
            return iTPRemoteTaskListener.getPlayerBufferLength(i3);
        } catch (Throwable th5) {
            this.mLogger.e("getPlayerBufferLength failed, taskId:" + i3 + ", error:" + th5);
            return 0L;
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr.TaskListener
    public long getRemainTimeBeforePlayMs(int i3) {
        ITPRemoteTaskListener iTPRemoteTaskListener = this.mRemoteTaskListener;
        if (iTPRemoteTaskListener == null) {
            this.mLogger.e("getRemainTimeBeforePlayMs remote task listener is null!");
            return -1L;
        }
        try {
            return iTPRemoteTaskListener.getRemainTimeBeforePlayMs(i3);
        } catch (Throwable th5) {
            this.mLogger.e("getRemainTimeBeforePlayMs failed, taskId:" + i3 + ", error:" + th5);
            return 0L;
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr.TaskListener
    public void onCommonMessageCallback(int i3, int i16, TPDataTransportMessageInfo tPDataTransportMessageInfo) {
        ITPRemoteTaskListener iTPRemoteTaskListener = this.mRemoteTaskListener;
        if (iTPRemoteTaskListener == null) {
            this.mLogger.e("onCommonMessageCallback remote task listener is null!");
            return;
        }
        try {
            iTPRemoteTaskListener.onCommonMessageCallback(i3, i16, tPDataTransportMessageInfo);
        } catch (Throwable th5) {
            this.mLogger.e("onCommonMessageCallback failed, taskId:" + i3 + ", error:" + th5);
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr.TaskListener
    public void onDownloadError(int i3, int i16, int i17, String str) {
        ITPRemoteTaskListener iTPRemoteTaskListener = this.mRemoteTaskListener;
        if (iTPRemoteTaskListener == null) {
            this.mLogger.e("onDownloadError remote task listener is null!");
            return;
        }
        try {
            iTPRemoteTaskListener.onDownloadError(i3, i16, i17, str);
        } catch (Throwable th5) {
            this.mLogger.e("onDownloadError failed, taskId:" + i3 + ", error:" + th5);
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr.TaskListener
    public void onDownloadFinished(int i3) {
        ITPRemoteTaskListener iTPRemoteTaskListener = this.mRemoteTaskListener;
        if (iTPRemoteTaskListener == null) {
            this.mLogger.e("onDownloadFinished remote task listener is null!");
            return;
        }
        try {
            iTPRemoteTaskListener.onDownloadFinished(i3);
        } catch (Throwable th5) {
            this.mLogger.e("onDownloadFinished failed, taskId:" + i3 + ", error:" + th5);
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr.TaskListener
    public void onDownloadProgressUpdate(int i3, int i16, int i17, long j3, long j16, String str) {
        ITPRemoteTaskListener iTPRemoteTaskListener = this.mRemoteTaskListener;
        if (iTPRemoteTaskListener == null) {
            this.mLogger.e("onDownloadProgressUpdate remote task listener is null!");
            return;
        }
        try {
            iTPRemoteTaskListener.onDownloadProgressUpdate(i3, i16, i17, j3, j16, str);
        } catch (Throwable th5) {
            this.mLogger.e("onDownloadProgressUpdate failed, taskId:" + i3 + ", error:" + th5);
        }
    }
}
