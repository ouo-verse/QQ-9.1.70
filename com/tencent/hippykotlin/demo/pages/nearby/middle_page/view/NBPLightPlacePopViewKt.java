package com.tencent.hippykotlin.demo.pages.nearby.middle_page.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQUIModule;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendOIDBRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.DeActivatePoi;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPPOIRepo;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.TextViewExtKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.middle_page.view_model.NBPMiddlePageViewModel;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.d;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.g;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.base.y;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.ntcompose.animation.AnimateAsStateKt;
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
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ButtonKt;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.KuiklyKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* loaded from: classes31.dex */
public final class NBPLightPlacePopViewKt {
    public static final void NBPLightPlacePopView(final NBPMiddlePageViewModel nBPMiddlePageViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-1432488747);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1432488747, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPLightPlacePopView (NBPLightPlacePopView.kt:54)");
        }
        BoxKt.a(ViewEventPropUpdaterKt.g(ModifiersKt.T(ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.0f, 1, null), 5), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPLightPlacePopViewKt$NBPLightPlacePopView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                NBPMiddlePageViewModel.this.fadeOutAnimation.setValue(Boolean.TRUE);
                return Unit.INSTANCE;
            }
        }), Alignment.TopCenter, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1807955697, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPLightPlacePopViewKt$NBPLightPlacePopView$2
            {
                super(3);
            }

            public static final float invoke$lambda$0(State<Float> state) {
                return state.getValue().floatValue();
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                int i16;
                b bVar2 = bVar;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 14) == 0) {
                    i16 = (composer3.changed(bVar2) ? 4 : 2) | intValue;
                } else {
                    i16 = intValue;
                }
                if ((i16 & 91) == 18 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1807955697, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPLightPlacePopView.<anonymous> (NBPLightPlacePopView.kt:63)");
                    }
                    final State<Float> c16 = AnimateAsStateKt.c(!NBPMiddlePageViewModel.this.fadeOutAnimation.getValue().booleanValue() ? 0.0f : 1.0f, com.tencent.ntcompose.animation.b.d(250, 0, com.tencent.ntcompose.animation.i.d(), null, 10, null), null, composer3, 0, 4);
                    i.Companion companion = i.INSTANCE;
                    BoxKt.a(ViewEventPropUpdaterKt.d(ModifiersKt.d(ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), 0.0f, 1, null), new h(0L, invoke$lambda$0(c16) / 2)), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPLightPlacePopViewKt$NBPLightPlacePopView$2.1
                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                            return Unit.INSTANCE;
                        }
                    }, 3, null), null, null, null, composer3, 8, 14);
                    i a16 = bVar2.a(ModifiersKt.b(ModifiersKt.j(ModifiersKt.d(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 296.0f), 361.0f), 0.0f, 200.0f, 0.0f, 0.0f, 13, null), QUIToken.color$default("bg_top_light")), 16.0f), c16.getValue().floatValue()), Alignment.TopCenter);
                    Alignment.Horizontal b16 = Alignment.INSTANCE.b();
                    a.k h16 = a.f339245a.h();
                    final NBPMiddlePageViewModel nBPMiddlePageViewModel2 = NBPMiddlePageViewModel.this;
                    ColumnKt.a(a16, h16, b16, null, ComposableLambdaKt.composableLambda(composer3, -1735393608, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPLightPlacePopViewKt$NBPLightPlacePopView$2.2
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
                                    ComposerKt.traceEventStart(-1735393608, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPLightPlacePopView.<anonymous>.<anonymous> (NBPLightPlacePopView.kt:85)");
                                }
                                i.Companion companion2 = i.INSTANCE;
                                i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion2, 296.0f), 193.6f);
                                Alignment alignment = Alignment.Center;
                                final NBPMiddlePageViewModel nBPMiddlePageViewModel3 = NBPMiddlePageViewModel.this;
                                BoxKt.a(k3, alignment, null, ComposableLambdaKt.composableLambda(composer5, -687180686, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPLightPlacePopViewKt.NBPLightPlacePopView.2.2.1
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(b bVar3, Composer composer6, Integer num3) {
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-687180686, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPLightPlacePopView.<anonymous>.<anonymous>.<anonymous> (NBPLightPlacePopView.kt:90)");
                                            }
                                            ImageKt.a("https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_YBAtkRVteco.png", null, null, null, null, ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), null, com.tencent.ntcompose.material.h.INSTANCE.a(), null, null, null, null, null, null, null, null, null, null, null, null, null, composer7, 12845062, 0, 0, 2096990);
                                            final NBPMiddlePageViewModel nBPMiddlePageViewModel4 = NBPMiddlePageViewModel.this;
                                            KuiklyKt.a(null, null, new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPLightPlacePopViewKt.NBPLightPlacePopView.2.2.1.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                                                    ViewContainer<?, ?> viewContainer2 = viewContainer;
                                                    viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPLightPlacePopViewKt.NBPLightPlacePopView.2.2.1.1.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(m mVar) {
                                                            m mVar2 = mVar;
                                                            mVar2.size(160.0f, 61.0f);
                                                            mVar2.flexDirectionColumn();
                                                            mVar2.alignItemsCenter();
                                                            mVar2.justifyContentFlexEnd();
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final NBPMiddlePageViewModel nBPMiddlePageViewModel5 = NBPMiddlePageViewModel.this;
                                                    w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPLightPlacePopViewKt.NBPLightPlacePopView.2.2.1.1.2
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(v vVar) {
                                                            v vVar2 = vVar;
                                                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPLightPlacePopViewKt.NBPLightPlacePopView.2.2.1.1.2.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(t tVar) {
                                                                    t tVar2 = tVar;
                                                                    tVar2.size(160.0f, 61.0f);
                                                                    tVar2.flexDirectionColumn();
                                                                    tVar2.alignItemsCenter();
                                                                    tVar2.justifyContentFlexEnd();
                                                                    NBPMainKtxKt.boxShadowWithBlackSet$default(tVar2, new g(0.0f, 8.0f, 10.0f, h.INSTANCE.a(0.16f)));
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final NBPMiddlePageViewModel nBPMiddlePageViewModel6 = NBPMiddlePageViewModel.this;
                                                            w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPLightPlacePopViewKt.NBPLightPlacePopView.2.2.1.1.2.2
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(v vVar3) {
                                                                    v vVar4 = vVar3;
                                                                    vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPLightPlacePopViewKt.NBPLightPlacePopView.2.2.1.1.2.2.1
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(t tVar) {
                                                                            t tVar2 = tVar;
                                                                            tVar2.size(160.0f, 56.0f);
                                                                            tVar2.borderRadius(6.0f);
                                                                            tVar2.mo113backgroundColor(h.INSTANCE.m());
                                                                            tVar2.flexDirectionRow();
                                                                            tVar2.overflow(true);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    final NBPMiddlePageViewModel nBPMiddlePageViewModel7 = NBPMiddlePageViewModel.this;
                                                                    ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPLightPlacePopViewKt.NBPLightPlacePopView.2.2.1.1.2.2.2
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ImageView imageView) {
                                                                            final NBPMiddlePageViewModel nBPMiddlePageViewModel8 = NBPMiddlePageViewModel.this;
                                                                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPLightPlacePopViewKt.NBPLightPlacePopView.2.2.1.1.2.2.2.1
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(af afVar) {
                                                                                    r35.a aVar;
                                                                                    af afVar2 = afVar;
                                                                                    afVar2.size(56.0f);
                                                                                    x25.m poiData = NBPMiddlePageViewModel.this.getPoiData();
                                                                                    if (poiData != null && (aVar = poiData.J) != null) {
                                                                                    }
                                                                                    afVar2.p();
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    final NBPMiddlePageViewModel nBPMiddlePageViewModel8 = NBPMiddlePageViewModel.this;
                                                                    w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPLightPlacePopViewKt.NBPLightPlacePopView.2.2.1.1.2.2.3
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(v vVar5) {
                                                                            v vVar6 = vVar5;
                                                                            vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPLightPlacePopViewKt.NBPLightPlacePopView.2.2.1.1.2.2.3.1
                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(t tVar) {
                                                                                    t tVar2 = tVar;
                                                                                    tVar2.flexDirectionColumn();
                                                                                    tVar2.paddingTop(6.0f);
                                                                                    tVar2.paddingLeft(8.0f);
                                                                                    tVar2.paddingBottom(6.0f);
                                                                                    tVar2.justifyContentCenter();
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            final NBPMiddlePageViewModel nBPMiddlePageViewModel9 = NBPMiddlePageViewModel.this;
                                                                            cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPLightPlacePopViewKt.NBPLightPlacePopView.2.2.1.1.2.2.3.2
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(TextView textView) {
                                                                                    final NBPMiddlePageViewModel nBPMiddlePageViewModel10 = NBPMiddlePageViewModel.this;
                                                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPLightPlacePopViewKt.NBPLightPlacePopView.2.2.1.1.2.2.3.2.1
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Unit invoke(ce ceVar) {
                                                                                            String str;
                                                                                            p35.ah ahVar;
                                                                                            ce ceVar2 = ceVar;
                                                                                            ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                                            ceVar2.lineHeight(15.0f);
                                                                                            ceVar2.color(new h(4279901214L));
                                                                                            ceVar2.fontWeight400();
                                                                                            x25.m poiData = NBPMiddlePageViewModel.this.getPoiData();
                                                                                            if (poiData == null || (ahVar = poiData.f447113d) == null || (str = ahVar.Q) == null) {
                                                                                                str = "";
                                                                                            }
                                                                                            TextViewExtKt.textWithLineHeightFix(ceVar2, str);
                                                                                            ceVar2.lines(1);
                                                                                            ceVar2.mo153width(88.0f);
                                                                                            ceVar2.textOverFlowTail();
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    });
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            final NBPMiddlePageViewModel nBPMiddlePageViewModel10 = NBPMiddlePageViewModel.this;
                                                                            cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPLightPlacePopViewKt.NBPLightPlacePopView.2.2.1.1.2.2.3.3
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(TextView textView) {
                                                                                    final NBPMiddlePageViewModel nBPMiddlePageViewModel11 = NBPMiddlePageViewModel.this;
                                                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPLightPlacePopViewKt.NBPLightPlacePopView.2.2.1.1.2.2.3.3.1
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Unit invoke(ce ceVar) {
                                                                                            String str;
                                                                                            ce ceVar2 = ceVar;
                                                                                            ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
                                                                                            ceVar2.lineHeight(12.0f);
                                                                                            ceVar2.fontWeight400();
                                                                                            ceVar2.lines(1);
                                                                                            ceVar2.color(new h(4287664276L));
                                                                                            x25.m poiData = NBPMiddlePageViewModel.this.getPoiData();
                                                                                            if (poiData == null || (str = poiData.G) == null) {
                                                                                                str = "";
                                                                                            }
                                                                                            TextViewExtKt.textWithLineHeightFix(ceVar2, str);
                                                                                            ceVar2.marginTop(2.0f);
                                                                                            ceVar2.mo153width(88.0f);
                                                                                            ceVar2.textOverFlowTail();
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    });
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPLightPlacePopViewKt.NBPLightPlacePopView.2.2.1.1.2.3
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(v vVar3) {
                                                                    vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPLightPlacePopViewKt.NBPLightPlacePopView.2.2.1.1.2.3.1
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(t tVar) {
                                                                            t tVar2 = tVar;
                                                                            tVar2.size(10.0f);
                                                                            tVar2.mo113backgroundColor(h.INSTANCE.m());
                                                                            d.a.a(tVar2, new com.tencent.kuikly.core.base.t(45.0f, 0.0f, 0.0f, 6, null), null, new y(0.0f, -0.5f, 0.0f, 0.0f, 12, null), null, null, 26, null);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            }, composer7, 0, 3);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 3128, 4);
                                i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion2, 296.0f), 168.0f), 20.0f, 0.0f, 20.0f, 9.0f, 2, null);
                                Alignment.Horizontal b17 = Alignment.INSTANCE.b();
                                final NBPMiddlePageViewModel nBPMiddlePageViewModel4 = NBPMiddlePageViewModel.this;
                                final State<Float> state = c16;
                                ColumnKt.a(n3, null, b17, null, ComposableLambdaKt.composableLambda(composer5, -1948130847, true, new Function3<com.tencent.ntcompose.foundation.layout.d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPLightPlacePopViewKt.NBPLightPlacePopView.2.2.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(com.tencent.ntcompose.foundation.layout.d dVar2, Composer composer6, Integer num3) {
                                        String str;
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1948130847, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPLightPlacePopView.<anonymous>.<anonymous>.<anonymous> (NBPLightPlacePopView.kt:192)");
                                            }
                                            i.Companion companion3 = i.INSTANCE;
                                            i n16 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(companion3, 0.0f, 1, null)), 0.0f, 14.0f, 0.0f, 0.0f, 13, null);
                                            Alignment alignment2 = Alignment.Center;
                                            final NBPMiddlePageViewModel nBPMiddlePageViewModel5 = NBPMiddlePageViewModel.this;
                                            BoxKt.a(n16, alignment2, null, ComposableLambdaKt.composableLambda(composer7, -786379109, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPLightPlacePopViewKt.NBPLightPlacePopView.2.2.2.1
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(b bVar3, Composer composer8, Integer num4) {
                                                    String str2;
                                                    Composer composer9 = composer8;
                                                    int intValue4 = num4.intValue();
                                                    if ((intValue4 & 81) == 16 && composer9.getSkipping()) {
                                                        composer9.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-786379109, intValue4, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPLightPlacePopView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NBPLightPlacePopView.kt:197)");
                                                        }
                                                        if (NBPMiddlePageViewModel.this.hasLightThisPlace.getValue().booleanValue()) {
                                                            str2 = "\u5df2\u70b9\u4eae";
                                                        } else {
                                                            str2 = "\u4f60\u4e0d\u5728\u6b64\u5730\u70b9\u9644\u8fd1\u54e6";
                                                        }
                                                        TextKt.a(str2, null, null, QUIToken.color$default("text_primary"), Float.valueOf(17.0f), null, c.INSTANCE.f(), null, null, null, null, null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer9, 1601536, 100663296, 0, 133955494);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer7, 3128, 4);
                                            i n17 = ComposeLayoutPropUpdaterKt.n(companion3, 0.0f, 10.0f, 0.0f, 0.0f, 13, null);
                                            if (NBPMiddlePageViewModel.this.hasLightThisPlace.getValue().booleanValue()) {
                                                str = OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u4f60\u4e8e"), ((com.tencent.kuikly.core.module.b) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRCalendarModule")).a(NBPMiddlePageViewModel.this.lightedTimestamps, "yyyy\u5e74MM\u6708dd\u65e5"), "\u70b9\u4eae\u8be5\u5730\u70b9\u3002");
                                            } else {
                                                str = "\u5728\u5730\u70b9\u9644\u8fd1\u624d\u80fd\u70b9\u4eae\u3001\u8868\u6001\u548c\u53d1\u5e03\u3002";
                                            }
                                            TextKt.a(str, n17, null, QUIToken.color$default("text_primary"), Float.valueOf(14.0f), null, c.INSTANCE.e(), null, null, null, null, null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer7, 1601600, 100663296, 0, 133955492);
                                            i b18 = ModifiersKt.b(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion3, 236.0f), 48.0f), 0.0f, 24.0f, 0.0f, 0.0f, 13, null), state.getValue().floatValue());
                                            a.e e16 = a.f339245a.e();
                                            final NBPMiddlePageViewModel nBPMiddlePageViewModel6 = NBPMiddlePageViewModel.this;
                                            RowKt.a(b18, e16, null, null, null, ComposableLambdaKt.composableLambda(composer7, 279572479, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPLightPlacePopViewKt.NBPLightPlacePopView.2.2.2.2
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(n nVar, Composer composer8, Integer num4) {
                                                    int i17;
                                                    n nVar2 = nVar;
                                                    Composer composer9 = composer8;
                                                    int intValue4 = num4.intValue();
                                                    if ((intValue4 & 14) == 0) {
                                                        i17 = (composer9.changed(nVar2) ? 4 : 2) | intValue4;
                                                    } else {
                                                        i17 = intValue4;
                                                    }
                                                    if ((i17 & 91) == 18 && composer9.getSkipping()) {
                                                        composer9.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(279572479, intValue4, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPLightPlacePopView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NBPLightPlacePopView.kt:225)");
                                                        }
                                                        if (NBPMiddlePageViewModel.this.hasLightThisPlace.getValue().booleanValue()) {
                                                            composer9.startReplaceableGroup(250808595);
                                                            final NBPMiddlePageViewModel nBPMiddlePageViewModel7 = NBPMiddlePageViewModel.this;
                                                            Function1<ClickParams, Unit> function1 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPLightPlacePopViewKt.NBPLightPlacePopView.2.2.2.2.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ClickParams clickParams) {
                                                                    MutableState<Boolean> mutableState = NBPMiddlePageViewModel.this.showPopView;
                                                                    Boolean bool = Boolean.FALSE;
                                                                    mutableState.setValue(bool);
                                                                    NBPMiddlePageViewModel.this.fadeOutAnimation.setValue(bool);
                                                                    QQUIModule qQUIModule = (QQUIModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("QQUIModule");
                                                                    final NBPMiddlePageViewModel nBPMiddlePageViewModel8 = NBPMiddlePageViewModel.this;
                                                                    qQUIModule.openAlertDialog("", "\u786e\u8ba4\u53d6\u6d88\u8be5\u70b9\u4eae\u5417\uff1f", "\u53d6\u6d88", "\u786e\u5b9a", "", false, new Function2<Boolean, Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPLightPlacePopViewKt.NBPLightPlacePopView.2.2.2.2.1.1
                                                                        {
                                                                            super(2);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function2
                                                                        public final Unit invoke(Boolean bool2, Boolean bool3) {
                                                                            Unit unit;
                                                                            p35.ah ahVar;
                                                                            boolean booleanValue = bool2.booleanValue();
                                                                            bool3.booleanValue();
                                                                            if (booleanValue) {
                                                                                final NBPMiddlePageViewModel nBPMiddlePageViewModel9 = NBPMiddlePageViewModel.this;
                                                                                x25.m poiData = nBPMiddlePageViewModel9.getPoiData();
                                                                                if (poiData == null || (ahVar = poiData.f447113d) == null) {
                                                                                    unit = null;
                                                                                } else {
                                                                                    NBPPOIRepo repo = nBPMiddlePageViewModel9.getRepo();
                                                                                    final Function2<Boolean, String, Unit> function2 = new Function2<Boolean, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view_model.NBPMiddlePageViewModel$cancelLightPoi$1$1
                                                                                        {
                                                                                            super(2);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function2
                                                                                        public final Unit invoke(Boolean bool4, String str2) {
                                                                                            boolean booleanValue2 = bool4.booleanValue();
                                                                                            KLog.INSTANCE.i("NBPMiddlePageViewModel", "deactivatePoi success\uff1a " + booleanValue2 + ", msg " + str2);
                                                                                            if (booleanValue2) {
                                                                                                NBPMiddlePageViewModel.this.hasLightThisPlace.setValue(Boolean.FALSE);
                                                                                                NBPMiddlePageViewModel.this.setActiveUserCount(r5.getActiveUserCount() - 1);
                                                                                                NBPMiddlePageViewModel.this.hasCanceledToday = true;
                                                                                            } else {
                                                                                                Utils.INSTANCE.currentBridgeModule().qToast("\u53d6\u6d88\u70b9\u4eae\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", QToastMode.Warning);
                                                                                            }
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    };
                                                                                    repo.getClass();
                                                                                    KLog kLog = KLog.INSTANCE;
                                                                                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("deactivatePoi: ");
                                                                                    m3.append(ahVar.Q);
                                                                                    m3.append('[');
                                                                                    m3.append(ahVar.R);
                                                                                    m3.append(']');
                                                                                    kLog.i("NBPPOIRepo", m3.toString());
                                                                                    DeActivatePoi deActivatePoi = new DeActivatePoi(ahVar);
                                                                                    QQKuiklyPlatformApi.Companion.sendOIDBRequest(deActivatePoi, false, new NearbyApi$sendOIDBRequest$1(new APICallTechReporter(1, deActivatePoi.getCmd()), new Function1<OIDBResponse<x25.d>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPPOIRepo$deactivatePoi$1
                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                        /* JADX WARN: Multi-variable type inference failed */
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Unit invoke(OIDBResponse<x25.d> oIDBResponse) {
                                                                                            OIDBResponse<x25.d> oIDBResponse2 = oIDBResponse;
                                                                                            if (oIDBResponse2.success) {
                                                                                                ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("deactivatePoi success, trace="), oIDBResponse2.code, KLog.INSTANCE, "NBPPOIRepo");
                                                                                            } else {
                                                                                                KLog kLog2 = KLog.INSTANCE;
                                                                                                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("deactivatePoi failure, code:");
                                                                                                m16.append(oIDBResponse2.code);
                                                                                                m16.append(", message:");
                                                                                                m16.append(oIDBResponse2.f114186msg);
                                                                                                m16.append('}');
                                                                                                kLog2.e("NBPPOIRepo", m16.toString());
                                                                                            }
                                                                                            function2.invoke(Boolean.valueOf(oIDBResponse2.success), oIDBResponse2.f114186msg);
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    }));
                                                                                    unit = Unit.INSTANCE;
                                                                                }
                                                                                if (unit == null) {
                                                                                    KLog.INSTANCE.e("NBPMiddlePageViewModel", "poiInfo is null");
                                                                                }
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    return Unit.INSTANCE;
                                                                }
                                                            };
                                                            i.Companion companion4 = i.INSTANCE;
                                                            ButtonKt.a(null, function1, ModifiersKt.g(ModifiersKt.j(ComposeLayoutPropUpdaterKt.k(nVar2.a(ComposeLayoutPropUpdaterKt.B(companion4), 1.0f), 48.0f), 12.0f), new e(1.0f, BorderStyle.SOLID, QUIToken.color$default("button_border_secondary_default"))), null, ComposableSingletons$NBPLightPlacePopViewKt.f49lambda1, composer9, 25088, 9);
                                                            final NBPMiddlePageViewModel nBPMiddlePageViewModel8 = NBPMiddlePageViewModel.this;
                                                            ButtonKt.a(null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPLightPlacePopViewKt.NBPLightPlacePopView.2.2.2.2.2
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ClickParams clickParams) {
                                                                    NBPMiddlePageViewModel.this.jumpToPublishPage();
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }, ModifiersKt.j(ModifiersKt.c(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(nVar2.a(ComposeLayoutPropUpdaterKt.B(companion4), 1.0f), 48.0f), 8.0f, 0.0f, 0.0f, 0.0f, 14, null), QUIToken.color$default("brand_standard")), 12.0f), null, ComposableSingletons$NBPLightPlacePopViewKt.f50lambda2, composer9, 25088, 9);
                                                            composer9.endReplaceableGroup();
                                                        } else {
                                                            composer9.startReplaceableGroup(250810764);
                                                            final NBPMiddlePageViewModel nBPMiddlePageViewModel9 = NBPMiddlePageViewModel.this;
                                                            ButtonKt.a(null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPLightPlacePopViewKt.NBPLightPlacePopView.2.2.2.2.3
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ClickParams clickParams) {
                                                                    NBPMiddlePageViewModel.this.fadeOutAnimation.setValue(Boolean.FALSE);
                                                                    final NBPMiddlePageViewModel nBPMiddlePageViewModel10 = NBPMiddlePageViewModel.this;
                                                                    TimerKt.d(ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPLightPlacePopViewKt.NBPLightPlacePopView.2.2.2.2.3.1
                                                                        {
                                                                            super(0);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function0
                                                                        public final Unit invoke() {
                                                                            NBPMiddlePageViewModel.this.showPopView.setValue(Boolean.FALSE);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }, ModifiersKt.j(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(nVar2.a(ComposeLayoutPropUpdaterKt.B(i.INSTANCE), 1.0f), 48.0f), QUIToken.color$default("brand_standard")), 12.0f), null, ComposableSingletons$NBPLightPlacePopViewKt.f51lambda3, composer9, 25088, 9);
                                                            composer9.endReplaceableGroup();
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer7, 196680, 28);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 24584, 10);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 24648, 8);
                    i b17 = ModifiersKt.b(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 100.0f), 60.0f), 0.0f, 580.0f, 0.0f, 0.0f, 13, null), c16.getValue().floatValue());
                    final NBPMiddlePageViewModel nBPMiddlePageViewModel3 = NBPMiddlePageViewModel.this;
                    BoxKt.a(ViewEventPropUpdaterKt.d(b17, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPLightPlacePopViewKt$NBPLightPlacePopView$2.3
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ClickParams clickParams) {
                            NBPMiddlePageViewModel.this.fadeOutAnimation.setValue(Boolean.FALSE);
                            final NBPMiddlePageViewModel nBPMiddlePageViewModel4 = NBPMiddlePageViewModel.this;
                            TimerKt.d(ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPLightPlacePopViewKt.NBPLightPlacePopView.2.3.1
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Unit invoke() {
                                    NBPMiddlePageViewModel.this.showPopView.setValue(Boolean.FALSE);
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    }, 3, null), Alignment.Center, null, ComposableSingletons$NBPLightPlacePopViewKt.f52lambda4, composer3, 3128, 4);
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
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPLightPlacePopViewKt$NBPLightPlacePopView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                NBPLightPlacePopViewKt.NBPLightPlacePopView(NBPMiddlePageViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
