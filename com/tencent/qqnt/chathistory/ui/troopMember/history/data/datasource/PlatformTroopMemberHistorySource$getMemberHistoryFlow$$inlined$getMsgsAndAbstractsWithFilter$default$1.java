package com.tencent.qqnt.chathistory.ui.troopMember.history.data.datasource;

import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chathistory.service.KernelServiceKt$getMsgsAndAbstractsWithFilter$1$1;
import com.tencent.qqnt.chathistory.util.d;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.ChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.IQueryMsgsAndAbstractsWithFilterCallback;
import com.tencent.qqnt.kernel.nativeinterface.QueriedMsgInfo;
import com.tencent.qqnt.kernel.nativeinterface.QueryMsgsParams;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/channels/ProducerScope;", "", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.chathistory.ui.troopMember.history.data.datasource.PlatformTroopMemberHistorySource$getMemberHistoryFlow$$inlined$getMsgsAndAbstractsWithFilter$default$1", f = "PlatformTroopMemberHistorySource.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes23.dex */
public final class PlatformTroopMemberHistorySource$getMemberHistoryFlow$$inlined$getMsgsAndAbstractsWithFilter$default$1 extends SuspendLambda implements Function2<ProducerScope<? super List<? extends com.tencent.qqnt.chathistory.ui.troopMember.history.data.model.a>>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ int $chatType;
    final /* synthetic */ int $cnt;
    final /* synthetic */ long $filterEndTime;
    final /* synthetic */ List $filterSendUids;
    final /* synthetic */ long $filterStartTime;
    final /* synthetic */ long $msgId;
    final /* synthetic */ long $msgSeq;
    final /* synthetic */ long $msgTime;
    final /* synthetic */ String $peerId;
    final /* synthetic */ List $typeFilters;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PlatformTroopMemberHistorySource this$0;

    @Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\f\u001a\u00020\t\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032*\u0010\b\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u0006H\n\u00a2\u0006\u0004\b\n\u0010\u000b"}, d2 = {"T", "", "result", "", "kotlin.jvm.PlatformType", "errMsg", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/QueriedMsgInfo;", TabPreloadItem.TAB_NAME_MESSAGE, "", "onResult", "(ILjava/lang/String;Ljava/util/ArrayList;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a implements IQueryMsgsAndAbstractsWithFilterCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ProducerScope<List<? extends com.tencent.qqnt.chathistory.ui.troopMember.history.data.model.a>> f353964a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ PlatformTroopMemberHistorySource f353965b;

        public a(ProducerScope producerScope, PlatformTroopMemberHistorySource platformTroopMemberHistorySource) {
            this.f353965b = platformTroopMemberHistorySource;
            this.f353964a = producerScope;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) producerScope, (Object) platformTroopMemberHistorySource);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQueryMsgsAndAbstractsWithFilterCallback
        public final void onResult(int i3, String errMsg, ArrayList<QueriedMsgInfo> arrayList) {
            List<? extends com.tencent.qqnt.chathistory.ui.troopMember.history.data.model.a> emptyList;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), errMsg, arrayList);
                return;
            }
            ProducerScope<List<? extends com.tencent.qqnt.chathistory.ui.troopMember.history.data.model.a>> producerScope = this.f353964a;
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            d.f354054a.a("PlatformTroopMemberHistorySource", "result: " + i3 + ", errMsg: " + errMsg);
            if (i3 == 0) {
                if (arrayList != null && !arrayList.isEmpty()) {
                    z16 = false;
                }
                if (!z16) {
                    emptyList = this.f353965b.d(arrayList);
                    producerScope.mo2003trySendJP2dKIU(emptyList);
                }
            }
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            producerScope.mo2003trySendJP2dKIU(emptyList);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlatformTroopMemberHistorySource$getMemberHistoryFlow$$inlined$getMsgsAndAbstractsWithFilter$default$1(long j3, long j16, long j17, int i3, String str, List list, List list2, long j18, long j19, int i16, Continuation continuation, PlatformTroopMemberHistorySource platformTroopMemberHistorySource) {
        super(2, continuation);
        this.$msgId = j3;
        this.$msgTime = j16;
        this.$msgSeq = j17;
        this.$chatType = i3;
        this.$peerId = str;
        this.$typeFilters = list;
        this.$filterSendUids = list2;
        this.$filterStartTime = j18;
        this.$filterEndTime = j19;
        this.$cnt = i16;
        this.this$0 = platformTroopMemberHistorySource;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Integer.valueOf(i3), str, list, list2, Long.valueOf(j18), Long.valueOf(j19), Integer.valueOf(i16), continuation, platformTroopMemberHistorySource);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        PlatformTroopMemberHistorySource$getMemberHistoryFlow$$inlined$getMsgsAndAbstractsWithFilter$default$1 platformTroopMemberHistorySource$getMemberHistoryFlow$$inlined$getMsgsAndAbstractsWithFilter$default$1 = new PlatformTroopMemberHistorySource$getMemberHistoryFlow$$inlined$getMsgsAndAbstractsWithFilter$default$1(this.$msgId, this.$msgTime, this.$msgSeq, this.$chatType, this.$peerId, this.$typeFilters, this.$filterSendUids, this.$filterStartTime, this.$filterEndTime, this.$cnt, continuation, this.this$0);
        platformTroopMemberHistorySource$getMemberHistoryFlow$$inlined$getMsgsAndAbstractsWithFilter$default$1.L$0 = obj;
        return platformTroopMemberHistorySource$getMemberHistoryFlow$$inlined$getMsgsAndAbstractsWithFilter$default$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        w c16;
        Object obj2;
        ProducerScope producerScope;
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
                ProducerScope producerScope2 = (ProducerScope) this.L$0;
                a aVar = new a(producerScope2, this.this$0);
                c16 = com.tencent.qqnt.chathistory.service.d.c();
                if (c16 != null) {
                    producerScope = producerScope2;
                    obj2 = coroutine_suspended;
                    c16.queryMsgsAndAbstractsWithFilter(this.$msgId, this.$msgTime, this.$msgSeq, new QueryMsgsParams(new ChatInfo(this.$chatType, this.$peerId), new ArrayList(this.$typeFilters), new ArrayList(this.$filterSendUids), this.$filterStartTime, this.$filterEndTime, this.$cnt, false, false), aVar);
                } else {
                    obj2 = coroutine_suspended;
                    producerScope = producerScope2;
                }
                KernelServiceKt$getMsgsAndAbstractsWithFilter$1$1 kernelServiceKt$getMsgsAndAbstractsWithFilter$1$1 = KernelServiceKt$getMsgsAndAbstractsWithFilter$1$1.INSTANCE;
                this.label = 1;
                Object obj3 = obj2;
                if (ProduceKt.awaitClose(producerScope, kernelServiceKt$getMsgsAndAbstractsWithFilter$1$1, this) == obj3) {
                    return obj3;
                }
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super List<? extends com.tencent.qqnt.chathistory.ui.troopMember.history.data.model.a>> producerScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((PlatformTroopMemberHistorySource$getMemberHistoryFlow$$inlined$getMsgsAndAbstractsWithFilter$default$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) producerScope, (Object) continuation);
    }
}
