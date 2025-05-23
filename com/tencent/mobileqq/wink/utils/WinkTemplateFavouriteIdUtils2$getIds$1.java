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
@DebugMetadata(c = "com.tencent.mobileqq.wink.utils.WinkTemplateFavouriteIdUtils2", f = "WinkTemplateFavouriteIdUtils2.kt", i = {}, l = {29}, m = "getIds", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkTemplateFavouriteIdUtils2$getIds$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WinkTemplateFavouriteIdUtils2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkTemplateFavouriteIdUtils2$getIds$1(WinkTemplateFavouriteIdUtils2 winkTemplateFavouriteIdUtils2, Continuation<? super WinkTemplateFavouriteIdUtils2$getIds$1> continuation) {
        super(continuation);
        this.this$0 = winkTemplateFavouriteIdUtils2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.h(this);
    }
}
