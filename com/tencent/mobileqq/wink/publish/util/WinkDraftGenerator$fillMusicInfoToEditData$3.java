package com.tencent.mobileqq.wink.publish.util;

import com.tencent.luggage.wxa.yf.e0;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.wink.publish.util.WinkDraftGenerator", f = "WinkDraftGenerator.kt", i = {0, 0}, l = {e0.CTRL_INDEX}, m = "fillMusicInfoToEditData", n = {"winkEditDataWrapper", "firstRecommendMusic"}, s = {"L$0", "L$1"})
/* loaded from: classes21.dex */
public final class WinkDraftGenerator$fillMusicInfoToEditData$3 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WinkDraftGenerator this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkDraftGenerator$fillMusicInfoToEditData$3(WinkDraftGenerator winkDraftGenerator, Continuation<? super WinkDraftGenerator$fillMusicInfoToEditData$3> continuation) {
        super(continuation);
        this.this$0 = winkDraftGenerator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object g16;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        g16 = this.this$0.g(null, null, this);
        return g16;
    }
}
