package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.HalfFloatingLayerKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.HalfFloatingLayerState;
import com.tencent.hippykotlin.demo.pages.foundation.lib.vas_report_utils.VasBusinessReportData$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsViewModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFTShareItem;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$fetchCompressedFileFolder$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQTransferCenterViewModel;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.module.QQFlashTransferKuiklyModule;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.resource.QQFTIconConstant;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTCenterUIConfig;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.luggage.wxa.xd.c0;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.foundation.lazy.layout.LazyDslKt;
import com.tencent.ntcompose.foundation.scheduler.SchedulerKt;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.LazyRowKt;
import com.tencent.ntcompose.material.ModalKt;
import com.tencent.ntcompose.material.ProgressIndicatorKt;
import com.tencent.ntcompose.material.RichTextKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.SurfaceKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.material.h;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.ntcompose.ui.platform.a;
import com.tencent.qq.ntkernel.flash_transfer.IKernelFlashTransferService;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import defpackage.j;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import ws3.br;
import ws3.dn;
import ws3.eg;
import ws3.es;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTCenterShareViewKt {
    public static final void doShareToFriend(int i3, String str, String str2, String str3, String str4) {
        NBPFeedCommentsViewModel$$ExternalSyntheticOutline0.m(VasBusinessReportData$$ExternalSyntheticOutline0.m(AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0.m("shareUploadedFileSet action:", i3, " fileSetId:", str, " uploaderName:"), str2, " fileSetName:", str3, " link:"), str4, KLog.INSTANCE, "QQFTCenterShareView");
        QQFlashTransferKuiklyModule companion = QQFlashTransferKuiklyModule.Companion.getInstance();
        QQFTCenterShareViewKt$doShareToFriend$1 qQFTCenterShareViewKt$doShareToFriend$1 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterShareViewKt$doShareToFriend$1
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                KLog.INSTANCE.d("QQFTCenterShareView", "shareUploadedFileSet callback " + eVar);
                return Unit.INSTANCE;
            }
        };
        companion.getClass();
        e eVar = new e();
        eVar.t("shareAction", i3);
        eVar.v("fileSetId", str);
        eVar.v("uploaderName", str2);
        eVar.v("fileSetName", str3);
        if (str4 != null) {
            eVar.v("shareLink", str4);
        }
        companion.toNative(true, "shareUploadedFileSet", eVar.toString(), qQFTCenterShareViewKt$doShareToFriend$1, false);
    }

    public static final void doShareAction(int i3, String str, String str2, String str3, String str4) {
        if (i3 == 1) {
            Utils.INSTANCE.currentBridgeModule().copyToPasteboard(str2 + "\u901a\u8fc7QQ\u95ea\u4f20\u5206\u4eab\u4e86\u3010" + str3 + "\u3011\n\u94fe\u63a5\uff1a" + str4);
            ((QQKuiklyPlatformApi) c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).qqToast("\u590d\u5236\u6210\u529f", QToastMode.Success);
            return;
        }
        if (i3 == 2) {
            doShareToFriend(i3, str, str2, str3, str4);
            return;
        }
        if (i3 == 9) {
            doShareToFriend(i3, str, str2, str3, str4);
        } else if (i3 != 123) {
            ((QQKuiklyPlatformApi) c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).qqToast("\u6682\u4e0d\u652f\u6301", QToastMode.Warning);
        } else {
            doShareToFriend(i3, str, str2, str3, str4);
        }
    }

    public static final void CoverWithStatus(final QQTransferCenterViewModel qQTransferCenterViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(698304887);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(698304887, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.CoverWithStatus (QQFTCenterShareView.kt:216)");
        }
        BoxKt.a(ComposeLayoutPropUpdaterKt.A(i.INSTANCE), Alignment.BottomEnd, null, ComposableLambdaKt.composableLambda(startRestartGroup, -742763779, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterShareViewKt$CoverWithStatus$1
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
                        ComposerKt.traceEventStart(-742763779, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.CoverWithStatus.<anonymous> (QQFTCenterShareView.kt:218)");
                    }
                    i.Companion companion = i.INSTANCE;
                    float f16 = 178;
                    i v3 = ComposeLayoutPropUpdaterKt.v(companion, f16, f16);
                    final QQTransferCenterViewModel qQTransferCenterViewModel2 = QQTransferCenterViewModel.this;
                    BoxKt.a(v3, null, null, ComposableLambdaKt.composableLambda(composer3, -807558653, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterShareViewKt$CoverWithStatus$1.1
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar2, Composer composer4, Integer num2) {
                            String str;
                            eg egVar;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-807558653, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.CoverWithStatus.<anonymous>.<anonymous> (QQFTCenterShareView.kt:222)");
                                }
                                i.Companion companion2 = i.INSTANCE;
                                i h16 = ComposeLayoutPropUpdaterKt.h(companion2, 0.0f, 1, null);
                                h.Companion companion3 = h.INSTANCE;
                                ImageKt.a(null, null, null, null, null, h16, null, companion3.a(), null, null, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAWQAAAFIBAMAAACVW5leAAAACXBIWXMAABYlAAAWJQFJUiTwAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAPUExURW54m0dwTHB4l36FmnN6my+enswAAAAFdFJOUzMAQEYY4T858gAAAchJREFUeNrt2NFtwjAUQFE3YQBcMkAIDEDjDECA/Wcqbb+p1FTIee258gBH1vvwc8rhSsjIyMjIyMjIyMjIyMjIyM8nn4cKbX5DriIehuNycjdUal5Mfq1F3i8mN7XI/WLyUK2l5K4eeUZGRkZ+PvlWrflfPT6RkaOSz2mFbb4jX4ZVNj0mb4eV9vKQfFkr+fiQPKy2+QF5i/yklTut4Q8AGRk5ILni4vSTxcp7GRm5JrlLgZo/yF2J1DjfydfSN/faZuW1n6dMOXWljzQYTZnTbkyhOrylto9FbqfUpmCNqUQjF2RkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRkZGRk5FWSD/HIbR9L3JzS9RSL3E5pG2yYyz7lwxjqksec8q6UQ5hK2d/J+VwCdcwf5NzdwjTnL3KwkJGRkZGRkZGRkZGRkf8++R1kKs0hPnxCCwAAAABJRU5ErkJggg", null, null, null, null, null, null, null, null, null, null, composer5, 12845056, 6, 0, 2095967);
                                float f17 = 178 / 263;
                                br brVar = QQTransferCenterViewModel.this.uploadedFileSet;
                                if (brVar == null || (egVar = brVar.f446191e) == null || (str = egVar.f446334c) == null) {
                                    str = QQFTIconConstant.FILE_TYPE_ICONS[0];
                                }
                                ImageKt.a(null, null, null, null, null, ModifiersKt.h(ModifiersKt.q(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.h(companion2, 0.0f, 1, null), 0.0f, 60 * f17, 0.0f, 20 * f17, 5, null), uo3.c.a(6 * f17)), 3 * f17, com.tencent.kuikly.core.base.h.INSTANCE.n(), null, 4, null), null, companion3.a(), null, null, str, null, null, null, null, null, null, null, null, null, null, composer5, 12845056, 0, 0, 2095967);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 3080, 6);
                    if (QQTransferCenterViewModel.this.fileSetUploadStatus.getValue().intValue() != 4 && QQTransferCenterViewModel.this.fileSetUploadStatus.getValue().intValue() != 6 && QQTransferCenterViewModel.this.fileSetUploadStatus.getValue().intValue() != 7) {
                        composer3.startReplaceableGroup(-1456112749);
                        i d16 = ModifiersKt.d(ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(companion, 33), (float) 16.5d), QUIToken.color$default("icon_allwhite_primary"));
                        Alignment alignment = Alignment.Center;
                        final QQTransferCenterViewModel qQTransferCenterViewModel3 = QQTransferCenterViewModel.this;
                        BoxKt.a(d16, alignment, null, ComposableLambdaKt.composableLambda(composer3, -361743705, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterShareViewKt$CoverWithStatus$1.3
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
                                        ComposerKt.traceEventStart(-361743705, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.CoverWithStatus.<anonymous>.<anonymous> (QQFTCenterShareView.kt:263)");
                                    }
                                    i.Companion companion2 = i.INSTANCE;
                                    ProgressIndicatorKt.a(QQTransferCenterViewModel.this.fileSetUploadProgress.getValue().floatValue(), ComposeLayoutPropUpdaterKt.u(companion2, 32), new com.tencent.kuikly.core.base.h(4278226175L), QUIToken.color$default("border_light"), 4, 0.0f, composer5, 29248, 32);
                                    ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion2, 14), null, 0, null, null, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB4AAAAgCAYAAAAFQMh/AAAACXBIWXMAABYlAAAWJQFJUiTwAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAADsSURBVHgB7dbhDYIwEAXg10sHcARWcQNHcAU20AlcQTdwA1fBDRjAgK3VKBXoXW3lT19CQrjwPkICLbBQFGJz6Ct02JhjBY0jatVIbo+DHXpBj+rZ0oCwluBy2EffTSJcBk+hETgfDqFCnAdzUQEehqUoE1dZUAausqEBnMSoLVLmh/Gd02Pmx3bYLts5C4dQ+/QdriOAmzFxEqNzn4mdMXFKhgpxSooKcAffsE2GMvHXq26TogzcwRrnwTAFOoebcxoMe+zNxToZ6uMf/XowBHbIFa+fsFAKXOACF/jvcIsfEwePrWZ6dAM4mTtEeagUO8mlDwAAAABJRU5ErkJggg==", null, null, null, null, null, null, null, null, new com.tencent.kuikly.core.base.h(4278226175L), null, composer5, 262144, 1073741830, 0, 1571807);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 3128, 4);
                        composer3.endReplaceableGroup();
                    } else {
                        composer3.startReplaceableGroup(-1456113556);
                        i d17 = ModifiersKt.d(ComposeLayoutPropUpdaterKt.u(companion, 32), com.tencent.kuikly.core.base.h.INSTANCE.n());
                        uo3.b b16 = uo3.c.b();
                        final QQTransferCenterViewModel qQTransferCenterViewModel4 = QQTransferCenterViewModel.this;
                        SurfaceKt.a(d17, b16, null, null, ComposableLambdaKt.composableLambda(composer3, -1273135658, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterShareViewKt$CoverWithStatus$1.2
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(Composer composer4, Integer num2) {
                                String str;
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 11) == 2 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1273135658, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.CoverWithStatus.<anonymous>.<anonymous> (QQFTCenterShareView.kt:245)");
                                    }
                                    if (QQTransferCenterViewModel.this.fileSetUploadStatus.getValue().intValue() == 4) {
                                        str = "tick_filled";
                                    } else {
                                        str = "caution_filled";
                                    }
                                    float f17 = 31;
                                    float f18 = (float) 0.5d;
                                    ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.v(i.INSTANCE, f17, f17), f18, f18, 0.0f, 0.0f, 12, null), null, 0, null, null, QUIToken.INSTANCE.image(str, new com.tencent.kuikly.core.base.h(QQTransferCenterViewModel.this.fileSetUploadStatus.getValue().intValue() == 4 ? 4284599932L : 4294901760L)), null, null, null, null, null, null, null, null, null, null, composer5, 262144, 0, 0, 2096095);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 24584, 12);
                        composer3.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 3128, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterShareViewKt$CoverWithStatus$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTCenterShareViewKt.CoverWithStatus(QQTransferCenterViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void QQFTCenterShareView(final QQTransferCenterViewModel qQTransferCenterViewModel, final Function1<? super Boolean, Unit> function1, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-530516298);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-530516298, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterShareView (QQFTCenterShareView.kt:63)");
        }
        ModalKt.a(null, false, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -990745292, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterShareViewKt$QQFTCenterShareView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                        ComposerKt.traceEventStart(-990745292, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterShareView.<anonymous> (QQFTCenterShareView.kt:64)");
                    }
                    i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                    Alignment alignment = Alignment.BottomEnd;
                    final Function1<Boolean, Unit> function12 = function1;
                    final int i16 = i3;
                    final QQTransferCenterViewModel qQTransferCenterViewModel2 = qQTransferCenterViewModel;
                    BoxKt.a(h16, alignment, null, ComposableLambdaKt.composableLambda(composer3, 1469008750, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterShareViewKt$QQFTCenterShareView$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
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
                                    ComposerKt.traceEventStart(1469008750, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterShareView.<anonymous>.<anonymous> (QQFTCenterShareView.kt:68)");
                                }
                                HalfFloatingLayerState rememberHalfFloatingLayerState = HalfFloatingLayerKt.rememberHalfFloatingLayerState(composer5);
                                float bottom = c0.CTRL_INDEX - ((a) composer5.consume(CompositionLocalsKt.d())).f().getBottom();
                                float f16 = 20;
                                com.tencent.kuikly.core.base.h color$default = QUIToken.color$default("overlay_dark");
                                final Function1<Boolean, Unit> function13 = function12;
                                composer5.startReplaceableGroup(1157296644);
                                boolean changed = composer5.changed(function13);
                                Object rememberedValue = composer5.rememberedValue();
                                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterShareViewKt$QQFTCenterShareView$1$1$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(Object obj) {
                                            KLog.INSTANCE.i("QQFTCenterShareView", "closeHandlerFn ");
                                            function13.invoke(Boolean.FALSE);
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composer5.updateRememberedValue(rememberedValue);
                                }
                                composer5.endReplaceableGroup();
                                Function1 function14 = (Function1) rememberedValue;
                                Function2<Composer, Integer, Unit> function2 = ComposableSingletons$QQFTCenterShareViewKt.f154lambda1;
                                final QQTransferCenterViewModel qQTransferCenterViewModel3 = qQTransferCenterViewModel2;
                                final Function1<Boolean, Unit> function15 = function12;
                                final int i17 = i16;
                                HalfFloatingLayerKt.HalfFloatingLayer(bottom, 0.5f, color$default, f16, function14, rememberHalfFloatingLayerState, function2, ComposableLambdaKt.composableLambda(composer5, -497615544, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterShareViewKt.QQFTCenterShareView.1.1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(Composer composer6, Integer num3) {
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 11) == 2 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-497615544, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterShareView.<anonymous>.<anonymous>.<anonymous> (QQFTCenterShareView.kt:83)");
                                            }
                                            QQFTCenterShareViewKt.boardContentView(QQTransferCenterViewModel.this, function15, composer7, (i17 & 112) | 8);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 14159408, 0);
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
        }), startRestartGroup, 24576, 15);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterShareViewKt$QQFTCenterShareView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTCenterShareViewKt.QQFTCenterShareView(QQTransferCenterViewModel.this, function1, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void QQFTSharePanelItemView(final i iVar, final QQFTShareItem qQFTShareItem, final Function0<Unit> function0, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-1022727932);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1022727932, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTSharePanelItemView (QQFTCenterShareView.kt:339)");
        }
        ColumnKt.a(iVar, null, Alignment.Horizontal.CenterHorizontally, null, ComposableLambdaKt.composableLambda(startRestartGroup, 61375163, true, new Function3<d, Composer, Integer, Unit>(function0, i3, qQFTShareItem) { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterShareViewKt$QQFTSharePanelItemView$1
            public final /* synthetic */ Function0<Unit> $onItemClick;
            public final /* synthetic */ QQFTShareItem $shareItem;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
                this.$shareItem = qQFTShareItem;
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(d dVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(61375163, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTSharePanelItemView.<anonymous> (QQFTCenterShareView.kt:343)");
                    }
                    i.Companion companion = i.INSTANCE;
                    i c16 = ModifiersKt.c(ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(companion, 56), 12), QUIToken.color$default("fill_light_secondary"));
                    final Function0<Unit> function02 = this.$onItemClick;
                    composer3.startReplaceableGroup(1157296644);
                    boolean changed = composer3.changed(function02);
                    Object rememberedValue = composer3.rememberedValue();
                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterShareViewKt$QQFTSharePanelItemView$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                function02.invoke();
                                return Unit.INSTANCE;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue);
                    }
                    composer3.endReplaceableGroup();
                    i d16 = ViewEventPropUpdaterKt.d(c16, false, null, (Function1) rememberedValue, 3, null);
                    final QQFTShareItem qQFTShareItem2 = this.$shareItem;
                    BoxKt.a(d16, null, null, ComposableLambdaKt.composableLambda(composer3, 262410945, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterShareViewKt$QQFTSharePanelItemView$1.2
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar, Composer composer4, Integer num2) {
                            int i16;
                            String image;
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
                                    ComposerKt.traceEventStart(262410945, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTSharePanelItemView.<anonymous>.<anonymous> (QQFTCenterShareView.kt:351)");
                                }
                                i a16 = bVar2.a(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 28), Alignment.Center);
                                if (QQFTShareItem.this.tokenName.length() == 0) {
                                    image = QQFTShareItem.this.iconUrl;
                                } else {
                                    image = QUIToken.INSTANCE.image(QQFTShareItem.this.tokenName, null);
                                }
                                ImageKt.a(null, null, null, null, null, a16, null, 0, null, null, image, null, null, null, null, null, null, null, null, QQFTShareItem.this.imageTintColor, null, composer5, 262144, 1073741824, 0, 1571807);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 3080, 6);
                    i n3 = ComposeLayoutPropUpdaterKt.n(companion, 0.0f, 6, 0.0f, 0.0f, 13, null);
                    final Function0<Unit> function03 = this.$onItemClick;
                    composer3.startReplaceableGroup(1157296644);
                    boolean changed2 = composer3.changed(function03);
                    Object rememberedValue2 = composer3.rememberedValue();
                    if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterShareViewKt$QQFTSharePanelItemView$1$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                function03.invoke();
                                return Unit.INSTANCE;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue2);
                    }
                    composer3.endReplaceableGroup();
                    i d17 = ViewEventPropUpdaterKt.d(n3, false, null, (Function1) rememberedValue2, 3, null);
                    TextKt.a(this.$shareItem.text, d17, null, QUIToken.color$default("text_primary"), Float.valueOf(10), null, new bp3.c(400), null, null, null, ai.f(ai.INSTANCE.a()), Float.valueOf(14), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 28736, 48, 0, 134214564);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 24968, 10);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterShareViewKt$QQFTSharePanelItemView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTCenterShareViewKt.QQFTSharePanelItemView(i.this, qQFTShareItem, function0, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void boardContentView(final QQTransferCenterViewModel qQTransferCenterViewModel, final Function1<? super Boolean, Unit> function1, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-944342711);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-944342711, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.boardContentView (QQFTCenterShareView.kt:92)");
        }
        SurfaceKt.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), c0.CTRL_INDEX - ((a) startRestartGroup.consume(CompositionLocalsKt.d())).f().getBottom()), QUIToken.color$default("bg_middle_standard")), new uo3.b(20.0f, 20.0f, 0.0f, 0.0f), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1755354741, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterShareViewKt$boardContentView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                        ComposerKt.traceEventStart(-1755354741, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.boardContentView.<anonymous> (QQFTCenterShareView.kt:97)");
                    }
                    i d16 = ModifiersKt.d(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), QUIToken.color$default("bg_middle_standard"));
                    final QQTransferCenterViewModel qQTransferCenterViewModel2 = QQTransferCenterViewModel.this;
                    final Function1<Boolean, Unit> function12 = function1;
                    final int i16 = i3;
                    ColumnKt.a(d16, null, null, null, ComposableLambdaKt.composableLambda(composer3, 961774082, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterShareViewKt$boardContentView$1.1
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
                                    ComposerKt.traceEventStart(961774082, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.boardContentView.<anonymous>.<anonymous> (QQFTCenterShareView.kt:100)");
                                }
                                QQFTCenterShareViewKt.topView(QQTransferCenterViewModel.this, function12, composer5, (i16 & 112) | 8);
                                QQFTCenterShareViewKt.simpleInfoView(QQTransferCenterViewModel.this, composer5, 8);
                                i.Companion companion = i.INSTANCE;
                                float f16 = 16;
                                SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, f16), composer5, 8, 0);
                                QQFTCenterShareViewKt.titleView(QQTransferCenterViewModel.this, composer5, 8);
                                SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, f16), composer5, 8, 0);
                                QQFTCenterUIConfig qQFTCenterUIConfig = QQFTCenterUIConfig.INSTANCE;
                                float m3 = GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0.m(c.f117352a);
                                float f17 = QQFTCenterUIConfig.shareViewMarginLeft;
                                i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, m3 - (2 * f17)), 76), f17, 0.0f, 0.0f, 0.0f, 14, null);
                                final QQTransferCenterViewModel qQTransferCenterViewModel3 = QQTransferCenterViewModel.this;
                                QQFTCenterShareViewKt.shareItemListView(n3, qQTransferCenterViewModel3.shareItems, new Function1<QQFTShareItem, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterShareViewKt.boardContentView.1.1.1
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
                                    
                                        if (r0 != null) goto L19;
                                     */
                                    /* JADX WARN: Type inference failed for: r0v15 */
                                    /* JADX WARN: Type inference failed for: r0v16 */
                                    /* JADX WARN: Type inference failed for: r0v7, types: [T, java.lang.String] */
                                    @Override // kotlin.jvm.functions.Function1
                                    /*
                                        Code decompiled incorrectly, please refer to instructions dump.
                                    */
                                    public final Unit invoke(QQFTShareItem qQFTShareItem) {
                                        ?? r06;
                                        List<es> list;
                                        Object firstOrNull;
                                        final QQFTShareItem qQFTShareItem2 = qQFTShareItem;
                                        KLog kLog = KLog.INSTANCE;
                                        ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("click item: "), qQFTShareItem2.action, kLog, "QQFTCenterShareView");
                                        br brVar = QQTransferCenterViewModel.this.uploadedFileSet;
                                        String str = brVar != null ? brVar.f446187a : null;
                                        final String str2 = brVar != null ? brVar.f446188b : null;
                                        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                                        br brVar2 = QQTransferCenterViewModel.this.uploadedFileSet;
                                        if (brVar2 != null && (list = brVar2.f446192f) != null) {
                                            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                                            es esVar = (es) firstOrNull;
                                            if (esVar != null) {
                                                String str3 = esVar.f446362b;
                                                r06 = str3;
                                            }
                                        }
                                        r06 = "";
                                        objectRef.element = r06;
                                        if (str != null && str2 != null) {
                                            String str4 = QQTransferCenterViewModel.this.uploadedFileSetShareLink;
                                            if (str4 != null) {
                                                int i17 = qQFTShareItem2.action;
                                                Intrinsics.checkNotNull(str4);
                                                QQFTCenterShareViewKt.doShareAction(i17, str, r06, str2, str4);
                                            } else {
                                                DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("getShareLinkReq: ", str, kLog, "QQFTCenterShareView");
                                                IKernelFlashTransferService a16 = IKernelFlashTransferService.f344757i.a();
                                                final QQTransferCenterViewModel qQTransferCenterViewModel4 = QQTransferCenterViewModel.this;
                                                final String str5 = str;
                                                a16.e(str, new dn() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterShareViewKt.boardContentView.1.1.1.1
                                                    @Override // ws3.dn
                                                    /* renamed from: onGetShareLink-32etgaw */
                                                    public final void mo122onGetShareLink32etgaw(final String str6, final long j3, final int i18, final String str7) {
                                                        final QQTransferCenterViewModel qQTransferCenterViewModel5 = QQTransferCenterViewModel.this;
                                                        final QQFTShareItem qQFTShareItem3 = qQFTShareItem2;
                                                        final String str8 = str5;
                                                        final Ref.ObjectRef<String> objectRef2 = objectRef;
                                                        final String str9 = str2;
                                                        SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterShareViewKt$boardContentView$1$1$1$1$onGetShareLink$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Unit invoke() {
                                                                KLog kLog2 = KLog.INSTANCE;
                                                                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onGetShareLink: ");
                                                                m16.append(str6);
                                                                m16.append(", expireTimestamp:");
                                                                StringBuilder m17 = QQFlashTransferViewModel$fetchCompressedFileFolder$2$$ExternalSyntheticOutline0.m(j3, m16, ", result:");
                                                                m17.append(i18);
                                                                m17.append(", errMsg:");
                                                                AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m17, str7, kLog2, "QQFTCenterShareView");
                                                                if (i18 != 0) {
                                                                    ((QQKuiklyPlatformApi) c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).qqToast(str7, QToastMode.Warning);
                                                                } else {
                                                                    QQTransferCenterViewModel qQTransferCenterViewModel6 = qQTransferCenterViewModel5;
                                                                    String str10 = str6;
                                                                    qQTransferCenterViewModel6.uploadedFileSetShareLink = str10;
                                                                    QQFTCenterShareViewKt.doShareAction(qQFTShareItem3.action, str8, objectRef2.element, str9, str10);
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                    }
                                                });
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }, composer5, 72);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 24584, 14);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 24584, 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterShareViewKt$boardContentView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTCenterShareViewKt.boardContentView(QQTransferCenterViewModel.this, function1, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void simpleInfoView(final QQTransferCenterViewModel qQTransferCenterViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(1329048777);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1329048777, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.simpleInfoView (QQFTCenterShareView.kt:281)");
        }
        ColumnKt.a(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null)), null, Alignment.Horizontal.CenterHorizontally, null, ComposableLambdaKt.composableLambda(startRestartGroup, -265929742, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterShareViewKt$simpleInfoView$1
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
                        ComposerKt.traceEventStart(-265929742, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.simpleInfoView.<anonymous> (QQFTCenterShareView.kt:285)");
                    }
                    QQFTCenterShareViewKt.CoverWithStatus(QQTransferCenterViewModel.this, composer3, 8);
                    i.Companion companion = i.INSTANCE;
                    float f16 = 16;
                    i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.z(companion), f16, f16, f16, 0.0f, 8, null);
                    br brVar = QQTransferCenterViewModel.this.uploadedFileSet;
                    TextKt.a(brVar != null ? brVar.f446188b : null, n3, null, QUIToken.color$default("text_primary"), Float.valueOf(22), null, bp3.c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.a()), Float.valueOf(30), null, null, null, null, null, null, 2, null, null, null, null, null, null, null, false, composer3, 1601600, 100663344, 0, 133952420);
                    Alignment.Vertical vertical = Alignment.Vertical.CenterVertically;
                    i n16 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.A(companion), 0.0f, 8, 0.0f, 0.0f, 13, null);
                    final QQTransferCenterViewModel qQTransferCenterViewModel2 = QQTransferCenterViewModel.this;
                    i d16 = ViewEventPropUpdaterKt.d(n16, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterShareViewKt$simpleInfoView$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ClickParams clickParams) {
                            String str;
                            String str2;
                            br brVar2 = QQTransferCenterViewModel.this.uploadedFileSet;
                            if (brVar2 != null && (str = brVar2.f446187a) != null) {
                                if (str.length() > 0) {
                                    if (QQTransferCenterViewModel.this.showTopEmptyCard) {
                                        str2 = "1";
                                    } else {
                                        str2 = "0";
                                    }
                                    StringBuilder a16 = j.a("mqqapi://kuikly/open?version=1&src_type=app&page_name=QQTransferDownloadActivity&local_bundle_name=nearbypro&qui_token_theme_mode=0&use_host_display_metrics=1&autorotate=1&file_set_id=", str, "&scene_type=7&entry_id=", "1", "&has_send_entrance=");
                                    a16.append(str2);
                                    String sb5 = a16.toString();
                                    QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                                    QQKuiklyPlatformApi.Companion.openPage$default(sb5, false, 6);
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }, 3, null);
                    final QQTransferCenterViewModel qQTransferCenterViewModel3 = QQTransferCenterViewModel.this;
                    RowKt.a(d16, null, vertical, null, null, ComposableLambdaKt.composableLambda(composer3, 629027344, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterShareViewKt$simpleInfoView$1.2
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
                                    ComposerKt.traceEventStart(629027344, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.simpleInfoView.<anonymous>.<anonymous> (QQFTCenterShareView.kt:307)");
                                }
                                i.Companion companion2 = i.INSTANCE;
                                i A = ComposeLayoutPropUpdaterKt.A(companion2);
                                String value = QQTransferCenterViewModel.this.fileSetUploadStatusContent.getValue();
                                QUIToken qUIToken = QUIToken.INSTANCE;
                                TextKt.a(value, A, null, QUIToken.color$default("text_primary"), Float.valueOf(14), null, bp3.c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.a()), Float.valueOf(20), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 1601600, 48, 0, 134214564);
                                ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion2, 16), null, 0, null, null, qUIToken.image("arrow_right", QUIToken.color$default("text_primary")), null, null, null, null, null, null, null, null, null, null, composer5, 262144, 0, 0, 2096095);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 197000, 26);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 24968, 10);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterShareViewKt$simpleInfoView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTCenterShareViewKt.simpleInfoView(QQTransferCenterViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void titleView(final QQTransferCenterViewModel qQTransferCenterViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-117551931);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-117551931, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.titleView (QQFTCenterShareView.kt:169)");
        }
        i.Companion companion = i.INSTANCE;
        QQFTCenterUIConfig qQFTCenterUIConfig = QQFTCenterUIConfig.INSTANCE;
        float m3 = GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0.m(c.f117352a);
        float f16 = QQFTCenterUIConfig.shareViewMarginLeft;
        SurfaceKt.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.w(companion, m3 - (2 * f16))), f16, 0.0f, 0.0f, 0.0f, 14, null), QUIToken.color$default("fill_light_secondary")), uo3.c.a(10), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1232078915, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterShareViewKt$titleView$1
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
                        ComposerKt.traceEventStart(1232078915, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.titleView.<anonymous> (QQFTCenterShareView.kt:176)");
                    }
                    i.Companion companion2 = i.INSTANCE;
                    i z16 = ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(companion2, 0.0f, 1, null));
                    float f17 = QQFTCenterUIConfig.shareSecondMarginLeft;
                    RowKt.a(ComposeLayoutPropUpdaterKt.n(z16, f17, f17, f17, 0.0f, 8, null), null, Alignment.Vertical.CenterVertically, null, null, ComposableSingletons$QQFTCenterShareViewKt.f155lambda2, composer3, 197000, 26);
                    i m16 = ComposeLayoutPropUpdaterKt.m(ComposeLayoutPropUpdaterKt.A(companion2), f17, 8, f17, f17);
                    RichTextKt.b(QQTransferCenterViewModel.this.uploadShareLinkContent.getValue(), m16, null, QUIToken.color$default("text_secondary"), Float.valueOf(14), null, bp3.c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.e()), Float.valueOf(20), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, composer3, 1601600, 48, 0, 268432292);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 24584, 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterShareViewKt$titleView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTCenterShareViewKt.titleView(QQTransferCenterViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void topView(final QQTransferCenterViewModel qQTransferCenterViewModel, final Function1<? super Boolean, Unit> function1, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-1610299761);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1610299761, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.topView (QQFTCenterShareView.kt:146)");
        }
        RowKt.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null)), 0.0f, 16, 0.0f, 0.0f, 13, null), null, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1618747569, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterShareViewKt$topView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                        ComposerKt.traceEventStart(1618747569, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.topView.<anonymous> (QQFTCenterShareView.kt:149)");
                    }
                    i.Companion companion = i.INSTANCE;
                    SpacerKt.a(nVar2.a(companion, 1.0f), composer3, 8, 0);
                    int c16 = h.INSTANCE.c();
                    String image = QUIToken.INSTANCE.image("qui_close_btn_large", QUIToken.color$default("icon_primary"));
                    i q16 = ModifiersKt.q(ModifiersKt.c(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(companion, 30), 0.0f, 0.0f, 16, 0.0f, 11, null), QUIToken.color$default("overlay_light")), uo3.c.a(15));
                    final QQTransferCenterViewModel qQTransferCenterViewModel2 = QQTransferCenterViewModel.this;
                    final Function1<Boolean, Unit> function12 = function1;
                    ImageKt.a(null, null, null, null, null, ViewEventPropUpdaterKt.d(q16, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterShareViewKt$topView$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ClickParams clickParams) {
                            KLog.INSTANCE.d(QQTransferCenterViewModel.this.kTag, "onClick close");
                            function12.invoke(Boolean.FALSE);
                            return Unit.INSTANCE;
                        }
                    }, 3, null), null, c16, null, null, image, null, null, null, null, null, null, null, null, null, null, composer3, 12845056, 0, 0, 2095967);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 196616, 30);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterShareViewKt$topView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTCenterShareViewKt.topView(QQTransferCenterViewModel.this, function1, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void shareItemListView(final i iVar, final List<QQFTShareItem> list, final Function1<? super QQFTShareItem, Unit> function1, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-646130535);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-646130535, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.shareItemListView (QQFTCenterShareView.kt:325)");
        }
        LazyRowKt.a(iVar, null, null, null, null, null, null, Boolean.FALSE, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -2054347024, true, new Function3<com.tencent.ntcompose.foundation.lazy.layout.a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterShareViewKt$shareItemListView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(com.tencent.ntcompose.foundation.lazy.layout.a aVar, Composer composer2, Integer num) {
                com.tencent.ntcompose.foundation.lazy.layout.a aVar2 = aVar;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2054347024, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.shareItemListView.<anonymous> (QQFTCenterShareView.kt:329)");
                }
                int size = list.size();
                final List<QQFTShareItem> list2 = list;
                final Function1<QQFTShareItem, Unit> function12 = function1;
                LazyDslKt.a(aVar2, size, null, ComposableLambdaKt.composableLambda(composer3, -1198661284, true, new Function3<Integer, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterShareViewKt$shareItemListView$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(Integer num2, Composer composer4, Integer num3) {
                        int i16;
                        final int intValue2 = num2.intValue();
                        Composer composer5 = composer4;
                        int intValue3 = num3.intValue();
                        if ((intValue3 & 14) == 0) {
                            i16 = (composer5.changed(intValue2) ? 4 : 2) | intValue3;
                        } else {
                            i16 = intValue3;
                        }
                        if ((i16 & 91) == 18 && composer5.getSkipping()) {
                            composer5.skipToGroupEnd();
                        } else {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1198661284, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.shareItemListView.<anonymous>.<anonymous> (QQFTCenterShareView.kt:330)");
                            }
                            i n3 = ComposeLayoutPropUpdaterKt.n(i.INSTANCE, intValue2 == 0 ? 0 : 32, 0.0f, 0.0f, 0.0f, 14, null);
                            QQFTShareItem qQFTShareItem = list2.get(intValue2);
                            final Function1<QQFTShareItem, Unit> function13 = function12;
                            final List<QQFTShareItem> list3 = list2;
                            QQFTCenterShareViewKt.QQFTSharePanelItemView(n3, qQFTShareItem, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterShareViewKt.shareItemListView.1.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Unit invoke() {
                                    Function1<QQFTShareItem, Unit> function14 = function13;
                                    if (function14 != null) {
                                        function14.invoke(list3.get(intValue2));
                                    }
                                    return Unit.INSTANCE;
                                }
                            }, composer5, 72);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }), composer3, 3080, 2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 12582920, 0, MsgConstant.KRMFILETHUMBSIZE384, 4194174);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterShareViewKt$shareItemListView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTCenterShareViewKt.shareItemListView(i.this, list, function1, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
