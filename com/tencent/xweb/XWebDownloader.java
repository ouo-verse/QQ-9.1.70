package com.tencent.xweb;

import android.os.AsyncTask;
import android.os.SystemClock;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.ar.z;
import com.tencent.luggage.wxa.yq.f;
import com.tencent.xweb.downloader.IFileDownloaderProxyCallback;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes27.dex */
public class XWebDownloader {

    /* renamed from: a, reason: collision with root package name */
    public static AsyncTask f385028a;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class DownloadInfo {
        public int mErrorType = 0;
        public int mErrorCode = 0;
        public int mDownloadType = 1;
        public String mUrl = "";
        public String mSavePath = "";
        public long mStartTimestamp = 0;
        public int mNetWorkType = 0;
        public boolean mIsDownloadResume = false;
        public long mFileTotalSize = 0;
        public boolean mIsRuntime = false;
        public int mBizType = 0;
        public int mRetryTimes = 0;
    }

    public static void b(String str, DownloadInfo downloadInfo, AsyncTask asyncTask) {
        if (downloadInfo.mIsRuntime) {
            f385028a = asyncTask;
            x0.d(str, "runtime onPreExecute, savePath:" + downloadInfo.mSavePath);
            return;
        }
        x0.d(str, "plugin onPreExecute, savePath:" + downloadInfo.mSavePath);
    }

    public static boolean isDownloading() {
        return f385028a instanceof HttpDownloadTask;
    }

    public static void startDownload(XWebDownloadListener xWebDownloadListener, f fVar) {
        WXFileDownloaderTask wXFileDownloaderTask = new WXFileDownloaderTask(true, xWebDownloadListener, fVar.f146072g, fVar.b(), fVar.d());
        if (fVar.f146075j && wXFileDownloaderTask.isValid()) {
            x0.d("XWebDownloader", "startDownload, use wx file downloader");
            wXFileDownloaderTask.execute(new Void[0]);
        } else {
            x0.d("XWebDownloader", "startDownload, use default file downloader");
            new HttpDownloadTask(true, xWebDownloadListener, fVar.f146072g, fVar.b()).execute(new Void[0]);
        }
    }

    public static void b(XWebDownloadListener xWebDownloadListener, Integer... numArr) {
        int intValue = numArr[1].intValue() > 0 ? (int) ((numArr[0].intValue() * 100.0d) / numArr[1].intValue()) : 0;
        if (xWebDownloadListener != null) {
            xWebDownloadListener.onDownloadUpdated(intValue);
        }
    }

    public static void b(DownloadInfo downloadInfo, XWebDownloadListener xWebDownloadListener, String str) {
        if (downloadInfo.mIsRuntime) {
            f385028a = null;
            x0.d(str, "runtime onCancelled");
        } else {
            x0.d(str, "plugin onCancelled");
        }
        if (xWebDownloadListener != null) {
            xWebDownloadListener.onDownloadCancelled();
        }
    }

