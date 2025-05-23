package com.tencent.qqnt.aio.icebreak;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.qqnt.aio.icebreak.IceBreakingWelcomeWording", f = "IceBreakingWelcomeWording.kt", i = {0, 0, 0, 0, 1, 1}, l = {119, 143}, m = "loadPictures", n = {"this", "md5", "prevPicturesDir", "picturesDir", "prevPicturesDir", "picturesDir"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1"})
/* loaded from: classes34.dex */
public final class IceBreakingWelcomeWording$loadPictures$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IceBreakingWelcomeWording this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IceBreakingWelcomeWording$loadPictures$1(IceBreakingWelcomeWording iceBreakingWelcomeWording, Continuation<? super IceBreakingWelcomeWording$loadPictures$1> continuation) {
        super(continuation);
        this.this$0 = iceBreakingWelcomeWording;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object g16;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        g16 = this.this$0.g(null, null, this);
        return g16;
    }
}
