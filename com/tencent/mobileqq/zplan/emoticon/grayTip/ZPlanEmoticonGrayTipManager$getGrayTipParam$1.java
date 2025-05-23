package com.tencent.mobileqq.zplan.emoticon.grayTip;

import android.os.Bundle;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionMainActivity;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.zplan.emoticon.grayTip.ZPlanEmoticonGrayTipManager;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.youtu.sdkkitframework.common.ErrorCode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import wk3.g;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.emoticon.grayTip.ZPlanEmoticonGrayTipManager$getGrayTipParam$1", f = "ZPlanEmoticonGrayTipManager.kt", i = {0, 0, 0, 0}, l = {104}, m = "invokeSuspend", n = {"tipFormat", "bundle", "highlightStartIndex", "highlightEndIndex"}, s = {"L$0", "L$1", "I$0", "I$1"})
/* loaded from: classes34.dex */
public final class ZPlanEmoticonGrayTipManager$getGrayTipParam$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ZPlanEmoticonGrayTipManager.a $listener;
    final /* synthetic */ MessageRecord $message;
    final /* synthetic */ p $sessionInfo;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanEmoticonGrayTipManager$getGrayTipParam$1(ZPlanEmoticonGrayTipManager.a aVar, MessageRecord messageRecord, p pVar, Continuation<? super ZPlanEmoticonGrayTipManager$getGrayTipParam$1> continuation) {
        super(2, continuation);
        this.$listener = aVar;
        this.$message = messageRecord;
        this.$sessionInfo = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZPlanEmoticonGrayTipManager$getGrayTipParam$1(this.$listener, this.$message, this.$sessionInfo, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        int length;
        Object b16;
        int i3;
        String str;
        Bundle bundle;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 == 0) {
            ResultKt.throwOnFailure(obj);
            g zPlanEmoticonGrayTipsConfig = ZPlanQQMC.INSTANCE.getZPlanEmoticonGrayTipsConfig();
            String highLightWord = zPlanEmoticonGrayTipsConfig.getHighLightWord();
            String tipWord = zPlanEmoticonGrayTipsConfig.getTipWord();
            String str2 = tipWord + " " + highLightWord;
            length = tipWord.length();
            int length2 = str2.length();
            Bundle bundle2 = new Bundle();
            ZPlanEmoticonGrayTipManager zPlanEmoticonGrayTipManager = ZPlanEmoticonGrayTipManager.f333111a;
            this.L$0 = str2;
            this.L$1 = bundle2;
            this.I$0 = length;
            this.I$1 = length2;
            this.label = 1;
            b16 = zPlanEmoticonGrayTipManager.b(this);
            if (b16 == coroutine_suspended) {
                return coroutine_suspended;
            }
            i3 = length2;
            obj = b16;
            str = str2;
            bundle = bundle2;
        } else if (i16 == 1) {
            i3 = this.I$1;
            length = this.I$0;
            bundle = (Bundle) this.L$1;
            String str3 = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
            str = str3;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int intValue = ((Number) obj).intValue();
        if (intValue == -1) {
            this.$listener.a(null);
            return Unit.INSTANCE;
        }
        bundle.putInt("key_action", intValue);
        bundle.putString("textColor", "#40A0FF");
        MessageRecord messageRecord = this.$message;
        com.tencent.mobileqq.graytip.g gVar = new com.tencent.mobileqq.graytip.g(messageRecord.frienduin, messageRecord.senderuin, str, this.$sessionInfo.f179555d, messageRecord.msgtype, ErrorCode.YT_SDK_VERIFY_TIMEOUT, messageRecord.time);
        gVar.b(length, i3, bundle);
        gVar.f213688k.putString(IPublicAccountImageCollectionMainActivity.CLICK_SOURCE, "zplan_emoticon_gray_tip");
        gVar.f213688k.putInt("zplan_emoticon_gray_tips_action_type", intValue);
        this.$listener.a(gVar);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZPlanEmoticonGrayTipManager$getGrayTipParam$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
