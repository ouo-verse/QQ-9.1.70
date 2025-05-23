package com.tencent.mobileqq.wink.lowthresholdltemplate;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.wink.lowthresholdltemplate.WinkTemplateShareRepo", f = "WinkTemplateShareDataSource.kt", i = {0, 1}, l = {74, 76}, m = "downloadAndCopyMedias", n = {"destination$iv$iv", "destination$iv$iv"}, s = {"L$0", "L$0"})
/* loaded from: classes21.dex */
public final class WinkTemplateShareRepo$downloadAndCopyMedias$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WinkTemplateShareRepo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkTemplateShareRepo$downloadAndCopyMedias$1(WinkTemplateShareRepo winkTemplateShareRepo, Continuation<? super WinkTemplateShareRepo$downloadAndCopyMedias$1> continuation) {
        super(continuation);
        this.this$0 = winkTemplateShareRepo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, this);
    }
}
