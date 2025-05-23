package com.tencent.qqnt.aio.adapter.api.impl;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.aio.adapter.api.impl.AIOChainAniStickerApiImpl$showSharePage$1", f = "AIOChainAniStickerApiImpl.kt", i = {}, l = {155}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
final class AIOChainAniStickerApiImpl$showSharePage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ CoroutineScope $mainScope;
    final /* synthetic */ String $picUrl;
    final /* synthetic */ int $reportChatType;
    final /* synthetic */ int $serverId;
    int label;
    final /* synthetic */ AIOChainAniStickerApiImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOChainAniStickerApiImpl$showSharePage$1(AIOChainAniStickerApiImpl aIOChainAniStickerApiImpl, Activity activity, CoroutineScope coroutineScope, int i3, String str, int i16, Continuation<? super AIOChainAniStickerApiImpl$showSharePage$1> continuation) {
        super(2, continuation);
        this.this$0 = aIOChainAniStickerApiImpl;
        this.$activity = activity;
        this.$mainScope = coroutineScope;
        this.$serverId = i3;
        this.$picUrl = str;
        this.$reportChatType = i16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AIOChainAniStickerApiImpl$showSharePage$1(this.this$0, this.$activity, this.$mainScope, this.$serverId, this.$picUrl, this.$reportChatType, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Object preparePicAndShow;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            AIOChainAniStickerApiImpl aIOChainAniStickerApiImpl = this.this$0;
            Activity activity = this.$activity;
            CoroutineScope coroutineScope = this.$mainScope;
            int i16 = this.$serverId;
            String str = this.$picUrl;
            int i17 = this.$reportChatType;
            this.label = 1;
            preparePicAndShow = aIOChainAniStickerApiImpl.preparePicAndShow(activity, coroutineScope, i16, str, i17, this);
            if (preparePicAndShow == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AIOChainAniStickerApiImpl$showSharePage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
