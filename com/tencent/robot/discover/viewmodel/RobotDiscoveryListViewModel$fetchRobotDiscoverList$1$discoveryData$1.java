package com.tencent.robot.discover.viewmodel;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Lk34/a;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.robot.discover.viewmodel.RobotDiscoveryListViewModel$fetchRobotDiscoverList$1$discoveryData$1", f = "RobotDiscoveryListViewModel.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
final class RobotDiscoveryListViewModel$fetchRobotDiscoverList$1$discoveryData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends k34.a>>, Object> {
    final /* synthetic */ Ref.LongRef $groupId;
    final /* synthetic */ int $sceneId;
    int label;
    final /* synthetic */ RobotDiscoveryListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotDiscoveryListViewModel$fetchRobotDiscoverList$1$discoveryData$1(RobotDiscoveryListViewModel robotDiscoveryListViewModel, Ref.LongRef longRef, int i3, Continuation<? super RobotDiscoveryListViewModel$fetchRobotDiscoverList$1$discoveryData$1> continuation) {
        super(2, continuation);
        this.this$0 = robotDiscoveryListViewModel;
        this.$groupId = longRef;
        this.$sceneId = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RobotDiscoveryListViewModel$fetchRobotDiscoverList$1$discoveryData$1(this.this$0, this.$groupId, this.$sceneId, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
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
            RobotDiscoveryListViewModel robotDiscoveryListViewModel = this.this$0;
            long j3 = this.$groupId.element;
            int i16 = this.$sceneId;
            this.label = 1;
            obj = robotDiscoveryListViewModel.Q1(j3, i16, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<? extends k34.a>> continuation) {
        return ((RobotDiscoveryListViewModel$fetchRobotDiscoverList$1$discoveryData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
