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
@DebugMetadata(c = "com.tencent.guild.api.marketface.impl.MarketFaceApiImpl", f = "MarketFaceApiImpl.kt", i = {0, 0}, l = {52}, m = "fetchMarketFaceInfoSuspend", n = {"this", "emoticonInfo"}, s = {"L$0", "L$1"})
/* loaded from: classes6.dex */
public final class MarketFaceApiImpl$fetchMarketFaceInfoSuspend$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MarketFaceApiImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarketFaceApiImpl$fetchMarketFaceInfoSuspend$1(MarketFaceApiImpl marketFaceApiImpl, Continuation<? super MarketFaceApiImpl$fetchMarketFaceInfoSuspend$1> continuation) {
        super(continuation);
        this.this$0 = marketFaceApiImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetchMarketFaceInfoSuspend(null, this);
    }
}
