package com.tencent.component.network.downloader.impl.ipc;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.impl.ipc.Const;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DownloadSerice extends Service {
    private static final String TAG = "DownloadSerice";
    private final Messenger mMessenger = new Messenger(new ClientHandler());

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class ClientHandler extends Handler {
        ClientHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.i(DownloadSerice.TAG, "on msg:" + message.what);
            try {
                int i3 = message.what;
                if (i3 != 101) {
                    if (i3 != 102) {
                        if (i3 != 107) {
                            super.handleMessage(message);
                        } else if (message.getData() != null) {
                            Bundle data = message.getData();
                            data.setClassLoader(DownloadSerice.this.getClassLoader());
                            DownloadSerice.this.cleanCache((Const.SimpleRequest) data.get(Const.BUNDLE_KEY_REQUEST), message.replyTo);
                        }
                    } else if (message.getData() != null) {
                        Bundle data2 = message.getData();
                        data2.setClassLoader(DownloadSerice.this.getClassLoader());
                        DownloadSerice.this.cancel((Const.SimpleRequest) data2.get(Const.BUNDLE_KEY_REQUEST), message.replyTo);
                    }
                } else if (message.getData() != null) {
                    Bundle data3 = message.getData();
                    data3.setClassLoader(DownloadSerice.this.getClassLoader());
                    DownloadSerice.this.download((Const.SimpleRequest) data3.get(Const.BUNDLE_KEY_REQUEST), message.replyTo);
                }
            } catch (Throwable th5) {
                Log.e(DownloadSerice.TAG, "", th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel(Const.SimpleRequest simpleRequest, Messenger messenger) {
        if (simpleRequest != null && messenger != null) {
            Log.i(TAG, "cancel request from DownloadClient:" + simpleRequest.toString());
            try {
                messenger.send(Const.obtainDownloadCanceledMsg(simpleRequest.url));
            } catch (RemoteException e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanCache(Const.SimpleRequest simpleRequest, Messenger messenger) {
        if (simpleRequest != null && messenger != null) {
            Log.i(TAG, "clean cache." + simpleRequest.toString());
            int i3 = simpleRequest.content_type;
            Downloader imageDownloader = DownloaderFactory.getInstance(this).getImageDownloader();
            if (i3 == 2) {
                imageDownloader = DownloaderFactory.getInstance(this).getCommonDownloader();
            }
            if ("".equals(simpleRequest.url)) {
                imageDownloader.cleanCache();
            } else {
                imageDownloader.cleanCache(simpleRequest.url);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void download(Const.SimpleRequest simpleRequest, final Messenger messenger) {
        if (simpleRequest != null && messenger != null) {
            Log.i(TAG, "download request from DownloadClient:" + simpleRequest.toString());
            int i3 = simpleRequest.content_type;
            Downloader imageDownloader = DownloaderFactory.getInstance(this).getImageDownloader();
            if (i3 == 2) {
                imageDownloader = DownloaderFactory.getInstance(this).getCommonDownloader();
            }
            imageDownloader.download(simpleRequest.url, simpleRequest.getPaths(), true, new Downloader.DownloadListener() { // from class: com.tencent.component.network.downloader.impl.ipc.DownloadSerice.1
                @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
                public void onDownloadCanceled(String str) {
                    try {
                        messenger.send(Const.obtainDownloadCanceledMsg(str));
                    } catch (RemoteException e16) {
                        e16.printStackTrace();
                    }
                }

                @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
                public void onDownloadFailed(String str, DownloadResult downloadResult) {
                    try {
                        messenger.send(Const.obtainDownloadFailedMsg(str, downloadResult));
                    } catch (RemoteException e16) {
                        e16.printStackTrace();
                    }
                }

                @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
                public void onDownloadProgress(String str, long j3, float f16) {
                    try {
                        messenger.send(Const.obtainDownloadProgressMsg(str, j3, f16));
                    } catch (RemoteException e16) {
                        e16.printStackTrace();
                    }
                }

                @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
                public void onDownloadSucceed(String str, DownloadResult downloadResult) {
                    try {
                        messenger.send(Const.obtainDownloadSucceedMsg(str, downloadResult));
                    } catch (RemoteException e16) {
                        e16.printStackTrace();
                    }
                }
            });
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Log.w(TAG, "Download Service Binded");
        return this.mMessenger.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        Log.e(TAG, "start onCreate~~~");
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        Log.e(TAG, "start onDestroy~~~");
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i3) {
        Log.e(TAG, "start onStart~~~");
        super.onStart(intent, i3);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        Log.e(TAG, "start onUnbind~~~");
        return super.onUnbind(intent);
    }
}
