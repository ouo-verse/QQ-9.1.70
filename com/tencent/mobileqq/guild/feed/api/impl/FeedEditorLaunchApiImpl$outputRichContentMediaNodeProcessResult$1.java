package com.tencent.mobileqq.guild.feed.api.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.api.impl.FeedEditorLaunchApiImpl", f = "FeedEditorLaunchApiImpl.kt", i = {0}, l = {327}, m = "outputRichContentMediaNodeProcessResult", n = {"option"}, s = {"L$0"})
/* loaded from: classes13.dex */
public final class FeedEditorLaunchApiImpl$outputRichContentMediaNodeProcessResult$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FeedEditorLaunchApiImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedEditorLaunchApiImpl$outputRichContentMediaNodeProcessResult$1(FeedEditorLaunchApiImpl feedEditorLaunchApiImpl, Continuation<? super FeedEditorLaunchApiImpl$outputRichContentMediaNodeProcessResult$1> continuation) {
        super(continuation);
        this.this$0 = feedEditorLaunchApiImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object v3;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        v3 = this.this$0.v(null, 0, null, null, null, this);
        return v3;
    }
}
