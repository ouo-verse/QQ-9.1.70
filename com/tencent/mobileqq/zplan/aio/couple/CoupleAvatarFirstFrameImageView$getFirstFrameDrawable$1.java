package com.tencent.mobileqq.zplan.aio.couple;

import cooperation.qzone.panorama.util.PanoramaConfig;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarFirstFrameImageView", f = "CoupleAvatarFirstFrameImageView.kt", i = {0, 0, 0}, l = {63}, m = "getFirstFrameDrawable", n = {"this", "option", PanoramaConfig.KEY_CURRENT_UIN}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes35.dex */
public final class CoupleAvatarFirstFrameImageView$getFirstFrameDrawable$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CoupleAvatarFirstFrameImageView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoupleAvatarFirstFrameImageView$getFirstFrameDrawable$1(CoupleAvatarFirstFrameImageView coupleAvatarFirstFrameImageView, Continuation<? super CoupleAvatarFirstFrameImageView$getFirstFrameDrawable$1> continuation) {
        super(continuation);
        this.this$0 = coupleAvatarFirstFrameImageView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(this);
    }
}
