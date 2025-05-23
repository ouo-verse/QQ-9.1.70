package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIButtonKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.module.QQFlashTransferKuiklyModule;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDebugViewModel;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.pager.a;
import com.tencent.ntcompose.activity.b;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.SwitchKt;
import com.tencent.ntcompose.material.TextFieldKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.qq.ntkernel.flash_transfer.IKernelFlashTransferService;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQTransferDebugActivity extends BaseComponentActivity {
    public final QQTransferDebugViewModel viewModel = new QQTransferDebugViewModel();
    public final String kTag = "QQTransferDebugActivity";

    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity, com.tencent.ntcompose.activity.ComponentActivity
    public final Map<String, Module> createExternalModules() {
        registerModule("QQFlashTransferKuiklyModule", new a() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDebugActivity$createExternalModules$1
            @Override // com.tencent.kuikly.core.pager.a
            public final Module createModule() {
                return new QQFlashTransferKuiklyModule();
            }
        });
        registerModule("KTIKernelFlashTransferService", new a() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDebugActivity$createExternalModules$2
            @Override // com.tencent.kuikly.core.pager.a
            public final Module createModule() {
                return new IKernelFlashTransferService();
            }
        });
        return super.createExternalModules();
    }

    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity, com.tencent.ntcompose.activity.ComponentActivity
    public final void onCreate(com.tencent.ntcompose.activity.a aVar) {
        super.onCreate(aVar);
        QQTransferDebugViewModel qQTransferDebugViewModel = this.viewModel;
        MutableState<Integer> mutableState = qQTransferDebugViewModel.isCustomExpireTimeOn;
        Utils utils = Utils.INSTANCE;
        Integer num = utils.cacheModule("").getInt("kCustomExpireTimeSwitchKey");
        mutableState.setValue(Integer.valueOf(num != null ? num.intValue() : 0));
        Integer num2 = utils.cacheModule("").getInt("kCustomExpireTimeValueKey");
        qQTransferDebugViewModel.customExpireTime = num2 != null ? num2.intValue() : 0;
        b.c(this, null, ComposableLambdaKt.composableLambdaInstance(-1510808496, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDebugActivity$onCreate$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer, Integer num3) {
                Composer composer2 = composer;
                int intValue = num3.intValue();
                if ((intValue & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1510808496, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDebugActivity.onCreate.<anonymous> (QQTransferDebugActivity.kt:83)");
                    }
                    QQTransferDebugActivity qQTransferDebugActivity = QQTransferDebugActivity.this;
                    qQTransferDebugActivity.body(qQTransferDebugActivity.viewModel, composer2, 72);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), 1, null);
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final void onPause() {
        super.onPause();
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final void onResume() {
        super.onResume();
    }

    public final void body(final QQTransferDebugViewModel qQTransferDebugViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-1442421342);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1442421342, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDebugActivity.body (QQTransferDebugActivity.kt:114)");
        }
        ColumnKt.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), QUIToken.color$default("bg_bottom_light")), null, Alignment.INSTANCE.b(), null, ComposableLambdaKt.composableLambda(startRestartGroup, 2100003531, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDebugActivity$body$1
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
                        ComposerKt.traceEventStart(2100003531, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDebugActivity.body.<anonymous> (QQTransferDebugActivity.kt:116)");
                    }
                    QQFTNavBarKt.QQFTNavBar(null, QUIToken.color$default("bg_nav_secondary"), null, null, null, "QQ\u95ea\u4f20Debug", null, null, null, null, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDebugActivity$body$1.1
                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                            QQKuiklyPlatformApi.Companion.closePage$default();
                            return Unit.INSTANCE;
                        }
                    }, null, null, null, null, 0.0f, composer3, 196672, 196614, 31709);
                    i.Companion companion = i.INSTANCE;
                    i z16 = ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null));
                    final QQTransferDebugViewModel qQTransferDebugViewModel2 = QQTransferDebugViewModel.this;
                    final QQTransferDebugActivity qQTransferDebugActivity = this;
                    RowKt.a(z16, null, null, null, null, ComposableLambdaKt.composableLambda(composer3, -742425367, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDebugActivity$body$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(n nVar, Composer composer4, Integer num2) {
                            int i16;
                            n nVar2 = nVar;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 14) == 0) {
                                i16 = (composer5.changed(nVar2) ? 4 : 2) | intValue2;
                            } else {
                                i16 = intValue2;
                            }
                            if ((i16 & 91) == 18 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-742425367, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDebugActivity.body.<anonymous>.<anonymous> (QQTransferDebugActivity.kt:126)");
                                }
                                i.Companion companion2 = i.INSTANCE;
                                TextKt.a("\u81ea\u5b9a\u4e49\u95ea\u4f20\u8fc7\u671f\u65f6\u95f4,\u5355\u4f4ds, 0\u8868\u793a\u7528\u540e\u53f0\u503c", nVar2.b(companion2, Alignment.Vertical.CenterVertically), null, QUIToken.color$default("text_primary"), Float.valueOf(14), null, c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 1601606, 0, 0, 134216612);
                                SpacerKt.a(nVar2.a(companion2, 1.0f), composer5, 8, 0);
                                boolean z17 = QQTransferDebugViewModel.this.isCustomExpireTimeOn.getValue().intValue() == 1;
                                final QQTransferDebugViewModel qQTransferDebugViewModel3 = QQTransferDebugViewModel.this;
                                final QQTransferDebugActivity qQTransferDebugActivity2 = qQTransferDebugActivity;
                                SwitchKt.a(z17, new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDebugActivity.body.1.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Boolean bool) {
                                        boolean booleanValue = bool.booleanValue();
                                        QQTransferDebugViewModel.this.isCustomExpireTimeOn.setValue(Integer.valueOf(booleanValue ? 1 : 0));
                                        CacheModule cacheModule = Utils.INSTANCE.cacheModule("");
                                        QQTransferDebugViewModel.Companion companion3 = QQTransferDebugViewModel.Companion;
                                        cacheModule.setInt("kCustomExpireTimeSwitchKey", Integer.valueOf(booleanValue ? 1 : 0));
                                        NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0.m("switch value changed value:", booleanValue ? 1 : 0, KLog.INSTANCE, qQTransferDebugActivity2.kTag);
                                        return Unit.INSTANCE;
                                    }
                                }, null, null, 0.0f, false, null, composer5, 0, 124);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 196616, 30);
                    composer3.startReplaceableGroup(-52243249);
                    if (QQTransferDebugViewModel.this.isCustomExpireTimeOn.getValue().intValue() == 1) {
                        i z17 = ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null));
                        final QQTransferDebugViewModel qQTransferDebugViewModel3 = QQTransferDebugViewModel.this;
                        RowKt.a(z17, null, null, null, null, ComposableLambdaKt.composableLambda(composer3, -1287430546, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDebugActivity$body$1.3
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(n nVar, Composer composer4, Integer num2) {
                                int i16;
                                n nVar2 = nVar;
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 14) == 0) {
                                    i16 = (composer5.changed(nVar2) ? 4 : 2) | intValue2;
                                } else {
                                    i16 = intValue2;
                                }
                                if ((i16 & 91) == 18 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1287430546, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDebugActivity.body.<anonymous>.<anonymous> (QQTransferDebugActivity.kt:147)");
                                    }
                                    i.Companion companion2 = i.INSTANCE;
                                    i h16 = ModifiersKt.h(nVar2.b(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion2, 100.0f), 30.0f), Alignment.Vertical.CenterVertically), 1.0f, h.INSTANCE.g(), null, 4, null);
                                    String valueOf = String.valueOf(QQTransferDebugViewModel.this.customExpireTime);
                                    final QQTransferDebugViewModel qQTransferDebugViewModel4 = QQTransferDebugViewModel.this;
                                    TextFieldKt.a(valueOf, null, new Function1<String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDebugActivity.body.1.3.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(String str) {
                                            String str2 = str;
                                            if (str2.length() > 0) {
                                                QQTransferDebugViewModel.this.customExpireTime = Integer.parseInt(str2);
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }, h16, null, null, false, null, null, null, null, null, null, null, null, false, null, null, false, null, null, false, composer5, 4096, 0, 0, 4194290);
                                    SpacerKt.a(nVar2.a(companion2, 1.0f), composer5, 8, 0);
                                    i k3 = ComposeLayoutPropUpdaterKt.k(companion2, 30.0f);
                                    final QQTransferDebugViewModel qQTransferDebugViewModel5 = QQTransferDebugViewModel.this;
                                    QUIButtonKt.QUIButton(k3, null, null, "\u786e\u5b9a", null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDebugActivity.body.1.3.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ClickParams clickParams) {
                                            CacheModule cacheModule = Utils.INSTANCE.cacheModule("");
                                            QQTransferDebugViewModel.Companion companion3 = QQTransferDebugViewModel.Companion;
                                            cacheModule.setInt("kCustomExpireTimeValueKey", Integer.valueOf(QQTransferDebugViewModel.this.customExpireTime));
                                            ((QQKuiklyPlatformApi) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).qqToast(AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u95ea\u4f20\u8fc7\u671f\u65f6\u95f4\u5df2\u8bbe\u7f6e\u4e3a"), QQTransferDebugViewModel.this.customExpireTime, 's'), QToastMode.Success);
                                            return Unit.INSTANCE;
                                        }
                                    }, null, null, composer5, 3080, 214);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 196616, 30);
                    }
                    composer3.endReplaceableGroup();
                    i q16 = ModifiersKt.q(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.v(companion, 264.0f, 48.0f), 0.0f, 20.0f, 0.0f, 0.0f, 13, null), uo3.c.a(22.0f));
                    final QQTransferDebugActivity qQTransferDebugActivity2 = this;
                    final QQTransferDebugViewModel qQTransferDebugViewModel4 = QQTransferDebugViewModel.this;
                    QUIButtonKt.QUIButton(q16, null, null, "\u9009\u62e9\u6587\u4ef6\u4e0a\u4f20", null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDebugActivity$body$1.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ClickParams clickParams) {
                            KLog.INSTANCE.d(QQTransferDebugActivity.this.kTag, "fullScreenEmptyView onClick \u9009\u62e9\u6587\u4ef6");
                            qQTransferDebugViewModel4.getClass();
                            QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                            QQKuiklyPlatformApi.Companion.openPage$default("mqqapi://kuikly/open?version=1&src_type=app&page_name=QQTransferCenterActivity&local_bundle_name=nearbypro&qui_token_theme_mode=0&use_host_display_metrics=1&force_show_empty=1", false, 6);
                            return Unit.INSTANCE;
                        }
                    }, null, null, composer3, 3080, 214);
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
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDebugActivity$body$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQTransferDebugActivity.this.body(qQTransferDebugViewModel, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
