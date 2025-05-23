package com.tencent.mobileqq.zplan.aio.graytips;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.zplan.api.IZPlanAIOGrayTipApi;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.graytips.action.p;
import com.tencent.qqnt.graytips.api.INtGrayTipApi;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import com.tencent.qqnt.kernel.nativeinterface.IAddJsonGrayTipMsgCallback;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.graytips.ZPlanAIOGrayTipHelper$showGrayTip$1", f = "ZPlanAIOGrayTipHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class ZPlanAIOGrayTipHelper$showGrayTip$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IZPlanAIOGrayTipApi.GrayTipInfo $info;
    final /* synthetic */ boolean $switchScreen;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanAIOGrayTipHelper$showGrayTip$1(IZPlanAIOGrayTipApi.GrayTipInfo grayTipInfo, boolean z16, Continuation<? super ZPlanAIOGrayTipHelper$showGrayTip$1> continuation) {
        super(2, continuation);
        this.$info = grayTipInfo;
        this.$switchScreen = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(IZPlanAIOGrayTipApi.GrayTipInfo grayTipInfo, int i3, long j3) {
        QLog.d("ZPlanAIOGrayTipHelper", 1, "addSwitchScreenGrayTip, result=" + i3 + ", msgId=" + j3 + ", friendUin: " + grayTipInfo.getFriendUin());
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZPlanAIOGrayTipHelper$showGrayTip$1(this.$info, this.$switchScreen, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZPlanAIOGrayTipHelper$showGrayTip$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String d16;
        String f16;
        INtGrayTipApi e16;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            QQAppInterface j3 = bb.f335811a.j();
            if (j3 == null) {
                return Unit.INSTANCE;
            }
            ZPlanAIOGrayTipHelper zPlanAIOGrayTipHelper = ZPlanAIOGrayTipHelper.f331022a;
            d16 = zPlanAIOGrayTipHelper.d();
            if (!(d16.length() == 0)) {
                f16 = zPlanAIOGrayTipHelper.f(this.$info.getFriendUin());
                LocalGrayTip.LocalGrayTipBuilder localGrayTipBuilder = new LocalGrayTip.LocalGrayTipBuilder(d16, 1, 2302L, 1, true, false, null, 64, null);
                IZPlanAIOGrayTipApi.GrayTipInfo grayTipInfo = this.$info;
                boolean z16 = this.$switchScreen;
                a aVar = new a(grayTipInfo);
                if (z16) {
                    localGrayTipBuilder.h(f16, new p("", f16, grayTipInfo.getFriendUin()), 3);
                    localGrayTipBuilder.g("\u5c06\u4f60\u4eec\u7684\u804a\u5929\u573a\u666f\u66f4\u6362\u4e3a ", 1);
                    localGrayTipBuilder.h(grayTipInfo.getSceneName(), aVar, 3);
                } else {
                    localGrayTipBuilder.h(f16, new p("", f16, grayTipInfo.getFriendUin()), 3);
                    localGrayTipBuilder.g("\u6b63\u5728\u4f7f\u7528", 1);
                    localGrayTipBuilder.h("\u597d\u53cb\u65f6\u5149", aVar, 3);
                    localGrayTipBuilder.g("\uff0c\u4e00\u8d77\u6765\u73a9\u5427", 1);
                }
                e16 = zPlanAIOGrayTipHelper.e();
                LocalGrayTip m3 = localGrayTipBuilder.m();
                final IZPlanAIOGrayTipApi.GrayTipInfo grayTipInfo2 = this.$info;
                e16.addLocalGrayTip(j3, m3, new IAddJsonGrayTipMsgCallback() { // from class: com.tencent.mobileqq.zplan.aio.graytips.c
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IAddJsonGrayTipMsgCallback
                    public final void onResult(int i3, long j16) {
                        ZPlanAIOGrayTipHelper$showGrayTip$1.b(IZPlanAIOGrayTipApi.GrayTipInfo.this, i3, j16);
                    }
                });
                e.f331031a.g(this.$info.getType());
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
