package com.tencent.mobileqq.wink.magicstudio;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel", f = "MagicStudioCreationViewModel.kt", i = {0}, l = {com.tencent.luggage.wxa.gg.e.CTRL_INDEX}, m = "combineTaskFlow", n = {"this"}, s = {"L$0"})
/* loaded from: classes21.dex */
public final class MagicStudioCreationViewModel$combineTaskFlow$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MagicStudioCreationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicStudioCreationViewModel$combineTaskFlow$1(MagicStudioCreationViewModel magicStudioCreationViewModel, Continuation<? super MagicStudioCreationViewModel$combineTaskFlow$1> continuation) {
        super(continuation);
        this.this$0 = magicStudioCreationViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object w26;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        w26 = this.this$0.w2(null, null, 0, this);
        return w26;
    }
}
