package com.tencent.thumbplayer.core.datatransport.service;

import com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteDataTransportResourceLoaderListener;
import com.tencent.thumbplayer.core.datatransport.resourceloader.ITPDownloadProxyResourceLoaderListener;
import com.tencent.thumbplayer.core.datatransport.util.ITPDataTransportLog;
import com.tencent.thumbplayer.core.datatransport.util.TPDataTransportLogFactory;

/* loaded from: classes26.dex */
public class TPResourceLoaderListenerInnerImpl implements ITPDownloadProxyResourceLoaderListener {
    private final ITPDataTransportLog mLogger = TPDataTransportLogFactory.getInstance().getLogger("TPResourceLoaderListenerInnerImpl");
    private ITPRemoteDataTransportResourceLoaderListener mRemoteTaskListener;

    public TPResourceLoaderListenerInnerImpl(ITPRemoteDataTransportResourceLoaderListener iTPRemoteDataTransportResourceLoaderListener) {
        this.mRemoteTaskListener = iTPRemoteDataTransportResourceLoaderListener;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.resourceloader.ITPDownloadProxyResourceLoaderListener
    public String getContentType(int i3, String str) {
        ITPRemoteDataTransportResourceLoaderListener iTPRemoteDataTransportResourceLoaderListener = this.mRemoteTaskListener;
        if (iTPRemoteDataTransportResourceLoaderListener == null) {
            this.mLogger.e("getContentType remote requestId listener is null!");
            return "";
        }
        try {
            return iTPRemoteDataTransportResourceLoaderListener.getContentType(i3, str);
        } catch (Throwable th5) {
            this.mLogger.e("getContentType failed, fileId:" + i3 + ", error:" + th5);
            return "";
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.resourceloader.ITPDownloadProxyResourceLoaderListener
    public String getDataFilePath(int i3, String str) {
        ITPRemoteDataTransportResourceLoaderListener iTPRemoteDataTransportResourceLoaderListener = this.mRemoteTaskListener;
        if (iTPRemoteDataTransportResourceLoaderListener == null) {
            this.mLogger.e("getDataFilePath remote requestId listener is null!");
            return "";
        }
        try {
            return iTPRemoteDataTransportResourceLoaderListener.getDataFilePath(i3, str);
        } catch (Throwable th5) {
            this.mLogger.e("getDataFilePath failed, fileId:" + i3 + ", error:" + th5);
            return "";
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.resourceloader.ITPDownloadProxyResourceLoaderListener
    public long getDataTotalSize(int i3, String str) {
        ITPRemoteDataTransportResourceLoaderListener iTPRemoteDataTransportResourceLoaderListener = this.mRemoteTaskListener;
        if (iTPRemoteDataTransportResourceLoaderListener == null) {
            this.mLogger.e("getDataTotalSize remote requestId listener is null!");
            return -1L;
        }
        try {
            return iTPRemoteDataTransportResourceLoaderListener.getDataTotalSize(i3, str);
        } catch (Throwable th5) {
            this.mLogger.e("getDataTotalSize failed, fileId:" + i3 + ", error:" + th5);
            return -1L;
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.resourceloader.ITPDownloadProxyResourceLoaderListener
    public int onReadData(int i3, String str, long j3, long j16) {
        ITPRemoteDataTransportResourceLoaderListener iTPRemoteDataTransportResourceLoaderListener = this.mRemoteTaskListener;
        if (iTPRemoteDataTransportResourceLoaderListener == null) {
            this.mLogger.e("onReadData remote requestId listener is null!");
            return -1;
        }
        try {
            return iTPRemoteDataTransportResourceLoaderListener.onReadData(i3, str, j3, j16);
        } catch (Throwable th5) {
            this.mLogger.e("onReadData failed, fileId:" + i3 + ", error:" + th5);
            return -1;
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.resourceloader.ITPDownloadProxyResourceLoaderListener
    public int onStartReadData(int i3, String str, long j3, long j16) {
        ITPRemoteDataTransportResourceLoaderListener iTPRemoteDataTransportResourceLoaderListener = this.mRemoteTaskListener;
        if (iTPRemoteDataTransportResourceLoaderListener == null) {
            this.mLogger.e("onStartReadData remote requestId listener is null!");
            return -1;
        }
        try {
            return iTPRemoteDataTransportResourceLoaderListener.onStartReadData(i3, str, j3, j16);
        } catch (Throwable th5) {
            this.mLogger.e("onStartReadData failed, fileId:" + i3 + ", error:" + th5);
            return -1;
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.resourceloader.ITPDownloadProxyResourceLoaderListener
    public int onStopReadData(int i3, String str, int i16) {
        ITPRemoteDataTransportResourceLoaderListener iTPRemoteDataTransportResourceLoaderListener = this.mRemoteTaskListener;
        if (iTPRemoteDataTransportResourceLoaderListener == null) {
            this.mLogger.e("onStopReadData remote requestId listener is null!");
            return -1;
        }
        try {
            return iTPRemoteDataTransportResourceLoaderListener.onStopReadData(i3, str, i16);
        } catch (Throwable th5) {
            this.mLogger.e("onStopReadData failed, fileId:" + i3 + ", error:" + th5);
            return -1;
        }
    }
}
