package com.tencent.mobileqq.guild.share.util;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.share.util.GuildWXShareUtils", f = "GuildWXShareUtils.kt", i = {0, 0}, l = {238}, m = "generateGuildChannelShareBitmap", n = {"this", "binding"}, s = {"L$0", "L$1"})
/* loaded from: classes14.dex */
public final class GuildWXShareUtils$generateGuildChannelShareBitmap$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GuildWXShareUtils this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildWXShareUtils$generateGuildChannelShareBitmap$1(GuildWXShareUtils guildWXShareUtils, Continuation<? super GuildWXShareUtils$generateGuildChannelShareBitmap$1> continuation) {
        super(continuation);
        this.this$0 = guildWXShareUtils;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object i3;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        i3 = this.this$0.i(null, null, null, this);
        return i3;
    }
}
