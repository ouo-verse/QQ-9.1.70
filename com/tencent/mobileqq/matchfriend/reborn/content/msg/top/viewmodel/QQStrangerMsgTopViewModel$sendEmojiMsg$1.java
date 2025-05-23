package com.tencent.mobileqq.matchfriend.reborn.content.msg.top.viewmodel;

import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.matchfriend.aio.sign.QQStrangerAIOSigUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IAIOEmoApi;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.msg.top.viewmodel.QQStrangerMsgTopViewModel$sendEmojiMsg$1", f = "QQStrangerMsgTopViewModel.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
final class QQStrangerMsgTopViewModel$sendEmojiMsg$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $emojiId;
    final /* synthetic */ long $tinyId;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerMsgTopViewModel$sendEmojiMsg$1(long j3, int i3, Continuation<? super QQStrangerMsgTopViewModel$sendEmojiMsg$1> continuation) {
        super(2, continuation);
        this.$tinyId = j3;
        this.$emojiId = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QQStrangerMsgTopViewModel$sendEmojiMsg$1(this.$tinyId, this.$emojiId, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            QLog.d("QQStrangerMsgTopViewModel", 1, "sendEmojiMsg tinyId=" + this.$tinyId + " emojiId=" + this.$emojiId);
            if (this.$emojiId <= 0) {
                return Unit.INSTANCE;
            }
            QQStrangerAIOSigUtil qQStrangerAIOSigUtil = QQStrangerAIOSigUtil.f243975a;
            long j3 = this.$tinyId;
            this.label = 1;
            obj = qQStrangerAIOSigUtil.h(104, j3, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int intValue = ((Number) obj).intValue();
        if (intValue != 0) {
            QLog.i("QQStrangerMsgTopViewModel", 1, "sendEmojiMsg prepare temp chat error " + intValue);
        }
        Contact contact = new Contact(104, String.valueOf(this.$tinyId), "");
        boolean isBigStickerById = QQSysFaceUtil.isBigStickerById(QQSysFaceUtil.convertToLocal(this.$emojiId));
        QRouteApi api = QRoute.api(IAIOEmoApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAIOEmoApi::class.java)");
        IAIOEmoApi.a.a((IAIOEmoApi) api, this.$emojiId, contact, isBigStickerById, null, 8, null);
        QLog.d("QQStrangerMsgTopViewModel", 1, "sendEmojiMsg finish");
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QQStrangerMsgTopViewModel$sendEmojiMsg$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
