package com.tencent.qqmini.sdk.core.proxy.service;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;

@ProxyService(proxy = DownloaderProxy.class)
/* loaded from: classes23.dex */
public class DownloaderProxyDefault extends DownloaderProxy {
    public static final int ERR_ABORTED = -3;
    public static final int ERR_INVALID_URL = -1;
    public static final int ERR_IO_ISSUES = -2;
    public static final int ERR_UNKOWN = -100;
    public static final int ERR_UNREASONABLE_REDIRECT_COUNT = -4;
    private static final String TAG = "DefaultDownloader";
    private static AtomicInteger uniqueTaskID = new AtomicInteger(1);
    public ConcurrentHashMap<Integer, DownloadTask> taskMap = new ConcurrentHashMap<>();

    /* loaded from: classes23.dex */
    public class DownloadTask implements Runnable {
        public String mFilePath;
        public Map<String, String> mHeader;
        public DownloaderProxy.DownloadListener mListener;
        public int mTaskId;
        public int mTimeout;
        public String mUrl;
        private int redirectCount = 0;
        public volatile boolean mAbort = false;

        public DownloadTask(int i3, String str, Map<String, String> map, String str2, int i16, DownloaderProxy.DownloadListener downloadListener) {
            this.mTaskId = i3;
            this.mUrl = str;
            this.mHeader = map;
            this.mFilePath = str2;
            this.mTimeout = i16;
            this.mListener = downloadListener;
        }

