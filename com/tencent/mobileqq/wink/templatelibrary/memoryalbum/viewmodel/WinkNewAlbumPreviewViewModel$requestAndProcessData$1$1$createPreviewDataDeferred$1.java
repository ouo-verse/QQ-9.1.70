package com.tencent.mobileqq.wink.templatelibrary.memoryalbum.viewmodel;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.viewmodel.WinkNewAlbumPreviewViewModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/viewmodel/WinkNewAlbumPreviewViewModel$b;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.templatelibrary.memoryalbum.viewmodel.WinkNewAlbumPreviewViewModel$requestAndProcessData$1$1$createPreviewDataDeferred$1", f = "WinkNewAlbumPreviewViewModel.kt", i = {}, l = {112}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
final class WinkNewAlbumPreviewViewModel$requestAndProcessData$1$1$createPreviewDataDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super WinkNewAlbumPreviewViewModel.b>, Object> {
    final /* synthetic */ Deferred<Pair<MetaMaterial, Long>> $mateDeferred;
    Object L$0;
    int label;
    final /* synthetic */ WinkNewAlbumPreviewViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkNewAlbumPreviewViewModel$requestAndProcessData$1$1$createPreviewDataDeferred$1(WinkNewAlbumPreviewViewModel winkNewAlbumPreviewViewModel, Deferred<Pair<MetaMaterial, Long>> deferred, Continuation<? super WinkNewAlbumPreviewViewModel$requestAndProcessData$1$1$createPreviewDataDeferred$1> continuation) {
        super(2, continuation);
        this.this$0 = winkNewAlbumPreviewViewModel;
        this.$mateDeferred = deferred;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkNewAlbumPreviewViewModel$requestAndProcessData$1$1$createPreviewDataDeferred$1(this.this$0, this.$mateDeferred, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        WinkNewAlbumPreviewViewModel winkNewAlbumPreviewViewModel;
        WinkNewAlbumPreviewViewModel.b N1;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 != 0) {
                if (i3 == 1) {
                    winkNewAlbumPreviewViewModel = (WinkNewAlbumPreviewViewModel) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                w53.b.f(this.this$0.getTAG(), "createPreviewDataDeferred begin");
                WinkNewAlbumPreviewViewModel winkNewAlbumPreviewViewModel2 = this.this$0;
                Deferred<Pair<MetaMaterial, Long>> deferred = this.$mateDeferred;
                this.L$0 = winkNewAlbumPreviewViewModel2;
                this.label = 1;
                Object await = deferred.await(this);
                if (await == coroutine_suspended) {
                    return coroutine_suspended;
                }
                winkNewAlbumPreviewViewModel = winkNewAlbumPreviewViewModel2;
                obj = await;
            }
            N1 = winkNewAlbumPreviewViewModel.N1((Pair) obj);
            return N1;
        } catch (Exception e16) {
            throw e16;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super WinkNewAlbumPreviewViewModel.b> continuation) {
        return ((WinkNewAlbumPreviewViewModel$requestAndProcessData$1$1$createPreviewDataDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
