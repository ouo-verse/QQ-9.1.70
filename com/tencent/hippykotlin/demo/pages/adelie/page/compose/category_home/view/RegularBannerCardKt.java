package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.ReportKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.AdelieHomePageBannerItemData;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQAnimatedImageKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQCommonNApiModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.emoticonview.report.EmotionDaTongReportUtil;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class RegularBannerCardKt {
    public static final void access$report(String str, e eVar, AdelieHomePageBannerItemData adelieHomePageBannerItemData) {
        e eVar2 = new e();
        eVar2.v("banner_name", adelieHomePageBannerItemData.name);
        eVar2.v("pic_url", adelieHomePageBannerItemData.picDayUrl9070);
        eVar2.v("jump_address", adelieHomePageBannerItemData.scheme);
        eVar2.v("banner_id", adelieHomePageBannerItemData.f114178id);
        Unit unit = Unit.INSTANCE;
        e eVar3 = new e(eVar.toString());
        eVar3.v("dt_eid", EmotionDaTongReportUtil.EM_BAS_BANNER);
        eVar3.v("cur_pg", eVar);
        Iterator<String> c16 = eVar2.c();
        if (c16 != null) {
            while (c16.hasNext()) {
                String next = c16.next();
                eVar3.v(next, eVar2.e(next));
            }
        }
        eVar3.v(MiniAppDesktopDtReportHelper.DT_MINI_PARENT_EID, null);
        ReportKt.reportCustomDTEvent(str, eVar3);
    }

    public static final void RegularBannerCard(final AdelieHomePageBannerItemData adelieHomePageBannerItemData, final e eVar, Composer composer, final int i3) {
        String str;
        Composer startRestartGroup = composer.startRestartGroup(511970166);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(511970166, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RegularBannerCard (RegularBannerCard.kt:18)");
        }
        i r16 = ViewEventPropUpdaterKt.r(ViewEventPropUpdaterKt.d(ComposeLayoutPropUpdaterKt.j(ComposeLayoutPropUpdaterKt.f(i.INSTANCE, 0.0f, 1, null), 0.0f, 1, null), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RegularBannerCardKt$RegularBannerCard$modifier$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                QQKuiklyPlatformApi.Companion.openPage$default(AdelieHomePageBannerItemData.this.scheme, false, 6);
                RegularBannerCardKt.access$report("dt_clck", eVar, AdelieHomePageBannerItemData.this);
                return Unit.INSTANCE;
            }
        }, 3, null), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RegularBannerCardKt$RegularBannerCard$modifier$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                RegularBannerCardKt.access$report("dt_imp", e.this, adelieHomePageBannerItemData);
                return Unit.INSTANCE;
            }
        });
        adelieHomePageBannerItemData.getClass();
        QQCommonNApiModule.Companion companion = QQCommonNApiModule.Companion;
        if (((QQCommonNApiModule) c.f117352a.g().acquireModule("QQCommonNApiModule")).isDarkTheme()) {
            str = adelieHomePageBannerItemData.picNightUrl9070;
            if (str.length() == 0) {
                str = adelieHomePageBannerItemData.picNightUrl;
            }
        } else {
            str = adelieHomePageBannerItemData.picDayUrl9070;
            if (str.length() == 0) {
                str = adelieHomePageBannerItemData.picDayUrl;
            }
        }
        QQAnimatedImageKt.QQAnimatedImage(str, r16, false, null, startRestartGroup, 64, 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RegularBannerCardKt$RegularBannerCard$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                RegularBannerCardKt.RegularBannerCard(AdelieHomePageBannerItemData.this, eVar, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