        private void doDownloadTask(File file) {
            InputStream inputStream;
            try {
                HttpURLConnection realConnection = getRealConnection(this.mUrl);
                if (realConnection == null) {
                    return;
                }
                int responseCode = realConnection.getResponseCode();
                if (responseCode >= 200 && responseCode < 300) {
                    PositionFixedInputStream positionFixedInputStream = new PositionFixedInputStream(realConnection.getInputStream());
                    this.mListener.onDownloadHeadersReceived(responseCode, realConnection.getHeaderFields());
                    String contentEncoding = realConnection.getContentEncoding();
                    if (!TextUtils.isEmpty(contentEncoding) && contentEncoding.contains("gzip")) {
                        inputStream = new GZIPInputStream(positionFixedInputStream);
                    } else {
                        inputStream = positionFixedInputStream;
                    }
                    int contentLength = realConnection.getContentLength();
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read != -1) {
                            if (this.mAbort) {
                                inputStream.close();
                                fileOutputStream.close();
                                return;
                            } else {
                                fileOutputStream.write(bArr, 0, read);
                                if (contentLength != -1) {
                                    this.mListener.onDownloadProgress((positionFixedInputStream.getPosition() * 1.0f) / contentLength, positionFixedInputStream.getPosition(), contentLength);
                                } else {
                                    this.mListener.onDownloadProgress(0.0f, positionFixedInputStream.getPosition(), 0L);
                                }
                            }
                        } else {
                            inputStream.close();
                            fileOutputStream.close();
                            realConnection.disconnect();
                            DownloaderProxyDefault.this.taskMap.remove(Integer.valueOf(this.mTaskId));
                            this.mListener.onDownloadSucceed(responseCode, this.mFilePath, new DownloaderProxy.DownloadListener.DownloadResult("", 200L, true, "", true, 0L, 0L, 0L, 0L, 0L, 0L, realConnection.getHeaderFields()));
                            return;
                        }
                    }
                } else {
                    throw new DownloadException(responseCode, "http server code indicates err status");
                }
            } catch (DownloadException e16) {
                DownloaderProxyDefault.this.taskMap.remove(Integer.valueOf(this.mTaskId));
                this.mListener.onDownloadFailed(e16.getCode(), e16.getMessage());
            } catch (IOException e17) {
                QMLog.e("DefaultDownloader", "io err", e17);
                DownloaderProxyDefault.this.taskMap.remove(Integer.valueOf(this.mTaskId));
                this.mListener.onDownloadFailed(-2, e17.getMessage());
            }
        }

        private HttpURLConnection getRealConnection(String str) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
                httpURLConnection.setConnectTimeout(this.mTimeout * 1000);
                httpURLConnection.setRequestMethod("GET");
                Map<String, String> map = this.mHeader;
                if (map != null) {
                    for (String str2 : map.keySet()) {
                        httpURLConnection.setRequestProperty(str2, this.mHeader.get(str2));
                    }
                }
                int responseCode = httpURLConnection.getResponseCode();
                if (!this.mAbort) {
                    if (responseCode != 302 && responseCode != 301) {
                        return httpURLConnection;
                    }
                    this.redirectCount++;
                    httpURLConnection.disconnect();
                    if (this.redirectCount <= 30) {
                        return getRealConnection(httpURLConnection.getHeaderField("Location"));
                    }
                    QMLog.e("DefaultDownloader", "url: " + this.mUrl + "server redirects connection to many times");
                    throw new DownloadException(-4, "url: " + this.mUrl + "server redirects connection to many times");
                }
                QMLog.i("DefaultDownloader", this.mUrl + " aborted");
                throw new DownloadException(-3, "aborted by outside");
            } catch (MalformedURLException e16) {
                throw new DownloadException(-1, e16.getMessage());
            } catch (Throwable th5) {
                QMLog.e("DefaultDownloader", "unknown err", th5);
                throw new DownloadException(-100, th5.getMessage());
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            File file = new File(this.mFilePath);
            if (file.exists()) {
                file.delete();
            }
            try {
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
            doDownloadTask(file);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes23.dex */
        public class PositionFixedInputStream extends InputStream {
            private InputStream proxiedStream;
            private int position = 0;
            private int markPosition = -1;

            public PositionFixedInputStream(InputStream inputStream) {
                this.proxiedStream = inputStream;
            }

            @Override // java.io.InputStream
            public int available() throws IOException {
                return this.proxiedStream.available();
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                this.proxiedStream.close();
            }

            public int getPosition() {
                return this.position;
            }

            @Override // java.io.InputStream
            public synchronized void mark(int i3) {
                this.markPosition = i3;
                this.proxiedStream.mark(i3);
            }

            @Override // java.io.InputStream
            public boolean markSupported() {
                return this.proxiedStream.markSupported();
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                this.position++;
                return this.proxiedStream.read();
            }

            @Override // java.io.InputStream
            public synchronized void reset() throws IOException {
                this.position = this.markPosition;
                this.proxiedStream.reset();
            }

            @Override // java.io.InputStream
            public long skip(long j3) throws IOException {
                return this.proxiedStream.skip(j3);
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr) throws IOException {
                this.position += bArr.length;
                return this.proxiedStream.read(bArr);
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i3, int i16) throws IOException {
                this.position += i16;
                return this.proxiedStream.read(bArr, i3, i16);
            }
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy
    public void abort(String str) {
        DownloadTask downloadTask = null;
        for (DownloadTask downloadTask2 : this.taskMap.values()) {
            if (downloadTask2.mUrl.equals(str)) {
                downloadTask = downloadTask2;
            }
        }
        if (downloadTask != null) {
            downloadTask.mAbort = true;
            this.taskMap.remove(Integer.valueOf(downloadTask.mTaskId));
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy
    public boolean download(String str, Map<String, String> map, String str2, int i3, DownloaderProxy.DownloadListener downloadListener) {
        DownloadTask downloadTask = new DownloadTask(uniqueTaskID.getAndIncrement(), str, map, str2, i3, downloadListener);
        this.taskMap.put(Integer.valueOf(downloadTask.mTaskId), downloadTask);
        ThreadManager.executeOnNetworkIOThreadPool(downloadTask);
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy
    public void loadMiniGameSo(String str, DownloaderProxy.SoLoadListener soLoadListener) {
        soLoadListener.onFail(-1);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy
    public void preConnectDownloadHost() {
    }
}
