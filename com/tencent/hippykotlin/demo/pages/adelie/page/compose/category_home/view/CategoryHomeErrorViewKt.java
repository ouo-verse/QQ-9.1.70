package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import bp3.k;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIButtonKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQCommonNApiModule;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.manager.c;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.ntcompose.ui.platform.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class CategoryHomeErrorViewKt {
    public static final void CategoryHomeErrorView(final Function0<Unit> function0, Composer composer, final int i3) {
        final int i16;
        Composer startRestartGroup = composer.startRestartGroup(96075428);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(function0) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i16 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(96075428, i16, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.CategoryHomeErrorView (CategoryHomeErrorView.kt:23)");
            }
            ColumnKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), ((a) startRestartGroup.consume(CompositionLocalsKt.d())).d()), null, Alignment.INSTANCE.b(), null, ComposableLambdaKt.composableLambda(startRestartGroup, 625043341, true, new Function3<d, Composer, Integer, Unit>(function0, i16) { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.CategoryHomeErrorViewKt$CategoryHomeErrorView$1
                public final /* synthetic */ Function0<Unit> $reload;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(d dVar, Composer composer2, Integer num) {
                    String str;
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 81) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(625043341, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.CategoryHomeErrorView.<anonymous> (CategoryHomeErrorView.kt:27)");
                        }
                        i.Companion companion = i.INSTANCE;
                        SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 114.0f), composer3, 8, 0);
                        i v3 = ComposeLayoutPropUpdaterKt.v(companion, 80.0f, 80.0f);
                        QQCommonNApiModule.Companion companion2 = QQCommonNApiModule.Companion;
                        if (((QQCommonNApiModule) c.f117352a.g().acquireModule("QQCommonNApiModule")).isDarkTheme()) {
                            str = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFYAAABWCAMAAABiiJHFAAAARVBMVEUAAADFxcnGxsrGxsrFxcq/v9DDw8nFxcnGxszGxsnFxcvExMvGxsjFxcrFxcfHx8rExMfFxcrHx8vPz8/GxsnGxsvGxspGGeEnAAAAFnRSTlMAIO/fvxBAgF+vkFBwoDCfYG9/EKDPE/0fswAAA1NJREFUWMPNWdkOozAMrO0cJOEs7Pz/p24viVZgDKUrrZ8qSifDOBm75mIHVbFzwgDA4lIs7eVs0OAYi2A30PeY/ioAICn3gR44I4US0/Pql8jBAeCuH1eeoZ8EgCtfgXIXNm6YAEh1HDSOhu69ABL2a5oA3sXjDtzs1LjwzNSMuFMJnwF3IMk0Admbdwm4PpbdmiEGj1a5xaIimyevYiRFVSPHWymugGwg6JmrNlCjCXAYt2UD1cDlVhE+Xk5EBtOK7IJ0ORUJ4lcWk/EcrBfkZbqYTns+oyyErY3fOEYyVq7BnzI06EwmgPlE7jM/ASArH81IDZy5+Lv/2nvrsa4Hm7vXvedLrHQw/I0MYO2Gd7oC04kdGvKNvbX7mW6Zydops2Km625kbdykVA1NXQJ2nYRZWEPd594d0JkFfkjCAP9J0SzgE+IrYcHomRhvIUYFD5CnBmJVYkju6WZEY1uywGoNGGRqMDDw2TO1k9EaTKitffBoGlZbA2vrsr4PvAPXSmvwR2k5Xke83ZD2j1r/STZcR25EC5KugJDecug6pJusUTEvq2C0jFqlE2/QReVTW6VAy1l3ccphsAuG02QIcBdRNoLtFAR45Qu5+7NK1j79CiyrviRoP71r+TmAVa8DVMMwYHWT0mEjsg2bUR+ETSg2bI+kwGqW8AftjkIE0UxBQFoBN8ODtdUcwveFC9COw4Tq17AF6Z7yX8NGRCWbp2ATipZNAdmoLVg5oFrOHYoNW+AUS1BK5EJyxY7qVft3akH3ikkb3jkvRmCzXz9k9ALSfYjY+pNyBdOG98X1RWvguoU6ALUuuC5j3Gq2fALituAOURtroFkb/VHJrA1JKjireNAEJfTOXFDmrFeHZozi1MlTBZmTN6t7NmRmOKt7Oq5PsjNd+gUqAeHTy9wJNPXceUZ9HnVYdK7lN2OKaqVH9ueHKv9mBDSuPkI+ubdIaduvZ1C51ZpzXL9HXabrPG7WUe+4jORPDFq1aOW7sTC3Px9iD7yDis9KrdF4OCCPu14mKJlTRhhcdhJYTgz0WfqRYXqQOzDZTOGCAbVUAk3YWLlTQI0oDoA0a5x91TFsULXsvl7DxRLIP65QqHJ6Xo3j//XS8BVtiWl+xdnFfgfkX5IuOdnZO1hkAAAAAElFTkSuQmCC";
                        } else {
                            str = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFYAAABWCAMAAABiiJHFAAAAUVBMVEUAAAAwMDAvMDIvMDMwMDAvMDMuMDMwMDQvMDMuMDIvMDIuMDIvMDMvMDIwMDIwMDQuMDIuMDIuMDMuMDMwMDMwMDksMDMwMDQvMDIwMDMvMDP4jtSAAAAAGnRSTlMAIN/vEL+gQK9gcIBf7zCAf5CPb1AgUE/PkOnu4qQAAANqSURBVFjDtVntluIwCBVI0qSZVqvtrHPf/0G3Op5T3Ujph8svT403eIEL4sG2IeXgWTCasI+5bw97bbh4QWHiL7Qd050Yo3HsUjUM9ydD1ef4+3QjcuUBNCG58i1KgQH4fhNoE6qZAwEAf60HPbr5Q5QY4Go5pxFoFvlxAw4LOf6WyVPTjguZcGfArwgyBeDszFOMpl4X3VrAhh+tcsRyhWcr70sQ3Ya6iZCvGVTgx0DQI/c1g3o0AVbjtmKgGrjSKsTPoNrWQegN7Yx42GURXIb7fHu4yxzjXFQ3GjrsNBL0BbG18RkviGTUG+T1GwcE05PRxMD1r/GpALLiERwFePPyZ/21c+t+r4MYxzL8c7zYCofAjc4AVjY8u8swldgjkAt2aqfJ3e/CWSVkS5JwctePztq4UekaGrsELKqEiViDXfdI4mA2+EtkAeQas9nAA/IjYJUxMwmejI0OXoF/OWCrE4O7NLjxddt3DGs0EJDJwUWA15mpDcZoEFBbeTANDf+OBlbqip4HzitDQy24Kur8KPF2htqr2v+JZ1SHQWOJRZ0BJn3k0HmISIeMrHLU0Oz8U6vNMo/Qf1R/aqsVaP6Eg1eKwW4YXqOhgj+wkgi2UhDglDf4ps+qs3b1K7Ci6hKjfdWu8nUFUbUOUAXDgC1FyobN6GzYDvVK2DHvbNiEqMBqknAdqTWNwIooKAlWJojyee02j2p74wK0cghIn4a9qVdG92nYjHyL5h5YLYsIrEmxaS1EKVAt5l7Ty1cSvSIJN4BkVNlcj1VapNbQXSHSinZqlxHEnNdXCT2DdB0isX6knNDQjPbl95fWwGkO9QLUOuE6jUcg0Nw+5zhPuEfW1hoI71Z/Q9+JtiRJ8FbzoADF9Mmcx4Q3p3y6+AaFsVc3Twk8BW9id6/x5OHE7m47gV9yTegTqARUr1rm14PYdecE9X7USzG59h+ggaTMqO4TS5Wf/7cCKr/CeWdukTK2n/agNq1WeDhtRy3DtR/3rKPecLcuWo1desvb1sJNax6RemVtLdlQu07pNYqRB36WEJdYiZyywmj6hQ6UGwM9xGtiXPENmGxP4SsDqmQC838VKaCG9R4Ah3c+uzRi2qBq2338DZf7argzOAxV6uLv0+PKurEbeuMvw2GvtX2Onps7HvuQ0wLIv+DfQmF45JSiAAAAAElFTkSuQmCC";
                        }
                        ImageKt.a(null, null, null, null, null, v3, null, 0, null, null, str, null, null, null, null, null, null, null, null, null, null, composer3, 262144, 0, 0, 2096095);
                        SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 24.0f), composer3, 8, 0);
                        h color$default = QUIToken.color$default("text_primary");
                        c.Companion companion3 = bp3.c.INSTANCE;
                        TextKt.a("\u52a0\u8f7d\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5", null, null, color$default, Float.valueOf(17.0f), null, companion3.e(), null, null, null, null, Float.valueOf(24.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601542, 48, 0, 134215590);
                        SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 16.0f), composer3, 8, 0);
                        i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 88.0f), 29.0f);
                        k kVar = new k(null, Float.valueOf(14.0f), companion3.e(), null, null, null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, 16121, null);
                        final Function0<Unit> function02 = this.$reload;
                        composer3.startReplaceableGroup(1157296644);
                        boolean changed = composer3.changed(function02);
                        Object rememberedValue = composer3.rememberedValue();
                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.CategoryHomeErrorViewKt$CategoryHomeErrorView$1$1$1
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
                        QUIButtonKt.QUIButton(k3, null, null, "\u91cd\u65b0\u52a0\u8f7d", kVar, (Function1) rememberedValue, null, null, composer3, (k.f28903n << 12) | 3080, 198);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.CategoryHomeErrorViewKt$CategoryHomeErrorView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                CategoryHomeErrorViewKt.CategoryHomeErrorView(function0, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
