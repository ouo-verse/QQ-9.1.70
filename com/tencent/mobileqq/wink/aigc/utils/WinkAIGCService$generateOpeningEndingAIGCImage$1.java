package com.tencent.mobileqq.wink.aigc.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.wink.aigc.utils.WinkAIGCService", f = "WinkAIGCService.kt", i = {}, l = {68}, m = "generateOpeningEndingAIGCImage", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkAIGCService$generateOpeningEndingAIGCImage$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WinkAIGCService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkAIGCService$generateOpeningEndingAIGCImage$1(WinkAIGCService winkAIGCService, Continuation<? super WinkAIGCService$generateOpeningEndingAIGCImage$1> continuation) {
        super(continuation);
        this.this$0 = winkAIGCService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, null, null, this);
    }
}
