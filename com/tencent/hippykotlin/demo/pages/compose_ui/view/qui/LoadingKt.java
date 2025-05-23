package com.tencent.hippykotlin.demo.pages.compose_ui.view.qui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.material.APNGKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class LoadingKt {

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoadingIconType.values().length];
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void Loading(final i iVar, LoadingIconType loadingIconType, Composer composer, final int i3, final int i16) {
        String str;
        Composer startRestartGroup = composer.startRestartGroup(-1846519437);
        final LoadingIconType loadingIconType2 = (i16 & 2) != 0 ? LoadingIconType.WHITE : loadingIconType;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1846519437, i3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.Loading (Loading.kt:12)");
        }
        int i17 = loadingIconType2 != null ? WhenMappings.$EnumSwitchMapping$0[loadingIconType2.ordinal()] : -1;
        if (i17 == 1) {
            str = "https://static-res.qq.com/static-res/qui/icon_loading_gray.png";
        } else if (i17 == 2) {
            str = "https://static-res.qq.com/static-res/qui/icon_loading_black.png";
        } else if (i17 != 3) {
            str = "https://static-res.qq.com/static-res/qui/icon_loading_white.png";
        } else {
            str = "https://static-res.qq.com/static-res/qui/icon_loading_colorful.png";
        }
        APNGKt.a(iVar, null, str, 0, Boolean.TRUE, null, null, null, startRestartGroup, 27656, 226);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.LoadingKt$Loading$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoadingKt.Loading(i.this, loadingIconType2, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }
}
