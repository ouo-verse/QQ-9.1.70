package com.tencent.ams.dsdk.download;

import android.text.TextUtils;
import com.tencent.ams.dsdk.download.DKDownloadManager;
import com.tencent.ams.dsdk.download.Download;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.dsdk.utils.Md5Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DefaultDownloadManager implements DKDownloadManager {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class DefaultDownloader implements DKDownloadManager.IDownloader {
        static IPatchRedirector $redirector_;
        private final DKDownloadManager.Callback mCallback;
        private Download mDownload;
        private final DownloadRequest mRequest;
        private volatile int mStatus;

        /* compiled from: P */
        /* loaded from: classes3.dex */
        private @interface DownloadStatus {
            public static final int FINISHED = 4;
            public static final int PAUSED = 2;
            public static final int RESUMED = 3;
            public static final int STARTED = 1;
            public static final int UNKNOWN = 0;
        }

        public DefaultDownloader(DownloadRequest downloadRequest, DKDownloadManager.Callback callback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) downloadRequest, (Object) callback);
                return;
            }
            this.mStatus = 0;
            this.mRequest = downloadRequest;
            this.mCallback = callback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @DKDownloadManager.ErrorCode
        public int convertErrorCode(int i3) {
            switch (i3) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                    return 6;
                default:
                    return 7;
            }
        }

        private void doDownload() {
            this.mDownload = DownloadManager.getInstance().download(this.mRequest, new Download.Callback() { // from class: com.tencent.ams.dsdk.download.DefaultDownloadManager.DefaultDownloader.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) DefaultDownloader.this);
                    }
                }

                @Override // com.tencent.ams.dsdk.download.Download.Callback
                public void onCancelled() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        iPatchRedirector.redirect((short) 4, (Object) this);
                        return;
                    }
                    if (DefaultDownloader.this.mCallback != null && DefaultDownloader.this.mStatus == 4) {
                        if (DefaultDownloader.this.mStatus == 2) {
                            DefaultDownloader.this.mCallback.onDownloadPause();
                        } else if (DefaultDownloader.this.mStatus == 4) {
                            DefaultDownloader.this.mCallback.onCancelled();
                        }
                    }
                }

                @Override // com.tencent.ams.dsdk.download.Download.Callback
                public void onDownloadComplete() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this);
                    } else if (DefaultDownloader.this.mCallback != null) {
                        DefaultDownloader.this.mCallback.onDownloadComplete();
                    }
                }

                @Override // com.tencent.ams.dsdk.download.Download.Callback
                public void onDownloadFailed(Exception exc) {
                    int i3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                        iPatchRedirector.redirect((short) 6, (Object) this, (Object) exc);
                        return;
                    }
                    if (DefaultDownloader.this.mCallback != null) {
                        DKDownloadManager.Callback callback = DefaultDownloader.this.mCallback;
                        if (exc instanceof DownloadException) {
                            i3 = DefaultDownloader.this.convertErrorCode(((DownloadException) exc).getErrorCode());
                        } else {
                            i3 = 7;
                        }
                        callback.onDownloadFailed(i3);
                    }
                }

                @Override // com.tencent.ams.dsdk.download.Download.Callback
                public void onDownloadProgress(long j3, long j16) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        iPatchRedirector.redirect((short) 5, this, Long.valueOf(j3), Long.valueOf(j16));
                    } else if (DefaultDownloader.this.mCallback != null) {
                        DefaultDownloader.this.mCallback.onDownloadUpdate((int) j3, (int) j16);
                    }
                }

                @Override // com.tencent.ams.dsdk.download.Download.Callback
                public void onDownloadStart() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (DefaultDownloader.this.mCallback != null) {
                        if (DefaultDownloader.this.mStatus == 1) {
                            DefaultDownloader.this.mCallback.onDownloadStart();
                        } else if (DefaultDownloader.this.mStatus == 3) {
                            DefaultDownloader.this.mCallback.onDownloadResume();
                        }
                    }
                }
            });
        }

        private DownloadItem getDownloadItem() {
            try {
                return new DownloadItem(this.mRequest.getUrl(), this.mRequest.getFileMd5(), 0L, 0L, this.mRequest.getFolder(), this.mRequest.getName()).query();
            } catch (Throwable th5) {
                DLog.e("getDownloadItem error.", th5);
                return null;
            }
        }

        @Override // com.tencent.ams.dsdk.download.DKDownloadManager.IDownloader
        public boolean cancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            this.mStatus = 4;
            Download download = this.mDownload;
            if (download != null && download.cancel()) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ams.dsdk.download.DKDownloadManager.IDownloader
        public int getDownloadStatus() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            Download download = this.mDownload;
            if (download != null) {
                return download.getDownloadStatus();
            }
            return 0;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x005d  */
        /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
        @Override // com.tencent.ams.dsdk.download.DKDownloadManager.IDownloader
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public float getDownloadedProgress() {
            float f16;
            DownloadItem downloadItem;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Float) iPatchRedirector.redirect((short) 4, (Object) this)).floatValue();
            }
            Download download = this.mDownload;
            if (download == null) {
                String folder = this.mRequest.getFolder();
                String name = this.mRequest.getName();
                String fileMd5 = this.mRequest.getFileMd5();
                if (!TextUtils.isEmpty(folder) && !TextUtils.isEmpty(name)) {
                    File file = new File(folder, name);
                    if (file.exists() && (TextUtils.isEmpty(fileMd5) || fileMd5.equals(Md5Utils.toMd5(file)))) {
                        f16 = 100.0f;
                        downloadItem = getDownloadItem();
                        if (downloadItem == null) {
                            long j3 = downloadItem.total;
                            if (j3 > 0) {
                                return ((float) downloadItem.progress) / ((float) j3);
                            }
                            return f16;
                        }
                        return f16;
                    }
                }
                f16 = 0.0f;
                downloadItem = getDownloadItem();
                if (downloadItem == null) {
                }
            } else {
                return download.getDownloadedProgress();
            }
        }

        @Override // com.tencent.ams.dsdk.download.DKDownloadManager.IDownloader
        public boolean isRunning() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            Download download = this.mDownload;
            if (download != null && download.isRunning()) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ams.dsdk.download.DKDownloadManager.IDownloader
        public boolean pause() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
            }
            Download download = this.mDownload;
            if (download != null) {
                if (this.mStatus == 1 || this.mStatus == 3) {
                    this.mStatus = 2;
                    return download.cancel();
                }
                return false;
            }
            return false;
        }

        @Override // com.tencent.ams.dsdk.download.DKDownloadManager.IDownloader
        public boolean resume() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
            }
            if (this.mStatus == 2) {
                this.mStatus = 3;
                doDownload();
                return false;
            }
            return false;
        }

        @Override // com.tencent.ams.dsdk.download.DKDownloadManager.IDownloader
        public boolean start() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            Download download = this.mDownload;
            if (this.mStatus == 0 && download == null) {
                this.mStatus = 1;
                doDownload();
                return true;
            }
            return false;
        }
    }

    public DefaultDownloadManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.ams.dsdk.download.DKDownloadManager
    public DKDownloadManager.IDownloader download(DownloadRequest downloadRequest, DKDownloadManager.Callback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (DKDownloadManager.IDownloader) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadRequest, (Object) callback);
        }
        return new DefaultDownloader(downloadRequest, callback);
    }
}
