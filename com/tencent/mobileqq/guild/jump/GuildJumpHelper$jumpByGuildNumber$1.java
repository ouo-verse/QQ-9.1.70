package com.tencent.mobileqq.guild.jump;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.jump.GuildJumpHelper", f = "GuildJumpHelper.kt", i = {0, 0, 0, 0}, l = {96}, m = "jumpByGuildNumber", n = {"this", "context", "param", "reportTask"}, s = {"L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes13.dex */
public final class GuildJumpHelper$jumpByGuildNumber$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GuildJumpHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildJumpHelper$jumpByGuildNumber$1(GuildJumpHelper guildJumpHelper, Continuation<? super GuildJumpHelper$jumpByGuildNumber$1> continuation) {
        super(continuation);
        this.this$0 = guildJumpHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object j3;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        j3 = this.this$0.j(null, null, this);
        return j3;
    }
}
