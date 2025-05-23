package com.tencent.hippykotlin.demo.pages.nearby.mood_group.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPJumpUtil;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.NBPMoodGroupViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootControlGuideViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootEntranceViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.shoot.NBPShootPoint;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.shoot.NBPShootViewModel;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.n;
import com.tencent.kuikly.core.views.o;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.material.APNGKt;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.KuiklyKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.ntcompose.ui.platform.a;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import defpackage.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class BottomViewKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final void BottomView(final NBPMoodGroupViewModel nBPMoodGroupViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-947145857);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-947145857, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.BottomView (BottomView.kt:43)");
        }
        BoxKt.a(ModifiersKt.T(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), 3), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 711946041, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.BottomViewKt$BottomView$1
            {
                super(3);
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
                        ComposerKt.traceEventStart(711946041, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.BottomView.<anonymous> (BottomView.kt:48)");
                    }
                    float e16 = ((a) composer3.consume(CompositionLocalsKt.d())).e();
                    float f16 = ((a) composer3.consume(CompositionLocalsKt.d())).l() ? 35.0f : 0.0f;
                    i.Companion companion = i.INSTANCE;
                    Alignment alignment = Alignment.BottomStart;
                    i p16 = ComposeLayoutPropUpdaterKt.p(ModifiersKt.T(ComposeLayoutPropUpdaterKt.j(bVar2.a(companion, alignment), 0.0f, 1, null), 1), 0.0f, ((a) composer3.consume(CompositionLocalsKt.d())).l() ? 0.0f : 35.0f, 1, null);
                    final NBPMoodGroupViewModel nBPMoodGroupViewModel2 = NBPMoodGroupViewModel.this;
                    BoxKt.a(p16, null, null, ComposableLambdaKt.composableLambda(composer3, -1933331085, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.BottomViewKt$BottomView$1.1
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar3, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1933331085, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.BottomView.<anonymous>.<anonymous> (BottomView.kt:60)");
                                }
                                ShootControlGuideViewKt.ShootControlGuideView(NBPMoodGroupViewModel.this.getShootVM(), composer5, 8);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 3080, 6);
                    float f17 = -(f16 + 56.0f);
                    i o16 = ComposeLayoutPropUpdaterKt.o(ModifiersKt.c(ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(bVar2.a(companion, alignment), 56.0f), 28.0f), new h(3439329279L)), 0.16588785f * e16, f17);
                    final NBPMoodGroupViewModel nBPMoodGroupViewModel3 = NBPMoodGroupViewModel.this;
                    i l3 = ViewEventPropUpdaterKt.l(o16, new Function1<ap3.a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.BottomViewKt$BottomView$1.2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ap3.a aVar) {
                            NBPMoodGroupViewModel.this.getReportVM().dtReportElementImp("em_nearby_luck_card_calendar_en", null);
                            return Unit.INSTANCE;
                        }
                    });
                    final NBPMoodGroupViewModel nBPMoodGroupViewModel4 = NBPMoodGroupViewModel.this;
                    i d16 = ViewEventPropUpdaterKt.d(l3, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.BottomViewKt$BottomView$1.3
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ClickParams clickParams) {
                            NBPJumpUtil.jumpPrayCalendarPage$default();
                            NBPMoodGroupViewModel.this.getReportVM().dtReportElementClick("em_nearby_luck_card_calendar_en", null);
                            TimerKt.d(100, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.BottomViewKt.BottomView.1.3.1
                                @Override // kotlin.jvm.functions.Function0
                                public final Unit invoke() {
                                    QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                                    QQKuiklyPlatformApi.Companion.closePage$default();
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    }, 3, null);
                    Alignment alignment2 = Alignment.Center;
                    final NBPMoodGroupViewModel nBPMoodGroupViewModel5 = NBPMoodGroupViewModel.this;
                    BoxKt.a(d16, alignment2, null, ComposableLambdaKt.composableLambda(composer3, 143806812, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.BottomViewKt$BottomView$1.4
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar3, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(143806812, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.BottomView.<anonymous>.<anonymous> (BottomView.kt:81)");
                                }
                                if (!NBPMoodGroupViewModel.this.didReceivePrayCard.getValue().booleanValue()) {
                                    composer5.startReplaceableGroup(931008889);
                                    ImageKt.a("https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_ERLF5F_msv8.png", null, null, null, null, ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 28.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer5, 262150, 0, 0, 2097118);
                                    composer5.endReplaceableGroup();
                                } else if (!NBPMoodGroupViewModel.this.startToPlay.getValue().booleanValue()) {
                                    composer5.startReplaceableGroup(931009177);
                                    ImageKt.a("https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_MtTqUnbowUE.png", null, null, null, null, ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 28.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, new h(4281282611L), null, composer5, 262150, 1073741824, 0, 1572830);
                                    composer5.endReplaceableGroup();
                                } else {
                                    composer5.startReplaceableGroup(931009488);
                                    APNGKt.a(ComposeLayoutPropUpdaterKt.v(i.INSTANCE, 80.0f, 80.0f), null, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_JvLJrECzE8W.png", 1, Boolean.TRUE, null, null, null, composer5, 28040, 226);
                                    composer5.endReplaceableGroup();
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 3128, 4);
                    float f18 = -(f16 + 46.0f);
                    a aVar = (a) composer3.consume(CompositionLocalsKt.d());
                    NBPShootViewModel shootVM = NBPMoodGroupViewModel.this.getShootVM();
                    float e17 = aVar.e();
                    float d17 = aVar.d();
                    float abs = Math.abs(f18);
                    shootVM.pagerWidth = e17;
                    shootVM.pagerHeight = d17;
                    float f19 = 2;
                    shootVM.shootCenterPointInPager = new NBPShootPoint(e17 / f19, (d17 - abs) - (shootVM.shootEntranceSize / f19));
                    i p17 = ComposeLayoutPropUpdaterKt.p(ModifiersKt.T(bVar2.a(companion, Alignment.BottomCenter), 2), 0.0f, f18, 1, null);
                    final NBPMoodGroupViewModel nBPMoodGroupViewModel6 = NBPMoodGroupViewModel.this;
                    BoxKt.a(p17, null, null, ComposableLambdaKt.composableLambda(composer3, -607742341, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.BottomViewKt$BottomView$1.6
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar3, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-607742341, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.BottomView.<anonymous>.<anonymous> (BottomView.kt:115)");
                                }
                                ShootEntranceViewKt.ShootEntranceView(NBPMoodGroupViewModel.this.getShootVM(), NBPMoodGroupViewModel.this.getReportVM(), composer5, 8);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 3080, 6);
                    i z16 = ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.o(bVar2.a(companion, alignment), e16 * 0.69158876f, f17), 56.0f));
                    final NBPMoodGroupViewModel nBPMoodGroupViewModel7 = NBPMoodGroupViewModel.this;
                    i d18 = ViewEventPropUpdaterKt.d(z16, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.BottomViewKt$BottomView$1.7
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ClickParams clickParams) {
                            if (NBPMoodGroupViewModel.this.getHostMood() == null) {
                                NBPMoodGroupViewModel.this.showJoinPop$delegate.setValue(Boolean.TRUE);
                            } else {
                                NBPMoodGroupViewModel.this.changeBarragePopVisible(true);
                            }
                            NBPMoodGroupViewModel.this.getReportVM().dtReportElementClick("em_nearby_send_bullet_screen", null);
                            return Unit.INSTANCE;
                        }
                    }, 3, null);
                    final NBPMoodGroupViewModel nBPMoodGroupViewModel8 = NBPMoodGroupViewModel.this;
                    ColumnKt.a(ViewEventPropUpdaterKt.l(d18, new Function1<ap3.a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.BottomViewKt$BottomView$1.8
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ap3.a aVar2) {
                            ap3.a aVar3 = aVar2;
                            NBPMoodGroupViewModel.this.barrageIconFrame = new d(aVar3.getX(), aVar3.getY(), aVar3.getWidth(), aVar3.getHeight());
                            return Unit.INSTANCE;
                        }
                    }), null, Alignment.INSTANCE.b(), null, ComposableSingletons$BottomViewKt.f65lambda2, composer3, 24584, 10);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 3080, 6);
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("isFoldDevice: ");
        m3.append(((a) startRestartGroup.consume(CompositionLocalsKt.d())).c().n().g("isFoldDevice", false));
        kLog.i("NBPShootResultPage", m3.toString());
        if (((Boolean) nBPMoodGroupViewModel.getResultVM().needToBlur$delegate.getValue()).booleanValue() && !((a) startRestartGroup.consume(CompositionLocalsKt.d())).c().n().g("isFoldDevice", false)) {
            KuiklyKt.a(null, null, new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.BottomViewKt$BottomView$2
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                    ViewContainer<?, ?> viewContainer2 = viewContainer;
                    viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.BottomViewKt$BottomView$2.1
                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(m mVar) {
                            m mVar2 = mVar;
                            mVar2.m154zIndex(4);
                            mVar2.absolutePositionAllZero();
                            mVar2.size(mVar2.getPagerData().m(), mVar2.getPagerData().l());
                            return Unit.INSTANCE;
                        }
                    });
                    viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.BottomViewKt$BottomView$2.2
                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(Event event) {
                            event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.BottomViewKt.BottomView.2.2.1
                                @Override // kotlin.jvm.functions.Function1
                                public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                    final float f16 = k.a(c.f117352a) ? 1.0f : 3.0f;
                    o.a(viewContainer2, new Function1<n, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.BottomViewKt$BottomView$2.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(n nVar) {
                            final float f17 = f16;
                            nVar.attr(new Function1<com.tencent.kuikly.core.views.m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.BottomViewKt.BottomView.2.3.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(com.tencent.kuikly.core.views.m mVar) {
                                    com.tencent.kuikly.core.views.m mVar2 = mVar;
                                    mVar2.positionAbsolute();
                                    mVar2.m142left(-5.0f);
                                    mVar2.m149right(-5.0f);
                                    mVar2.m150top(-5.0f);
                                    mVar2.m138bottom(-5.0f);
                                    mVar2.i(f17);
                                    mVar2.h(true);
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                    return Unit.INSTANCE;
                }
            }, startRestartGroup, MsgConstant.KRMFILETHUMBSIZE384, 3);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.BottomViewKt$BottomView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                BottomViewKt.BottomView(NBPMoodGroupViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
