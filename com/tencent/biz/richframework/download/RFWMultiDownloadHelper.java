package com.tencent.biz.richframework.download;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.download.RFWDownloader;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWMultiDownloadHelper {
    private static final String TAG = "RFWMultiDownloadHelper";
    private HashSet<RFWDownloader.RFWDownloadListener> mDownloadListenerSet;
    private Map<String, DownloadResult> mDownloadResultMap;
    private List<DownloadTask> mDownloadTasks;
    private AtomicInteger mErrorCount;
    private AtomicBoolean mIsDownloadIng = new AtomicBoolean(false);
    private WeakReference<MultiDownloadResultListener> mMultiDownloadResultListener;
    private AtomicInteger mSuccessCount;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class DownloadResult {
        public String mDownloadUrl;
        public String mFilePath;
        public boolean mIsSuccess;

        public DownloadResult(String str, boolean z16, String str2) {
            this.mDownloadUrl = str;
            this.mIsSuccess = z16;
            this.mFilePath = str2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class DownloadTask {
        public RFWDownloadStrategy mDownloadStrategy;
        public String mDownloadUrl;

        public DownloadTask(String str, RFWDownloadStrategy rFWDownloadStrategy) {
            this.mDownloadUrl = str;
            this.mDownloadStrategy = rFWDownloadStrategy;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface MultiDownloadResultListener {
        void onDownloadResult(boolean z16, Map<String, DownloadResult> map);
    }

    public RFWMultiDownloadHelper() {
    }

    public void addTask(DownloadTask downloadTask) {
        if (this.mDownloadTasks == null) {
            this.mDownloadTasks = new ArrayList();
        }
        this.mDownloadTasks.add(downloadTask);
    }

    public void setListener(MultiDownloadResultListener multiDownloadResultListener) {
        this.mMultiDownloadResultListener = new WeakReference<>(multiDownloadResultListener);
    }

    public void start() {
        if (this.mDownloadTasks == null) {
            return;
        }
        if (!this.mIsDownloadIng.compareAndSet(false, true)) {
            RFWLog.d(TAG, RFWLog.USR, "mIsDownloadIng is true");
            return;
        }
        this.mSuccessCount = new AtomicInteger(0);
        this.mErrorCount = new AtomicInteger(0);
        final int size = this.mDownloadTasks.size();
        this.mDownloadResultMap = new ConcurrentHashMap();
        this.mDownloadListenerSet = new HashSet<>();
        for (final DownloadTask downloadTask : this.mDownloadTasks) {
            RFWDownloader.RFWDownloadListener rFWDownloadListener = new RFWDownloader.RFWDownloadListener() { // from class: com.tencent.biz.richframework.download.RFWMultiDownloadHelper.1
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
                public /* synthetic */ void dnsEnd(Call call, String str, List list) {
                    v.i(this, call, str, list);
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void dnsStart(Call call, String str) {
                    v.j(this, call, str);
                }

                @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
                public void onRspCallback(boolean z16, String str) {
                    MultiDownloadResultListener multiDownloadResultListener;
                    DownloadResult downloadResult = new DownloadResult(downloadTask.mDownloadUrl, z16, str);
                    if (RFWMultiDownloadHelper.this.mDownloadResultMap != null) {
                        RFWMultiDownloadHelper.this.mDownloadResultMap.put(downloadTask.mDownloadUrl, downloadResult);
                    }
                    if (z16) {
                        RFWMultiDownloadHelper.this.mSuccessCount.incrementAndGet();
                    } else {
                        RFWMultiDownloadHelper.this.mErrorCount.incrementAndGet();
                    }
                    if (RFWMultiDownloadHelper.this.mSuccessCount.get() + RFWMultiDownloadHelper.this.mErrorCount.get() == size) {
                        boolean z17 = false;
                        RFWMultiDownloadHelper.this.mIsDownloadIng.set(false);
                        if (RFWMultiDownloadHelper.this.mMultiDownloadResultListener != null && (multiDownloadResultListener = (MultiDownloadResultListener) RFWMultiDownloadHelper.this.mMultiDownloadResultListener.get()) != null) {
                            if (RFWMultiDownloadHelper.this.mErrorCount.get() == 0) {
                                z17 = true;
                            }
                            multiDownloadResultListener.onDownloadResult(z17, RFWMultiDownloadHelper.this.mDownloadResultMap);
                        }
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

                @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
                public void onDownloadProgress(float f16, long j3, long j16) {
                }
            };
            this.mDownloadListenerSet.add(rFWDownloadListener);
            RFWDownloaderFactory.getDownloader(downloadTask.mDownloadStrategy).download(downloadTask.mDownloadUrl, rFWDownloadListener);
        }
    }

    public RFWMultiDownloadHelper(List<DownloadTask> list, MultiDownloadResultListener multiDownloadResultListener) {
        this.mDownloadTasks = list;
        this.mMultiDownloadResultListener = new WeakReference<>(multiDownloadResultListener);
    }
}
