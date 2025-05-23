package com.tencent.mobileqq.wink.newalbum.processor;

import com.tencent.mobileqq.wink.newalbum.collector.WinkNewMemoryAlbumResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.newalbum.processor.WinkNewAlbumProcessorManager$onCollectResult$1", f = "WinkNewAlbumProcessorManager.kt", i = {}, l = {140}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkNewAlbumProcessorManager$onCollectResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WinkNewMemoryAlbumResult $result;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkNewAlbumProcessorManager$onCollectResult$1(WinkNewMemoryAlbumResult winkNewMemoryAlbumResult, Continuation<? super WinkNewAlbumProcessorManager$onCollectResult$1> continuation) {
        super(2, continuation);
        this.$result = winkNewMemoryAlbumResult;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkNewAlbumProcessorManager$onCollectResult$1(this.$result, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        com.tencent.mobileqq.wink.newalbum.director.datasource.a aVar;
        List listOf;
        Object r16;
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
            if (!this.$result.getIsLast()) {
                aVar = WinkNewAlbumProcessorManager.dataConsumer;
                if (aVar != null) {
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(this.$result);
                    aVar.b(listOf);
                }
            } else {
                WinkNewAlbumProcessorManager winkNewAlbumProcessorManager = WinkNewAlbumProcessorManager.f324234a;
                this.label = 1;
                r16 = winkNewAlbumProcessorManager.r(this);
                if (r16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkNewAlbumProcessorManager$onCollectResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
