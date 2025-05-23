package com.tencent.mobileqq.guild.feed.nativepublish.publish;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativepublish.publish.PublishFeedVMDelegate", f = "PublishFeedVMDelegate.kt", i = {}, l = {119}, m = "checkContentRestrictionBeforeGenerateJson", n = {}, s = {})
/* loaded from: classes13.dex */
public final class PublishFeedVMDelegate$checkContentRestrictionBeforeGenerateJson$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PublishFeedVMDelegate this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishFeedVMDelegate$checkContentRestrictionBeforeGenerateJson$1(PublishFeedVMDelegate publishFeedVMDelegate, Continuation<? super PublishFeedVMDelegate$checkContentRestrictionBeforeGenerateJson$1> continuation) {
        super(continuation);
        this.this$0 = publishFeedVMDelegate;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object f16;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        f16 = this.this$0.f(this);
        return f16;
    }
}
