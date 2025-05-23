package com.tencent.mobileqq.zplan.meme.api.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.meme.ZPlanRecordScene;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.meme.model.MemeResult;
import com.tencent.zplan.record.ZPlanRecordResourceCenter;
import com.tencent.zplan.record.model.SingleRecordRequestParams;
import com.tencent.zplan.record.model.Source;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import java.util.List;
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
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.meme.api.impl.MemeHelper$recordSingleActionByResourceCenter$1", f = "MemeHelperImpl.kt", i = {}, l = {99}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class MemeHelper$recordSingleActionByResourceCenter$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.tencent.zplan.meme.a $listener;
    final /* synthetic */ SingleRecordRequestParams $params;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemeHelper$recordSingleActionByResourceCenter$1(SingleRecordRequestParams singleRecordRequestParams, com.tencent.zplan.meme.a aVar, Continuation<? super MemeHelper$recordSingleActionByResourceCenter$1> continuation) {
        super(2, continuation);
        this.$params = singleRecordRequestParams;
        this.$listener = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MemeHelper$recordSingleActionByResourceCenter$1(this.$params, this.$listener, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ZPlanRecordResourceCenter zPlanRecordResourceCenter = ZPlanRecordResourceCenter.f386003a;
            SingleRecordRequestParams singleRecordRequestParams = this.$params;
            List<Source> recordSourceWhenUsingFilament = ((IZPlanApi) QRoute.api(IZPlanApi.class)).getRecordSourceWhenUsingFilament(ZPlanRecordScene.HEAD_PORTRAIT);
            this.label = 1;
            obj = zPlanRecordResourceCenter.h(singleRecordRequestParams, recordSourceWhenUsingFilament, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ZPlanRecordResource zPlanRecordResource = (ZPlanRecordResource) obj;
        boolean z16 = zPlanRecordResource != null && zPlanRecordResource.o();
        QLog.i(MemeHelper.TAG, 1, "recordSingleActionByResourceCenter, success:" + z16 + ", result:" + zPlanRecordResource);
        com.tencent.zplan.meme.a aVar = this.$listener;
        if (aVar != null) {
            aVar.l9(z16, new MemeResult(this.$params.a(), this.$params.a().getKey(), zPlanRecordResource != null ? zPlanRecordResource.getLocalPath() : null));
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MemeHelper$recordSingleActionByResourceCenter$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
