package com.tencent.mobileqq.zplan.aigc.helper;

import com.tencent.mobileqq.zplan.aigc.p011const.ZPlanAIGCStatusCode;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import nk3.h;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.helper.ZPlanOutfitPublishHelper$triggerPublish$1", f = "ZPlanOutfitPublishHelper.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class ZPlanOutfitPublishHelper$triggerPublish$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ bv4.b $avatar;
    final /* synthetic */ nk3.h $callback;
    final /* synthetic */ bv4.c $detail;
    final /* synthetic */ bv4.e $outfit;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanOutfitPublishHelper$triggerPublish$1(bv4.b bVar, bv4.c cVar, bv4.e eVar, nk3.h hVar, Continuation<? super ZPlanOutfitPublishHelper$triggerPublish$1> continuation) {
        super(2, continuation);
        this.$avatar = bVar;
        this.$detail = cVar;
        this.$outfit = eVar;
        this.$callback = hVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZPlanOutfitPublishHelper$triggerPublish$1(this.$avatar, this.$detail, this.$outfit, this.$callback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                com.tencent.mobileqq.zplan.servlet.j jVar = com.tencent.mobileqq.zplan.servlet.j.f335411a;
                bv4.b bVar = this.$avatar;
                bv4.c cVar = this.$detail;
                bv4.e eVar = this.$outfit;
                this.label = 1;
                obj = jVar.c(bVar, cVar, eVar, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String str = (String) obj;
            if (str == null) {
                QLog.e("ZPlanOutfitPublishHelper", 1, "[triggerPublish] requestCreateOutfit failed.");
                nk3.h hVar = this.$callback;
                if (hVar != null) {
                    h.a.a(hVar, ZPlanAIGCStatusCode.CREATE_AIGC_FAILED, null, 2, null);
                }
                return Unit.INSTANCE;
            }
            nk3.h hVar2 = this.$callback;
            if (hVar2 != null) {
                hVar2.onSuccess(str);
            }
            return Unit.INSTANCE;
        } catch (Throwable th5) {
            QLog.e("ZPlanOutfitPublishHelper", 1, "[triggerPublish] requestCreateOutfit failed.", th5);
            nk3.h hVar3 = this.$callback;
            if (hVar3 != null) {
                h.a.a(hVar3, ZPlanAIGCStatusCode.CREATE_AIGC_FAILED, null, 2, null);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZPlanOutfitPublishHelper$triggerPublish$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
