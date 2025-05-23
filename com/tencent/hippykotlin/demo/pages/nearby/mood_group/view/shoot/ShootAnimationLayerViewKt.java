package com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.foundation.view.APNGAttr;
import com.tencent.hippykotlin.demo.pages.foundation.view.APNGEvent;
import com.tencent.hippykotlin.demo.pages.foundation.view.APNGVView;
import com.tencent.hippykotlin.demo.pages.foundation.view.APNGViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.shoot.NBPShootTrackAnimation;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.shoot.NBPShootViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.AnimationCompletionParams;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.base.y;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.material.APNGKt;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.KuiklyKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ShootAnimationLayerViewKt {
    public static final void ShootAnimationLayerView(final NBPShootViewModel nBPShootViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-473128847);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-473128847, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerView (ShootAnimationLayerView.kt:28)");
        }
        i.Companion companion = i.INSTANCE;
        BoxKt.a(ModifiersKt.T(ModifiersKt.M(ComposeLayoutPropUpdaterKt.h(companion, 0.0f, 1, null), false), 5), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1143333163, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerViewKt$ShootAnimationLayerView$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1143333163, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerView.<anonymous> (ShootAnimationLayerView.kt:34)");
                    }
                    final NBPShootViewModel nBPShootViewModel2 = NBPShootViewModel.this;
                    KuiklyKt.a(null, null, new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerViewKt$ShootAnimationLayerView$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                            ViewContainer<?, ?> viewContainer2 = viewContainer;
                            viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerViewKt.ShootAnimationLayerView.1.1.1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(m mVar) {
                                    m mVar2 = mVar;
                                    mVar2.absolutePositionAllZero();
                                    mVar2.mo113backgroundColor(h.INSTANCE.j());
                                    return Unit.INSTANCE;
                                }
                            });
                            final NBPShootViewModel nBPShootViewModel3 = NBPShootViewModel.this;
                            Function0<c<NBPShootTrackAnimation>> function0 = new Function0<c<NBPShootTrackAnimation>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerViewKt.ShootAnimationLayerView.1.1.2
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final c<NBPShootTrackAnimation> invoke() {
                                    return NBPShootViewModel.this.getTrackAnimations();
                                }
                            };
                            final NBPShootViewModel nBPShootViewModel4 = NBPShootViewModel.this;
                            LoopDirectivesViewKt.a(viewContainer2, function0, new Function2<LoopDirectivesView<NBPShootTrackAnimation>, NBPShootTrackAnimation, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerViewKt.ShootAnimationLayerView.1.1.3
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Unit invoke(LoopDirectivesView<NBPShootTrackAnimation> loopDirectivesView, NBPShootTrackAnimation nBPShootTrackAnimation) {
                                    final NBPShootTrackAnimation nBPShootTrackAnimation2 = nBPShootTrackAnimation;
                                    final NBPShootViewModel nBPShootViewModel5 = NBPShootViewModel.this;
                                    w.a(loopDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerViewKt.ShootAnimationLayerView.1.1.3.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar) {
                                            v vVar2 = vVar;
                                            final NBPShootTrackAnimation nBPShootTrackAnimation3 = NBPShootTrackAnimation.this;
                                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerViewKt.ShootAnimationLayerView.1.1.3.1.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 12, null);
                                                    tVar2.transform(new y(NBPShootTrackAnimation.this.getAnimationTransform().translateX, NBPShootTrackAnimation.this.getAnimationTransform().translateY, 0.0f, 0.0f, 12, null));
                                                    NBPShootTrackAnimation nBPShootTrackAnimation4 = NBPShootTrackAnimation.this;
                                                    tVar2.m134animation((com.tencent.kuikly.core.base.b) nBPShootTrackAnimation4.animationConfig$delegate.getValue(nBPShootTrackAnimation4, NBPShootTrackAnimation.$$delegatedProperties[2]), (Object) NBPShootTrackAnimation.this.getAnimationTransform());
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final NBPShootTrackAnimation nBPShootTrackAnimation4 = NBPShootTrackAnimation.this;
                                            vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerViewKt.ShootAnimationLayerView.1.1.3.1.2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(u uVar) {
                                                    u uVar2 = uVar;
                                                    final NBPShootTrackAnimation nBPShootTrackAnimation5 = NBPShootTrackAnimation.this;
                                                    FrameEventKt.d(uVar2, new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerViewKt.ShootAnimationLayerView.1.1.3.1.2.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(d dVar) {
                                                            NBPShootTrackAnimation nBPShootTrackAnimation6 = NBPShootTrackAnimation.this;
                                                            if (!nBPShootTrackAnimation6.startAnimation) {
                                                                nBPShootTrackAnimation6.startAnimation = true;
                                                                nBPShootTrackAnimation6.toNextFrameAnimation();
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final NBPShootTrackAnimation nBPShootTrackAnimation6 = NBPShootTrackAnimation.this;
                                                    uVar2.animationCompletion(new Function1<AnimationCompletionParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerViewKt.ShootAnimationLayerView.1.1.3.1.2.2
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(AnimationCompletionParams animationCompletionParams) {
                                                            NBPShootTrackAnimation nBPShootTrackAnimation7 = NBPShootTrackAnimation.this;
                                                            nBPShootTrackAnimation7.getAnimationTransform();
                                                            nBPShootTrackAnimation7.toNextFrameAnimation();
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final NBPShootTrackAnimation nBPShootTrackAnimation5 = NBPShootTrackAnimation.this;
                                            final NBPShootViewModel nBPShootViewModel6 = nBPShootViewModel5;
                                            ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerViewKt.ShootAnimationLayerView.1.1.3.1.3
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ImageView imageView) {
                                                    final NBPShootTrackAnimation nBPShootTrackAnimation6 = NBPShootTrackAnimation.this;
                                                    final NBPShootViewModel nBPShootViewModel7 = nBPShootViewModel6;
                                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerViewKt.ShootAnimationLayerView.1.1.3.1.3.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(af afVar) {
                                                            af afVar2 = afVar;
                                                            afVar2.size(NBPShootTrackAnimation.this.animationSize);
                                                            b.a.b(afVar2, nBPShootViewModel7.shootEmojiIcon, false, 2, null);
                                                            NBPShootTrackAnimation nBPShootTrackAnimation7 = NBPShootTrackAnimation.this;
                                                            afVar2.transform(new com.tencent.kuikly.core.base.t(((Number) nBPShootTrackAnimation7.animationRotate$delegate.getValue(nBPShootTrackAnimation7, NBPShootTrackAnimation.$$delegatedProperties[1])).floatValue(), 0.0f, 0.0f, 6, null));
                                                            NBPShootTrackAnimation nBPShootTrackAnimation8 = NBPShootTrackAnimation.this;
                                                            afVar2.m152visibility(!((Boolean) nBPShootTrackAnimation8.showBoomView$delegate.getValue(nBPShootTrackAnimation8, r3[3])).booleanValue());
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final NBPShootTrackAnimation nBPShootTrackAnimation6 = NBPShootTrackAnimation.this;
                                            Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerViewKt.ShootAnimationLayerView.1.1.3.1.4
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final Object invoke() {
                                                    NBPShootTrackAnimation nBPShootTrackAnimation7 = NBPShootTrackAnimation.this;
                                                    return Boolean.valueOf(((Boolean) nBPShootTrackAnimation7.showBoomView$delegate.getValue(nBPShootTrackAnimation7, NBPShootTrackAnimation.$$delegatedProperties[3])).booleanValue());
                                                }
                                            };
                                            final NBPShootViewModel nBPShootViewModel7 = nBPShootViewModel5;
                                            final NBPShootTrackAnimation nBPShootTrackAnimation7 = NBPShootTrackAnimation.this;
                                            ConditionViewKt.c(vVar2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerViewKt.ShootAnimationLayerView.1.1.3.1.5
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ConditionView conditionView) {
                                                    final NBPShootViewModel nBPShootViewModel8 = NBPShootViewModel.this;
                                                    final NBPShootTrackAnimation nBPShootTrackAnimation8 = nBPShootTrackAnimation7;
                                                    w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerViewKt.ShootAnimationLayerView.1.1.3.1.5.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(v vVar3) {
                                                            v vVar4 = vVar3;
                                                            vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerViewKt.ShootAnimationLayerView.1.1.3.1.5.1.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(t tVar) {
                                                                    t tVar2 = tVar;
                                                                    tVar2.absolutePositionAllZero();
                                                                    tVar2.allCenter();
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final NBPShootViewModel nBPShootViewModel9 = NBPShootViewModel.this;
                                                            final NBPShootTrackAnimation nBPShootTrackAnimation9 = nBPShootTrackAnimation8;
                                                            APNGViewKt.APNG(vVar4, new Function1<APNGVView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerViewKt.ShootAnimationLayerView.1.1.3.1.5.1.2
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(APNGVView aPNGVView) {
                                                                    APNGVView aPNGVView2 = aPNGVView;
                                                                    final NBPShootViewModel nBPShootViewModel10 = NBPShootViewModel.this;
                                                                    final NBPShootTrackAnimation nBPShootTrackAnimation10 = nBPShootTrackAnimation9;
                                                                    aPNGVView2.attr(new Function1<APNGAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerViewKt.ShootAnimationLayerView.1.1.3.1.5.1.2.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(APNGAttr aPNGAttr) {
                                                                            APNGAttr aPNGAttr2 = aPNGAttr;
                                                                            aPNGAttr2.with("src", NBPShootViewModel.this.shootBoomAPNG);
                                                                            float f16 = nBPShootTrackAnimation10.boomViewSize;
                                                                            aPNGAttr2.size(f16, f16);
                                                                            aPNGAttr2.repeatCount(1);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    final NBPShootTrackAnimation nBPShootTrackAnimation11 = nBPShootTrackAnimation9;
                                                                    aPNGVView2.event(new Function1<APNGEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerViewKt.ShootAnimationLayerView.1.1.3.1.5.1.2.2
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(APNGEvent aPNGEvent) {
                                                                            APNGEvent aPNGEvent2 = aPNGEvent;
                                                                            final NBPShootTrackAnimation nBPShootTrackAnimation12 = NBPShootTrackAnimation.this;
                                                                            aPNGEvent2.register("loadFailure", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerViewKt.ShootAnimationLayerView.1.1.3.1.5.1.2.2.1
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(Object obj) {
                                                                                    NBPShootTrackAnimation.this.onBoomAnimationCompletion();
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            final NBPShootTrackAnimation nBPShootTrackAnimation13 = NBPShootTrackAnimation.this;
                                                                            aPNGEvent2.register("animationStart", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerViewKt.ShootAnimationLayerView.1.1.3.1.5.1.2.2.2
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(Object obj) {
                                                                                    NBPShootTrackAnimation nBPShootTrackAnimation14 = NBPShootTrackAnimation.this;
                                                                                    nBPShootTrackAnimation14.boomAnimationBegin.invoke(nBPShootTrackAnimation14);
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            final NBPShootTrackAnimation nBPShootTrackAnimation14 = NBPShootTrackAnimation.this;
                                                                            aPNGEvent2.register("animationEnd", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerViewKt.ShootAnimationLayerView.1.1.3.1.5.1.2.2.3
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(Object obj) {
                                                                                    NBPShootTrackAnimation.this.onBoomAnimationCompletion();
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    final NBPShootTrackAnimation nBPShootTrackAnimation12 = nBPShootTrackAnimation9;
                                                                    Function0<Unit> function03 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerViewKt.ShootAnimationLayerView.1.1.3.1.5.1.2.3
                                                                        {
                                                                            super(0);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function0
                                                                        public final Unit invoke() {
                                                                            NBPShootTrackAnimation.this.onBoomAnimationCompletion();
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    };
                                                                    KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
                                                                    TimerKt.e(aPNGVView2.getPagerId(), 2000, function03);
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
                                    return Unit.INSTANCE;
                                }
                            });
                            final NBPShootViewModel nBPShootViewModel5 = NBPShootViewModel.this;
                            Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerViewKt.ShootAnimationLayerView.1.1.4
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Boolean.valueOf(!NBPShootViewModel.this.getSerialShootTimesIconArray().isEmpty());
                                }
                            };
                            final NBPShootViewModel nBPShootViewModel6 = NBPShootViewModel.this;
                            ConditionViewKt.c(viewContainer2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerViewKt.ShootAnimationLayerView.1.1.5
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ConditionView conditionView) {
                                    final NBPShootViewModel nBPShootViewModel7 = NBPShootViewModel.this;
                                    w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerViewKt.ShootAnimationLayerView.1.1.5.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar) {
                                            v vVar2 = vVar;
                                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerViewKt.ShootAnimationLayerView.1.1.5.1.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    Attr.absolutePosition$default(tVar2, 10.0f + tVar2.getPager().getPageData().getNavigationBarHeight(), 0.0f, 0.0f, 0.0f, 4, null);
                                                    tVar2.allCenter();
                                                    tVar2.flexDirectionRow();
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final NBPShootViewModel nBPShootViewModel8 = NBPShootViewModel.this;
                                            w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerViewKt.ShootAnimationLayerView.1.1.5.1.2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar3) {
                                                    v vVar4 = vVar3;
                                                    vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerViewKt.ShootAnimationLayerView.1.1.5.1.2.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            t tVar2 = tVar;
                                                            tVar2.margin(5.0f);
                                                            tVar2.size(26.0f);
                                                            tVar2.alignItemsCenter();
                                                            tVar2.justifyContentFlexStart();
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final NBPShootViewModel nBPShootViewModel9 = NBPShootViewModel.this;
                                                    ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerViewKt.ShootAnimationLayerView.1.1.5.1.2.2
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ImageView imageView) {
                                                            final NBPShootViewModel nBPShootViewModel10 = NBPShootViewModel.this;
                                                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerViewKt.ShootAnimationLayerView.1.1.5.1.2.2.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(af afVar) {
                                                                    af afVar2 = afVar;
                                                                    b.a.b(afVar2, NBPShootViewModel.this.xIconUrl, false, 2, null);
                                                                    afVar2.size(72.0f);
                                                                    afVar2.marginTop(-15.0f);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final NBPShootViewModel nBPShootViewModel9 = NBPShootViewModel.this;
                                            LoopDirectivesViewKt.a(vVar2, new Function0<c<String>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerViewKt.ShootAnimationLayerView.1.1.5.1.3
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final c<String> invoke() {
                                                    return NBPShootViewModel.this.getSerialShootTimesIconArray();
                                                }
                                            }, new Function2<LoopDirectivesView<String>, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerViewKt.ShootAnimationLayerView.1.1.5.1.4
                                                @Override // kotlin.jvm.functions.Function2
                                                public final Unit invoke(LoopDirectivesView<String> loopDirectivesView, String str) {
                                                    final String str2 = str;
                                                    w.a(loopDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerViewKt.ShootAnimationLayerView.1.1.5.1.4.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(v vVar3) {
                                                            v vVar4 = vVar3;
                                                            vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerViewKt.ShootAnimationLayerView.1.1.5.1.4.1.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(t tVar) {
                                                                    t tVar2 = tVar;
                                                                    tVar2.size(65.0f, 115.0f);
                                                                    tVar2.allCenter();
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final String str3 = str2;
                                                            ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerViewKt.ShootAnimationLayerView.1.1.5.1.4.1.2
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ImageView imageView) {
                                                                    final String str4 = str3;
                                                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerViewKt.ShootAnimationLayerView.1.1.5.1.4.1.2.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(af afVar) {
                                                                            af afVar2 = afVar;
                                                                            afVar2.size(83.0f, 115.0f);
                                                                            afVar2.o();
                                                                            b.a.b(afVar2, str4, false, 2, null);
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
        BoxKt.a(ModifiersKt.R(ModifiersKt.T(ModifiersKt.M(companion, false), -1), false), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 2126501204, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerViewKt$ShootAnimationLayerView$2
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
                        ComposerKt.traceEventStart(2126501204, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerView.<anonymous> (ShootAnimationLayerView.kt:181)");
                    }
                    composer3.startReplaceableGroup(-1024171093);
                    for (String str : NBPShootViewModel.this.numberIcons) {
                        composer3.startMovableGroup(-1024171051, str);
                        Composer composer4 = composer3;
                        ImageKt.a(str, null, null, null, null, ComposeLayoutPropUpdaterKt.v(i.INSTANCE, 83.0f, 115.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer4, 262144, 0, 0, 2097118);
                        composer4.endMovableGroup();
                        composer3 = composer4;
                    }
                    Composer composer5 = composer3;
                    composer5.endReplaceableGroup();
                    NBPShootViewModel nBPShootViewModel2 = NBPShootViewModel.this;
                    String str2 = nBPShootViewModel2.shootEmojiIcon;
                    i.Companion companion2 = i.INSTANCE;
                    ImageKt.a(str2, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion2, nBPShootViewModel2.shootEntranceSize), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer5, 262144, 0, 0, 2097118);
                    APNGKt.a(ComposeLayoutPropUpdaterKt.u(companion2, 100.0f), null, NBPShootViewModel.this.shootBoomAPNG, 1, null, null, null, null, composer5, 3080, 242);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerViewKt$ShootAnimationLayerView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                ShootAnimationLayerViewKt.ShootAnimationLayerView(NBPShootViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
