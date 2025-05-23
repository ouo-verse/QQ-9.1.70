package com.tencent.mobileqq.wink.magicstudio;

import com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioPrompt;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioTip;
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
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel$onPageInit$1", f = "MagicStudioCreationViewModel.kt", i = {}, l = {211}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class MagicStudioCreationViewModel$onPageInit$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<MagicStudioPrompt> $magicStudioPrompts;
    final /* synthetic */ List<com.tencent.mobileqq.wink.magicstudio.model.f> $magicStudioStyles;
    final /* synthetic */ List<MagicStudioTip> $magicStudioTips;
    int label;
    final /* synthetic */ MagicStudioCreationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicStudioCreationViewModel$onPageInit$1(MagicStudioCreationViewModel magicStudioCreationViewModel, List<MagicStudioTip> list, List<com.tencent.mobileqq.wink.magicstudio.model.f> list2, List<MagicStudioPrompt> list3, Continuation<? super MagicStudioCreationViewModel$onPageInit$1> continuation) {
        super(2, continuation);
        this.this$0 = magicStudioCreationViewModel;
        this.$magicStudioTips = list;
        this.$magicStudioStyles = list2;
        this.$magicStudioPrompts = list3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MagicStudioCreationViewModel$onPageInit$1(this.this$0, this.$magicStudioTips, this.$magicStudioStyles, this.$magicStudioPrompts, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        MagicStudioDataManager I2;
        MutableStateFlow<List<com.tencent.mobileqq.wink.magicstudio.model.f>> mutableStateFlow;
        MutableStateFlow<List<MagicStudioPrompt>> mutableStateFlow2;
        MutableSharedFlow<MagicStudioCreationViewModel.c> mutableSharedFlow;
        int S2;
        String str;
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
            I2 = this.this$0.I2();
            List<MagicStudioTip> list = this.$magicStudioTips;
            List<com.tencent.mobileqq.wink.magicstudio.model.f> list2 = this.$magicStudioStyles;
            List<MagicStudioPrompt> list3 = this.$magicStudioPrompts;
            mutableStateFlow = this.this$0._styleData;
            mutableStateFlow2 = this.this$0._tagData;
            mutableSharedFlow = this.this$0._selectEvent;
            this.label = 1;
            if (I2.k(list, list2, list3, mutableStateFlow, mutableStateFlow2, mutableSharedFlow, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        S2 = this.this$0.S2();
        this.this$0.g3(S2);
        str = this.this$0.schemaPrompt;
        if (str != null) {
            this.this$0.d3(str);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MagicStudioCreationViewModel$onPageInit$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
