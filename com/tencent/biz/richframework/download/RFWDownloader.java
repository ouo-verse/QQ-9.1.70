package com.tencent.biz.richframework.download;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Consumer;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.file.FileType;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.biz.richframework.util.RFWIOUtil;
import com.tencent.biz.richframework.util.RFWSaveUtil;
import com.tencent.biz.richframework.util.RFWSdcardUtils;
import com.tencent.biz.richframework.util.RFWUrlUtils;
import com.tencent.biz.richframework.util.bean.RFWSaveMediaResultBean;
import com.tencent.richframework.thread.RFWThreadManager;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWDownloader {
    private static final String COS_MD5 = "X-COS-META-MD5";
    private static final int MAX_FILE_NAME_LENGTH = 251;
    private static final String TAG = "RFWDownloader";
    private static final String TMP_FILE_SUFFIX = ".tmp";
    private static volatile OkHttpClient sOkHttpClient;
    private final String mDownloadRootPath;
    private final RFWDownloadStrategy mDownloadStrategy;
    private final Set<String> mDownloadingUrlSet = Collections.synchronizedSet(new HashSet());
    private final ConcurrentHashMap<String, ConcurrentHashMap<Integer, WeakReference<RFWDownloadListener>>> mDownloadCenter = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Call> mCallMap = new ConcurrentHashMap<>();
    private final ReentrantLock mLock = new ReentrantLock();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.richframework.download.RFWDownloader$8, reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass8 extends EventListener {
        AnonymousClass8() {
        }

        @Override // okhttp3.EventListener
        public void callEnd(@NonNull final Call call) {
            super.callEnd(call);
            RFWDownloader.this.dispatchEventListener(new Consumer() { // from class: com.tencent.biz.richframework.download.g
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    ((RFWDownloader.RFWDownloadListener) obj).callEnd(Call.this);
                }
            });
        }

        @Override // okhttp3.EventListener
        public void callFailed(@NonNull final Call call, @NonNull final IOException iOException) {
            super.callFailed(call, iOException);
            RFWDownloader.this.dispatchEventListener(new Consumer() { // from class: com.tencent.biz.richframework.download.k
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    ((RFWDownloader.RFWDownloadListener) obj).callFailed(Call.this, iOException);
                }
            });
        }

        @Override // okhttp3.EventListener
        public void callStart(@NonNull final Call call) {
            super.callStart(call);
            RFWDownloader.this.dispatchEventListener(new Consumer() { // from class: com.tencent.biz.richframework.download.d
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    ((RFWDownloader.RFWDownloadListener) obj).callStart(Call.this);
                }
            });
        }

        @Override // okhttp3.EventListener
        public void connectEnd(@NonNull final Call call, @NonNull final InetSocketAddress inetSocketAddress, @NonNull final Proxy proxy, @Nullable final Protocol protocol2) {
            super.connectEnd(call, inetSocketAddress, proxy, protocol2);
            RFWDownloader.this.dispatchEventListener(new Consumer() { // from class: com.tencent.biz.richframework.download.s
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    ((RFWDownloader.RFWDownloadListener) obj).connectEnd(Call.this, inetSocketAddress, proxy, protocol2);
                }
            });
        }

        @Override // okhttp3.EventListener
        public void connectFailed(@NonNull final Call call, @NonNull final InetSocketAddress inetSocketAddress, @NonNull final Proxy proxy, @Nullable final Protocol protocol2, @NonNull final IOException iOException) {
            super.connectFailed(call, inetSocketAddress, proxy, protocol2, iOException);
            RFWDownloader.this.dispatchEventListener(new Consumer() { // from class: com.tencent.biz.richframework.download.p
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    ((RFWDownloader.RFWDownloadListener) obj).connectFailed(Call.this, inetSocketAddress, proxy, protocol2, iOException);
                }
            });
        }

        @Override // okhttp3.EventListener
        public void connectStart(@NonNull final Call call, @NonNull final InetSocketAddress inetSocketAddress, @NonNull final Proxy proxy) {
            super.connectStart(call, inetSocketAddress, proxy);
            RFWDownloader.this.dispatchEventListener(new Consumer() { // from class: com.tencent.biz.richframework.download.i
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    ((RFWDownloader.RFWDownloadListener) obj).connectStart(Call.this, inetSocketAddress, proxy);
                }
            });
        }

        @Override // okhttp3.EventListener
        public void connectionAcquired(@NonNull final Call call, @NonNull final Connection connection) {
            super.connectionAcquired(call, connection);
            RFWDownloader.this.dispatchEventListener(new Consumer() { // from class: com.tencent.biz.richframework.download.n
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    ((RFWDownloader.RFWDownloadListener) obj).connectionAcquired(Call.this, connection);
                }
            });
        }

        @Override // okhttp3.EventListener
        public void connectionReleased(@NonNull final Call call, @NonNull final Connection connection) {
            super.connectionReleased(call, connection);
            RFWDownloader.this.dispatchEventListener(new Consumer() { // from class: com.tencent.biz.richframework.download.f
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    ((RFWDownloader.RFWDownloadListener) obj).connectionReleased(Call.this, connection);
                }
            });
        }

        @Override // okhttp3.EventListener
        public void dnsEnd(@NonNull final Call call, @NonNull final String str, @NonNull final List<InetAddress> list) {
            super.dnsEnd(call, str, list);
            RFWDownloader.this.dispatchEventListener(new Consumer() { // from class: com.tencent.biz.richframework.download.c
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    ((RFWDownloader.RFWDownloadListener) obj).dnsEnd(Call.this, str, list);
                }
            });
        }

        @Override // okhttp3.EventListener
        public void dnsStart(@NonNull final Call call, @NonNull final String str) {
            super.dnsStart(call, str);
            RFWDownloader.this.dispatchEventListener(new Consumer() { // from class: com.tencent.biz.richframework.download.j
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    ((RFWDownloader.RFWDownloadListener) obj).dnsStart(Call.this, str);
                }
            });
        }

        @Override // okhttp3.EventListener
        public void requestBodyEnd(@NonNull final Call call, final long j3) {
            super.requestBodyEnd(call, j3);
            RFWDownloader.this.dispatchEventListener(new Consumer() { // from class: com.tencent.biz.richframework.download.l
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    ((RFWDownloader.RFWDownloadListener) obj).requestBodyEnd(Call.this, j3);
                }
            });
        }

        @Override // okhttp3.EventListener
        public void requestBodyStart(@NonNull final Call call) {
            super.requestBodyStart(call);
            RFWDownloader.this.dispatchEventListener(new Consumer() { // from class: com.tencent.biz.richframework.download.e
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    ((RFWDownloader.RFWDownloadListener) obj).requestBodyStart(Call.this);
                }
            });
        }

        @Override // okhttp3.EventListener
        public void requestHeadersEnd(@NonNull final Call call, @NonNull final Request request) {
            super.requestHeadersEnd(call, request);
            RFWDownloader.this.dispatchEventListener(new Consumer() { // from class: com.tencent.biz.richframework.download.o
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    ((RFWDownloader.RFWDownloadListener) obj).requestHeadersEnd(Call.this, request);
                }
            });
        }

        @Override // okhttp3.EventListener
        public void requestHeadersStart(@NonNull final Call call) {
            super.requestHeadersStart(call);
            RFWDownloader.this.dispatchEventListener(new Consumer() { // from class: com.tencent.biz.richframework.download.h
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    ((RFWDownloader.RFWDownloadListener) obj).requestHeadersStart(Call.this);
                }
            });
        }

        @Override // okhttp3.EventListener
        public void responseBodyEnd(@NonNull final Call call, final long j3) {
            super.responseBodyEnd(call, j3);
            RFWDownloader.this.dispatchEventListener(new Consumer() { // from class: com.tencent.biz.richframework.download.q
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    ((RFWDownloader.RFWDownloadListener) obj).responseBodyEnd(Call.this, j3);
                }
            });
        }

        @Override // okhttp3.EventListener
        public void responseBodyStart(@NonNull final Call call) {
            super.responseBodyStart(call);
            RFWDownloader.this.dispatchEventListener(new Consumer() { // from class: com.tencent.biz.richframework.download.u
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    ((RFWDownloader.RFWDownloadListener) obj).responseBodyStart(Call.this);
                }
            });
        }

        @Override // okhttp3.EventListener
        public void responseHeadersEnd(@NonNull final Call call, @NonNull final Response response) {
            super.responseHeadersEnd(call, response);
            RFWDownloader.this.dispatchEventListener(new Consumer() { // from class: com.tencent.biz.richframework.download.m
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    ((RFWDownloader.RFWDownloadListener) obj).responseHeadersEnd(Call.this, response);
                }
            });
        }

        @Override // okhttp3.EventListener
        public void responseHeadersStart(@NonNull final Call call) {
            super.responseHeadersStart(call);
            RFWDownloader.this.dispatchEventListener(new Consumer() { // from class: com.tencent.biz.richframework.download.a
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    ((RFWDownloader.RFWDownloadListener) obj).responseHeadersStart(Call.this);
                }
            });
        }

        @Override // okhttp3.EventListener
        public void secureConnectEnd(@NonNull final Call call, @Nullable final Handshake handshake) {
            super.secureConnectEnd(call, handshake);
            RFWDownloader.this.dispatchEventListener(new Consumer() { // from class: com.tencent.biz.richframework.download.b
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    ((RFWDownloader.RFWDownloadListener) obj).secureConnectEnd(Call.this, handshake);
                }
            });
        }

        @Override // okhttp3.EventListener
        public void secureConnectStart(@NonNull final Call call) {
            super.secureConnectStart(call);
            RFWDownloader.this.dispatchEventListener(new Consumer() { // from class: com.tencent.biz.richframework.download.t
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    ((RFWDownloader.RFWDownloadListener) obj).secureConnectStart(Call.this);
                }
            });
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface RFWDownloadListener extends RFWOkHttpEventListener {
        void onDownloadProgress(float f16, long j3, long j16);

        void onRspCallback(boolean z16, String str);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface RFWDownloadMediaListener {
        void onDownloadProgress(float f16, long j3, long j16);

        void onSaveCallback(boolean z16, int i3, String str);
    }

    public RFWDownloader(RFWDownloadStrategy rFWDownloadStrategy) {
        this.mDownloadStrategy = rFWDownloadStrategy;
        String downloadRootPath = rFWDownloadStrategy.getDownloadRootPath();
        this.mDownloadRootPath = downloadRootPath;
        if (rFWDownloadStrategy.allowGeneratedNoMedia()) {
            initNoMedia(downloadRootPath);
        }
    }

    public static boolean checkFileValid(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return false;
        }
        for (File file2 : listFiles) {
            if (file2.isFile()) {
                if (file2.length() > 0) {
                    return true;
                }
            } else if (checkFileValid(file2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkResource(final String str, final RFWCheckResourceListener rFWCheckResourceListener) {
        if (rFWCheckResourceListener == null) {
            RFWLog.e(TAG, RFWLog.USR, "checkResource listener is null");
            return;
        }
        if (getDownloadSP() == null) {
            RFWLog.e(TAG, RFWLog.USR, "checkResource getSp is null");
            return;
        }
        final String string = getDownloadSP().getString(getResourceSPKey(str), "");
        final boolean isFileDownLoaded = isFileDownLoaded(str);
        RFWLog.i(TAG, RFWLog.USR, "checkResource url:" + str + " isDownloaded:" + isFileDownLoaded + "  preMd5" + string);
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.biz.richframework.download.RFWDownloader.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Response execute = RFWDownloader.this.getOkHttpClient().newCall(RFWDownloader.this.getFileUpdateRequest(str)).execute();
                    try {
                        if (execute.isSuccessful()) {
                            String str2 = execute.headers().get(RFWDownloader.COS_MD5);
                            if (!TextUtils.isEmpty(str2) && !string.equals(str2)) {
                                RFWLog.i(RFWDownloader.TAG, RFWLog.USR, "checkResource:" + str + " need update");
                                rFWCheckResourceListener.onCheckResult(true, isFileDownLoaded, true, str2);
                            }
                            RFWLog.i(RFWDownloader.TAG, RFWLog.USR, "checkResource:" + str + " is up to date");
                            rFWCheckResourceListener.onCheckResult(true, isFileDownLoaded, false, str2);
                        } else {
                            RFWLog.e(RFWDownloader.TAG, RFWLog.USR, "checkResource:" + str + " onFailure");
                            rFWCheckResourceListener.onCheckResult(false, isFileDownLoaded, false, string);
                        }
                        execute.close();
                    } finally {
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        });
    }

    private String checkSupplementFileExtensionName(String str, String str2) {
        if (!this.mDownloadStrategy.isSupplementFileExtensionName()) {
            return str2;
        }
        String fileExtensionFromFilePath = RFWFileUtils.getFileExtensionFromFilePath(str2);
        RFWLog.i(TAG, RFWLog.USR, "[checkSupplementFileExtensionName]  | filePath = " + str2 + " | fileExtensionFromPath = " + fileExtensionFromFilePath);
        if (!TextUtils.isEmpty(fileExtensionFromFilePath)) {
            try {
                FileType.valueOf(fileExtensionFromFilePath.toUpperCase());
                return str2;
            } catch (IllegalArgumentException e16) {
                RFWLog.w(TAG, RFWLog.USR, "[checkSupplementFileExtensionName]  | filePath = " + str2 + " | e = " + e16);
            }
        }
        String fileExtensionFromFileHeader = RFWFileUtils.getFileExtensionFromFileHeader(str2);
        RFWLog.i(TAG, RFWLog.USR, "[checkSupplementFileExtensionName]  | filePath = " + str2 + " | getFileHeadExtension = " + fileExtensionFromFileHeader);
        if (!TextUtils.isEmpty(fileExtensionFromFileHeader)) {
            String str3 = str2 + "." + fileExtensionFromFileHeader;
            boolean renameFile = RFWFileUtils.renameFile(str2, str3);
            RFWLog.i(TAG, RFWLog.USR, "[checkSupplementFileExtensionName]  renameFile   | newFilePath = " + str3 + " | result = " + renameFile);
            if (renameFile) {
                return str3;
            }
        }
        String fileExtensionFromUrl = RFWFileUtils.getFileExtensionFromUrl(str);
        if (!TextUtils.isEmpty(fileExtensionFromUrl) && !str2.endsWith(fileExtensionFromUrl)) {
            String str4 = str2 + "." + fileExtensionFromUrl;
            boolean renameFile2 = RFWFileUtils.renameFile(str2, str4);
            RFWLog.i(TAG, RFWLog.USR, "[checkSupplementFileExtensionName]  renameFile   | newFilePath = " + str4 + " | result = " + renameFile2);
            if (renameFile2) {
                return str4;
            }
        }
        return str2;
    }

    private void clearCallRequest(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Call remove = this.mCallMap.remove(str);
        if (!z16 && remove != null && remove.getCanceled()) {
            RFWLog.e(TAG, RFWLog.USR, "[clearCallRequest]  request was cancelled, url = " + str);
        }
    }

    private void dispatchDownloadProgress(String str, long j3, long j16) {
        RFWDownloadListener rFWDownloadListener;
        ConcurrentHashMap<Integer, WeakReference<RFWDownloadListener>> concurrentHashMap = this.mDownloadCenter.get(str);
        if (concurrentHashMap == null) {
            return;
        }
        for (WeakReference<RFWDownloadListener> weakReference : concurrentHashMap.values()) {
            if (weakReference != null && (rFWDownloadListener = weakReference.get()) != null) {
                rFWDownloadListener.onDownloadProgress((((float) j3) * 1.0f) / ((float) j16), j3, j16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchEventListener(@NonNull Consumer<RFWDownloadListener> consumer) {
        ConcurrentHashMap<Integer, WeakReference<RFWDownloadListener>> next;
        Iterator<ConcurrentHashMap<Integer, WeakReference<RFWDownloadListener>>> it = this.mDownloadCenter.values().iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            Iterator<WeakReference<RFWDownloadListener>> it5 = next.values().iterator();
            while (it5.hasNext()) {
                RFWDownloadListener rFWDownloadListener = it5.next().get();
                if (rFWDownloadListener == null) {
                    return;
                } else {
                    consumer.accept(rFWDownloadListener);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchGetFileResult(String str, boolean z16, String str2) {
        ConcurrentHashMap<Integer, WeakReference<RFWDownloadListener>> concurrentHashMap = this.mDownloadCenter.get(str);
        RFWLog.e(TAG, RFWLog.USR, "strategy:" + this.mDownloadStrategy.getClass().getName() + ",downloadUrl:" + str + " ,filePath:" + str2 + ",finish " + z16);
        if (concurrentHashMap == null) {
            return;
        }
        for (WeakReference<RFWDownloadListener> weakReference : concurrentHashMap.values()) {
            if (weakReference != null) {
                RFWDownloadListener rFWDownloadListener = weakReference.get();
                if (rFWDownloadListener != null) {
                    rFWDownloadListener.onRspCallback(z16, str2);
                    concurrentHashMap.remove(Integer.valueOf(rFWDownloadListener.hashCode()));
                } else {
                    RFWLog.e(TAG, RFWLog.USR, "downloadUrl:" + str + "  getFileListener release");
                }
            }
        }
        clearCallRequest(str, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadInCurrentThread(RFWDownloaderTask rFWDownloaderTask, RFWDownloadListener rFWDownloadListener) {
        RFWDownloadListener downloadListener;
        if (rFWDownloaderTask == null) {
            RFWLog.e(TAG, RFWLog.USR, "downloadInCurrentThread task = null");
            return;
        }
        if (RFWSdcardUtils.getSdCardDirectory() == null) {
            RFWLog.i(TAG, RFWLog.USR, "getFile error, SdCardUtil.getSdCardDirectory() == null");
            if (rFWDownloaderTask.getDownloadListener() != null) {
                rFWDownloaderTask.getDownloadListener().onRspCallback(false, "");
            }
        }
        if (rFWDownloaderTask.getDownloadListener() == null) {
            downloadListener = rFWDownloadListener;
        } else {
            downloadListener = rFWDownloaderTask.getDownloadListener();
        }
        if (!TextUtils.isEmpty(rFWDownloaderTask.getFilePath()) && isFileExist(rFWDownloaderTask.getFilePath())) {
            if (downloadListener != null) {
                downloadListener.onRspCallback(true, rFWDownloaderTask.getFilePath());
            }
        } else if (TextUtils.isEmpty(rFWDownloaderTask.getFilePath()) && isFileDownLoaded(rFWDownloaderTask.getUrl())) {
            if (downloadListener != null) {
                downloadListener.onRspCallback(true, getContentFilePath(rFWDownloaderTask.getUrl()));
            }
        } else {
            if (rFWDownloadListener != null) {
                registerEachListener(rFWDownloaderTask.getUrl(), rFWDownloadListener);
            }
            handleCheckAndDownload(null, rFWDownloaderTask);
        }
    }

    private void downloadProgressCallback(RFWDownloadInfo rFWDownloadInfo, long j3, long j16) {
        RFWDownloadListener downListener = rFWDownloadInfo.getDownListener();
        if (downListener != null) {
            downListener.onDownloadProgress((((float) j3) * 1.0f) / ((float) j16), j3, j16);
        }
    }

    private void downloadWithDownloadInfo(RFWDownloadInfo rFWDownloadInfo) {
        Closeable closeable;
        String url;
        char c16;
        String str = null;
        try {
            url = rFWDownloadInfo.getUrl();
        } catch (Throwable th5) {
            th = th5;
            closeable = null;
        }
        try {
            Request.Builder builder = new Request.Builder().url(url).get();
            if (this.mDownloadStrategy.supportBreakPointDownload()) {
                builder.addHeader("RANGE", "bytes=" + new File(rFWDownloadInfo.getTmpFilePath()).length() + "-");
            }
            Map<String, String> header = rFWDownloadInfo.getHeader();
            if (header != null && header.size() != 0) {
                for (Map.Entry<String, String> entry : header.entrySet()) {
                    builder.addHeader(entry.getKey(), entry.getValue());
                }
            }
            if (rFWDownloadInfo.getConnectTimeout() > 0) {
                builder.tag(ConnectTimeout.class, new ConnectTimeout(rFWDownloadInfo.getConnectTimeout()));
            }
            if (rFWDownloadInfo.getWriteTimeout() > 0) {
                builder.tag(WriteTimeout.class, new WriteTimeout(rFWDownloadInfo.getWriteTimeout()));
            }
            if (rFWDownloadInfo.getReadTimeout() > 0) {
                builder.tag(ReadTimeout.class, new ReadTimeout(rFWDownloadInfo.getReadTimeout()));
            }
            Call newCall = getOkHttpClient().newCall(builder.build());
            this.mCallMap.put(url, newCall);
            Response execute = newCall.execute();
            long uptimeMillis = SystemClock.uptimeMillis();
            if (execute.isSuccessful()) {
                long uptimeMillis2 = SystemClock.uptimeMillis();
                rFWDownloadInfo.setMd5(execute.headers().get(COS_MD5));
                writeFileFromResponse(rFWDownloadInfo, execute);
                long uptimeMillis3 = SystemClock.uptimeMillis();
                RFWLog.i(TAG, RFWLog.USR, "download [timeCost=" + (SystemClock.uptimeMillis() - uptimeMillis) + "][receiveData=" + (uptimeMillis3 - uptimeMillis2) + "] [url=" + rFWDownloadInfo.getUrl() + "]");
                c16 = 0;
            } else {
                c16 = 0;
                logDownloadInfo(rFWDownloadInfo, "downloadWithDownloadInfo response is error | code = " + execute.code() + " | message = " + execute.message());
                dispatchGetFileResult(url, false, "");
                rspCallback(rFWDownloadInfo, false, "");
            }
            this.mLock.lock();
            this.mDownloadingUrlSet.remove(url);
            this.mLock.unlock();
            Closeable[] closeableArr = new Closeable[1];
            closeableArr[c16] = execute;
            RFWIOUtil.closeAll(closeableArr);
        } catch (Throwable th6) {
            th = th6;
            closeable = null;
            str = url;
            try {
                logDownloadInfo(rFWDownloadInfo, "downloadWithDownloadInfo failed" + th.getMessage());
                dispatchGetFileResult(str, false, "");
                rspCallback(rFWDownloadInfo, false, "");
                this.mLock.lock();
                this.mDownloadingUrlSet.remove(str);
                this.mLock.unlock();
                RFWIOUtil.closeAll(closeable);
            } catch (Throwable th7) {
                this.mLock.lock();
                this.mDownloadingUrlSet.remove(str);
                this.mLock.unlock();
                RFWIOUtil.closeAll(closeable);
                throw th7;
            }
        }
    }

    private int getAllChildFileSize(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return 0;
        }
        int i3 = 0;
        for (File file2 : listFiles) {
            if (file2.isFile()) {
                i3 = (int) (i3 + file2.length());
            } else {
                i3 += getAllChildFileSize(file2);
            }
        }
        return i3;
    }

    private SharedPreferences getDownloadSP() {
        RFWDownloadStrategy rFWDownloadStrategy = this.mDownloadStrategy;
        if (rFWDownloadStrategy != null) {
            return rFWDownloadStrategy.getSP();
        }
        return null;
    }

    private String getFileNameForKey(String str) {
        int length = str.length() / 2;
        return String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode());
    }

    private String getFilePathFromUrl(String str) {
        try {
            return new URL(str).getPath();
        } catch (MalformedURLException e16) {
            RFWLog.e(TAG, RFWLog.USR, "getFilePathFromUrl error:" + e16);
            return null;
        }
    }

    private long getFileTotalLengthByResponse(Response response) {
        String header;
        String[] split;
        if (response != null && (header = response.header("Content-Range")) != null && (split = header.split("/")) != null && split.length == 2) {
            try {
                return Long.parseLong(split[1]);
            } catch (NumberFormatException e16) {
                RFWLog.e(TAG, RFWLog.USR, "getTotalLengthByResponse  e = " + e16);
            }
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Request getFileUpdateRequest(String str) {
        return new Request.Builder().url(str).head().build();
    }

    private String getResourceSPKey(String str) {
        return COS_MD5 + str;
    }

    private String getTmpSavePath(String str) {
        return getDefaultSavePath(str) + TMP_FILE_SUFFIX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCheckAndDownload(String str, RFWDownloaderTask rFWDownloaderTask) {
        this.mLock.lock();
        if (this.mDownloadingUrlSet.contains(rFWDownloaderTask.getUrl())) {
            this.mLock.unlock();
            RFWLog.i(TAG, RFWLog.USR, "getFile ..., file is downloading");
            return;
        }
        this.mDownloadingUrlSet.add(rFWDownloaderTask.getUrl());
        this.mLock.unlock();
        RFWLog.i(TAG, RFWLog.USR, "getFile ..., start download");
        RFWDownloadInfo initDownloadInfo = initDownloadInfo(rFWDownloaderTask);
        initDownloadInfo.setMd5(str);
        downloadWithDownloadInfo(initDownloadInfo);
    }

    private void handleDownloadFile(RFWDownloadInfo rFWDownloadInfo) {
        String url = rFWDownloadInfo.getUrl();
        String md5 = rFWDownloadInfo.getMd5();
        if (needUnzipFile(url) && !rFWDownloadInfo.getIsSpecifyPath()) {
            try {
                String contentFilePath = getContentFilePath(url);
                File file = new File(rFWDownloadInfo.getFilePath());
                RFWLog.i(TAG, RFWLog.USR, "start unzip file to folderPath:" + contentFilePath);
                RFWFileUtils.unZipFile(file, contentFilePath);
                logDownloadInfo(rFWDownloadInfo, "unZip success");
                updateFileMd5(url, md5);
                dispatchGetFileResult(url, true, contentFilePath);
                rspCallback(rFWDownloadInfo, true, contentFilePath);
                return;
            } catch (Exception e16) {
                logDownloadInfo(rFWDownloadInfo, "unZip failed" + e16.getMessage());
                dispatchGetFileResult(url, false, "");
                rspCallback(rFWDownloadInfo, false, "");
                return;
            }
        }
        RFWLog.i(TAG, RFWLog.USR, "is not zip file, not need upzip");
        updateFileMd5(url, md5);
        if (!rFWDownloadInfo.getIsSpecifyPath()) {
            rFWDownloadInfo.setFilePath(checkSupplementFileExtensionName(url, rFWDownloadInfo.getFilePath()));
        }
        dispatchGetFileResult(url, true, rFWDownloadInfo.getFilePath());
        rspCallback(rFWDownloadInfo, true, rFWDownloadInfo.getFilePath());
    }

    private RFWDownloadInfo initDownloadInfo(RFWDownloaderTask rFWDownloaderTask) {
        RFWDownloadInfo rFWDownloadInfo = new RFWDownloadInfo();
        rFWDownloadInfo.setUrl(rFWDownloaderTask.getUrl());
        if (TextUtils.isEmpty(rFWDownloaderTask.getFilePath())) {
            rFWDownloadInfo.setFilePath(getDefaultSavePath(rFWDownloaderTask.getUrl()));
            rFWDownloadInfo.setSpecifyPath(false);
        } else {
            rFWDownloadInfo.setFilePath(rFWDownloaderTask.getFilePath());
            rFWDownloadInfo.setSpecifyPath(true);
        }
        rFWDownloadInfo.setConnectTimeout(rFWDownloaderTask.getConnectTimeout());
        rFWDownloadInfo.setReadTimeout(rFWDownloaderTask.getReadTimeout());
        rFWDownloadInfo.setWriteTimeout(rFWDownloaderTask.getWriteTimeout());
        rFWDownloadInfo.setTmpFilePath(getTmpSavePath(rFWDownloaderTask.getUrl()));
        rFWDownloadInfo.setHeader(rFWDownloaderTask.getHeader());
        rFWDownloadInfo.setDownListener(rFWDownloaderTask.getDownloadListener());
        return rFWDownloadInfo;
    }

    private void initNoMedia(final String str) {
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.biz.richframework.download.RFWDownloader.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    RFWFileUtils.createFile(new File(str, ".nomedia").getAbsolutePath());
                    RFWLog.i(RFWDownloader.TAG, RFWLog.USR, "initNoMedia success");
                } catch (IOException e16) {
                    e16.printStackTrace();
                    RFWLog.e(RFWDownloader.TAG, RFWLog.USR, "initNoMedia error" + e16.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void insertMedia(Context context, final String str, String str2, final RFWDownloadMediaListener rFWDownloadMediaListener) {
        RFWSaveUtil.insertMedia(context, str, str2, false, new Consumer<RFWSaveMediaResultBean>() { // from class: com.tencent.biz.richframework.download.RFWDownloader.3
            @Override // androidx.core.util.Consumer
            public void accept(RFWSaveMediaResultBean rFWSaveMediaResultBean) {
                RFWDownloadMediaListener rFWDownloadMediaListener2 = rFWDownloadMediaListener;
                if (rFWDownloadMediaListener2 != null) {
                    boolean z16 = rFWSaveMediaResultBean.isSuccess;
                    rFWDownloadMediaListener2.onSaveCallback(z16, z16 ? 0 : -4, str);
                }
            }
        });
    }

    private boolean isZipFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.endsWith(".zip")) {
            return true;
        }
        String filePathFromUrl = getFilePathFromUrl(str);
        if (TextUtils.isEmpty(filePathFromUrl) || !filePathFromUrl.endsWith(".zip")) {
            return false;
        }
        return true;
    }

    private void logDownloadInfo(RFWDownloadInfo rFWDownloadInfo, Object... objArr) {
        RFWLog.e(TAG, RFWLog.USR, rFWDownloadInfo.getUrl(), objArr);
    }

    private boolean needUnzipFile(String str) {
        if (this.mDownloadStrategy.supportUnZipFile() && isZipFile(str)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerEachListener(String str, RFWDownloadListener rFWDownloadListener) {
        if (rFWDownloadListener == null) {
            return;
        }
        ConcurrentHashMap<Integer, WeakReference<RFWDownloadListener>> concurrentHashMap = this.mDownloadCenter.get(str);
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
        }
        concurrentHashMap.put(Integer.valueOf(rFWDownloadListener.hashCode()), new WeakReference<>(rFWDownloadListener));
        this.mDownloadCenter.put(str, concurrentHashMap);
    }

    private void rspCallback(RFWDownloadInfo rFWDownloadInfo, boolean z16, String str) {
        RFWDownloadListener downListener = rFWDownloadInfo.getDownListener();
        if (downListener != null) {
            downListener.onRspCallback(z16, str);
        }
    }

    private void updateFileMd5(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && getDownloadSP() != null) {
            getDownloadSP().edit().putString(getResourceSPKey(str), str2).apply();
        }
    }

    private void writeFileFromResponse(RFWDownloadInfo rFWDownloadInfo, Response response) {
        int i3;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        long contentLength;
        InputStream byteStream;
        byte[] bArr;
        long j3;
        String url = rFWDownloadInfo.getUrl();
        if (TextUtils.isEmpty(rFWDownloadInfo.getFilePath())) {
            return;
        }
        File file = new File(rFWDownloadInfo.getTmpFilePath());
        RFWLog.i(TAG, RFWLog.USR, "writeFileFromResponse to file:" + rFWDownloadInfo.getTmpFilePath());
        long length = file.length();
        try {
            if (!file.getParentFile().exists()) {
                boolean mkdirs = file.getParentFile().mkdirs();
                RFWLog.i(TAG, RFWLog.USR, "mkdir tempFile.getParentFile():" + file.getParentFile().getAbsolutePath() + " Result:" + mkdirs);
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            if (this.mDownloadStrategy.supportBreakPointDownload()) {
                contentLength = getFileTotalLengthByResponse(response);
            } else {
                contentLength = response.body().getContentLength();
            }
            rFWDownloadInfo.setTotalContentLength(contentLength);
            byteStream = response.body().byteStream();
        } catch (IOException e16) {
            e = e16;
            inputStream = null;
        } catch (Throwable th5) {
            th = th5;
            i3 = 2;
            inputStream = null;
        }
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, this.mDownloadStrategy.supportBreakPointDownload());
            try {
                byte[] bArr2 = new byte[4096];
                while (true) {
                    int read = byteStream.read(bArr2);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream2.write(bArr2, 0, read);
                    long j16 = read + length;
                    rFWDownloadInfo.setDownloadedLength(j16);
                    if (contentLength > 0) {
                        bArr = bArr2;
                        fileOutputStream = fileOutputStream2;
                        j3 = contentLength;
                        try {
                            dispatchDownloadProgress(url, j16, contentLength);
                            downloadProgressCallback(rFWDownloadInfo, j16, j3);
                        } catch (IOException e17) {
                            e = e17;
                            inputStream = byteStream;
                            try {
                                int i16 = RFWLog.USR;
                            } catch (Throwable th6) {
                                th = th6;
                                i3 = 2;
                                Closeable[] closeableArr = new Closeable[i3];
                                closeableArr[0] = inputStream;
                                closeableArr[1] = fileOutputStream;
                                RFWIOUtil.closeAll(closeableArr);
                                throw th;
                            }
                            try {
                                Object[] objArr = new Object[2];
                                objArr[0] = e.getMessage();
                                objArr[1] = e;
                                RFWLog.e(TAG, i16, objArr);
                                dispatchGetFileResult(url, false, "");
                                rspCallback(rFWDownloadInfo, false, "");
                                RFWIOUtil.closeAll(inputStream, fileOutputStream);
                            } catch (Throwable th7) {
                                th = th7;
                                i3 = 2;
                                Closeable[] closeableArr2 = new Closeable[i3];
                                closeableArr2[0] = inputStream;
                                closeableArr2[1] = fileOutputStream;
                                RFWIOUtil.closeAll(closeableArr2);
                                throw th;
                            }
                        } catch (Throwable th8) {
                            th = th8;
                            inputStream = byteStream;
                            i3 = 2;
                            Closeable[] closeableArr22 = new Closeable[i3];
                            closeableArr22[0] = inputStream;
                            closeableArr22[1] = fileOutputStream;
                            RFWIOUtil.closeAll(closeableArr22);
                            throw th;
                        }
                    } else {
                        bArr = bArr2;
                        fileOutputStream = fileOutputStream2;
                        j3 = contentLength;
                    }
                    length = j16;
                    fileOutputStream2 = fileOutputStream;
                    bArr2 = bArr;
                    contentLength = j3;
                }
                fileOutputStream = fileOutputStream2;
                logDownloadInfo(rFWDownloadInfo, "startWriteFile");
                fileOutputStream.flush();
                File file2 = new File(rFWDownloadInfo.getFilePath());
                if (file2.exists()) {
                    file2.delete();
                }
                file.renameTo(file2);
                handleDownloadFile(rFWDownloadInfo);
                RFWIOUtil.closeAll(byteStream, fileOutputStream);
            } catch (IOException e18) {
                e = e18;
                fileOutputStream = fileOutputStream2;
            } catch (Throwable th9) {
                th = th9;
                fileOutputStream = fileOutputStream2;
            }
        } catch (IOException e19) {
            e = e19;
            inputStream = byteStream;
            fileOutputStream = null;
            int i162 = RFWLog.USR;
            Object[] objArr2 = new Object[2];
            objArr2[0] = e.getMessage();
            objArr2[1] = e;
            RFWLog.e(TAG, i162, objArr2);
            dispatchGetFileResult(url, false, "");
            rspCallback(rFWDownloadInfo, false, "");
            RFWIOUtil.closeAll(inputStream, fileOutputStream);
        } catch (Throwable th10) {
            th = th10;
            inputStream = byteStream;
            i3 = 2;
            fileOutputStream = null;
            Closeable[] closeableArr222 = new Closeable[i3];
            closeableArr222[0] = inputStream;
            closeableArr222[1] = fileOutputStream;
            RFWIOUtil.closeAll(closeableArr222);
            throw th;
        }
    }

    public void cancelDownloadRequest(String str) {
        Call call = this.mCallMap.get(str);
        if (call != null) {
            call.cancel();
            RFWLog.d(TAG, RFWLog.USR, "[cancelDownloadRequest]  url = " + str);
        }
    }

    public void download(String str) {
        download(str, null);
    }

    public void downloadAndInsertMedia(final Context context, String str, final String str2, @Nullable final RFWDownloadMediaListener rFWDownloadMediaListener) {
        if (!RFWSaveUtil.checkSavePermission(context)) {
            if (rFWDownloadMediaListener != null) {
                rFWDownloadMediaListener.onSaveCallback(false, -1, "");
            }
            RFWLog.e(TAG, RFWLog.USR, "[downloadAndInsertMedia] no WRITE_EXTERNAL_STORAGE permission.");
        } else if (RFWFileUtils.isLocalPath(str)) {
            insertMedia(context, str, str2, rFWDownloadMediaListener);
            RFWLog.d(TAG, RFWLog.USR, "[downloadAndInsertMedia] save local media.");
        } else {
            if (!RFWUrlUtils.isValidUrl(str)) {
                if (rFWDownloadMediaListener != null) {
                    rFWDownloadMediaListener.onSaveCallback(false, -2, "");
                }
                RFWLog.e(TAG, RFWLog.USR, "[downloadAndInsertMedia] mediaUrl invalid.");
                return;
            }
            download(str, new RFWDownloadListener() { // from class: com.tencent.biz.richframework.download.RFWDownloader.2
                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void callEnd(Call call) {
                    v.a(this, call);
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void callFailed(Call call, IOException iOException) {
                    v.b(this, call, iOException);
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void callStart(Call call) {
                    v.c(this, call);
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol2) {
                    v.d(this, call, inetSocketAddress, proxy, protocol2);
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol2, IOException iOException) {
                    v.e(this, call, inetSocketAddress, proxy, protocol2, iOException);
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
                    v.f(this, call, inetSocketAddress, proxy);
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void connectionAcquired(Call call, Connection connection) {
                    v.g(this, call, connection);
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void connectionReleased(Call call, Connection connection) {
                    v.h(this, call, connection);
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void dnsEnd(Call call, String str3, List list) {
                    v.i(this, call, str3, list);
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void dnsStart(Call call, String str3) {
                    v.j(this, call, str3);
                }

                @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
                public void onDownloadProgress(float f16, long j3, long j16) {
                    RFWDownloadMediaListener rFWDownloadMediaListener2 = rFWDownloadMediaListener;
                    if (rFWDownloadMediaListener2 != null) {
                        rFWDownloadMediaListener2.onDownloadProgress(f16, j3, j16);
                    }
                }

                @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
                public void onRspCallback(boolean z16, String str3) {
                    if (z16) {
                        RFWDownloader.this.insertMedia(context, str3, str2, rFWDownloadMediaListener);
                        return;
                    }
                    RFWDownloadMediaListener rFWDownloadMediaListener2 = rFWDownloadMediaListener;
                    if (rFWDownloadMediaListener2 != null) {
                        rFWDownloadMediaListener2.onSaveCallback(false, -3, str3);
                    }
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void requestBodyEnd(Call call, long j3) {
                    v.k(this, call, j3);
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void requestBodyStart(Call call) {
                    v.l(this, call);
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void requestHeadersEnd(Call call, Request request) {
                    v.m(this, call, request);
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void requestHeadersStart(Call call) {
                    v.n(this, call);
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void responseBodyEnd(Call call, long j3) {
                    v.o(this, call, j3);
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void responseBodyStart(Call call) {
                    v.p(this, call);
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void responseHeadersEnd(Call call, Response response) {
                    v.q(this, call, response);
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void responseHeadersStart(Call call) {
                    v.r(this, call);
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void secureConnectEnd(Call call, Handshake handshake) {
                    v.s(this, call, handshake);
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void secureConnectStart(Call call) {
                    v.t(this, call);
                }
            });
        }
    }

    public void downloadOrUpdateFile(final String str, final RFWDownloadListener rFWDownloadListener) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.biz.richframework.download.RFWDownloader.6
            @Override // java.lang.Runnable
            public void run() {
                if (RFWSdcardUtils.getSdCardDirectory() == null) {
                    RFWLog.i(RFWDownloader.TAG, RFWLog.USR, "downloadOrUpdateFile error, SdCardUtil.getSdCardDirectory() == null");
                    RFWDownloadListener rFWDownloadListener2 = rFWDownloadListener;
                    if (rFWDownloadListener2 != null) {
                        rFWDownloadListener2.onRspCallback(false, "");
                    }
                }
                RFWDownloadListener rFWDownloadListener3 = rFWDownloadListener;
                if (rFWDownloadListener3 != null) {
                    RFWDownloader.this.registerEachListener(str, rFWDownloadListener3);
                }
                RFWDownloader.this.checkResource(str, new RFWCheckResourceListener() { // from class: com.tencent.biz.richframework.download.RFWDownloader.6.1
                    @Override // com.tencent.biz.richframework.download.RFWCheckResourceListener
                    public void onCheckResult(boolean z16, boolean z17, boolean z18, String str2) {
                        if (z17 && !z18) {
                            AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                            String contentFilePath = RFWDownloader.this.getContentFilePath(str);
                            RFWLog.i(RFWDownloader.TAG, RFWLog.USR, "getFile success, the file is exist path:" + contentFilePath);
                            AnonymousClass6 anonymousClass62 = AnonymousClass6.this;
                            RFWDownloader.this.dispatchGetFileResult(str, true, contentFilePath);
                            return;
                        }
                        AnonymousClass6 anonymousClass63 = AnonymousClass6.this;
                        RFWDownloader.this.handleCheckAndDownload(str2, new RFWDownloaderTask(str));
                    }
                });
            }
        });
    }

    public String getContentFilePath(String str) {
        if (needUnzipFile(str)) {
            return this.mDownloadRootPath + getFileNameForKey(str) + File.separator;
        }
        return getDefaultSavePath(str);
    }

    public String getDefaultSavePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (this.mDownloadStrategy.useSimpleFileName(str)) {
            String absolutePath = new File(this.mDownloadRootPath, getFileNameForKey(str)).getAbsolutePath();
            if (this.mDownloadStrategy.isSupplementFileExtensionName()) {
                String fileExtensionFromUrl = RFWFileUtils.getFileExtensionFromUrl(str);
                if (!TextUtils.isEmpty(fileExtensionFromUrl)) {
                    return absolutePath + "." + fileExtensionFromUrl;
                }
                return absolutePath;
            }
            return absolutePath;
        }
        try {
            String str2 = this.mDownloadRootPath + URLEncoder.encode(str, "UTF-8");
            if (str2.length() <= MAX_FILE_NAME_LENGTH) {
                return str2;
            }
        } catch (Exception e16) {
            RFWLog.e(TAG, RFWLog.USR, e16);
        }
        return new File(this.mDownloadRootPath, getFileNameForKey(str) + File.separator + RFWUrlUtils.getFileNameFromUrl(str)).getAbsolutePath();
    }

    public OkHttpClient getOkHttpClient() {
        if (sOkHttpClient == null) {
            synchronized (RFWDownloader.class) {
                if (sOkHttpClient == null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new RFWDownloaderTimeoutInterceptor());
                    sOkHttpClient = RFWOkHttpClientFactory.createDeFaultOKHttpClient(new AnonymousClass8(), arrayList);
                }
            }
        }
        return sOkHttpClient;
    }

    public boolean isFileDownLoaded(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return isFileExist(getContentFilePath(str));
    }

    public boolean isFileDownLoading(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.mDownloadingUrlSet.contains(str);
        }
        return false;
    }

    public boolean isFileExist(String str) {
        if (TextUtils.isEmpty(str) || RFWSdcardUtils.getSdCardDirectory() == null) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        if (file.isFile()) {
            if (file.length() <= 0) {
                return false;
            }
            return true;
        }
        return checkFileValid(file);
    }

    public void download(String str, final RFWDownloadListener rFWDownloadListener) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        final RFWDownloaderTask rFWDownloaderTask = new RFWDownloaderTask(str);
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.biz.richframework.download.RFWDownloader.4
            @Override // java.lang.Runnable
            public void run() {
                RFWDownloader.this.downloadInCurrentThread(rFWDownloaderTask, rFWDownloadListener);
            }
        });
    }

    public void download(final RFWDownloaderTask rFWDownloaderTask) {
        if (rFWDownloaderTask == null || TextUtils.isEmpty(rFWDownloaderTask.getUrl())) {
            return;
        }
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.biz.richframework.download.RFWDownloader.5
            @Override // java.lang.Runnable
            public void run() {
                RFWDownloader.this.downloadInCurrentThread(rFWDownloaderTask, null);
            }
        });
    }
}
