package com.tencent.mobileqq.matchfriend.api.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.api.impl.MatchFriendUploadApiImpl", f = "MatchFriendUploadApiImpl.kt", i = {}, l = {11}, m = "uploadPics", n = {}, s = {})
/* loaded from: classes33.dex */
public final class MatchFriendUploadApiImpl$uploadPics$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MatchFriendUploadApiImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MatchFriendUploadApiImpl$uploadPics$1(MatchFriendUploadApiImpl matchFriendUploadApiImpl, Continuation<? super MatchFriendUploadApiImpl$uploadPics$1> continuation) {
        super(continuation);
        this.this$0 = matchFriendUploadApiImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.uploadPics(null, false, this);
    }
}
