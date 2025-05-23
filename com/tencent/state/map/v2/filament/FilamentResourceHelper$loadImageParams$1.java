package com.tencent.state.map.v2.filament;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0086@"}, d2 = {"Lcom/tencent/state/map/v2/filament/ImageResource;", "image", "Lkotlin/coroutines/Continuation;", "Lcom/tencent/filament/zplan/scene/square/SquareImageData;", "continuation", "", "loadImageParams"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.state.map.v2.filament.FilamentResourceHelper", f = "FilamentResourceHelper.kt", i = {0}, l = {41}, m = "loadImageParams", n = {"imagePath"}, s = {"L$0"})
/* loaded from: classes34.dex */
public final class FilamentResourceHelper$loadImageParams$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FilamentResourceHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilamentResourceHelper$loadImageParams$1(FilamentResourceHelper filamentResourceHelper, Continuation continuation) {
        super(continuation);
        this.this$0 = filamentResourceHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadImageParams(null, this);
    }
}
