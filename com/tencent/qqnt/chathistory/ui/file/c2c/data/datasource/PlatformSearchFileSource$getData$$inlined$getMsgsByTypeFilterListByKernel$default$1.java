package com.tencent.qqnt.chathistory.ui.file.c2c.data.datasource;

import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chathistory.service.KernelServiceKt$getMsgsByTypeFilterListByKernel$1$2;
import com.tencent.qqnt.chathistory.ui.file.c2c.data.model.FileItemModel;
import com.tencent.qqnt.chathistory.util.d;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.ChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
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
@DebugMetadata(c = "com.tencent.qqnt.chathistory.ui.file.c2c.data.datasource.PlatformSearchFileSource$getData$$inlined$getMsgsByTypeFilterListByKernel$default$1", f = "PlatformSearchFileSource.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes23.dex */
public final class PlatformSearchFileSource$getData$$inlined$getMsgsByTypeFilterListByKernel$default$1 extends SuspendLambda implements Function2<ProducerScope<? super List<? extends FileItemModel>>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ int $chartType$inlined;
    final /* synthetic */ int $chatType;
    final /* synthetic */ int $cnt;
    final /* synthetic */ long $filterEndTime;
    final /* synthetic */ List $filterSendUids;
    final /* synthetic */ long $filterStartTime;
    final /* synthetic */ long $msgId;
    final /* synthetic */ long $msgSeq;
    final /* synthetic */ long $msgTime;
    final /* synthetic */ String $peerId;
    final /* synthetic */ String $peerId$inlined;
    final /* synthetic */ List $typeFilters;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PlatformSearchFileSource this$0;

    @Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\f\u001a\u00020\t\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032*\u0010\b\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u0006H\n\u00a2\u0006\u0004\b\n\u0010\u000b"}, d2 = {"T", "", "result", "", "kotlin.jvm.PlatformType", "errMsg", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", TabPreloadItem.TAB_NAME_MESSAGE, "", "onResult", "(ILjava/lang/String;Ljava/util/ArrayList;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a implements IMsgOperateCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ProducerScope<List<? extends FileItemModel>> f353578a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ PlatformSearchFileSource f353579b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f353580c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f353581d;

        public a(ProducerScope producerScope, PlatformSearchFileSource platformSearchFileSource, String str, int i3) {
            this.f353579b = platformSearchFileSource;
            this.f353580c = str;
            this.f353581d = i3;
            this.f353578a = producerScope;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, producerScope, platformSearchFileSource, str, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
        public final void onResult(int i3, String errMsg, ArrayList<MsgRecord> msgList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), errMsg, msgList);
                return;
            }
            ProducerScope<List<? extends FileItemModel>> producerScope = this.f353578a;
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
            d.f354054a.a("PlatformSearchFileSource", "getMsgsByTypeFilterListByKernel result-> " + i3 + "  errMsg-> " + errMsg);
            producerScope.mo2003trySendJP2dKIU((i3 != 0 || msgList.isEmpty()) ? CollectionsKt__CollectionsKt.emptyList() : this.f353579b.e(msgList, this.f353580c, this.f353581d));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlatformSearchFileSource$getData$$inlined$getMsgsByTypeFilterListByKernel$default$1(long j3, long j16, long j17, int i3, String str, List list, List list2, long j18, long j19, int i16, Continuation continuation, PlatformSearchFileSource platformSearchFileSource, String str2, int i17) {
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
        this.this$0 = platformSearchFileSource;
        this.$peerId$inlined = str2;
        this.$chartType$inlined = i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Integer.valueOf(i3), str, list, list2, Long.valueOf(j18), Long.valueOf(j19), Integer.valueOf(i16), continuation, platformSearchFileSource, str2, Integer.valueOf(i17));
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        PlatformSearchFileSource$getData$$inlined$getMsgsByTypeFilterListByKernel$default$1 platformSearchFileSource$getData$$inlined$getMsgsByTypeFilterListByKernel$default$1 = new PlatformSearchFileSource$getData$$inlined$getMsgsByTypeFilterListByKernel$default$1(this.$msgId, this.$msgTime, this.$msgSeq, this.$chatType, this.$peerId, this.$typeFilters, this.$filterSendUids, this.$filterStartTime, this.$filterEndTime, this.$cnt, continuation, this.this$0, this.$peerId$inlined, this.$chartType$inlined);
        platformSearchFileSource$getData$$inlined$getMsgsByTypeFilterListByKernel$default$1.L$0 = obj;
        return platformSearchFileSource$getData$$inlined$getMsgsByTypeFilterListByKernel$default$1;
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
                a aVar = new a(producerScope2, this.this$0, this.$peerId$inlined, this.$chartType$inlined);
                QLog.d("KernelService", 1, "queryMsgsWithFilterEx  msgId " + this.$msgId + " msgTime " + this.$msgTime + ", msgSeq " + this.$msgSeq);
                c16 = com.tencent.qqnt.chathistory.service.d.c();
                if (c16 != null) {
                    long j3 = this.$msgId;
                    long j16 = this.$msgTime;
                    long j17 = this.$msgSeq;
                    obj2 = coroutine_suspended;
                    producerScope = producerScope2;
                    QueryMsgsParams queryMsgsParams = new QueryMsgsParams(new ChatInfo(this.$chatType, this.$peerId), new ArrayList(this.$typeFilters), new ArrayList(this.$filterSendUids), this.$filterStartTime, this.$filterEndTime, this.$cnt, false, false);
                    d.f354054a.a("KernelService", "queryMsgsWithFilterEx queryParam " + queryMsgsParams);
                    Unit unit = Unit.INSTANCE;
                    c16.queryMsgsWithFilterEx(j3, j16, j17, queryMsgsParams, aVar);
                } else {
                    obj2 = coroutine_suspended;
                    producerScope = producerScope2;
                }
                KernelServiceKt$getMsgsByTypeFilterListByKernel$1$2 kernelServiceKt$getMsgsByTypeFilterListByKernel$1$2 = KernelServiceKt$getMsgsByTypeFilterListByKernel$1$2.INSTANCE;
                this.label = 1;
                Object obj3 = obj2;
                if (ProduceKt.awaitClose(producerScope, kernelServiceKt$getMsgsByTypeFilterListByKernel$1$2, this) == obj3) {
                    return obj3;
                }
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super List<? extends FileItemModel>> producerScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((PlatformSearchFileSource$getData$$inlined$getMsgsByTypeFilterListByKernel$default$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) producerScope, (Object) continuation);
    }
}
