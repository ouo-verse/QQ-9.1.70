package com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.modifer_ext.ModifierExtKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.QQAvatarViewKt;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq;
import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel$requestCreateTree$1;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.msf.QQNetworkEngine$Companion$sendOIDBRequest$1;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.msf.QQNetworkEngine$QQNetworkEngineOIDBRequest;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.utils.IntimateSpaceReportUtilKt;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.ntcompose.animation.Animatable;
import com.tencent.ntcompose.animation.m;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ActivityEventHandlerKt;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.APNGKt;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.ModalKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.material.h;
import e25.ad;
import e25.e;
import e25.f;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes37.dex */
public final class LoveWallPlantingGuildViewKt {
    public static final void LoveWallPlantingGuildView(final LoveWallHomepageViewModel loveWallHomepageViewModel, final Function0<Unit> function0, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-1194403102);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1194403102, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallPlantingGuildView (LoveWallPlantingGuildView.kt:47)");
        }
        ModalKt.a(null, false, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -302620380, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallPlantingGuildViewKt$LoveWallPlantingGuildView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        ComposerKt.traceEventStart(-302620380, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallPlantingGuildView.<anonymous> (LoveWallPlantingGuildView.kt:48)");
                    }
                    i pageVR = ModifierExtKt.pageVR(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), "pg_qz_love_tree_guide", IntimateSpaceReportUtilKt.getIntimateDTReportBaseParams());
                    final LoveWallHomepageViewModel loveWallHomepageViewModel2 = LoveWallHomepageViewModel.this;
                    final Function0<Unit> function02 = function0;
                    BoxKt.a(pageVR, null, null, ComposableLambdaKt.composableLambda(composer3, -101584598, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallPlantingGuildViewKt$LoveWallPlantingGuildView$1.1

                        @DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallPlantingGuildViewKt$LoveWallPlantingGuildView$1$1$2", f = "LoveWallPlantingGuildView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallPlantingGuildViewKt$LoveWallPlantingGuildView$1$1$2, reason: invalid class name */
                        /* loaded from: classes37.dex */
                        public final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            public final /* synthetic */ Animatable<Float> $successOpacityAnimation;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            public AnonymousClass2(Animatable<Float> animatable, Continuation<? super AnonymousClass2> continuation) {
                                super(2, continuation);
                                this.$successOpacityAnimation = animatable;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass2(this.$successOpacityAnimation, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                ResultKt.throwOnFailure(obj);
                                Animatable.b(this.$successOpacityAnimation, Boxing.boxFloat(1.0f), com.tencent.ntcompose.animation.b.d(500, 0, null, null, 14, null), null, false, 12, null);
                                return Unit.INSTANCE;
                            }
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-101584598, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallPlantingGuildView.<anonymous>.<anonymous> (LoveWallPlantingGuildView.kt:51)");
                                }
                                composer5.startReplaceableGroup(-492369756);
                                Object rememberedValue = composer5.rememberedValue();
                                Composer.Companion companion = Composer.INSTANCE;
                                if (rememberedValue == companion.getEmpty()) {
                                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(PlantingGuildStatus.START_PLANTING, null, 2, null);
                                    composer5.updateRememberedValue(rememberedValue);
                                }
                                composer5.endReplaceableGroup();
                                final MutableState mutableState = (MutableState) rememberedValue;
                                composer5.startReplaceableGroup(-492369756);
                                Object rememberedValue2 = composer5.rememberedValue();
                                if (rememberedValue2 == companion.getEmpty()) {
                                    rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new LoveWallPlantingGuildViewModel(), null, 2, null);
                                    composer5.updateRememberedValue(rememberedValue2);
                                }
                                composer5.endReplaceableGroup();
                                int ordinal = ((PlantingGuildStatus) mutableState.getValue()).ordinal();
                                if (ordinal == 0) {
                                    composer5.startReplaceableGroup(-1939392196);
                                    final LoveWallHomepageViewModel loveWallHomepageViewModel3 = LoveWallHomepageViewModel.this;
                                    LoveWallPlantingGuildViewKt.LoverWallStartGuildButtonView(loveWallHomepageViewModel3.pageData.peerUin, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallPlantingGuildViewKt.LoveWallPlantingGuildView.1.1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ClickParams clickParams) {
                                            final LoveWallHomepageViewModel loveWallHomepageViewModel4 = LoveWallHomepageViewModel.this;
                                            final MutableState<PlantingGuildStatus> mutableState2 = mutableState;
                                            final Function0<Unit> function03 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallPlantingGuildViewKt.LoveWallPlantingGuildView.1.1.1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final Unit invoke() {
                                                    mutableState2.setValue(PlantingGuildStatus.PLANT_SUCCESS);
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            e eVar = new e(Long.parseLong(loveWallHomepageViewModel4.pageData.peerUin));
                                            LoveWallHomepageViewModel$requestCreateTree$1 loveWallHomepageViewModel$requestCreateTree$1 = new Function1<byte[], f>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel$requestCreateTree$1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final f invoke(byte[] bArr) {
                                                    return (f) c45.i.b(new f(null, 1, null), bArr);
                                                }
                                            };
                                            Function1<OIDBResponse<f>, Unit> function1 = new Function1<OIDBResponse<f>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel$requestCreateTree$2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(OIDBResponse<f> oIDBResponse) {
                                                    ad adVar;
                                                    OIDBResponse<f> oIDBResponse2 = oIDBResponse;
                                                    if (!oIDBResponse2.success) {
                                                        KLog kLog = KLog.INSTANCE;
                                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("request create tree fail. Error: ");
                                                        m3.append(oIDBResponse2.f114186msg);
                                                        m3.append(", errorCode: ");
                                                        m3.append(oIDBResponse2.code);
                                                        kLog.e("LoveWallHomepage", m3.toString());
                                                        Mqq.INSTANCE.getUi().showErrorTips(ImageTaskConst.ErrorDesciption.IMAGE_TASK_LOCAL_RET_CODE_NETWORK_FAIL_DESC);
                                                    } else {
                                                        f fVar = oIDBResponse2.rsp;
                                                        if (fVar != null && (adVar = fVar.f395474d) != null) {
                                                            LoveWallHomepageViewModel loveWallHomepageViewModel5 = LoveWallHomepageViewModel.this;
                                                            Function0<Unit> function04 = function03;
                                                            loveWallHomepageViewModel5.tree.setValue(adVar);
                                                            loveWallHomepageViewModel5.userTreeState.setValue(UserTreeState.CREATED_TREE);
                                                            function04.invoke();
                                                            loveWallHomepageViewModel5.loadTree();
                                                            loveWallHomepageViewModel5.loadProgressView();
                                                            loveWallHomepageViewModel5.fetchWaterInfo(null);
                                                            LoveWallHomepageViewModel.fetchTree$default(loveWallHomepageViewModel5, true, null, 2);
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            QQKuiklyPlatformApi.Companion.sendOIDBRequest(new QQNetworkEngine$QQNetworkEngineOIDBRequest(37745, eVar, loveWallHomepageViewModel$requestCreateTree$1), false, new QQNetworkEngine$Companion$sendOIDBRequest$1(function1));
                                            return Unit.INSTANCE;
                                        }
                                    }, composer5, 0);
                                    composer5.endReplaceableGroup();
                                } else if (ordinal != 1) {
                                    composer5.startReplaceableGroup(-1939390521);
                                    composer5.endReplaceableGroup();
                                } else {
                                    composer5.startReplaceableGroup(-1939391780);
                                    if (mutableState.getValue() == PlantingGuildStatus.PLANT_SUCCESS) {
                                        composer5.startReplaceableGroup(-492369756);
                                        Object rememberedValue3 = composer5.rememberedValue();
                                        if (rememberedValue3 == companion.getEmpty()) {
                                            rememberedValue3 = new Animatable(Float.valueOf(0.0f));
                                            composer5.updateRememberedValue(rememberedValue3);
                                        }
                                        composer5.endReplaceableGroup();
                                        final Animatable animatable = (Animatable) rememberedValue3;
                                        EffectsKt.LaunchedEffect(animatable, new AnonymousClass2(animatable, null), composer5, Animatable.f339143c | 64);
                                        i D = ModifiersKt.D(i.INSTANCE, ((Number) animatable.f()).floatValue());
                                        String str = LoveWallHomepageViewModel.this.pageData.peerUin;
                                        final Function0<Unit> function03 = function02;
                                        LoveWallPlantingGuildViewKt.LoveWallStartSuccessGuildView(D, str, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallPlantingGuildViewKt.LoveWallPlantingGuildView.1.1.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Unit invoke() {
                                                Animatable<Float> animatable2 = animatable;
                                                Float valueOf = Float.valueOf(0.0f);
                                                m d16 = com.tencent.ntcompose.animation.b.d(500, 0, null, null, 14, null);
                                                final Function0<Unit> function04 = function03;
                                                Animatable.b(animatable2, valueOf, d16, new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallPlantingGuildViewKt.LoveWallPlantingGuildView.1.1.3.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Float f16) {
                                                        f16.floatValue();
                                                        function04.invoke();
                                                        return Unit.INSTANCE;
                                                    }
                                                }, false, 8, null);
                                                return Unit.INSTANCE;
                                            }
                                        }, composer5, 8);
                                    }
                                    composer5.endReplaceableGroup();
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 3080, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 24624, 13);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallPlantingGuildViewKt$LoveWallPlantingGuildView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallPlantingGuildViewKt.LoveWallPlantingGuildView(LoveWallHomepageViewModel.this, function0, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void LoveWallStartSuccessGuildView(final i iVar, final String str, final Function0<Unit> function0, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(505369312);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(505369312, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallStartSuccessGuildView (LoveWallPlantingGuildView.kt:190)");
        }
        i h16 = ComposeLayoutPropUpdaterKt.h(iVar, 0.0f, 1, null);
        startRestartGroup.startReplaceableGroup(1157296644);
        boolean changed = startRestartGroup.changed(function0);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallPlantingGuildViewKt$LoveWallStartSuccessGuildView$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(ClickParams clickParams) {
                    function0.invoke();
                    return Unit.INSTANCE;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        BoxKt.a(ViewEventPropUpdaterKt.d(h16, false, null, (Function1) rememberedValue, 3, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -2139907814, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallPlantingGuildViewKt$LoveWallStartSuccessGuildView$2

            @DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallPlantingGuildViewKt$LoveWallStartSuccessGuildView$2$3", f = "LoveWallPlantingGuildView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallPlantingGuildViewKt$LoveWallStartSuccessGuildView$2$3, reason: invalid class name */
            /* loaded from: classes37.dex */
            public final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                public final /* synthetic */ Animatable<Float> $opacityAnimation;
                public final /* synthetic */ MutableState<PlantingSuccessStatus> $status;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass3(Animatable<Float> animatable, MutableState<PlantingSuccessStatus> mutableState, Continuation<? super AnonymousClass3> continuation) {
                    super(2, continuation);
                    this.$opacityAnimation = animatable;
                    this.$status = mutableState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass3(this.$opacityAnimation, this.$status, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    ResultKt.throwOnFailure(obj);
                    Animatable<Float> animatable = this.$opacityAnimation;
                    Float boxFloat = Boxing.boxFloat(1.0f);
                    m d16 = com.tencent.ntcompose.animation.b.d(300, 0, null, null, 14, null);
                    final Animatable<Float> animatable2 = this.$opacityAnimation;
                    final MutableState<PlantingSuccessStatus> mutableState = this.$status;
                    Animatable.b(animatable, boxFloat, d16, new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallPlantingGuildViewKt.LoveWallStartSuccessGuildView.2.3.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(Float f16) {
                            f16.floatValue();
                            final Animatable<Float> animatable3 = animatable2;
                            final MutableState<PlantingSuccessStatus> mutableState2 = mutableState;
                            TimerKt.c(980, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallPlantingGuildViewKt.LoveWallStartSuccessGuildView.2.3.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Unit invoke() {
                                    Animatable<Float> animatable4 = animatable3;
                                    Float valueOf = Float.valueOf(0.0f);
                                    m d17 = com.tencent.ntcompose.animation.b.d(300, 0, null, null, 14, null);
                                    final MutableState<PlantingSuccessStatus> mutableState3 = mutableState2;
                                    Animatable.b(animatable4, valueOf, d17, new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallPlantingGuildViewKt.LoveWallStartSuccessGuildView.2.3.1.1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(Float f17) {
                                            f17.floatValue();
                                            mutableState3.setValue(PlantingSuccessStatus.TITLE_2);
                                            return Unit.INSTANCE;
                                        }
                                    }, false, 8, null);
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    }, false, 8, null);
                    return Unit.INSTANCE;
                }
            }

            @DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallPlantingGuildViewKt$LoveWallStartSuccessGuildView$2$4", f = "LoveWallPlantingGuildView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallPlantingGuildViewKt$LoveWallStartSuccessGuildView$2$4, reason: invalid class name */
            /* loaded from: classes37.dex */
            public final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                public final /* synthetic */ Animatable<Float> $opacityAnimation;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass4(Animatable<Float> animatable, Continuation<? super AnonymousClass4> continuation) {
                    super(2, continuation);
                    this.$opacityAnimation = animatable;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass4(this.$opacityAnimation, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    ResultKt.throwOnFailure(obj);
                    Animatable.b(this.$opacityAnimation, Boxing.boxFloat(1.0f), com.tencent.ntcompose.animation.b.d(300, 0, null, null, 14, null), null, false, 12, null);
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            /* JADX WARN: Type inference failed for: r3v4 */
            /* JADX WARN: Type inference failed for: r3v5, types: [int, boolean] */
            /* JADX WARN: Type inference failed for: r3v7 */
            /* JADX WARN: Type inference failed for: r3v8 */
            /* JADX WARN: Type inference failed for: r3v9 */
            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                Object obj;
                Object first;
                final MutableState mutableState;
                ?? r36;
                Object obj2;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2139907814, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallStartSuccessGuildView.<anonymous> (LoveWallPlantingGuildView.kt:193)");
                    }
                    i.Companion companion = i.INSTANCE;
                    ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.h(companion, 0.0f, 1, null), null, 0, null, null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_3NT0_y59pf2.png", null, null, null, null, null, null, null, null, null, null, composer3, 262144, 6, 0, 2096095);
                    composer3.startReplaceableGroup(-492369756);
                    Object rememberedValue2 = composer3.rememberedValue();
                    Composer.Companion companion2 = Composer.INSTANCE;
                    if (rememberedValue2 == companion2.getEmpty()) {
                        obj = null;
                        rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(PlantingSuccessStatus.NO_TITLE, null, 2, null);
                        composer3.updateRememberedValue(rememberedValue2);
                    } else {
                        obj = null;
                    }
                    composer3.endReplaceableGroup();
                    final MutableState mutableState2 = (MutableState) rememberedValue2;
                    i h17 = ComposeLayoutPropUpdaterKt.h(companion, 0.0f, 1, obj);
                    first = CollectionsKt___CollectionsKt.first((List<? extends Object>) LoveWallPlantingGuildViewModel.animationUrls);
                    String str2 = (String) first;
                    composer3.startReplaceableGroup(1157296644);
                    boolean changed2 = composer3.changed(mutableState2);
                    Object rememberedValue3 = composer3.rememberedValue();
                    if (changed2 || rememberedValue3 == companion2.getEmpty()) {
                        rememberedValue3 = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallPlantingGuildViewKt$LoveWallStartSuccessGuildView$2$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Object obj3) {
                                final MutableState<PlantingSuccessStatus> mutableState3 = mutableState2;
                                TimerKt.c(820, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallPlantingGuildViewKt$LoveWallStartSuccessGuildView$2$1$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        mutableState3.setValue(PlantingSuccessStatus.TITLE_1);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue3);
                    }
                    composer3.endReplaceableGroup();
                    Function1 function1 = (Function1) rememberedValue3;
                    final Function0<Unit> function02 = function0;
                    composer3.startReplaceableGroup(1157296644);
                    boolean changed3 = composer3.changed(function02);
                    Object rememberedValue4 = composer3.rememberedValue();
                    if (changed3 || rememberedValue4 == companion2.getEmpty()) {
                        rememberedValue4 = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallPlantingGuildViewKt$LoveWallStartSuccessGuildView$2$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Object obj3) {
                                function02.invoke();
                                return Unit.INSTANCE;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue4);
                    }
                    composer3.endReplaceableGroup();
                    APNGKt.a(h17, null, str2, 1, null, null, function1, (Function1) rememberedValue4, composer3, 3080, 50);
                    composer3.startReplaceableGroup(-492369756);
                    Object rememberedValue5 = composer3.rememberedValue();
                    if (rememberedValue5 == companion2.getEmpty()) {
                        rememberedValue5 = new Animatable(Float.valueOf(0.0f));
                        composer3.updateRememberedValue(rememberedValue5);
                    }
                    composer3.endReplaceableGroup();
                    Animatable animatable = (Animatable) rememberedValue5;
                    int ordinal = ((PlantingSuccessStatus) mutableState2.getValue()).ordinal();
                    if (ordinal != 0) {
                        r36 = 1;
                        r36 = 1;
                        r36 = 1;
                        if (ordinal == 1) {
                            obj2 = null;
                            composer3.startReplaceableGroup(1447651910);
                            mutableState = mutableState2;
                            EffectsKt.LaunchedEffect(animatable, new AnonymousClass3(animatable, mutableState, null), composer3, Animatable.f339143c | 64);
                            composer3.endReplaceableGroup();
                        } else if (ordinal != 2) {
                            composer3.startReplaceableGroup(1447653004);
                            composer3.endReplaceableGroup();
                            mutableState = mutableState2;
                            obj2 = null;
                        } else {
                            composer3.startReplaceableGroup(1447652746);
                            obj2 = null;
                            EffectsKt.LaunchedEffect(animatable, new AnonymousClass4(animatable, null), composer3, Animatable.f339143c | 64);
                            composer3.endReplaceableGroup();
                            mutableState = mutableState2;
                        }
                    } else {
                        mutableState = mutableState2;
                        r36 = 1;
                        obj2 = null;
                        composer3.startReplaceableGroup(1447651819);
                        composer3.endReplaceableGroup();
                    }
                    if (mutableState.getValue() == PlantingSuccessStatus.TITLE_1 || mutableState.getValue() == PlantingSuccessStatus.TITLE_2) {
                        i D = ModifiersKt.D(ComposeLayoutPropUpdaterKt.h(companion, 0.0f, r36, obj2), ((Number) animatable.f()).floatValue());
                        Alignment.Horizontal b16 = Alignment.INSTANCE.b();
                        final String str3 = str;
                        final int i16 = i3;
                        ColumnKt.a(D, null, b16, null, ComposableLambdaKt.composableLambda(composer3, 1723306888, r36, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallPlantingGuildViewKt$LoveWallStartSuccessGuildView$2.5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(d dVar, Composer composer4, Integer num2) {
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1723306888, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallStartSuccessGuildView.<anonymous>.<anonymous> (LoveWallPlantingGuildView.kt:249)");
                                    }
                                    i.Companion companion3 = i.INSTANCE;
                                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion3, 124), composer5, 8, 0);
                                    LoveWallPlantingGuildViewKt.LoverWallGuildAvatarView(str3, composer5, (i16 >> 3) & 14);
                                    i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion3, 0.0f, 1, null), 125.0f);
                                    final MutableState<PlantingSuccessStatus> mutableState3 = mutableState;
                                    BoxKt.a(k3, null, null, ComposableLambdaKt.composableLambda(composer5, 1339038402, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallPlantingGuildViewKt.LoveWallStartSuccessGuildView.2.5.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(b bVar2, Composer composer6, Integer num3) {
                                            int i17;
                                            String str4;
                                            b bVar3 = bVar2;
                                            Composer composer7 = composer6;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 14) == 0) {
                                                i17 = (composer7.changed(bVar3) ? 4 : 2) | intValue3;
                                            } else {
                                                i17 = intValue3;
                                            }
                                            if ((i17 & 91) == 18 && composer7.getSkipping()) {
                                                composer7.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1339038402, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallStartSuccessGuildView.<anonymous>.<anonymous>.<anonymous> (LoveWallPlantingGuildView.kt:254)");
                                                }
                                                i.Companion companion4 = i.INSTANCE;
                                                i a16 = bVar3.a(ComposeLayoutPropUpdaterKt.v(companion4, 227, 98), Alignment.Center);
                                                int c16 = h.INSTANCE.c();
                                                if (mutableState3.getValue() == PlantingSuccessStatus.TITLE_1) {
                                                    str4 = "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_27EH48ml6ux.png";
                                                } else {
                                                    str4 = "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_1E2oHD_EZYx.png";
                                                }
                                                ImageKt.a(null, null, null, null, null, a16, null, c16, null, null, str4, null, null, null, null, null, null, null, null, null, null, composer7, 12845056, 0, 0, 2095967);
                                                APNGKt.a(ComposeLayoutPropUpdaterKt.p(bVar3.a(ComposeLayoutPropUpdaterKt.v(companion4, (float) 211.5d, 93.5f), Alignment.TopCenter), 0.0f, -4, 1, null), null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/guild3_title_star.png", 0, null, null, null, null, composer7, 3464, 242);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer5, 3080, 6);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 24584, 10);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 3080, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallPlantingGuildViewKt$LoveWallStartSuccessGuildView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallPlantingGuildViewKt.LoveWallStartSuccessGuildView(i.this, str, function0, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void LoverWallGuildAvatarView(final String str, Composer composer, final int i3) {
        final int i16;
        Composer startRestartGroup = composer.startRestartGroup(198547);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(str) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i16 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(198547, i16, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoverWallGuildAvatarView (LoveWallPlantingGuildView.kt:94)");
            }
            BoxKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 64.0f), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -375268403, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallPlantingGuildViewKt$LoverWallGuildAvatarView$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(b bVar, Composer composer2, Integer num) {
                    int i17;
                    b bVar2 = bVar;
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 14) == 0) {
                        i17 = (composer3.changed(bVar2) ? 4 : 2) | intValue;
                    } else {
                        i17 = intValue;
                    }
                    if ((i17 & 91) == 18 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-375268403, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoverWallGuildAvatarView.<anonymous> (LoveWallPlantingGuildView.kt:97)");
                        }
                        i.Companion companion = i.INSTANCE;
                        i u16 = ComposeLayoutPropUpdaterKt.u(companion, 64.0f);
                        Alignment alignment = Alignment.Center;
                        i j3 = ModifiersKt.j(ComposeLayoutPropUpdaterKt.p(bVar2.a(u16, alignment), -25.0f, 0.0f, 2, null), 32.0f);
                        BorderStyle borderStyle = BorderStyle.SOLID;
                        h.Companion companion2 = com.tencent.kuikly.core.base.h.INSTANCE;
                        QQAvatarViewKt.QQAvatarView(ModifiersKt.g(j3, new com.tencent.kuikly.core.base.e(1.64f, borderStyle, companion2.m())), null, c.f117352a.g().getPageData().n().q("uin", ""), composer3, 8, 2);
                        QQAvatarViewKt.QQAvatarView(ModifiersKt.g(ModifiersKt.j(ComposeLayoutPropUpdaterKt.p(bVar2.a(ComposeLayoutPropUpdaterKt.u(companion, 64.0f), alignment), 25.0f, 0.0f, 2, null), 32.0f), new com.tencent.kuikly.core.base.e(1.64f, borderStyle, companion2.m())), null, str, composer3, ((i16 << 6) & 896) | 8, 2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 3080, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallPlantingGuildViewKt$LoverWallGuildAvatarView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallPlantingGuildViewKt.LoverWallGuildAvatarView(str, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void LoverWallStartGuildButtonView(final String str, final Function1<? super ClickParams, Unit> function1, Composer composer, final int i3) {
        final int i16;
        Composer startRestartGroup = composer.startRestartGroup(747256757);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(str) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i3 & 112) == 0) {
            i16 |= startRestartGroup.changed(function1) ? 32 : 16;
        }
        if ((i16 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(747256757, i16, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoverWallStartGuildButtonView (LoveWallPlantingGuildView.kt:121)");
            }
            BoxKt.a(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -101372869, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallPlantingGuildViewKt$LoverWallStartGuildButtonView$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(b bVar, Composer composer2, Integer num) {
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 81) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-101372869, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoverWallStartGuildButtonView.<anonymous> (LoveWallPlantingGuildView.kt:122)");
                        }
                        i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                        Alignment.Horizontal b16 = Alignment.INSTANCE.b();
                        final String str2 = str;
                        final int i17 = i16;
                        final Function1<ClickParams, Unit> function12 = function1;
                        ColumnKt.a(h16, null, b16, null, ComposableLambdaKt.composableLambda(composer3, -2122526862, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallPlantingGuildViewKt$LoverWallStartGuildButtonView$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(d dVar, Composer composer4, Integer num2) {
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-2122526862, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoverWallStartGuildButtonView.<anonymous>.<anonymous> (LoveWallPlantingGuildView.kt:125)");
                                    }
                                    i.Companion companion = i.INSTANCE;
                                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 78), composer5, 8, 0);
                                    LoveWallPlantingGuildViewKt.LoverWallGuildAvatarView(str2, composer5, i17 & 14);
                                    float f16 = 4;
                                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, f16), composer5, 8, 0);
                                    BoxKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), (float) 99.07d), null, null, ComposableSingletons$LoveWallPlantingGuildViewKt.f111lambda1, composer5, 3080, 6);
                                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, f16), composer5, 8, 0);
                                    composer5.startReplaceableGroup(-492369756);
                                    Object rememberedValue = composer5.rememberedValue();
                                    Composer.Companion companion2 = Composer.INSTANCE;
                                    if (rememberedValue == companion2.getEmpty()) {
                                        rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(Math.min((com.tencent.ntcompose.activity.b.a().getPageData().m() - 76.0f) * 1.6402439f, com.tencent.ntcompose.activity.b.a().getPageData().l() - 339.07f)), null, 2, null);
                                        composer5.updateRememberedValue(rememberedValue);
                                    }
                                    composer5.endReplaceableGroup();
                                    final MutableState mutableState = (MutableState) rememberedValue;
                                    Float valueOf = Float.valueOf(339.07f);
                                    composer5.startReplaceableGroup(511388516);
                                    boolean changed = composer5.changed(valueOf) | composer5.changed(mutableState);
                                    Object rememberedValue2 = composer5.rememberedValue();
                                    if (changed || rememberedValue2 == companion2.getEmpty()) {
                                        rememberedValue2 = new Function2<Double, Double, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallPlantingGuildViewKt$LoverWallStartGuildButtonView$1$1$1$1
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public final Unit invoke(Double d16, Double d17) {
                                                d16.doubleValue();
                                                d17.doubleValue();
                                                MutableState.this.setValue(Float.valueOf(Math.min((com.tencent.ntcompose.activity.b.a().getPageData().m() - 76.0f) * 1.6402439f, com.tencent.ntcompose.activity.b.a().getPageData().l() - 339.07f)));
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        composer5.updateRememberedValue(rememberedValue2);
                                    }
                                    composer5.endReplaceableGroup();
                                    ActivityEventHandlerKt.a((Function2) rememberedValue2, composer5, 0);
                                    float f17 = 38;
                                    i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, ((((Number) mutableState.getValue()).floatValue() * 328.0f) / 538.0f) + 76.0f), ((Number) mutableState.getValue()).floatValue()), f17, 0.0f, f17, 0.0f, 10, null);
                                    final Function1<ClickParams, Unit> function13 = function12;
                                    BoxKt.a(n3, null, null, ComposableLambdaKt.composableLambda(composer5, -990240081, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallPlantingGuildViewKt.LoverWallStartGuildButtonView.1.1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(b bVar2, Composer composer6, Integer num3) {
                                            int i18;
                                            b bVar3 = bVar2;
                                            Composer composer7 = composer6;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 14) == 0) {
                                                i18 = (composer7.changed(bVar3) ? 4 : 2) | intValue3;
                                            } else {
                                                i18 = intValue3;
                                            }
                                            if ((i18 & 91) == 18 && composer7.getSkipping()) {
                                                composer7.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-990240081, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoverWallStartGuildButtonView.<anonymous>.<anonymous>.<anonymous> (LoveWallPlantingGuildView.kt:157)");
                                                }
                                                i.Companion companion3 = i.INSTANCE;
                                                ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.h(companion3, 0.0f, 1, null), null, com.tencent.ntcompose.material.h.INSTANCE.c(), null, null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_xj63Ov11Dv1.png", null, null, null, null, null, null, null, null, null, null, composer7, 12845056, 6, 0, 2095967);
                                                BoxKt.a(ViewEventPropUpdaterKt.d(ModifierExtKt.elementVR(bVar3.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion3, 0.0f, 1, null), 80), Alignment.BottomCenter), "em_qz_together_plant", IntimateSpaceReportUtilKt.getIntimateDTReportBaseParams()), false, null, function13, 3, null), null, null, ComposableSingletons$LoveWallPlantingGuildViewKt.f112lambda2, composer7, 3080, 6);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer5, 3080, 6);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 24584, 10);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 3080, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallPlantingGuildViewKt$LoverWallStartGuildButtonView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallPlantingGuildViewKt.LoverWallStartGuildButtonView(str, function1, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
