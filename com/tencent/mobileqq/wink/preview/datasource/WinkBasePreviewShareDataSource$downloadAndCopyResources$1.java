package com.tencent.mobileqq.wink.preview.datasource;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.wink.preview.datasource.WinkBasePreviewShareDataSource", f = "WinkBasePreviewShareDataSource.kt", i = {0, 0, 1, 1}, l = {121, 124}, m = "downloadAndCopyResources$suspendImpl", n = {"$this", "destination$iv$iv", "$this", "destination$iv$iv"}, s = {"L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes21.dex */
public final class WinkBasePreviewShareDataSource$downloadAndCopyResources$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WinkBasePreviewShareDataSource this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkBasePreviewShareDataSource$downloadAndCopyResources$1(WinkBasePreviewShareDataSource winkBasePreviewShareDataSource, Continuation<? super WinkBasePreviewShareDataSource$downloadAndCopyResources$1> continuation) {
        super(continuation);
        this.this$0 = winkBasePreviewShareDataSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return WinkBasePreviewShareDataSource.f(this.this$0, null, 0, this);
    }
}
