package com.tencent.sqshow.zootopia.friendsdressup.filament;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.sqshow.zootopia.friendsdressup.filament.FriendsDressUpBusinessScene", f = "FriendsDressUpBusinessScene.kt", i = {0}, l = {102}, m = "fetchAvatarInfo", n = {"this"}, s = {"L$0"})
/* loaded from: classes34.dex */
public final class FriendsDressUpBusinessScene$fetchAvatarInfo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FriendsDressUpBusinessScene this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendsDressUpBusinessScene$fetchAvatarInfo$1(FriendsDressUpBusinessScene friendsDressUpBusinessScene, Continuation<? super FriendsDressUpBusinessScene$fetchAvatarInfo$1> continuation) {
        super(continuation);
        this.this$0 = friendsDressUpBusinessScene;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetchAvatarInfo(null, this);
    }
}
