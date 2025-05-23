package com.tencent.hippykotlin.demo.pages.qq_intimate_space.component;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import bp3.k;
import com.gcloudsdk.gcloud.voice.GCloudVoiceErrorCode;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterCommissionPercentRange$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.h;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.ao;
import e25.aj;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class LoveWallWaterDropKt {
    public static final void LoveWallWaterDrop(final i iVar, final aj ajVar, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(1549146607);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1549146607, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallWaterDrop (LoveWallWaterDrop.kt:22)");
        }
        ColumnKt.a(iVar, a.f339245a.b(), Alignment.INSTANCE.b(), null, ComposableLambdaKt.composableLambda(startRestartGroup, 127328792, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallWaterDropKt$LoveWallWaterDrop$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(d dVar, Composer composer2, Integer num) {
                int i16;
                d dVar2 = dVar;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 14) == 0) {
                    i16 = (composer3.changed(dVar2) ? 4 : 2) | intValue;
                } else {
                    i16 = intValue;
                }
                if ((i16 & 91) == 18 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(127328792, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallWaterDrop.<anonymous> (LoveWallWaterDrop.kt:30)");
                    }
                    i.Companion companion = i.INSTANCE;
                    i u16 = ComposeLayoutPropUpdaterKt.u(companion, 60.0f);
                    final aj ajVar2 = aj.this;
                    BoxKt.a(u16, null, null, ComposableLambdaKt.composableLambda(composer3, -1844485934, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallWaterDropKt$LoveWallWaterDrop$1.1
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar, Composer composer4, Integer num2) {
                            String str;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1844485934, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallWaterDrop.<anonymous>.<anonymous> (LoveWallWaterDrop.kt:33)");
                                }
                                i.Companion companion2 = i.INSTANCE;
                                i h16 = ComposeLayoutPropUpdaterKt.h(companion2, 0.0f, 1, null);
                                if (aj.this.f395463i > 0) {
                                    str = "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_pMEDoDyEEdx.png";
                                } else {
                                    str = "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_IyBNBy9O8YF.png";
                                }
                                ImageKt.a(null, null, null, null, null, h16, null, 0, null, null, str, null, null, null, null, null, null, null, null, null, null, composer5, 262144, 0, 0, 2096095);
                                i h17 = ComposeLayoutPropUpdaterKt.h(companion2, 0.0f, 1, null);
                                Alignment alignment = Alignment.Center;
                                final aj ajVar3 = aj.this;
                                BoxKt.a(h17, alignment, null, ComposableLambdaKt.composableLambda(composer5, 68889100, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallWaterDropKt.LoveWallWaterDrop.1.1.1
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(b bVar2, Composer composer6, Integer num3) {
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(68889100, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallWaterDrop.<anonymous>.<anonymous>.<anonymous> (LoveWallWaterDrop.kt:45)");
                                            }
                                            i.Companion companion3 = i.INSTANCE;
                                            StringBuilder sb5 = new StringBuilder();
                                            aj ajVar4 = aj.this;
                                            long j3 = ajVar4.f395463i;
                                            if (j3 <= 0) {
                                                j3 = ajVar4.f395462h;
                                            }
                                            LoveWallGradientOutLineTextKt.LoveWallGradientOutLineText(companion3, null, GoodsCenterCommissionPercentRange$$ExternalSyntheticOutline0.m(sb5, j3, 'g'), companion3, new k(new h(0, 152, 208, 1.0f), Float.valueOf(12.0f), c.INSTANCE.g(), null, null, null, null, null, null, null, null, null, null, null, 16376, null), new ao(h.INSTANCE.m(), com.tencent.ntcompose.activity.b.a().getPageData().getIsIOS() ? -15.0f : 5.0f), composer7, (k.f28903n << 12) | GCloudVoiceErrorCode.GCloudVoiceErrno.GCLOUD_VOICE_OPENFILE_ERR, 2);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 3128, 4);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 3080, 6);
                    LoveWallGradientOutLineTextKt.LoveWallGradientOutLineText(dVar2.b(companion, Alignment.INSTANCE.b()), null, aj.this.f395461f, ComposeLayoutPropUpdaterKt.B(companion), new k(h.INSTANCE.m(), Float.valueOf(10.0f), new c(600), null, null, null, null, null, null, null, null, null, null, null, 16376, null), new ao(new h(0, 130, 195, 1.0f), com.tencent.ntcompose.activity.b.a().getPageData().getIsIOS() ? -10.0f : 5.0f), composer3, (k.f28903n << 12) | GCloudVoiceErrorCode.GCloudVoiceErrno.GCLOUD_VOICE_OPENFILE_ERR, 2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 24648, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallWaterDropKt$LoveWallWaterDrop$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallWaterDropKt.LoveWallWaterDrop(i.this, ajVar, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
