package com.tencent.mobileqq.guild.feed.util;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.util.RichContentJsonPreProcessor", f = "RichContentJsonPreProcessor.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4}, l = {114, 119, 121, 132, 141}, m = "processMediaNodeInRichContentJson", n = {"this", "richContentJson", "option", "processControlCallback", "richContentJsonObject", "traceId", "this", "richContentJson", "option", "processControlCallback", "richContentJsonObject", "traceId", "this", "richContentJson", "option", "processControlCallback", "richContentJsonObject", "traceId", "this", "richContentJson", "option", "processControlCallback", "outputMediaList", "mediaList", "traceId", "result", "mediaWithQRCodeList"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1"})
/* loaded from: classes13.dex */
public final class RichContentJsonPreProcessor$processMediaNodeInRichContentJson$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RichContentJsonPreProcessor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RichContentJsonPreProcessor$processMediaNodeInRichContentJson$1(RichContentJsonPreProcessor richContentJsonPreProcessor, Continuation<? super RichContentJsonPreProcessor$processMediaNodeInRichContentJson$1> continuation) {
        super(continuation);
        this.this$0 = richContentJsonPreProcessor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.l(0, null, null, null, this);
    }
}
