package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardAnimationViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.da_tong_report.DTReportConstKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.modifer_ext.ModifierExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.module.QQFlashTransferKuiklyModule;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTBorderImageKt;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTCenterUIConfig;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemProcessViewKt;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.center.QQFTCenterFileSetCardVM;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.w;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.activity.photo.MediaDBValues;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
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
import com.tencent.ntcompose.material.DividerKt;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.an;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.material.h;
import defpackage.j;
import defpackage.k;
import it0.f;
import it0.g;
import java.util.List;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.UnsignedKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import uo3.c;
import ws3.br;
import ws3.eo;
import ws3.eq;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTCenterFileSetCardViewKt {
    public static final void jumpToFileSetDetail(QQFTCenterFileSetCardVM qQFTCenterFileSetCardVM, String str) {
        String str2;
        KLog.INSTANCE.d("QQFTCenterFileSetCardView", "onClick QQFTCenterFileSetCardView");
        if (qQFTCenterFileSetCardVM.f114262vm.showTopEmptyCard) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        StringBuilder a16 = j.a("mqqapi://kuikly/open?version=1&src_type=app&page_name=QQTransferDownloadActivity&local_bundle_name=nearbypro&qui_token_theme_mode=0&use_host_display_metrics=1&autorotate=1&file_set_id=", str, "&scene_type=7&entry_id=", "1", "&has_send_entrance=");
        a16.append(str2);
        String sb5 = a16.toString();
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.openPage$default(sb5, false, 6);
    }

    public static final void QQFTCenterFileSetCardView(final QQFTCenterFileSetCardVM qQFTCenterFileSetCardVM, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(1257911119);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1257911119, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFileSetCardView (QQFTCenterFileSetCardView.kt:65)");
        }
        if (qQFTCenterFileSetCardVM.f114262vm.getFilterCardVM().listGridMode.getValue().booleanValue()) {
            startRestartGroup.startReplaceableGroup(1315709077);
            gridCardView(qQFTCenterFileSetCardVM, startRestartGroup, 8);
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.startReplaceableGroup(1315709119);
            listCardView(qQFTCenterFileSetCardVM, startRestartGroup, 8);
            startRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFileSetCardViewKt$QQFTCenterFileSetCardView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTCenterFileSetCardViewKt.QQFTCenterFileSetCardView(QQFTCenterFileSetCardVM.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void coverView(final QQFTCenterFileSetCardVM qQFTCenterFileSetCardVM, final w wVar, final String str, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(1950533347);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1950533347, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.coverView (QQFTCenterFileSetCardView.kt:214)");
        }
        BoxKt.a(ComposeLayoutPropUpdaterKt.v(i.INSTANCE, wVar.getWidth(), wVar.getHeight()), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1922834665, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFileSetCardViewKt$coverView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                String str2;
                String str3;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1922834665, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.coverView.<anonymous> (QQFTCenterFileSetCardView.kt:218)");
                    }
                    if (UnsignedKt.ulongCompare(QQFTCenterFileSetCardVM.this.fileSet.f446189c, ULong.m648constructorimpl(1L)) > 0) {
                        composer3.startReplaceableGroup(1025787010);
                        i.Companion companion = i.INSTANCE;
                        i v3 = ComposeLayoutPropUpdaterKt.v(companion, wVar.getWidth() - 1.0f, wVar.getHeight() - 1.0f);
                        h.Companion companion2 = h.INSTANCE;
                        ImageKt.a(null, null, null, null, null, v3, null, companion2.a(), null, null, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAWQAAAFIBAMAAACVW5leAAAACXBIWXMAABYlAAAWJQFJUiTwAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAPUExURW54m0dwTHB4l36FmnN6my+enswAAAAFdFJOUzMAQEYY4T858gAAAchJREFUeNrt2NFtwjAUQFE3YQBcMkAIDEDjDECA/Wcqbb+p1FTIee258gBH1vvwc8rhSsjIyMjIyMjIyMjIyMjIyM8nn4cKbX5DriIehuNycjdUal5Mfq1F3i8mN7XI/WLyUK2l5K4eeUZGRkZ+PvlWrflfPT6RkaOSz2mFbb4jX4ZVNj0mb4eV9vKQfFkr+fiQPKy2+QF5i/yklTut4Q8AGRk5ILni4vSTxcp7GRm5JrlLgZo/yF2J1DjfydfSN/faZuW1n6dMOXWljzQYTZnTbkyhOrylto9FbqfUpmCNqUQjF2RkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRk5FWSD/HIbR9L3JzS9RSL3E5pG2yYyz7lwxjqksec8q6UQ5hK2d/J+VwCdcwf5NzdwjTnL3KwkJGRkZGRkZGRkZGRkf8++R1kKs0hPnxCCwAAAABJRU5ErkJggg", null, null, null, null, null, null, null, null, null, null, composer3, 12845056, 6, 0, 2095967);
                        String str4 = QQFTCenterFileSetCardVM.this.fileSet.f446191e.f446332a;
                        String str5 = str4.length() == 0 ? str : str4;
                        if (QQFTCenterFileSetCardVM.this.fileSet.f446201o == 6) {
                            str3 = "data:image/png;base64,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";
                        } else {
                            str3 = str;
                        }
                        int a16 = companion2.a();
                        float width = wVar.getWidth() * 4.0f;
                        QQFTCenterUIConfig qQFTCenterUIConfig = QQFTCenterUIConfig.INSTANCE;
                        float width2 = (wVar.getWidth() * 1.0f) / 178.0f;
                        com.tencent.kuikly.core.base.h hVar = new com.tencent.kuikly.core.base.h(0L, 0.03f);
                        i h16 = ComposeLayoutPropUpdaterKt.h(companion, 0.0f, 1, null);
                        float height = wVar.getHeight() * QQFTCenterUIConfig.topMarginScale;
                        float height2 = wVar.getHeight() * QQFTCenterUIConfig.bottomMarginScale;
                        float f16 = QQFTCenterUIConfig.leftRightMarginScale;
                        QQFTBorderImageKt.m123QQFTBorderImageajXzr8(str3, a16, width / 178.0f, width2, hVar, null, ComposeLayoutPropUpdaterKt.m(h16, wVar.getWidth() * f16, height, wVar.getWidth() * f16, height2), str5, composer3, 2129968, 32);
                        composer3.endReplaceableGroup();
                    } else {
                        composer3.startReplaceableGroup(1025788262);
                        String str6 = QQFTCenterFileSetCardVM.this.fileSet.f446191e.f446332a;
                        String str7 = str6.length() == 0 ? str : str6;
                        if (QQFTCenterFileSetCardVM.this.fileSet.f446201o == 6) {
                            str2 = "data:image/png;base64,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";
                        } else {
                            str2 = str;
                        }
                        int a17 = h.INSTANCE.a();
                        i h17 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                        float width3 = wVar.getWidth() * 4.0f;
                        QQFTCenterUIConfig qQFTCenterUIConfig2 = QQFTCenterUIConfig.INSTANCE;
                        i q16 = ModifiersKt.q(h17, c.a(width3 / 178.0f));
                        float height3 = wVar.getHeight() * QQFTCenterUIConfig.bottomMarginScale;
                        float f17 = QQFTCenterUIConfig.singleImageLeftRightScale;
                        ImageKt.a(str2, null, str7, null, null, ComposeLayoutPropUpdaterKt.m(q16, wVar.getWidth() * f17, 0.0f, wVar.getWidth() * f17, height3), null, a17, null, null, null, null, null, null, null, null, null, null, null, null, null, composer3, 12845056, 0, 0, 2096986);
                        composer3.endReplaceableGroup();
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFileSetCardViewKt$coverView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTCenterFileSetCardViewKt.coverView(QQFTCenterFileSetCardVM.this, wVar, str, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void gridCardView(final QQFTCenterFileSetCardVM qQFTCenterFileSetCardVM, Composer composer, final int i3) {
        String str;
        String a16;
        String a17;
        Composer startRestartGroup = composer.startRestartGroup(-1375227506);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1375227506, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.gridCardView (QQFTCenterFileSetCardView.kt:74)");
        }
        final br brVar = qQFTCenterFileSetCardVM.fileSet;
        i.Companion companion = i.INSTANCE;
        i y16 = ModifiersKt.y(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.w(ModifiersKt.b(companion, qQFTCenterFileSetCardVM.shouldAlpha() ? 0.3f : 1.0f), QQFTCenterUIConfig.INSTANCE.getDoubleCardWidth())), ModifiersKt.b(companion, qQFTCenterFileSetCardVM.shouldAlpha() ? 0.2f : 0.5f), ModifiersKt.b(companion, qQFTCenterFileSetCardVM.shouldAlpha() ? 0.3f : 1.0f), 0, false, 12, null);
        if (k.a(com.tencent.kuikly.core.manager.c.f117352a)) {
            str = "0S200MNJT807V3GE";
        } else {
            str = "0M2003OIIM08YV9M";
        }
        e dTBaseParams = DTReportConstKt.getDTBaseParams(str);
        dTBaseParams.v("file_set_id", brVar.f446187a);
        a16 = f.a(brVar.f446189c, 10);
        dTBaseParams.v("files_number", a16);
        a17 = it0.e.a(brVar.f446190d, 10);
        dTBaseParams.v(MediaDBValues.FILESIZE, a17);
        Unit unit = Unit.INSTANCE;
        ColumnKt.a(ViewEventPropUpdaterKt.d(ModifierExtKt.elementVR(y16, "em_bas_file_set", dTBaseParams), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFileSetCardViewKt$gridCardView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                int currentFileSetStatus = QQFTCenterFileSetCardVM.this.currentFileSetStatus();
                if (currentFileSetStatus == 7 || currentFileSetStatus == 4) {
                    QQKuiklyPlatformApi.Companion.qqToast("\u8be5\u95ea\u4f20\u4efb\u52a1\u5df2\u5220\u9664", QToastMode.Warning);
                } else {
                    QQFTCenterFileSetCardViewKt.jumpToFileSetDetail(QQFTCenterFileSetCardVM.this, brVar.f446187a);
                }
                return Unit.INSTANCE;
            }
        }, 3, null), null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -846259593, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFileSetCardViewKt$gridCardView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(d dVar, Composer composer2, Integer num) {
                Object firstOrNull;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-846259593, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.gridCardView.<anonymous> (QQFTCenterFileSetCardView.kt:95)");
                    }
                    QQFTCenterUIConfig qQFTCenterUIConfig = QQFTCenterUIConfig.INSTANCE;
                    w wVar = new w(qQFTCenterUIConfig.getDoubleCardWidth(), (qQFTCenterUIConfig.getDoubleCardWidth() / 178.0f) * 164.0f);
                    QQFTCenterFileSetCardVM qQFTCenterFileSetCardVM2 = QQFTCenterFileSetCardVM.this;
                    firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) brVar.f446191e.f446333b);
                    eq eqVar = (eq) firstOrNull;
                    QQFTCenterFileSetCardViewKt.coverView(qQFTCenterFileSetCardVM2, wVar, eqVar != null ? eqVar.f446358b : null, composer3, 72);
                    composer3.startReplaceableGroup(-492369756);
                    Object rememberedValue = composer3.rememberedValue();
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = GuideBannerCardAnimationViewKt$$ExternalSyntheticOutline0.m(0, null, 2, null, composer3);
                    }
                    composer3.endReplaceableGroup();
                    final MutableState mutableState = (MutableState) rememberedValue;
                    i z16 = ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, qQFTCenterUIConfig.getDoubleCardWidth()));
                    Alignment.Vertical c16 = Alignment.INSTANCE.c();
                    final QQFTCenterFileSetCardVM qQFTCenterFileSetCardVM3 = QQFTCenterFileSetCardVM.this;
                    final br brVar2 = brVar;
                    RowKt.a(z16, null, c16, null, null, ComposableLambdaKt.composableLambda(composer3, 214040853, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFileSetCardViewKt$gridCardView$3.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(n nVar, Composer composer4, Integer num2) {
                            int i16;
                            float doubleCardWidth;
                            String str2;
                            n nVar2 = nVar;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 14) == 0) {
                                i16 = (composer5.changed(nVar2) ? 4 : 2) | intValue2;
                            } else {
                                i16 = intValue2;
                            }
                            if ((i16 & 91) == 18 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(214040853, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.gridCardView.<anonymous>.<anonymous> (QQFTCenterFileSetCardView.kt:105)");
                                }
                                i.Companion companion2 = i.INSTANCE;
                                if (QQFTCenterFileSetCardVM.this.shouldShowShareButton()) {
                                    doubleCardWidth = (QQFTCenterUIConfig.INSTANCE.getDoubleCardWidth() - 30) + 10;
                                } else {
                                    doubleCardWidth = QQFTCenterUIConfig.INSTANCE.getDoubleCardWidth();
                                }
                                float f16 = 8;
                                i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.w(companion2, doubleCardWidth), 0.0f, f16, 0.0f, 0.0f, 13, null);
                                final MutableState<Float> mutableState2 = mutableState;
                                composer5.startReplaceableGroup(1157296644);
                                boolean changed = composer5.changed(mutableState2);
                                Object rememberedValue2 = composer5.rememberedValue();
                                if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue2 = new Function1<w, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFileSetCardViewKt$gridCardView$3$1$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(w wVar2) {
                                            mutableState2.setValue(Float.valueOf(wVar2.getHeight()));
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composer5.updateRememberedValue(rememberedValue2);
                                }
                                composer5.endReplaceableGroup();
                                TextKt.a(brVar2.f446188b, ViewEventPropUpdaterKt.m(n3, (Function1) rememberedValue2), null, QUIToken.color$default("text_primary"), Float.valueOf(16), null, bp3.c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.e()), Float.valueOf(22), null, null, null, null, an.d(an.INSTANCE.c()), null, 2, null, null, null, null, null, null, null, false, composer5, 1601600, 102236208, 0, 133886884);
                                SpacerKt.a(nVar2.a(companion2, 1.0f), composer5, 8, 0);
                                if (QQFTCenterFileSetCardVM.this.shouldShowShareButton()) {
                                    i n16 = ComposeLayoutPropUpdaterKt.n(nVar2.b(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion2, 30), mutableState.getValue().floatValue()), Alignment.Vertical.Top), -10, f16, 0.0f, 0.0f, 12, null);
                                    if (k.a(com.tencent.kuikly.core.manager.c.f117352a)) {
                                        str2 = "0S200MNJT807V3GE";
                                    } else {
                                        str2 = "0M2003OIIM08YV9M";
                                    }
                                    i elementVR = ModifierExtKt.elementVR(n16, WinkDaTongReportConstant.ElementId.EM_BAS_MORE, DTReportConstKt.getDTBaseParams(str2));
                                    final br brVar3 = brVar2;
                                    BoxKt.a(ViewEventPropUpdaterKt.d(elementVR, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFileSetCardViewKt.gridCardView.3.1.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ClickParams clickParams) {
                                            br brVar4 = br.this;
                                            KLog.INSTANCE.d("QQFTCenterFileSetCardView", "onClick \u66f4\u591a");
                                            QQFlashTransferKuiklyModule.Companion.getInstance().shareFileSet(brVar4, QQFTCenterFileSetCardViewKt$showSharePanel$1.INSTANCE);
                                            return Unit.INSTANCE;
                                        }
                                    }, 3, null), null, null, ComposableSingletons$QQFTCenterFileSetCardViewKt.f152lambda1, composer5, 3080, 6);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 196616, 26);
                    QQFTCenterFileSetCardViewKt.statusView(qQFTCenterUIConfig.getDoubleCardWidth(), 2, QQFTCenterFileSetCardVM.this, composer3, PlayerResources.ViewId.GET_MORE_TOGGLE_AREA);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 24584, 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFileSetCardViewKt$gridCardView$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTCenterFileSetCardViewKt.gridCardView(QQFTCenterFileSetCardVM.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void listCardView(final QQFTCenterFileSetCardVM qQFTCenterFileSetCardVM, Composer composer, final int i3) {
        String str;
        String a16;
        String a17;
        Composer startRestartGroup = composer.startRestartGroup(43455206);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(43455206, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.listCardView (QQFTCenterFileSetCardView.kt:148)");
        }
        final float f16 = 48;
        final br brVar = qQFTCenterFileSetCardVM.fileSet;
        i b16 = ModifiersKt.b(i.INSTANCE, qQFTCenterFileSetCardVM.shouldAlpha() ? 0.3f : 1.0f);
        com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
        i w3 = ModifiersKt.w(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(b16, cVar.g().getPageData().m()), QQFTCenterUIConfig.listCardHeight), 16.0f, 0.0f, 16.0f, 0.0f, 10, null), QUIToken.color$default("overlay_surface_bg"));
        if (k.a(cVar)) {
            str = "0S200MNJT807V3GE";
        } else {
            str = "0M2003OIIM08YV9M";
        }
        e dTBaseParams = DTReportConstKt.getDTBaseParams(str);
        dTBaseParams.v("file_set_id", brVar.f446187a);
        a16 = it0.h.a(brVar.f446189c, 10);
        dTBaseParams.v("files_number", a16);
        a17 = g.a(brVar.f446190d, 10);
        dTBaseParams.v(MediaDBValues.FILESIZE, a17);
        Unit unit = Unit.INSTANCE;
        BoxKt.a(ViewEventPropUpdaterKt.d(ModifierExtKt.elementVR(w3, "em_bas_file_set", dTBaseParams), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFileSetCardViewKt$listCardView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                int currentFileSetStatus = QQFTCenterFileSetCardVM.this.currentFileSetStatus();
                if (currentFileSetStatus == 7 || currentFileSetStatus == 4) {
                    QQKuiklyPlatformApi.Companion.qqToast("\u8be5\u95ea\u4f20\u4efb\u52a1\u5df2\u5220\u9664", QToastMode.Warning);
                } else {
                    QQFTCenterFileSetCardViewKt.jumpToFileSetDetail(QQFTCenterFileSetCardVM.this, brVar.f446187a);
                }
                return Unit.INSTANCE;
            }
        }, 3, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1680000480, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFileSetCardViewKt$listCardView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        ComposerKt.traceEventStart(-1680000480, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.listCardView.<anonymous> (QQFTCenterFileSetCardView.kt:166)");
                    }
                    Alignment.Vertical c16 = Alignment.INSTANCE.c();
                    i.Companion companion = i.INSTANCE;
                    i h16 = ComposeLayoutPropUpdaterKt.h(companion, 0.0f, 1, null);
                    final float f17 = f16;
                    final QQFTCenterFileSetCardVM qQFTCenterFileSetCardVM2 = qQFTCenterFileSetCardVM;
                    final br brVar2 = brVar;
                    RowKt.a(h16, null, c16, null, null, ComposableLambdaKt.composableLambda(composer3, 1517350718, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFileSetCardViewKt$listCardView$3.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(n nVar, Composer composer4, Integer num2) {
                            Object firstOrNull;
                            String str2;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1517350718, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.listCardView.<anonymous>.<anonymous> (QQFTCenterFileSetCardView.kt:169)");
                                }
                                float f18 = f17;
                                w wVar = new w(f18, f18);
                                QQFTCenterFileSetCardVM qQFTCenterFileSetCardVM3 = qQFTCenterFileSetCardVM2;
                                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) brVar2.f446191e.f446333b);
                                eq eqVar = (eq) firstOrNull;
                                QQFTCenterFileSetCardViewKt.coverView(qQFTCenterFileSetCardVM3, wVar, eqVar != null ? eqVar.f446358b : null, composer5, 72);
                                com.tencent.kuikly.core.manager.c cVar2 = com.tencent.kuikly.core.manager.c.f117352a;
                                float f19 = 12;
                                float f26 = 32;
                                final float m3 = (((cVar2.g().getPageData().m() - 32.0f) - f17) - f19) - f26;
                                i.Companion companion2 = i.INSTANCE;
                                i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion2, m3), f17), f19, 0.0f, 0.0f, 0.0f, 14, null);
                                a.e b17 = a.f339245a.b();
                                final br brVar3 = brVar2;
                                final QQFTCenterFileSetCardVM qQFTCenterFileSetCardVM4 = qQFTCenterFileSetCardVM2;
                                ColumnKt.a(n3, b17, null, null, ComposableLambdaKt.composableLambda(composer5, 1745062055, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFileSetCardViewKt.listCardView.3.1.1
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
                                                ComposerKt.traceEventStart(1745062055, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.listCardView.<anonymous>.<anonymous>.<anonymous> (QQFTCenterFileSetCardView.kt:177)");
                                            }
                                            i.Companion companion3 = i.INSTANCE;
                                            i j3 = ComposeLayoutPropUpdaterKt.j(companion3, 0.0f, 1, null);
                                            TextKt.a(br.this.f446188b, j3, null, QUIToken.color$default("text_primary"), Float.valueOf(17), null, bp3.c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.e()), Float.valueOf(22), null, null, null, null, an.d(an.INSTANCE.c()), null, 1, null, null, null, null, null, null, null, false, composer7, 1601600, 102236208, 0, 133886884);
                                            SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion3, 2.0f), composer7, 8, 0);
                                            QQFTCenterFileSetCardViewKt.statusView(m3, 0.0f, qQFTCenterFileSetCardVM4, composer7, PlayerResources.ViewId.GET_MORE_TOGGLE_AREA);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 24648, 12);
                                if (qQFTCenterFileSetCardVM2.shouldShowShareButton()) {
                                    i u16 = ComposeLayoutPropUpdaterKt.u(companion2, f26);
                                    if (k.a(cVar2)) {
                                        str2 = "0S200MNJT807V3GE";
                                    } else {
                                        str2 = "0M2003OIIM08YV9M";
                                    }
                                    i elementVR = ModifierExtKt.elementVR(u16, WinkDaTongReportConstant.ElementId.EM_BAS_MORE, DTReportConstKt.getDTBaseParams(str2));
                                    final br brVar4 = brVar2;
                                    BoxKt.a(ViewEventPropUpdaterKt.d(elementVR, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFileSetCardViewKt.listCardView.3.1.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ClickParams clickParams) {
                                            br brVar5 = br.this;
                                            KLog.INSTANCE.d("QQFTCenterFileSetCardView", "onClick \u66f4\u591a");
                                            QQFlashTransferKuiklyModule.Companion.getInstance().shareFileSet(brVar5, QQFTCenterFileSetCardViewKt$showSharePanel$1.INSTANCE);
                                            return Unit.INSTANCE;
                                        }
                                    }, 3, null), null, null, ComposableSingletons$QQFTCenterFileSetCardViewKt.f153lambda2, composer5, 3080, 6);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 196616, 26);
                    DividerKt.a(bVar2.a(ComposeLayoutPropUpdaterKt.k(ModifiersKt.d(ComposeLayoutPropUpdaterKt.n(companion, f16 + 12, 0.0f, 0.0f, 0.0f, 14, null), QUIToken.color$default("border_standard")), (float) 0.5d), Alignment.BottomStart), null, 0.0f, 0.0f, 0.0f, composer3, 8, 30);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFileSetCardViewKt$listCardView$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTCenterFileSetCardViewKt.listCardView(QQFTCenterFileSetCardVM.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void statusView(final float f16, final float f17, final QQFTCenterFileSetCardVM qQFTCenterFileSetCardVM, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-519216342);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-519216342, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.statusView (QQFTCenterFileSetCardView.kt:261)");
        }
        RowKt.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, f16)), 0.0f, f17, 0.0f, 0.0f, 13, null), null, Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -100905144, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFileSetCardViewKt$statusView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            /* JADX WARN: Code restructure failed: missing block: B:24:0x0092, code lost:
            
                if (r2 == 2) goto L27;
             */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:28:0x009f  */
            /* JADX WARN: Removed duplicated region for block: B:41:0x037d  */
            /* JADX WARN: Removed duplicated region for block: B:45:0x01a4  */
            @Override // kotlin.jvm.functions.Function3
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Unit invoke(n nVar, Composer composer2, Integer num) {
                boolean z16;
                float f18;
                i.Companion companion;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-100905144, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.statusView.<anonymous> (QQFTCenterFileSetCardView.kt:267)");
                    }
                    composer3.startReplaceableGroup(-492369756);
                    Object rememberedValue = composer3.rememberedValue();
                    Composer.Companion companion2 = Composer.INSTANCE;
                    if (rememberedValue == companion2.getEmpty()) {
                        rememberedValue = GuideBannerCardAnimationViewKt$$ExternalSyntheticOutline0.m(0.0f, null, 2, null, composer3);
                    }
                    composer3.endReplaceableGroup();
                    final MutableState mutableState = (MutableState) rememberedValue;
                    QQFTCenterFileSetCardVM qQFTCenterFileSetCardVM2 = QQFTCenterFileSetCardVM.this;
                    if (qQFTCenterFileSetCardVM2.currentFileSetStatus() == 2) {
                        int i16 = qQFTCenterFileSetCardVM2.fileSet.f446203q;
                        if (qQFTCenterFileSetCardVM2.simpleStatusInfo.getValue() != null) {
                            eo value = qQFTCenterFileSetCardVM2.simpleStatusInfo.getValue();
                            Intrinsics.checkNotNull(value);
                            i16 = value.f446351i;
                        }
                        if (i16 != 2) {
                            int i17 = qQFTCenterFileSetCardVM2.fileSet.f446202p;
                            if (qQFTCenterFileSetCardVM2.simpleStatusInfo.getValue() != null) {
                                eo value2 = qQFTCenterFileSetCardVM2.simpleStatusInfo.getValue();
                                Intrinsics.checkNotNull(value2);
                                i17 = value2.f446350h;
                            }
                        }
                        z16 = true;
                        if (!z16) {
                            composer3.startReplaceableGroup(1810897969);
                            QQFTCenterFileSetCardVM qQFTCenterFileSetCardVM3 = QQFTCenterFileSetCardVM.this;
                            eo value3 = qQFTCenterFileSetCardVM3.simpleStatusInfo.getValue();
                            long j3 = value3 != null ? value3.f446345c : 0L;
                            eo value4 = qQFTCenterFileSetCardVM3.simpleStatusInfo.getValue();
                            ULong m642boximpl = value4 != null ? ULong.m642boximpl(value4.f446347e) : null;
                            QQFTFileItemProcessViewKt.QQFTFileItemProcessView((m642boximpl == null || UnsignedKt.ulongCompare(m642boximpl.getData(), ULong.m648constructorimpl(0L)) <= 0) ? 0.0f : ((float) UnsignedKt.ulongToDouble(j3)) / ((float) UnsignedKt.ulongToDouble(m642boximpl.getData())), 12.0f, QUIToken.color$default("icon_tertiary"), QUIToken.color$default("icon_tertiary"), 0.0f, composer3, 4656, 16);
                            TextKt.a(QQFTCenterFileSetCardVM.this.statusData().getFirst() + QQFTCenterFileSetCardVM.this.statusData().getThird(), ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null)), 1, 0.0f, 0.0f, 0.0f, 14, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(12), null, bp3.c.INSTANCE.e(), null, Float.valueOf(0.0f), null, ai.f(ai.INSTANCE.e()), Float.valueOf(17), null, null, null, null, an.d(an.INSTANCE.c()), null, 1, null, null, null, null, null, null, null, false, composer3, 102264896, 102236208, 0, 133886628);
                            composer3.endReplaceableGroup();
                        } else {
                            composer3.startReplaceableGroup(1810898733);
                            float f19 = 1;
                            float floatValue = ((f16 - ((Number) mutableState.getValue()).floatValue()) - (QQFTCenterFileSetCardVM.this.statusData().getSecond().length() > 0 ? 12 : 0.0f)) - f19;
                            i.Companion companion3 = i.INSTANCE;
                            i z17 = ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.x(companion3, 0.0f, floatValue));
                            String first = QQFTCenterFileSetCardVM.this.statusData().getFirst();
                            com.tencent.kuikly.core.base.h color$default = QUIToken.color$default("text_secondary");
                            float f26 = 12;
                            float f27 = 17;
                            ai.Companion companion4 = ai.INSTANCE;
                            int e16 = companion4.e();
                            c.Companion companion5 = bp3.c.INSTANCE;
                            TextKt.a(first, z17, null, color$default, Float.valueOf(f26), null, companion5.e(), null, Float.valueOf(0.0f), null, ai.f(e16), Float.valueOf(f27), null, null, null, null, an.d(an.INSTANCE.c()), null, 1, null, null, null, null, null, null, null, false, composer3, 102264896, 102236208, 0, 133886628);
                            Composer composer4 = composer3;
                            composer4.startReplaceableGroup(1810899411);
                            if (QQFTCenterFileSetCardVM.this.statusData().getSecond().length() > 0) {
                                f18 = f26;
                                ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion3, f26), null, h.INSTANCE.a(), null, null, QQFTCenterFileSetCardVM.this.statusData().getSecond(), null, null, null, null, null, null, null, null, null, null, composer4, 12845056, 0, 0, 2095967);
                                companion = companion3;
                                composer4 = composer4;
                                SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion, f19), composer4, 8, 0);
                            } else {
                                f18 = f26;
                                companion = companion3;
                            }
                            composer4.endReplaceableGroup();
                            i z18 = ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.B(companion));
                            composer4.startReplaceableGroup(1157296644);
                            boolean changed = composer4.changed(mutableState);
                            Object rememberedValue2 = composer4.rememberedValue();
                            if (changed || rememberedValue2 == companion2.getEmpty()) {
                                rememberedValue2 = new Function1<w, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFileSetCardViewKt$statusView$1$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(w wVar) {
                                        mutableState.setValue(Float.valueOf(wVar.getWidth()));
                                        return Unit.INSTANCE;
                                    }
                                };
                                composer4.updateRememberedValue(rememberedValue2);
                            }
                            composer4.endReplaceableGroup();
                            Composer composer5 = composer4;
                            TextKt.a(QQFTCenterFileSetCardVM.this.statusData().getThird(), ViewEventPropUpdaterKt.m(z18, (Function1) rememberedValue2), null, QUIToken.color$default("text_secondary"), Float.valueOf(f18), null, companion5.e(), null, Float.valueOf(0.0f), null, ai.f(companion4.e()), Float.valueOf(f27), null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer5, 102264896, 100663344, 0, 133952164);
                            composer5.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    z16 = false;
                    if (!z16) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 196616, 26);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFileSetCardViewKt$statusView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTCenterFileSetCardViewKt.statusView(f16, f17, qQFTCenterFileSetCardVM, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
