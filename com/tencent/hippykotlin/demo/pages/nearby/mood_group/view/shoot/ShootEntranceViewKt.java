package com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheModule;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.NBPMoodGroupReportViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.shoot.NBPShootPoint;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.shoot.NBPShootViewModel;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.TouchParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.u;
import com.tencent.kuikly.core.base.y;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.Timer;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.ntcompose.animation.AnimateAsStateKt;
import com.tencent.ntcompose.animation.m;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.APNGKt;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.KuiklyKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ShootEntranceViewKt {
    public static final void ShootEntranceView(final NBPShootViewModel nBPShootViewModel, final NBPMoodGroupReportViewModel nBPMoodGroupReportViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(2019836615);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2019836615, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootEntranceView (ShootEntranceView.kt:36)");
        }
        BoxKt.a(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, nBPShootViewModel.shootEntranceSize), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 430493569, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootEntranceViewKt$ShootEntranceView$1
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
                        ComposerKt.traceEventStart(430493569, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootEntranceView.<anonymous> (ShootEntranceView.kt:39)");
                    }
                    i.Companion companion = i.INSTANCE;
                    i p16 = ComposeLayoutPropUpdaterKt.p(ModifiersKt.Q(bVar2.a(companion, Alignment.TopCenter), new y(0.0f, -1.0f, 0.0f, 0.0f, 12, null), null, 2, null), 0.0f, -40.0f, 1, null);
                    final NBPShootViewModel nBPShootViewModel2 = NBPShootViewModel.this;
                    BoxKt.a(p16, null, null, ComposableLambdaKt.composableLambda(composer3, 1268262587, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootEntranceViewKt$ShootEntranceView$1.1
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
                                    ComposerKt.traceEventStart(1268262587, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootEntranceView.<anonymous>.<anonymous> (ShootEntranceView.kt:42)");
                                }
                                ShootGuideTipViewKt.ShootGuideTipView(NBPShootViewModel.this, composer5, 8);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 3080, 6);
                    i u16 = ComposeLayoutPropUpdaterKt.u(companion, NBPShootViewModel.this.shootEntranceSize);
                    h.Companion companion2 = h.INSTANCE;
                    i c16 = ModifiersKt.c(u16, companion2.j());
                    final NBPShootViewModel nBPShootViewModel3 = NBPShootViewModel.this;
                    Function2<v, aa<v>, Unit> function2 = new Function2<v, aa<v>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootEntranceViewKt$ShootEntranceView$1.2
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Unit invoke(v vVar, aa<v> aaVar) {
                            NBPShootViewModel.this.entranceView = aaVar;
                            return Unit.INSTANCE;
                        }
                    };
                    final NBPShootViewModel nBPShootViewModel4 = NBPShootViewModel.this;
                    BoxKt.a(c16, null, function2, ComposableLambdaKt.composableLambda(composer3, -595900124, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootEntranceViewKt$ShootEntranceView$1.3
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar3, Composer composer4, Integer num2) {
                            int i17;
                            i c17;
                            Integer intOrNull;
                            b bVar4 = bVar3;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 14) == 0) {
                                i17 = (composer5.changed(bVar4) ? 4 : 2) | intValue2;
                            } else {
                                i17 = intValue2;
                            }
                            if ((i17 & 91) == 18 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-595900124, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootEntranceView.<anonymous>.<anonymous> (ShootEntranceView.kt:49)");
                                }
                                if (NBPShootViewModel.this.isPressingState.getValue().booleanValue()) {
                                    composer5.startReplaceableGroup(-70112425);
                                    APNGKt.a(bVar4.a(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 200.0f), Alignment.Center), null, "https://vfiles.gtimg.cn/wuji_dashboard/xy/componenthub/5Mgag8Bc.png", 1, null, null, null, null, composer5, 3464, 242);
                                    composer5.endReplaceableGroup();
                                } else if (NBPShootViewModel.this.hasTouchUp.getValue().booleanValue()) {
                                    composer5.startReplaceableGroup(-70112147);
                                    APNGKt.a(bVar4.a(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 200.0f), Alignment.Center), null, "https://vfiles.gtimg.cn/wuji_dashboard/xy/componenthub/zuHS9Bl3.png", 1, null, null, null, null, composer5, 3464, 242);
                                    composer5.endReplaceableGroup();
                                } else {
                                    composer5.startReplaceableGroup(-70111887);
                                    composer5.endReplaceableGroup();
                                }
                                float f16 = ((Boolean) AnimateAsStateKt.d(NBPShootViewModel.this.isPressingState.getValue(), new m(100, 0, null, false, null, 30, null), new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootEntranceViewKt$ShootEntranceView$1$3$pressScaleAnimate$2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                        bool.booleanValue();
                                        return Unit.INSTANCE;
                                    }
                                }, composer5, MsgConstant.KRMFILETHUMBSIZE384, 0).getValue()).booleanValue() ? 0.96f : 1.0f;
                                i O = ModifiersKt.O(i.INSTANCE, null, new u(f16, f16), null, null, null, 29, null);
                                float f17 = NBPShootViewModel.this.shootEntranceSize + 20.0f;
                                ImageKt.a("https://vfiles.gtimg.cn/wuji_dashboard/xy/componenthub/8ZJlYkMX.png", null, null, null, null, bVar4.a(ComposeLayoutPropUpdaterKt.v(O, f17, 1.0462962f * f17), Alignment.BottomCenter), null, com.tencent.ntcompose.material.h.INSTANCE.b(), null, null, null, null, null, null, null, null, null, null, null, null, null, composer5, 12845062, 0, 0, 2096990);
                                composer5.startReplaceableGroup(-70111125);
                                Iterator<Integer> it = NBPShootViewModel.this.pressAnimationCounts.iterator();
                                while (it.hasNext()) {
                                    composer5.startMovableGroup(-70111062, Integer.valueOf(it.next().intValue()));
                                    APNGKt.a(bVar4.a(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, NBPShootViewModel.this.shootEntranceSize + 60.0f), Alignment.Center), null, "https://vfiles.gtimg.cn/wuji_dashboard/xy/componenthub/xhc4zNkp.png", 100000000, null, null, null, null, composer5, 3464, 242);
                                    composer5.endMovableGroup();
                                }
                                composer5.endReplaceableGroup();
                                boolean z16 = false;
                                if (NBPShootViewModel.this.pageData.getIsAndroid()) {
                                    intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(NBPShootViewModel.this.pageData.getOsVersion());
                                    if ((intOrNull != null ? intOrNull.intValue() : 0) <= 27) {
                                        z16 = true;
                                    }
                                }
                                if (z16) {
                                    c17 = i.INSTANCE;
                                } else {
                                    c17 = ModifiersKt.c(ModifiersKt.j(i.INSTANCE, (NBPShootViewModel.this.shootEntranceSize - 16.0f) / 2), new h(4294243572L));
                                }
                                a.e b16 = a.f339245a.b();
                                i O2 = ModifiersKt.O(bVar4.a(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, NBPShootViewModel.this.shootEntranceSize - 16.0f).b(c17), Alignment.Center), null, new u(f16, f16), null, null, null, 29, null);
                                final NBPShootViewModel nBPShootViewModel5 = NBPShootViewModel.this;
                                ColumnKt.a(O2, b16, null, null, ComposableLambdaKt.composableLambda(composer5, 42210317, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootEntranceViewKt.ShootEntranceView.1.3.1
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(d dVar, Composer composer6, Integer num3) {
                                        int i18;
                                        d dVar2 = dVar;
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 14) == 0) {
                                            i18 = (composer7.changed(dVar2) ? 4 : 2) | intValue3;
                                        } else {
                                            i18 = intValue3;
                                        }
                                        if ((i18 & 91) == 18 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(42210317, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootEntranceView.<anonymous>.<anonymous>.<anonymous> (ShootEntranceView.kt:100)");
                                            }
                                            ImageKt.a(NBPShootViewModel.this.entranceEmojiIcon, null, null, null, null, dVar2.b(ComposeLayoutPropUpdaterKt.v(i.INSTANCE, 48.0f, 48.0f), Alignment.INSTANCE.b()), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer7, 262144, 0, 0, 2097118);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 24648, 12);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 3080, 2);
                    State d16 = AnimateAsStateKt.d(NBPShootViewModel.this.isPressingState.getValue(), new m(260, 0, null, false, null, 30, null), new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootEntranceViewKt$ShootEntranceView$1$transitionAnimate$2
                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            bool.booleanValue();
                            return Unit.INSTANCE;
                        }
                    }, composer3, MsgConstant.KRMFILETHUMBSIZE384, 0);
                    i j3 = ModifiersKt.j(ModifiersKt.L(ModifiersKt.c(ModifiersKt.D(ModifiersKt.Q(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.p(ComposeLayoutPropUpdaterKt.k(bVar2.a(companion, Alignment.BottomCenter), 22.0f), 0.0f, 36.0f, 1, null), 11.0f, 0.0f, 11.0f, 0.0f, 10, null), new y(0.0f, ((Boolean) d16.getValue()).booleanValue() ? 2.0f : 0.0f, 0.0f, 0.0f, 12, null), null, 2, null), ((Boolean) d16.getValue()).booleanValue() ? 0.0f : 1.0f), companion2.a(0.5f)), 0.0f, 0.0f, 6.7f, new h(603979776L)), 11.0f);
                    final NBPShootViewModel nBPShootViewModel5 = NBPShootViewModel.this;
                    BoxKt.a(j3, null, null, ComposableLambdaKt.composableLambda(composer3, -1080845373, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootEntranceViewKt$ShootEntranceView$1.4
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar3, Composer composer4, Integer num2) {
                            int i17;
                            b bVar4 = bVar3;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 14) == 0) {
                                i17 = (composer5.changed(bVar4) ? 4 : 2) | intValue2;
                            } else {
                                i17 = intValue2;
                            }
                            if ((i17 & 91) == 18 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1080845373, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootEntranceView.<anonymous>.<anonymous> (ShootEntranceView.kt:127)");
                                }
                                TextKt.a(NBPShootViewModel.this.bottomTipText, bVar4.a(i.INSTANCE, Alignment.Center), null, h.INSTANCE.m(), Float.valueOf(10.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 28736, 0, 0, 134217700);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 3080, 6);
                    final NBPShootViewModel nBPShootViewModel6 = NBPShootViewModel.this;
                    KuiklyKt.a(null, null, new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootEntranceViewKt$ShootEntranceView$1.5
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                            ViewContainer<?, ?> viewContainer2 = viewContainer;
                            viewContainer2.attr(new Function1<com.tencent.kuikly.core.base.m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootEntranceViewKt.ShootEntranceView.1.5.1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(com.tencent.kuikly.core.base.m mVar) {
                                    mVar.absolutePositionAllZero();
                                    return Unit.INSTANCE;
                                }
                            });
                            final NBPShootViewModel nBPShootViewModel7 = NBPShootViewModel.this;
                            w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootEntranceViewKt.ShootEntranceView.1.5.2
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar) {
                                    v vVar2 = vVar;
                                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootEntranceViewKt.ShootEntranceView.1.5.2.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            tVar.absolutePositionAllZero();
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final NBPShootViewModel nBPShootViewModel8 = NBPShootViewModel.this;
                                    vVar2.event(new Function1<com.tencent.kuikly.core.views.u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootEntranceViewKt.ShootEntranceView.1.5.2.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(com.tencent.kuikly.core.views.u uVar) {
                                            com.tencent.kuikly.core.views.u uVar2 = uVar;
                                            final NBPShootViewModel nBPShootViewModel9 = NBPShootViewModel.this;
                                            uVar2.touchDown(new Function1<TouchParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootEntranceViewKt.ShootEntranceView.1.5.2.2.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TouchParams touchParams) {
                                                    TouchParams touchParams2 = touchParams;
                                                    final NBPShootViewModel nBPShootViewModel10 = NBPShootViewModel.this;
                                                    nBPShootViewModel10.getClass();
                                                    KLog.INSTANCE.i(NBPShootViewModel.TAG, "onShootTouchDown");
                                                    NBPMoodGroupReportViewModel nBPMoodGroupReportViewModel2 = nBPShootViewModel10.reporter;
                                                    e eVar = new e();
                                                    eVar.v("nearby_emoji_id", nBPShootViewModel10.emojiId);
                                                    Unit unit = Unit.INSTANCE;
                                                    nBPMoodGroupReportViewModel2.dtReportElementClick("em_nearby_launch", eVar);
                                                    nBPShootViewModel10.isPressing = true;
                                                    nBPShootViewModel10.shootTouchDownPoint = new NBPShootPoint(touchParams2.getX(), touchParams2.getY());
                                                    Timer timer = new Timer();
                                                    timer.f(0, 120, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.shoot.NBPShootViewModel$onShootTouchDown$2$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(0);
                                                        }

                                                        /* JADX WARN: Type inference failed for: r2v1, types: [java.util.List<com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.shoot.NBPShootTrackTransform>, java.util.ArrayList] */
                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Unit invoke() {
                                                            NBPShootViewModel nBPShootViewModel11 = NBPShootViewModel.this;
                                                            int i17 = nBPShootViewModel11.animationId + 1;
                                                            nBPShootViewModel11.animationId = i17;
                                                            String.valueOf(i17);
                                                            NBPShootViewModel nBPShootViewModel12 = NBPShootViewModel.this;
                                                            NBPShootPoint nBPShootPoint = nBPShootViewModel12.shootCenterPointInPager;
                                                            float f16 = nBPShootViewModel12.entranceRotate;
                                                            boolean z16 = Random.INSTANCE.nextInt(com.tencent.kuikly.core.base.d.b((nBPShootViewModel12.serialShootTimes + 1) % 9 != 0), 2) == 0;
                                                            final NBPShootViewModel nBPShootViewModel13 = NBPShootViewModel.this;
                                                            float f17 = nBPShootViewModel13.pagerWidth;
                                                            float f18 = nBPShootViewModel13.pagerHeight;
                                                            final NBPShootViewModel nBPShootViewModel14 = nBPShootViewModel10;
                                                            Function1<NBPShootTrackAnimation, Unit> function1 = new Function1<NBPShootTrackAnimation, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.shoot.NBPShootViewModel$onShootTouchDown$2$1.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                /* JADX WARN: Type inference failed for: r1v9, types: [java.util.List<com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.shoot.NBPShootTrackTransform>, java.util.ArrayList] */
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(NBPShootTrackAnimation nBPShootTrackAnimation) {
                                                                    Object last;
                                                                    NBPShootPoint nBPShootPoint2;
                                                                    NBPShootTrackAnimation nBPShootTrackAnimation2 = nBPShootTrackAnimation;
                                                                    final NBPShootViewModel nBPShootViewModel15 = NBPShootViewModel.this;
                                                                    KProperty<Object>[] kPropertyArr = NBPShootViewModel.$$delegatedProperties;
                                                                    nBPShootViewModel15.getClass();
                                                                    ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).callNativeMethod("shakeHeavy", null, null);
                                                                    TimerKt.b(nBPShootViewModel15.delayCallbackRef);
                                                                    nBPShootViewModel15.updateShakeState(true);
                                                                    nBPShootViewModel15.delayCallbackRef = TimerKt.d(400, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.shoot.NBPShootViewModel$onBoomAnimationBegin$1
                                                                        {
                                                                            super(0);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function0
                                                                        public final Unit invoke() {
                                                                            NBPShootViewModel.this.updateShakeState(false);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    INBPShootEventListener iNBPShootEventListener = nBPShootViewModel13.shootListener;
                                                                    if (!nBPShootTrackAnimation2.keyframeAnimations.isEmpty()) {
                                                                        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) nBPShootTrackAnimation2.keyframeAnimations);
                                                                        nBPShootPoint2 = ((NBPShootTrackTransform) last).point;
                                                                    } else {
                                                                        nBPShootPoint2 = new NBPShootPoint(0.0f, 0.0f);
                                                                    }
                                                                    iNBPShootEventListener.onBoom(nBPShootPoint2);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            };
                                                            final NBPShootViewModel nBPShootViewModel15 = NBPShootViewModel.this;
                                                            final NBPShootViewModel nBPShootViewModel16 = nBPShootViewModel10;
                                                            NBPShootTrackAnimation nBPShootTrackAnimation = new NBPShootTrackAnimation(nBPShootPoint, f16, z16, f17, f18, function1, new Function1<NBPShootTrackAnimation, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.shoot.NBPShootViewModel$onShootTouchDown$2$1.2
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(NBPShootTrackAnimation nBPShootTrackAnimation2) {
                                                                    NBPShootViewModel.this.getTrackAnimations().remove(nBPShootTrackAnimation2);
                                                                    if (NBPShootViewModel.this.getTrackAnimations().isEmpty() && !NBPShootViewModel.this.isPressing) {
                                                                        NBPShootViewModel nBPShootViewModel17 = nBPShootViewModel16;
                                                                        nBPShootViewModel17.getClass();
                                                                        KLog.INSTANCE.i("NBPMoodGroupViewModel", "\u53d1\u5c04\u7ed3\u675f");
                                                                        e eVar2 = new e();
                                                                        eVar2.t("mid", nBPShootViewModel17.mid);
                                                                        eVar2.v(DownloadInfo.spKey_Config, nBPShootViewModel17.config);
                                                                        eVar2.v("emoji_id", nBPShootViewModel17.emojiId);
                                                                        eVar2.t("serial_shoot_times", nBPShootViewModel17.serialShootTimes);
                                                                        c cVar = c.f117352a;
                                                                        k.d((k) cVar.g().acquireModule("KRNotifyModule"), "NEARBY_OPEN_SHOOT_RESULT_PAGE", eVar2, false, 4, null);
                                                                        if (!Intrinsics.areEqual(nBPShootViewModel17.getLastDateOfShoot(), nBPShootViewModel17.today)) {
                                                                            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("nbp_last_shoot_date_key_");
                                                                            m3.append(PageDataExtKt.getUin(cVar.g().getPageData()));
                                                                            ((CacheModule) cVar.g().acquireModule("HRCacheModule")).setItem(m3.toString(), nBPShootViewModel17.today);
                                                                        }
                                                                        nBPShootViewModel17.toSetSerialShootTimes(0);
                                                                        NBPShootViewModel.this.shootListener.onShootEnd();
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            NBPShootViewModel nBPShootViewModel17 = nBPShootViewModel10;
                                                            NBPShootViewModel nBPShootViewModel18 = NBPShootViewModel.this;
                                                            if (!nBPShootTrackAnimation.keyframeAnimations.isEmpty()) {
                                                                nBPShootViewModel17.toSetSerialShootTimes(nBPShootViewModel18.serialShootTimes + 1);
                                                                nBPShootViewModel18.getTrackAnimations().add(nBPShootTrackAnimation);
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    nBPShootViewModel10.pressShootTimer = timer;
                                                    Timer timer2 = new Timer();
                                                    timer2.f(0, 200, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.shoot.NBPShootViewModel$onShootTouchDown$3$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(0);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Unit invoke() {
                                                            if (NBPShootViewModel.this.pressAnimationCounts.size() <= 3) {
                                                                SnapshotStateList<Integer> snapshotStateList = NBPShootViewModel.this.pressAnimationCounts;
                                                                snapshotStateList.add(Integer.valueOf(snapshotStateList.size()));
                                                            } else {
                                                                Timer timer3 = nBPShootViewModel10.pressAnimationTimer;
                                                                if (timer3 != null) {
                                                                    timer3.e();
                                                                }
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    nBPShootViewModel10.pressAnimationTimer = timer2;
                                                    nBPShootViewModel10.isPressingState.setValue(Boolean.TRUE);
                                                    nBPShootViewModel10.shootListener.onShootStart();
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final NBPShootViewModel nBPShootViewModel10 = NBPShootViewModel.this;
                                            uVar2.touchMove(new Function1<TouchParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootEntranceViewKt.ShootEntranceView.1.5.2.2.2
                                                {
                                                    super(1);
                                                }

                                                /* JADX WARN: Multi-variable type inference failed */
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TouchParams touchParams) {
                                                    Float valueOf;
                                                    v b16;
                                                    t tVar;
                                                    TouchParams touchParams2 = touchParams;
                                                    NBPShootViewModel nBPShootViewModel11 = NBPShootViewModel.this;
                                                    nBPShootViewModel11.getClass();
                                                    float x16 = touchParams2.getX();
                                                    float y16 = touchParams2.getY();
                                                    NBPShootPoint nBPShootPoint = nBPShootViewModel11.shootTouchDownPoint;
                                                    float f16 = nBPShootPoint.f114235y - y16;
                                                    if (Math.abs(x16 - nBPShootPoint.f114234x) > 10.0f || Math.abs(f16) > 10.0f) {
                                                        double atan2 = ((float) Math.atan2(f16, r1)) * 57.29577951308232d;
                                                        if (atan2 < 0.0d) {
                                                            atan2 += 360;
                                                        }
                                                        valueOf = Float.valueOf((float) atan2);
                                                    } else {
                                                        valueOf = null;
                                                    }
                                                    if (valueOf != null) {
                                                        float f17 = -(valueOf.floatValue() + 270.0f);
                                                        if (Math.abs(f17 - nBPShootViewModel11.entranceRotate) > 5.0f) {
                                                            aa<v> aaVar = nBPShootViewModel11.entranceView;
                                                            if (aaVar != null && (b16 = aaVar.b()) != null && (tVar = (t) b16.getViewAttr()) != null) {
                                                                tVar.transform(new com.tencent.kuikly.core.base.t(f17, 0.0f, 0.0f, 6, null));
                                                            }
                                                            nBPShootViewModel11.entranceRotate = f17;
                                                            int i17 = (((int) f17) + 360) % 360;
                                                            if ((f17 > 45.0f || f17 < 315.0f) && !nBPShootViewModel11.didControlGuideOnHistory) {
                                                                nBPShootViewModel11.didControlGuideOnHistory = true;
                                                                nBPShootViewModel11.showControlGuideView.setValue(Boolean.FALSE);
                                                                ((CacheModule) c.f117352a.g().acquireModule("HRCacheModule")).setInt(nBPShootViewModel11.controlGuideCacheKey(), 1);
                                                            }
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final NBPShootViewModel nBPShootViewModel11 = NBPShootViewModel.this;
                                            uVar2.touchUp(new Function1<TouchParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootEntranceViewKt.ShootEntranceView.1.5.2.2.3
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TouchParams touchParams) {
                                                    NBPShootViewModel nBPShootViewModel12 = NBPShootViewModel.this;
                                                    nBPShootViewModel12.getClass();
                                                    KLog.INSTANCE.i(NBPShootViewModel.TAG, "onShootTouchUp");
                                                    Timer timer = nBPShootViewModel12.pressShootTimer;
                                                    if (timer != null) {
                                                        timer.e();
                                                    }
                                                    nBPShootViewModel12.pressShootTimer = null;
                                                    Timer timer2 = nBPShootViewModel12.pressAnimationTimer;
                                                    if (timer2 != null) {
                                                        timer2.e();
                                                    }
                                                    nBPShootViewModel12.pressAnimationTimer = null;
                                                    nBPShootViewModel12.pressAnimationCounts.clear();
                                                    nBPShootViewModel12.hasTouchUp.setValue(Boolean.TRUE);
                                                    nBPShootViewModel12.isPressingState.setValue(Boolean.FALSE);
                                                    nBPShootViewModel12.isPressing = false;
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
                    }, composer3, 0, 3);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootEntranceViewKt$ShootEntranceView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                ShootEntranceViewKt.ShootEntranceView(NBPShootViewModel.this, nBPMoodGroupReportViewModel, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
