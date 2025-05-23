package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.compose.page.BaseComposePager;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt;
import com.tencent.hippykotlin.demo.pages.base.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUITokenThemeMode;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.ntcompose.activity.a;
import com.tencent.ntcompose.activity.b;
import com.tencent.ntcompose.animation.l;
import com.tencent.ntcompose.animation.m;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.material.AlertCustomDialogKt;
import com.tencent.ntcompose.material.AlertDialogTransitionType;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* loaded from: classes31.dex */
public final class AdelieAgreementConsentPage extends BaseComposePager {
    public static final /* synthetic */ int $r8$clinit = 0;

    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity, com.tencent.ntcompose.activity.ComponentActivity
    public final void onCreate(a aVar) {
        super.onCreate(aVar);
        b.c(this, null, ComposableLambdaKt.composableLambdaInstance(-1370286849, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieAgreementConsentPage$onCreate$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer, Integer num) {
                Composer composer2 = composer;
                int intValue = num.intValue();
                if ((intValue & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1370286849, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieAgreementConsentPage.onCreate.<anonymous> (AdelieAgreementConsentPage.kt:47)");
                    }
                    composer2.startReplaceableGroup(-492369756);
                    Object rememberedValue = composer2.rememberedValue();
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                        composer2.updateRememberedValue(rememberedValue);
                    }
                    composer2.endReplaceableGroup();
                    final MutableState mutableState = (MutableState) rememberedValue;
                    i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, ((com.tencent.ntcompose.ui.platform.a) composer2.consume(CompositionLocalsKt.d())).e()), ((com.tencent.ntcompose.ui.platform.a) composer2.consume(CompositionLocalsKt.d())).d());
                    final AdelieAgreementConsentPage adelieAgreementConsentPage = AdelieAgreementConsentPage.this;
                    BoxKt.a(k3, null, null, ComposableLambdaKt.composableLambda(composer2, 1408473093, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieAgreementConsentPage$onCreate$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer3, Integer num2) {
                            Composer composer4 = composer3;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1408473093, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieAgreementConsentPage.onCreate.<anonymous>.<anonymous> (AdelieAgreementConsentPage.kt:53)");
                                }
                                boolean booleanValue = mutableState.getValue().booleanValue();
                                h a16 = h.INSTANCE.a(0.5f);
                                AlertDialogTransitionType alertDialogTransitionType = AlertDialogTransitionType.DIRECTION_FROM_CENTER;
                                l b16 = com.tencent.ntcompose.animation.b.b(0.85f, 0.0f, 0, 0.0f, null, 0, false, 126, null);
                                m d16 = com.tencent.ntcompose.animation.b.d(200, 0, com.tencent.ntcompose.animation.i.c(), null, 10, null);
                                Alignment alignment = Alignment.TopCenter;
                                C13531 c13531 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieAgreementConsentPage.onCreate.1.1.1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final /* bridge */ /* synthetic */ Unit invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                AnonymousClass2 anonymousClass2 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieAgreementConsentPage.onCreate.1.1.2
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        Lazy lazy;
                                        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                        QQKuiklyPlatformApi.Companion.closePage$default();
                                        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AdelieKuiklyBaseModule>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieAgreementConsentPage$onCreate$1$1$2$adelieKuiklyModule$2
                                            @Override // kotlin.jvm.functions.Function0
                                            public final AdelieKuiklyBaseModule invoke() {
                                                return (AdelieKuiklyBaseModule) c.f117352a.g().acquireModule("AdelieKuiklyBaseModule");
                                            }
                                        });
                                        AdelieKuiklyBaseModule adelieKuiklyBaseModule = (AdelieKuiklyBaseModule) lazy.getValue();
                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ADELIE_HOME_PAGE_HAS_SHOW_USER_AGREEMENT_");
                                        m3.append(PageDataExtKt.getUin(c.f117352a.g().getPageData()));
                                        String sb5 = m3.toString();
                                        adelieKuiklyBaseModule.getClass();
                                        adelieKuiklyBaseModule.setStringToCache$enumunboxing$(sb5, String.valueOf(true), 1, 2);
                                        return Unit.INSTANCE;
                                    }
                                };
                                AnonymousClass3 anonymousClass3 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieAgreementConsentPage.onCreate.1.1.3
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        AdelieAgreementConsentPage$onCreate$1$1$3$$ExternalSyntheticOutline0.m((k) c.f117352a.g().acquireModule("KRNotifyModule"), "adelie_showing_user_agreement", false, 4, null);
                                        return Unit.INSTANCE;
                                    }
                                };
                                final MutableState<Boolean> mutableState2 = mutableState;
                                final AdelieAgreementConsentPage adelieAgreementConsentPage2 = adelieAgreementConsentPage;
                                AlertCustomDialogKt.a(booleanValue, false, a16, c13531, alertDialogTransitionType, anonymousClass2, anonymousClass3, alignment, b16, d16, ComposableLambdaKt.composableLambda(composer4, 764405048, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieAgreementConsentPage.onCreate.1.1.4
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(Composer composer5, Integer num3) {
                                        Composer composer6 = composer5;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 11) == 2 && composer6.getSkipping()) {
                                            composer6.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(764405048, intValue3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieAgreementConsentPage.onCreate.<anonymous>.<anonymous>.<anonymous> (AdelieAgreementConsentPage.kt:77)");
                                            }
                                            final MutableState<Boolean> mutableState3 = mutableState2;
                                            composer6.startReplaceableGroup(1157296644);
                                            boolean changed = composer6.changed(mutableState3);
                                            Object rememberedValue2 = composer6.rememberedValue();
                                            if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue2 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieAgreementConsentPage$onCreate$1$1$4$1$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Unit invoke() {
                                                        mutableState3.setValue(Boolean.FALSE);
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                composer6.updateRememberedValue(rememberedValue2);
                                            }
                                            composer6.endReplaceableGroup();
                                            AdelieAgreementConsentPage adelieAgreementConsentPage3 = adelieAgreementConsentPage2;
                                            int i3 = AdelieAgreementConsentPage.$r8$clinit;
                                            adelieAgreementConsentPage3.getClass();
                                            e eVar = new e();
                                            eVar.v("dt_pgid", "pg_bas_agent_home_page_new");
                                            eVar.v("superior_source", c.f117352a.g().getPageData().n().q("superior_source", "1"));
                                            AgreementConsentViewKt.agreementConsentView((Function0) rememberedValue2, eVar, composer6, 64);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer4, 115043888, 6, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer2, 3080, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), 1, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity
    public final QUITokenThemeMode quiTokenThemeMode() {
        return QUITokenThemeMode.ONLY_DAY_AND_NIGHT;
    }
}
