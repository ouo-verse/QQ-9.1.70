package com.tencent.mobileqq.guild.feed.feedsection.part;

import com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.k;
import com.tencent.mobileqq.guild.feed.squarehead.ownertask.event.OnOwnerTaskCardShowEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/squarehead/ownertask/event/OnOwnerTaskCardShowEvent;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.feedsection.part.FeedSectionUnitedBridgePart$onDependOnsReady$14", f = "FeedSectionUnitedBridgePart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class FeedSectionUnitedBridgePart$onDependOnsReady$14 extends SuspendLambda implements Function2<OnOwnerTaskCardShowEvent, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FeedSectionUnitedBridgePart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedSectionUnitedBridgePart$onDependOnsReady$14(FeedSectionUnitedBridgePart feedSectionUnitedBridgePart, Continuation<? super FeedSectionUnitedBridgePart$onDependOnsReady$14> continuation) {
        super(2, continuation);
        this.this$0 = feedSectionUnitedBridgePart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FeedSectionUnitedBridgePart$onDependOnsReady$14 feedSectionUnitedBridgePart$onDependOnsReady$14 = new FeedSectionUnitedBridgePart$onDependOnsReady$14(this.this$0, continuation);
        feedSectionUnitedBridgePart$onDependOnsReady$14.L$0 = obj;
        return feedSectionUnitedBridgePart$onDependOnsReady$14;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull OnOwnerTaskCardShowEvent onOwnerTaskCardShowEvent, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedSectionUnitedBridgePart$onDependOnsReady$14) create(onOwnerTaskCardShowEvent, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        k kVar;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            OnOwnerTaskCardShowEvent onOwnerTaskCardShowEvent = (OnOwnerTaskCardShowEvent) this.L$0;
            boolean z16 = true;
            QLog.i(this.this$0.getTAG(), 1, "OnOwnerTaskCardShowEvent contextHashCode:" + onOwnerTaskCardShowEvent.getContextHashCode() + " isShow:" + onOwnerTaskCardShowEvent.isShow());
            FeedSectionUnitedBridgePart feedSectionUnitedBridgePart = this.this$0;
            kVar = feedSectionUnitedBridgePart.vmApi;
            List<ij1.g> list = null;
            if (kVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vmApi");
                kVar = null;
            }
            UIStateData<List<ij1.g>> value = kVar.j().getValue();
            if (value != null) {
                list = value.getData();
            }
            List<ij1.g> list2 = list;
            if (list2 != null && !list2.isEmpty()) {
                z16 = false;
            }
            feedSectionUnitedBridgePart.X9(z16);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
