package com.tencent.mobileqq.zplan.aigc.render;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.render.ZplanFilamentAIGCEditorManager", f = "ZplanFilamentAIGCEditorManager.kt", i = {}, l = {628}, m = "adjustPixel", n = {}, s = {})
/* loaded from: classes35.dex */
public final class ZplanFilamentAIGCEditorManager$adjustPixel$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ZplanFilamentAIGCEditorManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanFilamentAIGCEditorManager$adjustPixel$1(ZplanFilamentAIGCEditorManager zplanFilamentAIGCEditorManager, Continuation<? super ZplanFilamentAIGCEditorManager$adjustPixel$1> continuation) {
        super(continuation);
        this.this$0 = zplanFilamentAIGCEditorManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object G;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        G = this.this$0.G(null, 0.0d, 0.0d, 0.0d, this);
        return G;
    }
}
