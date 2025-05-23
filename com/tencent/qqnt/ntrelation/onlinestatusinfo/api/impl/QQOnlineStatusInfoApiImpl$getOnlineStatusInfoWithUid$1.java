package com.tencent.qqnt.ntrelation.onlinestatusinfo.api.impl;

import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.e;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.g;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.ntrelation.onlinestatusinfo.api.impl.QQOnlineStatusInfoApiImpl$getOnlineStatusInfoWithUid$1", f = "QQOnlineStatusInfoApiImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
final class QQOnlineStatusInfoApiImpl$getOnlineStatusInfoWithUid$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IFriendDataService $friendDataService;
    final /* synthetic */ hx3.b<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> $iQueryGeneralDataCallback;
    final /* synthetic */ IRelationNTUinAndUidApi $relationNTUinAndUidApi;
    final /* synthetic */ ArrayList<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> $result;
    final /* synthetic */ String $trace;
    final /* synthetic */ ArrayList<String> $uids;
    int label;
    final /* synthetic */ QQOnlineStatusInfoApiImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQOnlineStatusInfoApiImpl$getOnlineStatusInfoWithUid$1(ArrayList<String> arrayList, IRelationNTUinAndUidApi iRelationNTUinAndUidApi, IFriendDataService iFriendDataService, QQOnlineStatusInfoApiImpl qQOnlineStatusInfoApiImpl, hx3.b<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> bVar, String str, ArrayList<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> arrayList2, Continuation<? super QQOnlineStatusInfoApiImpl$getOnlineStatusInfoWithUid$1> continuation) {
        super(2, continuation);
        this.$uids = arrayList;
        this.$relationNTUinAndUidApi = iRelationNTUinAndUidApi;
        this.$friendDataService = iFriendDataService;
        this.this$0 = qQOnlineStatusInfoApiImpl;
        this.$iQueryGeneralDataCallback = bVar;
        this.$trace = str;
        this.$result = arrayList2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QQOnlineStatusInfoApiImpl$getOnlineStatusInfoWithUid$1(this.$uids, this.$relationNTUinAndUidApi, this.$friendDataService, this.this$0, this.$iQueryGeneralDataCallback, this.$trace, this.$result, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a friend2DetailInfo;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ArrayList<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> arrayList = new ArrayList<>();
            e<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> eVar = new e<>();
            Iterator<String> it = this.$uids.iterator();
            while (it.hasNext()) {
                String uid = it.next();
                String uin = this.$relationNTUinAndUidApi.getUinFromUid(uid);
                Friends friend = this.$friendDataService.getFriend(uin, true);
                if (friend != null) {
                    QQOnlineStatusInfoApiImpl qQOnlineStatusInfoApiImpl = this.this$0;
                    Intrinsics.checkNotNullExpressionValue(uin, "uin");
                    Intrinsics.checkNotNullExpressionValue(uid, "uid");
                    friend2DetailInfo = qQOnlineStatusInfoApiImpl.friend2DetailInfo(uin, uid, friend);
                    arrayList.add(friend2DetailInfo);
                }
            }
            eVar.e(arrayList);
            this.$iQueryGeneralDataCallback.onQueryResult(eVar);
            g.f383981a.a(this.$trace, this.$result);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QQOnlineStatusInfoApiImpl$getOnlineStatusInfoWithUid$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
