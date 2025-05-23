package com.tencent.mobileqq.guild.feed.api.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.api.impl.GuildFeedLauncherHelper$makeCheckItemListener$1", f = "GuildShareToFeedApiImpl.kt", i = {0, 0}, l = {158}, m = "onCheckResult", n = {"this", "result"}, s = {"L$0", "L$1"})
/* loaded from: classes13.dex */
public final class GuildFeedLauncherHelper$makeCheckItemListener$1$onCheckResult$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GuildFeedLauncherHelper$makeCheckItemListener$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedLauncherHelper$makeCheckItemListener$1$onCheckResult$1(GuildFeedLauncherHelper$makeCheckItemListener$1 guildFeedLauncherHelper$makeCheckItemListener$1, Continuation<? super GuildFeedLauncherHelper$makeCheckItemListener$1$onCheckResult$1> continuation) {
        super(continuation);
        this.this$0 = guildFeedLauncherHelper$makeCheckItemListener$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
