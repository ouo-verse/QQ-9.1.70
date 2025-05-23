package com.tencent.mobileqq.wink.preview.datasource;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.wink.preview.datasource.WinkBasePreviewShareDataSource", f = "WinkBasePreviewShareDataSource.kt", i = {1}, l = {60, 61}, m = "downloadMaterial$suspendImpl", n = {"mate"}, s = {"L$0"})
/* loaded from: classes21.dex */
public final class WinkBasePreviewShareDataSource$downloadMaterial$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WinkBasePreviewShareDataSource this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkBasePreviewShareDataSource$downloadMaterial$1(WinkBasePreviewShareDataSource winkBasePreviewShareDataSource, Continuation<? super WinkBasePreviewShareDataSource$downloadMaterial$1> continuation) {
        super(continuation);
        this.this$0 = winkBasePreviewShareDataSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return WinkBasePreviewShareDataSource.i(this.this$0, this);
    }
}
