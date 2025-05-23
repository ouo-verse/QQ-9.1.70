package com.tencent.mobileqq.nearbypro.profile.avatar;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.nearbypro.profile.avatar.MyNearbyProBizScene", f = "MyNearbyProBizScene.kt", i = {}, l = {103}, m = "fetchAvatarInfo$suspendImpl", n = {}, s = {})
/* loaded from: classes15.dex */
public final class MyNearbyProBizScene$fetchAvatarInfo$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MyNearbyProBizScene this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyNearbyProBizScene$fetchAvatarInfo$1(MyNearbyProBizScene myNearbyProBizScene, Continuation<? super MyNearbyProBizScene$fetchAvatarInfo$1> continuation) {
        super(continuation);
        this.this$0 = myNearbyProBizScene;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return MyNearbyProBizScene.fetchAvatarInfo$suspendImpl(this.this$0, null, this);
    }
}
