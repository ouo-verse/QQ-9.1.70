package com.tencent.mobileqq.guild.aisearch.models;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.aisearch.models.AIChatRepository", f = "AIChatRepository.kt", i = {0, 0, 0}, l = {220}, m = "requestSearch-BWLJW6A", n = {"searchText", "modelType", "sessionId"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes12.dex */
public final class AIChatRepository$requestSearch$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIChatRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIChatRepository$requestSearch$1(AIChatRepository aIChatRepository, Continuation<? super AIChatRepository$requestSearch$1> continuation) {
        super(continuation);
        this.this$0 = aIChatRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object s16;
        Object coroutine_suspended;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        s16 = this.this$0.s(null, null, null, this);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (s16 == coroutine_suspended) {
            return s16;
        }
        return Result.m475boximpl(s16);
    }
}
