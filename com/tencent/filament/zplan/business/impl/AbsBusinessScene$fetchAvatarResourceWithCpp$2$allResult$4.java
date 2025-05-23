package com.tencent.filament.zplan.business.impl;

import cl0.c;
import com.tencent.filament.zplanservice.download.ZPlanAvatarInterfaceResult;
import com.tencent.filament.zplanservice.download.ZPlanAvatarService;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarInterfaceResult;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.business.impl.AbsBusinessScene$fetchAvatarResourceWithCpp$2$allResult$4", f = "AbsBusinessScene.kt", i = {}, l = {403, 405}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class AbsBusinessScene$fetchAvatarResourceWithCpp$2$allResult$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ZPlanAvatarInterfaceResult>, Object> {
    final /* synthetic */ List $checkIndirectLightResult;
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ AbsBusinessScene$fetchAvatarResourceWithCpp$2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsBusinessScene$fetchAvatarResourceWithCpp$2$allResult$4(AbsBusinessScene$fetchAvatarResourceWithCpp$2 absBusinessScene$fetchAvatarResourceWithCpp$2, List list, Continuation continuation) {
        super(2, continuation);
        this.this$0 = absBusinessScene$fetchAvatarResourceWithCpp$2;
        this.$checkIndirectLightResult = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new AbsBusinessScene$fetchAvatarResourceWithCpp$2$allResult$4(this.this$0, this.$checkIndirectLightResult, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ZPlanAvatarInterfaceResult> continuation) {
        return ((AbsBusinessScene$fetchAvatarResourceWithCpp$2$allResult$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        c cVar;
        Object obj2;
        List list;
        int i3;
        List list2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 == 2) {
                    i3 = this.I$0;
                    list = (List) this.L$1;
                    obj2 = this.L$0;
                    ResultKt.throwOnFailure(obj);
                    list2 = ArraysKt___ArraysKt.toList((Object[]) obj);
                    list.addAll(i3, list2);
                    return obj2;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            AbsBusinessScene$fetchAvatarResourceWithCpp$2 absBusinessScene$fetchAvatarResourceWithCpp$2 = this.this$0;
            AbsBusinessScene absBusinessScene = absBusinessScene$fetchAvatarResourceWithCpp$2.this$0;
            ZPlanAvatarService zPlanAvatarService = absBusinessScene$fetchAvatarResourceWithCpp$2.$avatarService;
            this.label = 1;
            obj = absBusinessScene.fetchIndirectLightWithCpp(zPlanAvatarService, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        ZPlanAvatarInterfaceResult zPlanAvatarInterfaceResult = (ZPlanAvatarInterfaceResult) obj;
        cVar = this.this$0.this$0.cppDownloadConfig;
        if (cVar.getEnableCheck()) {
            List list3 = this.$checkIndirectLightResult;
            ZPlanAvatarService zPlanAvatarService2 = this.this$0.$avatarService;
            this.L$0 = obj;
            this.L$1 = list3;
            this.I$0 = 0;
            this.label = 2;
            Object r16 = zPlanAvatarService2.r(zPlanAvatarInterfaceResult, this);
            if (r16 == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj2 = obj;
            obj = r16;
            list = list3;
            i3 = 0;
            list2 = ArraysKt___ArraysKt.toList((Object[]) obj);
            list.addAll(i3, list2);
            return obj2;
        }
        return obj;
    }
}
