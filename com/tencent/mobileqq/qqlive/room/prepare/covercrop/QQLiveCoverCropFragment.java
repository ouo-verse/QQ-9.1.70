package com.tencent.mobileqq.qqlive.room.prepare.covercrop;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.IQQLiveUtil;
import com.tencent.mobileqq.qqlive.base.QQLiveBaseFragment;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qqlive.data.CoverInfo;
import com.tencent.mobileqq.qqlive.data.common.QQLiveError;
import com.tencent.mobileqq.qqlive.data.upload.QQLiveUploadBitmapParams;
import com.tencent.mobileqq.qqlive.data.upload.QQLiveUploadBitmapResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkpublish.WinkPublishServiceProxy2;
import com.tencent.mobileqq.winkpublish.api.ITaskListener;
import com.tencent.mobileqq.winkpublish.model.params.ImageParams;
import com.tencent.mobileqq.winkpublish.model.params.WinkPublishParams;
import com.tencent.mobileqq.winkpublish.result.ImageResult;
import com.tencent.mobileqq.winkpublish.result.MediaUploadResult;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.api.IQQLiveReportApi;
import com.tencent.qqlive.common.report.constant.QQLiveQualityReportData;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.timi.game.utils.o;
import com.tencent.weiyun.transmission.db.JobDbManager;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 S2\u00020\u0001:\u0001TB\u0007\u00a2\u0006\u0004\bQ\u0010RJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u001a\u0010\u000b\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0014J\b\u0010\u0017\u001a\u00020\tH\u0016J\u001a\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0012J\b\u0010\u001d\u001a\u00020\u0004H\u0016R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\"\u00108\u001a\u0002018\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001b\u0010<\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u00109\u001a\u0004\b:\u0010;R\u001b\u0010?\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u00109\u001a\u0004\b>\u0010;R\u001b\u0010D\u001a\u00020@8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bA\u00109\u001a\u0004\bB\u0010CR\u001b\u0010I\u001a\u00020E8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bF\u00109\u001a\u0004\bG\u0010HR\u001b\u0010L\u001a\u00020E8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bJ\u00109\u001a\u0004\bK\u0010HR\u0014\u0010P\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010O\u00a8\u0006U"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/prepare/covercrop/QQLiveCoverCropFragment;", "Lcom/tencent/mobileqq/qqlive/base/QQLiveBaseFragment;", "Landroid/view/View;", "view", "", "initView", "Qh", "Lcom/tencent/mobileqq/qqlive/data/upload/QQLiveUploadBitmapResult;", "result", "", "isFinishActivity", "Th", "Hh", "Wh", "Lcom/tencent/mobileqq/qqlive/data/upload/QQLiveUploadBitmapParams;", "Ih", "Landroid/content/Intent;", "Nh", "", "eventId", "Vh", "", "getContentLayoutId", "isWrapContent", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "photoPath", "Uh", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/view/ViewGroup;", "D", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "E", "Z", "isUploading", "", UserInfo.SEX_FEMALE, "J", "startUploadTimeStamp", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "G", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "winkTaskInfo", "Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2;", "H", "Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2;", "winkPublishService", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "I", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "Mh", "()Lcom/tencent/mobileqq/widget/QQProgressDialog;", "Sh", "(Lcom/tencent/mobileqq/widget/QQProgressDialog;)V", "progressDialog", "Lkotlin/Lazy;", "getMediaPath", "()Ljava/lang/String;", "mediaPath", "K", "getRoomId", "roomId", "Lcom/tencent/mobileqq/qqlive/room/prepare/covercrop/LoadBitmapTask;", "L", "Kh", "()Lcom/tencent/mobileqq/qqlive/room/prepare/covercrop/LoadBitmapTask;", "loadBitmapTask", "Lkotlinx/coroutines/CoroutineScope;", "M", "Jh", "()Lkotlinx/coroutines/CoroutineScope;", "fileScope", "N", "Lh", "networkScope", "Lcom/tencent/mobileqq/winkpublish/api/ITaskListener$Stub;", "P", "Lcom/tencent/mobileqq/winkpublish/api/ITaskListener$Stub;", "mUploadCallback", "<init>", "()V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveCoverCropFragment extends QQLiveBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: D, reason: from kotlin metadata */
    private ViewGroup rootView;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isUploading;

    /* renamed from: F, reason: from kotlin metadata */
    private long startUploadTimeStamp;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private TaskInfo winkTaskInfo;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private WinkPublishServiceProxy2 winkPublishService;

    /* renamed from: I, reason: from kotlin metadata */
    public QQProgressDialog progressDialog;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy mediaPath;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy roomId;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy loadBitmapTask;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy fileScope;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Lazy networkScope;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final ITaskListener.Stub mUploadCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/prepare/covercrop/QQLiveCoverCropFragment$a;", "", "", "RATIO_CONST", "Ljava/lang/String;", "", "RATIO_TYPE_17_24", "I", "ROOM_ID", "SINGLE_PHOTO_PATH", "TAG", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.room.prepare.covercrop.QQLiveCoverCropFragment$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqlive/room/prepare/covercrop/QQLiveCoverCropFragment$b", "Lcom/tencent/mobileqq/winkpublish/api/ITaskListener$Stub;", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "taskInfo", "", "onTaskChange", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends ITaskListener.Stub {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveCoverCropFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.winkpublish.api.ITaskListener
        public void onTaskChange(@NotNull TaskInfo taskInfo) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) taskInfo);
                return;
            }
            Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
            AegisLogger.INSTANCE.d("Open_Live|QQLiveCoverCropFragment", "onTaskChange", "taskInfo:" + taskInfo);
            if (QQLiveCoverCropFragment.this.winkTaskInfo != null) {
                TaskInfo taskInfo2 = QQLiveCoverCropFragment.this.winkTaskInfo;
                Intrinsics.checkNotNull(taskInfo2);
                if (taskInfo2.getTaskId() == taskInfo.getTaskId()) {
                    if (taskInfo.isFinish() && (!taskInfo.getMediaInfos().isEmpty()) && (taskInfo.getMediaInfos().get(0).getUploadResult() instanceof ImageResult)) {
                        QQLiveUploadBitmapResult qQLiveUploadBitmapResult = new QQLiveUploadBitmapResult(0, true, "");
                        MediaUploadResult uploadResult = taskInfo.getMediaInfos().get(0).getUploadResult();
                        Intrinsics.checkNotNull(uploadResult, "null cannot be cast to non-null type com.tencent.mobileqq.winkpublish.result.ImageResult");
                        qQLiveUploadBitmapResult.url = ((ImageResult) uploadResult).getOriginUrl();
                        QQLiveCoverCropFragment.this.Th(qQLiveUploadBitmapResult, true);
                        return;
                    }
                    if (taskInfo.isCancelled()) {
                        QQLiveCoverCropFragment.this.Th(new QQLiveUploadBitmapResult(QQLiveError.UPLOAD_BITMAP_FAILED, false, "onTaskChange result code failed:" + taskInfo.getErrCode()), false);
                    }
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqlive/room/prepare/covercrop/QQLiveCoverCropFragment$c", "Lcom/tencent/mobileqq/winkpublish/WinkPublishHelper2$Callback;", "Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2;", "winkPublishServiceProxy2", "", "onServiceConnected", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c implements WinkPublishHelper2.Callback {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f271935b;

        c(String str) {
            this.f271935b = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveCoverCropFragment.this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.winkpublish.WinkPublishHelper2.Callback
        public void onServiceConnected(@NotNull WinkPublishServiceProxy2 winkPublishServiceProxy2) {
            List listOf;
            TaskInfo taskInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) winkPublishServiceProxy2);
                return;
            }
            Intrinsics.checkNotNullParameter(winkPublishServiceProxy2, "winkPublishServiceProxy2");
            AegisLogger.INSTANCE.i("Open_Live|QQLiveCoverCropFragment", "onServiceConnected");
            QQLiveCoverCropFragment.this.winkPublishService = winkPublishServiceProxy2;
            WinkPublishServiceProxy2 winkPublishServiceProxy22 = QQLiveCoverCropFragment.this.winkPublishService;
            if (winkPublishServiceProxy22 != null) {
                winkPublishServiceProxy22.addTaskListener2(QQLiveCoverCropFragment.this.mUploadCallback);
            }
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
            String traceId = QCirclePublishQualityReporter.getTraceId();
            Intrinsics.checkNotNullExpressionValue(traceId, "getTraceId()");
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new ImageParams(this.f271935b, 0, 0, 0, 0L, 0, 0, 0L, null, null, MiniReportManager.EventId.SDK_EMBEDDED_VIDEO, null));
            WinkPublishParams winkPublishParams = new WinkPublishParams(10, uuid, traceId, false, 23, listOf, null, null, null, null, 968, null);
            QQLiveCoverCropFragment qQLiveCoverCropFragment = QQLiveCoverCropFragment.this;
            WinkPublishServiceProxy2 service = WinkPublishHelper2.INSTANCE.getService(10);
            if (service != null) {
                taskInfo = service.addTask(winkPublishParams);
            } else {
                taskInfo = null;
            }
            qQLiveCoverCropFragment.winkTaskInfo = taskInfo;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35821);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveCoverCropFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.qqlive.room.prepare.covercrop.QQLiveCoverCropFragment$mediaPath$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveCoverCropFragment.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    Intent intent;
                    String stringExtra;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    FragmentActivity activity = QQLiveCoverCropFragment.this.getActivity();
                    return (activity == null || (intent = activity.getIntent()) == null || (stringExtra = intent.getStringExtra("SINGLE_PHOTO_PATH")) == null) ? "" : stringExtra;
                }
            });
            this.mediaPath = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.qqlive.room.prepare.covercrop.QQLiveCoverCropFragment$roomId$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveCoverCropFragment.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    Intent intent;
                    String stringExtra;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    FragmentActivity activity = QQLiveCoverCropFragment.this.getActivity();
                    return (activity == null || (intent = activity.getIntent()) == null || (stringExtra = intent.getStringExtra(AudienceReportConst.ROOM_ID)) == null) ? "" : stringExtra;
                }
            });
            this.roomId = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<LoadBitmapTask>() { // from class: com.tencent.mobileqq.qqlive.room.prepare.covercrop.QQLiveCoverCropFragment$loadBitmapTask$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveCoverCropFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final LoadBitmapTask invoke() {
                    ViewGroup viewGroup;
                    String mediaPath;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (LoadBitmapTask) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    FragmentActivity activity = QQLiveCoverCropFragment.this.getActivity();
                    viewGroup = QQLiveCoverCropFragment.this.rootView;
                    if (viewGroup == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                        viewGroup = null;
                    }
                    ViewGroup viewGroup2 = viewGroup;
                    mediaPath = QQLiveCoverCropFragment.this.getMediaPath();
                    return new LoadBitmapTask(2, 2, activity, viewGroup2, null, mediaPath, ViewUtils.getScreenWidth(), (ViewUtils.getScreenWidth() * 24) / 17);
                }
            });
            this.loadBitmapTask = lazy3;
            lazy4 = LazyKt__LazyJVMKt.lazy(QQLiveCoverCropFragment$fileScope$2.INSTANCE);
            this.fileScope = lazy4;
            lazy5 = LazyKt__LazyJVMKt.lazy(QQLiveCoverCropFragment$networkScope$2.INSTANCE);
            this.networkScope = lazy5;
            this.mUploadCallback = new b();
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final void Hh() {
        WinkPublishServiceProxy2 winkPublishServiceProxy2;
        TaskInfo taskInfo = this.winkTaskInfo;
        if (taskInfo != null && (winkPublishServiceProxy2 = this.winkPublishService) != null) {
            Intrinsics.checkNotNull(taskInfo);
            winkPublishServiceProxy2.cancelTaskWithId(taskInfo.getTaskId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QQLiveUploadBitmapParams Ih() {
        QQLiveUploadBitmapParams qQLiveUploadBitmapParams = new QQLiveUploadBitmapParams();
        qQLiveUploadBitmapParams.flag = this.C.getAppId();
        qQLiveUploadBitmapParams.format = "16:9";
        qQLiveUploadBitmapParams.roomId = getRoomId();
        qQLiveUploadBitmapParams.useTestEnv = Wh();
        return qQLiveUploadBitmapParams;
    }

    private final CoroutineScope Jh() {
        return (CoroutineScope) this.fileScope.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LoadBitmapTask Kh() {
        return (LoadBitmapTask) this.loadBitmapTask.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoroutineScope Lh() {
        return (CoroutineScope) this.networkScope.getValue();
    }

    private final Intent Nh(QQLiveUploadBitmapResult result) {
        Intent intent = new Intent();
        if (result != null) {
            if (result.isSuccess) {
                CoverInfo coverInfo = new CoverInfo();
                String str = result.url;
                coverInfo.roomLogo = str;
                coverInfo.roomLogo3v4 = str;
                coverInfo.roomLogo16v9 = str;
                coverInfo.roomLogoTime16v9 = result.timeStamp;
                intent.putExtra(IQQLiveUtil.COVER_INFO_KEY, coverInfo);
                Vh(QQLiveReportConstants.Event.E_SUCCESS_UPLOAD_COVER);
                AegisLogger.INSTANCE.i("Open_Live|QQLiveCoverCropFragment", "getUploadResultIntent", "upload bitmap success cover url " + result.url);
            } else {
                intent.putExtra(IQQLiveUtil.UPLOAD_ERROR_CODE, result.retCode);
                intent.putExtra(IQQLiveUtil.UPLOAD_ERROR_MESSAGE, result.errorMsg);
            }
        } else {
            intent.putExtra(IQQLiveUtil.UPLOAD_ERROR_CODE, -1);
            AegisLogger.INSTANCE.w("Open_Live|QQLiveCoverCropFragment", "getUploadResultIntent", "upload bitmap fail");
        }
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(QQLiveCoverCropFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getQBaseActivity().finish();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(QQLiveCoverCropFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!o.a()) {
            this$0.startUploadTimeStamp = System.currentTimeMillis();
            this$0.Vh(QQLiveReportConstants.Event.E_START_UPLOAD_COVER);
            this$0.Qh();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, com.tencent.mobileqq.qqlive.room.prepare.covercrop.d] */
    /* JADX WARN: Type inference failed for: r2v4, types: [T, kotlinx.coroutines.Job] */
    private final void Qh() {
        ?? launch$default;
        if (this.isUploading) {
            AegisLogger.INSTANCE.i("Open_Live|QQLiveCoverCropFragment", "onUploadCover", "the upload task is running ");
            return;
        }
        this.isUploading = true;
        Sh(new QQProgressDialog(getContext(), com.tencent.timi.game.utils.b.a(50)));
        if (!getQBaseActivity().isFinishing()) {
            Mh().show();
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        IQQLiveSDK sdk = this.C;
        Intrinsics.checkNotNullExpressionValue(sdk, "sdk");
        objectRef.element = new d(sdk);
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        launch$default = BuildersKt__Builders_commonKt.launch$default(Jh(), null, null, new QQLiveCoverCropFragment$onUploadCover$fileJob$1(objectRef, this, null), 3, null);
        objectRef2.element = launch$default;
        Mh().setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.mobileqq.qqlive.room.prepare.covercrop.c
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                QQLiveCoverCropFragment.Rh(QQLiveCoverCropFragment.this, objectRef2, objectRef, dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void Rh(QQLiveCoverCropFragment this$0, Ref.ObjectRef fileJob, Ref.ObjectRef uploadBitmapTask, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(fileJob, "$fileJob");
        Intrinsics.checkNotNullParameter(uploadBitmapTask, "$uploadBitmapTask");
        AegisLogger.INSTANCE.i("Open_Live|QQLiveCoverCropFragment", "onUploadCover", "cancel upload");
        this$0.isUploading = false;
        Job.DefaultImpls.cancel$default((Job) fileJob.element, (CancellationException) null, 1, (Object) null);
        ((d) uploadBitmapTask.element).a();
        this$0.Hh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Th(QQLiveUploadBitmapResult result, boolean isFinishActivity) {
        String str;
        WinkPublishServiceProxy2 winkPublishServiceProxy2;
        this.isUploading = false;
        ITaskListener.Stub stub = this.mUploadCallback;
        if (stub != null && (winkPublishServiceProxy2 = this.winkPublishService) != null) {
            winkPublishServiceProxy2.removeTaskListener(stub);
        }
        String str2 = null;
        this.winkPublishService = null;
        if (isFinishActivity) {
            if (!getQBaseActivity().isFinishing()) {
                if (Mh().isShowing()) {
                    Mh().dismiss();
                }
                getQBaseActivity().setResult(-1, Nh(result));
            }
            getQBaseActivity().finish();
            return;
        }
        if (Mh().isShowing()) {
            Mh().dismiss();
        }
        gt3.a a16 = gt3.a.INSTANCE.a();
        if (result != null) {
            str2 = result.errorMsg;
        }
        if (str2 == null) {
            str = "\u4e0a\u4f20\u5931\u8d25";
        } else {
            str = str2;
        }
        gt3.a.b(a16, str, 0, null, 6, null);
    }

    private final void Vh(String eventId) {
        QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
        if (c16 != null) {
            ((IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class)).qualityReport(new QQLiveQualityReportData.Builder(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108863, null).traceId(c16.n()).eventId(eventId).ext6(String.valueOf(System.currentTimeMillis())));
        }
    }

    private final boolean Wh() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getMediaPath() {
        return (String) this.mediaPath.getValue();
    }

    private final String getRoomId() {
        return (String) this.roomId.getValue();
    }

    private final void initView(View view) {
        View findViewById = view.findViewById(R.id.fqy);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.photocrop_rootview)");
        this.rootView = (ViewGroup) findViewById;
        view.findViewById(R.id.dum).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.room.prepare.covercrop.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QQLiveCoverCropFragment.Oh(QQLiveCoverCropFragment.this, view2);
            }
        });
        view.findViewById(R.id.f110876jp).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.room.prepare.covercrop.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QQLiveCoverCropFragment.Ph(QQLiveCoverCropFragment.this, view2);
            }
        });
    }

    @NotNull
    public final QQProgressDialog Mh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QQProgressDialog) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        QQProgressDialog qQProgressDialog = this.progressDialog;
        if (qQProgressDialog != null) {
            return qQProgressDialog;
        }
        Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
        return null;
    }

    public final void Sh(@NotNull QQProgressDialog qQProgressDialog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQProgressDialog);
        } else {
            Intrinsics.checkNotNullParameter(qQProgressDialog, "<set-?>");
            this.progressDialog = qQProgressDialog;
        }
    }

    public final void Uh(@NotNull String photoPath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) photoPath);
            return;
        }
        Intrinsics.checkNotNullParameter(photoPath, "photoPath");
        AegisLogger.INSTANCE.i("Open_Live|QQLiveCoverCropFragment", JobDbManager.TBL_UPLOAD, "upload:" + photoPath);
        WinkPublishHelper2.INSTANCE.bindService(10, new c(photoPath));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return R.layout.h__;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onDestroy();
        AegisLogger.INSTANCE.d("Open_Live|QQLiveCoverCropFragment", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        WinkPublishServiceProxy2 winkPublishServiceProxy2 = this.winkPublishService;
        if (winkPublishServiceProxy2 != null) {
            winkPublishServiceProxy2.removeTaskListener(this.mUploadCallback);
        }
        this.winkPublishService = null;
        this.winkTaskInfo = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setStatusBarImmersive();
        initView(view);
        Kh().g(true);
    }
}
