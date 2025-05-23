package com.tencent.sqshow.zootopia.nativeui.adapter.holder;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.adapter.holder.DressUpItemRecordHelper;
import com.tencent.zplan.record.ZPlanRecordResourceCenter;
import com.tencent.zplan.record.model.SingleRecordRequestParams;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.sqshow.zootopia.nativeui.adapter.holder.DressUpItemRecordHelper$startAvatarTemplateRecord$1$1", f = "DressUpItemRecordHelper.kt", i = {}, l = {76}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class DressUpItemRecordHelper$startAvatarTemplateRecord$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $dressKey;
    final /* synthetic */ String $logTag;
    final /* synthetic */ SingleRecordRequestParams $recordParam;
    final /* synthetic */ long $startTimeStamp;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DressUpItemRecordHelper$startAvatarTemplateRecord$1$1(String str, SingleRecordRequestParams singleRecordRequestParams, long j3, String str2, Continuation<? super DressUpItemRecordHelper$startAvatarTemplateRecord$1$1> continuation) {
        super(2, continuation);
        this.$logTag = str;
        this.$recordParam = singleRecordRequestParams;
        this.$startTimeStamp = j3;
        this.$dressKey = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(String str, final String str2, final ZPlanRecordResource zPlanRecordResource) {
        HashMap hashMap;
        QLog.i("DressUpItemViewHolder_DressUpItemRecordHelper", 1, str + " AvatarTemplateRecord# FINISH - post");
        hashMap = DressUpItemRecordHelper.recordLoadingMap;
        hashMap.remove(str2);
        DressUpItemRecordHelper dressUpItemRecordHelper = DressUpItemRecordHelper.f370779a;
        dressUpItemRecordHelper.j(str2, new Function1<DressUpItemRecordHelper.a, Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.adapter.holder.DressUpItemRecordHelper$startAvatarTemplateRecord$1$1$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DressUpItemRecordHelper.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DressUpItemRecordHelper.a recordListener) {
                Intrinsics.checkNotNullParameter(recordListener, "recordListener");
                recordListener.a(str2, zPlanRecordResource);
            }
        });
        dressUpItemRecordHelper.p(str2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DressUpItemRecordHelper$startAvatarTemplateRecord$1$1(this.$logTag, this.$recordParam, this.$startTimeStamp, this.$dressKey, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            QLog.i("DressUpItemViewHolder_DressUpItemRecordHelper", 1, this.$logTag + " AvatarTemplateRecord# BEGIN real! recordParam = " + this.$recordParam);
            ZPlanRecordResourceCenter zPlanRecordResourceCenter = ZPlanRecordResourceCenter.f386003a;
            SingleRecordRequestParams singleRecordRequestParams = this.$recordParam;
            this.label = 1;
            obj = ZPlanRecordResourceCenter.i(zPlanRecordResourceCenter, singleRecordRequestParams, null, this, 2, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final ZPlanRecordResource zPlanRecordResource = (ZPlanRecordResource) obj;
        String str = this.$logTag;
        Boolean boxBoolean = zPlanRecordResource != null ? Boxing.boxBoolean(zPlanRecordResource.o()) : null;
        Boolean boxBoolean2 = zPlanRecordResource != null ? Boxing.boxBoolean(zPlanRecordResource.p()) : null;
        QLog.i("DressUpItemViewHolder_DressUpItemRecordHelper", 1, str + " AvatarTemplateRecord# FINISH: " + zPlanRecordResource + ", isLocal= " + boxBoolean + ", isRemote= " + boxBoolean2 + ", totalCostTime = " + (System.currentTimeMillis() - this.$startTimeStamp));
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final String str2 = this.$logTag;
        final String str3 = this.$dressKey;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.adapter.holder.o
            @Override // java.lang.Runnable
            public final void run() {
                DressUpItemRecordHelper$startAvatarTemplateRecord$1$1.b(str2, str3, zPlanRecordResource);
            }
        });
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DressUpItemRecordHelper$startAvatarTemplateRecord$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
