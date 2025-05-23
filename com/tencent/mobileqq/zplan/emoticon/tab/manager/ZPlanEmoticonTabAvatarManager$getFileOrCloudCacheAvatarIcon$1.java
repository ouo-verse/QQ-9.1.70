package com.tencent.mobileqq.zplan.emoticon.tab.manager;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.zplan.emoticon.tab.manager.ZPlanEmoticonTabAvatarManager", f = "ZPlanEmoticonTabAvatarManager.kt", i = {0}, l = {501}, m = "getFileOrCloudCacheAvatarIcon", n = {"this"}, s = {"L$0"})
/* loaded from: classes34.dex */
public final class ZPlanEmoticonTabAvatarManager$getFileOrCloudCacheAvatarIcon$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ZPlanEmoticonTabAvatarManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanEmoticonTabAvatarManager$getFileOrCloudCacheAvatarIcon$1(ZPlanEmoticonTabAvatarManager zPlanEmoticonTabAvatarManager, Continuation<? super ZPlanEmoticonTabAvatarManager$getFileOrCloudCacheAvatarIcon$1> continuation) {
        super(continuation);
        this.this$0 = zPlanEmoticonTabAvatarManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object s16;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        s16 = this.this$0.s(this);
        return s16;
    }
}
