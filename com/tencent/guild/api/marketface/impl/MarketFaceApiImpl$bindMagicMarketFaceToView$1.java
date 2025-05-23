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
@DebugMetadata(c = "com.tencent.guild.api.marketface.impl.MarketFaceApiImpl", f = "MarketFaceApiImpl.kt", i = {0, 0, 0, 0, 0}, l = {78}, m = "bindMagicMarketFaceToView", n = {"markFaceMessage", "bubbleIv", "isLastMsg", "emoticonInfo", "msgId"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0"})
/* loaded from: classes6.dex */
public final class MarketFaceApiImpl$bindMagicMarketFaceToView$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MarketFaceApiImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarketFaceApiImpl$bindMagicMarketFaceToView$1(MarketFaceApiImpl marketFaceApiImpl, Continuation<? super MarketFaceApiImpl$bindMagicMarketFaceToView$1> continuation) {
        super(continuation);
        this.this$0 = marketFaceApiImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.bindMagicMarketFaceToView(null, null, 0L, null, this);
    }
}
