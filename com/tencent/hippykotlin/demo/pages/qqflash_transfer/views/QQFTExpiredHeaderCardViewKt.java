package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheModule;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTExpiredHeaderCardVM;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTExpiredHeaderCardViewKt {
    public static final void QQFTExpiredHeaderCardView(final QQFTExpiredHeaderCardVM qQFTExpiredHeaderCardVM, final boolean z16, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(2125897591);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2125897591, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTExpiredHeaderCardView (QQFTExpiredHeaderCardView.kt:32)");
        }
        if (z16) {
            startRestartGroup.startReplaceableGroup(-1125234788);
            expiredHeaderCard(qQFTExpiredHeaderCardVM, startRestartGroup, 8);
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.startReplaceableGroup(-1125234741);
            downloadedHeaderCard(qQFTExpiredHeaderCardVM, startRestartGroup, 8);
            startRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTExpiredHeaderCardViewKt$QQFTExpiredHeaderCardView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTExpiredHeaderCardViewKt.QQFTExpiredHeaderCardView(QQFTExpiredHeaderCardVM.this, z16, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void downloadedHeaderCard(final QQFTExpiredHeaderCardVM qQFTExpiredHeaderCardVM, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(397516620);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(397516620, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.downloadedHeaderCard (QQFTExpiredHeaderCardView.kt:41)");
        }
        RowKt.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, c.f117352a.g().getPageData().m()), 48), QUIToken.color$default("bg_bottom_light")), a.f339245a.b(), Alignment.Vertical.CenterVertically, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -668403346, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTExpiredHeaderCardViewKt$downloadedHeaderCard$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(n nVar, Composer composer2, Integer num) {
                int i16;
                n nVar2 = nVar;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 14) == 0) {
                    i16 = (composer3.changed(nVar2) ? 4 : 2) | intValue;
                } else {
                    i16 = intValue;
                }
                if ((i16 & 91) == 18 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-668403346, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.downloadedHeaderCard.<anonymous> (QQFTExpiredHeaderCardView.kt:48)");
                    }
                    i.Companion companion = i.INSTANCE;
                    TextKt.a("\u5df2\u4e0b\u8f7d\u6587\u4ef6", ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.A(companion), 16.0f, 0.0f, 0.0f, 0.0f, 14, null), null, QUIToken.color$default("text_primary"), Float.valueOf(16), null, bp3.c.INSTANCE.f(), null, null, null, null, Float.valueOf(22), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601606, 48, 0, 134215588);
                    SpacerKt.a(nVar2.a(companion, 1.0f), composer3, 8, 0);
                    QQFTExpiredHeaderCardViewKt.QQFTListModeButton(QQFTExpiredHeaderCardVM.this.f114260vm, composer3, 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 197064, 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTExpiredHeaderCardViewKt$downloadedHeaderCard$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTExpiredHeaderCardViewKt.downloadedHeaderCard(QQFTExpiredHeaderCardVM.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void expiredHeaderCard(final QQFTExpiredHeaderCardVM qQFTExpiredHeaderCardVM, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-447014806);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-447014806, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.expiredHeaderCard (QQFTExpiredHeaderCardView.kt:65)");
        }
        final float f16 = 52;
        RowKt.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, c.f117352a.g().getPageData().m()), f16), QUIToken.color$default("bg_bottom_light")), a.f339245a.b(), Alignment.Vertical.CenterVertically, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -249249400, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTExpiredHeaderCardViewKt$expiredHeaderCard$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(n nVar, Composer composer2, Integer num) {
                int i16;
                n nVar2 = nVar;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 14) == 0) {
                    i16 = (composer3.changed(nVar2) ? 4 : 2) | intValue;
                } else {
                    i16 = intValue;
                }
                if ((i16 & 91) == 18 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-249249400, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.expiredHeaderCard.<anonymous> (QQFTExpiredHeaderCardView.kt:72)");
                    }
                    i.Companion companion = i.INSTANCE;
                    TextKt.a("\u5df2\u8fc7\u671f\u6587\u4ef6", ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.A(companion), 16.0f, 0.0f, 0.0f, 0.0f, 14, null), null, QUIToken.color$default("text_primary"), Float.valueOf(16), null, bp3.c.INSTANCE.f(), null, null, null, null, Float.valueOf(22), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601606, 48, 0, 134215588);
                    SpacerKt.a(nVar2.a(companion, 1.0f), composer3, 8, 0);
                    i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.B(companion), f16), 0.0f, 0.0f, 16.0f, 0.0f, 11, null);
                    final QQFTExpiredHeaderCardVM qQFTExpiredHeaderCardVM2 = qQFTExpiredHeaderCardVM;
                    i d16 = ViewEventPropUpdaterKt.d(n3, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTExpiredHeaderCardViewKt$expiredHeaderCard$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ClickParams clickParams) {
                            QQFTExpiredHeaderCardVM.this.f114260vm.showExpiredList.setValue(Boolean.valueOf(!r3.getValue().booleanValue()));
                            QQFTExpiredHeaderCardVM.this.f114260vm.handleExpiredList();
                            KLog kLog = KLog.INSTANCE;
                            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("showExpiredList after click:");
                            m3.append(QQFTExpiredHeaderCardVM.this.f114260vm.showExpiredList.getValue().booleanValue());
                            kLog.d("QQFTExpiredHeaderCardView", m3.toString());
                            return Unit.INSTANCE;
                        }
                    }, 3, null);
                    a.e b16 = a.f339245a.b();
                    Alignment.Vertical vertical = Alignment.Vertical.CenterVertically;
                    final QQFTExpiredHeaderCardVM qQFTExpiredHeaderCardVM3 = qQFTExpiredHeaderCardVM;
                    RowKt.a(d16, b16, vertical, null, null, ComposableLambdaKt.composableLambda(composer3, 750724646, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTExpiredHeaderCardViewKt$expiredHeaderCard$1.2
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(n nVar3, Composer composer4, Integer num2) {
                            String str;
                            h color$default;
                            QUIToken qUIToken;
                            h color$default2;
                            String str2;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(750724646, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.expiredHeaderCard.<anonymous>.<anonymous> (QQFTExpiredHeaderCardView.kt:94)");
                                }
                                i.Companion companion2 = i.INSTANCE;
                                i A = ComposeLayoutPropUpdaterKt.A(companion2);
                                if (QQFTExpiredHeaderCardVM.this.f114260vm.showExpiredList.getValue().booleanValue()) {
                                    str = "\u6536\u8d77";
                                } else {
                                    str = "\u5c55\u5f00";
                                }
                                float f17 = 16;
                                float f18 = 20;
                                if (QQFTExpiredHeaderCardVM.this.f114260vm.showExpiredList.getValue().booleanValue()) {
                                    color$default = QUIToken.color$default("text_link");
                                } else {
                                    color$default = QUIToken.color$default("text_primary");
                                }
                                TextKt.a(str, A, null, color$default, Float.valueOf(f17), null, bp3.c.INSTANCE.e(), null, null, null, null, Float.valueOf(f18), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 1601600, 48, 0, 134215588);
                                i n16 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(companion2, f17), 2, 0.0f, 0.0f, 0.0f, 14, null);
                                if (QQFTExpiredHeaderCardVM.this.f114260vm.showExpiredList.getValue().booleanValue()) {
                                    qUIToken = QUIToken.INSTANCE;
                                    color$default2 = QUIToken.color$default("text_link");
                                    str2 = "chevron_up";
                                } else {
                                    qUIToken = QUIToken.INSTANCE;
                                    color$default2 = QUIToken.color$default("text_primary");
                                    str2 = "chevron_down";
                                }
                                ImageKt.a(qUIToken.image(str2, color$default2), null, null, null, null, n16, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer5, 262144, 0, 0, 2097118);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 197064, 24);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 197064, 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTExpiredHeaderCardViewKt$expiredHeaderCard$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTExpiredHeaderCardViewKt.expiredHeaderCard(QQFTExpiredHeaderCardVM.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void QQFTListModeButton(final QQFlashTransferViewModel qQFlashTransferViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-999870785);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-999870785, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTListModeButton (QQFTExpiredHeaderCardView.kt:115)");
        }
        BoxKt.a(ViewEventPropUpdaterKt.d(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 32), 0.0f, 0.0f, 16.0f, 0.0f, 11, null), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTExpiredHeaderCardViewKt$QQFTListModeButton$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                QQFlashTransferViewModel.this.isGridMode.setValue(Boolean.valueOf(!r5.getValue().booleanValue()));
                c cVar = c.f117352a;
                CacheModule cacheModule = (CacheModule) cVar.g().acquireModule("HRCacheModule");
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("qq_flash_transfer_list_mode");
                m3.append(cVar.g().getPageData().n().q("uin", ""));
                cacheModule.setInt(m3.toString(), Integer.valueOf(!QQFlashTransferViewModel.this.isGridMode.getValue().booleanValue() ? 1 : 0));
                return Unit.INSTANCE;
            }
        }, 3, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1571640825, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTExpiredHeaderCardViewKt$QQFTListModeButton$2
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                int i16;
                String image;
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
                        ComposerKt.traceEventStart(1571640825, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTListModeButton.<anonymous> (QQFTExpiredHeaderCardView.kt:125)");
                    }
                    i a16 = bVar2.a(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), Alignment.CenterEnd);
                    QUIToken qUIToken = QUIToken.INSTANCE;
                    h color$default = QUIToken.color$default("icon_primary");
                    if (QQFlashTransferViewModel.this.isGridMode.getValue().booleanValue()) {
                        image = qUIToken.image("ordered_list_new", null);
                    } else {
                        image = qUIToken.image("ordered_grid_new", null);
                    }
                    ImageKt.a(image, null, null, null, null, a16, null, 0, null, null, null, null, null, null, null, null, null, null, null, color$default, null, composer3, 262144, 1073741824, 0, 1572830);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTExpiredHeaderCardViewKt$QQFTListModeButton$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTExpiredHeaderCardViewKt.QQFTListModeButton(QQFlashTransferViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
