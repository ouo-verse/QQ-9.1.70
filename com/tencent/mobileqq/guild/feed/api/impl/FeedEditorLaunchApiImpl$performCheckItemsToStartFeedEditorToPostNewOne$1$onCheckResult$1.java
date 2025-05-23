package com.tencent.mobileqq.guild.feed.api.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.api.impl.FeedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1", f = "FeedEditorLaunchApiImpl.kt", i = {0}, l = {97, 100, 104}, m = "onCheckResult", n = {"this"}, s = {"L$0"})
/* loaded from: classes13.dex */
public final class FeedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1$onCheckResult$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FeedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1$onCheckResult$1(FeedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1 feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1, Continuation<? super FeedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1$onCheckResult$1> continuation) {
        super(continuation);
        this.this$0 = feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
