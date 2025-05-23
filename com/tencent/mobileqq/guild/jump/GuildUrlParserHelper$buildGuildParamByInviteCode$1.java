package com.tencent.mobileqq.guild.jump;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.jump.GuildUrlParserHelper", f = "GuildUrlParserHelper.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2}, l = {295, 305, 310}, m = "buildGuildParamByInviteCode", n = {"this", "context", "reportTask", "longUrl", "jumpGuildParam", "inviteCode", "contentId", "businessType", "this", "context", "reportTask", "longUrl", "jumpGuildParam", "inviteCode", "contentId", "businessType", "longUrl", "jumpGuildParam"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1"})
/* loaded from: classes13.dex */
public final class GuildUrlParserHelper$buildGuildParamByInviteCode$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GuildUrlParserHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildUrlParserHelper$buildGuildParamByInviteCode$1(GuildUrlParserHelper guildUrlParserHelper, Continuation<? super GuildUrlParserHelper$buildGuildParamByInviteCode$1> continuation) {
        super(continuation);
        this.this$0 = guildUrlParserHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object d16;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        d16 = this.this$0.d(null, null, null, this);
        return d16;
    }
}
