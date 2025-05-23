package com.tencent.mobileqq.winkpublish.outbox.task;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.model.params.ExportParams;
import com.tencent.mobileqq.winkpublish.model.params.MediaParams;
import com.tencent.mobileqq.winkpublish.model.params.VideoParams;
import com.tencent.mobileqq.winkpublish.model.params.WinkPublishParams;
import com.tencent.mobileqq.winkpublish.outbox.d;
import com.tencent.mobileqq.winkpublish.outbox.exceptions.FinishException;
import com.tencent.mobileqq.winkpublish.outbox.exceptions.NetworkException;
import com.tencent.mobileqq.winkpublish.outbox.exceptions.PreUploadException;
import com.tencent.mobileqq.winkpublish.outbox.exceptions.RetryException;
import com.tencent.mobileqq.winkpublish.outbox.exceptions.WinkPublishBaseException;
import com.tencent.mobileqq.winkpublish.outbox.slot.c;
import com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.PublishFeedFeat;
import com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.e;
import com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.f;
import com.tencent.mobileqq.winkpublish.outbox.task.feature.group.EAUVideoCoverAsyncFeatGroup;
import com.tencent.mobileqq.winkpublish.outbox.task.feature.group.UWEVideoCoverAsyncFeatGroup;
import com.tencent.mobileqq.winkpublish.report.TaskErrorCode;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Job;
import mqq.manager.MainTicketCallback;
import mqq.manager.MainTicketInfo;
import mqq.manager.TicketManager;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 G2\u00020\u0001:\u0001RB\u000f\u0012\u0006\u0010(\u001a\u00020$\u00a2\u0006\u0004\bP\u0010QJ\u0013\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0002J\b\u0010\u0015\u001a\u00020\u0007H\u0002J\u0013\u0010\u0016\u001a\u00020\u0005H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0004J\u0014\u0010\u001a\u001a\u00020\u00022\n\u0010\u0019\u001a\u00060\u0017j\u0002`\u0018H\u0002J\u0014\u0010\u001b\u001a\u00020\u00052\n\u0010\u0019\u001a\u00060\u0017j\u0002`\u0018H\u0002J\u0006\u0010\u001c\u001a\u00020\u0007J\u0006\u0010\u001d\u001a\u00020\u0007J\u0006\u0010\u001e\u001a\u00020\u0007J\u000e\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010 \u001a\u00020\u0007J\u0006\u0010!\u001a\u00020\u0007J\u0006\u0010#\u001a\u00020\"R\u0017\u0010(\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010%\u001a\u0004\b&\u0010'R\"\u00100\u001a\u00020)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R*\u00107\u001a\n\u0018\u00010\u0017j\u0004\u0018\u0001`\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010>\u001a\u0002088\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010\n\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0018\u0010A\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010@R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010@R\u0016\u0010C\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001cR\u0011\u0010F\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\bD\u0010ER\u0011\u0010I\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\bG\u0010HR$\u0010\u0006\u001a\u00020\u00052\u0006\u0010J\u001a\u00020\u00058F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bK\u0010E\"\u0004\bL\u0010MR\u0011\u0010O\u001a\u0002088F\u00a2\u0006\u0006\u001a\u0004\bN\u0010;\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006S"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/task/BaseTask;", "Lva3/b;", "", BdhLogUtil.LogTag.Tag_Req, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "state", "", "P", UserInfo.SEX_FEMALE, "J", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/b;", "l", "head", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", "Lcom/tencent/mobileqq/winkpublish/model/params/WinkPublishParams;", "newParams", "O", "D", BdhLogUtil.LogTag.Tag_Conn, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "I", "G", "r", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "o", "H", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;", "Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;", "y", "()Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;", "taskContext", "Lcom/tencent/mobileqq/winkpublish/outbox/slot/a;", "f", "Lcom/tencent/mobileqq/winkpublish/outbox/slot/a;", "v", "()Lcom/tencent/mobileqq/winkpublish/outbox/slot/a;", "L", "(Lcom/tencent/mobileqq/winkpublish/outbox/slot/a;)V", "slot", h.F, "Ljava/lang/Exception;", "t", "()Ljava/lang/Exception;", "K", "(Ljava/lang/Exception;)V", "exception", "", "i", "w", "()J", "M", "(J)V", "startWaitForOfflineMs", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/Job;", "job", SemanticAttributes.FaasTriggerValues.TIMER, "timerRunTimes", ReportConstant.COSTREPORT_PREFIX, "()I", "businessType", "E", "()Z", "isTrueUpload", "value", HippyTKDListViewAdapter.X, "N", "(I)V", "u", "id", "<init>", "(Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;)V", "a", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class BaseTask extends va3.b {

    /* renamed from: C, reason: from kotlin metadata */
    private Job timer;

    /* renamed from: D, reason: from kotlin metadata */
    private int timerRunTimes;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final TaskContext taskContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.winkpublish.outbox.slot.a slot;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Exception exception;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long startWaitForOfflineMs;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Job job;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/winkpublish/outbox/task/BaseTask$b", "Lmqq/manager/MainTicketCallback;", "Lmqq/manager/MainTicketInfo;", "info", "", "onSuccess", "", "errorCode", "", "errorMsg", "onFail", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements MainTicketCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Boolean> f327288a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f327289b;

        /* JADX WARN: Multi-variable type inference failed */
        b(CancellableContinuation<? super Boolean> cancellableContinuation, long j3) {
            this.f327288a = cancellableContinuation;
            this.f327289b = j3;
        }

        @Override // mqq.manager.MainTicketCallback
        public void onFail(int errorCode, String errorMsg) {
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            if (!this.f327288a.isActive()) {
                QLog.w("WinkPublish-upload2-BaseTask", 1, "[waitForA2] cont is not active");
                return;
            }
            QLog.w("WinkPublish-upload2-BaseTask", 1, "errorCode:" + errorCode + " errorMsg:" + errorMsg);
            ConcurrentHashMap<Long, String> concurrentHashMap = ua3.a.d().f438648a;
            Intrinsics.checkNotNullExpressionValue(concurrentHashMap, "getInstance().a2Map");
            concurrentHashMap.put(Long.valueOf(this.f327289b), "");
            CancellableContinuation<Boolean> cancellableContinuation = this.f327288a;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(Boolean.FALSE));
        }

        @Override // mqq.manager.MainTicketCallback
        public void onSuccess(MainTicketInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            if (!this.f327288a.isActive()) {
                QLog.w("WinkPublish-upload2-BaseTask", 1, "[waitForA2] cont is not active");
                return;
            }
            QLog.i("WinkPublish-upload2-BaseTask", 1, "preGetA2... onSuccess info:" + this.f327289b);
            ConcurrentHashMap<Long, String> concurrentHashMap = ua3.a.d().f438648a;
            Intrinsics.checkNotNullExpressionValue(concurrentHashMap, "getInstance().a2Map");
            concurrentHashMap.put(Long.valueOf(this.f327289b), info.getA2());
            CancellableContinuation<Boolean> cancellableContinuation = this.f327288a;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(Boolean.TRUE));
        }
    }

    public BaseTask(TaskContext taskContext) {
        Intrinsics.checkNotNullParameter(taskContext, "taskContext");
        this.taskContext = taskContext;
        this.slot = c.f327281a.a(s()).j();
        this.startWaitForOfflineMs = -1L;
    }

    private final int B(Exception e16) {
        if (e16 instanceof RetryException) {
            return 1;
        }
        if (e16 instanceof NetworkException) {
            return 6;
        }
        if (!(e16 instanceof PreUploadException)) {
            if (e16 instanceof FinishException) {
                return 3;
            }
            if (this.taskContext.B()) {
                return 5;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean D() {
        return x() == 0 || x() == 1 || x() == 6;
    }

    private final boolean F() {
        if (uq3.c.W6()) {
            return true;
        }
        QLog.i("WinkPublish-upload2-BaseTask", 1, "[isWnsOpenUploadCoverAsync] wns config is closed");
        return false;
    }

    private final boolean J() {
        int random;
        if (!F()) {
            return false;
        }
        random = RangesKt___RangesKt.random(new IntRange(0, 1), Random.INSTANCE);
        QLog.i("WinkPublish-upload2-BaseTask", 1, "[runAsyncTest] abTest=" + random);
        TaskContext taskContext = this.taskContext;
        d.e(taskContext, "T_CATCH_IMPORTANT_INFO", taskContext.r(), null, "scene_run_async_cover_upload", String.valueOf(random), null, null, null, null, null, null, null, null, null, 16356, null);
        return random == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean O(WinkPublishParams newParams) {
        MediaParams mediaParams;
        MediaParams mediaParams2;
        Object orNull;
        Object orNull2;
        Object orNull3;
        WinkPublishParams publishParams = this.taskContext.getPublishParams();
        List<MediaParams> mediaParamsList = publishParams.getMediaParamsList();
        Integer valueOf = mediaParamsList != null ? Integer.valueOf(mediaParamsList.size()) : null;
        List<MediaParams> mediaParamsList2 = newParams.getMediaParamsList();
        if (!Intrinsics.areEqual(valueOf, mediaParamsList2 != null ? Integer.valueOf(mediaParamsList2.size()) : null)) {
            List<MediaParams> mediaParamsList3 = publishParams.getMediaParamsList();
            Integer valueOf2 = mediaParamsList3 != null ? Integer.valueOf(mediaParamsList3.size()) : null;
            List<MediaParams> mediaParamsList4 = newParams.getMediaParamsList();
            QLog.i("WinkPublish-upload2-BaseTask", 1, "[shouldReRun] different medias size, old size=" + valueOf2 + ", new size=" + (mediaParamsList4 != null ? Integer.valueOf(mediaParamsList4.size()) : null));
            return true;
        }
        if (!Intrinsics.areEqual(publishParams.getExportParams(), newParams.getExportParams())) {
            ExportParams exportParams = publishParams.getExportParams();
            Integer valueOf3 = exportParams != null ? Integer.valueOf(exportParams.getResolutionLevel()) : null;
            ExportParams exportParams2 = newParams.getExportParams();
            QLog.i("WinkPublish-upload2-BaseTask", 1, "[shouldReRun] different reExport, old reExport is " + valueOf3 + ", new reExport is " + (exportParams2 != null ? Integer.valueOf(exportParams2.getResolutionLevel()) : null));
            return true;
        }
        List<MediaParams> mediaParamsList5 = publishParams.getMediaParamsList();
        if (mediaParamsList5 != null) {
            orNull3 = CollectionsKt___CollectionsKt.getOrNull(mediaParamsList5, 0);
            mediaParams = (MediaParams) orNull3;
        } else {
            mediaParams = null;
        }
        VideoParams videoParams = mediaParams instanceof VideoParams ? (VideoParams) mediaParams : null;
        List<MediaParams> mediaParamsList6 = newParams.getMediaParamsList();
        if (mediaParamsList6 != null) {
            orNull2 = CollectionsKt___CollectionsKt.getOrNull(mediaParamsList6, 0);
            mediaParams2 = (MediaParams) orNull2;
        } else {
            mediaParams2 = null;
        }
        VideoParams videoParams2 = mediaParams2 instanceof VideoParams ? (VideoParams) mediaParams2 : null;
        if (!Intrinsics.areEqual(videoParams != null ? videoParams.getCoverPath() : null, videoParams2 != null ? videoParams2.getCoverPath() : null)) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(this.taskContext.x(), 0);
            UploadMediaInfo uploadMediaInfo = (UploadMediaInfo) orNull;
            if ((uploadMediaInfo != null ? uploadMediaInfo.getCoverUploadTask() : null) != null) {
                QLog.i("WinkPublish-upload2-BaseTask", 1, "[shouldReRun] different coverPath, old coverPath=" + (videoParams != null ? videoParams.getCoverPath() : null) + ", new coverPath=" + (videoParams2 != null ? videoParams2.getCoverPath() : null));
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P(int state) {
        BuildersKt__Builders_commonKt.launch$default(new va3.a(), null, null, new BaseTask$transferState$1(this, state, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object R(Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        QLog.i("WinkPublish-upload2-BaseTask", 1, "waitForA2...");
        long f16 = ua3.a.d().f();
        TicketManager e16 = ua3.a.d().e();
        if (e16 == null) {
            QLog.e("WinkPublish-upload2-BaseTask", 1, "ticketManager == null");
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(Boxing.boxBoolean(false)));
        } else {
            e16.getA2(f16, 16, new b(cancellableContinuationImpl, f16));
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private final com.tencent.mobileqq.winkpublish.outbox.task.feature.base.b l() {
        com.tencent.mobileqq.winkpublish.outbox.task.feature.base.b n3;
        if (this.taskContext.u() <= 0) {
            QLog.w("WinkPublish-upload2-BaseTask", 1, "[assembleFeats] no media need to be handled");
            return null;
        }
        if (this.taskContext.A()) {
            return new com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.a();
        }
        com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.b bVar = this.taskContext.getPublishParams().getFeedParams() != null ? new com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.b(new PublishFeedFeat()) : null;
        if (this.taskContext.y()) {
            n3 = new com.tencent.mobileqq.winkpublish.outbox.task.feature.group.c(bVar);
        } else {
            if (!this.taskContext.C()) {
                return bVar;
            }
            if (J()) {
                n3 = m(bVar);
            } else {
                n3 = n(bVar);
            }
        }
        return n3;
    }

    private final com.tencent.mobileqq.winkpublish.outbox.task.feature.base.b m(com.tencent.mobileqq.winkpublish.outbox.task.feature.base.b head) {
        com.tencent.mobileqq.winkpublish.outbox.task.feature.base.b eAUVideoCoverAsyncFeatGroup;
        if (this.taskContext.getPublishParams().getExportParams() != null) {
            QLog.i("WinkPublish-upload2-BaseTask", 1, "[buildVideoAsyncFeat] enableSpeedTest=" + this.taskContext.getEnableSpeedTest() + ", enableUWETest=" + this.taskContext.getEnableUWETest());
            if (this.taskContext.getEnableUWETest()) {
                eAUVideoCoverAsyncFeatGroup = new f(new EAUVideoCoverAsyncFeatGroup(head), new UWEVideoCoverAsyncFeatGroup(head));
            } else {
                eAUVideoCoverAsyncFeatGroup = new EAUVideoCoverAsyncFeatGroup(head);
            }
            return this.taskContext.getEnableSpeedTest() ? new e(eAUVideoCoverAsyncFeatGroup, new com.tencent.mobileqq.winkpublish.outbox.task.feature.group.d(head)) : eAUVideoCoverAsyncFeatGroup;
        }
        return new com.tencent.mobileqq.winkpublish.outbox.task.feature.group.d(head);
    }

    private final com.tencent.mobileqq.winkpublish.outbox.task.feature.base.b n(com.tencent.mobileqq.winkpublish.outbox.task.feature.base.b head) {
        com.tencent.mobileqq.winkpublish.outbox.task.feature.base.b aVar;
        if (this.taskContext.getPublishParams().getExportParams() != null) {
            QLog.i("WinkPublish-upload2-BaseTask", 1, "[buildVideoSyncFeat] enableSpeedTest=" + this.taskContext.getEnableSpeedTest() + ", enableUWETest=" + this.taskContext.getEnableUWETest());
            if (this.taskContext.getEnableUWETest()) {
                aVar = new f(new com.tencent.mobileqq.winkpublish.outbox.task.feature.group.a(head), new com.tencent.mobileqq.winkpublish.outbox.task.feature.group.b(head));
            } else {
                aVar = new com.tencent.mobileqq.winkpublish.outbox.task.feature.group.a(head);
            }
            return this.taskContext.getEnableSpeedTest() ? new e(aVar, new com.tencent.mobileqq.winkpublish.outbox.task.feature.group.e(head)) : aVar;
        }
        return new com.tencent.mobileqq.winkpublish.outbox.task.feature.group.e(head);
    }

    private final boolean p(int state) {
        if (state == 0 || state == 6 || state == 1 || state == 5 || state == 3 || state == -1000) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0082, code lost:
    
        r8 = r15;
        r7 = 3;
        r2 = 0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0084 A[Catch: Exception -> 0x003d, TryCatch #0 {Exception -> 0x003d, blocks: (B:11:0x0038, B:12:0x00be, B:14:0x0084, B:18:0x00ea, B:23:0x004d, B:25:0x0078), top: B:10:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00ea A[Catch: Exception -> 0x003d, TRY_LEAVE, TryCatch #0 {Exception -> 0x003d, blocks: (B:11:0x0038, B:12:0x00be, B:14:0x0084, B:18:0x00ea, B:23:0x004d, B:25:0x0078), top: B:10:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0078 A[Catch: Exception -> 0x003d, TryCatch #0 {Exception -> 0x003d, blocks: (B:11:0x0038, B:12:0x00be, B:14:0x0084, B:18:0x00ea, B:23:0x004d, B:25:0x0078), top: B:10:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x00bb -> B:12:0x00be). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object q(Continuation<? super Integer> continuation) {
        BaseTask$doRunFeats$1 baseTask$doRunFeats$1;
        Object coroutine_suspended;
        int i3;
        BaseTask baseTask;
        int B;
        com.tencent.mobileqq.winkpublish.outbox.task.feature.base.b l3;
        com.tencent.mobileqq.winkpublish.outbox.task.feature.base.b bVar;
        int i16;
        boolean z16;
        if (continuation instanceof BaseTask$doRunFeats$1) {
            baseTask$doRunFeats$1 = (BaseTask$doRunFeats$1) continuation;
            int i17 = baseTask$doRunFeats$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                baseTask$doRunFeats$1.label = i17 - Integer.MIN_VALUE;
                Object obj = baseTask$doRunFeats$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = baseTask$doRunFeats$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    baseTask = this;
                    QLog.i("WinkPublish-upload2-BaseTask", 1, "[doRunFeats] run times=" + baseTask.taskContext.getSeqId() + ", task id=" + baseTask.u());
                    l3 = baseTask.l();
                    if (l3 == null) {
                    }
                    bVar = l3;
                    B = 3;
                    i16 = 0;
                    if (bVar == null) {
                    }
                } else if (i3 == 1) {
                    int i18 = baseTask$doRunFeats$1.I$1;
                    B = baseTask$doRunFeats$1.I$0;
                    bVar = (com.tencent.mobileqq.winkpublish.outbox.task.feature.base.b) baseTask$doRunFeats$1.L$1;
                    baseTask = (BaseTask) baseTask$doRunFeats$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        i16 = i18;
                    } catch (Exception e16) {
                        QLog.w("WinkPublish-upload2-BaseTask", 1, "[run] task id=" + baseTask.u() + " ", e16);
                        baseTask.exception = e16;
                        boolean A = baseTask.A(e16);
                        B = baseTask.B(e16);
                        z16 = A;
                    }
                    QLog.i("WinkPublish-upload2-BaseTask", 1, "[run] end feat=" + bVar.getClass().getSimpleName() + ", task id=" + baseTask.u());
                    bVar = bVar.getNext();
                    if (bVar == null) {
                        QLog.i("WinkPublish-upload2-BaseTask", 1, "[run] begin feat=" + bVar.getClass().getSimpleName() + ", task id=" + baseTask.u());
                        TaskContext taskContext = baseTask.taskContext;
                        baseTask$doRunFeats$1.L$0 = baseTask;
                        baseTask$doRunFeats$1.L$1 = bVar;
                        baseTask$doRunFeats$1.I$0 = B;
                        baseTask$doRunFeats$1.I$1 = i16;
                        baseTask$doRunFeats$1.label = 1;
                        i16 = i16;
                        if (bVar.a(taskContext, baseTask$doRunFeats$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        QLog.i("WinkPublish-upload2-BaseTask", 1, "[run] end feat=" + bVar.getClass().getSimpleName() + ", task id=" + baseTask.u());
                        bVar = bVar.getNext();
                        if (bVar == null) {
                            baseTask.taskContext.I("0");
                            baseTask.taskContext.J("");
                            z16 = i16;
                            boolean z17 = z16;
                            QLog.i("WinkPublish-upload2-BaseTask", 1, "[doRunFeats] shouldRetry=" + z17 + ", task id=" + baseTask.u());
                            if (!z16) {
                                return Boxing.boxInt(B);
                            }
                            QLog.i("WinkPublish-upload2-BaseTask", 1, "[doRunFeats] run times=" + baseTask.taskContext.getSeqId() + ", task id=" + baseTask.u());
                            l3 = baseTask.l();
                            if (l3 == null) {
                                QLog.w("WinkPublish-upload2-BaseTask", 1, "[run] no feature need to executed");
                            }
                            bVar = l3;
                            B = 3;
                            i16 = 0;
                            if (bVar == null) {
                            }
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        baseTask$doRunFeats$1 = new BaseTask$doRunFeats$1(this, continuation);
        Object obj2 = baseTask$doRunFeats$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = baseTask$doRunFeats$1.label;
        if (i3 != 0) {
        }
    }

    public final boolean E() {
        return this.taskContext.getPublishParams().isTruePublish();
    }

    public final void G() {
        QLog.i("WinkPublish-upload2-BaseTask", 1, "[ready] task id=" + u());
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new BaseTask$ready$1(this, null), 3, null);
    }

    public final void H() {
        QLog.i("WinkPublish-upload2-BaseTask", 1, "[reset] task id=" + u());
        this.taskContext.D();
    }

    public final void I() {
        Job launch$default;
        QLog.i("WinkPublish-upload2-BaseTask", 1, "[run] begin, task id=" + u());
        if (this.taskContext.getStartTimeMillis() == 0) {
            this.taskContext.N(System.currentTimeMillis());
        }
        Job job = this.job;
        boolean z16 = false;
        if (job != null && job.isActive()) {
            z16 = true;
        }
        if (z16) {
            QLog.w("WinkPublish-upload2-BaseTask", 1, "[run] already have a job");
            Job job2 = this.job;
            if (job2 != null) {
                Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
            }
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(this, null, null, new BaseTask$run$1(this, null), 3, null);
        this.job = launch$default;
    }

    public final void K(Exception exc) {
        this.exception = exc;
    }

    public final void L(com.tencent.mobileqq.winkpublish.outbox.slot.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.slot = aVar;
    }

    public final void M(long j3) {
        this.startWaitForOfflineMs = j3;
    }

    public final void N(int i3) {
        if (p(i3)) {
            this.taskContext.O(i3);
            return;
        }
        throw new IllegalStateException("invalid state: " + i3);
    }

    public final void Q(WinkPublishParams newParams) {
        Intrinsics.checkNotNullParameter(newParams, "newParams");
        QLog.i("WinkPublish-upload2-BaseTask", 1, "[update] task id=" + u() + ", traceId=" + newParams.getTraceId() + ", cameraSessionId=" + this.taskContext.getDtCameraSessionId());
        if (!this.taskContext.B()) {
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new BaseTask$update$1(this, newParams, null), 3, null);
        } else {
            QLog.i("WinkPublish-upload2-BaseTask", 1, "[update] true publish task no need update");
        }
    }

    public final void o() {
        long u16 = u();
        Job job = this.job;
        QLog.i("WinkPublish-upload2-BaseTask", 1, "[cancel] task id=" + u16 + " job:" + (job != null ? Boolean.valueOf(job.isActive()) : null));
        Job job2 = this.job;
        boolean z16 = false;
        if (job2 != null && job2.isActive()) {
            z16 = true;
        }
        if (z16) {
            Job job3 = this.job;
            if (job3 != null) {
                Job.DefaultImpls.cancel$default(job3, (CancellationException) null, 1, (Object) null);
                return;
            }
            return;
        }
        P(5);
    }

    public final void r() {
        QLog.i("WinkPublish-upload2-BaseTask", 1, "[finish] task id=" + u());
        Job job = this.job;
        if (job != null && job.isActive()) {
            Job job2 = this.job;
            if (job2 != null) {
                job2.cancel((CancellationException) new FinishException(new TaskErrorCode(0L, null, 2, null)));
                return;
            }
            return;
        }
        P(3);
    }

    public final int s() {
        return this.taskContext.b();
    }

    /* renamed from: t, reason: from getter */
    public final Exception getException() {
        return this.exception;
    }

    public final long u() {
        return this.taskContext.getId();
    }

    /* renamed from: v, reason: from getter */
    public final com.tencent.mobileqq.winkpublish.outbox.slot.a getSlot() {
        return this.slot;
    }

    /* renamed from: w, reason: from getter */
    public final long getStartWaitForOfflineMs() {
        return this.startWaitForOfflineMs;
    }

    public final int x() {
        return this.taskContext.getState();
    }

    /* renamed from: y, reason: from getter */
    public final TaskContext getTaskContext() {
        return this.taskContext;
    }

    public final TaskInfo z() {
        return this.taskContext.R();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C() {
        QLog.i("WinkPublish-upload2-BaseTask", 1, "[initUpload]");
        com.tencent.mobileqq.winkpublish.uploader.b bVar = new com.tencent.mobileqq.winkpublish.uploader.b();
        UploadServiceBuilder.init(RFWApplication.getApplication(), new com.tencent.mobileqq.winkpublish.uploader.a(), new com.tencent.mobileqq.winkpublish.uploader.c(), new com.tencent.mobileqq.winkpublish.uploader.d(), bVar, bVar, null);
    }

    private final boolean A(Exception e16) {
        String str;
        if (e16 instanceof RetryException) {
            this.taskContext.I(String.valueOf(((RetryException) e16).getErrorCode()));
            TaskContext taskContext = this.taskContext;
            String message = e16.getMessage();
            if (message == null) {
                message = "";
            }
            taskContext.J(message);
            TaskContext taskContext2 = this.taskContext;
            String r16 = taskContext2.r();
            String valueOf = String.valueOf(((RetryException) e16).getErrorCode());
            String message2 = e16.getMessage();
            String str2 = message2 == null ? "" : message2;
            if (this.taskContext.B()) {
                str = "1";
            } else {
                str = "0";
            }
            d.e(taskContext2, "T_CATCH_IMPORTANT_INFO", r16, valueOf, "scene_task_retry", str, String.valueOf(this.taskContext.getUploadTaskType()), null, null, null, str2, null, null, null, null, 15808, null);
            this.taskContext.D();
            return true;
        }
        if (e16 instanceof WinkPublishBaseException) {
            this.taskContext.I(String.valueOf(((WinkPublishBaseException) e16).getErrorCode()));
            TaskContext taskContext3 = this.taskContext;
            String message3 = e16.getMessage();
            taskContext3.J(message3 != null ? message3 : "");
        } else if (e16 instanceof CancellationException) {
            TaskErrorCode taskErrorCode = new TaskErrorCode(TaskErrorCode.ERROR_CODE_CANCEL, null, 2, null);
            this.taskContext.I(String.valueOf(taskErrorCode.transformedCode()));
            this.taskContext.J(taskErrorCode.getMessage());
        } else {
            TaskErrorCode taskErrorCode2 = new TaskErrorCode(TaskErrorCode.ERROR_CODE_UNKNOWN, null, 2, null);
            this.taskContext.I(String.valueOf(taskErrorCode2.transformedCode()));
            this.taskContext.J(taskErrorCode2.getMessage());
        }
        return false;
    }
}
