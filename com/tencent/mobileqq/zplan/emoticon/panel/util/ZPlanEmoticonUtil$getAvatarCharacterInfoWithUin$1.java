package com.tencent.mobileqq.zplan.emoticon.panel.util;

import com.tencent.luggage.wxa.uf.f;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.zplan.emoticon.panel.util.ZPlanEmoticonUtil", f = "ZPlanEmoticonUtil.kt", i = {0}, l = {f.CTRL_INDEX}, m = "getAvatarCharacterInfoWithUin", n = {"dressKey"}, s = {"L$0"})
/* loaded from: classes34.dex */
public final class ZPlanEmoticonUtil$getAvatarCharacterInfoWithUin$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ZPlanEmoticonUtil this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanEmoticonUtil$getAvatarCharacterInfoWithUin$1(ZPlanEmoticonUtil zPlanEmoticonUtil, Continuation<? super ZPlanEmoticonUtil$getAvatarCharacterInfoWithUin$1> continuation) {
        super(continuation);
        this.this$0 = zPlanEmoticonUtil;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object u16;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        u16 = this.this$0.u(null, this);
        return u16;
    }
}
