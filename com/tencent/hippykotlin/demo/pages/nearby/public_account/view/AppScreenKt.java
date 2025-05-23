package com.tencent.hippykotlin.demo.pages.nearby.public_account.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.avcore.jni.audiodevice.TraeAudioManager;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIGlobalLoadingViewKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPublicAccountViewModel;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.mobileqq.soload.api.SoLoad;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.lifecycle.common.Lifecycle;
import com.tencent.ntcompose.lifecycle.viewmodel.b;
import com.tencent.ntcompose.lifecycle.viewmodel.c;
import com.tencent.ntcompose.lifecycle.viewmodel.compose.a;
import com.tencent.ntcompose.lifecycle.viewmodel.e;
import com.tencent.ntcompose.lifecycle.viewmodel.g;
import com.tencent.ntcompose.lifecycle.viewmodel.i;
import com.tencent.ntcompose.lifecycle.viewmodel.k;
import com.tencent.ntcompose.material.ButtonKt;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.material.r;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AppScreenKt {
    public static final void AppScreen(final i iVar, final QQStrangerPublicAccountViewModel qQStrangerPublicAccountViewModel, Composer composer, final int i3, final int i16) {
        b bVar;
        Composer startRestartGroup = composer.startRestartGroup(685496702);
        int i17 = i16 & 2;
        int i18 = i17 != 0 ? i3 | 16 : i3;
        if ((i16 & 3) == 3 && (i18 & 81) == 16 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            startRestartGroup.startDefaults();
            if ((i3 & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                if ((i16 & 1) != 0) {
                    iVar = i.INSTANCE;
                }
                if (i17 != 0) {
                    AppScreenKt$AppScreen$1 appScreenKt$AppScreen$1 = new Function1<b, QQStrangerPublicAccountViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.AppScreenKt$AppScreen$1
                        @Override // kotlin.jvm.functions.Function1
                        public final QQStrangerPublicAccountViewModel invoke(b bVar2) {
                            return new QQStrangerPublicAccountViewModel();
                        }
                    };
                    startRestartGroup.startReplaceableGroup(1485077867);
                    Object consume = startRestartGroup.consume(CompositionLocalsKt.f());
                    if (consume != null) {
                        k kVar = (k) consume;
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(QQStrangerPublicAccountViewModel.class);
                        e eVar = new e();
                        eVar.a(Reflection.getOrCreateKotlinClass(QQStrangerPublicAccountViewModel.class), appScreenKt$AppScreen$1);
                        i.b b16 = eVar.b();
                        if (kVar instanceof c) {
                            bVar = ((c) kVar).a();
                        } else {
                            bVar = b.a.f339329b;
                        }
                        g c16 = a.c(orCreateKotlinClass, kVar, null, b16, bVar, startRestartGroup, TraeAudioManager.CustomHandler.MSG_VOICE_CALL_PRE_PROCESS, 0);
                        startRestartGroup.endReplaceableGroup();
                        qQStrangerPublicAccountViewModel = (QQStrangerPublicAccountViewModel) c16;
                    } else {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                    }
                }
            } else {
                startRestartGroup.skipToGroupEnd();
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(685496702, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.AppScreen (AppScreen.kt:51)");
            }
            a.b(qQStrangerPublicAccountViewModel, ((com.tencent.ntcompose.lifecycle.common.c) startRestartGroup.consume(CompositionLocalsKt.e())).getLifecycle(), startRestartGroup, (Lifecycle.f339325a << 3) | 8);
            BoxKt.a(ComposeLayoutPropUpdaterKt.h(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 310029752, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.AppScreenKt$AppScreen$2
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar2, Composer composer2, Integer num) {
                    String str;
                    String str2;
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 81) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(310029752, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.AppScreen.<anonymous> (AppScreen.kt:58)");
                        }
                        QQStrangerPublicAccountViewModel qQStrangerPublicAccountViewModel2 = QQStrangerPublicAccountViewModel.this;
                        if (qQStrangerPublicAccountViewModel2.getAppId() == 2 && !com.tencent.kuikly.core.manager.c.f117352a.g().isNightMode()) {
                            str = "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_iQ1A1gAUcRF.png";
                        } else if (qQStrangerPublicAccountViewModel2.getAppId() == 2 && com.tencent.kuikly.core.manager.c.f117352a.g().isNightMode()) {
                            str = "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_jtZen9c3KS1.png";
                        } else if (qQStrangerPublicAccountViewModel2.getAppId() != 2 && !com.tencent.kuikly.core.manager.c.f117352a.g().isNightMode()) {
                            str = "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_6xV31l37cfL.png";
                        } else {
                            str = "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_--yk5LlfdLX.png";
                        }
                        AppScreenKt.access$BackgroundView(str, composer3, 0);
                        h j3 = h.INSTANCE.j();
                        if (QQStrangerPublicAccountViewModel.this.getAppId() == 2) {
                            str2 = "\u9644\u8fd1";
                        } else {
                            str2 = SoLoad.BIZ_TRTC_PARTY_HOUSE;
                        }
                        String image = QUIToken.INSTANCE.image("more", QUIToken.color$default("icon_primary"));
                        final QQStrangerPublicAccountViewModel qQStrangerPublicAccountViewModel3 = QQStrangerPublicAccountViewModel.this;
                        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.AppScreenKt$AppScreen$2.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                QQStrangerPublicAccountViewModel.this.getClass();
                                QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                QQKuiklyPlatformApi.Companion.closePage$default();
                                return Unit.INSTANCE;
                            }
                        };
                        final QQStrangerPublicAccountViewModel qQStrangerPublicAccountViewModel4 = QQStrangerPublicAccountViewModel.this;
                        QUINavBarKt.QUINavBar(j3, null, null, str2, image, null, function0, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.AppScreenKt$AppScreen$2.2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                String str3;
                                QQStrangerPublicAccountViewModel qQStrangerPublicAccountViewModel5 = QQStrangerPublicAccountViewModel.this;
                                qQStrangerPublicAccountViewModel5.getClass();
                                QQNearbyModule companion = QQNearbyModule.Companion.getInstance();
                                int appId = qQStrangerPublicAccountViewModel5.getAppId();
                                companion.getClass();
                                if (appId != 1) {
                                    str3 = appId != 2 ? null : "3948659008";
                                } else {
                                    str3 = "3932480809";
                                }
                                if (str3 == null) {
                                    KLog.INSTANCE.e("QQNearbyModule", "startQQStrangerPublicAccountDetail: invalid appID: " + appId);
                                } else {
                                    com.tencent.kuikly.core.nvi.serialization.json.e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m(IPublicAccountBrowser.KEY_PUB_UIN, str3);
                                    Unit unit = Unit.INSTANCE;
                                    companion.asyncToNativeMethod("startQQStrangerPublicAccountDetail", m3, (Function1<? super com.tencent.kuikly.core.nvi.serialization.json.e, Unit>) null);
                                }
                                return Unit.INSTANCE;
                            }
                        }, QQStrangerPublicAccountViewModel.this.isHeaderRefreshing.getValue().booleanValue(), 0.0f, composer3, 8, 550);
                        int intValue2 = QQStrangerPublicAccountViewModel.this.pageState.getValue().intValue();
                        if (intValue2 == 0) {
                            composer3.startReplaceableGroup(-1469547487);
                            QUIGlobalLoadingViewKt.QUIGlobalLoadingView(null, null, composer3, 0, 3);
                            composer3.endReplaceableGroup();
                        } else if (intValue2 == 1) {
                            composer3.startReplaceableGroup(-1469546984);
                            AppScreenKt.access$QQStrangerPAContentView(QQStrangerPublicAccountViewModel.this, composer3, 8);
                            composer3.endReplaceableGroup();
                        } else if (intValue2 == 2) {
                            composer3.startReplaceableGroup(-1469547358);
                            final QQStrangerPublicAccountViewModel qQStrangerPublicAccountViewModel5 = QQStrangerPublicAccountViewModel.this;
                            AppScreenKt.access$LocationErrorView(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.AppScreenKt$AppScreen$2.3
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Unit invoke() {
                                    QQStrangerPublicAccountViewModel qQStrangerPublicAccountViewModel6 = QQStrangerPublicAccountViewModel.this;
                                    qQStrangerPublicAccountViewModel6.pageState.setValue(0);
                                    qQStrangerPublicAccountViewModel6.onCreateWithEnvReady(false);
                                    return Unit.INSTANCE;
                                }
                            }, composer3, 0);
                            composer3.endReplaceableGroup();
                        } else if (intValue2 != 3) {
                            composer3.startReplaceableGroup(-1469546915);
                            composer3.endReplaceableGroup();
                        } else {
                            composer3.startReplaceableGroup(-1469547169);
                            final QQStrangerPublicAccountViewModel qQStrangerPublicAccountViewModel6 = QQStrangerPublicAccountViewModel.this;
                            AppScreenKt.access$NetworkErrorView(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.AppScreenKt$AppScreen$2.4
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Unit invoke() {
                                    QQStrangerPublicAccountViewModel qQStrangerPublicAccountViewModel7 = QQStrangerPublicAccountViewModel.this;
                                    qQStrangerPublicAccountViewModel7.getClass();
                                    KLog.INSTANCE.i("QQStrangerPublicAccountVM", "onNetworkErrorViewClick");
                                    qQStrangerPublicAccountViewModel7.pageState.setValue(0);
                                    qQStrangerPublicAccountViewModel7.onFetchCardList(false, null);
                                    return Unit.INSTANCE;
                                }
                            }, composer3, 0);
                            composer3.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 3080, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.AppScreenKt$AppScreen$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                AppScreenKt.AppScreen(com.tencent.ntcompose.core.i.this, qQStrangerPublicAccountViewModel, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$BackgroundView(final String str, Composer composer, final int i3) {
        final int i16;
        Composer startRestartGroup = composer.startRestartGroup(1738099208);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(str) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i16 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1738099208, i16, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.BackgroundView (AppScreen.kt:93)");
            }
            BoxKt.a(ModifiersKt.c(ComposeLayoutPropUpdaterKt.h(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), QUIToken.color$default("bg_bottom_standard")), Alignment.TopCenter, null, ComposableLambdaKt.composableLambda(startRestartGroup, -2086051902, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.AppScreenKt$BackgroundView$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer2, Integer num) {
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 81) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2086051902, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.BackgroundView.<anonymous> (AppScreen.kt:100)");
                        }
                        ImageKt.a(str, null, null, null, null, ComposeLayoutPropUpdaterKt.v(com.tencent.ntcompose.core.i.INSTANCE, ((com.tencent.ntcompose.ui.platform.a) composer3.consume(CompositionLocalsKt.d())).e(), (((com.tencent.ntcompose.ui.platform.a) composer3.consume(CompositionLocalsKt.d())).e() * 1590.0f) / 1125.0f), null, com.tencent.ntcompose.material.h.INSTANCE.b(), null, null, null, null, null, null, null, null, null, null, null, null, null, composer3, (i16 & 14) | 12845056, 0, 0, 2096990);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 3128, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.AppScreenKt$BackgroundView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                AppScreenKt.access$BackgroundView(str, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$LocationErrorView(final Function0 function0, Composer composer, final int i3) {
        int i16;
        Composer startRestartGroup = composer.startRestartGroup(218297638);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(function0) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i16 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(218297638, i16, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.LocationErrorView (AppScreen.kt:151)");
            }
            TipView("\u91cd\u65b0\u6388\u6743", "\u5b9a\u4f4d\u6388\u6743\u83b7\u53d6\u5931\u8d25", "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_LqSqe-JNiLF.png", function0, null, startRestartGroup, ((i16 << 9) & 7168) | 438, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.AppScreenKt$LocationErrorView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                AppScreenKt.access$LocationErrorView(function0, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$NetworkErrorView(final Function0 function0, Composer composer, final int i3) {
        int i16;
        Composer startRestartGroup = composer.startRestartGroup(1894281475);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(function0) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i16 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1894281475, i16, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.NetworkErrorView (AppScreen.kt:139)");
            }
            TipView("\u91cd\u65b0\u52a0\u8f7d", "\u7f51\u7edc\u8fde\u63a5\u5f02\u5e38", "data:image/png;base64,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", function0, null, startRestartGroup, ((i16 << 9) & 7168) | 438, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.AppScreenKt$NetworkErrorView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                AppScreenKt.access$NetworkErrorView(function0, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$QQStrangerPAContentView(final QQStrangerPublicAccountViewModel qQStrangerPublicAccountViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(1377506187);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1377506187, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAContentView (AppScreen.kt:111)");
        }
        BoxKt.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.h(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), 0.0f, ((com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d())).b(), 0.0f, 0.0f, 13, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -510012527, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.AppScreenKt$QQStrangerPAContentView$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-510012527, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAContentView.<anonymous> (AppScreen.kt:114)");
                    }
                    com.tencent.ntcompose.ui.platform.a aVar = (com.tencent.ntcompose.ui.platform.a) composer3.consume(CompositionLocalsKt.d());
                    QQStrangerPublicAccountViewModel.this.feedListViewModel.buildLazyVerticalGrid(new r.a(2), ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.w(com.tencent.ntcompose.core.i.INSTANCE, aVar.e()), 0.0f, 1, null), aVar.e(), null, com.tencent.ntcompose.foundation.layout.k.c(6.0f, 0.0f, 6.0f, 0.0f, 10, null), 6.0f, 6.0f, null, null, null, null, null, null, 10, Float.valueOf(aVar.d() * 2), null, null, null, null, null, ComposableSingletons$AppScreenKt.f88lambda1, composer3, 1769536, 3072, 70, 1023880);
                    if (QQStrangerPublicAccountViewModel.this.showUserRegisterLoading.getValue().booleanValue()) {
                        QUIGlobalLoadingViewKt.QUIGlobalLoadingView("\u6ce8\u518c\u4e2d", null, composer3, 6, 2);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 3080, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.AppScreenKt$QQStrangerPAContentView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                AppScreenKt.access$QQStrangerPAContentView(QQStrangerPublicAccountViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TipView(final String str, final String str2, final String str3, final Function0<Unit> function0, com.tencent.ntcompose.core.i iVar, Composer composer, final int i3, final int i16) {
        int i17;
        final int i18;
        int i19;
        final com.tencent.ntcompose.core.i iVar2;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-2103695312);
        if ((i16 & 1) != 0) {
            i17 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i17 = (startRestartGroup.changed(str) ? 4 : 2) | i3;
        } else {
            i17 = i3;
        }
        if ((i16 & 2) != 0) {
            i17 |= 48;
        } else if ((i3 & 112) == 0) {
            i17 |= startRestartGroup.changed(str2) ? 32 : 16;
            if ((i16 & 4) == 0) {
                i17 |= MsgConstant.KRMFILETHUMBSIZE384;
            } else if ((i3 & 896) == 0) {
                i17 |= startRestartGroup.changed(str3) ? 256 : 128;
            }
            if ((i16 & 8) == 0) {
                i17 |= 3072;
            } else if ((i3 & 7168) == 0) {
                i17 |= startRestartGroup.changed(function0) ? 2048 : 1024;
            }
            i18 = i17;
            i19 = i16 & 16;
            if (i19 != 16 && (i18 & 5851) == 1170 && startRestartGroup.getSkipping()) {
                startRestartGroup.skipToGroupEnd();
                iVar2 = iVar;
            } else {
                com.tencent.ntcompose.core.i iVar3 = i19 == 0 ? com.tencent.ntcompose.core.i.INSTANCE : iVar;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2103695312, i18, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.TipView (AppScreen.kt:164)");
                }
                BoxKt.a(ComposeLayoutPropUpdaterKt.h(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), Alignment.Center, null, ComposableLambdaKt.composableLambda(startRestartGroup, -168679062, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.AppScreenKt$TipView$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer2, Integer num) {
                        Composer composer3 = composer2;
                        int intValue = num.intValue();
                        if ((intValue & 81) == 16 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                        } else {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-168679062, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.TipView.<anonymous> (AppScreen.kt:174)");
                            }
                            a.e b16 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.b();
                            Alignment.Horizontal b17 = Alignment.INSTANCE.b();
                            com.tencent.ntcompose.core.i A = ComposeLayoutPropUpdaterKt.A(com.tencent.ntcompose.core.i.INSTANCE);
                            final String str4 = str3;
                            final int i26 = i18;
                            final String str5 = str2;
                            final Function0<Unit> function02 = function0;
                            final String str6 = str;
                            ColumnKt.a(A, b16, b17, null, ComposableLambdaKt.composableLambda(composer3, -1903387757, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.AppScreenKt$TipView$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public final Unit invoke(d dVar, Composer composer4, Integer num2) {
                                    Composer composer5 = composer4;
                                    int intValue2 = num2.intValue();
                                    if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                        composer5.skipToGroupEnd();
                                    } else {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1903387757, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.TipView.<anonymous>.<anonymous> (AppScreen.kt:179)");
                                        }
                                        h color$default = QUIToken.color$default("icon_primary");
                                        int c16 = com.tencent.ntcompose.material.h.INSTANCE.c();
                                        i.Companion companion = com.tencent.ntcompose.core.i.INSTANCE;
                                        ImageKt.a(str4, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion, 100.0f), null, c16, null, null, null, null, null, null, null, null, null, null, null, color$default, null, composer5, ((i26 >> 6) & 14) | 12845056, 1073741824, 0, 1572702);
                                        bp3.c e16 = bp3.c.INSTANCE.e();
                                        TextKt.a(str5, ComposeLayoutPropUpdaterKt.n(companion, 0.0f, 24.0f, 0.0f, 0.0f, 13, null), null, QUIToken.color$default("text_primary"), Float.valueOf(17), null, e16, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, ((i26 >> 3) & 14) | 1601600, 0, 0, 134217636);
                                        com.tencent.ntcompose.core.i n3 = ComposeLayoutPropUpdaterKt.n(ModifiersKt.j(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 168.0f), 45.0f), QUIToken.color$default("button_bg_primary_default")), 4.0f), 0.0f, 16.0f, 0.0f, 0.0f, 13, null);
                                        final Function0<Unit> function03 = function02;
                                        composer5.startReplaceableGroup(1157296644);
                                        boolean changed = composer5.changed(function03);
                                        Object rememberedValue = composer5.rememberedValue();
                                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.AppScreenKt$TipView$1$1$1$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    function03.invoke();
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            composer5.updateRememberedValue(rememberedValue);
                                        }
                                        composer5.endReplaceableGroup();
                                        Function1 function1 = (Function1) rememberedValue;
                                        final String str7 = str6;
                                        final int i27 = i26;
                                        ButtonKt.a(null, function1, n3, null, ComposableLambdaKt.composableLambda(composer5, 1898084552, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.AppScreenKt.TipView.1.1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(n nVar, Composer composer6, Integer num3) {
                                                Composer composer7 = composer6;
                                                int intValue3 = num3.intValue();
                                                if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                    composer7.skipToGroupEnd();
                                                } else {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1898084552, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.TipView.<anonymous>.<anonymous>.<anonymous> (AppScreen.kt:201)");
                                                    }
                                                    TextKt.a(str7, null, null, QUIToken.color$default("button_text_primary_default"), Float.valueOf(17.0f), null, bp3.c.INSTANCE.f(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, (i27 & 14) | 1601536, 0, 0, 134217638);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), composer5, 25088, 9);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }), composer3, 24648, 8);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }), startRestartGroup, 3128, 4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                iVar2 = iVar3;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                return;
            }
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.AppScreenKt$TipView$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    AppScreenKt.TipView(str, str2, str3, function0, iVar2, composer2, i3 | 1, i16);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        if ((i16 & 4) == 0) {
        }
        if ((i16 & 8) == 0) {
        }
        i18 = i17;
        i19 = i16 & 16;
        if (i19 != 16) {
        }
        if (i19 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        BoxKt.a(ComposeLayoutPropUpdaterKt.h(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), Alignment.Center, null, ComposableLambdaKt.composableLambda(startRestartGroup, -168679062, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.AppScreenKt$TipView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-168679062, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.TipView.<anonymous> (AppScreen.kt:174)");
                    }
                    a.e b16 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.b();
                    Alignment.Horizontal b17 = Alignment.INSTANCE.b();
                    com.tencent.ntcompose.core.i A = ComposeLayoutPropUpdaterKt.A(com.tencent.ntcompose.core.i.INSTANCE);
                    final String str4 = str3;
                    final int i26 = i18;
                    final String str5 = str2;
                    final Function0<Unit> function02 = function0;
                    final String str6 = str;
                    ColumnKt.a(A, b16, b17, null, ComposableLambdaKt.composableLambda(composer3, -1903387757, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.AppScreenKt$TipView$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(d dVar, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1903387757, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.TipView.<anonymous>.<anonymous> (AppScreen.kt:179)");
                                }
                                h color$default = QUIToken.color$default("icon_primary");
                                int c16 = com.tencent.ntcompose.material.h.INSTANCE.c();
                                i.Companion companion = com.tencent.ntcompose.core.i.INSTANCE;
                                ImageKt.a(str4, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion, 100.0f), null, c16, null, null, null, null, null, null, null, null, null, null, null, color$default, null, composer5, ((i26 >> 6) & 14) | 12845056, 1073741824, 0, 1572702);
                                bp3.c e16 = bp3.c.INSTANCE.e();
                                TextKt.a(str5, ComposeLayoutPropUpdaterKt.n(companion, 0.0f, 24.0f, 0.0f, 0.0f, 13, null), null, QUIToken.color$default("text_primary"), Float.valueOf(17), null, e16, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, ((i26 >> 3) & 14) | 1601600, 0, 0, 134217636);
                                com.tencent.ntcompose.core.i n3 = ComposeLayoutPropUpdaterKt.n(ModifiersKt.j(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 168.0f), 45.0f), QUIToken.color$default("button_bg_primary_default")), 4.0f), 0.0f, 16.0f, 0.0f, 0.0f, 13, null);
                                final Function0<Unit> function03 = function02;
                                composer5.startReplaceableGroup(1157296644);
                                boolean changed = composer5.changed(function03);
                                Object rememberedValue = composer5.rememberedValue();
                                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.AppScreenKt$TipView$1$1$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ClickParams clickParams) {
                                            function03.invoke();
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composer5.updateRememberedValue(rememberedValue);
                                }
                                composer5.endReplaceableGroup();
                                Function1 function1 = (Function1) rememberedValue;
                                final String str7 = str6;
                                final int i27 = i26;
                                ButtonKt.a(null, function1, n3, null, ComposableLambdaKt.composableLambda(composer5, 1898084552, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.AppScreenKt.TipView.1.1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(n nVar, Composer composer6, Integer num3) {
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1898084552, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.TipView.<anonymous>.<anonymous>.<anonymous> (AppScreen.kt:201)");
                                            }
                                            TextKt.a(str7, null, null, QUIToken.color$default("button_text_primary_default"), Float.valueOf(17.0f), null, bp3.c.INSTANCE.f(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, (i27 & 14) | 1601536, 0, 0, 134217638);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 25088, 9);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 24648, 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 3128, 4);
        if (ComposerKt.isTraceInProgress()) {
        }
        iVar2 = iVar3;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
