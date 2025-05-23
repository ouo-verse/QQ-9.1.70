package com.tencent.mobileqq.wink.aigc.newtest;

import androidx.lifecycle.ViewModel;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.request.WinkMaliGetModelsRequest;
import com.tencent.mobileqq.wink.request.WinkMaliQueryRequest;
import com.tencent.mobileqq.wink.request.WinkMaliSubmitRequest;
import com.tencent.mobileqq.winkpublish.MediaInfo;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkpublish.WinkPublishServiceProxy2;
import com.tencent.mobileqq.winkpublish.api.ITaskListener;
import com.tencent.mobileqq.winkpublish.model.params.ImageParams;
import com.tencent.mobileqq.winkpublish.model.params.WinkPublishParams;
import com.tencent.mobileqq.winkpublish.result.ImageResult;
import com.tencent.mobileqq.winkpublish.result.MediaUploadResult;
import feedcloud.FeedCloudAigcsvr$GetModelsRsp;
import feedcloud.FeedCloudAigcsvr$Model;
import feedcloud.FeedCloudAigcsvr$QueryRsp;
import feedcloud.FeedCloudAigcsvr$SubmitRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u0001%\u0018\u0000 +2\u00020\u0001:\u0001,B\u0007\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0019\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0014J\u0013\u0010\u001a\u001a\u00020\u0019H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\tR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR(\u0010$\u001a\u0016\u0012\u0004\u0012\u00020 \u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0!0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/wink/aigc/newtest/a;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "mediaInfo", "Lcom/tencent/mobileqq/winkpublish/model/params/WinkPublishParams;", "R1", "", "Lcom/tencent/mobileqq/wink/aigc/newtest/ModelItem;", "S1", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/winkpublish/result/ImageResult;", "W1", "(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "model", "", "url", "Lfeedcloud/FeedCloudAigcsvr$SubmitRsp;", "U1", "(Lcom/tencent/mobileqq/wink/aigc/newtest/ModelItem;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "Lfeedcloud/FeedCloudAigcsvr$QueryRsp;", "T1", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "onCleared", "", "Q1", "Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2;", "i", "Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2;", "uploadService", "", "", "Lkotlinx/coroutines/CancellableContinuation;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/Map;", "uploadTaskMap", "com/tencent/mobileqq/wink/aigc/newtest/a$f", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/aigc/newtest/a$f;", "uploadListener", "<init>", "()V", "D", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a extends ViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkPublishServiceProxy2 uploadService;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Long, CancellableContinuation<ImageResult>> uploadTaskMap = new LinkedHashMap();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final f uploadListener = new f();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/aigc/newtest/a$b", "Lcom/tencent/mobileqq/winkpublish/WinkPublishHelper2$Callback;", "Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2;", "service", "", "onServiceConnected", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements WinkPublishHelper2.Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Boolean> f317910a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f317911b;

        /* JADX WARN: Multi-variable type inference failed */
        b(CancellableContinuation<? super Boolean> cancellableContinuation, a aVar) {
            this.f317910a = cancellableContinuation;
            this.f317911b = aVar;
        }

        @Override // com.tencent.mobileqq.winkpublish.WinkPublishHelper2.Callback
        public void onServiceConnected(@NotNull WinkPublishServiceProxy2 service) {
            Intrinsics.checkNotNullParameter(service, "service");
            com.tencent.xaction.log.b.a("MaliViewModel", 1, "[ensureUploadService] service connected, is cont active: " + this.f317910a.isActive());
            if (this.f317910a.isActive()) {
                this.f317911b.uploadService = service;
                service.addTaskListener2(this.f317911b.uploadListener);
                CancellableContinuation<Boolean> cancellableContinuation = this.f317910a;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m476constructorimpl(Boolean.TRUE));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\f\u001a\u00020\u000b2\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\b\u001a\n \u0001*\u0004\u0018\u00010\u00070\u00072\u000e\u0010\n\u001a\n \u0001*\u0004\u0018\u00010\t0\tH\n\u00a2\u0006\u0004\b\f\u0010\r"}, d2 = {"Lcom/tencent/biz/richframework/network/request/BaseRequest;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "", "isSuccess", "", "retCode", "", "errMsg", "Lfeedcloud/FeedCloudAigcsvr$GetModelsRsp;", "rsp", "", "a", "(Lcom/tencent/biz/richframework/network/request/BaseRequest;ZJLjava/lang/String;Lfeedcloud/FeedCloudAigcsvr$GetModelsRsp;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    static final class c<T> implements VSDispatchObserver.OnVSRspCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<List<ModelItem>> f317912a;

        /* JADX WARN: Multi-variable type inference failed */
        c(CancellableContinuation<? super List<ModelItem>> cancellableContinuation) {
            this.f317912a = cancellableContinuation;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudAigcsvr$GetModelsRsp feedCloudAigcsvr$GetModelsRsp) {
            List emptyList;
            if (z16 && j3 == 0) {
                ArrayList arrayList = new ArrayList();
                List<FeedCloudAigcsvr$Model> list = feedCloudAigcsvr$GetModelsRsp.models.get();
                Intrinsics.checkNotNullExpressionValue(list, "rsp.models.get()");
                for (FeedCloudAigcsvr$Model feedCloudAigcsvr$Model : list) {
                    String str2 = feedCloudAigcsvr$Model.model.get();
                    Intrinsics.checkNotNullExpressionValue(str2, "it.model.get()");
                    String str3 = feedCloudAigcsvr$Model.custom_param.icon_url.get();
                    Intrinsics.checkNotNullExpressionValue(str3, "it.custom_param.icon_url.get()");
                    String str4 = feedCloudAigcsvr$Model.custom_param.description.get();
                    Intrinsics.checkNotNullExpressionValue(str4, "it.custom_param.description.get()");
                    arrayList.add(new ModelItem(str2, str3, str4, 0, 0, 24, null));
                }
                if (this.f317912a.isActive()) {
                    this.f317912a.resumeWith(Result.m476constructorimpl(arrayList));
                    return;
                }
                return;
            }
            com.tencent.xaction.log.b.a("MaliViewModel", 1, "[submitTask] error, retCode=" + j3 + ", errMsg=" + str);
            if (this.f317912a.isActive()) {
                CancellableContinuation<List<ModelItem>> cancellableContinuation = this.f317912a;
                Result.Companion companion = Result.INSTANCE;
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                cancellableContinuation.resumeWith(Result.m476constructorimpl(emptyList));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\f\u001a\u00020\u000b2\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\b\u001a\n \u0001*\u0004\u0018\u00010\u00070\u00072\u000e\u0010\n\u001a\n \u0001*\u0004\u0018\u00010\t0\tH\n\u00a2\u0006\u0004\b\f\u0010\r"}, d2 = {"Lcom/tencent/biz/richframework/network/request/BaseRequest;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "", "isSuccess", "", "retCode", "", "errMsg", "Lfeedcloud/FeedCloudAigcsvr$QueryRsp;", "rsp", "", "a", "(Lcom/tencent/biz/richframework/network/request/BaseRequest;ZJLjava/lang/String;Lfeedcloud/FeedCloudAigcsvr$QueryRsp;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    static final class d<T> implements VSDispatchObserver.OnVSRspCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<FeedCloudAigcsvr$QueryRsp> f317913a;

        /* JADX WARN: Multi-variable type inference failed */
        d(CancellableContinuation<? super FeedCloudAigcsvr$QueryRsp> cancellableContinuation) {
            this.f317913a = cancellableContinuation;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudAigcsvr$QueryRsp feedCloudAigcsvr$QueryRsp) {
            if (z16 && j3 == 0) {
                com.tencent.xaction.log.b.a("MaliViewModel", 1, "[queryTask] success, taskId=" + feedCloudAigcsvr$QueryRsp.task.task_id.get() + ", status=" + feedCloudAigcsvr$QueryRsp.task.task_status.get() + ", img=" + feedCloudAigcsvr$QueryRsp.task.image.url.get());
                if (this.f317913a.isActive()) {
                    this.f317913a.resumeWith(Result.m476constructorimpl(feedCloudAigcsvr$QueryRsp));
                    return;
                }
                return;
            }
            com.tencent.xaction.log.b.a("MaliViewModel", 1, "[queryTask] error, retCode=" + j3 + ", errMsg=" + str);
            if (this.f317913a.isActive()) {
                this.f317913a.resumeWith(Result.m476constructorimpl(null));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\f\u001a\u00020\u000b2\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\b\u001a\n \u0001*\u0004\u0018\u00010\u00070\u00072\u000e\u0010\n\u001a\n \u0001*\u0004\u0018\u00010\t0\tH\n\u00a2\u0006\u0004\b\f\u0010\r"}, d2 = {"Lcom/tencent/biz/richframework/network/request/BaseRequest;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "", "isSuccess", "", "retCode", "", "errMsg", "Lfeedcloud/FeedCloudAigcsvr$SubmitRsp;", "rsp", "", "a", "(Lcom/tencent/biz/richframework/network/request/BaseRequest;ZJLjava/lang/String;Lfeedcloud/FeedCloudAigcsvr$SubmitRsp;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    static final class e<T> implements VSDispatchObserver.OnVSRspCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<FeedCloudAigcsvr$SubmitRsp> f317914a;

        /* JADX WARN: Multi-variable type inference failed */
        e(CancellableContinuation<? super FeedCloudAigcsvr$SubmitRsp> cancellableContinuation) {
            this.f317914a = cancellableContinuation;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudAigcsvr$SubmitRsp feedCloudAigcsvr$SubmitRsp) {
            if (z16 && j3 == 0) {
                com.tencent.xaction.log.b.a("MaliViewModel", 1, "[submitTask] success, taskId=" + feedCloudAigcsvr$SubmitRsp.task_id.get());
                if (this.f317914a.isActive()) {
                    this.f317914a.resumeWith(Result.m476constructorimpl(feedCloudAigcsvr$SubmitRsp));
                    return;
                }
                return;
            }
            com.tencent.xaction.log.b.a("MaliViewModel", 1, "[submitTask] error, retCode=" + j3 + ", errMsg=" + str);
            if (this.f317914a.isActive()) {
                this.f317914a.resumeWith(Result.m476constructorimpl(null));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/aigc/newtest/a$f", "Lcom/tencent/mobileqq/winkpublish/api/ITaskListener$Stub;", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "task", "", "onTaskChange", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class f extends ITaskListener.Stub {
        f() {
        }

        @Override // com.tencent.mobileqq.winkpublish.api.ITaskListener
        public void onTaskChange(@NotNull TaskInfo task) {
            Object orNull;
            MediaUploadResult mediaUploadResult;
            ImageResult imageResult;
            Intrinsics.checkNotNullParameter(task, "task");
            String str = null;
            boolean z16 = false;
            if (task.isFinish()) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(task.getMediaInfos(), 0);
                MediaInfo mediaInfo = (MediaInfo) orNull;
                if (mediaInfo != null) {
                    mediaUploadResult = mediaInfo.getUploadResult();
                } else {
                    mediaUploadResult = null;
                }
                if (mediaUploadResult instanceof ImageResult) {
                    imageResult = (ImageResult) mediaUploadResult;
                } else {
                    imageResult = null;
                }
                CancellableContinuation cancellableContinuation = (CancellableContinuation) a.this.uploadTaskMap.get(Long.valueOf(task.getTaskId()));
                if (cancellableContinuation != null && cancellableContinuation.isActive()) {
                    z16 = true;
                }
                if (z16) {
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(imageResult));
                }
                a.this.uploadTaskMap.remove(Long.valueOf(task.getTaskId()));
                long taskId = task.getTaskId();
                if (imageResult != null) {
                    str = imageResult.getOriginUrl();
                }
                com.tencent.xaction.log.b.a("MaliViewModel", 1, "[onTaskChange] finish, taskId=" + taskId + ", url=" + str);
                return;
            }
            if (task.isCancelled()) {
                CancellableContinuation cancellableContinuation2 = (CancellableContinuation) a.this.uploadTaskMap.get(Long.valueOf(task.getTaskId()));
                if (cancellableContinuation2 != null && cancellableContinuation2.isActive()) {
                    z16 = true;
                }
                if (z16) {
                    cancellableContinuation2.resumeWith(Result.m476constructorimpl(null));
                }
                a.this.uploadTaskMap.remove(Long.valueOf(task.getTaskId()));
                com.tencent.xaction.log.b.a("MaliViewModel", 1, "[onTaskChange] canceled, taskId=" + task.getTaskId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkPublishParams R1(LocalMediaInfo mediaInfo) {
        List listOf;
        ImageParams from = ImageParams.INSTANCE.from(mediaInfo, null);
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        String traceId = WinkContext.INSTANCE.d().getTraceId();
        listOf = CollectionsKt__CollectionsJVMKt.listOf(from);
        return new WinkPublishParams(3, uuid, traceId, false, 23, listOf, null, null, null, null, 968, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0053  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object Q1(@NotNull Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object result;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        if (this.uploadService != null) {
            WinkPublishServiceProxy2 winkPublishServiceProxy2 = this.uploadService;
            boolean z16 = false;
            if (winkPublishServiceProxy2 != null && winkPublishServiceProxy2.isBinderAlive()) {
                z16 = true;
            }
            if (z16) {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(Boxing.boxBoolean(true)));
                result = cancellableContinuationImpl.getResult();
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (result == coroutine_suspended) {
                    DebugProbes.probeCoroutineSuspended(continuation);
                }
                return result;
            }
        }
        com.tencent.xaction.log.b.a("MaliViewModel", 1, "[ensureUploadService] no service exists");
        this.uploadService = null;
        WinkPublishHelper2.INSTANCE.bindService(3, new b(cancellableContinuationImpl, this));
        result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
        }
        return result;
    }

    @Nullable
    public final Object S1(@NotNull Continuation<? super List<ModelItem>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        VSNetworkHelper.getInstance().sendRequest(new WinkMaliGetModelsRequest(), new c(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Nullable
    public final Object T1(@NotNull String str, @NotNull Continuation<? super FeedCloudAigcsvr$QueryRsp> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        VSNetworkHelper.getInstance().sendRequest(new WinkMaliQueryRequest(str), new d(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Nullable
    public final Object U1(@NotNull ModelItem modelItem, @NotNull String str, @NotNull Continuation<? super FeedCloudAigcsvr$SubmitRsp> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        VSNetworkHelper.getInstance().sendRequest(new WinkMaliSubmitRequest(modelItem.getModelName(), str, modelItem.getWantWidth(), modelItem.getWantHeight()), new e(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object W1(@Nullable LocalMediaInfo localMediaInfo, @NotNull Continuation<? super ImageResult> continuation) {
        Continuation intercepted;
        Object result;
        Object coroutine_suspended;
        boolean z16;
        TaskInfo addTask;
        boolean isBlank;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        if (localMediaInfo != null) {
            String str = localMediaInfo.path;
            if (str != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(str);
                if (!isBlank) {
                    z16 = false;
                    if (!z16) {
                        if (this.uploadService != null) {
                            WinkPublishParams R1 = R1(localMediaInfo);
                            WinkPublishServiceProxy2 winkPublishServiceProxy2 = this.uploadService;
                            if (winkPublishServiceProxy2 != null && (addTask = winkPublishServiceProxy2.addTask(R1)) != null) {
                                this.uploadTaskMap.put(Boxing.boxLong(addTask.getTaskId()), cancellableContinuationImpl);
                            }
                        } else {
                            com.tencent.xaction.log.b.a("MaliViewModel", 1, "[uploadPic] invalid service");
                            if (cancellableContinuationImpl.isActive()) {
                                cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(null));
                            }
                        }
                        result = cancellableContinuationImpl.getResult();
                        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (result == coroutine_suspended) {
                            DebugProbes.probeCoroutineSuspended(continuation);
                        }
                        return result;
                    }
                }
            }
            z16 = true;
            if (!z16) {
            }
        }
        com.tencent.xaction.log.b.a("MaliViewModel", 1, "[uploadPic] invalid mediaInfo");
        if (cancellableContinuationImpl.isActive()) {
            cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(null));
        }
        result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        WinkPublishServiceProxy2 winkPublishServiceProxy2 = this.uploadService;
        if (winkPublishServiceProxy2 != null) {
            winkPublishServiceProxy2.removeTaskListener(this.uploadListener);
        }
        Iterator<T> it = this.uploadTaskMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            WinkPublishServiceProxy2 winkPublishServiceProxy22 = this.uploadService;
            if (winkPublishServiceProxy22 != null) {
                winkPublishServiceProxy22.cancelTaskWithId(((Number) entry.getKey()).longValue());
            }
            CancellableContinuation.DefaultImpls.cancel$default((CancellableContinuation) entry.getValue(), null, 1, null);
        }
        this.uploadTaskMap.clear();
    }
}
