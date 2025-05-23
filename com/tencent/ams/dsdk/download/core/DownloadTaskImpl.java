package com.tencent.ams.dsdk.download.core;

import android.text.TextUtils;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.dsdk.download.DownloadException;
import com.tencent.ams.dsdk.download.DownloadItem;
import com.tencent.ams.dsdk.download.DownloadTask;
import com.tencent.ams.dsdk.utils.DKURLConnectionCreator;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.dsdk.utils.DynamicUtils;
import com.tencent.ams.dsdk.utils.Md5Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DownloadTaskImpl implements DownloadTask {
    static IPatchRedirector $redirector_ = null;
    private static final int BUFFER_SIZE = 10240;
    private static final int CONNECTION_TIMEOUT = 3000;
    private static final int HTTP_ERROR_416 = 416;
    private static final int MAX_REDIRECT_COUNT = 3;
    private static final String SUFFIX = ".temp";
    private static final String TAG = "DownloadTaskImpl";
    private int m416RetryCount;
    private int mCurrentRedirectCount;
    private int mCurrentRetryCount;
    private DownloadItem mDownloadItem;
    private DownloadTask.OnDownloadListener mDownloadListener;
    private int mMaxRetryCount;
    private final byte[] mStateLock;

    @Status
    private volatile int mStatus;
    private File mTargetFile;
    private File mTempFile;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    @interface Status {
        public static final int STATUS_CANCELLED = 2;
        public static final int STATUS_COMPLETED = 3;
        public static final int STATUS_FAILED = 4;
        public static final int STATUS_READY = 0;
        public static final int STATUS_STARTED = 1;
    }

    public DownloadTaskImpl(DownloadItem downloadItem, int i3, DownloadTask.OnDownloadListener onDownloadListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, downloadItem, Integer.valueOf(i3), onDownloadListener);
            return;
        }
        this.mDownloadListener = null;
        this.mTargetFile = null;
        this.mTempFile = null;
        this.mDownloadItem = null;
        this.mCurrentRetryCount = 0;
        this.mMaxRetryCount = 3;
        this.mCurrentRedirectCount = 0;
        this.m416RetryCount = 0;
        this.mStateLock = new byte[0];
        this.mStatus = 0;
        this.mDownloadListener = onDownloadListener;
        this.mDownloadItem = downloadItem;
        this.mMaxRetryCount = i3 <= 0 ? 3 : i3;
    }

    private void checkCanceled() throws DownloadException.CancelledException {
        if (!isCancelled()) {
        } else {
            throw new DownloadException.CancelledException();
        }
    }

    private boolean checkDownloadParams() {
        DownloadItem downloadItem = this.mDownloadItem;
        if (downloadItem != null && !TextUtils.isEmpty(downloadItem.url) && !TextUtils.isEmpty(this.mDownloadItem.folder) && !TextUtils.isEmpty(this.mDownloadItem.fileName)) {
            return true;
        }
        return false;
    }

    private boolean checkFileMd5(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        DownloadItem downloadItem = this.mDownloadItem;
        String str = downloadItem == null ? null : downloadItem.md5;
        if (downloadItem != null) {
            return TextUtils.isEmpty(str) || str.equalsIgnoreCase(Md5Utils.toMd5(file));
        }
        return false;
    }

    private boolean checkTempFileInvalid() {
        DownloadItem downloadItem;
        File file = this.mTempFile;
        if (file == null || !file.exists() || (downloadItem = this.mDownloadItem) == null || !downloadItem.isFinish() || this.mDownloadItem.total != this.mTempFile.length()) {
            return false;
        }
        boolean checkFileMd5 = checkFileMd5(this.mTempFile);
        if (!checkFileMd5) {
            this.mDownloadItem.updateProgress(0L);
            this.mTempFile.delete();
        }
        return checkFileMd5;
    }

    private HttpURLConnection connect(String str, long j3) throws Exception {
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        try {
            checkCanceled();
            long currentTimeMillis = System.currentTimeMillis();
            DKURLConnectionCreator connectionCreator = DKConfiguration.getConnectionCreator();
            if (connectionCreator != null) {
                httpURLConnection = connectionCreator.getURLConnection(str);
            } else {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            }
            if (httpURLConnection == null) {
                return null;
            }
            try {
                httpURLConnection.setConnectTimeout(3000);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.addRequestProperty("Range", "bytes=" + j3 + "-");
                httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                httpURLConnection.connect();
                DLog.d(TAG, "connect time cost: " + (System.currentTimeMillis() - currentTimeMillis));
                int responseCode = httpURLConnection.getResponseCode();
                if (isRedirect(responseCode)) {
                    int i3 = this.mCurrentRedirectCount + 1;
                    this.mCurrentRedirectCount = i3;
                    if (i3 < 3) {
                        String headerField = httpURLConnection.getHeaderField("location");
                        DLog.d(TAG, "download redirect, origin url: " + str + ", new url: " + headerField);
                        DynamicUtils.safeDisconnect(httpURLConnection);
                        return connect(headerField, j3);
                    }
                    throw new DownloadException(5, "\u91cd\u5b9a\u5411\u6b21\u6570\u8d85\u8fc7\u9650\u5236");
                }
                if (responseCode == 416) {
                    int i16 = this.m416RetryCount + 1;
                    this.m416RetryCount = i16;
                    if (i16 < 3) {
                        DynamicUtils.safeDisconnect(httpURLConnection);
                        DownloadItem downloadItem = this.mDownloadItem;
                        if (downloadItem != null) {
                            downloadItem.updateProgress(0L);
                        }
                        File file = this.mTempFile;
                        if (file != null) {
                            file.delete();
                        }
                        return connect(str, 0L);
                    }
                    throw new DownloadException(8, "416\u6b21\u6570\u8d85\u8fc7\u9650\u5236");
                }
                if (responseCode >= 200 && responseCode < 400) {
                    return httpURLConnection;
                }
                throw new DownloadException(6, "HTTP\u8bf7\u6c42\u9519\u8bef");
            } catch (Exception e16) {
                e = e16;
                httpURLConnection2 = httpURLConnection;
                DynamicUtils.safeDisconnect(httpURLConnection2);
                DLog.e(TAG, "connect error. exception: " + e, e);
                throw e;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    private void copyFile2Target() throws Exception {
        DownloadException downloadException;
        checkCanceled();
        File file = this.mTempFile;
        if (file != null && checkFileMd5(file)) {
            try {
                if (this.mTargetFile == null) {
                    this.mTargetFile = initTargetFile();
                }
                if (this.mTargetFile.exists()) {
                    this.mTargetFile.delete();
                }
                if (this.mTempFile.renameTo(this.mTargetFile)) {
                    DownloadItem downloadItem = this.mDownloadItem;
                    if (downloadItem != null) {
                        downloadItem.delete();
                        return;
                    }
                    return;
                }
                throw new DownloadException(3, "\u6587\u4ef6\u590d\u5236\u5931\u8d25");
            } catch (Exception e16) {
                DLog.e(TAG, "copy file to target file error., " + this, e16);
                throw e16;
            }
        }
        File file2 = this.mTempFile;
        if (file2 != null && file2.exists()) {
            downloadException = new DownloadException(2, "\u6587\u4ef6\u6821\u9a8c\u9519\u8bef");
            this.mTempFile.delete();
        } else {
            downloadException = new DownloadException(3, "\u4e0b\u8f7d\u4e34\u65f6\u6587\u4ef6\u4e0d\u5b58\u5728");
        }
        DownloadItem downloadItem2 = this.mDownloadItem;
        if (downloadItem2 != null) {
            downloadItem2.updateProgress(0L);
            throw downloadException;
        }
        throw downloadException;
    }

    private void doDownload() throws Exception {
        try {
            if (this.mDownloadItem != null) {
                File initTargetFile = initTargetFile();
                this.mTargetFile = initTargetFile;
                if (preDownloadCheck(initTargetFile.getAbsolutePath())) {
                    return;
                }
                this.mTempFile = initTempFile();
                if (!checkTempFileInvalid()) {
                    DownloadItem downloadItem = this.mDownloadItem;
                    doWriteFile(connect(downloadItem.url, downloadItem.progress));
                }
                copyFile2Target();
                return;
            }
            throw new DownloadException(1, "\u4e0b\u8f7d\u53c2\u6570\u4e3a\u7a7a");
        } catch (Exception e16) {
            DLog.e(TAG, "download error., " + this, e16);
            throw e16;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void doWriteFile(HttpURLConnection httpURLConnection) throws Exception {
        Throwable th5;
        InputStream inputStream;
        RandomAccessFile randomAccessFile;
        DownloadItem downloadItem;
        RandomAccessFile randomAccessFile2 = null;
        randomAccessFile2 = null;
        InputStream inputStream2 = null;
        try {
            checkCanceled();
            if (this.mDownloadItem != null) {
                if (httpURLConnection != null) {
                    File file = this.mTempFile;
                    if (file == null || !file.exists()) {
                        this.mTempFile = initTempFile();
                    }
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        if (inputStream != null) {
                            randomAccessFile = new RandomAccessFile(this.mTempFile, "rwd");
                            try {
                                randomAccessFile.seek(this.mDownloadItem.progress);
                                long j3 = this.mDownloadItem.progress;
                                long contentLength = httpURLConnection.getContentLength() + j3;
                                byte[] bArr = new byte[10240];
                                while (true) {
                                    int read = inputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    checkCanceled();
                                    randomAccessFile.write(bArr, 0, read);
                                    j3 += read;
                                    updateDownloadProgress(contentLength, j3);
                                }
                                DynamicUtils.safeClose(randomAccessFile);
                                DynamicUtils.safeClose(inputStream);
                                DynamicUtils.safeDisconnect(httpURLConnection);
                                DownloadItem downloadItem2 = this.mDownloadItem;
                                if (downloadItem2 != null) {
                                    downloadItem2.update();
                                    return;
                                }
                                return;
                            } catch (Exception e16) {
                                e = e16;
                                inputStream2 = inputStream;
                                try {
                                    DLog.e(TAG, "write to file error.", e);
                                    throw e;
                                } catch (Throwable th6) {
                                    inputStream = inputStream2;
                                    randomAccessFile2 = randomAccessFile;
                                    th5 = th6;
                                    DynamicUtils.safeClose(randomAccessFile2);
                                    DynamicUtils.safeClose(inputStream);
                                    DynamicUtils.safeDisconnect(httpURLConnection);
                                    downloadItem = this.mDownloadItem;
                                    if (downloadItem != null) {
                                        downloadItem.update();
                                    }
                                    throw th5;
                                }
                            } catch (Throwable th7) {
                                th5 = th7;
                                randomAccessFile2 = randomAccessFile;
                                DynamicUtils.safeClose(randomAccessFile2);
                                DynamicUtils.safeClose(inputStream);
                                DynamicUtils.safeDisconnect(httpURLConnection);
                                downloadItem = this.mDownloadItem;
                                if (downloadItem != null) {
                                }
                                throw th5;
                            }
                        }
                        throw new DownloadException("\u4e0b\u8f7d\u4fe1\u606f\u6d41\u4e3a\u7a7a");
                    } catch (Exception e17) {
                        randomAccessFile = null;
                        inputStream2 = inputStream;
                        e = e17;
                    } catch (Throwable th8) {
                        th5 = th8;
                    }
                } else {
                    throw new DownloadException("connect\u4e3a\u7a7a");
                }
            } else {
                throw new DownloadException(1, "\u4e0b\u8f7d\u53c2\u6570\u4e3a\u7a7a");
            }
        } catch (Exception e18) {
            e = e18;
            randomAccessFile = null;
        } catch (Throwable th9) {
            th5 = th9;
            inputStream = null;
        }
    }

    private void handleDownload() {
        try {
            updateAndDispatchStatus(1);
            if (!checkDownloadParams()) {
                updateAndDispatchStatus(4, new DownloadException(1, "\u4e0b\u8f7d\u53c2\u6570\u9519\u8bef"));
                return;
            }
            Exception e16 = null;
            while (this.mCurrentRetryCount < this.mMaxRetryCount) {
                checkCanceled();
                try {
                    doDownload();
                    updateAndDispatchStatus(3);
                    break;
                } catch (Exception e17) {
                    e16 = e17;
                    if (e16 instanceof DownloadException.CancelledException) {
                        break;
                    }
                    this.mCurrentRetryCount++;
                    DLog.e(TAG, "download error. mCurrentRetryCount: " + this.mCurrentRetryCount, e16);
                }
            }
            if (!isCompleted()) {
                if (e16 == null) {
                    e16 = new DownloadException(7, "\u4e0b\u8f7d\u5931\u8d25");
                }
                updateAndDispatchStatus(4, e16);
            }
        } catch (Exception e18) {
            DLog.e(TAG, "download error.", e18);
            if (e18 instanceof DownloadException.CancelledException) {
                notifyDownloadCancelled();
                return;
            }
            try {
                updateAndDispatchStatus(4, e18);
            } catch (DownloadException.CancelledException e19) {
                DLog.d(TAG, "download cancelled, update failed error.", e19);
                notifyDownloadCancelled();
            }
        }
    }

    private File initFolder() throws DownloadException {
        DownloadItem downloadItem = this.mDownloadItem;
        if (downloadItem != null) {
            String str = downloadItem.folder;
            DLog.d(TAG, "folder: " + str);
            if (!TextUtils.isEmpty(str)) {
                File file = new File(str);
                if (!file.exists() && !file.mkdirs()) {
                    throw new DownloadException(3, "\u521b\u5efa\u6587\u4ef6\u5939\u5931\u8d25");
                }
                return file;
            }
            throw new DownloadException(1, "\u4e0b\u8f7d\u6587\u4ef6\u5939\u4e3a\u7a7a");
        }
        throw new DownloadException(1, "\u4e0b\u8f7d\u8bf7\u6c42\u4e3a\u7a7a");
    }

    private File initTargetFile() throws DownloadException {
        String str;
        File initFolder = initFolder();
        DownloadItem downloadItem = this.mDownloadItem;
        if (downloadItem == null) {
            str = null;
        } else {
            str = downloadItem.fileName;
        }
        DLog.d(TAG, "fileName: " + str);
        if (!TextUtils.isEmpty(str)) {
            return new File(initFolder, str);
        }
        throw new DownloadException(1, "\u4e0b\u8f7d\u6587\u4ef6\u540d\u4e3a\u7a7a");
    }

    private File initTempFile() throws DownloadException {
        String str;
        File initFolder = initFolder();
        DownloadItem downloadItem = this.mDownloadItem;
        if (downloadItem == null) {
            str = null;
        } else {
            str = downloadItem.fileName;
        }
        DLog.d(TAG, "fileName: " + str);
        if (!TextUtils.isEmpty(str)) {
            File file = new File(initFolder, str + ".temp");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Throwable th5) {
                    DLog.e(TAG, "create temp file error.", th5);
                    throw new DownloadException(3, "\u521b\u5efa\u4e34\u65f6\u6587\u4ef6\u5931\u8d25");
                }
            }
            return file;
        }
        throw new DownloadException(1, "\u4e0b\u8f7d\u6587\u4ef6\u540d\u4e3a\u7a7a");
    }

    private boolean isRedirect(int i3) {
        if (i3 >= 300 && i3 <= 308) {
            return true;
        }
        return false;
    }

    private void notifyDownloadCancelled() {
        DownloadTask.OnDownloadListener onDownloadListener = this.mDownloadListener;
        if (onDownloadListener != null) {
            onDownloadListener.onCancelled();
        }
    }

    private void notifyDownloadComplete() {
        DownloadTask.OnDownloadListener onDownloadListener = this.mDownloadListener;
        if (onDownloadListener != null) {
            onDownloadListener.onDownloadComplete();
        }
    }

    private void notifyDownloadFailed(Exception exc) {
        DownloadTask.OnDownloadListener onDownloadListener = this.mDownloadListener;
        if (onDownloadListener != null && exc != null) {
            onDownloadListener.onDownloadFailed(exc);
        }
    }

    private void notifyDownloadStarted() {
        DownloadTask.OnDownloadListener onDownloadListener = this.mDownloadListener;
        if (onDownloadListener != null) {
            onDownloadListener.onDownloadStart();
        }
    }

    private void notifyProgress(long j3, long j16) {
        DownloadTask.OnDownloadListener onDownloadListener = this.mDownloadListener;
        if (onDownloadListener != null) {
            onDownloadListener.onDownloadProgress(j3, j16);
        }
    }

    private boolean preDownloadCheck(String str) {
        DownloadItem downloadItem;
        if (!TextUtils.isEmpty(str) && (downloadItem = this.mDownloadItem) != null && !TextUtils.isEmpty(downloadItem.md5)) {
            return checkFileMd5(str);
        }
        return false;
    }

    private void updateAndDispatchStatus(@Status int i3, Exception exc) throws DownloadException.CancelledException {
        synchronized (this.mStateLock) {
            DLog.d(TAG, "updateAndDispatchStatus, old: " + this.mStatus + ", new: " + i3);
            try {
                checkCanceled();
                e = null;
            } catch (DownloadException.CancelledException e16) {
                e = e16;
                DLog.e(TAG, "download cancelled, update status failed.", e);
            }
            if (e == null) {
                this.mStatus = i3;
            }
            if (i3 == 1) {
                notifyDownloadStarted();
            } else if (e == null && i3 == 3) {
                notifyDownloadComplete();
            } else if (e == null && i3 == 4) {
                notifyDownloadFailed(exc);
            }
            if (e != null) {
                throw e;
            }
        }
    }

    private void updateDownloadProgress(long j3, long j16) {
        notifyProgress(j3, j16);
        DownloadItem downloadItem = this.mDownloadItem;
        if (downloadItem != null) {
            downloadItem.updateTotalAndProgress(j3, j16);
        }
    }

    @Override // com.tencent.ams.dsdk.download.DownloadTask
    public boolean cancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        DLog.d(TAG, "cancel");
        synchronized (this.mStateLock) {
            if (this.mStatus != 2 && this.mStatus != 4 && this.mStatus != 3) {
                try {
                    updateAndDispatchStatus(2);
                } catch (Exception e16) {
                    DLog.e(TAG, "update cancel status error.", e16);
                }
                return true;
            }
            return false;
        }
    }

    @Override // com.tencent.ams.dsdk.download.DownloadTask
    public boolean isCancelled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (this.mStatus == 2) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ams.dsdk.download.DownloadTask
    public boolean isCompleted() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.mStatus == 3) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ams.dsdk.download.DownloadTask
    public boolean isDownloading() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this.mStatus == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ams.dsdk.download.DownloadTask
    public boolean isFailed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (this.mStatus == 4) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        handleDownload();
        DLog.d(TAG, "run finish. cost: " + (System.currentTimeMillis() - currentTimeMillis) + ", thread: " + Thread.currentThread());
    }

    private boolean checkFileMd5(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return checkFileMd5(new File(str));
    }

    private void updateAndDispatchStatus(@Status int i3) throws DownloadException.CancelledException {
        updateAndDispatchStatus(i3, null);
    }

    public DownloadTaskImpl(DownloadItem downloadItem, DownloadTask.OnDownloadListener onDownloadListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadItem, (Object) onDownloadListener);
            return;
        }
        this.mDownloadListener = null;
        this.mTargetFile = null;
        this.mTempFile = null;
        this.mDownloadItem = null;
        this.mCurrentRetryCount = 0;
        this.mMaxRetryCount = 3;
        this.mCurrentRedirectCount = 0;
        this.m416RetryCount = 0;
        this.mStateLock = new byte[0];
        this.mStatus = 0;
        this.mDownloadItem = downloadItem;
        this.mDownloadListener = onDownloadListener;
    }
}
