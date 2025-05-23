package com.tencent.mobileqq.winkpublish.outbox.task.feature.group;

import com.tencent.mobileqq.winkpublish.outbox.task.TaskContext;
import com.tencent.mobileqq.winkpublish.outbox.task.UploadMediaInfo;
import com.tencent.mobileqq.winkpublish.outbox.task.feature.base.FeatureGroup;
import com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.PublishFeedFeat;
import com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.UploadVideoCoverFeat;
import com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.j;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001\fB\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001b\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u000f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/group/EAUVideoCoverAsyncFeatGroup;", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/FeatureGroup;", "", "e", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/FeatureGroup$RunMode;", "f", "Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;", "taskContext", "", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/a;", "d", "", "a", "(Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;", "", "j", "()Z", "hasChangeCover", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/b;", "next", "<init>", "(Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/b;)V", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class EAUVideoCoverAsyncFeatGroup extends FeatureGroup {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TaskContext taskContext;

    public EAUVideoCoverAsyncFeatGroup() {
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
        EAUVideoCoverAsyncFeatGroup$run$1 eAUVideoCoverAsyncFeatGroup$run$1;
        Object coroutine_suspended;
        int i3;
        EAUVideoCoverAsyncFeatGroup eAUVideoCoverAsyncFeatGroup;
        if (continuation instanceof EAUVideoCoverAsyncFeatGroup$run$1) {
            eAUVideoCoverAsyncFeatGroup$run$1 = (EAUVideoCoverAsyncFeatGroup$run$1) continuation;
            int i16 = eAUVideoCoverAsyncFeatGroup$run$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eAUVideoCoverAsyncFeatGroup$run$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eAUVideoCoverAsyncFeatGroup$run$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eAUVideoCoverAsyncFeatGroup$run$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    eAUVideoCoverAsyncFeatGroup$run$1.L$0 = this;
                    eAUVideoCoverAsyncFeatGroup$run$1.L$1 = taskContext;
                    eAUVideoCoverAsyncFeatGroup$run$1.label = 1;
                    if (super.a(taskContext, eAUVideoCoverAsyncFeatGroup$run$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    eAUVideoCoverAsyncFeatGroup = this;
                } else if (i3 == 1) {
                    taskContext = (TaskContext) eAUVideoCoverAsyncFeatGroup$run$1.L$1;
                    eAUVideoCoverAsyncFeatGroup = (EAUVideoCoverAsyncFeatGroup) eAUVideoCoverAsyncFeatGroup$run$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eAUVideoCoverAsyncFeatGroup.taskContext = taskContext;
                QLog.d(eAUVideoCoverAsyncFeatGroup.e(), 1, "[run] hasChangeCover: " + eAUVideoCoverAsyncFeatGroup.j());
                if (eAUVideoCoverAsyncFeatGroup.j()) {
                    taskContext.P(1);
                    eAUVideoCoverAsyncFeatGroup.c(new UploadVideoCoverFeat(0, new com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.b(new PublishFeedFeat())));
                }
                return Unit.INSTANCE;
            }
        }
        eAUVideoCoverAsyncFeatGroup$run$1 = new EAUVideoCoverAsyncFeatGroup$run$1(this, continuation);
        Object obj2 = eAUVideoCoverAsyncFeatGroup$run$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eAUVideoCoverAsyncFeatGroup$run$1.label;
        if (i3 != 0) {
        }
        eAUVideoCoverAsyncFeatGroup.taskContext = taskContext;
        QLog.d(eAUVideoCoverAsyncFeatGroup.e(), 1, "[run] hasChangeCover: " + eAUVideoCoverAsyncFeatGroup.j());
        if (eAUVideoCoverAsyncFeatGroup.j()) {
        }
        return Unit.INSTANCE;
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.base.FeatureGroup
    public List<com.tencent.mobileqq.winkpublish.outbox.task.feature.base.a> d(TaskContext taskContext) {
        List<com.tencent.mobileqq.winkpublish.outbox.task.feature.base.a> listOf;
        Intrinsics.checkNotNullParameter(taskContext, "taskContext");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.mobileqq.winkpublish.outbox.task.feature.base.b[]{new j(), new d(null, 1, 0 == true ? 1 : 0)});
        return listOf;
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.base.FeatureGroup
    public String e() {
        return "WinkPublish-upload2-EAUVideoCoverAsyncFeatGroup";
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.base.FeatureGroup
    public FeatureGroup.RunMode f() {
        return FeatureGroup.RunMode.SYNC_RUN_MODE;
    }

    public EAUVideoCoverAsyncFeatGroup(com.tencent.mobileqq.winkpublish.outbox.task.feature.base.b bVar) {
        super(bVar);
    }

    public /* synthetic */ EAUVideoCoverAsyncFeatGroup(com.tencent.mobileqq.winkpublish.outbox.task.feature.base.b bVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : bVar);
    }
}
