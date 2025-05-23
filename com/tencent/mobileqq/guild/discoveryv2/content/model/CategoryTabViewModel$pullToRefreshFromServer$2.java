package com.tencent.mobileqq.guild.discoveryv2.content.model;

import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.CategoryFeaturedGuilds;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.CategoryFeaturedGuildsData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendExtData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.SpaceData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.SpecialActivityListData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.q;
import com.tencent.mobileqq.guild.discoveryv2.net.DataType;
import com.tencent.mobileqq.guild.discoveryv2.net.NetTransaction;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendCategory;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendContentItem;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem;
import com.tencent.mobileqq.qqguildsdk.data.genc.bg;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
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
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\b\u0001\u0012\u00020\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/net/h;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/bg;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/a;", "<name for destructuring parameter 0>", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.discoveryv2.content.model.CategoryTabViewModel$pullToRefreshFromServer$2", f = "CategoryTabViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class CategoryTabViewModel$pullToRefreshFromServer$2 extends SuspendLambda implements Function2<NetTransaction<bg, ? extends a>, Continuation<? super Unit>, Object> {
    final /* synthetic */ PullToRefreshArgs $pullToRefreshArgs;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CategoryTabViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CategoryTabViewModel$pullToRefreshFromServer$2(CategoryTabViewModel categoryTabViewModel, PullToRefreshArgs pullToRefreshArgs, Continuation<? super CategoryTabViewModel$pullToRefreshFromServer$2> continuation) {
        super(2, continuation);
        this.this$0 = categoryTabViewModel;
        this.$pullToRefreshArgs = pullToRefreshArgs;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        CategoryTabViewModel$pullToRefreshFromServer$2 categoryTabViewModel$pullToRefreshFromServer$2 = new CategoryTabViewModel$pullToRefreshFromServer$2(this.this$0, this.$pullToRefreshArgs, continuation);
        categoryTabViewModel$pullToRefreshFromServer$2.L$0 = obj;
        return categoryTabViewModel$pullToRefreshFromServer$2;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull NetTransaction<bg, ? extends a> netTransaction, @Nullable Continuation<? super Unit> continuation) {
        return ((CategoryTabViewModel$pullToRefreshFromServer$2) create(netTransaction, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0163  */
    /* JADX WARN: Type inference failed for: r13v1, types: [com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.a, T] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        float f16;
        List plus;
        float f17;
        List list;
        boolean z16;
        LinkedList S1;
        LinkedList S12;
        LinkedList S13;
        LinkedList S14;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            NetTransaction netTransaction = (NetTransaction) this.L$0;
            bg bgVar = (bg) netTransaction.a();
            a aVar = (a) netTransaction.b();
            DataType from = netTransaction.getFrom();
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
                    CategoryTabViewModel categoryTabViewModel = this.this$0;
                    if (from != DataType.NET) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    ri1.a result = aVar.getResult();
                    PullToRefreshType pullToRefreshType = this.$pullToRefreshArgs.getPullToRefreshType();
                    S1 = this.this$0.S1();
                    categoryTabViewModel.f2(new PullToRefreshState(z16, result, pullToRefreshType, S1, plus.isEmpty(), null, 32, null));
                    return Unit.INSTANCE;
                }
            }
            if (!aVar.getResult().d()) {
                plus = CollectionsKt__CollectionsKt.emptyList();
            } else if (aVar.getRaw() == null) {
                plus = CollectionsKt__CollectionsKt.emptyList();
            } else {
                String traceId = aVar.getRaw().getCommonRsp().getExtInfo().getTraceId();
                Intrinsics.checkNotNullExpressionValue(traceId, "rsp.raw.commonRsp.extInfo.traceId");
                RecommendExtData recommendExtData = new RecommendExtData(traceId, bgVar.a().e(), null, null, 0, 28, null);
                ArrayList arrayList = new ArrayList();
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                ArrayList<IGProRecommendItem> featuredGuilds = aVar.getRaw().getFeaturedGuilds();
                if (featuredGuilds != null && featuredGuilds.size() > 0) {
                    arrayList.add(new SpaceData(14.0f));
                    String featuredTitle = aVar.getRaw().getFeaturedTitle();
                    Intrinsics.checkNotNullExpressionValue(featuredTitle, "rsp.raw.featuredTitle");
                    IGProRecommendCategory featuredCategory = aVar.getRaw().getFeaturedCategory();
                    Intrinsics.checkNotNullExpressionValue(featuredCategory, "rsp.raw.featuredCategory");
                    ArrayList<IGProRecommendItem> featuredGuilds2 = aVar.getRaw().getFeaturedGuilds();
                    Intrinsics.checkNotNullExpressionValue(featuredGuilds2, "rsp.raw.featuredGuilds");
                    ?? categoryFeaturedGuilds = new CategoryFeaturedGuilds(featuredTitle, featuredCategory, featuredGuilds2);
                    arrayList.add(new CategoryFeaturedGuildsData(categoryFeaturedGuilds, RecommendExtData.b(recommendExtData, null, 0, null, null, 0, 31, null)));
                    objectRef.element = categoryFeaturedGuilds;
                }
                SpecialActivityListData b16 = q.b(aVar.getRaw(), recommendExtData);
                if (b16 != null) {
                    if (objectRef.element == 0) {
                        f17 = 14.0f;
                    } else {
                        f17 = 20.0f;
                    }
                    arrayList.add(new SpaceData(f17));
                    arrayList.add(b16);
                }
                if (objectRef.element == 0 && b16 == null) {
                    f16 = 9.0f;
                } else {
                    f16 = 27.0f;
                }
                arrayList.add(new SpaceData(f16));
                ArrayList<IGProRecommendContentItem> recommendList = aVar.getRaw().getCommonRsp().getRecommendList();
                Intrinsics.checkNotNullExpressionValue(recommendList, "rsp.raw.commonRsp.recommendList");
                plus = CollectionsKt___CollectionsKt.plus((Collection) arrayList, (Iterable) q.a(recommendList, recommendExtData));
            }
            list = plus;
            if (!list.isEmpty()) {
            }
            CategoryTabViewModel categoryTabViewModel2 = this.this$0;
            if (from != DataType.NET) {
            }
            ri1.a result2 = aVar.getResult();
            PullToRefreshType pullToRefreshType2 = this.$pullToRefreshArgs.getPullToRefreshType();
            S1 = this.this$0.S1();
            categoryTabViewModel2.f2(new PullToRefreshState(z16, result2, pullToRefreshType2, S1, plus.isEmpty(), null, 32, null));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
