package com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.BaseKt;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.ReportKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.GuardFastClickKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterViewModel;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerReport;
import com.tencent.hippykotlin.demo.pages.adelie.page.kuikly.manager.AdelieManagerViewModel$DisplayDataOption;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.material.n;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import common.config.service.QzoneConfig;
import defpackage.k;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt__MathJVMKt;
import org.slf4j.Marker;
import yo3.Offset;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class UserDataSectionKt {
    public static final void DataItem(final String str, final long j3, final float f16, Composer composer, final int i3) {
        int i16;
        Pair<String, String> pair;
        Composer startRestartGroup = composer.startRestartGroup(-547981473);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(str) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i3 & 112) == 0) {
            i16 |= startRestartGroup.changed(j3) ? 32 : 16;
        }
        if ((i3 & 896) == 0) {
            i16 |= startRestartGroup.changed(f16) ? 256 : 128;
        }
        final int i17 = i16;
        if ((i17 & TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_EMPTY) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-547981473, i17, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.DataItem (UserDataSection.kt:143)");
            }
            if (j3 >= 0) {
                pair = BaseKt.getToChineseUnit(j3);
            } else {
                pair = new Pair<>("-", null);
            }
            final Pair<String, String> pair2 = pair;
            KLog.INSTANCE.i("", "countPair=" + pair2);
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                if (k.a(c.f117352a)) {
                    rememberedValue = new n("DIN-NextLT-Pro-QQ");
                } else {
                    rememberedValue = new n("DINNextLTPro-Bold");
                }
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            final n nVar = (n) rememberedValue;
            ColumnKt.a(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.k(i.INSTANCE, 50.0f), 93.0f), null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 385522518, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserDataSectionKt$DataItem$1
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
                            ComposerKt.traceEventStart(385522518, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.DataItem.<anonymous> (UserDataSection.kt:155)");
                        }
                        a aVar = a.f339245a;
                        a.d g16 = aVar.g();
                        Alignment.Vertical c16 = Alignment.INSTANCE.c();
                        i.Companion companion = i.INSTANCE;
                        i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), 20.0f);
                        final String str2 = str;
                        final int i18 = i17;
                        final float f17 = f16;
                        RowKt.a(k3, g16, c16, null, null, ComposableLambdaKt.composableLambda(composer3, -706417416, true, new Function3<com.tencent.ntcompose.foundation.layout.n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserDataSectionKt$DataItem$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(com.tencent.ntcompose.foundation.layout.n nVar2, Composer composer4, Integer num2) {
                                int roundToInt;
                                String str3;
                                h color$default;
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-706417416, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.DataItem.<anonymous>.<anonymous> (UserDataSection.kt:160)");
                                    }
                                    h color$default2 = QUIToken.color$default("text_secondary");
                                    c.Companion companion2 = bp3.c.INSTANCE;
                                    bp3.c e16 = companion2.e();
                                    int a16 = ai.INSTANCE.a();
                                    n nVar3 = new n("PingFang SC");
                                    String str4 = str2;
                                    Float valueOf = Float.valueOf(14.0f);
                                    ai f18 = ai.f(a16);
                                    Float valueOf2 = Float.valueOf(20.0f);
                                    int i19 = (i18 & 14) | 1601536;
                                    int i26 = n.f339436b;
                                    TextKt.a(str4, null, null, color$default2, valueOf, null, e16, nVar3, null, null, f18, valueOf2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, i19 | (i26 << 21), 48, 0, 134214438);
                                    if (!Float.isNaN(f17)) {
                                        if (!(f17 == 0.0f)) {
                                            SpacerKt.a(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 2.0f), composer5, 8, 0);
                                            float f19 = f17;
                                            float abs = Math.abs(f19);
                                            double pow = Math.pow(10.0d, 1);
                                            roundToInt = MathKt__MathJVMKt.roundToInt(abs * pow);
                                            double d16 = roundToInt / pow;
                                            StringBuilder sb5 = new StringBuilder();
                                            if (f19 < 0.0f) {
                                                str3 = "-";
                                            } else {
                                                str3 = Marker.ANY_NON_NULL_MARKER;
                                            }
                                            sb5.append(str3);
                                            sb5.append(Math.abs(d16));
                                            sb5.append('%');
                                            String sb6 = sb5.toString();
                                            if (f17 > 0.0f) {
                                                color$default = QUIToken.color$default("feedback_error");
                                            } else {
                                                color$default = QUIToken.color$default("feedback_success");
                                            }
                                            TextKt.a(sb6, null, null, color$default, Float.valueOf(12.0f), null, companion2.f(), new n("PingFang SC"), null, null, null, Float.valueOf(17.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, (i26 << 21) | 1601536, 48, 0, 134215462);
                                        }
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 196680, 24);
                        com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
                        SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, k.a(cVar) ? 4.0f : 6.0f), composer3, 8, 0);
                        a.d g17 = aVar.g();
                        i k16 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), k.a(cVar) ? 26.0f : 24.0f);
                        final Pair<String, String> pair3 = pair2;
                        final n nVar2 = nVar;
                        RowKt.a(k16, g17, null, null, null, ComposableLambdaKt.composableLambda(composer3, -1107850513, true, new Function3<com.tencent.ntcompose.foundation.layout.n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserDataSectionKt$DataItem$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(com.tencent.ntcompose.foundation.layout.n nVar3, Composer composer4, Integer num2) {
                                bp3.c h16;
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1107850513, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.DataItem.<anonymous>.<anonymous> (UserDataSection.kt:190)");
                                    }
                                    String first = pair3.getFirst();
                                    h color$default = QUIToken.color$default("text_primary");
                                    com.tencent.kuikly.core.manager.c cVar2 = com.tencent.kuikly.core.manager.c.f117352a;
                                    float f18 = k.a(cVar2) ? 17.0f : 20.0f;
                                    float f19 = k.a(cVar2) ? 25.0f : 24.0f;
                                    if (k.a(cVar2)) {
                                        h16 = bp3.c.INSTANCE.f();
                                    } else {
                                        h16 = bp3.c.INSTANCE.h();
                                    }
                                    TextKt.a(first, null, null, color$default, Float.valueOf(f18), null, h16, nVar2, null, null, ai.f(ai.INSTANCE.a()), Float.valueOf(f19), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, (n.f339436b << 21) | 4096, 0, 0, 134214438);
                                    final String second = pair3.getSecond();
                                    if (second != null) {
                                        final n nVar4 = nVar2;
                                        i.Companion companion2 = i.INSTANCE;
                                        SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion2, 2.0f), composer5, 8, 0);
                                        ColumnKt.a(ComposeLayoutPropUpdaterKt.k(companion2, 24.0f), a.f339245a.h(), Alignment.INSTANCE.e(), null, ComposableLambdaKt.composableLambda(composer5, 1825472090, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserDataSectionKt$DataItem$1$2$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(d dVar2, Composer composer6, Integer num3) {
                                                Composer composer7 = composer6;
                                                int intValue3 = num3.intValue();
                                                if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                    composer7.skipToGroupEnd();
                                                } else {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1825472090, intValue3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.DataItem.<anonymous>.<anonymous>.<anonymous>.<anonymous> (UserDataSection.kt:206)");
                                                    }
                                                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(i.INSTANCE, 6.0f), composer7, 8, 0);
                                                    TextKt.a(second, null, null, QUIToken.color$default("text_primary"), Float.valueOf(12.0f), null, bp3.c.INSTANCE.h(), nVar4, null, null, ai.f(ai.INSTANCE.a()), Float.valueOf(16.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, (n.f339436b << 21) | 1601536, 48, 0, 134214438);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), composer5, 24648, 8);
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 196680, 28);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 24584, 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserDataSectionKt$DataItem$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                UserDataSectionKt.DataItem(str, j3, f16, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void UserDataSection(final AdelieManagerCenterViewModel adelieManagerCenterViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-600820325);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-600820325, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserDataSection (UserDataSection.kt:57)");
        }
        ColumnKt.a(ComposeLayoutPropUpdaterKt.m(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), 16.0f, 16.0f, 16.0f, 16.0f), null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1382684206, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserDataSectionKt$UserDataSection$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(d dVar, Composer composer2, Integer num) {
                List listOf;
                List listOf2;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1382684206, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserDataSection.<anonymous> (UserDataSection.kt:58)");
                    }
                    listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"\u597d\u53cb\u6570\u6307\u548c\u667a\u80fd\u4f53\u804a\u8fc7\u7684\u7528\u6237\u6570\uff1b", "\u6d88\u606f\u6570\u6307\u7528\u6237\u53d1\u7ed9\u667a\u80fd\u4f53\u7684\u6d88\u606f\u6570\uff1b", "\u8bbf\u5ba2\u6570\u6307\u8bbf\u95ee\u667a\u80fd\u4f53\u8d44\u6599\u5361\u7684\u7528\u6237\u6570\uff1b"});
                    UserDataSectionKt.access$DataHeader("\u7d2f\u8ba1\u6570\u636e", listOf, composer3, 6);
                    i.Companion companion = i.INSTANCE;
                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 10.0f), composer3, 8, 0);
                    a aVar = a.f339245a;
                    a.e e16 = aVar.e();
                    Alignment.Companion companion2 = Alignment.INSTANCE;
                    Alignment.Vertical c16 = companion2.c();
                    i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), 50.0f);
                    final AdelieManagerCenterViewModel adelieManagerCenterViewModel2 = AdelieManagerCenterViewModel.this;
                    RowKt.a(k3, e16, c16, null, null, ComposableLambdaKt.composableLambda(composer3, 1421858548, true, new Function3<com.tencent.ntcompose.foundation.layout.n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserDataSectionKt$UserDataSection$1.1
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(com.tencent.ntcompose.foundation.layout.n nVar, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1421858548, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserDataSection.<anonymous>.<anonymous> (UserDataSection.kt:69)");
                                }
                                Long value = AdelieManagerCenterViewModel.this.friendCount._state.getValue();
                                UserDataSectionKt.DataItem("\u597d\u53cb", value != null ? value.longValue() : 0L, Float.NaN, composer5, 390);
                                Long value2 = AdelieManagerCenterViewModel.this.msgCount._state.getValue();
                                UserDataSectionKt.DataItem(QzoneConfig.DefaultValue.DEFAULT_PASSIVE_FEED_TAB_NAME, value2 != null ? value2.longValue() : 0L, Float.NaN, composer5, 390);
                                Long value3 = AdelieManagerCenterViewModel.this.visitorCount._state.getValue();
                                UserDataSectionKt.DataItem("\u8bbf\u5ba2", value3 != null ? value3.longValue() : 0L, Float.NaN, composer5, 390);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 196680, 24);
                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 20.0f), composer3, 8, 0);
                    listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"\u7edf\u8ba1\u6700\u8fd1\u7b2c7\u592900:00\u5230\u6628\u592923:59\u7684\u6570\u636e\uff0c\u6bcf\u65e510\u70b9\u66f4\u65b0\uff08\u53ef\u80fd\u5b58\u5728\u6570\u636e\u5ef6\u8fdf\uff09\uff1b", "\u53d8\u5316\u7387\u4e3a\u5bf9\u6bd4\u4e0a\u4e00\u4e2a\u7edf\u8ba1\u4e03\u65e5\u7684\u6570\u636e\u6da8\u8dcc\u53d8\u5316\uff1b"});
                    UserDataSectionKt.access$DataHeader("\u8fd17\u65e5\u6570\u636e", listOf2, composer3, 6);
                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 10.0f), composer3, 8, 0);
                    a.e e17 = aVar.e();
                    Alignment.Vertical c17 = companion2.c();
                    i k16 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), 50.0f);
                    final AdelieManagerCenterViewModel adelieManagerCenterViewModel3 = AdelieManagerCenterViewModel.this;
                    RowKt.a(k16, e17, c17, null, null, ComposableLambdaKt.composableLambda(composer3, 162104619, true, new Function3<com.tencent.ntcompose.foundation.layout.n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserDataSectionKt$UserDataSection$1.2
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(com.tencent.ntcompose.foundation.layout.n nVar, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(162104619, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserDataSection.<anonymous>.<anonymous> (UserDataSection.kt:84)");
                                }
                                Long value = AdelieManagerCenterViewModel.this.last7DaysFriendCount._state.getValue();
                                long longValue = value != null ? value.longValue() : 0L;
                                Float value2 = AdelieManagerCenterViewModel.this.last7DaysFriendGrowthRate._state.getValue();
                                UserDataSectionKt.DataItem("\u65b0\u589e\u597d\u53cb", longValue, value2 != null ? value2.floatValue() : Float.NaN, composer5, 6);
                                Long value3 = AdelieManagerCenterViewModel.this.last7DaysMsgCount._state.getValue();
                                long longValue2 = value3 != null ? value3.longValue() : 0L;
                                Float value4 = AdelieManagerCenterViewModel.this.last7DaysMsgGrowthRate._state.getValue();
                                UserDataSectionKt.DataItem(QzoneConfig.DefaultValue.DEFAULT_PASSIVE_FEED_TAB_NAME, longValue2, value4 != null ? value4.floatValue() : Float.NaN, composer5, 6);
                                Long value5 = AdelieManagerCenterViewModel.this.last7DaysVisitorCount._state.getValue();
                                long longValue3 = value5 != null ? value5.longValue() : 0L;
                                Float value6 = AdelieManagerCenterViewModel.this.last7DaysVisitorGrowthRate._state.getValue();
                                UserDataSectionKt.DataItem("\u8bbf\u5ba2", longValue3, value6 != null ? value6.floatValue() : Float.NaN, composer5, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 196680, 24);
                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 16.0f), composer3, 8, 0);
                    AdelieManagerViewModel$DisplayDataOption adelieManagerViewModel$DisplayDataOption = AdelieManagerCenterViewModel.this.displayDataOption;
                    UserDataSectionKt.access$UserOptionView(adelieManagerViewModel$DisplayDataOption.option, adelieManagerViewModel$DisplayDataOption.jumpUrl, composer3, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 24584, 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserDataSectionKt$UserDataSection$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                UserDataSectionKt.UserDataSection(AdelieManagerCenterViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$TextList(final List list, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(2054867708);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2054867708, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.TextList (UserDataSection.kt:269)");
        }
        ColumnKt.a(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null)), null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1766293083, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserDataSectionKt$TextList$1
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
                        ComposerKt.traceEventStart(-1766293083, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.TextList.<anonymous> (UserDataSection.kt:272)");
                    }
                    for (final String str : list) {
                        RowKt.a(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null)), null, null, null, null, ComposableLambdaKt.composableLambda(composer3, 1178211447, true, new Function3<com.tencent.ntcompose.foundation.layout.n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserDataSectionKt$TextList$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(com.tencent.ntcompose.foundation.layout.n nVar, Composer composer4, Integer num2) {
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1178211447, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.TextList.<anonymous>.<anonymous>.<anonymous> (UserDataSection.kt:276)");
                                    }
                                    i.Companion companion = i.INSTANCE;
                                    SpacerKt.a(ModifiersKt.q(ModifiersKt.c(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(companion, 6.0f), 0.0f, 7.0f, 8.0f, 0.0f, 9, null), QUIToken.color$default("text_secondary")), uo3.c.a(3.0f)), composer5, 8, 0);
                                    h color$default = QUIToken.color$default("text_secondary");
                                    int e16 = ai.INSTANCE.e();
                                    bp3.c e17 = bp3.c.INSTANCE.e();
                                    TextKt.a(str, ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), null, color$default, Float.valueOf(14.0f), null, e17, null, null, null, ai.f(e16), Float.valueOf(18.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 1601600, 48, 0, 134214564);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 196616, 30);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 24584, 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserDataSectionKt$TextList$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                UserDataSectionKt.access$TextList(list, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$DataHeader(final String str, final List list, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-1687403437);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1687403437, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.DataHeader (UserDataSection.kt:95)");
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new Offset(0.0f, 0.0f), null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue;
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState2 = (MutableState) rememberedValue2;
        RowKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 24.0f), a.f339245a.g(), Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -737025035, true, new Function3<com.tencent.ntcompose.foundation.layout.n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserDataSectionKt$DataHeader$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(com.tencent.ntcompose.foundation.layout.n nVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-737025035, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.DataHeader.<anonymous> (UserDataSection.kt:103)");
                    }
                    TextKt.a(str, null, null, QUIToken.color$default("text_primary"), Float.valueOf(17.0f), null, bp3.c.INSTANCE.e(), new n("PingFang SC"), null, null, null, Float.valueOf(24.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, (i3 & 14) | 1601536 | (n.f339436b << 21), 48, 0, 134215462);
                    i u16 = ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 22.0f);
                    final MutableState<Boolean> mutableState3 = mutableState2;
                    composer3.startReplaceableGroup(1157296644);
                    boolean changed = composer3.changed(mutableState3);
                    Object rememberedValue3 = composer3.rememberedValue();
                    if (changed || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue3 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserDataSectionKt$DataHeader$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                final MutableState<Boolean> mutableState4 = mutableState3;
                                GuardFastClickKt.guardFastClick(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserDataSectionKt$DataHeader$1$1$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        mutableState4.setValue(Boolean.TRUE);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue3);
                    }
                    composer3.endReplaceableGroup();
                    i d16 = ViewEventPropUpdaterKt.d(u16, false, null, (Function1) rememberedValue3, 3, null);
                    Alignment alignment = Alignment.Center;
                    final MutableState<Offset> mutableState4 = mutableState;
                    BoxKt.a(d16, alignment, null, ComposableLambdaKt.composableLambda(composer3, -1670221317, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserDataSectionKt$DataHeader$1.2
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1670221317, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.DataHeader.<anonymous>.<anonymous> (UserDataSection.kt:120)");
                                }
                                final float f16 = 16.0f;
                                i u17 = ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 16.0f);
                                MutableState<Offset> mutableState5 = MutableState.this;
                                Float valueOf = Float.valueOf(16.0f);
                                final MutableState<Offset> mutableState6 = MutableState.this;
                                composer5.startReplaceableGroup(511388516);
                                boolean changed2 = composer5.changed(mutableState5) | composer5.changed(valueOf);
                                Object rememberedValue4 = composer5.rememberedValue();
                                if (changed2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue4 = new Function1<ap3.a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserDataSectionKt$DataHeader$1$2$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ap3.a aVar) {
                                            Offset d17 = ap3.d.d(aVar);
                                            mutableState6.setValue(new Offset((f16 / 2) + d17.getX(), d17.getY() + f16 + 4.0f));
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composer5.updateRememberedValue(rememberedValue4);
                                }
                                composer5.endReplaceableGroup();
                                ImageKt.a(null, null, null, null, null, ViewEventPropUpdaterKt.k(u17, (Function1) rememberedValue4), null, com.tencent.ntcompose.material.h.INSTANCE.a(), null, null, QUIToken.INSTANCE.image("info_circle", QUIToken.color$default("icon_tertiary")), null, null, null, null, null, null, null, null, null, null, composer5, 12845056, 0, 0, 2095967);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 3128, 4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 196680, 24);
        if (((Boolean) mutableState2.getValue()).booleanValue()) {
            FullScreenArrowLayer fullScreenArrowLayer = FullScreenArrowLayer.INSTANCE;
            Offset offset = (Offset) mutableState.getValue();
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, -983821098, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserDataSectionKt$DataHeader$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 11) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-983821098, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.DataHeader.<anonymous> (UserDataSection.kt:136)");
                        }
                        UserDataSectionKt.access$TextList(list, composer3, 8);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            });
            startRestartGroup.startReplaceableGroup(1157296644);
            boolean changed = startRestartGroup.changed(mutableState2);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserDataSectionKt$DataHeader$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        mutableState2.setValue(Boolean.FALSE);
                        return Unit.INSTANCE;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceableGroup();
            fullScreenArrowLayer.CustomizeBubbleView(offset, composableLambda, (Function0) rememberedValue3, startRestartGroup, Offset.f450729d | 3120, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserDataSectionKt$DataHeader$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                UserDataSectionKt.access$DataHeader(str, list, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$UserOptionView(final String str, final String str2, Composer composer, final int i3) {
        final int i16;
        Composer startRestartGroup = composer.startRestartGroup(800420594);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(str) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i3 & 112) == 0) {
            i16 |= startRestartGroup.changed(str2) ? 32 : 16;
        }
        if ((i16 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(800420594, i16, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserOptionView (UserDataSection.kt:224)");
            }
            a.e e16 = a.f339245a.e();
            Alignment.Vertical c16 = Alignment.INSTANCE.c();
            i r16 = ComposeLayoutPropUpdaterKt.r(ModifiersKt.j(ModifiersKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 32.0f), new h(436247039L)), 4.0f), 12.0f, 6.0f, 12.0f, 6.0f);
            startRestartGroup.startReplaceableGroup(1157296644);
            boolean changed = startRestartGroup.changed(str2);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserDataSectionKt$UserOptionView$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ClickParams clickParams) {
                        final String str3 = str2;
                        GuardFastClickKt.guardFastClick(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserDataSectionKt$UserOptionView$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                KLog kLog = KLog.INSTANCE;
                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("click option : ");
                                m3.append(str3);
                                kLog.i("AdelieManagerPage", m3.toString());
                                e eVar = new e();
                                eVar.v("dt_pgid", "pg_bas_agent_management");
                                e eVar2 = new e();
                                eVar2.v("dt_pgid", "pg_bas_agent_management");
                                eVar2.v("agent_id", AdelieManagerReport.uid);
                                eVar2.u("agent_uin", AdelieManagerReport.uin);
                                eVar.v("cur_pg", eVar2);
                                eVar.v("dt_eid", "em_bas_text_chain");
                                ReportKt.reportCustomDTEvent("dt_clck", eVar);
                                QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                QQKuiklyPlatformApi.Companion.openPage$default(str3, false, 6);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            RowKt.a(ViewEventPropUpdaterKt.r(ViewEventPropUpdaterKt.d(r16, false, null, (Function1) rememberedValue, 3, null), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserDataSectionKt$UserOptionView$2
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object obj) {
                    e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_agent_management");
                    e m16 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_agent_management");
                    m16.v("agent_id", AdelieManagerReport.uid);
                    m16.u("agent_uin", AdelieManagerReport.uin);
                    m3.v("cur_pg", m16);
                    m3.v("dt_eid", "em_bas_text_chain");
                    ReportKt.reportCustomDTEvent("dt_imp", m3);
                    return Unit.INSTANCE;
                }
            }), e16, c16, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 286871828, true, new Function3<com.tencent.ntcompose.foundation.layout.n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserDataSectionKt$UserOptionView$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(com.tencent.ntcompose.foundation.layout.n nVar, Composer composer2, Integer num) {
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 81) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(286871828, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserOptionView.<anonymous> (UserDataSection.kt:251)");
                        }
                        QUIToken qUIToken = QUIToken.INSTANCE;
                        h color$default = QUIToken.color$default("brand_standard");
                        n nVar2 = new n("PingFang SC");
                        TextKt.a(str, null, null, color$default, Float.valueOf(14.0f), null, bp3.c.INSTANCE.e(), nVar2, null, null, null, Float.valueOf(20.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, (i16 & 14) | 1601536 | (n.f339436b << 21), 48, 0, 134215462);
                        ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 16.0f), null, com.tencent.ntcompose.material.h.INSTANCE.a(), null, null, qUIToken.image("chevron_right", QUIToken.color$default("brand_standard")), null, null, null, null, null, null, null, null, null, null, composer3, 12845056, 0, 0, 2095967);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 196680, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.UserDataSectionKt$UserOptionView$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                UserDataSectionKt.access$UserOptionView(str, str2, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
