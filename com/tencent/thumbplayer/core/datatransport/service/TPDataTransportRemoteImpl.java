package com.tencent.thumbplayer.core.datatransport.service;

import com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote;
import com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteDataTransportResourceLoaderListener;
import com.tencent.thumbplayer.core.datatransport.aidl.ITPRemotePreloadTaskListener;
import com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteTaskListener;
import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportTaskParam;
import com.tencent.thumbplayer.core.datatransport.apiinner.ITPDataTransportTask;
import com.tencent.thumbplayer.core.datatransport.apiinner.TPDataTransportFactory;
import com.tencent.thumbplayer.core.datatransport.util.ITPDataTransportLog;
import com.tencent.thumbplayer.core.datatransport.util.TPDataTransportLogFactory;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes26.dex */
public class TPDataTransportRemoteImpl extends ITPDataTransportRemote.Stub {
    private ITPDataTransportTask mDataTransport;
    private final ITPDataTransportLog mLogger;

    public TPDataTransportRemoteImpl() {
        ITPDataTransportLog logger = TPDataTransportLogFactory.getInstance().getLogger("TPDataTransportRemoteImpl");
        this.mLogger = logger;
        this.mDataTransport = null;
        this.mDataTransport = TPDataTransportFactory.getInstance().getDataTransport(true);
        logger.i("construct start");
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
    public int createMultiTask(List<TPDataTransportTaskParam> list, ITPRemoteTaskListener iTPRemoteTaskListener) {
        return this.mDataTransport.createMultiTask(list, new TPTaskListenerInnerImpl(iTPRemoteTaskListener));
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
    public int createPreloadTask(TPDataTransportTaskParam tPDataTransportTaskParam, ITPRemotePreloadTaskListener iTPRemotePreloadTaskListener) {
        return this.mDataTransport.createPreloadTask(tPDataTransportTaskParam, new TPPreloadTaskListenerInnerImpl(iTPRemotePreloadTaskListener));
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
    public int createTask(TPDataTransportTaskParam tPDataTransportTaskParam, ITPRemoteTaskListener iTPRemoteTaskListener) {
        return this.mDataTransport.createTask(tPDataTransportTaskParam, new TPTaskListenerInnerImpl(iTPRemoteTaskListener));
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
    public String getProxyUrl(int i3, int i16) {
        return this.mDataTransport.getProxyUrl(i3, i16);
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
    public String getTaskAccessibleNativeInfo(int i3, int i16) {
        return this.mDataTransport.getTaskAccessibleNativeInfo(i3, i16);
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
    public String getTaskErrorCode(int i3) {
        return this.mDataTransport.getTaskErrorCode(i3);
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
    public void pauseTask(int i3) {
        this.mDataTransport.pauseTask(i3);
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
    public void resumeTask(int i3) {
        this.mDataTransport.resumeTask(i3);
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
    public void setTaskResourceLoaderListener(int i3, ITPRemoteDataTransportResourceLoaderListener iTPRemoteDataTransportResourceLoaderListener) {
        this.mDataTransport.setTaskResourceLoaderListener(i3, new TPResourceLoaderListenerInnerImpl(iTPRemoteDataTransportResourceLoaderListener));
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
    public void startTask(int i3) {
        this.mDataTransport.startTask(i3);
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
    public void stopTask(int i3) {
        this.mDataTransport.stopTask(i3);
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
    public void updateRunningTaskInfo(int i3, String str, String str2) {
        this.mDataTransport.setTaskOptionalConfigParam(i3, str, str2);
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
    public void updateRunningTaskParam(int i3, List<TPDataTransportTaskParam> list) {
        this.mDataTransport.updateRunningTaskParam(i3, list);
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
    public ArrayList<String> getMultiProxyUrlList(int i3, int i16) {
        return this.mDataTransport.getMultiProxyUrlList(i3, i16);
    }
}
