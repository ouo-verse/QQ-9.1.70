package com.tencent.mobileqq.guild.homev2.parts;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.home.views.GuildLoadingFrameLayout;
import com.tencent.mobileqq.guild.homev2.misc.GuildHomeV2FragmentBehavior;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qp1.ScrollStateData;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000  2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001c\u0010\r\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016R\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/parts/PullRefreshLoadingPart;", "Lcom/tencent/mobileqq/guild/homev2/parts/a;", "", "L9", "Lcom/tencent/mobileqq/guild/homev2/misc/GuildHomeV2FragmentBehavior$c;", "N9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "e", "Lcom/tencent/mobileqq/guild/homev2/misc/GuildHomeV2FragmentBehavior$c;", "onStateUpdate", "Lcom/tencent/mobileqq/guild/home/views/GuildLoadingFrameLayout;", "f", "Lcom/tencent/mobileqq/guild/home/views/GuildLoadingFrameLayout;", "loadingLayout", "", tl.h.F, "Z", "isLoading", "", "i", "J", "refreshTimeStamp", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class PullRefreshLoadingPart extends a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildHomeV2FragmentBehavior.c onStateUpdate = N9();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private GuildLoadingFrameLayout loadingLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isLoading;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long refreshTimeStamp;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/homev2/parts/PullRefreshLoadingPart$b", "Lcom/tencent/mobileqq/guild/homev2/misc/GuildHomeV2FragmentBehavior$c;", "Lqp1/b;", "state", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements GuildHomeV2FragmentBehavior.c {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f225946b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ PullRefreshLoadingPart f225947c;

        public b(String str, PullRefreshLoadingPart pullRefreshLoadingPart) {
            this.f225946b = str;
            this.f225947c = pullRefreshLoadingPart;
        }

        @Override // com.tencent.mobileqq.guild.homev2.misc.GuildHomeV2FragmentBehavior.c
        public void a(@NotNull ScrollStateData state) {
            Intrinsics.checkNotNullParameter(state, "state");
            if (!this.f225947c.isLoading) {
                Logger logger = Logger.f235387a;
                if (QLog.isDevelopLevel()) {
                    Log.d("PullRefreshLoadingPart", "newStateUpdateCallback " + state);
                }
                GuildLoadingFrameLayout guildLoadingFrameLayout = null;
                if (!state.k() || state.getState() == 5) {
                    GuildLoadingFrameLayout guildLoadingFrameLayout2 = this.f225947c.loadingLayout;
                    if (guildLoadingFrameLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
                        guildLoadingFrameLayout2 = null;
                    }
                    if (guildLoadingFrameLayout2.getVisibility() != 8) {
                        GuildLoadingFrameLayout guildLoadingFrameLayout3 = this.f225947c.loadingLayout;
                        if (guildLoadingFrameLayout3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
                            guildLoadingFrameLayout3 = null;
                        }
                        guildLoadingFrameLayout3.getInnerLoadingView().setStaticImageDrawable();
                        GuildLoadingFrameLayout guildLoadingFrameLayout4 = this.f225947c.loadingLayout;
                        if (guildLoadingFrameLayout4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
                            guildLoadingFrameLayout4 = null;
                        }
                        guildLoadingFrameLayout4.getInnerLoadingView().i();
                        GuildLoadingFrameLayout guildLoadingFrameLayout5 = this.f225947c.loadingLayout;
                        if (guildLoadingFrameLayout5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
                        } else {
                            guildLoadingFrameLayout = guildLoadingFrameLayout5;
                        }
                        guildLoadingFrameLayout.setVisibility(8);
                        return;
                    }
                    return;
                }
                GuildLoadingFrameLayout guildLoadingFrameLayout6 = this.f225947c.loadingLayout;
                if (guildLoadingFrameLayout6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
                    guildLoadingFrameLayout6 = null;
                }
                if (guildLoadingFrameLayout6.getVisibility() != 0) {
                    GuildLoadingFrameLayout guildLoadingFrameLayout7 = this.f225947c.loadingLayout;
                    if (guildLoadingFrameLayout7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
                        guildLoadingFrameLayout7 = null;
                    }
                    guildLoadingFrameLayout7.setVisibility(0);
                }
                GuildLoadingFrameLayout guildLoadingFrameLayout8 = this.f225947c.loadingLayout;
                if (guildLoadingFrameLayout8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
                    guildLoadingFrameLayout8 = null;
                }
                guildLoadingFrameLayout8.getInnerLoadingView().setLoadingDistance(state.getPullRefreshHeight());
                GuildLoadingFrameLayout guildLoadingFrameLayout9 = this.f225947c.loadingLayout;
                if (guildLoadingFrameLayout9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
                    guildLoadingFrameLayout9 = null;
                }
                guildLoadingFrameLayout9.getInnerLoadingView().h(Math.abs(state.getOffset()));
                if (state.getState() == 6) {
                    this.f225947c.C9().T().setValue(new ef1.a<>(Boolean.TRUE));
                    GuildLoadingFrameLayout guildLoadingFrameLayout10 = this.f225947c.loadingLayout;
                    if (guildLoadingFrameLayout10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
                        guildLoadingFrameLayout10 = null;
                    }
                    VideoReport.reportEvent("clck", guildLoadingFrameLayout10.getInnerLoadingView(), null);
                    this.f225947c.refreshTimeStamp = SystemClock.uptimeMillis();
                }
                if (state.getState() == 8) {
                    GuildLoadingFrameLayout guildLoadingFrameLayout11 = this.f225947c.loadingLayout;
                    if (guildLoadingFrameLayout11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
                    } else {
                        guildLoadingFrameLayout = guildLoadingFrameLayout11;
                    }
                    guildLoadingFrameLayout.getInnerLoadingView().setDynamicImageDrawable();
                    return;
                }
                if (state.getState() != 5 && state.getState() != 7) {
                    GuildLoadingFrameLayout guildLoadingFrameLayout12 = this.f225947c.loadingLayout;
                    if (guildLoadingFrameLayout12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
                    } else {
                        guildLoadingFrameLayout = guildLoadingFrameLayout12;
                    }
                    guildLoadingFrameLayout.getInnerLoadingView().setStaticImageDrawable();
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00028\u0000 \u0002*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00010\u0001H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "Lef1/a;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lef1/a;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c<T> implements Observer {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Object f225948d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Observer f225949e;

        public c(Object obj, Observer observer) {
            this.f225948d = obj;
            this.f225949e = observer;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(ef1.a<T> aVar) {
            T b16;
            if (aVar != null && (b16 = aVar.b(this.f225948d)) != null) {
                this.f225949e.onChanged(b16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L9() {
        Logger.f235387a.d().i("PullRefreshLoadingPart", 1, "finishLoadingAnimate");
        long uptimeMillis = SystemClock.uptimeMillis() - this.refreshTimeStamp;
        if (uptimeMillis < 300) {
            GuildLoadingFrameLayout guildLoadingFrameLayout = this.loadingLayout;
            if (guildLoadingFrameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
                guildLoadingFrameLayout = null;
            }
            guildLoadingFrameLayout.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.homev2.parts.s
                @Override // java.lang.Runnable
                public final void run() {
                    PullRefreshLoadingPart.M9(PullRefreshLoadingPart.this);
                }
            }, 300 - uptimeMillis);
            return;
        }
        z9().m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(PullRefreshLoadingPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.L9();
    }

    private final GuildHomeV2FragmentBehavior.c N9() {
        GuildHomeV2FragmentBehavior.c.Companion companion = GuildHomeV2FragmentBehavior.c.INSTANCE;
        return new b("PullRefreshLoadingPart", this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.loading_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.loading_layout)");
        GuildLoadingFrameLayout guildLoadingFrameLayout = (GuildLoadingFrameLayout) findViewById;
        this.loadingLayout = guildLoadingFrameLayout;
        if (guildLoadingFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
            guildLoadingFrameLayout = null;
        }
        guildLoadingFrameLayout.getInnerLoadingView().h(0);
        GuildLoadingFrameLayout guildLoadingFrameLayout2 = this.loadingLayout;
        if (guildLoadingFrameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
            guildLoadingFrameLayout2 = null;
        }
        guildLoadingFrameLayout2.getInnerLoadingView().setBackgroundColor(rootView.getResources().getColor(R.color.qui_common_fill_light_tertiary));
        GuildLoadingFrameLayout guildLoadingFrameLayout3 = this.loadingLayout;
        if (guildLoadingFrameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
            guildLoadingFrameLayout3 = null;
        }
        com.tencent.mobileqq.qwallet.k.b(guildLoadingFrameLayout3.getInnerLoadingView(), cw.b(10));
        GuildLoadingFrameLayout guildLoadingFrameLayout4 = this.loadingLayout;
        if (guildLoadingFrameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
            guildLoadingFrameLayout4 = null;
        }
        com.tencent.mobileqq.guild.base.extension.g.b(guildLoadingFrameLayout4.getInnerLoadingView(), "em_sgrp_pulldown_update", false, false, null, 8, null);
        e12.a<Boolean> d16 = GuildThemeManager.f235286a.d();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.homev2.parts.PullRefreshLoadingPart$onInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean isNightTheme) {
                Logger.f235387a.d().i("PullRefreshLoadingPart", 1, "nightThemeLiveData " + isNightTheme);
                Intrinsics.checkNotNullExpressionValue(isNightTheme, "isNightTheme");
                GuildLoadingFrameLayout guildLoadingFrameLayout5 = null;
                if (isNightTheme.booleanValue()) {
                    GuildLoadingFrameLayout guildLoadingFrameLayout6 = PullRefreshLoadingPart.this.loadingLayout;
                    if (guildLoadingFrameLayout6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
                    } else {
                        guildLoadingFrameLayout5 = guildLoadingFrameLayout6;
                    }
                    guildLoadingFrameLayout5.getInnerLoadingView().setLoadingColorType(0, true);
                    return;
                }
                GuildLoadingFrameLayout guildLoadingFrameLayout7 = PullRefreshLoadingPart.this.loadingLayout;
                if (guildLoadingFrameLayout7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
                } else {
                    guildLoadingFrameLayout5 = guildLoadingFrameLayout7;
                }
                guildLoadingFrameLayout5.getInnerLoadingView().setLoadingColorType(1, true);
            }
        };
        d16.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.homev2.parts.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PullRefreshLoadingPart.O9(Function1.this, obj);
            }
        });
        MutableLiveData<ef1.a<Boolean>> T1 = C9().T1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner2, "partHost.hostLifecycleOwner");
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.homev2.parts.PullRefreshLoadingPart$onInitView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                PullRefreshLoadingPart.this.L9();
            }
        };
        T1.observe(lifecycleOwner2, new c(this, new Observer() { // from class: com.tencent.mobileqq.guild.homev2.parts.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PullRefreshLoadingPart.P9(Function1.this, obj);
            }
        }));
        final MutableStateFlow<Rect> Q1 = C9().Q1();
        Flow<Integer> flow = new Flow<Integer>() { // from class: com.tencent.mobileqq.guild.homev2.parts.PullRefreshLoadingPart$onInitView$$inlined$map$1

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.homev2.parts.PullRefreshLoadingPart$onInitView$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes13.dex */
            public static final class AnonymousClass2 implements FlowCollector<Rect> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f225943d;

                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.guild.homev2.parts.PullRefreshLoadingPart$onInitView$$inlined$map$1$2", f = "PullRefreshLoadingPart.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.homev2.parts.PullRefreshLoadingPart$onInitView$$inlined$map$1$2$1, reason: invalid class name */
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
                    this.f225943d = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(Rect rect, @NotNull Continuation continuation) {
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
                                FlowCollector flowCollector = this.f225943d;
                                Integer boxInt = Boxing.boxInt(rect.top);
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(boxInt, anonymousClass1) == coroutine_suspended) {
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
            public Object collect(@NotNull FlowCollector<? super Integer> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        };
        final StateFlow<Pair<IGProGuildInfo, Integer>> O1 = C9().getGuildInfoViewModel().O1();
        Flow onEach = FlowKt.onEach(FlowKt.combine(flow, new Flow<String>() { // from class: com.tencent.mobileqq.guild.homev2.parts.PullRefreshLoadingPart$onInitView$$inlined$map$2

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.homev2.parts.PullRefreshLoadingPart$onInitView$$inlined$map$2$2, reason: invalid class name */
            /* loaded from: classes13.dex */
            public static final class AnonymousClass2 implements FlowCollector<Pair<? extends IGProGuildInfo, ? extends Integer>> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f225945d;

                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.guild.homev2.parts.PullRefreshLoadingPart$onInitView$$inlined$map$2$2", f = "PullRefreshLoadingPart.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.homev2.parts.PullRefreshLoadingPart$onInitView$$inlined$map$2$2$1, reason: invalid class name */
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
                    this.f225945d = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(Pair<? extends IGProGuildInfo, ? extends Integer> pair, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    String str;
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
                                FlowCollector flowCollector = this.f225945d;
                                IGProGuildInfo first = pair.getFirst();
                                if (first != null) {
                                    str = first.getCanBeEmptyCoverUrl(0, 0);
                                } else {
                                    str = null;
                                }
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(str, anonymousClass1) == coroutine_suspended) {
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
            public Object collect(@NotNull FlowCollector<? super String> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }, new PullRefreshLoadingPart$onInitView$3(null)), new PullRefreshLoadingPart$onInitView$4(this, null));
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner3, "partHost.hostLifecycleOwner");
        FlowKt.launchIn(onEach, LifecycleOwnerKt.getLifecycleScope(lifecycleOwner3));
    }

    @Override // com.tencent.mobileqq.guild.homev2.parts.a, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        z9().k(this.onStateUpdate);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        z9().A(this.onStateUpdate);
    }
}
