package com.tencent.rmonitor.base.reporter;

import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.IntRange;
import android.support.annotation.RestrictTo;
import android.text.TextUtils;
import com.tencent.ams.dynamicwidget.http.Method;
import com.tencent.bugly.common.meta.UserMeta;
import com.tencent.bugly.common.network.NetworkWatcher;
import com.tencent.bugly.common.reporter.IReporter;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.bugly.common.reporter.data.ReportData;
import com.tencent.bugly.common.reporter.data.ReportStrategy;
import com.tencent.bugly.common.reporter.link.PluginLinkDataProxy;
import com.tencent.bugly.common.reporter.upload.UploadProxy;
import com.tencent.bugly.common.thread.ThreadManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.rmonitor.base.db.DBDataStatus;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.base.reporter.ReporterMachine;
import com.tencent.rmonitor.base.reporter.batch.ReportCacheImpl;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.d;
import com.tencent.rmonitor.sla.AttaEvent;
import com.tencent.rmonitor.sla.AttaEventReporter;
import com.tencent.rmonitor.sla.StatisticsReporter;
import com.tencent.rmonitor.sla.e;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u0001%B\t\b\u0002\u00a2\u0006\u0004\bH\u0010IJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\n\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0002J\u001a\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J0\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0018\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J(\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u001a\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u000e\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010 \u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u0016J\u0006\u0010!\u001a\u00020\u000fJ\u0006\u0010\"\u001a\u00020\u0004J6\u0010$\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016R\u0016\u0010'\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\"\u0010/\u001a\u00020(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00106\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u0010=\u001a\u0002078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R(\u0010D\u001a\b\u0012\u0004\u0012\u00020\n0>8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0014\u0010G\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010F\u00a8\u0006J"}, d2 = {"Lcom/tencent/rmonitor/base/reporter/ReporterMachine;", "Lcom/tencent/bugly/common/reporter/IReporter;", "Lcom/tencent/bugly/common/reporter/data/ReportData;", "reportData", "", ReportConstant.COSTREPORT_PREFIX, "", "priority", "Ljava/lang/Runnable;", "runnable", "Lcom/tencent/rmonitor/base/reporter/ReporterMachine$a;", h.F, "g", "Lcom/tencent/bugly/common/reporter/IReporter$ReportCallback;", "callback", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "d", "errorCode", "i", "isSuccess", "contentLength", "", "costInMs", DomainData.DOMAIN_NAME, "Lcom/tencent/rmonitor/base/reporter/DiscardReason;", "discardReason", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", "reportNow", "k", "delay", "l", "r", "j", "hasRetry", "o", "a", "Z", "isStarted", "Landroid/os/Handler;", "b", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "setHandler", "(Landroid/os/Handler;)V", "handler", "c", "Lcom/tencent/bugly/common/reporter/IReporter;", "getUploadProxy", "()Lcom/tencent/bugly/common/reporter/IReporter;", "setUploadProxy", "(Lcom/tencent/bugly/common/reporter/IReporter;)V", "uploadProxy", "Lcom/tencent/rmonitor/base/reporter/a;", "Lcom/tencent/rmonitor/base/reporter/a;", "e", "()Lcom/tencent/rmonitor/base/reporter/a;", "setReportCache", "(Lcom/tencent/rmonitor/base/reporter/a;)V", "reportCache", "Ljava/util/concurrent/PriorityBlockingQueue;", "Ljava/util/concurrent/PriorityBlockingQueue;", "f", "()Ljava/util/concurrent/PriorityBlockingQueue;", "setReportQueue", "(Ljava/util/concurrent/PriorityBlockingQueue;)V", "reportQueue", "Ljava/lang/Thread;", "Ljava/lang/Thread;", "reportThread", "<init>", "()V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes25.dex */
public final class ReporterMachine implements IReporter {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static boolean isStarted;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static IReporter uploadProxy;

    /* renamed from: g, reason: collision with root package name */
    public static final ReporterMachine f365411g = new ReporterMachine();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Handler handler = new Handler(ThreadManager.INSTANCE.getMonitorThreadLooper());

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static com.tencent.rmonitor.base.reporter.a reportCache = new ReportCacheImpl();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static PriorityBlockingQueue<a> reportQueue = new PriorityBlockingQueue<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final Thread reportThread = new BaseThread(new Runnable() { // from class: com.tencent.rmonitor.base.reporter.ReporterMachine$reportThread$1
        @Override // java.lang.Runnable
        public final void run() {
            while (true) {
                ReporterMachine reporterMachine = ReporterMachine.f365411g;
                ReporterMachine.a take = reporterMachine.f().take();
                try {
                    Runnable runnable = take.getRunnable();
                    if (runnable != null) {
                        runnable.run();
                    }
                    ReportData reportData = take.getReportData();
                    if (reportData != null) {
                        reporterMachine.q(reportData, take.getCallback());
                    }
                } catch (Throwable th5) {
                    Logger.f365497g.c("RMonitor_report", th5);
                }
            }
        }
    });

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\"B%\u0012\b\b\u0001\u0010\u0014\u001a\u00020\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0011\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0000H\u0096\u0002R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u001c\u001a\u0004\b\u0016\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/rmonitor/base/reporter/ReporterMachine$a;", "", "", "otherIndex", "c", "other", "d", "I", "index", "Ljava/lang/Runnable;", "e", "Ljava/lang/Runnable;", "j", "()Ljava/lang/Runnable;", "k", "(Ljava/lang/Runnable;)V", "runnable", "f", "getPriority", "()I", "priority", "Lcom/tencent/bugly/common/reporter/data/ReportData;", h.F, "Lcom/tencent/bugly/common/reporter/data/ReportData;", "i", "()Lcom/tencent/bugly/common/reporter/data/ReportData;", "reportData", "Lcom/tencent/bugly/common/reporter/IReporter$ReportCallback;", "Lcom/tencent/bugly/common/reporter/IReporter$ReportCallback;", "()Lcom/tencent/bugly/common/reporter/IReporter$ReportCallback;", "callback", "<init>", "(ILcom/tencent/bugly/common/reporter/data/ReportData;Lcom/tencent/bugly/common/reporter/IReporter$ReportCallback;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class a implements Comparable<a> {

        /* renamed from: m, reason: collision with root package name */
        @NotNull
        private static AtomicInteger f365412m = new AtomicInteger(0);

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int index = f365412m.getAndIncrement();

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Runnable runnable;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final int priority;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final ReportData reportData;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final IReporter.ReportCallback callback;

        public a(@IntRange(from = 0, to = 4) int i3, @Nullable ReportData reportData, @Nullable IReporter.ReportCallback reportCallback) {
            this.priority = i3;
            this.reportData = reportData;
            this.callback = reportCallback;
        }

        private final int c(int otherIndex) {
            if (this.index > otherIndex) {
                return 1;
            }
            if (this.priority < otherIndex) {
                return -1;
            }
            return 0;
        }

        @Override // java.lang.Comparable
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compareTo(@NotNull a other) {
            Intrinsics.checkParameterIsNotNull(other, "other");
            int i3 = this.priority;
            int i16 = other.priority;
            if (i3 < i16) {
                return 1;
            }
            if (i3 > i16) {
                return -1;
            }
            return c(other.index);
        }

        @Nullable
        /* renamed from: h, reason: from getter */
        public final IReporter.ReportCallback getCallback() {
            return this.callback;
        }

        @Nullable
        /* renamed from: i, reason: from getter */
        public final ReportData getReportData() {
            return this.reportData;
        }

        @Nullable
        /* renamed from: j, reason: from getter */
        public final Runnable getRunnable() {
            return this.runnable;
        }

        public final void k(@Nullable Runnable runnable) {
            this.runnable = runnable;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J(\u0010\n\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/rmonitor/base/reporter/ReporterMachine$b", "Lcom/tencent/bugly/common/reporter/IReporter$ReportCallback;", "", "dbId", "contentLength", "", "onSuccess", "errorCode", "", "errorMsg", "onFailure", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class b implements IReporter.ReportCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f365418a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f365419b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ReportData f365420c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IReporter.ReportCallback f365421d;

        b(long j3, String str, ReportData reportData, IReporter.ReportCallback reportCallback) {
            this.f365418a = j3;
            this.f365419b = str;
            this.f365420c = reportData;
            this.f365421d = reportCallback;
        }

        @Override // com.tencent.bugly.common.reporter.IReporter.ReportCallback
        public void onCached() {
            IReporter.ReportCallback.DefaultImpls.onCached(this);
        }

        @Override // com.tencent.bugly.common.reporter.IReporter.ReportCallback
        public void onFailure(int errorCode, @NotNull String errorMsg, int dbId, int contentLength) {
            Intrinsics.checkParameterIsNotNull(errorMsg, "errorMsg");
            long uptimeMillis = SystemClock.uptimeMillis() - this.f365418a;
            if (Logger.debug) {
                Logger.f365497g.d("RMonitor_report", "reportInternal-onFailure, pluginName: " + this.f365419b + ", dbId: " + dbId + ", errorCode: " + errorCode + ", errorMsg: " + errorMsg);
            }
            ReporterMachine reporterMachine = ReporterMachine.f365411g;
            reporterMachine.e().c(dbId, DBDataStatus.SENT_FAIL);
            if (reporterMachine.i(errorCode, this.f365420c, this.f365421d)) {
                reporterMachine.o(this.f365420c, false, true, errorCode, contentLength, uptimeMillis);
                return;
            }
            reporterMachine.o(this.f365420c, false, false, errorCode, contentLength, uptimeMillis);
            IReporter.ReportCallback reportCallback = this.f365421d;
            if (reportCallback != null) {
                reportCallback.onFailure(errorCode, errorMsg, dbId, contentLength);
            }
        }

        @Override // com.tencent.bugly.common.reporter.IReporter.ReportCallback
        public void onSuccess(int dbId, int contentLength) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.f365418a;
            if (Logger.verbos) {
                Logger.f365497g.v("RMonitor_report", "reportInternal-onSuccess, pluginName: " + this.f365419b + ", dbId: " + dbId);
            }
            ReporterMachine reporterMachine = ReporterMachine.f365411g;
            reporterMachine.e().c(dbId, DBDataStatus.SENT);
            reporterMachine.o(this.f365420c, true, true, 0, contentLength, uptimeMillis);
            IReporter.ReportCallback reportCallback = this.f365421d;
            if (reportCallback != null) {
                reportCallback.onSuccess(dbId, contentLength);
            }
        }
    }

    ReporterMachine() {
    }

    private final boolean d(ReportData reportData) {
        if (reportData.getReportStrategy().getUploadStrategy() == ReportStrategy.UploadStrategy.UPLOAD_ANY) {
            return true;
        }
        if (reportData.getReportStrategy().getUploadStrategy() == ReportStrategy.UploadStrategy.UPLOAD_WIFI && NetworkWatcher.INSTANCE.isWiFiConnectedRealtime()) {
            return true;
        }
        reportData.getReportStrategy().getUploadStrategy();
        ReportStrategy.UploadStrategy uploadStrategy = ReportStrategy.UploadStrategy.UPLOAD_WIFI;
        return false;
    }

    private final IReporter g() {
        UserMeta userMeta = BaseInfo.userMeta;
        if (TextUtils.isEmpty(userMeta.appId)) {
            Logger.f365497g.e("RMonitor_report", "appid is empty.");
        }
        if (BaseInfo.app == null) {
            Logger.f365497g.e("RMonitor_report", "app is null.");
        }
        if (uploadProxy == null && !TextUtils.isEmpty(userMeta.appId)) {
            uploadProxy = new UploadProxy(BaseInfo.app, userMeta.appId);
        }
        if (uploadProxy == null) {
            Logger.f365497g.e("RMonitor_report", "IReporter is null.");
        }
        return uploadProxy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a h(int priority, Runnable runnable) {
        a aVar = new a(priority, null, null);
        aVar.k(runnable);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean i(int errorCode, final ReportData reportData, final IReporter.ReportCallback callback) {
        ReportStrategy reportStrategy = reportData.getReportStrategy();
        if (errorCode == 600 || errorCode == 700) {
            Logger.f365497g.d("RMonitor_report", "oom or other error happen, do not retry");
            reportStrategy.setAlreadyRetryTimes(reportStrategy.getRetryTimes());
        }
        int retryTimes = reportStrategy.getRetryTimes() - reportStrategy.getAlreadyRetryTimes();
        Logger logger = Logger.f365497g;
        logger.d("RMonitor_report", "can retry " + retryTimes + " times");
        if (retryTimes <= 0) {
            logger.d("RMonitor_report", "no chance to retry");
            return false;
        }
        reportStrategy.setAlreadyRetryTimes(reportStrategy.getAlreadyRetryTimes() + 1);
        int i3 = com.tencent.rmonitor.base.reporter.b.f365427a[reportStrategy.getRetryStrategy().ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                long pow = (long) (Math.pow(2.0d, reportStrategy.getAlreadyRetryTimes() - 1) * 60000);
                logger.d("RMonitor_report", "retry " + pow + "ms later");
                handler.postDelayed(new Runnable() { // from class: com.tencent.rmonitor.base.reporter.ReporterMachine$handleRetryStrategy$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ReporterMachine.f365411g.f().offer(new ReporterMachine.a(ReportData.this.getReportStrategy().getPriority(), ReportData.this, callback));
                    }
                }, pow);
            }
        } else {
            logger.d("RMonitor_report", "retry immediately");
            reportQueue.offer(new a(reportData.getReportStrategy().getPriority(), reportData, callback));
        }
        return true;
    }

    private final void m(ReportData reportData, DiscardReason discardReason) {
        if (reportData.getReportType() == 1) {
            d dVar = d.f365537a;
            String a16 = dVar.a(reportData.getParams(), ReportDataBuilder.KEY_BASE_TYPE);
            String a17 = dVar.a(reportData.getParams(), "sub_type");
            if (!TextUtils.isEmpty(a16) && !TextUtils.isEmpty(a17)) {
                StatisticsReporter.INSTANCE.a().h(a16, a17, discardReason);
            }
        }
    }

    private final void n(ReportData reportData, boolean isSuccess, int errorCode, int contentLength, long costInMs) {
        if (reportData.getReportType() == 1) {
            d dVar = d.f365537a;
            String a16 = dVar.a(reportData.getParams(), ReportDataBuilder.KEY_BASE_TYPE);
            String a17 = dVar.a(reportData.getParams(), "sub_type");
            if (!TextUtils.isEmpty(a16) && !TextUtils.isEmpty(a17)) {
                StatisticsReporter.INSTANCE.a().j(a16, a17, isSuccess, contentLength, (int) costInMs);
                if (!isSuccess) {
                    p(reportData, errorCode, contentLength, costInMs);
                }
            }
        }
    }

    private final void p(ReportData reportData, int errorCode, int contentLength, long costInMs) {
        if (!e.b().c("RMReportErrorCode")) {
            Logger.f365497g.d("RMonitor_report", "reportErrorCode miss hit sampling, eventName: " + reportData.getEventName() + ", errorCode: " + errorCode);
            return;
        }
        AttaEvent attaEvent = new AttaEvent(null, 1, null);
        attaEvent.R("RMReportErrorCode");
        attaEvent.T(0);
        attaEvent.Q(errorCode);
        attaEvent.S((int) costInMs);
        d dVar = d.f365537a;
        attaEvent.a0(dVar.a(reportData.getParams(), ReportDataBuilder.KEY_BASE_TYPE));
        attaEvent.b0(dVar.a(reportData.getParams(), "sub_type"));
        attaEvent.g0(String.valueOf(contentLength));
        attaEvent.h0(dVar.a(reportData.getParams(), ReportDataBuilder.KEY_CLIENT_IDENTIFY));
        AttaEventReporter.INSTANCE.a().c(attaEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(ReportData reportData, IReporter.ReportCallback callback) {
        if (Logger.verbos) {
            Logger.f365497g.v("RMonitor_report", "reportInternal: " + reportData.getParams());
        }
        if (reportData.getReportStrategy().getNeedCache() && reportData.getDbId() <= 0) {
            reportCache.a(reportData);
        }
        if (Logger.verbos) {
            Logger.f365497g.v("RMonitor_report", "reportInternal, name: " + reportData.getPluginName() + ", dbID: " + reportData.getDbId() + ", cid: " + reportData.getParams().optString(ReportDataBuilder.KEY_CLIENT_IDENTIFY));
        }
        String pluginName = reportData.getPluginName();
        long uptimeMillis = SystemClock.uptimeMillis();
        IReporter g16 = g();
        if (g16 != null) {
            g16.reportNow(reportData, new b(uptimeMillis, pluginName, reportData, callback));
        }
    }

    private final boolean s(ReportData reportData) {
        String pluginName = reportData.getPluginName();
        PluginController pluginController = PluginController.f365404b;
        if (!pluginController.f(pluginName)) {
            Logger.f365497g.d("RMonitor_report", "block report for not hit sampling, plugin: " + pluginName + " .");
            return true;
        }
        if (reportData.getDbId() > 0 || pluginController.b(pluginName)) {
            return false;
        }
        Logger.f365497g.d("RMonitor_report", "block report for exceed limit, plugin: " + pluginName + " .");
        return true;
    }

    @NotNull
    public final com.tencent.rmonitor.base.reporter.a e() {
        return reportCache;
    }

    @NotNull
    public final PriorityBlockingQueue<a> f() {
        return reportQueue;
    }

    public final boolean j() {
        return isStarted;
    }

    public final void k(@NotNull Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        if (Logger.verbos) {
            Logger.f365497g.v("RMonitor_report", Method.POST);
        }
        reportQueue.offer(h(2, runnable));
    }

    public final void l(@NotNull final Runnable runnable, long delay) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        if (Logger.verbos) {
            Logger.f365497g.v("RMonitor_report", "postDelay, delay:" + delay);
        }
        handler.postDelayed(new Runnable() { // from class: com.tencent.rmonitor.base.reporter.ReporterMachine$postDelayed$1
            @Override // java.lang.Runnable
            public final void run() {
                ReporterMachine.a h16;
                ReporterMachine reporterMachine = ReporterMachine.f365411g;
                PriorityBlockingQueue<ReporterMachine.a> f16 = reporterMachine.f();
                h16 = reporterMachine.h(2, runnable);
                f16.offer(h16);
            }
        }, delay);
    }

    public final void o(@NotNull ReportData reportData, boolean isSuccess, boolean hasRetry, int errorCode, int contentLength, long costInMs) {
        boolean z16;
        Intrinsics.checkParameterIsNotNull(reportData, "reportData");
        if (reportData.getDbId() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (isSuccess) {
            n(reportData, true, errorCode, contentLength, costInMs);
            return;
        }
        if (hasRetry) {
            n(reportData, false, errorCode, contentLength, costInMs);
        } else if (z16) {
            n(reportData, false, errorCode, contentLength, costInMs);
        } else {
            m(reportData, DiscardReason.RETRY_EXCEEDED);
            n(reportData, false, errorCode, contentLength, costInMs);
        }
    }

    public final void r() {
        Logger.f365497g.i("RMonitor_report", "start, isStarted: " + isStarted);
        synchronized (this) {
            if (!f365411g.j()) {
                reportCache.b();
                reportThread.start();
                isStarted = true;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.bugly.common.reporter.IReporter
    public boolean reportNow(@NotNull final ReportData reportData, @Nullable IReporter.ReportCallback callback) {
        Intrinsics.checkParameterIsNotNull(reportData, "reportData");
        if (Logger.verbos) {
            Logger.f365497g.v("RMonitor_report", "reportNow, dbId: " + reportData.getDbId() + ", eventName: " + reportData.getEventName() + " , reportStrategy:" + reportData.getReportStrategy());
        }
        if (s(reportData)) {
            if (callback != null) {
                callback.onSuccess(reportData.getDbId(), 0);
            }
            return true;
        }
        if (reportData.getShouldRecordLinkData()) {
            PluginLinkDataProxy.getInstance().recordPluginLinkData(reportData.getParams());
            reportData.setShouldRecordLinkData(false);
        }
        if (d(reportData)) {
            reportQueue.offer(new a(reportData.getReportStrategy().getPriority(), reportData, callback));
        } else {
            reportQueue.offer(h(2, new Runnable() { // from class: com.tencent.rmonitor.base.reporter.ReporterMachine$reportNow$1
                @Override // java.lang.Runnable
                public final void run() {
                    ReporterMachine.f365411g.e().a(ReportData.this);
                }
            }));
            if (callback != null) {
                callback.onCached();
            }
        }
        return true;
    }
}
