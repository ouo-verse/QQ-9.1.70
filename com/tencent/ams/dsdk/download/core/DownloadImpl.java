package com.tencent.ams.dsdk.download.core;

import android.text.TextUtils;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.dsdk.download.Download;
import com.tencent.ams.dsdk.download.DownloadItem;
import com.tencent.ams.dsdk.download.DownloadRequest;
import com.tencent.ams.dsdk.download.DownloadTask;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.dsdk.utils.WorkThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DownloadImpl implements Download {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DownloadImpl";
    private final List<Download.Callback> mCallbackList;
    private volatile DownloadTask mDownloadTask;
    private volatile boolean mIsCancelled;
    private volatile boolean mIsStarted;
    private DownloadRequest mRequest;
    private final Object mStateLock;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private class InnerDownloadCallback implements DownloadTask.OnDownloadListener {
        static IPatchRedirector $redirector_;

        InnerDownloadCallback() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) DownloadImpl.this);
        }

        @Override // com.tencent.ams.dsdk.download.DownloadTask.OnDownloadListener
        public void onCancelled() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                DownloadImpl.this.notifyCancelled();
            } else {
                iPatchRedirector.redirect((short) 4, (Object) this);
            }
        }

        @Override // com.tencent.ams.dsdk.download.DownloadTask.OnDownloadListener
        public void onDownloadComplete() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                DownloadImpl.this.notifyCompleted();
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.ams.dsdk.download.DownloadTask.OnDownloadListener
        public void onDownloadFailed(Exception exc) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                DownloadImpl.this.notifyFailed(exc);
            } else {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) exc);
            }
        }

        @Override // com.tencent.ams.dsdk.download.DownloadTask.OnDownloadListener
        public void onDownloadProgress(long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                DownloadImpl.this.notifyProgress(j3, j16);
            } else {
                iPatchRedirector.redirect((short) 5, this, Long.valueOf(j3), Long.valueOf(j16));
            }
        }

        @Override // com.tencent.ams.dsdk.download.DownloadTask.OnDownloadListener
        public void onDownloadStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                DownloadImpl.this.notifyStarted();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        /* synthetic */ InnerDownloadCallback(DownloadImpl downloadImpl, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                return;
            }
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) downloadImpl, (Object) anonymousClass1);
        }
    }

    public DownloadImpl(DownloadRequest downloadRequest) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) downloadRequest);
            return;
        }
        this.mRequest = null;
        this.mDownloadTask = null;
        this.mIsCancelled = false;
        this.mCallbackList = new CopyOnWriteArrayList();
        this.mStateLock = new Object();
        this.mIsStarted = false;
        this.mRequest = downloadRequest;
    }

    private DownloadItem getDownloadItem() {
        DownloadItem downloadItem = new DownloadItem(this.mRequest.getUrl(), this.mRequest.getFileMd5(), 0L, 0L, this.mRequest.getFolder(), this.mRequest.getName());
        DownloadItem query = downloadItem.query();
        if (query != null) {
            if (!TextUtils.isEmpty(downloadItem.url) && !downloadItem.url.equals(query.url)) {
                query.url = downloadItem.url;
                query.update();
            }
            return query;
        }
        return downloadItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyCancelled() {
        synchronized (this.mStateLock) {
            for (Download.Callback callback : this.mCallbackList) {
                if (callback != null) {
                    callback.onCancelled();
                }
            }
            this.mCallbackList.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyCompleted() {
        synchronized (this.mStateLock) {
            for (Download.Callback callback : this.mCallbackList) {
                if (callback != null) {
                    callback.onDownloadComplete();
                }
            }
            this.mCallbackList.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyFailed(Exception exc) {
        synchronized (this.mStateLock) {
            for (Download.Callback callback : this.mCallbackList) {
                if (callback != null) {
                    callback.onDownloadFailed(exc);
                }
            }
            this.mCallbackList.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyProgress(long j3, long j16) {
        synchronized (this.mStateLock) {
            for (Download.Callback callback : this.mCallbackList) {
                if (callback != null) {
                    callback.onDownloadProgress(j3, j16);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyStarted() {
        synchronized (this.mStateLock) {
            this.mIsStarted = true;
            for (Download.Callback callback : this.mCallbackList) {
                if (callback != null) {
                    callback.onDownloadStart();
                }
            }
        }
    }

    @Override // com.tencent.ams.dsdk.download.Download
    public synchronized boolean cancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        DLog.d(TAG, "cancel, download: " + this + ", task: " + this.mDownloadTask);
        if (this.mIsCancelled) {
            return false;
        }
        this.mIsCancelled = true;
        if (this.mDownloadTask == null) {
            return true;
        }
        return this.mDownloadTask.cancel();
    }

    @Override // com.tencent.ams.dsdk.download.Download
    public int getDownloadStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.ams.dsdk.download.Download
    public float getDownloadedProgress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Float) iPatchRedirector.redirect((short) 8, (Object) this)).floatValue();
        }
        DownloadRequest downloadRequest = this.mRequest;
        if (downloadRequest != null && !TextUtils.isEmpty(downloadRequest.getFolder()) && !TextUtils.isEmpty(this.mRequest.getName()) && new File(this.mRequest.getFolder(), this.mRequest.getName()).exists()) {
            return 1.0f;
        }
        DownloadItem downloadItem = getDownloadItem();
        long j3 = downloadItem.progress;
        if (j3 > 0) {
            long j16 = downloadItem.total;
            if (j16 > 0) {
                return ((float) j3) / ((float) j16);
            }
            return 0.0f;
        }
        return 0.0f;
    }

    public boolean isFinished() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this.mDownloadTask != null && (this.mDownloadTask.isCompleted() || this.mDownloadTask.isFailed() || this.mDownloadTask.isCancelled())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ams.dsdk.download.Download
    public boolean isRunning() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (!this.mIsCancelled && !isFinished()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ams.dsdk.download.Download
    public boolean registerCallback(Download.Callback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) callback)).booleanValue();
        }
        synchronized (this.mStateLock) {
            boolean z16 = false;
            if (isFinished()) {
                return false;
            }
            if (callback != null && !this.mCallbackList.contains(callback)) {
                z16 = this.mCallbackList.add(callback);
            }
            if (z16 && this.mIsStarted && callback != null) {
                callback.onDownloadStart();
            }
            DLog.d(TAG, "registerCallback, callback: " + callback + ", result: " + z16 + ", " + this);
            return z16;
        }
    }

    @Override // com.tencent.ams.dsdk.download.Download
    public boolean start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        DLog.d(TAG, "start, " + this);
        if (this.mRequest != null && !isFinished() && !this.mIsCancelled) {
            if (this.mDownloadTask == null) {
                this.mDownloadTask = new DownloadTaskImpl(getDownloadItem(), this.mRequest.getMaxRetryCount(), new InnerDownloadCallback(this, null));
                DLog.d(TAG, "download" + this + ", downloadTask: " + this.mDownloadTask);
                if (this.mRequest.getDownloadExecutor() != null) {
                    this.mRequest.getDownloadExecutor().execute(this.mDownloadTask);
                } else if (DKConfiguration.isEnableOrganizeThreads()) {
                    WorkThreadManager.getInstance().getBackgroundThreadPool().execute(this.mDownloadTask);
                } else {
                    WorkThreadManager.getInstance().getImmediateThreadPool().execute(this.mDownloadTask);
                }
            }
            DLog.d(TAG, "start success");
            return true;
        }
        DLog.d(TAG, "start false");
        return false;
    }

    @Override // com.tencent.ams.dsdk.download.Download
    public boolean unRegisterCallback(Download.Callback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) callback)).booleanValue();
        }
        DLog.d(TAG, "unRegisterCallback, callback: " + callback);
        synchronized (this.mStateLock) {
            if (callback != null) {
                if (this.mCallbackList.contains(callback)) {
                    return this.mCallbackList.remove(callback);
                }
            }
            return false;
        }
    }
}
