package com.tencent.mobileqq.guild.discoveryv2.share.oldpicture;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.discoveryv2.share.oldpicture.GuildSearchLLMChatPictureOldGenerator", f = "GuildSearchLLMChatPictureOldGenerator.kt", i = {0}, l = {65}, m = "bindRecyclerView", n = {"recyclerView"}, s = {"L$0"})
/* loaded from: classes13.dex */
public final class GuildSearchLLMChatPictureOldGenerator$bindRecyclerView$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GuildSearchLLMChatPictureOldGenerator this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildSearchLLMChatPictureOldGenerator$bindRecyclerView$1(GuildSearchLLMChatPictureOldGenerator guildSearchLLMChatPictureOldGenerator, Continuation<? super GuildSearchLLMChatPictureOldGenerator$bindRecyclerView$1> continuation) {
        super(continuation);
        this.this$0 = guildSearchLLMChatPictureOldGenerator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object d16;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        d16 = this.this$0.d(null, null, this);
        return d16;
    }
}
