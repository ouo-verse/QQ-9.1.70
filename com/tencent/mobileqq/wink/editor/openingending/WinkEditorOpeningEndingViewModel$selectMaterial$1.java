package com.tencent.mobileqq.wink.editor.openingending;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.wink.editor.openingending.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingViewModel$selectMaterial$1", f = "WinkEditorOpeningEndingViewModel.kt", i = {}, l = {210}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkEditorOpeningEndingViewModel$selectMaterial$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MetaMaterial $metaMaterial;
    int label;
    final /* synthetic */ WinkEditorOpeningEndingViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkEditorOpeningEndingViewModel$selectMaterial$1(WinkEditorOpeningEndingViewModel winkEditorOpeningEndingViewModel, MetaMaterial metaMaterial, Continuation<? super WinkEditorOpeningEndingViewModel$selectMaterial$1> continuation) {
        super(2, continuation);
        this.this$0 = winkEditorOpeningEndingViewModel;
        this.$metaMaterial = metaMaterial;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkEditorOpeningEndingViewModel$selectMaterial$1(this.this$0, this.$metaMaterial, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        MutableSharedFlow mutableSharedFlow;
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
            mutableSharedFlow = this.this$0._onOpeningEndingUiEvent;
            a.SelectMaterial selectMaterial = new a.SelectMaterial(this.$metaMaterial);
            this.label = 1;
            if (mutableSharedFlow.emit(selectMaterial, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkEditorOpeningEndingViewModel$selectMaterial$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
