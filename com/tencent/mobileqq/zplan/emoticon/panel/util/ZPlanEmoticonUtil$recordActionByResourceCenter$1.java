package com.tencent.mobileqq.zplan.emoticon.panel.util;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.emoticon.panel.util.ZPlanEmoticonUtil;
import com.tencent.mobileqq.zplan.meme.ZPlanRecordScene;
import com.tencent.mobileqq.zplan.model.ZPlanActionInfo;
import com.tencent.zplan.meme.Priority;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.record.ZPlanRecordResourceCenter;
import com.tencent.zplan.record.model.SingleRecordRequestParams;
import com.tencent.zplan.record.model.Source;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import nh3.ZPlanEmoticonReportData;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.emoticon.panel.util.ZPlanEmoticonUtil$recordActionByResourceCenter$1", f = "ZPlanEmoticonUtil.kt", i = {1}, l = {728, 740}, m = "invokeSuspend", n = {"recordParams"}, s = {"L$0"})
/* loaded from: classes34.dex */
public final class ZPlanEmoticonUtil$recordActionByResourceCenter$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ZPlanActionInfo $actionInfo;
    final /* synthetic */ jh3.b $listener;
    final /* synthetic */ MODE $mode;
    final /* synthetic */ Priority $priority;
    final /* synthetic */ String $uin;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanEmoticonUtil$recordActionByResourceCenter$1(ZPlanActionInfo zPlanActionInfo, String str, MODE mode, Priority priority, jh3.b bVar, Continuation<? super ZPlanEmoticonUtil$recordActionByResourceCenter$1> continuation) {
        super(2, continuation);
        this.$actionInfo = zPlanActionInfo;
        this.$uin = str;
        this.$mode = mode;
        this.$priority = priority;
        this.$listener = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZPlanEmoticonUtil$recordActionByResourceCenter$1(this.$actionInfo, this.$uin, this.$mode, this.$priority, this.$listener, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x009a  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        boolean C;
        boolean B;
        SingleRecordRequestParams singleRecordRequestParams;
        List listOf;
        ConcurrentHashMap concurrentHashMap;
        boolean C2;
        jh3.b bVar;
        ZPlanEmoticonReportData e06;
        ConcurrentHashMap concurrentHashMap2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ZPlanEmoticonUtil zPlanEmoticonUtil = ZPlanEmoticonUtil.f333176e;
            ZPlanActionInfo zPlanActionInfo = this.$actionInfo;
            String str = this.$uin;
            MODE mode = this.$mode;
            Priority priority = this.$priority;
            this.label = 1;
            obj = ZPlanEmoticonUtil.n0(zPlanEmoticonUtil, zPlanActionInfo, str, mode, priority, 0, this, 8, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    singleRecordRequestParams = (SingleRecordRequestParams) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    ZPlanRecordResource zPlanRecordResource = (ZPlanRecordResource) obj;
                    ZPlanEmoticonUtil zPlanEmoticonUtil2 = ZPlanEmoticonUtil.f333176e;
                    C2 = zPlanEmoticonUtil2.C();
                    if (C2) {
                        concurrentHashMap2 = ZPlanEmoticonUtil.idActionMap;
                        concurrentHashMap2.remove(Boxing.boxInt(singleRecordRequestParams.getResourceId()));
                    }
                    boolean z16 = zPlanRecordResource == null && zPlanRecordResource.o();
                    bVar = this.$listener;
                    if (bVar != null) {
                        String localPath = zPlanRecordResource != null ? zPlanRecordResource.getLocalPath() : null;
                        e06 = zPlanEmoticonUtil2.e0(zPlanRecordResource != null ? zPlanRecordResource.getStatistic() : null);
                        bVar.a(z16, localPath, e06, this.$mode);
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        SingleRecordRequestParams singleRecordRequestParams2 = (SingleRecordRequestParams) obj;
        ZPlanEmoticonUtil zPlanEmoticonUtil3 = ZPlanEmoticonUtil.f333176e;
        C = zPlanEmoticonUtil3.C();
        if (C) {
            concurrentHashMap = ZPlanEmoticonUtil.idActionMap;
            concurrentHashMap.put(Boxing.boxInt(singleRecordRequestParams2.getResourceId()), new ZPlanEmoticonUtil.PairEntry(singleRecordRequestParams2, this.$actionInfo));
        }
        List<Source> recordSourceWhenUsingFilament = ((IZPlanApi) QRoute.api(IZPlanApi.class)).getRecordSourceWhenUsingFilament(ZPlanRecordScene.EMOTICON);
        B = zPlanEmoticonUtil3.B();
        if (!B) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(Source.CLOUD_CACHE);
            recordSourceWhenUsingFilament = CollectionsKt___CollectionsKt.minus((Iterable) recordSourceWhenUsingFilament, (Iterable) listOf);
        }
        ZPlanRecordResourceCenter zPlanRecordResourceCenter = ZPlanRecordResourceCenter.f386003a;
        this.L$0 = singleRecordRequestParams2;
        this.label = 2;
        Object h16 = zPlanRecordResourceCenter.h(singleRecordRequestParams2, recordSourceWhenUsingFilament, this);
        if (h16 == coroutine_suspended) {
            return coroutine_suspended;
        }
        singleRecordRequestParams = singleRecordRequestParams2;
        obj = h16;
        ZPlanRecordResource zPlanRecordResource2 = (ZPlanRecordResource) obj;
        ZPlanEmoticonUtil zPlanEmoticonUtil22 = ZPlanEmoticonUtil.f333176e;
        C2 = zPlanEmoticonUtil22.C();
        if (C2) {
        }
        if (zPlanRecordResource2 == null) {
        }
        bVar = this.$listener;
        if (bVar != null) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZPlanEmoticonUtil$recordActionByResourceCenter$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
