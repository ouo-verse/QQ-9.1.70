package com.tencent.mobileqq.guild.share;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.share.FetchGuildArkInfo", f = "FetchGuildArkInfo.kt", i = {0}, l = {97}, m = "fetchArk", n = {"this"}, s = {"L$0"})
/* loaded from: classes14.dex */
public final class FetchGuildArkInfo$fetchArk$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FetchGuildArkInfo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FetchGuildArkInfo$fetchArk$1(FetchGuildArkInfo fetchGuildArkInfo, Continuation<? super FetchGuildArkInfo$fetchArk$1> continuation) {
        super(continuation);
        this.this$0 = fetchGuildArkInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(this);
    }
}
