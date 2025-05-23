package com.tencent.guild.api.marketface.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.guild.api.marketface.impl.MarketFaceApiImpl", f = "MarketFaceApiImpl.kt", i = {0, 0, 0}, l = {166, 171, 173, 176}, m = "processEmoAuth", n = {"this", "context", "emoticonInfo"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes6.dex */
public final class MarketFaceApiImpl$processEmoAuth$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MarketFaceApiImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarketFaceApiImpl$processEmoAuth$1(MarketFaceApiImpl marketFaceApiImpl, Continuation<? super MarketFaceApiImpl$processEmoAuth$1> continuation) {
        super(continuation);
        this.this$0 = marketFaceApiImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object processEmoAuth;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        processEmoAuth = this.this$0.processEmoAuth(null, null, null, this);
        return processEmoAuth;
    }
}
