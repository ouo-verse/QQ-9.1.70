package com.tencent.mobileqq.zplan.avatar.edit;

import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.meme.Priority;
import com.tencent.zplan.meme.model.MemeResult;
import com.tencent.zplan.record.ZPlanRecordResourceCenter;
import com.tencent.zplan.record.model.GeneralRecordParams;
import com.tencent.zplan.record.model.ZPlanRecordResource;
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
@DebugMetadata(c = "com.tencent.mobileqq.zplan.avatar.edit.ZPlanEditAvatarUtils$recordEditAvatar$1", f = "ZPlanEditAvatarUtils.kt", i = {0}, l = {93}, m = "invokeSuspend", n = {"recordParams"}, s = {"L$0"})
/* loaded from: classes35.dex */
public final class ZPlanEditAvatarUtils$recordEditAvatar$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.tencent.zplan.meme.a $memeListener;
    final /* synthetic */ int $portraitId;
    final /* synthetic */ Priority $priority;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanEditAvatarUtils$recordEditAvatar$1(int i3, Priority priority, com.tencent.zplan.meme.a aVar, Continuation<? super ZPlanEditAvatarUtils$recordEditAvatar$1> continuation) {
        super(2, continuation);
        this.$portraitId = i3;
        this.$priority = priority;
        this.$memeListener = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZPlanEditAvatarUtils$recordEditAvatar$1(this.$portraitId, this.$priority, this.$memeListener, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        GeneralRecordParams generalRecordParams;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            GeneralRecordParams U = ZPlanEditAvatarUtils.U(ZPlanEditAvatarUtils.f331613a, this.$portraitId, null, this.$priority, 2, null);
            ZPlanRecordResourceCenter zPlanRecordResourceCenter = ZPlanRecordResourceCenter.f386003a;
            this.L$0 = U;
            this.label = 1;
            Object g16 = zPlanRecordResourceCenter.g(U, this);
            if (g16 == coroutine_suspended) {
                return coroutine_suspended;
            }
            generalRecordParams = U;
            obj = g16;
        } else if (i3 == 1) {
            generalRecordParams = (GeneralRecordParams) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ZPlanRecordResource zPlanRecordResource = (ZPlanRecordResource) obj;
        boolean z16 = zPlanRecordResource != null && zPlanRecordResource.o();
        QLog.i("[ZPlanEditAvatarUtils]", 1, "requestSingleRecordResource, success:" + z16 + ", result:" + zPlanRecordResource);
        com.tencent.zplan.meme.a aVar = this.$memeListener;
        if (aVar != null) {
            aVar.l9(z16, new MemeResult(generalRecordParams.b().a(), generalRecordParams.b().a().getKey(), zPlanRecordResource != null ? zPlanRecordResource.getLocalPath() : null));
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZPlanEditAvatarUtils$recordEditAvatar$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
