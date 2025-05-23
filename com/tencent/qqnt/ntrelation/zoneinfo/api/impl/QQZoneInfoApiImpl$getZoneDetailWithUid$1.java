package com.tencent.qqnt.ntrelation.zoneinfo.api.impl;

import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.friend.api.IFriendExtensionService;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.ntrelation.zoneinfo.api.impl.QQZoneInfoApiImpl$getZoneDetailWithUid$1", f = "QQZoneInfoApiImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class QQZoneInfoApiImpl$getZoneDetailWithUid$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IFriendExtensionService $friendExtensionService;
    final /* synthetic */ hx3.b<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> $iQueryGeneralDataCallback;
    final /* synthetic */ IRelationNTUinAndUidApi $relationNTUinAndUidApi;
    final /* synthetic */ ArrayList<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> $result;
    final /* synthetic */ String $trace;
    final /* synthetic */ ArrayList<String> $uidList;
    int label;
    final /* synthetic */ QQZoneInfoApiImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQZoneInfoApiImpl$getZoneDetailWithUid$1(ArrayList<String> arrayList, IRelationNTUinAndUidApi iRelationNTUinAndUidApi, IFriendExtensionService iFriendExtensionService, QQZoneInfoApiImpl qQZoneInfoApiImpl, hx3.b<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> bVar, String str, ArrayList<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> arrayList2, Continuation<? super QQZoneInfoApiImpl$getZoneDetailWithUid$1> continuation) {
        super(2, continuation);
        this.$uidList = arrayList;
        this.$relationNTUinAndUidApi = iRelationNTUinAndUidApi;
        this.$friendExtensionService = iFriendExtensionService;
        this.this$0 = qQZoneInfoApiImpl;
        this.$iQueryGeneralDataCallback = bVar;
        this.$trace = str;
        this.$result = arrayList2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QQZoneInfoApiImpl$getZoneDetailWithUid$1(this.$uidList, this.$relationNTUinAndUidApi, this.$friendExtensionService, this.this$0, this.$iQueryGeneralDataCallback, this.$trace, this.$result, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        com.tencent.qqnt.ntrelation.zoneinfo.bean.a friend2DetailInfo;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ArrayList<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> arrayList = new ArrayList<>();
            e<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> eVar = new e<>();
            Iterator<String> it = this.$uidList.iterator();
            while (it.hasNext()) {
                String uid = it.next();
                String uin = this.$relationNTUinAndUidApi.getUinFromUid(uid);
                ExtensionInfo extensionInfo = this.$friendExtensionService.getExtensionInfo(uin, true);
                QQZoneInfoApiImpl qQZoneInfoApiImpl = this.this$0;
                Intrinsics.checkNotNullExpressionValue(uin, "uin");
                Intrinsics.checkNotNullExpressionValue(uid, "uid");
                friend2DetailInfo = qQZoneInfoApiImpl.friend2DetailInfo(uin, uid, extensionInfo);
                arrayList.add(friend2DetailInfo);
            }
            eVar.e(arrayList);
            this.$iQueryGeneralDataCallback.onQueryResult(eVar);
            g.f383981a.b(this.$trace, this.$result);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QQZoneInfoApiImpl$getZoneDetailWithUid$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
