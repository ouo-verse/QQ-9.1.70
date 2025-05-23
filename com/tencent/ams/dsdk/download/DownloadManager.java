package com.tencent.ams.dsdk.download;

import android.text.TextUtils;
import com.tencent.ams.dsdk.download.Download;
import com.tencent.ams.dsdk.download.core.DownloadImpl;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.dsdk.utils.Md5Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DownloadManager {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DownloadManager";
    private final byte[] mCacheLock;
    private final ConcurrentHashMap<String, Download> mDownloadingCache;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Holder {
        static IPatchRedirector $redirector_;
        private static DownloadManager INSTANCE;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17942);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                INSTANCE = new DownloadManager();
            }
        }

        Holder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class WrapCallback implements Download.Callback {
        static IPatchRedirector $redirector_;
        private Download.Callback mRealCallback;

        public WrapCallback(Download.Callback callback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) callback);
            } else {
                this.mRealCallback = callback;
            }
        }

        @Override // com.tencent.ams.dsdk.download.Download.Callback
        public void onCancelled() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            Download.Callback callback = this.mRealCallback;
            if (callback != null) {
                callback.onCancelled();
            }
        }

        @Override // com.tencent.ams.dsdk.download.Download.Callback
        public void onDownloadComplete() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            Download.Callback callback = this.mRealCallback;
            if (callback != null) {
                callback.onDownloadComplete();
            }
        }

        @Override // com.tencent.ams.dsdk.download.Download.Callback
        public void onDownloadFailed(Exception exc) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) exc);
                return;
            }
            Download.Callback callback = this.mRealCallback;
            if (callback != null) {
                callback.onDownloadFailed(exc);
            }
        }

        @Override // com.tencent.ams.dsdk.download.Download.Callback
        public void onDownloadProgress(long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Long.valueOf(j3), Long.valueOf(j16));
                return;
            }
            Download.Callback callback = this.mRealCallback;
            if (callback != null) {
                callback.onDownloadProgress(j3, j16);
            }
        }

        @Override // com.tencent.ams.dsdk.download.Download.Callback
        public void onDownloadStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Download.Callback callback = this.mRealCallback;
            if (callback != null) {
                callback.onDownloadStart();
            }
        }
    }

    public DownloadManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mDownloadingCache = new ConcurrentHashMap<>();
            this.mCacheLock = new byte[0];
        }
    }

    private Download doRealDownload(DownloadRequest downloadRequest, Download.Callback callback) {
        DownloadImpl downloadImpl = new DownloadImpl(downloadRequest);
        downloadImpl.registerCallback(new WrapCallback(callback, downloadRequest, downloadImpl) { // from class: com.tencent.ams.dsdk.download.DownloadManager.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Download val$download;
            final /* synthetic */ DownloadRequest val$request;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(callback);
                this.val$request = downloadRequest;
                this.val$download = downloadImpl;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, DownloadManager.this, callback, downloadRequest, downloadImpl);
                }
            }

            @Override // com.tencent.ams.dsdk.download.DownloadManager.WrapCallback, com.tencent.ams.dsdk.download.Download.Callback
            public void onCancelled() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                    DownloadManager.this.removeDownloadFromCache(this.val$request, this.val$download);
                    super.onCancelled();
                } else {
                    iPatchRedirector.redirect((short) 3, (Object) this);
                }
            }

            @Override // com.tencent.ams.dsdk.download.DownloadManager.WrapCallback, com.tencent.ams.dsdk.download.Download.Callback
            public void onDownloadComplete() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    DownloadManager.this.removeDownloadFromCache(this.val$request, this.val$download);
                    super.onDownloadComplete();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }

            @Override // com.tencent.ams.dsdk.download.DownloadManager.WrapCallback, com.tencent.ams.dsdk.download.Download.Callback
            public void onDownloadFailed(Exception exc) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                    DownloadManager.this.removeDownloadFromCache(this.val$request, this.val$download);
                    super.onDownloadFailed(exc);
                } else {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) exc);
                }
            }
        });
        DLog.d(TAG, "cache downloader, key: " + getKey(downloadRequest) + ", downloader: " + downloadImpl);
        synchronized (this.mCacheLock) {
            this.mDownloadingCache.put(getKey(downloadRequest), downloadImpl);
        }
        try {
            downloadImpl.start();
        } catch (Throwable th5) {
            DLog.e(TAG, "download.start error :", th5);
        }
        return downloadImpl;
    }

    public static DownloadManager getInstance() {
        return Holder.INSTANCE;
    }

    private String getKey(DownloadRequest downloadRequest) {
        if (downloadRequest != null && !TextUtils.isEmpty(downloadRequest.getUrl())) {
            return Md5Utils.toMd5(downloadRequest.getUrl());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeDownloadFromCache(DownloadRequest downloadRequest, Download download) {
        String key = getKey(downloadRequest);
        synchronized (this.mCacheLock) {
            Download download2 = this.mDownloadingCache.get(key);
            DLog.d(TAG, "removeDownloadFromCache, request: " + downloadRequest + ", download: " + download + ", catchDownload: " + download2);
            if (download2 != null && download2 == download) {
                this.mDownloadingCache.remove(key);
            }
        }
    }

    public synchronized Download download(DownloadRequest downloadRequest, Download.Callback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Download) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadRequest, (Object) callback);
        }
        String key = getKey(downloadRequest);
        if (key == null) {
            if (callback != null) {
                callback.onDownloadFailed(new DownloadException(1, "request\u6216\u8005\u4e0b\u8f7d\u94fe\u63a5\u4e3a\u7a7a"));
            }
            return null;
        }
        Download download = this.mDownloadingCache.get(key);
        if (download != null && download.isRunning() && download.registerCallback(callback)) {
            return download;
        }
        return doRealDownload(downloadRequest, callback);
    }
}
