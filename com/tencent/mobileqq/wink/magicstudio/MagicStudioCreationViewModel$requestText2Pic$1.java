package com.tencent.mobileqq.wink.magicstudio;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel;
import com.tencent.mobileqq.wink.magicstudio.model.CombineFlowInfo;
import com.tencent.mobileqq.wink.magicstudio.model.GenerateInfo;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel$requestText2Pic$1", f = "MagicStudioCreationViewModel.kt", i = {0, 1, 1, 2, 2, 3, 3}, l = {com.tencent.luggage.wxa.wh.b.CTRL_INDEX, 741, 745, 746, 747, 1147, 768}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "firstAigcFlow", "firstAigcFlow", "count", "firstAigcFlow", "count"}, s = {"L$0", "L$0", "L$1", "L$0", "I$0", "L$0", "I$0"})
/* loaded from: classes21.dex */
public final class MagicStudioCreationViewModel$requestText2Pic$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $desc;
    final /* synthetic */ com.tencent.mobileqq.wink.magicstudio.model.f $nnCurStyle;
    final /* synthetic */ String $operationalTopics;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MagicStudioCreationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/tencent/mobileqq/wink/magicstudio/model/a;", "", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel$requestText2Pic$1$1", f = "MagicStudioCreationViewModel.kt", i = {0}, l = {749, com.tencent.luggage.wxa.sm.e.O}, m = "invokeSuspend", n = {"$this$catch"}, s = {"L$0"})
    /* renamed from: com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel$requestText2Pic$1$1, reason: invalid class name */
    /* loaded from: classes21.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<FlowCollector<? super CombineFlowInfo>, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;
        final /* synthetic */ MagicStudioCreationViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MagicStudioCreationViewModel magicStudioCreationViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(3, continuation);
            this.this$0 = magicStudioCreationViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            FlowCollector flowCollector;
            MutableSharedFlow mutableSharedFlow;
            Map emptyMap;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                flowCollector = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                flowCollector = (FlowCollector) this.L$0;
                Throwable th5 = (Throwable) this.L$1;
                w53.b.h("MagicStudioCreationViewModel", "catch make fail ", th5);
                mutableSharedFlow = this.this$0._event;
                MagicStudioCreationViewModel.b.MakeFail makeFail = new MagicStudioCreationViewModel.b.MakeFail(th5);
                this.L$0 = flowCollector;
                this.label = 1;
                if (mutableSharedFlow.emit(makeFail, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            MagicStudioDataSource.f323652a.l0(0L, "");
            MetaMaterial metaMaterial = new MetaMaterial();
            emptyMap = MapsKt__MapsKt.emptyMap();
            CombineFlowInfo combineFlowInfo = new CombineFlowInfo(metaMaterial, new GenerateInfo(emptyMap, "", false, null, null, null, null, 0, 0, 508, null), 1);
            this.L$0 = null;
            this.label = 2;
            if (flowCollector.emit(combineFlowInfo, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        public final Object invoke(@NotNull FlowCollector<? super CombineFlowInfo> flowCollector, @NotNull Throwable th5, @Nullable Continuation<? super Unit> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = flowCollector;
            anonymousClass1.L$1 = th5;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicStudioCreationViewModel$requestText2Pic$1(MagicStudioCreationViewModel magicStudioCreationViewModel, com.tencent.mobileqq.wink.magicstudio.model.f fVar, String str, String str2, Continuation<? super MagicStudioCreationViewModel$requestText2Pic$1> continuation) {
        super(2, continuation);
        this.this$0 = magicStudioCreationViewModel;
        this.$nnCurStyle = fVar;
        this.$desc = str;
        this.$operationalTopics = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        MagicStudioCreationViewModel$requestText2Pic$1 magicStudioCreationViewModel$requestText2Pic$1 = new MagicStudioCreationViewModel$requestText2Pic$1(this.this$0, this.$nnCurStyle, this.$desc, this.$operationalTopics, continuation);
        magicStudioCreationViewModel$requestText2Pic$1.L$0 = obj;
        return magicStudioCreationViewModel$requestText2Pic$1;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000f. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0166 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0189 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x013e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0130 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x010f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0095 A[Catch: Exception -> 0x002d, TryCatch #0 {Exception -> 0x002d, blocks: (B:10:0x0020, B:11:0x0025, B:22:0x0037, B:28:0x0043, B:39:0x0050, B:41:0x00aa, B:50:0x0081, B:52:0x0095, B:53:0x009b), top: B:2:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009a  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Continuation continuation;
        MutableSharedFlow mutableSharedFlow;
        MagicStudioCreationViewModel.b.MakeFail makeFail;
        CoroutineScope coroutineScope;
        MutableSharedFlow mutableSharedFlow2;
        List<Pair<String, Integer>> h16;
        int i3;
        Object C2;
        CoroutineScope coroutineScope2;
        MutableSharedFlow mutableSharedFlow3;
        int intValue;
        MagicStudioCreationViewModel magicStudioCreationViewModel;
        String str;
        com.tencent.mobileqq.wink.magicstudio.model.f fVar;
        MagicStudioDataManager I2;
        String uploadUrl;
        MagicStudioDataManager I22;
        String safeId;
        MutableSharedFlow mutableSharedFlow4;
        int i16;
        MutableSharedFlow mutableSharedFlow5;
        MagicStudioCreationViewModel.b.ProgressUpdate progressUpdate;
        MetaMaterial metaMaterial;
        Object w26;
        Flow cancellable;
        MagicStudioCreationViewModel$requestText2Pic$1$invokeSuspend$$inlined$collect$1 magicStudioCreationViewModel$requestText2Pic$1$invokeSuspend$$inlined$collect$1;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (Exception e16) {
            e = e16;
            continuation = null;
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.L$0;
                mutableSharedFlow2 = this.this$0._event;
                MagicStudioCreationViewModel.b.ProgressUpdate progressUpdate2 = new MagicStudioCreationViewModel.b.ProgressUpdate(0, false, 2, null);
                this.L$0 = coroutineScope;
                this.label = 1;
                if (mutableSharedFlow2.emit(progressUpdate2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                MutableSharedFlow MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
                this.this$0.z2();
                this.this$0.A2();
                MagicStudioCreationViewModel magicStudioCreationViewModel2 = this.this$0;
                h16 = this.$nnCurStyle.h();
                if (h16 == null) {
                    i3 = h16.size();
                } else {
                    i3 = 0;
                }
                this.L$0 = coroutineScope;
                this.L$1 = MutableSharedFlow$default;
                this.label = 2;
                C2 = magicStudioCreationViewModel2.C2(i3, this);
                if (C2 != coroutine_suspended) {
                    return coroutine_suspended;
                }
                coroutineScope2 = coroutineScope;
                mutableSharedFlow3 = MutableSharedFlow$default;
                intValue = ((Number) C2).intValue();
                this.this$0.aigcCount = intValue;
                w53.b.f("MagicStudioCreationViewModel", "getAigcCount " + intValue);
                magicStudioCreationViewModel = this.this$0;
                str = this.$desc;
                fVar = this.$nnCurStyle;
                I2 = magicStudioCreationViewModel.I2();
                uploadUrl = I2.b().getUploadUrl();
                I22 = this.this$0.I2();
                safeId = I22.b().getSafeId();
                this.L$0 = mutableSharedFlow3;
                this.L$1 = null;
                this.I$0 = intValue;
                this.label = 3;
                try {
                } catch (Exception e17) {
                    e = e17;
                    continuation = null;
                    w53.b.h("MagicStudioCreationViewModel", "make fail", e);
                    mutableSharedFlow = this.this$0._event;
                    makeFail = new MagicStudioCreationViewModel.b.MakeFail(e);
                    this.L$0 = continuation;
                    this.L$1 = continuation;
                    this.label = 7;
                    if (mutableSharedFlow.emit(makeFail, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                if (MagicStudioCreationViewModel.q2(magicStudioCreationViewModel, coroutineScope2, str, fVar, uploadUrl, safeId, mutableSharedFlow3, intValue, false, this, 128, null) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableSharedFlow4 = mutableSharedFlow3;
                i16 = intValue;
                mutableSharedFlow5 = this.this$0._event;
                continuation = null;
                metaMaterial = 0;
                try {
                    progressUpdate = new MagicStudioCreationViewModel.b.ProgressUpdate(20, false, 2, null);
                    this.L$0 = mutableSharedFlow4;
                    this.I$0 = i16;
                    this.label = 4;
                    if (mutableSharedFlow5.emit(progressUpdate, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    MagicStudioCreationViewModel magicStudioCreationViewModel3 = this.this$0;
                    this.L$0 = metaMaterial;
                    this.label = 5;
                    w26 = magicStudioCreationViewModel3.w2(mutableSharedFlow4, metaMaterial, i16, this);
                    continuation = metaMaterial;
                    if (w26 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    cancellable = FlowKt.cancellable(FlowKt.m2026catch((Flow) w26, new AnonymousClass1(this.this$0, continuation)));
                    magicStudioCreationViewModel$requestText2Pic$1$invokeSuspend$$inlined$collect$1 = new MagicStudioCreationViewModel$requestText2Pic$1$invokeSuspend$$inlined$collect$1(this.this$0, this.$desc, this.$operationalTopics, this.$nnCurStyle);
                    this.label = 6;
                    if (cancellable.collect(magicStudioCreationViewModel$requestText2Pic$1$invokeSuspend$$inlined$collect$1, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } catch (Exception e18) {
                    e = e18;
                    w53.b.h("MagicStudioCreationViewModel", "make fail", e);
                    mutableSharedFlow = this.this$0._event;
                    makeFail = new MagicStudioCreationViewModel.b.MakeFail(e);
                    this.L$0 = continuation;
                    this.L$1 = continuation;
                    this.label = 7;
                    if (mutableSharedFlow.emit(makeFail, this) == coroutine_suspended) {
                    }
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case 1:
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                MutableSharedFlow MutableSharedFlow$default2 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
                this.this$0.z2();
                this.this$0.A2();
                MagicStudioCreationViewModel magicStudioCreationViewModel22 = this.this$0;
                h16 = this.$nnCurStyle.h();
                if (h16 == null) {
                }
                this.L$0 = coroutineScope;
                this.L$1 = MutableSharedFlow$default2;
                this.label = 2;
                C2 = magicStudioCreationViewModel22.C2(i3, this);
                if (C2 != coroutine_suspended) {
                }
                break;
            case 2:
                mutableSharedFlow3 = (MutableSharedFlow) this.L$1;
                CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                C2 = obj;
                coroutineScope2 = coroutineScope3;
                intValue = ((Number) C2).intValue();
                this.this$0.aigcCount = intValue;
                w53.b.f("MagicStudioCreationViewModel", "getAigcCount " + intValue);
                magicStudioCreationViewModel = this.this$0;
                str = this.$desc;
                fVar = this.$nnCurStyle;
                I2 = magicStudioCreationViewModel.I2();
                uploadUrl = I2.b().getUploadUrl();
                I22 = this.this$0.I2();
                safeId = I22.b().getSafeId();
                this.L$0 = mutableSharedFlow3;
                this.L$1 = null;
                this.I$0 = intValue;
                this.label = 3;
                if (MagicStudioCreationViewModel.q2(magicStudioCreationViewModel, coroutineScope2, str, fVar, uploadUrl, safeId, mutableSharedFlow3, intValue, false, this, 128, null) != coroutine_suspended) {
                }
                break;
            case 3:
                i16 = this.I$0;
                mutableSharedFlow4 = (MutableSharedFlow) this.L$0;
                ResultKt.throwOnFailure(obj);
                mutableSharedFlow5 = this.this$0._event;
                continuation = null;
                metaMaterial = 0;
                progressUpdate = new MagicStudioCreationViewModel.b.ProgressUpdate(20, false, 2, null);
                this.L$0 = mutableSharedFlow4;
                this.I$0 = i16;
                this.label = 4;
                if (mutableSharedFlow5.emit(progressUpdate, this) == coroutine_suspended) {
                }
                MagicStudioCreationViewModel magicStudioCreationViewModel32 = this.this$0;
                this.L$0 = metaMaterial;
                this.label = 5;
                w26 = magicStudioCreationViewModel32.w2(mutableSharedFlow4, metaMaterial, i16, this);
                continuation = metaMaterial;
                if (w26 == coroutine_suspended) {
                }
                cancellable = FlowKt.cancellable(FlowKt.m2026catch((Flow) w26, new AnonymousClass1(this.this$0, continuation)));
                magicStudioCreationViewModel$requestText2Pic$1$invokeSuspend$$inlined$collect$1 = new MagicStudioCreationViewModel$requestText2Pic$1$invokeSuspend$$inlined$collect$1(this.this$0, this.$desc, this.$operationalTopics, this.$nnCurStyle);
                this.label = 6;
                if (cancellable.collect(magicStudioCreationViewModel$requestText2Pic$1$invokeSuspend$$inlined$collect$1, this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 4:
                i16 = this.I$0;
                mutableSharedFlow4 = (MutableSharedFlow) this.L$0;
                ResultKt.throwOnFailure(obj);
                metaMaterial = 0;
                MagicStudioCreationViewModel magicStudioCreationViewModel322 = this.this$0;
                this.L$0 = metaMaterial;
                this.label = 5;
                w26 = magicStudioCreationViewModel322.w2(mutableSharedFlow4, metaMaterial, i16, this);
                continuation = metaMaterial;
                if (w26 == coroutine_suspended) {
                }
                cancellable = FlowKt.cancellable(FlowKt.m2026catch((Flow) w26, new AnonymousClass1(this.this$0, continuation)));
                magicStudioCreationViewModel$requestText2Pic$1$invokeSuspend$$inlined$collect$1 = new MagicStudioCreationViewModel$requestText2Pic$1$invokeSuspend$$inlined$collect$1(this.this$0, this.$desc, this.$operationalTopics, this.$nnCurStyle);
                this.label = 6;
                if (cancellable.collect(magicStudioCreationViewModel$requestText2Pic$1$invokeSuspend$$inlined$collect$1, this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 5:
                ResultKt.throwOnFailure(obj);
                w26 = obj;
                continuation = null;
                cancellable = FlowKt.cancellable(FlowKt.m2026catch((Flow) w26, new AnonymousClass1(this.this$0, continuation)));
                magicStudioCreationViewModel$requestText2Pic$1$invokeSuspend$$inlined$collect$1 = new MagicStudioCreationViewModel$requestText2Pic$1$invokeSuspend$$inlined$collect$1(this.this$0, this.$desc, this.$operationalTopics, this.$nnCurStyle);
                this.label = 6;
                if (cancellable.collect(magicStudioCreationViewModel$requestText2Pic$1$invokeSuspend$$inlined$collect$1, this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 6:
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            case 7:
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MagicStudioCreationViewModel$requestText2Pic$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
