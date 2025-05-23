package com.tencent.mobileqq.wink.publish;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.wink.publish.OneClickPublishingHelper", f = "OneClickPublishingHelper.kt", i = {0}, l = {501}, m = "processQZoneMedia", n = {"mediaPaths"}, s = {"L$0"})
/* loaded from: classes21.dex */
public final class OneClickPublishingHelper$processQZoneMedia$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OneClickPublishingHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OneClickPublishingHelper$processQZoneMedia$1(OneClickPublishingHelper oneClickPublishingHelper, Continuation<? super OneClickPublishingHelper$processQZoneMedia$1> continuation) {
        super(continuation);
        this.this$0 = oneClickPublishingHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object x16;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        x16 = this.this$0.x(null, this);
        return x16;
    }
}
