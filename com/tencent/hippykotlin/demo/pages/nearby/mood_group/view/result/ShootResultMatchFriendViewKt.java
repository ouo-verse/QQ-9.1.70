package com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailViewModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.data.NBPMoodGroupConfig;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.NBPMoodGroupReportViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.result.NBPShootResultPageState;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.result.NBPShootResultViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.InputEvent;
import com.tencent.kuikly.core.views.InputParams;
import com.tencent.kuikly.core.views.InputView;
import com.tencent.kuikly.core.views.KeyboardParams;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ai;
import com.tencent.kuikly.core.views.am;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.ntcompose.animation.AnimateAsStateKt;
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
import com.tencent.ntcompose.material.ButtonKt;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.KuiklyKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;
import w25.g;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ShootResultMatchFriendViewKt {
    public static final void access$TagsDisplay(final List list, final boolean z16, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(831159627);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(831159627, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.TagsDisplay (ShootResultMatchFriendView.kt:459)");
        }
        if (list.isEmpty()) {
            startRestartGroup.startReplaceableGroup(821469828);
            BoxKt.a(ComposeLayoutPropUpdaterKt.r(ModifiersKt.c(ModifiersKt.j(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 72.0f), 18.0f), 4.0f), QUIToken.color$default("fill_standard_primary")), 3.0f, 3.0f, 3.0f, 3.0f), Alignment.Center, null, ComposableLambdaKt.composableLambda(startRestartGroup, 879848364, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt$TagsDisplay$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(b bVar, Composer composer2, Integer num) {
                    int i16;
                    String str;
                    b bVar2 = bVar;
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 14) == 0) {
                        i16 = (composer3.changed(bVar2) ? 4 : 2) | intValue;
                    } else {
                        i16 = intValue;
                    }
                    if ((i16 & 91) == 18 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(879848364, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.TagsDisplay.<anonymous> (ShootResultMatchFriendView.kt:469)");
                        }
                        if (z16) {
                            str = "\u5728\u7ebf";
                        } else {
                            str = "\u521a\u521a\u6d3b\u8dc3";
                        }
                        TextKt.a(str, bVar2.a(i.INSTANCE, Alignment.Center), null, QUIToken.color$default("text_secondary"), Float.valueOf(10.0f), null, c.INSTANCE.e(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601600, 0, 0, 134217636);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 3128, 4);
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.startReplaceableGroup(821470412);
            RowKt.a(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), a.f339245a.b(), Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1924173039, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt$TagsDisplay$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(n nVar, Composer composer2, Integer num) {
                    List<t35.a> take;
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 81) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1924173039, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.TagsDisplay.<anonymous> (ShootResultMatchFriendView.kt:485)");
                        }
                        take = CollectionsKt___CollectionsKt.take(list, 4);
                        for (final t35.a aVar : take) {
                            Alignment alignment = Alignment.Center;
                            i.Companion companion = i.INSTANCE;
                            BoxKt.a(ComposeLayoutPropUpdaterKt.n(ModifiersKt.d(ComposeLayoutPropUpdaterKt.s(ModifiersKt.j(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.B(companion), 18.0f), 4.0f), 3.0f, 0.0f, 3.0f, 0.0f, 10, null), QUIToken.color$default("fill_standard_primary")), 2.0f, 0.0f, 2.0f, 0.0f, 10, null), alignment, null, ComposableLambdaKt.composableLambda(composer3, -1948705190, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt$TagsDisplay$2$1$1
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public final Unit invoke(b bVar, Composer composer4, Integer num2) {
                                    int i16;
                                    b bVar2 = bVar;
                                    Composer composer5 = composer4;
                                    int intValue2 = num2.intValue();
                                    if ((intValue2 & 14) == 0) {
                                        i16 = (composer5.changed(bVar2) ? 4 : 2) | intValue2;
                                    } else {
                                        i16 = intValue2;
                                    }
                                    if ((i16 & 91) == 18 && composer5.getSkipping()) {
                                        composer5.skipToGroupEnd();
                                    } else {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1948705190, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.TagsDisplay.<anonymous>.<anonymous>.<anonymous> (ShootResultMatchFriendView.kt:494)");
                                        }
                                        TextKt.a(t35.a.this.f435363e, bVar2.a(i.INSTANCE, Alignment.Center), null, QUIToken.color$default("text_secondary"), Float.valueOf(10.0f), null, c.INSTANCE.e(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 1601600, 0, 0, 134217636);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }), composer3, 3128, 4);
                            SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 4.0f), composer3, 8, 0);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 196680, 24);
            startRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt$TagsDisplay$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                ShootResultMatchFriendViewKt.access$TagsDisplay(list, z16, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$UserItemView(final g gVar, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(85401488);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(85401488, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.UserItemView (ShootResultMatchFriendView.kt:510)");
        }
        ColumnKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 75.0f), 85.0f), null, Alignment.INSTANCE.b(), null, ComposableLambdaKt.composableLambda(startRestartGroup, 1223893177, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt$UserItemView$1
            {
                super(3);
            }

            /* JADX WARN: Type inference failed for: r3v18, types: [T, java.lang.String] */
            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(d dVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1223893177, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.UserItemView.<anonymous> (ShootResultMatchFriendView.kt:514)");
                    }
                    i.Companion companion = i.INSTANCE;
                    ImageKt.a(g.this.f444491h, null, null, null, null, ModifiersKt.g(ModifiersKt.j(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 68.0f), 68.0f), 34.0f), new e(1.0f, BorderStyle.SOLID, h.INSTANCE.m())), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer3, 262144, 0, 0, 2097118);
                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 16.0f), composer3, 8, 0);
                    final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    objectRef.element = "\u521a\u521a\u6d3b\u8dc3";
                    if (!g.this.D.isEmpty()) {
                        objectRef.element = g.this.D.get(0).f435363e;
                    } else if (g.this.C) {
                        objectRef.element = "\u5728\u7ebf";
                    }
                    BoxKt.a(ComposeLayoutPropUpdaterKt.r(ModifiersKt.d(ModifiersKt.j(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 72.0f), 18.0f), 4.0f), QUIToken.color$default("fill_standard_primary")), 3.0f, 6.0f, 3.0f, 6.0f), Alignment.Center, null, ComposableLambdaKt.composableLambda(composer3, 1661663603, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt$UserItemView$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar, Composer composer4, Integer num2) {
                            int i16;
                            b bVar2 = bVar;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 14) == 0) {
                                i16 = (composer5.changed(bVar2) ? 4 : 2) | intValue2;
                            } else {
                                i16 = intValue2;
                            }
                            if ((i16 & 91) == 18 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1661663603, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.UserItemView.<anonymous>.<anonymous> (ShootResultMatchFriendView.kt:536)");
                                }
                                TextKt.a(objectRef.element, bVar2.a(i.INSTANCE, Alignment.Center), null, QUIToken.color$default("text_secondary"), Float.valueOf(10.0f), null, c.INSTANCE.e(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 1601600, 0, 0, 134217636);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 3128, 4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 24584, 10);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt$UserItemView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                ShootResultMatchFriendViewKt.access$UserItemView(g.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void ShootResultMatchFriendView(final NBPShootResultViewModel nBPShootResultViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-537844868);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-537844868, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendView (ShootResultMatchFriendView.kt:65)");
        }
        BoxKt.a(ViewEventPropUpdaterKt.g(ModifiersKt.b(ModifiersKt.d(ModifiersKt.T(ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.0f, 1, null), 5), new h(0L, 0.5f)), AnimateAsStateKt.c(!nBPShootResultViewModel.fadeOutAnimation.getValue().booleanValue() ? 0.0f : 1.0f, com.tencent.ntcompose.animation.b.d(150, 0, com.tencent.ntcompose.animation.i.d(), null, 10, null), null, startRestartGroup, 0, 4).getValue().floatValue()), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt$ShootResultMatchFriendView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                NBPShootResultViewModel.this.fadeOutAnimation.setValue(Boolean.TRUE);
                NBPMoodGroupReportViewModel nBPMoodGroupReportViewModel = NBPShootResultViewModel.this.reportVM;
                com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
                NBPShootResultViewModel nBPShootResultViewModel2 = NBPShootResultViewModel.this;
                eVar.t("nearby_click_area", 0);
                eVar.v("nearby_text", nBPShootResultViewModel2.getEditedText());
                Unit unit = Unit.INSTANCE;
                nBPMoodGroupReportViewModel.dtReportElementImp("em_nearby_greet_pop", eVar);
                return Unit.INSTANCE;
            }
        }), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 633626882, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt$ShootResultMatchFriendView$2
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                int i16;
                b bVar2 = bVar;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 14) == 0) {
                    i16 = (composer3.changed(bVar2) ? 4 : 2) | intValue;
                } else {
                    i16 = intValue;
                }
                if ((i16 & 91) == 18 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(633626882, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendView.<anonymous> (ShootResultMatchFriendView.kt:85)");
                    }
                    i.Companion companion = i.INSTANCE;
                    i a16 = bVar2.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, NBPShootResultViewModel.this.topRightBackgroundImg.width), NBPShootResultViewModel.this.topRightBackgroundImg.height), Alignment.TopEnd);
                    final NBPShootResultViewModel nBPShootResultViewModel2 = NBPShootResultViewModel.this;
                    BoxKt.a(a16, null, null, ComposableLambdaKt.composableLambda(composer3, -882580472, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt$ShootResultMatchFriendView$2.1
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar3, Composer composer4, Integer num2) {
                            int i17;
                            b bVar4 = bVar3;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 14) == 0) {
                                i17 = (composer5.changed(bVar4) ? 4 : 2) | intValue2;
                            } else {
                                i17 = intValue2;
                            }
                            if ((i17 & 91) == 18 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-882580472, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendView.<anonymous>.<anonymous> (ShootResultMatchFriendView.kt:90)");
                                }
                                ImageKt.a(NBPShootResultViewModel.this.topRightBackgroundImg.url, null, null, null, null, bVar4.a(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), Alignment.TopEnd), null, com.tencent.ntcompose.material.h.INSTANCE.b(), null, null, null, null, null, null, null, null, null, null, null, null, null, composer5, 12845056, 0, 0, 2096990);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 3080, 6);
                    i n3 = ComposeLayoutPropUpdaterKt.n(ModifiersKt.j(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 296.0f), 335.0f), QUIToken.color$default("bg_top_light")), 6.0f), 0.0f, 220.0f - NBPShootResultViewModel.this.smallScreenOffsetY.getValue().floatValue(), 0.0f, 0.0f, 13, null);
                    Alignment alignment = Alignment.TopCenter;
                    i a17 = bVar2.a(n3, alignment);
                    Alignment alignment2 = Alignment.CenterStart;
                    final NBPShootResultViewModel nBPShootResultViewModel3 = NBPShootResultViewModel.this;
                    BoxKt.a(a17, alignment2, null, ComposableLambdaKt.composableLambda(composer3, 1906180671, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt$ShootResultMatchFriendView$2.2
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
                                    ComposerKt.traceEventStart(1906180671, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendView.<anonymous>.<anonymous> (ShootResultMatchFriendView.kt:107)");
                                }
                                i a18 = ComposeLayoutPropUpdaterKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 296.0f), 335.0f), 0.0f, 0.0f);
                                final NBPShootResultViewModel nBPShootResultViewModel4 = NBPShootResultViewModel.this;
                                BoxKt.a(a18, null, null, ComposableLambdaKt.composableLambda(composer5, -1102700219, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt.ShootResultMatchFriendView.2.2.1
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(b bVar4, Composer composer6, Integer num3) {
                                        NBPMoodGroupConfig.MatchConfig matchConfig;
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1102700219, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendView.<anonymous>.<anonymous>.<anonymous> (ShootResultMatchFriendView.kt:111)");
                                            }
                                            i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 296.0f), 139.0f);
                                            NBPMoodGroupConfig resultConfig$qecommerce_biz_release = NBPShootResultViewModel.this.getResultConfig$qecommerce_biz_release();
                                            ImageKt.a((resultConfig$qecommerce_biz_release == null || (matchConfig = resultConfig$qecommerce_biz_release.matchMsgConfig) == null) ? null : matchConfig.cardBackgroundImg, null, null, null, null, k3, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer7, 262144, 0, 0, 2097118);
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
                    }), composer3, 3128, 4);
                    i a18 = bVar2.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 296.0f), 335.0f), 0.0f, 220.0f - NBPShootResultViewModel.this.smallScreenOffsetY.getValue().floatValue(), 0.0f, 0.0f, 13, null), alignment);
                    final NBPShootResultViewModel nBPShootResultViewModel4 = NBPShootResultViewModel.this;
                    BoxKt.a(a18, alignment2, null, ComposableLambdaKt.composableLambda(composer3, -176370688, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt$ShootResultMatchFriendView$2.3
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
                                    ComposerKt.traceEventStart(-176370688, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendView.<anonymous>.<anonymous> (ShootResultMatchFriendView.kt:124)");
                                }
                                i a19 = ComposeLayoutPropUpdaterKt.a(ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.0f, 1, null), 0.0f, 0.0f);
                                Alignment.Horizontal b16 = Alignment.INSTANCE.b();
                                a.e b17 = a.f339245a.b();
                                final NBPShootResultViewModel nBPShootResultViewModel5 = NBPShootResultViewModel.this;
                                ColumnKt.a(a19, b17, b16, null, ComposableLambdaKt.composableLambda(composer5, 1311052215, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt.ShootResultMatchFriendView.2.3.1
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(d dVar, Composer composer6, Integer num3) {
                                        int i17;
                                        d dVar2 = dVar;
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 14) == 0) {
                                            i17 = (composer7.changed(dVar2) ? 4 : 2) | intValue3;
                                        } else {
                                            i17 = intValue3;
                                        }
                                        if ((i17 & 91) == 18 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1311052215, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendView.<anonymous>.<anonymous>.<anonymous> (ShootResultMatchFriendView.kt:130)");
                                            }
                                            i.Companion companion2 = i.INSTANCE;
                                            i n16 = ComposeLayoutPropUpdaterKt.n(dVar2.b(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion2, 0.0f, 1, null), 75.0f), Alignment.INSTANCE.e()), 16.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                            final NBPShootResultViewModel nBPShootResultViewModel6 = NBPShootResultViewModel.this;
                                            RowKt.a(n16, null, null, null, null, ComposableLambdaKt.composableLambda(composer7, 160908249, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt.ShootResultMatchFriendView.2.3.1.1
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(n nVar, Composer composer8, Integer num4) {
                                                    Composer composer9 = composer8;
                                                    int intValue4 = num4.intValue();
                                                    if ((intValue4 & 81) == 16 && composer9.getSkipping()) {
                                                        composer9.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(160908249, intValue4, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ShootResultMatchFriendView.kt:135)");
                                                        }
                                                        i.Companion companion3 = i.INSTANCE;
                                                        i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion3, 134.0f), 75.0f);
                                                        final NBPShootResultViewModel nBPShootResultViewModel7 = NBPShootResultViewModel.this;
                                                        ColumnKt.a(k3, null, null, null, ComposableLambdaKt.composableLambda(composer9, 543433680, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt.ShootResultMatchFriendView.2.3.1.1.1
                                                            {
                                                                super(3);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function3
                                                            public final Unit invoke(d dVar3, Composer composer10, Integer num5) {
                                                                Composer composer11 = composer10;
                                                                int intValue5 = num5.intValue();
                                                                if ((intValue5 & 81) == 16 && composer11.getSkipping()) {
                                                                    composer11.skipToGroupEnd();
                                                                } else {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(543433680, intValue5, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ShootResultMatchFriendView.kt:138)");
                                                                    }
                                                                    i.Companion companion4 = i.INSTANCE;
                                                                    i k16 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion4, 134.0f), 52.0f);
                                                                    final NBPShootResultViewModel nBPShootResultViewModel8 = NBPShootResultViewModel.this;
                                                                    RowKt.a(k16, null, null, null, null, ComposableLambdaKt.composableLambda(composer11, 1660239218, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt.ShootResultMatchFriendView.2.3.1.1.1.1
                                                                        {
                                                                            super(3);
                                                                        }

                                                                        /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
                                                                        
                                                                            if (r1 != null) goto L33;
                                                                         */
                                                                        /* JADX WARN: Code restructure failed: missing block: B:33:0x0073, code lost:
                                                                        
                                                                            if (r1 != null) goto L33;
                                                                         */
                                                                        @Override // kotlin.jvm.functions.Function3
                                                                        /*
                                                                            Code decompiled incorrectly, please refer to instructions dump.
                                                                        */
                                                                        public final Unit invoke(n nVar2, Composer composer12, Integer num6) {
                                                                            String str;
                                                                            NBPMoodGroupConfig.MatchConfig matchConfig;
                                                                            List<String> list;
                                                                            Object orNull;
                                                                            NBPMoodGroupConfig.MatchConfig matchConfig2;
                                                                            List<String> list2;
                                                                            Object orNull2;
                                                                            Composer composer13 = composer12;
                                                                            int intValue6 = num6.intValue();
                                                                            if ((intValue6 & 81) == 16 && composer13.getSkipping()) {
                                                                                composer13.skipToGroupEnd();
                                                                            } else {
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventStart(1660239218, intValue6, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ShootResultMatchFriendView.kt:141)");
                                                                                }
                                                                                if (NBPShootResultViewModel.this.matchResult.size() == 1) {
                                                                                    NBPMoodGroupConfig resultConfig$qecommerce_biz_release = NBPShootResultViewModel.this.getResultConfig$qecommerce_biz_release();
                                                                                    if (resultConfig$qecommerce_biz_release != null && (matchConfig2 = resultConfig$qecommerce_biz_release.matchMsgConfig) != null && (list2 = matchConfig2.welcomeText) != null) {
                                                                                        orNull2 = CollectionsKt___CollectionsKt.getOrNull(list2, 0);
                                                                                        str = (String) orNull2;
                                                                                    }
                                                                                    str = "\u4f60\u51fb\u4e2d\u4e86\u540c\u6837EMO\u7684TA";
                                                                                } else {
                                                                                    NBPMoodGroupConfig resultConfig$qecommerce_biz_release2 = NBPShootResultViewModel.this.getResultConfig$qecommerce_biz_release();
                                                                                    if (resultConfig$qecommerce_biz_release2 != null && (matchConfig = resultConfig$qecommerce_biz_release2.matchMsgConfig) != null && (list = matchConfig.welcomeText) != null) {
                                                                                        orNull = CollectionsKt___CollectionsKt.getOrNull(list, 1);
                                                                                        str = (String) orNull;
                                                                                    }
                                                                                    str = "\u4f60\u51fb\u4e2d\u4e86\u540c\u6837EMO\u7684\u4ed6\u4eec";
                                                                                }
                                                                                TextKt.a(str, ComposeLayoutPropUpdaterKt.i(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.q(i.INSTANCE, 8.0f), 130.0f), 118.0f), null, null, Float.valueOf(20.0f), null, c.INSTANCE.g(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer13, 1597504, 0, 0, 134217644);
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventEnd();
                                                                                }
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    }), composer11, 196616, 30);
                                                                    i k17 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion4, 134.0f), 21.0f);
                                                                    final NBPShootResultViewModel nBPShootResultViewModel9 = NBPShootResultViewModel.this;
                                                                    RowKt.a(k17, null, null, null, null, ComposableLambdaKt.composableLambda(composer11, 1868076905, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt.ShootResultMatchFriendView.2.3.1.1.1.2
                                                                        {
                                                                            super(3);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function3
                                                                        public final Unit invoke(n nVar2, Composer composer12, Integer num6) {
                                                                            String str;
                                                                            Composer composer13 = composer12;
                                                                            int intValue6 = num6.intValue();
                                                                            if ((intValue6 & 81) == 16 && composer13.getSkipping()) {
                                                                                composer13.skipToGroupEnd();
                                                                            } else {
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventStart(1868076905, intValue6, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ShootResultMatchFriendView.kt:160)");
                                                                                }
                                                                                if (NBPShootResultViewModel.this.matchResult.size() == 1) {
                                                                                    str = "\u771f\u7684\u597d\u5de7\u554a";
                                                                                } else {
                                                                                    str = "\u4e00\u8d77\u804a\u804a\u5427";
                                                                                }
                                                                                c e16 = c.INSTANCE.e();
                                                                                TextKt.a(str, ComposeLayoutPropUpdaterKt.i(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.q(i.INSTANCE, 8.0f), 130.0f), 118.0f), null, QUIToken.color$default("text_primary"), Float.valueOf(14.0f), null, e16, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer13, 1601600, 0, 0, 134217636);
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventEnd();
                                                                                }
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    }), composer11, 196616, 30);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }), composer9, 24584, 14);
                                                        i n17 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion3, NBPShootResultViewModel.this.cartoonImg.width), NBPShootResultViewModel.this.cartoonImg.height), 0.0f, NBPShootResultViewModel.this.cartoonImg.offsetY, 0.0f, 0.0f, 13, null);
                                                        final NBPShootResultViewModel nBPShootResultViewModel8 = NBPShootResultViewModel.this;
                                                        BoxKt.a(n17, null, null, ComposableLambdaKt.composableLambda(composer9, 828174687, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt.ShootResultMatchFriendView.2.3.1.1.2
                                                            {
                                                                super(3);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function3
                                                            public final Unit invoke(b bVar4, Composer composer10, Integer num5) {
                                                                Composer composer11 = composer10;
                                                                int intValue5 = num5.intValue();
                                                                if ((intValue5 & 81) == 16 && composer11.getSkipping()) {
                                                                    composer11.skipToGroupEnd();
                                                                } else {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(828174687, intValue5, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ShootResultMatchFriendView.kt:182)");
                                                                    }
                                                                    ImageKt.a(NBPShootResultViewModel.this.cartoonImg.url, null, null, null, null, ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer11, 262144, 0, 0, 2097118);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }), composer9, 3080, 6);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer7, 196616, 30);
                                            SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion2, 16.0f), composer7, 8, 0);
                                            i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion2, 0.0f, 1, null), 95.0f);
                                            a.e f16 = a.f339245a.f();
                                            final NBPShootResultViewModel nBPShootResultViewModel7 = NBPShootResultViewModel.this;
                                            RowKt.a(k3, f16, null, null, null, ComposableLambdaKt.composableLambda(composer7, -1503362160, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt.ShootResultMatchFriendView.2.3.1.2
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(n nVar, Composer composer8, Integer num4) {
                                                    List take;
                                                    Composer composer9 = composer8;
                                                    int intValue4 = num4.intValue();
                                                    if ((intValue4 & 81) == 16 && composer9.getSkipping()) {
                                                        composer9.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1503362160, intValue4, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ShootResultMatchFriendView.kt:195)");
                                                        }
                                                        if (NBPShootResultViewModel.this.matchResult.size() == 1) {
                                                            composer9.startReplaceableGroup(-449067463);
                                                            i k16 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 85.0f);
                                                            Alignment.Horizontal b18 = Alignment.INSTANCE.b();
                                                            final NBPShootResultViewModel nBPShootResultViewModel8 = NBPShootResultViewModel.this;
                                                            ColumnKt.a(k16, null, b18, null, ComposableLambdaKt.composableLambda(composer9, 118194018, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt.ShootResultMatchFriendView.2.3.1.2.1
                                                                {
                                                                    super(3);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function3
                                                                public final Unit invoke(d dVar3, Composer composer10, Integer num5) {
                                                                    Composer composer11 = composer10;
                                                                    int intValue5 = num5.intValue();
                                                                    if ((intValue5 & 81) == 16 && composer11.getSkipping()) {
                                                                        composer11.skipToGroupEnd();
                                                                    } else {
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(118194018, intValue5, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ShootResultMatchFriendView.kt:200)");
                                                                        }
                                                                        i.Companion companion3 = i.INSTANCE;
                                                                        i k17 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion3, 0.0f, 1, null), 70.0f);
                                                                        Alignment alignment3 = Alignment.Center;
                                                                        final NBPShootResultViewModel nBPShootResultViewModel9 = NBPShootResultViewModel.this;
                                                                        BoxKt.a(k17, alignment3, null, ComposableLambdaKt.composableLambda(composer11, -1658716952, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt.ShootResultMatchFriendView.2.3.1.2.1.1
                                                                            {
                                                                                super(3);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function3
                                                                            public final Unit invoke(b bVar4, Composer composer12, Integer num6) {
                                                                                Composer composer13 = composer12;
                                                                                int intValue6 = num6.intValue();
                                                                                if ((intValue6 & 81) == 16 && composer13.getSkipping()) {
                                                                                    composer13.skipToGroupEnd();
                                                                                } else {
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        ComposerKt.traceEventStart(-1658716952, intValue6, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ShootResultMatchFriendView.kt:204)");
                                                                                    }
                                                                                    i.Companion companion4 = i.INSTANCE;
                                                                                    i n17 = ComposeLayoutPropUpdaterKt.n(ModifiersKt.j(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion4, 68.0f), 68.0f), 34.0f), -35.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                                                                    BorderStyle borderStyle = BorderStyle.SOLID;
                                                                                    h.Companion companion5 = h.INSTANCE;
                                                                                    ImageKt.a(UserDataManager.INSTANCE.getUserSelfInfo().avatarUrl, null, null, null, null, ModifiersKt.g(n17, new e(2.0f, borderStyle, companion5.m())), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer13, 262144, 0, 0, 2097118);
                                                                                    ImageKt.a(NBPShootResultViewModel.this.matchResult.get(0).f444491h, null, null, null, null, ModifiersKt.g(ComposeLayoutPropUpdaterKt.n(ModifiersKt.j(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion4, 68.0f), 68.0f), 34.0f), 45.0f, 0.0f, 0.0f, 0.0f, 14, null), new e(2.0f, borderStyle, companion5.m())), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer13, 262144, 0, 0, 2097118);
                                                                                    DatalineDetailViewModel$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("match result gender = "), NBPShootResultViewModel.this.matchResult.get(0).E, KLog.INSTANCE, "NBPShootResultPage");
                                                                                    if (NBPShootResultViewModel.this.matchResult.get(0).E == 1) {
                                                                                        composer13.startReplaceableGroup(1396141317);
                                                                                        BoxKt.a(ComposeLayoutPropUpdaterKt.n(ModifiersKt.c(ModifiersKt.j(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion4, 23.0f), 23.0f), 11.5f), new h(4278229503L)), 84.0f, 41.0f, 0.0f, 0.0f, 12, null), Alignment.Center, null, ComposableSingletons$ShootResultMatchFriendViewKt.f71lambda1, composer13, 3128, 4);
                                                                                        composer13.endReplaceableGroup();
                                                                                    } else if (NBPShootResultViewModel.this.matchResult.get(0).E == 2) {
                                                                                        composer13.startReplaceableGroup(1396142164);
                                                                                        BoxKt.a(ComposeLayoutPropUpdaterKt.n(ModifiersKt.c(ModifiersKt.j(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion4, 23.0f), 23.0f), 11.5f), new h(4294934719L)), 84.0f, 41.0f, 0.0f, 0.0f, 12, null), Alignment.Center, null, ComposableSingletons$ShootResultMatchFriendViewKt.f72lambda2, composer13, 3128, 4);
                                                                                        composer13.endReplaceableGroup();
                                                                                    } else {
                                                                                        composer13.startReplaceableGroup(1396142963);
                                                                                        composer13.endReplaceableGroup();
                                                                                    }
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        ComposerKt.traceEventEnd();
                                                                                    }
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        }), composer11, 3128, 4);
                                                                        SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion3, 10.0f), composer11, 8, 0);
                                                                        i j3 = ComposeLayoutPropUpdaterKt.j(companion3, 0.0f, 1, null);
                                                                        Alignment.Vertical c16 = Alignment.INSTANCE.c();
                                                                        a.e b19 = a.f339245a.b();
                                                                        final NBPShootResultViewModel nBPShootResultViewModel10 = NBPShootResultViewModel.this;
                                                                        RowKt.a(j3, b19, c16, null, null, ComposableLambdaKt.composableLambda(composer11, -1297533436, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt.ShootResultMatchFriendView.2.3.1.2.1.2
                                                                            {
                                                                                super(3);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function3
                                                                            public final Unit invoke(n nVar2, Composer composer12, Integer num6) {
                                                                                Composer composer13 = composer12;
                                                                                int intValue6 = num6.intValue();
                                                                                if ((intValue6 & 81) == 16 && composer13.getSkipping()) {
                                                                                    composer13.skipToGroupEnd();
                                                                                } else {
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        ComposerKt.traceEventStart(-1297533436, intValue6, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ShootResultMatchFriendView.kt:254)");
                                                                                    }
                                                                                    ShootResultMatchFriendViewKt.access$TagsDisplay(NBPShootResultViewModel.this.matchResult.get(0).D, NBPShootResultViewModel.this.matchResult.get(0).C, composer13, 8);
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        ComposerKt.traceEventEnd();
                                                                                    }
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        }), composer11, 196680, 24);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }), composer9, 24584, 10);
                                                            composer9.endReplaceableGroup();
                                                        } else if (NBPShootResultViewModel.this.matchResult.size() > 1) {
                                                            composer9.startReplaceableGroup(-449063552);
                                                            take = CollectionsKt___CollectionsKt.take(NBPShootResultViewModel.this.matchResult, 3);
                                                            Iterator it = take.iterator();
                                                            while (it.hasNext()) {
                                                                ShootResultMatchFriendViewKt.access$UserItemView((g) it.next(), composer9, 8);
                                                            }
                                                            composer9.endReplaceableGroup();
                                                        } else {
                                                            composer9.startReplaceableGroup(-449063393);
                                                            composer9.endReplaceableGroup();
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer7, 196680, 28);
                                            SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion2, 16.0f), composer7, 8, 0);
                                            final NBPShootResultViewModel nBPShootResultViewModel8 = NBPShootResultViewModel.this;
                                            KuiklyKt.a(null, null, new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt.ShootResultMatchFriendView.2.3.1.3
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                                                    ViewContainer<?, ?> viewContainer2 = viewContainer;
                                                    final NBPShootResultViewModel nBPShootResultViewModel9 = NBPShootResultViewModel.this;
                                                    viewContainer2.ref(viewContainer2, new Function1<aa<ViewContainer<?, ?>>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt.ShootResultMatchFriendView.2.3.1.3.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(aa<ViewContainer<?, ?>> aaVar) {
                                                            NBPShootResultViewModel.this.inputViewRef = aaVar;
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt.ShootResultMatchFriendView.2.3.1.3.2
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(m mVar) {
                                                            m mVar2 = mVar;
                                                            mVar2.size(238.0f, 42.0f);
                                                            mVar2.borderRadius(4.0f);
                                                            mVar2.flexDirectionRow();
                                                            mVar2.mo113backgroundColor(QUIToken.color$default("fill_standard_primary"));
                                                            mVar2.alignItemsCenter();
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final NBPShootResultViewModel nBPShootResultViewModel10 = NBPShootResultViewModel.this;
                                                    am.a(viewContainer2, new Function1<InputView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt.ShootResultMatchFriendView.2.3.1.3.3
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(InputView inputView) {
                                                            InputView inputView2 = inputView;
                                                            final NBPShootResultViewModel nBPShootResultViewModel11 = NBPShootResultViewModel.this;
                                                            inputView2.ref(inputView2, new Function1<aa<InputView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt.ShootResultMatchFriendView.2.3.1.3.3.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(aa<InputView> aaVar) {
                                                                    NBPShootResultViewModel.this.inputRef = aaVar;
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final NBPShootResultViewModel nBPShootResultViewModel12 = NBPShootResultViewModel.this;
                                                            inputView2.attr(new Function1<ai, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt.ShootResultMatchFriendView.2.3.1.3.3.2
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ai aiVar) {
                                                                    ai aiVar2 = aiVar;
                                                                    Attr.absolutePosition$default(aiVar2, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                                                    aiVar2.m150top(8.0f);
                                                                    aiVar2.m138bottom(8.0f);
                                                                    aiVar2.m142left(16.0f);
                                                                    aiVar2.m149right(36.0f);
                                                                    aiVar2.C();
                                                                    aiVar2.u("\u8f93\u5165\u6587\u672c");
                                                                    aiVar2.i(QUIToken.color$default("text_primary"));
                                                                    ai.m(aiVar2, 17.0f, null, 2, null);
                                                                    aiVar2.t(65);
                                                                    aiVar2.B(NBPShootResultViewModel.this.getEditedText());
                                                                    aiVar2.w();
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final NBPShootResultViewModel nBPShootResultViewModel13 = NBPShootResultViewModel.this;
                                                            inputView2.event(new Function1<InputEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt.ShootResultMatchFriendView.2.3.1.3.3.3
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(InputEvent inputEvent) {
                                                                    InputEvent inputEvent2 = inputEvent;
                                                                    final NBPShootResultViewModel nBPShootResultViewModel14 = NBPShootResultViewModel.this;
                                                                    InputEvent.q(inputEvent2, false, new Function1<InputParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt.ShootResultMatchFriendView.2.3.1.3.3.3.1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(InputParams inputParams) {
                                                                            CharSequence trimEnd;
                                                                            trimEnd = StringsKt__StringsKt.trimEnd((CharSequence) inputParams.getText());
                                                                            String obj = trimEnd.toString();
                                                                            if (obj.length() >= 65) {
                                                                                Utils.INSTANCE.currentBridgeModule().qToast("\u8f93\u5165\u6587\u5b57\u4e0d\u8981\u8d85\u8fc765\u5b57", QToastMode.Info);
                                                                                obj = obj.substring(0, 65);
                                                                                Intrinsics.checkNotNullExpressionValue(obj, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                                                            }
                                                                            NBPShootResultViewModel.this.editedText$delegate.setValue(obj);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    }, 1, null);
                                                                    final NBPShootResultViewModel nBPShootResultViewModel15 = NBPShootResultViewModel.this;
                                                                    InputEvent.l(inputEvent2, false, new Function1<KeyboardParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt.ShootResultMatchFriendView.2.3.1.3.3.3.2
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(KeyboardParams keyboardParams) {
                                                                            ViewContainer<?, ?> b18;
                                                                            com.tencent.kuikly.core.layout.d frame;
                                                                            KeyboardParams keyboardParams2 = keyboardParams;
                                                                            if (!NBPShootResultViewModel.this.hasAddHeight) {
                                                                                float l3 = (com.tencent.kuikly.core.manager.c.f117352a.g().getPageData().l() - keyboardParams2.getHeight()) - 42.0f;
                                                                                aa<ViewContainer<?, ?>> aaVar = NBPShootResultViewModel.this.inputViewRef;
                                                                                if (l3 < ((aaVar == null || (b18 = aaVar.b()) == null || (frame = b18.getFrame()) == null) ? 240.0f : frame.getY()) + 220.0f) {
                                                                                    MutableState<Float> mutableState = NBPShootResultViewModel.this.smallScreenOffsetY;
                                                                                    mutableState.setValue(Float.valueOf(mutableState.getValue().floatValue() + 60.0f));
                                                                                    NBPShootResultViewModel.this.hasAddHeight = true;
                                                                                }
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    }, 1, null);
                                                                    inputEvent2.r(new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt.ShootResultMatchFriendView.2.3.1.3.3.3.3
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(Object obj) {
                                                                            Utils.INSTANCE.currentBridgeModule().qToast("\u8f93\u5165\u6587\u5b57\u4e0d\u8981\u8d85\u8fc765\u5b57", QToastMode.Info);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    final NBPShootResultViewModel nBPShootResultViewModel16 = NBPShootResultViewModel.this;
                                                                    inputEvent2.j(new Function1<InputParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt.ShootResultMatchFriendView.2.3.1.3.3.3.4
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(InputParams inputParams) {
                                                                            InputView b18;
                                                                            aa<InputView> aaVar = NBPShootResultViewModel.this.inputRef;
                                                                            if (aaVar != null && (b18 = aaVar.b()) != null) {
                                                                                b18.h();
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    final NBPShootResultViewModel nBPShootResultViewModel17 = NBPShootResultViewModel.this;
                                                                    VisibilityEventKt.b(inputEvent2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt.ShootResultMatchFriendView.2.3.1.3.3.3.5
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(Object obj) {
                                                                            InputView b18;
                                                                            aa<InputView> aaVar = NBPShootResultViewModel.this.inputRef;
                                                                            if (aaVar != null && (b18 = aaVar.b()) != null) {
                                                                                b18.l(0);
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final NBPShootResultViewModel nBPShootResultViewModel11 = NBPShootResultViewModel.this;
                                                    w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt.ShootResultMatchFriendView.2.3.1.3.4
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(v vVar) {
                                                            v vVar2 = vVar;
                                                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt.ShootResultMatchFriendView.2.3.1.3.4.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(t tVar) {
                                                                    t tVar2 = tVar;
                                                                    tVar2.positionAbsolute();
                                                                    tVar2.m149right(12.0f);
                                                                    tVar2.m150top(0.0f);
                                                                    tVar2.m138bottom(0.0f);
                                                                    tVar2.justifyContentCenter();
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt.ShootResultMatchFriendView.2.3.1.3.4.2
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ImageView imageView) {
                                                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt.ShootResultMatchFriendView.2.3.1.3.4.2.1
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(af afVar) {
                                                                            af afVar2 = afVar;
                                                                            afVar2.size(16.0f, 16.0f);
                                                                            b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_BRRaDZOKepp.png", false, 2, null);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final NBPShootResultViewModel nBPShootResultViewModel12 = NBPShootResultViewModel.this;
                                                            vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt.ShootResultMatchFriendView.2.3.1.3.4.3
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(u uVar) {
                                                                    final NBPShootResultViewModel nBPShootResultViewModel13 = NBPShootResultViewModel.this;
                                                                    uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt.ShootResultMatchFriendView.2.3.1.3.4.3.1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ClickParams clickParams) {
                                                                            InputView b18;
                                                                            InputView b19;
                                                                            if (NBPShootResultViewModel.this.getRecommendMatchMsgList().size() < 2) {
                                                                                KLog.INSTANCE.i("NBPShootResultPage", "recommendMatchMsgList.size < 2");
                                                                            } else {
                                                                                NBPShootResultViewModel nBPShootResultViewModel14 = NBPShootResultViewModel.this;
                                                                                nBPShootResultViewModel14.textIndex$delegate.setValue(Integer.valueOf((nBPShootResultViewModel14.getTextIndex() + 1) % NBPShootResultViewModel.this.getRecommendMatchMsgList().size()));
                                                                                aa<InputView> aaVar = NBPShootResultViewModel.this.inputRef;
                                                                                if (aaVar != null && (b19 = aaVar.b()) != null) {
                                                                                    final NBPShootResultViewModel nBPShootResultViewModel15 = NBPShootResultViewModel.this;
                                                                                    b19.attr(new Function1<ai, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt.ShootResultMatchFriendView.2.3.1.3.4.3.1.1
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Unit invoke(ai aiVar) {
                                                                                            aiVar.B(NBPShootResultViewModel.this.getRecommendMatchMsgList().get(NBPShootResultViewModel.this.getTextIndex()));
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    });
                                                                                }
                                                                                NBPShootResultViewModel nBPShootResultViewModel16 = NBPShootResultViewModel.this;
                                                                                nBPShootResultViewModel16.editedText$delegate.setValue(nBPShootResultViewModel16.getRecommendMatchMsgList().get(NBPShootResultViewModel.this.getTextIndex()));
                                                                                aa<InputView> aaVar2 = NBPShootResultViewModel.this.inputRef;
                                                                                if (aaVar2 != null && (b18 = aaVar2.b()) != null) {
                                                                                    b18.l(0);
                                                                                }
                                                                                NBPMoodGroupReportViewModel nBPMoodGroupReportViewModel = NBPShootResultViewModel.this.reportVM;
                                                                                com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
                                                                                NBPShootResultViewModel nBPShootResultViewModel17 = NBPShootResultViewModel.this;
                                                                                eVar.t("nearby_click_area", 1);
                                                                                eVar.v("nearby_text", nBPShootResultViewModel17.getEditedText());
                                                                                Unit unit = Unit.INSTANCE;
                                                                                nBPMoodGroupReportViewModel.dtReportElementClick("em_nearby_greet_pop", eVar);
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            }, composer7, 0, 3);
                                            SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion2, 16.0f), composer7, 8, 0);
                                            final NBPShootResultViewModel nBPShootResultViewModel9 = NBPShootResultViewModel.this;
                                            ButtonKt.a(null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt.ShootResultMatchFriendView.2.3.1.4
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    List<g> take;
                                                    take = CollectionsKt___CollectionsKt.take(NBPShootResultViewModel.this.matchResult, 3);
                                                    final NBPShootResultViewModel nBPShootResultViewModel10 = NBPShootResultViewModel.this;
                                                    for (g gVar : take) {
                                                        KLog kLog = KLog.INSTANCE;
                                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("tid: ");
                                                        m3.append(gVar.f444488d);
                                                        m3.append(" msg:");
                                                        m3.append(nBPShootResultViewModel10.getEditedText());
                                                        kLog.i("NBPShootResultPage", m3.toString());
                                                        QQNearbyModule.Companion.getInstance().sendAIOMessage(String.valueOf(gVar.f444488d), nBPShootResultViewModel10.getEditedText(), new Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt$ShootResultMatchFriendView$2$3$1$4$1$1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(com.tencent.kuikly.core.nvi.serialization.json.e eVar) {
                                                                final NBPShootResultViewModel nBPShootResultViewModel11 = NBPShootResultViewModel.this;
                                                                TimerKt.d(200, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt$ShootResultMatchFriendView$2$3$1$4$1$1.1
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final Unit invoke() {
                                                                        NBPShootResultViewModel nBPShootResultViewModel12 = NBPShootResultViewModel.this;
                                                                        if (nBPShootResultViewModel12.readyToShowThemeMapGuide) {
                                                                            nBPShootResultViewModel12.setShowThemeMapGuide(true);
                                                                        }
                                                                        NBPShootResultViewModel.this.setNeedToBlur(false);
                                                                        NBPShootResultViewModel.this.resultViewState.setValue(NBPShootResultPageState.NULL);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                    }
                                                    NBPShootResultViewModel.this.fadeOutAnimation.setValue(Boolean.FALSE);
                                                    final NBPShootResultViewModel nBPShootResultViewModel11 = NBPShootResultViewModel.this;
                                                    TimerKt.d(150, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt.ShootResultMatchFriendView.2.3.1.4.2
                                                        {
                                                            super(0);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Unit invoke() {
                                                            NBPShootResultViewModel.this.resultViewState.setValue(NBPShootResultPageState.NULL);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    NBPMoodGroupReportViewModel nBPMoodGroupReportViewModel = NBPShootResultViewModel.this.reportVM;
                                                    com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
                                                    NBPShootResultViewModel nBPShootResultViewModel12 = NBPShootResultViewModel.this;
                                                    eVar.t("nearby_click_area", 2);
                                                    eVar.v("nearby_text", nBPShootResultViewModel12.getEditedText());
                                                    Unit unit = Unit.INSTANCE;
                                                    nBPMoodGroupReportViewModel.dtReportElementClick("em_nearby_greet_pop", eVar);
                                                    ((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule")).qToast("\u6d88\u606f\u5df2\u53d1\u9001", QToastMode.Success);
                                                    return Unit.INSTANCE;
                                                }
                                            }, ModifiersKt.j(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion2, 238.0f), 42.0f), QUIToken.color$default("brand_standard")), 4.0f), null, ComposableSingletons$ShootResultMatchFriendViewKt.f73lambda3, composer7, 25088, 9);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 24648, 8);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 3128, 4);
                    i a19 = bVar2.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 100.0f), 60.0f), 0.0f, 580.0f - NBPShootResultViewModel.this.smallScreenOffsetY.getValue().floatValue(), 0.0f, 0.0f, 13, null), alignment);
                    final NBPShootResultViewModel nBPShootResultViewModel5 = NBPShootResultViewModel.this;
                    BoxKt.a(ViewEventPropUpdaterKt.d(a19, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt$ShootResultMatchFriendView$2.4
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ClickParams clickParams) {
                            NBPShootResultViewModel nBPShootResultViewModel6 = NBPShootResultViewModel.this;
                            if (nBPShootResultViewModel6.readyToShowThemeMapGuide) {
                                nBPShootResultViewModel6.setShowThemeMapGuide(true);
                            }
                            NBPMoodGroupReportViewModel nBPMoodGroupReportViewModel = NBPShootResultViewModel.this.reportVM;
                            com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
                            NBPShootResultViewModel nBPShootResultViewModel7 = NBPShootResultViewModel.this;
                            eVar.t("nearby_click_area", 0);
                            eVar.v("nearby_text", nBPShootResultViewModel7.getEditedText());
                            Unit unit = Unit.INSTANCE;
                            nBPMoodGroupReportViewModel.dtReportElementClick("em_nearby_greet_pop", eVar);
                            NBPShootResultViewModel.this.setNeedToBlur(false);
                            NBPShootResultViewModel.this.fadeOutAnimation.setValue(Boolean.FALSE);
                            final NBPShootResultViewModel nBPShootResultViewModel8 = NBPShootResultViewModel.this;
                            TimerKt.d(150, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt.ShootResultMatchFriendView.2.4.2
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Unit invoke() {
                                    NBPShootResultViewModel.this.resultViewState.setValue(NBPShootResultPageState.NULL);
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    }, 3, null), Alignment.Center, null, ComposableSingletons$ShootResultMatchFriendViewKt.f74lambda4, composer3, 3128, 4);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt$ShootResultMatchFriendView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                ShootResultMatchFriendViewKt.ShootResultMatchFriendView(NBPShootResultViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
