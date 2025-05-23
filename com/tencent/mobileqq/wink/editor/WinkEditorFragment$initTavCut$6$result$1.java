package com.tencent.mobileqq.wink.editor;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.editor.WinkEditorFragment$initTavCut$6$result$1", f = "WinkEditorFragment.kt", i = {}, l = {1507}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
final class WinkEditorFragment$initTavCut$6$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;
    final /* synthetic */ WinkEditorFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkEditorFragment$initTavCut$6$result$1(WinkEditorFragment winkEditorFragment, Continuation<? super WinkEditorFragment$initTavCut$6$result$1> continuation) {
        super(2, continuation);
        this.this$0 = winkEditorFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkEditorFragment$initTavCut$6$result$1(this.this$0, continuation);
    }

    /* JADX WARN: Incorrect condition in loop: B:9:0x0023 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ArrayList arrayList;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0 && i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        while (arrayList.size() == 0) {
            this.label = 1;
            if (DelayKt.delay(10L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Boxing.boxBoolean(true);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((WinkEditorFragment$initTavCut$6$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
