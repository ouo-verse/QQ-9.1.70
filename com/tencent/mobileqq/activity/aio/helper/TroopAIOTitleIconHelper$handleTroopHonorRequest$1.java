package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.activity.aio.helper.TroopAIOTitleIconHelper$handleTroopHonorRequest$1", f = "TroopAIOTitleIconHelper.kt", i = {}, l = {114}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes10.dex */
public final class TroopAIOTitleIconHelper$handleTroopHonorRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $needAnim;
    int label;
    final /* synthetic */ TroopAIOTitleIconHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.activity.aio.helper.TroopAIOTitleIconHelper$handleTroopHonorRequest$1$1", f = "TroopAIOTitleIconHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.activity.aio.helper.TroopAIOTitleIconHelper$handleTroopHonorRequest$1$1, reason: invalid class name */
    /* loaded from: classes10.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Pair<com.tencent.mobileqq.aio.title.ae, com.tencent.mobileqq.aio.title.ae> $mutualMarkDataPair;
        final /* synthetic */ boolean $needAnim;
        int label;
        final /* synthetic */ TroopAIOTitleIconHelper this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TroopAIOTitleIconHelper troopAIOTitleIconHelper, Pair<com.tencent.mobileqq.aio.title.ae, com.tencent.mobileqq.aio.title.ae> pair, boolean z16, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = troopAIOTitleIconHelper;
            this.$mutualMarkDataPair = pair;
            this.$needAnim = z16;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$mutualMarkDataPair, this.$needAnim, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            com.tencent.aio.api.runtime.a aVar;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                aVar = this.this$0.mAIOContext;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                    aVar = null;
                }
                aVar.e().h(new AIOTitleEvent.MutualMarkResponseEvent(this.$mutualMarkDataPair.getFirst(), this.$mutualMarkDataPair.getSecond(), this.$needAnim));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopAIOTitleIconHelper$handleTroopHonorRequest$1(TroopAIOTitleIconHelper troopAIOTitleIconHelper, boolean z16, Continuation<? super TroopAIOTitleIconHelper$handleTroopHonorRequest$1> continuation) {
        super(2, continuation);
        this.this$0 = troopAIOTitleIconHelper;
        this.$needAnim = z16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TroopAIOTitleIconHelper$handleTroopHonorRequest$1(this.this$0, this.$needAnim, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Pair i3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 != 0) {
            if (i16 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            i3 = this.this$0.i();
            i.e eVar = i.e.f261783e;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, i3, this.$needAnim, null);
            this.label = 1;
            if (CorountineFunKt.i(eVar, null, null, anonymousClass1, this, 6, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TroopAIOTitleIconHelper$handleTroopHonorRequest$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
