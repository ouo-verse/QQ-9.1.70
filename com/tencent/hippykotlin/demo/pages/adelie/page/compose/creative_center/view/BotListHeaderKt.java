package com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import ap3.a;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieBottomBubbleTipView;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieBottomBubbleTipViewAttr;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieBottomBubbleTipViewEvent;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardAnimationViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.AdelieCreativeCenterViewModel;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.foundation.lazy.d;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.KuiklyKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import yo3.Offset;
import yo3.Size;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class BotListHeaderKt {
    public static final void BotListHeader(final AdelieCreativeCenterViewModel adelieCreativeCenterViewModel, final d dVar, final boolean z16, final Function1<? super Boolean, Unit> function1, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-1042899171);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1042899171, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListHeader (BotListHeader.kt:47)");
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = GuideBannerCardAnimationViewKt$$ExternalSyntheticOutline0.m(0.0f, null, 2, null, startRestartGroup);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue;
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState2 = (MutableState) rememberedValue2;
        Float valueOf = Float.valueOf(dVar.c());
        startRestartGroup.startReplaceableGroup(1618982084);
        boolean changed = startRestartGroup.changed(dVar) | startRestartGroup.changed(mutableState) | startRestartGroup.changed(function1);
        Object rememberedValue3 = startRestartGroup.rememberedValue();
        if (changed || rememberedValue3 == companion.getEmpty()) {
            rememberedValue3 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListHeaderKt$BotListHeader$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("contentOffset: ");
                    m3.append(d.this.c());
                    kLog.i("listView", m3.toString());
                    mutableState.setValue(Float.valueOf(d.this.c()));
                    function1.invoke(Boolean.FALSE);
                    return new DisposableEffectResult() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListHeaderKt$BotListHeader$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public final void dispose() {
                        }
                    };
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue3);
        }
        startRestartGroup.endReplaceableGroup();
        EffectsKt.DisposableEffect(valueOf, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue3, startRestartGroup, 0);
        RowKt.a(null, null, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -943173061, true, new Function3<n, Composer, Integer, Unit>(function1, i3, mutableState2, z16, adelieCreativeCenterViewModel) { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListHeaderKt$BotListHeader$2
            public final /* synthetic */ Function1<Boolean, Unit> $bubbleShow;
            public final /* synthetic */ boolean $bubbleState;
            public final /* synthetic */ MutableState<a> $imgCoordinates$delegate;
            public final /* synthetic */ AdelieCreativeCenterViewModel $viewModel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
                this.$imgCoordinates$delegate = mutableState2;
                this.$bubbleState = z16;
                this.$viewModel = adelieCreativeCenterViewModel;
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(n nVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-943173061, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListHeader.<anonymous> (BotListHeader.kt:62)");
                    }
                    com.tencent.ntcompose.material.n nVar2 = new com.tencent.ntcompose.material.n("PingFang SC");
                    int b16 = o.INSTANCE.b();
                    QUIToken qUIToken = QUIToken.INSTANCE;
                    h color$default = QUIToken.color$default("text_primary");
                    c f16 = c.INSTANCE.f();
                    i.Companion companion2 = i.INSTANCE;
                    TextKt.a("\u6211\u521b\u5efa\u7684", ComposeLayoutPropUpdaterKt.n(companion2, 16.0f, 16.0f, 0.0f, 10.0f, 4, null), null, color$default, Float.valueOf(17.0f), o.c(b16), f16, nVar2, null, null, null, Float.valueOf(24.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, (com.tencent.ntcompose.material.n.f339436b << 21) | 1601606, 48, 0, 134215428);
                    i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.v(companion2, 16.0f, 16.0f), 4.0f, 20.0f, 0.0f, 0.0f, 12, null);
                    final Function1<Boolean, Unit> function12 = this.$bubbleShow;
                    composer3.startReplaceableGroup(1157296644);
                    boolean changed2 = composer3.changed(function12);
                    Object rememberedValue4 = composer3.rememberedValue();
                    if (changed2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue4 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListHeaderKt$BotListHeader$2$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                function12.invoke(Boolean.TRUE);
                                return Unit.INSTANCE;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue4);
                    }
                    composer3.endReplaceableGroup();
                    i d16 = ViewEventPropUpdaterKt.d(n3, false, null, (Function1) rememberedValue4, 3, null);
                    final MutableState<a> mutableState3 = this.$imgCoordinates$delegate;
                    composer3.startReplaceableGroup(1157296644);
                    boolean changed3 = composer3.changed(mutableState3);
                    Object rememberedValue5 = composer3.rememberedValue();
                    if (changed3 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue5 = new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListHeaderKt$BotListHeader$2$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(a aVar) {
                                mutableState3.setValue(aVar);
                                return Unit.INSTANCE;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue5);
                    }
                    composer3.endReplaceableGroup();
                    ImageKt.a(qUIToken.image("info_circle", QUIToken.color$default("icon_tertiary")), null, null, null, null, ViewEventPropUpdaterKt.k(d16, (Function1) rememberedValue5), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer3, 262144, 0, 0, 2097118);
                    if (this.$bubbleState) {
                        final AdelieCreativeCenterViewModel adelieCreativeCenterViewModel2 = this.$viewModel;
                        final MutableState<a> mutableState4 = this.$imgCoordinates$delegate;
                        final Function1<Boolean, Unit> function13 = this.$bubbleShow;
                        KuiklyKt.a(null, null, new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListHeaderKt$BotListHeader$2.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                                final AdelieCreativeCenterViewModel adelieCreativeCenterViewModel3 = AdelieCreativeCenterViewModel.this;
                                final MutableState<a> mutableState5 = mutableState4;
                                final Function1<Boolean, Unit> function14 = function13;
                                viewContainer.addChild(new AdelieBottomBubbleTipView(), new Function1<AdelieBottomBubbleTipView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListHeaderKt.BotListHeader.2.3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(AdelieBottomBubbleTipView adelieBottomBubbleTipView) {
                                        AdelieBottomBubbleTipView adelieBottomBubbleTipView2 = adelieBottomBubbleTipView;
                                        final AdelieCreativeCenterViewModel adelieCreativeCenterViewModel4 = AdelieCreativeCenterViewModel.this;
                                        final MutableState<a> mutableState6 = mutableState5;
                                        adelieBottomBubbleTipView2.attr(new Function1<AdelieBottomBubbleTipViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListHeaderKt.BotListHeader.2.3.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(AdelieBottomBubbleTipViewAttr adelieBottomBubbleTipViewAttr) {
                                                AdelieBottomBubbleTipViewAttr adelieBottomBubbleTipViewAttr2 = adelieBottomBubbleTipViewAttr;
                                                ReadWriteProperty readWriteProperty = adelieBottomBubbleTipViewAttr2.bubbleMaxWidth$delegate;
                                                KProperty<?>[] kPropertyArr = AdelieBottomBubbleTipViewAttr.$$delegatedProperties;
                                                readWriteProperty.setValue(adelieBottomBubbleTipViewAttr2, kPropertyArr[0], Float.valueOf(160.0f));
                                                adelieBottomBubbleTipViewAttr2.bubbleTipMsg$delegate.setValue(adelieBottomBubbleTipViewAttr2, kPropertyArr[3], AdelieCreativeCenterViewModel.this.recycleTips);
                                                a value = mutableState6.getValue();
                                                if (value != null) {
                                                    Offset c16 = ap3.d.c(value);
                                                    Size size = value.getSize();
                                                    if (c16.getY() > 60.0f) {
                                                        adelieBottomBubbleTipViewAttr2.direction = 1;
                                                        adelieBottomBubbleTipViewAttr2.anchorX$delegate.setValue(adelieBottomBubbleTipViewAttr2, kPropertyArr[1], Float.valueOf((size.getWidth() / 2) + c16.getX()));
                                                        adelieBottomBubbleTipViewAttr2.anchorY$delegate.setValue(adelieBottomBubbleTipViewAttr2, kPropertyArr[2], Float.valueOf(c16.getY()));
                                                    } else {
                                                        adelieBottomBubbleTipViewAttr2.direction = 2;
                                                        adelieBottomBubbleTipViewAttr2.anchorX$delegate.setValue(adelieBottomBubbleTipViewAttr2, kPropertyArr[1], Float.valueOf((size.getWidth() / 2) + c16.getX()));
                                                        adelieBottomBubbleTipViewAttr2.anchorY$delegate.setValue(adelieBottomBubbleTipViewAttr2, kPropertyArr[2], Float.valueOf(c16.getY() + 16));
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final Function1<Boolean, Unit> function15 = function14;
                                        adelieBottomBubbleTipView2.event(new Function1<AdelieBottomBubbleTipViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListHeaderKt.BotListHeader.2.3.1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(AdelieBottomBubbleTipViewEvent adelieBottomBubbleTipViewEvent) {
                                                final Function1<Boolean, Unit> function16 = function15;
                                                adelieBottomBubbleTipViewEvent.clickHandler = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListHeaderKt.BotListHeader.2.3.1.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Unit invoke() {
                                                        function16.invoke(Boolean.FALSE);
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        }, composer3, 0, 3);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 196608, 31);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListHeaderKt$BotListHeader$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                BotListHeaderKt.BotListHeader(AdelieCreativeCenterViewModel.this, dVar, z16, function1, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
