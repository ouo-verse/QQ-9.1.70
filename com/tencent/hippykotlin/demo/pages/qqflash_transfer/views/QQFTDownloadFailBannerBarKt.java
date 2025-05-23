package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.a;
import bp3.c;
import bp3.j;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.da_tong_report.DTReportConstKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.modifer_ext.ModifierExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.manager.c;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.RichTextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import defpackage.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTDownloadFailBannerBarKt {
    public static final void QQFTDownloadFailBannerBar(final QQFlashTransferViewModel qQFlashTransferViewModel, Composer composer, final int i3) {
        String str;
        Composer startRestartGroup = composer.startRestartGroup(2070544219);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2070544219, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadFailBannerBar (QQFTDownloadFailBannerBar.kt:43)");
        }
        startRestartGroup.startReplaceableGroup(-1066692343);
        if (qQFlashTransferViewModel.downloadFailedFileList.size() > 0) {
            i d16 = ViewEventPropUpdaterKt.d(ModifiersKt.c(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 48.0f), 16.0f, 0.0f, 0.0f, 0.0f, 14, null), new h(4294963185L)), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadFailBannerBarKt$QQFTDownloadFailBannerBar$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(ClickParams clickParams) {
                    QQFlashTransferViewModel.this.showCreateFloatView.setValue(Boolean.TRUE);
                    return Unit.INSTANCE;
                }
            }, 3, null);
            if (k.a(c.f117352a)) {
                str = "0S200MNJT807V3GE";
            } else {
                str = "0M2003OIIM08YV9M";
            }
            BoxKt.a(ModifiersKt.A(ModifierExtKt.elementVR(d16, "em_bas_transmission_failure_small_bar", DTReportConstKt.getDTBaseParams(str)), 0.5f, 0.0f, 2, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 624981884, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadFailBannerBarKt$QQFTDownloadFailBannerBar$2
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
                            ComposerKt.traceEventStart(624981884, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadFailBannerBar.<anonymous> (QQFTDownloadFailBannerBar.kt:52)");
                        }
                        i.Companion companion = i.INSTANCE;
                        i a16 = bVar2.a(companion, Alignment.CenterStart);
                        final QQFlashTransferViewModel qQFlashTransferViewModel2 = QQFlashTransferViewModel.this;
                        RowKt.a(a16, null, null, null, null, ComposableLambdaKt.composableLambda(composer3, 755360286, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadFailBannerBarKt$QQFTDownloadFailBannerBar$2.1
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
                                        ComposerKt.traceEventStart(755360286, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadFailBannerBar.<anonymous>.<anonymous> (QQFTDownloadFailBannerBar.kt:53)");
                                    }
                                    ImageKt.a(QUIToken.INSTANCE.image("caution_filled", QUIToken.color$default("feedback_error")), null, null, null, null, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), 0.0f, 0.0f, 8.0f, 0.0f, 11, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer5, 262144, 0, 0, 2097118);
                                    QQFlashTransferViewModel qQFlashTransferViewModel3 = QQFlashTransferViewModel.this;
                                    a.C0144a c0144a = new a.C0144a(0, 1, null);
                                    c.Companion companion2 = bp3.c.INSTANCE;
                                    int e16 = c0144a.e(new j(null, null, companion2.g(), null, null, null, null, null, null, null, null, null, null, null, null, 32763, null));
                                    try {
                                        StringBuilder sb5 = new StringBuilder();
                                        sb5.append(qQFlashTransferViewModel3.downloadFailedFileList.size());
                                        sb5.append(TokenParser.SP);
                                        c0144a.a(sb5.toString());
                                        Unit unit = Unit.INSTANCE;
                                        c0144a.c(e16);
                                        e16 = c0144a.e(new j(null, null, companion2.e(), null, null, null, null, null, null, null, null, null, null, null, null, 32763, null));
                                        try {
                                            c0144a.a("\u4e2a\u6587\u4ef6\u4e0b\u8f7d\u5931\u8d25");
                                            c0144a.c(e16);
                                            RichTextKt.b(c0144a.f(), null, null, QUIToken.color$default("text_secondary"), Float.valueOf(14.0f), null, null, null, null, null, null, Float.valueOf(20), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, composer5, 28672, 48, 0, 268433382);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        } finally {
                                        }
                                    } finally {
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 196616, 30);
                        i a17 = bVar2.a(companion, Alignment.CenterEnd);
                        final QQFlashTransferViewModel qQFlashTransferViewModel3 = QQFlashTransferViewModel.this;
                        RowKt.a(a17, null, null, null, null, ComposableLambdaKt.composableLambda(composer3, 22050709, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadFailBannerBarKt$QQFTDownloadFailBannerBar$2.2
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(n nVar, Composer composer4, Integer num2) {
                                int i17;
                                n nVar2 = nVar;
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 14) == 0) {
                                    i17 = (composer5.changed(nVar2) ? 4 : 2) | intValue2;
                                } else {
                                    i17 = intValue2;
                                }
                                if ((i17 & 91) == 18 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(22050709, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadFailBannerBar.<anonymous>.<anonymous> (QQFTDownloadFailBannerBar.kt:74)");
                                    }
                                    i b16 = nVar2.b(ComposeLayoutPropUpdaterKt.u(ComposeLayoutPropUpdaterKt.n(i.INSTANCE, 4.0f, 0.0f, 0.0f, 0.0f, 14, null), 16.0f), Alignment.INSTANCE.c());
                                    final QQFlashTransferViewModel qQFlashTransferViewModel4 = QQFlashTransferViewModel.this;
                                    ImageKt.a(QUIToken.INSTANCE.image("chevron_right", QUIToken.color$default("icon_secondary")), null, null, null, null, ViewEventPropUpdaterKt.d(b16, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadFailBannerBarKt.QQFTDownloadFailBannerBar.2.2.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ClickParams clickParams) {
                                            QQFlashTransferViewModel.this.showCreateFloatView.setValue(Boolean.TRUE);
                                            return Unit.INSTANCE;
                                        }
                                    }, 3, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer5, 262144, 0, 0, 2097118);
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
            }), startRestartGroup, 3080, 6);
        }
        startRestartGroup.endReplaceableGroup();
        if (qQFlashTransferViewModel.showCreateFloatView.getValue().booleanValue() && qQFlashTransferViewModel.downloadFailedFileList.size() > 0) {
            QQFTDownloadFailedFileListFloatViewKt.QQFTDownloadFailedFileListFloatView(qQFlashTransferViewModel, new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadFailBannerBarKt$QQFTDownloadFailBannerBar$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Boolean bool) {
                    bool.booleanValue();
                    QQFlashTransferViewModel.this.showCreateFloatView.setValue(Boolean.FALSE);
                    QQFlashTransferViewModel.this.downloadFailedFileList.clear();
                    return Unit.INSTANCE;
                }
            }, startRestartGroup, 8);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDownloadFailBannerBarKt$QQFTDownloadFailBannerBar$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTDownloadFailBannerBarKt.QQFTDownloadFailBannerBar(QQFlashTransferViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
