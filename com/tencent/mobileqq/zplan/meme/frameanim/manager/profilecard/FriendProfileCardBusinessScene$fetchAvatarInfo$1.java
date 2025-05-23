package com.tencent.mobileqq.zplan.meme.frameanim.manager.profilecard;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.zplan.meme.frameanim.manager.profilecard.FriendProfileCardBusinessScene", f = "FriendProfileCardBusinessScene.kt", i = {}, l = {11}, m = "fetchAvatarInfo", n = {}, s = {})
/* loaded from: classes34.dex */
public final class FriendProfileCardBusinessScene$fetchAvatarInfo$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FriendProfileCardBusinessScene this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendProfileCardBusinessScene$fetchAvatarInfo$1(FriendProfileCardBusinessScene friendProfileCardBusinessScene, Continuation<? super FriendProfileCardBusinessScene$fetchAvatarInfo$1> continuation) {
        super(continuation);
        this.this$0 = friendProfileCardBusinessScene;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetchAvatarInfo(null, this);
    }
}
