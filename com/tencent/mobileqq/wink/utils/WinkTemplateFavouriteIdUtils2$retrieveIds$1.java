package com.tencent.mobileqq.wink.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.wink.utils.WinkTemplateFavouriteIdUtils2", f = "WinkTemplateFavouriteIdUtils2.kt", i = {1}, l = {49, 62}, m = "retrieveIds", n = {"this"}, s = {"L$0"})
/* loaded from: classes21.dex */
public final class WinkTemplateFavouriteIdUtils2$retrieveIds$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WinkTemplateFavouriteIdUtils2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkTemplateFavouriteIdUtils2$retrieveIds$1(WinkTemplateFavouriteIdUtils2 winkTemplateFavouriteIdUtils2, Continuation<? super WinkTemplateFavouriteIdUtils2$retrieveIds$1> continuation) {
        super(continuation);
        this.this$0 = winkTemplateFavouriteIdUtils2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object j3;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        j3 = this.this$0.j(this);
        return j3;
    }
}
