package com.tencent.mobileqq.zplan.emoticon.grayTip;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.graytips.api.INtGrayTipApi;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import com.tencent.qqnt.kernel.nativeinterface.IAddJsonGrayTipMsgCallback;
import ih3.b;
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
import wk3.g;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.emoticon.grayTip.ZPlanEmoticonGrayTipNTHelper$doShowZPlanEmoticonGrayTips$1", f = "ZPlanEmoticonGrayTipNTHelper.kt", i = {0, 0, 0}, l = {153}, m = "invokeSuspend", n = {"app", "highlightWord", "tipWord"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes34.dex */
public final class ZPlanEmoticonGrayTipNTHelper$doShowZPlanEmoticonGrayTips$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $chatType;
    final /* synthetic */ String $friendUin;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanEmoticonGrayTipNTHelper$doShowZPlanEmoticonGrayTips$1(String str, int i3, Continuation<? super ZPlanEmoticonGrayTipNTHelper$doShowZPlanEmoticonGrayTips$1> continuation) {
        super(2, continuation);
        this.$friendUin = str;
        this.$chatType = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(String str, int i3, int i16, long j3) {
        QLog.d("ZPlanEmoticonGrayTipNTHelper", 2, "doShowZPlanEmoticonGrayTips, result=" + i16 + ", msgId=" + j3 + ", friendUin: " + str + ", chatType: " + i3);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZPlanEmoticonGrayTipNTHelper$doShowZPlanEmoticonGrayTips$1(this.$friendUin, this.$chatType, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZPlanEmoticonGrayTipNTHelper$doShowZPlanEmoticonGrayTips$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        QQAppInterface j3;
        Object checkCreatedRole;
        String str;
        String str2;
        String h16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            j3 = bb.f335811a.j();
            if (j3 == null) {
                return Unit.INSTANCE;
            }
            g zPlanEmoticonGrayTipsConfig = ((IZPlanQQMC) QRoute.api(IZPlanQQMC.class)).getZPlanEmoticonGrayTipsConfig();
            String highLightWord = zPlanEmoticonGrayTipsConfig.getHighLightWord();
            String tipWord = zPlanEmoticonGrayTipsConfig.getTipWord();
            IZPlanDataHelper iZPlanDataHelper = (IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class);
            this.L$0 = j3;
            this.L$1 = highLightWord;
            this.L$2 = tipWord;
            this.label = 1;
            checkCreatedRole = iZPlanDataHelper.checkCreatedRole(this);
            if (checkCreatedRole == coroutine_suspended) {
                return coroutine_suspended;
            }
            str = tipWord;
            str2 = highLightWord;
        } else if (i3 == 1) {
            str = (String) this.L$2;
            str2 = (String) this.L$1;
            j3 = (QQAppInterface) this.L$0;
            ResultKt.throwOnFailure(obj);
            checkCreatedRole = obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        boolean booleanValue = ((Boolean) checkCreatedRole).booleanValue();
        if (!booleanValue) {
            h16 = ZPlanEmoticonGrayTipNTHelper.f333115a.h();
        } else {
            h16 = ZPlanEmoticonGrayTipTABGroup.HAS_CREATED_ROLE;
        }
        if (Intrinsics.areEqual(h16, ZPlanEmoticonGrayTipTABGroup.CONTRAST)) {
            return Unit.INSTANCE;
        }
        a aVar = new a(h16);
        QLog.i("ZPlanEmoticonGrayTipNTHelper", 1, "doShowZPlanEmoticonGrayTips, hasCreatedRole: " + booleanValue + ", actionType: " + aVar.getActionType() + ", group: " + h16);
        LocalGrayTip.LocalGrayTipBuilder localGrayTipBuilder = new LocalGrayTip.LocalGrayTipBuilder(this.$friendUin, this.$chatType, 1009L, 1, true, false, null, 64, null);
        localGrayTipBuilder.g(str, 1);
        localGrayTipBuilder.g(" ", 1);
        localGrayTipBuilder.h(str2, aVar, 3);
        INtGrayTipApi iNtGrayTipApi = (INtGrayTipApi) QRoute.api(INtGrayTipApi.class);
        LocalGrayTip m3 = localGrayTipBuilder.m();
        final String str3 = this.$friendUin;
        final int i16 = this.$chatType;
        iNtGrayTipApi.addLocalGrayTip(j3, m3, new IAddJsonGrayTipMsgCallback() { // from class: com.tencent.mobileqq.zplan.emoticon.grayTip.b
            @Override // com.tencent.qqnt.kernel.nativeinterface.IAddJsonGrayTipMsgCallback
            public final void onResult(int i17, long j16) {
                ZPlanEmoticonGrayTipNTHelper$doShowZPlanEmoticonGrayTips$1.b(str3, i16, i17, j16);
            }
        });
        ih3.b.f407666a.d(new b.GrayTipsReportConfig(booleanValue, this.$chatType, "imp"));
        return Unit.INSTANCE;
    }
}
