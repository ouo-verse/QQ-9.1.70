package com.tencent.mobileqq.guild.discoveryv2.content.model;

import android.text.TextUtils;
import androidx.lifecycle.ViewModelKt;
import com.tencent.mobileqq.guild.discoveryv2.RecommendAdMessage;
import com.tencent.mobileqq.guild.discoveryv2.content.base.BaseFeedViewModel;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendExtData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.SpecialActivityData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.SpecialActivityListData;
import com.tencent.mobileqq.guild.discoveryv2.net.DataType;
import com.tencent.mobileqq.guild.discoveryv2.net.NetTransaction;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendH5Kuikly;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecommendTabContentRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendContentItem;
import com.tencent.mobileqq.qqguildsdk.data.genc.bv;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\t*\u0001\u0019\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u0012*\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0010R\u001a\u0010\u0018\u001a\u00020\f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/model/RecommendTabViewModel;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/BaseFeedViewModel;", "Lcom/tencent/mvi/base/route/j;", "message", "", "D0", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/i;", "pullToRefreshArgs", "c2", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/g;", "loadMoreArgs", ICustomDataEditor.STRING_ARRAY_PARAM_2, "", "account", "onAccountChanged", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetRecommendTabContentRsp;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "baseExt", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/u;", "k2", "H", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "tag", "com/tencent/mobileqq/guild/discoveryv2/content/model/RecommendTabViewModel$networkHelper$1", "I", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/RecommendTabViewModel$networkHelper$1;", "networkHelper", "<init>", "()V", "J", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class RecommendTabViewModel extends BaseFeedViewModel {

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final String tag = "RecommendTabViewModel_" + hashCode();

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final RecommendTabViewModel$networkHelper$1 networkHelper = new RecommendTabViewModel$networkHelper$1(this);

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object j2(com.tencent.mobileqq.guild.discoveryv2.net.a aVar, RecommendAdMessage recommendAdMessage, Continuation continuation) {
        aVar.d(recommendAdMessage);
        return Unit.INSTANCE;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.BaseFeedViewModel, com.tencent.mobileqq.guild.discoveryv2.content.model.f
    public void D0(@NotNull com.tencent.mvi.base.route.j message) {
        Intrinsics.checkNotNullParameter(message, "message");
        super.D0(message);
        FlowKt.launchIn(FlowKt.merge(FlowKt.onEach(FlowKt.callbackFlow(new RecommendTabViewModel$init$$inlined$eventFlow$1(message, null)), new RecommendTabViewModel$init$1(this.networkHelper.getAdDecorator()))), ViewModelKt.getViewModelScope(this));
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.BaseFeedViewModel
    public void a2(@NotNull LoadMoreArgs loadMoreArgs) {
        Intrinsics.checkNotNullParameter(loadMoreArgs, "loadMoreArgs");
        FlowKt.launchIn(FlowKt.onEach(this.networkHelper.d(), new RecommendTabViewModel$loadMoreFormServer$1(this, loadMoreArgs, null)), ViewModelKt.getViewModelScope(this));
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.BaseFeedViewModel
    public void c2(@NotNull PullToRefreshArgs pullToRefreshArgs) {
        Intrinsics.checkNotNullParameter(pullToRefreshArgs, "pullToRefreshArgs");
        final Flow<NetTransaction<bv, ? extends e>> g16 = this.networkHelper.g(S1().isEmpty());
        FlowKt.launchIn(FlowKt.onEach(new Flow<NetTransaction<bv, ? extends e>>() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.model.RecommendTabViewModel$pullToRefreshFromServer$$inlined$filter$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.discoveryv2.content.model.RecommendTabViewModel$pullToRefreshFromServer$$inlined$filter$1$2, reason: invalid class name */
            /* loaded from: classes13.dex */
            public static final class AnonymousClass2 implements FlowCollector<NetTransaction<bv, ? extends e>> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f216983d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ RecommendTabViewModel f216984e;

                /* compiled from: P */
                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.guild.discoveryv2.content.model.RecommendTabViewModel$pullToRefreshFromServer$$inlined$filter$1$2", f = "RecommendTabViewModel.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.discoveryv2.content.model.RecommendTabViewModel$pullToRefreshFromServer$$inlined$filter$1$2$1, reason: invalid class name */
                /* loaded from: classes13.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, RecommendTabViewModel recommendTabViewModel) {
                    this.f216983d = flowCollector;
                    this.f216984e = recommendTabViewModel;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:21:0x0054  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(NetTransaction<bv, ? extends e> netTransaction, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    boolean z16;
                    LinkedList S1;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i16 = anonymousClass1.label;
                        if ((i16 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i16 - Integer.MIN_VALUE;
                            Object obj = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i3 = anonymousClass1.label;
                            if (i3 == 0) {
                                if (i3 == 1) {
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.throwOnFailure(obj);
                                FlowCollector flowCollector = this.f216983d;
                                if (netTransaction.d() != DataType.NET) {
                                    S1 = this.f216984e.S1();
                                    if (!S1.isEmpty()) {
                                        z16 = false;
                                        if (z16) {
                                            anonymousClass1.label = 1;
                                            if (flowCollector.emit(netTransaction, anonymousClass1) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                        }
                                    }
                                }
                                z16 = true;
                                if (z16) {
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj2 = anonymousClass1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = anonymousClass1.label;
                    if (i3 == 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super NetTransaction<bv, ? extends e>> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }, new RecommendTabViewModel$pullToRefreshFromServer$2(this, pullToRefreshArgs, null)), ViewModelKt.getViewModelScope(this));
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.BaseFeedViewModel
    @NotNull
    public String getTag() {
        return this.tag;
    }

    @Nullable
    public final SpecialActivityListData k2(@NotNull IGProGetRecommendTabContentRsp iGProGetRecommendTabContentRsp, @NotNull RecommendExtData baseExt) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        String joinToString$default;
        String hotTitle;
        Intrinsics.checkNotNullParameter(iGProGetRecommendTabContentRsp, "<this>");
        Intrinsics.checkNotNullParameter(baseExt, "baseExt");
        ArrayList<IGProRecommendContentItem> hotActivities = iGProGetRecommendTabContentRsp.getHotActivities();
        Intrinsics.checkNotNullExpressionValue(hotActivities, "hotActivities");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(hotActivities, 10);
        ArrayList<SpecialActivityData> arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = hotActivities.iterator();
        while (it.hasNext()) {
            IGProContentRecommendH5Kuikly h5kuikly = ((IGProRecommendContentItem) it.next()).getH5kuikly();
            String iconUrl = h5kuikly.getIconUrl();
            Intrinsics.checkNotNullExpressionValue(iconUrl, "activityInfo.iconUrl");
            String name = h5kuikly.getName();
            Intrinsics.checkNotNullExpressionValue(name, "activityInfo.name");
            String jumpUrl = h5kuikly.getJumpUrl();
            Intrinsics.checkNotNullExpressionValue(jumpUrl, "activityInfo.jumpUrl");
            arrayList.add(new SpecialActivityData(iconUrl, name, jumpUrl));
        }
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        for (SpecialActivityData specialActivityData : arrayList) {
            arrayList2.add(specialActivityData.getName() + "-" + specialActivityData.getJumpUrl());
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList2, ",", null, null, 0, null, null, 62, null);
        QLog.i("RecSpecialActivityList", 1, joinToString$default);
        if (arrayList.size() < 2) {
            return null;
        }
        if (TextUtils.isEmpty(iGProGetRecommendTabContentRsp.getHotTitle())) {
            hotTitle = "\u7279\u8272\u6d3b\u52a8";
        } else {
            hotTitle = iGProGetRecommendTabContentRsp.getHotTitle();
        }
        String str = hotTitle;
        Intrinsics.checkNotNullExpressionValue(str, "if (TextUtils.isEmpty(ho\u2026\u7279\u8272\u6d3b\u52a8\" } else { hotTitle }");
        return new SpecialActivityListData(str, arrayList, RecommendExtData.b(baseExt, null, 0, null, null, 0, 31, null));
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.BaseFeedViewModel, com.tencent.mobileqq.guild.discoveryv2.content.model.f
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        super.onAccountChanged(account);
        this.networkHelper.e();
    }
}
