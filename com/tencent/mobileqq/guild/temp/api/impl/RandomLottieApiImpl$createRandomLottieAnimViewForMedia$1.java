package com.tencent.mobileqq.guild.temp.api.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.temp.api.impl.RandomLottieApiImpl", f = "RandomLottieApiImpl.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {84, 90}, m = "createRandomLottieAnimViewForMedia", n = {"this", "faceElement", "contact", "rootLayout", "alreadyRead", "msgSeq", "localId"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "J$0", "I$0"})
/* loaded from: classes33.dex */
public final class RandomLottieApiImpl$createRandomLottieAnimViewForMedia$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RandomLottieApiImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RandomLottieApiImpl$createRandomLottieAnimViewForMedia$1(RandomLottieApiImpl randomLottieApiImpl, Continuation<? super RandomLottieApiImpl$createRandomLottieAnimViewForMedia$1> continuation) {
        super(continuation);
        this.this$0 = randomLottieApiImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.createRandomLottieAnimViewForMedia(null, null, null, 0, false, 0L, null, null, this);
    }
}
