package com.tencent.thumbplayer.core.datatransport.resourceloader;

import android.os.HandlerThread;
import androidx.annotation.NonNull;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thumbplayer.core.datatransport.apiinner.TPDataTransportFactory;
import com.tencent.thumbplayer.core.datatransport.resourceloader.TPResourceLoaderRequestFileLinker;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes26.dex */
public class TPDownloadProxyResourceLoaderAdapter implements ITPDownloadProxyResourceLoaderListener {
    private static final String TAG = "TPResourceLoader";
    private static final String WRITE_DATA_THREAD_NAME = "TPResourceLoader-DataWrite";
    private HandlerThread mWriteDataThread;
    private final HashMap<Integer, ResourceLoaderLinker> mResourceLoaderLinkers = new HashMap<>();
    private final AtomicInteger mBaseRequestNum = new AtomicInteger(0);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class StartReadDataParams {
        private int mFileId;
        private long mRequestEnd;
        private int mRequestNum;
        private long mRequestStart;
        private String mUri;

        StartReadDataParams() {
        }

        public String toString() {
            return "StartReadDataParams{mRequestNum=" + this.mRequestNum + ", mFileId=" + this.mFileId + ", mUri=" + this.mUri + ", mRequestStart=" + this.mRequestStart + ", mRequestEnd=" + this.mRequestEnd + '}';
        }
    }

    public TPDownloadProxyResourceLoaderAdapter() {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread(WRITE_DATA_THREAD_NAME);
        this.mWriteDataThread = baseHandlerThread;
        baseHandlerThread.start();
    }

    private boolean IsInvalidResourceLoader(ResourceLoaderLinker resourceLoaderLinker) {
        if (resourceLoaderLinker != null && !resourceLoaderLinker.IsInvalidResourceLoader()) {
            return false;
        }
        return true;
    }

    private boolean IsValidMediaContentInfo(TPDataTransportResourceLoaderMediaContentInfo tPDataTransportResourceLoaderMediaContentInfo) {
        if (tPDataTransportResourceLoaderMediaContentInfo != null && tPDataTransportResourceLoaderMediaContentInfo.getResponseCode() == 0) {
            return true;
        }
        return false;
    }

    private TPResourceLoaderRequestFileLinker createRequestLinker(StartReadDataParams startReadDataParams) {
        long j3;
        if (startReadDataParams.mRequestEnd < 0) {
            j3 = -1;
        } else {
            j3 = startReadDataParams.mRequestEnd - startReadDataParams.mRequestStart;
        }
        return new TPResourceLoaderRequestFileLinker(TPDataTransportFactory.getInstance().getContext(), new TPResourceLoaderRequestFileLinker.RequestParams.Builder(startReadDataParams.mRequestNum, startReadDataParams.mUri).setFileId(startReadDataParams.mFileId).setRequestStartOffset(startReadDataParams.mRequestStart).setRequestLength(j3).build(), this.mWriteDataThread.getLooper());
    }

    public void addResourceLoaderListener(int i3, ITPDataTransportResourceLoaderListener iTPDataTransportResourceLoaderListener) {
        ResourceLoaderLinker resourceLoaderLinker = this.mResourceLoaderLinkers.get(Integer.valueOf(i3));
        if (!IsInvalidResourceLoader(resourceLoaderLinker)) {
            resourceLoaderLinker.close();
        }
        this.mResourceLoaderLinkers.put(Integer.valueOf(i3), new ResourceLoaderLinker(i3, iTPDataTransportResourceLoaderListener));
    }

    @Override // com.tencent.thumbplayer.core.datatransport.resourceloader.ITPDownloadProxyResourceLoaderListener
    public String getContentType(int i3, String str) {
        ResourceLoaderLinker resourceLoaderLinker = this.mResourceLoaderLinkers.get(Integer.valueOf(i3));
        if (IsInvalidResourceLoader(resourceLoaderLinker)) {
            TPDLProxyLog.e(TAG, 0, ITPDLProxyLogListener.COMMON_TAG, "getContentType, resource loader is null");
            return "";
        }
        if (IsValidMediaContentInfo(resourceLoaderLinker.getMediaContentInfo())) {
            return resourceLoaderLinker.getMediaContentInfo().getContentType();
        }
        TPDataTransportResourceLoaderMediaContentInfo readMediaContentInfo = resourceLoaderLinker.readMediaContentInfo(i3, str);
        if (IsValidMediaContentInfo(readMediaContentInfo)) {
            resourceLoaderLinker.setMediaContentInfo(readMediaContentInfo);
            return readMediaContentInfo.getContentType();
        }
        TPDLProxyLog.e(TAG, 0, ITPDLProxyLogListener.COMMON_TAG, "getContentType, readMediaContentInfo is invalid.");
        return "";
    }

