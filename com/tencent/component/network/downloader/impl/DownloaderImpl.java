package com.tencent.component.network.downloader.impl;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.component.network.Global;
import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadRequest;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.PreConnectManager;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.downloader.handler.ContentHandler;
import com.tencent.component.network.downloader.handler.FileHandler;
import com.tencent.component.network.downloader.impl.DownloadTask;
import com.tencent.component.network.downloader.strategy.DownloadPreprocessStrategy;
import com.tencent.component.network.downloader.strategy.KeepAliveStrategy;
import com.tencent.component.network.downloader.strategy.ResumeTransfer;
import com.tencent.component.network.module.base.Config;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.cache.CacheManager;
import com.tencent.component.network.module.cache.file.FileCacheService;
import com.tencent.component.network.module.common.NetworkState;
import com.tencent.component.network.utils.AssertUtil;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.component.network.utils.MultiHashMap;
import com.tencent.component.network.utils.http.HttpUtil;
import com.tencent.component.network.utils.http.base.QZoneHttpClient;
import com.tencent.component.network.utils.http.pool.CustomDnsResolve;
import com.tencent.component.network.utils.thread.Future;
import com.tencent.component.network.utils.thread.FutureListener;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DownloaderImpl extends Downloader implements DownloadTask.DownloadTaskHandler {
    private static final KeepAliveStrategy.KeepAlive DEFAULT_KEEP_ALIVE;
    private static final KeepAliveStrategy.KeepAlive DEFAULT_KEEP_ALIVE_PROXY;
    private static final DownloadPreprocessStrategy.DownloadPool DEFAULT_THREAD_POOL;
    private static volatile int DownloadingHttp2TaskCount = 0;
    private static volatile int DownloadingHttpTaskCount = 0;
    public static int MAX_CONNECTION = 0;
    public static int MAX_CONNECTION_PER_ROUTE = 0;
    private static final String TAG = "Downloader";
    public static final int THREAD_POOL_SIZE;
    public static final long TIME_TO_LIVE_HTTP;
    public static final long TIME_TO_LIVE_HTTP2;
    public static final TimeUnit TIME_TO_LIVE_UNIT;
    private static final ThreadPoolCache sThreadPoolCache;
    private Object ExecutingTaskListRock;
    private final FileCacheService mCacheFileCache;
    private Map<String, List<WeakReference<DownloadTask>>> mExecutingTaskList;
    private final HashMap<String, Future<DownloadResult>> mFutures;
    private QZoneHttpClient mHttpClient;
    private LockManager mLockManager;
    private OkHttpClient mOkClient;
    private boolean mPaused;
    private final MultiHashMap<String, DownloadRequest> mPendingRequests;
    private final ThreadPoolCache mThreadPoolCache;

    /* compiled from: P */
    /* renamed from: com.tencent.component.network.downloader.impl.DownloaderImpl$2, reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$component$network$downloader$strategy$KeepAliveStrategy$KeepAlive;

        static {
            int[] iArr = new int[KeepAliveStrategy.KeepAlive.values().length];
            $SwitchMap$com$tencent$component$network$downloader$strategy$KeepAliveStrategy$KeepAlive = iArr;
            try {
                iArr[KeepAliveStrategy.KeepAlive.ENABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$component$network$downloader$strategy$KeepAliveStrategy$KeepAlive[KeepAliveStrategy.KeepAlive.DISABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$component$network$downloader$strategy$KeepAliveStrategy$KeepAlive[KeepAliveStrategy.KeepAlive.IGNORE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private class LockManager {
        private Object Lock;
        private Map<String, Object> mActiveLocks;
        private List<Object> mIdleLockObjects;

        LockManager() {
            this.Lock = new Object();
            this.mIdleLockObjects = new ArrayList();
            this.mActiveLocks = new HashMap();
        }

        public Object obtaionLock(String str) {
            Object obj;
            synchronized (this.Lock) {
                if (this.mActiveLocks.containsKey(str)) {
                    return this.mActiveLocks.get(str);
                }
                if (this.mIdleLockObjects.size() > 0) {
                    obj = this.mIdleLockObjects.remove(0);
                } else {
                    obj = new Object();
                }
                this.mActiveLocks.put(str, obj);
                return obj;
            }
        }

        public void releaseLock(String str) {
            synchronized (this.Lock) {
                if (!this.mActiveLocks.containsKey(str)) {
                    return;
                }
                Object remove = this.mActiveLocks.remove(str);
                if (remove != null && !this.mIdleLockObjects.contains(remove)) {
                    this.mIdleLockObjects.add(remove);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class ThreadPoolCache {
        private final String mName;
        private final int mPoolSize;
        private final HashMap<String, PriorityThreadPool> mThreadPoolMap = new HashMap<>();

        ThreadPoolCache(String str, int i3) {
            str = str == null ? "" : str;
            i3 = i3 <= 0 ? 1 : i3;
            this.mName = str;
            this.mPoolSize = i3;
        }

        public PriorityThreadPool get(String str) {
            PriorityThreadPool priorityThreadPool;
            String str2 = this.mName + "-" + str;
            PriorityThreadPool priorityThreadPool2 = this.mThreadPoolMap.get(str2);
            if (priorityThreadPool2 != null) {
                return priorityThreadPool2;
            }
            synchronized (this.mThreadPoolMap) {
                PriorityThreadPool priorityThreadPool3 = this.mThreadPoolMap.get(str2);
                if (priorityThreadPool3 != null) {
                    return priorityThreadPool3;
                }
                if (str != null && str.equals(DownloadPreprocessStrategy.DownloadPool.HTTP2.getName())) {
                    priorityThreadPool = new PriorityThreadPool(str2, Config.getDefaultHttp2ThreadPoolSize());
                } else {
                    priorityThreadPool = new PriorityThreadPool(str2, this.mPoolSize);
                }
                this.mThreadPoolMap.put(str2, priorityThreadPool);
                return priorityThreadPool;
            }
        }
    }

    static {
        int defaultThreadPoolSize = Config.getDefaultThreadPoolSize();
        THREAD_POOL_SIZE = defaultThreadPoolSize;
        MAX_CONNECTION = DownloadPreprocessStrategy.DownloadPool.size() * 3 * 5;
        MAX_CONNECTION_PER_ROUTE = defaultThreadPoolSize + 1;
        TIME_TO_LIVE_HTTP = Config.getDefaultHttpLiveTime();
        TIME_TO_LIVE_HTTP2 = Config.getDefaultHttp2LiveTime();
        TIME_TO_LIVE_UNIT = TimeUnit.SECONDS;
        KeepAliveStrategy.KeepAlive keepAlive = KeepAliveStrategy.KeepAlive.DISABLE;
        DEFAULT_KEEP_ALIVE = keepAlive;
        DEFAULT_KEEP_ALIVE_PROXY = keepAlive;
        DEFAULT_THREAD_POOL = DownloadPreprocessStrategy.DownloadPool.COMMON;
        sThreadPoolCache = new ThreadPoolCache("download", defaultThreadPoolSize);
    }

    public DownloaderImpl(Context context, String str, int i3) {
        super(context, str);
        this.mPendingRequests = new MultiHashMap<>();
        this.mFutures = new HashMap<>();
        this.mPaused = false;
        this.mExecutingTaskList = new HashMap();
        this.ExecutingTaskListRock = new Object();
        this.mLockManager = new LockManager();
        this.mThreadPoolCache = sThreadPoolCache;
        this.mCacheFileCache = CacheManager.getFileCacheService(this.mContext, "download_cache", 100, 50, false);
    }

    private boolean abortExecutingTask(String str) {
        if (!Utils.checkUrl(str)) {
            return false;
        }
        synchronized (this.ExecutingTaskListRock) {
            if (this.mExecutingTaskList.containsKey(str)) {
                List<WeakReference<DownloadTask>> list = this.mExecutingTaskList.get(str);
                this.mExecutingTaskList.remove(str);
                if (list != null) {
                    Iterator<WeakReference<DownloadTask>> it = list.iterator();
                    while (it.hasNext()) {
                        DownloadTask downloadTask = it.next().get();
                        if (downloadTask != null && str.equals(downloadTask.getUrl())) {
                            downloadTask.abort();
                        }
                    }
                }
            }
        }
        return true;
    }

    static /* synthetic */ int access$108() {
        int i3 = DownloadingHttp2TaskCount;
        DownloadingHttp2TaskCount = i3 + 1;
        return i3;
    }

    static /* synthetic */ int access$110() {
        int i3 = DownloadingHttp2TaskCount;
        DownloadingHttp2TaskCount = i3 - 1;
        return i3;
    }

    static /* synthetic */ int access$208() {
        int i3 = DownloadingHttpTaskCount;
        DownloadingHttpTaskCount = i3 + 1;
        return i3;
    }

    static /* synthetic */ int access$210() {
        int i3 = DownloadingHttpTaskCount;
        DownloadingHttpTaskCount = i3 - 1;
        return i3;
    }

    private boolean addPendingRequest(String str, String str2, DownloadRequest downloadRequest) {
        int i3;
        boolean z16 = false;
        if (downloadRequest == null) {
            return false;
        }
        synchronized (this.mPendingRequests) {
            this.mPendingRequests.sizeOf(str2);
            Collection<DownloadRequest> collection = (Collection) this.mPendingRequests.get(str2);
            if (collection != null) {
                i3 = 0;
                for (DownloadRequest downloadRequest2 : collection) {
                    if (downloadRequest2 != null && !downloadRequest2.isCanceled()) {
                        i3++;
                    }
                }
            } else {
                i3 = 0;
            }
            this.mPendingRequests.add(str2, downloadRequest);
            if (i3 == 0) {
                z16 = true;
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void beaconReport(DownloadReport downloadReport, DownloadResult.Status status, boolean z16) {
        String str;
        if (downloadReport != null && status != null) {
            String str2 = downloadReport.url;
            HashMap hashMap = new HashMap();
            hashMap.put("totalTime", String.valueOf(downloadReport.totaltime));
            hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME, String.valueOf(downloadReport.t_wait));
            hashMap.put("recvTime", String.valueOf(downloadReport.t_recvdata));
            hashMap.put("getIPTime", String.valueOf(downloadReport.t_prepare));
            hashMap.put(PreDownloadConstants.RPORT_KEY_REQ_TIME, String.valueOf(downloadReport.t_recvrsp));
            hashMap.put("fileSize", String.valueOf(downloadReport.fileSize));
            hashMap.put(DKEngine.GlobalKey.NET_WORK_TYPE, String.valueOf(NetworkState.g().getNetworkType()));
            hashMap.put("downloadUrl", String.valueOf(str2));
            hashMap.put("contentType", String.valueOf(downloadReport.content_type));
            hashMap.put("retryCount", String.valueOf(downloadReport.currAttempCount));
            hashMap.put("concurrent", String.valueOf(downloadReport.concurrent));
            hashMap.put("domain", String.valueOf(downloadReport.domain));
            hashMap.put("IPStrategy", String.valueOf(downloadReport.strategyId));
            hashMap.put(PreDownloadConstants.RPORT_KEY_DOWNLOAD_TIME, String.valueOf(downloadReport.downloadTime));
            long j3 = downloadReport.downloadTime;
            if (j3 != 0) {
                hashMap.put("downloadSpeed", String.valueOf((downloadReport.fileSize * 1000.0d) / j3));
            }
            long j16 = downloadReport.totaltime;
            if (j16 != 0) {
                hashMap.put("totalSpeed", String.valueOf((downloadReport.fileSize * 1000.0d) / j16));
            }
            if (downloadReport.isFromQzoneAlbum) {
                if (z16) {
                    hashMap.put("degradeToHttp", String.valueOf(!downloadReport.isHttp2 ? 1 : 0));
                    str = "actQZphotoDownloadH2";
                } else {
                    str = "actQZphotoDownloadAlbum";
                }
            } else {
                String str3 = downloadReport.url;
                if (str3 != null && str3.startsWith("https://")) {
                    str = "actQZphotoDownloadATS";
                } else {
                    str = "actQZphotoDownload";
                }
            }
            if (!downloadReport.isSucceed) {
                hashMap.put("httpRetCode", String.valueOf(status.failReason));
                hashMap.put("param_FailCode", String.valueOf(status.failReason));
                if (status.failException != null) {
                    hashMap.put("exception2Code", String.valueOf(status.exception2Code));
                }
                hashMap.put("httpStatus", String.valueOf(downloadReport.httpStatus));
            }
            Config.reportToBeacon(str, downloadReport.isSucceed, hashMap, downloadReport.totaltime);
        }
    }

    private MultiHashMap<String, DownloadRequest> collectAllPendingRequest(boolean z16, MultiHashMap<String, DownloadRequest> multiHashMap) {
        synchronized (this.mPendingRequests) {
            if (multiHashMap != null) {
                multiHashMap.clear();
            }
            if (this.mPendingRequests.isEmpty()) {
                return multiHashMap;
            }
            if (multiHashMap == null) {
                multiHashMap = new MultiHashMap<>();
            }
            multiHashMap.putAll(this.mPendingRequests);
            if (z16) {
                this.mPendingRequests.clear();
            }
            return multiHashMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Collection<DownloadRequest> collectPendingRequest(String str, boolean z16, Collection<DownloadRequest> collection) {
        Object obj;
        try {
            synchronized (this.mPendingRequests) {
                if (z16) {
                    obj = this.mPendingRequests.remove(str);
                } else {
                    obj = this.mPendingRequests.get(str);
                }
                HashSet hashSet = (HashSet) obj;
                if (collection != null) {
                    collection.clear();
                    if (hashSet != null) {
                        collection.addAll(hashSet);
                    }
                    return collection;
                }
                return hashSet;
            }
        } catch (Throwable unused) {
            return new ArrayList();
        }
    }

    private void enqueueTask(final DownloadTask downloadTask) {
        if (downloadTask == null || this.mPaused) {
            return;
        }
        PriorityThreadPool downloadThreadPool = getDownloadThreadPool(downloadTask.getUrl(), downloadTask.getDomain());
        downloadTask.onTaskEnqueue();
        Future<DownloadResult> submit = downloadThreadPool.submit(downloadTask, new FutureListener<DownloadResult>() { // from class: com.tencent.component.network.downloader.impl.DownloaderImpl.1
            @Override // com.tencent.component.network.utils.thread.FutureListener
            public void onFutureBegin(Future<DownloadResult> future) {
                boolean z16;
                if (downloadTask.mOriginalIsHttp2) {
                    DownloaderImpl.access$108();
                } else {
                    DownloaderImpl.access$208();
                }
                synchronized (DownloaderImpl.this.mLockManager.obtaionLock(downloadTask.getUrl())) {
                    synchronized (DownloaderImpl.this.ExecutingTaskListRock) {
                        WeakReference weakReference = new WeakReference(downloadTask);
                        List list = (List) DownloaderImpl.this.mExecutingTaskList.get(downloadTask.getUrl());
                        if (list == null) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(weakReference);
                            DownloaderImpl.this.mExecutingTaskList.put(downloadTask.getUrl(), arrayList);
                        } else {
                            Iterator it = list.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    WeakReference weakReference2 = (WeakReference) it.next();
                                    if (weakReference2 != null && ((DownloadTask) weakReference2.get()) == downloadTask) {
                                        z16 = false;
                                        break;
                                    }
                                } else {
                                    z16 = true;
                                    break;
                                }
                            }
                            if (z16) {
                                list.add(weakReference);
                            }
                        }
                    }
                }
            }

            /* JADX WARN: Can't wrap try/catch for region: R(8:(6:(3:208|209|(10:211|157|158|159|160|161|162|163|164|(2:171|172)(2:168|169)))|163|164|(1:166)|171|172)|156|157|158|159|160|161|162) */
            /* JADX WARN: Code restructure failed: missing block: B:201:0x039d, code lost:
            
                r0 = th;
             */
            /* JADX WARN: Code restructure failed: missing block: B:205:0x039f, code lost:
            
                r0 = th;
             */
            /* JADX WARN: Removed duplicated region for block: B:155:0x031f  */
            /* JADX WARN: Removed duplicated region for block: B:214:0x03a6  */
            /* JADX WARN: Removed duplicated region for block: B:272:0x04d7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Unreachable blocks removed: 2, instructions: 6 */
            @Override // com.tencent.component.network.utils.thread.FutureListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onFutureDone(Future<DownloadResult> future) {
                Object obj;
                LockManager lockManager;
                String url;
                File file;
                LockManager lockManager2;
                String url2;
                DownloadResult downloadResult;
                Collection collection;
                boolean z16;
                Collection collection2;
                File file2;
                boolean z17;
                Iterator it;
                boolean z18;
                boolean z19;
                int i3;
                String[] strArr;
                File file3;
                File file4;
                boolean copyFiles;
                boolean rename;
                StringBuilder sb5;
                LockManager lockManager3;
                String url3;
                List list;
                WeakReference weakReference;
                long j3;
                if (QDLog.isDebugEnable()) {
                    QDLog.d(DownloaderImpl.TAG, "download onFutureDone " + downloadTask.getUrl());
                }
                if (downloadTask.mOriginalIsHttp2) {
                    DownloaderImpl.access$110();
                } else {
                    DownloaderImpl.access$210();
                }
                String urlKey = downloadTask.getUrlKey();
                synchronized (DownloaderImpl.this.mFutures) {
                    DownloaderImpl.this.mFutures.remove(urlKey);
                }
                DownloadResult downloadResult2 = future.get();
                if (QDLog.isDebugEnable()) {
                    if (downloadResult2 != null) {
                        if (downloadResult2.getPath() != null) {
                            j3 = new File(downloadResult2.getPath()).length();
                        } else {
                            j3 = -1;
                        }
                        QDLog.d(DownloaderImpl.TAG, "download result: " + downloadResult2.getStatus().isSucceed() + " path:" + downloadResult2.getPath() + " length:" + j3);
                    } else {
                        QDLog.d(DownloaderImpl.TAG, "download result: null");
                    }
                }
                if (downloadResult2 != null) {
                    DownloadReport report = downloadResult2.getReport();
                    DownloadResult.Status status = downloadResult2.getStatus();
                    if (report != null && status != null) {
                        DownloaderImpl.beaconReport(report, status, downloadTask.mOriginalIsHttp2);
                    }
                }
                System.currentTimeMillis();
                Object obtaionLock = DownloaderImpl.this.mLockManager.obtaionLock(downloadTask.getUrl());
                synchronized (obtaionLock) {
                    try {
                        try {
                            synchronized (DownloaderImpl.this.ExecutingTaskListRock) {
                                try {
                                    try {
                                        file = null;
                                        if (DownloaderImpl.this.mExecutingTaskList.containsKey(downloadTask.getUrl()) && (list = (List) DownloaderImpl.this.mExecutingTaskList.get(downloadTask.getUrl())) != null) {
                                            Iterator it5 = list.iterator();
                                            while (true) {
                                                if (it5.hasNext()) {
                                                    weakReference = (WeakReference) it5.next();
                                                    if (weakReference != null && ((DownloadTask) weakReference.get()) == downloadTask) {
                                                        break;
                                                    }
                                                } else {
                                                    weakReference = null;
                                                    break;
                                                }
                                            }
                                            if (weakReference != null) {
                                                list.remove(weakReference);
                                                if (list.size() <= 0) {
                                                    DownloaderImpl.this.mExecutingTaskList.remove(downloadTask.getUrl());
                                                }
                                            }
                                        }
                                    } catch (Throwable th5) {
                                        th = th5;
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    while (true) {
                                        try {
                                            break;
                                        } catch (Throwable th7) {
                                            th = th7;
                                        }
                                    }
                                    throw th;
                                }
                            }
                            if (downloadResult2 != null && downloadResult2.getStatus().isRetrying()) {
                                if (QDLog.isDebugEnable()) {
                                    QDLog.d(DownloaderImpl.TAG, "download result: " + downloadTask.getUrl() + " isRetrying");
                                }
                                try {
                                    try {
                                        if (!future.isCancelled()) {
                                            if (((Downloader) DownloaderImpl.this).pResumeTransfer != null) {
                                                ((Downloader) DownloaderImpl.this).pResumeTransfer.onDownloadResult(downloadResult2.getUrl(), downloadResult2.getStatus().isSucceed());
                                            }
                                            if ((downloadResult2.getStatus().isSucceed() || ((Downloader) DownloaderImpl.this).pResumeTransfer == null) && !TextUtils.isEmpty(downloadResult2.getPath())) {
                                                FileUtils.delete(new File(downloadResult2.getPath()));
                                            }
                                        }
                                        lockManager3 = DownloaderImpl.this.mLockManager;
                                        url3 = downloadTask.getUrl();
                                    } catch (Throwable unused) {
                                        lockManager3 = DownloaderImpl.this.mLockManager;
                                        url3 = downloadTask.getUrl();
                                    }
                                    lockManager3.releaseLock(url3);
                                } catch (Throwable th8) {
                                    th = th8;
                                    obj = obtaionLock;
                                    throw th;
                                }
                            } else {
                                boolean z26 = true;
                                Collection collectPendingRequest = DownloaderImpl.this.collectPendingRequest(urlKey, true, null);
                                if (downloadResult2 != null && downloadResult2.getStatus().isSucceed()) {
                                    if (collectPendingRequest != null) {
                                        ArrayList arrayList = new ArrayList();
                                        File file5 = new File(downloadResult2.getPath());
                                        long length = file5.length();
                                        Iterator it6 = collectPendingRequest.iterator();
                                        boolean z27 = false;
                                        while (it6.hasNext()) {
                                            DownloadRequest downloadRequest = (DownloadRequest) it6.next();
                                            if (downloadRequest != null && !downloadRequest.isCanceled()) {
                                                if (downloadRequest.shouldCacheEntry()) {
                                                    z17 = z26;
                                                } else {
                                                    z17 = z27;
                                                }
                                                String[] paths = downloadRequest.getPaths();
                                                if (paths != null) {
                                                    int length2 = paths.length;
                                                    int i16 = 0;
                                                    while (true) {
                                                        if (i16 < length2) {
                                                            if (arrayList.contains(paths[i16])) {
                                                                z19 = true;
                                                                break;
                                                            }
                                                            i16++;
                                                        } else {
                                                            z19 = false;
                                                            break;
                                                        }
                                                    }
                                                    if (z19) {
                                                        z27 = z17;
                                                        z26 = true;
                                                    } else {
                                                        int length3 = paths.length;
                                                        int i17 = 0;
                                                        while (true) {
                                                            if (i17 < length3) {
                                                                String str = paths[i17];
                                                                if (TextUtils.isEmpty(str)) {
                                                                    downloadResult = downloadResult2;
                                                                    obj = obtaionLock;
                                                                    collection2 = collectPendingRequest;
                                                                    i3 = length3;
                                                                } else {
                                                                    i3 = length3;
                                                                    if (!DownloaderImpl.this.handleDownloadFile(downloadResult2, downloadRequest) && downloadResult2.getPath() != null && !arrayList.contains(str)) {
                                                                        int i18 = 1;
                                                                        boolean z28 = false;
                                                                        while (i18 >= 0 && !z28) {
                                                                            i18--;
                                                                            it = it6;
                                                                            try {
                                                                                File file6 = new File(str);
                                                                                try {
                                                                                    try {
                                                                                        try {
                                                                                            if (file != null) {
                                                                                                try {
                                                                                                    if (file.exists()) {
                                                                                                        downloadResult = downloadResult2;
                                                                                                        obj = obtaionLock;
                                                                                                        collection2 = collectPendingRequest;
                                                                                                        z18 = z17;
                                                                                                        strArr = paths;
                                                                                                        if (z28) {
                                                                                                            try {
                                                                                                                if (file != null) {
                                                                                                                    try {
                                                                                                                        if (file.exists()) {
                                                                                                                            file4 = file;
                                                                                                                            copyFiles = FileUtils.copyFiles(file4, file6);
                                                                                                                            long length4 = file6.length();
                                                                                                                            file3 = file;
                                                                                                                            StringBuilder sb6 = new StringBuilder();
                                                                                                                            file2 = file5;
                                                                                                                            sb6.append("download file copy from ");
                                                                                                                            sb6.append(file4.getPath());
                                                                                                                            sb6.append(" to:");
                                                                                                                            sb6.append(str);
                                                                                                                            sb6.append(" ");
                                                                                                                            sb6.append(downloadTask.getUrl());
                                                                                                                            sb6.append(" result:");
                                                                                                                            sb6.append(copyFiles);
                                                                                                                            sb6.append(" src-length:");
                                                                                                                            sb6.append(length);
                                                                                                                            sb6.append(" dst-length:");
                                                                                                                            sb6.append(length4);
                                                                                                                            sb6.append(" retry:");
                                                                                                                            sb6.append(i18);
                                                                                                                            QDLog.i(DownloaderImpl.TAG, sb6.toString());
                                                                                                                            if (!copyFiles && length == length4) {
                                                                                                                                z28 = true;
                                                                                                                            } else {
                                                                                                                                FileUtils.delete(file6);
                                                                                                                            }
                                                                                                                        }
                                                                                                                    } catch (Throwable th9) {
                                                                                                                        th = th9;
                                                                                                                        file2 = file5;
                                                                                                                        try {
                                                                                                                            QDLog.w(DownloaderImpl.TAG, "download ------- copy exception!!! " + downloadTask.getUrl(), th);
                                                                                                                            i17++;
                                                                                                                            length3 = i3;
                                                                                                                            it6 = it;
                                                                                                                            z17 = z18;
                                                                                                                            paths = strArr;
                                                                                                                            collectPendingRequest = collection2;
                                                                                                                            obtaionLock = obj;
                                                                                                                            downloadResult2 = downloadResult;
                                                                                                                            file5 = file2;
                                                                                                                        } catch (Throwable th10) {
                                                                                                                            th = th10;
                                                                                                                            downloadResult2 = downloadResult;
                                                                                                                            if (downloadResult2 != null) {
                                                                                                                                try {
                                                                                                                                    if (!future.isCancelled()) {
                                                                                                                                        if (((Downloader) DownloaderImpl.this).pResumeTransfer != null) {
                                                                                                                                            ((Downloader) DownloaderImpl.this).pResumeTransfer.onDownloadResult(downloadResult2.getUrl(), downloadResult2.getStatus().isSucceed());
                                                                                                                                        }
                                                                                                                                        if ((downloadResult2.getStatus().isSucceed() || ((Downloader) DownloaderImpl.this).pResumeTransfer == null) && !TextUtils.isEmpty(downloadResult2.getPath())) {
                                                                                                                                            FileUtils.delete(new File(downloadResult2.getPath()));
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                } catch (Throwable unused2) {
                                                                                                                                    lockManager = DownloaderImpl.this.mLockManager;
                                                                                                                                    url = downloadTask.getUrl();
                                                                                                                                    lockManager.releaseLock(url);
                                                                                                                                    throw th;
                                                                                                                                }
                                                                                                                            }
                                                                                                                            lockManager = DownloaderImpl.this.mLockManager;
                                                                                                                            url = downloadTask.getUrl();
                                                                                                                            lockManager.releaseLock(url);
                                                                                                                            throw th;
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                                sb6.append("download file copy from ");
                                                                                                                sb6.append(file4.getPath());
                                                                                                                sb6.append(" to:");
                                                                                                                sb6.append(str);
                                                                                                                sb6.append(" ");
                                                                                                                sb6.append(downloadTask.getUrl());
                                                                                                                sb6.append(" result:");
                                                                                                                sb6.append(copyFiles);
                                                                                                                sb6.append(" src-length:");
                                                                                                                sb6.append(length);
                                                                                                                sb6.append(" dst-length:");
                                                                                                                sb6.append(length4);
                                                                                                                sb6.append(" retry:");
                                                                                                                sb6.append(i18);
                                                                                                                QDLog.i(DownloaderImpl.TAG, sb6.toString());
                                                                                                                if (!copyFiles) {
                                                                                                                }
                                                                                                                FileUtils.delete(file6);
                                                                                                            } catch (Throwable th11) {
                                                                                                                th = th11;
                                                                                                                file = file3;
                                                                                                                QDLog.w(DownloaderImpl.TAG, "download ------- copy exception!!! " + downloadTask.getUrl(), th);
                                                                                                                i17++;
                                                                                                                length3 = i3;
                                                                                                                it6 = it;
                                                                                                                z17 = z18;
                                                                                                                paths = strArr;
                                                                                                                collectPendingRequest = collection2;
                                                                                                                obtaionLock = obj;
                                                                                                                downloadResult2 = downloadResult;
                                                                                                                file5 = file2;
                                                                                                            }
                                                                                                            file4 = file5;
                                                                                                            copyFiles = FileUtils.copyFiles(file4, file6);
                                                                                                            long length42 = file6.length();
                                                                                                            file3 = file;
                                                                                                            StringBuilder sb62 = new StringBuilder();
                                                                                                            file2 = file5;
                                                                                                        } else {
                                                                                                            file3 = file;
                                                                                                            file2 = file5;
                                                                                                        }
                                                                                                        it6 = it;
                                                                                                        file = file3;
                                                                                                        z17 = z18;
                                                                                                        paths = strArr;
                                                                                                        collectPendingRequest = collection2;
                                                                                                        obtaionLock = obj;
                                                                                                        downloadResult2 = downloadResult;
                                                                                                        file5 = file2;
                                                                                                    }
                                                                                                } catch (Throwable th12) {
                                                                                                    th = th12;
                                                                                                    downloadResult = downloadResult2;
                                                                                                    obj = obtaionLock;
                                                                                                    collection2 = collectPendingRequest;
                                                                                                    file2 = file5;
                                                                                                    z18 = z17;
                                                                                                    strArr = paths;
                                                                                                    QDLog.w(DownloaderImpl.TAG, "download ------- copy exception!!! " + downloadTask.getUrl(), th);
                                                                                                    i17++;
                                                                                                    length3 = i3;
                                                                                                    it6 = it;
                                                                                                    z17 = z18;
                                                                                                    paths = strArr;
                                                                                                    collectPendingRequest = collection2;
                                                                                                    obtaionLock = obj;
                                                                                                    downloadResult2 = downloadResult;
                                                                                                    file5 = file2;
                                                                                                }
                                                                                            }
                                                                                            sb5.append("download file rename from ");
                                                                                            sb5.append(file5.getPath());
                                                                                            sb5.append(" to:");
                                                                                            sb5.append(str);
                                                                                            sb5.append(" ");
                                                                                            sb5.append(downloadTask.getUrl());
                                                                                            sb5.append(" result:");
                                                                                            sb5.append(rename);
                                                                                            sb5.append(" src-length:");
                                                                                            sb5.append(length);
                                                                                            sb5.append(" dst-length:");
                                                                                            downloadResult = downloadResult2;
                                                                                            obj = obtaionLock;
                                                                                            sb5.append(file6.length());
                                                                                            QDLog.i(DownloaderImpl.TAG, sb5.toString());
                                                                                            file = file3;
                                                                                            if (z28) {
                                                                                            }
                                                                                            it6 = it;
                                                                                            file = file3;
                                                                                            z17 = z18;
                                                                                            paths = strArr;
                                                                                            collectPendingRequest = collection2;
                                                                                            obtaionLock = obj;
                                                                                            downloadResult2 = downloadResult;
                                                                                            file5 = file2;
                                                                                        } catch (Throwable th13) {
                                                                                            th = th13;
                                                                                            downloadResult = downloadResult2;
                                                                                            obj = obtaionLock;
                                                                                            file2 = file5;
                                                                                            file = file3;
                                                                                            QDLog.w(DownloaderImpl.TAG, "download ------- copy exception!!! " + downloadTask.getUrl(), th);
                                                                                            i17++;
                                                                                            length3 = i3;
                                                                                            it6 = it;
                                                                                            z17 = z18;
                                                                                            paths = strArr;
                                                                                            collectPendingRequest = collection2;
                                                                                            obtaionLock = obj;
                                                                                            downloadResult2 = downloadResult;
                                                                                            file5 = file2;
                                                                                        }
                                                                                        sb5 = new StringBuilder();
                                                                                        collection2 = collectPendingRequest;
                                                                                    } catch (Throwable th14) {
                                                                                        th = th14;
                                                                                        downloadResult = downloadResult2;
                                                                                        obj = obtaionLock;
                                                                                        collection2 = collectPendingRequest;
                                                                                    }
                                                                                    rename = FileUtils.rename(file5, file6);
                                                                                    if (rename) {
                                                                                        file3 = file6;
                                                                                        z18 = z17;
                                                                                        z28 = true;
                                                                                    } else {
                                                                                        z18 = z17;
                                                                                    }
                                                                                    strArr = paths;
                                                                                } catch (Throwable th15) {
                                                                                    th = th15;
                                                                                    downloadResult = downloadResult2;
                                                                                    obj = obtaionLock;
                                                                                    collection2 = collectPendingRequest;
                                                                                    file2 = file5;
                                                                                    z18 = z17;
                                                                                    strArr = paths;
                                                                                    file = file3;
                                                                                    QDLog.w(DownloaderImpl.TAG, "download ------- copy exception!!! " + downloadTask.getUrl(), th);
                                                                                    i17++;
                                                                                    length3 = i3;
                                                                                    it6 = it;
                                                                                    z17 = z18;
                                                                                    paths = strArr;
                                                                                    collectPendingRequest = collection2;
                                                                                    obtaionLock = obj;
                                                                                    downloadResult2 = downloadResult;
                                                                                    file5 = file2;
                                                                                }
                                                                                file3 = file;
                                                                            } catch (Throwable th16) {
                                                                                th = th16;
                                                                                downloadResult = downloadResult2;
                                                                                obj = obtaionLock;
                                                                                collection2 = collectPendingRequest;
                                                                            }
                                                                        }
                                                                        downloadResult = downloadResult2;
                                                                        obj = obtaionLock;
                                                                        collection2 = collectPendingRequest;
                                                                        File file7 = file;
                                                                        file2 = file5;
                                                                        it = it6;
                                                                        z18 = z17;
                                                                        strArr = paths;
                                                                        if (z28) {
                                                                            arrayList.add(str);
                                                                            file = file7;
                                                                            break;
                                                                        }
                                                                        FileUtils.delete(new File(str));
                                                                        file = file7;
                                                                        i17++;
                                                                        length3 = i3;
                                                                        it6 = it;
                                                                        z17 = z18;
                                                                        paths = strArr;
                                                                        collectPendingRequest = collection2;
                                                                        obtaionLock = obj;
                                                                        downloadResult2 = downloadResult;
                                                                        file5 = file2;
                                                                    } else {
                                                                        downloadResult = downloadResult2;
                                                                        obj = obtaionLock;
                                                                        collection2 = collectPendingRequest;
                                                                    }
                                                                }
                                                                file2 = file5;
                                                                it = it6;
                                                                z18 = z17;
                                                                strArr = paths;
                                                                i17++;
                                                                length3 = i3;
                                                                it6 = it;
                                                                z17 = z18;
                                                                paths = strArr;
                                                                collectPendingRequest = collection2;
                                                                obtaionLock = obj;
                                                                downloadResult2 = downloadResult;
                                                                file5 = file2;
                                                            } else {
                                                                downloadResult = downloadResult2;
                                                                obj = obtaionLock;
                                                                collection2 = collectPendingRequest;
                                                                file2 = file5;
                                                                it = it6;
                                                                z18 = z17;
                                                                break;
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    downloadResult = downloadResult2;
                                                    obj = obtaionLock;
                                                    collection2 = collectPendingRequest;
                                                    file2 = file5;
                                                    it = it6;
                                                    z18 = z17;
                                                    if (downloadRequest.outputStream != null) {
                                                        FileUtils.copyFile(downloadResult.getPath(), downloadRequest.outputStream);
                                                    }
                                                }
                                                it6 = it;
                                                z27 = z18;
                                                collectPendingRequest = collection2;
                                                obtaionLock = obj;
                                                downloadResult2 = downloadResult;
                                                file5 = file2;
                                                z26 = true;
                                            }
                                            downloadResult = downloadResult2;
                                            obj = obtaionLock;
                                            collection2 = collectPendingRequest;
                                            file2 = file5;
                                            it6 = it6;
                                            collectPendingRequest = collection2;
                                            obtaionLock = obj;
                                            downloadResult2 = downloadResult;
                                            file5 = file2;
                                            z26 = true;
                                        }
                                        downloadResult = downloadResult2;
                                        obj = obtaionLock;
                                        collection = collectPendingRequest;
                                        z16 = z27;
                                    } else {
                                        downloadResult = downloadResult2;
                                        obj = obtaionLock;
                                        collection = collectPendingRequest;
                                        z16 = false;
                                    }
                                    downloadResult2 = downloadResult;
                                    DownloaderImpl.this.notifyDownloadSucceed(collection, downloadResult2);
                                    if (z16) {
                                        DownloaderImpl.this.addCacheEntry(downloadTask.getUrl(), downloadResult2);
                                    }
                                    if (downloadResult2 != null) {
                                        try {
                                            if (!future.isCancelled()) {
                                                if (((Downloader) DownloaderImpl.this).pResumeTransfer != null) {
                                                    ((Downloader) DownloaderImpl.this).pResumeTransfer.onDownloadResult(downloadResult2.getUrl(), downloadResult2.getStatus().isSucceed());
                                                }
                                                if ((downloadResult2.getStatus().isSucceed() || ((Downloader) DownloaderImpl.this).pResumeTransfer == null) && !TextUtils.isEmpty(downloadResult2.getPath())) {
                                                    FileUtils.delete(new File(downloadResult2.getPath()));
                                                }
                                            }
                                        } catch (Throwable unused3) {
                                            lockManager2 = DownloaderImpl.this.mLockManager;
                                            url2 = downloadTask.getUrl();
                                        }
                                    }
                                    lockManager2 = DownloaderImpl.this.mLockManager;
                                    url2 = downloadTask.getUrl();
                                    lockManager2.releaseLock(url2);
                                }
                                obj = obtaionLock;
                                if (!DownloaderImpl.this.handleRangeModeFail(downloadTask)) {
                                    DownloaderImpl.this.notifyDownloadFailed(collectPendingRequest, downloadResult2);
                                }
                                if (downloadResult2 != null) {
                                }
                                lockManager2 = DownloaderImpl.this.mLockManager;
                                url2 = downloadTask.getUrl();
                                lockManager2.releaseLock(url2);
                            }
                        } catch (Throwable th17) {
                            th = th17;
                            obj = obtaionLock;
                        }
                    } catch (Throwable th18) {
                        th = th18;
                        throw th;
                    }
                }
            }
        }, downloadTask.getPriority());
        synchronized (this.mFutures) {
            this.mFutures.put(downloadTask.getUrlKey(), submit);
        }
    }

    private PriorityThreadPool getDownloadThreadPool(String str, String str2) {
        boolean z16;
        DownloadPreprocessStrategy.DownloadPool downloadPool;
        if (str != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        AssertUtil.assertTrue(z16);
        PriorityThreadPool priorityThreadPool = this.pExternalThreadPool;
        if (priorityThreadPool != null) {
            return priorityThreadPool;
        }
        DownloadPreprocessStrategy downloadPreprocessStrategy = this.pProcessStrategy;
        if (downloadPreprocessStrategy != null) {
            downloadPool = downloadPreprocessStrategy.downloadPool(str, str2);
        } else {
            downloadPool = null;
        }
        if (downloadPool == null) {
            downloadPool = DEFAULT_THREAD_POOL;
        }
        return this.mThreadPoolCache.get(downloadPool.getName());
    }

    public static PriorityThreadPool getWorkThreadPool() {
        return PriorityThreadPool.getDefault();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleDownloadFile(DownloadResult downloadResult, DownloadRequest downloadRequest) {
        FileHandler fileHandler;
        if (downloadRequest == null || (fileHandler = this.pFileHandler) == null) {
            return false;
        }
        return fileHandler.handleFile(downloadResult.getPath(), downloadRequest.getPath());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleRangeModeFail(DownloadTask downloadTask) {
        DownloadRequest downloadRequest;
        if ((downloadTask instanceof RangeDownloadTask) && (downloadRequest = downloadTask.getDownloadRequest()) != null) {
            QDLog.w(QDLog.TAG_DOWNLOAD_RANGE, "download fail, retry on  StrictMode, url:" + downloadRequest.getUrl());
            downloadRequest.mode = Downloader.DownloadMode.StrictMode;
            download(downloadRequest, true);
            return true;
        }
        return false;
    }

    private boolean isDownloading(String str) {
        boolean z16 = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        synchronized (this.ExecutingTaskListRock) {
            List<WeakReference<DownloadTask>> list = this.mExecutingTaskList.get(str);
            if (list != null && list.size() > 0) {
                z16 = true;
            }
        }
        return z16;
    }

    private void notifyDownloadCanceled(Collection<DownloadRequest> collection) {
        Downloader.DownloadListener listener;
        if (collection == null) {
            return;
        }
        for (DownloadRequest downloadRequest : collection) {
            if (downloadRequest != null && !downloadRequest.isCanceled() && (listener = downloadRequest.getListener()) != null) {
                listener.onDownloadCanceled(downloadRequest.getUrl());
                Global.dispatchOnDownloadCanceled(downloadRequest.getUrl());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDownloadFailed(Collection<DownloadRequest> collection, DownloadResult downloadResult) {
        if (collection == null) {
            return;
        }
        for (DownloadRequest downloadRequest : collection) {
            if (downloadRequest != null && downloadRequest.getListener() != null) {
                downloadRequest.getListener().onDownloadFailed(downloadRequest.getUrl(), downloadResult);
                Global.dispatchOnDownloadFailed(downloadRequest.getUrl(), downloadResult);
            }
        }
    }

    private void notifyDownloadProgress(Collection<DownloadRequest> collection, long j3, float f16) {
        Downloader.DownloadListener listener;
        if (collection == null) {
            return;
        }
        for (DownloadRequest downloadRequest : collection) {
            if (downloadRequest != null && !downloadRequest.isCanceled() && (listener = downloadRequest.getListener()) != null) {
                listener.onDownloadProgress(downloadRequest.getUrl(), j3, f16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDownloadSucceed(Collection<DownloadRequest> collection, DownloadResult downloadResult) {
        if (collection == null) {
            return;
        }
        for (DownloadRequest downloadRequest : collection) {
            if (downloadRequest != null && downloadRequest.getListener() != null && !downloadRequest.isCanceled()) {
                downloadRequest.getListener().onDownloadSucceed(downloadRequest.getUrl(), downloadResult);
                Global.dispatchOnDownloadSucceed(downloadRequest.getUrl(), downloadResult);
            }
        }
    }

    private void notifyHeaderRequest(Collection<DownloadRequest> collection, int i3, Map<String, List<String>> map) {
        if (collection == null) {
            return;
        }
        for (DownloadRequest downloadRequest : collection) {
            if (downloadRequest != null && !downloadRequest.isCanceled()) {
                Downloader.DownloadListener listener = downloadRequest.getListener();
                if (listener instanceof Downloader.MiniDownloadListener) {
                    ((Downloader.MiniDownloadListener) listener).onDownloadHeadersReceived(downloadRequest.getUrl(), i3, map);
                }
            }
        }
    }

    private void notifyStreamDownloadProgress(Collection<DownloadRequest> collection, String str) {
        Downloader.StreamDownloadListener streamDownloadListener;
        if (collection == null) {
            return;
        }
        for (DownloadRequest downloadRequest : collection) {
            if (downloadRequest != null && !downloadRequest.isCanceled() && (downloadRequest.getListener() instanceof Downloader.StreamDownloadListener) && (streamDownloadListener = (Downloader.StreamDownloadListener) downloadRequest.getListener()) != null) {
                streamDownloadListener.onStreamDownloadProgress(downloadRequest.getUrl(), str);
            }
        }
    }

    private OkHttpClient obtainHttp2Client() {
        OkHttpClient okHttpClient = this.mOkClient;
        if (okHttpClient != null) {
            return okHttpClient;
        }
        synchronized (this) {
            OkHttpClient okHttpClient2 = this.mOkClient;
            if (okHttpClient2 != null) {
                return okHttpClient2;
            }
            HttpUtil.ClientOptions clientOptions = new HttpUtil.ClientOptions();
            clientOptions.multiConnection = true;
            clientOptions.maxConnection = MAX_CONNECTION;
            clientOptions.maxConnectionPerRoute = MAX_CONNECTION_PER_ROUTE;
            clientOptions.timeToLive = TIME_TO_LIVE_HTTP2;
            CustomDnsResolve customDnsResolve = new CustomDnsResolve();
            customDnsResolve.addIpStrategy(this.pDirectIPConfig);
            customDnsResolve.addIpStrategy(this.pBackupIPConfig);
            OkHttpClient createHttp2Client = HttpUtil.createHttp2Client(clientOptions, customDnsResolve);
            this.mOkClient = createHttp2Client;
            return createHttp2Client;
        }
    }

    private QZoneHttpClient obtainHttpClient() {
        QZoneHttpClient qZoneHttpClient = this.mHttpClient;
        if (qZoneHttpClient != null) {
            return qZoneHttpClient;
        }
        synchronized (this) {
            QZoneHttpClient qZoneHttpClient2 = this.mHttpClient;
            if (qZoneHttpClient2 != null) {
                return qZoneHttpClient2;
            }
            if (this.pHttpsIpDirectEnable) {
                CustomDnsResolve customDnsResolve = new CustomDnsResolve();
                customDnsResolve.addIpStrategy(this.pDirectIPConfig);
                customDnsResolve.addIpStrategy(this.pBackupIPConfig);
                this.mHttpClient = HttpUtil.CreateDefaultHttpClient(customDnsResolve);
            } else {
                this.mHttpClient = HttpUtil.CreateDefaultHttpClient();
            }
            return this.mHttpClient;
        }
    }

    private boolean removePendingRequest(String str, DownloadRequest downloadRequest, Collection<DownloadRequest> collection) {
        int i3;
        boolean z16 = false;
        if (downloadRequest == null) {
            return false;
        }
        synchronized (this.mPendingRequests) {
            int sizeOf = this.mPendingRequests.sizeOf(str);
            if (collection != null) {
                collection.clear();
            }
            Collection<DownloadRequest> collection2 = (Collection) this.mPendingRequests.get(str);
            if (collection2 != null) {
                i3 = 0;
                for (DownloadRequest downloadRequest2 : collection2) {
                    if (downloadRequest.equals(downloadRequest2)) {
                        downloadRequest2.cancel();
                        if (collection != null) {
                            collection.add(downloadRequest);
                        }
                    }
                    if (downloadRequest2 != null && !downloadRequest2.isCanceled()) {
                        i3++;
                    }
                }
            } else {
                i3 = 0;
            }
            if (sizeOf > 0 && i3 == 0) {
                z16 = true;
            }
        }
        return z16;
    }

    @Override // com.tencent.component.network.downloader.Downloader
    public void abort(String str, Downloader.DownloadListener downloadListener) {
        Future<DownloadResult> remove;
        if (QDLog.isInfoEnable()) {
            QDLog.i(TAG, "download abort url:" + str + " listener:" + downloadListener);
        }
        String generateUrlKey = generateUrlKey(str);
        synchronized (this.mFutures) {
            remove = this.mFutures.remove(generateUrlKey);
        }
        if (remove != null) {
            remove.cancel();
        }
        abortExecutingTask(str);
        ArrayList arrayList = new ArrayList();
        collectPendingRequest(generateUrlKey, true, arrayList);
        notifyDownloadCanceled(arrayList);
    }

    public void addCacheEntry(String str, DownloadResult downloadResult) {
        String generateStorageName = generateStorageName(str);
        String path = this.mCacheFileCache.getPath(generateStorageName);
        try {
            File file = new File(downloadResult.getPath());
            boolean copyFiles = FileUtils.copyFiles(file, new File(path));
            if (!copyFiles) {
                path = this.mCacheFileCache.getPath(generateStorageName, false);
                copyFiles = FileUtils.copyFiles(file, new File(path));
            }
            if (QDLog.isInfoEnable()) {
                QDLog.i(TAG, "download cache entry to: " + path + " " + str + " result:" + copyFiles);
            }
        } catch (Throwable th5) {
            QDLog.w(TAG, "download ------- copy exception!!! " + str, th5);
        }
    }

    @Override // com.tencent.component.network.downloader.Downloader
    public void cancel(String str, Downloader.DownloadListener downloadListener) {
        Future<DownloadResult> remove;
        if (Utils.checkUrl(str)) {
            String generateUrlKey = generateUrlKey(str);
            DownloadRequest downloadRequest = new DownloadRequest(str, new String[0], false, downloadListener);
            ArrayList arrayList = new ArrayList();
            if (removePendingRequest(generateUrlKey, downloadRequest, arrayList)) {
                synchronized (this.mFutures) {
                    remove = this.mFutures.remove(generateUrlKey);
                }
                if (remove != null && !isDownloading(str)) {
                    remove.cancel();
                }
            }
            notifyDownloadCanceled(arrayList);
        }
    }

    @Override // com.tencent.component.network.downloader.Downloader
    public void cancelAll() {
        cancel();
    }

    @Override // com.tencent.component.network.downloader.Downloader
    public void cleanCache(String str) {
        this.mCacheFileCache.deleteFile(generateStorageFileName(str));
        ResumeTransfer resumeTransfer = this.pResumeTransfer;
        if (resumeTransfer != null) {
            resumeTransfer.cleanCache(str);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r9v2 ??, still in use, count: 1, list:
          (r9v2 ?? I:com.tencent.component.network.downloader.impl.DownloadTask) from 0x00d7: INVOKE 
          (r9v2 ?? I:com.tencent.component.network.downloader.impl.DownloadTask)
          (r23v0 ?? I:com.tencent.component.network.downloader.DownloadRequest)
         VIRTUAL call: com.tencent.component.network.downloader.impl.DownloadTask.setDownloadRequest(com.tencent.component.network.downloader.DownloadRequest):void A[MD:(com.tencent.component.network.downloader.DownloadRequest):void (m)] (LINE:216)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:88)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:87)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:72)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:54)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:34)
        */
    @Override // com.tencent.component.network.downloader.Downloader
    public boolean download(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r9v2 ??, still in use, count: 1, list:
          (r9v2 ?? I:com.tencent.component.network.downloader.impl.DownloadTask) from 0x00d7: INVOKE 
          (r9v2 ?? I:com.tencent.component.network.downloader.impl.DownloadTask)
          (r23v0 ?? I:com.tencent.component.network.downloader.DownloadRequest)
         VIRTUAL call: com.tencent.component.network.downloader.impl.DownloadTask.setDownloadRequest(com.tencent.component.network.downloader.DownloadRequest):void A[MD:(com.tencent.component.network.downloader.DownloadRequest):void (m)] (LINE:216)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:88)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:87)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:72)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:54)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r23v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:237)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:223)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:168)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        */

    @Override // com.tencent.component.network.downloader.impl.DownloadTask.DownloadTaskHandler
    public String findCacheEntryPath(String str) {
        File file = this.mCacheFileCache.getFile(generateStorageName(str));
        if (file != null && file.exists()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    @Override // com.tencent.component.network.downloader.impl.DownloadTask.DownloadTaskHandler
    public String generateStorageFileName(String str) {
        return super.generateStorageName(str);
    }

    @Override // com.tencent.component.network.downloader.impl.DownloadTask.DownloadTaskHandler
    public Proxy getCustomProxy() {
        return getMobileProxy();
    }

    @Override // com.tencent.component.network.downloader.impl.DownloadTask.DownloadTaskHandler
    public int getHttp2TaskConcurrentCount() {
        return DownloadingHttp2TaskCount;
    }

    @Override // com.tencent.component.network.downloader.impl.DownloadTask.DownloadTaskHandler
    public int getHttpTaskConcurrentCount() {
        return DownloadingHttpTaskCount;
    }

    @Override // com.tencent.component.network.downloader.impl.DownloadTask.DownloadTaskHandler
    public boolean handleContentType(DownloadResult downloadResult, HttpResponse httpResponse, Response response) {
        ContentHandler contentHandler = this.pContentHandler;
        if (contentHandler != null) {
            return contentHandler.handleContentType(downloadResult, httpResponse, response);
        }
        return true;
    }

    @Override // com.tencent.component.network.downloader.impl.DownloadTask.DownloadTaskHandler
    public void handleDownloadProgress(String str, long j3, float f16) {
        notifyDownloadProgress(collectPendingRequest(str, false, new ArrayList()), j3, f16);
    }

    @Override // com.tencent.component.network.downloader.impl.DownloadTask.DownloadTaskHandler
    public void handleKeepAliveStrategy(String str, String str2, HttpRequest httpRequest, Request.Builder builder, HttpUtil.RequestOptions requestOptions) {
        boolean z16;
        KeepAliveStrategy.KeepAlive keepAlive;
        if (str != null && str2 != null && (builder != null || httpRequest != null)) {
            z16 = true;
        } else {
            z16 = false;
        }
        AssertUtil.assertTrue(z16);
        KeepAliveStrategy keepAliveStrategy = this.pKeepAliveStrategy;
        if (keepAliveStrategy != null) {
            keepAlive = keepAliveStrategy.keepAlive(str2, httpRequest, requestOptions);
        } else {
            keepAlive = null;
        }
        if (keepAlive == null) {
            if (HttpUtil.containsProxy(httpRequest, requestOptions)) {
                keepAlive = DEFAULT_KEEP_ALIVE_PROXY;
            } else {
                keepAlive = DEFAULT_KEEP_ALIVE;
            }
        }
        int i3 = AnonymousClass2.$SwitchMap$com$tencent$component$network$downloader$strategy$KeepAliveStrategy$KeepAlive[keepAlive.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                HttpUtil.setKeepAliveEnabled(httpRequest, builder, false);
                return;
            }
            return;
        }
        HttpUtil.setKeepAliveEnabled(httpRequest, builder, true);
    }

    @Override // com.tencent.component.network.downloader.impl.DownloadTask.DownloadTaskHandler
    public void handlePrepareRequest(String str, String str2, HttpRequest httpRequest, Request.Builder builder, int i3) {
        DownloadPreprocessStrategy downloadPreprocessStrategy = this.pProcessStrategy;
        if (downloadPreprocessStrategy != null) {
            downloadPreprocessStrategy.prepareRequest(str, str2, httpRequest, builder, i3);
        }
    }

    @Override // com.tencent.component.network.downloader.impl.DownloadTask.DownloadTaskHandler
    public void handleRequestHeader(String str, int i3, Map<String, List<String>> map) {
        notifyHeaderRequest(collectPendingRequest(str, false, null), i3, map);
    }

    @Override // com.tencent.component.network.downloader.impl.DownloadTask.DownloadTaskHandler
    public void handleStreamDownloadProgress(String str, String str2) {
        notifyStreamDownloadProgress(collectPendingRequest(str, false, new ArrayList()), str2);
    }

    public void pause() {
        this.mPaused = true;
    }

    @Override // com.tencent.component.network.downloader.Downloader
    public void preConnectHost(ArrayList<String> arrayList, String str) {
        PreConnectManager.connectHost(obtainHttp2Client(), arrayList, str);
    }

    @Override // com.tencent.component.network.downloader.impl.DownloadTask.DownloadTaskHandler
    public String prepareRequestUrl(String str) {
        DownloadPreprocessStrategy downloadPreprocessStrategy = this.pProcessStrategy;
        if (downloadPreprocessStrategy == null) {
            return null;
        }
        return downloadPreprocessStrategy.prepareUrl(str);
    }

    public void resume() {
        this.mPaused = false;
    }

    @Override // com.tencent.component.network.downloader.Downloader
    public void setHttpConnectionParam(int i3, int i16) {
        super.setHttpConnectionParam(i3, i16);
        int i17 = this.pMaxConnectionPerRoute;
        if (i17 > 0) {
            MAX_CONNECTION_PER_ROUTE = i17;
        }
        int i18 = this.pMaxConnection;
        if (i18 > 0) {
            MAX_CONNECTION = i18;
        }
    }

    @Override // com.tencent.component.network.downloader.Downloader
    public void cleanCache() {
        this.mCacheFileCache.clear();
        ResumeTransfer resumeTransfer = this.pResumeTransfer;
        if (resumeTransfer != null) {
            resumeTransfer.cleanCache();
        }
    }

    public void cancel() {
        ArrayList arrayList = null;
        MultiHashMap<String, DownloadRequest> collectAllPendingRequest = collectAllPendingRequest(true, null);
        synchronized (this.mFutures) {
            if (!this.mFutures.isEmpty()) {
                arrayList = new ArrayList(this.mFutures.values());
                this.mFutures.clear();
            }
        }
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Future future = (Future) it.next();
                if (future != null) {
                    future.cancel();
                }
            }
        }
        abortAll();
        if (collectAllPendingRequest != null) {
            for (String str : collectAllPendingRequest.keySet()) {
                if (str != null) {
                    notifyDownloadCanceled((Collection) collectAllPendingRequest.get(str));
                }
            }
        }
    }

    public void abortAll() {
    }
}
