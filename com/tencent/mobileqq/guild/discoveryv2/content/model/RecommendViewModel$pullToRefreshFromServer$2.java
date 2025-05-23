package com.tencent.mobileqq.guild.discoveryv2.content.model;

import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendExtData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.q;
import com.tencent.mobileqq.guild.discoveryv2.net.DataType;
import com.tencent.mobileqq.guild.discoveryv2.net.NetTransaction;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendContentItem;
import com.tencent.mobileqq.qqguildsdk.data.genc.bj;
import java.util.ArrayList;
import java.util.LinkedList;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\b\u0001\u0012\u00020\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/net/h;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/bj;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/d;", "<name for destructuring parameter 0>", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.discoveryv2.content.model.RecommendViewModel$pullToRefreshFromServer$2", f = "RecommendViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class RecommendViewModel$pullToRefreshFromServer$2 extends SuspendLambda implements Function2<NetTransaction<bj, ? extends d>, Continuation<? super Unit>, Object> {
    final /* synthetic */ PullToRefreshArgs $pullToRefreshArgs;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RecommendViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendViewModel$pullToRefreshFromServer$2(RecommendViewModel recommendViewModel, PullToRefreshArgs pullToRefreshArgs, Continuation<? super RecommendViewModel$pullToRefreshFromServer$2> continuation) {
        super(2, continuation);
        this.this$0 = recommendViewModel;
        this.$pullToRefreshArgs = pullToRefreshArgs;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        RecommendViewModel$pullToRefreshFromServer$2 recommendViewModel$pullToRefreshFromServer$2 = new RecommendViewModel$pullToRefreshFromServer$2(this.this$0, this.$pullToRefreshArgs, continuation);
        recommendViewModel$pullToRefreshFromServer$2.L$0 = obj;
        return recommendViewModel$pullToRefreshFromServer$2;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull NetTransaction<bj, ? extends d> netTransaction, @Nullable Continuation<? super Unit> continuation) {
        return ((RecommendViewModel$pullToRefreshFromServer$2) create(netTransaction, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00a7  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        List<com.tencent.mobileqq.guild.discoveryv2.content.base.h> a16;
        List<com.tencent.mobileqq.guild.discoveryv2.content.base.h> list;
        LinkedList S1;
        LinkedList S12;
        LinkedList S13;
        LinkedList S14;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            NetTransaction netTransaction = (NetTransaction) this.L$0;
            bj bjVar = (bj) netTransaction.a();
            d dVar = (d) netTransaction.b();
            DataType from = netTransaction.getFrom();
            boolean z16 = true;
            if (from == DataType.FILE) {
                S14 = this.this$0.S1();
                if (!S14.isEmpty()) {
                    a16 = CollectionsKt__CollectionsKt.emptyList();
                    list = a16;
                    if (!list.isEmpty()) {
                        S12 = this.this$0.S1();
                        S12.clear();
                        S13 = this.this$0.S1();
                        S13.addAll(list);
                    }
                    RecommendViewModel recommendViewModel = this.this$0;
                    if (from != DataType.NET) {
                        z16 = false;
                    }
                    ri1.a result = dVar.getResult();
                    PullToRefreshType pullToRefreshType = this.$pullToRefreshArgs.getPullToRefreshType();
                    S1 = this.this$0.S1();
                    recommendViewModel.f2(new PullToRefreshState(z16, result, pullToRefreshType, S1, false, null, 48, null));
                    return Unit.INSTANCE;
                }
            }
            if (!dVar.getResult().d()) {
                a16 = CollectionsKt__CollectionsKt.emptyList();
            } else if (dVar.getRaw() == null) {
                a16 = CollectionsKt__CollectionsKt.emptyList();
            } else {
                String traceId = dVar.getRaw().getExtInfo().getTraceId();
                Intrinsics.checkNotNullExpressionValue(traceId, "rsp.raw.extInfo.traceId");
                RecommendExtData recommendExtData = new RecommendExtData(traceId, bjVar.f(), null, null, 0, 28, null);
                ArrayList<IGProRecommendContentItem> recommendList = dVar.getRaw().getRecommendList();
                Intrinsics.checkNotNullExpressionValue(recommendList, "rsp.raw.recommendList");
                a16 = q.a(recommendList, recommendExtData);
            }
            list = a16;
            if (!list.isEmpty()) {
            }
            RecommendViewModel recommendViewModel2 = this.this$0;
            if (from != DataType.NET) {
            }
            ri1.a result2 = dVar.getResult();
            PullToRefreshType pullToRefreshType2 = this.$pullToRefreshArgs.getPullToRefreshType();
            S1 = this.this$0.S1();
            recommendViewModel2.f2(new PullToRefreshState(z16, result2, pullToRefreshType2, S1, false, null, 48, null));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
