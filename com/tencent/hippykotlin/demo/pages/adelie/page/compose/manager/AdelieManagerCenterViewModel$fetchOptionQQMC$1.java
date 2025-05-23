package com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieAudioRecordFrequencyView$endRecording$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.kuikly.manager.AdelieManagerViewModel$DisplayDataOption;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterViewModel$fetchOptionQQMC$1", f = "AdelieManagerCenterViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class AdelieManagerCenterViewModel$fetchOptionQQMC$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ AdelieManagerCenterViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdelieManagerCenterViewModel$fetchOptionQQMC$1(AdelieManagerCenterViewModel adelieManagerCenterViewModel, Continuation<? super AdelieManagerCenterViewModel$fetchOptionQQMC$1> continuation) {
        super(2, continuation);
        this.this$0 = adelieManagerCenterViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdelieManagerCenterViewModel$fetchOptionQQMC$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((AdelieManagerCenterViewModel$fetchOptionQQMC$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        this.this$0.getClass();
        AdelieKuiklyBaseModule adelieKuiklyBaseModule = (AdelieKuiklyBaseModule) c.f117352a.g().acquireModule("AdelieKuiklyBaseModule");
        final AdelieManagerCenterViewModel adelieManagerCenterViewModel = this.this$0;
        AdelieManagerViewModel$DisplayDataOption adelieManagerViewModel$DisplayDataOption = adelieManagerCenterViewModel.displayDataOption;
        adelieManagerViewModel$DisplayDataOption.getClass();
        e eVar = new e();
        eVar.v("option", adelieManagerViewModel$DisplayDataOption.option);
        eVar.v(WadlProxyConsts.KEY_JUMP_URL, adelieManagerViewModel$DisplayDataOption.jumpUrl);
        adelieKuiklyBaseModule.getQQMCConfig("adelie_display_data_option", eVar.toString(), new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterViewModel$fetchOptionQQMC$1$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar2) {
                e eVar3 = eVar2;
                AdelieAudioRecordFrequencyView$endRecording$1$$ExternalSyntheticOutline0.m("adelie_display_data_option : ", eVar3, KLog.INSTANCE, "AdelieManagerCenterViewModel");
                if (eVar3 != null) {
                    try {
                        AdelieManagerViewModel$DisplayDataOption adelieManagerViewModel$DisplayDataOption2 = AdelieManagerCenterViewModel.this.displayDataOption;
                        adelieManagerViewModel$DisplayDataOption2.getClass();
                        e eVar4 = new e();
                        eVar4.v("option", adelieManagerViewModel$DisplayDataOption2.option);
                        eVar4.v(WadlProxyConsts.KEY_JUMP_URL, adelieManagerViewModel$DisplayDataOption2.jumpUrl);
                        e eVar5 = new e(eVar3.q("data", eVar4.toString()));
                        AdelieManagerCenterViewModel adelieManagerCenterViewModel2 = AdelieManagerCenterViewModel.this;
                        adelieManagerCenterViewModel2.displayDataOption = new AdelieManagerViewModel$DisplayDataOption(eVar5.q("option", adelieManagerCenterViewModel2.displayDataOption.option), eVar5.q(WadlProxyConsts.KEY_JUMP_URL, AdelieManagerCenterViewModel.this.displayDataOption.jumpUrl));
                    } catch (Throwable th5) {
                        AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("getQQMCConfig error, ", th5, KLog.INSTANCE, "AdelieManagerCenterViewModel");
                    }
                }
                return Unit.INSTANCE;
            }
        });
        return Unit.INSTANCE;
    }
}
