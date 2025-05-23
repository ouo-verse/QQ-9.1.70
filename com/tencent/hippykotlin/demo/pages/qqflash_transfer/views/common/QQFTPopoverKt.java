package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import ap3.a;
import ap3.d;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardAnimationViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.PopoverTriangle;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.PopoverTriangleOffset;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.PopoverTriangleShadow;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPopoverKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.w;
import com.tencent.kuikly.core.manager.c;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import yo3.Offset;

/* loaded from: classes37.dex */
public final class QQFTPopoverKt {
    public static final void QQFTPopover(final MutableState<Boolean> mutableState, final a aVar, PopoverTriangleOffset popoverTriangleOffset, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i3, final int i16) {
        MutableState mutableStateOf$default;
        Offset a16;
        Composer startRestartGroup = composer.startRestartGroup(-1601267223);
        PopoverTriangleOffset popoverTriangleOffset2 = (i16 & 4) != 0 ? null : popoverTriangleOffset;
        final Function2<? super Composer, ? super Integer, Unit> function22 = (i16 & 8) != 0 ? null : function2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1601267223, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common.QQFTPopover (QQFTPopover.kt:30)");
        }
        if (!mutableState.getValue().booleanValue()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                return;
            }
            final PopoverTriangleOffset popoverTriangleOffset3 = popoverTriangleOffset2;
            final Function2<? super Composer, ? super Integer, Unit> function23 = function22;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common.QQFTPopoverKt$QQFTPopover$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    QQFTPopoverKt.QQFTPopover(mutableState, aVar, popoverTriangleOffset3, function23, composer2, i3 | 1, i16);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.INSTANCE.a(), null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState2 = (MutableState) rememberedValue;
        if (((com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d())).e() > 0.0f) {
            if (aVar != null) {
                Offset d16 = d.d(aVar);
                a16 = new Offset((aVar.getWidth() / 2) + d16.getX(), aVar.getHeight() + d16.getY() + 4);
            } else {
                a16 = Offset.INSTANCE.a();
            }
            mutableState2.setValue(a16);
        }
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(popoverTriangleOffset2, null, 2, null);
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = GuideBannerCardAnimationViewKt$$ExternalSyntheticOutline0.m(0.0f, null, 2, null, startRestartGroup);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState3 = (MutableState) rememberedValue2;
        startRestartGroup.startReplaceableGroup(-1076812343);
        if (mutableStateOf$default.getValue() == null) {
            startRestartGroup.startReplaceableGroup(511388516);
            boolean changed = startRestartGroup.changed(mutableState2) | startRestartGroup.changed(mutableState3);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new Function0<Float>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common.QQFTPopoverKt$QQFTPopover$adaptiveOffset$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        float f16;
                        double d17 = 16;
                        double doubleValue = (mutableState3.getValue().doubleValue() / 2.0d) + mutableState2.getValue().getX() + d17;
                        c cVar = c.f117352a;
                        if (doubleValue > GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0.m(cVar)) {
                            f16 = (float) ((((mutableState3.getValue().doubleValue() / 2.0d) + mutableState2.getValue().getX()) + d17) - GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0.m(cVar));
                        } else {
                            f16 = 0.0f;
                        }
                        if ((mutableState2.getValue().getX() - (mutableState3.getValue().doubleValue() / 2.0d)) - d17 < 0.0d) {
                            f16 = mutableState2.getValue().getX() - ((mutableState3.getValue().floatValue() / 2) + 16);
                        }
                        return Float.valueOf(f16);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceableGroup();
            mutableStateOf$default.setValue(new PopoverTriangleOffset(2, ((Number) SnapshotStateKt.derivedStateOf((Function0) rememberedValue3).getValue()).floatValue()));
        }
        startRestartGroup.endReplaceableGroup();
        Offset offset = (Offset) mutableState2.getValue();
        h color$default = QUIToken.color$default("bg_middle_light");
        Object value = mutableStateOf$default.getValue();
        Intrinsics.checkNotNull(value);
        QUIPopoverKt.QUIPopover(mutableState, offset, null, new PopoverTriangle(true, 7, color$default, (PopoverTriangleOffset) value, new PopoverTriangleShadow(h.INSTANCE.a(0.16f))), true, ComposableLambdaKt.composableLambda(startRestartGroup, -932770697, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common.QQFTPopoverKt$QQFTPopover$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 11) == 2 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-932770697, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common.QQFTPopover.<anonymous> (QQFTPopover.kt:80)");
                    }
                    i A = ComposeLayoutPropUpdaterKt.A(i.INSTANCE);
                    final MutableState<Float> mutableState4 = mutableState3;
                    composer3.startReplaceableGroup(1157296644);
                    boolean changed2 = composer3.changed(mutableState4);
                    Object rememberedValue4 = composer3.rememberedValue();
                    if (changed2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue4 = new Function1<w, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common.QQFTPopoverKt$QQFTPopover$3$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(w wVar) {
                                mutableState4.setValue(Float.valueOf(wVar.getWidth()));
                                return Unit.INSTANCE;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue4);
                    }
                    composer3.endReplaceableGroup();
                    i m3 = ViewEventPropUpdaterKt.m(A, (Function1) rememberedValue4);
                    final Function2<Composer, Integer, Unit> function24 = function22;
                    final int i17 = i3;
                    BoxKt.a(m3, null, null, ComposableLambdaKt.composableLambda(composer3, 939800241, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common.QQFTPopoverKt$QQFTPopover$3.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(939800241, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common.QQFTPopover.<anonymous>.<anonymous> (QQFTPopover.kt:85)");
                                }
                                Function2<Composer, Integer, Unit> function25 = function24;
                                if (function25 != null) {
                                    function25.invoke(composer5, Integer.valueOf((i17 >> 9) & 14));
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
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
        }), startRestartGroup, (i3 & 14) | 225280 | (Offset.f450729d << 3), 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 == null) {
            return;
        }
        final PopoverTriangleOffset popoverTriangleOffset4 = popoverTriangleOffset2;
        final Function2<? super Composer, ? super Integer, Unit> function24 = function22;
        endRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common.QQFTPopoverKt$QQFTPopover$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTPopoverKt.QQFTPopover(mutableState, aVar, popoverTriangleOffset4, function24, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }
}
