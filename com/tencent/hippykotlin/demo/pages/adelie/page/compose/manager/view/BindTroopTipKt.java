package com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import bp3.a;
import bp3.c;
import bp3.j;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.GuardFastClickKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterViewModel;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.material.RichTextKt;
import h25.u;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class BindTroopTipKt {
    public static final void BindTroopTip(final AdelieManagerCenterViewModel adelieManagerCenterViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(1341283435);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1341283435, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.BindTroopTip (BindTroopTip.kt:18)");
        }
        a.C0144a c0144a = new a.C0144a(0, 1, null);
        h color$default = QUIToken.color$default("text_primary");
        c.Companion companion = c.INSTANCE;
        int e16 = c0144a.e(new j(color$default, Float.valueOf(14.0f), companion.e(), null, null, null, null, null, null, Float.valueOf(20.0f), null, null, null, null, null, 32248, null));
        try {
            c0144a.a("\u5c55\u793a\u7fa4\u804a\u5230\u667a\u80fd\u4f53\u8d44\u6599\u5361\uff0c\u5438\u5f15\u66f4\u591a\u5174\u8da3\u540c\u597d\u52a0\u7fa4\u6269\u5217\uff0c\u70b9\u51fb\u6b64\u5904");
            Unit unit = Unit.INSTANCE;
            c0144a.c(e16);
            c0144a.d("clickEvent", "clickEvent");
            e16 = c0144a.e(new j(QUIToken.color$default("text_link"), Float.valueOf(14.0f), companion.e(), null, null, null, null, null, null, Float.valueOf(20.0f), null, null, null, null, null, 32248, null));
            try {
                c0144a.a("\u4e86\u89e3\u7fa4\u804a\u73a9\u6cd5");
                c0144a.c(e16);
                RichTextKt.a(c0144a.f(), ComposeLayoutPropUpdaterKt.n(i.INSTANCE, 16.0f, 0.0f, 16.0f, 16.0f, 2, null), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new Function2<Integer, ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.BindTroopTipKt$BindTroopTip$1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Integer num, ClickParams clickParams) {
                        final int intValue = num.intValue();
                        final AdelieManagerCenterViewModel adelieManagerCenterViewModel2 = AdelieManagerCenterViewModel.this;
                        GuardFastClickKt.guardFastClick(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.BindTroopTipKt$BindTroopTip$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                u uVar;
                                String str;
                                if (intValue == 1 && (uVar = adelieManagerCenterViewModel2.userIdentityInfo) != null && (str = uVar.f404243f) != null) {
                                    BridgeModule.openPage$default((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule"), str, false, null, null, 30);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                }, startRestartGroup, 64, 0, 0, 67108860);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                    return;
                }
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.BindTroopTipKt$BindTroopTip$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Composer composer2, Integer num) {
                        num.intValue();
                        BindTroopTipKt.BindTroopTip(AdelieManagerCenterViewModel.this, composer2, i3 | 1);
                        return Unit.INSTANCE;
                    }
                });
            } finally {
            }
        } finally {
        }
    }
}
