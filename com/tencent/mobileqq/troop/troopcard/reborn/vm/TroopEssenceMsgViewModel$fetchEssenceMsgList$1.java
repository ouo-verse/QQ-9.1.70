package com.tencent.mobileqq.troop.troopcard.reborn.vm;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopcard.reborn.repo.TroopCardRepo;
import com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopEssenceMsgViewModel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.EssenceMsgInfo;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupLatestEssenceListReq;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupLatestEssenceListRsp;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopEssenceMsgViewModel$fetchEssenceMsgList$1", f = "TroopEssenceMsgViewModel.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
public final class TroopEssenceMsgViewModel$fetchEssenceMsgList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    int label;
    final /* synthetic */ TroopEssenceMsgViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopEssenceMsgViewModel$fetchEssenceMsgList$1(TroopEssenceMsgViewModel troopEssenceMsgViewModel, Continuation<? super TroopEssenceMsgViewModel$fetchEssenceMsgList$1> continuation) {
        super(2, continuation);
        this.this$0 = troopEssenceMsgViewModel;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopEssenceMsgViewModel, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new TroopEssenceMsgViewModel$fetchEssenceMsgList$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        String str;
        String str2;
        TroopCardRepo troopCardRepo;
        MutableLiveData mutableLiveData;
        List list;
        List list2;
        int lastIndex;
        boolean z16;
        List list3;
        MutableLiveData mutableLiveData2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                GetGroupLatestEssenceListReq getGroupLatestEssenceListReq = new GetGroupLatestEssenceListReq();
                TroopEssenceMsgViewModel troopEssenceMsgViewModel = this.this$0;
                str = troopEssenceMsgViewModel.troopUin;
                getGroupLatestEssenceListReq.groupCode = Long.parseLong(str);
                getGroupLatestEssenceListReq.source = 1;
                str2 = troopEssenceMsgViewModel.cookie;
                getGroupLatestEssenceListReq.pageCookie = str2;
                getGroupLatestEssenceListReq.excludeMsgType = 4;
                troopCardRepo = this.this$0.repo;
                this.label = 1;
                obj = troopCardRepo.o(getGroupLatestEssenceListReq, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            GetGroupLatestEssenceListRsp getGroupLatestEssenceListRsp = (GetGroupLatestEssenceListRsp) obj;
            if (getGroupLatestEssenceListRsp == null) {
                QLog.e("TroopEssenceMsgViewModel", 1, "rsp is null");
                mutableLiveData2 = this.this$0._state;
                mutableLiveData2.setValue(TroopEssenceMsgViewModel.b.a.f299822a);
                return Unit.INSTANCE;
            }
            TroopEssenceMsgViewModel troopEssenceMsgViewModel2 = this.this$0;
            String str3 = getGroupLatestEssenceListRsp.nextPageCookie;
            Intrinsics.checkNotNullExpressionValue(str3, "rsp.nextPageCookie");
            troopEssenceMsgViewModel2.cookie = str3;
            ArrayList<EssenceMsgInfo> arrayList = getGroupLatestEssenceListRsp.msgList;
            Intrinsics.checkNotNullExpressionValue(arrayList, "rsp.msgList");
            TroopEssenceMsgViewModel troopEssenceMsgViewModel3 = this.this$0;
            int i16 = 0;
            for (Object obj2 : arrayList) {
                int i17 = i16 + 1;
                if (i16 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                EssenceMsgInfo msg2 = (EssenceMsgInfo) obj2;
                com.tencent.mobileqq.troop.troopcard.reborn.essence.message.a aVar = new com.tencent.mobileqq.troop.troopcard.reborn.essence.message.a();
                Intrinsics.checkNotNullExpressionValue(msg2, "msg");
                aVar.c(msg2);
                ArrayList<EssenceMsgInfo> arrayList2 = getGroupLatestEssenceListRsp.msgList;
                Intrinsics.checkNotNullExpressionValue(arrayList2, "rsp.msgList");
                lastIndex = CollectionsKt__CollectionsKt.getLastIndex(arrayList2);
                if (i16 == lastIndex) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                aVar.d(z16);
                list3 = troopEssenceMsgViewModel3.com.tencent.ttpic.openapi.util.VideoTemplateParser.ITEM_LIST java.lang.String;
                list3.add(aVar);
                i16 = i17;
            }
            mutableLiveData = this.this$0._state;
            list = this.this$0.com.tencent.ttpic.openapi.util.VideoTemplateParser.ITEM_LIST java.lang.String;
            list2 = CollectionsKt___CollectionsKt.toList(list);
            boolean z17 = getGroupLatestEssenceListRsp.isEnd;
            String str4 = getGroupLatestEssenceListRsp.jumpUrl;
            Intrinsics.checkNotNullExpressionValue(str4, "rsp.jumpUrl");
            mutableLiveData.setValue(new TroopEssenceMsgViewModel.b.C8797b(list2, z17, str4));
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((TroopEssenceMsgViewModel$fetchEssenceMsgList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
