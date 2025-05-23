package com.tencent.mobileqq.wink.explore;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.wink.explore.WinkMediaModelGenerator", f = "WinkMediaModelGenerator.kt", i = {0, 0, 0, 0, 0, 0}, l = {101}, m = "downloadAndSaveDataToWrapper", n = {"this", "context", "topic", "jsonData", "width", "height"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1"})
/* loaded from: classes21.dex */
public final class WinkMediaModelGenerator$downloadAndSaveDataToWrapper$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WinkMediaModelGenerator this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkMediaModelGenerator$downloadAndSaveDataToWrapper$1(WinkMediaModelGenerator winkMediaModelGenerator, Continuation<? super WinkMediaModelGenerator$downloadAndSaveDataToWrapper$1> continuation) {
        super(continuation);
        this.this$0 = winkMediaModelGenerator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.k(null, 0, 0, null, null, this);
    }
}
