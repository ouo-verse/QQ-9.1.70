package com.tencent.thumbplayer.core.datatransport.client;

import android.os.IBinder;
import com.tencent.thumbplayer.core.datatransport.aidl.ITPRemotePreloadTaskListener;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportPreloadTaskMgr;
import com.tencent.thumbplayer.core.datatransport.util.ITPDataTransportLog;
import com.tencent.thumbplayer.core.datatransport.util.TPDataTransportLogFactory;
import com.tencent.thumbplayer.core.datatransport.util.TPListenerMgr;

/* loaded from: classes26.dex */
public class TPRemotePreloadTaskListenerInnerImpl extends ITPRemotePreloadTaskListener.Stub {
    private final ITPDataTransportLog mLogger = TPDataTransportLogFactory.getInstance().getLogger("TPRemotePreloadTaskListenerInnerImpl");
    private final TPListenerMgr<ITPDataTransportPreloadTaskMgr.PreloadTaskListener> mPreloadTaskListenerMgr = new TPListenerMgr<>("PreloadTaskListenerInnerMgr");

    public void addPreloadTaskListener(int i3, ITPDataTransportPreloadTaskMgr.PreloadTaskListener preloadTaskListener) {
        this.mPreloadTaskListenerMgr.addTaskListener(i3, preloadTaskListener);
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemotePreloadTaskListener
    public void onDownloadProgressUpdate(int i3, final int i16, final int i17, final long j3, final long j16, final String str) {
        this.mPreloadTaskListenerMgr.startNotify(i3, new TPListenerMgr.INotifyCallback<ITPDataTransportPreloadTaskMgr.PreloadTaskListener>() { // from class: com.tencent.thumbplayer.core.datatransport.client.TPRemotePreloadTaskListenerInnerImpl.1
            @Override // com.tencent.thumbplayer.core.datatransport.util.TPListenerMgr.INotifyCallback
            public void onNotify(int i18, ITPDataTransportPreloadTaskMgr.PreloadTaskListener preloadTaskListener) {
                preloadTaskListener.onDownloadProgressUpdate(i18, i16, i17, j3, j16, str);
            }
        });
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemotePreloadTaskListener
    public void onPrepareError(int i3, final int i16, final int i17, final String str) {
        this.mPreloadTaskListenerMgr.startNotify(i3, new TPListenerMgr.INotifyCallback<ITPDataTransportPreloadTaskMgr.PreloadTaskListener>() { // from class: com.tencent.thumbplayer.core.datatransport.client.TPRemotePreloadTaskListenerInnerImpl.3
            @Override // com.tencent.thumbplayer.core.datatransport.util.TPListenerMgr.INotifyCallback
            public void onNotify(int i18, ITPDataTransportPreloadTaskMgr.PreloadTaskListener preloadTaskListener) {
                preloadTaskListener.onPrepareError(i18, i16, i17, str);
            }
        });
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemotePreloadTaskListener
    public void onPrepareFinished(int i3) {
        this.mPreloadTaskListenerMgr.startNotify(i3, new TPListenerMgr.INotifyCallback<ITPDataTransportPreloadTaskMgr.PreloadTaskListener>() { // from class: com.tencent.thumbplayer.core.datatransport.client.TPRemotePreloadTaskListenerInnerImpl.2
            @Override // com.tencent.thumbplayer.core.datatransport.util.TPListenerMgr.INotifyCallback
            public void onNotify(int i16, ITPDataTransportPreloadTaskMgr.PreloadTaskListener preloadTaskListener) {
                preloadTaskListener.onPrepareFinished(i16);
            }
        });
    }

    public void removePreloadTaskListener(int i3) {
        this.mPreloadTaskListenerMgr.removeTaskListener(i3);
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemotePreloadTaskListener.Stub, android.os.IInterface
    public IBinder asBinder() {
        return this;
    }
}
