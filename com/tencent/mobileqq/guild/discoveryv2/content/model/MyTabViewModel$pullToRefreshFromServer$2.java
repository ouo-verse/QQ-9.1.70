package com.tencent.mobileqq.guild.discoveryv2.content.model;

import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendExtData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.n;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.q;
import com.tencent.mobileqq.guild.discoveryv2.net.DataType;
import com.tencent.mobileqq.guild.discoveryv2.net.NetTransaction;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendContentItem;
import com.tencent.mobileqq.qqguildsdk.data.genc.br;
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
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\b\u0001\u0012\u00020\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/net/h;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/br;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/c;", "<name for destructuring parameter 0>", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.discoveryv2.content.model.MyTabViewModel$pullToRefreshFromServer$2", f = "MyTabViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class MyTabViewModel$pullToRefreshFromServer$2 extends SuspendLambda implements Function2<NetTransaction<br, ? extends c>, Continuation<? super Unit>, Object> {
    final /* synthetic */ PullToRefreshArgs $pullToRefreshArgs;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MyTabViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyTabViewModel$pullToRefreshFromServer$2(MyTabViewModel myTabViewModel, PullToRefreshArgs pullToRefreshArgs, Continuation<? super MyTabViewModel$pullToRefreshFromServer$2> continuation) {
        super(2, continuation);
        this.this$0 = myTabViewModel;
        this.$pullToRefreshArgs = pullToRefreshArgs;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        MyTabViewModel$pullToRefreshFromServer$2 myTabViewModel$pullToRefreshFromServer$2 = new MyTabViewModel$pullToRefreshFromServer$2(this.this$0, this.$pullToRefreshArgs, continuation);
        myTabViewModel$pullToRefreshFromServer$2.L$0 = obj;
        return myTabViewModel$pullToRefreshFromServer$2;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull NetTransaction<br, ? extends c> netTransaction, @Nullable Continuation<? super Unit> continuation) {
        return ((MyTabViewModel$pullToRefreshFromServer$2) create(netTransaction, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e5  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        List<com.tencent.mobileqq.guild.discoveryv2.content.base.h> a16;
        List<com.tencent.mobileqq.guild.discoveryv2.content.base.h> list;
        boolean z16;
        boolean z17;
        LinkedList S1;
        LinkedList S12;
        LinkedList S13;
        LinkedList S14;
        LinkedList S15;
        LinkedList S16;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            NetTransaction netTransaction = (NetTransaction) this.L$0;
            br brVar = (br) netTransaction.a();
            c cVar = (c) netTransaction.b();
            DataType from = netTransaction.getFrom();
            if (from == DataType.FILE) {
                S16 = this.this$0.S1();
                if (!S16.isEmpty()) {
                    a16 = CollectionsKt__CollectionsKt.emptyList();
                    list = a16;
                    if (!list.isEmpty()) {
                        S14 = this.this$0.S1();
                        S14.clear();
                        S15 = this.this$0.S1();
                        S15.addAll(list);
                    }
                    if (!cVar.getResult().d() && (a16.isEmpty() || cVar.getNoGuild())) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        S12 = this.this$0.S1();
                        S12.clear();
                        S13 = this.this$0.S1();
                        S13.add(n.f217127d);
                    }
                    MyTabViewModel myTabViewModel = this.this$0;
                    if (from != DataType.NET) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    ri1.a result = cVar.getResult();
                    PullToRefreshType pullToRefreshType = this.$pullToRefreshArgs.getPullToRefreshType();
                    S1 = this.this$0.S1();
                    myTabViewModel.f2(new PullToRefreshState(z17, result, pullToRefreshType, S1, z16, ""));
                    return Unit.INSTANCE;
                }
            }
            if (!cVar.getResult().d()) {
                a16 = CollectionsKt__CollectionsKt.emptyList();
            } else if (cVar.getRaw() == null) {
                a16 = CollectionsKt__CollectionsKt.emptyList();
            } else {
                String traceId = cVar.getRaw().getCommonRsp().getExtInfo().getTraceId();
                Intrinsics.checkNotNullExpressionValue(traceId, "rsp.raw.commonRsp.extInfo.traceId");
                RecommendExtData recommendExtData = new RecommendExtData(traceId, brVar.a().e(), null, null, 0, 28, null);
                ArrayList<IGProRecommendContentItem> recommendList = cVar.getRaw().getCommonRsp().getRecommendList();
                Intrinsics.checkNotNullExpressionValue(recommendList, "rsp.raw.commonRsp.recommendList");
                a16 = q.a(recommendList, recommendExtData);
            }
            list = a16;
            if (!list.isEmpty()) {
            }
            if (!cVar.getResult().d()) {
            }
            z16 = false;
            if (z16) {
            }
            MyTabViewModel myTabViewModel2 = this.this$0;
            if (from != DataType.NET) {
            }
            ri1.a result2 = cVar.getResult();
            PullToRefreshType pullToRefreshType2 = this.$pullToRefreshArgs.getPullToRefreshType();
            S1 = this.this$0.S1();
            myTabViewModel2.f2(new PullToRefreshState(z17, result2, pullToRefreshType2, S1, z16, ""));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
