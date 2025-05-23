package com.tencent.mobileqq.wink.magicstudio;

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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel$onStyleClicked$1", f = "MagicStudioCreationViewModel.kt", i = {}, l = {250, 251, 252}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class MagicStudioCreationViewModel$onStyleClicked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.tencent.mobileqq.wink.magicstudio.model.f $style;
    int label;
    final /* synthetic */ MagicStudioCreationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicStudioCreationViewModel$onStyleClicked$1(MagicStudioCreationViewModel magicStudioCreationViewModel, com.tencent.mobileqq.wink.magicstudio.model.f fVar, Continuation<? super MagicStudioCreationViewModel$onStyleClicked$1> continuation) {
        super(2, continuation);
        this.this$0 = magicStudioCreationViewModel;
        this.$style = fVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MagicStudioCreationViewModel$onStyleClicked$1(this.this$0, this.$style, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x007d A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        MutableStateFlow mutableStateFlow;
        Object z36;
        MutableSharedFlow mutableSharedFlow;
        Boolean boxBoolean;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                mutableSharedFlow = this.this$0._showCollection;
                boxBoolean = Boxing.boxBoolean(this.$style.getIsCollectionStyle());
                this.label = 3;
                if (mutableSharedFlow.emit(boxBoolean, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            String component2 = this.this$0.J2().getValue().component2();
            mutableStateFlow = this.this$0._descData;
            Pair pair = TuplesKt.to(this.$style.getDefaultPromptTip(), component2);
            this.label = 1;
            if (mutableStateFlow.emit(pair, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        MagicStudioCreationViewModel magicStudioCreationViewModel = this.this$0;
        String styleID = this.$style.getStyleID();
        this.label = 2;
        z36 = magicStudioCreationViewModel.z3(styleID, this);
        if (z36 == coroutine_suspended) {
            return coroutine_suspended;
        }
        mutableSharedFlow = this.this$0._showCollection;
        boxBoolean = Boxing.boxBoolean(this.$style.getIsCollectionStyle());
        this.label = 3;
        if (mutableSharedFlow.emit(boxBoolean, this) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MagicStudioCreationViewModel$onStyleClicked$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
