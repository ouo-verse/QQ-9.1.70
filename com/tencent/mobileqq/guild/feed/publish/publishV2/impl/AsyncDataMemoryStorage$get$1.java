package com.tencent.mobileqq.guild.feed.publish.publishV2.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.publish.publishV2.impl.AsyncDataMemoryStorage", f = "AsyncDataMemoryStorage.kt", i = {0, 0, 0}, l = {29, 29}, m = "get", n = {"this", "key", "refresh"}, s = {"L$0", "L$1", "Z$0"})
/* loaded from: classes13.dex */
public final class AsyncDataMemoryStorage$get$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AsyncDataMemoryStorage<K, V> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsyncDataMemoryStorage$get$1(AsyncDataMemoryStorage<K, V> asyncDataMemoryStorage, Continuation<? super AsyncDataMemoryStorage$get$1> continuation) {
        super(continuation);
        this.this$0 = asyncDataMemoryStorage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, false, this);
    }
}
