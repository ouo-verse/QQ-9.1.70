package com.tencent.mobileqq.guild.feed.link;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.link.LinkApi", f = "LinkApi.kt", i = {0, 0}, l = {36}, m = "batchTransThirdPlatformURL", n = {"callback", "req"}, s = {"L$0", "L$1"})
/* loaded from: classes13.dex */
public final class LinkApi$batchTransThirdPlatformURL$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LinkApi this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkApi$batchTransThirdPlatformURL$1(LinkApi linkApi, Continuation<? super LinkApi$batchTransThirdPlatformURL$1> continuation) {
        super(continuation);
        this.this$0 = linkApi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, this);
    }
}
