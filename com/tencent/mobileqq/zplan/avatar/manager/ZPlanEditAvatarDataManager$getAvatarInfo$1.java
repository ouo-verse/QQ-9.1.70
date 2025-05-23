package com.tencent.mobileqq.zplan.avatar.manager;

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
import ze3.ZPlanEditAvatarConfigInfo;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.avatar.manager.ZPlanEditAvatarDataManager$getAvatarInfo$1", f = "ZPlanEditAvatarDataManager.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class ZPlanEditAvatarDataManager$getAvatarInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ a $callback;
    final /* synthetic */ int $gender;
    final /* synthetic */ long $uin;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanEditAvatarDataManager$getAvatarInfo$1(long j3, int i3, a aVar, Continuation<? super ZPlanEditAvatarDataManager$getAvatarInfo$1> continuation) {
        super(2, continuation);
        this.$uin = j3;
        this.$gender = i3;
        this.$callback = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZPlanEditAvatarDataManager$getAvatarInfo$1(this.$uin, this.$gender, this.$callback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        ZPlanEditAvatarAllConfigInfo i3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 == 0) {
            ResultKt.throwOnFailure(obj);
            QLog.i("ZPlanEditAvatarDataManager", 1, "[fetchEditAvatarConfig] start");
            ZPlanEditAvatarDataManager zPlanEditAvatarDataManager = ZPlanEditAvatarDataManager.f331961a;
            long j3 = this.$uin;
            int i17 = this.$gender;
            this.label = 1;
            obj = zPlanEditAvatarDataManager.e(j3, i17, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i16 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ZPlanEditAvatarConfigInfo zPlanEditAvatarConfigInfo = (ZPlanEditAvatarConfigInfo) obj;
        if (zPlanEditAvatarConfigInfo != null) {
            a aVar = this.$callback;
            QLog.i("ZPlanEditAvatarDataManager", 1, "[fetchEditAvatarConfig] success");
            i3 = ZPlanEditAvatarDataManager.f331961a.i(zPlanEditAvatarConfigInfo);
            aVar.a(true, i3);
            return Unit.INSTANCE;
        }
        QLog.i("ZPlanEditAvatarDataManager", 1, "[fetchEditAvatarConfig] result null.");
        this.$callback.a(false, null);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZPlanEditAvatarDataManager$getAvatarInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
