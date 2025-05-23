package com.tencent.mobileqq.guild.discoveryv2.content.model;

import androidx.lifecycle.ViewModelKt;
import com.tencent.mobileqq.guild.discoveryv2.RecommendAdMessage;
import com.tencent.mobileqq.guild.discoveryv2.content.base.BaseFeedViewModel;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendExtData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.q;
import com.tencent.mobileqq.guild.discoveryv2.jump.GuildPropsParam;
import com.tencent.mobileqq.guild.discoveryv2.net.DataType;
import com.tencent.mobileqq.guild.discoveryv2.net.NetTransaction;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProSourceInfoBid;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetContentRecommendRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendContentItem;
import com.tencent.mobileqq.qqguildsdk.data.genc.bj;
import com.tencent.mobileqq.qqguildsdk.data.genc.dh;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0004\n\u0002\b\t*\u0002\u0018\u001c\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0017\u001a\u00020\f8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/model/RecommendViewModel;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/BaseFeedViewModel;", "Lcom/tencent/mvi/base/route/j;", "message", "", "D0", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/i;", "pullToRefreshArgs", "c2", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/g;", "loadMoreArgs", ICustomDataEditor.STRING_ARRAY_PARAM_2, "", "account", "onAccountChanged", "Lcom/tencent/mobileqq/guild/discoveryv2/jump/GuildPropsParam;", "H", "Lcom/tencent/mobileqq/guild/discoveryv2/jump/GuildPropsParam;", "propsParam", "I", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "tag", "com/tencent/mobileqq/guild/discoveryv2/content/model/RecommendViewModel$b", "J", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/RecommendViewModel$b;", "networkContext", "com/tencent/mobileqq/guild/discoveryv2/content/model/RecommendViewModel$networkHelper$1", "K", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/RecommendViewModel$networkHelper$1;", "networkHelper", "<init>", "(Lcom/tencent/mobileqq/guild/discoveryv2/jump/GuildPropsParam;)V", "L", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class RecommendViewModel extends BaseFeedViewModel {

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final GuildPropsParam propsParam;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final String tag;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final b networkContext;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final RecommendViewModel$networkHelper$1 networkHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u001c\u0010\t\u001a\u00020\b2\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005J\u0006\u0010\n\u001a\u00020\bR\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/content/model/RecommendViewModel$b", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/bj;", "b", "a", "Lcom/tencent/mobileqq/guild/discoveryv2/net/h;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/d;", "transaction", "", "e", "d", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/bj;", "nextReq", "Lrh1/a;", "Lrh1/a;", "c", "()Lrh1/a;", "adPageData", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private bj nextReq = new bj();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final rh1.a adPageData = new rh1.a("guild", 82);

        b() {
        }

        @NotNull
        public final bj a() {
            bj bjVar = this.nextReq;
            bjVar.l(2);
            bjVar.m(bjVar.f() + 1);
            bjVar.f();
            bjVar.i(rh1.a.d(this.adPageData, false, 1, null).toByteArray());
            return bjVar;
        }

        @NotNull
        public final bj b() {
            bj bjVar = new bj();
            RecommendViewModel recommendViewModel = RecommendViewModel.this;
            dh dhVar = new dh();
            dhVar.d(recommendViewModel.propsParam.getBid());
            dhVar.f(recommendViewModel.propsParam.getSceneId());
            dhVar.e(recommendViewModel.propsParam.getBussiSource());
            bjVar.o(dhVar);
            bjVar.l(1);
            bjVar.m(0);
            bjVar.n("");
            bjVar.k(null);
            bjVar.j(recommendViewModel.propsParam.getBusiInfo());
            bjVar.i(this.adPageData.c(true).toByteArray());
            RecommendViewModel recommendViewModel2 = RecommendViewModel.this;
            this.nextReq = bjVar;
            recommendViewModel2.propsParam.setBusiInfo("");
            return bjVar;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final rh1.a getAdPageData() {
            return this.adPageData;
        }

        public final void d() {
            this.adPageData.b();
        }

        public final void e(@NotNull NetTransaction<bj, ? extends d> transaction) {
            Intrinsics.checkNotNullParameter(transaction, "transaction");
            d b16 = transaction.b();
            if (transaction.getFrom() == DataType.NET && b16.getResult().d() && b16.getRaw() != null) {
                IGProGetContentRecommendRsp raw = b16.getRaw();
                bj bjVar = this.nextReq;
                bjVar.k(raw.getCookies());
                bjVar.n(raw.getSessionId());
                bjVar.j("");
            }
        }
    }

    public RecommendViewModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object l2(rh1.a aVar, RecommendAdMessage recommendAdMessage, Continuation continuation) {
        aVar.e(recommendAdMessage);
        return Unit.INSTANCE;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.BaseFeedViewModel, com.tencent.mobileqq.guild.discoveryv2.content.model.f
    public void D0(@NotNull com.tencent.mvi.base.route.j message) {
        Intrinsics.checkNotNullParameter(message, "message");
        super.D0(message);
        FlowKt.launchIn(FlowKt.merge(FlowKt.onEach(FlowKt.callbackFlow(new RecommendViewModel$init$$inlined$eventFlow$1(message, null)), new RecommendViewModel$init$1(this.networkContext.getAdPageData()))), ViewModelKt.getViewModelScope(this));
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.BaseFeedViewModel
    public void a2(@NotNull final LoadMoreArgs loadMoreArgs) {
        Intrinsics.checkNotNullParameter(loadMoreArgs, "loadMoreArgs");
        final Flow<NetTransaction<bj, ? extends d>> c16 = this.networkHelper.c();
        FlowKt.launchIn(new Flow<Unit>() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.model.RecommendViewModel$loadMoreFormServer$$inlined$map$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.discoveryv2.content.model.RecommendViewModel$loadMoreFormServer$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes13.dex */
            public static final class AnonymousClass2 implements FlowCollector<NetTransaction<bj, ? extends d>> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f216995d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ RecommendViewModel f216996e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ LoadMoreArgs f216997f;

                /* compiled from: P */
                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.guild.discoveryv2.content.model.RecommendViewModel$loadMoreFormServer$$inlined$map$1$2", f = "RecommendViewModel.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.discoveryv2.content.model.RecommendViewModel$loadMoreFormServer$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes13.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
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

                public AnonymousClass2(FlowCollector flowCollector, RecommendViewModel recommendViewModel, LoadMoreArgs loadMoreArgs) {
                    this.f216995d = flowCollector;
                    this.f216996e = recommendViewModel;
                    this.f216997f = loadMoreArgs;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(NetTransaction<bj, ? extends d> netTransaction, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    List<com.tencent.mobileqq.guild.discoveryv2.content.base.h> a16;
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
                                FlowCollector flowCollector = this.f216995d;
                                NetTransaction<bj, ? extends d> netTransaction2 = netTransaction;
                                bj a17 = netTransaction2.a();
                                d b16 = netTransaction2.b();
                                if (netTransaction2.getFrom() != DataType.NET) {
                                    a16 = CollectionsKt__CollectionsKt.emptyList();
                                } else if (!b16.getResult().d()) {
                                    a16 = CollectionsKt__CollectionsKt.emptyList();
                                } else if (b16.getRaw() == null) {
                                    a16 = CollectionsKt__CollectionsKt.emptyList();
                                } else {
                                    ArrayList<IGProRecommendContentItem> recommendList = b16.getRaw().getRecommendList();
                                    Intrinsics.checkNotNullExpressionValue(recommendList, "rsp.raw.recommendList");
                                    String traceId = b16.getRaw().getExtInfo().getTraceId();
                                    Intrinsics.checkNotNullExpressionValue(traceId, "rsp.raw.extInfo.traceId");
                                    a16 = q.a(recommendList, new RecommendExtData(traceId, a17.f(), null, null, 0, 28, null));
                                }
                                List<com.tencent.mobileqq.guild.discoveryv2.content.base.h> list = a16;
                                S1 = this.f216996e.S1();
                                S1.addAll(list);
                                this.f216996e.e2(new LoadMoreState(true, b16.getResult(), this.f216997f.getLoadMoreType(), list, false, null, 48, null));
                                Unit unit = Unit.INSTANCE;
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(unit, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
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
            public Object collect(@NotNull FlowCollector<? super Unit> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this, loadMoreArgs), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }, ViewModelKt.getViewModelScope(this));
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.BaseFeedViewModel
    public void c2(@NotNull PullToRefreshArgs pullToRefreshArgs) {
        Intrinsics.checkNotNullParameter(pullToRefreshArgs, "pullToRefreshArgs");
        final Flow<NetTransaction<bj, ? extends d>> d16 = this.networkHelper.d(S1().isEmpty());
        FlowKt.launchIn(FlowKt.onEach(new Flow<NetTransaction<bj, ? extends d>>() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.model.RecommendViewModel$pullToRefreshFromServer$$inlined$filter$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.discoveryv2.content.model.RecommendViewModel$pullToRefreshFromServer$$inlined$filter$1$2, reason: invalid class name */
            /* loaded from: classes13.dex */
            public static final class AnonymousClass2 implements FlowCollector<NetTransaction<bj, ? extends d>> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f217000d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ RecommendViewModel f217001e;

                /* compiled from: P */
                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.guild.discoveryv2.content.model.RecommendViewModel$pullToRefreshFromServer$$inlined$filter$1$2", f = "RecommendViewModel.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.discoveryv2.content.model.RecommendViewModel$pullToRefreshFromServer$$inlined$filter$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, RecommendViewModel recommendViewModel) {
                    this.f217000d = flowCollector;
                    this.f217001e = recommendViewModel;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:21:0x0054  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(NetTransaction<bj, ? extends d> netTransaction, @NotNull Continuation continuation) {
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
                                FlowCollector flowCollector = this.f217000d;
                                if (netTransaction.d() != DataType.NET) {
                                    S1 = this.f217001e.S1();
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
            public Object collect(@NotNull FlowCollector<? super NetTransaction<bj, ? extends d>> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }, new RecommendViewModel$pullToRefreshFromServer$2(this, pullToRefreshArgs, null)), ViewModelKt.getViewModelScope(this));
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.BaseFeedViewModel
    @NotNull
    public String getTag() {
        return this.tag;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.BaseFeedViewModel, com.tencent.mobileqq.guild.discoveryv2.content.model.f
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        super.onAccountChanged(account);
        this.networkContext.d();
    }

    public /* synthetic */ RecommendViewModel(GuildPropsParam guildPropsParam, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new GuildPropsParam(14, GGProSourceInfoBid.PD_DISCOVER, 4, null, 8, null) : guildPropsParam);
    }

    public RecommendViewModel(@NotNull GuildPropsParam propsParam) {
        Intrinsics.checkNotNullParameter(propsParam, "propsParam");
        this.propsParam = propsParam;
        this.tag = "DiscoveryV2.ContentRecommendListViewModel";
        this.networkContext = new b();
        this.networkHelper = new RecommendViewModel$networkHelper$1(this);
    }
}
