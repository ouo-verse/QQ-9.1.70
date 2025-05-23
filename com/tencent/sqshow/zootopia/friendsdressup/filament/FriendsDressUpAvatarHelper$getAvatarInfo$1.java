package com.tencent.sqshow.zootopia.friendsdressup.filament;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.sqshow.zootopia.friendsdressup.filament.FriendsDressUpAvatarHelper", f = "FriendsDressUpAvatarHelper.kt", i = {0, 0}, l = {46}, m = "getAvatarInfo", n = {"this", "uin"}, s = {"L$0", "J$0"})
/* loaded from: classes34.dex */
public final class FriendsDressUpAvatarHelper$getAvatarInfo$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FriendsDressUpAvatarHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendsDressUpAvatarHelper$getAvatarInfo$1(FriendsDressUpAvatarHelper friendsDressUpAvatarHelper, Continuation<? super FriendsDressUpAvatarHelper$getAvatarInfo$1> continuation) {
        super(continuation);
        this.this$0 = friendsDressUpAvatarHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object h16;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        h16 = this.this$0.h(0L, this);
        return h16;
    }
}
