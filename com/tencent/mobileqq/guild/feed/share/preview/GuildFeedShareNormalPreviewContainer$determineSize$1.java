package com.tencent.mobileqq.guild.feed.share.preview;

import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.share.preview.GuildFeedShareNormalPreviewContainer", f = "GuildFeedShareNormalPreviewContainer.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 2}, l = {200, 201, 225}, m = "determineSize", n = {"this", NodeProps.MIN_HEIGHT, NodeProps.MAX_HEIGHT, "this", NodeProps.MIN_HEIGHT, NodeProps.MAX_HEIGHT, "this", NodeProps.MIN_HEIGHT, NodeProps.MAX_HEIGHT, "shouldShowMore"}, s = {"L$0", "I$0", "I$1", "L$0", "I$0", "I$1", "L$0", "I$0", "I$1", "I$2"})
/* loaded from: classes13.dex */
public final class GuildFeedShareNormalPreviewContainer$determineSize$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GuildFeedShareNormalPreviewContainer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedShareNormalPreviewContainer$determineSize$1(GuildFeedShareNormalPreviewContainer guildFeedShareNormalPreviewContainer, Continuation<? super GuildFeedShareNormalPreviewContainer$determineSize$1> continuation) {
        super(continuation);
        this.this$0 = guildFeedShareNormalPreviewContainer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.x(this);
    }
}
