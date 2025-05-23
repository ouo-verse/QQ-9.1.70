package com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "", "", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click.BaseWinkAlbumClickDelegator$onAlbumItemClick$2$costMap$1", f = "BaseWinkAlbumClickDelegator.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
final class BaseWinkAlbumClickDelegator$onAlbumItemClick$2$costMap$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<String, ? extends Long>>, Object> {
    final /* synthetic */ MetaMaterial $material;
    int label;
    final /* synthetic */ BaseWinkAlbumClickDelegator<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseWinkAlbumClickDelegator$onAlbumItemClick$2$costMap$1(BaseWinkAlbumClickDelegator<T> baseWinkAlbumClickDelegator, MetaMaterial metaMaterial, Continuation<? super BaseWinkAlbumClickDelegator$onAlbumItemClick$2$costMap$1> continuation) {
        super(2, continuation);
        this.this$0 = baseWinkAlbumClickDelegator;
        this.$material = metaMaterial;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new BaseWinkAlbumClickDelegator$onAlbumItemClick$2$costMap$1(this.this$0, this.$material, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Map<String, ? extends Long>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Map<String, Long>>) continuation);
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
            BaseWinkAlbumClickDelegator<T> baseWinkAlbumClickDelegator = this.this$0;
            MetaMaterial metaMaterial = this.$material;
            this.label = 1;
            obj = baseWinkAlbumClickDelegator.e(metaMaterial, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Map<String, Long>> continuation) {
        return ((BaseWinkAlbumClickDelegator$onAlbumItemClick$2$costMap$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
