package com.tencent.mobileqq.guild.homev2.parts;

import android.view.View;
import com.tencent.mobileqq.guild.home.navigator.NavigatorData;
import com.tencent.mobileqq.guild.homev2.viewmodels.GuildHomeViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.homev2.parts.GuildNavigatorPart$initData$1", f = "GuildNavigatorPart.kt", i = {}, l = {390}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildNavigatorPart$initData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<GuildHomeViewModel.GuildHomeUiState> $stateFlow;
    int label;
    final /* synthetic */ GuildNavigatorPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0000\u0012\u0004\u0012\u00020\u00030\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u008a@"}, d2 = {"", "Lcom/tencent/mobileqq/guild/home/navigator/d;", "navigatorList", "Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildHomeViewModel$b;", "uiState", "Lkotlin/Pair;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.homev2.parts.GuildNavigatorPart$initData$1$1", f = "GuildNavigatorPart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.homev2.parts.GuildNavigatorPart$initData$1$1, reason: invalid class name */
    /* loaded from: classes13.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<List<? extends NavigatorData>, GuildHomeViewModel.GuildHomeUiState, Continuation<? super Pair<? extends List<? extends NavigatorData>, ? extends GuildHomeViewModel.GuildHomeUiState>>, Object> {
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(List<? extends NavigatorData> list, GuildHomeViewModel.GuildHomeUiState guildHomeUiState, Continuation<? super Pair<? extends List<? extends NavigatorData>, ? extends GuildHomeViewModel.GuildHomeUiState>> continuation) {
            return invoke2((List<NavigatorData>) list, guildHomeUiState, (Continuation<? super Pair<? extends List<NavigatorData>, GuildHomeViewModel.GuildHomeUiState>>) continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return new Pair((List) this.L$0, (GuildHomeViewModel.GuildHomeUiState) this.L$1);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Nullable
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull List<NavigatorData> list, @NotNull GuildHomeViewModel.GuildHomeUiState guildHomeUiState, @Nullable Continuation<? super Pair<? extends List<NavigatorData>, GuildHomeViewModel.GuildHomeUiState>> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = list;
            anonymousClass1.L$1 = guildHomeUiState;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements FlowCollector<Pair<? extends List<? extends NavigatorData>, ? extends GuildHomeViewModel.GuildHomeUiState>> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ GuildNavigatorPart f225929d;

        public a(GuildNavigatorPart guildNavigatorPart) {
            this.f225929d = guildNavigatorPart;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(Pair<? extends List<? extends NavigatorData>, ? extends GuildHomeViewModel.GuildHomeUiState> pair, @NotNull Continuation<? super Unit> continuation) {
            View view;
            Pair<? extends List<? extends NavigatorData>, ? extends GuildHomeViewModel.GuildHomeUiState> pair2 = pair;
            if (pair2.getSecond().getIsNormalGuild() || pair2.getSecond().getIsVisitorVisibleGuild()) {
                this.f225929d.ba(pair2.getFirst());
            } else {
                view = this.f225929d.navigatorLayout;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navigatorLayout");
                    view = null;
                }
                view.setVisibility(8);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildNavigatorPart$initData$1(GuildNavigatorPart guildNavigatorPart, Flow<GuildHomeViewModel.GuildHomeUiState> flow, Continuation<? super GuildNavigatorPart$initData$1> continuation) {
        super(2, continuation);
        this.this$0 = guildNavigatorPart;
        this.$stateFlow = flow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildNavigatorPart$initData$1(this.this$0, this.$stateFlow, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
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
            Flow combine = FlowKt.combine(this.this$0.C9().Z1().U1(), this.$stateFlow, new AnonymousClass1(null));
            a aVar = new a(this.this$0);
            this.label = 1;
            if (combine.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildNavigatorPart$initData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
