package com.tencent.mobileqq.guild.media.core.logic;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.media.core.logic.MediaEnterExitRequestHelper", f = "MediaEnterExitRequestHelper.kt", i = {0, 0, 0, 1, 1, 1, 2, 2}, l = {253, 260, 271}, m = "questEnterChannelLogic", n = {"this", "callback", "prepareTrtcAsync", "this", "callback", "enterChannelRsp", "this", "callback"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1"})
/* loaded from: classes14.dex */
public final class MediaEnterExitRequestHelper$questEnterChannelLogic$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MediaEnterExitRequestHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaEnterExitRequestHelper$questEnterChannelLogic$1(MediaEnterExitRequestHelper mediaEnterExitRequestHelper, Continuation<? super MediaEnterExitRequestHelper$questEnterChannelLogic$1> continuation) {
        super(continuation);
        this.this$0 = mediaEnterExitRequestHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object Z0;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Z0 = this.this$0.Z0(null, 0L, null, this);
        return Z0;
    }
}
