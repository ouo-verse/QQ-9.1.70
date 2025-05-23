package com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.foundation.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.Point;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.ntcompose.activity.b;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.material.APNGKt;
import com.tencent.ntcompose.material.ModalKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class LoveWallLightingFlowerGuildViewKt {
    public static final void LoveWallLightingFlowerGuildView(final LoveWallHomepageViewModel loveWallHomepageViewModel, final Function0<Unit> function0, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-823246782);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-823246782, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallLightingFlowerGuildView (LoveWallLightingFlowerGuildView.kt:19)");
        }
        ModalKt.a(ModifiersKt.d(i.INSTANCE, h.INSTANCE.a(0.4f)), false, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1799064700, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallLightingFlowerGuildViewKt$LoveWallLightingFlowerGuildView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                Float density;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 11) == 2 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1799064700, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallLightingFlowerGuildView.<anonymous> (LoveWallLightingFlowerGuildView.kt:20)");
                    }
                    final Ref.FloatRef floatRef = new Ref.FloatRef();
                    floatRef.element = PageDataExtKt.getDpScaleDensity(b.a().getPageData());
                    if (b.a().getPageData().getIsIOS() && (density = b.a().getPageData().getDensity()) != null) {
                        floatRef.element *= density.floatValue();
                    }
                    i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                    final LoveWallHomepageViewModel loveWallHomepageViewModel2 = LoveWallHomepageViewModel.this;
                    final Function0<Unit> function02 = function0;
                    i d16 = ViewEventPropUpdaterKt.d(h16, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallLightingFlowerGuildViewKt$LoveWallLightingFlowerGuildView$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:6:0x0052, code lost:
                        
                            if ((r2.f114258y / r2.element) > com.tencent.ntcompose.activity.b.a().getPageData().l()) goto L8;
                         */
                        @Override // kotlin.jvm.functions.Function1
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Unit invoke(ClickParams clickParams) {
                            if (LoveWallHomepageViewModel.this.sproutFlowerPosition.getValue() != null) {
                                Point value = LoveWallHomepageViewModel.this.sproutFlowerPosition.getValue();
                                Intrinsics.checkNotNull(value);
                                if (value.f114257x / floatRef.element <= b.a().getPageData().m()) {
                                    Point value2 = LoveWallHomepageViewModel.this.sproutFlowerPosition.getValue();
                                    Intrinsics.checkNotNull(value2);
                                }
                            }
                            function02.invoke();
                            return Unit.INSTANCE;
                        }
                    }, 3, null);
                    final LoveWallHomepageViewModel loveWallHomepageViewModel3 = LoveWallHomepageViewModel.this;
                    final Function0<Unit> function03 = function0;
                    final int i16 = i3;
                    BoxKt.a(d16, null, null, ComposableLambdaKt.composableLambda(composer3, -889574774, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallLightingFlowerGuildViewKt$LoveWallLightingFlowerGuildView$1.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer4, Integer num2) {
                            float f16;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-889574774, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallLightingFlowerGuildView.<anonymous>.<anonymous> (LoveWallLightingFlowerGuildView.kt:35)");
                                }
                                if (LoveWallHomepageViewModel.this.sproutFlowerPosition.getValue() == null) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                } else {
                                    i v3 = ComposeLayoutPropUpdaterKt.v(i.INSTANCE, 169, 180);
                                    float f17 = 0.0f;
                                    if (LoveWallHomepageViewModel.this.sproutFlowerPosition.getValue() == null) {
                                        f16 = 0.0f;
                                    } else {
                                        Point value = LoveWallHomepageViewModel.this.sproutFlowerPosition.getValue();
                                        Intrinsics.checkNotNull(value);
                                        f16 = (value.f114257x / floatRef.element) - 15.0f;
                                    }
                                    if (LoveWallHomepageViewModel.this.sproutFlowerPosition.getValue() != null) {
                                        float l3 = b.a().getPageData().l();
                                        Point value2 = LoveWallHomepageViewModel.this.sproutFlowerPosition.getValue();
                                        Intrinsics.checkNotNull(value2);
                                        f17 = (l3 - (value2.f114258y / floatRef.element)) - 15.0f;
                                    }
                                    BoxKt.a(ComposeLayoutPropUpdaterKt.o(v3, f16, f17), null, null, ComposableLambdaKt.composableLambda(composer5, 2124711696, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>(function03, i16) { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallLightingFlowerGuildViewKt.LoveWallLightingFlowerGuildView.1.3.1
                                        public final /* synthetic */ Function0<Unit> $onNextStep;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar2, Composer composer6, Integer num3) {
                                            Composer composer7 = composer6;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                composer7.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(2124711696, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallLightingFlowerGuildView.<anonymous>.<anonymous>.<anonymous> (LoveWallLightingFlowerGuildView.kt:50)");
                                                }
                                                i.Companion companion = i.INSTANCE;
                                                i u16 = ComposeLayoutPropUpdaterKt.u(companion, 126);
                                                final Function0<Unit> function04 = this.$onNextStep;
                                                composer7.startReplaceableGroup(1157296644);
                                                boolean changed = composer7.changed(function04);
                                                Object rememberedValue = composer7.rememberedValue();
                                                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallLightingFlowerGuildViewKt$LoveWallLightingFlowerGuildView$1$3$1$1$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            function04.invoke();
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    composer7.updateRememberedValue(rememberedValue);
                                                }
                                                composer7.endReplaceableGroup();
                                                BoxKt.a(ViewEventPropUpdaterKt.d(u16, false, null, (Function1) rememberedValue, 3, null), null, null, null, composer7, 8, 14);
                                                i v16 = ComposeLayoutPropUpdaterKt.v(companion, (float) 118.81d, 120);
                                                final Function0<Unit> function05 = this.$onNextStep;
                                                composer7.startReplaceableGroup(1157296644);
                                                boolean changed2 = composer7.changed(function05);
                                                Object rememberedValue2 = composer7.rememberedValue();
                                                if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallLightingFlowerGuildViewKt$LoveWallLightingFlowerGuildView$1$3$1$2$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            function05.invoke();
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    composer7.updateRememberedValue(rememberedValue2);
                                                }
                                                composer7.endReplaceableGroup();
                                                APNGKt.a(ViewEventPropUpdaterKt.d(v16, false, null, (Function1) rememberedValue2, 3, null), null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_mSbOXa9EB79.png", 0, null, null, null, null, composer7, 3464, 242);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer5, 3080, 6);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 3080, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 24584, 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallLightingFlowerGuildViewKt$LoveWallLightingFlowerGuildView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallLightingFlowerGuildViewKt.LoveWallLightingFlowerGuildView(LoveWallHomepageViewModel.this, function0, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
