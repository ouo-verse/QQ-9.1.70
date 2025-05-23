package com.tencent.mobileqq.wink.preprocess;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.wink.preprocess.WinkMaterialResourceLoader", f = "WinkMaterialResourceLoader.kt", i = {0}, l = {123, 124}, m = "prepareResourceAndMaterial", n = {"downloadTemplateDeferred"}, s = {"L$0"})
/* loaded from: classes21.dex */
public final class WinkMaterialResourceLoader$prepareResourceAndMaterial$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WinkMaterialResourceLoader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkMaterialResourceLoader$prepareResourceAndMaterial$1(WinkMaterialResourceLoader winkMaterialResourceLoader, Continuation<? super WinkMaterialResourceLoader$prepareResourceAndMaterial$1> continuation) {
        super(continuation);
        this.this$0 = winkMaterialResourceLoader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i(null, null, this);
    }
}
