package com.tencent.thumbplayer.core.datatransport.service;

import com.tencent.thumbplayer.core.datatransport.aidl.ITPRemotePreloadTaskListener;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportPreloadTaskMgr;
import com.tencent.thumbplayer.core.datatransport.util.ITPDataTransportLog;
import com.tencent.thumbplayer.core.datatransport.util.TPDataTransportLogFactory;

/* loaded from: classes26.dex */
public class TPPreloadTaskListenerInnerImpl implements ITPDataTransportPreloadTaskMgr.PreloadTaskListener {
    private final ITPDataTransportLog mLogger = TPDataTransportLogFactory.getInstance().getLogger("TPPreloadTaskListenerInnerImpl");
    private ITPRemotePreloadTaskListener mRemotePreloadTaskListener;

    public TPPreloadTaskListenerInnerImpl(ITPRemotePreloadTaskListener iTPRemotePreloadTaskListener) {
        this.mRemotePreloadTaskListener = iTPRemotePreloadTaskListener;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportPreloadTaskMgr.PreloadTaskListener
    public void onDownloadProgressUpdate(int i3, int i16, int i17, long j3, long j16, String str) {
        ITPRemotePreloadTaskListener iTPRemotePreloadTaskListener = this.mRemotePreloadTaskListener;
        if (iTPRemotePreloadTaskListener == null) {
            this.mLogger.e("onDownloadProgressUpdate remote preload task listener is null!");
            return;
        }
        try {
            iTPRemotePreloadTaskListener.onDownloadProgressUpdate(i3, i16, i17, j3, j16, str);
        } catch (Throwable th5) {
            this.mLogger.e("onDownloadProgressUpdate failed, taskId:" + i3 + ", error:" + th5);
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportPreloadTaskMgr.PreloadTaskListener
    public void onPrepareError(int i3, int i16, int i17, String str) {
        ITPRemotePreloadTaskListener iTPRemotePreloadTaskListener = this.mRemotePreloadTaskListener;
        if (iTPRemotePreloadTaskListener == null) {
            this.mLogger.e("onPrepareError remote preload task listener is null!");
            return;
        }
        try {
            iTPRemotePreloadTaskListener.onPrepareError(i3, i16, i17, str);
        } catch (Throwable th5) {
            this.mLogger.e("onPrepareError failed, taskId:" + i3 + ", error:" + th5);
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportPreloadTaskMgr.PreloadTaskListener
    public void onPrepareFinished(int i3) {
        ITPRemotePreloadTaskListener iTPRemotePreloadTaskListener = this.mRemotePreloadTaskListener;
        if (iTPRemotePreloadTaskListener == null) {
            this.mLogger.e("onPrepareFinished remote preload task listener is null!");
            return;
        }
        try {
            iTPRemotePreloadTaskListener.onPrepareFinished(i3);
        } catch (Throwable th5) {
            this.mLogger.e("onPrepareFinished failed, taskId:" + i3 + ", error:" + th5);
        }
    }
}
