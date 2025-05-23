package com.tencent.mobileqq.guild.discoveryv2.content.model;

import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendExtData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.o;
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
@DebugMetadata(c = "com.tencent.mobileqq.guild.discoveryv2.content.model.MyTabViewModel$loadMoreFormServer$1", f = "MyTabViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class MyTabViewModel$loadMoreFormServer$1 extends SuspendLambda implements Function2<NetTransaction<br, ? extends c>, Continuation<? super Unit>, Object> {
    final /* synthetic */ LoadMoreArgs $loadMoreArgs;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MyTabViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyTabViewModel$loadMoreFormServer$1(MyTabViewModel myTabViewModel, LoadMoreArgs loadMoreArgs, Continuation<? super MyTabViewModel$loadMoreFormServer$1> continuation) {
        super(2, continuation);
        this.this$0 = myTabViewModel;
        this.$loadMoreArgs = loadMoreArgs;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        MyTabViewModel$loadMoreFormServer$1 myTabViewModel$loadMoreFormServer$1 = new MyTabViewModel$loadMoreFormServer$1(this.this$0, this.$loadMoreArgs, continuation);
        myTabViewModel$loadMoreFormServer$1.L$0 = obj;
        return myTabViewModel$loadMoreFormServer$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull NetTransaction<br, ? extends c> netTransaction, @Nullable Continuation<? super Unit> continuation) {
        return ((MyTabViewModel$loadMoreFormServer$1) create(netTransaction, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        List<com.tencent.mobileqq.guild.discoveryv2.content.base.h> a16;
        LinkedList S1;
        boolean z16;
        LinkedList S12;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            NetTransaction netTransaction = (NetTransaction) this.L$0;
            br brVar = (br) netTransaction.a();
            c cVar = (c) netTransaction.b();
            if (netTransaction.getFrom() != DataType.NET) {
                a16 = CollectionsKt__CollectionsKt.emptyList();
            } else if (!cVar.getResult().d()) {
                a16 = CollectionsKt__CollectionsKt.emptyList();
            } else if (cVar.getRaw() == null) {
                a16 = CollectionsKt__CollectionsKt.emptyList();
            } else {
                ArrayList<IGProRecommendContentItem> recommendList = cVar.getRaw().getCommonRsp().getRecommendList();
                Intrinsics.checkNotNullExpressionValue(recommendList, "rsp.raw.commonRsp.recommendList");
                String traceId = cVar.getRaw().getCommonRsp().getExtInfo().getTraceId();
                Intrinsics.checkNotNullExpressionValue(traceId, "rsp.raw.commonRsp.extInfo.traceId");
                a16 = q.a(recommendList, new RecommendExtData(traceId, brVar.a().e(), null, null, 0, 28, null));
            }
            List<com.tencent.mobileqq.guild.discoveryv2.content.base.h> list = a16;
            S1 = this.this$0.S1();
            S1.addAll(list);
            if (cVar.getResult().d() && list.isEmpty()) {
                z16 = true;
            } else {
                z16 = false;
            }
            boolean z17 = z16;
            if (z17) {
                S12 = this.this$0.S1();
                S12.add(o.f217128d);
            }
            this.this$0.e2(new LoadMoreState(true, cVar.getResult(), this.$loadMoreArgs.getLoadMoreType(), list, z17, ""));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
