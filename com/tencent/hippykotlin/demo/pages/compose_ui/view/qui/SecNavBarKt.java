package com.tencent.hippykotlin.demo.pages.compose_ui.view.qui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import bp3.k;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class SecNavBarKt {
    public static final int CENTER_TEXT_ALIGN;
    public static final c CENTER_TEXT_WEIGHT;
    public static final int LR_TEXT_ALIGN;
    public static final c LR_TEXT_WEIGHT;

    static {
        c.Companion companion = c.INSTANCE;
        LR_TEXT_WEIGHT = companion.e();
        ai.Companion companion2 = ai.INSTANCE;
        LR_TEXT_ALIGN = companion2.d();
        CENTER_TEXT_WEIGHT = companion.f();
        CENTER_TEXT_ALIGN = companion2.a();
    }

    public static final void RightContent(final RightContentConfig rightContentConfig, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-487794602);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-487794602, i3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.RightContent (SecNavBar.kt:142)");
        }
        if (rightContentConfig == null) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                return;
            }
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.SecNavBarKt$RightContent$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    SecNavBarKt.RightContent(RightContentConfig.this, composer2, i3 | 1);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        final int i16 = 4;
        int ordinal = BoxType$EnumUnboxingSharedUtility.ordinal(4);
        if (ordinal == 0) {
            startRestartGroup.startReplaceableGroup(1715914258);
            startRestartGroup.endReplaceableGroup();
        } else if (ordinal == 1 || ordinal == 2 || ordinal == 3) {
            startRestartGroup.startReplaceableGroup(1715914449);
            final List<RightContentData> list = rightContentConfig.rightContentList;
            if (list == null) {
                startRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
                if (endRestartGroup2 == null) {
                    return;
                }
                endRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.SecNavBarKt$RightContent$list$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Composer composer2, Integer num) {
                        num.intValue();
                        SecNavBarKt.RightContent(RightContentConfig.this, composer2, i3 | 1);
                        return Unit.INSTANCE;
                    }
                });
                return;
            }
            RowKt.a(ComposeLayoutPropUpdaterKt.n(i.INSTANCE, 0.0f, 0.0f, 16.0f, 0.0f, 11, null), null, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1524397167, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.SecNavBarKt$RightContent$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Incorrect types in method signature: (Ljava/util/List<Lcom/tencent/hippykotlin/demo/pages/compose_ui/view/qui/RightContentData;>;Ljava/lang/Object;)V */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(n nVar, Composer composer2, Integer num) {
                    int i17;
                    int i18;
                    List<RightContentData> list2;
                    Composer composer3;
                    Composer composer4;
                    Composer composer5 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 81) == 16 && composer5.getSkipping()) {
                        composer5.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1524397167, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.RightContent.<anonymous> (SecNavBar.kt:154)");
                        }
                        List<RightContentData> list3 = list;
                        int i19 = i16;
                        int i26 = 0;
                        int i27 = 0;
                        Composer composer6 = composer5;
                        for (Object obj : list3) {
                            int i28 = i27 + 1;
                            if (i27 < 0) {
                                CollectionsKt__CollectionsKt.throwIndexOverflow();
                            }
                            final RightContentData rightContentData = (RightContentData) obj;
                            composer6.startReplaceableGroup(-1560327214);
                            if (((1 > i27 || i27 >= list3.size()) ? i26 : 1) != 0) {
                                SpacerKt.a(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, i19 == 4 ? 8.0f : 12.0f), composer6, 8, i26);
                            }
                            composer6.endReplaceableGroup();
                            int ordinal2 = BoxType$EnumUnboxingSharedUtility.ordinal(i19);
                            if (ordinal2 == 1) {
                                i17 = i26;
                                i18 = i19;
                                list2 = list3;
                                composer6.startReplaceableGroup(-638211967);
                                i.Companion companion = i.INSTANCE;
                                composer6.startReplaceableGroup(1157296644);
                                boolean changed = composer6.changed(rightContentData);
                                Object rememberedValue = composer6.rememberedValue();
                                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.SecNavBarKt$RightContent$2$1$1$1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(Object obj2) {
                                            Function0<Unit> function0 = RightContentData.this.rightClickDidAppearCallback;
                                            if (function0 != null) {
                                                function0.invoke();
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composer6.updateRememberedValue(rememberedValue);
                                }
                                composer6.endReplaceableGroup();
                                i g16 = ViewEventPropUpdaterKt.g(companion, (Function1) rememberedValue);
                                composer6.startReplaceableGroup(1157296644);
                                boolean changed2 = composer6.changed(rightContentData);
                                Object rememberedValue2 = composer6.rememberedValue();
                                if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.SecNavBarKt$RightContent$2$1$2$1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ClickParams clickParams) {
                                            Function0<Unit> function0 = RightContentData.this.rightClickCallback;
                                            if (function0 != null) {
                                                function0.invoke();
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composer6.updateRememberedValue(rememberedValue2);
                                }
                                composer6.endReplaceableGroup();
                                composer3 = composer6;
                                TextKt.a(rightContentData.rightText, ViewEventPropUpdaterKt.d(g16, false, null, (Function1) rememberedValue2, 3, null), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new k(QUIToken.color$default(rightContentData.rightTextColor), Float.valueOf(17.0f), SecNavBarKt.LR_TEXT_WEIGHT, null, null, null, null, null, ai.f(SecNavBarKt.LR_TEXT_ALIGN), Float.valueOf(24.0f), null, null, null, null, 15608, null), null, null, null, null, null, false, composer3, 64, 0, k.f28903n, 133169148);
                                composer3.endReplaceableGroup();
                            } else if (ordinal2 != 2) {
                                if (ordinal2 != 3) {
                                    composer6.startReplaceableGroup(-638208969);
                                    composer6.endReplaceableGroup();
                                } else {
                                    composer6.startReplaceableGroup(-638210194);
                                    final String str = rightContentData.rightIconUrl;
                                    if (str != null) {
                                        i q16 = ModifiersKt.q(ModifiersKt.c(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 28.0f), QUIToken.color$default("fill_allblack_weak")), uo3.c.b());
                                        composer6.startReplaceableGroup(1157296644);
                                        boolean changed3 = composer6.changed(rightContentData);
                                        Object rememberedValue3 = composer6.rememberedValue();
                                        if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue3 = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.SecNavBarKt$RightContent$2$1$4$1$1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(Object obj2) {
                                                    Function0<Unit> function0 = RightContentData.this.rightClickDidAppearCallback;
                                                    if (function0 != null) {
                                                        function0.invoke();
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            composer6.updateRememberedValue(rememberedValue3);
                                        }
                                        composer6.endReplaceableGroup();
                                        i g17 = ViewEventPropUpdaterKt.g(q16, (Function1) rememberedValue3);
                                        composer6.startReplaceableGroup(1157296644);
                                        boolean changed4 = composer6.changed(rightContentData);
                                        Object rememberedValue4 = composer6.rememberedValue();
                                        if (changed4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue4 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.SecNavBarKt$RightContent$2$1$4$2$1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    Function0<Unit> function0 = RightContentData.this.rightClickCallback;
                                                    if (function0 != null) {
                                                        function0.invoke();
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            composer6.updateRememberedValue(rememberedValue4);
                                        }
                                        composer6.endReplaceableGroup();
                                        BoxKt.a(ViewEventPropUpdaterKt.d(g17, false, null, (Function1) rememberedValue4, 3, null), Alignment.Center, null, ComposableLambdaKt.composableLambda(composer6, -1873045989, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.SecNavBarKt$RightContent$2$1$4$3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(b bVar, Composer composer7, Integer num2) {
                                                Composer composer8 = composer7;
                                                int intValue2 = num2.intValue();
                                                if ((intValue2 & 81) == 16 && composer8.getSkipping()) {
                                                    composer8.skipToGroupEnd();
                                                } else {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1873045989, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.RightContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SecNavBar.kt:216)");
                                                    }
                                                    ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 20.0f), null, 0, null, null, QUIToken.INSTANCE.image(str, QUIToken.color$default(rightContentData.rightIconCircleColor)), null, null, null, null, null, null, null, null, null, null, composer8, 262144, 0, 0, 2096095);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), composer6, 3128, 4);
                                    }
                                    composer6.endReplaceableGroup();
                                }
                                i17 = i26;
                                i18 = i19;
                                list2 = list3;
                                composer3 = composer6;
                            } else {
                                composer6.startReplaceableGroup(-638210961);
                                String str2 = rightContentData.rightIconUrl;
                                if (str2 == null) {
                                    i17 = i26;
                                    i18 = i19;
                                    list2 = list3;
                                    composer4 = composer6;
                                } else {
                                    i u16 = ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f);
                                    composer6.startReplaceableGroup(1157296644);
                                    boolean changed5 = composer6.changed(rightContentData);
                                    Object rememberedValue5 = composer6.rememberedValue();
                                    if (changed5 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue5 = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.SecNavBarKt$RightContent$2$1$3$1$1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj2) {
                                                Function0<Unit> function0 = RightContentData.this.rightClickDidAppearCallback;
                                                if (function0 != null) {
                                                    function0.invoke();
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        composer6.updateRememberedValue(rememberedValue5);
                                    }
                                    composer6.endReplaceableGroup();
                                    i g18 = ViewEventPropUpdaterKt.g(u16, (Function1) rememberedValue5);
                                    composer6.startReplaceableGroup(1157296644);
                                    boolean changed6 = composer6.changed(rightContentData);
                                    Object rememberedValue6 = composer6.rememberedValue();
                                    if (changed6 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue6 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.SecNavBarKt$RightContent$2$1$3$2$1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                Function0<Unit> function0 = RightContentData.this.rightClickCallback;
                                                if (function0 != null) {
                                                    function0.invoke();
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        composer6.updateRememberedValue(rememberedValue6);
                                    }
                                    composer6.endReplaceableGroup();
                                    i17 = i26;
                                    i18 = i19;
                                    list2 = list3;
                                    composer4 = composer6;
                                    ImageKt.a(null, null, null, null, null, ViewEventPropUpdaterKt.d(g18, false, null, (Function1) rememberedValue6, 3, null), null, 0, null, null, QUIToken.INSTANCE.image(str2, QUIToken.color$default(rightContentData.rightIconColor)), null, null, null, null, null, null, null, null, null, null, composer4, 262144, 0, 0, 2096095);
                                }
                                composer4.endReplaceableGroup();
                                composer3 = composer4;
                            }
                            i27 = i28;
                            i26 = i17;
                            i19 = i18;
                            list3 = list2;
                            composer6 = composer3;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 196616, 30);
            startRestartGroup.endReplaceableGroup();
        } else if (ordinal != 4) {
            startRestartGroup.startReplaceableGroup(1715918269);
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.startReplaceableGroup(1715914296);
            startRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup3 = startRestartGroup.endRestartGroup();
        if (endRestartGroup3 == null) {
            return;
        }
        endRestartGroup3.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.SecNavBarKt$RightContent$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                SecNavBarKt.RightContent(RightContentConfig.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void SecNavBar(h hVar, final LeftContentConfig leftContentConfig, final CenterContentConfig centerContentConfig, final RightContentConfig rightContentConfig, Composer composer, final int i3, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(234194261);
        int i17 = i16 & 1;
        final int i18 = i17 != 0 ? i3 | 2 : i3;
        if ((i16 & 2) != 0) {
            i18 |= 48;
        } else if ((i3 & 112) == 0) {
            i18 |= startRestartGroup.changed(leftContentConfig) ? 32 : 16;
        }
        if ((i16 & 4) != 0) {
            i18 |= MsgConstant.KRMFILETHUMBSIZE384;
        } else if ((i3 & 896) == 0) {
            i18 |= startRestartGroup.changed(centerContentConfig) ? 256 : 128;
        }
        int i19 = i16 & 8;
        if (i19 != 0) {
            i18 |= 1024;
        }
        if ((i16 & 9) == 9 && (i18 & 5851) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            startRestartGroup.startDefaults();
            if ((i3 & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                if (i17 != 0) {
                    hVar = h.INSTANCE.j();
                    i18 &= -15;
                }
                if (i19 != 0) {
                    rightContentConfig = null;
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                if (i17 != 0) {
                    i18 &= -15;
                }
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(234194261, i18, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.SecNavBar (SecNavBar.kt:35)");
            }
            BoxKt.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), defpackage.k.a(com.tencent.kuikly.core.manager.c.f117352a) ? 50.0f : 44.0f), hVar), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -624464881, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.SecNavBarKt$SecNavBar$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(b bVar, Composer composer2, Integer num) {
                    int i26;
                    b bVar2 = bVar;
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 14) == 0) {
                        i26 = (composer3.changed(bVar2) ? 4 : 2) | intValue;
                    } else {
                        i26 = intValue;
                    }
                    if ((i26 & 91) == 18 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-624464881, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.SecNavBar.<anonymous> (SecNavBar.kt:46)");
                        }
                        i.Companion companion = i.INSTANCE;
                        i a16 = bVar2.a(companion, Alignment.CenterStart);
                        final LeftContentConfig leftContentConfig2 = LeftContentConfig.this;
                        composer3.startReplaceableGroup(1157296644);
                        boolean changed = composer3.changed(leftContentConfig2);
                        Object rememberedValue = composer3.rememberedValue();
                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.SecNavBarKt$SecNavBar$1$1$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(Object obj) {
                                    Function0<Unit> function0 = LeftContentConfig.this.leftClickDidAppearCallback;
                                    if (function0 != null) {
                                        function0.invoke();
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue);
                        }
                        composer3.endReplaceableGroup();
                        i g16 = ViewEventPropUpdaterKt.g(a16, (Function1) rememberedValue);
                        final LeftContentConfig leftContentConfig3 = LeftContentConfig.this;
                        composer3.startReplaceableGroup(1157296644);
                        boolean changed2 = composer3.changed(leftContentConfig3);
                        Object rememberedValue2 = composer3.rememberedValue();
                        if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.SecNavBarKt$SecNavBar$1$2$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ClickParams clickParams) {
                                    Function0<Unit> function0 = LeftContentConfig.this.leftClickCallback;
                                    if (function0 != null) {
                                        function0.invoke();
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue2);
                        }
                        composer3.endReplaceableGroup();
                        i d16 = ViewEventPropUpdaterKt.d(g16, false, null, (Function1) rememberedValue2, 3, null);
                        final LeftContentConfig leftContentConfig4 = LeftContentConfig.this;
                        final int i27 = i18;
                        BoxKt.a(d16, null, null, ComposableLambdaKt.composableLambda(composer3, -84501175, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.SecNavBarKt$SecNavBar$1.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(b bVar3, Composer composer4, Integer num2) {
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-84501175, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.SecNavBar.<anonymous>.<anonymous> (SecNavBar.kt:55)");
                                    }
                                    SecNavBarKt.LeftContent(LeftContentConfig.this, composer5, (i27 >> 3) & 14);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 3080, 6);
                        i a17 = bVar2.a(companion, Alignment.Center);
                        final CenterContentConfig centerContentConfig2 = centerContentConfig;
                        final int i28 = i18;
                        BoxKt.a(a17, null, null, ComposableLambdaKt.composableLambda(composer3, -1466746702, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.SecNavBarKt$SecNavBar$1.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(b bVar3, Composer composer4, Integer num2) {
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1466746702, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.SecNavBar.<anonymous>.<anonymous> (SecNavBar.kt:59)");
                                    }
                                    SecNavBarKt.CenterContent(CenterContentConfig.this, composer5, (i28 >> 6) & 14);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 3080, 6);
                        i a18 = bVar2.a(companion, Alignment.CenterEnd);
                        final RightContentConfig rightContentConfig2 = rightContentConfig;
                        BoxKt.a(a18, null, null, ComposableLambdaKt.composableLambda(composer3, -1894016431, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.SecNavBarKt$SecNavBar$1.5
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(b bVar3, Composer composer4, Integer num2) {
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1894016431, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.SecNavBar.<anonymous>.<anonymous> (SecNavBar.kt:63)");
                                    }
                                    SecNavBarKt.RightContent(RightContentConfig.this, composer5, 8);
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
            }), startRestartGroup, 3080, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final h hVar2 = hVar;
        final RightContentConfig rightContentConfig2 = rightContentConfig;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.SecNavBarKt$SecNavBar$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                SecNavBarKt.SecNavBar(h.this, leftContentConfig, centerContentConfig, rightContentConfig2, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void CenterContent(final CenterContentConfig centerContentConfig, Composer composer, final int i3) {
        int i16;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1060298478);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(centerContentConfig) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i16 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1060298478, i3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.CenterContent (SecNavBar.kt:119)");
            }
            int ordinal = BoxType$EnumUnboxingSharedUtility.ordinal(centerContentConfig.centerContentType);
            if (ordinal == 0) {
                composer2 = startRestartGroup;
                composer2.startReplaceableGroup(-702541863);
                composer2.endReplaceableGroup();
            } else if (ordinal != 1) {
                if (ordinal != 2) {
                    startRestartGroup.startReplaceableGroup(-702541272);
                    startRestartGroup.endReplaceableGroup();
                } else {
                    startRestartGroup.startReplaceableGroup(-702541345);
                    Function2<Composer, Integer, Unit> function2 = centerContentConfig.centerContent;
                    if (function2 != null) {
                        function2.invoke(startRestartGroup, 0);
                    }
                    startRestartGroup.endReplaceableGroup();
                }
                composer2 = startRestartGroup;
            } else {
                startRestartGroup.startReplaceableGroup(-702541826);
                TextKt.a(centerContentConfig.centerText, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new k(QUIToken.color$default(centerContentConfig.centerTextColor), Float.valueOf(17.0f), CENTER_TEXT_WEIGHT, null, null, null, null, null, ai.f(CENTER_TEXT_ALIGN), Float.valueOf(24.0f), null, null, null, null, 15608, null), null, null, null, null, null, false, startRestartGroup, 0, 0, k.f28903n, 133169150);
                startRestartGroup.endReplaceableGroup();
                composer2 = startRestartGroup;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.SecNavBarKt$CenterContent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer3, Integer num) {
                num.intValue();
                SecNavBarKt.CenterContent(CenterContentConfig.this, composer3, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void LeftContent(final LeftContentConfig leftContentConfig, Composer composer, final int i3) {
        int i16;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-134072822);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(leftContentConfig) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i16 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-134072822, i3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.LeftContent (SecNavBar.kt:70)");
            }
            int ordinal = BoxType$EnumUnboxingSharedUtility.ordinal(leftContentConfig.leftContentType);
            if (ordinal == 0) {
                startRestartGroup.startReplaceableGroup(-988710219);
                composer2 = startRestartGroup;
                TextKt.a(leftContentConfig.leftText, ComposeLayoutPropUpdaterKt.n(i.INSTANCE, 16.0f, 0.0f, 0.0f, 0.0f, 14, null), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new k(QUIToken.color$default(leftContentConfig.leftTextColor), Float.valueOf(17.0f), LR_TEXT_WEIGHT, null, null, null, null, null, ai.f(LR_TEXT_ALIGN), Float.valueOf(24.0f), null, null, null, null, 15608, null), null, null, null, null, null, false, composer2, 64, 0, k.f28903n, 133169148);
                composer2.endReplaceableGroup();
            } else if (ordinal != 1) {
                if (ordinal == 2) {
                    startRestartGroup.startReplaceableGroup(-988709369);
                    BoxKt.a(ModifiersKt.q(ModifiersKt.c(ComposeLayoutPropUpdaterKt.u(ComposeLayoutPropUpdaterKt.n(i.INSTANCE, 16.0f, 0.0f, 0.0f, 0.0f, 14, null), 28.0f), QUIToken.color$default("fill_allblack_weak")), uo3.c.b()), Alignment.Center, null, ComposableLambdaKt.composableLambda(startRestartGroup, -950768944, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.SecNavBarKt$LeftContent$1
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar, Composer composer3, Integer num) {
                            Composer composer4 = composer3;
                            int intValue = num.intValue();
                            if ((intValue & 81) == 16 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-950768944, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.LeftContent.<anonymous> (SecNavBar.kt:104)");
                                }
                                ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 20.0f), null, 0, null, null, QUIToken.INSTANCE.image("chevron_left", QUIToken.color$default(LeftContentConfig.this.leftIconCircleColor)), null, null, null, null, null, null, null, null, null, null, composer4, 262144, 0, 0, 2096095);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), startRestartGroup, 3128, 4);
                    startRestartGroup.endReplaceableGroup();
                } else if (ordinal != 3) {
                    startRestartGroup.startReplaceableGroup(-988708696);
                    startRestartGroup.endReplaceableGroup();
                } else {
                    startRestartGroup.startReplaceableGroup(-988708765);
                    Function2<Composer, Integer, Unit> function2 = leftContentConfig.leftContent;
                    if (function2 != null) {
                        function2.invoke(startRestartGroup, 0);
                    }
                    startRestartGroup.endReplaceableGroup();
                }
                composer2 = startRestartGroup;
            } else {
                startRestartGroup.startReplaceableGroup(-988709682);
                ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), 10.0f, 0.0f, 0.0f, 0.0f, 14, null), null, 0, null, null, QUIToken.INSTANCE.image("chevron_left", QUIToken.color$default(leftContentConfig.leftIconColor)), null, null, null, null, null, null, null, null, null, null, startRestartGroup, 262144, 0, 0, 2096095);
                startRestartGroup.endReplaceableGroup();
                composer2 = startRestartGroup;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.SecNavBarKt$LeftContent$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer3, Integer num) {
                num.intValue();
                SecNavBarKt.LeftContent(LeftContentConfig.this, composer3, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
