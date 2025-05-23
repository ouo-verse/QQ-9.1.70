package com.tencent.ecommerce.biz.register.officialAccountFollowedChecker;

import com.tencent.mobileqq.vas.ipc.VasLiveIPCModule;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\u0086@"}, d2 = {"", "accountType", "accountFollowScene", "Lkotlin/coroutines/Continuation;", "Lcom/tencent/ecommerce/base/network/api/d;", "Lorg/json/JSONObject;", "continuation", "", VasLiveIPCModule.ACTION_FOLLOW_ACCOUNT}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.register.officialAccountFollowedChecker.ECAccountFollowedRepository", f = "ECAccountFollowedRepository.kt", i = {0}, l = {73}, m = VasLiveIPCModule.ACTION_FOLLOW_ACCOUNT, n = {"reqParams"}, s = {"L$0"})
/* loaded from: classes31.dex */
public final class ECAccountFollowedRepository$followAccount$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECAccountFollowedRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECAccountFollowedRepository$followAccount$1(ECAccountFollowedRepository eCAccountFollowedRepository, Continuation continuation) {
        super(continuation);
        this.this$0 = eCAccountFollowedRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(0, 0, this);
    }
}
