package com.tencent.mobileqq.guild.feed.util;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.util.RichContentJsonPreProcessor", f = "RichContentJsonPreProcessor.kt", i = {0}, l = {365}, m = "execDownloadAndTransformImageJSONArray", n = {"images"}, s = {"L$0"})
/* loaded from: classes13.dex */
public final class RichContentJsonPreProcessor$execDownloadAndTransformImageJSONArray$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RichContentJsonPreProcessor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RichContentJsonPreProcessor$execDownloadAndTransformImageJSONArray$1(RichContentJsonPreProcessor richContentJsonPreProcessor, Continuation<? super RichContentJsonPreProcessor$execDownloadAndTransformImageJSONArray$1> continuation) {
        super(continuation);
        this.this$0 = richContentJsonPreProcessor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object g16;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        g16 = this.this$0.g(null, this);
        return g16;
    }
}
