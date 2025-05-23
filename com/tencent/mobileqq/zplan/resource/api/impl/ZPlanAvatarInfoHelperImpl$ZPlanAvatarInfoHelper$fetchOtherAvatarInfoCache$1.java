package com.tencent.mobileqq.zplan.resource.api.impl;

import com.tencent.mobileqq.zplan.resource.api.impl.ZPlanAvatarInfoHelperImpl;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.zplan.resource.api.impl.ZPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper", f = "ZPlanAvatarInfoHelperImpl.kt", i = {}, l = {61}, m = "fetchOtherAvatarInfoCache", n = {}, s = {})
/* loaded from: classes34.dex */
public final class ZPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoCache$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ZPlanAvatarInfoHelperImpl.Companion this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoCache$1(ZPlanAvatarInfoHelperImpl.Companion companion, Continuation<? super ZPlanAvatarInfoHelperImpl$ZPlanAvatarInfoHelper$fetchOtherAvatarInfoCache$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetchOtherAvatarInfoCache(null, this);
    }
}
