package com.tencent.hippykotlin.demo.pages.adelie.common.compose.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.ButtonKt;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.material.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ErrorViewKt {
    public static final void ErrorView(final Function0<Unit> function0, Composer composer, final int i3) {
        final int i16;
        Composer startRestartGroup = composer.startRestartGroup(-1702068832);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(function0) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i16 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1702068832, i16, -1, "com.tencent.hippykotlin.demo.pages.adelie.common.compose.view.ErrorView (ErrorView.kt:27)");
            }
            c cVar = c.f117352a;
            float m3 = cVar.g().getPageData().m() / 0.9236453f;
            Alignment.Horizontal b16 = Alignment.INSTANCE.b();
            i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, cVar.g().getPageData().m() - 32.0f), m3);
            startRestartGroup.startReplaceableGroup(1157296644);
            boolean changed = startRestartGroup.changed(function0);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.compose.view.ErrorViewKt$ErrorView$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ClickParams clickParams) {
                        KLog.INSTANCE.i("ErrorView", "reload server data");
                        function0.invoke();
                        return Unit.INSTANCE;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            ColumnKt.a(ViewEventPropUpdaterKt.d(k3, false, null, (Function1) rememberedValue, 3, null), null, b16, null, ComposableLambdaKt.composableLambda(startRestartGroup, -899766519, true, new Function3<d, Composer, Integer, Unit>(function0, i16) { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.compose.view.ErrorViewKt$ErrorView$2
                public final /* synthetic */ Function0<Unit> $reload;

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
                            ComposerKt.traceEventStart(-899766519, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.common.compose.view.ErrorView.<anonymous> (ErrorView.kt:37)");
                        }
                        i.Companion companion = i.INSTANCE;
                        SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 114.0f), composer3, 8, 0);
                        ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.v(companion, 80.0f, 80.0f), null, 0, null, null, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAKEAAACgCAMAAABT0/whAAAASFBMVEUAAAAwMDQwMDQvMDMwMDQwMDIvMDMvMDMvMDMwMDQwMDQwMDMwMDMwMDMwMDMvMDMuMDMvMDMuMDIvMDQvMDQwMDQwMDMvMDNHyf7OAAAAF3RSTlMAEEDfIGCf77+Av5BQcDCvj89/z1/PsCLwlV0AAAYsSURBVHja7ZzbctsgEIZZzggdbae8/5s2yHK3nbGFWCGU6ei76UVS5dceYAUL7OLi4uLi4iIT2SqntV3Qo1O8Zz8E4J0W4S3T4DiwUwE+TiHBNHJ2EqCsQSFGDNq7Tn3jnNfNlwnIoE4wJUd5X77r4a37fYMiW1YTuL3kNalI4+6lUoySVYLrxbEbnQdqWETqKhq5XaynICdmm1oa5dMcxkH2/9Sigka4GdSXj3pqvB2X2K2YI14xMgqfcADSov32aDzM1e3sYA+7X1QfY0YY43PvvIgzZjOO+K7lHupYIdxsRlnaw6Iv/Mam3ER4wwgsBfh53GFlmEOwY4Xp5mAs8rYaPVyUPnpaFxB4zwhqQjBOUELgHdghyKmAxCiwAXYQMOyWqAmhUukPYBYP7FDsroy+YQweBkw7xsUWs/hAIGZ0S8s0QxBIHHSMpL5bzyrQR18BLUs6VoWOlC0qFgusEp4QilLQLE/PFiPzR1JSltBD0Wb72LGKuEw/Q/Qxq8qUF1U39HEteJbXJE7n9fA5yaJxMqkHmBCGDBOqHauexipqsvDtJiR+0LwYgTYo2kNNOKJAWhgrNGJhE+Lz7y3/phX4p7Iw+GZHmNDGAQ2rUkuMRNjkLMFoBmgZ1r6GmM6OJRHEsfDpWRx+ielsNpX+8iyFsCWAhxAadpZCZtMBDIQ8Aa7eK+xayB8QDKTHDMje3WveKpwtoiA3Vx5JJ//KmefGOM99VhjRPK9ytsloUtnbU0a/V+jDE6tKuBkfDXn6TKPgU6ZAq8OMUKWy2W/OZPnU99XBei7LZSPKys3Z7BO1uNu2fRYiDd8y2vAmo95xIdzJNka4QH0phfj7An+fHGf45PTegOlyRuynr2/0QEQTNxsj0MP2OQU3yya55aOvWx0N/aYlfMGzZj10tZAbvqg0VT9uTzUyc17G3XPzSC8zicTsv8oD9/cIlYObgzG9QLL6Q0jnyINe2ygTJSZTRa6kskkKND2x+sIoviWL9ZVJ8Z4aq0S/rz6UyaVdEb1EHWxUzEWiQpRoHqnyyuUmOsL7/TW27JMFmF75mWcZ0BSSBkSsK9z5CjHWCiqU7xVyRqFbV/ggtdB8+goQivK40gq5fT5RzDMm1vLLQok8XeH4+pLSKEcu6xYWJ7nTFMr7LJC/hnOtvpm//+RSKqDuQgo7lkNvsG0m5iDiGBauoj8jl7HQGQAfHcH6GwvXB1UhfcRGgR1DpG8igwOGuFyJfn1O0XkCzWNLS1ZCYoadXM6SSI+V2JZo5SxNOtZUzvKrFCgwKTEnoac3Fqct7krbbh7VG8habuZri+zATgO/AlZrvNPPbKzURTi3kpHdYO3QyZ1ND/dkotObjQt01/s4oCT0E+EGJz2RTiLaxMZ3pAqfpzuvlhM/fE+tnlp4orc7djjRGaC/KCRWOOlteg8cWAnPwRXORJha8ijm/t3+AmoYeoqNczfbAJc2yPtm6R0XatmJGUncpU4aWRPDUBMKOcKOE+64EBcK0qu59G1FdDNxrspazaVvK1paNvN/I1wSB1aLTi6ezf+2NhD7xuSm/jRDy0L1dwuLToYTvU2FPtjaPxuM/J7dxo2mHzNmB0pnbzCTMPHfOxD9ILeZ2rCdXVUDEE2ot6alYhRUE3DL9CgTYvcRCeBKYfvFISbEdsrqoAnTDJjO9ZA5zVLSFDljdVR/NbZTVkXG0Mob2yZWldwe+rZ2styyhzhbaYGE3l8tTe2TC0ISPo2q5fNImsZ83RM0/n88hfTzT3LFUKyRLRJPw+XjCKc6SUdn3a4TVpYdyhCz5H8+2cpgwpL+AMAGXAkgS1zrePsRx7dhOvaUOgqkc+xJ/yIR5I+7LcGzMrjy94DAiDv55W7tkIU9bNrSQR1u5Srq8ukHvtxD+f3jPSU/4nIfGMMnD/+Iy32Wu6Sag+YAVeomqJYdBbiAGivcxUV3dRBaEvWFgeBgisbM80WgLH1pka4xbL4ZT5uAB5KqIL1YRFrH19XxW7Qexl892iG8sGPH4Y24vsM7MM0x7k1fa4iYyerROfVN50Y9iKdj8SjVSXD/FRJ8+fPvM3XDB5lCd/z0HqgXPVfO62ZBa6dayS4uLi4uLi6y+A3fw6XEU/JwPgAAAABJRU5ErkJggg==", null, null, null, null, null, null, null, null, null, null, composer3, 262144, 6, 0, 2096095);
                        SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 24.0f), composer3, 8, 0);
                        TextKt.a("\u52a0\u8f7d\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5", null, null, QUIToken.color$default("text_primary"), Float.valueOf(17.0f), null, bp3.c.INSTANCE.e(), null, null, null, null, Float.valueOf(24.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601542, 48, 0, 134215590);
                        SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 16.0f), composer3, 8, 0);
                        i f16 = ModifiersKt.f(ModifiersKt.j(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 88.0f), 29.0f), QUIToken.color$default("button_bg_secondary_default")), 4.0f), 1.0f, QUIToken.color$default("button_border_secondary_default"), BorderStyle.SOLID);
                        com.tencent.ntcompose.material.d a16 = e.f339415a.a(h.INSTANCE.n());
                        final Function0<Unit> function02 = this.$reload;
                        composer3.startReplaceableGroup(1157296644);
                        boolean changed2 = composer3.changed(function02);
                        Object rememberedValue2 = composer3.rememberedValue();
                        if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.compose.view.ErrorViewKt$ErrorView$2$1$1
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
                            composer3.updateRememberedValue(rememberedValue2);
                        }
                        composer3.endReplaceableGroup();
                        ButtonKt.a(null, (Function1) rememberedValue2, f16, a16, ComposableSingletons$ErrorViewKt.f3lambda1, composer3, 29184, 1);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.compose.view.ErrorViewKt$ErrorView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                ErrorViewKt.ErrorView(function0, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
