package com.tencent.mobileqq.wink.editor.aielimination;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.wink.editor.aielimination.WinkAiEliminationViewModel", f = "WinkAiEliminationViewModel.kt", i = {0, 0, 0}, l = {523}, m = "downloadByUrl", n = {"this", "targetUrl", "shareImageSavePath"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes21.dex */
public final class WinkAiEliminationViewModel$downloadByUrl$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WinkAiEliminationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkAiEliminationViewModel$downloadByUrl$1(WinkAiEliminationViewModel winkAiEliminationViewModel, Continuation<? super WinkAiEliminationViewModel$downloadByUrl$1> continuation) {
        super(continuation);
        this.this$0 = winkAiEliminationViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object X1;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        X1 = this.this$0.X1(null, this);
        return X1;
    }
}
