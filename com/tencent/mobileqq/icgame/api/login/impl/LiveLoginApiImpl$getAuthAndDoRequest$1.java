package com.tencent.mobileqq.icgame.api.login.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.icgame.api.login.impl.LiveLoginApiImpl", f = "LiveLoginApiImpl.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {126, 139, 146}, m = "getAuthAndDoRequest", n = {"this", "appId", "uin", "qqConnectappId", "isRetry", "this", "appId", "uin", "authRequestRsp", "isRetry"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0"})
/* loaded from: classes15.dex */
public final class LiveLoginApiImpl$getAuthAndDoRequest$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LiveLoginApiImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveLoginApiImpl$getAuthAndDoRequest$1(LiveLoginApiImpl liveLoginApiImpl, Continuation<? super LiveLoginApiImpl$getAuthAndDoRequest$1> continuation) {
        super(continuation);
        this.this$0 = liveLoginApiImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object authAndDoRequest;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        authAndDoRequest = this.this$0.getAuthAndDoRequest(null, null, null, false, this);
        return authAndDoRequest;
    }
}
