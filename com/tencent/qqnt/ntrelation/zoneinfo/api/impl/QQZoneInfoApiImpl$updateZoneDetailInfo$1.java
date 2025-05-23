package com.tencent.qqnt.ntrelation.zoneinfo.api.impl;

import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.friend.api.IFriendExtensionService;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.e;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.ntrelation.zoneinfo.api.impl.QQZoneInfoApiImpl$updateZoneDetailInfo$1", f = "QQZoneInfoApiImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
final class QQZoneInfoApiImpl$updateZoneDetailInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppRuntime $app;
    final /* synthetic */ hx3.c<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> $iUpdateGeneralDataCallback;
    final /* synthetic */ ArrayList<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> $ntZoneSimpleInfoList;
    int label;
    final /* synthetic */ QQZoneInfoApiImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQZoneInfoApiImpl$updateZoneDetailInfo$1(AppRuntime appRuntime, ArrayList<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> arrayList, QQZoneInfoApiImpl qQZoneInfoApiImpl, hx3.c<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> cVar, Continuation<? super QQZoneInfoApiImpl$updateZoneDetailInfo$1> continuation) {
        super(2, continuation);
        this.$app = appRuntime;
        this.$ntZoneSimpleInfoList = arrayList;
        this.this$0 = qQZoneInfoApiImpl;
        this.$iUpdateGeneralDataCallback = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QQZoneInfoApiImpl$updateZoneDetailInfo$1(this.$app, this.$ntZoneSimpleInfoList, this.this$0, this.$iUpdateGeneralDataCallback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            IRuntimeService runtimeService = this.$app.getRuntimeService(IFriendExtensionService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IF\u2026va, ProcessConstant.MAIN)");
            IFriendExtensionService iFriendExtensionService = (IFriendExtensionService) runtimeService;
            ArrayList<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> arrayList = new ArrayList<>();
            ArrayList arrayList2 = new ArrayList();
            Iterator<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> it = this.$ntZoneSimpleInfoList.iterator();
            while (it.hasNext()) {
                com.tencent.qqnt.ntrelation.zoneinfo.bean.a ntZoneDetailInfo = it.next();
                ExtensionInfo extensionInfo = iFriendExtensionService.getExtensionInfo(ntZoneDetailInfo.o(), true);
                if (extensionInfo == null) {
                    extensionInfo = new ExtensionInfo();
                    extensionInfo.uin = ntZoneDetailInfo.o();
                }
                QQZoneInfoApiImpl qQZoneInfoApiImpl = this.this$0;
                Intrinsics.checkNotNullExpressionValue(ntZoneDetailInfo, "ntZoneDetailInfo");
                qQZoneInfoApiImpl.zoneDetailInfoTransferExtensionInfo(ntZoneDetailInfo, extensionInfo);
                arrayList2.add(extensionInfo);
                arrayList.add(ntZoneDetailInfo);
            }
            boolean saveExtensionInfoList = iFriendExtensionService.saveExtensionInfoList(arrayList2);
            e<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> eVar = new e<>();
            if (!saveExtensionInfoList) {
                eVar.d(-1);
            }
            eVar.e(arrayList);
            hx3.c<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> cVar = this.$iUpdateGeneralDataCallback;
            if (cVar != null) {
                cVar.onUpdateResult(eVar);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QQZoneInfoApiImpl$updateZoneDetailInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
