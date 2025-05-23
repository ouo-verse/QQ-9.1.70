package com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.CenterContentConfig;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.LeftContentConfig;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.SecNavBarKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.kuikly.core.base.h;
import com.tencent.ntcompose.foundation.layout.b;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* loaded from: classes31.dex */
public final class ComposableSingletons$PermissionsSettingPageKt {
    public static final ComposableSingletons$PermissionsSettingPageKt INSTANCE = new ComposableSingletons$PermissionsSettingPageKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f9lambda1 = ComposableLambdaKt.composableLambdaInstance(1622102907, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting.ComposableSingletons$PermissionsSettingPageKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(b bVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1622102907, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting.ComposableSingletons$PermissionsSettingPageKt.lambda-1.<anonymous> (PermissionsSettingPage.kt:91)");
                }
                SecNavBarKt.SecNavBar(h.INSTANCE.j(), new LeftContentConfig("icon_allwhite_primary", new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting.ComposableSingletons$PermissionsSettingPageKt$lambda-1$1.1
                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                        QQKuiklyPlatformApi.Companion.closePage$default();
                        return Unit.INSTANCE;
                    }
                }, 182), new CenterContentConfig("\u6743\u9650\u8bbe\u7f6e"), null, composer2, 8, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
