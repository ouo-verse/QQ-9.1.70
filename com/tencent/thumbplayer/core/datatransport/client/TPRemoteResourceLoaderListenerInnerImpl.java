package com.tencent.thumbplayer.core.datatransport.client;

import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteDataTransportResourceLoaderListener;
import com.tencent.thumbplayer.core.datatransport.resourceloader.ITPDownloadProxyResourceLoaderListener;
import com.tencent.thumbplayer.core.datatransport.util.ITPDataTransportLog;
import com.tencent.thumbplayer.core.datatransport.util.TPDataTransportLogFactory;
import com.tencent.thumbplayer.core.datatransport.util.TPListenerMgr;

/* loaded from: classes26.dex */
public class TPRemoteResourceLoaderListenerInnerImpl extends ITPRemoteDataTransportResourceLoaderListener.Stub {
    private final ITPDataTransportLog mLogger;
    private final TPListenerMgr<ITPDownloadProxyResourceLoaderListener> mResourceLoaderListenerMgr;

    public TPRemoteResourceLoaderListenerInnerImpl() {
        ITPDataTransportLog logger = TPDataTransportLogFactory.getInstance().getLogger("TPRemoteResourceLoaderListenerInnerImpl");
        this.mLogger = logger;
        this.mResourceLoaderListenerMgr = new TPListenerMgr<>("ResourceLoaderListenerInnerMgr");
        logger.i("construct start");
    }

    public void addResourceLoaderListener(int i3, ITPDownloadProxyResourceLoaderListener iTPDownloadProxyResourceLoaderListener) {
        this.mResourceLoaderListenerMgr.addTaskListener(i3, iTPDownloadProxyResourceLoaderListener);
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteDataTransportResourceLoaderListener
    public String getContentType(final int i3, final String str) throws RemoteException {
        final String[] strArr = {""};
        this.mResourceLoaderListenerMgr.startNotify(i3, new TPListenerMgr.INotifyCallback<ITPDownloadProxyResourceLoaderListener>() { // from class: com.tencent.thumbplayer.core.datatransport.client.TPRemoteResourceLoaderListenerInnerImpl.6
            @Override // com.tencent.thumbplayer.core.datatransport.util.TPListenerMgr.INotifyCallback
            public void onNotify(int i16, ITPDownloadProxyResourceLoaderListener iTPDownloadProxyResourceLoaderListener) {
                strArr[0] = iTPDownloadProxyResourceLoaderListener.getContentType(i3, str);
            }
        });
        return strArr[0];
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteDataTransportResourceLoaderListener
    public String getDataFilePath(final int i3, final String str) throws RemoteException {
        final String[] strArr = {""};
        this.mResourceLoaderListenerMgr.startNotify(i3, new TPListenerMgr.INotifyCallback<ITPDownloadProxyResourceLoaderListener>() { // from class: com.tencent.thumbplayer.core.datatransport.client.TPRemoteResourceLoaderListenerInnerImpl.5
            @Override // com.tencent.thumbplayer.core.datatransport.util.TPListenerMgr.INotifyCallback
            public void onNotify(int i16, ITPDownloadProxyResourceLoaderListener iTPDownloadProxyResourceLoaderListener) {
                strArr[0] = iTPDownloadProxyResourceLoaderListener.getDataFilePath(i3, str);
            }
        });
        return strArr[0];
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteDataTransportResourceLoaderListener
    public long getDataTotalSize(final int i3, final String str) throws RemoteException {
        final long[] jArr = {0};
        this.mResourceLoaderListenerMgr.startNotify(i3, new TPListenerMgr.INotifyCallback<ITPDownloadProxyResourceLoaderListener>() { // from class: com.tencent.thumbplayer.core.datatransport.client.TPRemoteResourceLoaderListenerInnerImpl.4
            @Override // com.tencent.thumbplayer.core.datatransport.util.TPListenerMgr.INotifyCallback
            public void onNotify(int i16, ITPDownloadProxyResourceLoaderListener iTPDownloadProxyResourceLoaderListener) {
                jArr[0] = iTPDownloadProxyResourceLoaderListener.getDataTotalSize(i3, str);
            }
        });
        return jArr[0];
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteDataTransportResourceLoaderListener
    public int onReadData(final int i3, final String str, final long j3, final long j16) throws RemoteException {
        final int[] iArr = {0};
        this.mResourceLoaderListenerMgr.startNotify(i3, new TPListenerMgr.INotifyCallback<ITPDownloadProxyResourceLoaderListener>() { // from class: com.tencent.thumbplayer.core.datatransport.client.TPRemoteResourceLoaderListenerInnerImpl.2
            @Override // com.tencent.thumbplayer.core.datatransport.util.TPListenerMgr.INotifyCallback
            public void onNotify(int i16, ITPDownloadProxyResourceLoaderListener iTPDownloadProxyResourceLoaderListener) {
                iArr[0] = iTPDownloadProxyResourceLoaderListener.onReadData(i3, str, j3, j16);
            }
        });
        return iArr[0];
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteDataTransportResourceLoaderListener
    public int onStartReadData(final int i3, final String str, final long j3, final long j16) throws RemoteException {
        final int[] iArr = {0};
        this.mResourceLoaderListenerMgr.startNotify(i3, new TPListenerMgr.INotifyCallback<ITPDownloadProxyResourceLoaderListener>() { // from class: com.tencent.thumbplayer.core.datatransport.client.TPRemoteResourceLoaderListenerInnerImpl.1
            @Override // com.tencent.thumbplayer.core.datatransport.util.TPListenerMgr.INotifyCallback
            public void onNotify(int i16, ITPDownloadProxyResourceLoaderListener iTPDownloadProxyResourceLoaderListener) {
                iArr[0] = iTPDownloadProxyResourceLoaderListener.onStartReadData(i3, str, j3, j16);
            }
        });
        return iArr[0];
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteDataTransportResourceLoaderListener
    public int onStopReadData(final int i3, final String str, final int i16) throws RemoteException {
        final int[] iArr = {0};
        this.mResourceLoaderListenerMgr.startNotify(i3, new TPListenerMgr.INotifyCallback<ITPDownloadProxyResourceLoaderListener>() { // from class: com.tencent.thumbplayer.core.datatransport.client.TPRemoteResourceLoaderListenerInnerImpl.3
            @Override // com.tencent.thumbplayer.core.datatransport.util.TPListenerMgr.INotifyCallback
            public void onNotify(int i17, ITPDownloadProxyResourceLoaderListener iTPDownloadProxyResourceLoaderListener) {
                iArr[0] = iTPDownloadProxyResourceLoaderListener.onStopReadData(i3, str, i16);
            }
        });
        return iArr[0];
    }

    public void removeResourceLoaderListener(int i3) {
        this.mResourceLoaderListenerMgr.removeTaskListener(i3);
    }

    @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteDataTransportResourceLoaderListener.Stub, android.os.IInterface
    public IBinder asBinder() {
        return this;
    }
}
