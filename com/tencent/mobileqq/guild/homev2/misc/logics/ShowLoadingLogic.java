package com.tencent.mobileqq.guild.homev2.misc.logics;

import android.view.View;
import com.tencent.mobileqq.guild.homev2.viewmodels.GuildHomeViewModel;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
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
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 \u00052\u00020\u0001:\u0001\u0007B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\f\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/misc/logics/ShowLoadingLogic;", "", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildHomeViewModel$b;", "flow", "e", "Landroid/view/View;", "a", "Landroid/view/View;", "c", "()Landroid/view/View;", "loadingView", "Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildHomeViewModel;", "b", "Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildHomeViewModel;", "d", "()Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildHomeViewModel;", "viewModel", "", "J", "startTime", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_LOADING_TIME, "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildHomeViewModel;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ShowLoadingLogic {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View loadingView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildHomeViewModel viewModel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long startTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long loadingTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/misc/logics/ShowLoadingLogic$a;", "", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildHomeViewModel$b;", "Lcom/tencent/mobileqq/guild/homev2/misc/logics/ShowLoadingLogic;", "logic", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.homev2.misc.logics.ShowLoadingLogic$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Flow<Object> a(@NotNull Flow<GuildHomeViewModel.GuildHomeUiState> flow, @NotNull ShowLoadingLogic logic) {
            Intrinsics.checkNotNullParameter(flow, "<this>");
            Intrinsics.checkNotNullParameter(logic, "logic");
            return logic.e(flow);
        }

        Companion() {
        }
    }

    public ShowLoadingLogic(@NotNull View loadingView, @NotNull GuildHomeViewModel viewModel) {
        Intrinsics.checkNotNullParameter(loadingView, "loadingView");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.loadingView = loadingView;
        this.viewModel = viewModel;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final View getLoadingView() {
        return this.loadingView;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final GuildHomeViewModel getViewModel() {
        return this.viewModel;
    }

    @NotNull
    public final Flow<Object> e(@NotNull Flow<GuildHomeViewModel.GuildHomeUiState> flow) {
        Intrinsics.checkNotNullParameter(flow, "flow");
        final Flow onStart = FlowKt.onStart(flow, new ShowLoadingLogic$with$1(this, null));
        return FlowKt.onEach(FlowKt.distinctUntilChanged(new Flow<Boolean>() { // from class: com.tencent.mobileqq.guild.homev2.misc.logics.ShowLoadingLogic$with$$inlined$map$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.homev2.misc.logics.ShowLoadingLogic$with$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes13.dex */
            public static final class AnonymousClass2 implements FlowCollector<GuildHomeViewModel.GuildHomeUiState> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f225906d;

                /* compiled from: P */
                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.guild.homev2.misc.logics.ShowLoadingLogic$with$$inlined$map$1$2", f = "ShowLoadingLogic.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.homev2.misc.logics.ShowLoadingLogic$with$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f225906d = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(GuildHomeViewModel.GuildHomeUiState guildHomeUiState, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
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
                                FlowCollector flowCollector = this.f225906d;
                                Boolean boxBoolean = Boxing.boxBoolean(guildHomeUiState.getIsLoading());
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(boxBoolean, anonymousClass1) == coroutine_suspended) {
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
            public Object collect(@NotNull FlowCollector<? super Boolean> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }), new ShowLoadingLogic$with$3(this, null));
    }
}
