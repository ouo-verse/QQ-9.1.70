package com.tencent.mobileqq.guild.feed.morepanel.handler;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.morepanel.handler.GuildFeedShareToWXHelper", f = "GuildFeedShareToWXHelper.kt", i = {}, l = {235}, m = "checkSmallImage", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildFeedShareToWXHelper$checkSmallImage$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GuildFeedShareToWXHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedShareToWXHelper$checkSmallImage$1(GuildFeedShareToWXHelper guildFeedShareToWXHelper, Continuation<? super GuildFeedShareToWXHelper$checkSmallImage$1> continuation) {
        super(continuation);
        this.this$0 = guildFeedShareToWXHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object g16;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        g16 = this.this$0.g(0, 0, null, this);
        return g16;
    }
}
