package com.tencent.component.network.downloader.impl.ipc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import com.tencent.component.network.downloader.DownloadRequest;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.utils.MultiHashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes5.dex */
public class DownloaderProxy extends Downloader {
    private static final String TAG = "RemoteDownloader";
    private Messenger mClientMessenger;
    private ServiceConnection mConnection;
    private DownloadHandler mHandler;
    private final MultiHashMap<String, Const.SimpleRequest> mPendingRequests;
    private Messenger mServiceMessenger;
    private int mType;
    private final List<Const.SimpleRequest> mWaitingRequest;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class DownloadHandler extends Handler {
        public DownloadHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ArrayList arrayList = new ArrayList();
            Log.i(DownloaderProxy.TAG, "on message:" + message.what);
            try {
                switch (message.what) {
                    case 103:
                        if (message.getData() != null) {
                            Bundle data = message.getData();
                            data.setClassLoader(((Downloader) DownloaderProxy.this).mContext.getClassLoader());
                            DownloadResult downloadResult = (DownloadResult) data.getParcelable("result");
                            DownloaderProxy.this.collectPendingRequest(downloadResult.getUrl(), true, arrayList);
                            DownloaderProxy.this.notifyDownloadSucceed(arrayList, downloadResult);
                            break;
                        }
                        break;
                    case 104:
                        if (message.getData() != null) {
                            Bundle data2 = message.getData();
                            data2.setClassLoader(((Downloader) DownloaderProxy.this).mContext.getClassLoader());
                            DownloadResult downloadResult2 = (DownloadResult) data2.getParcelable("result");
                            DownloaderProxy.this.collectPendingRequest(downloadResult2.getUrl(), true, arrayList);
                            DownloaderProxy.this.notifyDownloadFailed(arrayList, downloadResult2);
                            break;
                        }
                        break;
                    case 105:
                        if (message.getData() != null) {
                            DownloaderProxy.this.collectPendingRequest(message.getData().getString("url"), true, arrayList);
                            DownloaderProxy.this.notifyDownloadCanceled(arrayList);
                            break;
                        }
                        break;
                    case 106:
                        if (message.getData() != null) {
                            String string = message.getData().getString("url");
                            long j3 = message.arg1;
                            float f16 = message.arg2;
                            DownloaderProxy.this.collectPendingRequest(string, false, arrayList);
                            DownloaderProxy.this.notifyDownloadProgress(arrayList, j3, f16);
                            break;
                        }
                        break;
                    default:
                        super.handleMessage(message);
                        break;
                }
            } catch (Throwable th5) {
                Log.e(DownloaderProxy.TAG, "", th5);
            }
        }
    }

    public DownloaderProxy(Context context, String str, int i3) {
        super(context, str);
        this.mType = 2;
        this.mPendingRequests = new MultiHashMap<>();
        this.mWaitingRequest = new ArrayList();
        this.mConnection = new ServiceConnection() { // from class: com.tencent.component.network.downloader.impl.ipc.DownloaderProxy.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                DownloaderProxy.this.mServiceMessenger = new Messenger(iBinder);
                synchronized (DownloaderProxy.this.mWaitingRequest) {
                    for (Const.SimpleRequest simpleRequest : DownloaderProxy.this.mWaitingRequest) {
                        DownloaderProxy.this.download(simpleRequest.url, simpleRequest.getPaths(), true, simpleRequest.listener, simpleRequest.mode);
                    }
                    DownloaderProxy.this.mWaitingRequest.clear();
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                DownloaderProxy.this.mServiceMessenger = null;
            }
        };
        this.mType = i3;
        init();
    }

    private boolean addPendingRequest(String str, String str2, Const.SimpleRequest simpleRequest) {
        boolean z16 = false;
        if (simpleRequest == null) {
            return false;
        }
        synchronized (this.mPendingRequests) {
            int sizeOf = this.mPendingRequests.sizeOf(str2);
            this.mPendingRequests.add(str2, simpleRequest);
            if (sizeOf == 0) {
                z16 = true;
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Collection<Const.SimpleRequest> collectPendingRequest(String str, boolean z16, Collection<Const.SimpleRequest> collection) {
        Object obj;
        synchronized (this.mPendingRequests) {
            if (z16) {
                obj = this.mPendingRequests.remove(str);
            } else {
                obj = this.mPendingRequests.get(str);
            }
            HashSet hashSet = (HashSet) obj;
            if (collection != null) {
                collection.clear();
                if (hashSet != null) {
                    collection.addAll(hashSet);
                }
                return collection;
            }
            return hashSet;
        }
    }

    private void doRequestDownload(String str, String[] strArr, Downloader.DownloadMode downloadMode) {
        Message obtainDownloadRequestMsg = Const.obtainDownloadRequestMsg(str, strArr, this.mType, downloadMode, this.mClientMessenger);
        try {
            Messenger messenger = this.mServiceMessenger;
            if (messenger != null) {
                messenger.send(obtainDownloadRequestMsg);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    private void init() {
        this.mHandler = new DownloadHandler(Looper.getMainLooper());
        this.mClientMessenger = new Messenger(this.mHandler);
        startService();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDownloadCanceled(Collection<Const.SimpleRequest> collection) {
        Downloader.DownloadListener downloadListener;
        if (collection == null) {
            return;
        }
        for (Const.SimpleRequest simpleRequest : collection) {
            if (simpleRequest != null && (downloadListener = simpleRequest.listener) != null) {
                downloadListener.onDownloadCanceled(simpleRequest.url);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDownloadFailed(Collection<Const.SimpleRequest> collection, DownloadResult downloadResult) {
        Downloader.DownloadListener downloadListener;
        if (collection == null) {
            return;
        }
        for (Const.SimpleRequest simpleRequest : collection) {
            if (simpleRequest != null && (downloadListener = simpleRequest.listener) != null) {
                downloadListener.onDownloadFailed(simpleRequest.url, downloadResult);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDownloadProgress(Collection<Const.SimpleRequest> collection, long j3, float f16) {
        Downloader.DownloadListener downloadListener;
        if (collection == null) {
            return;
        }
        for (Const.SimpleRequest simpleRequest : collection) {
            if (simpleRequest != null && (downloadListener = simpleRequest.listener) != null) {
                downloadListener.onDownloadProgress(simpleRequest.url, j3, f16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDownloadSucceed(Collection<Const.SimpleRequest> collection, DownloadResult downloadResult) {
        Downloader.DownloadListener downloadListener;
        if (collection == null) {
            return;
        }
        for (Const.SimpleRequest simpleRequest : collection) {
            if (simpleRequest != null && (downloadListener = simpleRequest.listener) != null) {
                downloadListener.onDownloadSucceed(simpleRequest.url, downloadResult);
            }
        }
    }

    private boolean removePendingRequest(String str, Const.SimpleRequest simpleRequest, Collection<Const.SimpleRequest> collection) {
        boolean z16 = false;
        if (simpleRequest == null) {
            return false;
        }
        synchronized (this.mPendingRequests) {
            int sizeOf = this.mPendingRequests.sizeOf(str);
            if (collection != null) {
                collection.clear();
            }
            if (this.mPendingRequests.removeItem(str, simpleRequest) && collection != null) {
                collection.add(simpleRequest);
            }
            if (sizeOf > 0 && this.mPendingRequests.sizeOf(str) == 0) {
                z16 = true;
            }
        }
        return z16;
    }

    private void startService() {
        if (this.mServiceMessenger == null) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(this.mContext, "com.tencent.component.network.downloader.impl.ipc.DownloadSerice"));
            try {
                this.mContext.bindService(intent, this.mConnection, 1);
            } catch (Throwable th5) {
                QDLog.e(TAG, "exception when bind download service!!!", th5);
            }
        }
    }

    @Override // com.tencent.component.network.downloader.Downloader
    public void abort(String str, Downloader.DownloadListener downloadListener) {
        if (!Utils.checkUrl(str)) {
            return;
        }
        Const.SimpleRequest simpleRequest = new Const.SimpleRequest();
        simpleRequest.url = str;
        simpleRequest.listener = downloadListener;
        ArrayList arrayList = new ArrayList();
        if (removePendingRequest(str, simpleRequest, arrayList)) {
            Message obtainDownloadCancelMsg = Const.obtainDownloadCancelMsg(str, this.mType, this.mClientMessenger);
            Messenger messenger = this.mServiceMessenger;
            if (messenger != null) {
                try {
                    messenger.send(obtainDownloadCancelMsg);
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        }
        notifyDownloadCanceled(arrayList);
    }

    @Override // com.tencent.component.network.downloader.Downloader
    public void cancel(String str, Downloader.DownloadListener downloadListener) {
        if (!Utils.checkUrl(str)) {
            return;
        }
        Const.SimpleRequest simpleRequest = new Const.SimpleRequest();
        simpleRequest.url = str;
        simpleRequest.listener = downloadListener;
        ArrayList arrayList = new ArrayList();
        if (removePendingRequest(str, simpleRequest, arrayList)) {
            Message obtainDownloadCancelMsg = Const.obtainDownloadCancelMsg(str, this.mType, this.mClientMessenger);
            Messenger messenger = this.mServiceMessenger;
            if (messenger != null) {
                try {
                    messenger.send(obtainDownloadCancelMsg);
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        }
        notifyDownloadCanceled(arrayList);
    }

    @Override // com.tencent.component.network.downloader.Downloader
    public void cleanCache(String str) {
        if (Utils.checkUrl(str)) {
            Message obtainCleanCacheMsg = Const.obtainCleanCacheMsg(str, this.mType, this.mClientMessenger);
            Messenger messenger = this.mServiceMessenger;
            if (messenger != null) {
                try {
                    messenger.send(obtainCleanCacheMsg);
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        }
    }

    @Override // com.tencent.component.network.downloader.Downloader
    public boolean download(DownloadRequest downloadRequest, boolean z16) {
        String url = downloadRequest.getUrl();
        String[] paths = downloadRequest.getPaths();
        if (!Utils.checkUrl(url) || paths == null) {
            return false;
        }
        Const.SimpleRequest simpleRequest = new Const.SimpleRequest();
        simpleRequest.url = url;
        for (String str : paths) {
            simpleRequest.addDstPath(str);
        }
        simpleRequest.listener = downloadRequest.getListener();
        simpleRequest.mode = downloadRequest.mode;
        if (this.mServiceMessenger == null) {
            synchronized (this.mWaitingRequest) {
                this.mWaitingRequest.add(simpleRequest);
            }
            startService();
            return true;
        }
        if (addPendingRequest(url, url, simpleRequest)) {
            doRequestDownload(url, paths, downloadRequest.mode);
        }
        return true;
    }

    public void uninit() {
        ServiceConnection serviceConnection;
        if (this.mServiceMessenger != null && (serviceConnection = this.mConnection) != null) {
            this.mContext.unbindService(serviceConnection);
        }
    }

    @Override // com.tencent.component.network.downloader.Downloader
    public void cleanCache() {
        Message obtainCleanCacheMsg = Const.obtainCleanCacheMsg("", this.mType, this.mClientMessenger);
        Messenger messenger = this.mServiceMessenger;
        if (messenger != null) {
            try {
                messenger.send(obtainCleanCacheMsg);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    @Override // com.tencent.component.network.downloader.Downloader
    public void cancelAll() {
    }

    @Override // com.tencent.component.network.downloader.Downloader
    public void preConnectHost(ArrayList<String> arrayList, String str) {
    }
}
