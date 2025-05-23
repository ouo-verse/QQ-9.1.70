package com.tencent.mobileqq.zplan.aio.couple;

import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanAIOGrayTipApi;
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
import ku4.n;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarViewController$switchToBothSceneIdAndChangeScene$1", f = "CoupleAvatarViewController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class CoupleAvatarViewController$switchToBothSceneIdAndChangeScene$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $bothSceneId;
    int label;
    final /* synthetic */ CoupleAvatarViewController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoupleAvatarViewController$switchToBothSceneIdAndChangeScene$1(int i3, CoupleAvatarViewController coupleAvatarViewController, Continuation<? super CoupleAvatarViewController$switchToBothSceneIdAndChangeScene$1> continuation) {
        super(2, continuation);
        this.$bothSceneId = i3;
        this.this$0 = coupleAvatarViewController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CoupleAvatarViewController$switchToBothSceneIdAndChangeScene$1(this.$bothSceneId, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoupleAvatarSceneConfigManager coupleAvatarSceneConfigManager = CoupleAvatarSceneConfigManager.f330980a;
            final int i3 = this.$bothSceneId;
            final CoupleAvatarViewController coupleAvatarViewController = this.this$0;
            coupleAvatarSceneConfigManager.h(i3, new h() { // from class: com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarViewController$switchToBothSceneIdAndChangeScene$1.1
                @Override // com.tencent.mobileqq.zplan.aio.couple.h
                public void a(boolean isSuccess) {
                    n d16;
                    if (!isSuccess || (d16 = CoupleAvatarSceneConfigManager.f330980a.d(i3)) == null) {
                        return;
                    }
                    IZPlanAIOGrayTipApi iZPlanAIOGrayTipApi = (IZPlanAIOGrayTipApi) QRoute.api(IZPlanAIOGrayTipApi.class);
                    String peerUin = coupleAvatarViewController.getPeerUin();
                    String str = d16.f413121b;
                    Intrinsics.checkNotNullExpressionValue(str, "sceneConfig.name");
                    iZPlanAIOGrayTipApi.showGrayTip(new IZPlanAIOGrayTipApi.GrayTipInfo(peerUin, str, i3, null, 8, null));
                    CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
                    if (f16 != null) {
                        CorountineFunKt.e(f16, "CoupleAvatarViewController_switchToBothSceneIdAndChangeScene_onUpdate", null, null, null, new CoupleAvatarViewController$switchToBothSceneIdAndChangeScene$1$1$onUpdate$1(coupleAvatarViewController, d16, null), 14, null);
                    }
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CoupleAvatarViewController$switchToBothSceneIdAndChangeScene$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
