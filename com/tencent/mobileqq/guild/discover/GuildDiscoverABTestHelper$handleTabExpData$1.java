package com.tencent.mobileqq.guild.discover;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.discover.GuildDiscoverABTestHelper", f = "GuildDiscoverABTestHelper.kt", i = {0, 0}, l = {275}, m = "handleTabExpData", n = {"this", "source"}, s = {"L$0", "L$1"})
/* loaded from: classes13.dex */
public final class GuildDiscoverABTestHelper$handleTabExpData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GuildDiscoverABTestHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildDiscoverABTestHelper$handleTabExpData$1(GuildDiscoverABTestHelper guildDiscoverABTestHelper, Continuation<? super GuildDiscoverABTestHelper$handleTabExpData$1> continuation) {
        super(continuation);
        this.this$0 = guildDiscoverABTestHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object A;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        A = this.this$0.A(null, null, this);
        return A;
    }
}
