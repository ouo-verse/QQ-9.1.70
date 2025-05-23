package com.tencent.qqnt.ntrelation.onlinestatusinfo.api.impl;

import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.e;
import hx3.c;
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
@DebugMetadata(c = "com.tencent.qqnt.ntrelation.onlinestatusinfo.api.impl.QQOnlineStatusInfoApiImpl$updateOnlineStatusInfo$1", f = "QQOnlineStatusInfoApiImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
final class QQOnlineStatusInfoApiImpl$updateOnlineStatusInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppRuntime $app;
    final /* synthetic */ c<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> $iUpdateGeneralDataCallback;
    final /* synthetic */ ArrayList<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> $ntOnlineStatusDetailInfoList;
    int label;
    final /* synthetic */ QQOnlineStatusInfoApiImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQOnlineStatusInfoApiImpl$updateOnlineStatusInfo$1(AppRuntime appRuntime, ArrayList<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> arrayList, QQOnlineStatusInfoApiImpl qQOnlineStatusInfoApiImpl, c<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> cVar, Continuation<? super QQOnlineStatusInfoApiImpl$updateOnlineStatusInfo$1> continuation) {
        super(2, continuation);
        this.$app = appRuntime;
        this.$ntOnlineStatusDetailInfoList = arrayList;
        this.this$0 = qQOnlineStatusInfoApiImpl;
        this.$iUpdateGeneralDataCallback = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QQOnlineStatusInfoApiImpl$updateOnlineStatusInfo$1(this.$app, this.$ntOnlineStatusDetailInfoList, this.this$0, this.$iUpdateGeneralDataCallback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            IRuntimeService runtimeService = this.$app.getRuntimeService(IFriendDataService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IF\u2026va, ProcessConstant.MAIN)");
            IFriendDataService iFriendDataService = (IFriendDataService) runtimeService;
            e<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> eVar = new e<>();
            ArrayList<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> arrayList = new ArrayList<>();
            Iterator<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> it = this.$ntOnlineStatusDetailInfoList.iterator();
            while (it.hasNext()) {
                com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a ntOnlineStatusDetailInfo = it.next();
                Friends friend = iFriendDataService.getFriend(ntOnlineStatusDetailInfo.f0(), true);
                if (friend == null) {
                    friend = new Friends();
                    friend.uin = ntOnlineStatusDetailInfo.f0();
                }
                QQOnlineStatusInfoApiImpl qQOnlineStatusInfoApiImpl = this.this$0;
                Intrinsics.checkNotNullExpressionValue(ntOnlineStatusDetailInfo, "ntOnlineStatusDetailInfo");
                qQOnlineStatusInfoApiImpl.onlineStatusDetailInfoTransferFriend(ntOnlineStatusDetailInfo, friend);
                if (iFriendDataService.saveFriend(friend)) {
                    arrayList.add(ntOnlineStatusDetailInfo);
                }
            }
            eVar.e(arrayList);
            c<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> cVar = this.$iUpdateGeneralDataCallback;
            if (cVar != null) {
                cVar.onUpdateResult(eVar);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QQOnlineStatusInfoApiImpl$updateOnlineStatusInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
