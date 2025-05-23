package com.tencent.hippykotlin.demo.pages.qqfile.views;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.h;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFileBlankViewKt {
    public static final void blankView(final String str, final String str2, final String str3, Composer composer, final int i3) {
        final int i16;
        Composer startRestartGroup = composer.startRestartGroup(-1240590383);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(str) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i3 & 112) == 0) {
            i16 |= startRestartGroup.changed(str2) ? 32 : 16;
        }
        if ((i3 & 896) == 0) {
            i16 |= startRestartGroup.changed(str3) ? 256 : 128;
        }
        if ((i16 & TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_EMPTY) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1240590383, i16, -1, "com.tencent.hippykotlin.demo.pages.qqfile.views.blankView (QQFileBlankView.kt:19)");
            }
            ColumnKt.a(ComposeLayoutPropUpdaterKt.j(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), 0.0f, 257.0f, 0.0f, 0.0f, 13, null), 0.0f, 1, null), null, Alignment.INSTANCE.b(), null, ComposableLambdaKt.composableLambda(startRestartGroup, -1345386040, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqfile.views.QQFileBlankViewKt$blankView$1
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
                            ComposerKt.traceEventStart(-1345386040, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqfile.views.blankView.<anonymous> (QQFileBlankView.kt:30)");
                        }
                        i.Companion companion = i.INSTANCE;
                        ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion, 100.0f), null, h.INSTANCE.a(), null, null, QUIToken.INSTANCE.image(str, null), null, null, null, null, null, null, null, null, null, null, composer3, 12845056, 0, 0, 2095967);
                        SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 24.0f), composer3, 8, 0);
                        TextKt.a(str2, null, null, QUIToken.color$default("text_primary"), Float.valueOf(17.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, ((i16 >> 3) & 14) | 28672, 0, 0, 134217702);
                        SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 4.0f), composer3, 8, 0);
                        TextKt.a(str3, null, null, QUIToken.color$default("text_secondary"), Float.valueOf(14.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, ((i16 >> 6) & 14) | 28672, 0, 0, 134217702);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqfile.views.QQFileBlankViewKt$blankView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFileBlankViewKt.blankView(str, str2, str3, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
