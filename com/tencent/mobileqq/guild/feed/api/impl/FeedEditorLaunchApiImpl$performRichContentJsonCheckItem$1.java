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
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.api.impl.FeedEditorLaunchApiImpl", f = "FeedEditorLaunchApiImpl.kt", i = {1, 1}, l = {260, 275, 284}, m = "performRichContentJsonCheckItem", n = {"checkItemListener", "traceId"}, s = {"L$0", "I$0"})
/* loaded from: classes13.dex */
public final class FeedEditorLaunchApiImpl$performRichContentJsonCheckItem$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FeedEditorLaunchApiImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedEditorLaunchApiImpl$performRichContentJsonCheckItem$1(FeedEditorLaunchApiImpl feedEditorLaunchApiImpl, Continuation<? super FeedEditorLaunchApiImpl$performRichContentJsonCheckItem$1> continuation) {
        super(continuation);
        this.this$0 = feedEditorLaunchApiImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object A;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        A = this.this$0.A(0, null, null, null, null, this);
        return A;
    }
}
