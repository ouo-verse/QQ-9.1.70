package com.tencent.mobileqq.zplan.avatar.manager;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.zplan.avatar.manager.ZPlanEditAvatarDataManager", f = "ZPlanEditAvatarDataManager.kt", i = {0, 0, 0}, l = {33}, m = "fetchEditAvatarConfig", n = {"localAvatarConfigInfo", "uin", "gender"}, s = {"L$0", "J$0", "I$0"})
/* loaded from: classes35.dex */
public final class ZPlanEditAvatarDataManager$fetchEditAvatarConfig$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ZPlanEditAvatarDataManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanEditAvatarDataManager$fetchEditAvatarConfig$1(ZPlanEditAvatarDataManager zPlanEditAvatarDataManager, Continuation<? super ZPlanEditAvatarDataManager$fetchEditAvatarConfig$1> continuation) {
        super(continuation);
        this.this$0 = zPlanEditAvatarDataManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object e16;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        e16 = this.this$0.e(0L, 0, this);
        return e16;
    }
}
