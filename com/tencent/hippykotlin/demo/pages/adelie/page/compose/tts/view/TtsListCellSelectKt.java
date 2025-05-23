package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsInfo;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.TtsPlayState;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.h;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class TtsListCellSelectKt {
    public static final void TtsListCellSelect(final AdelieTtsInfo adelieTtsInfo, Composer composer, final int i3) {
        Composer composer2;
        Composer composer3;
        Composer startRestartGroup = composer.startRestartGroup(1002390288);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1002390288, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsListCellSelect (TtsListCellSelect.kt:18)");
        }
        startRestartGroup.startReplaceableGroup(925975756);
        if (adelieTtsInfo.getPlayState() == TtsPlayState.PLAYING || adelieTtsInfo.getPlayState() == TtsPlayState.COMPLETED) {
            composer2 = startRestartGroup;
            ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 20.0f), 0.0f, 0.0f, 12.0f, 0.0f, 11, null), 20.0f), 20.0f), null, h.INSTANCE.a(), null, null, QUIToken.INSTANCE.image("qui_check", QUIToken.color$default("brand_standard")), null, null, null, null, null, null, null, null, null, null, composer2, 12845056, 0, 0, 2095967);
        } else {
            composer2 = startRestartGroup;
        }
        composer2.endReplaceableGroup();
        if (adelieTtsInfo.getPlayState() == TtsPlayState.LOADING) {
            composer3 = composer2;
            TtsListCellMyOPKt.Loading(composer3, 0);
        } else {
            composer3 = composer2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsListCellSelectKt$TtsListCellSelect$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer4, Integer num) {
                num.intValue();
                TtsListCellSelectKt.TtsListCellSelect(AdelieTtsInfo.this, composer4, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
