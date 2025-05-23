package com.tencent.thumbplayer.core.datatransport.client;

import android.os.IBinder;
import com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteTaskListener;
import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportMessageInfo;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr;
import com.tencent.thumbplayer.core.datatransport.util.ITPDataTransportLog;
import com.tencent.thumbplayer.core.datatransport.util.TPDataTransportLogFactory;
import com.tencent.thumbplayer.core.datatransport.util.TPListenerMgr;

/* loaded from: classes26.dex */
public class TPRemoteTaskListenerInnerImpl extends ITPRemoteTaskListener.Stub {
    private final ITPDataTransportLog mLogger = TPDataTransportLogFactory.getInstance().getLogger("TPRemoteTaskListenerInnerImpl");
    private final TPListenerMgr<ITPDataTransportTaskMgr.TaskListener> mTaskListenerMgr = new TPListenerMgr<>("TaskListenerInnerMgr");

    public void addTaskListener(int i3, ITPDataTransportTaskMgr.TaskListener taskListener) {
        this.mTaskListenerMgr.addTaskListener(i3, taskListener);
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteTaskListener
    public long getCurrentPlayOffset(int i3) {
        final long[] jArr = {0};
        this.mTaskListenerMgr.startNotify(i3, new TPListenerMgr.INotifyCallback<ITPDataTransportTaskMgr.TaskListener>() { // from class: com.tencent.thumbplayer.core.datatransport.client.TPRemoteTaskListenerInnerImpl.7
            @Override // com.tencent.thumbplayer.core.datatransport.util.TPListenerMgr.INotifyCallback
            public void onNotify(int i16, ITPDataTransportTaskMgr.TaskListener taskListener) {
                jArr[0] = taskListener.getCurrentPlayOffset(i16);
            }
        });
        return jArr[0];
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteTaskListener
    public long getCurrentPosition(int i3) {
        final long[] jArr = {0};
        this.mTaskListenerMgr.startNotify(i3, new TPListenerMgr.INotifyCallback<ITPDataTransportTaskMgr.TaskListener>() { // from class: com.tencent.thumbplayer.core.datatransport.client.TPRemoteTaskListenerInnerImpl.6
            @Override // com.tencent.thumbplayer.core.datatransport.util.TPListenerMgr.INotifyCallback
            public void onNotify(int i16, ITPDataTransportTaskMgr.TaskListener taskListener) {
                jArr[0] = taskListener.getCurrentPosition(i16);
            }
        });
        return jArr[0];
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteTaskListener
    public long getPlayerBufferLength(int i3) {
        final long[] jArr = {0};
        this.mTaskListenerMgr.startNotify(i3, new TPListenerMgr.INotifyCallback<ITPDataTransportTaskMgr.TaskListener>() { // from class: com.tencent.thumbplayer.core.datatransport.client.TPRemoteTaskListenerInnerImpl.5
            @Override // com.tencent.thumbplayer.core.datatransport.util.TPListenerMgr.INotifyCallback
            public void onNotify(int i16, ITPDataTransportTaskMgr.TaskListener taskListener) {
                jArr[0] = taskListener.getPlayerBufferLength(i16);
            }
        });
        return jArr[0];
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteTaskListener
    public long getRemainTimeBeforePlayMs(int i3) {
        final long[] jArr = {0};
        this.mTaskListenerMgr.startNotify(i3, new TPListenerMgr.INotifyCallback<ITPDataTransportTaskMgr.TaskListener>() { // from class: com.tencent.thumbplayer.core.datatransport.client.TPRemoteTaskListenerInnerImpl.8
            @Override // com.tencent.thumbplayer.core.datatransport.util.TPListenerMgr.INotifyCallback
            public void onNotify(int i16, ITPDataTransportTaskMgr.TaskListener taskListener) {
                jArr[0] = taskListener.getRemainTimeBeforePlayMs(i16);
            }
        });
        return jArr[0];
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteTaskListener
    public void onCommonMessageCallback(int i3, final int i16, final TPDataTransportMessageInfo tPDataTransportMessageInfo) {
        this.mTaskListenerMgr.startNotify(i3, new TPListenerMgr.INotifyCallback<ITPDataTransportTaskMgr.TaskListener>() { // from class: com.tencent.thumbplayer.core.datatransport.client.TPRemoteTaskListenerInnerImpl.4
            @Override // com.tencent.thumbplayer.core.datatransport.util.TPListenerMgr.INotifyCallback
            public void onNotify(int i17, ITPDataTransportTaskMgr.TaskListener taskListener) {
                taskListener.onCommonMessageCallback(i17, i16, tPDataTransportMessageInfo);
            }
        });
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteTaskListener
    public void onDownloadError(int i3, final int i16, final int i17, final String str) {
        this.mTaskListenerMgr.startNotify(i3, new TPListenerMgr.INotifyCallback<ITPDataTransportTaskMgr.TaskListener>() { // from class: com.tencent.thumbplayer.core.datatransport.client.TPRemoteTaskListenerInnerImpl.3
            @Override // com.tencent.thumbplayer.core.datatransport.util.TPListenerMgr.INotifyCallback
            public void onNotify(int i18, ITPDataTransportTaskMgr.TaskListener taskListener) {
                taskListener.onDownloadError(i18, i16, i17, str);
            }
        });
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteTaskListener
    public void onDownloadFinished(int i3) {
        this.mTaskListenerMgr.startNotify(i3, new TPListenerMgr.INotifyCallback<ITPDataTransportTaskMgr.TaskListener>() { // from class: com.tencent.thumbplayer.core.datatransport.client.TPRemoteTaskListenerInnerImpl.2
            @Override // com.tencent.thumbplayer.core.datatransport.util.TPListenerMgr.INotifyCallback
            public void onNotify(int i16, ITPDataTransportTaskMgr.TaskListener taskListener) {
                taskListener.onDownloadFinished(i16);
            }
        });
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteTaskListener
    public void onDownloadProgressUpdate(int i3, final int i16, final int i17, final long j3, final long j16, final String str) {
        this.mTaskListenerMgr.startNotify(i3, new TPListenerMgr.INotifyCallback<ITPDataTransportTaskMgr.TaskListener>() { // from class: com.tencent.thumbplayer.core.datatransport.client.TPRemoteTaskListenerInnerImpl.1
            @Override // com.tencent.thumbplayer.core.datatransport.util.TPListenerMgr.INotifyCallback
            public void onNotify(int i18, ITPDataTransportTaskMgr.TaskListener taskListener) {
                taskListener.onDownloadProgressUpdate(i18, i16, i17, j3, j16, str);
            }
        });
    }

    public void removeTaskListener(int i3) {
        this.mTaskListenerMgr.removeTaskListener(i3);
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteTaskListener.Stub, android.os.IInterface
    public IBinder asBinder() {
        return this;
    }
}
