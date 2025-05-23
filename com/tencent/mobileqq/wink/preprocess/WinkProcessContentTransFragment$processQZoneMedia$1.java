package com.tencent.mobileqq.wink.preprocess;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.wink.preprocess.WinkProcessContentTransFragment", f = "WinkProcessContentTransFragment.kt", i = {0, 0}, l = {221}, m = "processQZoneMedia", n = {"this", "mediaPaths"}, s = {"L$0", "L$1"})
/* loaded from: classes21.dex */
public final class WinkProcessContentTransFragment$processQZoneMedia$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WinkProcessContentTransFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkProcessContentTransFragment$processQZoneMedia$1(WinkProcessContentTransFragment winkProcessContentTransFragment, Continuation<? super WinkProcessContentTransFragment$processQZoneMedia$1> continuation) {
        super(continuation);
        this.this$0 = winkProcessContentTransFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object Kh;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Kh = this.this$0.Kh(null, this);
        return Kh;
    }
}
