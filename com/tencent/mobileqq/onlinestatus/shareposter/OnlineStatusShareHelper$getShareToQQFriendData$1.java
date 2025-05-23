package com.tencent.mobileqq.onlinestatus.shareposter;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.onlinestatus.shareposter.OnlineStatusShareHelper", f = "OnlineStatusShareHelper.kt", i = {0, 0}, l = {533}, m = "getShareToQQFriendData", n = {"filePath", "useBottomHalfPreview"}, s = {"L$0", "Z$0"})
/* loaded from: classes16.dex */
public final class OnlineStatusShareHelper$getShareToQQFriendData$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OnlineStatusShareHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnlineStatusShareHelper$getShareToQQFriendData$1(OnlineStatusShareHelper onlineStatusShareHelper, Continuation<? super OnlineStatusShareHelper$getShareToQQFriendData$1> continuation) {
        super(continuation);
        this.this$0 = onlineStatusShareHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object H;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        H = this.this$0.H(null, false, this);
        return H;
    }
}
