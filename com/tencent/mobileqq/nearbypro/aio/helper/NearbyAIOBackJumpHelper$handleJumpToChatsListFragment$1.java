package com.tencent.mobileqq.nearbypro.aio.helper;

import android.os.Bundle;
import com.tencent.aio.runtime.message.ExternalCommIntent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.nearbypro.aio.helper.NearbyAIOBackJumpHelper$handleJumpToChatsListFragment$1", f = "NearbyAIOBackJumpHelper.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes15.dex */
public final class NearbyAIOBackJumpHelper$handleJumpToChatsListFragment$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ NearbyAIOBackJumpHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearbyAIOBackJumpHelper$handleJumpToChatsListFragment$1(NearbyAIOBackJumpHelper nearbyAIOBackJumpHelper, Continuation<? super NearbyAIOBackJumpHelper$handleJumpToChatsListFragment$1> continuation) {
        super(2, continuation);
        this.this$0 = nearbyAIOBackJumpHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new NearbyAIOBackJumpHelper$handleJumpToChatsListFragment$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        com.tencent.aio.api.runtime.a aVar;
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
            this.label = 1;
            if (DelayKt.delay(500L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        aVar = this.this$0.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        aVar.e().h(new ExternalCommIntent("close_aio", new Bundle()));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((NearbyAIOBackJumpHelper$handleJumpToChatsListFragment$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
