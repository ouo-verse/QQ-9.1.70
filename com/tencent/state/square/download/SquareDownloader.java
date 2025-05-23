package com.tencent.state.square.download;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.state.square.IDownloadListener;
import com.tencent.state.square.IHttpDownloader;
import com.tencent.state.square.IZPlanRecorder;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.cache.IDiskCache;
import com.tencent.state.square.download.SquareDownloader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\nH\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\rH\u0002J\u000e\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\rR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/tencent/state/square/download/SquareDownloader;", "", "diskCache", "Lcom/tencent/state/square/cache/IDiskCache;", "(Lcom/tencent/state/square/cache/IDiskCache;)V", "getDiskCache", "()Lcom/tencent/state/square/cache/IDiskCache;", "setDiskCache", "downloadQueue", "Ljava/util/PriorityQueue;", "Lcom/tencent/state/square/download/TaskRequest;", "downloadingMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "addDownloadTask", "", "source", "Lcom/tencent/state/square/download/Source;", "callback", "Lcom/tencent/state/square/download/DownloadCallback;", "priority", "", "addHighTask", "addNormalTask", "download", Const.BUNDLE_KEY_REQUEST, "onDownloadComplete", "", "key", "removeCallback", "url", "Companion", "Reporter", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final class SquareDownloader {
    private static final int MAX_DOWNLOAD_COUNT = 5;
    private static final int PRIORITY_HIGH = 2;
    private static final int PRIORITY_NORMAL = 1;
    private static final String TAG = "Square_SquareDownloader";

    @Nullable
    private IDiskCache diskCache;
    private final PriorityQueue<TaskRequest> downloadQueue;
    private final ConcurrentHashMap<String, TaskRequest> downloadingMap;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005\u00a2\u0006\u0002\u0010\u0002J.\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\fJ\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/square/download/SquareDownloader$Reporter;", "", "()V", "checkFileCost", "", "downloadFinishTime", "taskCreateTime", "taskResponseTime", "taskStartTime", "doReport", "", "url", "", "file", "Ljava/io/File;", "errorCode", "", "message", "getFileSizes", "onDownloadFinish", "time", "onTaskResponse", "onTaskStart", "recordCheckCostTime", "Companion", "square_base_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes26.dex */
    public static final class Reporter {
        private static final String EVENT_SQUARE_DOWNLOAD = "ev_zplan_square_download";
        private static final String PARAM_ALL_COST_TIME = "all_cost_time";
        private static final String PARAM_CHECK_FILE_TIME = "check_file_time";
        private static final String PARAM_COST_TIME = "cost_time";
        private static final String PARAM_ERROR_CODE = "error_code";
        private static final String PARAM_ERROR_MESSAGE = "error_msg";
        private static final String PARAM_FILE_SIZE = "file_size";
        private static final String PARAM_RESPONSE_TIME = "connect_response_time";
        private static final String PARAM_URL = "url";
        private static final String PARAM_WAIT_TIME = "response_time";
        private static final String TAG = "SquareDownloader-Reporter";
        private static final int TIME = 1000000;
        private long checkFileCost;
        private long downloadFinishTime;
        private final long taskCreateTime = System.nanoTime();
        private long taskResponseTime;
        private long taskStartTime;

        public static /* synthetic */ void doReport$default(Reporter reporter, String str, File file, int i3, String str2, int i16, Object obj) {
            if ((i16 & 2) != 0) {
                file = null;
            }
            if ((i16 & 4) != 0) {
                i3 = 0;
            }
            if ((i16 & 8) != 0) {
                str2 = "";
            }
            reporter.doReport(str, file, i3, str2);
        }

        private final long getFileSizes(File file) {
            if (file == null) {
                return 0L;
            }
            FileInputStream fileInputStream = null;
            try {
                try {
                    if (!file.exists()) {
                        return 0L;
                    }
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        long available = fileInputStream2.available();
                        try {
                            fileInputStream2.close();
                        } catch (IOException e16) {
                            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "getFileSizes throw " + e16, null, 4, null);
                        }
                        return available;
                    } catch (Exception e17) {
                        e = e17;
                        fileInputStream = fileInputStream2;
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "getFileSizes throw " + e, null, 4, null);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e18) {
                                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "getFileSizes throw " + e18, null, 4, null);
                            }
                        }
                        return 0L;
                    } catch (Throwable th5) {
                        th = th5;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e19) {
                                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "getFileSizes throw " + e19, null, 4, null);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e26) {
                    e = e26;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }

        public final void doReport(@NotNull String url, @Nullable File file, int errorCode, @NotNull String message) {
            Map<String, Object> mutableMapOf;
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(message, "message");
            if (this.taskCreateTime != 0 && this.taskResponseTime != 0 && this.downloadFinishTime != 0 && this.checkFileCost != 0) {
                long j3 = 1000000;
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("error_code", String.valueOf(errorCode)), TuplesKt.to("error_msg", message), TuplesKt.to("cost_time", String.valueOf((this.downloadFinishTime - this.taskStartTime) / j3)), TuplesKt.to(PARAM_RESPONSE_TIME, String.valueOf((this.taskResponseTime - this.taskStartTime) / j3)), TuplesKt.to("response_time", String.valueOf((this.taskStartTime - this.taskCreateTime) / j3)), TuplesKt.to(PARAM_CHECK_FILE_TIME, String.valueOf(this.checkFileCost / j3)), TuplesKt.to(PARAM_ALL_COST_TIME, String.valueOf((this.downloadFinishTime - this.taskCreateTime) / j3)), TuplesKt.to("url", url), TuplesKt.to("file_size", String.valueOf(getFileSizes(file) / 1024)));
                SquareBase.INSTANCE.getConfig().getReporter().reportEvent(EVENT_SQUARE_DOWNLOAD, mutableMapOf);
            }
        }

        public final void onDownloadFinish(long time) {
            this.downloadFinishTime = time;
        }

        public final void onTaskResponse(long time) {
            this.taskResponseTime = time;
        }

        public final void onTaskStart(long time) {
            this.taskStartTime = time;
        }

        public final void recordCheckCostTime(long time) {
            this.checkFileCost = time;
        }
    }

    public SquareDownloader() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final synchronized boolean addDownloadTask(Source source, DownloadCallback callback, int priority) {
        Object obj;
        TaskRequest taskRequest;
        CopyOnWriteArrayList<DownloadCallback> callback2;
        String remoteUrl = source.getRemoteUrl();
        if (this.downloadingMap.containsKey(remoteUrl)) {
            if (callback != null && (taskRequest = this.downloadingMap.get(remoteUrl)) != null && (callback2 = taskRequest.getCallback()) != null) {
                callback2.add(callback);
            }
            return true;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        if (callback != null) {
            copyOnWriteArrayList.add(callback);
        }
        TaskRequest taskRequest2 = new TaskRequest(source, copyOnWriteArrayList, priority, null, 8, null);
        Iterator<T> it = this.downloadQueue.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((TaskRequest) obj).getKey(), taskRequest2.getKey())) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        TaskRequest taskRequest3 = (TaskRequest) obj;
        if (taskRequest3 != null) {
            if (taskRequest2.getPriority() > taskRequest3.getPriority()) {
                this.downloadQueue.remove(taskRequest3);
                this.downloadQueue.offer(taskRequest2);
            }
            taskRequest3.getCallback().add(callback);
            return true;
        }
        if (this.downloadingMap.size() < 5) {
            download(taskRequest2);
        } else {
            this.downloadQueue.offer(taskRequest2);
        }
        return true;
    }

    private final boolean download(final TaskRequest request) {
        SquareBaseKt.getSquareLog().i(TAG, "download: " + request);
        final String key = request.getKey();
        synchronized (this) {
            if (this.downloadingMap.containsKey(key)) {
                return true;
            }
            this.downloadingMap.put(key, request);
            final IHttpDownloader.Task task = new IHttpDownloader.Task(request.getSource().getRemoteUrl(), request.getSource().getCachePath());
            SquareBase.INSTANCE.getConfig().getDownloader().download(task, new IDownloadListener(request, key, task) { // from class: com.tencent.state.square.download.SquareDownloader$download$2
                final /* synthetic */ String $key;
                final /* synthetic */ TaskRequest $request;
                final /* synthetic */ IHttpDownloader.Task $task;

                @NotNull
                private final TaskProgress progress = new TaskProgress();

                @NotNull
                private final TaskResponse response;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.$request = request;
                    this.$key = key;
                    this.$task = task;
                    this.response = new TaskResponse(request.getSource(), DownloadsKt.getCacheFile(request.getSource()));
                }

                @NotNull
                public final TaskProgress getProgress() {
                    return this.progress;
                }

                @NotNull
                public final TaskResponse getResponse() {
                    return this.response;
                }

                @Override // com.tencent.state.square.IDownloadListener
                public void onDownloadFinish(@Nullable File tempFile) {
                    this.$request.getReporter().onDownloadFinish(System.nanoTime());
                }

                @Override // com.tencent.state.square.IDownloadListener
                public boolean onTaskCheckFile(@Nullable File tempFile) {
                    boolean endsWith;
                    long nanoTime = System.nanoTime();
                    boolean z16 = true;
                    if (tempFile != null) {
                        endsWith = StringsKt__StringsJVMKt.endsWith(this.$request.getSource().getCachePath(), ".mp4", true);
                        if (endsWith) {
                            IZPlanRecorder recorder = SquareBase.INSTANCE.getConfig().getRecorder();
                            String absolutePath = tempFile.getAbsolutePath();
                            Intrinsics.checkNotNullExpressionValue(absolutePath, "tempFile.absolutePath");
                            z16 = recorder.isMp4FileValid(absolutePath);
                        }
                    }
                    this.$request.getReporter().recordCheckCostTime(System.nanoTime() - nanoTime);
                    return z16;
                }

                @Override // com.tencent.state.square.IDownloadListener
                public void onTaskFailed(int errorCode, @NotNull String errorMessage) {
                    ConcurrentHashMap concurrentHashMap;
                    Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                    concurrentHashMap = SquareDownloader.this.downloadingMap;
                    TaskRequest taskRequest = (TaskRequest) concurrentHashMap.get(this.$key);
                    if (taskRequest != null) {
                        this.response.setErrorCode(errorCode);
                        Iterator<T> it = taskRequest.getCallback().iterator();
                        while (it.hasNext()) {
                            ((DownloadCallback) it.next()).onTaskFailed(taskRequest.getSource(), this.response);
                        }
                    }
                    SquareDownloader.this.onDownloadComplete(this.$key);
                    SquareDownloader.Reporter.doReport$default(this.$request.getReporter(), this.$task.getUrl(), null, errorCode, errorMessage, 2, null);
                }

                @Override // com.tencent.state.square.IDownloadListener
                public void onTaskProgress(@NotNull File tmpFile, @NotNull byte[] data, int size, long current) {
                    ConcurrentHashMap concurrentHashMap;
                    Intrinsics.checkNotNullParameter(tmpFile, "tmpFile");
                    Intrinsics.checkNotNullParameter(data, "data");
                    concurrentHashMap = SquareDownloader.this.downloadingMap;
                    TaskRequest taskRequest = (TaskRequest) concurrentHashMap.get(this.$key);
                    if (taskRequest != null) {
                        this.progress.setData(data);
                        this.progress.setSize(size);
                        this.progress.setProgress(current);
                        this.progress.setTmpFile(tmpFile);
                        Iterator<T> it = taskRequest.getCallback().iterator();
                        while (it.hasNext()) {
                            ((DownloadCallback) it.next()).onTaskProgress(taskRequest.getSource(), this.response, this.progress);
                        }
                    }
                }

                @Override // com.tencent.state.square.IDownloadListener
                public void onTaskResponse(long contentLength) {
                    ConcurrentHashMap concurrentHashMap;
                    concurrentHashMap = SquareDownloader.this.downloadingMap;
                    TaskRequest taskRequest = (TaskRequest) concurrentHashMap.get(this.$key);
                    if (taskRequest != null) {
                        this.response.setContentLength(contentLength);
                        this.progress.setTotal(contentLength);
                        Iterator<T> it = taskRequest.getCallback().iterator();
                        while (it.hasNext()) {
                            ((DownloadCallback) it.next()).onTaskStart(taskRequest.getSource(), this.response);
                        }
                    }
                    this.$request.getReporter().onTaskResponse(System.nanoTime());
                }

                @Override // com.tencent.state.square.IDownloadListener
                public void onTaskStart() {
                    this.$request.getReporter().onTaskStart(System.nanoTime());
                }

                @Override // com.tencent.state.square.IDownloadListener
                public void onTaskSuccess(@NotNull File resultFile) {
                    ConcurrentHashMap concurrentHashMap;
                    Intrinsics.checkNotNullParameter(resultFile, "resultFile");
                    concurrentHashMap = SquareDownloader.this.downloadingMap;
                    TaskRequest taskRequest = (TaskRequest) concurrentHashMap.get(this.$key);
                    if (taskRequest != null) {
                        Iterator<T> it = taskRequest.getCallback().iterator();
                        while (it.hasNext()) {
                            ((DownloadCallback) it.next()).onTaskSuccess(taskRequest.getSource(), this.response);
                        }
                    }
                    SquareDownloader.this.onDownloadComplete(this.$key);
                    IDiskCache diskCache = SquareDownloader.this.getDiskCache();
                    if (diskCache != null) {
                        diskCache.add(resultFile);
                    }
                    SquareDownloader.Reporter.doReport$default(this.$request.getReporter(), this.$task.getUrl(), resultFile, 0, null, 12, null);
                }
            });
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void onDownloadComplete(String key) {
        this.downloadingMap.remove(key);
        while (this.downloadingMap.size() < 5) {
            TaskRequest poll = this.downloadQueue.poll();
            if (poll == null) {
                return;
            } else {
                download(poll);
            }
        }
    }

    public final boolean addHighTask(@NotNull Source source, @Nullable DownloadCallback callback) {
        Intrinsics.checkNotNullParameter(source, "source");
        return addDownloadTask(source, callback, 2);
    }

    public final boolean addNormalTask(@NotNull Source source, @Nullable DownloadCallback callback) {
        Intrinsics.checkNotNullParameter(source, "source");
        return addDownloadTask(source, callback, 1);
    }

    @Nullable
    public final IDiskCache getDiskCache() {
        return this.diskCache;
    }

    public final void removeCallback(@NotNull String url) {
        CopyOnWriteArrayList<DownloadCallback> callback;
        Intrinsics.checkNotNullParameter(url, "url");
        TaskRequest taskRequest = this.downloadingMap.get(url);
        if (taskRequest != null && (callback = taskRequest.getCallback()) != null) {
            callback.clear();
        }
    }

    public final void setDiskCache(@Nullable IDiskCache iDiskCache) {
        this.diskCache = iDiskCache;
    }

    public SquareDownloader(@Nullable IDiskCache iDiskCache) {
        this.diskCache = iDiskCache;
        this.downloadQueue = new PriorityQueue<>(20, new Comparator<TaskRequest>() { // from class: com.tencent.state.square.download.SquareDownloader$downloadQueue$1
            @Override // java.util.Comparator
            public final int compare(TaskRequest taskRequest, TaskRequest taskRequest2) {
                return taskRequest2.getPriority() - taskRequest.getPriority();
            }
        });
        this.downloadingMap = new ConcurrentHashMap<>();
    }

    public /* synthetic */ SquareDownloader(IDiskCache iDiskCache, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : iDiskCache);
    }
}
