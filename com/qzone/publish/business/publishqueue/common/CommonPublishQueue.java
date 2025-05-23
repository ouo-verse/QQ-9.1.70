package com.qzone.publish.business.publishqueue.common;

import android.os.Handler;
import android.os.Message;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.publish.business.process.base.QZoneProcessType;
import com.qzone.publish.business.task.IQueueTask;
import com.qzone.publish.business.task.QZoneQueueTask;
import com.qzone.publish.business.task.intimate.QZoneIntimateUploadAlbumTask;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vip.TMSManager;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QzoneConfig;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tl.h;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u00152\u00020\u00012\u00020\u00022\u00020\u0003:\u00016B\u001f\u0012\u0006\u0010B\u001a\u00020$\u0012\u0006\u0010E\u001a\u00020C\u0012\u0006\u0010F\u001a\u00020$\u00a2\u0006\u0004\bW\u0010XJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\"\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\u0013H\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0002J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002J\b\u0010 \u001a\u00020\u0004H\u0002J\u0016\u0010#\u001a\u00020\u00042\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040!H\u0002J\b\u0010%\u001a\u00020$H\u0016J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0013H\u0016J\u0010\u0010(\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0006\u0010)\u001a\u00020\u0004J\u0012\u0010*\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010+\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010,\u001a\u00020\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010-\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010.\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u00100\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010/\u001a\u00020\u0013H\u0016J\u0012\u00102\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u00103\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u00104\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u000e\u00106\u001a\b\u0012\u0004\u0012\u00020\u000e05H\u0016J\u0006\u00108\u001a\u000207J\u0006\u00109\u001a\u00020\u0013J\u0006\u0010:\u001a\u00020\u0013J\u000e\u0010;\u001a\b\u0012\u0004\u0012\u00020\u000e05H\u0016J\u001a\u0010=\u001a\u00020\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010<\u001a\u00020\u0013H\u0016J\u0012\u0010?\u001a\u00020\u00062\n\b\u0002\u0010>\u001a\u0004\u0018\u00010$J\u0006\u0010@\u001a\u00020\u0004R\u0014\u0010B\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u0010AR\u0014\u0010E\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010DR\u0014\u0010F\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010AR \u0010I\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00060G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010HR\u0014\u0010L\u001a\u00020J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u0010KR \u0010Q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0N0M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010T\u001a\u00020R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010SR\u0014\u0010U\u001a\u00020R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010SR\u0014\u0010V\u001a\u00020R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010S\u00a8\u0006Y"}, d2 = {"Lcom/qzone/publish/business/publishqueue/common/CommonPublishQueue;", "Landroid/os/Handler$Callback;", "Lcooperation/qzone/util/NetworkState$NetworkStateListener;", "Lcom/qzone/publish/business/publishqueue/a;", "", "E", "", "w", "L", "I", BdhLogUtil.LogTag.Tag_Req, "Landroid/os/Message;", "msg", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/publish/business/task/IQueueTask;", "task", ExifInterface.LATITUDE_SOUTH, "r", "K", "", "t", UserInfo.SEX_FEMALE, "J", "D", "Lcom/qzone/publish/business/task/QZoneQueueTask;", "queueTask", "isSucceed", "u", "H", "", "Lcom/qzone/publish/business/publishqueue/b;", ReportConstant.COSTREPORT_PREFIX, "B", "Lkotlin/Function0;", "action", "P", "", HippyTKDListViewAdapter.X, "connected", "onNetworkConnect", "handleMessage", "O", "b", "c", "f", "G", "j", "successed", "g", "listener", "i", "M", "d", "Ljava/util/concurrent/CopyOnWriteArrayList;", "a", "", "y", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "e", "notify", h.F, "albumId", "v", "N", "Ljava/lang/String;", "caseId", "Lcom/qzone/publish/business/publishqueue/common/f;", "Lcom/qzone/publish/business/publishqueue/common/f;", "taskManager", "businessReportFlag", "", "Ljava/util/Map;", "lastTaskBeginTimeMap", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "", "Ljava/lang/ref/WeakReference;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "listeners", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "checkRetryForOffline", "checkRetry", "checkRetryForOffline2Normal", "<init>", "(Ljava/lang/String;Lcom/qzone/publish/business/publishqueue/common/f;Ljava/lang/String;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public class CommonPublishQueue implements Handler.Callback, NetworkState.NetworkStateListener, com.qzone.publish.business.publishqueue.a {

    /* renamed from: C, reason: from kotlin metadata */
    private final Runnable checkRetryForOffline;

    /* renamed from: D, reason: from kotlin metadata */
    private final Runnable checkRetry;

    /* renamed from: E, reason: from kotlin metadata */
    private final Runnable checkRetryForOffline2Normal;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String caseId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final f taskManager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final String businessReportFlag;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Map<String, Long> lastTaskBeginTimeMap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Handler handler;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final List<WeakReference<com.qzone.publish.business.publishqueue.b>> listeners;

    public CommonPublishQueue(String caseId, f taskManager, String businessReportFlag) {
        Intrinsics.checkNotNullParameter(caseId, "caseId");
        Intrinsics.checkNotNullParameter(taskManager, "taskManager");
        Intrinsics.checkNotNullParameter(businessReportFlag, "businessReportFlag");
        this.caseId = caseId;
        this.taskManager = taskManager;
        this.businessReportFlag = businessReportFlag;
        this.lastTaskBeginTimeMap = new LinkedHashMap();
        this.handler = new Handler(QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).getLooper(), this);
        this.listeners = new ArrayList();
        RFWLog.i(x(), RFWLog.USR, "init, caseId:" + caseId);
        NetworkState.addListener(this);
        this.checkRetryForOffline = new Runnable() { // from class: com.qzone.publish.business.publishqueue.common.a
            @Override // java.lang.Runnable
            public final void run() {
                CommonPublishQueue.p(CommonPublishQueue.this);
            }
        };
        this.checkRetry = new Runnable() { // from class: com.qzone.publish.business.publishqueue.common.b
            @Override // java.lang.Runnable
            public final void run() {
                CommonPublishQueue.o(CommonPublishQueue.this);
            }
        };
        this.checkRetryForOffline2Normal = new Runnable() { // from class: com.qzone.publish.business.publishqueue.common.c
            @Override // java.lang.Runnable
            public final void run() {
                CommonPublishQueue.q(CommonPublishQueue.this);
            }
        };
    }

    private final void B() {
        try {
            for (final com.qzone.publish.business.publishqueue.b bVar : s()) {
                P(new Function0<Unit>() { // from class: com.qzone.publish.business.publishqueue.common.CommonPublishQueue$notifyChange$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        com.qzone.publish.business.publishqueue.b.this.onQueueChanged();
                    }
                });
            }
        } catch (Exception e16) {
            xe.b.f447841a.d(e16);
        }
    }

    private final void C(Message msg2) {
        Object obj = msg2.obj;
        IQueueTask iQueueTask = obj instanceof IQueueTask ? (IQueueTask) obj : null;
        if (iQueueTask == null) {
            RFWLog.w(x(), RFWLog.USR, "onAddTask, task is null ");
            return;
        }
        RFWLog.i(x(), RFWLog.USR, "onAddTask, taskId:" + iQueueTask.getTaskId() + ", type:" + iQueueTask.getExactType());
        iQueueTask.resetTraceId();
        this.taskManager.a(iQueueTask);
        if (!NetworkState.isNetSupport()) {
            iQueueTask.setState(6);
        }
        S(iQueueTask);
        R();
        B();
        WinkPublishQualityReportData.Builder ext1 = new WinkPublishQualityReportData.Builder().eventId(eo.d.f396882b).ext1(iQueueTask.getClientKey());
        int retryNum = iQueueTask.getRetryNum();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(retryNum);
        WinkPublishQualityReportData.Builder ext2 = ext1.ext2(sb5.toString());
        int exactType = iQueueTask.getExactType();
        StringBuilder sb6 = new StringBuilder();
        sb6.append(exactType);
        eo.d.b(ext2.ext3(sb6.toString()).ext4(this.businessReportFlag).traceId(iQueueTask.getTraceId()).getReportData());
    }

    private final void D(Message msg2) {
        Object obj = msg2.obj;
        IQueueTask iQueueTask = obj instanceof IQueueTask ? (IQueueTask) obj : null;
        if (iQueueTask == null) {
            RFWLog.w(x(), RFWLog.USR, "onCompleteTask, task is null ");
            return;
        }
        RFWLog.i(x(), RFWLog.USR, "onCompleteTask, taskId:" + iQueueTask.getTaskId() + ", type:" + iQueueTask.getExactType());
        this.taskManager.c(iQueueTask, msg2.arg1 == 1);
        u(iQueueTask, iQueueTask instanceof QZoneQueueTask ? (QZoneQueueTask) iQueueTask : null, msg2.arg1 == 1);
        d(iQueueTask);
        R();
        B();
    }

    private final void E() {
        RFWLog.i(x(), RFWLog.USR, "onMobileNetConnected ");
        if (y() <= 0) {
            return;
        }
        int config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PUBLISH_QUEUE_LEAVE_WIFI_CHECK_SIZE, 10);
        RFWLog.i(x(), RFWLog.USR, "onMobileNetConnected, leaveWifiCheckSize:" + config);
        if (w() > config * 1024 * 1024) {
            this.handler.removeCallbacks(this.checkRetryForOffline2Normal);
            this.taskManager.n(this.caseId);
            B();
        } else {
            this.handler.removeCallbacks(this.checkRetryForOffline2Normal);
            this.handler.postDelayed(this.checkRetryForOffline2Normal, 10000L);
        }
    }

    private final void F(Message msg2) {
        Object obj = msg2.obj;
        IQueueTask iQueueTask = obj instanceof IQueueTask ? (IQueueTask) obj : null;
        if (iQueueTask == null) {
            RFWLog.w(x(), RFWLog.USR, "onPauseTask, task is null ");
            return;
        }
        RFWLog.i(x(), RFWLog.USR, "onPauseTask, taskId:" + iQueueTask.getTaskId() + ", type:" + iQueueTask.getExactType());
        this.taskManager.o(iQueueTask);
    }

    private final void H() {
        RFWLog.i(x(), RFWLog.USR, "onResetTask, ");
        this.taskManager.s(this.caseId);
    }

    private final void I() {
        RFWLog.i(x(), RFWLog.USR, "onRestore, task size:" + a().size());
        if (!a().isEmpty()) {
            this.handler.removeCallbacks(this.checkRetry);
            this.handler.postDelayed(this.checkRetry, 3000L);
            this.handler.removeCallbacks(this.checkRetryForOffline);
            this.handler.postDelayed(this.checkRetryForOffline, 5000L);
        }
        B();
    }

    private final void J(Message msg2) {
        Object obj = msg2.obj;
        IQueueTask iQueueTask = obj instanceof IQueueTask ? (IQueueTask) obj : null;
        if (iQueueTask == null) {
            RFWLog.w(x(), RFWLog.USR, "onResumeTask, task is null ");
            return;
        }
        RFWLog.i(x(), RFWLog.USR, "onResumeTask, taskId:" + iQueueTask.getTaskId() + ", type:" + iQueueTask.getExactType());
        if (iQueueTask.getState() == 2 && iQueueTask.getResultCode() != 0) {
            iQueueTask.resetTraceId();
            WinkPublishQualityReportData.Builder ext1 = new WinkPublishQualityReportData.Builder().eventId(eo.d.f396884d).ext1(iQueueTask.getClientKey());
            int retryNum = iQueueTask.getRetryNum();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(retryNum);
            WinkPublishQualityReportData.Builder ext2 = ext1.ext2(sb5.toString());
            int exactType = iQueueTask.getExactType();
            StringBuilder sb6 = new StringBuilder();
            sb6.append(exactType);
            eo.d.b(ext2.ext3(sb6.toString()).ext4(this.businessReportFlag).traceId(iQueueTask.getTraceId()).getReportData());
        }
        this.taskManager.u(iQueueTask);
        R();
        B();
    }

    private final void K(Message msg2) {
        Object obj = msg2.obj;
        IQueueTask iQueueTask = obj instanceof IQueueTask ? (IQueueTask) obj : null;
        if (iQueueTask == null) {
            RFWLog.w(x(), RFWLog.USR, "onUpdateTask, task is null ");
            return;
        }
        RFWLog.i(x(), RFWLog.USR, "onUpdateTask, taskId:" + iQueueTask.getTaskId() + ", type:" + iQueueTask.getExactType());
        this.taskManager.y(iQueueTask);
    }

    private final void L() {
        RFWLog.i(x(), RFWLog.USR, "onWifiConnected");
        this.handler.removeCallbacks(this.checkRetryForOffline2Normal);
        this.handler.postDelayed(this.checkRetryForOffline2Normal, 10000L);
    }

    private final void P(final Function0<Unit> action) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.publish.business.publishqueue.common.d
            @Override // java.lang.Runnable
            public final void run() {
                CommonPublishQueue.Q(Function0.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    private final void R() {
        try {
            this.taskManager.v();
        } catch (Exception e16) {
            xe.b.f447841a.d(e16);
        }
    }

    private final void S(IQueueTask task) {
        if (task instanceof QZoneIntimateUploadAlbumTask) {
            this.lastTaskBeginTimeMap.put(((QZoneIntimateUploadAlbumTask) task).params.getAlbumInfo().getAlbumId(), Long.valueOf(System.currentTimeMillis()));
        } else {
            this.lastTaskBeginTimeMap.put("last_task_begin_time", Long.valueOf(System.currentTimeMillis()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(CommonPublishQueue this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWLog.i(this$0.x(), RFWLog.USR, "checkRetry, run size=" + this$0.a().size());
        if (!NetworkState.isWifiConn()) {
            RFWLog.w(this$0.x(), RFWLog.USR, "checkRetry, is not wifi ");
            return;
        }
        for (IQueueTask iQueueTask : this$0.a()) {
            if (iQueueTask != null) {
                RFWLog.i(this$0.x(), RFWLog.USR, "checkRetry, repeat, run, taskId:" + iQueueTask.getTaskId());
                if (com.qzone.publish.business.publishqueue.intimate.a.f(iQueueTask, this$0.x()) && com.qzone.publish.business.publishqueue.intimate.a.g(iQueueTask, this$0.x()) && !this$0.h(iQueueTask, true)) {
                    this$0.j(iQueueTask);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(CommonPublishQueue this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWLog.i(this$0.x(), RFWLog.USR, "checkRetryForOffline, run ");
        this$0.R();
        this$0.B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(CommonPublishQueue this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWLog.i(this$0.x(), RFWLog.USR, "checkRetryForOffline2Normal, run size=" + this$0.a().size());
        for (IQueueTask iQueueTask : this$0.a()) {
            if (iQueueTask != null) {
                RFWLog.i(this$0.x(), RFWLog.USR, "checkRetryForOffline2Normal, repeat, run, taskId:" + iQueueTask.getTaskId());
                if (com.qzone.publish.business.publishqueue.intimate.a.f(iQueueTask, this$0.x()) && com.qzone.publish.business.publishqueue.intimate.a.g(iQueueTask, this$0.x()) && !this$0.h(iQueueTask, true)) {
                    this$0.j(iQueueTask);
                }
            }
        }
    }

    private final void r(IQueueTask task) {
        if (Intrinsics.areEqual(this.caseId, task.getCaseId())) {
            return;
        }
        RFWLog.fatal(x(), RFWLog.USR, new RuntimeException(this + " want caseId is " + this.caseId + ", but get " + task.getCaseId()));
    }

    private final List<com.qzone.publish.business.publishqueue.b> s() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.listeners) {
            Iterator<T> it = this.listeners.iterator();
            while (it.hasNext()) {
                com.qzone.publish.business.publishqueue.b bVar = (com.qzone.publish.business.publishqueue.b) ((WeakReference) it.next()).get();
                if (bVar != null) {
                    Intrinsics.checkNotNullExpressionValue(bVar, "this");
                    arrayList.add(bVar);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        return arrayList;
    }

    private final boolean t(IQueueTask task) {
        return this.taskManager.d(task);
    }

    private final void u(IQueueTask task, QZoneQueueTask queueTask, boolean isSucceed) {
        String sb5;
        WinkPublishQualityReportData.Builder ext1 = new WinkPublishQualityReportData.Builder().eventId(eo.d.f396883c).ext1(task.getClientKey());
        int retryNum = task.getRetryNum();
        StringBuilder sb6 = new StringBuilder();
        sb6.append(retryNum);
        WinkPublishQualityReportData.Builder ext2 = ext1.ext2(sb6.toString());
        int exactType = task.getExactType();
        StringBuilder sb7 = new StringBuilder();
        sb7.append(exactType);
        WinkPublishQualityReportData.Builder traceId = ext2.ext3(sb7.toString()).ext4(this.businessReportFlag).traceId(task.getTraceId());
        if (isSucceed) {
            sb5 = "0";
        } else {
            int resultCode = task.getResultCode();
            StringBuilder sb8 = new StringBuilder();
            sb8.append(resultCode);
            sb5 = sb8.toString();
        }
        WinkPublishQualityReportData.Builder retCode = traceId.retCode(sb5);
        com.qzone.publish.business.model.a reportInfo = queueTask != null ? queueTask.getReportInfo() : null;
        if (reportInfo != null) {
            reportInfo.f51013d = System.currentTimeMillis();
            JSONObject c16 = reportInfo.c();
            if (c16 != null) {
                retCode.attachInfo(c16.toString());
            }
            QZoneProcessType breakTaskProcessType = queueTask.getBreakTaskProcessType();
            if (breakTaskProcessType != null && !isSucceed) {
                retCode.desc(breakTaskProcessType.convertErrorDesc(task.getResultMsg()));
            } else {
                retCode.desc(task.getResultMsg());
            }
        } else {
            retCode.desc(task.getResultMsg());
        }
        eo.d.b(retCode.getReportData());
    }

    private final long w() {
        return this.taskManager.e(this.caseId);
    }

    public final boolean A() {
        return this.taskManager.l(this.caseId);
    }

    public void G(Message msg2) {
        String str;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Object obj = msg2.obj;
        IQueueTask iQueueTask = obj instanceof IQueueTask ? (IQueueTask) obj : null;
        if (iQueueTask == null) {
            RFWLog.w(x(), RFWLog.USR, "onRemoveTask, task is null ");
            return;
        }
        if (iQueueTask.getState() == 2 && iQueueTask.getResultCode() != 0) {
            str = eo.d.f396885e;
            Intrinsics.checkNotNullExpressionValue(str, "{\n            QZonePubli\u2026_TASK_ON_FAILED\n        }");
        } else {
            str = eo.d.f396886f;
            Intrinsics.checkNotNullExpressionValue(str, "{\n            QZonePubli\u2026TASK_ON_PROCESS\n        }");
        }
        WinkPublishQualityReportData.Builder ext1 = new WinkPublishQualityReportData.Builder().eventId(str).ext1(iQueueTask.getClientKey());
        int retryNum = iQueueTask.getRetryNum();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(retryNum);
        WinkPublishQualityReportData.Builder ext2 = ext1.ext2(sb5.toString());
        int exactType = iQueueTask.getExactType();
        StringBuilder sb6 = new StringBuilder();
        sb6.append(exactType);
        eo.d.b(ext2.ext3(sb6.toString()).ext4(this.businessReportFlag).traceId(iQueueTask.getTraceId()).getReportData());
        RFWLog.i(x(), RFWLog.USR, "onRemoveTask, taskId:" + iQueueTask.getTaskId() + ", type:" + iQueueTask.getExactType());
        this.taskManager.p(iQueueTask);
        R();
        B();
    }

    public final void N() {
        RFWLog.i(x(), RFWLog.USR, "resetQueue ");
        NetworkState.removeListener(this);
        synchronized (this.listeners) {
            this.listeners.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void O() {
        Message obtain = Message.obtain();
        obtain.what = 5;
        this.handler.sendMessage(obtain);
    }

    @Override // com.qzone.publish.business.publishqueue.a
    public CopyOnWriteArrayList<IQueueTask> a() {
        return this.taskManager.f(this.caseId);
    }

    @Override // com.qzone.publish.business.publishqueue.a
    public void d(final IQueueTask task) {
        try {
            for (final com.qzone.publish.business.publishqueue.b bVar : s()) {
                P(new Function0<Unit>() { // from class: com.qzone.publish.business.publishqueue.common.CommonPublishQueue$notifyProgress$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        com.qzone.publish.business.publishqueue.b.this.H(task);
                    }
                });
            }
        } catch (Exception e16) {
            xe.b.f447841a.d(e16);
        }
    }

    @Override // com.qzone.publish.business.publishqueue.a
    public CopyOnWriteArrayList<IQueueTask> e() {
        return this.taskManager.g(this.caseId);
    }

    @Override // com.qzone.publish.business.publishqueue.a
    public boolean h(IQueueTask task, boolean notify) {
        boolean a16 = com.qzone.publish.business.publishqueue.intimate.a.a(task, x());
        if (a16 && notify) {
            B();
        }
        return a16;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        switch (msg2.what) {
            case 1:
                C(msg2);
                return false;
            case 2:
                J(msg2);
                return false;
            case 3:
                F(msg2);
                return false;
            case 4:
                G(msg2);
                return false;
            case 5:
                I();
                return false;
            case 6:
                D(msg2);
                return false;
            case 7:
                H();
                return false;
            case 8:
                K(msg2);
                return false;
            default:
                return false;
        }
    }

    @Override // cooperation.qzone.util.NetworkState.NetworkStateListener
    public void onNetworkConnect(boolean connected) {
        RFWLog.i(x(), RFWLog.USR, "onNetworkConnect, connected:" + connected);
        if (connected && NetworkState.isWifiConn()) {
            L();
        } else {
            if (!connected || NetworkState.isWifiConn() || TMSManager.e().h()) {
                return;
            }
            E();
        }
    }

    public String x() {
        return "upload2-CommonPublishQueue";
    }

    public final int y() {
        return a().size();
    }

    public final boolean z() {
        return this.taskManager.j(this.caseId);
    }

    @Override // com.qzone.publish.business.publishqueue.a
    public void b(IQueueTask task) {
        if (task == null) {
            RFWLog.w(x(), RFWLog.USR, "addTask, task is null ");
            return;
        }
        r(task);
        RFWLog.i(x(), RFWLog.USR, "addTask, taskId: " + task.getTaskId());
        task.setTime(System.currentTimeMillis());
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = task;
        this.handler.sendMessage(obtain);
    }

    @Override // com.qzone.publish.business.publishqueue.a
    public void c(IQueueTask task) {
        if (task == null) {
            RFWLog.w(x(), RFWLog.USR, "updateTask, task is null ");
            return;
        }
        r(task);
        RFWLog.i(x(), RFWLog.USR, "updateTask, taskId: " + task.getTaskId() + ", state=" + task.getState());
        Message obtain = Message.obtain();
        obtain.what = 8;
        obtain.obj = task;
        this.handler.sendMessage(obtain);
    }

    @Override // com.qzone.publish.business.publishqueue.a
    public void g(IQueueTask task, boolean successed) {
        if (task == null) {
            RFWLog.w(x(), RFWLog.USR, "completeTask, task is null ");
            return;
        }
        r(task);
        RFWLog.i(x(), RFWLog.USR, "completeTask, taskId:" + task.getTaskId());
        Message obtain = Message.obtain();
        obtain.what = 6;
        obtain.arg1 = successed ? 1 : 0;
        obtain.obj = task;
        this.handler.sendMessage(obtain);
    }

    @Override // com.qzone.publish.business.publishqueue.a
    public void j(IQueueTask task) {
        if (task == null) {
            RFWLog.w(x(), RFWLog.USR, "resumeTask, task is null ");
            return;
        }
        r(task);
        S(task);
        RFWLog.i(x(), RFWLog.USR, "resumeTask, taskId:" + task.getTaskId());
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = task;
        this.handler.sendMessage(obtain);
    }

    public final long v(String albumId) {
        Comparable maxOrNull;
        Long l3;
        if (albumId == null || (l3 = this.lastTaskBeginTimeMap.get(albumId)) == null) {
            maxOrNull = CollectionsKt___CollectionsKt.maxOrNull((Iterable<? extends Comparable>) this.lastTaskBeginTimeMap.values());
            l3 = (Long) maxOrNull;
            if (l3 == null) {
                return 0L;
            }
        }
        return l3.longValue();
    }

    public void M(com.qzone.publish.business.publishqueue.b listener) {
        if (listener == null) {
            return;
        }
        synchronized (this.listeners) {
            Iterator<WeakReference<com.qzone.publish.business.publishqueue.b>> it = this.listeners.iterator();
            while (it.hasNext()) {
                WeakReference<com.qzone.publish.business.publishqueue.b> next = it.next();
                if (next.get() == null) {
                    it.remove();
                } else if (next.get() == listener) {
                    it.remove();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.qzone.publish.business.publishqueue.a
    public boolean f(IQueueTask task) {
        boolean z16 = false;
        if (task == null) {
            RFWLog.w(x(), RFWLog.USR, "removeTask, task is null ");
            return false;
        }
        r(task);
        RFWLog.i(x(), RFWLog.USR, "removeTask, taskId: " + task.getTaskId());
        if (t(task)) {
            int state = task.getState();
            if (state == 0 || state == 2 || state == 5 || state == 6 || task.cancel()) {
                z16 = true;
            } else {
                RFWLog.w(x(), RFWLog.USR, "removeTask, cancel fail ");
            }
        }
        Message obtain = Message.obtain();
        obtain.what = 4;
        obtain.obj = task;
        this.handler.sendMessage(obtain);
        return z16;
    }

    @Override // com.qzone.publish.business.publishqueue.a
    public void i(com.qzone.publish.business.publishqueue.b listener) {
        if (listener == null) {
            return;
        }
        synchronized (this.listeners) {
            Iterator<WeakReference<com.qzone.publish.business.publishqueue.b>> it = this.listeners.iterator();
            while (it.hasNext()) {
                WeakReference<com.qzone.publish.business.publishqueue.b> next = it.next();
                if (next.get() == null) {
                    it.remove();
                } else if (next.get() == listener) {
                    return;
                }
            }
            this.listeners.add(new WeakReference<>(listener));
        }
    }
}
