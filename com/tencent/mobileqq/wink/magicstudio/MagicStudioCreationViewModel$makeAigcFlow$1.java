package com.tencent.mobileqq.wink.magicstudio;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.aigc.bean.AIGCContentOutput;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\u0010\u0006\u001a\u00020\u0005* \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/Pair;", "Lorg/light/aigc/bean/AIGCContentOutput;", "", "", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel$makeAigcFlow$1", f = "MagicStudioCreationViewModel.kt", i = {}, l = {903, 902}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class MagicStudioCreationViewModel$makeAigcFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super Pair<? extends AIGCContentOutput, ? extends Map<String, ? extends String>>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $desc;
    final /* synthetic */ int $i;
    final /* synthetic */ com.tencent.mobileqq.wink.magicstudio.model.f $nnCurStyle;
    final /* synthetic */ String $picPath;
    final /* synthetic */ boolean $requireBaseImageIndex;
    final /* synthetic */ String $safeId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MagicStudioCreationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicStudioCreationViewModel$makeAigcFlow$1(com.tencent.mobileqq.wink.magicstudio.model.f fVar, int i3, boolean z16, String str, String str2, String str3, MagicStudioCreationViewModel magicStudioCreationViewModel, Continuation<? super MagicStudioCreationViewModel$makeAigcFlow$1> continuation) {
        super(2, continuation);
        this.$nnCurStyle = fVar;
        this.$i = i3;
        this.$requireBaseImageIndex = z16;
        this.$desc = str;
        this.$picPath = str2;
        this.$safeId = str3;
        this.this$0 = magicStudioCreationViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        MagicStudioCreationViewModel$makeAigcFlow$1 magicStudioCreationViewModel$makeAigcFlow$1 = new MagicStudioCreationViewModel$makeAigcFlow$1(this.$nnCurStyle, this.$i, this.$requireBaseImageIndex, this.$desc, this.$picPath, this.$safeId, this.this$0, continuation);
        magicStudioCreationViewModel$makeAigcFlow$1.L$0 = obj;
        return magicStudioCreationViewModel$makeAigcFlow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Pair<? extends AIGCContentOutput, ? extends Map<String, ? extends String>>> flowCollector, Continuation<? super Unit> continuation) {
        return invoke2((FlowCollector<? super Pair<? extends AIGCContentOutput, ? extends Map<String, String>>>) flowCollector, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004e, code lost:
    
        if (r14 != null) goto L20;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        FlowCollector flowCollector;
        String styleModeId;
        Integer num;
        int i3;
        Object orNull;
        Object orNull2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 == 2) {
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
            if (this.$nnCurStyle.getIsCollectionStyle()) {
                List<Pair<String, Integer>> h16 = this.$nnCurStyle.h();
                if (h16 != null) {
                    orNull2 = CollectionsKt___CollectionsKt.getOrNull(h16, this.$i);
                    Pair pair = (Pair) orNull2;
                    if (pair != null) {
                        styleModeId = (String) pair.getFirst();
                    }
                }
                styleModeId = this.$nnCurStyle.getStyleModeId();
            } else {
                styleModeId = this.$nnCurStyle.getStyleModeId();
            }
            String str = styleModeId;
            w53.b.f("MagicStudioCreationViewModel", "aigcContent " + this.$i + ", style = " + str);
            if (this.$requireBaseImageIndex) {
                if (this.$nnCurStyle.getIsCollectionStyle()) {
                    List<Pair<String, Integer>> h17 = this.$nnCurStyle.h();
                    if (h17 != null) {
                        orNull = CollectionsKt___CollectionsKt.getOrNull(h17, this.$i);
                        Pair pair2 = (Pair) orNull;
                        if (pair2 != null) {
                            i3 = ((Number) pair2.getSecond()).intValue();
                        }
                    }
                    i3 = this.$i;
                } else {
                    i3 = this.$i;
                }
                num = Boxing.boxInt(i3);
            } else {
                num = null;
            }
            MagicStudioDataSource magicStudioDataSource = MagicStudioDataSource.f323652a;
            String str2 = this.$desc;
            String str3 = this.$picPath;
            String str4 = this.$safeId;
            boolean isRegenerate = this.this$0.getIsRegenerate();
            this.L$0 = flowCollector;
            this.label = 1;
            obj = magicStudioDataSource.j0(str2, str, str3, str4, num, isRegenerate, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        this.L$0 = null;
        this.label = 2;
        if (flowCollector.emit(obj, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull FlowCollector<? super Pair<? extends AIGCContentOutput, ? extends Map<String, String>>> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((MagicStudioCreationViewModel$makeAigcFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
