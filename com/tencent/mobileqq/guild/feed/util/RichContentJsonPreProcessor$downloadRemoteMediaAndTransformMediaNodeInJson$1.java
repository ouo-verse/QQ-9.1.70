package com.tencent.mobileqq.guild.feed.util;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.util.RichContentJsonPreProcessor", f = "RichContentJsonPreProcessor.kt", i = {0, 0, 0, 0, 0}, l = {220}, m = "downloadRemoteMediaAndTransformMediaNodeInJson", n = {"this", "richContentJsonObject", "imageArray", "traceId", "start$iv"}, s = {"L$0", "L$1", "L$2", "I$0", "J$0"})
/* loaded from: classes13.dex */
public final class RichContentJsonPreProcessor$downloadRemoteMediaAndTransformMediaNodeInJson$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RichContentJsonPreProcessor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RichContentJsonPreProcessor$downloadRemoteMediaAndTransformMediaNodeInJson$1(RichContentJsonPreProcessor richContentJsonPreProcessor, Continuation<? super RichContentJsonPreProcessor$downloadRemoteMediaAndTransformMediaNodeInJson$1> continuation) {
        super(continuation);
        this.this$0 = richContentJsonPreProcessor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object e16;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        e16 = this.this$0.e(null, 0, this);
        return e16;
    }
}
