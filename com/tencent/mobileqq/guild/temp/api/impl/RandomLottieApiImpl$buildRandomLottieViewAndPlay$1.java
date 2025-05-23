package com.tencent.mobileqq.guild.temp.api.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.temp.api.impl.RandomLottieApiImpl", f = "RandomLottieApiImpl.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {145}, m = "buildRandomLottieViewAndPlay", n = {"this", "faceElement", "rootLayout", "lottieView", "isLastMsg", "localId", "alreadyRead", "msgSeq"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "Z$0", "J$0"})
/* loaded from: classes33.dex */
public final class RandomLottieApiImpl$buildRandomLottieViewAndPlay$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RandomLottieApiImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RandomLottieApiImpl$buildRandomLottieViewAndPlay$1(RandomLottieApiImpl randomLottieApiImpl, Continuation<? super RandomLottieApiImpl$buildRandomLottieViewAndPlay$1> continuation) {
        super(continuation);
        this.this$0 = randomLottieApiImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object buildRandomLottieViewAndPlay;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        buildRandomLottieViewAndPlay = this.this$0.buildRandomLottieViewAndPlay(null, 0, null, false, 0L, null, this);
        return buildRandomLottieViewAndPlay;
    }
}
