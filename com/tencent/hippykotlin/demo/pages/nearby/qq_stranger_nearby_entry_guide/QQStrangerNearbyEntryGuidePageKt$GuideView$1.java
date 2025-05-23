package com.tencent.hippykotlin.demo.pages.nearby.qq_stranger_nearby_entry_guide;

import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.views.CanvasBlendMode;
import com.tencent.ntcompose.material.i;
import com.tencent.ntcompose.ui.platform.a;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.nearby.qq_stranger_nearby_entry_guide.QQStrangerNearbyEntryGuidePageKt$GuideView$1", f = "QQStrangerNearbyEntryGuidePage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class QQStrangerNearbyEntryGuidePageKt$GuideView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ a $cfg;
    public final /* synthetic */ i $drawState;
    public final /* synthetic */ GuideParams $params;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerNearbyEntryGuidePageKt$GuideView$1(i iVar, a aVar, GuideParams guideParams, Continuation<? super QQStrangerNearbyEntryGuidePageKt$GuideView$1> continuation) {
        super(2, continuation);
        this.$drawState = iVar;
        this.$cfg = aVar;
        this.$params = guideParams;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QQStrangerNearbyEntryGuidePageKt$GuideView$1(this.$drawState, this.$cfg, this.$params, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QQStrangerNearbyEntryGuidePageKt$GuideView$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        i iVar = this.$drawState;
        a aVar = this.$cfg;
        iVar.b();
        iVar.m(0.0f, 0.0f);
        iVar.k(aVar.e(), 0.0f);
        iVar.k(aVar.e(), aVar.d());
        iVar.k(0.0f, aVar.d());
        iVar.k(0.0f, 0.0f);
        iVar.f(QUIToken.color$default("overlay_dark"));
        iVar.e();
        iVar.d();
        i iVar2 = this.$drawState;
        GuideParams guideParams = this.$params;
        iVar2.b();
        iVar2.r(CanvasBlendMode.CLEAR);
        iVar2.l(0.0f);
        float f16 = guideParams.targetRadius;
        float f17 = guideParams.targetX;
        float f18 = guideParams.targetY;
        float f19 = guideParams.targetWidth;
        float f26 = guideParams.targetHeight;
        float f27 = f19 + f17;
        float f28 = f18 + f16;
        iVar2.m(f27, f28);
        float f29 = f26 + f18;
        float f36 = f29 - f16;
        iVar2.k(f27, f36);
        float f37 = f27 - f16;
        iVar2.a(f37, f36, f16, 0.0f, 1.5707964f, false);
        float f38 = f17 + f16;
        iVar2.k(f38, f29);
        iVar2.a(f38, f36, f16, 1.5707964f, 3.1415927f, false);
        iVar2.k(f17, f28);
        iVar2.a(f38, f28, f16, 3.1415927f, 4.712389f, false);
        iVar2.k(f37, f18);
        iVar2.a(f37, f28, f16, 4.712389f, 6.2831855f, false);
        iVar2.e();
        iVar2.d();
        return Unit.INSTANCE;
    }
}
