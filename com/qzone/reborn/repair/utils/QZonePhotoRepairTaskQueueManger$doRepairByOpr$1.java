package com.qzone.reborn.repair.utils;

import com.qzone.reborn.repair.bean.QZoneRepairTaskStateBean;
import com.tencent.mobileqq.opr.helper.repair.model.ImageInfo;
import com.tencent.mobileqq.opr.helper.repair.model.OprStatus;
import com.tencent.qphone.base.util.QLog;
import com.tencent.view.FilterEnum;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.qzone.reborn.repair.utils.QZonePhotoRepairTaskQueueManger$doRepairByOpr$1", f = "QZonePhotoRepairTaskQueueManger.kt", i = {0, 1, 1, 2, 2}, l = {272, 276, FilterEnum.MIC_PTU_BAIXI}, m = "invokeSuspend", n = {"startTime", "oprResult", "startTime", "oprResult", "startTime"}, s = {"J$0", "L$0", "J$0", "L$0", "J$0"})
/* loaded from: classes37.dex */
public final class QZonePhotoRepairTaskQueueManger$doRepairByOpr$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ QZoneRepairTaskStateBean $taskBean;
    long J$0;
    Object L$0;
    int label;
    final /* synthetic */ QZonePhotoRepairTaskQueueManger this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZonePhotoRepairTaskQueueManger$doRepairByOpr$1(QZoneRepairTaskStateBean qZoneRepairTaskStateBean, QZonePhotoRepairTaskQueueManger qZonePhotoRepairTaskQueueManger, Continuation<? super QZonePhotoRepairTaskQueueManger$doRepairByOpr$1> continuation) {
        super(2, continuation);
        this.$taskBean = qZoneRepairTaskStateBean;
        this.this$0 = qZonePhotoRepairTaskQueueManger;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QZonePhotoRepairTaskQueueManger$doRepairByOpr$1(this.$taskBean, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QZonePhotoRepairTaskQueueManger$doRepairByOpr$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ed A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00f6  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        long currentTimeMillis;
        Object f16;
        com.tencent.mobileqq.opr.helper.repair.model.a aVar;
        boolean z16;
        String b16;
        Object L;
        long j3;
        boolean z17;
        String b17;
        Object M;
        OprStatus e16;
        boolean z18;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            QLog.i("QZonePhotoRepairTaskQueueManger", 1, "[doRepairByOpr] start opr");
            currentTimeMillis = System.currentTimeMillis();
            ImageInfo imageInfo = new ImageInfo(this.$taskBean.getAlbumId(), this.$taskBean.getLloc(), this.$taskBean.getSrOriginUrl(), "", this.$taskBean.getTaskId());
            QZonePhotoRepairQNESingletonVM qZonePhotoRepairQNESingletonVM = QZonePhotoRepairQNESingletonVM.f59266a;
            this.J$0 = currentTimeMillis;
            this.label = 1;
            f16 = QZonePhotoRepairQNESingletonVM.f(qZonePhotoRepairQNESingletonVM, imageInfo, null, null, this, 6, null);
            if (f16 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        j3 = this.J$0;
                        aVar = (com.tencent.mobileqq.opr.helper.repair.model.a) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        M = obj;
                        if (!((Boolean) M).booleanValue()) {
                            aVar = new com.tencent.mobileqq.opr.helper.repair.model.a(OprStatus.UploadResultFail, null, null, null, 0, 30, null);
                        }
                        z18 = this.this$0.mIsRepairLayerFragmentShowing;
                        QLog.i("QZonePhotoRepairTaskQueueManger", 1, "[doRepairByOpr] end opr, showing=" + z18 + ", isSilentRepair=" + this.$taskBean.getIsSilentRepair() + ", oprResult=" + aVar + ", cost=" + (System.currentTimeMillis() - j3));
                        this.this$0.A(this.$taskBean, aVar);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                long j16 = this.J$0;
                aVar = (com.tencent.mobileqq.opr.helper.repair.model.a) this.L$0;
                ResultKt.throwOnFailure(obj);
                currentTimeMillis = j16;
                L = obj;
                Boxing.boxBoolean(((Boolean) L).booleanValue());
                j3 = currentTimeMillis;
                z17 = false;
                if (aVar != null && (e16 = aVar.e()) != null && e16.getSuccess()) {
                    z17 = true;
                }
                if (z17 && aVar.c() != null) {
                    b17 = aVar.b();
                    if (b17 == null) {
                        b17 = "";
                    }
                    QZonePhotoRepairTaskQueueManger qZonePhotoRepairTaskQueueManger = this.this$0;
                    int a16 = aVar.a();
                    this.L$0 = aVar;
                    this.J$0 = j3;
                    this.label = 3;
                    M = qZonePhotoRepairTaskQueueManger.M(b17, a16, 1, this);
                    if (M == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (!((Boolean) M).booleanValue()) {
                    }
                }
                z18 = this.this$0.mIsRepairLayerFragmentShowing;
                QLog.i("QZonePhotoRepairTaskQueueManger", 1, "[doRepairByOpr] end opr, showing=" + z18 + ", isSilentRepair=" + this.$taskBean.getIsSilentRepair() + ", oprResult=" + aVar + ", cost=" + (System.currentTimeMillis() - j3));
                this.this$0.A(this.$taskBean, aVar);
                return Unit.INSTANCE;
            }
            long j17 = this.J$0;
            ResultKt.throwOnFailure(obj);
            currentTimeMillis = j17;
            f16 = obj;
        }
        aVar = (com.tencent.mobileqq.opr.helper.repair.model.a) f16;
        z16 = this.this$0.mIsRepairLayerFragmentShowing;
        if (!z16 && !this.$taskBean.getIsSilentRepair() && aVar != null && (b16 = aVar.b()) != null) {
            QZonePhotoRepairTaskQueueManger qZonePhotoRepairTaskQueueManger2 = this.this$0;
            this.L$0 = aVar;
            this.J$0 = currentTimeMillis;
            this.label = 2;
            L = qZonePhotoRepairTaskQueueManger2.L(b16, this);
            if (L == coroutine_suspended) {
                return coroutine_suspended;
            }
            Boxing.boxBoolean(((Boolean) L).booleanValue());
        }
        j3 = currentTimeMillis;
        z17 = false;
        if (aVar != null) {
            z17 = true;
        }
        if (z17) {
            b17 = aVar.b();
            if (b17 == null) {
            }
            QZonePhotoRepairTaskQueueManger qZonePhotoRepairTaskQueueManger3 = this.this$0;
            int a162 = aVar.a();
            this.L$0 = aVar;
            this.J$0 = j3;
            this.label = 3;
            M = qZonePhotoRepairTaskQueueManger3.M(b17, a162, 1, this);
            if (M == coroutine_suspended) {
            }
            if (!((Boolean) M).booleanValue()) {
            }
        }
        z18 = this.this$0.mIsRepairLayerFragmentShowing;
        QLog.i("QZonePhotoRepairTaskQueueManger", 1, "[doRepairByOpr] end opr, showing=" + z18 + ", isSilentRepair=" + this.$taskBean.getIsSilentRepair() + ", oprResult=" + aVar + ", cost=" + (System.currentTimeMillis() - j3));
        this.this$0.A(this.$taskBean, aVar);
        return Unit.INSTANCE;
    }
}
