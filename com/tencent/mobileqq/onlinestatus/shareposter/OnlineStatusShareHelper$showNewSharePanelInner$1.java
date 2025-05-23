package com.tencent.mobileqq.onlinestatus.shareposter;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.onlinestatus.shareposter.OnlineStatusShareHelper", f = "OnlineStatusShareHelper.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1}, l = {174, 179}, m = "showNewSharePanelInner", n = {"this", "onlineStatusData", "backgroundUrl", "qrCodeBitmap", "isAvatarOpened", "showAvatar", "this", "onlineStatusData", "isAvatarOpened"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "I$0", "L$0", "L$1", "Z$0"})
/* loaded from: classes16.dex */
public final class OnlineStatusShareHelper$showNewSharePanelInner$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OnlineStatusShareHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnlineStatusShareHelper$showNewSharePanelInner$1(OnlineStatusShareHelper onlineStatusShareHelper, Continuation<? super OnlineStatusShareHelper$showNewSharePanelInner$1> continuation) {
        super(continuation);
        this.this$0 = onlineStatusShareHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object V;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        V = this.this$0.V(null, 0, false, null, null, this);
        return V;
    }
}
