package com.tencent.mobileqq.zplan.aio.couple;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarViewController", f = "CoupleAvatarViewController.kt", i = {0, 0, 0}, l = {198, 210}, m = "changeScene", n = {"this", "sceneConfig", "needPush"}, s = {"L$0", "L$1", "Z$0"})
/* loaded from: classes35.dex */
public final class CoupleAvatarViewController$changeScene$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CoupleAvatarViewController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoupleAvatarViewController$changeScene$1(CoupleAvatarViewController coupleAvatarViewController, Continuation<? super CoupleAvatarViewController$changeScene$1> continuation) {
        super(continuation);
        this.this$0 = coupleAvatarViewController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, false, this);
    }
}
