package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
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
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import yo3.Offset;

/* loaded from: classes31.dex */
public final class PopDownMenuKt {
    public static final void PopDownMenu(final Offset offset, final List<PopDownMenuItemData> list, final Function1<? super ClickParams, Unit> function1, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(1831370762);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1831370762, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenu (PopDownMenu.kt:33)");
        }
        final float size = (list.size() * 52.0f) + 16.0f;
        BoxKt.a(ViewEventPropUpdaterKt.d(ModifiersKt.c(ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.0f, 1, null), h.INSTANCE.j()), false, null, function1, 3, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1784884676, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuKt$PopDownMenu$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        ComposerKt.traceEventStart(1784884676, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenu.<anonymous> (PopDownMenu.kt:47)");
                    }
                    h color$default = QUIToken.color$default("bg_top_light");
                    int a16 = com.tencent.ntcompose.material.h.INSTANCE.a();
                    i.Companion companion = i.INSTANCE;
                    ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.o(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 15.0f), 7.0f), Offset.this.getX() + 9.0f, Offset.this.getY() + 38.0f), null, a16, null, null, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAC0AAAAeCAYAAAC49JeZAAAACXBIWXMAACE4AAAhOAFFljFgAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAENSURBVHgB7dfRDYIwGATgqxM4QkfQCdQNHMENdANH0A0cxRF0A3AC3eD8GyABRQpS2j70S/6QwEPPyhEAkiRJ/qEwAZJaDmZypVSOmJmwMlc2XcofEZ8ycMZ2N5k5YtMRuHJCTEwg9nNADCTIkcOsEZIEWHC4jKGKye7i2fgvpllwRODKBT6xf/Fs/BSTw4tns8aUZIEt3XtyqmJyXPFsMrouJt0Uz8ZtMVm89PhwhAt0XzybLcbgNMWzsRZTdQTWcrjJhHilzGWW8gHxars4aztZBr4iTGBDm/X544nytdO1wBrh5TKbz0+2xk5L4D2KW0IjDhrFju/qJ1X5F5iLprUrxOshc5ZdvyPx5A15yLtZgVLiywAAAABJRU5ErkJggg==", null, null, null, null, null, null, null, null, color$default, null, composer3, 12845056, 1073741830, 0, 1571679);
                    i d16 = ModifiersKt.d(ModifiersKt.j(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.o(companion, Offset.this.getX() - 99.0f, Offset.this.getY() + 44.0f), 131.0f), size), 4.0f), QUIToken.color$default("bg_top_light"));
                    final List<PopDownMenuItemData> list2 = list;
                    BoxKt.a(d16, null, null, ComposableLambdaKt.composableLambda(composer3, 951510526, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuKt$PopDownMenu$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar2, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(951510526, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenu.<anonymous>.<anonymous> (PopDownMenu.kt:62)");
                                }
                                final List<PopDownMenuItemData> list3 = list2;
                                ColumnKt.a(null, null, null, null, ComposableLambdaKt.composableLambda(composer5, 1505936807, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuKt.PopDownMenu.1.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                                ComposerKt.traceEventStart(1505936807, intValue3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenu.<anonymous>.<anonymous>.<anonymous> (PopDownMenu.kt:63)");
                                            }
                                            SpacerKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 1.0f), 8.0f), composer7, 8, 0);
                                            composer7.startReplaceableGroup(-583745395);
                                            for (PopDownMenuItemData popDownMenuItemData : list3) {
                                                PopDownMenuKt.popMenuItem(popDownMenuItemData.itemIcon, popDownMenuItemData.iconSize, popDownMenuItemData.itemName, popDownMenuItemData.textSize, popDownMenuItemData.clickEvent, popDownMenuItemData.enableClick, composer7, 0, 0);
                                            }
                                            composer7.endReplaceableGroup();
                                            SpacerKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 1.0f), 8.0f), composer7, 8, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 24576, 15);
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
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuKt$PopDownMenu$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                PopDownMenuKt.PopDownMenu(Offset.this, list, function1, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void popMenuItem(final String str, final float f16, final String str2, final float f17, final Function1<? super ClickParams, Unit> function1, boolean z16, Composer composer, final int i3, final int i16) {
        int i17;
        int i18;
        boolean z17;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(691967208);
        if ((i16 & 1) != 0) {
            i17 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i17 = (startRestartGroup.changed(str) ? 4 : 2) | i3;
        } else {
            i17 = i3;
        }
        if ((i16 & 2) != 0) {
            i17 |= 48;
        } else if ((i3 & 112) == 0) {
            i17 |= startRestartGroup.changed(f16) ? 32 : 16;
            if ((i16 & 4) == 0) {
                i17 |= MsgConstant.KRMFILETHUMBSIZE384;
            } else if ((i3 & 896) == 0) {
                i17 |= startRestartGroup.changed(str2) ? 256 : 128;
                if ((i16 & 8) != 0) {
                    i17 |= 3072;
                } else if ((i3 & 7168) == 0) {
                    i17 |= startRestartGroup.changed(f17) ? 2048 : 1024;
                    if ((i16 & 16) == 0) {
                        i17 |= 24576;
                    } else if ((57344 & i3) == 0) {
                        i17 |= startRestartGroup.changed(function1) ? 16384 : 8192;
                    }
                    i18 = i16 & 32;
                    if (i18 == 0) {
                        i17 |= 196608;
                    } else if ((458752 & i3) == 0) {
                        z17 = z16;
                        i17 |= startRestartGroup.changed(z17) ? 131072 : 65536;
                        if ((374491 & i17) != 74898 && startRestartGroup.getSkipping()) {
                            startRestartGroup.skipToGroupEnd();
                        } else {
                            boolean z18 = i18 != 0 ? true : z17;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(691967208, i17, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.popMenuItem (PopDownMenu.kt:78)");
                            }
                            final int i19 = i17;
                            BoxKt.a(ModifiersKt.b(ViewEventPropUpdaterKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 131.0f), 52.0f), false, null, function1, 3, null), z18 ? 1.0f : 0.3f), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1953309918, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuKt$popMenuItem$1
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
                                            ComposerKt.traceEventStart(-1953309918, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.popMenuItem.<anonymous> (PopDownMenu.kt:94)");
                                        }
                                        i a16 = bVar2.a(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), Alignment.BottomStart);
                                        a.d g16 = a.f339245a.g();
                                        Alignment.Vertical c16 = Alignment.INSTANCE.c();
                                        final float f18 = f16;
                                        final String str3 = str;
                                        final int i27 = i19;
                                        final String str4 = str2;
                                        final float f19 = f17;
                                        RowKt.a(a16, g16, c16, null, null, ComposableLambdaKt.composableLambda(composer3, -500771520, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuKt$popMenuItem$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                                        ComposerKt.traceEventStart(-500771520, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.popMenuItem.<anonymous>.<anonymous> (PopDownMenu.kt:99)");
                                                    }
                                                    i.Companion companion = i.INSTANCE;
                                                    ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.u(companion, f18), 20.0f, 14.0f, 0.0f, 14.0f, 4, null), null, com.tencent.ntcompose.material.h.INSTANCE.a(), null, null, str3, null, null, null, null, null, null, null, null, QUIToken.color$default("icon_primary"), null, composer5, 12845056, (i27 & 14) | 1073741824, 0, 1571679);
                                                    h color$default = QUIToken.color$default("text_primary");
                                                    c e16 = c.INSTANCE.e();
                                                    i r16 = ComposeLayoutPropUpdaterKt.r(companion, 16.0f, 16.0f, 20.0f, 16.0f);
                                                    String str5 = str4;
                                                    Float valueOf = Float.valueOf(f19);
                                                    Float valueOf2 = Float.valueOf(24.0f);
                                                    int i28 = i27;
                                                    TextKt.a(str5, r16, null, color$default, valueOf, null, e16, null, null, null, null, valueOf2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, ((i28 >> 6) & 14) | 1577024 | ((i28 << 3) & 57344), 48, 0, 134215588);
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
                                    return Unit.INSTANCE;
                                }
                            }), startRestartGroup, 3080, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z17 = z18;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                            return;
                        }
                        final boolean z19 = z17;
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuKt$popMenuItem$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(Composer composer2, Integer num) {
                                num.intValue();
                                PopDownMenuKt.popMenuItem(str, f16, str2, f17, function1, z19, composer2, i3 | 1, i16);
                                return Unit.INSTANCE;
                            }
                        });
                        return;
                    }
                    z17 = z16;
                    if ((374491 & i17) != 74898) {
                    }
                    if (i18 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final int i192 = i17;
                    BoxKt.a(ModifiersKt.b(ViewEventPropUpdaterKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 131.0f), 52.0f), false, null, function1, 3, null), z18 ? 1.0f : 0.3f), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1953309918, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuKt$popMenuItem$1
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
                                    ComposerKt.traceEventStart(-1953309918, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.popMenuItem.<anonymous> (PopDownMenu.kt:94)");
                                }
                                i a16 = bVar2.a(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), Alignment.BottomStart);
                                a.d g16 = a.f339245a.g();
                                Alignment.Vertical c16 = Alignment.INSTANCE.c();
                                final float f18 = f16;
                                final String str3 = str;
                                final int i27 = i192;
                                final String str4 = str2;
                                final float f19 = f17;
                                RowKt.a(a16, g16, c16, null, null, ComposableLambdaKt.composableLambda(composer3, -500771520, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuKt$popMenuItem$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                                ComposerKt.traceEventStart(-500771520, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.popMenuItem.<anonymous>.<anonymous> (PopDownMenu.kt:99)");
                                            }
                                            i.Companion companion = i.INSTANCE;
                                            ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.u(companion, f18), 20.0f, 14.0f, 0.0f, 14.0f, 4, null), null, com.tencent.ntcompose.material.h.INSTANCE.a(), null, null, str3, null, null, null, null, null, null, null, null, QUIToken.color$default("icon_primary"), null, composer5, 12845056, (i27 & 14) | 1073741824, 0, 1571679);
                                            h color$default = QUIToken.color$default("text_primary");
                                            c e16 = c.INSTANCE.e();
                                            i r16 = ComposeLayoutPropUpdaterKt.r(companion, 16.0f, 16.0f, 20.0f, 16.0f);
                                            String str5 = str4;
                                            Float valueOf = Float.valueOf(f19);
                                            Float valueOf2 = Float.valueOf(24.0f);
                                            int i28 = i27;
                                            TextKt.a(str5, r16, null, color$default, valueOf, null, e16, null, null, null, null, valueOf2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, ((i28 >> 6) & 14) | 1577024 | ((i28 << 3) & 57344), 48, 0, 134215588);
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
                            return Unit.INSTANCE;
                        }
                    }), startRestartGroup, 3080, 6);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    z17 = z18;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                if ((i16 & 16) == 0) {
                }
                i18 = i16 & 32;
                if (i18 == 0) {
                }
                z17 = z16;
                if ((374491 & i17) != 74898) {
                }
                if (i18 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                final int i1922 = i17;
                BoxKt.a(ModifiersKt.b(ViewEventPropUpdaterKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 131.0f), 52.0f), false, null, function1, 3, null), z18 ? 1.0f : 0.3f), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1953309918, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuKt$popMenuItem$1
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
                                ComposerKt.traceEventStart(-1953309918, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.popMenuItem.<anonymous> (PopDownMenu.kt:94)");
                            }
                            i a16 = bVar2.a(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), Alignment.BottomStart);
                            a.d g16 = a.f339245a.g();
                            Alignment.Vertical c16 = Alignment.INSTANCE.c();
                            final float f18 = f16;
                            final String str3 = str;
                            final int i27 = i1922;
                            final String str4 = str2;
                            final float f19 = f17;
                            RowKt.a(a16, g16, c16, null, null, ComposableLambdaKt.composableLambda(composer3, -500771520, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuKt$popMenuItem$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                            ComposerKt.traceEventStart(-500771520, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.popMenuItem.<anonymous>.<anonymous> (PopDownMenu.kt:99)");
                                        }
                                        i.Companion companion = i.INSTANCE;
                                        ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.u(companion, f18), 20.0f, 14.0f, 0.0f, 14.0f, 4, null), null, com.tencent.ntcompose.material.h.INSTANCE.a(), null, null, str3, null, null, null, null, null, null, null, null, QUIToken.color$default("icon_primary"), null, composer5, 12845056, (i27 & 14) | 1073741824, 0, 1571679);
                                        h color$default = QUIToken.color$default("text_primary");
                                        c e16 = c.INSTANCE.e();
                                        i r16 = ComposeLayoutPropUpdaterKt.r(companion, 16.0f, 16.0f, 20.0f, 16.0f);
                                        String str5 = str4;
                                        Float valueOf = Float.valueOf(f19);
                                        Float valueOf2 = Float.valueOf(24.0f);
                                        int i28 = i27;
                                        TextKt.a(str5, r16, null, color$default, valueOf, null, e16, null, null, null, null, valueOf2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, ((i28 >> 6) & 14) | 1577024 | ((i28 << 3) & 57344), 48, 0, 134215588);
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
                        return Unit.INSTANCE;
                    }
                }), startRestartGroup, 3080, 6);
                if (ComposerKt.isTraceInProgress()) {
                }
                z17 = z18;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            if ((i16 & 8) != 0) {
            }
            if ((i16 & 16) == 0) {
            }
            i18 = i16 & 32;
            if (i18 == 0) {
            }
            z17 = z16;
            if ((374491 & i17) != 74898) {
            }
            if (i18 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            final int i19222 = i17;
            BoxKt.a(ModifiersKt.b(ViewEventPropUpdaterKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 131.0f), 52.0f), false, null, function1, 3, null), z18 ? 1.0f : 0.3f), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1953309918, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuKt$popMenuItem$1
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
                            ComposerKt.traceEventStart(-1953309918, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.popMenuItem.<anonymous> (PopDownMenu.kt:94)");
                        }
                        i a16 = bVar2.a(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), Alignment.BottomStart);
                        a.d g16 = a.f339245a.g();
                        Alignment.Vertical c16 = Alignment.INSTANCE.c();
                        final float f18 = f16;
                        final String str3 = str;
                        final int i27 = i19222;
                        final String str4 = str2;
                        final float f19 = f17;
                        RowKt.a(a16, g16, c16, null, null, ComposableLambdaKt.composableLambda(composer3, -500771520, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuKt$popMenuItem$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                        ComposerKt.traceEventStart(-500771520, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.popMenuItem.<anonymous>.<anonymous> (PopDownMenu.kt:99)");
                                    }
                                    i.Companion companion = i.INSTANCE;
                                    ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.u(companion, f18), 20.0f, 14.0f, 0.0f, 14.0f, 4, null), null, com.tencent.ntcompose.material.h.INSTANCE.a(), null, null, str3, null, null, null, null, null, null, null, null, QUIToken.color$default("icon_primary"), null, composer5, 12845056, (i27 & 14) | 1073741824, 0, 1571679);
                                    h color$default = QUIToken.color$default("text_primary");
                                    c e16 = c.INSTANCE.e();
                                    i r16 = ComposeLayoutPropUpdaterKt.r(companion, 16.0f, 16.0f, 20.0f, 16.0f);
                                    String str5 = str4;
                                    Float valueOf = Float.valueOf(f19);
                                    Float valueOf2 = Float.valueOf(24.0f);
                                    int i28 = i27;
                                    TextKt.a(str5, r16, null, color$default, valueOf, null, e16, null, null, null, null, valueOf2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, ((i28 >> 6) & 14) | 1577024 | ((i28 << 3) & 57344), 48, 0, 134215588);
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
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 3080, 6);
            if (ComposerKt.isTraceInProgress()) {
            }
            z17 = z18;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        if ((i16 & 4) == 0) {
        }
        if ((i16 & 8) != 0) {
        }
        if ((i16 & 16) == 0) {
        }
        i18 = i16 & 32;
        if (i18 == 0) {
        }
        z17 = z16;
        if ((374491 & i17) != 74898) {
        }
        if (i18 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        final int i192222 = i17;
        BoxKt.a(ModifiersKt.b(ViewEventPropUpdaterKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 131.0f), 52.0f), false, null, function1, 3, null), z18 ? 1.0f : 0.3f), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1953309918, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuKt$popMenuItem$1
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
                        ComposerKt.traceEventStart(-1953309918, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.popMenuItem.<anonymous> (PopDownMenu.kt:94)");
                    }
                    i a16 = bVar2.a(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), Alignment.BottomStart);
                    a.d g16 = a.f339245a.g();
                    Alignment.Vertical c16 = Alignment.INSTANCE.c();
                    final float f18 = f16;
                    final String str3 = str;
                    final int i27 = i192222;
                    final String str4 = str2;
                    final float f19 = f17;
                    RowKt.a(a16, g16, c16, null, null, ComposableLambdaKt.composableLambda(composer3, -500771520, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuKt$popMenuItem$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                    ComposerKt.traceEventStart(-500771520, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.popMenuItem.<anonymous>.<anonymous> (PopDownMenu.kt:99)");
                                }
                                i.Companion companion = i.INSTANCE;
                                ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.u(companion, f18), 20.0f, 14.0f, 0.0f, 14.0f, 4, null), null, com.tencent.ntcompose.material.h.INSTANCE.a(), null, null, str3, null, null, null, null, null, null, null, null, QUIToken.color$default("icon_primary"), null, composer5, 12845056, (i27 & 14) | 1073741824, 0, 1571679);
                                h color$default = QUIToken.color$default("text_primary");
                                c e16 = c.INSTANCE.e();
                                i r16 = ComposeLayoutPropUpdaterKt.r(companion, 16.0f, 16.0f, 20.0f, 16.0f);
                                String str5 = str4;
                                Float valueOf = Float.valueOf(f19);
                                Float valueOf2 = Float.valueOf(24.0f);
                                int i28 = i27;
                                TextKt.a(str5, r16, null, color$default, valueOf, null, e16, null, null, null, null, valueOf2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, ((i28 >> 6) & 14) | 1577024 | ((i28 << 3) & 57344), 48, 0, 134215588);
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
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 3080, 6);
        if (ComposerKt.isTraceInProgress()) {
        }
        z17 = z18;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
