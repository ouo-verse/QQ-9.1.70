package com.tencent.mobileqq.winkpublish.outbox.task.feature.group;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.winkpublish.outbox.task.TaskContext;
import com.tencent.mobileqq.winkpublish.outbox.task.UploadMediaInfo;
import com.tencent.mobileqq.winkpublish.outbox.task.feature.base.FeatureGroup;
import com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.PublishFeedFeat;
import com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.UploadVideoCoverFeat;
import com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.i;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001b\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000eR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/group/UWEVideoCoverAsyncFeatGroup;", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/FeatureGroup;", "", "e", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/FeatureGroup$RunMode;", "f", "Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;", "taskContext", "", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/a;", "d", "", "a", "(Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;", "Lkotlinx/coroutines/channels/Channel;", "", "Lkotlinx/coroutines/channels/Channel;", WadlProxyConsts.CHANNEL, "", "j", "()Z", "hasChangeCover", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/b;", "next", "<init>", "(Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/b;)V", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class UWEVideoCoverAsyncFeatGroup extends FeatureGroup {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TaskContext taskContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Channel<Integer> channel;

    public UWEVideoCoverAsyncFeatGroup() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final boolean j() {
        Object orNull;
        Object orNull2;
        TaskContext taskContext = this.taskContext;
        if (taskContext == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskContext");
            taskContext = null;
        }
        orNull = CollectionsKt___CollectionsKt.getOrNull(taskContext.x(), 0);
        UploadMediaInfo uploadMediaInfo = (UploadMediaInfo) orNull;
        if (!(uploadMediaInfo != null ? uploadMediaInfo.getHasChangedCover() : false)) {
            TaskContext taskContext2 = this.taskContext;
            if (taskContext2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("taskContext");
                taskContext2 = null;
            }
            orNull2 = CollectionsKt___CollectionsKt.getOrNull(taskContext2.x(), 0);
            UploadMediaInfo uploadMediaInfo2 = (UploadMediaInfo) orNull2;
            if ((uploadMediaInfo2 != null ? uploadMediaInfo2.getCoverUploadResponse() : null) != null) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.base.FeatureGroup, com.tencent.mobileqq.winkpublish.outbox.task.feature.base.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(TaskContext taskContext, Continuation<? super Unit> continuation) {
        UWEVideoCoverAsyncFeatGroup$run$1 uWEVideoCoverAsyncFeatGroup$run$1;
        Object coroutine_suspended;
        int i3;
        UWEVideoCoverAsyncFeatGroup uWEVideoCoverAsyncFeatGroup;
        if (continuation instanceof UWEVideoCoverAsyncFeatGroup$run$1) {
            uWEVideoCoverAsyncFeatGroup$run$1 = (UWEVideoCoverAsyncFeatGroup$run$1) continuation;
            int i16 = uWEVideoCoverAsyncFeatGroup$run$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                uWEVideoCoverAsyncFeatGroup$run$1.label = i16 - Integer.MIN_VALUE;
                Object obj = uWEVideoCoverAsyncFeatGroup$run$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = uWEVideoCoverAsyncFeatGroup$run$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    uWEVideoCoverAsyncFeatGroup$run$1.L$0 = this;
                    uWEVideoCoverAsyncFeatGroup$run$1.L$1 = taskContext;
                    uWEVideoCoverAsyncFeatGroup$run$1.label = 1;
                    if (super.a(taskContext, uWEVideoCoverAsyncFeatGroup$run$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    uWEVideoCoverAsyncFeatGroup = this;
                } else if (i3 == 1) {
                    taskContext = (TaskContext) uWEVideoCoverAsyncFeatGroup$run$1.L$1;
                    uWEVideoCoverAsyncFeatGroup = (UWEVideoCoverAsyncFeatGroup) uWEVideoCoverAsyncFeatGroup$run$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                uWEVideoCoverAsyncFeatGroup.taskContext = taskContext;
                QLog.d(uWEVideoCoverAsyncFeatGroup.e(), 1, "[run] hasChangeCover: " + uWEVideoCoverAsyncFeatGroup.j());
                if (uWEVideoCoverAsyncFeatGroup.j()) {
                    taskContext.P(1);
                    uWEVideoCoverAsyncFeatGroup.c(new UploadVideoCoverFeat(0, new com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.b(new PublishFeedFeat())));
                }
                return Unit.INSTANCE;
            }
        }
        uWEVideoCoverAsyncFeatGroup$run$1 = new UWEVideoCoverAsyncFeatGroup$run$1(this, continuation);
        Object obj2 = uWEVideoCoverAsyncFeatGroup$run$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = uWEVideoCoverAsyncFeatGroup$run$1.label;
        if (i3 != 0) {
        }
        uWEVideoCoverAsyncFeatGroup.taskContext = taskContext;
        QLog.d(uWEVideoCoverAsyncFeatGroup.e(), 1, "[run] hasChangeCover: " + uWEVideoCoverAsyncFeatGroup.j());
        if (uWEVideoCoverAsyncFeatGroup.j()) {
        }
        return Unit.INSTANCE;
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.base.FeatureGroup
    public List<com.tencent.mobileqq.winkpublish.outbox.task.feature.base.a> d(TaskContext taskContext) {
        List<com.tencent.mobileqq.winkpublish.outbox.task.feature.base.a> listOf;
        Intrinsics.checkNotNullParameter(taskContext, "taskContext");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.mobileqq.winkpublish.outbox.task.feature.base.a[]{new i(this.channel), new UploadVideoCoverFeat(0, this.channel)});
        return listOf;
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.base.FeatureGroup
    public String e() {
        return "WinkPublish-upload2-UWEVideoCoverAsyncFeatGroup";
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.base.FeatureGroup
    public FeatureGroup.RunMode f() {
        return FeatureGroup.RunMode.ASYNC_RUN_MODE;
    }

    public UWEVideoCoverAsyncFeatGroup(com.tencent.mobileqq.winkpublish.outbox.task.feature.base.b bVar) {
        super(bVar);
        this.channel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
    }

    public /* synthetic */ UWEVideoCoverAsyncFeatGroup(com.tencent.mobileqq.winkpublish.outbox.task.feature.base.b bVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : bVar);
    }
}
