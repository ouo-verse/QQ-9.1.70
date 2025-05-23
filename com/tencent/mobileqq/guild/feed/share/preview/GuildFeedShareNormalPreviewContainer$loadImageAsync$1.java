package com.tencent.mobileqq.guild.feed.share.preview;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.share.preview.GuildFeedShareNormalPreviewContainer", f = "GuildFeedShareNormalPreviewContainer.kt", i = {0}, l = {512}, m = "loadImageAsync", n = {"imageView"}, s = {"L$0"})
/* loaded from: classes13.dex */
public final class GuildFeedShareNormalPreviewContainer$loadImageAsync$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GuildFeedShareNormalPreviewContainer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedShareNormalPreviewContainer$loadImageAsync$1(GuildFeedShareNormalPreviewContainer guildFeedShareNormalPreviewContainer, Continuation<? super GuildFeedShareNormalPreviewContainer$loadImageAsync$1> continuation) {
        super(continuation);
        this.this$0 = guildFeedShareNormalPreviewContainer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object z16;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        z16 = this.this$0.z(null, null, this);
        return z16;
    }
}
