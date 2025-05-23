package com.tencent.mobileqq.wink.editor.aielimination;

import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import java.util.Map;
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

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.editor.aielimination.WinkAiEliminationViewModel$fetchShareImg$2$downloadOutPath$1", f = "WinkAiEliminationViewModel.kt", i = {}, l = {PlayerResources.ViewId.PLAYER_DURATION}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkAiEliminationViewModel$fetchShareImg$2$downloadOutPath$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    int label;
    final /* synthetic */ WinkAiEliminationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkAiEliminationViewModel$fetchShareImg$2$downloadOutPath$1(WinkAiEliminationViewModel winkAiEliminationViewModel, Continuation<? super WinkAiEliminationViewModel$fetchShareImg$2$downloadOutPath$1> continuation) {
        super(2, continuation);
        this.this$0 = winkAiEliminationViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkAiEliminationViewModel$fetchShareImg$2$downloadOutPath$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        String str;
        Map<String, String> d16;
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
            WinkAiEliminationViewModel winkAiEliminationViewModel = this.this$0;
            com.tencent.mobileqq.wink.editor.aielimination.model.b f26 = winkAiEliminationViewModel.f2();
            if (f26 != null && (d16 = f26.d()) != null) {
                str = d16.get("SHARE_PREFIX__OUT_CHANNEL");
            } else {
                str = null;
            }
            this.label = 1;
            obj = winkAiEliminationViewModel.X1(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super String> continuation) {
        return ((WinkAiEliminationViewModel$fetchShareImg$2$downloadOutPath$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
