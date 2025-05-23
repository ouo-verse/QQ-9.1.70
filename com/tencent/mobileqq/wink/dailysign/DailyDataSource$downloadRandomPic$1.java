package com.tencent.mobileqq.wink.dailysign;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.wink.dailysign.DailyDataSource", f = "DailyDataSource.kt", i = {0}, l = {174}, m = "downloadRandomPic", n = {"finalRandomIndex"}, s = {"I$0"})
/* loaded from: classes21.dex */
public final class DailyDataSource$downloadRandomPic$1 extends ContinuationImpl {
    int I$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DailyDataSource this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DailyDataSource$downloadRandomPic$1(DailyDataSource dailyDataSource, Continuation<? super DailyDataSource$downloadRandomPic$1> continuation) {
        super(continuation);
        this.this$0 = dailyDataSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(null, 0, this);
    }
}
