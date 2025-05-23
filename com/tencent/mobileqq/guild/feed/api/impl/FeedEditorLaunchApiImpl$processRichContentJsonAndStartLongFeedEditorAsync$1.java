package com.tencent.mobileqq.guild.feed.api.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.api.impl.FeedEditorLaunchApiImpl", f = "FeedEditorLaunchApiImpl.kt", i = {0, 0, 0, 0, 1}, l = {643, 646}, m = "processRichContentJsonAndStartLongFeedEditorAsync", n = {"ignition", "finalRichContentJson", "mediaList", "start$iv", "start$iv"}, s = {"L$0", "L$1", "L$2", "J$0", "J$0"})
/* loaded from: classes13.dex */
public final class FeedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FeedEditorLaunchApiImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$1(FeedEditorLaunchApiImpl feedEditorLaunchApiImpl, Continuation<? super FeedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$1> continuation) {
        super(continuation);
        this.this$0 = feedEditorLaunchApiImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object F;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        F = this.this$0.F(null, null, null, null, this);
        return F;
    }
}
