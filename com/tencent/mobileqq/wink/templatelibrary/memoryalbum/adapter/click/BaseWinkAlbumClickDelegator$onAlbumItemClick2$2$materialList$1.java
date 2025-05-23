package com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import java.util.List;
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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click.BaseWinkAlbumClickDelegator$onAlbumItemClick2$2$materialList$1", f = "BaseWinkAlbumClickDelegator.kt", i = {}, l = {140}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
final class BaseWinkAlbumClickDelegator$onAlbumItemClick2$2$materialList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends MetaMaterial>>, Object> {
    final /* synthetic */ T $data;
    int label;
    final /* synthetic */ BaseWinkAlbumClickDelegator<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseWinkAlbumClickDelegator$onAlbumItemClick2$2$materialList$1(BaseWinkAlbumClickDelegator<T> baseWinkAlbumClickDelegator, T t16, Continuation<? super BaseWinkAlbumClickDelegator$onAlbumItemClick2$2$materialList$1> continuation) {
        super(2, continuation);
        this.this$0 = baseWinkAlbumClickDelegator;
        this.$data = t16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new BaseWinkAlbumClickDelegator$onAlbumItemClick2$2$materialList$1(this.this$0, this.$data, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends MetaMaterial>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<MetaMaterial>>) continuation);
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
            T t16 = this.$data;
            this.label = 1;
            obj = baseWinkAlbumClickDelegator.l(t16, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<MetaMaterial>> continuation) {
        return ((BaseWinkAlbumClickDelegator$onAlbumItemClick2$2$materialList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