    @Override // com.tencent.thumbplayer.core.datatransport.resourceloader.ITPDownloadProxyResourceLoaderListener
    public String getDataFilePath(int i3, String str) {
        TPResourceLoaderRequestFileLinker fileLinker = this.mResourceLoaderLinkers.get(Integer.valueOf(i3)).getFileLinker();
        if (fileLinker == null) {
            TPDLProxyLog.e(TAG, 0, ITPDLProxyLogListener.COMMON_TAG, "getDataFilePath, fileLinker is null");
            return "";
        }
        return fileLinker.getDataFilePath(TPDataTransportFactory.getInstance().getContext());
    }

    @Override // com.tencent.thumbplayer.core.datatransport.resourceloader.ITPDownloadProxyResourceLoaderListener
    public long getDataTotalSize(int i3, String str) {
        ResourceLoaderLinker resourceLoaderLinker = this.mResourceLoaderLinkers.get(Integer.valueOf(i3));
        if (IsInvalidResourceLoader(resourceLoaderLinker)) {
            TPDLProxyLog.e(TAG, 0, ITPDLProxyLogListener.COMMON_TAG, "getDataTotalSize, resource loader is null");
            return 0L;
        }
        TPDataTransportResourceLoaderMediaContentInfo mediaContentInfo = resourceLoaderLinker.getMediaContentInfo();
        if (IsValidMediaContentInfo(mediaContentInfo)) {
            return mediaContentInfo.getContentLength();
        }
        TPDataTransportResourceLoaderMediaContentInfo readMediaContentInfo = resourceLoaderLinker.readMediaContentInfo(i3, str);
        if (IsValidMediaContentInfo(readMediaContentInfo)) {
            resourceLoaderLinker.setMediaContentInfo(readMediaContentInfo);
            return readMediaContentInfo.getContentLength();
        }
        TPDLProxyLog.e(TAG, 0, ITPDLProxyLogListener.COMMON_TAG, "getDataTotalSize, readMediaContentInfo is invalid.");
        return 0L;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.resourceloader.ITPDownloadProxyResourceLoaderListener
    public int onReadData(int i3, String str, long j3, long j16) {
        ResourceLoaderLinker resourceLoaderLinker = this.mResourceLoaderLinkers.get(Integer.valueOf(i3));
        if (IsInvalidResourceLoader(resourceLoaderLinker)) {
            TPDLProxyLog.e(TAG, 0, ITPDLProxyLogListener.COMMON_TAG, "onReadData, resourceLoaderLinker invalid");
            return -1;
        }
        TPDataTransportResourceLoaderData readData = resourceLoaderLinker.readData(i3, str, j16);
        if (readData != null && readData.getResponseCode() == 0 && readData.getData().length > 0) {
            resourceLoaderLinker.getFileLinker().respond(readData.getData());
        }
        int dataReadyLength = resourceLoaderLinker.getFileLinker().getDataReadyLength(j3, j16);
        TPDLProxyLog.d(TAG, 0, ITPDLProxyLogListener.COMMON_TAG, "onReadData, id: " + i3 + ", dataReadyLength:" + dataReadyLength);
        if (dataReadyLength <= 0) {
            return -1;
        }
        return dataReadyLength;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.resourceloader.ITPDownloadProxyResourceLoaderListener
    public int onStartReadData(int i3, String str, long j3, long j16) {
        ResourceLoaderLinker resourceLoaderLinker = this.mResourceLoaderLinkers.get(Integer.valueOf(i3));
        if (IsInvalidResourceLoader(resourceLoaderLinker)) {
            TPDLProxyLog.e(TAG, 0, ITPDLProxyLogListener.COMMON_TAG, "onStartReadData, resourceLoaderLinker invalid");
            return -1;
        }
        int incrementAndGet = this.mBaseRequestNum.incrementAndGet();
        StartReadDataParams startReadDataParams = new StartReadDataParams();
        startReadDataParams.mRequestStart = j3;
        startReadDataParams.mRequestEnd = j16;
        startReadDataParams.mFileId = i3;
        startReadDataParams.mUri = str;
        startReadDataParams.mRequestNum = incrementAndGet;
        if (!resourceLoaderLinker.open(i3, str)) {
            return -1;
        }
        TPResourceLoaderRequestFileLinker fileLinker = resourceLoaderLinker.getFileLinker();
        if (fileLinker != null) {
            TPDLProxyLog.d(TAG, 0, ITPDLProxyLogListener.COMMON_TAG, "onStartReadData, switch seek, start:" + j3 + ", end:" + j16);
            fileLinker.stop();
        }
        resourceLoaderLinker.seekData(i3, str, j3);
        resourceLoaderLinker.setFileLinker(createRequestLinker(startReadDataParams));
        return incrementAndGet;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.resourceloader.ITPDownloadProxyResourceLoaderListener
    public int onStopReadData(int i3, String str, int i16) {
        return 0;
    }

    public void removeResourceLoaderListener(int i3) {
        ResourceLoaderLinker resourceLoaderLinker = this.mResourceLoaderLinkers.get(Integer.valueOf(i3));
        if (!IsInvalidResourceLoader(resourceLoaderLinker)) {
            resourceLoaderLinker.close();
            this.mResourceLoaderLinkers.remove(Integer.valueOf(i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class ResourceLoaderLinker implements ITPDataTransportResourceLoaderListener {
        private final int mFileId;
        private TPResourceLoaderRequestFileLinker mFileLinker;
        private boolean mIsConnected = false;
        private TPDataTransportResourceLoaderMediaContentInfo mMediaContentInfo;
        private final ITPDataTransportResourceLoaderListener mResourceLoader;
        private String mUri;

        ResourceLoaderLinker(int i3, ITPDataTransportResourceLoaderListener iTPDataTransportResourceLoaderListener) {
            this.mFileId = i3;
            this.mResourceLoader = iTPDataTransportResourceLoaderListener;
        }

        public boolean IsInvalidFileLinker() {
            if (this.mFileLinker == null) {
                return true;
            }
            return false;
        }

        public boolean IsInvalidResourceLoader() {
            if (this.mResourceLoader == null) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.resourceloader.ITPDataTransportResourceLoaderListener
        public void close(int i3, @NonNull String str) {
            this.mIsConnected = false;
            if (!IsInvalidFileLinker()) {
                this.mFileLinker.stop();
            }
            if (IsInvalidResourceLoader()) {
                return;
            }
            this.mResourceLoader.close(i3, str);
        }

        int getFileId() {
            return this.mFileId;
        }

        TPResourceLoaderRequestFileLinker getFileLinker() {
            return this.mFileLinker;
        }

        public TPDataTransportResourceLoaderMediaContentInfo getMediaContentInfo() {
            return this.mMediaContentInfo;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.resourceloader.ITPDataTransportResourceLoaderListener
        public boolean open(int i3, @NonNull String str) {
            this.mUri = str;
            if (!this.mIsConnected && this.mResourceLoader.open(i3, str)) {
                this.mIsConnected = true;
            }
            return this.mIsConnected;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.resourceloader.ITPDataTransportResourceLoaderListener
        public TPDataTransportResourceLoaderData readData(int i3, @NonNull String str, long j3) {
            return this.mResourceLoader.readData(i3, str, j3);
        }

        @Override // com.tencent.thumbplayer.core.datatransport.resourceloader.ITPDataTransportResourceLoaderListener
        public TPDataTransportResourceLoaderMediaContentInfo readMediaContentInfo(int i3, @NonNull String str) {
            TPDataTransportResourceLoaderMediaContentInfo readMediaContentInfo = this.mResourceLoader.readMediaContentInfo(i3, str);
            this.mMediaContentInfo = readMediaContentInfo;
            return readMediaContentInfo;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.resourceloader.ITPDataTransportResourceLoaderListener
        public int seekData(int i3, @NonNull String str, long j3) {
            return this.mResourceLoader.seekData(i3, str, j3);
        }

        void setFileLinker(TPResourceLoaderRequestFileLinker tPResourceLoaderRequestFileLinker) {
            this.mFileLinker = tPResourceLoaderRequestFileLinker;
        }

        public void setMediaContentInfo(TPDataTransportResourceLoaderMediaContentInfo tPDataTransportResourceLoaderMediaContentInfo) {
            this.mMediaContentInfo = tPDataTransportResourceLoaderMediaContentInfo;
        }

        @NonNull
        public String toString() {
            return "ResourceLoaderLinker{mIsConnected=" + this.mIsConnected + "mFileId=" + this.mFileId + "mUri=" + this.mUri + '}';
        }

        public void close() {
            close(this.mFileId, this.mUri);
        }
    }
}
