package com.tencent.aelight.camera.ae.flashshow.ui;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialManager", f = "AEFlashShowMaterialManager.kt", i = {0, 0, 1, 1}, l = {com.tencent.luggage.wxa.q2.d.CTRL_INDEX, 888}, m = "removeMaterialFromFavoriteToServer", n = {"this", "info", "info", "result"}, s = {"L$0", "L$1", "L$0", "Z$0"})
/* loaded from: classes32.dex */
public final class AEFlashShowMaterialManager$removeMaterialFromFavoriteToServer$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AEFlashShowMaterialManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AEFlashShowMaterialManager$removeMaterialFromFavoriteToServer$1(AEFlashShowMaterialManager aEFlashShowMaterialManager, Continuation<? super AEFlashShowMaterialManager$removeMaterialFromFavoriteToServer$1> continuation) {
        super(continuation);
        this.this$0 = aEFlashShowMaterialManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f0(null, this);
    }
}
