package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.ReportKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieMyTtsVoiceState;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsDataManager;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsInfo;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsPlayerManager;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsReport;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingViewModel;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.TtsPlayState;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.ntcompose.foundation.lazy.layout.a;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class TtsListKt {
    public static final void access$TtsList$onClick(Ref.LongRef longRef, AdelieTtsSettingViewModel adelieTtsSettingViewModel, AdelieTtsInfo adelieTtsInfo) {
        KLog.INSTANCE.i("LazyListScope.TtsList", "click ttsInfo=" + adelieTtsInfo);
        long currentTimeStamp = Utils.INSTANCE.currentBridgeModule().currentTimeStamp();
        if (currentTimeStamp - longRef.element > 500) {
            e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_ugc_tone_selection");
            e m16 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_ugc_tone_selection");
            m16.v("current_timbre", AdelieTtsReport.currentTimbreId);
            m3.v("cur_pg", m16);
            m3.v("dt_eid", "em_bas_timbre_articles");
            m3.v("timbre_id", adelieTtsInfo.ttsId);
            m3.t("timbre_type", BoxType$EnumUnboxingSharedUtility.ordinal(adelieTtsInfo.type));
            ReportKt.reportCustomDTEvent("dt_clck", m3);
            if (adelieTtsInfo.getState() == AdelieMyTtsVoiceState.LOADING) {
                ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).qToast("\u58f0\u97f3\u751f\u6210\u4e2d\uff0c\u8bf7\u7a0d\u5019", QToastMode.Warning);
            } else if (adelieTtsInfo.getState() != AdelieMyTtsVoiceState.ERROR && adelieTtsInfo.getState() != AdelieMyTtsVoiceState.CANNOT) {
                AdelieTtsInfo selectTtsInfo = AdelieTtsDataManager.INSTANCE.getSelectTtsInfo();
                if (selectTtsInfo != null) {
                    AdelieTtsDataManager.preSelectTtsId = selectTtsInfo.ttsId;
                    selectTtsInfo.playState$delegate.setValue(TtsPlayState.NONE);
                }
                AdelieTtsPlayerManager.INSTANCE.startPlay(adelieTtsInfo);
                adelieTtsSettingViewModel.userIsSelected = true;
            } else {
                ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).qToast("\u751f\u6210\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5", QToastMode.Warning);
            }
            longRef.element = currentTimeStamp;
        }
    }

    public static final void TtsList(final a aVar, final AdelieTtsSettingViewModel adelieTtsSettingViewModel, Composer composer, final int i3) {
        List listOf;
        Composer startRestartGroup = composer.startRestartGroup(1360270066);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1360270066, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsList (TtsList.kt:22)");
        }
        Ref.LongRef longRef = new Ref.LongRef();
        listOf = CollectionsKt__CollectionsJVMKt.listOf(AdelieTtsDataManager.noneVoiceTtsInfo);
        TtsListSectionKt.TtsListSection(aVar, "", listOf, new TtsListKt$TtsList$1(longRef, adelieTtsSettingViewModel), null, null, startRestartGroup, PlayerResources.ViewId.EXTENDED_VIEW_BTN_NORMAL_BUTTON, 24);
        TtsListSectionKt.TtsListSection(aVar, "\u6211\u7684", AdelieTtsDataManager.myTtsInfoList._stateList, new TtsListKt$TtsList$2(longRef, adelieTtsSettingViewModel), new TtsListKt$TtsList$3(adelieTtsSettingViewModel), new TtsListKt$TtsList$4(adelieTtsSettingViewModel), startRestartGroup, PlayerResources.ViewId.EXTENDED_VIEW_BTN_NORMAL_BUTTON, 0);
        TtsListSectionKt.TtsListSection(aVar, "\u5b98\u65b9", AdelieTtsDataManager.officialTtsInfoList, new TtsListKt$TtsList$5(longRef, adelieTtsSettingViewModel), null, null, startRestartGroup, PlayerResources.ViewId.EXTENDED_VIEW_BTN_NORMAL_BUTTON, 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsListKt$TtsList$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                TtsListKt.TtsList(a.this, adelieTtsSettingViewModel, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
