package com.tencent.mobileqq.guild.temp.api.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.temp.api.impl.RandomLottieApiImpl", f = "RandomLottieApiImpl.kt", i = {0}, l = {184}, m = "checkIsLastMsg", n = {"msgSeq"}, s = {"J$0"})
/* loaded from: classes33.dex */
public final class RandomLottieApiImpl$checkIsLastMsg$1 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RandomLottieApiImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RandomLottieApiImpl$checkIsLastMsg$1(RandomLottieApiImpl randomLottieApiImpl, Continuation<? super RandomLottieApiImpl$checkIsLastMsg$1> continuation) {
        super(continuation);
        this.this$0 = randomLottieApiImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object checkIsLastMsg;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        checkIsLastMsg = this.this$0.checkIsLastMsg(null, 0L, this);
        return checkIsLastMsg;
    }
}
