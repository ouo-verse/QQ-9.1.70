package com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.a;
import bp3.c;
import bp3.j;
import bp3.k;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.ReportKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerReport;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.HalfFloatingLayerKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIButtonKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQCommonNApiModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.vas.qid.QidPagView;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.ModalKt;
import com.tencent.ntcompose.material.RichTextKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.material.h;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.ntcompose.ui.platform.a;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt___StringsKt;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class OpenQZoneSheetKt {
    public static final void report(String str, String str2) {
        e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_agent_management");
        e m16 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_agent_management");
        m16.v("agent_id", AdelieManagerReport.uid);
        m16.u("agent_uin", AdelieManagerReport.uin);
        m3.v("cur_pg", m16);
        m3.v("dt_eid", str2);
        ReportKt.reportCustomDTEvent(str, m3);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OpenQZoneSheet(String str, String str2, Function0<Unit> function0, Function0<Unit> function02, Composer composer, final int i3, final int i16) {
        String str3;
        int i17;
        String str4;
        int i18;
        Function0<Unit> function03;
        int i19;
        Function0<Unit> function04;
        final int i26;
        final String str5;
        final Function0<Unit> function05;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1950175297);
        int i27 = i16 & 1;
        if (i27 != 0) {
            i17 = i3 | 6;
            str3 = str;
        } else if ((i3 & 14) == 0) {
            str3 = str;
            i17 = (startRestartGroup.changed(str3) ? 4 : 2) | i3;
        } else {
            str3 = str;
            i17 = i3;
        }
        int i28 = i16 & 2;
        if (i28 != 0) {
            i17 |= 48;
        } else if ((i3 & 112) == 0) {
            str4 = str2;
            i17 |= startRestartGroup.changed(str4) ? 32 : 16;
            i18 = i16 & 4;
            if (i18 == 0) {
                i17 |= MsgConstant.KRMFILETHUMBSIZE384;
            } else if ((i3 & 896) == 0) {
                function03 = function0;
                i17 |= startRestartGroup.changed(function03) ? 256 : 128;
                i19 = i16 & 8;
                if (i19 != 0) {
                    i17 |= 3072;
                } else if ((i3 & 7168) == 0) {
                    function04 = function02;
                    i17 |= startRestartGroup.changed(function04) ? 2048 : 1024;
                    i26 = i17;
                    if ((i26 & 5851) != 1170 && startRestartGroup.getSkipping()) {
                        startRestartGroup.skipToGroupEnd();
                        str5 = str4;
                        function05 = function04;
                    } else {
                        if (i27 != 0) {
                            str3 = null;
                        }
                        str5 = i28 == 0 ? null : str4;
                        Function0<Unit> function06 = i18 == 0 ? null : function03;
                        function05 = i19 == 0 ? function04 : null;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1950175297, i26, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheet (OpenQZoneSheet.kt:51)");
                        }
                        final float min = Math.min(((a) startRestartGroup.consume(CompositionLocalsKt.d())).e(), 428.0f);
                        float f16 = min / QidPagView.DESIGN_PAG_WIDTH;
                        final float f17 = f16 * 250;
                        final float f18 = f16 * 60;
                        final float f19 = f16 * 36;
                        final float f26 = f16 * 16;
                        final Function0<Unit> function07 = function05;
                        final String str6 = str3;
                        final Function0<Unit> function08 = function06;
                        final String str7 = str5;
                        ModalKt.a(ViewEventPropUpdaterKt.r(i.INSTANCE, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Object obj) {
                                OpenQZoneSheetKt.report("dt_imp", "em_bas_open_space_floating_layer");
                                return Unit.INSTANCE;
                            }
                        }), false, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1317032833, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2
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
                                        ComposerKt.traceEventStart(1317032833, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheet.<anonymous> (OpenQZoneSheet.kt:67)");
                                    }
                                    i f27 = ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.0f, 1, null);
                                    final Function0<Unit> function09 = function07;
                                    final int i29 = i26;
                                    final String str8 = str6;
                                    final float f28 = min;
                                    final Function0<Unit> function010 = function08;
                                    final float f29 = f17;
                                    final float f36 = f18;
                                    final float f37 = f19;
                                    final float f38 = f26;
                                    final String str9 = str7;
                                    BoxKt.a(f27, null, null, ComposableLambdaKt.composableLambda(composer3, 320318471, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                                    ComposerKt.traceEventStart(320318471, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheet.<anonymous>.<anonymous> (OpenQZoneSheet.kt:72)");
                                                }
                                                h color$default = QUIToken.color$default("bg_middle_light");
                                                final Function0<Unit> function011 = function09;
                                                composer5.startReplaceableGroup(1157296644);
                                                boolean changed = composer5.changed(function011);
                                                Object rememberedValue = composer5.rememberedValue();
                                                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2$1$1$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(Object obj) {
                                                            Function0<Unit> function012 = function011;
                                                            if (function012 != null) {
                                                                function012.invoke();
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    composer5.updateRememberedValue(rememberedValue);
                                                }
                                                composer5.endReplaceableGroup();
                                                Function1 function1 = (Function1) rememberedValue;
                                                Function2<Composer, Integer, Unit> function2 = ComposableSingletons$OpenQZoneSheetKt.f11lambda2;
                                                final String str10 = str8;
                                                final float f39 = f28;
                                                final Function0<Unit> function012 = function010;
                                                final int i36 = i29;
                                                final float f46 = f29;
                                                final float f47 = f36;
                                                final float f48 = f37;
                                                final float f49 = f38;
                                                final String str11 = str9;
                                                HalfFloatingLayerKt.HalfFloatingLayer(559.0f, 0.5f, color$default, 0.0f, function1, null, function2, ComposableLambdaKt.composableLambda(composer5, 2038013165, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt.OpenQZoneSheet.2.1.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public final Unit invoke(Composer composer6, Integer num3) {
                                                        Composer composer7 = composer6;
                                                        int intValue3 = num3.intValue();
                                                        if ((intValue3 & 11) == 2 && composer7.getSkipping()) {
                                                            composer7.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(2038013165, intValue3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheet.<anonymous>.<anonymous>.<anonymous> (OpenQZoneSheet.kt:95)");
                                                            }
                                                            i d16 = ViewEventPropUpdaterKt.d(ModifiersKt.d(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null)), QUIToken.color$default("bg_middle_light")), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt.OpenQZoneSheet.2.1.2.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }, 3, null);
                                                            Alignment.Horizontal horizontal = Alignment.Horizontal.CenterHorizontally;
                                                            final String str12 = str10;
                                                            final float f56 = f39;
                                                            final Function0<Unit> function013 = function012;
                                                            final int i37 = i36;
                                                            final float f57 = f46;
                                                            final float f58 = f47;
                                                            final float f59 = f48;
                                                            final float f65 = f49;
                                                            final String str13 = str11;
                                                            ColumnKt.a(d16, null, horizontal, null, ComposableLambdaKt.composableLambda(composer7, 1736859734, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt.OpenQZoneSheet.2.1.2.2
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(3);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function3
                                                                public final Unit invoke(d dVar, Composer composer8, Integer num4) {
                                                                    String take;
                                                                    Composer composer9 = composer8;
                                                                    int intValue4 = num4.intValue();
                                                                    if ((intValue4 & 81) == 16 && composer9.getSkipping()) {
                                                                        composer9.skipToGroupEnd();
                                                                    } else {
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(1736859734, intValue4, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheet.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OpenQZoneSheet.kt:105)");
                                                                        }
                                                                        String str14 = str12;
                                                                        composer9.startReplaceableGroup(-1994463563);
                                                                        if (str14 != null) {
                                                                            i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.A(i.INSTANCE), 0.0f, 23.0f, 0.0f, 0.0f, 13, null);
                                                                            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u606d\u559c\u4f60\n\u53ef\u4ee5\u4e3a\u300c");
                                                                            if (str14.length() > 6) {
                                                                                StringBuilder sb5 = new StringBuilder();
                                                                                take = StringsKt___StringsKt.take(str14, 6);
                                                                                sb5.append(take);
                                                                                sb5.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
                                                                                str14 = sb5.toString();
                                                                            }
                                                                            TextKt.a(OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(m3, str14, "\u300d\u5f00\u901a\u7a7a\u95f4\u5566"), n3, null, QUIToken.color$default("text_primary"), Float.valueOf(20.0f), null, c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.a()), Float.valueOf(30.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer9, 1601600, 48, 0, 134214564);
                                                                            Unit unit = Unit.INSTANCE;
                                                                        }
                                                                        composer9.endReplaceableGroup();
                                                                        i.Companion companion = i.INSTANCE;
                                                                        i n16 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, f56), 250.0f), 0.0f, 8.0f, 0.0f, 0.0f, 13, null);
                                                                        final float f66 = f56;
                                                                        final float f67 = f57;
                                                                        final float f68 = f58;
                                                                        final float f69 = f59;
                                                                        final float f75 = f65;
                                                                        final String str15 = str13;
                                                                        final int i38 = i37;
                                                                        BoxKt.a(n16, null, null, ComposableLambdaKt.composableLambda(composer9, 642258832, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt.OpenQZoneSheet.2.1.2.2.2
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(3);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function3
                                                                            public final Unit invoke(b bVar2, Composer composer10, Integer num5) {
                                                                                String str16;
                                                                                Composer composer11 = composer10;
                                                                                int intValue5 = num5.intValue();
                                                                                if ((intValue5 & 81) == 16 && composer11.getSkipping()) {
                                                                                    composer11.skipToGroupEnd();
                                                                                } else {
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        ComposerKt.traceEventStart(642258832, intValue5, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheet.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OpenQZoneSheet.kt:122)");
                                                                                    }
                                                                                    i.Companion companion2 = i.INSTANCE;
                                                                                    i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion2, f66), f67);
                                                                                    QQCommonNApiModule.Companion companion3 = QQCommonNApiModule.Companion;
                                                                                    if (((QQCommonNApiModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("QQCommonNApiModule")).isDarkTheme()) {
                                                                                        str16 = "https://bot-resource-1251316161.file.myqcloud.com/media/fILelgSL.png";
                                                                                    } else {
                                                                                        str16 = "https://bot-resource-1251316161.file.myqcloud.com/media/Cj09WDy7.png";
                                                                                    }
                                                                                    h.Companion companion4 = com.tencent.ntcompose.material.h.INSTANCE;
                                                                                    ImageKt.a(null, null, null, null, null, k3, null, companion4.a(), null, null, str16, null, null, null, null, null, null, null, null, null, null, composer11, 12845056, 0, 0, 2095967);
                                                                                    ImageKt.a(null, null, null, null, null, ModifiersKt.q(ModifiersKt.h(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(companion2, com.tencent.kuikly.core.utils.b.a(f68)), f69, f75, 0.0f, 0.0f, 12, null), com.tencent.kuikly.core.utils.b.a(2.0f), com.tencent.kuikly.core.base.h.INSTANCE.m(), null, 4, null), uo3.c.a(com.tencent.kuikly.core.utils.b.a(f68 / 2))), null, companion4.a(), null, null, str15, null, null, null, null, null, null, null, null, null, null, composer11, 12845056, (i38 >> 3) & 14, 0, 2095967);
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        ComposerKt.traceEventEnd();
                                                                                    }
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        }), composer9, 3080, 6);
                                                                        a.C0144a c0144a = new a.C0144a(0, 1, null);
                                                                        c.Companion companion2 = c.INSTANCE;
                                                                        int e16 = c0144a.e(new j(null, null, companion2.e(), null, null, null, null, null, null, null, null, null, null, null, null, 32763, null));
                                                                        try {
                                                                            c0144a.a("\u7531\u4e8e\u60a8\u7684\u667a\u80fd\u4f53\u62e5\u6709\u4e00\u5b9a\u5f71\u54cd\u529b\u548c\u6d3b\u8dc3\u5ea6\n\u5df2\u83b7\u5f97");
                                                                            Unit unit2 = Unit.INSTANCE;
                                                                            c0144a.c(e16);
                                                                            e16 = c0144a.e(new j(null, null, companion2.g(), null, null, null, null, null, null, null, null, null, null, null, null, 32763, null));
                                                                            try {
                                                                                c0144a.a("\u5f00\u901a\u7a7a\u95f4\u52a8\u6001");
                                                                                c0144a.c(e16);
                                                                                e16 = c0144a.e(new j(null, null, companion2.e(), null, null, null, null, null, null, null, null, null, null, null, null, 32763, null));
                                                                                try {
                                                                                    c0144a.a("\u7684\u8d44\u683c");
                                                                                    c0144a.c(e16);
                                                                                    bp3.a f76 = c0144a.f();
                                                                                    com.tencent.kuikly.core.base.h color$default2 = QUIToken.color$default("text_primary");
                                                                                    i n17 = ComposeLayoutPropUpdaterKt.n(companion, 0.0f, 10.0f, 0.0f, 0.0f, 13, null);
                                                                                    ai.Companion companion3 = ai.INSTANCE;
                                                                                    RichTextKt.b(f76, n17, null, color$default2, Float.valueOf(14.0f), null, null, null, null, null, ai.f(companion3.a()), Float.valueOf(22.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, composer9, 28736, 48, 0, 268432356);
                                                                                    TextKt.a("*\u672c\u529f\u80fd\u76ee\u524d\u5904\u4e8e\u5185\u6d4b\u72b6\u6001\uff0c\u4ec5\u5f00\u653e\u7ed9\u5c11\u6570\u4f18\u8d28\u667a\u80fd\u4f53", ComposeLayoutPropUpdaterKt.n(companion, 0.0f, 17.5f, 0.0f, 0.0f, 13, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(12.0f), null, null, null, null, null, null, Float.valueOf(17.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer9, 28742, 48, 0, 134215652);
                                                                                    i r16 = ViewEventPropUpdaterKt.r(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 343.0f), 45.0f), 0.0f, 23.5f, 0.0f, 0.0f, 13, null), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt.OpenQZoneSheet.2.1.2.2.4
                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Unit invoke(Object obj) {
                                                                                            OpenQZoneSheetKt.report("dt_imp", "em_bas_open_immediately");
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    });
                                                                                    k kVar = new k(null, Float.valueOf(17.0f), companion2.f(), null, null, null, null, null, ai.f(companion3.a()), null, null, null, null, null, 16121, null);
                                                                                    final Function0<Unit> function014 = function013;
                                                                                    composer9.startReplaceableGroup(1157296644);
                                                                                    boolean changed2 = composer9.changed(function014);
                                                                                    Object rememberedValue2 = composer9.rememberedValue();
                                                                                    if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                                                        rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$5$1
                                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                            {
                                                                                                super(1);
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(ClickParams clickParams) {
                                                                                                QQKuiklyPlatformApi.Companion companion4 = QQKuiklyPlatformApi.Companion;
                                                                                                if (companion4.getNetworkType() == QQKuiklyPlatformApi.QQNetworkType.NOT_REACHABLE) {
                                                                                                    companion4.qqToast("\u7f51\u7edc\u8fde\u63a5\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u540e\u91cd\u8bd5", QToastMode.Warning);
                                                                                                } else {
                                                                                                    OpenQZoneSheetKt.report("dt_clck", "em_bas_open_immediately");
                                                                                                    Function0<Unit> function015 = function014;
                                                                                                    if (function015 != null) {
                                                                                                        function015.invoke();
                                                                                                    }
                                                                                                }
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        };
                                                                                        composer9.updateRememberedValue(rememberedValue2);
                                                                                    }
                                                                                    composer9.endReplaceableGroup();
                                                                                    QUIButtonKt.QUIButton(r16, null, null, "\u7acb\u5373\u5f00\u901a", kVar, (Function1) rememberedValue2, null, null, composer9, (k.f28903n << 12) | 3080, 198);
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        ComposerKt.traceEventEnd();
                                                                                    }
                                                                                } finally {
                                                                                }
                                                                            } finally {
                                                                            }
                                                                        } finally {
                                                                        }
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }), composer7, 24968, 10);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer5, 14156342, 40);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer3, 3080, 6);
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
                        function03 = function06;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        return;
                    }
                    final String str8 = str3;
                    final Function0<Unit> function09 = function03;
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Unit invoke(Composer composer2, Integer num) {
                            num.intValue();
                            OpenQZoneSheetKt.OpenQZoneSheet(str8, str5, function09, function05, composer2, i3 | 1, i16);
                            return Unit.INSTANCE;
                        }
                    });
                    return;
                }
                function04 = function02;
                i26 = i17;
                if ((i26 & 5851) != 1170) {
                }
                if (i27 != 0) {
                }
                if (i28 == 0) {
                }
                if (i18 == 0) {
                }
                if (i19 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                final float min2 = Math.min(((com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d())).e(), 428.0f);
                float f162 = min2 / QidPagView.DESIGN_PAG_WIDTH;
                final float f172 = f162 * 250;
                final float f182 = f162 * 60;
                final float f192 = f162 * 36;
                final float f262 = f162 * 16;
                final Function0<Unit> function072 = function05;
                final String str62 = str3;
                final Function0<Unit> function082 = function06;
                final String str72 = str5;
                ModalKt.a(ViewEventPropUpdaterKt.r(i.INSTANCE, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object obj) {
                        OpenQZoneSheetKt.report("dt_imp", "em_bas_open_space_floating_layer");
                        return Unit.INSTANCE;
                    }
                }), false, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1317032833, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2
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
                                ComposerKt.traceEventStart(1317032833, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheet.<anonymous> (OpenQZoneSheet.kt:67)");
                            }
                            i f27 = ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.0f, 1, null);
                            final Function0<Unit> function092 = function072;
                            final int i29 = i26;
                            final String str82 = str62;
                            final float f28 = min2;
                            final Function0<Unit> function010 = function082;
                            final float f29 = f172;
                            final float f36 = f182;
                            final float f37 = f192;
                            final float f38 = f262;
                            final String str9 = str72;
                            BoxKt.a(f27, null, null, ComposableLambdaKt.composableLambda(composer3, 320318471, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                            ComposerKt.traceEventStart(320318471, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheet.<anonymous>.<anonymous> (OpenQZoneSheet.kt:72)");
                                        }
                                        com.tencent.kuikly.core.base.h color$default = QUIToken.color$default("bg_middle_light");
                                        final Function0<Unit> function011 = function092;
                                        composer5.startReplaceableGroup(1157296644);
                                        boolean changed = composer5.changed(function011);
                                        Object rememberedValue = composer5.rememberedValue();
                                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2$1$1$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(Object obj) {
                                                    Function0<Unit> function012 = function011;
                                                    if (function012 != null) {
                                                        function012.invoke();
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            composer5.updateRememberedValue(rememberedValue);
                                        }
                                        composer5.endReplaceableGroup();
                                        Function1 function1 = (Function1) rememberedValue;
                                        Function2<Composer, Integer, Unit> function2 = ComposableSingletons$OpenQZoneSheetKt.f11lambda2;
                                        final String str10 = str82;
                                        final float f39 = f28;
                                        final Function0<Unit> function012 = function010;
                                        final int i36 = i29;
                                        final float f46 = f29;
                                        final float f47 = f36;
                                        final float f48 = f37;
                                        final float f49 = f38;
                                        final String str11 = str9;
                                        HalfFloatingLayerKt.HalfFloatingLayer(559.0f, 0.5f, color$default, 0.0f, function1, null, function2, ComposableLambdaKt.composableLambda(composer5, 2038013165, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt.OpenQZoneSheet.2.1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public final Unit invoke(Composer composer6, Integer num3) {
                                                Composer composer7 = composer6;
                                                int intValue3 = num3.intValue();
                                                if ((intValue3 & 11) == 2 && composer7.getSkipping()) {
                                                    composer7.skipToGroupEnd();
                                                } else {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(2038013165, intValue3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheet.<anonymous>.<anonymous>.<anonymous> (OpenQZoneSheet.kt:95)");
                                                    }
                                                    i d16 = ViewEventPropUpdaterKt.d(ModifiersKt.d(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null)), QUIToken.color$default("bg_middle_light")), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt.OpenQZoneSheet.2.1.2.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                                            return Unit.INSTANCE;
                                                        }
                                                    }, 3, null);
                                                    Alignment.Horizontal horizontal = Alignment.Horizontal.CenterHorizontally;
                                                    final String str12 = str10;
                                                    final float f56 = f39;
                                                    final Function0<Unit> function013 = function012;
                                                    final int i37 = i36;
                                                    final float f57 = f46;
                                                    final float f58 = f47;
                                                    final float f59 = f48;
                                                    final float f65 = f49;
                                                    final String str13 = str11;
                                                    ColumnKt.a(d16, null, horizontal, null, ComposableLambdaKt.composableLambda(composer7, 1736859734, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt.OpenQZoneSheet.2.1.2.2
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public final Unit invoke(d dVar, Composer composer8, Integer num4) {
                                                            String take;
                                                            Composer composer9 = composer8;
                                                            int intValue4 = num4.intValue();
                                                            if ((intValue4 & 81) == 16 && composer9.getSkipping()) {
                                                                composer9.skipToGroupEnd();
                                                            } else {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(1736859734, intValue4, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheet.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OpenQZoneSheet.kt:105)");
                                                                }
                                                                String str14 = str12;
                                                                composer9.startReplaceableGroup(-1994463563);
                                                                if (str14 != null) {
                                                                    i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.A(i.INSTANCE), 0.0f, 23.0f, 0.0f, 0.0f, 13, null);
                                                                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u606d\u559c\u4f60\n\u53ef\u4ee5\u4e3a\u300c");
                                                                    if (str14.length() > 6) {
                                                                        StringBuilder sb5 = new StringBuilder();
                                                                        take = StringsKt___StringsKt.take(str14, 6);
                                                                        sb5.append(take);
                                                                        sb5.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
                                                                        str14 = sb5.toString();
                                                                    }
                                                                    TextKt.a(OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(m3, str14, "\u300d\u5f00\u901a\u7a7a\u95f4\u5566"), n3, null, QUIToken.color$default("text_primary"), Float.valueOf(20.0f), null, c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.a()), Float.valueOf(30.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer9, 1601600, 48, 0, 134214564);
                                                                    Unit unit = Unit.INSTANCE;
                                                                }
                                                                composer9.endReplaceableGroup();
                                                                i.Companion companion = i.INSTANCE;
                                                                i n16 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, f56), 250.0f), 0.0f, 8.0f, 0.0f, 0.0f, 13, null);
                                                                final float f66 = f56;
                                                                final float f67 = f57;
                                                                final float f68 = f58;
                                                                final float f69 = f59;
                                                                final float f75 = f65;
                                                                final String str15 = str13;
                                                                final int i38 = i37;
                                                                BoxKt.a(n16, null, null, ComposableLambdaKt.composableLambda(composer9, 642258832, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt.OpenQZoneSheet.2.1.2.2.2
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(3);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function3
                                                                    public final Unit invoke(b bVar2, Composer composer10, Integer num5) {
                                                                        String str16;
                                                                        Composer composer11 = composer10;
                                                                        int intValue5 = num5.intValue();
                                                                        if ((intValue5 & 81) == 16 && composer11.getSkipping()) {
                                                                            composer11.skipToGroupEnd();
                                                                        } else {
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventStart(642258832, intValue5, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheet.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OpenQZoneSheet.kt:122)");
                                                                            }
                                                                            i.Companion companion2 = i.INSTANCE;
                                                                            i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion2, f66), f67);
                                                                            QQCommonNApiModule.Companion companion3 = QQCommonNApiModule.Companion;
                                                                            if (((QQCommonNApiModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("QQCommonNApiModule")).isDarkTheme()) {
                                                                                str16 = "https://bot-resource-1251316161.file.myqcloud.com/media/fILelgSL.png";
                                                                            } else {
                                                                                str16 = "https://bot-resource-1251316161.file.myqcloud.com/media/Cj09WDy7.png";
                                                                            }
                                                                            h.Companion companion4 = com.tencent.ntcompose.material.h.INSTANCE;
                                                                            ImageKt.a(null, null, null, null, null, k3, null, companion4.a(), null, null, str16, null, null, null, null, null, null, null, null, null, null, composer11, 12845056, 0, 0, 2095967);
                                                                            ImageKt.a(null, null, null, null, null, ModifiersKt.q(ModifiersKt.h(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(companion2, com.tencent.kuikly.core.utils.b.a(f68)), f69, f75, 0.0f, 0.0f, 12, null), com.tencent.kuikly.core.utils.b.a(2.0f), com.tencent.kuikly.core.base.h.INSTANCE.m(), null, 4, null), uo3.c.a(com.tencent.kuikly.core.utils.b.a(f68 / 2))), null, companion4.a(), null, null, str15, null, null, null, null, null, null, null, null, null, null, composer11, 12845056, (i38 >> 3) & 14, 0, 2095967);
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventEnd();
                                                                            }
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                }), composer9, 3080, 6);
                                                                a.C0144a c0144a = new a.C0144a(0, 1, null);
                                                                c.Companion companion2 = c.INSTANCE;
                                                                int e16 = c0144a.e(new j(null, null, companion2.e(), null, null, null, null, null, null, null, null, null, null, null, null, 32763, null));
                                                                try {
                                                                    c0144a.a("\u7531\u4e8e\u60a8\u7684\u667a\u80fd\u4f53\u62e5\u6709\u4e00\u5b9a\u5f71\u54cd\u529b\u548c\u6d3b\u8dc3\u5ea6\n\u5df2\u83b7\u5f97");
                                                                    Unit unit2 = Unit.INSTANCE;
                                                                    c0144a.c(e16);
                                                                    e16 = c0144a.e(new j(null, null, companion2.g(), null, null, null, null, null, null, null, null, null, null, null, null, 32763, null));
                                                                    try {
                                                                        c0144a.a("\u5f00\u901a\u7a7a\u95f4\u52a8\u6001");
                                                                        c0144a.c(e16);
                                                                        e16 = c0144a.e(new j(null, null, companion2.e(), null, null, null, null, null, null, null, null, null, null, null, null, 32763, null));
                                                                        try {
                                                                            c0144a.a("\u7684\u8d44\u683c");
                                                                            c0144a.c(e16);
                                                                            bp3.a f76 = c0144a.f();
                                                                            com.tencent.kuikly.core.base.h color$default2 = QUIToken.color$default("text_primary");
                                                                            i n17 = ComposeLayoutPropUpdaterKt.n(companion, 0.0f, 10.0f, 0.0f, 0.0f, 13, null);
                                                                            ai.Companion companion3 = ai.INSTANCE;
                                                                            RichTextKt.b(f76, n17, null, color$default2, Float.valueOf(14.0f), null, null, null, null, null, ai.f(companion3.a()), Float.valueOf(22.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, composer9, 28736, 48, 0, 268432356);
                                                                            TextKt.a("*\u672c\u529f\u80fd\u76ee\u524d\u5904\u4e8e\u5185\u6d4b\u72b6\u6001\uff0c\u4ec5\u5f00\u653e\u7ed9\u5c11\u6570\u4f18\u8d28\u667a\u80fd\u4f53", ComposeLayoutPropUpdaterKt.n(companion, 0.0f, 17.5f, 0.0f, 0.0f, 13, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(12.0f), null, null, null, null, null, null, Float.valueOf(17.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer9, 28742, 48, 0, 134215652);
                                                                            i r16 = ViewEventPropUpdaterKt.r(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 343.0f), 45.0f), 0.0f, 23.5f, 0.0f, 0.0f, 13, null), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt.OpenQZoneSheet.2.1.2.2.4
                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(Object obj) {
                                                                                    OpenQZoneSheetKt.report("dt_imp", "em_bas_open_immediately");
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            k kVar = new k(null, Float.valueOf(17.0f), companion2.f(), null, null, null, null, null, ai.f(companion3.a()), null, null, null, null, null, 16121, null);
                                                                            final Function0<Unit> function014 = function013;
                                                                            composer9.startReplaceableGroup(1157296644);
                                                                            boolean changed2 = composer9.changed(function014);
                                                                            Object rememberedValue2 = composer9.rememberedValue();
                                                                            if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                                                rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$5$1
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                                        QQKuiklyPlatformApi.Companion companion4 = QQKuiklyPlatformApi.Companion;
                                                                                        if (companion4.getNetworkType() == QQKuiklyPlatformApi.QQNetworkType.NOT_REACHABLE) {
                                                                                            companion4.qqToast("\u7f51\u7edc\u8fde\u63a5\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u540e\u91cd\u8bd5", QToastMode.Warning);
                                                                                        } else {
                                                                                            OpenQZoneSheetKt.report("dt_clck", "em_bas_open_immediately");
                                                                                            Function0<Unit> function015 = function014;
                                                                                            if (function015 != null) {
                                                                                                function015.invoke();
                                                                                            }
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                };
                                                                                composer9.updateRememberedValue(rememberedValue2);
                                                                            }
                                                                            composer9.endReplaceableGroup();
                                                                            QUIButtonKt.QUIButton(r16, null, null, "\u7acb\u5373\u5f00\u901a", kVar, (Function1) rememberedValue2, null, null, composer9, (k.f28903n << 12) | 3080, 198);
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventEnd();
                                                                            }
                                                                        } finally {
                                                                        }
                                                                    } finally {
                                                                    }
                                                                } finally {
                                                                }
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    }), composer7, 24968, 10);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), composer5, 14156342, 40);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }), composer3, 3080, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }), startRestartGroup, 24584, 14);
                if (ComposerKt.isTraceInProgress()) {
                }
                function03 = function06;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function03 = function0;
            i19 = i16 & 8;
            if (i19 != 0) {
            }
            function04 = function02;
            i26 = i17;
            if ((i26 & 5851) != 1170) {
            }
            if (i27 != 0) {
            }
            if (i28 == 0) {
            }
            if (i18 == 0) {
            }
            if (i19 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            final float min22 = Math.min(((com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d())).e(), 428.0f);
            float f1622 = min22 / QidPagView.DESIGN_PAG_WIDTH;
            final float f1722 = f1622 * 250;
            final float f1822 = f1622 * 60;
            final float f1922 = f1622 * 36;
            final float f2622 = f1622 * 16;
            final Function0<Unit> function0722 = function05;
            final String str622 = str3;
            final Function0<Unit> function0822 = function06;
            final String str722 = str5;
            ModalKt.a(ViewEventPropUpdaterKt.r(i.INSTANCE, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$1
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object obj) {
                    OpenQZoneSheetKt.report("dt_imp", "em_bas_open_space_floating_layer");
                    return Unit.INSTANCE;
                }
            }), false, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1317032833, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2
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
                            ComposerKt.traceEventStart(1317032833, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheet.<anonymous> (OpenQZoneSheet.kt:67)");
                        }
                        i f27 = ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.0f, 1, null);
                        final Function0<Unit> function092 = function0722;
                        final int i29 = i26;
                        final String str82 = str622;
                        final float f28 = min22;
                        final Function0<Unit> function010 = function0822;
                        final float f29 = f1722;
                        final float f36 = f1822;
                        final float f37 = f1922;
                        final float f38 = f2622;
                        final String str9 = str722;
                        BoxKt.a(f27, null, null, ComposableLambdaKt.composableLambda(composer3, 320318471, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                        ComposerKt.traceEventStart(320318471, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheet.<anonymous>.<anonymous> (OpenQZoneSheet.kt:72)");
                                    }
                                    com.tencent.kuikly.core.base.h color$default = QUIToken.color$default("bg_middle_light");
                                    final Function0<Unit> function011 = function092;
                                    composer5.startReplaceableGroup(1157296644);
                                    boolean changed = composer5.changed(function011);
                                    Object rememberedValue = composer5.rememberedValue();
                                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2$1$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                Function0<Unit> function012 = function011;
                                                if (function012 != null) {
                                                    function012.invoke();
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        composer5.updateRememberedValue(rememberedValue);
                                    }
                                    composer5.endReplaceableGroup();
                                    Function1 function1 = (Function1) rememberedValue;
                                    Function2<Composer, Integer, Unit> function2 = ComposableSingletons$OpenQZoneSheetKt.f11lambda2;
                                    final String str10 = str82;
                                    final float f39 = f28;
                                    final Function0<Unit> function012 = function010;
                                    final int i36 = i29;
                                    final float f46 = f29;
                                    final float f47 = f36;
                                    final float f48 = f37;
                                    final float f49 = f38;
                                    final String str11 = str9;
                                    HalfFloatingLayerKt.HalfFloatingLayer(559.0f, 0.5f, color$default, 0.0f, function1, null, function2, ComposableLambdaKt.composableLambda(composer5, 2038013165, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt.OpenQZoneSheet.2.1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Unit invoke(Composer composer6, Integer num3) {
                                            Composer composer7 = composer6;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 11) == 2 && composer7.getSkipping()) {
                                                composer7.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(2038013165, intValue3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheet.<anonymous>.<anonymous>.<anonymous> (OpenQZoneSheet.kt:95)");
                                                }
                                                i d16 = ViewEventPropUpdaterKt.d(ModifiersKt.d(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null)), QUIToken.color$default("bg_middle_light")), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt.OpenQZoneSheet.2.1.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                                        return Unit.INSTANCE;
                                                    }
                                                }, 3, null);
                                                Alignment.Horizontal horizontal = Alignment.Horizontal.CenterHorizontally;
                                                final String str12 = str10;
                                                final float f56 = f39;
                                                final Function0<Unit> function013 = function012;
                                                final int i37 = i36;
                                                final float f57 = f46;
                                                final float f58 = f47;
                                                final float f59 = f48;
                                                final float f65 = f49;
                                                final String str13 = str11;
                                                ColumnKt.a(d16, null, horizontal, null, ComposableLambdaKt.composableLambda(composer7, 1736859734, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt.OpenQZoneSheet.2.1.2.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(d dVar, Composer composer8, Integer num4) {
                                                        String take;
                                                        Composer composer9 = composer8;
                                                        int intValue4 = num4.intValue();
                                                        if ((intValue4 & 81) == 16 && composer9.getSkipping()) {
                                                            composer9.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(1736859734, intValue4, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheet.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OpenQZoneSheet.kt:105)");
                                                            }
                                                            String str14 = str12;
                                                            composer9.startReplaceableGroup(-1994463563);
                                                            if (str14 != null) {
                                                                i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.A(i.INSTANCE), 0.0f, 23.0f, 0.0f, 0.0f, 13, null);
                                                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u606d\u559c\u4f60\n\u53ef\u4ee5\u4e3a\u300c");
                                                                if (str14.length() > 6) {
                                                                    StringBuilder sb5 = new StringBuilder();
                                                                    take = StringsKt___StringsKt.take(str14, 6);
                                                                    sb5.append(take);
                                                                    sb5.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
                                                                    str14 = sb5.toString();
                                                                }
                                                                TextKt.a(OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(m3, str14, "\u300d\u5f00\u901a\u7a7a\u95f4\u5566"), n3, null, QUIToken.color$default("text_primary"), Float.valueOf(20.0f), null, c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.a()), Float.valueOf(30.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer9, 1601600, 48, 0, 134214564);
                                                                Unit unit = Unit.INSTANCE;
                                                            }
                                                            composer9.endReplaceableGroup();
                                                            i.Companion companion = i.INSTANCE;
                                                            i n16 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, f56), 250.0f), 0.0f, 8.0f, 0.0f, 0.0f, 13, null);
                                                            final float f66 = f56;
                                                            final float f67 = f57;
                                                            final float f68 = f58;
                                                            final float f69 = f59;
                                                            final float f75 = f65;
                                                            final String str15 = str13;
                                                            final int i38 = i37;
                                                            BoxKt.a(n16, null, null, ComposableLambdaKt.composableLambda(composer9, 642258832, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt.OpenQZoneSheet.2.1.2.2.2
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(3);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function3
                                                                public final Unit invoke(b bVar2, Composer composer10, Integer num5) {
                                                                    String str16;
                                                                    Composer composer11 = composer10;
                                                                    int intValue5 = num5.intValue();
                                                                    if ((intValue5 & 81) == 16 && composer11.getSkipping()) {
                                                                        composer11.skipToGroupEnd();
                                                                    } else {
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(642258832, intValue5, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheet.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OpenQZoneSheet.kt:122)");
                                                                        }
                                                                        i.Companion companion2 = i.INSTANCE;
                                                                        i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion2, f66), f67);
                                                                        QQCommonNApiModule.Companion companion3 = QQCommonNApiModule.Companion;
                                                                        if (((QQCommonNApiModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("QQCommonNApiModule")).isDarkTheme()) {
                                                                            str16 = "https://bot-resource-1251316161.file.myqcloud.com/media/fILelgSL.png";
                                                                        } else {
                                                                            str16 = "https://bot-resource-1251316161.file.myqcloud.com/media/Cj09WDy7.png";
                                                                        }
                                                                        h.Companion companion4 = com.tencent.ntcompose.material.h.INSTANCE;
                                                                        ImageKt.a(null, null, null, null, null, k3, null, companion4.a(), null, null, str16, null, null, null, null, null, null, null, null, null, null, composer11, 12845056, 0, 0, 2095967);
                                                                        ImageKt.a(null, null, null, null, null, ModifiersKt.q(ModifiersKt.h(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(companion2, com.tencent.kuikly.core.utils.b.a(f68)), f69, f75, 0.0f, 0.0f, 12, null), com.tencent.kuikly.core.utils.b.a(2.0f), com.tencent.kuikly.core.base.h.INSTANCE.m(), null, 4, null), uo3.c.a(com.tencent.kuikly.core.utils.b.a(f68 / 2))), null, companion4.a(), null, null, str15, null, null, null, null, null, null, null, null, null, null, composer11, 12845056, (i38 >> 3) & 14, 0, 2095967);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }), composer9, 3080, 6);
                                                            a.C0144a c0144a = new a.C0144a(0, 1, null);
                                                            c.Companion companion2 = c.INSTANCE;
                                                            int e16 = c0144a.e(new j(null, null, companion2.e(), null, null, null, null, null, null, null, null, null, null, null, null, 32763, null));
                                                            try {
                                                                c0144a.a("\u7531\u4e8e\u60a8\u7684\u667a\u80fd\u4f53\u62e5\u6709\u4e00\u5b9a\u5f71\u54cd\u529b\u548c\u6d3b\u8dc3\u5ea6\n\u5df2\u83b7\u5f97");
                                                                Unit unit2 = Unit.INSTANCE;
                                                                c0144a.c(e16);
                                                                e16 = c0144a.e(new j(null, null, companion2.g(), null, null, null, null, null, null, null, null, null, null, null, null, 32763, null));
                                                                try {
                                                                    c0144a.a("\u5f00\u901a\u7a7a\u95f4\u52a8\u6001");
                                                                    c0144a.c(e16);
                                                                    e16 = c0144a.e(new j(null, null, companion2.e(), null, null, null, null, null, null, null, null, null, null, null, null, 32763, null));
                                                                    try {
                                                                        c0144a.a("\u7684\u8d44\u683c");
                                                                        c0144a.c(e16);
                                                                        bp3.a f76 = c0144a.f();
                                                                        com.tencent.kuikly.core.base.h color$default2 = QUIToken.color$default("text_primary");
                                                                        i n17 = ComposeLayoutPropUpdaterKt.n(companion, 0.0f, 10.0f, 0.0f, 0.0f, 13, null);
                                                                        ai.Companion companion3 = ai.INSTANCE;
                                                                        RichTextKt.b(f76, n17, null, color$default2, Float.valueOf(14.0f), null, null, null, null, null, ai.f(companion3.a()), Float.valueOf(22.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, composer9, 28736, 48, 0, 268432356);
                                                                        TextKt.a("*\u672c\u529f\u80fd\u76ee\u524d\u5904\u4e8e\u5185\u6d4b\u72b6\u6001\uff0c\u4ec5\u5f00\u653e\u7ed9\u5c11\u6570\u4f18\u8d28\u667a\u80fd\u4f53", ComposeLayoutPropUpdaterKt.n(companion, 0.0f, 17.5f, 0.0f, 0.0f, 13, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(12.0f), null, null, null, null, null, null, Float.valueOf(17.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer9, 28742, 48, 0, 134215652);
                                                                        i r16 = ViewEventPropUpdaterKt.r(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 343.0f), 45.0f), 0.0f, 23.5f, 0.0f, 0.0f, 13, null), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt.OpenQZoneSheet.2.1.2.2.4
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(Object obj) {
                                                                                OpenQZoneSheetKt.report("dt_imp", "em_bas_open_immediately");
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        k kVar = new k(null, Float.valueOf(17.0f), companion2.f(), null, null, null, null, null, ai.f(companion3.a()), null, null, null, null, null, 16121, null);
                                                                        final Function0<Unit> function014 = function013;
                                                                        composer9.startReplaceableGroup(1157296644);
                                                                        boolean changed2 = composer9.changed(function014);
                                                                        Object rememberedValue2 = composer9.rememberedValue();
                                                                        if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                                            rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$5$1
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(ClickParams clickParams) {
                                                                                    QQKuiklyPlatformApi.Companion companion4 = QQKuiklyPlatformApi.Companion;
                                                                                    if (companion4.getNetworkType() == QQKuiklyPlatformApi.QQNetworkType.NOT_REACHABLE) {
                                                                                        companion4.qqToast("\u7f51\u7edc\u8fde\u63a5\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u540e\u91cd\u8bd5", QToastMode.Warning);
                                                                                    } else {
                                                                                        OpenQZoneSheetKt.report("dt_clck", "em_bas_open_immediately");
                                                                                        Function0<Unit> function015 = function014;
                                                                                        if (function015 != null) {
                                                                                            function015.invoke();
                                                                                        }
                                                                                    }
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            };
                                                                            composer9.updateRememberedValue(rememberedValue2);
                                                                        }
                                                                        composer9.endReplaceableGroup();
                                                                        QUIButtonKt.QUIButton(r16, null, null, "\u7acb\u5373\u5f00\u901a", kVar, (Function1) rememberedValue2, null, null, composer9, (k.f28903n << 12) | 3080, 198);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    } finally {
                                                                    }
                                                                } finally {
                                                                }
                                                            } finally {
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer7, 24968, 10);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer5, 14156342, 40);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 3080, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 24584, 14);
            if (ComposerKt.isTraceInProgress()) {
            }
            function03 = function06;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        str4 = str2;
        i18 = i16 & 4;
        if (i18 == 0) {
        }
        function03 = function0;
        i19 = i16 & 8;
        if (i19 != 0) {
        }
        function04 = function02;
        i26 = i17;
        if ((i26 & 5851) != 1170) {
        }
        if (i27 != 0) {
        }
        if (i28 == 0) {
        }
        if (i18 == 0) {
        }
        if (i19 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        final float min222 = Math.min(((com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d())).e(), 428.0f);
        float f16222 = min222 / QidPagView.DESIGN_PAG_WIDTH;
        final float f17222 = f16222 * 250;
        final float f18222 = f16222 * 60;
        final float f19222 = f16222 * 36;
        final float f26222 = f16222 * 16;
        final Function0<Unit> function07222 = function05;
        final String str6222 = str3;
        final Function0<Unit> function08222 = function06;
        final String str7222 = str5;
        ModalKt.a(ViewEventPropUpdaterKt.r(i.INSTANCE, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$1
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                OpenQZoneSheetKt.report("dt_imp", "em_bas_open_space_floating_layer");
                return Unit.INSTANCE;
            }
        }), false, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1317032833, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2
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
                        ComposerKt.traceEventStart(1317032833, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheet.<anonymous> (OpenQZoneSheet.kt:67)");
                    }
                    i f27 = ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.0f, 1, null);
                    final Function0<Unit> function092 = function07222;
                    final int i29 = i26;
                    final String str82 = str6222;
                    final float f28 = min222;
                    final Function0<Unit> function010 = function08222;
                    final float f29 = f17222;
                    final float f36 = f18222;
                    final float f37 = f19222;
                    final float f38 = f26222;
                    final String str9 = str7222;
                    BoxKt.a(f27, null, null, ComposableLambdaKt.composableLambda(composer3, 320318471, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                    ComposerKt.traceEventStart(320318471, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheet.<anonymous>.<anonymous> (OpenQZoneSheet.kt:72)");
                                }
                                com.tencent.kuikly.core.base.h color$default = QUIToken.color$default("bg_middle_light");
                                final Function0<Unit> function011 = function092;
                                composer5.startReplaceableGroup(1157296644);
                                boolean changed = composer5.changed(function011);
                                Object rememberedValue = composer5.rememberedValue();
                                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2$1$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(Object obj) {
                                            Function0<Unit> function012 = function011;
                                            if (function012 != null) {
                                                function012.invoke();
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composer5.updateRememberedValue(rememberedValue);
                                }
                                composer5.endReplaceableGroup();
                                Function1 function1 = (Function1) rememberedValue;
                                Function2<Composer, Integer, Unit> function2 = ComposableSingletons$OpenQZoneSheetKt.f11lambda2;
                                final String str10 = str82;
                                final float f39 = f28;
                                final Function0<Unit> function012 = function010;
                                final int i36 = i29;
                                final float f46 = f29;
                                final float f47 = f36;
                                final float f48 = f37;
                                final float f49 = f38;
                                final String str11 = str9;
                                HalfFloatingLayerKt.HalfFloatingLayer(559.0f, 0.5f, color$default, 0.0f, function1, null, function2, ComposableLambdaKt.composableLambda(composer5, 2038013165, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt.OpenQZoneSheet.2.1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(Composer composer6, Integer num3) {
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 11) == 2 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(2038013165, intValue3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheet.<anonymous>.<anonymous>.<anonymous> (OpenQZoneSheet.kt:95)");
                                            }
                                            i d16 = ViewEventPropUpdaterKt.d(ModifiersKt.d(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null)), QUIToken.color$default("bg_middle_light")), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt.OpenQZoneSheet.2.1.2.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                                    return Unit.INSTANCE;
                                                }
                                            }, 3, null);
                                            Alignment.Horizontal horizontal = Alignment.Horizontal.CenterHorizontally;
                                            final String str12 = str10;
                                            final float f56 = f39;
                                            final Function0<Unit> function013 = function012;
                                            final int i37 = i36;
                                            final float f57 = f46;
                                            final float f58 = f47;
                                            final float f59 = f48;
                                            final float f65 = f49;
                                            final String str13 = str11;
                                            ColumnKt.a(d16, null, horizontal, null, ComposableLambdaKt.composableLambda(composer7, 1736859734, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt.OpenQZoneSheet.2.1.2.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(d dVar, Composer composer8, Integer num4) {
                                                    String take;
                                                    Composer composer9 = composer8;
                                                    int intValue4 = num4.intValue();
                                                    if ((intValue4 & 81) == 16 && composer9.getSkipping()) {
                                                        composer9.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(1736859734, intValue4, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheet.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OpenQZoneSheet.kt:105)");
                                                        }
                                                        String str14 = str12;
                                                        composer9.startReplaceableGroup(-1994463563);
                                                        if (str14 != null) {
                                                            i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.A(i.INSTANCE), 0.0f, 23.0f, 0.0f, 0.0f, 13, null);
                                                            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u606d\u559c\u4f60\n\u53ef\u4ee5\u4e3a\u300c");
                                                            if (str14.length() > 6) {
                                                                StringBuilder sb5 = new StringBuilder();
                                                                take = StringsKt___StringsKt.take(str14, 6);
                                                                sb5.append(take);
                                                                sb5.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
                                                                str14 = sb5.toString();
                                                            }
                                                            TextKt.a(OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(m3, str14, "\u300d\u5f00\u901a\u7a7a\u95f4\u5566"), n3, null, QUIToken.color$default("text_primary"), Float.valueOf(20.0f), null, c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.a()), Float.valueOf(30.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer9, 1601600, 48, 0, 134214564);
                                                            Unit unit = Unit.INSTANCE;
                                                        }
                                                        composer9.endReplaceableGroup();
                                                        i.Companion companion = i.INSTANCE;
                                                        i n16 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, f56), 250.0f), 0.0f, 8.0f, 0.0f, 0.0f, 13, null);
                                                        final float f66 = f56;
                                                        final float f67 = f57;
                                                        final float f68 = f58;
                                                        final float f69 = f59;
                                                        final float f75 = f65;
                                                        final String str15 = str13;
                                                        final int i38 = i37;
                                                        BoxKt.a(n16, null, null, ComposableLambdaKt.composableLambda(composer9, 642258832, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt.OpenQZoneSheet.2.1.2.2.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(3);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function3
                                                            public final Unit invoke(b bVar2, Composer composer10, Integer num5) {
                                                                String str16;
                                                                Composer composer11 = composer10;
                                                                int intValue5 = num5.intValue();
                                                                if ((intValue5 & 81) == 16 && composer11.getSkipping()) {
                                                                    composer11.skipToGroupEnd();
                                                                } else {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(642258832, intValue5, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheet.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OpenQZoneSheet.kt:122)");
                                                                    }
                                                                    i.Companion companion2 = i.INSTANCE;
                                                                    i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion2, f66), f67);
                                                                    QQCommonNApiModule.Companion companion3 = QQCommonNApiModule.Companion;
                                                                    if (((QQCommonNApiModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("QQCommonNApiModule")).isDarkTheme()) {
                                                                        str16 = "https://bot-resource-1251316161.file.myqcloud.com/media/fILelgSL.png";
                                                                    } else {
                                                                        str16 = "https://bot-resource-1251316161.file.myqcloud.com/media/Cj09WDy7.png";
                                                                    }
                                                                    h.Companion companion4 = com.tencent.ntcompose.material.h.INSTANCE;
                                                                    ImageKt.a(null, null, null, null, null, k3, null, companion4.a(), null, null, str16, null, null, null, null, null, null, null, null, null, null, composer11, 12845056, 0, 0, 2095967);
                                                                    ImageKt.a(null, null, null, null, null, ModifiersKt.q(ModifiersKt.h(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(companion2, com.tencent.kuikly.core.utils.b.a(f68)), f69, f75, 0.0f, 0.0f, 12, null), com.tencent.kuikly.core.utils.b.a(2.0f), com.tencent.kuikly.core.base.h.INSTANCE.m(), null, 4, null), uo3.c.a(com.tencent.kuikly.core.utils.b.a(f68 / 2))), null, companion4.a(), null, null, str15, null, null, null, null, null, null, null, null, null, null, composer11, 12845056, (i38 >> 3) & 14, 0, 2095967);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }), composer9, 3080, 6);
                                                        a.C0144a c0144a = new a.C0144a(0, 1, null);
                                                        c.Companion companion2 = c.INSTANCE;
                                                        int e16 = c0144a.e(new j(null, null, companion2.e(), null, null, null, null, null, null, null, null, null, null, null, null, 32763, null));
                                                        try {
                                                            c0144a.a("\u7531\u4e8e\u60a8\u7684\u667a\u80fd\u4f53\u62e5\u6709\u4e00\u5b9a\u5f71\u54cd\u529b\u548c\u6d3b\u8dc3\u5ea6\n\u5df2\u83b7\u5f97");
                                                            Unit unit2 = Unit.INSTANCE;
                                                            c0144a.c(e16);
                                                            e16 = c0144a.e(new j(null, null, companion2.g(), null, null, null, null, null, null, null, null, null, null, null, null, 32763, null));
                                                            try {
                                                                c0144a.a("\u5f00\u901a\u7a7a\u95f4\u52a8\u6001");
                                                                c0144a.c(e16);
                                                                e16 = c0144a.e(new j(null, null, companion2.e(), null, null, null, null, null, null, null, null, null, null, null, null, 32763, null));
                                                                try {
                                                                    c0144a.a("\u7684\u8d44\u683c");
                                                                    c0144a.c(e16);
                                                                    bp3.a f76 = c0144a.f();
                                                                    com.tencent.kuikly.core.base.h color$default2 = QUIToken.color$default("text_primary");
                                                                    i n17 = ComposeLayoutPropUpdaterKt.n(companion, 0.0f, 10.0f, 0.0f, 0.0f, 13, null);
                                                                    ai.Companion companion3 = ai.INSTANCE;
                                                                    RichTextKt.b(f76, n17, null, color$default2, Float.valueOf(14.0f), null, null, null, null, null, ai.f(companion3.a()), Float.valueOf(22.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, composer9, 28736, 48, 0, 268432356);
                                                                    TextKt.a("*\u672c\u529f\u80fd\u76ee\u524d\u5904\u4e8e\u5185\u6d4b\u72b6\u6001\uff0c\u4ec5\u5f00\u653e\u7ed9\u5c11\u6570\u4f18\u8d28\u667a\u80fd\u4f53", ComposeLayoutPropUpdaterKt.n(companion, 0.0f, 17.5f, 0.0f, 0.0f, 13, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(12.0f), null, null, null, null, null, null, Float.valueOf(17.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer9, 28742, 48, 0, 134215652);
                                                                    i r16 = ViewEventPropUpdaterKt.r(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 343.0f), 45.0f), 0.0f, 23.5f, 0.0f, 0.0f, 13, null), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt.OpenQZoneSheet.2.1.2.2.4
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(Object obj) {
                                                                            OpenQZoneSheetKt.report("dt_imp", "em_bas_open_immediately");
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    k kVar = new k(null, Float.valueOf(17.0f), companion2.f(), null, null, null, null, null, ai.f(companion3.a()), null, null, null, null, null, 16121, null);
                                                                    final Function0<Unit> function014 = function013;
                                                                    composer9.startReplaceableGroup(1157296644);
                                                                    boolean changed2 = composer9.changed(function014);
                                                                    Object rememberedValue2 = composer9.rememberedValue();
                                                                    if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                                        rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$5$1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ClickParams clickParams) {
                                                                                QQKuiklyPlatformApi.Companion companion4 = QQKuiklyPlatformApi.Companion;
                                                                                if (companion4.getNetworkType() == QQKuiklyPlatformApi.QQNetworkType.NOT_REACHABLE) {
                                                                                    companion4.qqToast("\u7f51\u7edc\u8fde\u63a5\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u540e\u91cd\u8bd5", QToastMode.Warning);
                                                                                } else {
                                                                                    OpenQZoneSheetKt.report("dt_clck", "em_bas_open_immediately");
                                                                                    Function0<Unit> function015 = function014;
                                                                                    if (function015 != null) {
                                                                                        function015.invoke();
                                                                                    }
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        };
                                                                        composer9.updateRememberedValue(rememberedValue2);
                                                                    }
                                                                    composer9.endReplaceableGroup();
                                                                    QUIButtonKt.QUIButton(r16, null, null, "\u7acb\u5373\u5f00\u901a", kVar, (Function1) rememberedValue2, null, null, composer9, (k.f28903n << 12) | 3080, 198);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                } finally {
                                                                }
                                                            } finally {
                                                            }
                                                        } finally {
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer7, 24968, 10);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 14156342, 40);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 3080, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 24584, 14);
        if (ComposerKt.isTraceInProgress()) {
        }
        function03 = function06;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
