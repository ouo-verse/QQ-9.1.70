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
@DebugMetadata(c = "com.tencent.guild.api.marketface.impl.MarketFaceApiImpl", f = "MarketFaceApiImpl.kt", i = {0}, l = {96}, m = "checkIsLastMsg", n = {"msgId"}, s = {"J$0"})
/* loaded from: classes6.dex */
public final class MarketFaceApiImpl$checkIsLastMsg$1 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MarketFaceApiImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarketFaceApiImpl$checkIsLastMsg$1(MarketFaceApiImpl marketFaceApiImpl, Continuation<? super MarketFaceApiImpl$checkIsLastMsg$1> continuation) {
        super(continuation);
        this.this$0 = marketFaceApiImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object checkIsLastMsg;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        checkIsLastMsg = this.this$0.checkIsLastMsg(null, 0L, this);
        return checkIsLastMsg;
    }
}
