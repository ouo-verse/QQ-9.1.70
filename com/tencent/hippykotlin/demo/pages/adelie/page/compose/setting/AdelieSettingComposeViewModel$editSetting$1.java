package com.tencent.hippykotlin.demo.pages.adelie.page.compose.setting;

import androidx.compose.runtime.MutableState;
import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.RequestKt;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import h25.h;
import h25.l;
import h25.m;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.adelie.page.compose.setting.AdelieSettingComposeViewModel$editSetting$1", f = "AdelieSettingComposeViewModel.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class AdelieSettingComposeViewModel$editSetting$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ boolean $isOn;
    public int label;
    public final /* synthetic */ AdelieSettingComposeViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdelieSettingComposeViewModel$editSetting$1(boolean z16, AdelieSettingComposeViewModel adelieSettingComposeViewModel, Continuation<? super AdelieSettingComposeViewModel$editSetting$1> continuation) {
        super(2, continuation);
        this.$isOn = z16;
        this.this$0 = adelieSettingComposeViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdelieSettingComposeViewModel$editSetting$1(this.$isOn, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((AdelieSettingComposeViewModel$editSetting$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        h hVar;
        h hVar2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            final boolean z16 = this.$isOn;
            this.label = 1;
            obj = RequestKt.sendOIDBRequest(1, 37342, new Function0<l>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.setting.AdelieSettingComposeRequest$editSetting$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final l invoke() {
                    return new l(z16);
                }
            }, new Function1<byte[], m>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.setting.AdelieSettingComposeRequest$editSetting$3
                @Override // kotlin.jvm.functions.Function1
                public final m invoke(byte[] bArr) {
                    return (m) i.b(new m(null, 1, null), bArr);
                }
            }, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        OIDBResponse oIDBResponse = (OIDBResponse) obj;
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("editSetting ");
        m3.append(this.$isOn);
        m3.append(", ");
        m3.append(oIDBResponse.success);
        m3.append(", ");
        m3.append(oIDBResponse.code);
        m3.append(", ");
        m3.append(oIDBResponse.f114186msg);
        m3.append(", ");
        m mVar = (m) oIDBResponse.rsp;
        m3.append((mVar == null || (hVar2 = mVar.f404217d) == null) ? null : Boxing.boxBoolean(hVar2.f404207e));
        kLog.i("AdelieSettingViewModel", m3.toString());
        MutableState<Boolean> mutableState = this.this$0.accessible;
        m mVar2 = (m) oIDBResponse.rsp;
        mutableState.setValue(Boxing.boxBoolean((mVar2 == null || (hVar = mVar2.f404217d) == null || !hVar.f404207e) ? false : true));
        AdelieKuiklyBaseModule adelieKuiklyBaseModule = this.this$0.adelieKuiklyBaseModule;
        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("is_switch_on_");
        m16.append(c.f117352a.g().getPageData().n().q("uin", ""));
        String sb5 = m16.toString();
        String obj2 = this.this$0.accessible.toString();
        int i16 = AdelieKuiklyBaseModule.$r8$clinit;
        adelieKuiklyBaseModule.setStringToCache$enumunboxing$(sb5, obj2, 1, 1);
        return Unit.INSTANCE;
    }
}
