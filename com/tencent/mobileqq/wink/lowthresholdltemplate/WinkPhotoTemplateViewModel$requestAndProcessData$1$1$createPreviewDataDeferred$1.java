package com.tencent.mobileqq.wink.lowthresholdltemplate;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.wink.lowthresholdltemplate.WinkPhotoTemplateViewModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/WinkPhotoTemplateViewModel$a;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.lowthresholdltemplate.WinkPhotoTemplateViewModel$requestAndProcessData$1$1$createPreviewDataDeferred$1", f = "WinkPhotoTemplateViewModel.kt", i = {}, l = {129, 130}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
final class WinkPhotoTemplateViewModel$requestAndProcessData$1$1$createPreviewDataDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super WinkPhotoTemplateViewModel.a>, Object> {
    final /* synthetic */ Deferred<Pair<Unit, Long>> $loadLightDeferred;
    final /* synthetic */ Deferred<Pair<MetaMaterial, Long>> $mateDeferred;
    final /* synthetic */ Ref.BooleanRef $needDownLoadSo;
    final /* synthetic */ Ref.BooleanRef $needDownLoadTemplate;
    long J$0;
    Object L$0;
    int label;
    final /* synthetic */ WinkPhotoTemplateViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkPhotoTemplateViewModel$requestAndProcessData$1$1$createPreviewDataDeferred$1(WinkPhotoTemplateViewModel winkPhotoTemplateViewModel, Deferred<Pair<Unit, Long>> deferred, Deferred<Pair<MetaMaterial, Long>> deferred2, Ref.BooleanRef booleanRef, Ref.BooleanRef booleanRef2, Continuation<? super WinkPhotoTemplateViewModel$requestAndProcessData$1$1$createPreviewDataDeferred$1> continuation) {
        super(2, continuation);
        this.this$0 = winkPhotoTemplateViewModel;
        this.$loadLightDeferred = deferred;
        this.$mateDeferred = deferred2;
        this.$needDownLoadSo = booleanRef;
        this.$needDownLoadTemplate = booleanRef2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkPhotoTemplateViewModel$requestAndProcessData$1$1$createPreviewDataDeferred$1(this.this$0, this.$loadLightDeferred, this.$mateDeferred, this.$needDownLoadSo, this.$needDownLoadTemplate, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        WinkPhotoTemplateViewModel winkPhotoTemplateViewModel;
        WinkPhotoTemplateViewModel winkPhotoTemplateViewModel2;
        long j3;
        WinkPhotoTemplateViewModel.a P1;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        j3 = this.J$0;
                        winkPhotoTemplateViewModel2 = (WinkPhotoTemplateViewModel) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        P1 = winkPhotoTemplateViewModel2.P1(j3, (Pair) obj, TuplesKt.to(Boxing.boxBoolean(this.$needDownLoadSo.element), Boxing.boxBoolean(this.$needDownLoadTemplate.element)));
                        return P1;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                winkPhotoTemplateViewModel = (WinkPhotoTemplateViewModel) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                w53.b.f(this.this$0.getTAG(), "createPreviewDataDeferred begin");
                WinkPhotoTemplateViewModel winkPhotoTemplateViewModel3 = this.this$0;
                Deferred<Pair<Unit, Long>> deferred = this.$loadLightDeferred;
                this.L$0 = winkPhotoTemplateViewModel3;
                this.label = 1;
                Object await = deferred.await(this);
                if (await == coroutine_suspended) {
                    return coroutine_suspended;
                }
                winkPhotoTemplateViewModel = winkPhotoTemplateViewModel3;
                obj = await;
            }
            long longValue = ((Number) ((Pair) obj).getSecond()).longValue();
            Deferred<Pair<MetaMaterial, Long>> deferred2 = this.$mateDeferred;
            this.L$0 = winkPhotoTemplateViewModel;
            this.J$0 = longValue;
            this.label = 2;
            obj = deferred2.await(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            winkPhotoTemplateViewModel2 = winkPhotoTemplateViewModel;
            j3 = longValue;
            P1 = winkPhotoTemplateViewModel2.P1(j3, (Pair) obj, TuplesKt.to(Boxing.boxBoolean(this.$needDownLoadSo.element), Boxing.boxBoolean(this.$needDownLoadTemplate.element)));
            return P1;
        } catch (Exception e16) {
            throw e16;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super WinkPhotoTemplateViewModel.a> continuation) {
        return ((WinkPhotoTemplateViewModel$requestAndProcessData$1$1$createPreviewDataDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
