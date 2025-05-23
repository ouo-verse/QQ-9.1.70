package com.tencent.biz.qqcircle.wink;

import com.tencent.biz.qqcircle.immersive.part.QFSPublishNotification;
import com.tencent.biz.qqcircle.widgets.p;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010\u000f\u001a\u00020\bJ\u0006\u0010\u0010\u001a\u00020\bJ\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013R\u0016\u0010\u0018\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0017R \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/biz/qqcircle/wink/QCirclePublishProgress;", "Lkotlinx/coroutines/CoroutineScope;", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "Lkotlinx/coroutines/Job;", "d", "Lcom/tencent/biz/qqcircle/wink/c;", "info", "", "k", "l", "", "success", "j", "c", tl.h.F, "i", "", "e", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "taskInfo", "g", "f", "Z", "isAppBackground", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "progressInfoMap", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QCirclePublishProgress implements CoroutineScope {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean isAppBackground;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final QCirclePublishProgress f93922d = new QCirclePublishProgress();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Long, ProgressInfo> progressInfoMap = new ConcurrentHashMap<>();

    QCirclePublishProgress() {
    }

    private final boolean c(ProgressInfo info) {
        if (isAppBackground && info.getShowNotification()) {
            return true;
        }
        return false;
    }

    private final Job d(long taskId) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this, null, null, new QCirclePublishProgress$createProgressJob$1(taskId, null), 3, null);
        return launch$default;
    }

    private final void j(boolean success, ProgressInfo info) {
        if (!c(info)) {
            return;
        }
        if (success) {
            QFSPublishNotification.f87509a.n(info.getTaskId(), info.getTraceId(), info.getMissionId(), info.getCoverBitmap());
        } else {
            QFSPublishNotification.f87509a.k(info.getTaskId(), info.getTraceId(), info.getMissionId(), info.getCoverBitmap());
        }
    }

    private final void k(ProgressInfo info) {
        if (!c(info)) {
            return;
        }
        QFSPublishNotification.f87509a.l(info.getTaskId(), info.getTraceId(), info.getMissionId(), info.getCoverBitmap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(ProgressInfo info) {
        if (!c(info)) {
            return;
        }
        QFSPublishNotification.f87509a.m(info.getTaskId(), info.getTraceId(), info.getMissionId(), (int) Math.ceil(info.getCurrProgress()), info.getCoverBitmap());
    }

    public final int e(long taskId) {
        double d16;
        ProgressInfo progressInfo = progressInfoMap.get(Long.valueOf(taskId));
        if (progressInfo != null) {
            d16 = progressInfo.getCurrProgress();
        } else {
            d16 = 0.0d;
        }
        return (int) Math.ceil(d16);
    }

    public final void f(@NotNull TaskInfo taskInfo) {
        Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
        ProgressInfo progressInfo = progressInfoMap.get(Long.valueOf(taskInfo.getTaskId()));
        if (progressInfo != null) {
            progressInfo.p(taskInfo.getUploadProgress());
            progressInfo.n(taskInfo.getExportProgress());
        }
    }

    public final void g(@NotNull TaskInfo taskInfo) {
        ProgressInfo remove;
        Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
        ProgressInfo progressInfo = new ProgressInfo(taskInfo.getTaskId(), taskInfo.getTraceId(), taskInfo.getMissionId(), taskInfo.getUploadProgress(), taskInfo.getExportProgress(), taskInfo.getCoverUrl(), d.a(taskInfo), null, 0, 0, 0, 0.0d, null, 8064, null);
        ConcurrentHashMap<Long, ProgressInfo> concurrentHashMap = progressInfoMap;
        ProgressInfo putIfAbsent = concurrentHashMap.putIfAbsent(Long.valueOf(taskInfo.getTaskId()), progressInfo);
        if (putIfAbsent != null) {
            progressInfo = putIfAbsent;
        }
        if (taskInfo.isActive()) {
            if (taskInfo.isNetworkWaiting()) {
                Job computeJob = progressInfo.getComputeJob();
                if (computeJob != null) {
                    Job.DefaultImpls.cancel$default(computeJob, (CancellationException) null, 1, (Object) null);
                }
                k(progressInfo);
                return;
            }
            if (taskInfo.getUploadProgress() >= 100.0d && taskInfo.getExportProgress() >= 100.0d) {
                progressInfo.o(100.0d);
            } else {
                progressInfo.o(0.0d);
                progressInfo.l(d(taskInfo.getTaskId()));
            }
            progressInfo.k();
            l(progressInfo);
            return;
        }
        if (p.d(taskInfo) && (remove = concurrentHashMap.remove(Long.valueOf(taskInfo.getTaskId()))) != null) {
            Job computeJob2 = remove.getComputeJob();
            if (computeJob2 != null) {
                Job.DefaultImpls.cancel$default(computeJob2, (CancellationException) null, 1, (Object) null);
            }
            f93922d.j(taskInfo.isSuccess(), remove);
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null));
    }

    public final void h() {
        isAppBackground = true;
    }

    public final void i() {
        isAppBackground = false;
    }
}
