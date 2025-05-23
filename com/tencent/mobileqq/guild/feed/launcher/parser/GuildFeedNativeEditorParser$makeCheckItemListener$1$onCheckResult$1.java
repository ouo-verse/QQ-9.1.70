package com.tencent.mobileqq.guild.feed.launcher.parser;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.launcher.parser.GuildFeedNativeEditorParser$makeCheckItemListener$1", f = "GuildFeedNativeEditorParser.kt", i = {}, l = {112}, m = "onCheckResult", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildFeedNativeEditorParser$makeCheckItemListener$1$onCheckResult$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GuildFeedNativeEditorParser$makeCheckItemListener$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedNativeEditorParser$makeCheckItemListener$1$onCheckResult$1(GuildFeedNativeEditorParser$makeCheckItemListener$1 guildFeedNativeEditorParser$makeCheckItemListener$1, Continuation<? super GuildFeedNativeEditorParser$makeCheckItemListener$1$onCheckResult$1> continuation) {
        super(continuation);
        this.this$0 = guildFeedNativeEditorParser$makeCheckItemListener$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
