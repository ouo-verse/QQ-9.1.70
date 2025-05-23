package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsInfo;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.TtsPlayState;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.h;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class TtsListCellLeftKt {
    public static final void TtsListCellLeft(final AdelieTtsInfo adelieTtsInfo, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(1450550714);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1450550714, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsListCellLeft (TtsListCellLeft.kt:26)");
        }
        RowKt.a(null, null, Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1749109464, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsListCellLeftKt$TtsListCellLeft$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(n nVar, Composer composer2, Integer num) {
                h color$default;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1749109464, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsListCellLeft.<anonymous> (TtsListCellLeft.kt:32)");
                    }
                    i j3 = ModifiersKt.j(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 28.0f), 16.0f, 0.0f, 8.0f, 0.0f, 10, null), 28.0f / 2);
                    if (AdelieTtsInfo.this.type == 1) {
                        color$default = h.INSTANCE.j();
                    } else {
                        color$default = QUIToken.color$default("fill_standard_brand");
                    }
                    i c16 = ModifiersKt.c(j3, color$default);
                    Alignment.Vertical c17 = Alignment.INSTANCE.c();
                    a.e b16 = a.f339245a.b();
                    final AdelieTtsInfo adelieTtsInfo2 = AdelieTtsInfo.this;
                    RowKt.a(c16, b16, c17, null, null, ComposableLambdaKt.composableLambda(composer3, -1916490890, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsListCellLeftKt$TtsListCellLeft$1.1
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(n nVar2, Composer composer4, Integer num2) {
                            String image;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1916490890, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsListCellLeft.<anonymous>.<anonymous> (TtsListCellLeft.kt:42)");
                                }
                                AdelieTtsInfo adelieTtsInfo3 = AdelieTtsInfo.this;
                                float f16 = (adelieTtsInfo3.type == 1 || adelieTtsInfo3.getPlayState() == TtsPlayState.PLAYING) ? 20.0f : 14.0f;
                                AdelieTtsInfo adelieTtsInfo4 = AdelieTtsInfo.this;
                                if (adelieTtsInfo4.type == 1) {
                                    image = QUIToken.INSTANCE.image("qui_volume_off_2", QUIToken.color$default("icon_secondary"));
                                } else if (adelieTtsInfo4.getPlayState() == TtsPlayState.PLAYING) {
                                    image = "https://static-res.qq.com/static-res/adelie/aio/aio_audio_playing.png";
                                } else {
                                    image = QUIToken.INSTANCE.image("qui_play_filled", QUIToken.color$default("brand_standard"));
                                }
                                ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.u(i.INSTANCE, f16), null, com.tencent.ntcompose.material.h.INSTANCE.a(), null, null, image, null, null, null, null, null, null, null, null, null, null, composer5, 12845056, 0, 0, 2095967);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 196680, 24);
                    TextKt.a(AdelieTtsInfo.this.getTtsName(), null, null, QUIToken.color$default("text_primary"), Float.valueOf(14.0f), null, c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.e()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601536, 0, 0, 134216614);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 196608, 27);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsListCellLeftKt$TtsListCellLeft$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                TtsListCellLeftKt.TtsListCellLeft(AdelieTtsInfo.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