    public static void b(DownloadInfo downloadInfo, XWebDownloadListener xWebDownloadListener, String str, Integer num) {
        if (downloadInfo.mIsRuntime) {
            f385028a = null;
            x0.d(str, "runtime onPostExecute result:" + num);
        } else {
            x0.d(str, "plugin onPostExecute result:" + num);
        }
        if (num.intValue() == 0) {
            if (xWebDownloadListener != null) {
                xWebDownloadListener.onDownloadCompleted(downloadInfo);
            }
        } else if (xWebDownloadListener != null) {
            xWebDownloadListener.onDownloadFailed(downloadInfo);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class WXFileDownloaderTask extends AsyncTask<Void, Integer, Integer> implements IFileDownloaderProxyCallback {
        public static final String TAG_TASK = "WXFileDownloaderTask";

        /* renamed from: a, reason: collision with root package name */
        public final XWebDownloadListener f385033a;

        /* renamed from: b, reason: collision with root package name */
        public final DownloadInfo f385034b;

        /* renamed from: c, reason: collision with root package name */
        public final com.tencent.luggage.wxa.rq.a f385035c;

        /* renamed from: d, reason: collision with root package name */
        public final Object f385036d = new Object();

        /* renamed from: e, reason: collision with root package name */
        public boolean f385037e = false;

        public WXFileDownloaderTask(boolean z16, XWebDownloadListener xWebDownloadListener, String str, String str2, int i3) {
            this.f385033a = xWebDownloadListener;
            DownloadInfo downloadInfo = new DownloadInfo();
            this.f385034b = downloadInfo;
            downloadInfo.mErrorType = 0;
            downloadInfo.mErrorCode = 0;
            downloadInfo.mDownloadType = 2;
            downloadInfo.mUrl = str;
            downloadInfo.mSavePath = str2;
            downloadInfo.mIsRuntime = z16;
            downloadInfo.mBizType = i3;
            com.tencent.luggage.wxa.rq.a aVar = new com.tencent.luggage.wxa.rq.a();
            this.f385035c = aVar;
            aVar.a(this);
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer doInBackground(Void... voidArr) {
            XWebDownloadListener xWebDownloadListener = this.f385033a;
            if (xWebDownloadListener != null) {
                xWebDownloadListener.onDownloadStarted(this.f385034b.mDownloadType);
            }
            this.f385034b.mStartTimestamp = System.currentTimeMillis();
            this.f385034b.mNetWorkType = z.a(XWalkEnvironment.getApplicationContext());
            com.tencent.luggage.wxa.rq.a aVar = this.f385035c;
            if (aVar != null && aVar.a()) {
                com.tencent.luggage.wxa.rq.a aVar2 = this.f385035c;
                DownloadInfo downloadInfo = this.f385034b;
                if (aVar2.a(downloadInfo.mUrl, downloadInfo.mSavePath, downloadInfo.mBizType) != 0) {
                    DownloadInfo downloadInfo2 = this.f385034b;
                    downloadInfo2.mErrorType = 1;
                    downloadInfo2.mErrorCode = -1;
                    return -1;
                }
                synchronized (this.f385036d) {
                    try {
                        this.f385037e = true;
                        this.f385036d.wait(600000L);
                    } catch (InterruptedException e16) {
                        x0.a(TAG_TASK, "download error", e16);
                        this.f385037e = false;
                        DownloadInfo downloadInfo3 = this.f385034b;
                        downloadInfo3.mErrorType = 2;
                        downloadInfo3.mErrorCode = -101;
                    }
                    if (this.f385037e) {
                        DownloadInfo downloadInfo4 = this.f385034b;
                        downloadInfo4.mErrorType = 1;
                        downloadInfo4.mErrorCode = -100;
                    }
                    DownloadInfo downloadInfo5 = this.f385034b;
                    if (downloadInfo5.mErrorType == 0 && downloadInfo5.mErrorCode == 0) {
                        return 0;
                    }
                    x0.c(TAG_TASK, "download errorType:" + this.f385034b.mErrorType + ", errorcode:" + this.f385034b.mErrorCode + ", waitTimeout:" + this.f385037e);
                    return -1;
                }
            }
            DownloadInfo downloadInfo6 = this.f385034b;
            downloadInfo6.mErrorType = 2;
            downloadInfo6.mErrorCode = -1;
            return -1;
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Integer num) {
            XWebDownloader.b(this.f385034b, this.f385033a, TAG_TASK, num);
        }

        public boolean isValid() {
            com.tencent.luggage.wxa.rq.a aVar = this.f385035c;
            if (aVar == null) {
                return false;
            }
            return aVar.a();
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            XWebDownloader.b(TAG_TASK, this.f385034b, this);
        }

        @Override // com.tencent.xweb.downloader.IFileDownloaderProxyCallback
        public void onTaskFailed(String str, int i3, boolean z16) {
            synchronized (this.f385036d) {
                DownloadInfo downloadInfo = this.f385034b;
                downloadInfo.mErrorType = 1;
                downloadInfo.mErrorCode = i3;
                downloadInfo.mIsDownloadResume = z16;
                this.f385037e = false;
                this.f385036d.notify();
            }
        }

        @Override // com.tencent.xweb.downloader.IFileDownloaderProxyCallback
        public void onTaskFinished(String str, String str2, boolean z16) {
            synchronized (this.f385036d) {
                this.f385034b.mIsDownloadResume = z16;
                this.f385037e = false;
                this.f385036d.notify();
            }
        }

        @Override // com.tencent.xweb.downloader.IFileDownloaderProxyCallback
        public void onTaskProgressChanged(String str, long j3, long j16) {
            DownloadInfo downloadInfo = this.f385034b;
            if (downloadInfo.mFileTotalSize != j16) {
                downloadInfo.mFileTotalSize = j16;
            }
            publishProgress(Integer.valueOf((int) j3), Integer.valueOf((int) j16));
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(Integer... numArr) {
            XWebDownloader.b(this.f385033a, numArr);
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onCancelled(Integer num) {
            XWebDownloader.b(this.f385034b, this.f385033a, TAG_TASK);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class HttpDownloadTask extends AsyncTask<Void, Integer, Integer> {
        public static final String TAG_TASK = "HttpDownloadTask";

        /* renamed from: a, reason: collision with root package name */
        public final DownloadInfo f385029a;

        /* renamed from: b, reason: collision with root package name */
        public final XWebDownloadListener f385030b;

        /* renamed from: c, reason: collision with root package name */
        public final File f385031c;

        /* renamed from: d, reason: collision with root package name */
        public long f385032d;

        public HttpDownloadTask(boolean z16, XWebDownloadListener xWebDownloadListener, String str, String str2) {
            this.f385030b = xWebDownloadListener;
            DownloadInfo downloadInfo = new DownloadInfo();
            this.f385029a = downloadInfo;
            downloadInfo.mErrorType = 0;
            downloadInfo.mErrorCode = 0;
            downloadInfo.mDownloadType = 1;
            downloadInfo.mUrl = str;
            downloadInfo.mSavePath = str2;
            downloadInfo.mIsRuntime = z16;
            this.f385031c = new File(downloadInfo.mSavePath);
        }

        /* JADX WARN: Code restructure failed: missing block: B:101:0x019d, code lost:
        
            r7.close();
            r5.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:0x015a, code lost:
        
            r0 = java.lang.Integer.valueOf(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x015e, code lost:
        
            r7.close();
            r5.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x0199, code lost:
        
            r8 = r4;
            r7.flush();
         */
        /* JADX WARN: Removed duplicated region for block: B:67:0x01dd A[Catch: IOException -> 0x01e0, TRY_LEAVE, TryCatch #9 {IOException -> 0x01e0, blocks: (B:74:0x01d8, B:67:0x01dd), top: B:73:0x01d8 }] */
        /* JADX WARN: Removed duplicated region for block: B:71:0x01e2  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x01d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:83:0x01f3 A[DONT_GENERATE, FINALLY_INSNS] */
        /* JADX WARN: Removed duplicated region for block: B:85:? A[DONT_GENERATE, FINALLY_INSNS, SYNTHETIC] */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Integer doInBackground(Void... voidArr) {
            HttpURLConnection httpURLConnection;
            InputStream inputStream;
            FileOutputStream fileOutputStream;
            URL url;
            long j3;
            FileOutputStream fileOutputStream2;
            HttpURLConnection httpURLConnection2;
            byte[] bArr;
            Integer valueOf;
            XWebDownloadListener xWebDownloadListener = this.f385030b;
            if (xWebDownloadListener != null) {
                xWebDownloadListener.onDownloadStarted(this.f385029a.mDownloadType);
            }
            this.f385029a.mStartTimestamp = System.currentTimeMillis();
            this.f385029a.mNetWorkType = z.a(XWalkEnvironment.getApplicationContext());
            int i3 = -1;
            try {
                url = new URL(this.f385029a.mUrl);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                try {
                    httpURLConnection.setConnectTimeout(30000);
                    httpURLConnection.setReadTimeout(30000);
                    httpURLConnection.connect();
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (Throwable th6) {
                th = th6;
                httpURLConnection = null;
            }
            if (httpURLConnection.getResponseCode() != 200 && httpURLConnection.getResponseCode() != 206) {
                x0.c(TAG_TASK, "Server returned HTTP " + httpURLConnection.getResponseCode() + " " + httpURLConnection.getResponseMessage());
                httpURLConnection.disconnect();
                return -1;
            }
            int contentLength = httpURLConnection.getContentLength();
            long j16 = 0;
            if (this.f385031c.exists()) {
                j3 = this.f385031c.length();
                if (contentLength == j3) {
                    x0.d(TAG_TASK, "same size in server, return success");
                    httpURLConnection.disconnect();
                    return 0;
                }
                if (j3 > 0) {
                    this.f385029a.mIsDownloadResume = true;
                    x0.d(TAG_TASK, "http download resume");
                }
                httpURLConnection.disconnect();
                HttpURLConnection httpURLConnection3 = (HttpURLConnection) url.openConnection();
                try {
                    httpURLConnection3.setConnectTimeout(30000);
                    httpURLConnection3.setReadTimeout(30000);
                    httpURLConnection3.setRequestProperty("Range", "bytes=" + j3 + "-");
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("download range begin:");
                    sb5.append(j3);
                    x0.d(TAG_TASK, sb5.toString());
                    httpURLConnection3.connect();
                    if (httpURLConnection3.getResponseCode() != 200 && httpURLConnection3.getResponseCode() != 206) {
                        x0.c(TAG_TASK, "Server returned HTTP " + httpURLConnection3.getResponseCode() + " " + httpURLConnection3.getResponseMessage());
                        httpURLConnection3.disconnect();
                        return -1;
                    }
                    contentLength = httpURLConnection3.getContentLength();
                    httpURLConnection = httpURLConnection3;
                } catch (Throwable th7) {
                    th = th7;
                    httpURLConnection = httpURLConnection3;
                    inputStream = null;
                    fileOutputStream = null;
                    try {
                        x0.a("XWebDownloader", "download error", th);
                        if (fileOutputStream != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        return -1;
                    } finally {
                    }
                }
            } else {
                j3 = 0;
            }
            try {
                inputStream = httpURLConnection.getInputStream();
            } catch (Throwable th8) {
                th = th8;
                inputStream = null;
                fileOutputStream = null;
                x0.a("XWebDownloader", "download error", th);
                if (fileOutputStream != null) {
                }
                if (inputStream != null) {
                }
                if (httpURLConnection != null) {
                }
                return -1;
            }
            try {
                fileOutputStream2 = new FileOutputStream(this.f385031c, true);
                try {
                    bArr = new byte[4096];
                } catch (Throwable th9) {
                    th = th9;
                    httpURLConnection2 = httpURLConnection;
                }
            } catch (Throwable th10) {
                th = th10;
                fileOutputStream = null;
                x0.a("XWebDownloader", "download error", th);
                if (fileOutputStream != null) {
                }
                if (inputStream != null) {
                }
                if (httpURLConnection != null) {
                }
                return -1;
            }
            while (true) {
                int read = inputStream.read(bArr);
                if (read == i3) {
                    break;
                }
                if (isCancelled()) {
                    break;
                }
                j16 += read;
                fileOutputStream2.write(bArr, 0, read);
                long uptimeMillis = SystemClock.uptimeMillis();
                httpURLConnection2 = httpURLConnection;
                try {
                    if (uptimeMillis - this.f385032d > 500) {
                        this.f385032d = uptimeMillis;
                        publishProgress(Integer.valueOf((int) (j16 + j3)), Integer.valueOf((int) (contentLength + j3)));
                    }
                    httpURLConnection = httpURLConnection2;
                    i3 = -1;
                } catch (Throwable th11) {
                    th = th11;
                }
                th = th11;
                fileOutputStream = fileOutputStream2;
                httpURLConnection = httpURLConnection2;
                x0.a("XWebDownloader", "download error", th);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return -1;
            }
            httpURLConnection2.disconnect();
            this.f385029a.mFileTotalSize = this.f385031c.length();
            return 0;
            httpURLConnection.disconnect();
            return valueOf;
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Integer num) {
            if (num.intValue() == 0) {
                this.f385029a.mErrorCode = 0;
            } else {
                this.f385029a.mErrorCode = -1;
            }
            XWebDownloader.b(this.f385029a, this.f385030b, TAG_TASK, num);
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            XWebDownloader.b(TAG_TASK, this.f385029a, this);
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(Integer... numArr) {
            XWebDownloader.b(this.f385030b, numArr);
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onCancelled(Integer num) {
            XWebDownloader.b(this.f385029a, this.f385030b, TAG_TASK);
        }
    }
}
