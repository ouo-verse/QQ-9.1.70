package com.tencent.mobileqq.activity.qcircle.bubble;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.FrameFragment;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleCounterStyle$StyleBubble;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.activity.qcircle.bubble.QCircleTabRedPointBubbleShowController$showBubbleWithTimeout$1", f = "QCircleTabRedPointBubbleShowController.kt", i = {}, l = {196}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes10.dex */
public final class QCircleTabRedPointBubbleShowController$showBubbleWithTimeout$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ n $callback;
    final /* synthetic */ List<Drawable> $downloadedDrawableList;
    final /* synthetic */ Job $fetchDrawableJob;
    final /* synthetic */ FrameFragment $frameFragment;
    final /* synthetic */ Ref.BooleanRef $isShowedBubble;
    final /* synthetic */ long $operateId;
    final /* synthetic */ QQCircleCounterStyle$StyleBubble $styleBubble;
    final /* synthetic */ long $timeoutMills;
    final /* synthetic */ int $urlSize;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QCircleTabRedPointBubbleShowController$showBubbleWithTimeout$1(long j3, Job job, Ref.BooleanRef booleanRef, long j16, FrameFragment frameFragment, QQCircleCounterStyle$StyleBubble qQCircleCounterStyle$StyleBubble, List<Drawable> list, int i3, n nVar, Continuation<? super QCircleTabRedPointBubbleShowController$showBubbleWithTimeout$1> continuation) {
        super(2, continuation);
        this.$timeoutMills = j3;
        this.$fetchDrawableJob = job;
        this.$isShowedBubble = booleanRef;
        this.$operateId = j16;
        this.$frameFragment = frameFragment;
        this.$styleBubble = qQCircleCounterStyle$StyleBubble;
        this.$downloadedDrawableList = list;
        this.$urlSize = i3;
        this.$callback = nVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new QCircleTabRedPointBubbleShowController$showBubbleWithTimeout$1(this.$timeoutMills, this.$fetchDrawableJob, this.$isShowedBubble, this.$operateId, this.$frameFragment, this.$styleBubble, this.$downloadedDrawableList, this.$urlSize, this.$callback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        List emptyList;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            long j3 = this.$timeoutMills;
            this.label = 1;
            if (DelayKt.delay(j3, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        Job.DefaultImpls.cancel$default(this.$fetchDrawableJob, (CancellationException) null, 1, (Object) null);
        if (!this.$isShowedBubble.element) {
            QCircleTabRedPointBubbleShowController qCircleTabRedPointBubbleShowController = QCircleTabRedPointBubbleShowController.f184502a;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            qCircleTabRedPointBubbleShowController.w(this.$operateId, this.$frameFragment, this.$styleBubble, this.$downloadedDrawableList, this.$urlSize, emptyList, this.$callback);
            this.$isShowedBubble.element = true;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((QCircleTabRedPointBubbleShowController$showBubbleWithTimeout$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
