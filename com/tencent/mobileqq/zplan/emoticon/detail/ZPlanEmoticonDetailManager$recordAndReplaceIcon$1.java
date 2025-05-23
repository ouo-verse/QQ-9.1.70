package com.tencent.mobileqq.zplan.emoticon.detail;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmoticonApi;
import com.tencent.mobileqq.zplan.meme.ZPlanRecordScene;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.zplan.record.ZPlanRecordResourceCenter;
import com.tencent.zplan.record.model.GeneralRecordSwitches;
import com.tencent.zplan.record.model.SingleRecordRequestParams;
import com.tencent.zplan.record.model.Source;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.emoticon.detail.ZPlanEmoticonDetailManager$recordAndReplaceIcon$1", f = "ZPlanEmoticonDetailManager.kt", i = {}, l = {128}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class ZPlanEmoticonDetailManager$recordAndReplaceIcon$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $uin;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanEmoticonDetailManager$recordAndReplaceIcon$1(String str, Continuation<? super ZPlanEmoticonDetailManager$recordAndReplaceIcon$1> continuation) {
        super(2, continuation);
        this.$uin = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZPlanEmoticonDetailManager$recordAndReplaceIcon$1(this.$uin, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        SingleRecordRequestParams k3;
        List<Source> plus;
        Drawable i3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 == 0) {
            ResultKt.throwOnFailure(obj);
            GeneralRecordSwitches generalRecordSwitchesByScene = ZPlanQQMC.INSTANCE.getGeneralRecordSwitchesByScene(ZPlanRecordScene.EMOTICON_DETAIL);
            k3 = ZPlanEmoticonDetailManager.f333107a.k(this.$uin, generalRecordSwitchesByScene);
            if (generalRecordSwitchesByScene.getCloudSwitches().getEnableCloudCache()) {
                plus = CollectionsKt___CollectionsKt.plus((Collection<? extends Source>) ((Collection<? extends Object>) Source.LOCAL_CACHE.plus(Source.CLOUD_CACHE)), Source.LOCAL_RECORD);
            } else {
                plus = Source.LOCAL_CACHE.plus(Source.LOCAL_RECORD);
            }
            ZPlanRecordResourceCenter zPlanRecordResourceCenter = ZPlanRecordResourceCenter.f386003a;
            this.label = 1;
            obj = zPlanRecordResourceCenter.h(k3, plus, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i16 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ZPlanRecordResource zPlanRecordResource = (ZPlanRecordResource) obj;
        if (zPlanRecordResource != null && zPlanRecordResource.o()) {
            WeakReference weakReference = ZPlanEmoticonDetailManager.zPlanEmoticonDetailRequestListenerRef;
            IZPlanEmoticonApi.b bVar = weakReference != null ? (IZPlanEmoticonApi.b) weakReference.get() : null;
            if (bVar == null) {
                QLog.e("ZPlanEmoticonDetailUtil", 1, "recordAndReplaceIcon listener == null");
                return Unit.INSTANCE;
            }
            ZPlanEmoticonDetailManager zPlanEmoticonDetailManager = ZPlanEmoticonDetailManager.f333107a;
            Intrinsics.checkNotNull(zPlanRecordResource);
            String localPath = zPlanRecordResource.getLocalPath();
            Intrinsics.checkNotNull(localPath);
            i3 = zPlanEmoticonDetailManager.i(localPath);
            bVar.a(i3, zPlanEmoticonDetailManager.m(), zPlanEmoticonDetailManager.o());
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZPlanEmoticonDetailManager$recordAndReplaceIcon$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
