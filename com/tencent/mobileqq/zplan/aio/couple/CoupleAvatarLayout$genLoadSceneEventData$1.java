package com.tencent.mobileqq.zplan.aio.couple;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarLayout", f = "CoupleAvatarLayout.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2}, l = {500, 502, 507}, m = "genLoadSceneEventData", n = {"this", "leftAvatarInfo", WadlProxyConsts.SCENE_ID, "this", "leftAvatarInfo", WadlProxyConsts.SCENE_ID, "this", "leftAvatarInfo", WadlProxyConsts.SCENE_ID}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "I$0", "L$0", "L$1", "I$0"})
/* loaded from: classes35.dex */
public final class CoupleAvatarLayout$genLoadSceneEventData$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CoupleAvatarLayout this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoupleAvatarLayout$genLoadSceneEventData$1(CoupleAvatarLayout coupleAvatarLayout, Continuation<? super CoupleAvatarLayout$genLoadSceneEventData$1> continuation) {
        super(continuation);
        this.this$0 = coupleAvatarLayout;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object K;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        K = this.this$0.K(0, this);
        return K;
    }
}
