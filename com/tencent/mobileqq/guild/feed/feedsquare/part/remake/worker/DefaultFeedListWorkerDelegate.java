package com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker;

import androidx.annotation.CallSuper;
import androidx.lifecycle.LifecycleOwnerKt;
import bk1.a;
import com.tencent.mobileqq.guild.feed.feedsquare.adapter.GuildFeedSquareListAdapter;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.DeleteFeedArgs;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.InsertFeedArgs;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.ModifyFeedArgs;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.ModifyFeedArgsV2;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.UIStateDataUtils;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.guild.feed.publish.publishV2.IFeedPublishServiceV2;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProEditScheduleReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.List;
import kn1.FeedPublishStateV2;
import kn1.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u001b\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0011H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017J\b\u0010\u0015\u001a\u00020\u0006H\u0017R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/worker/DefaultFeedListWorkerDelegate;", "Lbk1/a$b;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/GuildFeedSquareListAdapter;", "", "Lvi1/e;", "listUIOperationApi", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "Lkn1/b;", "state", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkn1/a$a;", "event", DomainData.DOMAIN_NAME, "(Lkn1/a$a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkn1/a$b;", "o", "(Lkn1/a$b;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "i", "destroy", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "c", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "serviceObserver", "<init>", "()V", "d", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class DefaultFeedListWorkerDelegate extends a.b<GuildFeedSquareListAdapter, Object> {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GPServiceObserver serviceObserver;

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean m(FeedPublishStateV2 state) {
        if (!Intrinsics.areEqual(String.valueOf(state.getStFeed().channelInfo.sign.guildId), e().d().a().getGuildId())) {
            return false;
        }
        if (!wj1.c.c(e().d()) && !Intrinsics.areEqual(String.valueOf(state.getStFeed().channelInfo.sign.channelId), e().d().a().getChannelId())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object n(final a.FeedPublishBegin feedPublishBegin, Continuation<? super Unit> continuation) {
        List<? extends ij1.g> listOf;
        Logger.f235387a.d().i("DefaultFeedListWorkerDelegate", 1, "handlePublishBegin event: stFeed idd:" + feedPublishBegin.getState().getStFeed().idd + " isNewFeed:" + feedPublishBegin.getState().getIsNewFeed() + " isEdit:" + feedPublishBegin.getState().getTaskState().isEdit() + " taskState:" + feedPublishBegin.getState().getTaskState());
        if (!feedPublishBegin.getState().getIsNewFeed()) {
            e().getVmApi().i1(new ModifyFeedArgsV2(new Function1<ij1.g, Boolean>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.DefaultFeedListWorkerDelegate$handlePublishBegin$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull ij1.g it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(Intrinsics.areEqual(it.b().idd, a.FeedPublishBegin.this.getState().getStFeed().idd));
                }
            }, new Function1<ij1.g, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.DefaultFeedListWorkerDelegate$handlePublishBegin$4
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ij1.g gVar) {
                    invoke2(gVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull ij1.g it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    GProStFeed b16 = it.b();
                    Intrinsics.checkNotNullExpressionValue(b16, "it.sourceData");
                    com.tencent.mobileqq.guild.feed.nativeinterface.kt.a.m(b16, a.FeedPublishBegin.this.getState().getStFeed());
                    it.z(a.FeedPublishBegin.this.getState().getTaskState());
                }
            }));
        } else {
            com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.k vmApi = e().getVmApi();
            ij1.g gVar = new ij1.g(feedPublishBegin.getState().getStFeed());
            gVar.z(feedPublishBegin.getState().getTaskState());
            listOf = CollectionsKt__CollectionsJVMKt.listOf(gVar);
            vmApi.J1(listOf, new InsertFeedArgs(UIStateDataUtils.InsertType.PublishFeed, 0, 0, new Function1<ij1.g, Boolean>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.DefaultFeedListWorkerDelegate$handlePublishBegin$6
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull ij1.g it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(Intrinsics.areEqual(it.b().idd, a.FeedPublishBegin.this.getState().getStFeed().idd));
                }
            }, 4, null));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object o(final a.FeedPublishFinish feedPublishFinish, Continuation<? super Unit> continuation) {
        boolean isEdit = feedPublishFinish.getState().getTaskState().isEdit();
        Logger.f235387a.d().i("DefaultFeedListWorkerDelegate", 1, "handlePublishEnd event: stFeed idd:" + feedPublishFinish.getState().getStFeed().idd + " isEdit:" + isEdit + " taskState:" + feedPublishFinish.getState().getTaskState());
        if (kn1.c.c(feedPublishFinish.getState().getTaskState())) {
            com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.k vmApi = e().getVmApi();
            ij1.g gVar = new ij1.g(feedPublishFinish.getState().getStFeed());
            gVar.z(feedPublishFinish.getState().getTaskState());
            vmApi.x1(gVar, new ModifyFeedArgs(new Function1<ij1.g, Boolean>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.DefaultFeedListWorkerDelegate$handlePublishEnd$4
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull ij1.g it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    GuildTaskProgressState p16 = it.p();
                    return Boolean.valueOf(Intrinsics.areEqual(p16 != null ? p16.mTaskId : null, a.FeedPublishFinish.this.getState().getTaskState().mTaskId));
                }
            }, new Function1<ij1.g, Boolean>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.DefaultFeedListWorkerDelegate$handlePublishEnd$5
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull ij1.g it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(Intrinsics.areEqual(it.b().idd, a.FeedPublishFinish.this.getState().getStFeed().idd));
                }
            }, !isEdit));
        } else {
            e().getVmApi().i1(new ModifyFeedArgsV2(new Function1<ij1.g, Boolean>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.DefaultFeedListWorkerDelegate$handlePublishEnd$6
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull ij1.g it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    GuildTaskProgressState p16 = it.p();
                    return Boolean.valueOf(Intrinsics.areEqual(p16 != null ? p16.mTaskId : null, a.FeedPublishFinish.this.getState().getTaskState().mTaskId));
                }
            }, new Function1<ij1.g, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.DefaultFeedListWorkerDelegate$handlePublishEnd$7
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ij1.g gVar2) {
                    invoke2(gVar2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull ij1.g it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.z(a.FeedPublishFinish.this.getState().getTaskState());
                }
            }));
        }
        return Unit.INSTANCE;
    }

    private final void p() {
        final Flow<a.FeedPublishBegin> publishBeginFlow = ((IFeedPublishServiceV2) ch.R0(IFeedPublishServiceV2.class)).publishBeginFlow();
        FlowKt.launchIn(FlowKt.onEach(new Flow<a.FeedPublishBegin>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.DefaultFeedListWorkerDelegate$onFeedPublishObserve$$inlined$filter$1

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.DefaultFeedListWorkerDelegate$onFeedPublishObserve$$inlined$filter$1$2, reason: invalid class name */
            /* loaded from: classes13.dex */
            public static final class AnonymousClass2 implements FlowCollector<a.FeedPublishBegin> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f219011d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ DefaultFeedListWorkerDelegate f219012e;

                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.DefaultFeedListWorkerDelegate$onFeedPublishObserve$$inlined$filter$1$2", f = "DefaultFeedListWorkerDelegate.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.DefaultFeedListWorkerDelegate$onFeedPublishObserve$$inlined$filter$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, DefaultFeedListWorkerDelegate defaultFeedListWorkerDelegate) {
                    this.f219011d = flowCollector;
                    this.f219012e = defaultFeedListWorkerDelegate;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(a.FeedPublishBegin feedPublishBegin, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    boolean m3;
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
                                FlowCollector flowCollector = this.f219011d;
                                m3 = this.f219012e.m(feedPublishBegin.getState());
                                if (m3) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(feedPublishBegin, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
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
            public Object collect(@NotNull FlowCollector<? super a.FeedPublishBegin> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }, new DefaultFeedListWorkerDelegate$onFeedPublishObserve$2(this, null)), LifecycleOwnerKt.getLifecycleScope(e().getLifecycleOwner()));
        final Flow<a.FeedPublishFinish> publishEndFlow = ((IFeedPublishServiceV2) ch.R0(IFeedPublishServiceV2.class)).publishEndFlow();
        FlowKt.launchIn(FlowKt.onEach(new Flow<a.FeedPublishFinish>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.DefaultFeedListWorkerDelegate$onFeedPublishObserve$$inlined$filter$2

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.DefaultFeedListWorkerDelegate$onFeedPublishObserve$$inlined$filter$2$2, reason: invalid class name */
            /* loaded from: classes13.dex */
            public static final class AnonymousClass2 implements FlowCollector<a.FeedPublishFinish> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f219015d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ DefaultFeedListWorkerDelegate f219016e;

                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.DefaultFeedListWorkerDelegate$onFeedPublishObserve$$inlined$filter$2$2", f = "DefaultFeedListWorkerDelegate.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.DefaultFeedListWorkerDelegate$onFeedPublishObserve$$inlined$filter$2$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, DefaultFeedListWorkerDelegate defaultFeedListWorkerDelegate) {
                    this.f219015d = flowCollector;
                    this.f219016e = defaultFeedListWorkerDelegate;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(a.FeedPublishFinish feedPublishFinish, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    boolean m3;
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
                                FlowCollector flowCollector = this.f219015d;
                                m3 = this.f219016e.m(feedPublishFinish.getState());
                                if (m3) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(feedPublishFinish, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
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
            public Object collect(@NotNull FlowCollector<? super a.FeedPublishFinish> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }, new DefaultFeedListWorkerDelegate$onFeedPublishObserve$4(this, null)), LifecycleOwnerKt.getLifecycleScope(e().getLifecycleOwner()));
    }

    private final void q(final vi1.e listUIOperationApi) {
        final com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<? extends Object> e16 = e();
        final GuildFeedSquareListAdapter d16 = d();
        com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl.c cVar = new com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl.c(listUIOperationApi, e16, d16) { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.DefaultFeedListWorkerDelegate$onGPServiceObserve$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
            public void onEditScheduleNew(int result, @Nullable String errMsg, @Nullable final GProEditScheduleReq req) {
                super.onEditScheduleNew(result, errMsg, req);
                if (result == 0) {
                    boolean z16 = false;
                    if (req != null && req.editType == 1) {
                        z16 = true;
                    }
                    if (z16) {
                        this.e().getVmApi().J0(new DeleteFeedArgs(new Function1<ij1.g, Boolean>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.DefaultFeedListWorkerDelegate$onGPServiceObserve$1$onEditScheduleNew$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            @NotNull
                            public final Boolean invoke(@NotNull ij1.g it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                GProStFeed b16 = it.b();
                                return Boolean.valueOf(Intrinsics.areEqual(b16 != null ? b16.idd : null, String.valueOf(GProEditScheduleReq.this.scheduleInfo.scheduleId)));
                            }
                        }));
                    }
                }
            }
        };
        com.tencent.mobileqq.guild.feed.util.l.a(cVar);
        this.serviceObserver = cVar;
    }

    @Override // qz0.a
    @CallSuper
    public void destroy() {
        GPServiceObserver gPServiceObserver = this.serviceObserver;
        if (gPServiceObserver != null) {
            com.tencent.mobileqq.guild.feed.util.l.b(gPServiceObserver);
        }
    }

    @Override // bk1.a.b
    @CallSuper
    public void i(@NotNull vi1.e listUIOperationApi) {
        Intrinsics.checkNotNullParameter(listUIOperationApi, "listUIOperationApi");
        p();
        q(listUIOperationApi);
    }
}
