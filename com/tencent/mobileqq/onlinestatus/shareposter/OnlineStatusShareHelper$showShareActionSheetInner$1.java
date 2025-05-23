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
@DebugMetadata(c = "com.tencent.mobileqq.onlinestatus.shareposter.OnlineStatusShareHelper", f = "OnlineStatusShareHelper.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3}, l = {110, 118, 127, 138}, m = "showShareActionSheetInner", n = {"this", "onlineStatusData", "isAvatarOpened", "onlineStatusId", "this", "onlineStatusData", "backgroundUrl", "qrCodeBitmap", "isAvatarOpened", "onlineStatusId", "this", "onlineStatusData", "backgroundUrl", "qrCodeBitmap", "avatarShareActionSheet", "isAvatarOpened"}, s = {"L$0", "L$1", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0"})
/* loaded from: classes16.dex */
public final class OnlineStatusShareHelper$showShareActionSheetInner$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OnlineStatusShareHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnlineStatusShareHelper$showShareActionSheetInner$1(OnlineStatusShareHelper onlineStatusShareHelper, Continuation<? super OnlineStatusShareHelper$showShareActionSheetInner$1> continuation) {
        super(continuation);
        this.this$0 = onlineStatusShareHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object Y;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Y = this.this$0.Y(null, false, this);
        return Y;
    }
}
