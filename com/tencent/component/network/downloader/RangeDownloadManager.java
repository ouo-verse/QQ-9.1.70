package com.tencent.component.network.downloader;

import android.net.http.Headers;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.httpcore.HttpHeaders;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RangeDownloadManager {
    private static final int DEFAULT_RANGE_NUMBER = 4;
    private static final int MAX_THREAD_NUM_LIMIT = 4;
    private long contentLength;
    private long durationMillisForHeadPhase;
    private long durationMillisForRangeReceivePhase;
    private final int numberOfRangeTasks;
    private final OkHttpClient okHttpClient;
    private ProgressHandler progressHandler;
    private List<RangeDownloadCallable> allRangeRequests = new ArrayList();
    private List<RangeDownloadReport> rangeDownloadReports = new ArrayList();
    private long totalFileSize = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class ProgressHandler extends Handler {
        private long contentLength;
        private WeakReference<ProgressListener> progressListenerWeakReference;
        private long totalByteReceive;

        public ProgressHandler(Looper looper, ProgressListener progressListener, long j3) {
            super(looper);
            this.contentLength = 0L;
            this.totalByteReceive = 0L;
            this.progressListenerWeakReference = new WeakReference<>(progressListener);
            this.contentLength = j3;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int intValue = ((Integer) message.obj).intValue();
            if (intValue > 0 && this.contentLength > 0) {
                this.totalByteReceive += intValue;
                WeakReference<ProgressListener> weakReference = this.progressListenerWeakReference;
                if (weakReference != null && weakReference.get() != null) {
                    this.progressListenerWeakReference.get().onReceive((((float) this.totalByteReceive) * 1.0f) / ((float) this.contentLength));
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface ProgressListener {
        void onReceive(float f16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class RangeDownloadCallable implements Callable<RangeDownloadResult> {
        private long contentLength;
        private final int index;
        private final OkHttpClient okHttpClient;
        private ProgressHandler progressHandler;
        private final Request request;
        private String savePath;
        private final long startPos;

        RangeDownloadCallable(OkHttpClient okHttpClient, Request request, String str, long j3, long j16, int i3, ProgressHandler progressHandler) {
            this.okHttpClient = okHttpClient;
            this.request = request;
            this.savePath = str;
            this.index = i3;
            this.startPos = j3;
            this.contentLength = j16;
            this.progressHandler = progressHandler;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public RangeDownloadResult call() throws Exception {
            Response response;
            long j3;
            RangeDownloadReport rangeDownloadReport;
            long j16;
            long j17;
            RandomAccessFile randomAccessFile;
            Throwable th5;
            InputStream byteStream;
            Throwable th6;
            byte[] bArr;
            int i3;
            long j18;
            int i16;
            long currentTimeMillis = System.currentTimeMillis();
            RangeDownloadReport rangeDownloadReport2 = new RangeDownloadReport();
            Response execute = this.okHttpClient.newCall(this.request).execute();
            long currentTimeMillis2 = System.currentTimeMillis();
            long j19 = currentTimeMillis2 - currentTimeMillis;
            rangeDownloadReport2.setTimeCostHeader(j19);
            if (execute != null && execute.isSuccessful() && execute.body() != null) {
                String header = execute.header(Headers.CONTENT_LEN);
                if (!TextUtils.isEmpty(header)) {
                    this.contentLength = Long.parseLong(header);
                }
                try {
                    randomAccessFile = new RandomAccessFile(this.savePath, "rw");
                    try {
                        byteStream = execute.body().byteStream();
                        try {
                            bArr = new byte[8192];
                            i3 = 0;
                            j18 = 0;
                            i16 = 0;
                        } catch (Throwable th7) {
                            response = execute;
                            j3 = j19;
                            rangeDownloadReport = rangeDownloadReport2;
                            th6 = th7;
                            j16 = 0;
                        }
                        while (true) {
                            try {
                                int read = byteStream.read(bArr, i3, 8192 - i3);
                                response = execute;
                                if (read == -1) {
                                    break;
                                }
                                i3 += read;
                                if (i3 < 8192) {
                                    j3 = j19;
                                    rangeDownloadReport = rangeDownloadReport2;
                                    try {
                                        if (j18 + i3 < this.contentLength) {
                                            rangeDownloadReport2 = rangeDownloadReport;
                                            execute = response;
                                            j19 = j3;
                                        }
                                    } catch (Throwable th8) {
                                        th = th8;
                                    }
                                } else {
                                    j3 = j19;
                                    rangeDownloadReport = rangeDownloadReport2;
                                }
                                randomAccessFile.seek(this.startPos + j18);
                                randomAccessFile.write(bArr, 0, i3);
                                j18 += i3;
                                i16++;
                                if (this.progressHandler != null) {
                                    Message obtain = Message.obtain();
                                    obtain.obj = Integer.valueOf(i3);
                                    this.progressHandler.sendMessage(obtain);
                                }
                                i3 = 0;
                                rangeDownloadReport2 = rangeDownloadReport;
                                execute = response;
                                j19 = j3;
                                th = th8;
                            } catch (Throwable th9) {
                                th = th9;
                                response = execute;
                                j3 = j19;
                                rangeDownloadReport = rangeDownloadReport2;
                            }
                            th6 = th;
                            j16 = j18;
                            if (byteStream == null) {
                                throw th6;
                            }
                            try {
                                try {
                                    byteStream.close();
                                    throw th6;
                                } catch (Throwable th10) {
                                    th5 = th10;
                                    try {
                                        try {
                                            randomAccessFile.close();
                                            throw th5;
                                        } catch (Exception e16) {
                                            e = e16;
                                            QDLog.i(QDLog.TAG_DOWNLOAD_RANGE, "range exception is " + e);
                                            j17 = j16;
                                            long currentTimeMillis3 = System.currentTimeMillis();
                                            long j26 = currentTimeMillis3 - currentTimeMillis2;
                                            long j27 = currentTimeMillis3 - currentTimeMillis;
                                            RangeDownloadReport rangeDownloadReport3 = rangeDownloadReport;
                                            rangeDownloadReport3.setTimeCostData(j26);
                                            rangeDownloadReport3.setTimeCost(j27);
                                            rangeDownloadReport3.setRangeId(this.index);
                                            rangeDownloadReport3.setContentLength(j17);
                                            QDLog.e(QDLog.TAG_DOWNLOAD_RANGE, "range task id:" + this.index + " header costTime:" + j3 + ", data costtime:" + j26 + ", totalCostTime:" + j27 + ", byte count:" + j17);
                                            return new RangeDownloadResult(this.index, response, j17, rangeDownloadReport3);
                                        }
                                    } catch (Throwable th11) {
                                        th5.addSuppressed(th11);
                                        throw th5;
                                    }
                                }
                            } catch (Throwable th12) {
                                th6.addSuppressed(th12);
                                throw th6;
                            }
                        }
                        j3 = j19;
                        rangeDownloadReport = rangeDownloadReport2;
                        QDLog.d(QDLog.TAG_DOWNLOAD_RANGE, "range task id:" + this.index + ", round:" + i16);
                    } catch (Throwable th13) {
                        response = execute;
                        j3 = j19;
                        rangeDownloadReport = rangeDownloadReport2;
                        th5 = th13;
                        j16 = 0;
                    }
                } catch (Exception e17) {
                    e = e17;
                    response = execute;
                    j3 = j19;
                    rangeDownloadReport = rangeDownloadReport2;
                    j16 = 0;
                }
                try {
                    byteStream.close();
                    try {
                        randomAccessFile.close();
                        j17 = j18;
                    } catch (Exception e18) {
                        e = e18;
                        j16 = j18;
                        QDLog.i(QDLog.TAG_DOWNLOAD_RANGE, "range exception is " + e);
                        j17 = j16;
                        long currentTimeMillis32 = System.currentTimeMillis();
                        long j262 = currentTimeMillis32 - currentTimeMillis2;
                        long j272 = currentTimeMillis32 - currentTimeMillis;
                        RangeDownloadReport rangeDownloadReport32 = rangeDownloadReport;
                        rangeDownloadReport32.setTimeCostData(j262);
                        rangeDownloadReport32.setTimeCost(j272);
                        rangeDownloadReport32.setRangeId(this.index);
                        rangeDownloadReport32.setContentLength(j17);
                        QDLog.e(QDLog.TAG_DOWNLOAD_RANGE, "range task id:" + this.index + " header costTime:" + j3 + ", data costtime:" + j262 + ", totalCostTime:" + j272 + ", byte count:" + j17);
                        return new RangeDownloadResult(this.index, response, j17, rangeDownloadReport32);
                    }
                    long currentTimeMillis322 = System.currentTimeMillis();
                    long j2622 = currentTimeMillis322 - currentTimeMillis2;
                    long j2722 = currentTimeMillis322 - currentTimeMillis;
                    RangeDownloadReport rangeDownloadReport322 = rangeDownloadReport;
                    rangeDownloadReport322.setTimeCostData(j2622);
                    rangeDownloadReport322.setTimeCost(j2722);
                    rangeDownloadReport322.setRangeId(this.index);
                    rangeDownloadReport322.setContentLength(j17);
                    QDLog.e(QDLog.TAG_DOWNLOAD_RANGE, "range task id:" + this.index + " header costTime:" + j3 + ", data costtime:" + j2622 + ", totalCostTime:" + j2722 + ", byte count:" + j17);
                    return new RangeDownloadResult(this.index, response, j17, rangeDownloadReport322);
                } catch (Throwable th14) {
                    th5 = th14;
                    j16 = j18;
                    randomAccessFile.close();
                    throw th5;
                }
            }
            throw new Exception(execute != null ? execute.message() : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class RangeDownloadResult {
        private final int index;
        private final RangeDownloadReport rangeDownloadReport;
        private final Response response;
        private final long responseDataLength;

        RangeDownloadResult(int i3, Response response, long j3, RangeDownloadReport rangeDownloadReport) {
            this.index = i3;
            this.response = response;
            this.responseDataLength = j3;
            this.rangeDownloadReport = rangeDownloadReport;
        }

        public int getIndex() {
            return this.index;
        }

        public RangeDownloadReport getRangeDownloadReport() {
            return this.rangeDownloadReport;
        }

        public Response getResponse() {
            return this.response;
        }

        public long getResponseDataLength() {
            return this.responseDataLength;
        }
    }

    public RangeDownloadManager(OkHttpClient okHttpClient, int i3) {
        this.okHttpClient = okHttpClient;
        this.numberOfRangeTasks = i3 <= 0 ? 4 : i3;
    }

    private Response buildResponse(List<RangeDownloadResult> list) {
        Request request = null;
        if (list == null) {
            return null;
        }
        this.totalFileSize = 0L;
        Protocol protocol2 = null;
        String str = null;
        Response response = null;
        for (RangeDownloadResult rangeDownloadResult : list) {
            if (rangeDownloadResult != null) {
                this.rangeDownloadReports.add(rangeDownloadResult.getRangeDownloadReport());
                if (rangeDownloadResult.response != null) {
                    if (rangeDownloadResult.response.request() != null) {
                        request = rangeDownloadResult.response.request();
                    }
                    if (rangeDownloadResult.response.protocol() != null) {
                        protocol2 = rangeDownloadResult.response.protocol();
                    }
                    if (rangeDownloadResult.response.message() != null) {
                        str = rangeDownloadResult.response.message();
                    }
                    if (rangeDownloadResult.response.priorResponse() != null) {
                        response = rangeDownloadResult.response.priorResponse();
                    }
                    if (rangeDownloadResult.responseDataLength > 0) {
                        this.totalFileSize += rangeDownloadResult.responseDataLength;
                    }
                }
            }
        }
        return new Response.Builder().request(request).protocol(protocol2).message(str).priorResponse(response).code(200).build();
    }

    private List<RangeDownloadResult> executeAsync() throws Exception {
        ArrayList arrayList = new ArrayList();
        int i3 = this.numberOfRangeTasks;
        if (i3 > 4) {
            i3 = 4;
        }
        ExecutorService newFixedThreadPool = ProxyExecutors.newFixedThreadPool(i3);
        for (Future future : newFixedThreadPool.invokeAll(this.allRangeRequests)) {
            if (future != null) {
                arrayList.add((RangeDownloadResult) future.get());
            }
        }
        newFixedThreadPool.shutdown();
        newFixedThreadPool.awaitTermination(1L, TimeUnit.SECONDS);
        return arrayList;
    }

    private List<RangeDownloadResult> executeSingle() throws Exception {
        if (this.allRangeRequests.size() > 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.allRangeRequests.get(0).call());
            return arrayList;
        }
        return null;
    }

    private long getContentLength(Request.Builder builder, String str) {
        long contentLength = getContentLength();
        if (contentLength <= 0) {
            long currentTimeMillis = System.currentTimeMillis();
            Response requestHeader = requestHeader(builder, str);
            if (requestHeader != null && requestHeader.isSuccessful()) {
                String header = requestHeader.header(HttpHeaders.ACCEPT_RANGES, null);
                if (!TextUtils.isEmpty(header) && !header.equalsIgnoreCase("none")) {
                    long parseLong = Long.parseLong(requestHeader.header("Content-Length", "0"));
                    setContentLength(parseLong);
                    contentLength = parseLong;
                }
            }
            QDLog.i(QDLog.TAG_DOWNLOAD_RANGE, "getContentLength header costTime:" + (System.currentTimeMillis() - currentTimeMillis) + ", contentLength:" + contentLength + ", rangeTaskNum:" + this.numberOfRangeTasks);
        }
        return contentLength;
    }

    private ProgressHandler getProgressHandler(ProgressListener progressListener, long j3) {
        if (this.progressHandler == null) {
            this.progressHandler = new ProgressHandler(GlobalHandlerThread.getInstance(null).getLooper(), progressListener, j3);
        }
        return this.progressHandler;
    }

    private Request getRequest(Request.Builder builder, String str, long j3, long j16) {
        Object valueOf;
        Request.Builder url = builder.get().url(str);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("bytes=");
        sb5.append(j3);
        sb5.append('-');
        if (j16 == -1) {
            valueOf = "";
        } else {
            valueOf = Long.valueOf(j16);
        }
        sb5.append(valueOf);
        url.header("Range", sb5.toString());
        url.header("Connection", "keep-alive");
        return url.build();
    }

    private Response requestHeader(Request.Builder builder, String str) {
        try {
            return this.okHttpClient.newCall(builder.url(str).header("Connection", "keep-alive").head().build()).execute();
        } catch (IOException e16) {
            QDLog.e(QDLog.TAG_DOWNLOAD_RANGE, "requestHeader exception", e16);
            return null;
        }
    }

    public boolean createEmptyFile(String str) {
        long uptimeMillis = SystemClock.uptimeMillis();
        long contentLength = getContentLength();
        if (contentLength <= 0) {
            return false;
        }
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.setLength(contentLength);
            randomAccessFile.close();
            QDLog.e(QDLog.TAG_DOWNLOAD_RANGE, "createFileWithSize fileSize: " + file.length() + ", cost time: " + (SystemClock.uptimeMillis() - uptimeMillis));
            return true;
        } catch (Exception e16) {
            QDLog.e(QDLog.TAG_DOWNLOAD_RANGE, "createFileWithSize exception", e16);
            return false;
        }
    }

    public Response execute() throws Exception {
        List<RangeDownloadResult> list;
        long uptimeMillis = SystemClock.uptimeMillis();
        int i3 = this.numberOfRangeTasks;
        if (i3 == 1) {
            list = executeSingle();
        } else if (i3 > 1) {
            list = executeAsync();
        } else {
            list = null;
        }
        Response buildResponse = buildResponse(list);
        this.durationMillisForRangeReceivePhase = SystemClock.uptimeMillis() - uptimeMillis;
        return buildResponse;
    }

    public long getDurationMillisForHeadPhase() {
        return this.durationMillisForHeadPhase;
    }

    public long getDurationMillisForRangeReceivePhase() {
        return this.durationMillisForRangeReceivePhase;
    }

    public int getNumberOfRangeTasks() {
        return this.numberOfRangeTasks;
    }

    public List<RangeDownloadReport> getRangeDownloadReports() {
        return this.rangeDownloadReports;
    }

    public long getTotalFileSize() {
        return this.totalFileSize;
    }

    public void setContentLength(long j3) {
        this.contentLength = j3;
    }

    public boolean tryBuildAllRangeRequests(String str, String str2, Request.Builder builder, String str3, ProgressListener progressListener) {
        Request.Builder builder2;
        long j3;
        ProgressListener progressListener2;
        long j16;
        if (builder == null) {
            builder2 = new Request.Builder();
        } else {
            builder2 = builder;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long contentLength = getContentLength(builder2, str2);
        if (contentLength > 0) {
            long j17 = (contentLength / this.numberOfRangeTasks) + 1;
            int i3 = 0;
            while (i3 < this.numberOfRangeTasks) {
                long j18 = i3 * j17;
                long j19 = j18 + (j17 - 1);
                if (j19 >= contentLength) {
                    j3 = -1;
                } else {
                    j3 = j19;
                }
                List<RangeDownloadCallable> list = this.allRangeRequests;
                OkHttpClient okHttpClient = this.okHttpClient;
                int i16 = i3;
                Request request = getRequest(builder2, str, j18, j3);
                if (j3 == -1) {
                    j16 = contentLength - j18;
                    progressListener2 = progressListener;
                } else {
                    progressListener2 = progressListener;
                    j16 = (j3 - j18) + 1;
                }
                list.add(new RangeDownloadCallable(okHttpClient, request, str3, j18, j16, i16, getProgressHandler(progressListener2, contentLength)));
                i3 = i16 + 1;
            }
            this.durationMillisForHeadPhase = System.currentTimeMillis() - currentTimeMillis;
            return true;
        }
        QDLog.e(QDLog.TAG_DOWNLOAD_RANGE, "tryBuildAllRangeRequests fail, url:" + str + ", requestUrl:" + str2);
        return false;
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public void cancel() {
    }
}
