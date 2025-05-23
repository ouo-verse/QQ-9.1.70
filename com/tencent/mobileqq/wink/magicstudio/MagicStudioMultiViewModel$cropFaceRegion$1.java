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
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.MagicStudioMultiViewModel", f = "MagicStudioMultiViewModel.kt", i = {0, 0}, l = {249}, m = "cropFaceRegion", n = {"imagePath", "ratio"}, s = {"L$0", "L$1"})
/* loaded from: classes21.dex */
public final class MagicStudioMultiViewModel$cropFaceRegion$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MagicStudioMultiViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicStudioMultiViewModel$cropFaceRegion$1(MagicStudioMultiViewModel magicStudioMultiViewModel, Continuation<? super MagicStudioMultiViewModel$cropFaceRegion$1> continuation) {
        super(continuation);
        this.this$0 = magicStudioMultiViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object S1;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        S1 = this.this$0.S1(null, null, this);
        return S1;
    }
}
