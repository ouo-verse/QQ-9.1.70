package com.tencent.hippykotlin.demo.pages.qq_intimate_space.share;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QRCodeViewKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.QQAvatarViewKt;
import com.tencent.hippykotlin.demo.pages.foundation.lib.UriKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveFlowerCardConfig;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveFlowerCardViewKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveSproutCardConfig;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveSproutCardViewKt;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.views.LoadSuccessParams;
import com.tencent.kuikly.core.views.v;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* loaded from: classes37.dex */
public final class LoveWallFlowerCardSharePageViewKt {
    public static final void FlowerCardShareContentView(final i iVar, Function2<? super v, ? super aa<v>, Unit> function2, final float f16, final LoveWallFlowerCardShareViewModel loveWallFlowerCardShareViewModel, Composer composer, final int i3, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(107382223);
        if ((i16 & 2) != 0) {
            function2 = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(107382223, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.FlowerCardShareContentView (LoveWallFlowerCardSharePageView.kt:110)");
        }
        BoxKt.a(iVar, null, function2, ComposableLambdaKt.composableLambda(startRestartGroup, -1756393207, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallFlowerCardSharePageViewKt$FlowerCardShareContentView$1
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
                        ComposerKt.traceEventStart(-1756393207, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.FlowerCardShareContentView.<anonymous> (LoveWallFlowerCardSharePageView.kt:119)");
                    }
                    composer3.startReplaceableGroup(-492369756);
                    Object rememberedValue = composer3.rememberedValue();
                    Composer.Companion companion = Composer.INSTANCE;
                    if (rememberedValue == companion.getEmpty()) {
                        rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composer3.updateRememberedValue(rememberedValue);
                    }
                    composer3.endReplaceableGroup();
                    final MutableState mutableState = (MutableState) rememberedValue;
                    i.Companion companion2 = i.INSTANCE;
                    i h16 = ComposeLayoutPropUpdaterKt.h(companion2, 0.0f, 1, null);
                    composer3.startReplaceableGroup(1157296644);
                    boolean changed = composer3.changed(mutableState);
                    Object rememberedValue2 = composer3.rememberedValue();
                    if (changed || rememberedValue2 == companion.getEmpty()) {
                        rememberedValue2 = new Function1<LoadSuccessParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallFlowerCardSharePageViewKt$FlowerCardShareContentView$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(LoadSuccessParams loadSuccessParams) {
                                mutableState.setValue(Boolean.TRUE);
                                return Unit.INSTANCE;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue2);
                    }
                    composer3.endReplaceableGroup();
                    ImageKt.a(null, null, null, null, null, h16, null, 0, null, null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_N8aSQUQJRTl.png", null, null, null, null, null, (Function1) rememberedValue2, null, null, null, null, composer3, 262144, 6, 0, 2030559);
                    if (!((Boolean) mutableState.getValue()).booleanValue()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        i h17 = ComposeLayoutPropUpdaterKt.h(companion2, 0.0f, 1, null);
                        Alignment.Companion companion3 = Alignment.INSTANCE;
                        Alignment.Horizontal b16 = companion3.b();
                        final LoveWallFlowerCardShareViewModel loveWallFlowerCardShareViewModel2 = LoveWallFlowerCardShareViewModel.this;
                        final float f17 = f16;
                        ColumnKt.a(h17, null, b16, null, ComposableLambdaKt.composableLambda(composer3, -1969130446, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallFlowerCardSharePageViewKt$FlowerCardShareContentView$1.2
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
                                        ComposerKt.traceEventStart(-1969130446, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.FlowerCardShareContentView.<anonymous>.<anonymous> (LoveWallFlowerCardSharePageView.kt:135)");
                                    }
                                    i.Companion companion4 = i.INSTANCE;
                                    BoxKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion4, 0.0f, 1, null), 26), null, null, ComposableSingletons$LoveWallFlowerCardSharePageViewKt.f113lambda1, composer5, 3080, 6);
                                    if (LoveWallFlowerCardShareViewModel.this.flower.f395478d == 1) {
                                        composer5.startReplaceableGroup(1091821556);
                                        LoveSproutCardViewKt.LoveSproutCardView(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion4, 0.0f, 1, null), f17), 16.28f, 0.0f, 10, 0.0f, 10, null), new LoveSproutCardConfig(LoveWallFlowerCardShareViewModel.this.flower, (String) null, (String) null, 28.0f, 12.0f, 6), null, composer5, 8, 4);
                                        composer5.endReplaceableGroup();
                                    } else {
                                        composer5.startReplaceableGroup(1091822061);
                                        LoveFlowerCardViewKt.LoveFlowerCardView(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion4, 0.0f, 1, null), f17), 16.28f, 0.0f, 10, 0.0f, 10, null), LoveWallFlowerCardShareViewModel.this.flower, new LoveFlowerCardConfig(false, 28.0f), null, composer5, 72, 8);
                                        composer5.endReplaceableGroup();
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 24584, 10);
                        float f18 = 12;
                        i a16 = bVar2.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion2, 0.0f, 1, null), 51), f18, 0.0f, f18, f18, 2, null), Alignment.BottomStart);
                        Alignment.Vertical a17 = companion3.a();
                        a.e e16 = a.f339245a.e();
                        final LoveWallFlowerCardShareViewModel loveWallFlowerCardShareViewModel3 = LoveWallFlowerCardShareViewModel.this;
                        RowKt.a(a16, e16, a17, null, null, ComposableLambdaKt.composableLambda(composer3, -1748441, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallFlowerCardSharePageViewKt$FlowerCardShareContentView$1.3
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(n nVar, Composer composer4, Integer num2) {
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1748441, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.FlowerCardShareContentView.<anonymous>.<anonymous> (LoveWallFlowerCardSharePageView.kt:180)");
                                    }
                                    i.Companion companion4 = i.INSTANCE;
                                    i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.f(companion4, 0.0f, 1, null), 12, 0.0f, 0.0f, 0.0f, 14, null);
                                    final LoveWallFlowerCardShareViewModel loveWallFlowerCardShareViewModel4 = LoveWallFlowerCardShareViewModel.this;
                                    ColumnKt.a(n3, null, null, null, ComposableLambdaKt.composableLambda(composer5, -302901872, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallFlowerCardSharePageViewKt.FlowerCardShareContentView.1.3.1
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(d dVar, Composer composer6, Integer num3) {
                                            Composer composer7 = composer6;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                composer7.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-302901872, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.FlowerCardShareContentView.<anonymous>.<anonymous>.<anonymous> (LoveWallFlowerCardSharePageView.kt:184)");
                                                }
                                                i.Companion companion5 = i.INSTANCE;
                                                i v3 = ComposeLayoutPropUpdaterKt.v(companion5, 63.58f, 36.0f);
                                                final LoveWallFlowerCardShareViewModel loveWallFlowerCardShareViewModel5 = LoveWallFlowerCardShareViewModel.this;
                                                BoxKt.a(v3, null, null, ComposableLambdaKt.composableLambda(composer7, -1397502774, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallFlowerCardSharePageViewKt.FlowerCardShareContentView.1.3.1.1
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(b bVar3, Composer composer8, Integer num4) {
                                                        Composer composer9 = composer8;
                                                        int intValue4 = num4.intValue();
                                                        if ((intValue4 & 81) == 16 && composer9.getSkipping()) {
                                                            composer9.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1397502774, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.FlowerCardShareContentView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LoveWallFlowerCardSharePageView.kt:185)");
                                                            }
                                                            i.Companion companion6 = i.INSTANCE;
                                                            float f19 = 36;
                                                            float f26 = 18;
                                                            i j3 = ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(companion6, f19), f26);
                                                            BorderStyle borderStyle = BorderStyle.SOLID;
                                                            h.Companion companion7 = h.INSTANCE;
                                                            QQAvatarViewKt.QQAvatarView(ModifiersKt.g(j3, new e(1.64f, borderStyle, companion7.m())), null, c.f117352a.g().getPageData().n().q("uin", ""), composer9, 8, 2);
                                                            QQAvatarViewKt.QQAvatarView(ModifiersKt.g(ModifiersKt.j(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(companion6, f19), 27.58f, 0.0f, 0.0f, 0.0f, 14, null), f26), new e(1.64f, borderStyle, companion7.m())), null, LoveWallFlowerCardShareViewModel.this.pageData.peerUin, composer9, 8, 2);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer7, 3080, 6);
                                                TextKt.a("\u626b\u4e00\u626b\uff0c\u53c2\u4e0e\u7231\u60c5\u85e4\u8513", ComposeLayoutPropUpdaterKt.n(companion5, 0.0f, 4, 0.0f, 0.0f, 13, null), null, QUIToken.color$default("button_text_secondary_disable"), Float.valueOf(7.65f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, 28742, 0, 0, 134217700);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer5, 24584, 14);
                                    i D = ModifiersKt.D(ComposeLayoutPropUpdaterKt.u(companion4, 40), 0.5f);
                                    LoveWallFlowerCardShareViewModel loveWallFlowerCardShareViewModel5 = LoveWallFlowerCardShareViewModel.this;
                                    loveWallFlowerCardShareViewModel5.getClass();
                                    String str = "mqzone://arouse/intimate/lovetree?uin=" + c.f117352a.g().getPageData().n().q("uin", "") + "&peer_uin=" + loveWallFlowerCardShareViewModel5.pageData.peerUin + "&enter_page=1&flower_id=" + loveWallFlowerCardShareViewModel5.flower.f395478d + "&from=4";
                                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("https://ti.qq.com/open_qq/index.html?url=");
                                    m3.append(UriKt.encodeURIComponent(str));
                                    String sb5 = m3.toString();
                                    DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("qrCodeUrl: ", sb5, KLog.INSTANCE, "LoveWallFlowerCardShareViewModel");
                                    QRCodeViewKt.QRCodeView(D, null, sb5, 40.0f, null, null, composer5, 3080, 50);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 196680, 24);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, ((i3 << 3) & 896) | 3080, 2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Function2<? super v, ? super aa<v>, Unit> function22 = function2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallFlowerCardSharePageViewKt$FlowerCardShareContentView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallFlowerCardSharePageViewKt.FlowerCardShareContentView(i.this, function22, f16, loveWallFlowerCardShareViewModel, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void LoveWallFlowerCardSharePageView(final LoveWallFlowerCardShareViewModel loveWallFlowerCardShareViewModel, final Function0<Unit> function0, Composer composer, final int i3, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(2099101278);
        if ((i16 & 2) != 0) {
            function0 = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2099101278, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallFlowerCardSharePageView (LoveWallFlowerCardSharePageView.kt:54)");
        }
        BoxKt.a(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1580815848, true, new Function3<b, Composer, Integer, Unit>(function0, i3, loveWallFlowerCardShareViewModel) { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallFlowerCardSharePageViewKt$LoveWallFlowerCardSharePageView$1
            public static final /* synthetic */ int $r8$clinit = 0;
            public final /* synthetic */ Function0<Unit> $onDismiss;
            public final /* synthetic */ LoveWallFlowerCardShareViewModel $viewModel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
                this.$viewModel = loveWallFlowerCardShareViewModel;
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1580815848, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallFlowerCardSharePageView.<anonymous> (LoveWallFlowerCardSharePageView.kt:58)");
                    }
                    composer3.startReplaceableGroup(-492369756);
                    Object rememberedValue = composer3.rememberedValue();
                    Composer.Companion companion = Composer.INSTANCE;
                    if (rememberedValue == companion.getEmpty()) {
                        rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                        composer3.updateRememberedValue(rememberedValue);
                    }
                    composer3.endReplaceableGroup();
                    final MutableState mutableState = (MutableState) rememberedValue;
                    composer3.startReplaceableGroup(-492369756);
                    Object rememberedValue2 = composer3.rememberedValue();
                    if (rememberedValue2 == companion.getEmpty()) {
                        rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new ImageSharePanelViewModel(null, null, 3, null), null, 2, null);
                        composer3.updateRememberedValue(rememberedValue2);
                    }
                    composer3.endReplaceableGroup();
                    final MutableState mutableState2 = (MutableState) rememberedValue2;
                    composer3.startReplaceableGroup(-492369756);
                    Object rememberedValue3 = composer3.rememberedValue();
                    if (rememberedValue3 == companion.getEmpty()) {
                        rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composer3.updateRememberedValue(rememberedValue3);
                    }
                    composer3.endReplaceableGroup();
                    final MutableState mutableState3 = (MutableState) rememberedValue3;
                    ImageSharePanelViewModel imageSharePanelViewModel = (ImageSharePanelViewModel) mutableState2.getValue();
                    PanelConfig panelConfig = new PanelConfig();
                    composer3.startReplaceableGroup(1157296644);
                    boolean changed = composer3.changed(mutableState);
                    Object rememberedValue4 = composer3.rememberedValue();
                    if (changed || rememberedValue4 == companion.getEmpty()) {
                        rememberedValue4 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallFlowerCardSharePageViewKt$LoveWallFlowerCardSharePageView$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                mutableState.setValue(Boolean.TRUE);
                                return Unit.INSTANCE;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue4);
                    }
                    composer3.endReplaceableGroup();
                    Function0 function02 = (Function0) rememberedValue4;
                    composer3.startReplaceableGroup(1157296644);
                    boolean changed2 = composer3.changed(mutableState);
                    Object rememberedValue5 = composer3.rememberedValue();
                    if (changed2 || rememberedValue5 == companion.getEmpty()) {
                        rememberedValue5 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallFlowerCardSharePageViewKt$LoveWallFlowerCardSharePageView$1$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                mutableState.setValue(Boolean.FALSE);
                                return Unit.INSTANCE;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue5);
                    }
                    composer3.endReplaceableGroup();
                    Function0 function03 = (Function0) rememberedValue5;
                    final Function0<Unit> function04 = this.$onDismiss;
                    composer3.startReplaceableGroup(1157296644);
                    boolean changed3 = composer3.changed(function04);
                    Object rememberedValue6 = composer3.rememberedValue();
                    if (changed3 || rememberedValue6 == companion.getEmpty()) {
                        rememberedValue6 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallFlowerCardSharePageViewKt$LoveWallFlowerCardSharePageView$1$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                Function0<Unit> function05 = function04;
                                if (function05 != null) {
                                    function05.invoke();
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue6);
                    }
                    composer3.endReplaceableGroup();
                    final LoveWallFlowerCardShareViewModel loveWallFlowerCardShareViewModel2 = this.$viewModel;
                    Function1<ShareItem, Unit> function1 = new Function1<ShareItem, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallFlowerCardSharePageViewKt$LoveWallFlowerCardSharePageView$1.4

                        @DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallFlowerCardSharePageViewKt$LoveWallFlowerCardSharePageView$1$4$1", f = "LoveWallFlowerCardSharePageView.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallFlowerCardSharePageViewKt$LoveWallFlowerCardSharePageView$1$4$1, reason: invalid class name */
                        /* loaded from: classes37.dex */
                        public final class AnonymousClass1 extends SuspendLambda implements Function2<com.tencent.kuikly.core.coroutines.b, Continuation<? super Unit>, Object> {
                            public final /* synthetic */ ShareItem $item;
                            public final /* synthetic */ MutableState<aa<v>> $screenShotRef$delegate;
                            public final /* synthetic */ MutableState<ImageSharePanelViewModel> $sharePanelViewModel;
                            public final /* synthetic */ LoveWallFlowerCardShareViewModel $viewModel;
                            public int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            public AnonymousClass1(LoveWallFlowerCardShareViewModel loveWallFlowerCardShareViewModel, MutableState<ImageSharePanelViewModel> mutableState, ShareItem shareItem, MutableState<aa<v>> mutableState2, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$viewModel = loveWallFlowerCardShareViewModel;
                                this.$sharePanelViewModel = mutableState;
                                this.$item = shareItem;
                                this.$screenShotRef$delegate = mutableState2;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.$viewModel, this.$sharePanelViewModel, this.$item, this.$screenShotRef$delegate, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(com.tencent.kuikly.core.coroutines.b bVar, Continuation<? super Unit> continuation) {
                                return ((AnonymousClass1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                Object coroutine_suspended;
                                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i3 = this.label;
                                if (i3 == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    LoveWallFlowerCardShareViewModel loveWallFlowerCardShareViewModel = this.$viewModel;
                                    aa<v> value = this.$screenShotRef$delegate.getValue();
                                    int nativeRef = value != null ? value.getNativeRef() : 0;
                                    ImageSharePanelViewModel value2 = this.$sharePanelViewModel.getValue();
                                    ShareItem shareItem = this.$item;
                                    this.label = 1;
                                    if (loveWallFlowerCardShareViewModel.share(nativeRef, value2, shareItem, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else if (i3 == 1) {
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                return Unit.INSTANCE;
                            }
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ShareItem shareItem) {
                            BuildersKt.e(com.tencent.kuikly.core.coroutines.e.f117232d, null, null, new AnonymousClass1(LoveWallFlowerCardShareViewModel.this, mutableState2, shareItem, mutableState3, null), 3, null);
                            return Unit.INSTANCE;
                        }
                    };
                    final LoveWallFlowerCardShareViewModel loveWallFlowerCardShareViewModel3 = this.$viewModel;
                    ImageSharePanelViewKt.ImageSharePanelView(imageSharePanelViewModel, panelConfig, null, null, function02, function03, (Function0) rememberedValue6, function1, ComposableLambdaKt.composableLambda(composer3, 1944264358, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallFlowerCardSharePageViewKt$LoveWallFlowerCardSharePageView$1.5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Unit invoke(Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 11) == 2 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1944264358, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallFlowerCardSharePageView.<anonymous>.<anonymous> (LoveWallFlowerCardSharePageView.kt:83)");
                                }
                                float f16 = (com.tencent.ntcompose.activity.b.a().getPageData().getIsIphoneX() ? 34.0f : 0.0f) + 266.0f;
                                if (mutableState.getValue().booleanValue()) {
                                    final float l3 = (com.tencent.ntcompose.activity.b.a().getPageData().l() - f16) - com.tencent.ntcompose.activity.b.a().getPageData().getStatusBarHeight();
                                    i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), l3);
                                    final MutableState<aa<v>> mutableState4 = mutableState3;
                                    final LoveWallFlowerCardShareViewModel loveWallFlowerCardShareViewModel4 = loveWallFlowerCardShareViewModel3;
                                    BoxKt.a(k3, null, null, ComposableLambdaKt.composableLambda(composer5, -358808953, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallFlowerCardSharePageViewKt.LoveWallFlowerCardSharePageView.1.5.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(b bVar2, Composer composer6, Integer num3) {
                                            int i17;
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
                                                    ComposerKt.traceEventStart(-358808953, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallFlowerCardSharePageView.<anonymous>.<anonymous>.<anonymous> (LoveWallFlowerCardSharePageView.kt:88)");
                                                }
                                                i a16 = bVar3.a(ModifiersKt.J(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(ModifiersKt.d(i.INSTANCE, h.INSTANCE.a(0.0f)), 240.0f), 480.0f), (l3 - 56.0f) / 480.0f, null, 2, null), Alignment.Center);
                                                final MutableState<aa<v>> mutableState5 = mutableState4;
                                                composer7.startReplaceableGroup(1157296644);
                                                boolean changed4 = composer7.changed(mutableState5);
                                                Object rememberedValue7 = composer7.rememberedValue();
                                                if (changed4 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue7 = new Function2<v, aa<v>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallFlowerCardSharePageViewKt$LoveWallFlowerCardSharePageView$1$5$1$1$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(2);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        public final Unit invoke(v vVar, aa<v> aaVar) {
                                                            mutableState5.setValue(aaVar);
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    composer7.updateRememberedValue(rememberedValue7);
                                                }
                                                composer7.endReplaceableGroup();
                                                LoveWallFlowerCardSharePageViewKt.FlowerCardShareContentView(a16, (Function2) rememberedValue7, 380.0f, loveWallFlowerCardShareViewModel4, composer7, 4488, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer5, 3080, 6);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 100663368, 12);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallFlowerCardSharePageViewKt$LoveWallFlowerCardSharePageView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallFlowerCardSharePageViewKt.LoveWallFlowerCardSharePageView(LoveWallFlowerCardShareViewModel.this, function0, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }
}
