package com.tencent.mobileqq.guild.discoveryv2.share.picture;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.discoveryv2.share.picture.GuildSearchLLMChatPictureGenerator", f = "GuildSearchLLMChatPictureGenerator.kt", i = {0}, l = {76}, m = "bindRecyclerView", n = {"recyclerView"}, s = {"L$0"})
/* loaded from: classes13.dex */
public final class GuildSearchLLMChatPictureGenerator$bindRecyclerView$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GuildSearchLLMChatPictureGenerator this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildSearchLLMChatPictureGenerator$bindRecyclerView$1(GuildSearchLLMChatPictureGenerator guildSearchLLMChatPictureGenerator, Continuation<? super GuildSearchLLMChatPictureGenerator$bindRecyclerView$1> continuation) {
        super(continuation);
        this.this$0 = guildSearchLLMChatPictureGenerator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object h16;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        h16 = this.this$0.h(null, null, this);
        return h16;
    }
}
