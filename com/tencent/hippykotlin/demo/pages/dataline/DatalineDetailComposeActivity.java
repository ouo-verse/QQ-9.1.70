package com.tencent.hippykotlin.demo.pages.dataline;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.avcore.jni.audiodevice.TraeAudioManager;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIActionSheetItem;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIActionSheetKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineCommonViewKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineFooterViewKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineSwitchViewKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt;
import com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailUserIntent;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.Module;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
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
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.LazyColumnKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class DatalineDetailComposeActivity extends BaseComponentActivity {
    public static final void access$body(final DatalineDetailComposeActivity datalineDetailComposeActivity, Composer composer, final int i3) {
        final int i16;
        b bVar;
        datalineDetailComposeActivity.getClass();
        Composer startRestartGroup = composer.startRestartGroup(-1811495326);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(datalineDetailComposeActivity) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i16 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1811495326, i16, -1, "com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity.body (DatalineDetailComposeActivity.kt:49)");
            }
            final String p16 = datalineDetailComposeActivity.getPageData().n().p("target_uin");
            final int j3 = datalineDetailComposeActivity.getPageData().n().j("target_type");
            final int j16 = datalineDetailComposeActivity.getPageData().n().j("self_type");
            startRestartGroup.startReplaceableGroup(-1019837266);
            Integer valueOf = Integer.valueOf(j3);
            Integer valueOf2 = Integer.valueOf(j16);
            startRestartGroup.startReplaceableGroup(1618982084);
            boolean changed = startRestartGroup.changed(valueOf) | startRestartGroup.changed(p16) | startRestartGroup.changed(valueOf2);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1<b, DatalineDetailViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity$body$vm$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DatalineDetailViewModel invoke(b bVar2) {
                        return new DatalineDetailViewModel(p16, j3, j16);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            Function1 function1 = (Function1) rememberedValue;
            startRestartGroup.startReplaceableGroup(1485077867);
            Object consume = startRestartGroup.consume(CompositionLocalsKt.f());
            if (consume != null) {
                k kVar = (k) consume;
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(DatalineDetailViewModel.class);
                e eVar = new e();
                eVar.a(Reflection.getOrCreateKotlinClass(DatalineDetailViewModel.class), function1);
                i.b b16 = eVar.b();
                if (kVar instanceof c) {
                    bVar = ((c) kVar).a();
                } else {
                    bVar = b.a.f339329b;
                }
                g c16 = a.c(orCreateKotlinClass, kVar, null, b16, bVar, startRestartGroup, TraeAudioManager.CustomHandler.MSG_VOICE_CALL_PRE_PROCESS, 0);
                startRestartGroup.endReplaceableGroup();
                final DatalineDetailViewModel datalineDetailViewModel = (DatalineDetailViewModel) c16;
                a.b(datalineDetailViewModel, ((com.tencent.ntcompose.lifecycle.common.c) startRestartGroup.consume(CompositionLocalsKt.e())).getLifecycle(), startRestartGroup, (Lifecycle.f339325a << 3) | 8);
                startRestartGroup.endReplaceableGroup();
                BoxKt.a(ComposeLayoutPropUpdaterKt.h(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1035105436, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity$body$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar2, Composer composer2, Integer num) {
                        Composer composer3 = composer2;
                        int intValue = num.intValue();
                        if ((intValue & 81) == 16 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                        } else {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1035105436, intValue, -1, "com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity.body.<anonymous> (DatalineDetailComposeActivity.kt:56)");
                            }
                            String image = QUIToken.INSTANCE.image("token_bg", QUIToken.color$default("bg_bottom_standard"));
                            i.Companion companion = com.tencent.ntcompose.core.i.INSTANCE;
                            ImageKt.a(image, null, null, null, null, ComposeLayoutPropUpdaterKt.h(companion, 0.0f, 1, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer3, 262144, 0, 0, 2097118);
                            com.tencent.ntcompose.core.i d16 = ModifiersKt.d(ComposeLayoutPropUpdaterKt.h(companion, 0.0f, 1, null), QUIToken.color$default("bg_bottom_standard"));
                            final DatalineDetailComposeActivity datalineDetailComposeActivity2 = DatalineDetailComposeActivity.this;
                            final DatalineDetailViewModel datalineDetailViewModel2 = datalineDetailViewModel;
                            final int i17 = i16;
                            ColumnKt.a(d16, null, null, null, ComposableLambdaKt.composableLambda(composer3, 1688625989, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity$body$1.1
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
                                            ComposerKt.traceEventStart(1688625989, intValue2, -1, "com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity.body.<anonymous>.<anonymous> (DatalineDetailComposeActivity.kt:62)");
                                        }
                                        QUINavBarKt.QUINavBar(QUIToken.color$default("bg_nav_secondary"), null, null, "\u8be6\u7ec6\u8d44\u6599", null, null, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity.body.1.1.1
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Unit invoke() {
                                                QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                                                QQKuiklyPlatformApi.Companion.closePage$default();
                                                return Unit.INSTANCE;
                                            }
                                        }, null, false, 0.0f, composer5, 806882312, 438);
                                        com.tencent.ntcompose.core.i h16 = ComposeLayoutPropUpdaterKt.h(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null);
                                        final DatalineDetailComposeActivity datalineDetailComposeActivity3 = DatalineDetailComposeActivity.this;
                                        final DatalineDetailViewModel datalineDetailViewModel3 = datalineDetailViewModel2;
                                        final int i18 = i17;
                                        LazyColumnKt.a(h16, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, ComposableLambdaKt.composableLambda(composer5, 739564202, true, new Function3<com.tencent.ntcompose.foundation.lazy.layout.a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity.body.1.1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(com.tencent.ntcompose.foundation.lazy.layout.a aVar, Composer composer6, Integer num3) {
                                                Composer composer7 = composer6;
                                                int intValue3 = num3.intValue();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(739564202, intValue3, -1, "com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity.body.<anonymous>.<anonymous>.<anonymous> (DatalineDetailComposeActivity.kt:69)");
                                                }
                                                DatalineDetailComposeActivity.access$logo(DatalineDetailComposeActivity.this, datalineDetailViewModel3, composer7, ((i18 << 3) & 112) | 8);
                                                DatalineDetailComposeActivity.access$functionProduceView(DatalineDetailComposeActivity.this, datalineDetailViewModel3, composer7, ((i18 << 3) & 112) | 8);
                                                DatalineDetailComposeActivity.access$setTopView(DatalineDetailComposeActivity.this, datalineDetailViewModel3, composer7, ((i18 << 3) & 112) | 8);
                                                DatalineDetailComposeActivity.access$noWifiRecvFileView(DatalineDetailComposeActivity.this, datalineDetailViewModel3, composer7, ((i18 << 3) & 112) | 8);
                                                DatalineDetailComposeActivity.access$pcOnlineMentionView(DatalineDetailComposeActivity.this, datalineDetailViewModel3, composer7, ((i18 << 3) & 112) | 8);
                                                DatalineDetailComposeActivity.access$queryDownloadFileView(DatalineDetailComposeActivity.this, datalineDetailViewModel3, composer7, ((i18 << 3) & 112) | 8);
                                                DatalineDetailComposeActivity.access$addShortCutView(DatalineDetailComposeActivity.this, datalineDetailViewModel3, composer7, ((i18 << 3) & 112) | 8);
                                                DatalineDetailComposeActivity.access$clearMsgView(DatalineDetailComposeActivity.this, datalineDetailViewModel3, composer7, ((i18 << 3) & 112) | 8);
                                                DatalineDetailComposeActivity.access$managerDeviceView(DatalineDetailComposeActivity.this, datalineDetailViewModel3, composer7, ((i18 << 3) & 112) | 8);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), composer5, 8, 0, MsgConstant.KRMFILETHUMBSIZE384, 4194302);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }), composer3, 24584, 14);
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
            } else {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity$body$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                DatalineDetailComposeActivity.access$body(DatalineDetailComposeActivity.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$functionProduceView(final DatalineDetailComposeActivity datalineDetailComposeActivity, final DatalineDetailViewModel datalineDetailViewModel, Composer composer, final int i3) {
        datalineDetailComposeActivity.getClass();
        Composer startRestartGroup = composer.startRestartGroup(-1534189554);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1534189554, i3, -1, "com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity.functionProduceView (DatalineDetailComposeActivity.kt:102)");
        }
        i.Companion companion = com.tencent.ntcompose.core.i.INSTANCE;
        SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 10), startRestartGroup, 8, 0);
        com.tencent.ntcompose.core.i j3 = ComposeLayoutPropUpdaterKt.j(ComposeLayoutPropUpdaterKt.q(companion, 16), 0.0f, 1, null);
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u529f\u80fd\u4ecb\u7ecd ");
        m3.append(datalineDetailViewModel.introduce.getValue());
        RowKt.a(ModifiersKt.d(ModifiersKt.a(j3, m3.toString()), QUIToken.color$default("fill_light_secondary")), null, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 772608044, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity$functionProduceView$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(n nVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(772608044, intValue, -1, "com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity.functionProduceView.<anonymous> (DatalineDetailComposeActivity.kt:109)");
                    }
                    float f16 = 15;
                    h color$default = QUIToken.color$default("text_secondary");
                    Float valueOf = Float.valueOf(f16);
                    Boolean bool = Boolean.TRUE;
                    TextKt.a("\u529f\u80fd\u4ecb\u7ecd", null, null, color$default, valueOf, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, bool, null, null, false, composer3, 28678, 0, 3072, 125829094);
                    i.Companion companion2 = com.tencent.ntcompose.core.i.INSTANCE;
                    SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion2, f16), composer3, 8, 0);
                    TextKt.a(DatalineDetailViewModel.this.introduce.getValue(), ComposeLayoutPropUpdaterKt.j(companion2, 0.0f, 1, null), null, QUIToken.color$default("text_primary"), Float.valueOf(f16), null, null, null, null, null, null, null, null, Float.valueOf(4), null, null, null, null, null, null, null, null, null, bool, null, null, false, composer3, 28736, 3072, 3072, 125820900);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 196616, 30);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity$functionProduceView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                DatalineDetailComposeActivity.access$functionProduceView(DatalineDetailComposeActivity.this, datalineDetailViewModel, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$logo(final DatalineDetailComposeActivity datalineDetailComposeActivity, final DatalineDetailViewModel datalineDetailViewModel, Composer composer, final int i3) {
        datalineDetailComposeActivity.getClass();
        Composer startRestartGroup = composer.startRestartGroup(148097268);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(148097268, i3, -1, "com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity.logo (DatalineDetailComposeActivity.kt:85)");
        }
        RowKt.a(ModifiersKt.a(ComposeLayoutPropUpdaterKt.q(com.tencent.ntcompose.core.i.INSTANCE, 16), datalineDetailViewModel.deviceName.getValue()), null, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 230842518, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity$logo$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(n nVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(230842518, intValue, -1, "com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity.logo.<anonymous> (DatalineDetailComposeActivity.kt:86)");
                    }
                    String value = DatalineDetailViewModel.this.deviceImg.getValue();
                    i.Companion companion = com.tencent.ntcompose.core.i.INSTANCE;
                    ImageKt.a(value, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion, 75), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer3, 262144, 0, 0, 2097118);
                    SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion, 20), composer3, 8, 0);
                    TextKt.a(DatalineDetailViewModel.this.deviceName.getValue(), null, null, QUIToken.color$default("text_primary"), Float.valueOf(18), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Boolean.TRUE, null, null, false, composer3, 28672, 0, 3072, 125829094);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 196616, 30);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity$logo$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                DatalineDetailComposeActivity.access$logo(DatalineDetailComposeActivity.this, datalineDetailViewModel, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$noWifiRecvFileView(final DatalineDetailComposeActivity datalineDetailComposeActivity, final DatalineDetailViewModel datalineDetailViewModel, Composer composer, final int i3) {
        datalineDetailComposeActivity.getClass();
        Composer startRestartGroup = composer.startRestartGroup(704462082);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(704462082, i3, -1, "com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity.noWifiRecvFileView (DatalineDetailComposeActivity.kt:141)");
        }
        SpacerKt.a(ComposeLayoutPropUpdaterKt.k(com.tencent.ntcompose.core.i.INSTANCE, 16), startRestartGroup, 8, 0);
        QUIListSingleLineSwitchViewKt.QUIListSingleLineSwitchView(null, null, null, "\u975eWiFi\u81ea\u52a8\u63a5\u6536\u6587\u4ef6", null, datalineDetailViewModel.noWifiAutoRecvFile.getValue().booleanValue(), new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity$noWifiRecvFileView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Boolean bool) {
                DatalineDetailViewModel.this.sendIntent$qecommerce_biz_release(new DatalineDetailUserIntent.CheckNoWifiAutoRecvFile(bool.booleanValue()));
                return Unit.INSTANCE;
            }
        }, startRestartGroup, 3072, 23);
        QUIListSingleLineFooterViewKt.QUIListSingleLineFooterDescView("\u5f00\u542f\u540e\uff0c\u4f1a\u5728\u975eWiFi\u7f51\u7edc\u73af\u5883\u65f6\u4e5f\u81ea\u52a8\u4e0b\u8f7d\u6587\u4ef6\uff0c\u5c06\u53ef\u80fd\u4ea7\u751f\u7f51\u7edc\u6d41\u91cf\u3002", startRestartGroup, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity$noWifiRecvFileView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                DatalineDetailComposeActivity.access$noWifiRecvFileView(DatalineDetailComposeActivity.this, datalineDetailViewModel, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$pcOnlineMentionView(final DatalineDetailComposeActivity datalineDetailComposeActivity, final DatalineDetailViewModel datalineDetailViewModel, Composer composer, final int i3) {
        datalineDetailComposeActivity.getClass();
        Composer startRestartGroup = composer.startRestartGroup(-1362960494);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1362960494, i3, -1, "com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity.pcOnlineMentionView (DatalineDetailComposeActivity.kt:154)");
        }
        SpacerKt.a(ComposeLayoutPropUpdaterKt.k(com.tencent.ntcompose.core.i.INSTANCE, 16), startRestartGroup, 8, 0);
        QUIListSingleLineSwitchViewKt.QUIListSingleLineSwitchView(null, null, null, datalineDetailViewModel.pcOnlineSwitchText.getValue(), null, datalineDetailViewModel.pcQQMentionChecked.getValue().booleanValue(), new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity$pcOnlineMentionView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Boolean bool) {
                DatalineDetailViewModel.this.sendIntent$qecommerce_biz_release(new DatalineDetailUserIntent.CheckPCQQOnlineMention(bool.booleanValue()));
                return Unit.INSTANCE;
            }
        }, startRestartGroup, 0, 23);
        QUIListSingleLineFooterViewKt.QUIListSingleLineFooterDescView(datalineDetailViewModel.pcOnlineSwitchTextDesc.getValue(), startRestartGroup, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity$pcOnlineMentionView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                DatalineDetailComposeActivity.access$pcOnlineMentionView(DatalineDetailComposeActivity.this, datalineDetailViewModel, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$setTopView(final DatalineDetailComposeActivity datalineDetailComposeActivity, final DatalineDetailViewModel datalineDetailViewModel, Composer composer, final int i3) {
        datalineDetailComposeActivity.getClass();
        Composer startRestartGroup = composer.startRestartGroup(-453163097);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-453163097, i3, -1, "com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity.setTopView (DatalineDetailComposeActivity.kt:129)");
        }
        SpacerKt.a(ComposeLayoutPropUpdaterKt.k(com.tencent.ntcompose.core.i.INSTANCE, 16), startRestartGroup, 8, 0);
        QUIListSingleLineSwitchViewKt.QUIListSingleLineSwitchView(null, null, null, "\u8bbe\u4e3a\u7f6e\u9876", null, datalineDetailViewModel.topChecked.getValue().booleanValue(), new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity$setTopView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Boolean bool) {
                DatalineDetailViewModel.this.sendIntent$qecommerce_biz_release(new DatalineDetailUserIntent.CheckSetTop(bool.booleanValue()));
                return Unit.INSTANCE;
            }
        }, startRestartGroup, 3072, 23);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity$setTopView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                DatalineDetailComposeActivity.access$setTopView(DatalineDetailComposeActivity.this, datalineDetailViewModel, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity, com.tencent.ntcompose.activity.ComponentActivity
    public final Map<String, Module> createExternalModules() {
        registerModule("DatalineModule", new com.tencent.kuikly.core.pager.a() { // from class: com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity$createExternalModules$1
            @Override // com.tencent.kuikly.core.pager.a
            public final Module createModule() {
                return new DatalineModule();
            }
        });
        return super.createExternalModules();
    }

    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity, com.tencent.ntcompose.activity.ComponentActivity
    public final void onCreate(com.tencent.ntcompose.activity.a aVar) {
        super.onCreate(aVar);
        com.tencent.ntcompose.activity.b.c(this, null, ComposableLambdaKt.composableLambdaInstance(-981381228, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity$onCreate$1
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
                        ComposerKt.traceEventStart(-981381228, intValue, -1, "com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity.onCreate.<anonymous> (DatalineDetailComposeActivity.kt:45)");
                    }
                    DatalineDetailComposeActivity.access$body(DatalineDetailComposeActivity.this, composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), 1, null);
    }

    public static final void access$clearMsgView(final DatalineDetailComposeActivity datalineDetailComposeActivity, final DatalineDetailViewModel datalineDetailViewModel, Composer composer, final int i3) {
        datalineDetailComposeActivity.getClass();
        Composer startRestartGroup = composer.startRestartGroup(692125222);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(692125222, i3, -1, "com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity.clearMsgView (DatalineDetailComposeActivity.kt:199)");
        }
        i.Companion companion = com.tencent.ntcompose.core.i.INSTANCE;
        SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 16), startRestartGroup, 8, 0);
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        Composer.Companion companion2 = Composer.INSTANCE;
        if (rememberedValue == companion2.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue;
        startRestartGroup.startReplaceableGroup(1157296644);
        boolean changed = startRestartGroup.changed(mutableState);
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (changed || rememberedValue2 == companion2.getEmpty()) {
            rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity$clearMsgView$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(ClickParams clickParams) {
                    mutableState.setValue(Boolean.TRUE);
                    KLog.INSTANCE.d("DatalineDetailComposeActivity", "clearMsgView CLICK");
                    return Unit.INSTANCE;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        startRestartGroup.endReplaceableGroup();
        QUIListSingleLineCommonViewKt.QUIListSingleLineCommonView(ViewEventPropUpdaterKt.d(companion, false, null, (Function1) rememberedValue2, 3, null), null, null, "\u6e05\u7a7a\u6d88\u606f\u8bb0\u5f55", 0.0f, QUIToken.color$default("text_link"), null, null, null, "", null, 0.0f, startRestartGroup, 805571592, 0, 3542);
        boolean booleanValue = ((Boolean) mutableState.getValue()).booleanValue();
        QUIActionSheetItem[] qUIActionSheetItemArr = {QUIActionSheetKt.QUIActionSheetWarningTextItem("\u6e05\u7a7a\u6d88\u606f\u8bb0\u5f55", new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity$clearMsgView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                mutableState.setValue(Boolean.FALSE);
                datalineDetailViewModel.sendIntent$qecommerce_biz_release(DatalineDetailUserIntent.ClearMsgRecord.INSTANCE);
                return Unit.INSTANCE;
            }
        })};
        startRestartGroup.startReplaceableGroup(1157296644);
        boolean changed2 = startRestartGroup.changed(mutableState);
        Object rememberedValue3 = startRestartGroup.rememberedValue();
        if (changed2 || rememberedValue3 == companion2.getEmpty()) {
            rememberedValue3 = new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity$clearMsgView$3$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Boolean bool) {
                    bool.booleanValue();
                    mutableState.setValue(Boolean.FALSE);
                    return Unit.INSTANCE;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue3);
        }
        startRestartGroup.endReplaceableGroup();
        QUIActionSheetKt.QUIActionSheet(booleanValue, "\u6e05\u7a7a\u6d88\u606f\u8bb0\u5f55\u540e\uff0c\u6587\u4ef6\u4f9d\u7136\u4fdd\u7559\uff0c\u786e\u5b9a\u8981\u6e05\u7a7a\u6d88\u606f\u8bb0\u5f55\uff1f", qUIActionSheetItemArr, null, (Function1) rememberedValue3, null, startRestartGroup, PlayerResources.ViewId.GET_MORE_TOGGLE_AREA, 40);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity$clearMsgView$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                DatalineDetailComposeActivity.access$clearMsgView(DatalineDetailComposeActivity.this, datalineDetailViewModel, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$addShortCutView(final DatalineDetailComposeActivity datalineDetailComposeActivity, final DatalineDetailViewModel datalineDetailViewModel, Composer composer, final int i3) {
        datalineDetailComposeActivity.getClass();
        Composer startRestartGroup = composer.startRestartGroup(942005679);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(942005679, i3, -1, "com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity.addShortCutView (DatalineDetailComposeActivity.kt:181)");
        }
        if (((com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d())).k()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                return;
            }
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity$addShortCutView$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    DatalineDetailComposeActivity.access$addShortCutView(DatalineDetailComposeActivity.this, datalineDetailViewModel, composer2, i3 | 1);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        i.Companion companion = com.tencent.ntcompose.core.i.INSTANCE;
        SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 16), startRestartGroup, 8, 0);
        QUIListSingleLineCommonViewKt.QUIListSingleLineCommonView(ViewEventPropUpdaterKt.d(companion, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity$addShortCutView$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                DatalineDetailViewModel.this.sendIntent$qecommerce_biz_release(DatalineDetailUserIntent.AddDeskTopShortCut.INSTANCE);
                return Unit.INSTANCE;
            }
        }, 3, null), null, null, "\u6dfb\u52a0\u684c\u9762\u5feb\u6377\u65b9\u5f0f", 0.0f, QUIToken.color$default("text_link"), null, null, null, "", null, 0.0f, startRestartGroup, 805571592, 0, 3542);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 == null) {
            return;
        }
        endRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity$addShortCutView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                DatalineDetailComposeActivity.access$addShortCutView(DatalineDetailComposeActivity.this, datalineDetailViewModel, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$managerDeviceView(final DatalineDetailComposeActivity datalineDetailComposeActivity, final DatalineDetailViewModel datalineDetailViewModel, Composer composer, final int i3) {
        datalineDetailComposeActivity.getClass();
        Composer startRestartGroup = composer.startRestartGroup(-316796877);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-316796877, i3, -1, "com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity.managerDeviceView (DatalineDetailComposeActivity.kt:227)");
        }
        if (!datalineDetailViewModel.isDeviceOnline.getValue().booleanValue()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                return;
            }
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity$managerDeviceView$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    DatalineDetailComposeActivity.access$managerDeviceView(DatalineDetailComposeActivity.this, datalineDetailViewModel, composer2, i3 | 1);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u7ba1\u7406");
        m3.append(datalineDetailViewModel.deviceName.getValue());
        String sb5 = m3.toString();
        i.Companion companion = com.tencent.ntcompose.core.i.INSTANCE;
        SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 16), startRestartGroup, 8, 0);
        QUIListSingleLineCommonViewKt.QUIListSingleLineCommonView(ViewEventPropUpdaterKt.d(companion, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity$managerDeviceView$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                DatalineDetailViewModel.this.sendIntent$qecommerce_biz_release(DatalineDetailUserIntent.ManagerDevice.INSTANCE);
                return Unit.INSTANCE;
            }
        }, 3, null), null, null, sb5, 0.0f, null, null, "\u5728\u7ebf", null, null, null, 0.0f, startRestartGroup, 12582920, 0, 3958);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 == null) {
            return;
        }
        endRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity$managerDeviceView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                DatalineDetailComposeActivity.access$managerDeviceView(DatalineDetailComposeActivity.this, datalineDetailViewModel, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$queryDownloadFileView(final DatalineDetailComposeActivity datalineDetailComposeActivity, final DatalineDetailViewModel datalineDetailViewModel, Composer composer, final int i3) {
        String str;
        datalineDetailComposeActivity.getClass();
        Composer startRestartGroup = composer.startRestartGroup(-1097990934);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1097990934, i3, -1, "com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity.queryDownloadFileView (DatalineDetailComposeActivity.kt:166)");
        }
        if (((com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d())).k()) {
            str = "\u67e5\u770b\u672c\u5730\u6587\u4ef6";
        } else {
            str = "\u67e5\u770b\u5df2\u4e0b\u8f7d\u6587\u4ef6";
        }
        i.Companion companion = com.tencent.ntcompose.core.i.INSTANCE;
        SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 16), startRestartGroup, 8, 0);
        QUIListSingleLineCommonViewKt.QUIListSingleLineCommonView(ViewEventPropUpdaterKt.d(companion, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity$queryDownloadFileView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                DatalineDetailViewModel.this.sendIntent$qecommerce_biz_release(DatalineDetailUserIntent.QueryDownloadedFiles.INSTANCE);
                return Unit.INSTANCE;
            }
        }, 3, null), null, null, str, 0.0f, null, null, null, null, null, null, 0.0f, startRestartGroup, 8, 0, 4086);
        if (((com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d())).k()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                return;
            }
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity$queryDownloadFileView$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    DatalineDetailComposeActivity.access$queryDownloadFileView(DatalineDetailComposeActivity.this, datalineDetailViewModel, composer2, i3 | 1);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        QUIListSingleLineFooterViewKt.QUIListSingleLineFooterDescView(datalineDetailViewModel.recvFilePath.getValue(), startRestartGroup, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 == null) {
            return;
        }
        endRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity$queryDownloadFileView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                DatalineDetailComposeActivity.access$queryDownloadFileView(DatalineDetailComposeActivity.this, datalineDetailViewModel, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
