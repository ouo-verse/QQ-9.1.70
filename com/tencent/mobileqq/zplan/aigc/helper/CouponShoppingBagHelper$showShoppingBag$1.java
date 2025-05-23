package com.tencent.mobileqq.zplan.aigc.helper;

import android.content.Context;
import com.tencent.mobileqq.zplan.servlet.ZPlanAIGCRequest;
import k94.DialogCustomData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import uv4.az;
import uv4.bc;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.helper.CouponShoppingBagHelper$showShoppingBag$1", f = "CouponShoppingBagHelper.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class CouponShoppingBagHelper$showShoppingBag$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $source;
    int label;
    final /* synthetic */ CouponShoppingBagHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CouponShoppingBagHelper$showShoppingBag$1(CouponShoppingBagHelper couponShoppingBagHelper, Context context, String str, Continuation<? super CouponShoppingBagHelper$showShoppingBag$1> continuation) {
        super(2, continuation);
        this.this$0 = couponShoppingBagHelper;
        this.$context = context;
        this.$source = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CouponShoppingBagHelper$showShoppingBag$1(this.this$0, this.$context, this.$source, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ZPlanAIGCRequest zPlanAIGCRequest = ZPlanAIGCRequest.f335341a;
            this.label = 1;
            obj = zPlanAIGCRequest.d(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        com.tencent.mobileqq.zplan.aigc.data.a aVar = (com.tencent.mobileqq.zplan.aigc.data.a) obj;
        if (aVar == null) {
            return Unit.INSTANCE;
        }
        bc bcVar = new bc();
        bcVar.f440315d = (int) aVar.getGoldPrice();
        bcVar.f440316e = (int) aVar.getSilverPrice();
        bcVar.f440312a = (int) aVar.getPriceType();
        az azVar = new az();
        azVar.f440279f = aVar.getCom.tencent.qq.minibox.api.data.MiniBoxNoticeInfo.KEY_ICON_URL java.lang.String();
        azVar.f440277d = aVar.getCouponName();
        azVar.f440287n = bcVar;
        final DialogCustomData dialogCustomData = new DialogCustomData(null, null, null, null, null, 0, 63, null);
        dialogCustomData.h(azVar);
        t74.l lVar = t74.l.f435563a;
        final CouponShoppingBagHelper couponShoppingBagHelper = this.this$0;
        final Context context = this.$context;
        final String str = this.$source;
        lVar.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.helper.CouponShoppingBagHelper$showShoppingBag$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                com.tencent.sqshow.zootopia.nativeui.data.j c16;
                ga4.g a16;
                ga4.f dialogController;
                CouponShoppingBagHelper couponShoppingBagHelper2 = CouponShoppingBagHelper.this;
                c16 = couponShoppingBagHelper2.c();
                couponShoppingBagHelper2.d(c16);
                ga4.j jVar = ga4.j.f401682a;
                com.tencent.sqshow.zootopia.nativeui.data.j mChannel = CouponShoppingBagHelper.this.getMChannel();
                Intrinsics.checkNotNull(mChannel);
                a16 = jVar.a(21, mChannel, context, (r22 & 8) != 0 ? new DialogCustomData(null, null, null, null, null, 0, 63, null) : dialogCustomData, (r22 & 16) != 0 ? false : false);
                com.tencent.sqshow.zootopia.nativeui.data.j mChannel2 = CouponShoppingBagHelper.this.getMChannel();
                if (mChannel2 == null || (dialogController = mChannel2.getDialogController()) == null) {
                    return;
                }
                dialogController.e(a16);
                zd3.d.f452376a.g(a16.getView(), str);
            }
        });
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CouponShoppingBagHelper$showShoppingBag$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
