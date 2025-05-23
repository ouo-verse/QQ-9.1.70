package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.FooterRefreshState;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.l;
import com.tencent.ntcompose.foundation.lazy.layout.LazyDslKt;
import com.tencent.ntcompose.foundation.lazy.layout.a;
import com.tencent.ntcompose.material.FooterRefreshKt;
import com.tencent.ntcompose.material.GridLayoutMode;
import com.tencent.ntcompose.material.LazyVerticalGridKt;
import com.tencent.ntcompose.material.p;
import com.tencent.ntcompose.material.r;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ComposeFeedListViewModel {
    public MutableState<Boolean> disableFooterRefresh;
    public final SnapshotStateList<BaseComposeCardViewModel> feedCardViewModelList = SnapshotStateKt.mutableStateListOf();
    public p footerRefreshState;
    public final Function1<Function2<? super Boolean, ? super Boolean, Unit>, Unit> onLoadMore;

    /* JADX WARN: Multi-variable type inference failed */
    public ComposeFeedListViewModel(Function1<? super Function2<? super Boolean, ? super Boolean, Unit>, Unit> function1) {
        MutableState<Boolean> mutableStateOf$default;
        this.onLoadMore = function1;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.disableFooterRefresh = mutableStateOf$default;
    }

    public static final void access$GenerateFeedItems(ComposeFeedListViewModel composeFeedListViewModel, final a aVar, final ComposeFeedListViewModel composeFeedListViewModel2, Composer composer, final int i3) {
        composeFeedListViewModel.getClass();
        Composer startRestartGroup = composer.startRestartGroup(-834040298);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-834040298, i3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.ComposeFeedListViewModel.GenerateFeedItems (ComposeFeedListViewModel.kt:151)");
        }
        LazyDslKt.c(aVar, composeFeedListViewModel2.feedCardViewModelList, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1818703686, true, new Function4<Integer, BaseComposeCardViewModel, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.ComposeFeedListViewModel$GenerateFeedItems$1
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public final Unit invoke(Integer num, BaseComposeCardViewModel baseComposeCardViewModel, Composer composer2, Integer num2) {
                int intValue = num.intValue();
                BaseComposeCardViewModel baseComposeCardViewModel2 = baseComposeCardViewModel;
                Composer composer3 = composer2;
                int intValue2 = num2.intValue();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1818703686, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.ComposeFeedListViewModel.GenerateFeedItems.<anonymous> (ComposeFeedListViewModel.kt:152)");
                }
                baseComposeCardViewModel2.buildCardView(a.this, baseComposeCardViewModel2, intValue, composer3, ((intValue2 << 6) & 896) | 4168);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 3080, 2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.ComposeFeedListViewModel$GenerateFeedItems$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                ComposeFeedListViewModel.access$GenerateFeedItems(ComposeFeedListViewModel.this, aVar, composeFeedListViewModel2, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$GenerateFooterRefresh(final ComposeFeedListViewModel composeFeedListViewModel, final float f16, final Function3 function3, Composer composer, final int i3) {
        MutableState mutableStateOf$default;
        composeFeedListViewModel.getClass();
        Composer startRestartGroup = composer.startRestartGroup(661966185);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(661966185, i3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.ComposeFeedListViewModel.GenerateFooterRefresh (ComposeFeedListViewModel.kt:158)");
        }
        if (!composeFeedListViewModel.disableFooterRefresh.getValue().booleanValue()) {
            final p b16 = FooterRefreshKt.b(startRestartGroup, 0);
            composeFeedListViewModel.footerRefreshState = b16;
            EffectsKt.DisposableEffect(Unit.INSTANCE, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.ComposeFeedListViewModel$GenerateFooterRefresh$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    final ComposeFeedListViewModel composeFeedListViewModel2 = ComposeFeedListViewModel.this;
                    return new DisposableEffectResult() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.ComposeFeedListViewModel$GenerateFooterRefresh$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public final void dispose() {
                            ComposeFeedListViewModel.this.footerRefreshState = null;
                        }
                    };
                }
            }, startRestartGroup, 0);
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue = startRestartGroup.rememberedValue();
            T t16 = rememberedValue;
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(FooterRefreshState.IDLE, null, 2, null);
                startRestartGroup.updateRememberedValue(mutableStateOf$default);
                t16 = mutableStateOf$default;
            }
            startRestartGroup.endReplaceableGroup();
            objectRef.element = t16;
            FooterRefreshKt.a(b16, null, ComposeLayoutPropUpdaterKt.w(i.INSTANCE, f16), 1000.0f, 0.0f, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.ComposeFeedListViewModel$GenerateFooterRefresh$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    if (objectRef.element.getValue() != FooterRefreshState.NONE_MORE_DATA) {
                        objectRef.element.setValue(FooterRefreshState.REFRESHING);
                        Function1<Function2<? super Boolean, ? super Boolean, Unit>, Unit> function1 = composeFeedListViewModel.onLoadMore;
                        final p pVar = b16;
                        final Ref.ObjectRef<MutableState<FooterRefreshState>> objectRef2 = objectRef;
                        function1.invoke(new Function2<Boolean, Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.ComposeFeedListViewModel$GenerateFooterRefresh$2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(Boolean bool, Boolean bool2) {
                                boolean booleanValue = bool.booleanValue();
                                boolean booleanValue2 = bool2.booleanValue();
                                p.this.b(false);
                                if (booleanValue2) {
                                    objectRef2.element.setValue(FooterRefreshState.FAILURE);
                                } else if (booleanValue) {
                                    objectRef2.element.setValue(FooterRefreshState.NONE_MORE_DATA);
                                } else {
                                    objectRef2.element.setValue(FooterRefreshState.IDLE);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                    }
                    return Unit.INSTANCE;
                }
            }, ComposableLambdaKt.composableLambda(startRestartGroup, -67105645, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.ComposeFeedListViewModel$GenerateFooterRefresh$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 11) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-67105645, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.ComposeFeedListViewModel.GenerateFooterRefresh.<anonymous> (ComposeFeedListViewModel.kt:187)");
                        }
                        function3.invoke(objectRef.element.getValue(), composer3, Integer.valueOf(i3 & 112));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 1576448, 18);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.ComposeFeedListViewModel$GenerateFooterRefresh$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                ComposeFeedListViewModel.access$GenerateFooterRefresh(ComposeFeedListViewModel.this, f16, function3, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static void resetFooterRefresh$default(ComposeFeedListViewModel composeFeedListViewModel) {
        composeFeedListViewModel.disableFooterRefresh.setValue(Boolean.TRUE);
        composeFeedListViewModel.footerRefreshState = null;
        TimerKt.c(17, new ComposeFeedListViewModel$resetFooterRefresh$1(composeFeedListViewModel, null));
    }

    public final void buildLazyVerticalGrid(r rVar, i iVar, final float f16, com.tencent.ntcompose.foundation.lazy.a aVar, l lVar, float f17, float f18, Boolean bool, to3.a aVar2, Boolean bool2, Boolean bool3, Boolean bool4, GridLayoutMode gridLayoutMode, int i3, Float f19, Function1<? super ScrollParams, Unit> function1, Function1<? super ScrollParams, Unit> function12, Function1<? super ScrollParams, Unit> function13, Function1<? super ScrollParams, Unit> function14, Function2<? super Float, ? super Float, Unit> function2, final Function3<? super FooterRefreshState, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i16, final int i17, final int i18, final int i19) {
        r rVar2;
        int i26;
        Composer startRestartGroup = composer.startRestartGroup(321664104);
        if ((i19 & 1) != 0) {
            i26 = i16 & (-15);
            rVar2 = new r.a(1);
        } else {
            rVar2 = rVar;
            i26 = i16;
        }
        i iVar2 = (i19 & 2) != 0 ? i.INSTANCE : iVar;
        com.tencent.ntcompose.foundation.lazy.a aVar3 = (i19 & 8) != 0 ? null : aVar;
        l lVar2 = (i19 & 16) != 0 ? null : lVar;
        float f26 = (i19 & 32) != 0 ? 0.0f : f17;
        float f27 = (i19 & 64) != 0 ? 0.0f : f18;
        Boolean bool5 = (i19 & 128) != 0 ? null : bool;
        to3.a aVar4 = (i19 & 256) != 0 ? null : aVar2;
        Boolean bool6 = (i19 & 512) != 0 ? null : bool2;
        Boolean bool7 = (i19 & 1024) != 0 ? null : bool3;
        Boolean bool8 = (i19 & 2048) != 0 ? null : bool4;
        GridLayoutMode gridLayoutMode2 = (i19 & 4096) != 0 ? null : gridLayoutMode;
        int i27 = (i19 & 8192) != 0 ? 8 : i3;
        Float f28 = (i19 & 16384) != 0 ? null : f19;
        Function1<? super ScrollParams, Unit> function15 = (32768 & i19) != 0 ? null : function1;
        Function1<? super ScrollParams, Unit> function16 = (65536 & i19) != 0 ? null : function12;
        Function1<? super ScrollParams, Unit> function17 = (131072 & i19) != 0 ? null : function13;
        Function1<? super ScrollParams, Unit> function18 = (262144 & i19) != 0 ? null : function14;
        Function2<? super Float, ? super Float, Unit> function22 = (524288 & i19) != 0 ? null : function2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(321664104, i26, i17, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.ComposeFeedListViewModel.buildLazyVerticalGrid (ComposeFeedListViewModel.kt:65)");
        }
        if (this.feedCardViewModelList.isEmpty()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                return;
            }
            final r rVar3 = rVar2;
            final i iVar3 = iVar2;
            final com.tencent.ntcompose.foundation.lazy.a aVar5 = aVar3;
            final l lVar3 = lVar2;
            final float f29 = f26;
            final float f36 = f27;
            final Boolean bool9 = bool5;
            final to3.a aVar6 = aVar4;
            final Boolean bool10 = bool6;
            final Boolean bool11 = bool7;
            final Boolean bool12 = bool8;
            final GridLayoutMode gridLayoutMode3 = gridLayoutMode2;
            final int i28 = i27;
            final Float f37 = f28;
            final Function1<? super ScrollParams, Unit> function19 = function15;
            final Function1<? super ScrollParams, Unit> function110 = function16;
            final Function1<? super ScrollParams, Unit> function111 = function17;
            final Function1<? super ScrollParams, Unit> function112 = function18;
            final Function2<? super Float, ? super Float, Unit> function23 = function22;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.ComposeFeedListViewModel$buildLazyVerticalGrid$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    ComposeFeedListViewModel.this.buildLazyVerticalGrid(rVar3, iVar3, f16, aVar5, lVar3, f29, f36, bool9, aVar6, bool10, bool11, bool12, gridLayoutMode3, i28, f37, function19, function110, function111, function112, function23, function3, composer2, i16 | 1, i17, i18, i19);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        final int i29 = i26;
        int i36 = i26 << 3;
        int i37 = (i26 & 14) | 64 | (i26 & 896) | (i36 & 57344) | (458752 & i36) | (i36 & 3670016) | (i36 & 29360128) | (234881024 & i36) | (i36 & 1879048192);
        int i38 = i17 << 3;
        int i39 = ((i26 >> 27) & 14) | (i38 & 112) | (i38 & 896) | (i38 & 7168);
        int i46 = i17 << 9;
        int i47 = i39 | (i46 & 3670016) | (i46 & 29360128);
        int i48 = i17 >> 15;
        LazyVerticalGridKt.a(rVar2, iVar2, f16, null, aVar3, lVar2, f26, f27, bool5, aVar4, bool6, bool7, bool8, gridLayoutMode2, null, null, i27, f28, null, null, function15, function16, function17, function18, function22, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1547828883, true, new Function3<a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.ComposeFeedListViewModel$buildLazyVerticalGrid$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(a aVar7, Composer composer2, Integer num) {
                a aVar8 = aVar7;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1547828883, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.ComposeFeedListViewModel.buildLazyVerticalGrid.<anonymous> (ComposeFeedListViewModel.kt:143)");
                }
                ComposeFeedListViewModel.access$GenerateFeedItems(ComposeFeedListViewModel.this, aVar8, this, composer3, 584);
                ComposeFeedListViewModel.access$GenerateFooterRefresh(ComposeFeedListViewModel.this, f16, function3, composer3, ((i29 >> 6) & 14) | 512 | ((i18 << 3) & 112));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, i37, i47, (i48 & 14) | 1572864 | (i48 & 112) | (i48 & 896) | (i48 & 7168) | (i48 & 57344), 34390024);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 == null) {
            return;
        }
        final r rVar4 = rVar2;
        final i iVar4 = iVar2;
        final com.tencent.ntcompose.foundation.lazy.a aVar7 = aVar3;
        final l lVar4 = lVar2;
        final float f38 = f26;
        final float f39 = f27;
        final Boolean bool13 = bool5;
        final to3.a aVar8 = aVar4;
        final Boolean bool14 = bool6;
        final Boolean bool15 = bool7;
        final Boolean bool16 = bool8;
        final GridLayoutMode gridLayoutMode4 = gridLayoutMode2;
        final int i49 = i27;
        final Float f46 = f28;
        final Function1<? super ScrollParams, Unit> function113 = function15;
        final Function1<? super ScrollParams, Unit> function114 = function16;
        final Function1<? super ScrollParams, Unit> function115 = function17;
        final Function1<? super ScrollParams, Unit> function116 = function18;
        final Function2<? super Float, ? super Float, Unit> function24 = function22;
        endRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.ComposeFeedListViewModel$buildLazyVerticalGrid$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                ComposeFeedListViewModel.this.buildLazyVerticalGrid(rVar4, iVar4, f16, aVar7, lVar4, f38, f39, bool13, aVar8, bool14, bool15, bool16, gridLayoutMode4, i49, f46, function113, function114, function115, function116, function24, function3, composer2, i16 | 1, i17, i18, i19);
                return Unit.INSTANCE;
            }
        });
    }
}
