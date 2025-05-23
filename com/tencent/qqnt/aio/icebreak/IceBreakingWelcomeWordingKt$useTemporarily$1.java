package com.tencent.qqnt.aio.icebreak;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.qqnt.aio.icebreak.IceBreakingWelcomeWordingKt", f = "IceBreakingWelcomeWording.kt", i = {0, 0}, l = {243}, m = "useTemporarily", n = {"savePath", "block"}, s = {"L$0", "L$1"})
/* loaded from: classes34.dex */
public final class IceBreakingWelcomeWordingKt$useTemporarily$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IceBreakingWelcomeWordingKt$useTemporarily$1(Continuation<? super IceBreakingWelcomeWordingKt$useTemporarily$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c16;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        c16 = IceBreakingWelcomeWordingKt.c(null, null, null, null, this);
        return c16;
    }
}
