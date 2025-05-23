package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView$contentComments$1$1$7$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.an;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import ws3.br;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTTitleStatusCardViewKt {
    public static final void QQFTTitleStatusCardView(final i iVar, final QQFlashTransferViewModel qQFlashTransferViewModel, Composer composer, final int i3, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(1699889104);
        if ((i16 & 1) != 0) {
            iVar = i.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1699889104, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTTitleStatusCardView (QQFTTitleStatusCardView.kt:43)");
        }
        if (qQFlashTransferViewModel.clusterId.length() > 0) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                return;
            }
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTTitleStatusCardViewKt$QQFTTitleStatusCardView$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    QQFTTitleStatusCardViewKt.QQFTTitleStatusCardView(i.this, qQFlashTransferViewModel, composer2, i3 | 1, i16);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        ColumnKt.a(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, c.f117352a.g().getPageData().m())), 16.0f, 0.0f, 16.0f, 0.0f, 10, null), a.f339245a.b(), Alignment.INSTANCE.e(), null, ComposableLambdaKt.composableLambda(startRestartGroup, -1036086471, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTTitleStatusCardViewKt$QQFTTitleStatusCardView$2
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
                        ComposerKt.traceEventStart(-1036086471, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTTitleStatusCardView.<anonymous> (QQFTTitleStatusCardView.kt:52)");
                    }
                    i.Companion companion = i.INSTANCE;
                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 12.0f), composer3, 8, 0);
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("isLoadingData=");
                    m3.append(QQFlashTransferViewModel.this.isLoadingData.getValue().booleanValue());
                    m3.append(" fileSetIsNull=");
                    NBPFeedCommentsView$contentComments$1$1$7$1$2$1$$ExternalSyntheticOutline0.m(m3, QQFlashTransferViewModel.this.fileSet.getValue() == null, kLog, "QQFTTitleStatusCardView");
                    if (QQFlashTransferViewModel.this.isLoadingData.getValue().booleanValue() && QQFlashTransferViewModel.this.fileSet.getValue() == null) {
                        composer3.startReplaceableGroup(-2020761164);
                        i k3 = ComposeLayoutPropUpdaterKt.k(companion, 45.0f);
                        c cVar = c.f117352a;
                        float f16 = 2;
                        ColumnKt.a(ModifiersKt.c(ModifiersKt.q(ComposeLayoutPropUpdaterKt.w(k3, GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0.m(cVar) / f16), uo3.c.a(10.0f)), QUIToken.color$default("fill_standard_primary")), null, null, null, ComposableSingletons$QQFTTitleStatusCardViewKt.f145lambda1, composer3, 24584, 14);
                        SpacerKt.a(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.k(companion, 4.0f), cVar.g().getPageData().m() / f16), composer3, 8, 0);
                        ColumnKt.a(ModifiersKt.c(ModifiersKt.q(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.k(companion, 18.0f), GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0.m(cVar) / 6), uo3.c.a(6.0f)), QUIToken.color$default("fill_standard_primary")), null, null, null, ComposableSingletons$QQFTTitleStatusCardViewKt.f146lambda2, composer3, 24584, 14);
                        SpacerKt.a(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.k(companion, 12.0f), cVar.g().getPageData().m() / f16), composer3, 8, 0);
                        composer3.endReplaceableGroup();
                    } else {
                        br value = QQFlashTransferViewModel.this.fileSet.getValue();
                        if (value != null && value.f446201o == 6) {
                            composer3.startReplaceableGroup(-2020760521);
                            QQFTFileSetStatusViewKt.QQFTFileSetStatusView(14.0f, 20.0f, QQFlashTransferViewModel.this, 0.0f, false, composer3, PlayerResources.ViewId.EXTENDED_VIEW_IV_USER_PORTRAIT, 24);
                            composer3.endReplaceableGroup();
                        } else if (!QQFlashTransferViewModel.this.isLoadingData.getValue().booleanValue() && QQFlashTransferViewModel.this.fileSet.getValue() == null) {
                            composer3.startReplaceableGroup(-2020758447);
                            composer3.endReplaceableGroup();
                        } else {
                            composer3.startReplaceableGroup(-2020760354);
                            final QQFlashTransferViewModel qQFlashTransferViewModel2 = QQFlashTransferViewModel.this;
                            RowKt.a(null, null, null, null, null, ComposableLambdaKt.composableLambda(composer3, -184702252, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTTitleStatusCardViewKt$QQFTTitleStatusCardView$2.1
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public final Unit invoke(n nVar, Composer composer4, Integer num2) {
                                    int i17;
                                    float f17;
                                    Composer composer5;
                                    n nVar2 = nVar;
                                    Composer composer6 = composer4;
                                    int intValue2 = num2.intValue();
                                    if ((intValue2 & 14) == 0) {
                                        i17 = (composer6.changed(nVar2) ? 4 : 2) | intValue2;
                                    } else {
                                        i17 = intValue2;
                                    }
                                    if ((i17 & 91) == 18 && composer6.getSkipping()) {
                                        composer6.skipToGroupEnd();
                                    } else {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-184702252, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTTitleStatusCardView.<anonymous>.<anonymous> (QQFTTitleStatusCardView.kt:68)");
                                        }
                                        composer6.startReplaceableGroup(-385032155);
                                        if (QQFlashTransferViewModel.this.clusterId.length() > 0) {
                                            f17 = 32.0f;
                                            composer5 = composer6;
                                            ImageKt.a(null, null, null, null, null, nVar2.b(ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(ComposeLayoutPropUpdaterKt.n(i.INSTANCE, 0.0f, 0.0f, 8.0f, 0.0f, 11, null), 32.0f), 4.0f), Alignment.INSTANCE.c()), null, 0, null, null, QQFlashTransferViewModel.this.curFaceUrl.getValue(), null, null, null, null, null, null, null, null, null, null, composer5, 262144, 0, 0, 2096095);
                                        } else {
                                            f17 = 32.0f;
                                            composer5 = composer6;
                                        }
                                        composer5.endReplaceableGroup();
                                        TextKt.a(QQFlashTransferViewModel.this.pageTitle.getValue(), ComposeLayoutPropUpdaterKt.w(nVar2.b(i.INSTANCE, Alignment.INSTANCE.c()), c.f117352a.g().getPageData().m() - f17), null, QUIToken.color$default("text_primary"), Float.valueOf(f17), null, bp3.c.INSTANCE.a(), null, null, null, ai.f(ai.INSTANCE.e()), null, null, null, null, null, an.d(an.INSTANCE.c()), null, 1, null, null, null, null, null, null, null, false, composer5, 1601600, 102236160, 0, 133888932);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }), composer3, 196608, 31);
                            SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 4.0f), composer3, 8, 0);
                            QQFTFileSetStatusViewKt.QQFTFileSetStatusView(14.0f, 20.0f, QQFlashTransferViewModel.this, 0.0f, false, composer3, PlayerResources.ViewId.EXTENDED_VIEW_IV_USER_PORTRAIT, 24);
                            SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 12.0f), composer3, 8, 0);
                            composer3.endReplaceableGroup();
                        }
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 24648, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 == null) {
            return;
        }
        endRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTTitleStatusCardViewKt$QQFTTitleStatusCardView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTTitleStatusCardViewKt.QQFTTitleStatusCardView(i.this, qQFlashTransferViewModel, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }
}
