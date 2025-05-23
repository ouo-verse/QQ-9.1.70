package cooperation.qzone;

import android.content.Context;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.DownloadRequest;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Vector;

/* loaded from: classes28.dex */
public class QzonePreDownloadManager {
    private static QzonePreDownloadManager mInstance;
    private DownloadEnty currentEnty;
    private boolean isDownloading;
    private Downloader mImageDownloader = null;
    private Context context = BaseApplication.getContext();
    private Vector<DownloadEnty> downloadList = new Vector<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes28.dex */
    public class DownloadEnty {
        DownloadRequest downloadRequest;
        Downloader.DownloadListener localListener;
        Downloader.DownloadListener oridownloadListener;
        String path;
        boolean priority;
        boolean startimmediately;
        String url;

        DownloadEnty() {
        }
    }

    private synchronized Downloader getDownloader() {
        Downloader downloader = this.mImageDownloader;
        if (downloader != null) {
            return downloader;
        }
        Downloader downloader2 = null;
        try {
            downloader2 = DownloaderFactory.getInstance(this.context).getCommonDownloader();
            downloader2.enableResumeTransfer();
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        this.mImageDownloader = downloader2;
        if (downloader2 != null) {
            return downloader2;
        }
        throw new RuntimeException("no downloader available");
    }

    public static QzonePreDownloadManager getInstance() {
        if (mInstance == null) {
            synchronized (QzonePreDownloadManager.class) {
                mInstance = new QzonePreDownloadManager();
            }
        }
        return mInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean runTask(DownloadEnty downloadEnty) {
        if (this.isDownloading) {
            if (downloadEnty.startimmediately) {
                this.downloadList.add(0, downloadEnty);
            } else {
                this.downloadList.add(downloadEnty);
            }
            return true;
        }
        if (downloadEnty.downloadRequest != null) {
            if (!getDownloader().download(downloadEnty.downloadRequest, downloadEnty.priority)) {
                return false;
            }
            this.currentEnty = downloadEnty;
            this.isDownloading = true;
            return true;
        }
        if (!getDownloader().download(downloadEnty.url, downloadEnty.path, downloadEnty.priority, downloadEnty.localListener)) {
            return false;
        }
        this.currentEnty = downloadEnty;
        this.isDownloading = true;
        return true;
    }

    public void abort(String str, Downloader.DownloadListener downloadListener) {
        getDownloader().abort(str, downloadListener);
        if (this.downloadList.size() > 0) {
            DownloadEnty downloadEnty = this.downloadList.get(0);
            this.downloadList.remove(0);
            this.isDownloading = false;
            runTask(downloadEnty);
        }
    }

    public void cancel(String str, Downloader.DownloadListener downloadListener) {
        getDownloader().cancel(str, downloadListener);
        if (this.downloadList.size() > 0) {
            DownloadEnty downloadEnty = this.downloadList.get(0);
            this.downloadList.remove(0);
            this.isDownloading = false;
            runTask(downloadEnty);
        }
    }

    public final boolean download(DownloadRequest downloadRequest, boolean z16) {
        return download(null, null, z16, false, downloadRequest, downloadRequest.getListener());
    }

    public final boolean download(String str, String str2, Downloader.DownloadListener downloadListener) {
        return download(str, str2, false, false, downloadListener);
    }

    public final boolean download(String str, String str2, boolean z16, Downloader.DownloadListener downloadListener) {
        return download(str, str2, z16, false, downloadListener);
    }

    public final boolean download(String str, String str2, boolean z16, boolean z17, Downloader.DownloadListener downloadListener) {
        return download(str, str2, z16, z17, null, downloadListener);
    }

    public final boolean download(String str, String str2, boolean z16, boolean z17, DownloadRequest downloadRequest, Downloader.DownloadListener downloadListener) {
        final DownloadEnty downloadEnty = new DownloadEnty();
        downloadEnty.path = str2;
        downloadEnty.url = str;
        downloadEnty.priority = z16;
        downloadEnty.startimmediately = z17;
        downloadEnty.oridownloadListener = downloadListener;
        Downloader.DownloadListener downloadListener2 = new Downloader.DownloadListener() { // from class: cooperation.qzone.QzonePreDownloadManager.1
            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadCanceled(String str3) {
                QzonePreDownloadManager.this.isDownloading = false;
                if (QzonePreDownloadManager.this.downloadList.size() > 0) {
                    DownloadEnty downloadEnty2 = (DownloadEnty) QzonePreDownloadManager.this.downloadList.get(0);
                    QzonePreDownloadManager.this.downloadList.remove(0);
                    QzonePreDownloadManager.this.runTask(downloadEnty2);
                }
                Downloader.DownloadListener downloadListener3 = downloadEnty.oridownloadListener;
                if (downloadListener3 != null) {
                    downloadListener3.onDownloadCanceled(str3);
                }
            }

            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadFailed(String str3, DownloadResult downloadResult) {
                QzonePreDownloadManager.this.isDownloading = false;
                if (QzonePreDownloadManager.this.downloadList.size() > 0) {
                    DownloadEnty downloadEnty2 = (DownloadEnty) QzonePreDownloadManager.this.downloadList.get(0);
                    QzonePreDownloadManager.this.downloadList.remove(0);
                    QzonePreDownloadManager.this.runTask(downloadEnty2);
                }
                Downloader.DownloadListener downloadListener3 = downloadEnty.oridownloadListener;
                if (downloadListener3 != null) {
                    downloadListener3.onDownloadFailed(str3, downloadResult);
                }
            }

            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadProgress(String str3, long j3, float f16) {
                Downloader.DownloadListener downloadListener3 = downloadEnty.oridownloadListener;
                if (downloadListener3 != null) {
                    downloadListener3.onDownloadProgress(str3, j3, f16);
                }
            }

            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadSucceed(String str3, DownloadResult downloadResult) {
                QzonePreDownloadManager.this.isDownloading = false;
                if (QzonePreDownloadManager.this.downloadList.size() > 0) {
                    DownloadEnty downloadEnty2 = (DownloadEnty) QzonePreDownloadManager.this.downloadList.get(0);
                    QzonePreDownloadManager.this.downloadList.remove(0);
                    QzonePreDownloadManager.this.runTask(downloadEnty2);
                }
                Downloader.DownloadListener downloadListener3 = downloadEnty.oridownloadListener;
                if (downloadListener3 != null) {
                    downloadListener3.onDownloadSucceed(str3, downloadResult);
                }
            }
        };
        downloadEnty.localListener = downloadListener2;
        if (downloadRequest != null) {
            downloadRequest.setListener(downloadListener2);
            downloadEnty.downloadRequest = downloadRequest;
        }
        return runTask(downloadEnty);
    }
}
