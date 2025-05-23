package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSBottomDynamicGuideEvent;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel;
import com.tencent.kuikly.core.manager.c;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.SurfaceKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import defpackage.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTFileSkeletonItemKt {
    public static final void QQFTFileSkeletonItem(final int i3, final QQFlashTransferViewModel qQFlashTransferViewModel, Composer composer, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(-810889664);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-810889664, i16, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileSkeletonItem (QQFTFileSkeletonItem.kt:39)");
        }
        if (qQFlashTransferViewModel.isGridMode.getValue().booleanValue()) {
            startRestartGroup.startReplaceableGroup(-250775269);
            if (!qQFlashTransferViewModel.isImageGridMode()) {
                gridSkeletonView(((GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0.m(c.f117352a) - 3) - 8.0f) / 3.0f, startRestartGroup, 0);
            }
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.startReplaceableGroup(-250775141);
            listSkeletonView(i3, qQFlashTransferViewModel, 71.0f, startRestartGroup, (i16 & 14) | TroopInfo.PAY_PRIVILEGE_ALL);
            startRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileSkeletonItemKt$QQFTFileSkeletonItem$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTFileSkeletonItemKt.QQFTFileSkeletonItem(i3, qQFlashTransferViewModel, composer2, i16 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void gridSkeletonView(final float f16, Composer composer, final int i3) {
        int i16;
        Composer startRestartGroup = composer.startRestartGroup(-1545875676);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(f16) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i16 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1545875676, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.gridSkeletonView (QQFTFileSkeletonItem.kt:50)");
            }
            ColumnKt.a(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, f16), null, Alignment.INSTANCE.b(), null, ComposableLambdaKt.composableLambda(startRestartGroup, 1738279245, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileSkeletonItemKt$gridSkeletonView$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(d dVar, Composer composer2, Integer num) {
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 81) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1738279245, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.gridSkeletonView.<anonymous> (QQFTFileSkeletonItem.kt:51)");
                        }
                        i.Companion companion = i.INSTANCE;
                        float f17 = 72;
                        ColumnKt.a(ModifiersKt.c(ModifiersKt.q(ComposeLayoutPropUpdaterKt.u(ComposeLayoutPropUpdaterKt.n(companion, 0.0f, 8.0f, 0.0f, 0.0f, 13, null), f16 - f17), uo3.c.a(10.0f)), QUIToken.color$default("fill_standard_primary")), null, null, null, ComposableSingletons$QQFTFileSkeletonItemKt.f134lambda1, composer3, 24584, 14);
                        ColumnKt.a(ModifiersKt.c(ModifiersKt.q(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.n(companion, 0.0f, 11.5f, 0.0f, 0.0f, 13, null), f16 - 26), 20.0f), uo3.c.a(6.0f)), QUIToken.color$default("fill_standard_primary")), null, null, null, ComposableSingletons$QQFTFileSkeletonItemKt.f136lambda2, composer3, 24584, 14);
                        ColumnKt.a(ModifiersKt.c(ModifiersKt.q(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.n(companion, 0.0f, 2.0f, 0.0f, 0.0f, 13, null), f16 - f17), 17.0f), uo3.c.a(4.0f)), QUIToken.color$default("fill_standard_primary")), null, null, null, ComposableSingletons$QQFTFileSkeletonItemKt.f137lambda3, composer3, 24584, 14);
                        SpacerKt.a(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.k(companion, 12.0f), GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0.m(c.f117352a) / 3), composer3, 8, 0);
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
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileSkeletonItemKt$gridSkeletonView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTFileSkeletonItemKt.gridSkeletonView(f16, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void listSkeletonView(final int i3, final QQFlashTransferViewModel qQFlashTransferViewModel, final float f16, Composer composer, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(951490026);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(951490026, i16, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.listSkeletonView (QQFTFileSkeletonItem.kt:67)");
        }
        i.Companion companion = i.INSTANCE;
        i k3 = ComposeLayoutPropUpdaterKt.k(companion, f16);
        c cVar = c.f117352a;
        RowKt.a(ComposeLayoutPropUpdaterKt.w(k3, cVar.g().getPageData().m()), null, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1195380852, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileSkeletonItemKt$listSkeletonView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(n nVar, Composer composer2, Integer num) {
                int i17;
                n nVar2 = nVar;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 14) == 0) {
                    i17 = (composer3.changed(nVar2) ? 4 : 2) | intValue;
                } else {
                    i17 = intValue;
                }
                if ((i17 & 91) == 18 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1195380852, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.listSkeletonView.<anonymous> (QQFTFileSkeletonItem.kt:68)");
                    }
                    i.Companion companion2 = i.INSTANCE;
                    QQFTCheckBoxViewKt.QQFTCheckBoxView(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(companion2, f16), 16.0f, 0.0f, 14.0f, 0.0f, 10, null), 0.0f, false, null, null, false, composer3, QFSBottomDynamicGuideEvent.DYNAMIC_GUIDE_BUTTON_TYPE, 58);
                    i a16 = nVar2.a(nVar2.b(ComposeLayoutPropUpdaterKt.k(companion2, f16), Alignment.INSTANCE.c()), 1.0f);
                    final float f17 = f16;
                    RowKt.a(a16, null, null, null, null, ComposableLambdaKt.composableLambda(composer3, 1604435374, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileSkeletonItemKt$listSkeletonView$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(n nVar3, Composer composer4, Integer num2) {
                            int i18;
                            n nVar4 = nVar3;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 14) == 0) {
                                i18 = (composer5.changed(nVar4) ? 4 : 2) | intValue2;
                            } else {
                                i18 = intValue2;
                            }
                            if ((i18 & 91) == 18 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1604435374, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.listSkeletonView.<anonymous>.<anonymous> (QQFTFileSkeletonItem.kt:75)");
                                }
                                i.Companion companion3 = i.INSTANCE;
                                i u16 = ComposeLayoutPropUpdaterKt.u(companion3, f17 * 0.75f);
                                Alignment.Companion companion4 = Alignment.INSTANCE;
                                BoxKt.a(ModifiersKt.c(ModifiersKt.q(nVar4.b(u16, companion4.c()), uo3.c.a(6.0f)), QUIToken.color$default("fill_standard_primary")), null, null, ComposableSingletons$QQFTFileSkeletonItemKt.f138lambda4, composer5, 3080, 6);
                                ColumnKt.a(ComposeLayoutPropUpdaterKt.n(nVar4.a(nVar4.b(companion3, companion4.c()), 1.0f), 12.0f, 0.0f, 0.0f, 0.0f, 14, null), null, null, null, ComposableSingletons$QQFTFileSkeletonItemKt.f141lambda7, composer5, 24584, 14);
                                if (!k.a(c.f117352a)) {
                                    composer5.startReplaceableGroup(-1745795534);
                                    BoxKt.a(ModifiersKt.w(nVar4.b(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion3, 56.0f), f17), companion4.c()), QUIToken.color$default("overlay_standard_secondary")), null, null, ComposableSingletons$QQFTFileSkeletonItemKt.f142lambda8, composer5, 3080, 6);
                                    composer5.endReplaceableGroup();
                                } else {
                                    composer5.startReplaceableGroup(-1745795081);
                                    BoxKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion3, 16.0f), f17), null, null, null, composer5, 8, 14);
                                    composer5.endReplaceableGroup();
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 196616, 30);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 196616, 30);
        if (i3 != qQFlashTransferViewModel.feedListViewModel.feedCardViewModelList.size() - 1) {
            RowKt.a(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.w(companion, cVar.g().getPageData().m()), 0.0f, 0.0f, 16.0f, 0.0f, 11, null), null, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1623288153, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileSkeletonItemKt$listSkeletonView$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(n nVar, Composer composer2, Integer num) {
                    int i17;
                    n nVar2 = nVar;
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 14) == 0) {
                        i17 = (composer3.changed(nVar2) ? 4 : 2) | intValue;
                    } else {
                        i17 = intValue;
                    }
                    if ((i17 & 91) == 18 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1623288153, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.listSkeletonView.<anonymous> (QQFTFileSkeletonItem.kt:118)");
                        }
                        i.Companion companion2 = i.INSTANCE;
                        SurfaceKt.a(ModifiersKt.R(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion2, (f16 * 0.75f) + 62), 0.5f), false), null, null, null, ComposableSingletons$QQFTFileSkeletonItemKt.f143lambda9, composer3, 24584, 14);
                        SurfaceKt.a(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(nVar2.a(companion2, 1.0f), 0.5f), QUIToken.color$default("border_standard")), null, null, null, ComposableSingletons$QQFTFileSkeletonItemKt.f135lambda10, composer3, 24584, 14);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 196616, 30);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileSkeletonItemKt$listSkeletonView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTFileSkeletonItemKt.listSkeletonView(i3, qQFlashTransferViewModel, f16, composer2, i16 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
