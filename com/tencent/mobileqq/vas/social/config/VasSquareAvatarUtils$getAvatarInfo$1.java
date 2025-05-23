package com.tencent.mobileqq.vas.social.config;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.vas.social.config.VasSquareAvatarUtils", f = "VasSquareAvatarUtils.kt", i = {1, 1}, l = {29, 42}, m = "getAvatarInfo", n = {"this", "uin"}, s = {"L$0", "J$0"})
/* loaded from: classes35.dex */
public final class VasSquareAvatarUtils$getAvatarInfo$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VasSquareAvatarUtils this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasSquareAvatarUtils$getAvatarInfo$1(VasSquareAvatarUtils vasSquareAvatarUtils, Continuation<? super VasSquareAvatarUtils$getAvatarInfo$1> continuation) {
        super(continuation);
        this.this$0 = vasSquareAvatarUtils;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getAvatarInfo(0L, false, this);
    }
}
