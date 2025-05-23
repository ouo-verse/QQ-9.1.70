package com.tencent.mobileqq.wink.dailysign;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.wink.dailysign.DailyDataSource", f = "DailyDataSource.kt", i = {}, l = {43, 44}, m = "findAndDownloadMaterial", n = {}, s = {})
/* loaded from: classes21.dex */
public final class DailyDataSource$findAndDownloadMaterial$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DailyDataSource this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DailyDataSource$findAndDownloadMaterial$1(DailyDataSource dailyDataSource, Continuation<? super DailyDataSource$findAndDownloadMaterial$1> continuation) {
        super(continuation);
        this.this$0 = dailyDataSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object g16;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        g16 = this.this$0.g(null, this);
        return g16;
    }
}
