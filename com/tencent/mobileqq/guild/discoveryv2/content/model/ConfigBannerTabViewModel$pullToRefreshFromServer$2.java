package com.tencent.mobileqq.guild.discoveryv2.content.model;

import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.ConfigBannerData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.ConfigTabBanner;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendExtData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.q;
import com.tencent.mobileqq.guild.discoveryv2.net.DataType;
import com.tencent.mobileqq.guild.discoveryv2.net.NetTransaction;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendContentItem;
import com.tencent.mobileqq.qqguildsdk.data.genc.bi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\b\u0001\u0012\u00020\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/net/h;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/bi;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/b;", "<name for destructuring parameter 0>", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.discoveryv2.content.model.ConfigBannerTabViewModel$pullToRefreshFromServer$2", f = "ConfigBannerTabViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class ConfigBannerTabViewModel$pullToRefreshFromServer$2 extends SuspendLambda implements Function2<NetTransaction<bi, ? extends b>, Continuation<? super Unit>, Object> {
    final /* synthetic */ PullToRefreshArgs $pullToRefreshArgs;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ConfigBannerTabViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConfigBannerTabViewModel$pullToRefreshFromServer$2(ConfigBannerTabViewModel configBannerTabViewModel, PullToRefreshArgs pullToRefreshArgs, Continuation<? super ConfigBannerTabViewModel$pullToRefreshFromServer$2> continuation) {
        super(2, continuation);
        this.this$0 = configBannerTabViewModel;
        this.$pullToRefreshArgs = pullToRefreshArgs;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ConfigBannerTabViewModel$pullToRefreshFromServer$2 configBannerTabViewModel$pullToRefreshFromServer$2 = new ConfigBannerTabViewModel$pullToRefreshFromServer$2(this.this$0, this.$pullToRefreshArgs, continuation);
        configBannerTabViewModel$pullToRefreshFromServer$2.L$0 = obj;
        return configBannerTabViewModel$pullToRefreshFromServer$2;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull NetTransaction<bi, ? extends b> netTransaction, @Nullable Continuation<? super Unit> continuation) {
        return ((ConfigBannerTabViewModel$pullToRefreshFromServer$2) create(netTransaction, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00e2  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        List listOf;
        List plus;
        List list;
        LinkedList S1;
        LinkedList S12;
        LinkedList S13;
        LinkedList S14;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            NetTransaction netTransaction = (NetTransaction) this.L$0;
            bi biVar = (bi) netTransaction.a();
            b bVar = (b) netTransaction.b();
            DataType from = netTransaction.getFrom();
            boolean z16 = true;
            if (from == DataType.FILE) {
                S14 = this.this$0.S1();
                if (!S14.isEmpty()) {
                    plus = CollectionsKt__CollectionsKt.emptyList();
                    list = plus;
                    if (!list.isEmpty()) {
                        S12 = this.this$0.S1();
                        S12.clear();
                        S13 = this.this$0.S1();
                        S13.addAll(list);
                    }
                    ConfigBannerTabViewModel configBannerTabViewModel = this.this$0;
                    if (from != DataType.NET) {
                        z16 = false;
                    }
                    ri1.a result = bVar.getResult();
                    PullToRefreshType pullToRefreshType = this.$pullToRefreshArgs.getPullToRefreshType();
                    S1 = this.this$0.S1();
                    configBannerTabViewModel.f2(new PullToRefreshState(z16, result, pullToRefreshType, S1, plus.isEmpty(), null, 32, null));
                    return Unit.INSTANCE;
                }
            }
            if (!bVar.getResult().d()) {
                plus = CollectionsKt__CollectionsKt.emptyList();
            } else if (bVar.getRaw() == null) {
                plus = CollectionsKt__CollectionsKt.emptyList();
            } else {
                String traceId = bVar.getRaw().getCommonRsp().getExtInfo().getTraceId();
                Intrinsics.checkNotNullExpressionValue(traceId, "rsp.raw.commonRsp.extInfo.traceId");
                RecommendExtData recommendExtData = new RecommendExtData(traceId, biVar.a().e(), null, null, 0, 28, null);
                ArrayList<IGProRecommendContentItem> bannerConfigList = bVar.getRaw().getBannerConfigList();
                Intrinsics.checkNotNullExpressionValue(bannerConfigList, "rsp.raw.getBannerConfigList()");
                listOf = CollectionsKt__CollectionsJVMKt.listOf(new ConfigBannerData(new ConfigTabBanner(bannerConfigList), RecommendExtData.b(recommendExtData, null, 0, null, null, 0, 31, null)));
                ArrayList<IGProRecommendContentItem> recommendList = bVar.getRaw().getCommonRsp().getRecommendList();
                Intrinsics.checkNotNullExpressionValue(recommendList, "rsp.raw.commonRsp.recommendList");
                plus = CollectionsKt___CollectionsKt.plus((Collection) listOf, (Iterable) q.a(recommendList, recommendExtData));
            }
            list = plus;
            if (!list.isEmpty()) {
            }
            ConfigBannerTabViewModel configBannerTabViewModel2 = this.this$0;
            if (from != DataType.NET) {
            }
            ri1.a result2 = bVar.getResult();
            PullToRefreshType pullToRefreshType2 = this.$pullToRefreshArgs.getPullToRefreshType();
            S1 = this.this$0.S1();
            configBannerTabViewModel2.f2(new PullToRefreshState(z16, result2, pullToRefreshType2, S1, plus.isEmpty(), null, 32, null));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
