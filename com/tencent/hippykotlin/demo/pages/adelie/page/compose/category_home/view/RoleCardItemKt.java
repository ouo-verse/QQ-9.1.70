package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.compose.view.superResolution.AdelieSuperResolutionImageKt;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.ReportKt;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.util.AdelieCategoryAIOJumpUtil;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.AdelieHomeCategoryViewModel;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.SurfaceKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.an;
import com.tencent.ntcompose.material.base.ModifiersKt;
import g25.k;
import g25.n;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt__StringsKt;
import uo3.b;
import uo3.c;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class RoleCardItemKt {
    public static final void access$report(String str, e eVar, String str2, k kVar, String str3, String str4, String str5, e eVar2) {
        String str6;
        Iterator<String> c16;
        e eVar3 = new e();
        eVar3.u("agent_uin", kVar.f401171d);
        eVar3.v("agent_name", kVar.f401173e);
        n nVar = kVar.H;
        if (nVar == null || (str6 = nVar.f401187e) == null) {
            str6 = "";
        }
        eVar3.v("creator_uid", str6);
        eVar3.v("agent_id", kVar.G);
        eVar3.t("serial_number", kVar.L);
        eVar3.v("trace_id", kVar.V);
        if (str3 != null) {
            eVar3.v("tab_name", str3);
        }
        if (str4 != null) {
            eVar3.v("tabid", str4);
        }
        Unit unit = Unit.INSTANCE;
        e eVar4 = new e(eVar.toString());
        eVar4.v("dt_eid", str2);
        eVar4.v("cur_pg", eVar);
        Iterator<String> c17 = eVar3.c();
        if (c17 != null) {
            while (c17.hasNext()) {
                String next = c17.next();
                eVar4.v(next, eVar3.e(next));
            }
        }
        eVar4.v(MiniAppDesktopDtReportHelper.DT_MINI_PARENT_EID, str5);
        if (eVar2 != null && (c16 = eVar2.c()) != null) {
            while (c16.hasNext()) {
                String next2 = c16.next();
                eVar4.v(next2, eVar2.e(next2));
            }
        }
        ReportKt.reportCustomDTEvent(str, eVar4);
    }

    public static final void RoleCardItem(final k kVar, final float f16, final e eVar, final String str, String str2, String str3, String str4, e eVar2, final AdelieHomeCategoryViewModel adelieHomeCategoryViewModel, Composer composer, final int i3, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(-212026869);
        String str5 = (i16 & 16) != 0 ? null : str2;
        String str6 = (i16 & 32) != 0 ? null : str3;
        String str7 = (i16 & 64) != 0 ? null : str4;
        e eVar3 = (i16 & 128) != 0 ? null : eVar2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-212026869, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RoleCardItem (RoleCardItem.kt:33)");
        }
        final String str8 = str5;
        final String str9 = str6;
        final String str10 = str7;
        final e eVar4 = eVar3;
        ColumnKt.a(ViewEventPropUpdaterKt.d(ViewEventPropUpdaterKt.r(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.z(i.INSTANCE)), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RoleCardItemKt$RoleCardItem$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                RoleCardItemKt.access$report("dt_imp", e.this, str, kVar, str8, str9, str10, eVar4);
                return Unit.INSTANCE;
            }
        }), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RoleCardItemKt$RoleCardItem$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                AdelieCategoryAIOJumpUtil.INSTANCE.jumpToAIO$qecommerce_biz_release(k.this, null, null, false);
                RoleCardItemKt.access$report("dt_clck", eVar, str, k.this, str8, str9, str10, eVar4);
                return Unit.INSTANCE;
            }
        }, 3, null), null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 847496372, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RoleCardItemKt$RoleCardItem$3
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
                        ComposerKt.traceEventStart(847496372, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RoleCardItem.<anonymous> (RoleCardItem.kt:55)");
                    }
                    i.Companion companion = i.INSTANCE;
                    i L = ModifiersKt.L(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.w(companion, f16)), 0.0f, 4.0f, 10.0f, new h(0, 0, 0, 0.05f));
                    h j3 = h.INSTANCE.j();
                    b a16 = c.a(8.0f);
                    final float f17 = f16;
                    final AdelieHomeCategoryViewModel adelieHomeCategoryViewModel2 = adelieHomeCategoryViewModel;
                    final k kVar2 = kVar;
                    SurfaceKt.a(L, a16, null, j3, ComposableLambdaKt.composableLambda(composer3, 1647036918, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RoleCardItemKt$RoleCardItem$3.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Unit invoke(Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 11) == 2 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1647036918, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RoleCardItem.<anonymous>.<anonymous> (RoleCardItem.kt:63)");
                                }
                                i w3 = ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.z(i.INSTANCE), f17);
                                Alignment alignment = Alignment.BottomEnd;
                                final AdelieHomeCategoryViewModel adelieHomeCategoryViewModel3 = adelieHomeCategoryViewModel2;
                                final k kVar3 = kVar2;
                                final float f18 = f17;
                                BoxKt.a(w3, alignment, null, ComposableLambdaKt.composableLambda(composer5, -1565467780, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RoleCardItemKt.RoleCardItem.3.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    /* JADX WARN: Code restructure failed: missing block: B:15:0x004a, code lost:
                                    
                                        if (r1 == true) goto L17;
                                     */
                                    @Override // kotlin.jvm.functions.Function3
                                    /*
                                        Code decompiled incorrectly, please refer to instructions dump.
                                    */
                                    public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer6, Integer num3) {
                                        boolean z16;
                                        Composer composer7;
                                        boolean contains$default;
                                        Composer composer8 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                            composer8.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1565467780, intValue3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RoleCardItem.<anonymous>.<anonymous>.<anonymous> (RoleCardItem.kt:67)");
                                            }
                                            AdelieHomeCategoryViewModel adelieHomeCategoryViewModel4 = AdelieHomeCategoryViewModel.this;
                                            String valueOf = String.valueOf(kVar3.f401171d);
                                            String str11 = adelieHomeCategoryViewModel4.superResolutionUinBlacklist;
                                            if (str11 != null) {
                                                contains$default = StringsKt__StringsKt.contains$default((CharSequence) str11, (CharSequence) valueOf, false, 2, (Object) null);
                                                z16 = true;
                                            }
                                            z16 = false;
                                            if (z16) {
                                                composer8.startReplaceableGroup(161764031);
                                                ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.u(i.INSTANCE, f18), null, 0, null, null, kVar3.f401175f, null, null, null, null, null, null, null, null, null, null, composer8, 262144, 0, 0, 2096095);
                                                composer8.endReplaceableGroup();
                                                composer7 = composer8;
                                            } else {
                                                composer7 = composer8;
                                                composer7.startReplaceableGroup(161764213);
                                                AdelieSuperResolutionImageKt.AdelieSuperResolutionImage(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, f18), null, kVar3.f401175f, null, null, new Function1<LoadFailParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RoleCardItemKt.RoleCardItem.3.1.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(LoadFailParams loadFailParams) {
                                                        LoadFailParams loadFailParams2 = loadFailParams;
                                                        KLog kLog = KLog.INSTANCE;
                                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("loadFail code=");
                                                        m3.append(loadFailParams2.code);
                                                        m3.append(", msg=");
                                                        m3.append(loadFailParams2.f114177msg);
                                                        kLog.e("RoleCardItem", m3.toString());
                                                        return Unit.INSTANCE;
                                                    }
                                                }, composer7, 196616, 26);
                                                composer7.endReplaceableGroup();
                                            }
                                            HotViewKt.HotView(kVar3, 0, composer7, 8, 2);
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
                    }), composer3, 28680, 4);
                    String str11 = kVar.f401173e;
                    h color$default = QUIToken.color$default("text_primary");
                    c.Companion companion2 = bp3.c.INSTANCE;
                    bp3.c f18 = companion2.f();
                    an.Companion companion3 = an.INSTANCE;
                    TextKt.a(str11, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.w(companion, f16), 0.0f, 8.0f, 0.0f, 0.0f, 13, null), null, color$default, Float.valueOf(16.0f), null, f18, null, null, null, null, Float.valueOf(22.0f), null, null, null, null, an.d(companion3.b()), null, 1, null, null, null, null, null, null, null, false, composer3, 1601600, 102236208, 0, 133887908);
                    TextKt.a(kVar.f401177h, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.k(companion, 40.0f), f16), 0.0f, 4.0f, 0.0f, 0.0f, 13, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(14.0f), null, companion2.e(), null, null, null, null, Float.valueOf(20.0f), null, null, null, null, an.d(companion3.b()), null, 2, null, null, null, null, null, null, null, false, composer3, 1601600, 102236208, 0, 133887908);
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
        final String str11 = str5;
        final String str12 = str6;
        final String str13 = str7;
        final e eVar5 = eVar3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RoleCardItemKt$RoleCardItem$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                RoleCardItemKt.RoleCardItem(k.this, f16, eVar, str, str11, str12, str13, eVar5, adelieHomeCategoryViewModel, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }
}
