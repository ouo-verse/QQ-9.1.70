package com.tencent.mobileqq.zplan.meme.frameanim.manager.dynamic;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.zplan.meme.frameanim.manager.dynamic.DynamicBusinessScene", f = "DynamicBusinessScene.kt", i = {}, l = {80, 82}, m = "fetchAvatarInfo$suspendImpl", n = {}, s = {})
/* loaded from: classes34.dex */
public final class DynamicBusinessScene$fetchAvatarInfo$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DynamicBusinessScene this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DynamicBusinessScene$fetchAvatarInfo$1(DynamicBusinessScene dynamicBusinessScene, Continuation<? super DynamicBusinessScene$fetchAvatarInfo$1> continuation) {
        super(continuation);
        this.this$0 = dynamicBusinessScene;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DynamicBusinessScene.fetchAvatarInfo$suspendImpl(this.this$0, null, this);
    }
}
