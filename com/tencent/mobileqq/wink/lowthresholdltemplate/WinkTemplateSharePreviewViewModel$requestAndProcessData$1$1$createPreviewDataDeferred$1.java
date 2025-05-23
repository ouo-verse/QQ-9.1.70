package com.tencent.mobileqq.wink.lowthresholdltemplate;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import java.util.List;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/a;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.lowthresholdltemplate.WinkTemplateSharePreviewViewModel$requestAndProcessData$1$1$createPreviewDataDeferred$1", f = "WinkTemplateSharePreviewViewModel.kt", i = {}, l = {136, 137, 138}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
final class WinkTemplateSharePreviewViewModel$requestAndProcessData$1$1$createPreviewDataDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super a>, Object> {
    final /* synthetic */ Deferred<Pair<List<String>, Long>> $downloadDeferred;
    final /* synthetic */ Deferred<Pair<Unit, Long>> $loadLightDeferred;
    final /* synthetic */ Deferred<Pair<MetaMaterial, Long>> $mateDeferred;
    final /* synthetic */ Ref.BooleanRef $needDownLoadSo;
    final /* synthetic */ Ref.BooleanRef $needDownLoadTemplate;
    final /* synthetic */ long $startTime;
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ WinkTemplateSharePreviewViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WinkTemplateSharePreviewViewModel$requestAndProcessData$1$1$createPreviewDataDeferred$1(WinkTemplateSharePreviewViewModel winkTemplateSharePreviewViewModel, long j3, Deferred<Pair<Unit, Long>> deferred, Deferred<? extends Pair<? extends List<String>, Long>> deferred2, Deferred<Pair<MetaMaterial, Long>> deferred3, Ref.BooleanRef booleanRef, Ref.BooleanRef booleanRef2, Continuation<? super WinkTemplateSharePreviewViewModel$requestAndProcessData$1$1$createPreviewDataDeferred$1> continuation) {
        super(2, continuation);
        this.this$0 = winkTemplateSharePreviewViewModel;
        this.$startTime = j3;
        this.$loadLightDeferred = deferred;
        this.$downloadDeferred = deferred2;
        this.$mateDeferred = deferred3;
        this.$needDownLoadSo = booleanRef;
        this.$needDownLoadTemplate = booleanRef2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkTemplateSharePreviewViewModel$requestAndProcessData$1$1$createPreviewDataDeferred$1(this.this$0, this.$startTime, this.$loadLightDeferred, this.$downloadDeferred, this.$mateDeferred, this.$needDownLoadSo, this.$needDownLoadTemplate, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00a3 A[Catch: Exception -> 0x00cb, TryCatch #0 {Exception -> 0x00cb, blocks: (B:8:0x001d, B:10:0x0098, B:12:0x00a3, B:13:0x00aa, B:20:0x0039, B:21:0x007e, B:26:0x0043, B:27:0x005e, B:32:0x004a), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0092 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0093  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        WinkTemplateSharePreviewViewModel winkTemplateSharePreviewViewModel;
        long j3;
        long j16;
        long j17;
        Object await;
        WinkTemplateSharePreviewViewModel winkTemplateSharePreviewViewModel2;
        Pair pair;
        long j18;
        p pVar;
        a W1;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            long j19 = this.J$1;
                            long j26 = this.J$0;
                            Pair pair2 = (Pair) this.L$1;
                            WinkTemplateSharePreviewViewModel winkTemplateSharePreviewViewModel3 = (WinkTemplateSharePreviewViewModel) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            pair = pair2;
                            winkTemplateSharePreviewViewModel2 = winkTemplateSharePreviewViewModel3;
                            j18 = j26;
                            j16 = j19;
                            Pair pair3 = (Pair) obj;
                            pVar = this.this$0.winkTemplateShareConfig;
                            if (pVar == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
                                pVar = null;
                            }
                            W1 = winkTemplateSharePreviewViewModel2.W1(j18, j16, pair, pair3, pVar.d().a(), TuplesKt.to(Boxing.boxBoolean(this.$needDownLoadSo.element), Boxing.boxBoolean(this.$needDownLoadTemplate.element)));
                            return W1;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j16 = this.J$1;
                    j17 = this.J$0;
                    winkTemplateSharePreviewViewModel = (WinkTemplateSharePreviewViewModel) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    Pair pair4 = (Pair) obj;
                    Deferred<Pair<MetaMaterial, Long>> deferred = this.$mateDeferred;
                    this.L$0 = winkTemplateSharePreviewViewModel;
                    this.L$1 = pair4;
                    this.J$0 = j17;
                    this.J$1 = j16;
                    this.label = 3;
                    await = deferred.await(this);
                    if (await != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    winkTemplateSharePreviewViewModel2 = winkTemplateSharePreviewViewModel;
                    long j27 = j17;
                    pair = pair4;
                    obj = await;
                    j18 = j27;
                    Pair pair32 = (Pair) obj;
                    pVar = this.this$0.winkTemplateShareConfig;
                    if (pVar == null) {
                    }
                    W1 = winkTemplateSharePreviewViewModel2.W1(j18, j16, pair, pair32, pVar.d().a(), TuplesKt.to(Boxing.boxBoolean(this.$needDownLoadSo.element), Boxing.boxBoolean(this.$needDownLoadTemplate.element)));
                    return W1;
                }
                j3 = this.J$0;
                winkTemplateSharePreviewViewModel = (WinkTemplateSharePreviewViewModel) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                winkTemplateSharePreviewViewModel = this.this$0;
                long j28 = this.$startTime;
                Deferred<Pair<Unit, Long>> deferred2 = this.$loadLightDeferred;
                this.L$0 = winkTemplateSharePreviewViewModel;
                this.J$0 = j28;
                this.label = 1;
                obj = deferred2.await(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                j3 = j28;
            }
            long longValue = ((Number) ((Pair) obj).getSecond()).longValue();
            Deferred<Pair<List<String>, Long>> deferred3 = this.$downloadDeferred;
            this.L$0 = winkTemplateSharePreviewViewModel;
            this.J$0 = j3;
            this.J$1 = longValue;
            this.label = 2;
            obj = deferred3.await(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            j16 = longValue;
            j17 = j3;
            Pair pair42 = (Pair) obj;
            Deferred<Pair<MetaMaterial, Long>> deferred4 = this.$mateDeferred;
            this.L$0 = winkTemplateSharePreviewViewModel;
            this.L$1 = pair42;
            this.J$0 = j17;
            this.J$1 = j16;
            this.label = 3;
            await = deferred4.await(this);
            if (await != coroutine_suspended) {
            }
        } catch (Exception e16) {
            throw e16;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super a> continuation) {
        return ((WinkTemplateSharePreviewViewModel$requestAndProcessData$1$1$createPreviewDataDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
