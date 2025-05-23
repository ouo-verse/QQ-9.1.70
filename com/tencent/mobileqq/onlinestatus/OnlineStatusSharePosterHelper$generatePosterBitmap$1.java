package com.tencent.mobileqq.onlinestatus;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.onlinestatus.OnlineStatusSharePosterHelper", f = "OnlineStatusSharePosterHelper.kt", i = {0}, l = {60}, m = "generatePosterBitmap", n = {ParseCommon.CONTAINER}, s = {"L$0"})
/* loaded from: classes16.dex */
public final class OnlineStatusSharePosterHelper$generatePosterBitmap$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OnlineStatusSharePosterHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnlineStatusSharePosterHelper$generatePosterBitmap$1(OnlineStatusSharePosterHelper onlineStatusSharePosterHelper, Continuation<? super OnlineStatusSharePosterHelper$generatePosterBitmap$1> continuation) {
        super(continuation);
        this.this$0 = onlineStatusSharePosterHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, null, null, null, false, null, this);
    }
}
