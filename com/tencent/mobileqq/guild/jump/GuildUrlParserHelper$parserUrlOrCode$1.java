package com.tencent.mobileqq.guild.jump;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.jump.GuildUrlParserHelper", f = "GuildUrlParserHelper.kt", i = {0, 0, 0, 1, 1, 1}, l = {68, 72}, m = "parserUrlOrCode", n = {"this", "originalParam", "reportTask", "this", "originalParam", "reportTask"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
/* loaded from: classes13.dex */
public final class GuildUrlParserHelper$parserUrlOrCode$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GuildUrlParserHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildUrlParserHelper$parserUrlOrCode$1(GuildUrlParserHelper guildUrlParserHelper, Continuation<? super GuildUrlParserHelper$parserUrlOrCode$1> continuation) {
        super(continuation);
        this.this$0 = guildUrlParserHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.r(null, null, null, this);
    }
}
